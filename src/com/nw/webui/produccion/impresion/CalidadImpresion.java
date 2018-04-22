package com.nw.webui.produccion.impresion;

import java.sql.Timestamp;
import java.util.Date;
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
public class CalidadImpresion {
//extends BaseDaoJpaImpl implements BarcoEstibaCubaDAO {

	private static Log logger = LogFactory.getLog(CalidadImpresion.class);
	private String usuario;
	
	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public CalidadImpresion() {
    	usuario = (String)Sessions.getCurrent().getAttribute("usuario");
    }
    public void doImprimirEvolutionEmpleadoEficiencia(String nombre_report, String logo, String fecha1,String fecha2) throws JRException, SuspendNotAllowedException, InterruptedException 
    {                 
          //Obtenemos la ruta del reporte .jrxml
          String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
          String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
          String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
          
          Map parameters = new HashMap();
          
          parameters.put("LOGO",ruta_logo);
          parameters.put("fecha1",fecha1);
          parameters.put("fecha2",fecha2);
          //parameters.put("FECHAFIN", fecha2);
          parameters.put("SUBREPORT_DIR", ruta_sub_report);
          //
          //Ejecutamos el reporte
          EjecutarReporte(parameters, ruta_report);
    }

    
    public void doImprimirEmpleadoDetallePesos(String nombre_report, String logo, Long idproduccion, Integer idturno) throws JRException, SuspendNotAllowedException, InterruptedException 
    {                 
          //Obtenemos la ruta del reporte .jrxml
          String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
          String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
          String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
          
          Map parameters = new HashMap();
          System.out.println("nombre_report :"+nombre_report);
          System.out.println("ruta_logo :"+ruta_logo);
          System.out.println("IDPRODUCCION :"+idproduccion);
          System.out.println("IDTURNO :"+idturno);
          
          parameters.put("LOGO",ruta_logo);
          parameters.put("IDPRODUCCION",idproduccion);
          parameters.put("IDTURNO",idturno);
          //parameters.put("FECHAFIN", fecha2);
          parameters.put("SUBREPORT_DIR", ruta_sub_report);
          //
          //Ejecutamos el reporte
          EjecutarReporte(parameters, ruta_report);
    }    

    
    
    public void doImprimirBalancePesos(String nombre_report, String logo, Long idproduccion, Integer idturno, String usuario) throws JRException, SuspendNotAllowedException, InterruptedException 
    {                 
          //Obtenemos la ruta del reporte .jrxml
          String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
          String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
          String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
          
          Map parameters = new HashMap();
          System.out.println("nombre_report :"+nombre_report);
          System.out.println("ruta_logo :"+ruta_logo);
          System.out.println("IDPRODUCCION :"+idproduccion);
          System.out.println("IDTURNO :"+idturno);
          
          
          parameters.put("LOGO",ruta_logo);
          parameters.put("PRODUCCION_ID",idproduccion);
          parameters.put("TURNO",idturno);
          parameters.put("USUARIO",usuario);
          
          //parameters.put("FECHAFIN", fecha2);
          parameters.put("SUBREPORT_DIR", ruta_sub_report);
          //
          //Ejecutamos el reporte
          EjecutarReporte(parameters, ruta_report);
    }     
    
    
	public void doImprimirCalidadBPMDesembarco(String nombre_report, String logo, Long id) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("idbpmdesembarco",id);
		parameters.put("LOGO",ruta_logo);
		
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	    

	public void doImprimirCalidadBPMClasificacion(String nombre_report, String logo, Long id) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("idbpmdesembarco",id);
		parameters.put("LOGO",ruta_logo);
		
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	    
	
	public void doImprimirbtnCalidadPCC1(String nombre_report, String logo, Long id, String vtipo) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		
		Map parameters = new HashMap();
		parameters.put("idcalidadpcc",id);
		//parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("LOGO",ruta_logo);
		parameters.put("vtipo",vtipo);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	    
	

