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

import com.nw.model.EvisceradoDetalleProceso;
//import com.nw.model.LonjasDetalleProcesoConteo;
//import com.nw.model.LonjasDetalleProcesoLote;
//import com.nw.model.LonjasEspecietalla;
//import com.nw.model.LonjasProceso;
//import com.nw.model.LonjasTunel;
import com.nw.model.PanzasDetalleProcesoConteo;
import com.nw.model.PanzasDetalleProcesoLote;
import com.nw.model.PanzasProceso;
//import com.nw.model.PouchDetalleProcesoConteo;
import com.nw.model.PouchDetalleProcesoLote;
import com.nw.model.PouchProceso;

//import com.nw.model.EspecialidadesProceso;
//import com.nw.model.dao.EspecialidadesProcesoEnlatadoDAO;

import com.nw.model.dao.PouchDAO;

public class PanzasDAOJpaImpl extends BaseDaoJpaImpl implements PouchDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public PanzasDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}


	public PanzasProceso obtenerPanzasProcesoApertura(Integer turno) {
		try {
			PanzasProceso lp = new PanzasProceso();
			Query query = em
					.createQuery("select pp from PanzasProceso pp , ProcesoAperturaCierre pac  "
							+ "where pac.idprocesoaperturacierre = pp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 " +
							" and pp.turno.idturno= :turno ");
			query.setParameter("turno", turno);
			lp = (PanzasProceso) query.getSingleResult();
			return lp;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	public List<PouchProceso> obtenerListaOrdenProduccion(Long paraidpro) {

		try {
			PouchProceso pac = new PouchProceso();
			Query query = em
					.createQuery("Select pp from PouchProceso pp where pp.produccion.idproduccion = :idpro ");
			query.setParameter("idpro", paraidpro);
			return query.getResultList();

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}

	public PanzasProceso obtenerPanzasProceso(Long paraidpro,Integer paraturno) {

		try {

			PanzasProceso edpl = new PanzasProceso();
			Query query = em
					.createQuery("select pp from PanzasProceso pp "
							+ " where  pp.produccion.idproduccion = :idpro and pp.turno.idturno= :turno ");
			query.setParameter("idpro", paraidpro);
			query.setParameter("turno", paraturno);	
			edpl = (PanzasProceso) query.getSingleResult();
			return edpl;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}

	
	public EvisceradoDetalleProceso obtenerEviceradoLote(Long paraidpro) {

		try {

			EvisceradoDetalleProceso edpl = new EvisceradoDetalleProceso();
			Query query = em
					.createQuery("select edp from EvisceradoDetalleProceso edp  "
							+ " where edp.idevisceradodetalleproceso = :idpro ");
			query.setParameter("idpro", paraidpro);
			edpl = (EvisceradoDetalleProceso) query.getSingleResult();
			return edpl;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}


	public List<EvisceradoDetalleProceso> obtenerListaLotesdeEvicerado(Long paraIdpro,Integer paraTurno) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoDetalleProceso> lista = new ArrayList<EvisceradoDetalleProceso>();

		EntityTransaction t = em.getTransaction();
		try {
			Query query = em.createQuery("select edp from EvisceradoDetalleProceso edp" +
					" where  edp.idevisceradodetalleproceso NOT IN  (select p.evisceradoDetalleProceso.idevisceradodetalleproceso" +
					" from	PanzasDetalleProcesoLote p where p.turno.idturno= :turno and p.estado=1)   AND edp.evisceradoProceso.produccion.idproduccion = :idpro " +
					" order by edp.produccionDetalleLoteCajon.produccionDetalleLote.idlote ");
					query.setParameter("turno", paraTurno);
					query.setParameter("idpro", paraIdpro);
			lista = query.getResultList();
			return lista;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}
	

	public List<PanzasDetalleProcesoLote> obtenerListaLotesenProcesoPanza(
			Long paraidpro,Integer paraturno) {

		try {
			PanzasDetalleProcesoLote pdl = new PanzasDetalleProcesoLote();
			Query query = em
					.createQuery("select pdp from PanzasDetalleProcesoLote pdp  "
							+ " inner join  pdp.panzasProceso lp where lp.produccion.idproduccion = " +
							" :idpro and pdp.estado= 1 and pdp.turno.idturno= :turno order " +
							" by pdp.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.idlote");
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

	public void guardarActualizarPanzasProcesoConteo(
			PanzasDetalleProcesoConteo Pdpc) {

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

	public PanzasDetalleProcesoConteo obtenerNumCochePanzas() {

		try {
			PanzasDetalleProcesoConteo pdpc = new PanzasDetalleProcesoConteo();

			Query query = em
					.createQuery("select pdp from PanzasDetalleProcesoConteo pdp  "
							+ " where pdp.idpanzasdetalleprocesoconteo = (select max(pdpc.idpanzasdetalleprocesoconteo) from PanzasDetalleProcesoConteo pdpc)");

			pdpc = (PanzasDetalleProcesoConteo) query.getSingleResult();
			return pdpc;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}

	public void guardarActualizarPanzasProcesoLote(PanzasDetalleProcesoLote pdpl) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			em.merge(pdpl);// merge
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) { // isActive()
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void guardarActualizarPanzasAperturaCierre(PanzasProceso lp) {

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
