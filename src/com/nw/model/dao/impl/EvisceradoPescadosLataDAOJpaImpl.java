package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EvisceradoPescadosLata;
 
import com.nw.model.dao.EvisceradoPescadosLataDAO;

public class EvisceradoPescadosLataDAOJpaImpl extends BaseDaoJpaImpl
		implements EvisceradoPescadosLataDAO {

	@SuppressWarnings("unchecked")
	/**
	 * METODO QUE OBTIENE LOS REGISTROS de LA TABLA eviscerado_pescados_lata
	 * @return
	 */
	@Override
	public List<EvisceradoPescadosLata> getEvisceradoPescadosLatas() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoPescadosLata> evisceradoPescadosLata = new ArrayList<EvisceradoPescadosLata>();

		try {
			Query query = em
					.createQuery("select epl from EvisceradoPescadosLata epl ");
			evisceradoPescadosLata = (List<EvisceradoPescadosLata>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return evisceradoPescadosLata;
	}

	@Override
	public void saveOrUpdate(EvisceradoPescadosLata evisceradoPescadosLata) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(evisceradoPescadosLata);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EvisceradoPescadosLata> getListaPescadosLatasxPeso(Double peso) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoPescadosLata> evisceradoPescadosLata = new ArrayList<EvisceradoPescadosLata>();
		try {
			Query query = em
					.createQuery("select epl from EvisceradoPescadosLata epl " +
							"where epl.idevisceradopescadoslata between " +
							"( select ecp1.evisceradoPescadosLata.idevisceradopescadoslata from EstandarClasificacionXPeso ecp1 " +
							" where ecp1.peso > :ppeso " +
							"order by ecp1.peso " +
							"limit 1 )" +
							"and " +
							"( select ecp2.evisceradoPescadosLata.idevisceradopescadoslata from EstandarClasificacionXPeso ecp1 " +
							" where ecp2.peso <= :ppeso " +
							"order by ecp2.peso desc " +
							"limit 1) ");
	          query.setParameter("ppeso", peso);
			evisceradoPescadosLata = (List<EvisceradoPescadosLata>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return evisceradoPescadosLata;
	}
	
	
}