	public void doImprimirbtnCalidadSensorialMP(String nombre_report, String logo, Long id, String vtipo) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
				
		Map parameters = new HashMap();
		parameters.put("idcalidadsensorialmp",id);
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("LOGO",ruta_logo);
		parameters.put("VTIPO",	vtipo);
		
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	    
	
	public void doImprimirbtnCalidadSensorialMP2(String nombre_report, String logo, Long id, String vtipo) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
				
		Map parameters = new HashMap();
		parameters.put("idcalidadsensorialmp",id);
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("LOGO",ruta_logo);
		parameters.put("VTIPO",	vtipo);
		
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	    

	public void doImprimirCalidadPCC1Histamina(String nombre_report, String logo, Long id) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		
		Map parameters = new HashMap();
		parameters.put("idcalidadpcc",id);
		parameters.put("LOGO",ruta_logo);
		

		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}		

	
	
	public void doImprimirCalidadInformesSalinidadPesca(String nombre_report, String logo, Long id) throws JRException, SuspendNotAllowedException, InterruptedException 
	{
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		
		Map parameters = new HashMap();
		parameters.put("idcalidadpcc",id);
		parameters.put("LOGO",ruta_logo);
		

		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}		
	
	
	
	public void doImprimirHistorialBarcosDescargas(String nombre_report, String logo, Timestamp f1c, Timestamp f2c) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("fecha1",f1c);
		parameters.put("fecha2",f2c);
		parameters.put("LOGO",ruta_logo);
		
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	
	


    public void doImprimirCajonUbicacionCamara(String nombre_report, String logo, int idcamara ) throws JRException, SuspendNotAllowedException, InterruptedException
    {           
        //Obtenemos la ruta del reporte .jrxml
        String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
        String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

        Map parameters = new HashMap();
       // parameters.put("idfila",idfila);
        parameters.put("LOGO",ruta_logo);
       // parameters.put("Fecha",fecha1);
        parameters.put("Camara",idcamara);
         
        //Ejecutamos el reporte
        EjecutarReporte(parameters, ruta_report);
    }
    
    public void doImprimirMovimientosInventarioCamaraAtun(String nombre_report, String logo,  int idcamara, Date fecha1, Date fecha2) throws JRException, SuspendNotAllowedException, InterruptedException
    {           
        //Obtenemos la ruta del reporte .jrxml
        String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
        String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

        Map parameters = new HashMap();
        //parameters.put("idFila",idfila);
        parameters.put("LOGO",ruta_logo);
        parameters.put("fecha1",fecha1);
        parameters.put("fecha2",fecha2);
        parameters.put("idCamara",idcamara); //cambviart el id 
        //Ejecutamos el reporte
        EjecutarReporte(parameters, ruta_report);
    }
	
	public void doImprimirCajonesDescongelado(String nombre_report, String logo, int turno, Date fecha ) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("fecha",fecha);
		parameters.put("turno", turno);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
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
	

public void doImprimirCocinaEntradaSalida(String nombre_report, String logo, int turno, Date fecha ) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("fecha",fecha);
		parameters.put("turno", turno);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
