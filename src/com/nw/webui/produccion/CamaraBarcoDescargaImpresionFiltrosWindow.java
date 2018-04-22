package com.nw.webui.produccion;

import java.io.FileNotFoundException;
import java.util.*;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.*;

import com.nw.model.Barco;
import com.nw.model.BarcoDescarga;
import com.nw.model.CalidadBpmDesembarco;
import com.nw.model.CalidadRespuestaPreguntaBpmdesembarco;
import com.nw.model.dao.impl.BarcoDescargaDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
//import com.nw.produccion.dao.*;
import com.nw.util.*;
import com.nw.webui.DescargarArchivoExcel;
import com.nw.webui.produccion.impresion.CalidadImpresion;


public class CamaraBarcoDescargaImpresionFiltrosWindow extends GenericForwardComposer{	

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(CamaraBarcoDescargaImpresionFiltrosWindow.class);

	public AreaMarco area;
	protected Window winCamaraBarcoDescargaImpresion; // autowired
	protected Vbox vbxMain;
	
	private Listbox lbxBarco, lbxRegistro;
	private Textbox txtNumFormato;
	private Textbox txtRegistro;
	private Textbox txtNumBarco;
	private Textbox txtTipo;
	private BarcoDescarga barcodescarga;
	
	private Textbox txtBarcoMercante;
	private Row RwBarcoMercante;	
	
	private Datebox dteFecha1, dteFecha2;
	
/*	protected Toolbarbutton btnGrabar;*/
	private String vtipo;
	protected List<CalidadRespuestaPreguntaBpmdesembarco> lrespuestasgrupo1;
	
	CalidadBpmDesembarco cs;
	private CalidadRespuestaPreguntaBpmdesembarco crpbd;
	
