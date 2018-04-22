package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Camara;
import com.nw.model.dao.CamaraDAO;


@SuppressWarnings("unchecked")
public class CamaraDAOJpaImpl extends BaseDaoJpaImpl implements CamaraDAO {

	@SuppressWarnings("unused")
	private static Log logger = LogFactory.getLog(CamaraDAOJpaImpl.class);

	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public CamaraDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	public List<Camara> getCamaras() {
		return em.createQuery("select c from Camara c order by c.descripcion ")
				.getResultList();
	}

	public List<Camara> getCamara() {
		return em.createQuery("select c from Camara c where c.idcamara <>99  and c.tipo=1 order by c.descripcion ")
				.getResultList();
	}
	
	
	@Override
	public void saveOrUpdate(Camara camara) {

	}

}
