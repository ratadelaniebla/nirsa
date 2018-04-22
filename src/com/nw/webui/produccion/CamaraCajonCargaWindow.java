package com.nw.webui.produccion;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Progressmeter;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;

import com.nw.model.Barco;
import com.nw.model.BarcoCuba;
import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.Cajon;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraCajonCarga;
import com.nw.model.CamaraFilaColumna;
import com.nw.model.Cuba;
import com.nw.model.EspecieTalla;
import com.nw.model.TipoCaptura;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.CamaraCajonCargaDAOJpaImpl;
import com.nw.util.ExcelReadWrite;
import com.nw.util.Sistema;
import com.nw.util.WorkingDirectory;

public class CamaraCajonCargaWindow extends GenericForwardComposer{
	 
	private static final long serialVersionUID = 1L;
	Textbox txtNovedad, txtExaminar, txtNomArchivo, txtDiaProd, txtTurno;
	Datebox dteFecReg;
	Vbox flist;
	Hbox hl;
	Button btnExaminar, btnCargarGrabar;
	Media media;
	boolean ValidarDatos;
	Usuario usuario = new Usuario();
	Usuario usu = new Usuario();
	
	List<CamaraCajonCarga> camarasCajonCargas = new ArrayList<CamaraCajonCarga>();
	
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	
	public CamaraCajonCargaWindow() {
	 
	}
	
	// BOTON btnExaminar
	public void onClick$btnExaminar() throws InterruptedException, IOException {
		try {

			// nuevo();
			//Media media 
			media = Fileupload.get();

			System.out.println("media-->" + media.getName());
			flist = new Vbox();
			Hbox hl = new Hbox();
	
			hl.setSpacing("6px");
			hl.setClass("newFile");
			Progressmeter pm = new Progressmeter();
			hl.appendChild(pm);
			hl.appendChild(new Label(media.getName()));
			flist.appendChild(hl);
			//@SuppressWarnings("unused")
			//String filename = addItemMedia(media);
			boolean estado = consultarFormatoArchivo(media.getName());
			if (estado == true)
			{
				Sistema.mensaje("El formato del archivo es no es compatible de ser: (.xls)");
				return; 
			}
			txtExaminar.setValue(media.getName());
			txtNomArchivo.setValue(media.getName());
			ValidarDatos = false;

		} catch (Exception e) {
			System.out.println("paso esto -->" + e.getMessage());
		}
	}
	 
	
	public void onClick$btnCargarGrabar() throws InterruptedException {
		//  ValidarDatos = true ||
		if ( this.media==null ) {
			Sistema.mensaje("Debe cargar un archivo de excel..");
			txtNovedad.setValue("");
			return;
		}
		
//		Usuario usu = new Usuario();
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
/*		
		if (usuarioid==null||usuarioid.endsWith("")) {
			Sistema.mensaje("Usuario no se ha autenticado... ");
			return;
		}*/
		//usuario.setIdusuario("ticcamara");
		
		txtNovedad.setValue(txtNovedad.getValue() + "\n"
				+ "Iniciando lectura de archivo " + txtNomArchivo.getValue());
		
		// TODO LINEA MAGICA... PARA LECTURA DE ARCHIVO
		//List sheetData = new ExcelReadWrite().readAllExcelMedia(this.media, 0);
		leerExelData(this.media, 0);
		
		
		txtNovedad.setValue(txtNovedad.getValue() + "\n"
				+ "Lecura exitosa de archivo " + txtNomArchivo.getValue()
				+ "\n");

		
		
	}

	
	
	public String addItemMedia(org.zkoss.util.media.Media media)
			throws IOException {
		txtNovedad.setValue(txtNovedad.getValue() + "\n Archivo -->"
				+ media.getName() + " ...Subiendo Archivo ");

		String fileName = WorkingDirectory.get().toString() + "\\upload\\"
				+ media.getName();
		// String fileName="\\upload\\"+media.getName();
		File dst = new File(fileName);
		// Media media = Fileupload.get();
		org.zkoss.io.Files.copy(dst, media.getStreamData());
		return fileName;
	}

 
	
