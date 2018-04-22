package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.RackeoProcesoEmpleado;

public class RackeoProcesoEmpleadoDAOJpaImpl {

	
	public RackeoProcesoEmpleadoDAOJpaImpl() {
	}
	
	public RackeoProcesoEmpleado saveOrUpdate(RackeoProcesoEmpleado RackeoProcesoEmpleado) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		RackeoProcesoEmpleado RackeoProcesoEmpleadoDevuelto = null;
		try {
			t.begin();
			RackeoProcesoEmpleadoDevuelto = em.merge(RackeoProcesoEmpleado);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return RackeoProcesoEmpleadoDevuelto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<RackeoProcesoEmpleado> getListaEmpleadoPuestosActivosPorMesa(long idrackeoproceso, int idmesa) 
	{
		List<RackeoProcesoEmpleado> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
			try {
				 Query qry  = em.createQuery("select ep from RackeoProcesoEmpleado ep " +
						" where ep.rackeoProceso.idrackeoproceso = :idrackeo and ep.mesa = :idmesa and ep.estado = 1 " +
						" order by  ep.ubicacion ");
				
				 qry.setParameter("idrackeo",  idrackeoproceso );
				 qry.setParameter("idmesa",  idmesa );
				 lista = qry.getResultList();
				
				return lista;
			} catch (Exception e) {
				e.printStackTrace();
				lista = new ArrayList<>();
				return lista;
			}finally{
				em.close();
			}
	}	
	
	
}
