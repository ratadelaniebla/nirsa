package com.nw.webui.produccion;

import net.sf.jasperreports.engine.JRException;

import org.zkoss.util.media.AMedia;
import org.zkoss.zul.Checkbox;

import java.io.File;
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
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.Cajon;
import com.nw.model.CalidadMuestraAreaCabecera;
import com.nw.model.CalidadMuestraAreaCabeceraAprobacion;
import com.nw.model.Camara;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraFilaColumna;
import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.EspecieTalla;
import com.nw.model.Parametro;
import com.nw.model.TipoCaptura;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.UsuariosAprobacion;
import com.nw.model.dao.impl.CalidadMuestraAreaDetalleDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonUbicacionDAOJpaImpl;
import com.nw.model.dao.impl.CamaraDAOJpaImpl;
import com.nw.model.dao.impl.CamaraFilaColumnaDAOJpaImpl;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioAprobacionDAOJpaImpl;
import com.nw.temp.model.ColumnaCamara;
import com.nw.temp.model.FilaCamara;
import com.nw.util.AreaMarco;
import com.nw.util.LlamarSAP;
import com.nw.util.Sistema;


public class CalidadMuestraAreaReportesAprobacionWindow extends GenericForwardComposer {
	public AreaMarco area;
	protected Vbox vbxMain;	

	private static final long serialVersionUID = 1L;
	//Objetos zul
	Listbox lbxBarcoDescarga,lbxCajones, lbxLoteHccp; // lbxTurno
	Toolbarbutton btnSAP,btnPCC1B,btnPROTOCOLO;
	Datebox dteFecInicio,dteFecFin;
	private Iframe iframe;
	private Checkbox chkAprobado,chkRevisado,chkRechazado, chkVerificado;
	private Label lblAprobado,lblRevisado,lblRechazado , lblVerificado;
	//Textbox txtCajon;
	java.sql.Connection connection; 
    Integer mirareporte=0,ban1=0,ban2=0,ban3=0;
	//Objetos
	UsuariosAprobacion usuarioAprobacion;
	CalidadMuestraAreaCabeceraAprobacion aprobacion;
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
	Integer ban=0;
	Integer idarea;
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
		Usuario usu = new Usuario();
		String usuario = (String) Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		
		usuarioAprobacion=new UsuarioAprobacionDAOJpaImpl().getUserAprobacion(usuario);
		Boolean respuesta=false, respuesta1=false , respuestaverificado = false;
		
		respuesta=usuarioAprobacion.getAccesoaprobacion();
		respuesta1=usuarioAprobacion.getAccesorevision();
		System.out.println("respuesta1 aprobado: "+respuesta);
		System.out.println("respuesta2 revisado: "+respuesta1);
		
		idarea=usuarioAprobacion.getIdarea();
		if(respuesta==null)
			respuesta=false;
		if(respuesta1==null)
			respuesta1=false;
			
		
		if(respuesta==false)
		{
			chkAprobado.setVisible(false);
			lblAprobado.setVisible(false);
			chkRechazado.setVisible(false);
			lblRechazado.setVisible(false);
			
		}
		if(respuesta1==false)
		{
			chkRevisado.setVisible(false);
			lblRevisado.setVisible(false);
		}
		
		if (usuarioAprobacion != null) {
			if (usuarioAprobacion.getAccesoverificado()!=null) {
				if (usuarioAprobacion.getAccesoverificado()) {
					respuestaverificado = true;
				}else{
					respuestaverificado = false;
				}
			}
		}
		
		if (respuestaverificado == false) {
			chkVerificado.setVisible(false);
			lblVerificado.setVisible(false);
		}
		
		if(idarea==1)
		{
			btnSAP.setVisible(true);
			btnPROTOCOLO.setVisible(true);
			btnPCC1B.setVisible(false);
		}
		if(idarea==2)
		{
			btnSAP.setVisible(false);
			btnPROTOCOLO.setVisible(false);
			btnPCC1B.setVisible(true);
			
			
		}
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
		System.out.println("BarcoDescarga: "+barcoDescarga.getIdbarcodescarga());
		List <CalidadMuestraAreaCabecera> lcalidadMuestraAreaCabecera =null;
			
		if(idarea==1)
		{
			lcalidadMuestraAreaCabecera = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea1(barcoDescarga.getIdbarcodescarga());

		}
		if(idarea==2)
		{
			lcalidadMuestraAreaCabecera = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea2(barcoDescarga.getIdbarcodescarga());

		}
		if(lcalidadMuestraAreaCabecera==null)
			{
				Sistema.mensaje("No hay información registrada para este registro");
				return;
			}
		Listitem li = new Listitem();
		li.setValue(new CalidadMuestraAreaCabecera());
		li.setParent(lbxLoteHccp);			
		