	@SuppressWarnings("unused")
	public Boolean consultarFormatoArchivo(String para_nombreArchivo) {
		String archivo;
		boolean estado = false;
		
		if (para_nombreArchivo.contains("xlsx")){
			nuevo();
			archivo="";
			return estado = true;
		}
		else
		{
			return estado = false;
		}
				
	}
	
	
	public void nuevo() {
		txtNovedad.setValue("");
		txtExaminar.setValue("");
		txtNomArchivo.setValue("");
		txtDiaProd.setValue("");
		txtTurno.setValue("");
		//dteFecReg.setValue(new Date());
		
	}
	
 
	
	@SuppressWarnings({ "unused", "rawtypes" })
	private void leerExelData(Media media, int hoja) throws InterruptedException {
		 
		List sheetData = new ExcelReadWrite().readAllExcelMedia(this.media, 0);
		List list; 
		List listcontenido; 

		int cantidadcolumnas = 4;
		 String nombre;

			for (int i = 1; i < sheetData.size(); i++) { //recorremos las filas dsde la segunda
				
			  if (ValidarDatos == false){
				
				//list almacena cada fila 
				//de la hoja 
				//el tamaño  de list es el valor de las columnas de izquierda a derecha
				//ej:
				//material, descripcion , lote .... ->
				list = (List) sheetData.get(i);
				
				if (list.size() > 5) { //pregunto por la cantidad de columnas
					
					//si no esten vacias las columnas principales 
					if ( (!list.get(0).toString().equals("")) //material
							&& (!list.get(1).toString().equals("")) //descripcion material
							&& (!list.get(2).toString().equals("")) //lote
							&& (!list.get(3).toString().equals("")) //usuario
							&& (!list.get(4).toString().equals(""))//fecha Creacion
							&& (!list.get(5).toString().equals(""))// barco
							&& (!list.get(6).toString().equals("")) //viaje
							&& (!list.get(7).toString().equals("")) // origen  // tip cap lo omiti xq ta vacio
							&& (!list.get(8).toString().equals("")) // zonafao  
							&& (!list.get(10).toString().equals("")) // cuba
							&& (!list.get(11).toString().equals("")) // cajon
							&& (!list.get(12).toString().equals("")) // peso bruto //double
							&& (!list.get(13).toString().equals(""))  // peso neto  //double
							&& (!list.get(14).toString().equals("")) // tara  //double
							&& (!list.get(15).toString().equals(""))  //registro  cv
							&& (!list.get(16).toString().equals("")) //doc referencia  cv
							&& (!list.get(17).toString().equals(""))  //ticket
							&& (!list.get(18).toString().equals(""))  //ubicacion camara   //integer
							&& (!list.get(19).toString().equals("")) // fila   // integer
							&& (!list.get(20).toString().equals("")) // columna  cv
							&& (!list.get(21).toString().equals("")) // peso libre utilizacion //double
							
					){
						CamaraCajonCarga cc = new CamaraCajonCarga();
						cc.setIdmaterial(list.get(0).toString());
						cc.setDescripcionMaterial(list.get(1).toString());
						cc.setLotecajonsap(list.get(2).toString());
						cc.setUsuario(list.get(3).toString());
						Timestamp fechacreacion = obtenerStringATimeStamp(list.get(4).toString());
						if (fechacreacion==null) {
							Sistema.mensaje("Fecha con formato diferente o vacia");
							return;
						}
						cc.setFechacreacion(fechacreacion);
						cc.setIdbarco(list.get(5).toString());
						cc.setIdviaje(list.get(6).toString());
						cc.setIdorigen(list.get(7).toString());
						cc.setZonafao(list.get(8).toString());
						// aki deberia asignar tipo captura
						if (list.get(9).toString().equals("")) {
							cc.setIdtipocaptura("-");
						}else{
							cc.setIdtipocaptura(list.get(9).toString());
						}
						cc.setIdcuba(list.get(10).toString());
						cc.setIdcajon(list.get(11).toString());
						cc.setPesobruto(Double.valueOf(list.get(12).toString()).doubleValue());
						cc.setPesoneto(Double.valueOf(list.get(13).toString()).doubleValue());
						cc.setTara(Double.valueOf(list.get(14).toString()).doubleValue());
						cc.setNumregistro(list.get(15).toString());
						cc.setReferencia(list.get(16).toString());
						cc.setTicket(list.get(17).toString());
						cc.setUbicacionCamara(Integer.valueOf(list.get(18).toString()).intValue());
						cc.setFila(Integer.valueOf(list.get(19).toString()).intValue());
						cc.setColumna(list.get(20).toString());
						cc.setPesolibreutilizacion(Double.valueOf(list.get(21).toString()).doubleValue());
						cc.setFechareg(new Timestamp(new Date().getTime()));
						
						// adiciono a la lista 
						camarasCajonCargas.add(cc);
						
 
						
					}// end if de diferente a vacio
					else {
						//si todas las filas(horizontalmente) estan vacias
						// salgo del for
						if ((list.get(0).toString().equals("")
								&& list.get(1).toString().equals("")
								&& list.get(2).toString().equals("")
								&& list.get(3).toString().equals("")
								&& list.get(4).toString().equals("")
								&& list.get(5).toString().equals("")
								&& list.get(6).toString().equals("")
								&& list.get(7).toString().equals("")
								&& list.get(8).toString().equals("")
								&& list.get(9).toString().equals("")
								&& list.get(10).toString().equals("") 
								&& list.get(11).toString().equals("")))
						{
							
							break;
						} else {
							// esto le puse yo 
							// pregunto si alguna fila esta vacia
							if ((list.get(0).toString().equals("")
									|| list.get(1).toString().equals("")
									|| list.get(2).toString().equals("")
									|| list.get(3).toString().equals("")
									|| list.get(4).toString().equals("")
									|| list.get(5).toString().equals("")
									|| list.get(6).toString().equals("")
									|| list.get(7).toString().equals("")
									|| list.get(8).toString().equals("")
									|| list.get(9).toString().equals("")
									|| list.get(10).toString().equals("")
									|| list.get(11).toString().equals("")
									|| list.get(12).toString().equals("")
									|| list.get(13).toString().equals("")
									|| list.get(14).toString().equals("")
									|| list.get(15).toString().equals("")
									|| list.get(16).toString().equals("")
									|| list.get(17).toString().equals("")
									|| list.get(18).toString().equals("")
									|| list.get(19).toString().equals("")
									|| list.get(20).toString().equals("")
									|| list.get(21).toString().equals("")
								))

							{
								validarContenido(this.media,i);
							}
							
							
						}

					}
				}//end if list.size() >5
				else {
					break;
				}
			  }else{
					//Sistema.mensaje("d vacio");
					return ; 
	
				}
			  
			}// fin for
		 
		//llamar al metodo q guarda y enviarle la lista con los datos asignados
			//si es false no han existidos problemas
			if (grabarRegistros()==false) {
				Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			} 
		
		//return "";
	}
	
	
	
