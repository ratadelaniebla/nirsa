package com.nw.model.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.OeeDetalleParada;
import com.nw.model.dao.OeeDetalleParadaDAO;

public class OeeDetalleParadaDAOJpaImpl extends BaseDaoJpaImpl implements
		OeeDetalleParadaDAO {

	public OeeDetalleParadaDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	@Override
	public void saveOrUpdate(OeeDetalleParada oeeDetalleParada) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(oeeDetalleParada);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	public OeeDetalleParada saveOrUpdate2(OeeDetalleParada oeeDetalleParada) {
		EntityTransaction t = em.getTransaction();
		OeeDetalleParada odp = new OeeDetalleParada();
		try {
			t.begin();
			odp = em.merge(oeeDetalleParada);
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
			return null;
		} finally {
			em.close();
		}
		return odp;
	}

	@SuppressWarnings("unchecked")
	public List<OeeDetalleParada> getParadasEnCurso(int idproceso) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT odp ");
			sbuilder.append("FROM ProcesoAperturaCierre pac, OeeDetalleParada odp, OeeParada op ");
			sbuilder.append("WHERE pac.idprocesoaperturacierre = odp.procesoAperturaCierre.idprocesoaperturacierre ");
			sbuilder.append("AND odp.oeeParada.idOeeParada = op.idOeeParada ");
			sbuilder.append("AND pac.proceso.idproceso = :idproceso ");
			sbuilder.append("AND odp.fechaHoraFin IS NULL ");
			sbuilder.append("ORDER BY odp.fechaHoraInicio");
			return (List<OeeDetalleParada>) em.createQuery(sbuilder.toString())
					.setParameter("idproceso", idproceso).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OeeDetalleParada> findByIdPacAndIdProceso(Long idpac,
			int idproceso) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT odp ");
			sbuilder.append("FROM ProcesoAperturaCierre pac, OeeDetalleParada odp, OeeParada op ");
			sbuilder.append("WHERE pac.idprocesoaperturacierre = :idpac ");
			sbuilder.append("AND pac.proceso.idproceso = :idproceso ");
			sbuilder.append("AND pac.idprocesoaperturacierre = odp.procesoAperturaCierre.idprocesoaperturacierre ");
			sbuilder.append("AND odp.oeeParada.idOeeParada = op.idOeeParada ");
			sbuilder.append("ORDER BY odp.fechaHoraInicio");
			return (List<OeeDetalleParada>) em.createQuery(sbuilder.toString())
					.setParameter("idpac", idpac)//
					.setParameter("idproceso", idproceso)//
					.getResultList();
		} catch (Exception e) {
			em.close();
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OeeDetalleParada> getOeeDetalleParadaByIdPacAndIdProcesoAndFechaHoraInicio(
			Long idpac, int idproceso, Timestamp fechahorainicio) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT odp ");
			sbuilder.append("FROM ProcesoAperturaCierre pac, OeeDetalleParada odp, OeeParada op ");
			sbuilder.append("WHERE pac.idprocesoaperturacierre = :idpac ");
			sbuilder.append("AND pac.idproceso = :idproceso ");
			sbuilder.append("AND pac.idprocesoaperturacierre = odp.procesoAperturaCierre.idprocesoaperturacierre ");
			sbuilder.append("AND odp.oeeParada.idOeeParada = op.idOeeParada ");
			sbuilder.append("AND func('DATE', odp.fechaHoraInicio) = func('DATE', :fechahorainicio) ");
			sbuilder.append("ORDER BY odp.fechaHoraInicio");
			return (List<OeeDetalleParada>) em.createQuery(sbuilder.toString())
					.setParameter("idpac", idpac)//
					.setParameter("idproceso", idproceso)//
					.setParameter("fechahorainicio", fechahorainicio)//
					.getResultList();
		} catch (Exception e) {
			em.close();
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean delete(OeeDetalleParada oeeDetalleParada) {
		EntityTransaction t = em.getTransaction();
		boolean result;
		try {
			t.begin();
			OeeDetalleParada oeedp = em.find(OeeDetalleParada.class,
					oeeDetalleParada.getIdOeeDetalleParada());
			em.remove(oeedp);
			t.commit();
			result = true;
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			result = false;
		} finally {
			em.close();
		}
		return result;
	}

	
	/* 10-01-2018 Listado de Paradas por proceso_apertura_cierre   */
	@SuppressWarnings("unchecked")
	public List<OeeDetalleParada> getListaOeeDetalleParadaByIdpac(long idprocesoaperturacierre , int idlinea ) 
	{
		List<OeeDetalleParada> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			
		
		 Query qry  = em.createQuery("select ep from OeeDetalleParada ep , OeeDetalleParadaLimpieza odpl " +
									 " where ep.procesoAperturaCierre.idprocesoaperturacierre = :idpac " +
									 "  and  ep.idOeeDetalleParada = odpl.oeeDetalleParada.idOeeDetalleParada " +
									 "   and odpl.limpiezaLinea.idlimpiezalinea = :idline " +
									 " order by  ep.fechaHoraInicio asc ");
		
		 qry.setParameter("idpac",  idprocesoaperturacierre );
		 qry.setParameter("idline",  idlinea );
		  
		 lista = qry.getResultList();
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			em.close();
		}
		 
		return lista;
	}	
	
	@SuppressWarnings("unchecked")
	public List<OeeDetalleParada> getListaOeeDetalleParadaByIdpac(long idprocesoaperturacierre, long idoeedp ) //15823
	{
		List<OeeDetalleParada> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 
		 Query qry  = em.createQuery("select ep from OeeDetalleParada ep " +
				" where ep.procesoAperturaCierre.idprocesoaperturacierre = :idpac and ep.idOeeDetalleParada = :idoeedp" +
				" order by  ep.fechaHoraInicio asc ");
		
		 qry.setParameter("idpac",    idprocesoaperturacierre );
		 qry.setParameter("idoeedp",  idoeedp );
		  
		 lista = qry.getResultList();
		 em.close();
		return lista;
			 
	}	
	
	
	
	
}