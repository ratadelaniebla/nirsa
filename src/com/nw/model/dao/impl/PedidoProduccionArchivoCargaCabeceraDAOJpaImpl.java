package com.nw.model.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.PedidoProduccionArchivoCargaCabecera;
import com.nw.model.Produccion;
 

public class PedidoProduccionArchivoCargaCabeceraDAOJpaImpl {

	public PedidoProduccionArchivoCargaCabeceraDAOJpaImpl() {
		 
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PedidoProduccionArchivoCargaCabecera> getPedidoProduccionCabeceraByFecha(Date fecha) 
	{ 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<PedidoProduccionArchivoCargaCabecera> lista = new ArrayList<>();
		 try {
				Query qry = em.createQuery("select p from PedidoProduccionArchivoCargaCabecera p " +
											 " where func('DATE', p.fechaarchivo) = :pro");
				qry.setParameter("pro", fecha );
				lista = (List<PedidoProduccionArchivoCargaCabecera>) qry.getResultList();
			   
		 } catch (RuntimeException e) {
			 e.printStackTrace();
			return null;
		 }finally{
   			em.close();
   		 }
		return  lista;
	} 
	
	
	public PedidoProduccionArchivoCargaCabecera getPedidoProduccionCabeceraByProduccion(Produccion produccion) 
	{ 
		PedidoProduccionArchivoCargaCabecera pedidoProduccionCabecera = null;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 try {
				Query qry = em.createQuery("select p from PedidoProduccionArchivoCargaCabecera p " +
											 " where p.produccion.idproduccion = :pro");
				qry.setParameter("pro", produccion.getIdproduccion() );
				pedidoProduccionCabecera = (PedidoProduccionArchivoCargaCabecera) qry.getSingleResult();
			   
		 } catch (RuntimeException e) {
			return null;
		 }finally{
   			em.close();
   		 }
		return  pedidoProduccionCabecera;
	} 
	
	
	public PedidoProduccionArchivoCargaCabecera saveOrUpdate(PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabeceraDevuelto = null;
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				pedidoProduccionArchivoCargaCabeceraDevuelto = em.merge(pedidoProduccionArchivoCargaCabecera); 
				t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			pedidoProduccionArchivoCargaCabeceraDevuelto = null;
			if (t.isActive()){    
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
		return pedidoProduccionArchivoCargaCabeceraDevuelto;
	}
	
	
}