  public boolean grabarRegistros(){
	  boolean estado =false;
		System.out.println("tamaño de lista camara cajon cargas-->"+camarasCajonCargas.size());
//		System.out.println("ticket->"+cc.getTicket() +"tipo captura->"+cc.getIdtipocaptura()
//				+"fecha creacion->"+cc.getFechacreacion());
		
		CamaraCajonCargaDAOJpaImpl daoCamaraCajonCarga = new CamaraCajonCargaDAOJpaImpl();
		
		for (CamaraCajonCarga ccc : camarasCajonCargas) 
		{
			
			//buscar cada lote(lotecajonsap) en camara cajon 
			// si no existe ahy q ingresar el registro en camara cajon
			CamaraCajon camara = new CamaraCajon();
			int idlote = Integer.valueOf(ccc.getLotecajonsap().trim()).intValue();
			System.out.println("id especie fortmateada->"+idlote);
			String idlotesap = String.valueOf(idlote);
			
			//Verifica si existe el cajón por el lote SAP
			camara = daoCamaraCajonCarga.getCamaraCajonByLoteCajonSap(idlotesap.trim());
			
			//No existe el cajón
			if (camara==null) 
			{
				//NUEVO REGISTRO
				//debo insertar el registro en camara cajon 
				System.out.println("asignando a camara cajon");
				// aki se debe consultar sino hay ningun error de buskeda
				// de cada campo del archivo ej: barcocuba,barcodescarga etc
				
				//ccc.- Es camara_cajon_archivo, el cual contiene todos los datos que
				//se necesitan para insertar en camara_cajon
				
				//Crea un nuevo objeto tipo "camaraConsulta"
				CamaraCajon camaraConsulta =new CamaraCajon();
				
				//Asigna todos los dade de ccc en camaraConsulta (tipo camara_cajon)
				camaraConsulta = asignarCargaToCamaraCajon(ccc);
				
				//Verifica si el objeto camaraConsulta se lleno con datos producto de la asignación
				if (camaraConsulta!=null) 
				{
//					 camaraConsulta.setUsuario(this.usuario);
					 camaraConsulta.setUsuario(usu);
					 
					 daoCamaraCajonCarga.saveOrUpdateCamaraCajon(camaraConsulta);
					 
					 //tambien grabo en la tabla de carga
					 daoCamaraCajonCarga.saveOrUpdate(ccc);
				}
				else
					{
						estado =true;
						return estado;
					}
			}
			else
				/////////////////
				//ACTUALIZACION//
				/////////////////
				{
					//CamaraCajon camaraConsulta =new CamaraCajon();
					//camaraConsulta = asignarCargaToCamaraCajon(ccc);
//
//					
//					//Crea un nuevo objeto tipo "camaraConsulta"
//					CamaraCajon camaraConsulta =new CamaraCajon();
//					
//					//Asigna todos los dade de ccc en camaraConsulta (tipo camara_cajon)
//					camaraConsulta = asignarCargaToCamaraCajon(ccc);
					
					camara = asignarCamaraCajonCargaToCamaraCajon(ccc, camara);
					//camara.setTara(ccc.getTara());
					
					
					if (camara!=null) 
					{
						daoCamaraCajonCarga.saveOrUpdateCamaraCajon(camara);
						
						//guarda cada registro del archivo
						daoCamaraCajonCarga.saveOrUpdate(ccc);
					}
					else
						{
							estado = true;
							return estado;
						}
				}
		}

		
		return estado;
		
	}
	
