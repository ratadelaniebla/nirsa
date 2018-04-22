package com.nw.model.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.PedidoProduccionCabecera;
import com.nw.model.Produccion;
 

public class PedidoProduccionCabeceraDAOJpaImpl {

	public PedidoProduccionCabeceraDAOJpaImpl() {
		 
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoProduccionCabecera> getPedidoProduccionCabeceras(long idcab) 
	{ 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<PedidoProduccionCabecera> lista = new ArrayList<>();
		 try {
				Query qry = em.createQuery("select p from PedidoProduccionCabecera p " +
											 " order by p.idpedidoproduccioncabecera asc ");
				lista = (List<PedidoProduccionCabecera>) qry.getResultList();
			   
		 } catch (RuntimeException e) {
			 e.printStackTrace();
			return null;
		 }finally{
   			em.close();
   		 }
		return  lista;
	} 
	
	public PedidoProduccionCabecera getPedidoProduccionCabeceraByProduccion(Produccion produccion) 
	{ 
		PedidoProduccionCabecera pedidoProduccionCabecera = null;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 try {
				Query qry = em.createQuery("select p from PedidoProduccionCabecera p " +
											 " where p.produccion.idproduccion = :pro");
				qry.setParameter("pro", produccion.getIdproduccion() );
				pedidoProduccionCabecera = (PedidoProduccionCabecera) qry.getSingleResult();
			   
		 } catch (RuntimeException e) {
			return null;
		 }finally{
   			em.close();
   		 }
		return  pedidoProduccionCabecera;
	} 
	
	
	public PedidoProduccionCabecera saveOrUpdate(PedidoProduccionCabecera PedidoProduccionCabecera) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PedidoProduccionCabecera PedidoProduccionCabeceraDevuelto = null;
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				PedidoProduccionCabeceraDevuelto = em.merge(PedidoProduccionCabecera); 
				t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			PedidoProduccionCabeceraDevuelto = null;
			if (t.isActive()){    
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
		return PedidoProduccionCabeceraDevuelto;
	}
	
	
}
