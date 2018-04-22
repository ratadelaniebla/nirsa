package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
 
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.dao.CocinaTrasladoCocheDAO;


/**
 * 
 * @author Carlos Holguin
 *
 */
public class CocinaTrasladoCocheDAOJpaImpl extends BaseDaoJpaImpl implements CocinaTrasladoCocheDAO{

	
	public CocinaTrasladoCocheDAOJpaImpl() {
	}
	
	public void AnularCocinas() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();

			Query qry = em
					.createNativeQuery("update cocina_apertura_cierre_detalle set estado =  -2 where estado = 1");
			qry.executeUpdate();

			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive())
				t.rollback();
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<CocinaAperturaCierreDetalle> getCocinasAperturaCierreDetallePorFechaProduccion(Long idproduccion) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();
		//List<CocinaAperturaCierreDetalle> listaresulatnte = new ArrayList<CocinaAperturaCierreDetalle>();

		Query query = em
				.createQuery("SELECT cacd FROM CocinaAperturaCierreDetalle cacd" +
			   		" where cacd.produccion.idproduccion = :idpro and cacd.estadococinada in (0,1) order by cacd.numerococinadageneral asc");  //order by cacd.cocina.idcocina asc);
		
		query.setParameter("idpro", idproduccion);
		

				 cocinasAperturaCierreDetalles = query.getResultList(); 
		
			
				 cocinasAperturaCierreDetalles = (List<CocinaAperturaCierreDetalle>)query.getResultList();
			 
		 return  cocinasAperturaCierreDetalles;
	}	
	

	@SuppressWarnings({ "unchecked" })
	public List<CocinaAperturaCierreDetalle> getCocinadasProduccion(Long idproduccion) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();
		//List<CocinaAperturaCierreDetalle> listaresulatnte = new ArrayList<CocinaAperturaCierreDetalle>();

		Query query = em
				.createQuery("SELECT cacd FROM CocinaAperturaCierreDetalle cacd" +
					" where cacd.produccion.idproduccion = :idpro order by cacd.numerococinadageneral desc");  //order by cacd.cocina.idcocina asc);
		
		query.setParameter("idpro", idproduccion);
		

				 cocinasAperturaCierreDetalles = query.getResultList(); 
		
			
				 cocinasAperturaCierreDetalles = (List<CocinaAperturaCierreDetalle>)query.getResultList();
			 
		 return  cocinasAperturaCierreDetalles;
	}	
	
	

	@SuppressWarnings({ "unchecked" })
	public List<CocinaAperturaCierreDetalle> getCocinadasFinalizadasPorProduccionesActivas() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();

		Query query = em
				.createQuery("SELECT cacd FROM CocinaAperturaCierreDetalle cacd" +
					" where cacd.produccion.estado = 1 and cacd.fechafincocinada is not null " +
					"and cacd.estadococinada = 2 " +
					"order by cacd.produccion.idproduccion desc, cacd.numerococinadageneral desc");  //order by cacd.cocina.idcocina asc);

				
				 cocinasAperturaCierreDetalles = query.getResultList(); 
		
			
				 cocinasAperturaCierreDetalles = (List<CocinaAperturaCierreDetalle>)query.getResultList();
			 
		 return  cocinasAperturaCierreDetalles;
	}	


	@SuppressWarnings({ "unchecked" })
	public List<CocinaAperturaCierreDetalle> getCocinadasFinalizadasxProcesosEvisceradoActivas() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();
/*		Query query = em
				.createQuery("SELECT cacd FROM CocinaAperturaCierreDetalle cacd" +
					" where cacd.produccion.evisceradoProcesos.procesoAperturaCierre.estado = 1 and cacd.fechafincocinada is not null " +
					"and cacd.estadococinada = 2 " +
					"order by cacd.produccion.idproduccion desc, cacd.numerococinadageneral desc");  //order by cacd.cocina.idcocina asc);
*/		
		Query query = em
				.createQuery("SELECT cacd FROM CocinaAperturaCierreDetalle cacd, Produccion p, EvisceradoProceso ep, ProcesoAperturaCierre pac" +
					" where cacd.produccion.idproduccion = p.idproduccion " +
					"and p.idproduccion = ep.produccion.idproduccion " +
					"and ep.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre " +
					"and pac.estado = 1 and cacd.fechafincocinada is not null " +
					"and cacd.estadococinada = 2 " +
					"order by p.idproduccion desc, cacd.numerococinadageneral desc");  //order by cacd.cocina.idcocina asc);
		
		
				 cocinasAperturaCierreDetalles = query.getResultList(); 
			
				 cocinasAperturaCierreDetalles = (List<CocinaAperturaCierreDetalle>)query.getResultList();
			 
		 return  cocinasAperturaCierreDetalles;
	}	
	
	
	
	@SuppressWarnings({ "unchecked" })
	public List<CocinaAperturaCierreDetalle> getCocinadasFinalizadasPorProduccionesActivasxLote(Long idevisdetpc) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();

		Query query = em
				.createQuery("SELECT cacd FROM EvisceradoDetalleProcesoCoche edpc, CocinaAperturaCierreDetalle cacd, EvisceradoDetalleProceso edp " +
					" where edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle " +
					" and edpc.evisceradoDetalleProceso.idevisceradodetalleproceso = edp.idevisceradodetalleproceso " +
					" and edp.idevisceradodetalleproceso = '" + idevisdetpc.toString() +"' " +
					" group by cacd.idcocinaaperturacierredetalle");  //order by cacd.cocina.idcocina asc);
		

				 cocinasAperturaCierreDetalles = query.getResultList(); 
		
			
				 cocinasAperturaCierreDetalles = (List<CocinaAperturaCierreDetalle>)query.getResultList();
			 
		 return  cocinasAperturaCierreDetalles;
	}	
	
	
	
	@SuppressWarnings({ "unchecked" })
	public List<CocinaAperturaCierreDetalle> getCocinadasFinalizadas() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();

		Query query = em
				.createQuery("SELECT cacd FROM CocinaAperturaCierreDetalle cacd" +
					" where cacd.produccion.estado = 1 " +
					"and cacd.estadococinada <> 2 " +
					"order by cacd.produccion.idproduccion desc, cacd.numerococinadageneral desc");  //order by cacd.cocina.idcocina asc);
		

				 cocinasAperturaCierreDetalles = query.getResultList(); 
		
			
				 cocinasAperturaCierreDetalles = (List<CocinaAperturaCierreDetalle>)query.getResultList();
			 
		 return  cocinasAperturaCierreDetalles;
	}	
	
	