		for (CalidadMuestraAreaCabecera o: lcalidadMuestraAreaCabecera)
		{
			

			//////VALIDA QUE HAYA SIDO REVISADO EN CASO DE PROTOCOLO SE DEBE CONSIDERAR QUE LA HISTAMINA Y LA SAL HAYAN SIDO REVISADOS CASO CONTRARIO
			//////SEGUIRÁN MOSTRANDOSE EN ESTA PANTALLA
		
			System.out.println(o.getRevisadohistamina());
			Boolean respuesta = false,respuestasal=false,respuestahistamina=false;
			try {
				
				respuestahistamina=o.getAprobadohistamina();
				respuestasal=o.getAprobadosal();
				if(respuestahistamina==null)
					respuestahistamina=false;
				if(respuestasal==null)
					respuestasal=false;
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				if(o.getAprobadohistamina()==null)
					respuestahistamina=false;
				if(o.getAprobadosal()==null)
					respuestasal=false;
			}
			System.out.println("R2: "+respuestahistamina);
			
			if(o.getCalidadMuestraArea().getIdcalidadmuestraarea().toString().equals("3"))
			{
				if(respuestahistamina==true && respuestasal==true)
					respuesta=true;
				else
					respuesta=false;
			}
			else
			{
				
				if(respuestahistamina==true )
					respuesta=true;
				else
					respuesta=false;
				
			}
			
			//////////////FIN VALIDACIÓN PARA VISUALIZAR/OCULTAR MUESTRAS TOMADAS EN OTRAS ÁREAS.
			
			
		
			if(respuesta==false)
			{
			li = new Listitem();
			li.setValue(o);
			new Listcell( o.getLotehaccp()).setParent(li);
			li.setParent(lbxLoteHccp);
			}
			
		}
		
		lbxLoteHccp.setSelectedIndex(0);
	}
	

	
