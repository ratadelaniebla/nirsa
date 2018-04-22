package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Lugar;
import com.nw.model.LugarDetalle;
import com.nw.model.dao.LugarDAO;

@SuppressWarnings("unchecked")
public class LugarDAOJpaImpl extends BaseDaoJpaImpl implements LugarDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LugarDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public Lugar getFindLugarId(Integer vid) {
		return em.find(Lugar.class, vid);	
	}	    
   
    
	public List<Lugar> getLugaresDesperdicios(Integer idareadesperdicio) {
		return em.createQuery("select l from Lugar l where l.desperdicio = 1 and l.area.idarea = :vidareadesperdicio order by l.descripcionlugar")
				.setParameter("vidareadesperdicio",idareadesperdicio)
				.getResultList();
	}

	
	public List<LugarDetalle> getDetalleLugaresDesperdicios(Integer idlugar, Integer idarea) {
		return em.createQuery("select ld from LugarDetalle ld  where ld.lugar.idlugar = :vidlugar and ld.area.idarea = :vidarea order by ld.numerolugar")
				.setParameter("vidlugar",idlugar)
				.setParameter("vidarea", idarea)
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
	public void saveOrUpdate(Lugar lugar) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(lugar);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	
}