	public CamaraBarcoDescargaImpresionFiltrosWindow() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}
	
	public void onCreate$winCamaraBarcoDescargaImpresion(Event event) throws Exception {

		area = (AreaMarco)Sessions.getCurrent().getAttribute("areaMarco");
		winCamaraBarcoDescargaImpresion.setWidth(area.ancho);
		vbxMain.setWidth(area.anchoInterno);
		vtipo = txtTipo.getValue();
		//cargarBarcosDescarga();

		dteFecha1.setValue(new Date());
		dteFecha1.setFormat(Sistema.FORMATO_FECHA_DMY);			

		dteFecha2.setValue(new Date());
		dteFecha2.setFormat(Sistema.FORMATO_FECHA_DMY);			
		
		lbxBarco.addEventListener("onSelect", new org.zkoss.zk.ui.event.EventListener(){
			public void onEvent(Event event){
				txtBarcoMercante.setText("");			
				txtBarcoMercante.setValue("");
				RwBarcoMercante.setVisible(false);
				lbxRegistro.getItems().clear();
				
				if (lbxBarco.getSelectedIndex() > 0)
				{
					cargarRegistrosBarcosDescarga();
				}

			}
		});
		
		
		lbxRegistro.addEventListener("onSelect", new org.zkoss.zk.ui.event.EventListener(){
			public void onEvent(Event event){
				txtBarcoMercante.setText("");			
				txtBarcoMercante.setValue("");
				RwBarcoMercante.setVisible(false);
				
//				txtNumFormato.setText("");
//				txtRegistro.setText("");
//				txtNumBarco.setText("");
				
				if (lbxRegistro.getSelectedIndex() > 0)
				{
					
					barcodescarga  = (BarcoDescarga) lbxRegistro.getSelectedItem().getValue();
					
					/////////////////////////////mostrarBarcoDescarga();
					//Verificamos si es un subabarco (propiedad = 5)
					//if (((BarcoDescarga)lbxRegistro.getSelectedItem().getValue()).getBarco().getIdpropiedad() == 5)
					if (((BarcoDescarga)lbxRegistro.getSelectedItem().getValue()).getMercante() != null)
					{
						RwBarcoMercante.setVisible(true);
						txtBarcoMercante.setValue(((BarcoDescarga)lbxRegistro.getSelectedItem().getValue()).getMercante().getDescripcionmercante());
					}	
					
					try {
						Long id;
						id = barcodescarga.getCalidadPccs().get(0).getIdcalidadpcc();
						System.out.println("idcalidadpcc -> " + id);
					} catch (Exception e) {
						System.out.println("no se puede acceder al idcalidadpcc " +
								"desde el barco descarga escogido -> " + barcodescarga.getIdbarcodescarga() );
					}

				}
			}
		});		

		
		dteFecha1.addEventListener("onChange", new org.zkoss.zk.ui.event.EventListener(){
			public void onEvent(Event event){
				lbxBarco.getItems().clear();
				lbxRegistro.getItems().clear();
			}
		});

		dteFecha2.addEventListener("onChange", new org.zkoss.zk.ui.event.EventListener(){
			public void onEvent(Event event){
				lbxBarco.getItems().clear();
				lbxRegistro.getItems().clear();
			}
		});
		
		
	}


	/**
	 * Carga los barcos de descarga mediante JPA en el listbox respectivo
	 */	
	private void cargarBarcosDescarga(){
		lbxBarco.getItems().clear();
		lbxRegistro.getItems().clear();
		
		//Cambiamos a la fecha de fecha como esta configurada la base de datos
		dteFecha1.setFormat(Sistema.FORMATO_FECHA_GUI);
		dteFecha2.setFormat(Sistema.FORMATO_FECHA_GUI);
		
		//'09-08-2013 00:00:00.000'
		String f1;
		f1 = dteFecha1.getAreaText().trim() + " 00:00:00.000";
		
		//'20-08-2013 23:59:59.000'
		String f2;
		f2 = dteFecha2.getAreaText().trim() + " 23:59:59.999";
		
		List <Barco> barco = new BarcoDescargaDAOJpaImpl().getBarcosDescargadosByEntreFechas(f1, f2);

		//Regresamos de la fecha como esta configurada la base de datos 
		dteFecha1.setFormat(Sistema.FORMATO_FECHA_DMY);
		dteFecha2.setFormat(Sistema.FORMATO_FECHA_DMY);
		
		if(barco.size() == 0)
		{
			//txtNumBarco.setValue(null);
			//txtRegistro.setValue(null);
			//txtNumBarco.focus();
			Sistema.mensaje("No existen datos");
		}
		else
		{
			Listitem li = new Listitem();
			li.setValue(new Barco());
			li.setParent(lbxBarco);			
			
			for (Barco o: barco){
				li = new Listitem();
				li.setValue(o);
				
				if(o.getMercante() == null)
				{
					new Listcell( o.getNombre()).setParent(li);
				
				}
				else
				{				
					new Listcell( o.getNombre()+" ("+o.getMercante().getDescripcionmercante().trim()+")" ).setParent(li);
				}
				li.setParent(lbxBarco);		
			}
			
			lbxBarco.setSelectedIndex(0);
		}
		
	}	
	
	
	private void cargarRegistrosBarcosDescarga(){
		lbxRegistro.getItems().clear();
		
		//Cambiamos a la fecha de fecha como esta configurada la base de datos
		dteFecha1.setFormat(Sistema.FORMATO_FECHA_GUI);
		dteFecha2.setFormat(Sistema.FORMATO_FECHA_GUI);
		
		//'09-08-2013 00:00:00.000'
		String f1;
		f1 = dteFecha1.getAreaText().trim() + " 00:00:00.000";
		
		//'20-08-2013 23:59:59.000'
		String f2;
		f2 = dteFecha2.getAreaText().trim() + " 23:59:59.999";
		
		List <BarcoDescarga> barcodescarga = new BarcoDescargaDAOJpaImpl().getBarcosDescargadosByBarcoEntreFechas(((Barco) lbxBarco.getSelectedItem().getValue()).getIdbarco(), f1, f2);

		//Regresamos de la fecha como esta configurada la base de datos 
		dteFecha1.setFormat(Sistema.FORMATO_FECHA_DMY);
		dteFecha2.setFormat(Sistema.FORMATO_FECHA_DMY);
		
		if(barcodescarga.size() == 0)
		{
			//txtNumBarco.setValue(null);
			//txtRegistro.setValue(null);
			//txtNumBarco.focus();
			Sistema.mensaje("No existen datos");
		}
		else
		{
			Listitem li = new Listitem();
			li.setValue(new BarcoDescarga());
			li.setParent(lbxRegistro);			
			
			for (BarcoDescarga o: barcodescarga){
				li = new Listitem();
				li.setValue(o);
				
				new Listcell(o.getRegistro()+" Viaje("+o.getViaje()+")").setParent(li);
				li.setParent(lbxRegistro);		
			}
			
			lbxRegistro.setSelectedIndex(0);
		}
		
	}	
	
	
