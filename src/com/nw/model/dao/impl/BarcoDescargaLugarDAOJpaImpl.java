package com.nw.model.dao.impl;

 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
 
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoDescargaLugar;
import com.nw.model.BarcoDescargaMedioTransporte;
 

public class BarcoDescargaLugarDAOJpaImpl {

	public BarcoDescargaLugarDAOJpaImpl() {
	}
	
	@SuppressWarnings("unchecked")
	public List<BarcoDescargaLugar> getBarcoDescargaAll(){ 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<BarcoDescargaLugar> lista = new ArrayList<>();
		 
			Query qry = em.createQuery("select bd from BarcoDescargaLugar bd order by bd.idbarcodescargalugar ");
			//qry.setParameter("idc", id );
			lista = (List<BarcoDescargaLugar>) qry.getResultList();
   			em.close();
   		 
		return  lista;
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<BarcoDescargaMedioTransporte> getBarcoDescargaMedioTransporteAll(){ 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<BarcoDescargaMedioTransporte> lista = new ArrayList<>();
		 
			Query qry = em.createQuery("select bd from BarcoDescargaMedioTransporte bd order by bd.idbarcodescargamediotransporte ");
			lista = (List<BarcoDescargaMedioTransporte>) qry.getResultList();
   			em.close();
   		 
		return  lista;
	} 

}