	/**
	 * consulta y asignacion de valores al ojbeto camara cajon
	 * si no devuelve null las consultas y asginaciones estan bien
	 * @param cc
	 * @return
	 */
	public CamaraCajon asignarCargaToCamaraCajon(CamaraCajonCarga cc){
	   CamaraCajonCargaDAOJpaImpl dao = new CamaraCajonCargaDAOJpaImpl();
	   CamaraCajon camara = new CamaraCajon();
	    //busquedas
		EspecieTalla et = new EspecieTalla();
		int idespecie = Integer.valueOf(cc.getIdmaterial()).intValue();
		//System.out.println("id especie->"+idespecie);
		et = dao.getEspecieTallaById(idespecie);
		if (et!=null) {
			camara.setEspecieTalla(et);
		}else{
			Sistema.mensaje("No existe Espcecie talla con idmaterial ->"+idespecie);
			return null;
		}
		
		//et.setIdespecietalla(idespecie);
		
		BarcoDescarga bd = new BarcoDescarga();
		// consultar el bd por viaje , origen y registro
		//int origen = Integer.valueOf(cc.getIdorigen().trim());
		//int viaje = Integer.valueOf(cc.getIdviaje().trim());
		//bd = dao.getBarcoDescargaByViajeOrigenRegistro(origen, cc.getNumregistro().trim(), viaje);
		bd = dao.getBarcoDescargaByRegistro(cc.getNumregistro().trim());
		
		if (bd!=null) {
			camara.setBarcoDescarga(bd);
		}else{
			Sistema.mensaje("No existe barco Descarga con el Registro ->"+cc.getNumregistro());
			return null;
		}
		
		//buscar la cuba y el barco para obtener el barcoCuba y luego
		//con esto obteneer el barcoEstibaCuba q vaina 
		Cuba cuba = new Cuba();
		Barco barco = new Barco();
		BarcoCuba bc = new BarcoCuba();
		BarcoEstibaCuba bec = new BarcoEstibaCuba();
		cuba = dao.getCubaByNombre(cc.getIdcuba().trim());
		barco = dao.getBarcoByNombre(cc.getIdbarco().trim());
		System.out.println("El idbarco es :"+barco.getIdbarco().toString());
		System.out.println("El idcuba es :"+cuba.getIdcuba());
		bc = dao.getBarcoCubaByIdBarcoIdCuba(barco.getIdbarco(), cuba.getIdcuba());
		//bd 
		//bec = dao.getBarcoEstibaCubaByBarcoCuba(bc.getIdbarcocuba());
		bec = dao.getBarcoEstibaCubaByBarcoCubaBarcoDescarga(bc.getIdbarcocuba(),bd.getIdbarcodescarga());
		
		if (bec!=null) {
			camara.setBarcoEstibaCuba(bec);
		}else{
			Sistema.mensaje("No existe barcoEstibaCuba cuba->"+cc.getIdcuba()+"num barco->"+cc.getIdbarco());
			return null;
		}
		
		//cajon 
		Cajon cajon = new Cajon();
		//cajon.setIdcajon(cc.getIdcajon().trim());
		cajon = dao.getCajonById(cc.getIdcajon().trim());
		
		if (cajon!=null) {
			camara.setCajon(cajon);
		}else{
			Sistema.mensaje("No existe cajon->"+cc.getIdcajon());
			return null;
		}
		
		//ubicacion camara fila columna 
		CamaraFilaColumna cfc = new CamaraFilaColumna();
		CamaraFilaColumna cfcfijo = new CamaraFilaColumna();
		Long idcamara =  Long.valueOf(cc.getUbicacionCamara()).longValue();
		int idfila =  cc.getFila();
		
		cfc = dao.getCamaraFilaColumnaByIdCamaraFilaColumna(idcamara, cc.getColumna().trim(), idfila);
		if (cfc==null) {
			//asignar el  idfilacolumna = 4635
			cfcfijo.setIdcamarafilacolumna(Long.valueOf(4635).longValue());
			camara.setCamaraFilaColumna(cfcfijo);
		}else{
			camara.setCamaraFilaColumna(cfc);
		}
		
//		Usuario usuario = new Usuario();
//		usuario = new UsuarioDAOJpaImpl().getUser(cc.getUsuario().trim());
//		usuario.setIdusuario("ticcamara");
//		camara.setUsuario(usuario);
		
		//ASIGNACION A CAMARA
		
		//camara.setCamara(camara);
		//camara.setCamaraArea(camaraArea);
		//camara.setCamaraCajonRegistroSap(camaraCajonRegistroSap);
		camara.setEstado(0);
		camara.setFechareg(cc.getFechacreacion());
		camara.setFechaactualizacion(new Timestamp(new Date().getTime()));
		int idlote = Integer.valueOf(cc.getLotecajonsap().trim()).intValue();
		String idlotesap = String.valueOf(idlote);
		camara.setLotecajonsap(idlotesap.trim());
		camara.setPesobruto(cc.getPesobruto());
		camara.setPesoneto(cc.getPesoneto());
		camara.setTara(cc.getTara());
		camara.setTicket(cc.getTicket().trim());
		TipoCaptura tc = new TipoCaptura();
		tc.setIdtipocaptura(cc.getIdtipocaptura());
		camara.setTipoCaptura(tc);
		//camara.setTipotratamiento(tipotratamiento)
		camara.setZonafao(cc.getZonafao().trim());
		camara.setPesolibreutilizacion(cc.getPesolibreutilizacion());
		
		Sistema.mensaje("Libre :"+String.valueOf(camara.getPesolibreutilizacion()));
		// se retorna el camara cajon con los datos asignados 
		// si no ha habido errores de consulta de algunas propiedades
		// para la asignacion
		return camara;
		
	}
	

