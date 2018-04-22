package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.OeeEnvasadoDetalleVelocidadMaquinaCerradora;

public class OeeEnvasadoDetalleVelocidadMaquinaCerradoraDAOJpaImpl {

	
	public OeeEnvasadoDetalleVelocidadMaquinaCerradoraDAOJpaImpl() {
	}
	
	public OeeEnvasadoDetalleVelocidadMaquinaCerradora saveOrUpdate(OeeEnvasadoDetalleVelocidadMaquinaCerradora OeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		OeeEnvasadoDetalleVelocidadMaquinaCerradora OeeEnvasadoDetalleVelocidadMaquinaCerradoraDevuelto = null;
		try {
			t.begin();
			OeeEnvasadoDetalleVelocidadMaquinaCerradoraDevuelto = em.merge(OeeEnvasadoDetalleVelocidadMaquinaCerradora);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		return OeeEnvasadoDetalleVelocidadMaquinaCerradoraDevuelto;
	}
	
	@SuppressWarnings("unchecked")
	public List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradoras( int idcabecera  ) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
 
		List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> lista = new ArrayList<>();
		try {			
			Query qry  = em.createQuery("select oed from OeeEnvasadoDetalleVelocidadMaquinaCerradora oed " +
					" where oed.oeeEnvasadoCabeceraVelocidadMaquinaCerradora.idOeeEnvasadoCabeceraVelocidadMaquinaCerradora =:id " +
					"   order by oed.idOeeEnvasadoDetalleVelocidadMaquinaCerradora asc  " );
			qry.setParameter("id", idcabecera);
			 
			 lista = qry.getResultList();
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	public int eliminar(OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		int id = oeeEnvasadoDetalleVelocidadMaquinaCerradora.getIdOeeEnvasadoDetalleVelocidadMaquinaCerradora();
		int r = 0;
		try {
			t.begin();
			//Query query = em
			//		.createQuery("Delete from OeeEnvasadoDetalleVelocidadMaquinaCerradora where idOeeEnvasadoDetalleVelocidadMaquinaCerradora =:idoee");
			//query.setParameter("idoee", id);
			//query.executeUpdate();
			OeeEnvasadoDetalleVelocidadMaquinaCerradora def = em.find(
					OeeEnvasadoDetalleVelocidadMaquinaCerradora.class, id );
			em.remove(def);
			t.commit();
			r = 0;
		} catch (RuntimeException e) {
			if (t.isActive()) {
				e.printStackTrace();
				t.rollback();
			}
			r = 1;
		} finally {
			em.close();
		}
		return r;
	}

	
	/* buscar por la maquina cerradora y por el procesoaperturacierre */
	@SuppressWarnings("unchecked")
	public List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradorasByMaquinaAndProcesoApertura( 
			int idmaquinacerradora , Long idprocesoaperturacierre ) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
 
		List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> lista = new ArrayList<>();
		try {			
			Query qry  = em.createQuery("select oed from OeeEnvasadoDetalleVelocidadMaquinaCerradora oed " +
					" where oed.oeeEnvasadoCabeceraVelocidadMaquinaCerradora.procesoAperturaCierre.idprocesoaperturacierre =:idpac" +
					"  and oed.oeeEnvasadoCabeceraVelocidadMaquinaCerradora.maquinaCerradora.idmaquinacerradora =:idmaquina " +
					"   order by oed.idOeeEnvasadoDetalleVelocidadMaquinaCerradora asc  " );
			qry.setParameter("idpac", idprocesoaperturacierre  );
			qry.setParameter("idmaquina", idmaquinacerradora);
			 
			 lista = qry.getResultList();
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}

	
}
