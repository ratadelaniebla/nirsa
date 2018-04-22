package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadBpmDesembarco;
import com.nw.model.dao.CalidadBpmdesembarcoDAO;

@SuppressWarnings("unchecked")
public class CalidadBpmDesembarcoDAOJpaImpl extends BaseDaoJpaImpl implements CalidadBpmdesembarcoDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadBpmDesembarcoDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }




	@Override
	public List<CalidadBpmDesembarco> getCalidadBpmDesembarcos() {
		// TODO Auto-generated method stub
		return em.createQuery("select b from CalidadBpmdesembarco b").getResultList();
	}


	@Override
	public CalidadBpmDesembarco getCalidadBpmDesembarcoById(
			Integer idbpmdesembarco) {
		// TODO Auto-generated method stub
		return em.find(CalidadBpmDesembarco.class, idbpmdesembarco);
	}

	
	
	//@Override
	public CalidadBpmDesembarco getCalidadBpmDesembarcobyId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadBpmDesembarco o "); 
		sb.append("Where o.idbpmdesembarco = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadBpmDesembarco) items.get(0);
        }		
	}	
	
	/*
	 * Ejemplos de consultas nativas...
	 * 
	Query query = em.createNativeQuery("SELECT * FROM EMPLOYEE", Employee.class);
	List<Employee> result = query.getResultList();

	Query query = em.createNativeQuery("SELECT SYSDATE FROM DUAL");
	Date result = (Date)query.getSingleResult();

	Query query = em.createNativeQuery("SELECT MAX(SALARY), MIN(SALARY) FROM EMPLOYEE");
	List<Object[]> results = query.getResultList();
	int max = results.get(0)[0];
	int min = results.get(0)[1];

	Query query = em.createNativeQuery("DELETE FROM EMPLOYEE");
	int rowCount = query.executeUpdate();
	*/
	
	@Override
	public void saveOrUpdate(CalidadBpmDesembarco calidadbpmdesembarco) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(calidadbpmdesembarco);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	public void saveNative(CalidadBpmDesembarco calidadbpmdesembarco) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
	    
	    String sql = " INSERT INTO calidad_bpm_desembarco( " +
	    		" idbpmdesembarco, idbarcodescarga, fecha, observaciones, estado) VALUES (?, ?, ?, ?, ?) ";
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
					Query query = em.createNativeQuery(sql);
					    query.setParameter(1, calidadbpmdesembarco.getIdbpmdesembarco() );
				        query.setParameter(2, calidadbpmdesembarco.getBarcoDescarga().getIdbarcodescarga());
				        query.setParameter(3, calidadbpmdesembarco.getFecha());
				        if (calidadbpmdesembarco.getObservaciones() != null) {
				        	query.setParameter(4, calidadbpmdesembarco.getObservaciones().trim() );
						}else{
							query.setParameter(4, "" );
						}
				        //query.setParameter(4, calidadbpmdesembarco.getObservaciones().trim() );
				        query.setParameter(5, calidadbpmdesembarco.getEstado() );
				        
				        query.executeUpdate();
	 			    t.commit();
    		  } catch (RuntimeException e) {
  				e.printStackTrace();
  				if (t.isActive()){    
  					t.rollback();
  				}	 
  			  }
			}finally{
				em.close();
			}
	}
	
	
}
