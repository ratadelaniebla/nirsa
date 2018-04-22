package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.PedidoProduccionArchivoCargaCabecera;
import com.nw.model.PedidoProduccionArchivoCargaDetalle;


public class PedidoProduccionArchivoCargaDetalleDAOJpaImpl {

	public PedidoProduccionArchivoCargaDetalleDAOJpaImpl() {
	}
	
	
	/* buscar el item detalle por el caajon y el registro */
	
	public PedidoProduccionArchivoCargaDetalle getPedidoProduccionDetalleByCajonAndRegistro(String  idcajon , String registro) 
	{ 
		PedidoProduccionArchivoCargaDetalle pedidoProduccionDetalle = null;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 try {
				Query qry = em.createQuery("select p from PedidoProduccionArchivoCargaDetalle p " +
											 " where p.idcajon = :cajon and p.registro = :registro ");
				qry.setParameter("cajon",    idcajon );
				qry.setParameter("registro", registro );
				pedidoProduccionDetalle = (PedidoProduccionArchivoCargaDetalle) qry.getSingleResult();
			   
		 } catch (RuntimeException e) {
			 e.printStackTrace();
			return null;
		 }finally{
   			em.close();
   		 }
		return  pedidoProduccionDetalle;
	} 
	
	
	@SuppressWarnings("unchecked")
	public List<PedidoProduccionArchivoCargaDetalle> getPedidoProduccionCabeceraByCabecera(PedidoProduccionArchivoCargaCabecera pedidoProduccionCabecera) 
	{ 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<PedidoProduccionArchivoCargaDetalle> lista = new ArrayList<>();
		 try {
				Query qry = em.createQuery("select p from PedidoProduccionArchivoCargaDetalle p " +
											 " where p.pedidoProduccionArchivoCargaCabecera.idpedidoproduccionarchivocargacabecera =:idc");
				qry.setParameter("idc", pedidoProduccionCabecera.getIdpedidoproduccionarchivocargacabecera() );
				lista = (List<PedidoProduccionArchivoCargaDetalle>) qry.getResultList();
			   
		 } catch (RuntimeException e) {
			 e.printStackTrace();
			return null;
		 }finally{
   			em.close();
   		 }
		return  lista;
	} 
	
	public PedidoProduccionArchivoCargaDetalle saveOrUpdate(PedidoProduccionArchivoCargaDetalle pedidoProduccionDetalle ,PedidoProduccionArchivoCargaCabecera pedidoProduccionCabecera) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PedidoProduccionArchivoCargaDetalle PedidoProduccionDetalleDevuelto = null;
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				pedidoProduccionDetalle.setPedidoProduccionArchivoCargaCabecera(pedidoProduccionCabecera);
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