	/**
	 * consulta y asignacion de valores al ojbeto camara cajon
	 * si no devuelve null las consultas y asginaciones estan bien
	 * @param cc
	 * @return
	 */
	public CamaraCajon asignarCamaraCajonCargaToCamaraCajon(CamaraCajonCarga cc, CamaraCajon camara){
	   CamaraCajonCargaDAOJpaImpl dao = new CamaraCajonCargaDAOJpaImpl();
	   //CamaraCajon camara = new CamaraCajon();
	    //busquedas
		EspecieTalla et = new EspecieTalla();
		int idespecie = Integer.valueOf(cc.getIdmaterial()).intValue();
		//System.out.println("id especie->"+idespecie);
		et = dao.getEspecieTallaById(idespecie);
		if (et!=null) {
			camara.setEspecieTalla(et);
		}else{
			Sistema.mensaje("No existe Espcecie talla con idmaterial ->"+idespecie);
			return null;
		}
		
		//et.setIdespecietalla(idespecie);
		
		BarcoDescarga bd = new BarcoDescarga();
		// consultar el bd por viaje , origen y registro
		//int origen = Integer.valueOf(cc.getIdorigen().trim());
		//int viaje = Integer.valueOf(cc.getIdviaje().trim());
		//bd = dao.getBarcoDescargaByViajeOrigenRegistro(origen, cc.getNumregistro().trim(), viaje);
		bd = dao.getBarcoDescargaByRegistro(cc.getNumregistro().trim());
		
		if (bd!=null) {
			camara.setBarcoDescarga(bd);
		}else{
			Sistema.mensaje("No existe barco Descarga con el Registro ->"+cc.getNumregistro());
			return null;
		}
		
		//buscar la cuba y el barco para obtener el barcoCuba y luego
		//con esto obteneer el barcoEstibaCuba q vaina 
		Cuba cuba = new Cuba();
		Barco barco = new Barco();
		BarcoCuba bc = new BarcoCuba();
		BarcoEstibaCuba bec = new BarcoEstibaCuba();
		cuba = dao.getCubaByNombre(cc.getIdcuba().trim());
		barco = dao.getBarcoByNombre(cc.getIdbarco().trim());
		System.out.println("El idbarco es :"+barco.getIdbarco().toString());
		System.out.println("El idcuba es :"+cuba.getIdcuba());
		bc = dao.getBarcoCubaByIdBarcoIdCuba(barco.getIdbarco(), cuba.getIdcuba());
		//bd 
		//bec = dao.getBarcoEstibaCubaByBarcoCuba(bc.getIdbarcocuba());
		bec = dao.getBarcoEstibaCubaByBarcoCubaBarcoDescarga(bc.getIdbarcocuba(),bd.getIdbarcodescarga());
		
		if (bec!=null) {
			camara.setBarcoEstibaCuba(bec);
		}else{
			Sistema.mensaje("No existe barcoEstibaCuba cuba->"+cc.getIdcuba()+"num barco->"+cc.getIdbarco());
			return null;
		}
		
		//cajon 
		Cajon cajon = new Cajon();
		//cajon.setIdcajon(cc.getIdcajon().trim());
		cajon = dao.getCajonById(cc.getIdcajon().trim());
		
		if (cajon!=null) {
			camara.setCajon(cajon);
		}else{
			Sistema.mensaje("No existe cajon->"+cc.getIdcajon());
			return null;
		}
		
		//ubicacion camara fila columna 
		CamaraFilaColumna cfc = new CamaraFilaColumna();
		CamaraFilaColumna cfcfijo = new CamaraFilaColumna();
		Long idcamara =  Long.valueOf(cc.getUbicacionCamara()).longValue();
		int idfila =  cc.getFila();
		
		cfc = dao.getCamaraFilaColumnaByIdCamaraFilaColumna(idcamara, cc.getColumna().trim(), idfila);
		if (cfc==null) {
			//asignar el  idfilacolumna = 4635
			cfcfijo.setIdcamarafilacolumna(Long.valueOf(4635).longValue());
			camara.setCamaraFilaColumna(cfcfijo);
		}else{
			camara.setCamaraFilaColumna(cfc);
		}
		
//		Usuario usuario = new Usuario();
//		usuario = new UsuarioDAOJpaImpl().getUser(cc.getUsuario().trim());
//		usuario.setIdusuario("ticcamara");
//		camara.setUsuario(usuario);
		
		//ASIGNACION A CAMARA
		
		//camara.setCamara(camara);
		//camara.setCamaraArea(camaraArea);
		//camara.setCamaraCajonRegistroSap(camaraCajonRegistroSap);
		camara.setEstado(0);
		camara.setFechareg(cc.getFechacreacion());
		camara.setFechaactualizacion(new Timestamp(new Date().getTime()));
		int idlote = Integer.valueOf(cc.getLotecajonsap().trim()).intValue();
		String idlotesap = String.valueOf(idlote);
		camara.setLotecajonsap(idlotesap.trim());
		camara.setPesobruto(cc.getPesobruto());
		camara.setPesoneto(cc.getPesoneto());
		camara.setTara(cc.getTara());
		camara.setTicket(cc.getTicket().trim());
		TipoCaptura tc = new TipoCaptura();
		tc.setIdtipocaptura(cc.getIdtipocaptura());
		camara.setTipoCaptura(tc);
		//camara.setTipotratamiento(tipotratamiento)
		camara.setZonafao(cc.getZonafao().trim());
		camara.setPesolibreutilizacion(cc.getPesolibreutilizacion());
		
		Sistema.mensaje("Libre :"+String.valueOf(camara.getPesolibreutilizacion()));
		// se retorna el camara cajon con los datos asignados 
		// si no ha habido errores de consulta de algunas propiedades
		// para la asignacion
		return camara;
		
	}
	
	
	
