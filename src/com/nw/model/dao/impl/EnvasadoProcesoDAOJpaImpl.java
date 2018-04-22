package com.nw.model.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EnvasadoProceso;
import com.nw.model.dao.EnvasadoProcesoDAO;

public class EnvasadoProcesoDAOJpaImpl extends BaseDaoJpaImpl implements
		EnvasadoProcesoDAO {

	public EnvasadoProcesoDAOJpaImpl() {
	}

	public EnvasadoProceso getEnvasadoProcesoByIdTurno(Integer idturno) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT o ");
		sb.append("FROM EnvasadoProceso o ");
		sb.append("WHERE o.turno.idturno = '" + idturno + "'");

		@SuppressWarnings("rawtypes")
		List items = em.createQuery(sb.toString()).getResultList();

		if (items == null || items.isEmpty()) {
			return null;
		} else {
			return (EnvasadoProceso) items.get(0);
		}
	}

	public EnvasadoProceso getEnvasadoProcesoByEstado(Integer estado) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT o ");
		sb.append("FROM EnvasadoProceso o ");
		sb.append("WHERE o.estado = '" + estado + "'");

		@SuppressWarnings("rawtypes")
		List items = em.createQuery(sb.toString()).getResultList();

		if (items == null || items.isEmpty()) {
			return null;
		} else {
			return (EnvasadoProceso) items.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public EnvasadoProceso getEnvasadoProcesoByIdAndStatus(int idproceso, int estado) {
		
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EnvasadoProceso> envasadoProcesos = new ArrayList<>();
		
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT ep ");
		sbuilder.append("FROM EnvasadoProceso ep, ProcesoAperturaCierre pac ");
		sbuilder.append("WHERE pac.idprocesoaperturacierre = ep.procesoAperturaCierre.idprocesoaperturacierre ");
		sbuilder.append("AND pac.proceso.idproceso = :idproceso ");
		sbuilder.append("AND pac.estado =:estado ");

		envasadoProcesos = em.createQuery(sbuilder.toString())
				.setParameter("idproceso", idproceso) 
				.setParameter("estado", estado) 
				.getResultList();
		em.close();
		System.out.println("EnvasadoProcesos activos tamanio ->" +envasadoProcesos.size());
		if (envasadoProcesos == null || envasadoProcesos.isEmpty())
			return null;
		else
			return (EnvasadoProceso) envasadoProcesos.get(0);
	}

	public EnvasadoProceso getEnvasadoProcesoAperturado() {
		return getEnvasadoProcesoByIdAndStatus(13, 1);
	}

	@SuppressWarnings("finally")
	public EnvasadoProceso saveOrUpdate(EnvasadoProceso envasadoProceso) {
		EntityTransaction t = em.getTransaction();
		EnvasadoProceso proceso = null;
		try {
			t.begin();
			proceso = em.merge(envasadoProceso);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			return proceso;
		}
	}

	//mt
	@SuppressWarnings("unchecked")
	public List<EnvasadoProceso> getEnvasadoProcesoByStatus(int estado) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT lp ");
			sbuilder.append("FROM EnvasadoProceso ep, ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE ep.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			sbuilder.append("AND pac.estado = :estado ");
			return (List<EnvasadoProceso>) em.createQuery(sbuilder.toString())
					.setParameter("estado", estado)//
					.getResultList();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

	public EnvasadoProceso getEnvasadoProcesoByDateAndTurn( 
			Timestamp date, int turn) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("YYYY-mm-dd");
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT lp ");
			sbuilder.append("FROM EnvasadoProceso lp, ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE lp.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			sbuilder.append("AND lp.fechareg BETWEEN :param1 AND :param2 ");
			sbuilder.append("AND lp.turno.idturno =:turn ");
			String param1 = String.format("%s 00:00:00", sdFormat.format(date));
			String param2 = String.format("%s 23:59:59", sdFormat.format(date));
			return (EnvasadoProceso) em.createQuery(sbuilder.toString())//
					.setParameter("param1", param1)//
					.setParameter("param2", param2)//
					.setParameter("turn", turn)//
					.getResultList();
		} catch (Exception e) {
			em.close();
			new EnvasadoProceso();
			return null;
		}
	}

	/* correcion de este metodo */
	@SuppressWarnings("unchecked")
	public List<EnvasadoProceso> getEnvasadoProcesoByIdProduccion(
			Long idproduccion) {
		StringBuilder sbuilder = new StringBuilder();
		List<EnvasadoProceso> envasadoProcesos = new ArrayList<>();
		try {
			sbuilder.append("SELECT ep ");
			sbuilder.append("FROM EnvasadoProceso ep, ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE ep.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			//sbuilder.append("AND lp.fechareg BETWEEN :param1 AND :param2 ");
			sbuilder.append("AND ep.produccion.idproduccion = :idproduccion ");
			envasadoProcesos = (List<EnvasadoProceso>) em.createQuery(sbuilder.toString())
					.setParameter("idproduccion", idproduccion)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			em.close();
		}
		

		return envasadoProcesos;
	}
	
	/**
	 * Obtiene un proceso de envasado por fecha y turno siempre 
	 * relacionado con un proceso de apertura-cierre
	 * @param fechadate
	 * @param turno
	 * @return
	 */
	public EnvasadoProceso getEnvasadoProcesoByDateAndTurno(  Timestamp fechadate, int turno) {
		 
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT lp ");
			sbuilder.append("FROM EnvasadoProceso lp, ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE lp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			sbuilder.append("AND func('DATE', lp.fechareg) = func('DATE', :fecharegistro ) " );
			sbuilder.append("AND lp.turno.idturno =:turn ");
	 
			return (EnvasadoProceso) em.createQuery(sbuilder.toString()) 
					.setParameter("fecharegistro", fechadate) 
					.setParameter("turn", turno) 
					.getSingleResult();
		} catch (Exception e) {
		    e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	

	public EnvasadoProceso getEnvasadoProcesoSingleByIdProduccion(
			Long idproduccion) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT lp ");
			sbuilder.append("FROM EnvasadoProceso lp, ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE lp.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			sbuilder.append("AND pac.estado = 1 ");
			sbuilder.append("AND lp.idproduccion = :idproduccion ");
			return (EnvasadoProceso) em.createQuery(sbuilder.toString())//
					.setParameter("idproduccion", idproduccion)//
					.getSingleResult();
		} catch (Exception e) {
			em.close();
			new EnvasadoProceso();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoProceso> getEnvasadoProcesoByEstado(int estado) {
		
		String sql = "SELECT ep FROM EnvasadoProceso ep, ProcesoAperturaCierre pac" +
					 " WHERE ep.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre " +
					 " AND pac.estado = :estado  ";
		List<EnvasadoProceso> lista = em.createQuery(sql).setParameter("estado", estado).getResultList();
		em.close();
		return lista;
	}

}
