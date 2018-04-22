package com.nw.model.dao.impl;
 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
 
 
 
import com.nw.model.LonjasEstandarFundasTalla;
 
 

public class LonjasEstandarFundasTallaDAOJpaImpl extends BaseDaoJpaImpl {

 
	public LonjasEstandarFundasTallaDAOJpaImpl() {
	}

	
	 
	public LonjasEstandarFundasTalla saveOrUpdate(LonjasEstandarFundasTalla lonjasEstandarFundasTalla) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		LonjasEstandarFundasTalla LonjasEstandarFundasTallaDevuelto = null;
		try {
			t.begin();
			LonjasEstandarFundasTallaDevuelto = em.merge(lonjasEstandarFundasTalla);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return LonjasEstandarFundasTallaDevuelto;
	}
	
	public void saveNative(LonjasEstandarFundasTalla lonjasEstandarFundasTalla) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		int 	id 			= lonjasEstandarFundasTalla.getIdlonjasestandarfundastallas();
		String 	talla 		= lonjasEstandarFundasTalla.getIdtalla(); 
		int 	fundasxhora = lonjasEstandarFundasTalla.getEstandarfundasporhora();
		
	    String sql = "INSERT INTO lonjas_estandar_fundas_tallas(" +
	    			 "    idlonjasestandarfundastallas, idtalla, estandarfundasporhora)" +
	    			 "     VALUES (?, ? , ? );";
		try {
			 t.begin();
				 Query query  = em.createNativeQuery( sql );
				 query.setParameter(1, id);
				 query.setParameter(2, talla);
				 query.setParameter(3, fundasxhora);
				 query.executeUpdate();
			 t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
	 
	}
	
	   
	public LonjasEstandarFundasTalla getLonjasEstandarFundasTallaById( int id) {
		LonjasEstandarFundasTalla ep = new LonjasEstandarFundasTalla();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 
		try {			
			Query qry  = em.createQuery("select lef from LonjasEstandarFundasTalla lef " +
					" where lef.idlonjasestandarfundastallas =:id  ");
		
			qry.setParameter("id", id);
		 
			ep = (LonjasEstandarFundasTalla) qry.getSingleResult();
			
			return ep;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LonjasEstandarFundasTalla> getLonjasEstandarFundasTallaByTalla( String idtalla) {
	 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<LonjasEstandarFundasTalla> lista = new ArrayList<>(); 
		try {			
			Query qry  = em.createQuery("select lef from LonjasEstandarFundasTalla lef " +
					" where lef.idtalla =:id  ");
		
			qry.setParameter("id", idtalla);
			lista =   qry.getResultList();
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			 lista = new ArrayList<>(); 
			return lista;
		}finally{
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LonjasEstandarFundasTalla> getLonjasEstandarFundasTallaAll() {
	 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<LonjasEstandarFundasTalla> lista = new ArrayList<>(); 
		try {			
			Query qry  = em.createQuery("select lef from LonjasEstandarFundasTalla lef order by lef.idlonjasestandarfundastallas desc  ");
			lista =   qry.getResultList();
			 
		} catch (Exception e) {
			e.printStackTrace();
			 lista = new ArrayList<>(); 
			 return lista;
		}finally{
			em.close();
		}
		return lista;
	}

}