public void onSelect$lbxLoteHccp() throws InterruptedException{
		 
		if (lbxLoteHccp.getSelectedIndex()>0) 
		{
			//vaciamos el objeto barcoDescarga creando una nueva instancia 
			calidadMuestraAreaCabecera = new CalidadMuestraAreaCabecera();
			calidadMuestraAreaCabecera = (CalidadMuestraAreaCabecera) lbxLoteHccp.getSelectedItem().getValue();
			mirareporte=0;
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

			System.out.println("Tamaño :"+lcalidadMuestraAreaCabecera);
			
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
			// e.printStackTrace();
		}
		
		
		System.out.println(resultado);

	}
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public void onClick$btnSAP() throws Exception
	{
		if (lbxBarcoDescarga.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione registro de descarga");
			lbxBarcoDescarga.setFocus(true);
			return;
		}
		mirareporte=1;
		ban1=1;
		ban2=0;
		ban3=0;
		if (lbxLoteHccp.getSelectedIndex() > 0)
		{
			String nombrejasper = "CalidadMuestrasRecepcionMateriaPrima.jasper";
	        String logo = "logo_nirsa.gif";

	                      String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
	                      //String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

	                     
	                       logo = "logo_real.gif";
	              		
	              		//Obtenemos la ruta del reporte .jrxml
	              		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+"CalidadMuestrasRecepcionMateriaPrima.jasper";
	              		 ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
	              		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
	              		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
	              		String ruta_visto = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+"visto.png";
	              		Long area=(long) 2;
	              		Map parameters = new HashMap();
	            		//parameters.put("visto",ruta_visto);
	            		parameters.put("LOTEHACCP",calidadMuestraAreaCabecera.getLotehaccp());
	            		parameters.put("LOGO",ruta_logo);
	            	//	parameters.put("idbarcodescarga",barcoDescarga.getIdbarcodescarga().intValue());
	            		//parameters.put("USUARIO",usuario);
	            		parameters.put("SUBREPORT_DIR", ruta_sub_report);
	            	//	parameters.put("USUARIO",usuario);
	            		//Ejecutamos el reporte y enviamos los 2 parametros, parameters y ruta_report
	            		//Obtenemos el reporte ejecutado en PDF en esta variable
	            		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl().ReportesDAOJpaImpl(parameters, ruta_report);
	            		iframe.setContent(reporteejecutado);
		}	
		else
		{
			String nombrejasper = "CalidadMuestrasRecepcionMateriaPrimaRegistro.jasper";
	        String logo = "logo_nirsa.gif";

	                      String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
	                      //String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

	                     
	                       logo = "logo_real.gif";
	              		
	              		//Obtenemos la ruta del reporte .jrxml
	              		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+"CalidadMuestrasRecepcionMateriaPrimaRegistro.jasper";
	              		 ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
	              		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
	              		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
	              		String ruta_visto = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+"visto.png";
	              		Long area=(long) 2;
	              		Map parameters = new HashMap();
	              		parameters.put("idbarcodescarga",barcoDescarga.getIdbarcodescarga());
	            		parameters.put("LOGO",ruta_logo);
	            	//	parameters.put("idbarcodescarga",barcoDescarga.getIdbarcodescarga().intValue());
	            		//parameters.put("USUARIO",usuario);
	            		parameters.put("SUBREPORT_DIR", ruta_sub_report);
	            	//	parameters.put("USUARIO",usuario);
	            		//Ejecutamos el reporte y enviamos los 2 parametros, parameters y ruta_report
	            		//Obtenemos el reporte ejecutado en PDF en esta variable
	            		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl().ReportesDAOJpaImpl(parameters, ruta_report);
	            		iframe.setContent(reporteejecutado);
		}
		
	}
	
	

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void doImprimir() throws JRException, SuspendNotAllowedException, InterruptedException 
	{

		String nombre_report = "CalidadMuestrasRecepcionMateriaPrima.jasper";
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


	
	public static void borrarDirectorio (File directorio){
		
		File[] ficheros = directorio.listFiles();
		 
		 for (int x=0;x<ficheros.length;x++){

				if (ficheros[x].isDirectory()) {
				  borrarDirectorio(ficheros[x]);
				}
				ficheros[x].delete();
			}
		
		
		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void onClick$btnPCC1B() throws Exception
	{
		
		
		if (lbxBarcoDescarga.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione registro de descarga");
			lbxBarcoDescarga.setFocus(true);
			return;
		}
		mirareporte=1;
		if (lbxLoteHccp.getSelectedIndex() > 0)
		{
			ban3=1;
			ban1=0;
			ban2=0;
			String nombrejasper = "CalidadMuestrasPCC1B.jasper";
	        String logo = "logo_nirsa.gif";

	                      String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
	                      //String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

	                     
	                       logo = "logo_real.gif";
	              		
	              		//Obtenemos la ruta del reporte .jrxml
	              		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+"CalidadMuestrasPCC1B.jasper";
	              		 ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
	              		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
	              		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
	              		String ruta_visto = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+"visto.png";
	              		Long area=(long) 2;
	              		Map parameters = new HashMap();
	            		parameters.put("visto",ruta_visto);
	            		parameters.put("idcabecera",calidadMuestraAreaCabecera.getIdcalidadmuestraareacabecera());
	            		parameters.put("LOGO",ruta_logo);
	            	//	parameters.put("idbarcodescarga",barcoDescarga.getIdbarcodescarga().intValue());
	            		//parameters.put("USUARIO",usuario);
	            	//	parameters.put("SUBREPORT_DIR", ruta_sub_report);
	            	//	parameters.put("USUARIO",usuario);
	            		//Ejecutamos el reporte y enviamos los 2 parametros, parameters y ruta_report
	            		//Obtenemos el reporte ejecutado en PDF en esta variable
	            		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl().ReportesDAOJpaImpl(parameters, ruta_report);
	            		iframe.setContent(reporteejecutado);
		}	
		else
		{
			String nombrejasper = "CalidadMuestrasPCC1BRegistro.jasper";
	        String logo = "logo_nirsa.gif";

	                      String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
	                      //String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

	                     
	                       logo = "logo_real.gif";
	              		
	              		//Obtenemos la ruta del reporte .jrxml
	              		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+"CalidadMuestrasPCC1BRegistro.jasper";
	              		 ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
	              		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
	              		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
	              		String ruta_visto = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+"visto.png";
	              		Long area=(long) 2;
	              		Map parameters = new HashMap();
	            		parameters.put("visto",ruta_visto);
	            		parameters.put("idarea",area);
	            		parameters.put("LOGO",ruta_logo);
	            		parameters.put("idbarcodescarga",barcoDescarga.getIdbarcodescarga().intValue());
	            		//parameters.put("USUARIO",usuario);
	            		parameters.put("SUBREPORT_DIR", ruta_sub_report);
	            	//	parameters.put("USUARIO",usuario);
	            		//Ejecutamos el reporte y enviamos los 2 parametros, parameters y ruta_report
	            		//Obtenemos el reporte ejecutado en PDF en esta variable
	            		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl().ReportesDAOJpaImpl(parameters, ruta_report);
	            		iframe.setContent(reporteejecutado);
		}
		
                        
                      
                       
                   
	}


	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public void onClick$btnPROTOCOLO() throws Exception
	{
		if (lbxBarcoDescarga.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione registro de descarga");
			lbxBarcoDescarga.setFocus(true);
			return;
		}
		ban2=1;
		ban1=0;
		ban3=0;
		mirareporte=1;
		if (lbxLoteHccp.getSelectedIndex() > 0)
		{
				
		String nombrejasper = "CalidadMuestrasEvaluacionProtocolos.jasper";
        String logo = "logo_nirsa.gif";

                      String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
                      //String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

                     
                       logo = "logo_real.gif";
              		
              		//Obtenemos la ruta del reporte .jrxml
              		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+"CalidadMuestrasEvaluacionProtocolos.jasper";
              		 ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
              		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
              		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
              		String ruta_visto = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+"visto.png";
              		Long area=(long) 3;
              		Map parameters = new HashMap();
            		//parameters.put("visto",ruta_visto);
              		//parameters.put("visto",ruta_visto);
            		parameters.put("idcabecera",calidadMuestraAreaCabecera.getIdcalidadmuestraareacabecera());
            		parameters.put("LOGO",ruta_logo);
            		parameters.put("SUBREPORT_DIR", ruta_sub_report);
            	//	parameters.put("USUARIO",usuario);
            		//Ejecutamos el reporte y enviamos los 2 parametros, parameters y ruta_report
            		//Obtenemos el reporte ejecutado en PDF en esta variable
            		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl().ReportesDAOJpaImpl(parameters, ruta_report);
            		iframe.setContent(reporteejecutado);
		}
		else
		{
			
		String nombrejasper = "CalidadMuestrasEvaluacionProtocolosRegistro.jasper";
        String logo = "logo_nirsa.gif";

                      String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
                      //String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

                     
                       logo = "logo_real.gif";
              		
              		//Obtenemos la ruta del reporte .jrxml
              		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+"CalidadMuestrasEvaluacionProtocolosRegistro.jasper";
              		 ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
              		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
              		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
              		String ruta_visto = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+"visto.png";
              		Long area=(long) 3;
              		Map parameters = new HashMap();
            		//parameters.put("visto",ruta_visto);
            		parameters.put("idarea",area);
            		parameters.put("LOGO",ruta_logo);
            		parameters.put("idbarcodescarga",barcoDescarga.getIdbarcodescarga().intValue());
            		//parameters.put("USUARIO",usuario);
            		parameters.put("SUBREPORT_DIR", ruta_sub_report);
            	//	parameters.put("USUARIO",usuario);
            		//Ejecutamos el reporte y enviamos los 2 parametros, parameters y ruta_report
            		//Obtenemos el reporte ejecutado en PDF en esta variable
            		AMedia reporteejecutado = new com.nw.model.dao.impl.ReportesDAOJpaImpl().ReportesDAOJpaImpl(parameters, ruta_report);
            		iframe.setContent(reporteejecutado);
			
			
		}
	}
	
	public void onCheck$chkRevisado() throws Exception
	{
		if(chkRevisado.isChecked() && mirareporte==1){
		if(calidadMuestraAreaCabecera==null)
		{
			List<CalidadMuestraAreaCabecera> listacmac=new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescarga(barcoDescarga.getIdbarcodescarga());
			if(ban1==1)
			{
				//listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea11(barcoDescarga.getIdbarcodescarga());
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea11SinAp(barcoDescarga.getIdbarcodescarga());
			}
			if(ban2==1)
			{
				//listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea1(barcoDescarga.getIdbarcodescarga());
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea1SinAp(barcoDescarga.getIdbarcodescarga());
			}
			if(ban3==1)
			{
				//listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea2(barcoDescarga.getIdbarcodescarga());
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea2SinAp(barcoDescarga.getIdbarcodescarga());
			}
			
			if (listacmac.isEmpty()) {
				Sistema.mensaje("El reporte debe ser Aprobado ");
				return;
			}
			
			for (CalidadMuestraAreaCabecera bd : listacmac) {
				
				//cambio, si ya existe en CalidadMuestraAreaCabeceraAprobacion solo actualizar el estado de verificacion 
				List<CalidadMuestraAreaCabeceraAprobacion> lista = 
							new CalidadMuestraAreaDetalleDAOJpaImpl().
									getCalidadMuestraAreaCabeceraAprobacionByIdCmac(bd.getIdcalidadmuestraareacabecera());
				
				if (! lista.isEmpty()) {
					System.out.println("existen ->" + lista.size() +" registros a revisar");
					for (CalidadMuestraAreaCabeceraAprobacion aprobacion : lista) {
						bd.setRevisadohistamina(true);
						bd.setRevisadosal(true);
						 
						//aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
						aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
						/* solo se estaria verificando */
						//if (usuarioAprobacion.getAccesoverificado()!=null) {
							//aprobacion.setAccesoverificado(usuarioAprobacion.getAccesoverificado());
						//} 
						aprobacion.setCalidadMuestraAreaCabecera(bd);
						aprobacion.setIdarearevisionaprobacion(Integer.valueOf(bd.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
						aprobacion.setUsuariosAprobacion(usuarioAprobacion);
						aprobacion.setUsuario(usuarioAprobacion.getUsuario());
						aprobacion.setCalidadMuestraArea(bd.getCalidadMuestraArea());//calidadMuestraAreaCabecera.getCalidadMuestraArea()
						aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
						new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(bd);
						new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
					}
				}else{
					/* si no existe registro en cabecera de aprobacion*/
					bd.setRevisadohistamina(true);
					bd.setRevisadosal(true);
				
					aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
					//aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
					//aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
					if (usuarioAprobacion.getAccesoverificado()!=null) {
						aprobacion.setAccesoverificado(usuarioAprobacion.getAccesoverificado());
					} 
					aprobacion.setCalidadMuestraAreaCabecera(bd);
					aprobacion.setIdarearevisionaprobacion(Integer.valueOf(bd.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
					aprobacion.setUsuariosAprobacion(usuarioAprobacion);
					aprobacion.setUsuario(usuarioAprobacion.getUsuario());
					aprobacion.setCalidadMuestraArea(bd.getCalidadMuestraArea());//calidadMuestraAreaCabecera.getCalidadMuestraArea()
					aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
					new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(bd);
					new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
					 
				} 
		    }
			
			/* bd.setRevisadohistamina(true);
			bd.setRevisadosal(true);
		
			aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
			aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
			aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
			aprobacion.setCalidadMuestraAreaCabecera(bd);
			aprobacion.setIdarearevisionaprobacion(Integer.valueOf(bd.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
			aprobacion.setUsuariosAprobacion(usuarioAprobacion);
			aprobacion.setUsuario(usuarioAprobacion.getUsuario());
			aprobacion.setCalidadMuestraArea(bd.getCalidadMuestraArea());//calidadMuestraAreaCabecera.getCalidadMuestraArea()
			aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
			new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(bd);
			new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);*/
	
		}
		else{
			    calidadMuestraAreaCabecera.setRevisadohistamina(true);
				calidadMuestraAreaCabecera.setRevisadosal(true);
				
				//cambio, si ya existe en CalidadMuestraAreaCabeceraAprobacion solo actualizar el estado de verificacion 
				List<CalidadMuestraAreaCabeceraAprobacion> lista = 
							new CalidadMuestraAreaDetalleDAOJpaImpl().
									getCalidadMuestraAreaCabeceraAprobacionByIdCmac(calidadMuestraAreaCabecera.getIdcalidadmuestraareacabecera());
				
				for (CalidadMuestraAreaCabeceraAprobacion aprobacion : lista) {
					//aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
					aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
					//if (usuarioAprobacion.getAccesoverificado()!=null) {
						//aprobacion.setAccesoverificado(usuarioAprobacion.getAccesoverificado());
					//}
					aprobacion.setCalidadMuestraAreaCabecera(calidadMuestraAreaCabecera);
					aprobacion.setIdarearevisionaprobacion(Integer.valueOf(calidadMuestraAreaCabecera.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
					aprobacion.setUsuariosAprobacion(usuarioAprobacion);
					aprobacion.setUsuario(usuarioAprobacion.getUsuario());
					aprobacion.setCalidadMuestraArea(calidadMuestraAreaCabecera.getCalidadMuestraArea());
					aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
					
					new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
				}
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(calidadMuestraAreaCabecera);
				
				
				/* aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
				aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
				aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
				aprobacion.setCalidadMuestraAreaCabecera(calidadMuestraAreaCabecera);
				aprobacion.setIdarearevisionaprobacion(Integer.valueOf(calidadMuestraAreaCabecera.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
				aprobacion.setUsuariosAprobacion(usuarioAprobacion);
				aprobacion.setUsuario(usuarioAprobacion.getUsuario());
				aprobacion.setCalidadMuestraArea(calidadMuestraAreaCabecera.getCalidadMuestraArea());
				aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(calidadMuestraAreaCabecera);
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion); */
			}
			
			Sistema.mensaje("El reporte fue Revisado");
			limpiarControles();
		}
	}
	
	public void onCheck$chkVerificado() throws Exception
	{
		if(chkVerificado.isChecked() && mirareporte==1){
			if (usuarioAprobacion.getAccesoverificado()==null) {
				Sistema.mensaje("El usuario : "+usuarioAprobacion.getUsuario().getUsuario() +
						" " + "no tiene aisignado un valor en columna de acceso verificado tabla usuario_aprobacion");
				chkVerificado.setChecked(false);
				return;
			}
			
			if(calidadMuestraAreaCabecera==null)
			{
				List<CalidadMuestraAreaCabecera> listacmac=new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescarga(barcoDescarga.getIdbarcodescarga());
				if(ban1==1)
				{
					listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea11SinAp(barcoDescarga.getIdbarcodescarga());
	
				}
				if(ban2==1) 
				{
					listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea1SinAp(barcoDescarga.getIdbarcodescarga());
	
				}
				if(ban3==1)
				{
					listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea2SinAp(barcoDescarga.getIdbarcodescarga());
	
				}
				
				if (listacmac.isEmpty()) {
					Sistema.mensaje("El reporte debe ser Aprobado para poder ser Verificado");
					return;
				}
				
				for (CalidadMuestraAreaCabecera bd : listacmac) {
					
					//cambio, si ya existe en CalidadMuestraAreaCabeceraAprobacion solo actualizar el estado de verificacion 
					List<CalidadMuestraAreaCabeceraAprobacion> lista = 
								new CalidadMuestraAreaDetalleDAOJpaImpl().
										getCalidadMuestraAreaCabeceraAprobacionByIdCmac(bd.getIdcalidadmuestraareacabecera());
					
					
					if (! lista.isEmpty()) {
						System.out.println("existen ->" + lista.size() +" registros");
						for (CalidadMuestraAreaCabeceraAprobacion aprobacion : lista) {
							bd.setRevisadohistamina(true);
							bd.setRevisadosal(true);
							 
							//aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
							//aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
							/* solo se estaria verificando */
							if (usuarioAprobacion.getAccesoverificado()!=null) {
								aprobacion.setAccesoverificado(usuarioAprobacion.getAccesoverificado());
							} 
							aprobacion.setCalidadMuestraAreaCabecera(bd);
							aprobacion.setIdarearevisionaprobacion(Integer.valueOf(bd.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
							aprobacion.setUsuariosAprobacion(usuarioAprobacion);
							aprobacion.setUsuario(usuarioAprobacion.getUsuario());
							aprobacion.setCalidadMuestraArea(bd.getCalidadMuestraArea());//calidadMuestraAreaCabecera.getCalidadMuestraArea()
							aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
							new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(bd);
							new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
						}
					}else{
						/* si no existe registro en cabecera de aprobacion*/
						bd.setRevisadohistamina(true);
						bd.setRevisadosal(true);
					
						aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
						//aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
						//aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
						if (usuarioAprobacion.getAccesoverificado()!=null) {
							aprobacion.setAccesoverificado(usuarioAprobacion.getAccesoverificado());
						} 
						aprobacion.setCalidadMuestraAreaCabecera(bd);
						aprobacion.setIdarearevisionaprobacion(Integer.valueOf(bd.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
						aprobacion.setUsuariosAprobacion(usuarioAprobacion);
						aprobacion.setUsuario(usuarioAprobacion.getUsuario());
						aprobacion.setCalidadMuestraArea(bd.getCalidadMuestraArea());//calidadMuestraAreaCabecera.getCalidadMuestraArea()
						aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
						new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(bd);
						new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
						
					}
					
					
					/* bd.setRevisadohistamina(true);
					bd.setRevisadosal(true);
				
					aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
					aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
					aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
					if (usuarioAprobacion.getAccesoverificado()!=null) {
						aprobacion.setAccesoverificado(usuarioAprobacion.getAccesoverificado());
					} 
					aprobacion.setCalidadMuestraAreaCabecera(bd);
					aprobacion.setIdarearevisionaprobacion(Integer.valueOf(bd.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
					aprobacion.setUsuariosAprobacion(usuarioAprobacion);
					aprobacion.setUsuario(usuarioAprobacion.getUsuario());
					aprobacion.setCalidadMuestraArea(bd.getCalidadMuestraArea());//calidadMuestraAreaCabecera.getCalidadMuestraArea()
					aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
					new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(bd);
					new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion); */
					
			   }
		       System.out.println("verifico all ....");
			}
			else{
				calidadMuestraAreaCabecera.setRevisadohistamina(true);
				calidadMuestraAreaCabecera.setRevisadosal(true);
				
				//cambio, si ya existe en CalidadMuestraAreaCabeceraAprobacion solo actualizar el estado de verificacion 
				List<CalidadMuestraAreaCabeceraAprobacion> lista = 
							new CalidadMuestraAreaDetalleDAOJpaImpl().
									getCalidadMuestraAreaCabeceraAprobacionByIdCmac(calidadMuestraAreaCabecera.getIdcalidadmuestraareacabecera());
				
				for (CalidadMuestraAreaCabeceraAprobacion aprobacion : lista) {
					//aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
					//aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
					if (usuarioAprobacion.getAccesoverificado()!=null) {
						aprobacion.setAccesoverificado(usuarioAprobacion.getAccesoverificado());
					}
					aprobacion.setCalidadMuestraAreaCabecera(calidadMuestraAreaCabecera);
					aprobacion.setIdarearevisionaprobacion(Integer.valueOf(calidadMuestraAreaCabecera.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
					aprobacion.setUsuariosAprobacion(usuarioAprobacion);
					aprobacion.setUsuario(usuarioAprobacion.getUsuario());
					aprobacion.setCalidadMuestraArea(calidadMuestraAreaCabecera.getCalidadMuestraArea());
					aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
					
					new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
				}
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(calidadMuestraAreaCabecera);
				
				
				/* aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
				aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
				aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
				if (usuarioAprobacion.getAccesoverificado()!=null) {
					aprobacion.setAccesoverificado(usuarioAprobacion.getAccesoverificado());
				}
				aprobacion.setCalidadMuestraAreaCabecera(calidadMuestraAreaCabecera);
				aprobacion.setIdarearevisionaprobacion(Integer.valueOf(calidadMuestraAreaCabecera.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
				aprobacion.setUsuariosAprobacion(usuarioAprobacion);
				aprobacion.setUsuario(usuarioAprobacion.getUsuario());
				aprobacion.setCalidadMuestraArea(calidadMuestraAreaCabecera.getCalidadMuestraArea());
				aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(calidadMuestraAreaCabecera);
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion); */
				
				 System.out.println("verifico only ....");
			}
			
			Sistema.mensaje("El reporte fue Verificado");
			limpiarControles();
		}
	}
	
	
	
	public void onCheck$chkAprobado() throws Exception
	{
		if(chkAprobado.isChecked() && mirareporte==1)
		{
		
			if(calidadMuestraAreaCabecera==null)
			{
			List<CalidadMuestraAreaCabecera> listacmac=new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescarga(barcoDescarga.getIdbarcodescarga());
			if(ban1==1)
			{
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea11(barcoDescarga.getIdbarcodescarga());

			}
			if(ban2==1)
			{
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea1(barcoDescarga.getIdbarcodescarga());

			}
			if(ban3==1)
			{
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea2(barcoDescarga.getIdbarcodescarga());

			}
			for (CalidadMuestraAreaCabecera bd : listacmac) {
				
				bd.setRevisadohistamina(true);
				bd.setRevisadosal(true);
				bd.setAprobado(true);
				
				aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
				aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
				aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
				aprobacion.setAccesoverificado(false);
				aprobacion.setCalidadMuestraAreaCabecera(bd);
				aprobacion.setIdarearevisionaprobacion(Integer.valueOf(bd.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
				aprobacion.setUsuariosAprobacion(usuarioAprobacion);
				aprobacion.setUsuario(usuarioAprobacion.getUsuario());
				aprobacion.setCalidadMuestraArea(bd.getCalidadMuestraArea());
				aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(bd);
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
				
				
				
		}
	
			}
			else
			{
				calidadMuestraAreaCabecera.setRevisadohistamina(true);
				calidadMuestraAreaCabecera.setRevisadosal(true);
				
				aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
				aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
				aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
				aprobacion.setCalidadMuestraAreaCabecera(calidadMuestraAreaCabecera);
				aprobacion.setIdarearevisionaprobacion(Integer.valueOf(calidadMuestraAreaCabecera.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
				aprobacion.setUsuariosAprobacion(usuarioAprobacion);
				aprobacion.setUsuario(usuarioAprobacion.getUsuario());
				aprobacion.setCalidadMuestraArea(calidadMuestraAreaCabecera.getCalidadMuestraArea());
				aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(calidadMuestraAreaCabecera);
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
			
				
				
			}
		
	Sistema.mensaje("El reporte fue Aprobado");
	limpiarControles();
		}
	}
	
	
	public void onCheck$chkRechazado() throws Exception
	{
		if(chkRechazado.isChecked() && mirareporte==1)
		{
		if(calidadMuestraAreaCabecera==null)
		{
			List<CalidadMuestraAreaCabecera> listacmac=new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescarga(barcoDescarga.getIdbarcodescarga());
			if(ban1==1)
			{
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea11(barcoDescarga.getIdbarcodescarga());

			}
			if(ban2==1)
			{
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea1(barcoDescarga.getIdbarcodescarga());

			}
			if(ban3==1)
			{
				listacmac = new CalidadMuestraAreaDetalleDAOJpaImpl().getCalidadMuestraAreaCabeceraByBarcoDescargaArea2(barcoDescarga.getIdbarcodescarga());

			}
			for (CalidadMuestraAreaCabecera bd : listacmac) {
				
				bd.setRechazado(true);
				
				aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
				aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
				aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
				aprobacion.setCalidadMuestraAreaCabecera(bd);
				aprobacion.setIdarearevisionaprobacion(Integer.valueOf(bd.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
				aprobacion.setUsuariosAprobacion(usuarioAprobacion);
				aprobacion.setUsuario(usuarioAprobacion.getUsuario());
				aprobacion.setCalidadMuestraArea(calidadMuestraAreaCabecera.getCalidadMuestraArea());
				aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(bd);
				new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
				
				
				
		}
			
			
			
			
		}
		else{
		calidadMuestraAreaCabecera.setRechazado(true);
		
		aprobacion=new CalidadMuestraAreaCabeceraAprobacion();
		aprobacion.setAccesoaprobacion(usuarioAprobacion.getAccesoaprobacion());
		aprobacion.setAccesorevision(usuarioAprobacion.getAccesorevision());
		aprobacion.setCalidadMuestraAreaCabecera(calidadMuestraAreaCabecera);
		aprobacion.setIdarearevisionaprobacion(Integer.valueOf(calidadMuestraAreaCabecera.getCalidadMuestraArea().getIdcalidadmuestraarea().toString()));
		aprobacion.setUsuariosAprobacion(usuarioAprobacion);
		aprobacion.setUsuario(usuarioAprobacion.getUsuario());
		aprobacion.setCalidadMuestraArea(calidadMuestraAreaCabecera.getCalidadMuestraArea());
		aprobacion.setFecharegistro(new java.sql.Timestamp(new Date().getTime()));
		new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdate(calidadMuestraAreaCabecera);
		new CalidadMuestraAreaDetalleDAOJpaImpl().saveOrUpdateAprobacion(aprobacion);
		
		}
		
		
	Sistema.mensaje("El reporte fue Rechazado");
	limpiarControles();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
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
		//parameters.put("USUARIO",usuario);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);

		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	
	
	
	//Funcion Generica para visulizar los reportes
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	
	
	
	public void limpiarControles(){
	
		
		camaraCajones = new ArrayList<CamaraCajon>();

	
		columnasCamara = new ArrayList<ColumnaCamara>();
		filasCamara = new ArrayList<FilaCamara>();
		calidadMuestraAreaCabecera=null;
		if(lbxBarcoDescarga.getItemCount()>0)
		lbxBarcoDescarga.getItems().clear();
		if(lbxLoteHccp.getItemCount()>0)
			lbxLoteHccp.getItems().clear();
		
		chkRevisado.setChecked(false);
		chkAprobado.setChecked(false);
		chkVerificado.setChecked(false);
		iframe.setSrc(null);
		mirareporte=0;
		ban1=0;
		ban2=0;
		ban3=0;
	}
	


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
		
	
		
	}

	
	
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
		
	
		
		columnasCamara = new ArrayList<ColumnaCamara>();
		filasCamara = new ArrayList<FilaCamara>();
		
		
	}

	

}
