package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Autoclave;
import com.nw.model.dao.AutoClaveDAO;


public class AutoClaveDAOJpaImpl extends BaseDaoJpaImpl implements AutoClaveDAO {
	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public AutoClaveDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public Autoclave getFindAutoClaveId(Integer vid) {
		return em.find(Autoclave.class, vid);	
	}
   
	@SuppressWarnings("unchecked")
	@Override
	public List<Autoclave> getFindAutoClaveAll() {
		return getObjects(Autoclave.class);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Autoclave> obtieneAutoClavesDisponibles(Long idproduccion) {
		String sql = "SELECT a "
				+ "FROM Autoclave a "
				+ "WHERE a.idautoclave NOT IN (SELECT epp.autoclave.idautoclave "
				+ "								 FROM EsterilizadoProcesoParada epp "
				+ "								WHERE epp.produccion.idproduccion = :idproduccion  "
				+ "								  AND epp.estado = 1 )"
				+ " ORDER BY a.idautoclave ";
		Query query = em.createQuery(sql).setParameter("idproduccion", idproduccion);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Autoclave> obtieneAutoClavesOcupados(Long idproduccion) {
		String sql = "SELECT a "
				+ "FROM Autoclave a "
				+ "WHERE a.idautoclave IN (SELECT epp.autoclave.idautoclave "
				+ "								 FROM EsterilizadoProcesoParada epp "
				+ "								WHERE epp.produccion.idproduccion = :idproduccion  "
				+ "								  AND epp.estado = 1 )"
				+ " ORDER BY a.idautoclave ";
		Query query = em.createQuery(sql).setParameter("idproduccion", idproduccion);
		return query.getResultList();
	}
	
}
