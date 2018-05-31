package com.nw.webui.produccion;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.zkoss.poi.ss.usermodel.Cell;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Progressmeter;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;

import com.nw.model.ProduccionArchivoCargaOrden;
import com.nw.model.ProduccionArchivoCargaOrdenDetalle;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.dao.ProduccionArchivoCargaOrdenDAO;
import com.nw.model.dao.ProduccionArchivoCargaOrdenDetalleDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.ProduccionArchivoCargaOrdenDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionArchivoCargaOrdenDetalleDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleOrdenDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.ExcelReadWrite;
import com.nw.util.ProduccionCargaOrdenesControlXLS;
import com.nw.util.Sistema;
import com.nw.util.WorkingDirectory;

/**
 * 
 * @author Cls mbaque
 * @since 09/04/2018
 */
public class ProduccionCargaOrdenesWindow extends GenericForwardComposer{
	
	private static final long serialVersionUID = 1L;
	AnnotateDataBinder binder;
	
	Datebox dteFecReg;
	Button btnExaminar, btnCargarGrabar;
	Vbox flist;
	Textbox txtNovedad, txtExaminar, txtNomArchivo, txtDiaProd;
	
	private File archivoOrdenDetalle;
	@Override
	public void doAfterCompose(Component comp) throws Exception {

		super.doAfterCompose(comp);

		binder = new AnnotateDataBinder(comp);
		
		binder.loadAll();
		iniciar();
//		nuevo();
	}
	
	private void iniciar(){
		if (dteFecReg.getValue() == null)
			dteFecReg.setValue(new Date());
//		flist = new Vbox();
	}
	
	/**
	 * limpia las casillas que tiene la informacion del archivos a carga
	 */
	private void nuevo(){
		txtNomArchivo.setValue(null);
		txtExaminar.setValue(null);
		txtDiaProd.setValue(null);
		dteFecReg.setValue(new Date());
		archivoOrdenDetalle = null;
		flist = new Vbox();
		binder.loadAll();
	}
	
	public void onClick$btnExaminar() throws InterruptedException, IOException {
		try {
			// nuevo();
			Media media = Fileupload.get();

			System.out.println("media-->" + media.getName());
			flist = new Vbox();
			Hbox hl = new Hbox();
			hl.setSpacing("6px");
			hl.setClass("newFile");
			hl.appendChild(new Progressmeter());
			hl.appendChild(new Label(media.getName()));

			flist.appendChild(hl);
			
			addItemMedia(media);
			
			if (!consultarFormatoArchivo(media.getName())) {
				Sistema.mensaje("El formato del archivo es no es compatible debe ser: (.xls)");
				return; 
			}
			
			txtExaminar.setValue(media.getName());
			txtNomArchivo.setValue(media.getName());

		} catch (Exception e) {
			System.out.println("paso esto -->" + e.getMessage());
		}
	}
	
	public String addItemMedia(org.zkoss.util.media.Media media)
			throws IOException {
		txtNovedad.setValue(txtNovedad.getValue() + "\n Archivo -->"
				+ media.getName() + " ...Subiendo Archivo ");

		String fileName = WorkingDirectory.get().toString() + "\\upload\\"
				+ media.getName();
		archivoOrdenDetalle = new File(fileName);
		org.zkoss.io.Files.copy(archivoOrdenDetalle, media.getStreamData());

		return fileName;
	}
	
	/**
	 * Valida que el archivo de carga sea solo de extension <code>.xlsx</code>, <code>.xls</code>  
	 * @param para_nombreArchivo
	 * @return
	 */
	public Boolean consultarFormatoArchivo(String para_nombreArchivo) {
		if (para_nombreArchivo.contains("xlsx")||para_nombreArchivo.contains("xls")) {
//			nuevo();			
			iniciar();
			return true;
		} else 
			return false;
	}
	
	public void onClick$btnCargarGrabar() throws InterruptedException {
		if(flist.getChildren().size() == 0){
			Sistema.mensaje("Seleccione archivo a subir");
			iniciar();
			return;
		}
		ProduccionArchivoCargaOrden produccionArchivoCargaOrden = new ProduccionArchivoCargaOrden();
		
		List<List<Cell>> sheetData = new ExcelReadWrite().readAllExcel(archivoOrdenDetalle.getAbsolutePath(), 0);
		
		HashMap<String, Object> infoXLSCargaOrden = ProduccionCargaOrdenesControlXLS.procesaXLSCargaOrden(sheetData, dteFecReg.getValue());
		
		if (infoXLSCargaOrden==null) {
			nuevo();
			return;
		}
			
		produccionArchivoCargaOrden = procesaArchivoCargaOrden(infoXLSCargaOrden);
		
		if (produccionArchivoCargaOrden==null) {
			nuevo();
			return;
		}
			
		
		registraArchivoCargaOrden(produccionArchivoCargaOrden);
		
		Sistema.mensaje("Carga de XLS procesada correctamente.");
		
		nuevo();
		binder.loadAll();
	}
	
