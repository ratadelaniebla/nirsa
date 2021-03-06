package com.nw.webui.produccion.impresion;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zul.Window;

public class ProgamaProduccionImpresion {

	private String usuario;
	
	public ProgamaProduccionImpresion() {
    	usuario = (String)Sessions.getCurrent().getAttribute("usuario");
    }
	
	public void doImprimirProgramaProduccion(String nombre_report, String logo, Long idproduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_report_principal = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("USUARIO",id);
		parameters.put("LOGO", ruta_logo);
		parameters.put("IDPRODUCCION", idproduccion);
		parameters.put("SUBREPORT_DIR", ruta_report);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report_principal);
	}
	
	public void doImprimirProgramaFillWeigth(String nombre_report, String logo, Long idproduccion, Integer idTurno) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_report_principal = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("LOGO", ruta_logo);
		parameters.put("IDPRODUCCION", idproduccion);
		parameters.put("SUBREPORT_DIR", ruta_report);
		parameters.put("IDTURNO", idTurno);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report_principal);
	}
	
	public void doImprimirProgramaPesoFill(String nombre_report, String logo, Long idenvasadocontrolpesofillcabecera) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_report_principal = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("LOGO", ruta_logo);
		parameters.put("SUBREPORT_DIR", ruta_report);
		parameters.put("idenvasadocontrolpesofillcabecera", idenvasadocontrolpesofillcabecera);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report_principal);
	}
	
	public void doImprimirProgramaPesoNeto(String nombre_report, String logo, Long idenvasadocontrolpesonetocabecera) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_report_principal = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("LOGO", ruta_logo);
		parameters.put("SUBREPORT_DIR", ruta_report);
		parameters.put("idenvasadocontrolpesonetocabecera", idenvasadocontrolpesonetocabecera);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report_principal);
	}
	
	public void doImprimirReporteProductosEnvasado(String nombre_report, String logo, Long idproduccion, Integer idturno) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_report_principal = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("LOGO", ruta_logo);
		parameters.put("SUBREPORT_DIR", ruta_report);
		parameters.put("idproduccion", idproduccion);
		parameters.put("idturno", idturno);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report_principal);
	}
	
	public void doImprimirReporteMaquinaPlantaAtunera(String nombre_report, String logo, Long idproduccion, Integer idturno) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_report_principal = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("LOGO", ruta_logo);
		parameters.put("SUBREPORT_DIR", ruta_report);
		parameters.put("idproduccion", idproduccion);
		parameters.put("idturno", idturno);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report_principal);
	}
	
	public void doImprimirProgramaAutoClaveControl(String nombre_report, String logo, Long idproduccion, Integer idTurno) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_report_principal = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("LOGO", ruta_logo);
		parameters.put("IDPRODUCCION", idproduccion);
		parameters.put("SUBREPORT_DIR", ruta_report);
		if(idTurno!=null)
			parameters.put("IDTURNO", idTurno);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report_principal);
	}
	
	public void EjecutarReporte(Map<String, Object> parameters, String ruta_report) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		
		
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
