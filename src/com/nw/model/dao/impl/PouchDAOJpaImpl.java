package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;

//import com.nw.model.EspecialidadesProceso;
import com.nw.model.EspecialidadesIncidencia;
//import com.nw.model.EspecialidadesIncidencia;
//import com.nw.model.EspecialidadesIncidenciaEnlatado;
//import com.nw.model.EspecialidadesProcesoEnlatado;
//import com.nw.model.EspecialidadesProducto;

import com.nw.model.LimpiezaDetalleProcesoLote;

//import com.nw.model.LonjasDetalleProcesoConteo;
//import com.nw.model.LonjasDetalleProcesoLote;
//import com.nw.model.LonjasEspecietalla;
//import com.nw.model.LonjasProceso;
//import com.nw.model.LonjasTunel;
import com.nw.model.PouchDetalleProcesoConteo;
import com.nw.model.PouchDetalleProcesoLote;
import com.nw.model.PouchProceso;

//import com.nw.model.EspecialidadesProceso;
//import com.nw.model.dao.EspecialidadesProcesoEnlatadoDAO;


import com.nw.model.dao.PouchDAO;

public class PouchDAOJpaImpl extends BaseDaoJpaImpl implements PouchDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public PouchDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	
	/**
	 * Consultas de Pouch
	 * @param ldpc
	 */
	public PouchProceso obtenerPouchProcesoApertura()
	{
		try {
			PouchProceso lp = new PouchProceso();
			Query query = em.createQuery("select lp from PouchProceso lp , ProcesoAperturaCierre pac  " +
					"where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");
			lp = (PouchProceso) query.getSingleResult();
			return lp;
			
		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;	
		}
		
	}
	
	public List<PouchProceso> obtenerListaOrdenProduccion(Long paraidpro) {

		try {
			PouchProceso pac = new PouchProceso();
			Query query = em.createQuery("Select pp from PouchProceso pp where pp.produccion.idproduccion = :idpro and " +
					" pp.procesoAperturaCierre.estado = 1 ");
			query.setParameter("idpro", paraidpro);
			return query.getResultList();

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}
	
	public LimpiezaDetalleProcesoLote obtenerLimpizaLote(Long paraidpro) {

		try {
			
			LimpiezaDetalleProcesoLote ldpl = new LimpiezaDetalleProcesoLote();
			Query query = em
					.createQuery("select ldp from LimpiezaDetalleProcesoLote ldp  "
							+ " where ldp.idlimpiezadetalleprocesolote = :idpro ");
			query.setParameter("idpro", paraidpro);
			ldpl = (LimpiezaDetalleProcesoLote) query.getSingleResult();
			return ldpl;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}

	public List<LimpiezaDetalleProcesoLote> obtenerListaLotesenLimpieza(Long paraIdpro,Integer paraTurno) {

		try {
			LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
			Query query = em
					.createQuery("select limdpl from LimpiezaDetalleProcesoLote limdpl  "
							+ " where limdpl.idlimpiezadetalleprocesolote NOT IN " +
							"  (Select pdp.limpiezaDetalleProcesoLote.idlimpiezadetalleprocesolote" +
							" from  PouchDetalleProcesoLote pdp where pdp.estado=1) " +
							" AND limdpl.limpiezaProceso.produccion.idproduccion = :idpro AND limdpl.turno.idturno = :turno" +
							" order by limdpl.produccionDetalleLote.idlote ");
			query.setParameter("turno", paraTurno);
			query.setParameter("idpro", paraIdpro);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}
	public List<Long> obtenerListaLotesenLimpiezadePouch(Long paraIdpro) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Long> listalotelong = new ArrayList<Long>();
		//List<LimpiezaDetalleProcesoLote> listalotelimp = new ArrayList<LimpiezaDetalleProcesoLote>();
		EntityTransaction t = em.getTransaction();
		try {
			
			Query query = em
					.createNativeQuery("select limpieza_detalle_proceso_lote.idlimpiezadetalleprocesolote" +
							" from limpieza_detalle_proceso_lote inner join limpieza_proceso on " +
							" (limpieza_detalle_proceso_lote.idlimpiezaproceso= limpieza_proceso.idlimpiezaproceso)" +
							"	where limpieza_detalle_proceso_lote.estado=1  and  limpieza_proceso.idproduccion = " + paraIdpro + " " +
							"	EXCEPT	SELECT	idlimpiezadetalleprocesolote from  pouch_detalle_proceso_lote" +
							"	inner join pouch_proceso on	(pouch_detalle_proceso_lote.idpouchproceso=pouch_proceso.idpouchproceso)" +
							"	where estado =1 and pouch_proceso.idproduccion = " + paraIdpro + " " );//setParameter(0, Long.valueOf(paraIdpro)).setParameter(1,Long.valueOf(paraIdpro));
			//query.setParameter("estado", paraEstado);
			//query.setParameter("idpro", paraIdpro);
			listalotelong =query.getResultList();
			return listalotelong;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
		
	}
	
	public List<PouchDetalleProcesoLote> obtenerListaLotesenProcesoPouch(
			Long paraidpro,Integer paraturno) {

		try {
			LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
			Query query = em
					.createQuery("select ldp from PouchDetalleProcesoLote ldp  "
							+ " inner join  ldp.pouchProceso lp where lp.produccion.idproduccion = :idpro " +
							" and ldp.estado= 1 and ldp.limpiezaDetalleProcesoLote.turno.idturno = :turno ");
			query.setParameter("idpro", paraidpro);
			query.setParameter("turno", paraturno);
			return query.getResultList();

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}
	
	public PouchDetalleProcesoLote obtenerPouchDetpl(Long paraidpro,
			Integer praridLote) {

		try {
			PouchDetalleProcesoLote let = new PouchDetalleProcesoLote();
		
			Query query = em
					.createQuery("select ldp from PouchDetalleProcesoLote ldp  "
							+ " where ldp.limpiezaDetalleProcesoLote.produccionDetalleLote.produccion.idproduccion = :idpro and ldp.limpiezaDetalleProcesoLote.produccionDetalleLote.idlote= :idlote ");
			query.setParameter("idpro", paraidpro);
			query.setParameter("idlote", praridLote);
			let = (PouchDetalleProcesoLote) query.getSingleResult();
			return let;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}
	public void guardarActualizarPouchProcesoConteo(PouchDetalleProcesoConteo Pdpc) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(Pdpc);// merge
			
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) { // isActive()
				t.rollback();

			}
		} finally {
			em.close();
		}
	}

	public PouchDetalleProcesoConteo obtenerNumCochePounch() {

		try {
			PouchDetalleProcesoConteo let = new PouchDetalleProcesoConteo();

			Query query = em
					.createQuery("select ldp from PouchDetalleProcesoConteo ldp  "
							+ " where ldp.idpouchdetalleprocesoconteo = (select max(ldpc.idpouchdetalleprocesoconteo) from PouchDetalleProcesoConteo ldpc)");

			let = (PouchDetalleProcesoConteo) query.getSingleResult();
			return let;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
		
	}
	
	public void guardarActualizarPouchProcesoLote(PouchDetalleProcesoLote ldpl) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.merge(ldpl);// merge
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) { // isActive()
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void guardarActualizarPouchAperturaCierre(PouchProceso lp) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(lp);// merge
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) { // isActive()
				t.rollback();

			}
		} finally {
			em.close();
		}

	}

}
