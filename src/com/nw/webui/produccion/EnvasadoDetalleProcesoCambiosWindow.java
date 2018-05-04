package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.EnvasadoDetalleProcesoCambio;
import com.nw.model.EnvasadoDetalleProcesoCambiosLuthy;
import com.nw.model.EnvasadoProceso;
import com.nw.model.EnvasadoTipoProteina;
import com.nw.model.Luthy;
import com.nw.model.MaquinaCerradora;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.dao.EnvasadoDetalleProcesoCambioDAO;
import com.nw.model.dao.EnvasadoTipoProteinaDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoDetalleProcesoCambiosDAOJpaimpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoTipoProteinaDAOJpaImpl;
import com.nw.model.dao.impl.LuthyDAOJpaImpl;
import com.nw.model.dao.impl.MaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleOrdenDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;

/**
 * 
 * @author Cls Mbaque
 * @since 17/04/2018
 */
public class EnvasadoDetalleProcesoCambiosWindow extends GenericForwardComposer{
	private static final long serialVersionUID = 1L;
	private static final Integer ESTADO = 1; 
	AnnotateDataBinder binder;
	
	Textbox txtProduccionTurno, txtOrden, txtProducto, txtCodVideoJet, txtTapa, txtPresentacion, txtPNeto, txtDestino, txtObservacion;
	Listbox lbxTurnoLabor, lbxItemOrden, lbxMSelladora, lbxLuthy, lbxLista, lbxTipoProteina;
	Listbox lbxMes, lbxDias, lbxHoras, lbxMinutos;
//	Doublebox dcbFill, dcbH2O, dcbAceite, dcbProteina, dcbDrenado, dcbFlakes, dcbLatas;
	Textbox dcbFill, dcbH2O, dcbAceite, dcbProteina, dcbDrenado, dcbFlakes, dcbLatas;
	//se carga con el metodo cargaProduccionTurno()
	private Turno turno;
	//se carga con el metodo cargaProduccionTurno()
	private Produccion produccion;
	
	private EnvasadoProceso envasadoProceso;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		
		txtProduccionTurno.setValue(cargaProduccionTurno());
		cargaInfoInicial();
		
