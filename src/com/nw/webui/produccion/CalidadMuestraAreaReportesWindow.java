package com.nw.webui.produccion;

import net.sf.jasperreports.engine.JRException;

import org.zkoss.util.media.AMedia;
//import org.zkoss.zul.Checkbox;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.Cajon;
import com.nw.model.CalidadMuestraAreaCabecera;
import com.nw.model.Camara;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraFilaColumna;
import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.EspecieTalla;
import com.nw.model.Parametro;
import com.nw.model.TipoCaptura;
import com.nw.model.Turno;
//import com.nw.model.Usuario;
import com.nw.model.dao.impl.CalidadMuestraAreaDetalleDAOJpaImpl;
//import com.nw.model.dao.impl.CalidadMuestrasClasificacionDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonUbicacionDAOJpaImpl;
import com.nw.model.dao.impl.CamaraDAOJpaImpl;
import com.nw.model.dao.impl.CamaraFilaColumnaDAOJpaImpl;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.temp.model.ColumnaCamara;
import com.nw.temp.model.FilaCamara;
import com.nw.util.LlamarSAP;
import com.nw.util.Sistema;


public class CalidadMuestraAreaReportesWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	
	//Objetos zul
	Listbox lbxBarcoDescarga,lbxCajones, lbxLoteHccp; // lbxTurno
	Toolbarbutton btnGrabar,btnBuscarBarco;
	Datebox dteFecInicio,dteFecFin;
	//Textbox txtCajon;
	
    
	//Objetos
	CamaraCajon camaraCajon = null;
	BarcoDescarga barcoDescarga = null;
	BarcoEstibaCuba barcoEstibaCuba = null;
	EspecieTalla especieTalla = null;
	Turno turno = null;
	Cajon cajonconsultado = new Cajon();
	TipoCaptura tipoCaptura = null;
	Camara camara;
	FilaCamara fila;
	ColumnaCamara columna;
	Parametro parametro = new Parametro();	
	
	//Listados
	List<CamaraCajon> camaraCajones = null;
	List<BarcoDescarga> barcosDescargas = null;
	List<BarcoEstibaCuba> barcosEstibaCubas = null;
	List<Turno> turnos = null;
	List<TipoCaptura> tipoCapturas = null;
	List<Camara> camaras = new CamaraDAOJpaImpl().getCamara();	
	CamaraFilaColumnaDAOJpaImpl camaraFilaColumnaDAOJpaImpl = new CamaraFilaColumnaDAOJpaImpl();
	CamaraCajonDAOJpaImpl camaraCajonDAOJpaImpl = new CamaraCajonDAOJpaImpl();
	CamaraCajonUbicacionDAOJpaImpl camaraCajonUbicacionDAOJpaImpl = new CamaraCajonUbicacionDAOJpaImpl();
	
	CamaraFilaColumna camaraFilaColumna; 
	//lista de columnas en q se llenara seguna la camara seleecionada
	List<ColumnaCamara> columnasCamara = new ArrayList<ColumnaCamara>();
	List<FilaCamara> filasCamara = new ArrayList<FilaCamara>();
	//variables 
	Double peso = 0.00;
	Double pesod = 0.00;

	CamaraCajon camaracajon = new CamaraCajon();
	
	CalidadMuestraAreaCabecera calidadMuestraAreaCabecera = new CalidadMuestraAreaCabecera();
	List<CalidadMuestraAreaCabecera> lcalidadMuestraAreaCabecera = null;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		dteFecInicio.setValue(new Date());
		dteFecFin.setValue(new Date());
		cargarTurnos();