	@SuppressWarnings("unchecked")
	private ProduccionArchivoCargaOrden procesaArchivoCargaOrden (HashMap<String, Object> infoXLSCargaOrden) {
		
		ProduccionArchivoCargaOrden paco = new ProduccionArchivoCargaOrden();
		
		List<ProduccionArchivoCargaOrdenDetalle> listPacoD = new ArrayList<ProduccionArchivoCargaOrdenDetalle>();
		ProduccionArchivoCargaOrdenDetalle pacoD = new ProduccionArchivoCargaOrdenDetalle();
		
		Object oSemana = infoXLSCargaOrden.get("semana");
		Object oProduccion = infoXLSCargaOrden.get("produccion");
		Object oObservacion = infoXLSCargaOrden.get("observacion");
		
		paco.setSemana(new Double(oSemana.toString()).intValue());
		paco.setProduccion(new ProduccionDAOJpaImpl().getProduccionById(new Long(oProduccion.toString())));
		paco.setObservacion(oObservacion.toString());
		paco.setNombrearchivo(archivoOrdenDetalle.getName());
		paco.setFechaarchivo(new Timestamp(System.currentTimeMillis()));
		paco.setFechacarga(new Timestamp(System.currentTimeMillis()));
		
		//valida la informacion del usuario logueado
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return null;
		}
		paco.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
		
		for (int i = 0 ; infoXLSCargaOrden.size() > i ; i++) {
			if (infoXLSCargaOrden.containsKey("TURNO_"+(i+1))){
				for(List<Cell> filaDetalle: (List<List<Cell>>)infoXLSCargaOrden.get("TURNO_"+(i+1))) {
					if(filaDetalle.size()<2)
						continue;
					pacoD = ProduccionCargaOrdenesControlXLS.validaInfoOrdenDetalle(filaDetalle);
					if (pacoD == null) {
						nuevo();
						return null;
					}
						
					pacoD.setTurno(new TurnoDAOJpaImpl().getFindTurnoId(i+1));
					pacoD.setProduccionArchivoCargaOrden(paco);
					listPacoD.add(pacoD);
				}
				paco.setProduccionArchivoCargaOrdenDetalles(listPacoD);
			}
		}
		
