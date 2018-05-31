package com.nw.util;

import java.io.ByteArrayOutputStream;
//import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

import org.eclipse.persistence.internal.databaseaccess.Accessor;
import org.eclipse.persistence.internal.sessions.UnitOfWorkImpl;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Filedownload;

import com.avante.core.jpa.JPAPersistenceManager;




public class ReporteExcel {

	
	public ReporteExcel() {
	 
	}
	
	
	
	/**
	 * Genera un reporte en Excel en base a un archivo .jasper
	 * Este metodo se basa en las mismas librerias del ireport,
	 * el parametro "nombreReporteGenerar" es cualquier nombre q uno le kiera poner al reporte q dara como 
	 * resultado para descargar o visualizar ej: "reporteMermaCocina"
	 * 
	 * el exito del reporte en excel es q el diseño en el jasperReport este bien realizado
	 * es decir sin espacios entre label o field y asignar un borde de 0,5 en los mismos para que se vea bien 
	 * enmarcado en el archivo de excel 
	 * @param nombreReporteGenerar
	 * @param nombrejasper
	 * @param logo
	 * @param parameters
	 * @throws JRException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void generarExcelJasper(String nombreReporteGenerar, String nombrejasper, String logo, Map parameters ) throws JRException, FileNotFoundException{
		String usuario = "";
		String logo2 = "logo_real.gif";
		String fileName = Executions.getCurrent().getDesktop().
				getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombrejasper;
	
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		String ruta_logo2  = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo2;
		
		usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		
		//asignar los parametros faltantes
		parameters.put("LOGO",ruta_logo);
		parameters.put("LOGO2",ruta_logo2);
		parameters.put("USUARIO",usuario);
		
		
		// conexion 
		
	 	EntityManagerFactory emf;
	 	 
	    EntityManager em;
	    
	    emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    
	    em = emf.createEntityManager();  
	    
	     
	    em.getTransaction().begin();
	   
		UnitOfWorkImpl unitOfWork = (UnitOfWorkImpl)((JpaEntityManager)em.getDelegate()).getActiveSession();
		 
		unitOfWork.beginEarlyTransaction();
	 
		Accessor accessor = unitOfWork.getAccessor();
		 
		accessor.incrementCallCount(unitOfWork.getParent());
		 
		accessor.decrementCallCount();
		 
		java.sql.Connection connection = accessor.getConnection();
		
		
		
		//reporte excel 
		JasperPrint jasperPrint = 
				 JasperFillManager.fillReport(fileName,parameters, connection );//datasource
		  
			
		  ByteArrayOutputStream out = new ByteArrayOutputStream();
			OutputStream output = new FileOutputStream(new File("C:\\mbaque\\JasperReport.pdf"));
			//OutputStream output = new FileOutputStream(""); // esta linea es de prueba
			JasperExportManager.exportReportToPdfStream(jasperPrint, output);
			// coding For Excel:
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
			//exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			////agregadas
			exporterXLS.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, true);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, true);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, false);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
			
			
			exporterXLS.exportReport();
		  
			
			 Date fechaActual = new Date();
	            
	           String fechaformateada = "";
	           String hora ="";
	           //SimpleDateFormat format = new SimpleDateFormat("EEE-MMM-dd-yyyy-HH:mm:ss");
	           SimpleDateFormat format = new SimpleDateFormat("MMM-dd-yyyy-HH:mm:ss");
	           fechaformateada= format.format(fechaActual);
	           hora=fechaformateada.replace(":", "-");
	           
			
			// asigno el nombre mas la hora de la descarga para evitar que salgan reportes con el mismo nombre
		    AMedia amedia = new AMedia(nombreReporteGenerar+"-"+hora+".xls", "xls", "application/file", out.toByteArray());
		    Filedownload.save(amedia);  
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void generarExcelConttrolJasper(String nombreReporteGenerar, String nombrejasper, String logo, Map parameters ) throws JRException, FileNotFoundException{
		String fileName = Executions.getCurrent().getDesktop().
				getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombrejasper;
		// conexion 
		
	 	EntityManagerFactory emf;
	 	 
	    EntityManager em;
	    
	    emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    
	    em = emf.createEntityManager();  
	    
	     
	    em.getTransaction().begin();
	   
		UnitOfWorkImpl unitOfWork = (UnitOfWorkImpl)((JpaEntityManager)em.getDelegate()).getActiveSession();
		 
		unitOfWork.beginEarlyTransaction();
	 
		Accessor accessor = unitOfWork.getAccessor();
		 
		accessor.incrementCallCount(unitOfWork.getParent());
		 
		accessor.decrementCallCount();
		 
		java.sql.Connection connection = accessor.getConnection();
		
		
		
		//reporte excel 
		JasperPrint jasperPrint = 
				 JasperFillManager.fillReport(fileName,parameters, connection );//datasource
		  
			
		  ByteArrayOutputStream out = new ByteArrayOutputStream();
			OutputStream output = new FileOutputStream(new File("JasperReport.pdf"));
			//OutputStream output = new FileOutputStream(""); // esta linea es de prueba
			JasperExportManager.exportReportToPdfStream(jasperPrint, output);
			// coding For Excel:
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
			//exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			////agregadas
			exporterXLS.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, true);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, true);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, false);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
			
			
			exporterXLS.exportReport();
		  
			
			 Date fechaActual = new Date();
	            
	           String fechaformateada = "";
	           String hora ="";
	           //SimpleDateFormat format = new SimpleDateFormat("EEE-MMM-dd-yyyy-HH:mm:ss");
	           SimpleDateFormat format = new SimpleDateFormat("MMM-dd-yyyy-HH:mm:ss");
	           fechaformateada= format.format(fechaActual);
	           hora=fechaformateada.replace(":", "-");
	           
			
			// asigno el nombre mas la hora de la descarga para evitar que salgan reportes con el mismo nombre
		    AMedia amedia = new AMedia(nombreReporteGenerar+"-"+hora+".xls", "xls", "application/file", out.toByteArray());
		    Filedownload.save(amedia);  
	}
	
	
	
	//este metodo de conexion lo saque de la clase ReportesDAOJpaImpl
	public Connection coneccion(){
		
	 	EntityManagerFactory emf;
	  
	    EntityManager em;
	    
	    emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	   
	    em = emf.createEntityManager();  
	    
		    em.getTransaction().begin();
			   
			UnitOfWorkImpl unitOfWork = (UnitOfWorkImpl)((JpaEntityManager)em.getDelegate()).getActiveSession();
			 
			unitOfWork.beginEarlyTransaction();
			 
			Accessor accessor = unitOfWork.getAccessor();
			 
			accessor.incrementCallCount(unitOfWork.getParent());
			 
			accessor.decrementCallCount();
				
			Connection connection = accessor.getConnection();
	 
		
		
		return connection;
		
	}
	



@SuppressWarnings({ "rawtypes", "unchecked" })
	public void generarExcelJasperFechaproduccion(String nombreReporteGenerar, String nombrejasper, String logo, Map parameters,int turno, Date fechaproduccion ) throws JRException, FileNotFoundException{
		String usuario = "";
		
		String fileName = Executions.getCurrent().getDesktop().
				getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombrejasper;
	
		String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
		
		usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		
		//asignar los parametros faltantes
		parameters.put("LOGO",ruta_logo);
		parameters.put("USUARIO",usuario);
		
		
		// conexion 
		
	 	EntityManagerFactory emf;
	 	System.out.println("l1");
	    EntityManager em;
	    System.out.println("l2");
	    emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    System.out.println("l3");
	    em = emf.createEntityManager();  
	    
	    System.out.println("l4");
	    em.getTransaction().begin();
	    System.out.println("l5");
		UnitOfWorkImpl unitOfWork = (UnitOfWorkImpl)((JpaEntityManager)em.getDelegate()).getActiveSession();
		System.out.println("l6");
		unitOfWork.beginEarlyTransaction();
		System.out.println("l7");
		Accessor accessor = unitOfWork.getAccessor();
		System.out.println("l8");
		accessor.incrementCallCount(unitOfWork.getParent());
		System.out.println("l9");
		accessor.decrementCallCount();
		System.out.println("l10");
		java.sql.Connection connection = accessor.getConnection();
		
		
		
		//reporte excel 
		JasperPrint jasperPrint = 
				 JasperFillManager.fillReport(fileName,parameters, connection );//datasource
		  
			
		  ByteArrayOutputStream out = new ByteArrayOutputStream();
			OutputStream output = new FileOutputStream(new File("JasperReport.pdf"));
			//OutputStream output = new FileOutputStream(""); // esta linea es de prueba
			JasperExportManager.exportReportToPdfStream(jasperPrint, output);
			// coding For Excel:
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			////agregadas
			exporterXLS.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, true);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, false);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
			
			
			exporterXLS.exportReport();
//			 Produccion p;
//			
//			 Timestamp dia = new Timestamp(dteFecha.getValue().getTime());
//		        
//		        new Fecha().ConvertirFechaTimestamp(dia.toString());
//		       p = new ProduccionDAOJpaImpl().consultarfechadeProduccionReporte(dia);
			 
			// Date fechaActual = new Date();
	            
	           String fechaformateada = "";
	           String hora ="";
	           
	           //SimpleDateFormat format = new SimpleDateFormat("EEE-MMM-dd-yyyy-HH:mm:ss");
	           SimpleDateFormat format = new SimpleDateFormat("MMM-dd-yyyy");
	        //   fechaformateada= format.format(fechaActual);
	           fechaformateada= format.format(fechaproduccion);
	           System.out.println("nombre->"+fechaformateada);
	           hora=fechaformateada.replace(":", "-");
	           System.out.println("hora->"+hora);
	         
	           
			
			// asigno el nombre mas la hora de la descarga para evitar que salgan reportes con el mismo nombre
		    AMedia amedia = new AMedia(nombreReporteGenerar+hora+"-"+"turno"+turno+".xls", "xls", "application/file", out.toByteArray());
		    Filedownload.save(amedia);  
		
	}	



     @SuppressWarnings({ "unchecked", "rawtypes" })
	 public void generarExcelJasperxlsx(String nombreReporteGenerar, String nombrejasper, String logo, Map parameters ) throws JRException, FileNotFoundException{
            String usuario = "";
            
            String fileName = Executions.getCurrent().getDesktop().
                  getWebApp().getRealPath("/reportes").toString()+System.getProperty("file.separator")+nombrejasper;
      
            String ruta_logo = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/img").toString()+System.getProperty("file.separator")+logo;
            
            usuario = (String)Sessions.getCurrent().getAttribute("usuario");
            
            //asignar los parametros faltantes
            parameters.put("LOGO",ruta_logo);
            parameters.put("USUARIO",usuario);
            
            // conexion 
            EntityManagerFactory emf;
           EntityManager em;
           emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
           em = emf.createEntityManager();  
           em.getTransaction().begin();
           
            UnitOfWorkImpl unitOfWork = (UnitOfWorkImpl)((JpaEntityManager)em.getDelegate()).getActiveSession();
           
            unitOfWork.beginEarlyTransaction();
            Accessor accessor = unitOfWork.getAccessor();
            accessor.incrementCallCount(unitOfWork.getParent());
            accessor.decrementCallCount();
            java.sql.Connection connection = accessor.getConnection();
            
            //reporte excel 
            JasperPrint jasperPrint = 
                         JasperFillManager.fillReport(fileName,parameters, connection );//datasource
              
                  
              ByteArrayOutputStream out = new ByteArrayOutputStream();
                  OutputStream output = new FileOutputStream(new File("JasperReport.pdf"));
                  //OutputStream output = new FileOutputStream(""); // esta linea es de prueba
                  JasperExportManager.exportReportToPdfStream(jasperPrint, output);
                  // coding For Excel:
                  JRXlsxExporter exporterXLS = new JRXlsxExporter();
                  exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                  exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
                  exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                  
            /*    exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
                  exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                  exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                  ////agregadas
                  exporterXLS.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, true);
                  exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
                  exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, false);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
                  
                  */
                  exporterXLS.exportReport();
              
                  
                   Date fechaActual = new Date();
                  
                 String fechaformateada = "";
                 String hora ="";
                 //SimpleDateFormat format = new SimpleDateFormat("EEE-MMM-dd-yyyy-HH:mm:ss");
                 SimpleDateFormat format = new SimpleDateFormat("MMM-dd-yyyy-HH:mm:ss");
                 fechaformateada= format.format(fechaActual);
                 System.out.println("nombre->"+fechaformateada);
                 hora=fechaformateada.replace(":", "-");
                 System.out.println("hora->"+hora);
                  
                  // asigno el nombre mas la hora de la descarga para evitar que salgan reportes con el mismo nombre
                AMedia amedia = new AMedia(nombreReporteGenerar+"-"+hora+".xlsx", "xlsx", "application/file", out.toByteArray());
                Filedownload.save(amedia);  
            
            
            
      }

	
}
