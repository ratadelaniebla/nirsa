package com.nw.model.dao.impl;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.BarcoCuba;
//import com.nw.model.Empleado;
//import com.nw.model.LimpiezaDetalleProcesoBandeja;
import com.nw.model.LimpiezaSecuenciaOrden;
//import com.nw.model.dao.BarcoCubaDAO;
import com.nw.model.dao.LimpiezaSecuenciaOrdenDAO;
//import com.nw.temp.model.BarcoCubaEstado;

@SuppressWarnings("unchecked")
public class LimpiezaSecuenciaOrdenDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaSecuenciaOrdenDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaSecuenciaOrdenDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }


	public LimpiezaSecuenciaOrden getFinLimpiezaSecuenciaOrdenId(Long id) {
		return em.find(LimpiezaSecuenciaOrden.class, id);	
	}    
    
    
    public LimpiezaSecuenciaOrden getLimpiezaSecuenciaOrden(String id){
    	LimpiezaSecuenciaOrden LimpiezaSecuenciaOrden;
    	try {
    		Query qry = em.createQuery(" select b from LimpiezaSecuenciaOrden b where b.codpersona=:idbc");
    		qry.setParameter("idbc", id);
    		LimpiezaSecuenciaOrden = (LimpiezaSecuenciaOrden) qry.getSingleResult(); 
    		return LimpiezaSecuenciaOrden;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }
    
/*    
	public void saveOrUpdate(LimpiezaSecuenciaOrden limpiezasecuenciaorden) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(limpiezasecuenciaorden);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}    
 */   
	
	
    @Override
    public  LimpiezaSecuenciaOrden saveOrUpdate(LimpiezaSecuenciaOrden limpiezasecuenciaorden) {
          EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
            EntityManager em = emf.createEntityManager();
            LimpiezaSecuenciaOrden  LimpiezaSecuenciaOrdenDevuelto = new LimpiezaSecuenciaOrden();
          try {
                 
                 
                 
                 EntityTransaction t = em.getTransaction();
                 try {
                        t.begin();
                        LimpiezaSecuenciaOrdenDevuelto = em.merge(limpiezasecuenciaorden);
                        t.commit();
                 } finally {
                        if (t.isActive())
                               t.rollback();
                 }
          } finally {
                 em.close();
          }
          return LimpiezaSecuenciaOrdenDevuelto;
    }	
	
	
	
   
}