//	@SuppressWarnings({ "unchecked", "unused" })
//	public List<Object> getCocinasAperturaCierreDetallePorFechaProduccion(Long idproduccion) {
//		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
//				.getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		
//		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();
//		 List<Object> listaresulatnte = new ArrayList<Object>();
//	 
//			   String consulta ="SELECT distinct cacd.cocina.idcocina FROM CocinaAperturaCierreDetalle cacd" +
//			   		" where cacd.produccion.idproduccion = :id order by cacd.cocina.idcocina asc";
//				 Query query = em.createQuery(consulta);
//				 query.setParameter("id", idproduccion);
//			
//				  listaresulatnte = (List<Object>)query.getResultList();
//			 
//		 return  listaresulatnte;
//	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CocinaAperturaCierreDetalle> getCocinasAperturaCierreDetallePorProduccionCocina(
			Long idproduccion, Long idcocina) {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();
		  
		//try {
			   String consulta ="SELECT cacd FROM CocinaAperturaCierreDetalle cacd" +
			   		" where cacd.produccion.idproduccion = :id and cacd.cocina.idcocina = :idcoc " +
			   		"order by cacd.idcocinaaperturacierredetalle asc";
				 Query query = em.createQuery(consulta);
				 query.setParameter("id", idproduccion);
				 query.setParameter("idcoc", idcocina);
				 cocinasAperturaCierreDetalles = query.getResultList(); 
			      
	
//			} finally {
//			   em.close();
//			   emf.close();
//			}
		return cocinasAperturaCierreDetalles;
	}
	
	
	
	
//	--3.- LISTA DE ORDEN: lleno la lista haciendo un filtrado 
//	   -- en la tabla eviscerado_detalle_proceso_coche 
//	   -- en base al idcocinaaperturacierredetalle escogido en el punto 2
//	   --agregar una secuencia de orden ej : 1234
	
//	SELECT idevisceradodetalleprocesocoche 
//	  FROM eviscerado_detalle_proceso_coche
//	  where idcocinaaperturacierredetalle = 1


	@SuppressWarnings("unchecked")
	@Override
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCochePorCocina(
			Long idcocinaaperturacierredetalle) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches = new ArrayList<EvisceradoDetalleProcesoCoche>();
		
		 String consulta ="SELECT edpc FROM EvisceradoDetalleProcesoCoche edpc" +
			   		" where edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :id  " +
			   		"order by edpc.idevisceradodetalleprocesocoche asc";
				 Query query = em.createQuery(consulta);
				 query.setParameter("id", idcocinaaperturacierredetalle);
				 evisceradoDetalleProcesoCoches = query.getResultList();
		
		return evisceradoDetalleProcesoCoches;
	}

	@Override
	public void saveOrUpdate(
			EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			 t.begin();
				em.merge(evisceradoDetalleProcesoCoche);
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}


@SuppressWarnings({ "unchecked" })
	public List<CocinaAperturaCierreDetalle> getCocinasAperturaCierreDetallePorFechaProduccion1(Long idproduccion) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();
		//List<CocinaAperturaCierreDetalle> listaresulatnte = new ArrayList<CocinaAperturaCierreDetalle>();

		Query query = em
				.createQuery("SELECT cacd FROM CocinaAperturaCierreDetalle cacd" +
			   		" where cacd.produccion.idproduccion = :idpro and cacd.estadococinada in (0,1,2) order by cacd.numerococinadageneral asc");  //order by cacd.cocina.idcocina asc);
		
		query.setParameter("idpro", idproduccion);
		

				 cocinasAperturaCierreDetalles = query.getResultList(); 
		
			
				 cocinasAperturaCierreDetalles = (List<CocinaAperturaCierreDetalle>)query.getResultList();
			 
		 return  cocinasAperturaCierreDetalles;
	}		
	
	
}
