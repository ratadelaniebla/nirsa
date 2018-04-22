package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Area;
import com.nw.model.AreaProceso;
import com.nw.model.AreaSubproducto;
import com.nw.model.dao.AreaDAO;


@SuppressWarnings("unchecked")
public class AreaDAOJpaImpl extends BaseDaoJpaImpl implements AreaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public AreaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public Area getFindAreaId(Integer vid) {
		return em.find(Area.class, vid);	
	}	    
   
 
	public List<Area> getAreasDesperdiciosCrudo() {
		//return em.createQuery("select a from Area a where a.desperdicio = 1 order by a.nombre").getResultList();
		return em.createQuery("select a from Area a where a.idarea = 17 order by a.nombre").getResultList();
	}	
	
	
	public List<Area> getAreasDesperdicios() {
		return em.createQuery("select a from Area a where a.desperdicio = 1 order by a.nombre").getResultList();
	}
	
	public List<AreaProceso> getOtrasAreasDesperdicios() {
		return em.createQuery("select ap from AreaProceso ap Where ap.proceso.idproceso = 2 order by ap.area.nombre").getResultList();
	}
	
	public List<AreaSubproducto> getAreaSubproductos(Integer id) {
		return em.createQuery("select asp from AreaSubproducto asp Where asp.area.idarea = :vid and asp.lugar is null order by asp.subproducto.descripcion")
			.setParameter("vid",id)
			.getResultList();		
	}	

	public List<AreaSubproducto> getAreaSubproductosByIdAreByIdLugar(Integer ida, Integer idl) {
		return em.createQuery("select asp from AreaSubproducto asp Where asp.area.idarea = :vida and asp.lugar.idlugar = :vidl order by asp.subproducto.descripcion")
			.setParameter("vida",ida)
			.setParameter("vidl",idl)
			.getResultList();		
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
	public void saveOrUpdate(Area area) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(area);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	
}
