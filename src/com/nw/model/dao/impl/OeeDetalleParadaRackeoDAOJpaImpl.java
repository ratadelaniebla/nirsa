package com.nw.model.dao.impl;

import javax.persistence.EntityTransaction;

import com.nw.model.OeeDetalleParadaRackeo;
import com.nw.model.dao.OeeDetalleParadaRackeoDAO;

public class OeeDetalleParadaRackeoDAOJpaImpl extends BaseDaoJpaImpl implements
		OeeDetalleParadaRackeoDAO {

	public OeeDetalleParadaRackeoDAOJpaImpl() {
	}

	@Override
	public void saveOrUpdate(OeeDetalleParadaRackeo oeeDetalleParadaRackeo) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(oeeDetalleParadaRackeo);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public OeeDetalleParadaRackeo findById(Long idOeeDetalleParada) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT odpr ");
			sbuilder.append("FROM OeeDetalleParadaRackeo odpr ");
			sbuilder.append("WHERE odpr.oeeDetalleParada.idOeeDetalleParada = :idOeeDetalleParada ");
			return (OeeDetalleParadaRackeo) em.createQuery(sbuilder.toString())//
					.setParameter("idOeeDetalleParada", idOeeDetalleParada)//
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
		
	}

	public boolean delete(OeeDetalleParadaRackeo oeeDetalleParadaRackeo) {
		EntityTransaction t = em.getTransaction();
		boolean result;
		try {
			t.begin();
			OeeDetalleParadaRackeo oeedpr = em.find(
					OeeDetalleParadaRackeo.class,
					oeeDetalleParadaRackeo.getIdoeedetalleparadarackeo());
			em.remove(oeedpr);
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

	public OeeDetalleParadaRackeo findByIdDescongeladoDetalleProceso(
			Long iddescongeladodetalleproceso) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT odpr ");
			sbuilder.append("FROM OeeDetalleParadaRackeo odpr ");
			sbuilder.append("WHERE odpr.descongeladoDetalleProceso.iddescongeladodetalleproceso = :iddescongeladodetalleproceso ");
			return (OeeDetalleParadaRackeo) em
					.createQuery(sbuilder.toString())
					//
					.setParameter("iddescongeladodetalleproceso",
							iddescongeladodetalleproceso)//
					.getSingleResult();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
}