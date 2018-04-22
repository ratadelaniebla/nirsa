package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EvisceradoCorte;

 
import com.nw.model.dao.CortesDAO;

public class CorteDAOJpaImpl extends BaseDaoJpaImpl implements CortesDAO {

	@SuppressWarnings("unchecked")
	/**
	 * METODO QUE OBTIENE LOS REGISTROS de LA TABLA eviscerado_pescados_lata
	 * @return
	 */
	@Override
	public List<EvisceradoCorte> getCortes() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoCorte> evisceradocrte = new ArrayList<EvisceradoCorte>();

		try {
			Query query = em
					.createQuery("select c from EvisceradoCorte c ");
			evisceradocrte = (List<EvisceradoCorte>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return evisceradocrte;
	}



}
