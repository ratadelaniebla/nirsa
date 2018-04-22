package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BiEstandarClasificacionTalla;
 
 

public class BiEstandarClasificacionTallaDAOJpaImpl {

	
	public BiEstandarClasificacionTallaDAOJpaImpl() {
	}
	
	
	@SuppressWarnings("unchecked")
	public List<BiEstandarClasificacionTalla> getBiEstandarClasificacionTallaAll() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<BiEstandarClasificacionTalla> lista = new ArrayList<>(); 
		try {			
			Query qry  = em.createQuery("select bi from BiEstandarClasificacionTalla bi order by bi.idbiestandarclasificaciontallas desc  ");
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
	
	public BiEstandarClasificacionTalla getBiEstandarClasificacionTallaByTallaAndLimpiezaTipo( int idtalla , int idlimpiezatipo){
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		BiEstandarClasificacionTalla biEstandarClasificacionTalla = null;
		 
		try {
			Query qry  = em.createQuery("select bi from BiEstandarClasificacionTalla bi " +
					"	where bi.talla.idtalla = :idtalla and bi.limpiezaTipo.idlimpiezatipo = :idlimpiezatipo  ");
			   qry.setParameter("idtalla", idtalla);
			   qry.setParameter("idlimpiezatipo", idlimpiezatipo);
			   biEstandarClasificacionTalla =   (BiEstandarClasificacionTalla) qry.getSingleResult();
			
		} catch (RuntimeException e) {
			 e.printStackTrace();
			 return null;
		} finally {
			em.close();
		}
		
		return biEstandarClasificacionTalla;
	}
	
	public BiEstandarClasificacionTalla saveOrUpdate(BiEstandarClasificacionTalla biEstandarClasificacionTalla){
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		BiEstandarClasificacionTalla biEstandarClasificacionTallaDevuelto = null;
		 
		try {
			t.begin();
			biEstandarClasificacionTallaDevuelto = em.merge(biEstandarClasificacionTalla);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		
		return biEstandarClasificacionTallaDevuelto;
	}
	
	
	public void saveNative(BiEstandarClasificacionTalla biEstandarClasificacionTalla) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction 	  t   = em.getTransaction();
		int 	id 			 = biEstandarClasificacionTalla.getIdbiestandarclasificaciontallas();
		int 	talla 		 = biEstandarClasificacionTalla.getTalla().getIdtalla(); 
		int 	limpiezatipo = biEstandarClasificacionTalla.getLimpiezaTipo().getIdlimpiezatipo();
		double  valor        = biEstandarClasificacionTalla.getValor();
		
	    String sql = " INSERT INTO bi_estandar_clasificacion_tallas( " +
	    			 "     idbiestandarclasificaciontallas, idtalla, idlimpiezatipo, valor)" +
	    			 "     VALUES (? , ? , ? , ? ) ;";
		try {
			 t.begin();
				 Query query  = em.createNativeQuery( sql );
				 query.setParameter(1, id);
				 query.setParameter(2, talla);
				 query.setParameter(3, limpiezatipo);
				 query.setParameter(4, valor);
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
	
	
}
