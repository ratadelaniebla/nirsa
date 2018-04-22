package com.nw.model.dao.impl;

import javax.persistence.EntityTransaction;

import com.nw.model.OeeDetalleParadaEnvasado;
import com.nw.model.dao.OeeDetalleParadaEnvasadoDAO;

public class OeeDetalleParadaEnvasadoDAOJpaImpl extends BaseDaoJpaImpl
		implements OeeDetalleParadaEnvasadoDAO {

	public OeeDetalleParadaEnvasadoDAOJpaImpl() {
	}

	@Override
	public OeeDetalleParadaEnvasado saveOrUpdate(OeeDetalleParadaEnvasado oeeDetalleParadaEnvasado) {
		EntityTransaction t = em.getTransaction();
		OeeDetalleParadaEnvasado oeeDetalleParadaEnvasadoNew = new OeeDetalleParadaEnvasado();
		try {
			t.begin();
			oeeDetalleParadaEnvasadoNew = em.merge(oeeDetalleParadaEnvasado);
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
		return oeeDetalleParadaEnvasadoNew;
	}

	public boolean delete(OeeDetalleParadaEnvasado oeeDetalleParadaEnvasado) {
		EntityTransaction t = em.getTransaction();
		boolean result;
		try {
			t.begin();
			OeeDetalleParadaEnvasado edpe = em.find(
					OeeDetalleParadaEnvasado.class,
					oeeDetalleParadaEnvasado.getIdoeedetalleparadaenvasado());
			em.remove(edpe);
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

	public OeeDetalleParadaEnvasado getByIdDetalleParada(Long idOeeDetalleParada) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT odpe ");
			sbuilder.append("FROM OeeDetalleParadaEnvasado odpe ");
			sbuilder.append("WHERE odpe.oeeDetalleParada.idOeeDetalleParada = :idOeeDetalleParada ");
			return (OeeDetalleParadaEnvasado) em
					.createQuery(sbuilder.toString())
					.setParameter("idOeeDetalleParada", idOeeDetalleParada)
					.getSingleResult();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
			System.out.println(e.getMessage() + "idOeeDetalleParada ->"+idOeeDetalleParada);
			return null;
		}
	}

}