		boolean filaUnica = ProduccionCargaOrdenesControlXLS.validaInformacionUnica(paco);
//		
		return filaUnica==true?null:paco;
	}
	
	
	/**
	 * Se encarga de realizar la validaciones para realizar la insercion de la informacion
	 * en las entidades <br> {@link ProduccionArchivoCargaOrdenDetalle}<br>
	 * {@link ProduccionArchivoCargaOrden}<br>
	 * {@link ProduccionArchivoCargaOrdenDetalle}
	 * @param produccionArchivoCargaOrden
	 */
	public void registraArchivoCargaOrden(ProduccionArchivoCargaOrden produccionArchivoCargaOrden) {
		ProduccionArchivoCargaOrdenDAO pacoDAO = new ProduccionArchivoCargaOrdenDAOJpaImpl();
		
		List<ProduccionArchivoCargaOrdenDetalle> listaPacoOrDet = produccionArchivoCargaOrden.getProduccionArchivoCargaOrdenDetalles();
		List<ProduccionArchivoCargaOrdenDetalle> listaPacoOrDetNueva = new ArrayList<ProduccionArchivoCargaOrdenDetalle>();
		
		List<ProduccionArchivoCargaOrden> listaPacoActualiza = new ArrayList<ProduccionArchivoCargaOrden>();
		
		boolean isNuevoCargaOrden=false;
		for (ProduccionArchivoCargaOrdenDetalle pacoOrDet : listaPacoOrDet) {
			ProduccionArchivoCargaOrdenDetalleDAO cargaOrdenDetalleDao = new ProduccionArchivoCargaOrdenDetalleDAOJpaImpl();
			boolean existeArchivoCargaOrdenDetalle = cargaOrdenDetalleDao.existeArchivoCargaOrdenDetalle( 
							pacoOrDet.getTurno().getIdturno(), pacoOrDet.getItem(), pacoOrDet.getOrden(), produccionArchivoCargaOrden.getProduccion().getIdproduccion());
			if (existeArchivoCargaOrdenDetalle) {
				System.out.println("si existe entonces actualiza");
				ProduccionArchivoCargaOrdenDetalle existePacoDet = new ProduccionArchivoCargaOrdenDetalle();
				existePacoDet = cargaOrdenDetalleDao.archivoCargaOrdenDetalles(
								pacoOrDet.getTurno().getIdturno(), pacoOrDet.getItem(), pacoOrDet.getOrden(), produccionArchivoCargaOrden.getProduccion().getIdproduccion()).
								get(0);
				List<ProduccionArchivoCargaOrdenDetalle> listaExistePacoDet = new ArrayList<ProduccionArchivoCargaOrdenDetalle>();
				
				Long existePacoDetID = existePacoDet.getIdproduccionarchivocargaordendetalle();

				ProduccionArchivoCargaOrden paco = new ProduccionArchivoCargaOrden();
				paco = copiaOrden( pacoDAO.archivoCargaOrdenPorID(
						existePacoDet.getProduccionArchivoCargaOrden().getIdproduccionarchivocargaorden()) );
				
				existePacoDet = copiaOrdenDetalle(pacoOrDet, paco);
				existePacoDet.setIdproduccionarchivocargaordendetalle(existePacoDetID);
				
				listaExistePacoDet.add(existePacoDet);
				paco.setProduccionArchivoCargaOrdenDetalles(listaExistePacoDet);
				
				listaPacoActualiza.add(paco);
				
			}else{
				System.out.println("no existe entonces inserta");
				isNuevoCargaOrden=true;
				listaPacoOrDetNueva.add(pacoOrDet);
			}
		}
		//realiza una insercion directa de la informacion para las tablas de auditoria.
		pacoDAO.saveObject(produccionArchivoCargaOrden);
		//prepara la lista de los detalles que se deben de actualizar en la tabla "produccion_detalle_orden"
		produccionArchivoCargaOrden.getProduccionArchivoCargaOrdenDetalles().clear();
		produccionArchivoCargaOrden.setProduccionArchivoCargaOrdenDetalles(listaPacoOrDetNueva);
		
		//realiza una insercion directa de la informacion en la tabla "produccion_detalle_orden".
		if (isNuevoCargaOrden)
			registraDetalleOrden(produccionArchivoCargaOrden);
		
		//se encarga de validar la informacion que solo se va a actualizar en la entidad final
		if (!listaPacoActualiza.isEmpty()) {
			for (ProduccionArchivoCargaOrden pacoActualiza : listaPacoActualiza) {
	//			pacoDAO.updateObject(pacoActualiza);
				for (ProduccionArchivoCargaOrdenDetalle pacoD: pacoActualiza.getProduccionArchivoCargaOrdenDetalles())
					actualizaDetalleOrden(pacoD);
			}
		}
	}
	
	private void actualizaDetalleOrden(ProduccionArchivoCargaOrdenDetalle pacoD){
		ProduccionDetalleOrdenDAO pdoDAO = new ProduccionDetalleOrdenDAOJpaImpl();
		ProduccionDetalleOrden pdo = new ProduccionDetalleOrden();
		Integer pdoId = null;
		pdoId = pdoDAO.existeDetalleOrden(pacoD.getTurno().getIdturno(), 
				pacoD.getProduccionArchivoCargaOrden().getProduccion().getIdproduccion(), 
				pacoD.getItem(),
				pacoD.getOrden()).getIdproducciondetalleorden();
		
		pdo = preparaProduccionDetalleOrden(pacoD.getProduccionArchivoCargaOrden(), pacoD);
		pdo.setIdproducciondetalleorden(pdoId);
		System.out.println(pdo.getPs());
		pdoDAO.updateObject(pdo);
		
	}
	private ProduccionDetalleOrden preparaProduccionDetalleOrden(ProduccionArchivoCargaOrden paco, ProduccionArchivoCargaOrdenDetalle pacoD){
		ProduccionDetalleOrden pdo = new ProduccionDetalleOrden();
		pdo.setAc(pacoD.getAc());
		pdo.setAg(pacoD.getAg());
		pdo.setCajas(pacoD.getCajas());
		pdo.setCliente(pacoD.getCliente());
		pdo.setCrudo(pacoD.getCrudo());
		pdo.setDestino(pacoD.getDestino());
		pdo.setEnvase(pacoD.getEnvase());
		pdo.setDre(pacoD.getDre());
		pdo.setEsp(pacoD.getEsp());
		pdo.setFi(pacoD.getFi());
		pdo.setFill(pacoD.getFill());
		pdo.setFlake(pacoD.getFlake());
		pdo.setProduccion(paco.getProduccion());
		pdo.setTurno(pacoD.getTurno());
		pdo.setUsuario(paco.getUsuario());
		pdo.setItem(pacoD.getItem());
		pdo.setFormato(pacoD.getFormato());
		pdo.setLatas(pacoD.getLatas());
		pdo.setLomolimpio(pacoD.getLomolimpio());
		pdo.setMarca(pacoD.getMarca());
		pdo.setMaterialfer(pacoD.getMaterialfer());
		pdo.setMaterialhal(pacoD.getMaterialhal());
		pdo.setMesa(pacoD.getMesa());
		pdo.setObservacion(pacoD.getObservacion());
		pdo.setOrden(pacoD.getOrden());
		pdo.setOrdenfer(pacoD.getOrdenfer());
		pdo.setOrdenhal(pacoD.getOrdenhal());
		pdo.setPresentacion(pacoD.getPresentacion());
		pdo.setProducto(pacoD.getProducto());
		pdo.setPs(pacoD.getPs());
		pdo.setRalladoempacado(pacoD.getRalladoempacado());
		pdo.setRen(pacoD.getRen());
		pdo.setReproceso(pacoD.getReproceso());
		pdo.setSemana(paco.getSemana());
		pdo.setTapa(pacoD.getTapa());
		pdo.setTon(pacoD.getTon());
		pdo.setVideo(pacoD.getVideo());
		return pdo;
	}
	private void registraDetalleOrden(ProduccionArchivoCargaOrden paco) {
		ProduccionDetalleOrden pdo = new ProduccionDetalleOrden();
		ProduccionDetalleOrdenDAO pdoDAO = new ProduccionDetalleOrdenDAOJpaImpl();
		for (ProduccionArchivoCargaOrdenDetalle pacoD: paco.getProduccionArchivoCargaOrdenDetalles()) {
			pdo = preparaProduccionDetalleOrden(paco, pacoD);
			if(!pdoDAO.saveObject(pdo)) {
				Sistema.mensaje("Ocurrio un error al guardar la orden.");
				throw new RuntimeException("Ocurrio un error al guardar la orden.");
			}
		}
	}
	
	private ProduccionArchivoCargaOrden copiaOrden(ProduccionArchivoCargaOrden origen) {
		ProduccionArchivoCargaOrden destino = new ProduccionArchivoCargaOrden();
		destino.setIdproduccionarchivocargaorden(origen.getIdproduccionarchivocargaorden());
		destino.setFechaarchivo(origen.getFechaarchivo());
		destino.setFechacarga(origen.getFechacarga());
		destino.setProduccion(origen.getProduccion());
		destino.setUsuario(origen.getUsuario());
		destino.setNombrearchivo(origen.getNombrearchivo());
		destino.setObservacion(origen.getObservacion());
		destino.setSemana(origen.getSemana());
		return destino;
	}

	private ProduccionArchivoCargaOrdenDetalle copiaOrdenDetalle(ProduccionArchivoCargaOrdenDetalle origen, ProduccionArchivoCargaOrden produccionArchivoCargaOrden) {
		ProduccionArchivoCargaOrdenDetalle destino = new ProduccionArchivoCargaOrdenDetalle();
		destino.setProduccionArchivoCargaOrden(produccionArchivoCargaOrden);
		destino.setAc(origen.getAc());
		destino.setAg(origen.getAg());
		destino.setCajas(origen.getCajas());
		destino.setCliente(origen.getCliente());
		destino.setDestino(origen.getDestino());
		destino.setCrudo(origen.getCrudo());
		destino.setEnvase(origen.getEnvase());
		destino.setPresentacion(origen.getPresentacion());
		destino.setDre(origen.getDre());
		destino.setEsp(origen.getEsp());
		destino.setFi(origen.getFi());
		destino.setFill(origen.getFill());
		destino.setFlake(origen.getFlake());
		destino.setTurno(origen.getTurno());
		destino.setItem(origen.getItem());
		destino.setFormato(origen.getFormato());
		destino.setLatas(origen.getLatas());
		destino.setLomolimpio(origen.getLomolimpio());
		destino.setMarca(origen.getMarca());
		destino.setMaterialfer(origen.getMaterialfer());
		destino.setMaterialhal(origen.getMaterialhal());
		destino.setMesa(origen.getMesa());
		destino.setObservacion(origen.getObservacion());
		destino.setOrden(origen.getOrden());
		destino.setOrdenfer(origen.getOrdenfer());
		destino.setOrdenhal(origen.getOrdenhal());
		destino.setProducto(origen.getProducto());
		destino.setPs(origen.getPs());
		destino.setRalladoempacado(origen.getRalladoempacado());
		destino.setRen(origen.getRen());
		destino.setReproceso(origen.getReproceso());
		destino.setTapa(origen.getTapa());
		destino.setTon(origen.getTon());
		destino.setVideo(origen.getVideo());
		
		return destino;
	}
}
