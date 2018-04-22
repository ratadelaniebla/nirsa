package com.nw.model.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.PedidoProduccionDetalle;
import com.nw.model.PedidoProduccionCabecera;


public class PedidoProduccionDetalleDAOJpaImpl {

	public PedidoProduccionDetalleDAOJpaImpl() {
	}
	
	
	/* buscar el item detalle por el caajon y el registro */
	
	public PedidoProduccionDetalle getPedidoProduccionDetalleByCajonAndRegistro(String  idcajon , String registro) 
	{ 
		PedidoProduccionDetalle pedidoProduccionDetalle = null;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 try {
				Query qry = em.createQuery("select p from PedidoProduccionDetalle p " +
											 " where p.idcajon = :cajon and p.registro = :registro ");
				qry.setParameter("cajon",    idcajon );
				qry.setParameter("registro", registro );
				pedidoProduccionDetalle = (PedidoProduccionDetalle) qry.getSingleResult();
			   
		 } catch (RuntimeException e) {
			return null;
		 }finally{
   			em.close();
   		 }
		return  pedidoProduccionDetalle;
	} 
	
	public PedidoProduccionDetalle saveOrUpdate(PedidoProduccionDetalle pedidoProduccionDetalle ,PedidoProduccionCabecera pedidoProduccionCabecera) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PedidoProduccionDetalle PedidoProduccionDetalleDevuelto = null;
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				pedidoProduccionDetalle.setPedidoProduccionCabecera(pedidoProduccionCabecera);
				PedidoProduccionDetalleDevuelto = em.merge(pedidoProduccionDetalle); 
				t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			PedidoProduccionDetalleDevuelto = null;
			if (t.isActive()){    
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
		return PedidoProduccionDetalleDevuelto;
	}
	
}
