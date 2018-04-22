package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.RociadoDetalleProcesoCoche;
import com.nw.model.RociadoDetalleProcesoCocheTemperatura;
import com.nw.model.dao.RociadoDetalleProcesoCocheDAO;

public class RociadoDetalleProcesoCocheDAOJpaImpl extends BaseDaoJpaImpl implements RociadoDetalleProcesoCocheDAO {

	@SuppressWarnings("unchecked")
	public List<RociadoDetalleProcesoCoche> listaRociadoDetalleProcesoCoche(long idcoche)
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<RociadoDetalleProcesoCoche> lista = new ArrayList<RociadoDetalleProcesoCoche>();
		
		Query qry = em.createQuery("select coc from RociadoDetalleProcesoCoche coc " +
				"where coc.evisceradoDetalleProcesoCoche.codbarra = :idcoc and coc.evisceradoDetalleProcesoCoche.estadouso = 1 " +
				"and coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
				"and coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " );
				//"and coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche in (select rdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from RociadoDetalleProcesoCoche rdpc)");
//				" and " +
//				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
//				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");

		qry.setParameter("idcoc", idcoche);
//		qry.setParameter("idproduc", idprod);
//		qry.setParameter("idturn", idtur);

		lista =  qry.getResultList();

		return lista;
	}
	
	public void guardarRociadoDetalleProcesoCoche (RociadoDetalleProcesoCoche rociadoDetalleProcesoCoche)
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(rociadoDetalleProcesoCoche);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
	}
	
	public void guardarRociadoDetalleProcesoCocheTemperatura (RociadoDetalleProcesoCocheTemperatura rociadoDetalleProcesoCocheTemp)
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(rociadoDetalleProcesoCocheTemp);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
	}


	@Override
	public void saveorUpdate(
			RociadoDetalleProcesoCoche rociadoDetalleProcesoCoche) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> ListarRociadoDetalleProcesoCoche(Long valorCocheCodigoBarra)
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select r.evisceradoDetalleProcesoCoche from RociadoDetalleProcesoCoche r " +
/*HN				"where r.evisceradoDetalleProcesoCoche.codbarra = :idcoc "+
				" and r.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
				" and r.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " );*/
	 //"and r.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 ");

				"where r.evisceradoDetalleProcesoCoche.codbarra = :idcoc and r.evisceradoDetalleProcesoCoche.estadouso = 1 " +
				"order by r.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche desc  ");
	 
	 
	 qry.setParameter("idcoc", valorCocheCodigoBarra);
		lista =  qry.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> ListarRociadoDetalleProcesoCoche2(Long idevisceradodetalleprocesocoche)
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select r from RociadoDetalleProcesoCoche r " +
				"where r.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idcoc " );
			qry.setParameter("idcoc", idevisceradodetalleprocesocoche);
		lista =  qry.getResultList();
		return lista;
	}

	
 	public RociadoDetalleProcesoCoche getRociadoDetalleProcesoCoche(Long idevisceradodetalleprocesocoche)
	{
		RociadoDetalleProcesoCoche rdp = new RociadoDetalleProcesoCoche();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
		Query qry = em.createQuery("select r from RociadoDetalleProcesoCoche r " +
				"where r.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idcoc " );
			qry.setParameter("idcoc", idevisceradodetalleprocesocoche);
		
			 rdp =  (RociadoDetalleProcesoCoche) qry.getSingleResult();
			 return rdp;
		} catch (Exception e) {
			return null; 
		}
			
		
	}
	
	
}