//		cargarTiposCapturas();
//		cargarListaCamaras();
	}

	
	/********************************  Metodos vista ***********************************************/
	
	public void onClick$btnBuscarBarco()
	{
		camaraCajon = null;
		barcoDescarga = null;
		calidadMuestraAreaCabecera =  null;
		lbxLoteHccp.getItems().clear();
		lbxBarcoDescarga.getItems().clear();
		
		barcosDescargas = new ArrayList<BarcoDescarga>();
		barcosDescargas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getBarcoDescargaPorFechaDescarga(dteFecInicio.getValue(),  getAumentarUnDiaAFecha(dteFecFin.getValue()));

		//lleno el listbox de barco descarga
		cargarBarcosDescargaPorFecha(barcosDescargas);
	}
	
	public void onSelect$lbxBarcoDescarga()
	{
		camaraCajon = null;
		barcoDescarga = null;
		calidadMuestraAreaCabecera =  null;
		lbxLoteHccp.getItems().clear();
		
		if (lbxBarcoDescarga.getSelectedIndex() > 0)
		{
			seleccionarBarcoDescarga();
			cargarLotesHaccp();
		}
		
	}

	
	private void cargarLotesHaccp()
	{
		lbxLoteHccp.getItems().clear();
		List <CalidadMuestraAreaCabecera> lcalidadMuestraAreaCabecera = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescarga(barcoDescarga.getIdbarcodescarga());

		Listitem li = new Listitem();
		li.setValue(new CalidadMuestraAreaCabecera());
		li.setParent(lbxLoteHccp);			
		
		for (CalidadMuestraAreaCabecera o: lcalidadMuestraAreaCabecera)
		{
			li = new Listitem();
			li.setValue(o);
			
			if (o.getTurno() != null) {
				new Listcell( o.getLotehaccp()+ " - " + o.getCalidadMuestraArea().getDescripcion()+" - Turno "+o.getTurno().getIdturno()).setParent(li);
			}else{
				new Listcell( o.getLotehaccp()+ " - " + o.getCalidadMuestraArea().getDescripcion() ).setParent(li);				
			}
			
			li.setParent(lbxLoteHccp);
			
//			li = new Listitem();
//			li.setValue(o);
//			li.setParent(lbxLoteHccp);
//			new Listcell(o.getLotehaccp()).setParent(li);
//			li.setParent(lbxLoteHccp);			
		}
		
		lbxLoteHccp.setSelectedIndex(0);
		
		System.out.println("barcoDescarga ID ->" + barcoDescarga.getIdbarcodescarga());
	}
	

	
	public void onSelect$lbxLoteHccp() throws InterruptedException{
		 
		if (lbxLoteHccp.getSelectedIndex()>0) 
		{
			//vaciamos el objeto barcoDescarga creando una nueva instancia 
			calidadMuestraAreaCabecera = new CalidadMuestraAreaCabecera();
			calidadMuestraAreaCabecera = (CalidadMuestraAreaCabecera) lbxLoteHccp.getSelectedItem().getValue();
			}
			else
			{
				calidadMuestraAreaCabecera = null;
			}
		
	}
	
	
	public void actualizar()
	{
		String resultado = "";		
		try {
			
			parametro = new Parametro();
			//Tomamos el parametro del sistema operativo 1=Linux, 2=Windows
			parametro= new ParametroDAOJpaImpl().getParametroById(String.valueOf(96));
			int so;
			so = (int) parametro.getValor();
			resultado = new LlamarSAP().ejecutar(so, "ZMM_DATOS_HACCP", 1, calidadMuestraAreaCabecera.getLotehaccp().trim());
			
			List<CalidadMuestraAreaCabecera> lcalidadMuestraAreaCabecera;
			
			lcalidadMuestraAreaCabecera = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByHaccp(calidadMuestraAreaCabecera.getLotehaccp().trim());

			System.out.println("Tama�o :"+lcalidadMuestraAreaCabecera);
			
			for (CalidadMuestraAreaCabecera o: lcalidadMuestraAreaCabecera)
			{
				
				System.out.println("CAB :"+o.getIdcalidadmuestraareacabecera().toString());
				
				CalidadMuestraAreaCabecera calidadMuestraAreaCabecera = new CalidadMuestraAreaCabecera();
				//Recuperamos la cebecera segun la lista
				calidadMuestraAreaCabecera = new CalidadMuestraAreaDetalleDAOJpaImpl().getListaCalidadMuestraAreaCabecerabyId(o.getIdcalidadmuestraareacabecera().toString());
				System.out.println("Resultado :"+resultado);
				
				//Actualizamos el total del lotehaccp
				calidadMuestraAreaCabecera.setTotalnetohaccp(Double.valueOf(resultado));
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(calidadMuestraAreaCabecera);
				
			}
				
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(resultado);

	}
	
	public void onClick$btnSAP() throws Exception
	{
		if (lbxBarcoDescarga.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione registro de descarga");
			lbxBarcoDescarga.setFocus(true);
			return;
		}
		
		if (lbxLoteHccp.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione lote Haccp");
			lbxLoteHccp.setFocus(true);
			return;
		}
		
		//TODO ESTE METODO DEBE DESCOMENTARSE
		actualizar();
		
		doImprimir("CalidadMuestrasRecepcionMateriaPrima.jasper");
	}
	
	public void onClick$btnPccAccionCorrectiva() throws Exception
	{
		if (lbxBarcoDescarga.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione registro de descarga");
			lbxBarcoDescarga.setFocus(true);
			return;
		}
		
		if (lbxLoteHccp.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione lote Haccp");
			lbxLoteHccp.setFocus(true);
			return;
		}
		
		//TODO ESTE METODO DEBE DESCOMENTARSE
		actualizar();
		
		doImprimir("CalidadMuestraAccionCorrectiva.jasper");
	}
	

	public void doImprimir(String nombre_report) throws JRException, SuspendNotAllowedException, InterruptedException 
	{

		//String nombre_report = "CalidadMuestrasRecepcionMateriaPrima.jasper";
		String logo = "logo_real.gif";
		
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

		Map parameters = new HashMap();
				
		parameters.put("LOGO",ruta_logo);
		parameters.put("LOTEHACCP",calidadMuestraAreaCabecera.getLotehaccp());
		//parameters.put("USUARIO",usuario);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);

		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	


	
	
	
	public void onClick$btnPCC1B() throws Exception
	{
		if (lbxBarcoDescarga.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione registro de descarga");
			lbxBarcoDescarga.setFocus(true);
			return;
		}
		
		if (lbxLoteHccp.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione lote Haccp");
			lbxLoteHccp.setFocus(true);
			return;
		}
		
		//TODO ESTE METODO DEBE DESCOMENTARSE
		actualizar();
		//Sistema.mensaje("calidadMuestraAreaCabecera ID CABECERA -> " + calidadMuestraAreaCabecera.getIdcalidadmuestraareacabecera());
		doImprimir2("CalidadMuestrasPCC1B.jasper", "1");
	}

	

	
	public void onClick$btnPROTOCOLO() throws Exception
	{
		if (lbxBarcoDescarga.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione registro de descarga");
			lbxBarcoDescarga.setFocus(true);
			return;
		}
		
		if (lbxLoteHccp.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione lote Haccp");
			lbxLoteHccp.setFocus(true);
			return;
		}
			
		//TODO ESTE METODO DEBE DESCOMENTARSE
		actualizar();
		//Sistema.mensaje("calidadMuestraAreaCabecera ID CABECERA -> " + calidadMuestraAreaCabecera.getIdcalidadmuestraareacabecera());
		doImprimir2("CalidadMuestrasEvaluacionProtocolos.jasper", "0");
	}
	
	
	
	public void doImprimir2(String nombre_report, String estado_visto) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		String logo = "logo_real.gif";
		
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

		Map parameters = new HashMap();

		String ruta_visto = ""; 
		if(estado_visto.equals("1"))
		{
			ruta_visto = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+"visto.png";
			parameters.put("visto",ruta_visto);
		}
		
				
		parameters.put("LOGO",ruta_logo);
		parameters.put("idcabecera",calidadMuestraAreaCabecera.getIdcalidadmuestraareacabecera());
		parameters.put("lotehac",calidadMuestraAreaCabecera.getLotehaccp().trim());
		//parameters.put("USUARIO",usuario);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);

		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	
	
	
	//Funcion Generica para visulizar los reportes
	public void EjecutarReporte(Map parameters, String ruta_report) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		
		parameters.put("USUARIO",usuario);
		//Ejecutamos el reporte y enviamos los 2 parametros, parameters y ruta_report
		//Obtenemos el reporte ejecutado en PDF en esta variable
		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl().ReportesDAOJpaImpl(parameters, ruta_report);

		//Creamos un obj. window donde estara el zul que se llamara
		Window win = (Window) Executions.createComponents("/produccion/VisorReporte.zul", null,null);
		
		//Enviamos los parametros al zul
		win.setAttribute("reporteejecutado", reporteejecutado);
		
		//Ejecutamos el objeto winsdows con con el zul (esta enbebido)
		win.doModal(); // It shows subwindow.zul window.
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void onSelect$lbxCuba(){
//		 seleccionarBarcoEstibaCuba();
//	}
	
//	public void onSelect$lbxTurno(){
//		 seleccionarTurno();
//	}
	
//	public void onSelect$lbxTipoCaptura(){
//		 seleccionarTipoCaptura();
//	}
//	
//	public void onClick$btnBuscarCajon(){
//		buscarRegistroCamaraCajon();
//	}
	
//	public void onClick$btnBuscarEspecieTalla(){
//		buscarRegistroEspecieTalla();
//	}
	
	
//	public void onClick$btnGrabar(){
//		guardarEditar();
//		txtTicket.setReadonly(false);
//		txtLoteCajonSap.setReadonly(false);		
//	}
	
//	public void onChanging$dbbxPesoBruto(InputEvent event){
//		 //System.out.println("valor peso bruto es -->"+event.getValue());
//		 String valor = "";
//		 valor = event.getValue();
//		 peso = 0.00;
//		 peso = Sistema.parseDouble(valor);
//		 recalcularPesoNeto(peso);
//		
//	}


//	public void onSelect$lbxCajonesDisponibles(){
//		txtTara.setValue(null);
//		limpiarControlesSinCajon();
//		
//		if (lbxCajonesDisponibles.getSelectedIndex() > 0)		
//		{
//			//Crear nuevo caj�n
//			if (lbxCajonesDisponibles.getSelectedIndex() == 1)		
//			{
//				 camaraCajon = new CamaraCajon();
//				 txtTara.setValue(String.valueOf(cajonconsultado.getTara()));
//				 //el cajon se encuentra registrado			
//				 String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
//				
////				 txtTicket.setReadonly(true);
////				 txtLoteCajonSap.setReadonly(true);
////				
////				 txtTicket.setValue("1");
////				 txtLoteCajonSap.setValue("1");
//				
//				if (usuario==null || usuario.equals("")) 
//				{
//					Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
//					return;
//				}				
//				
//			}
//			else
//			{
//				//Toma los datos de un caj�n existente
//				CargarDatosCajon();	
//			}
//		}	
//	}
	
	
//	public void CargarDatosCajon()
//	{
//		 camaraCajon = new CamaraCajon();
//		 camaraCajon = (CamaraCajon) lbxCajonesDisponibles.getSelectedItem().getValue();
//		 
//		 //camaraCajon = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCamaraCajonPorBarcoDescargaUnico(barcoDescarga, cajonconsultado.getIdcajon());
//		
//		//el cajon se encuentra registrado			
//		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
//		//System.out.println("valor de variable usuario-->"+usuario);
//		
//		if (usuario==null || usuario.equals("")) 
//		{
//			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
//			return;
//		}
//	
//		camaraCajon.setFechaactualizacion(new Timestamp(new Date().getTime()));
//		
//		//System.out.println("idcamaracajon->"+camaraCajon.getIdcamaracajon());
//		posicionarCuba();
//		posicionarTipoCaptura();
//		
//		//onSelect$lbxColumnas();
//
//		//asginar los demas valores de camara_cajon
//		txtPesoNeto.setValue(camaraCajon.getPesoneto()+"");		
//		txtTara.setValue(camaraCajon.getTara()+"");
//		txtTicket.setValue(camaraCajon.getTicket());
//		lbInfoCajon.setValue(camaraCajon.getCajon().getIdcajon());
//		dbbxPesoBruto.setValue(camaraCajon.getPesobruto());
//		txtLoteCajonSap.setValue(camaraCajon.getLotecajonsap());
//		txtEspecieTalla.setValue(camaraCajon.getEspecieTalla().getIdespecietalla()+"");
//		txtZonaFao.setValue(camaraCajon.getZonafao());
//		lbInfoEspecieTallaActual.setValue(camaraCajon.getEspecieTalla().getEspecie().getNombre()+" "+camaraCajon.getEspecieTalla().getTalla().getNombre());		
//		lbInfoEspecieTallaAnterior.setValue(camaraCajon.getEspecieTalla().getEspecie().getNombre()+" "+camaraCajon.getEspecieTalla().getTalla().getNombre());
//		
//		camaraFilaColumna = new CamaraFilaColumna();
//		camaraFilaColumna = camaraCajon.getCamaraFilaColumna();
//		
//		posicionarCamara();
//		onSelect$lbxCamaras();
//		
//		posicionarColumna();
//		onSelect$lbxColumnas();
//		
//		
//		//VER AQUI
//			//cargarListaFilasCamara();
//			posicionarFila();
//			onSelect$lbxFilas();		
//		
//	}
	
	
	
//	public void onChanging$txtCajon(InputEvent event){
//		 System.out.println("valor es -->"+event.getValue());
//		 buscarRegistroCamaraCajon();
//	}
	

	/********************************  Metodos Negocio ***********************************************/
	
	
	public void cargarBarcosDescargaPorFecha(List<BarcoDescarga> barcosDescargas){
		
		//llenar el listbox 
		// lbxBarcoDescarga
		
		lbxBarcoDescarga.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new CocinaAperturaCierreDetalle());
		li.setParent(lbxBarcoDescarga);
		
		for (BarcoDescarga bd : barcosDescargas) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell("("+ bd.getRegistro()+") " + "  " + bd.getBarco().getNombre()+" ").setParent(li); 
			li.setParent(lbxBarcoDescarga);		}
		lbxBarcoDescarga.setSelectedIndex(0);
	}
	
	public void seleccionarBarcoDescarga(){
		if (lbxBarcoDescarga.getSelectedIndex()>0) {
			 
			 barcoDescarga = new BarcoDescarga();
			 barcoDescarga = (BarcoDescarga) lbxBarcoDescarga.getSelectedItem().getValue();
			 
				//aki debo cargar las cubas del barco aperturado con esto lleno la lista
				// pasos -> barco_estiba_cuba -> barco_cuba -> cuba
				barcosEstibaCubas = new ArrayList<BarcoEstibaCuba>();
				barcosEstibaCubas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
				                            .getBarcoEstibaCubaBarcoDescarga(barcoDescarga);
				
				//cargarListadoCubasBarcos(barcosEstibaCubas);
			 
			 // esto ya no cargar los datos de la tabla camara_cajon en base al idbarcodescarga
			 // cargarInformacionCamaraCajon(barcoDescarga);
		}else{
			barcoDescarga = null;
		}
		
	}
	
	
//	public void seleccionarTurno(){
//		if (lbxTurno.getSelectedIndex()>0) {
//			 turno = new Turno();
//			 turno = (Turno) lbxTurno.getSelectedItem().getValue();
//		}else{
//			turno = null;
//		}
//	}
	
//	public void seleccionarTipoCaptura()
//	{
//		 
//		if (lbxTipoCaptura.getSelectedIndex()>0) 
//		{
//			 tipoCaptura = new TipoCaptura();
//			 tipoCaptura = (TipoCaptura) lbxTipoCaptura.getSelectedItem().getValue();
//		}
//		else
//		{
//			tipoCaptura = null;
//		}
//		
//	}

	
//public void buscarRegistroCamaraCajon(){
//	
//		txtTicket.setReadonly(false);
//		txtLoteCajonSap.setReadonly(false);
//	
//		String ca;
//		ca =  txtCajon.getValue().trim();			 
//
//		limpiarControlesSinCajon();
//		lbxCajonesDisponibles.getItems().clear();
//
//		//valido que exista informacion para la busqueda
//		if (txtCajon.getValue()==null || txtCajon.getValue().equals("")) {
//			Sistema.mensaje("Debe ingresar un numero de cajon");
//			return;
//		}
//		
//		if (barcoDescarga==null) {
//			Sistema.mensaje("Debe seleccionar un Barco");
//			return;
//		}
//		
//		cajonconsultado = new Cajon();
//		cajonconsultado = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCajonPorId(txtCajon.getValue().trim());
//		if (cajonconsultado==null) {
//			Sistema.mensaje("El caj�n ingresado no es un cajon valido");
//			return;
//		}
//		
//		int res = 0;
//		res = BuscarListaCajones();
//		 
//		 //if (camaraCajon==null)
//		 //La Lista de Cajones esta vacia (No encontro ning�n caj�n)
//		 if(res == 0)
//		 {
//			Sistema.mensaje("Asigne los demas valores para registrar el cajon");
//
//			limpiarControlesSinCajon();			
//			camaraCajon = new CamaraCajon();
//			
//			
//			camaraCajon.setFechareg(new Timestamp(new Date().getTime()));
//			txtTara.setValue(cajonconsultado.getTara()+"");
//			
//			txtCajon.setValue(ca);
//			
//			//nuevo caj�n
//			try {
//				lbxCajonesDisponibles.setSelectedIndex(1);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//			}
//		}
//
//	}


//	public int BuscarListaCajones(){
//		txtTicket.setReadonly(false);
//		txtLoteCajonSap.setReadonly(false);
//		
//		camaraCajones = new ArrayList<CamaraCajon>();
//		//camaraCajones = new CajonDAOJpaImpl().getListadoCajones(txtCajon.getValue().trim());	 
//
//		camaraCajones = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl(). getCamaraCajonRepetidosPorBarcoDescarga(barcoDescarga, cajonconsultado.getIdcajon());		
//		 
//		if (camaraCajones.size() == 0) {
//			txtCajon.setValue(null);
//			txtCajon.setFocus(true);
//			//Sistema.mensaje("No existen cajones");
//			return 0;
//		}
//		
//		//System.out.println("TAMA====>"+String.valueOf(camaraCajones.size()));
//		if (camaraCajones.size()>1) 
//		{
//			String mensaje = "Caj�n :" +" "+camaraCajones.get(0).getCajon().getIdcajon()
//					+" "+"repetido"+" "+camaraCajones.size()+" "+"veces.";
//			
//			Sistema.mensaje(mensaje + "");
//		}
//		
//		lbxCajonesDisponibles.getItems().clear();
//		
//		//Item en blanco
//		Listitem li = new Listitem();
//		li.setValue(new CamaraCajon());
//		li.setParent(lbxCajonesDisponibles);
//
//		
//		//Item Crear Nuevo caj�n
//		li = new Listitem();
//		li.setValue(new CamaraCajon());
//		new Listcell("CREAR NUEVO CAJ�N").setParent(li);
//		li.setParent(lbxCajonesDisponibles);
//
//		
//		for (CamaraCajon camaraCajon : camaraCajones) {
//			li = new Listitem();
//			li.setValue(camaraCajon);
//			String e = "Caj�n "+camaraCajon.getCajon().getIdcajon()+" "+String.valueOf("Lote SAP "+camaraCajon.getLotecajonsap().toString())+" "+String.valueOf("P. Bruto "+camaraCajon.getPesobruto())+" "+String.valueOf("P. Neto "+camaraCajon.getPesoneto()+"  Estado "+camaraCajon.getEstado().toString());
//			new Listcell(e).setParent(li);
//			li.setParent(lbxCajonesDisponibles);
//			
//			
//		}
//		lbxCajonesDisponibles.setSelectedIndex(0);
//		
//		return 1;
//		
//	}

	

//		private static boolean isNumeric(String cadena){
//		  try {
//		         Integer.parseInt(cadena);
//		         return true;
//			  } catch (NumberFormatException nfe){
//			         return false;
//			  }
//		}
          

	
//	public void guardarEditar(){
//		
//		if (barcoDescarga==null) {
//			Sistema.mensaje("No se ha escogido un registro de barco ");
//			lbxBarcoDescarga.setFocus(true);
//			return;
//		}
//		
//
////		if (lbxCajonesDisponibles.getItems().size() > 0)
////		{
////			if (lbxCajonesDisponibles.getSelectedIndex() == 0)
////			{
////				Sistema.mensaje("Selecione caj�n a modificar o caj�n a crear de la lista de cajones disponibles ");
////				lbxCajonesDisponibles.setFocus(true);
////				return;
////			}
////		}		
//		
//		
//		if (txtCajon.getValue()==null || txtCajon.getValue().equals("")) {
//			Sistema.mensaje("No se ha ingresado un n�mero de caj�n..");
//			txtCajon.setFocus(true);
//			return;
//		}		 
//		
////		if (lbxCuba.getSelectedIndex()==0) {
////			Sistema.mensaje("No se ha escogido una cuba ");
////			lbxCuba.setFocus(true);
////			return;
////		}
//		 
//		
////		if (lbxTurno.getSelectedIndex()==0) {
////			Sistema.mensaje("No se ha escogido un turno.. ");
////			return;
////		}
//		
////		if (barcoEstibaCuba==null) {
////			Sistema.mensaje("No se ha escogido una cuba ");
////			return;
////		}
////		
//		
////		if (dbbxPesoBruto.getValue()==null) {
////			Sistema.mensaje("No se ha establecido un Peso Bruto..");
////			dbbxPesoBruto.setFocus(true);
////			return;
////		}
//		
//		Cajon cajon = new Cajon();
//		cajon = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCajonPorId(txtCajon.getValue().trim());
//		if (cajon==null) {
//			Sistema.mensaje("El caj�n ingresado no es un cajon valido");
//			return;
//		}
//
//		
////		if (txtTicket.getValue().isEmpty())
////		{
////			Sistema.mensaje("Debe ingresar el Ticket");
////			txtTicket.setFocus(true);
////			return;
////		}
//		
////		//VALIDAMOS QUE NO INGRESEN LETRAS EN EL TOKET Y LOTESAP
////		boolean res = Sistema.isNumeric(txtTicket.getValue().trim());
//
////		if (res == false)
////		{
////			Sistema.mensaje("El Ticket no puede tener letras ni espacios, ingrese solo n�meros");
////			txtTicket.setFocus(true);
////			return;
////		}		
//		
//
////		if (txtLoteCajonSap.getValue().isEmpty())
////		{
////			Sistema.mensaje("Debe ingresar el LoteSap");
////			txtLoteCajonSap.setFocus(true);
////			return;
////		}		
////		
////		res = Sistema.isNumeric(txtLoteCajonSap.getValue().trim());
////		
////		if (res == false)
////		{
////			Sistema.mensaje("El LoteSap no puede tener letras ni espacios, ingrese solo n�meros");
////			txtLoteCajonSap.setFocus(true);
////			return;
////		}
//		
//
//		
//				
//		
////		Integer idespecietalla = 0;
////		if (txtEspecieTalla.getValue()==null || txtEspecieTalla.getValue().equals("")) {
////			Sistema.mensaje("Debe ingresar un valor de especie talla para buscar");
////			txtEspecieTalla.setFocus(true);
////			return;
////		}
////		idespecietalla = Sistema.parseInt(txtEspecieTalla.getValue());
//		
//		EspecieTalla especieTalla = new EspecieTalla();
//		especieTalla = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getEspecieTallaPorId(idespecietalla);
//		if (especieTalla==null) {
//			Sistema.mensaje("No se ha encontrado la Especie-Talla consultada ");
//			return;
//		}
//		
//		if (lbxTipoCaptura.getSelectedIndex() == 0)
//		{
//			Sistema.mensaje("Seleccione tipo de captura");
//			lbxTipoCaptura.setFocus(true);
//			return;
//		}
//
//		
//		if (txtZonaFao.getValue().isEmpty())
//		{
//			Sistema.mensaje("Ingrese Zona Fao");
//			txtZonaFao.setFocus(true);
//			return;
//		}		
//		
//		if (lbxCamaras.getSelectedIndex() == 0)
//		{
//			Sistema.mensaje("Seleccione camara");
//			lbxCamaras.setFocus(true);
//			return;
//		}
//
//		
//		if (lbxColumnas.getSelectedIndex() == 0)
//		{
//			Sistema.mensaje("Seleccione columna");
//			lbxColumnas.setFocus(true);
//			return;
//		}
//
//
//		if (lbxFilas.getSelectedIndex() == 0)
//		{
//			Sistema.mensaje("Seleccione fila");
//			lbxFilas.setFocus(true);
//			return;
//		}		
//		
//		
//		lbInfoEspecieTallaActual.setValue(especieTalla.getEspecie().getNombre()+
//				" "+especieTalla.getTalla().getNombre());
//		
//		if (especieTalla!=null) {//si se busco una nueva especie la asigno a camara cajon 
//			camaraCajon.setEspecieTalla(especieTalla);
//		}
//		
//		
//
//			   
//		
//		
//		
//		if (turno!=null) {// si se escogio un turno del combo lo asigno a camara cajon
//			camaraCajon.setTurno(turno);
//		}
//		if (tipoCaptura!=null) { // si se escogio un tipo captura del combo lo asigno a camara cajon
//			camaraCajon.setTipoCaptura(tipoCaptura);
//		}
//		
//		if (barcoEstibaCuba!=null) { // si se escogio una cuba del combo lo asigno a camara_cajon
//			camaraCajon.setBarcoEstibaCuba(barcoEstibaCuba);
//		}
//		
//		if (barcoDescarga!=null) {
//			camaraCajon.setBarcoDescarga(barcoDescarga);
//		}
//    
//		if (cajon!=null) {
//			camaraCajon.setCajon(cajon);
//		} 
//		
//		Camara camaraconbillete = new Camara();
//		if (camara==null) {
//			camaraconbillete.setIdcamara((long) 99);
//			camaraCajon.setCamara(camaraconbillete);	
//			camara=camaraconbillete;
//		}
//		
//		// validar en el caso de guardar si el cajon q se digito es valido
//		// es decir si el cajon no consta en la tabla camara_cajon se debe buscar 
//		// en la tabla cajon 
//				
//		CamaraFilaColumna camaraFila = new CamaraFilaColumna();
//		if (camaraFilaColumna== null) {
//			camaraFila.setIdcamarafilacolumna((long) 4635);
//			camaraCajon.setCamaraFilaColumna(camaraFila);
//		}
//		
//		 String columna ="";
//			if (this.columna != null) {
//				  columna = this.columna.getColumna().trim();
//			}
//			
//			int filanum =0;
//			if (this.fila!= null) {
//				filanum = this.fila.getFila();
//			}
//			
//		//consultamos en base a fila y columna el id de camara_fila_columna
//		camaraFilaColumna = camaraFilaColumnaDAOJpaImpl.getIdFilaColumna2(camara.getIdcamara(),filanum,columna);
//		if (camara!=null) {
//    		camaraCajon.setCamara(camara);
//    		 //System.out.println("encontro camara");
//	    }
//				
//		if (camaraFilaColumna !=null) {
//	    	 camaraCajon.setCamaraFilaColumna(camaraFilaColumna);
//	    	  //System.out.println("encontro camarafilacolumna");
//	    	  //System.out.println("idFilaColumnaObtenido-->"+camaraFilaColumna.getIdcamarafilacolumna());
//	    	   
//	         }		 
//		
//		
//		//Es un nuevo caj�n (select 0) o crea sea un nuevo caj�n forzado (select 1)
//		if(lbxCajonesDisponibles.getSelectedIndex() <= 1 )
//		{
//			camaraCajon.setEstado(0);	
//		}	
//		
//		//NUEVO CAJ�N
//		if(lbxCajonesDisponibles.getSelectedIndex() == 1)
//		{
//			camaraCajon.setFechareg(new java.sql.Timestamp(new Date().getTime()));
//		}
//		
//		camaraCajon.setPesobruto(dbbxPesoBruto.getValue());
//		camaraCajon.setPesoneto(Sistema.parseDouble( txtPesoNeto.getValue().trim() ));
//		camaraCajon.setTara(Sistema.parseDouble(txtTara.getValue() ));
//		camaraCajon.setTicket(txtTicket.getValue());
//		camaraCajon.setLotecajonsap(txtLoteCajonSap.getValue());
//		camaraCajon.setZonafao(txtZonaFao.getValue().trim());
//	
//		
//		
//		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
//		//System.out.println("valor de variable usuario-->"+usuario);
//		
//		Usuario usu = new Usuario();
//		String usuariograbar = (String) Sessions.getCurrent().getAttribute("usuario");
//		usu.setIdusuario(usuariograbar);
//		if (usuariograbar == null || usuariograbar.equals("")) {
//			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
//			 return;
//		}
//		
//		if (camaraCajon.getIdcamaracajon()==null) {
//			camaraCajon.setUsuario(usu);
//		}
//		
////		
//		
//		int ban = 0;
//		CamaraCajon camaraCajonNuevo = new CamaraCajon();
//		if(ChkNuevoCajon.isChecked())
//		{
//			if(txtPesoNetod.getText().isEmpty())
//			{
//				dbbxPesoBrutod.setFocus(true);
//				Sistema.mensaje("Debe ingresar el peso bruto para el nuevo caj�n");				
//				return;
//			}
//			
//			camaraCajonNuevo.setCodigoalmacen(camaraCajon.getCodigoalmacen());
//			camaraCajonNuevo.setColumnapasillo(camaraCajon.getColumnapasillo());
//			//camaraCajonNuevo.setEstado(camaraCajon.getEstado());
//			camaraCajonNuevo.setEstado(1);
//			camaraCajonNuevo.setFechaactualizacion(camaraCajon.getFechaactualizacion());
//			camaraCajonNuevo.setFechaactualizacionmovimiento(camaraCajon.getFechaactualizacionmovimiento());
//			camaraCajonNuevo.setFechareg(camaraCajon.getFechareg());
//			camaraCajonNuevo.setFechaultimomovimiento(camaraCajon.getFechaultimomovimiento());
//			camaraCajonNuevo.setIdbarcoestibacuba2(camaraCajon.getIdbarcoestibacuba2());
//			camaraCajonNuevo.setIdmaterialanterior(camaraCajon.getIdmaterialanterior());
//			camaraCajonNuevo.setLadopasillo(camaraCajon.getLadopasillo());
//			camaraCajonNuevo.setLotecajonsap(camaraCajon.getLotecajonsap());
//			camaraCajonNuevo.setLotecajonsapantesdenacionalizar(camaraCajon.getLotecajonsapantesdenacionalizar());
//			camaraCajonNuevo.setObservacion(camaraCajon.getObservacion());			
//			camaraCajonNuevo.setPesolibreutilizacion(camaraCajon.getPesolibreutilizacion());
//						
//			camaraCajonNuevo.setPesobruto(dbbxPesoBrutod.getValue());
//			camaraCajonNuevo.setPesoneto(Sistema.parseDouble( txtPesoNetod.getValue().trim() ));
//						
//			camaraCajonNuevo.setProcesado(camaraCajon.getProcesado());
//			camaraCajonNuevo.setTara(camaraCajon.getTara());
//			camaraCajonNuevo.setTicket(camaraCajon.getTicket());
//			camaraCajonNuevo.setTipotratamiento(camaraCajon.getTipotratamiento());
//			camaraCajonNuevo.setUsuarioactualizacion(camaraCajon.getUsuarioactualizacion());
//			camaraCajonNuevo.setUsuarioactualizacionmovimiento(camaraCajon.getUsuarioactualizacionmovimiento());
//			camaraCajonNuevo.setUsuarioultimomovimiento(camaraCajon.getUsuarioultimomovimiento());
//			camaraCajonNuevo.setZonafao(camaraCajon.getZonafao());
//			camaraCajonNuevo.setBarcoDescarga(camaraCajon.getBarcoDescarga());
//			camaraCajonNuevo.setBarcoEstibaCuba(camaraCajon.getBarcoEstibaCuba());
//			camaraCajonNuevo.setCajon(camaraCajon.getCajon());
//			camaraCajonNuevo.setCamaraArea(camaraCajon.getCamaraArea());
//			camaraCajonNuevo.setCamaraCajonRegistroSap(camaraCajon.getCamaraCajonRegistroSap());
//
//			
//			camaraCajonNuevo.setCamara(camaraCajon.getCamara());
//			camaraCajonNuevo.setCamaraFilaColumna(camaraCajon.getCamaraFilaColumna());
//			
//			camaraCajonNuevo.setEspecieTalla(camaraCajon.getEspecieTalla());
//			camaraCajonNuevo.setTipoCaptura(camaraCajon.getTipoCaptura());
//			camaraCajonNuevo.setTurno(camaraCajon.getTurno());
//			camaraCajonNuevo.setUsuario(camaraCajon.getUsuario());
//			
//			ban = 1;
//		}	
//		
//		new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().saveOrUpdate(camaraCajon);
//		
//		//Verifica si graba el nuevo caj�n
//		if(ban == 1)
//		{
//			new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().saveOrUpdate(camaraCajonNuevo);
//		}	
//		
//		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);	
//		limpiarControles();
//		cargarLimpiarControles();
//		
//	}
	
	
//	public void cargarListadoCubasBarcos(List<BarcoEstibaCuba> barcosEstibaCubas){
//		
//		lbxCuba.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new BarcoEstibaCuba());
//		li.setParent(lbxCuba);
//		
//		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
//				li = new Listitem();
//				li.setValue(bec);
//				 
//				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
//				//aki ir consultando 
//				new Listcell( new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
//				          .getCubaPorBarcoCuba(bec.getIdbarcocuba()).getCuba().getNombrecuba() +""  ).setParent(li);
//				//new Listcell(""+bec.getIdbarcocuba()).setParent(li); 
//				
//			   li.setParent(lbxCuba);		
//			}
//		lbxCuba.setSelectedIndex(0);
//		
//	}
	
	
//	public void posicionarCuba(){
//		
//		int pos = 0;
//		
//		if(camaraCajon.getBarcoEstibaCuba() != null)
//		{
//			for (BarcoEstibaCuba bec : barcosEstibaCubas) 
//			{
//				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
//				if (bec.getIdbarcoestibacuba().equals(camaraCajon.getBarcoEstibaCuba().getIdbarcoestibacuba()) ) 
//				{
//					lbxCuba.setSelectedIndex(pos+1);
//				}
//			    pos++;
//			}
//		}
//		else
//		{
//			lbxCuba.setSelectedIndex(0);
//		}
//			
//	}
	
	
//	public void seleccionarBarcoEstibaCuba(){
//	 
//		if (lbxCuba.getSelectedIndex()>0) {
//			 
//			 barcoEstibaCuba = new BarcoEstibaCuba();
//			 barcoEstibaCuba = (BarcoEstibaCuba) lbxCuba.getSelectedItem().getValue();
//			 //System.out.println("id barco estiba cuba->"+barcoEstibaCuba.getIdbarcocuba());
//			  
//		}else{
//			barcoEstibaCuba = null;
//		}
//		
//	}
	
	
//	public void buscarRegistroEspecieTalla(){
//		
//		
//		//buscar el valor q se ingresa en un metodo q me devuelva el objeto para 
//		// poderlo asginar al objeto camara_cajon
//		Integer idespecietalla = 0;
//		if (txtEspecieTalla.getValue()==null || txtEspecieTalla.getValue().equals("")) {
//			Sistema.mensaje("Debe ingresar un valor de especie talla para buscar");
//			return;
//		}
//		idespecietalla = Sistema.parseInt(txtEspecieTalla.getValue());
//		
//		especieTalla = new EspecieTalla();
//		especieTalla = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getEspecieTallaPorId(idespecietalla);
//		if (especieTalla==null) {
//			Sistema.mensaje("No se ha encontrado la Especie-Talla consultada ");
//			return;
//		}
//		lbInfoEspecieTallaActual.setValue(especieTalla.getEspecie().getNombre()+
//				" "+especieTalla.getTalla().getNombre());
//		
//	}
	
	
	public void limpiarControles(){
		
//		txtCajon.setValue("");
//		txtPesoNeto.setValue("");
//		txtEspecieTalla.setValue("");
//		txtLoteCajonSap.setValue("");
//		txtTara.setValue("");
//		txtTicket.setValue("");
//		txtZonaFao.setValue("");
//		dbbxPesoBruto.setValue(null);
		//listbox
//		lbxCuba.setSelectedIndex(0);
		//lbxTurno.setSelectedIndex(0);
//		lbxTipoCaptura.setSelectedIndex(0);

//		lbxCuba.getItems().clear();
//		lbxTurno.getItems().clear();
//		lbxTipoCaptura.getItems().clear();
		//label
//		lbInfoCajon.setValue("");
//		lbInfoEspecieTallaActual.setValue("");
//		lbInfoEspecieTallaAnterior.setValue("");
		
		camaraCajones = new ArrayList<CamaraCajon>();
//		lbxCajonesDisponibles.getItems().clear();
		
//		txtPesoNetod.setValue("");
//		dbbxPesoBrutod.setValue(null);
//		ChkNuevoCajon.setChecked(false);		
		
//		if (camara!=null) {
//			lbxCamaras.setSelectedIndex(0);
//		}
//		
//		if (columna!=null) {
//			lbxColumnas.setSelectedIndex(0);
//		}
//		
//		if (fila!=null) {
//			lbxFilas.setSelectedIndex(0);
//		}
	
		columnasCamara = new ArrayList<ColumnaCamara>();
		filasCamara = new ArrayList<FilaCamara>();
		
		
	}
	

//public void limpiarControlesSinCajon(){
//		txtPesoNeto.setValue("");
//		txtEspecieTalla.setValue("");
//		txtLoteCajonSap.setValue("");
//		txtTara.setValue("");
//		txtTicket.setValue("");
//		dbbxPesoBruto.setValue(null);
//		
//		
//		txtPesoNetod.setValue("");
//		dbbxPesoBrutod.setValue(null);
//		ChkNuevoCajon.setChecked(false);
//		//listbox
//		
//		if(lbxCuba.getItems().size() > 0)
//		{
//			lbxCuba.setSelectedIndex(0);	
//		}
//		
//		//lbxTurno.setSelectedIndex(0);
//
//		if(lbxTipoCaptura.getItems().size() > 0)
//		{
//			lbxTipoCaptura.setSelectedIndex(0);	
//		}
//
//			
//		
//		
//        txtZonaFao.setValue("");
//		//label
//		lbInfoCajon.setValue("");
//		lbInfoEspecieTallaActual.setValue("");
//		lbInfoEspecieTallaAnterior.setValue("");
//		
//		if (lbxColumnas.getSelectedIndex()>0) 
//		{
//			lbxColumnas.setSelectedIndex(0);
//		}
//		
//		if (lbxCamaras.getSelectedIndex()>0) 
//		{
//			lbxCamaras.setSelectedIndex(0);
//		}
//		
//		if (lbxFilas.getSelectedIndex()>0) 
//		{
//			lbxFilas.setSelectedIndex(0);
//		}
//		
//		columnasCamara = new ArrayList<ColumnaCamara>();
//		filasCamara = new ArrayList<FilaCamara>();
//		
//	}


	//este metodo se pensaba utilizar en primer instancia
	public void cargarInformacionCamaraCajon(BarcoDescarga barcoDescarga){
		
		camaraCajones = new ArrayList<CamaraCajon>();
		camaraCajones = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
		 		.getCamaraCajonPorBarcoDescarga(barcoDescarga);
		 //System.out.println("tamano de lista camara cajon->"+camaraCajones.size());
		
		 //cargar el listado de cajones
		 
	}
	
	public void cargarTurnos(){
		turnos = new ArrayList<Turno>();
		turnos = new TurnoDAOJpaImpl().getTurnos();
		turno = new Turno();
		turno = turnos.get(0); // asigno el primer turno
		
		//llenar el listbox de turnos
		
//		lbxTurno.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new Turno());
//		li.setParent(lbxTurno);
//		
//		for (Turno bec : turnos) {
//				li = new Listitem();
//				li.setValue(bec);
//				new Listcell(bec.getIdturno()+" "+bec.getNombre()).setParent(li); 
//				
//			   li.setParent(lbxTurno);		
//			}
//		lbxTurno.setSelectedIndex(0);
		
	}
	
	
//	public void cargarTiposCapturas(){
//		
//		List<TipoCaptura> tipoCapturas = new ArrayList<TipoCaptura>();
//		tipoCapturas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getTiposCapturas();
//		this.tipoCapturas = new ArrayList<TipoCaptura>();
//		
//		for (TipoCaptura tc : tipoCapturas) {
//			if ( !(tc.getIdtipocaptura().trim().equals("ZZ")) ) {
//				this.tipoCapturas.add(tc);
//			}
//		}
//		
//		//llenar el listbox de lbxTipoCaptura
//		
//		lbxTipoCaptura.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new TipoCaptura());
//		li.setParent(lbxTipoCaptura);
//		
//		for (TipoCaptura bec : this.tipoCapturas) {
//				li = new Listitem();
//				li.setValue(bec);
//				new Listcell(bec.getIdtipocaptura()+" "+bec.getDescripcion()).setParent(li); 
//				
//			   li.setParent(lbxTipoCaptura);		
//			}
//	 
//		
//	}
	
	
//	public void cargarListaCamaras(){
//		lbxCamaras.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new Camara());
//		li.setParent(lbxCamaras);
//		
//		//List<Camara> camaras = new CamaraDAOJpaImpl().getCamara();
//		for (Camara camara : camaras) {
//			 li = new Listitem();
//			 li.setValue(camara);
//			 new Listcell("Camara->"+camara.getDescripcion()).setParent(li);
//			 li.setParent(lbxCamaras);
//		}
//		lbxCamaras.setSelectedIndex(0);
//		
//	}

	
//	public void onSelect$lbxCamaras(){
//		
//		lbxFilas.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new FilaCamara());
//		li.setParent(lbxFilas);		
//	    filasCamara = null;
//	    
//		if (lbxCamaras.getSelectedIndex()>0) {
//			camara = new Camara();
//			camara = (Camara) lbxCamaras.getSelectedItem().getValue();
//			//System.out.println("valor descripcion de la camara escogida es-->"+camara.getDescripcion());
//			//debo de cargar las filas y columnas correspondientes a la camara
//			//cargarListaFilasCamara();
//			cargarListaColumnasCamara();
//		}else{
//			camara = null; //se vacia el objeto para q pueda validar de nuevo q debe escoger una camara
//		}
//	}

	
//	public void cargarListaColumnasCamara(){
//		lbxColumnas.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new ColumnaCamara());
//		li.setParent(lbxColumnas);
//
//		columnasCamara = camaraFilaColumnaDAOJpaImpl.obtenerColumnas2(Integer.valueOf(String.valueOf(camara.getIdcamara()).trim()) );
////				
////				camaraFilaColumnaDAOJpaImpl.getCamaraColumnas
////				(Integer.valueOf( String.valueOf(camara.getIdcamara()) ));
//		for (ColumnaCamara columna : columnasCamara) 
//		{
//			 li = new Listitem();
//			 li.setValue(columna);
//			 new Listcell("Columna->"+columna.getColumna().trim()).setParent(li);
//			 li.setParent(lbxColumnas);
//		}
//		lbxColumnas.setSelectedIndex(0);
//		
//	}
	
	
//	public void cargarListaFilasCamara(){
//		lbxFilas.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new FilaCamara());
//		li.setParent(lbxFilas);
//		
//	    filasCamara = camaraFilaColumnaDAOJpaImpl.obtenerFilasConIdColumna(Integer.valueOf(String.valueOf(camara.getIdcamara()).trim()), columna.getColumna().trim()  );
//				 
//		for (FilaCamara fila : filasCamara) {
//			 li = new Listitem();
//			 li.setValue(fila);
//			 new Listcell("Fila->"+fila.getFila()).setParent(li);
//			 li.setParent(lbxFilas);
//		}
//		lbxFilas.setSelectedIndex(0);
//		
//	}
	
//	public void onSelect$lbxColumnas(){
//		if (lbxColumnas.getSelectedIndex()>0) {
//			//columna = new CamaraFilaColumna();
//			columna = new ColumnaCamara();
//			columna = new ColumnaCamara();
//			columna = (ColumnaCamara) lbxColumnas.getSelectedItem().getValue();
//			//System.out.println("valor descripcion de la columna escogida es-->"+columna.getColumna());
//			cargarListaFilasCamara();//llenamos las filas correspondientes a la columna 
//		}else{
//			columna = null;// se vacia el objeto para q pueda validar de nuevo q debe escoger una columna
//		}
//	}
	
	
//	public void onSelect$lbxFilas(){
//		if (lbxFilas.getSelectedIndex()>0) {
//			fila = new FilaCamara();
//			fila = (FilaCamara) lbxFilas.getSelectedItem().getValue();
//			//System.out.println("valor descripcion de la fila escogida es-->"+fila.getFila());
//		}else{
//			fila = null;// se vacia el objeto para q pueda validar de nuevo q debe escoger una fila
//		}
//	}
	
	
	
	
	
	
//	public void posicionarTurno(){
//		int pos = 0;
//		for (Turno turno : turnos) {
//			if (turno.getIdturno()==camaraCajon.getTurno().getIdturno() ) {
//				System.out.println("encontro el registro de turno");
//				lbxTurno.setSelectedIndex(pos+1);
//			}
//		    pos++;
//		}
//	 }
	
//	public void posicionarTipoCaptura(){
//		
//		int pos = 0;
//		
//		for (TipoCaptura tc : tipoCapturas) {
//			if (tc.getIdtipocaptura().trim().equals(camaraCajon.getTipoCaptura().getIdtipocaptura().trim()) ) {
//				//System.out.println("encontro el registro de tipo Captura");
//				lbxTipoCaptura.setSelectedIndex(pos+1);
//			}
//		    pos++;
//		}
//	}
	
//	public void recalcularPesoNeto(Double pesoBruto){
//		
//		Double pesoNeto = 0.00;
//		Double tara = 0.00;
//		tara =  Sistema.parseDouble(txtTara.getValue());
//		
//		pesoNeto  = pesoBruto - tara;
//		txtPesoNeto.setValue(pesoNeto+"");
//		
//	}
	

	
//	public void recalcularPesoNetod(Double pesoBrutod){
//		
//			
//			////////////////////////////////////////////
//			//Recaculamos el peso principal del caj�n //
//			////////////////////////////////////////////			
//			//Bruto
//			//dbbxPesoBruto.setValue(camaraCajon.getPesobruto() - pesoBrutod);
//				
//			////////////////////////////////////////////
//			
//			
//			///////////////////////////////////////////
//			//Calculamos el peso neto del nuevo caj�n//
//			///////////////////////////////////////////
//			Double pesoNetod = 0.00;
//			Double tara = 0.00;
//			tara =  Sistema.parseDouble(txtTara.getValue());
//			
//			pesoNetod  = pesoBrutod - tara;
//			
//			if (pesoNetod < 0)
//			{
//				txtPesoNetod.setText("");
//				
//				dbbxPesoBruto.setValue(camaraCajon.getPesobruto());
//				txtPesoNeto.setValue(camaraCajon.getPesoneto()+"");		
//				txtTara.setValue(camaraCajon.getTara()+"");
//			}
//			else
//			{
//				txtPesoNetod.setValue(pesoNetod+"");
//
//				dbbxPesoBruto.setValue( (camaraCajon.getPesoneto() - pesoNetod) + camaraCajon.getTara());
//				
//				//Neto
//				String valor = "";
//				valor = String.valueOf(dbbxPesoBruto.getValue());
//				peso = 0.00;
//				peso = Sistema.parseDouble(valor);
//				recalcularPesoNeto(peso);					
//			}
//			
//			
//			
//			//////////////////////////////////////////
//		
//	}
	
	
	public Date getAumentarUnDiaAFecha(Date fecha){
		Date fecha_aumentada = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.add(Calendar.DAY_OF_YEAR, 1); // Aumentamos un dia a la fecha
		fecha_aumentada= cal.getTime();
		//System.out.println("fecha aumentada->"+fecha_aumentada);
		return fecha_aumentada;
	}
	
	
	public void cargarLimpiarControles(){
//		
//		if (lbxCajones.getSelectedIndex()>0 ) {
//			lbxCajones.setSelectedIndex(0);
//		}
		//lbxBarcoDescarga.setSelectedIndex(0);
		
	//	barcoDescarga = null;
		camaraCajon = null;
		camaraFilaColumna = null;
		camara = null;
		
		//limpiar las listas de camara , columnas y filas 
		
//		if (lbxColumnas.getSelectedIndex()>0 ) {
//			lbxColumnas.setSelectedIndex(0);
//		}
		
//		if (lbxCamaras.getSelectedIndex()>0 ) {
//			lbxCamaras.setSelectedIndex(0);
//		}
		
//		if (lbxFilas.getSelectedIndex()>0 ) {
//			lbxFilas.setSelectedIndex(0);
//		}
		
		columnasCamara = new ArrayList<ColumnaCamara>();
		filasCamara = new ArrayList<FilaCamara>();
		
		
	}

	

//	public void posicionarColumna(){
//		
//		
//		//||camaraCajon.getCamaraFilaColumna().getIdcolumna()==null
//		if ((camaraCajon.getCamaraFilaColumna()==null)) 
//		{		
//			return;
//		}
//				
//		int pos = 0;
//		for (ColumnaCamara c : columnasCamara) 
//		{
//			//System.out.println("BUSCANDO "+c.getColumna().trim()+" == "+ camaraCajon.getCamaraFilaColumna().getIdcolumna().trim());
//			//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
//			if (c.getColumna().trim().equals(camaraCajon.getCamaraFilaColumna().getIdcolumna().trim())) 
//			{
//				//camaraFilaColumna.geti
//				//System.out.println("encontro el registro de columna");
//				lbxColumnas.setSelectedIndex(pos+1);
//			}
//		   pos++;
//		}
//	}
		


//	public void posicionarFila()
//	{
//
//		//if ((camaraCajon.getCamaraFilaColumna()==null) ||camaraCajon.getCamaraFilaColumna().getIdfila()==0) {
//		if ((camaraCajon.getCamaraFilaColumna()==null) ||camaraCajon.getCamaraFilaColumna().getIdfila()==null) {
//			return;
//		}
//		int pos = 0;
//		
//				
//		if (lbxColumnas.getSelectedIndex() > 0)
//		{
//			for (FilaCamara f : filasCamara) 
//			{
//				
////				System.out.println("Fila de lista :"+f.getFila());
////				System.out.println("Fila de objeto :"+String.valueOf((camaraCajon.getCamaraFilaColumna().getIdfila())));
//				
//				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
//				if (  String.valueOf(f.getFila()).equals(   String.valueOf((camaraCajon.getCamaraFilaColumna().getIdfila())))     ) 
//				{
//					//System.out.println("encontro el registro de fila");
//					lbxFilas.setSelectedIndex(pos+1);
//				}
//			   pos++;
//			}
//		}
//
//		
//	}



//	public void posicionarCamara(){
//		
//		if ((camaraCajon.getCamara()==null) || camaraCajon.getCamara().getIdcamara()==null) {
//			lbxCamaras.setSelectedIndex(0);
//			return;
//		}
//		
//			int pos = 0;
//			for (Camara c : camaras) {
//				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
//				if (c.getIdcamara().equals(camaraCajon.getCamara().getIdcamara()) ) {
//					//System.out.println("encontro el registro de camara");
//					lbxCamaras.setSelectedIndex(pos+1);
//				}
//			   pos++;
//			}
//		}

	
}
