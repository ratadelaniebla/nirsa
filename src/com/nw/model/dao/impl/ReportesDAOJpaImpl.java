package com.nw.model.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.persistence.internal.databaseaccess.Accessor;
import org.eclipse.persistence.internal.sessions.UnitOfWorkImpl;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.zkoss.util.media.AMedia;
import org.zkoss.zul.api.Iframe;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.dao.ReportesConsultaDAO;
 
public class ReportesDAOJpaImpl extends BaseDaoJpaImpl implements com.nw.model.dao.ReportesConsultaDAO{

	@SuppressWarnings("unused")
	private static Log logger = LogFactory.getLog(ReportesDAOJpaImpl.class);

	@PersistenceContext
//    private EntityManagerFactory emf;
//    private EntityManager em;
    
    protected JasperReport jasperReport;
    protected Iframe report;
 
    public AMedia ReportesDAOJpaImpl(Map parameters, String rutaReport) throws JRException {

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
		
		JasperPrint jasperPrint;
		System.out.println("l11");
		//jasperReport = JasperCompileManager.compileReport(rutaReport);
		
		jasperReport = (JasperReport) JRLoader.loadObject(rutaReport);
		System.out.println("l12");
		jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, connection);
		System.out.println("l3");	
		final byte[] buf = JasperRunManager.runReportToPdf(jasperReport, parameters, connection);
		System.out.println("l14");
		final InputStream mediais = new ByteArrayInputStream(buf);
		System.out.println("l15");
		final AMedia amedia = new AMedia("Reporte.pdf", "pdf", "application/pdf", mediais);
		System.out.println("l6");
		
		em.close();
		
		return amedia;
    }



//
//	public void saveOrUpdate(Tblconsulta consulta) {
//		try{
//	    	EntityTransaction t = em.getTransaction();
//	    	try {
//				t.begin();  
//				em.merge(consulta);
//				t.commit();				
//	    	} finally {
//	    		if (t.isActive()) t.rollback();
//	    	}
//		}finally{
//			em.close();
//		}
//	}
	
//	public Tblconsulta saveOrUpdateReturn(Tblconsulta consulta) {
//		try{
//	    	EntityTransaction t = em.getTransaction();
//	    	try {
//				t.begin();  
//				em.merge(consulta);
//				
//				List lc = getConsultas();
//				t.commit();
//				
//				return (Tblconsulta) lc.get(lc.size()-1);
//				
//	    	} finally {
//	    		if (t.isActive()) t.rollback();
//	    	}
//		}finally{
//			em.close();
//		}
//	}
	
//	public List<Tblconsulta> getConsultas() {
//		StringBuffer sb = new StringBuffer();
//
//		sb.append("Select o ");
//		sb.append("From Tblconsulta o ");
//
//		logger.info(ReportesDAOJpaImpl.class +" -> "+sb.toString());
//
//		List<Tblconsulta> ltblconsulta = em.createQuery(sb.toString()).getResultList();
//
//        if (ltblconsulta.size() == 0 || ltblconsulta.isEmpty()) {
//            return null;
//        } else {
//        	return ltblconsulta;
//        }
//	}
//	
//	public List<Tblconsulta> getConsultasByEmpleado(int idempleado) { 
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append("Select c ");
//		sb.append("From Tblconsulta c ");
//		sb.append("Where c.fkempleado =" + idempleado);
//		
//		logger.info(ReportesDAOJpaImpl.class +" -> "+sb.toString());
//		
//		List<Tblconsulta> ltblconsulta = em.createQuery(sb.toString()).getResultList();
//		
//        if (ltblconsulta == null || ltblconsulta.isEmpty()) {
//            return null;
//        } else {
//            return ltblconsulta;
//        }
//	}
//	/*
//	public Tblconsulta getIdconsulta(Integer idconsulta) {
//		return em.find(Tblconsulta.class, idconsulta);
//	}*/
}