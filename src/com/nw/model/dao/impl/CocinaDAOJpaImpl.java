package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Cocina;
import com.nw.model.Produccion;
 
import com.nw.model.dao.CocinaDAO;

public class CocinaDAOJpaImpl extends BaseDaoJpaImpl
		implements CocinaDAO {

	@SuppressWarnings("unchecked")
	/**
	 * METODO QUE OBTIENE LOS REGISTROS de LA TABLA eviscerado_pescados_lata
	 * @return
	 */
	@Override
	public List<Cocina> getCocinas() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Cocina> cocinas = new ArrayList<Cocina>();

		try {
			Query query = em
					.createQuery("select c from Cocina c ");
			cocinas = (List<Cocina>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return cocinas;
	}

	@Override
	public void saveOrUpdate(Cocina cocina) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(cocina);
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
	public List<Cocina> obtenerCocinas(Produccion idPro) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Cocina> cocinas = new ArrayList<Cocina>();

		try {
			Query query = em
					.createQuery("select c from Cocina c where c.idcocina NOT IN (select cc.cocina.idcocina from CocinaAperturaCierreDetalle " +
							" cc where cc.produccion=:prod and cc.estado in(1,2,3)  group by cc.cocina.idcocina )  order by c.idcocina");
			query.setParameter("prod", idPro);
			cocinas = (List<Cocina>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return cocinas;
	}	
	
}
