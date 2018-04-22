package com.nw.webui.produccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import net.sf.jasperreports.engine.JRException;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.nw.model.BarcoDescarga;
import com.nw.model.dao.impl.CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl;
import com.nw.util.Sistema;
 
 


public class CalidadMuestraAsignacionEspecieResultadoWindow extends GenericForwardComposer { //GenericForwardComposer

	private static final long serialVersionUID = 1L;
	
	AnnotateDataBinder binder;
	
	private Datebox 									dteFecha1, dteFecha2;
	private Listbox 									lbxBarcoDescarga;  
	private Textbox 									txtRegistro;
	private BarcoDescarga 								barcoDescarga;
	
	private List<BarcoDescarga> 						barcosDescargas 						= new ArrayList<>();
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable(comp.getId(), this, true);
		dteFecha1.setValue(new Date());
		dteFecha2.setValue(new Date());
		binder = new AnnotateDataBinder(comp);
		binder.loadAll();
	}	

	public void onClick$btnBuscar(){	
		limpiarControles();
		barcosDescargas = new ArrayList<BarcoDescarga>();
		barcosDescargas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
								.getBarcoDescargaPorFechaDescargaDate
									(dteFecha1.getValue(),   dteFecha2.getValue());
		//lleno el listbox de barco descarga
		cargarBarcosDescargaPorFecha(barcosDescargas);
	}	
	
	public void cargarBarcosDescargaPorFecha(List<BarcoDescarga> barcosDescargas){
		
		lbxBarcoDescarga.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new BarcoDescarga());
		li.setParent(lbxBarcoDescarga);
		
		for (BarcoDescarga bd : barcosDescargas) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell("("+ bd.getRegistro()+") " + "  " + bd.getBarco().getNombre()+" ").setParent(li); 
			li.setParent(lbxBarcoDescarga);		}
		lbxBarcoDescarga.setSelectedIndex(0);
	}
	
	
	public void onSelect$lbxBarcoDescarga() throws InterruptedException{
		if (lbxBarcoDescarga.getSelectedIndex()>0) {
			barcoDescarga = (BarcoDescarga) lbxBarcoDescarga.getSelectedItem().getValue();
			limpiarControles();
			txtRegistro .setValue(barcoDescarga.getRegistro());
			System.out.println("barcoDescarga id ->" + barcoDescarga.getIdbarcodescarga());
		}else{
			barcoDescarga = null;
			limpiarControles();
		}
	}
	
	public void onClick$btnPdf() throws InterruptedException, SuspendNotAllowedException, JRException {		
		
		if (barcoDescarga == null){
			Sistema.mensaje("Selecciones un Barco Descarga");
			lbxBarcoDescarga.focus();
			return;
		}		
		
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("fechadesde",dteFecha1.getValue());
		parameters.put("fechahasta",dteFecha2.getValue());
		parameters.put("barco", barcoDescarga.getBarco().getNombre() );
		parameters.put("registro",barcoDescarga.getRegistro());
		parameters.put("idBarcoDescarga",barcoDescarga.getIdbarcodescarga());
		doImprimir("CalidadPCC1AsignacionMuestrasEspecie.jasper", parameters);
		//Ejecutamos el reporte
		//new CalidadImpresion()
			//.doImprimirReporteCalidadEspecieTalla
				//("CalidadPCC1AsignacionMuestrasEspecie.jasper", "logo_real.gif", barcoDescarga.getIdbarcodescarga());
		
	}
	
	
	
	public void limpiarControles(){
		txtRegistro.setValue("");
		//txtNBarco.setValue("");
		binder.loadAll();
	}
	
	public void doImprimir(String nombre_report, Map<String,Object> parameters )
			throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		String logo = "logo_real.gif";
		String logo2 = "logo_real.gif";
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo   = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_logo2  = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo2;
				
		//Map<String,Object> parameters = new HashMap<String,Object>();
		//parameters.put("turno",idturno);
		//parameters.put("idpro",idProduccion);
		parameters.put("LOGO",ruta_logo);
		parameters.put("LOGO2",ruta_logo2);
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	private void EjecutarReporte(Map<String,Object> parameters, String ruta_report) throws JRException, SuspendNotAllowedException, InterruptedException 
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
 
	
}