		binder.loadAll();
	}
	
	public void cargaInfoInicial(){
		cargarListaTurnoLabor();
		cargaItemOrden(turno.getIdturno(), produccion.getIdproduccion());
		cargaInfoMSelladora();
		cargaLuthy();
		cargalbxTipoProteina();
	}
	
	/**
	 * se encarga de realizar las primeras validaciones en el zul y Carga&Valida
	 * la informacion de produccion y turno
	 * 
	 * @return
	 */
	private String cargaProduccionTurno(){
		Date fechaProduccion;
		String formatoProduccion;
		envasadoProceso = cargaEnvasadoProceso();
		if (envasadoProceso==null) {
			Sistema.mensaje("No existe proceso activo.");
			return null;
		}
	
		fechaProduccion = envasadoProceso.getProduccion().getFechaproduccion();
		formatoProduccion = new SimpleDateFormat("dd/MM/yyyy").format(fechaProduccion);
			
		this.produccion = cargaProduccion(envasadoProceso);
		if (produccion==null) {
			Sistema.mensaje("La produccion " + formatoProduccion + " no se encuentra configurada.");
			return null;
		}
		
		this.turno = cargaTurno(envasadoProceso);
		if (turno == null) {
			Sistema.mensaje("El turno " + envasadoProceso.getTurno().getNombre() + " no se encuentra configurada.");
			return null;
		}
		return formatoProduccion +" - "+turno.getNombre();
	}
	
	/**
	 * 
	 */
	public void cargarListaTurnoLabor(){
		lbxTurnoLabor.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurnoLabor);
		
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		for (Turno turno : listaTurnos) {
			 li = new Listitem();
			 li.setValue(turno);
			 new Listcell("Turno -> "+turno.getNombre()).setParent(li);
			 li.setParent(lbxTurnoLabor);
		}
		lbxTurnoLabor.setSelectedIndex(0);
	}
	
	/**
	 * carga la informacion del campo Item - Orden bajo los parametros idTurno, IdProduccion
	 * @param idturno
	 * @param idproduccion
	 */
	public void cargaItemOrden(Integer idturno, Long idproduccion) {

		ProduccionDetalleOrdenDAO pdoDAOJpa = new ProduccionDetalleOrdenDAOJpaImpl();
		
		List<ProduccionDetalleOrden> listaProduccionDetalleOrden = pdoDAOJpa
				.obtieneDetalleOrdenByProduccionTurno(idturno, idproduccion);
		
		String itemOrden;
		
		if (listaProduccionDetalleOrden.isEmpty()) {
			Sistema.mensaje("No existe informacion Item-Orden para la produccion " + txtProduccionTurno.getValue());
			return;
		}
		
		lbxItemOrden.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ProduccionDetalleOrden());
		li.setParent(lbxItemOrden);
		
		for (ProduccionDetalleOrden produccionDetalleOrden : listaProduccionDetalleOrden) {
			itemOrden = produccionDetalleOrden.getItem() + " - " + produccionDetalleOrden.getOrden();
			li = new Listitem();
			li.setValue(produccionDetalleOrden);
			new Listcell(itemOrden).setParent(li);
			li.setParent(lbxItemOrden);
		}
		lbxTurnoLabor.setSelectedIndex(0);
	}
	
	/**
	 * carga la informacion de los campos Orden y Producto
	 * @throws InterruptedException
	 */
	public void onSelect$lbxItemOrden() throws InterruptedException{
		try {
			ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden) lbxItemOrden
					.getSelectedItem().getValue();
			if (produccionDetalleOrden.getIdproducciondetalleorden()!=null) {
				txtOrden.setValue(produccionDetalleOrden.getOrden());
				txtProducto.setValue(produccionDetalleOrden.getProducto());
				dcbFill.setValue(String.valueOf(produccionDetalleOrden.getFill()));
				dcbH2O.setValue(String.valueOf(produccionDetalleOrden.getAg()));
				dcbAceite.setValue(String.valueOf(produccionDetalleOrden.getAc()));
				txtTapa.setValue(produccionDetalleOrden.getTapa());
				txtPresentacion.setValue(produccionDetalleOrden.getProducto());
				dcbDrenado.setValue(String.valueOf(produccionDetalleOrden.getDre()));
				dcbFlakes.setValue(String.valueOf(produccionDetalleOrden.getFlake()));

				String pNeto = produccionDetalleOrden.getPresentacion();
				if (pNeto!=null)
					if(pNeto.toUpperCase().contains("X"))
						txtPNeto.setValue(pNeto.substring(pNeto.indexOf("X")+2, pNeto.length()));

				txtDestino.setValue(produccionDetalleOrden.getDestino());
				dcbLatas.setValue(String.valueOf(produccionDetalleOrden.getLatas()));
			} else {
				txtOrden.setValue(null);
				txtProducto.setValue(null);
				dcbFill.setValue(null);
				dcbH2O.setValue(null);
				dcbAceite.setValue(null);
				txtTapa.setValue(null);
				txtPresentacion.setValue(null);
				dcbDrenado.setValue(null);
				dcbFlakes.setValue(null);
				txtPNeto.setValue(null);
				txtDestino.setValue(null);
				dcbLatas.setValue(null);
			}
			
		
		} catch (Exception e) {
			Sistema.mensaje("Ocurrio un error no  esperado al cargar la informacion de Orden y Producto");
			System.out.println("Mensaje de error " + e.getMessage());
		}
	}
	
	/**
	 * carga la informacion de las maquina cerradoras a la lista M. Selladora
	 */
	public void cargaInfoMSelladora() {
		
		List<MaquinaCerradora> listaMCerradora = new MaquinaCerradoraDAOJpaImpl().getAll();
		
		if (listaMCerradora.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion para maquina cerradora.");
			return;
		}
			
		lbxMSelladora.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new MaquinaCerradora());
		li.setParent(lbxMSelladora);
		
		for (MaquinaCerradora mCerradora : listaMCerradora) {
			li = new Listitem();
			li.setValue(mCerradora);
			new Listcell(mCerradora.getDescripcion()).setParent(li);
			li.setParent(lbxMSelladora);
		}
		
		lbxMSelladora.setSelectedIndex(0);
	}
	
	/**
	 * carga la informacion de Luthy en la lista Luthy
	 */
	public void cargaLuthy() {
		
		List<Luthy> listaLuthy = new LuthyDAOJpaImpl().getAll();
		
		if (listaLuthy.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion Luthy.");
			return;
		}
			
		lbxLuthy.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Luthy());
		li.setParent(lbxLuthy);
		
		for (Luthy luthy : listaLuthy) {
			li = new Listitem();
			li.setValue(luthy);
			new Listcell(luthy.getNumeroluthy().toString()).setParent(li);
			li.setParent(lbxLuthy);
		}
		
		lbxLuthy.setSelectedIndex(0);
	}
	
	public void onClick$btnEliminarItem() throws InterruptedException {
		lbxLista.getItems().clear();
		onClick$btnEliminar();
		binder.loadComponent(lbxLista);
	}
	/**
	 * Agrega los Luthy que se van a configurar
	 * @throws InterruptedException
	 */
