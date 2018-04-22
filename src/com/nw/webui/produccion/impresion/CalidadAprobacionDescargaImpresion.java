package com.nw.webui.produccion.impresion;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zul.Window;

@SuppressWarnings("unchecked")
public class CalidadAprobacionDescargaImpresion {
//extends BaseDaoJpaImpl implements BarcoEstibaCubaDAO {

	private static Log logger = LogFactory.getLog(CalidadAprobacionDescargaImpresion.class);
	private String usuario;
	
	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public CalidadAprobacionDescargaImpresion() {
    	usuario = (String)Sessions.getCurrent().getAttribute("usuario");
    }

    
	public void doImprimirCalidadAprobacionDescargaCuba(String nombre_report, String logo, Long vIdcalidadpcc, Long vIdbarcoestibacuba) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("idcalidadpcc",vIdcalidadpcc);
		parameters.put("idcuba",vIdbarcoestibacuba);
		parameters.put("LOGO",ruta_logo);
		parameters.put("VTIPO","SC");
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	    

	
	//Funcion Generica para visulizar los reportes
	public void EjecutarReporte(Map parameters, String ruta_report) throws JRException, SuspendNotAllowedException, InterruptedException 
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