//	private void mostrarBarcoDescarga() {
//		if ( lbxBarco.getItems().size()>0 ){
//			//BarcoDescarga o = (BarcoDescarga) lbxBarco.getSelectedItem().getValue(); 
//			barcodescarga  = (BarcoDescarga) lbxBarco.getSelectedItem().getValue();
//			//cs = (CalidadBpmDesembarco)barcodescarga.getCalidadBpmDesembarcos().get(0);
//			//txtNumFormato.setValue("RG-CC-01-" + cs.getIdbpmdesembarco());
//			txtNumBarco.setValue("" + barcodescarga.getBarco().getNumbarco());
//			txtRegistro.setValue(barcodescarga.getRegistro());
//		}
//	}

	
	
	private void grabar(){
		try {

			barcodescarga.setEstado(0);
			new BarcoDescargaDAOJpaImpl().saveOrUpdate(barcodescarga);

			Sistema.mensaje("Registro grabado exitosamente");		    
			
		} catch (Exception e) {
			String message = e.getMessage();
			String message1 = e.getCause().getMessage();
			Sistema.mensaje(message+' '+message1);
			return;	
		}
	}	


	public void onClick$btnBuscar(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {	
		cargarBarcosDescarga();
	}	
	
	
	//Impresiones	
	public void onClick$btnCalidadBPMDesembarco(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {
		if (lbxBarco.getItemCount() == 0 || lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}
		
		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}	
		
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadBpmDesembarcos().get(0).getIdbpmdesembarco();
		
		//Ejecutamos el reporte
		new CalidadImpresion().doImprimirCalidadBPMDesembarco("CalidadBPMDesembarco.jasper","logo_real.gif", id);
	}

	public void onClick$btnCalidadPCC1(Event event) throws SuspendNotAllowedException, JRException, InterruptedException  {
		if (lbxBarco.getItemCount() == 0 || lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}
		
		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadPccs().get(0).getIdcalidadpcc();
		
		//Ejecutamos el reporte
		new CalidadImpresion().doImprimirbtnCalidadPCC1("CalidadPCC1.jasper", "logo_real.gif", id, vtipo);
	}

	public void onClick$btnCalidadPCC1V2(Event event) throws SuspendNotAllowedException, JRException, InterruptedException, FileNotFoundException  {
		if (lbxBarco.getItemCount() == 0 || lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}
		
		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadPccs().get(0).getIdcalidadpcc();
		//Ejecutamos el reporte
		//new CalidadImpresion().doImprimirbtnCalidadPCC1("CalidadPCC1V2018.jasper", "logo_real.gif", id, vtipo);
		doImprimir3("CalidadPCC1V2018.jasper" , id , "CalidadPCC1V2018" );
		System.out.println("idcalidadpcc -> " + id);
	}

	
	public void onClick$btnCalidadPCC1Excel(Event event) throws Exception  {
		if (lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}

		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}
		
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadPccs().get(0).getIdcalidadpcc();
		
		//Ejecutamos el reporte
		//new CalidadImpresion().doImprimirbtnCalidadPCC1("CalidadPCC1.jasper", "logo_nirsa.gif", id, vtipo);
		//Sistema.mensaje("id calidad pcc ->" + id);
		//new DescargarArchivoExcel().getCalidadPcc1(id);
		doImprimir2("CalidadBarcoDescargado.jasper",id,"Calidad_barco_descarga");
	}	
	
	public void onClick$btnCalidadPCC1ExcelAccionCorrectiva(Event event) throws Exception  {
		if (lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}

		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}
		
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadPccs().get(0).getIdcalidadpcc();
		
		//Ejecutamos el reporte
		//new CalidadImpresion().doImprimirbtnCalidadPCC1("CalidadPCC1.jasper", "logo_nirsa.gif", id, vtipo);
		//Sistema.mensaje("id calidad pcc ->" + id);
		//new DescargarArchivoExcel().getCalidadPcc1(id);
		doImprimir2("CalidadBarcoDescargadoAccionCorrectivaMain.jasper",id,"Calidad_Accion_correctiva_PCC1A");
	}	
	
	public void onClick$btnCalidadPCC1ExcelMuestras(Event event) throws Exception  {
		if (lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}

		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}
		
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadPccs().get(0).getIdcalidadpcc();
		
		//Ejecutamos el reporte
		//new CalidadImpresion().doImprimirbtnCalidadPCC1("CalidadPCC1.jasper", "logo_nirsa.gif", id, vtipo);
		//Sistema.mensaje("id calidad pcc ->" + id);
		//new DescargarArchivoExcel().getCalidadPcc1(id); CalidadBarcoDescargadoMainSINAC
		doImprimir2("CalidadBarcoDescargadoMuestraMain.jasper",id, "Calidad_materia_prima_muestra ");
	}	
	
	@SuppressWarnings({ "unused"})
	public void doImprimir2(String nombre_report, long id, String nombre_descarga_report) throws JRException, SuspendNotAllowedException, InterruptedException, FileNotFoundException 
	{
		String logo = "logo_real.gif";
		
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

		//Map parameters = new HashMap();
		Map<String,Object> parameters = new HashMap<String,Object>();	
		parameters.put("LOGO",ruta_logo);
		parameters.put("idcalidad",id);
		parameters.put("fechadesde",dteFecha1.getValue());
		parameters.put("fechahasta",dteFecha2.getValue());
		//parameters.put("USUARIO",usuario);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);

		//Ejecutamos el reporte 
		//EjecutarReporte(parameters, ruta_report);
		 //String logo = "logo_nirsa.gif";
		new ReporteExcel().generarExcelJasper(nombre_descarga_report, nombre_report, logo, parameters);//CalidadBarcoDescargado
	}	
	
	
    /*IMPRESION PDF */
	public void doImprimir3(String nombre_report, long id, String nombre_descarga_report) throws JRException, SuspendNotAllowedException, InterruptedException, FileNotFoundException 
	{
		String logo = "logo_real.gif";
		
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");

		//Map parameters = new HashMap();
		Map<String,Object> parameters = new HashMap<String,Object>();	
		parameters.put("LOGO",ruta_logo);
		parameters.put("idcalidadpcc",id);
		parameters.put("fechadesde",dteFecha1.getValue());
		parameters.put("fechahasta",dteFecha2.getValue());
		//parameters.put("USUARIO",usuario);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);

		//Ejecutamos el reporte 
		 EjecutarReporte(parameters, ruta_report);
		 //String logo = "logo_nirsa.gif";
		//new ReporteExcel().generarExcelJasper(nombre_descarga_report, nombre_report, logo, parameters);//CalidadBarcoDescargado
	}
	
	//Funcion Generica para visulizar los reportes
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void EjecutarReporte(Map parameters, String ruta_report) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		
		//new UsuarioDAOJpaImpl().getUser(id);
		
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
	
	public void onClick$btnCalidadSensorialMP2(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {		
		if (lbxBarco.getItemCount() == 0 || lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}
		
		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}		
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadSensorialMps().get(0).getIdcalidadsensorialmp();
		
		String nombre_reporte;
		//Verificamos si es un subabarco (propiedad = 5)
		if (((BarcoDescarga)lbxRegistro.getSelectedItem().getValue()).getBarco().getBarcoPropiedad().getIdpropiedad() == 5)
		{
			nombre_reporte="CalidadSensorialMPMercante.jasper";
		}
		else
		{
			nombre_reporte="CalidadSensorialMP.jasper";
		}
		
		//Ejecutamos el reporte
		new CalidadImpresion().doImprimirbtnCalidadSensorialMP(nombre_reporte, "logo_nirsa.gif",  id, vtipo);		
	}
	
	public void onClick$btnCalidadSensorialMP3(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {		
		if (lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}
		
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadSensorialMps().get(0).getIdcalidadsensorialmp();
		Sistema.mensaje("ID getIdcalidadsensorialmp " + id);
		String nombre_reporte;
		//Verificamos si es un subabarco (propiedad = 5)
		if (((BarcoDescarga)lbxRegistro.getSelectedItem().getValue()).getBarco().getBarcoPropiedad().getIdpropiedad() == 5)
		{
			nombre_reporte="CalidadSensorialMPMercante.jasper";
		}
		else
		{
			nombre_reporte="CalidadSensorialMP2.jasper";
		}
		
		//Ejecutamos el reporte
		new CalidadImpresion().doImprimirbtnCalidadSensorialMP2(nombre_reporte, "logo_real.gif",  id, vtipo);		
	}

	
	
	public void onClick$btnCalidadPCC1Histamina(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {	
		if (lbxBarco.getItemCount() == 0 || lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}
		
		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}
		
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadPccs().get(0).getIdcalidadpcc();
		
		//Ejecutamos el reporte
		new CalidadImpresion().doImprimirCalidadPCC1Histamina("CalidadPCC1Histamina.jasper", "logo_nirsa.gif", id);		
	}


	public void onClick$btnCalidadInformesSalinidadPesca(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {	
		if (lbxBarco.getItemCount() == 0 || lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}
		
		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadPccs().get(0).getIdcalidadpcc();
		
		//Ejecutamos el reporte
		new CalidadImpresion().doImprimirCalidadInformesSalinidadPesca("CalidadInformesSalinidadPesca.jasper", "logo_nirsa.gif", id);		
	}	
	
	public void onClick$btnCalidadBPMClasificacion(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {
		if (lbxBarco.getItemCount() == 0 || lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccion Barco");
			lbxBarco.focus();
			return;
		}
		
		if (lbxRegistro.getItemCount() == 0 || lbxRegistro.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Selecciones Registro de Barco");
			lbxRegistro.focus();
			return;
		}	
		
		//Tomamos los parametros
		Long id;
		id = barcodescarga.getCalidadBpmDesembarcos().get(0).getIdbpmdesembarco();
		
		//Ejecutamos el reporte
		new CalidadImpresion().doImprimirCalidadBPMClasificacion("CalidadBPMClasificacion.jasper","logo_nirsa.gif", id);
	}
	
}