//	public void onSelect$lbxLuthy() throws InterruptedException{
	public void onClick$btnAgregarItem() throws InterruptedException{
		try {
			binder.loadComponent(lbxLista);
			
			Luthy luthy = (Luthy) lbxLuthy.getSelectedItem().getValue();
			
			Listitem li = new Listitem();
//			li.setValue(new Luthy());
//			li.setParent(lbxLista);
			
			li = new Listitem();
			li.setValue(luthy);
			
			//agrega cell al Listitem
			if (luthy.getNumeroluthy()==null) {
				Sistema.mensaje("Por favor seleccione un Luthy.");
				return;
			}
				
			Listcell listcellLuthy = new Listcell(luthy.getNumeroluthy().toString());
			listcellLuthy.setId(luthy.getIdluthy().toString());
			listcellLuthy.setParent(li);
			
			Checkbox cbxLuthy = new Checkbox();
			cbxLuthy.setChecked(false);
			cbxLuthy.setId("check"+luthy.getIdluthy());
			Listcell listcellCeck =new Listcell();
			listcellCeck.appendChild(cbxLuthy);
			listcellCeck.setParent(li);
			
			//agrega cell al Listitem
			li.setParent(lbxLista);
			
			lbxLuthy.setSelectedIndex(0);
			
			lbxLista.setVisible(true);
			
		} catch (Exception e) {
			if (e.getMessage()!=null)
				if (e.getMessage().contains("Not unique in the new ID")) {
					Sistema.mensaje("El Luthi "+lbxLuthy.getSelectedItem().getLabel()+" ya se encuentra agregado. Por favor seleccione otro Luthy.");
					lbxLuthy.setSelectedIndex(0);
					return;
				}
					
			Sistema.mensaje("Ocurrio un error no  esperado al cargar la informacion de los Luthy seleccionados.");
			e.printStackTrace();
		}
	}
	/**
	 * elimina el listcell que se encuentre chekeado
	 * @throws InterruptedException
	 */
	public void onClick$btnEliminar() throws InterruptedException{
		try {
			 @SuppressWarnings("unchecked")
			List<Listitem> listLuthy = lbxLista.getItems();
			List<Listitem> luthysEliminado = new ArrayList<Listitem>();
			for (Listitem listitem : listLuthy) {
				Listcell cellCheck = (Listcell)listitem.getChildren().get(1);
				Checkbox checkLuthy = (Checkbox)cellCheck.getChildren().get(0);
				if (checkLuthy.isChecked())
					luthysEliminado.add(listitem);
			}
			 for(Listitem item : luthysEliminado)
				 lbxLista.getItems().remove(item);
			 if (listLuthy.size()<1)
				 lbxLista.setVisible(false);
			 binder.loadComponent(lbxLista);
		} catch(Exception e) {
			Sistema.mensaje("Ocurrio un error no esperado al intentar eliminar un Luthy seleccionado.");
			e.printStackTrace();
		}
	}
	
	public void cargalbxTipoProteina() {
		EnvasadoTipoProteinaDAO etpDAO = new EnvasadoTipoProteinaDAOJpaImpl();
		List<EnvasadoTipoProteina> listaTipoProteina = etpDAO.getAll();
		
		if (listaTipoProteina.isEmpty()) {
			Sistema.mensaje("No se encuentra configuracion para Tipos de proteina.");
			return;
		}
			
		lbxTipoProteina.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoTipoProteina());
		li.setParent(lbxTipoProteina);
		
		for (EnvasadoTipoProteina etp : listaTipoProteina) {
			li = new Listitem();
			li.setValue(etp);
			new Listcell(etp.getDescripcion()).setParent(li);
			li.setParent(lbxTipoProteina);
		}
		
		lbxTipoProteina.setSelectedIndex(0);
	}
	@SuppressWarnings("unchecked")
	public void onClick$btnGrabar() {
		try {
			EnvasadoDetalleProcesoCambioDAO daoJpa = new EnvasadoDetalleProcesoCambiosDAOJpaimpl(); 
			EnvasadoDetalleProcesoCambio edpc = new EnvasadoDetalleProcesoCambio(); 
			EnvasadoDetalleProcesoCambiosLuthy edpcL;
			List<EnvasadoDetalleProcesoCambiosLuthy> listaEdpcL = new ArrayList<EnvasadoDetalleProcesoCambiosLuthy>();
			
			ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden) lbxItemOrden
					.getSelectedItem().getValue();
			
			//prepara la informacion de la cabecera
			
			edpc.setProduccionDetalleOrden(produccionDetalleOrden);
			edpc.setEnvasadoProceso(envasadoProceso);
			
			Turno turno = (Turno)lbxTurnoLabor.getSelectedItem().getValue();
			if (turno.getIdturno()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Turno Labor.");
				return;
			}
			edpc.setTurno(turno);
			
			MaquinaCerradora maquinaCerradora = (MaquinaCerradora) lbxMSelladora.getSelectedItem().getValue();
			if (maquinaCerradora.getIdmaquinacerradora()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo M. Cerradora");
				return;
			}
			edpc.setMaquinaCerradora(maquinaCerradora);
			
			//valida la informacion del usuario logueado
			String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
			if (idUsuario==null) {
				Sistema.mensaje("Error. Usuario no logueado.");
				return;
			}
			edpc.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
			
			//prepara la informacion del detalle
			if (lbxLista.getItems().isEmpty()) {
				Sistema.mensaje("Se debe agregar Luthy.");
				return;					
			}
				
			for (Listitem listitem : (List<Listitem>)lbxLista.getItems()) {
				Listcell cellCheck = (Listcell)listitem.getChildren().get(0);
				if (cellCheck.getId()!=null) {
					edpcL = new EnvasadoDetalleProcesoCambiosLuthy();
					edpcL.setLuthy((Luthy)cellCheck.getValue());
					edpcL.setEnvasadoDetalleProcesoCambio(edpc);
					listaEdpcL.add(edpcL);
				}
			}
			edpc.setEnvasadoDetalleProcesoCambiosLuthies(listaEdpcL);
			
			try {
				if (dcbFill.getValue()==null?true:dcbFill.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %Fill");
					dcbFill.setFocus(true);
					return;
				} else if(parseDouble(dcbFill.getValue()) < 0){
					Sistema.mensaje("El campo %Fill no permite numeros negativos.");
					dcbFill.setValue(null);
					dcbFill.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %Fill solo acepta numeros.");
				dcbFill.setValue(null);
				dcbFill.setFocus(true);
				return;
			}
			edpc.setFill(parseDouble(dcbFill.getValue()));
			try {
				if (dcbH2O.getValue()==null?true:dcbH2O.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %H2O");
					dcbH2O.setFocus(true);
					return;
				} else if(parseDouble(dcbH2O.getValue()) < 0){
					Sistema.mensaje("El campo %H2O no permite numeros negativos.");
					dcbH2O.setValue(null);
					dcbH2O.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %H2O solo acepta numeros.");
				dcbH2O.setValue(null);
				dcbH2O.setFocus(true);
				return;
			}
			edpc.setAg(parseDouble(dcbH2O.getValue()));//H2O = ag
			
			try {
				if (dcbAceite.getValue()==null?true:dcbAceite.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %Aceite");
					dcbAceite.setFocus(true);
					return;
				} else if(parseDouble(dcbAceite.getValue()) < 0){
					Sistema.mensaje("El campo %Aceite no permite numeros negativos.");
					dcbAceite.setValue(null);
					dcbAceite.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %Aceite solo acepta numeros.");
				dcbAceite.setValue(null);
				dcbAceite.setFocus(true);
				return;
			}
			edpc.setAc(parseDouble(dcbAceite.getValue()));//aceite = AC
			
			EnvasadoTipoProteina envasadoTipoProteina = (EnvasadoTipoProteina) lbxTipoProteina.getSelectedItem().getValue();
			if (envasadoTipoProteina.getIdenvasadotipoproteina()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Tipo Proteina");
				return;
			}
			edpc.setEnvasadoTipoProteina(envasadoTipoProteina);
			
			try {
				if (dcbProteina.getValue()==null?true:dcbProteina.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Debe seleccionar un valor para el campo %Proteina");
					dcbProteina.setFocus(true);
					return;
				} else if(parseDouble(dcbProteina.getValue()) < 0){
					Sistema.mensaje("Debe seleccionar un valor para el campo %Proteina");
					dcbProteina.setValue(null);
					dcbProteina.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %Proteina solo acepta numeros.");
				dcbProteina.setValue(null);
				dcbProteina.setFocus(true);
				return;
			}
			edpc.setPorcentajeproteina(parseDouble(dcbProteina.getValue()));
			
			if (txtCodVideoJet.getValue()==null?true:txtCodVideoJet.getValue().isEmpty()?true:false) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Cod. Video Jet");
				txtCodVideoJet.setFocus(true);
				return;
			}
			edpc.setCodvideojet(txtCodVideoJet.getValue());
			//tapa =visual
			//presentacion=producto visual
			try {
				if (dcbDrenado.getValue()==null?true:dcbDrenado.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo Drenado");
					dcbDrenado.setFocus(true);
					return;
				} else if(parseDouble(dcbDrenado.getValue()) < 0){
					Sistema.mensaje("El campo Drenado no permite numeros negativos.");
					dcbDrenado.setValue(null);
					dcbDrenado.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo Drenado solo acepta numeros.");
				dcbDrenado.setValue(null);
				dcbDrenado.setFocus(true);
				return;
			}
			edpc.setDre(parseDouble(dcbDrenado.getValue()));//drenado = DRE
			
			try {
				if (dcbFlakes.getValue()==null?true:dcbFlakes.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %Flakes");
					dcbFlakes.setFocus(true);
					return;
				} else if(parseDouble(dcbFlakes.getValue()) < 0){
					Sistema.mensaje("El campo %Flakes no permite numeros negativos.");
					dcbFlakes.setValue(null);
					dcbFlakes.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %Flakes solo acepta numeros.");
				dcbFlakes.setValue(null);
				dcbFlakes.setFocus(true);
				return;
			}
			edpc.setFlake(parseDouble(dcbFlakes.getValue()));
			
			if (txtPNeto.getValue()==null?true:txtPNeto.getValue().isEmpty()?true:false) {
				Sistema.mensaje("Debe seleccionar un valor para el campo P. Neto");
				txtPNeto.setFocus(true);
				return;
			}
			edpc.setPesoneto(txtPNeto.getValue());
			//destino=visual
			try {
				if (dcbLatas.getValue()==null?true:dcbLatas.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo #Latas");
					dcbLatas.setFocus(true);
					return;
				} else if(parseDouble(dcbLatas.getValue()) < 0){
					Sistema.mensaje("El campo Latas no permite numeros negativos.");
					dcbLatas.setValue(null);
					dcbLatas.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo Latas solo acepta numeros.");
				dcbLatas.setValue(null);
				dcbLatas.setFocus(true);
				return;
			}
			edpc.setLatas(parseDouble(dcbLatas.getValue()));
			
			Timestamp fechaRegistro = obtieneFechaRegistro();
			if (fechaRegistro==null)
				return;
			edpc.setFechacambio(fechaRegistro);
			edpc.setFechareg(new Timestamp(System.currentTimeMillis()));
			edpc.setObservacion(txtObservacion.getValue());
			
			if (!isEnvasadoProcesoActivo()) {
				Sistema.mensaje("El registro de envasado proceso se ha cerrado durante su modificacion.");
				return;
			}
			
			daoJpa.saveOrUpdate(edpc);
			
			Sistema.mensaje("Cambios guardados exitosamente.");
			
			limpiarFormulario(); 
			
			binder.loadAll();
		} catch(Exception e) {
			Sistema.mensaje("Ocurrio un error al intentar guardar la informacion.");
			e.printStackTrace();
			
		}
		
	}
	
	
	/*********************************************************************************/
	/*******************************UTILIDADES****************************************/
	/*********************************************************************************/
	private boolean isEnvasadoProcesoActivo(){
		
		EnvasadoProcesoDAOJpaImpl epDAOJpa = new EnvasadoProcesoDAOJpaImpl();
		EnvasadoProceso envasadoProceso = epDAOJpa.getEnvasadoProcesoByEstado(ESTADO);
		
		if (this.envasadoProceso.getIdenvasadoproceso() != envasadoProceso.getIdenvasadoproceso())
			return false;
		else
			return true;
	}
	
	public void onSelect$lbxMes(){
		int anio = Calendar.getInstance().get(Calendar.YEAR) - 1900;
		String mes="";
		lbxDias.getItems().clear();
		if (lbxMes.getSelectedItem().getValue()==null)
			return;
		mes = lbxMes.getSelectedItem().getValue().toString();
		Calendar c = new GregorianCalendar(anio, Integer.parseInt(mes)-1, 1);
		int dias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		
		Listitem li = new Listitem();
		li.setValue(new Integer("0"));
		li.setParent(lbxDias);
		
		for (int i=1 ; dias>=i ; i++) {
			li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxDias);
		}
		
		lbxDias.setSelectedIndex(0);
		
	}
	private Timestamp obtieneFechaRegistro() {
		String dia ="";
		String mes ="";
		String hora ="";
		String min ="";
		String mensaje = new String();
		
		if (lbxMinutos.getSelectedItem().getValue()!=null)
			min = lbxMinutos.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Minuto.";
		
		if(lbxHoras.getSelectedItem().getValue()!=null)
			hora = lbxHoras.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Hora.";
		
		if (lbxDias.getSelectedItem()!=null && lbxDias.getSelectedItem().getValue()!=null) {
			if (!"0".equals(lbxDias.getSelectedItem().getValue().toString()))
				dia = lbxDias.getSelectedItem().getValue().toString();
			else
				mensaje="Por favor seleccione un valor para Dia.";
		} else
			mensaje="Por favor seleccione un valor para Dia.";
		
		if (lbxMes.getSelectedItem().getValue()!=null)
			mes = lbxMes.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Mes.";
		
		int anio = Calendar.getInstance().get(Calendar.YEAR);
		
		int second = Calendar.getInstance().get(Calendar.SECOND);

		String fechaCambio = anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+second;
		if (!mensaje.isEmpty()) {
			Sistema.mensaje(mensaje);
			return null;
		} else 
			return Timestamp.valueOf(fechaCambio);
	}
	
	private EnvasadoProceso cargaEnvasadoProceso(){
		EnvasadoProcesoDAOJpaImpl epJpa = new EnvasadoProcesoDAOJpaImpl();
		return epJpa.getEnvasadoProcesoByEstado(ESTADO);
	}
	
	private Produccion cargaProduccion(EnvasadoProceso ep) {
		ProduccionDAOJpaImpl pJpa = new ProduccionDAOJpaImpl();
		return pJpa.getProduccionById(ep.getProduccion().getIdproduccion());
	}
	
	private Turno cargaTurno(EnvasadoProceso ep) {
		TurnoDAOJpaImpl tJpa = new TurnoDAOJpaImpl();
		return tJpa.getFindTurnoId(ep.getTurno().getIdturno());
	}
	
	private void limpiarFormulario() {
		//Limpia Texto
//		txtProduccionTurno.setValue("");
		txtOrden.setValue("");
		txtProducto.setValue("");
		txtTapa.setValue("");
		txtPresentacion.setValue("");
		txtDestino.setValue("");
		txtObservacion.setValue("");
		txtCodVideoJet.setValue("");
		txtPNeto.setValue("");
		
		lbxTurnoLabor.getItems().clear();
		lbxItemOrden.getItems().clear();
		lbxMSelladora.getItems().clear();
		lbxLuthy.getItems().clear();
		lbxLista.getItems().clear();
		lbxLista.setVisible(false);
		lbxTipoProteina.setSelectedIndex(0);
		
		lbxMes.setSelectedIndex(0);
		lbxDias.setSelectedIndex(0);
		lbxHoras.setSelectedIndex(0);
		lbxMinutos.setSelectedIndex(0);

//		Checkbox cbxLuthy;
		
		//Limpia Double
		dcbFill.setValue(null);
		dcbFlakes.setValue(null);
		dcbLatas.setValue(null);
		dcbH2O.setValue(null);
		dcbAceite.setValue(null);
		dcbDrenado.setValue(null);
		dcbProteina.setValue(null);
		
		cargaInfoInicial();
	}
	/*********************************************************************************/
	/***********************************GET&SET***************************************/
	/*********************************************************************************/
	public Textbox getTxtProduccionTurno() {
		return txtProduccionTurno;
	}

	public void setTxtProduccionTurno(Textbox txtProduccionTurno) {
		this.txtProduccionTurno = txtProduccionTurno;
	}

	public Listbox getLbxTurnoLabor() {
		return lbxTurnoLabor;
	}

	public void setLbxTurnoLabor(Listbox lbxTurnoLabor) {
		this.lbxTurnoLabor = lbxTurnoLabor;
	}

	public Listbox getLbxItemOrden() {
		return lbxItemOrden;
	}

	public void setLbxItemOrden(Listbox lbxItemOrden) {
		this.lbxItemOrden = lbxItemOrden;
	}

	public Textbox getTxtOrden() {
		return txtOrden;
	}

	public void setTxtOrden(Textbox txtOrden) {
		this.txtOrden = txtOrden;
	}

	public Textbox getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(Textbox txtProducto) {
		this.txtProducto = txtProducto;
	}

	
	public Listbox getLbxMSelladora() {
		return lbxMSelladora;
	}

	
	public void setLbxMSelladora(Listbox lbxMSelladora) {
		this.lbxMSelladora = lbxMSelladora;
	}

	
	public Listbox getLbxLuthy() {
		return lbxLuthy;
	}

	
	public void setLbxLuthy(Listbox lbxLuthy) {
		this.lbxLuthy = lbxLuthy;
	}

	
	public Listbox getLbxLista() {
		return lbxLista;
	}

	
	public void setLbxLista(Listbox lbxLista) {
		this.lbxLista = lbxLista;
	}

	
	public Textbox getTxtObservacion() {
		return txtObservacion;
	}

	
	public void setTxtObservacion(Textbox txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public Listbox getLbxMes() {
		return lbxMes;
	}

	public void setLbxMes(Listbox lbxMes) {
		this.lbxMes = lbxMes;
	}

	public Listbox getLbxDias() {
		return lbxDias;
	}

	public void setLbxDias(Listbox lbxDias) {
		this.lbxDias = lbxDias;
	}

	public Listbox getLbxHoras() {
		return lbxHoras;
	}

	public void setLbxHoras(Listbox lbxHoras) {
		this.lbxHoras = lbxHoras;
	}

	public Listbox getLbxMinutos() {
		return lbxMinutos;
	}

	public void setLbxMinutos(Listbox lbxMinutos) {
		this.lbxMinutos = lbxMinutos;
	}

	/*********************************************************************************/
	/***********************************valida Doubles********************************/
	/*********************************************************************************/

//	public void onChange$dcbLatas(InputEvent event) throws InterruptedException, IOException {
//		dcbLatas.setValue(parseDouble(event.getValue()));
//	}
//	
//	public void onChange$dcbFill(InputEvent event) throws InterruptedException, IOException {
//		dcbFill.setValue(parseDouble(event.getValue()));
//	}
//	
//	public void onChange$dcbAceite(InputEvent event) throws InterruptedException, IOException {
//		dcbAceite.setValue(parseDouble(event.getValue()));
//	}
//	
//	public void onChange$dcbProteina(InputEvent event) throws InterruptedException, IOException {
//		dcbProteina.setValue(parseDouble(event.getValue()));
//	}
//	
//	public void onChange$dcbDrenado(InputEvent event) throws InterruptedException, IOException {
//		dcbDrenado.setValue(parseDouble(event.getValue()));
//	}
//	
//	public void onChange$dcbFlakes(InputEvent event) throws InterruptedException, IOException {
//		dcbFlakes.setValue(parseDouble(event.getValue()));
//	}
	
	/**
	 * valida el valor del punto o la coma para el tipo de dato Double
	 * @param valor
	 * @return
	 */
	private static Double parseDouble(String valor) {
		try {
			//retorna el valor recibido
			return Double.valueOf(valor);
		} catch(Exception e){
			try {
				//retorna el valor reemplazando el punto por la coma.
				if (valor !=null)
					if (!valor.isEmpty())
						return new Double(valor.replaceAll("\\.", ","));
				return Double.valueOf(valor);
			}catch(Exception e1) {
				try {
					if (valor !=null)
						if (!valor.isEmpty())
							return new Double(valor.replaceAll(",", "\\."));
					return Double.valueOf(valor);
				}catch(Exception e2) {
//					e.printStackTrace();
					return new Double("");
				}
			}
		}
	}

}

