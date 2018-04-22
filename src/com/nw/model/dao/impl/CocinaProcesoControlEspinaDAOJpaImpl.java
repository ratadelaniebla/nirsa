package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;

import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import com.avante.core.jpa.JPAPersistenceManager;

import com.nw.model.CocinaProcesoControlEspina;
import com.nw.model.dao.CocinaProcesoControlEspinaDAO;

@SuppressWarnings("unchecked")
public class CocinaProcesoControlEspinaDAOJpaImpl extends BaseDaoJpaImpl implements CocinaProcesoControlEspinaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CocinaProcesoControlEspinaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
	public List<CocinaProcesoControlEspina> getCocinaProcesoControlEspinas() {
		return em.createQuery("select c from CocinaProcesoControlEspina c order by c.numeroespina").getResultList();
	}

	
//	public Cuba getFindBarcoCubaId(Integer vid) {
//		return em.find(Cuba.class, vid);	
//	}	
//	
//	public Cuba getMaxIdCuba(){
//    	Cuba cuba;
//    	try {
//    		Query qry = em.createQuery(" select b  from Cuba b where b.idcuba = (Select max (ba.idcuba) from Cuba ba )");
//    		cuba = (Cuba) qry.getSingleResult(); 
//    		return cuba;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
//    	
//    }
//   
//	public void saveOrUpdate(Cuba cuba) {
//		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction t = em.getTransaction();
//		try{
//	    	 
//	    	  try {
//						t.begin();  
//						em.merge(cuba);
//	 			        t.commit();
//    		  } finally {
//    		    if (t.isActive()) t.rollback();
//    		  }
//			}finally{
//				em.close();
//			}
//	}
//	
//	public void saveCuba(Cuba cuba) {
//		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
//	    EntityManager em = emf.createEntityManager();   
//		try{
//	    	 EntityTransaction t = em.getTransaction();
//	    	  try {
//					t.begin();  
//						Query quy = em.createNativeQuery("INSERT INTO cuba(idcuba, nombrecuba, especificacion)" +
//								" VALUES (?, ?, ?) ");
//						quy.setParameter(1, cuba.getIdcuba());
//						quy.setParameter(2, cuba.getNombrecuba());
//						quy.setParameter(3, cuba.getEspecificacion());
//						quy.executeUpdate();
//	 			        t.commit();
//    		  } finally {
//    		    if (t.isActive()) t.rollback();
//    		  }
//			}finally{
//				em.close();
//			}
//	}
}
