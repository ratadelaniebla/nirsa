package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.OeeEnvasadoCabeceraVelocidadMaquinaCerradora;
 

public class OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDAOJpaImpl {

	
	public OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDAOJpaImpl() {
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradoras( long idprocesoaperturacierre  ) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
 
		List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> lista = new ArrayList<>();
		try {			
			 Query qry  = em.createQuery("select oed from OeeEnvasadoCabeceraVelocidadMaquinaCerradora oed " +
					" where oed.procesoAperturaCierre.idprocesoaperturacierre =:id and oed.fechaHoraFin is null " +
					"   order by oed.idOeeEnvasadoCabeceraVelocidadMaquinaCerradora asc  " );
			 qry.setParameter("id", idprocesoaperturacierre);
			 
			 lista = qry.getResultList();
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradorasAll( long idprocesoaperturacierre  ) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
 
		List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> lista = new ArrayList<>();
		try {			
			 Query qry  = em.createQuery("select oed from OeeEnvasadoCabeceraVelocidadMaquinaCerradora oed " +
					" where oed.procesoAperturaCierre.idprocesoaperturacierre =:id  " +
					"   order by oed.idOeeEnvasadoCabeceraVelocidadMaquinaCerradora asc  " );
			 qry.setParameter("id", idprocesoaperturacierre);
			 
			 lista = qry.getResultList();
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora saveOrUpdate(OeeEnvasadoCabeceraVelocidadMaquinaCerradora OeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		OeeEnvasadoCabeceraVelocidadMaquinaCerradora OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDevuelto = null;
		try {
			t.begin();
			OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDevuelto = em.merge(OeeEnvasadoCabeceraVelocidadMaquinaCerradora);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		return OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDevuelto;
	}
	
	
	
	
	
}
