package com.nw.model.dao.impl;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.nw.model.EnvasadoFichaTecnica;
import com.nw.model.dao.EnvasadoFichaTecnicaDAO;

public class EnvasadoFichaTecnicaDAOJpaImpl extends BaseDaoJpaImpl
		implements EnvasadoFichaTecnicaDAO {

	private EntityTransaction t;

	public EnvasadoFichaTecnicaDAOJpaImpl() {
		t = em.getTransaction();
	}

	public EnvasadoFichaTecnica updateEnvasadoFichaTecnica(EnvasadoFichaTecnica envasadoFichaTecnica) {
		EnvasadoFichaTecnica eft = null;
		try {
			t.begin();
			eft = em.merge(envasadoFichaTecnica);
			t.commit();

			return eft;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	public EnvasadoFichaTecnica getByOrden(Integer idproducciondetalleorden) {
		try {
			String sql = "SELECT e FROM EnvasadoFichaTecnica e "
					+ "WHERE e.produccionDetalleOrden.idproducciondetalleorden = :idproducciondetalleorden " ;
			return (EnvasadoFichaTecnica) em
					.createQuery(sql)
					.setParameter("idproducciondetalleorden", idproducciondetalleorden)
					.getSingleResult();
		} catch( NoResultException e) {
			return new EnvasadoFichaTecnica();
		} catch( Exception e) {
			e.printStackTrace();
			return new EnvasadoFichaTecnica();
		}
	}
}
