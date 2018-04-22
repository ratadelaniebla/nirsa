package com.nw.model.dao.impl;
 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
 
import com.nw.model.LonjasProceso;
import com.nw.model.LonjasProcesoEmpleado;
 
 

public class LonjasProcesoEmpleadoDAOJpaImpl extends BaseDaoJpaImpl {

 
	public LonjasProcesoEmpleadoDAOJpaImpl() {
	}

	
	 
	public LonjasProcesoEmpleado saveOrUpdate(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager 		 em   = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		LonjasProcesoEmpleado lonjasProcesoEmpleadoDevuelto = null;
		try {
			t.begin();
			lonjasProcesoEmpleadoDevuelto = em.merge(lonjasProcesoEmpleado);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return lonjasProcesoEmpleadoDevuelto;
	}
	
 
	  /* buscar emleado por ubicacion y linea  */
		public LonjasProcesoEmpleado getDatosEmpleadoByUbicacionAndLinea(LonjasProceso lproceso, int linea , int ubicacion) {
			LonjasProcesoEmpleado ep = new LonjasProcesoEmpleado();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			long idlproceso = lproceso.getIdlonjasproceso();
			try {			
				Query qry  = em.createQuery("select lpe from LonjasProcesoEmpleado lpe " +
						" where lpe.lonjasProceso.idlonjasproceso =:lp " +
						"    and lpe.lonjasLinea.idlonjaslinea =:idEmp" +
						"        and lpe.ubicacion =:ubicacion and lpe.idlonjascargo = 1 ");
			
				qry.setParameter("lp", idlproceso);
				qry.setParameter("idEmp", linea);
				qry.setParameter("ubicacion", ubicacion);
				ep = (LonjasProcesoEmpleado) qry.getSingleResult();
				
				return ep;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{
				em.close();
			}
		}
		
		public LonjasProcesoEmpleado getDatosEmpleadoByLonjasProcesoAndLinea(LonjasProceso lproceso, int linea ) {
			LonjasProcesoEmpleado ep = new LonjasProcesoEmpleado();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			long idlproceso = lproceso.getIdlonjasproceso();
			try {			
				Query qry  = em.createQuery("select lpe from LonjasProcesoEmpleado lpe " +
						" where lpe.lonjasProceso.idlonjasproceso =:lp " +
						"    and lpe.lonjasLinea.idlonjaslinea =:idline " +
						"        and lpe.idlonjascargo = 1 ");
				qry.setParameter("lp", idlproceso);
				qry.setParameter("idline", linea);
				ep = (LonjasProcesoEmpleado) qry.getSingleResult();
				
				return ep;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{
				em.close();
			}
		}
		
		
		@SuppressWarnings("unchecked")
		public List<LonjasProcesoEmpleado> getListaEmpleadoByLonjasProcesoAndLinea(LonjasProceso lproceso, int linea ) {
			List<LonjasProcesoEmpleado> lista = new ArrayList<>();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			long idlproceso = lproceso.getIdlonjasproceso();		
				try {
					Query qry  = em.createQuery("select lpe from LonjasProcesoEmpleado lpe " +
							" where lpe.lonjasProceso.idlonjasproceso =:lp " +
							"    and lpe.lonjasLinea.idlonjaslinea =:idline " +
							"        and lpe.idlonjascargo = 1 order by lpe.ubicacion asc "); //lpe.idlonjasprocesoempleado asc 
					
					qry.setParameter("lp", idlproceso);
					qry.setParameter("idline", linea);
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
		
		
		
		public LonjasProcesoEmpleado getDatosEmpleadoByUbicacionAndLonjasProceso(LonjasProceso lproceso,   int ubicacion) {
			LonjasProcesoEmpleado ep = new LonjasProcesoEmpleado();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			long idlproceso = lproceso.getIdlonjasproceso();
			try {			
				Query qry  = em.createQuery("select lpe from LonjasProcesoEmpleado lpe " +
						" where lpe.lonjasProceso.idlonjasproceso =:lp " +
						"        and lpe.ubicacion =:ubicacion and lpe.idlonjascargo = 1 ");
			
				qry.setParameter("lp", idlproceso);
				qry.setParameter("ubicacion", ubicacion);
				ep = (LonjasProcesoEmpleado) qry.getSingleResult();
				
				return ep;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{
				em.close();
			}
		}
	
	 

}
