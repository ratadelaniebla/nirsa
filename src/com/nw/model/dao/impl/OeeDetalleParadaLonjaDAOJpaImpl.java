package com.nw.model.dao.impl;

import javax.persistence.EntityTransaction;

import com.nw.model.OeeDetalleParadaLonja;
import com.nw.model.dao.OeeDetalleParadaLonjasDAO;

public class OeeDetalleParadaLonjaDAOJpaImpl extends BaseDaoJpaImpl implements
		OeeDetalleParadaLonjasDAO {
	public OeeDetalleParadaLonjaDAOJpaImpl() {
	}

	@Override
	public OeeDetalleParadaLonja saveOrUpdate(OeeDetalleParadaLonja oeeDetalleParadaLonja) {
		EntityTransaction t = em.getTransaction();
		OeeDetalleParadaLonja oeeDetalleParadaLonjaNew = new OeeDetalleParadaLonja();
		try {
			t.begin();
			oeeDetalleParadaLonjaNew = em.merge(oeeDetalleParadaLonja);
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		return oeeDetalleParadaLonjaNew;
	}

	public boolean delete(OeeDetalleParadaLonja oeeDetalleParadaLonja) {
		EntityTransaction t = em.getTransaction();
		boolean result;
		try {
			t.begin();
			OeeDetalleParadaLonja odpl = em.find(OeeDetalleParadaLonja.class,
					oeeDetalleParadaLonja.getIdoeedetalleparadalonjas());
			em.remove(odpl);
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

	public OeeDetalleParadaLonja getByIdDetalleParada(Long idOeeDetalleParada) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT odpl ");
			sbuilder.append("FROM OeeDetalleParadaLonja odpl ");
			sbuilder.append("WHERE odpl.oeeDetalleParada.idOeeDetalleParada = :idOeeDetalleParada ");
			return (OeeDetalleParadaLonja) em.createQuery(sbuilder.toString())
					.setParameter("idOeeDetalleParada", idOeeDetalleParada)
					.getSingleResult();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
}