public void doImprimirMermaCocinaRociado(String nombre_report, String logo, Timestamp fecha, Timestamp fechafinal ) throws JRException, SuspendNotAllowedException, InterruptedException 
{			
	//Obtenemos la ruta del reporte .jrxml
	String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
	String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

	Map parameters = new HashMap();
	
	parameters.put("LOGO",ruta_logo);
	parameters.put("Fecha",fecha);
	parameters.put("FechaFinal",fechafinal); 
	//parameters.put("turno", turno);
	//Ejecutamos el reporte
	EjecutarReporte(parameters, ruta_report);
}

	public void doImprimirCocheRackeoPeso(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

		
	public void doImprimirMermasCrudo(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	public void doImprimirMermasCocido(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

		

	public void doImprimirDespCocidosxLinea(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	public void doImprimirMermasCrudoPeriodo(String nombre_report, String logo, Timestamp f1c, Timestamp f2c) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("fecha1",f1c);
		parameters.put("fecha2",f2c);
		parameters.put("LOGO",ruta_logo);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	public void doImprimirMermasCocidoPeriodo(String nombre_report, String logo, Timestamp f1c, Timestamp f2c) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("fecha1",f1c);
		parameters.put("fecha2",f2c);
		parameters.put("LOGO",ruta_logo);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	public void doImprimirVerifStdDesperdicioCrudo(String nombre_report, String logo, Timestamp f1c, Timestamp f2c) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("fecha1",f1c);
		parameters.put("fecha2",f2c);
		parameters.put("LOGO",ruta_logo);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	public void doImprimirVerifStdDesperdicioCocido(String nombre_report, String logo, Timestamp f1c, Timestamp f2c) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("fecha1",f1c);
		parameters.put("fecha2",f2c);
		parameters.put("LOGO",ruta_logo);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	
	public void doImprimirCochesAsignados(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	
	public void doImprimirCochesxCocinada(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirCochexLotexProduccion(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	public void doImprimirControlClasificacionxPesos(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirProcesosPcc3(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("IDPRODUCCION", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirProcesosPcc4yPcc5(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("IDPRODUCCION", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
		
	
	public void doImprimirPesosDescongeladoProduccion(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}


	
	public void doImprimirPesosControlLinea(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("turno", turno);
		parameters.put("idproduccion", idProduccion);
		parameters.put("USUARIO", (String)Sessions.getCurrent().getAttribute("usuario"));
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	
	
	public void doImprimirAsignacionCoches(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirCochesEviscerados(String nombre_report, String logo, Timestamp f1c, Timestamp f2c) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("fecha1",f1c);
		parameters.put("fecha2",f2c);
		parameters.put("LOGO",ruta_logo);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	public void doImprimirPagoFileteador(String nombre_report, String logo, Timestamp f1c, Timestamp f2c) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("fecha1",f1c);
		parameters.put("fecha2",f2c);
		parameters.put("LOGO",ruta_logo);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirCajonesDescongelado(String nombre_report, String logo, Timestamp f1c, Timestamp f2c) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String sruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		parameters.put("SUBREPORT_DIR",sruta_report);
		parameters.put("fecha1",f1c);
		parameters.put("fecha2",f2c);
		parameters.put("LOGO",ruta_logo);
		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirTiempoExposicionxCoche(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	public void doImprimirEvisceradoLotesProcesados(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	
	public void doImprimirMermas(String nombre_report, String logo, int turno, Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("IDPRODUCCION", idProduccion);
		parameters.put("TURNO", turno);
		
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirTempPreproceso(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("IDPRODUCCION", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	public void doImprimirProcesoPcc2(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("IDPRODUCCION", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	public void doImprimirTempxCocinada(String nombre_report, String logo, int turno, Date fecha,Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirRegistroCochesAProduccion(String nombre_report, String logo, int turno, Date fecha, Long idProduccion) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("fecha",fecha);
		parameters.put("turno",turno);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		parameters.put("idProduccion", idProduccion);

		
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
	
	
	public void doImprimirLoteCajonReporte(String nombre_report, String logo, int turno, Long idproduccion ) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("idProduccion",idproduccion);
		parameters.put("turno", turno);
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}

	public void doImprimirTemperaturaDescongelado(String nombre_report, String logo, Timestamp fecha , Timestamp fecha2) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("fecha1",fecha);
		parameters.put("fecha2",fecha2);
		//parameters.put("turno", turno);
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}	
	
	public void doImprimirDescongeladoCamara(String nombre_report, String logo, Date fecha, int turno ) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;

		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("Fecha",fecha);
		parameters.put("turno", turno);
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
		
	}

	public void doImprimirPonchadas(String nombre_report, String logo, int turno, Date fecha,Long idProduccion,String codPersona, Integer idLimpieza) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		//String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		parameters.put("FECHA",fecha);
		//parameters.put("FECHAFIN", fecha2);
		parameters.put("TURNO", turno);
		parameters.put("idProduccion", idProduccion);
		parameters.put("codPersona",codPersona); //
		parameters.put("idLinea",idLimpieza); 
		
		EjecutarReporte(parameters, ruta_report);
	}	

	public void doImprimirReporteCalidadEspecieTalla(String nombre_report, String logo, Long idBD) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		Map parameters = new HashMap();
		parameters.put("LOGO",ruta_logo);
		parameters.put("idBarcoDescarga",idBD); //
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		EjecutarReporte(parameters, ruta_report);
	}	

	public void doImprimirReporteRemuestreo(String nombre_report, String logo, Long idBD) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
//		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		Map parameters = new HashMap();
		parameters.put("LOGO",ruta_logo);
		parameters.put("idBD",idBD); //
//		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		EjecutarReporte(parameters, ruta_report);
	}	

	@SuppressWarnings("rawtypes")
	public void doImprimirCocinaGrafica(String nombre_report, String logo, int idCocina, Date fecha,Long idProduccion, Integer idCocinada,String rutaImgen) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
//		String ruta_imagen = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes/imgenes").toString()+System.getProperty("file.separator")+nombreImgen+".jpg";
		
		Map parameters = new HashMap();
		parameters.put("IMAGEN", rutaImgen);
		parameters.put("LOGO",ruta_logo);
		parameters.put("fecha",fecha);
		parameters.put("cocina", idCocina);
//		parameters.put("idProduccion", idProduccion);
		parameters.put("idcocinada",idCocinada);
		
		
		EjecutarReporte(parameters, ruta_report);
	}
	
	public void doImprimirProduccionxHora(String nombre_report, String logo, int turno, Date fecha,Long idProduccion,StringBuffer sb,Integer horas,String usuario,StringBuffer sf) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		System.out.println("SBQUERY: "+sb.toString());
		parameters.put("LOGO",ruta_logo);
		parameters.put("idproduccion",idProduccion);
		parameters.put("usuario", usuario);
		parameters.put("idturno", turno);
		parameters.put("horas", horas);
		parameters.put("sdextra",sb.toString()); 
		parameters.put("sf",sf.toString()); 
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		System.out.println("Parametros: ");
		System.out.println("fechaproduccion: "+fecha.toString());
		System.out.println("idturno: "+turno);
		System.out.println("subquery: "+sb.toString());
		EjecutarReporte(parameters, ruta_report);
	}
	

	public void doImprimirProduccionTrazabilidad(String nombre_report, String logo, String fecha1,String fecha2,String usuario) throws JRException, SuspendNotAllowedException, InterruptedException 
    {                 
          //Obtenemos la ruta del reporte .jrxml
          String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
          String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
          String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
          
          Map parameters = new HashMap();
          parameters.put("LOGO",ruta_logo);
          parameters.put("fecha1",fecha1);
          parameters.put("usuario", usuario);
          parameters.put("fecha2", fecha2);
          parameters.put("SUBREPORT_DIR", ruta_sub_report);
          System.out.println("Parametros: ");
          EjecutarReporte(parameters, ruta_report);
    }
	
	
	public void doImprimirParadas(String nombre_report, String logo, Long idProduccion1, Long idProduccion2) throws JRException, SuspendNotAllowedException, InterruptedException 
	{			
		//Obtenemos la ruta del reporte .jrxml
		String ruta_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombre_report;
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_sub_report = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator");
		
		Map parameters = new HashMap();
		
		parameters.put("LOGO",ruta_logo);
		
		parameters.put("fecha1",idProduccion1);
		parameters.put("fecha2",idProduccion2);

		
		parameters.put("SUBREPORT_DIR", ruta_sub_report);
		//
		//Ejecutamos el reporte
		EjecutarReporte(parameters, ruta_report);
	}
}

