package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Subproducto;
import com.nw.model.dao.SubproductoDAO;


@SuppressWarnings("unchecked")
public class SubproductoDAOJpaImpl extends BaseDaoJpaImpl implements SubproductoDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public SubproductoDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public Subproducto getFindSubproductoId(Integer vid) {
		return em.find(Subproducto.class, vid);	
	}	    
   
    
	public List<Subproducto> getSubproductosCocidos(String tipo, Integer idlugar) {
		return em.createQuery("select sp from Subproducto sp where sp.tipo = :vtipo and sp.lugar.idlugar =:vidlugar order by sp.descripcion")
				.setParameter("vtipo",tipo.toString().trim())
				.setParameter("vidlugar",idlugar)
				.getResultList();		
	}	

    
	public List<Subproducto> getSubproductosFileteado(String tipo, Integer idlugar) {
		return em.createQuery("select sp from Subproducto sp where sp.tipo = :vtipo and sp.lugar.idlugar =:vidlugar " +
				" and sp.idsubproducto in (1,3) order by sp.descripcion")
				.setParameter("vtipo",tipo.toString().trim())
				.setParameter("vidlugar",idlugar)
				.getResultList();		
	}	

	
	
//	public List<BarcoEstibaCuba> getListBarcoEstibaCubaByIdBarcoDescarga(String idBarcoDescarga) {
//		return em.createQuery("select bec From BarcoEstibaCuba bec where bec.barcoDescarga.idbarcodescarga = :idBarcoDes and bec.estadodescargacuba = 0 order by bec.idbarcoestibacuba")
//				.setParameter("idBarcoDes", Integer.valueOf(idBarcoDescarga))
//				.getResultList();
//	}	
	
	
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
	public void saveOrUpdate(Subproducto subproducto) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(subproducto);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	
}
