package com.nw.model.dao.impl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EsterilizadoCoche;

/**
 * Clase para manejar la Entidad EsterilizadoCoche
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-04-03
 */
public class EsterilizadoCocheDAOJpaImpl extends BaseDaoJpaImpl {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public EsterilizadoCocheDAOJpaImpl() {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public EsterilizadoCoche getEsterilizadoCocheById(Long id) {
		return em.find(EsterilizadoCoche.class, id);
    }
    
	public EsterilizadoCoche getEsterilizadoCocheByCodBarra(Long codBarra, Long idesterilizadoproceso) {

		try {
			
			Query query = em.createQuery("SELECT MIN(ec.fechareg) "
					+ "						FROM EsterilizadoCoche ec "
					+ "					   WHERE ec.codbarra =:codBarra "
					+ "						 AND ec.esterilizadoProceso.idesterilizadoproceso = :idesterilizadoproceso");
			query.setParameter("codBarra", codBarra);
			query.setParameter("idesterilizadoproceso", idesterilizadoproceso);
			
			Timestamp fechareg = (Timestamp)query.getSingleResult();
			
			query = em.createQuery("SELECT ec "
					+ "						FROM EsterilizadoCoche ec "
					+ "					   WHERE ec.codbarra =:codBarra "
					+ "						 AND ec.esterilizadoProceso.idesterilizadoproceso = :idesterilizadoproceso"
					+ "						 AND ec.fechareg = :fechareg");

			query.setParameter("codBarra", codBarra);
			query.setParameter("idesterilizadoproceso", idesterilizadoproceso);
			query.setParameter("fechareg", fechareg);
			
			return (EsterilizadoCoche) query.getSingleResult();
			
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}
    
	@SuppressWarnings("unused")
	public EsterilizadoCoche getEsterilizadoCoche(long codBarra, Integer idproducciondetalleorden) {
		try {
			Query query = em.createQuery("SELECT ec "
					+ "						FROM EsterilizadoCoche ec "
					+ "					   WHERE ec.codbarra =:codBarra "
					+ "						 AND ec.produccionDetalleOrden.idproducciondetalleorden = :idproducciondetalleorden");
			query.setParameter("codBarra", codBarra);
			query.setParameter("idproducciondetalleorden", idproducciondetalleorden);
			return (EsterilizadoCoche)query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
}
