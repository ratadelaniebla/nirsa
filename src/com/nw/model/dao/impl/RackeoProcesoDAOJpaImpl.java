package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.nw.model.RackeoProceso;
import com.nw.model.dao.RackeoProcesoDAO;
import com.nw.util.Sistema;

public class RackeoProcesoDAOJpaImpl extends BaseDaoJpaImpl implements
		RackeoProcesoDAO {

	public RackeoProcesoDAOJpaImpl() {
	}

	@Override
	public void saveOrUpdate(RackeoProceso rackeoProceso) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(rackeoProceso);
			em.flush();
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public RackeoProceso getRackeoProcesoByIdTurno(Integer idturno) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT o ");
		sb.append("FROM RackeoProceso o ");
		sb.append("WHERE o.turno.idturno = :idturno ");

		@SuppressWarnings("rawtypes")
		List items = em.createQuery(sb.toString())//
				.setParameter("idturno", idturno)//
				.getResultList();

		if (items == null || items.isEmpty()) {
			return null;
		} else {
			return (RackeoProceso) items.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public List<RackeoProceso> getRackeoProcesoByIdProcesoAndEstado(
			int idproceso, int estado) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT rp ");
			sbuilder.append("FROM RackeoProceso rp, ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE rp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			sbuilder.append("AND pac.proceso.idproceso = :idproceso ");
			sbuilder.append("AND pac.estado = :estado ");
			return (List<RackeoProceso>) em.createQuery(sbuilder.toString())
					.setParameter("idproceso", idproceso) 
					.setParameter("estado", estado) 
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}

	public RackeoProceso getRackeoProcesoByIdPacAndIdTurno(
			Long idprocesoaperturacierre, Integer idturno) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT rp ");
			sbuilder.append("FROM RackeoProceso rp  ");
			sbuilder.append("WHERE rp.procesoAperturaCierre.idprocesoaperturacierre = :idpac ");
			sbuilder.append("AND rp.turno.idturno = :idturno ");
			return (RackeoProceso) em.createQuery(sbuilder.toString())
					.setParameter("idpac", idprocesoaperturacierre) 
					.setParameter("idturno", idturno) 
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}

	/*
	public RackeoProceso getRackeoProcesoByIdProduccion(Long idproduccion) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT rp ");
			sbuilder.append("FROM ProcesoAperturaCierre pac, RackeoProceso rp ");
			sbuilder.append("WHERE pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");
			sbuilder.append("AND pac.proceso.idproceso = :idproduccion ");
			sbuilder.append("AND pac.estado = 1 ");
			return (RackeoProceso) em.createQuery(sbuilder.toString())
					.setParameter("idproduccion", idproduccion)//
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			return null;
		}
	} */
	
	/**
	 * Devuelve un objeto RackeoProceso que esta aperturado
	 */
	@SuppressWarnings("unchecked")
	public RackeoProceso getRackeoProcesoActivo() {
		StringBuilder sbuilder = new StringBuilder();
		List<RackeoProceso> rackeos = new ArrayList<RackeoProceso>();
		RackeoProceso rp = new RackeoProceso();
		try {
			sbuilder.append("SELECT rp ");
			sbuilder.append("FROM RackeoProceso rp , ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre ");
			sbuilder.append("AND pac.proceso.idproceso = 12 ");
			sbuilder.append("AND pac.estado = 1 ");
			rackeos = em.createQuery(sbuilder.toString()).getResultList();
			  
			if (rackeos.size()==0) {
				rp = null;
			}
			
			if (rackeos.size()==1) {
				rp =  rackeos.get(0);
			}
			
			if (rackeos.size() > 1) {
				Sistema.mensaje("Existe mas de un proceso activo y deben cerrarse");
				rp =  null;
			}
			
			//return (RackeoProceso) em.createQuery(sbuilder.toString())
				//	.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
		
		return rp;
	}

	public RackeoProceso getRackeoProcesoByEstadoOne() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT rp ");
			sbuilder.append("FROM RackeoProceso rp ");
			sbuilder.append("WHERE rp.estado = 1 ");
			return (RackeoProceso) em.createQuery(sbuilder.toString())
					.getSingleResult();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	
	/**
	 * Devuelve los ultimos N registros de rackeo 
	 * @fecha 24-10-2017 
	 * @param cantidad_registros
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RackeoProceso> getRackeoProcesoAllDesc(int cantidad_registros ) {
		List<RackeoProceso>  lista = new ArrayList<>();
		try {
			String sql = "SELECT rp  " +
					"    FROM RackeoProceso rp, ProcesoAperturaCierre pac " +
					"    WHERE rp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre " +
					"    order by rp.idrackeoproceso desc    ";
			
			Query q1 =  em.createQuery(sql);
			      q1.setMaxResults(cantidad_registros);
					
			lista =  (List<RackeoProceso>) q1.getResultList();
					
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