	public void validarContenido(Media mediaexcel ,int fila){
		int i = fila;
		  ValidarDatos = false;//prueba era de 8 el final es de 20
		 // con el for de j se recorre todas las columnas q se usan del archivo
		for (int j = 0; j <= 20; j++) {
			if (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 
					|| j == 10 || j == 11 || j == 12 || j == 13 || j == 14 || j == 15 || j == 16 || j == 17 
					|| j == 18 || j == 19 || j == 20) { 
				String especieTalla1 = new ExcelReadWrite().readExcelMedia(mediaexcel,
						0, i, j);
				if (especieTalla1.equals("")) {
					Sistema.mensaje("campo vacio en celda " + (i + 1)
							+ " columna " + (j + 1) + " ");
					this.media = null;
					txtNovedad.setValue("");
					ValidarDatos = true;
					nuevo();
					//return ValidarDatos;
					return;
				}
			}
		}
		//return ValidarDatos;
	}

	
	public Timestamp obtenerStringATimeStamp(String para_fecha) {

		try{
			//dd-MMM-yyyy hh:mm:ss.SSS
			para_fecha = para_fecha+" "+"00:00:00";
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		    Date parsedDate = dateFormat.parse(para_fecha);
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    return timestamp;
		 }catch(Exception e){//this generic but you csan control another types of exception
		 //look the origin of excption 
			 e.printStackTrace();
			 System.out.println("paso esto->"+e.getMessage());
			 //Sistema.mensaje("Los formatos de fecha creacion en el archivo no pueden ser procesados.. ");
			return null;
		 }

	}
	
	
	
}
