package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Talla;
import com.nw.model.dao.TallaDAO;

public class TallaDAOJpaImpl extends BaseDaoJpaImpl implements TallaDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;
	
	public TallaDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
	}

	@Override
	public void saveOrUpdate(Talla talla) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(talla);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public Talla getById(int idtalla) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT t ");
			sbuilder.append("FROM Talla t ");
			sbuilder.append("WHERE t.idtalla = :idtalla ");
			return (Talla) em.createQuery(sbuilder.toString())
					.setParameter("idtalla", idtalla)//
					.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}finally{
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Talla> getTallas() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Talla> lista = new ArrayList<>();
		try {			
			 Query qry  = em.createQuery("select t from Talla t " +
					"   order by t.idtalla asc  " );
			 lista = qry.getResultList();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return lista;
		}finally{
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Talla> getTalla() {
		return em.createQuery("select et from Talla et where et.codigosaptalla='OK' order by et.idtalla").getResultList();
	}


}