package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.EspecialidadesIncidencia;
import com.nw.model.EspecialidadesIncidenciaEnlatado;
import com.nw.model.EspecialidadesProcesoEnlatado;
import com.nw.model.EspecialidadesProducto;
import com.nw.model.EspecialidadesReceta;
//import com.nw.model.EvisceradoProceso;
//import com.nw.model.LimpiezaProceso;
//import com.nw.model.ProcesoAperturaCierre;
//import com.nw.model.Produccion;
import com.nw.model.EspecialidadesProceso;
import com.nw.model.dao.EspecialidadesProcesoEnlatadoDAO;

public class EspecialidadesProcesoEnlatadoDAOJpaImpl extends BaseDaoJpaImpl
		implements EspecialidadesProcesoEnlatadoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public EspecialidadesProcesoEnlatadoDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	// select proceso_apertura_cierre from proceso_apertura_cierre,
	// limpieza_proceso
	// where proceso_apertura_cierre.idprocesoaperturacierre =
	// limpieza_proceso.idprocesoaperturacierre and
	// proceso_apertura_cierre.estado = 1
	/**
	 * Consulta a un objeto tipo ProcesoAperturaCierre con campo estado = 1
	 * (cruzando con la tabla: LimpiezaProceso) Nota.- Solo puede existir id de
	 * LimpiezaProceso activo, ya que la linea de trabaja un proceso a la vez
	 * 
	 * @return ProcesoAperturaCierre
	 */

	public List<EspecialidadesProceso> getSeleccionEspecialidadesProceso(
			Long paraidproducion) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			EspecialidadesProceso pac = new EspecialidadesProceso();
			Query query = em
					.createQuery("select ep from EspecialidadesProceso ep "
							+ " inner join ep.produccion pr where pr.idproduccion = :idpro and " +
							" ep.procesoAperturaCierre.estado = 1  ");
			query.setParameter("idpro", paraidproducion);

			return query.getResultList();

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	
	public List<EspecialidadesProducto> getSeleccionEspecialidadesProducto() {
		try {
			EspecialidadesProducto pac = new EspecialidadesProducto();
			Query query = em
					.createQuery("select ep from EspecialidadesProducto ep ");
			return query.getResultList();

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	public EspecialidadesReceta getSeleccionEspecialidadesReceta(Integer paraidproducion) {
		try {
			EspecialidadesReceta epre = new EspecialidadesReceta();
			Query query = em
					.createQuery(" Select er from EspecialidadesReceta er where  er.especialidadesProducto.idespecialidadesproducto= :idpro ");
			query.setParameter("idpro", paraidproducion);
			epre=(EspecialidadesReceta)query.getSingleResult();
			return epre;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	
	public List<EspecialidadesIncidencia> obtenerEspecidadesProceso() {
		List<EspecialidadesIncidencia> ep = new ArrayList<EspecialidadesIncidencia>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query qry = em
				.createQuery("select ei from EspecialidadesIncidencia ei ");
		
		ep = qry.getResultList();
		// System.out.println("EvisceradoProceso obteeenido " + ep.getId);

		return ep;

	}

	public EspecialidadesProceso obtenerActualizarEspecidadesProceso(long idproAC) {
		EspecialidadesProceso ep = new EspecialidadesProceso();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query qry = em
				.createQuery("select ep from EspecialidadesProceso ep  inner join ep.procesoAperturaCierre pac where pac.idprocesoaperturacierre= :idpro ");
		qry.setParameter("idpro", idproAC);
		ep = (EspecialidadesProceso) qry.getSingleResult();
		// System.out.println("EvisceradoProceso obteeenido " + ep.getId);

		return ep;

	}
	
	public EspecialidadesProcesoEnlatado obtenerEspecidadesProcesoEnlatado(
			Long idprocesoAperturaCierre) {
		EspecialidadesProcesoEnlatado ep = new EspecialidadesProcesoEnlatado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query qry = em
				.createQuery("select epe from EspecialidadesProcesoEnlatado epe "
						+ " inner join ep.procesoAperturaCierre pac "
						+ " where pac.idprocesoaperturacierre =:idpac ");

		qry.setParameter("idpac", idprocesoAperturaCierre);
		ep = (EspecialidadesProcesoEnlatado) qry.getSingleResult();
		System.out.println("EvisceradoProceso obteeenido "
				+ ep.getIdespecialidadesprocesollenado());

		return ep;

	}

	public EspecialidadesProcesoEnlatado obtenerNumeroLatas(
			Long paraidespecilidadProceso) {
		try {
			EspecialidadesProcesoEnlatado especilidadeproceso = new EspecialidadesProcesoEnlatado();
			Query query = em
					.createQuery(" SELECT epro FROM EspecialidadesProcesoEnlatado epro"
							+ " inner join epro.especialidadesProceso ep "
							+ " where ep.idespecialidadesproceso = :idpro  ");// .setParameter(0,
			query.setParameter("idpro", paraidespecilidadProceso);
			especilidadeproceso = (EspecialidadesProcesoEnlatado) query
					.getSingleResult();
			return especilidadeproceso;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	
	public EspecialidadesProcesoEnlatado obtenerMaxEspecialidadProcesoEnlatado() {
		long idp;
		try {
			EspecialidadesProcesoEnlatado especilidadeproceso = new EspecialidadesProcesoEnlatado();
			Query query = em
					.createNativeQuery(" select max(idespecialidadesprocesollenado) FROM especialidades_proceso_enlatado ");
			Object valorMaximoObjeto = query.getSingleResult();
			idp = (Long.valueOf((Long) valorMaximoObjeto));
			Query qry = em
					.createQuery(" SELECT epe FROM EspecialidadesProcesoEnlatado epe where epe.idespecialidadesprocesollenado= :idespecialidad " );
			qry.setParameter("idespecialidad", idp);
			especilidadeproceso = (EspecialidadesProcesoEnlatado) qry
					.getSingleResult();
			return especilidadeproceso;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	public List<EspecialidadesProducto> obtenerListaEspecialidadesProceso(
			Long paraidproducion) {
		try {
			List<EspecialidadesProducto> especilidadeproducto = new ArrayList<EspecialidadesProducto>();
			Query query = em
					.createQuery(" SELECT epro FROM EspecialidadesProducto epro"
							+ " inner join epro.especialidadesRecetas er "
							+ " inner join er.especialidadesProcesos ep "
							+ " inner join ep.produccion pr where pr.idproduccion = :idpro  ");// .setParameter(0,
																								// paraidproducion);

			query.setParameter("idpro", paraidproducion);
			especilidadeproducto = query.getResultList();
			return especilidadeproducto;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	

	public void guardarActualizarEspecialidadesProceso(EspecialidadesProceso ep) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(ep);// merge
			// obtengo y asigno el ultimo id ingresado en la tabla produccion

			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) { // isActive()
				t.rollback();
			}
		} finally {
			em.close();
		}

	}

	public void guardarActualizarEPE(EspecialidadesProcesoEnlatado epe) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(epe);// merge
			// obtengo y asigno el ultimo id ingresado en la tabla produccion

			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) { // isActive()
				t.rollback();
			}
		} finally {
			em.close();
		}

	} 

	public EspecialidadesIncidenciaEnlatado obtenerActualizarespecilidadIE(long paraidespecilidadProceso,long paraidproducion) {
		try {
			EspecialidadesIncidenciaEnlatado especilidadeproceso = new EspecialidadesIncidenciaEnlatado();
			Query query = em
					.createQuery(" SELECT eie FROM EspecialidadesIncidenciaEnlatado eie inner join eie.especialidadesProcesoEnlatado epe inner join epe.especialidadesProceso ep  inner join ep.produccion p WHERE epe.idespecialidadesprocesollenado= :paraidprocesoenlatado and eie.estado= 1 and p.idproduccion=:idpro ");
			query.setParameter("paraidprocesoenlatado", paraidespecilidadProceso);
			query.setParameter("idpro", paraidproducion);
			especilidadeproceso = (EspecialidadesIncidenciaEnlatado) query
					.getSingleResult();
			return especilidadeproceso;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	
	
	public void guardarActualizarespcialidadprocesoenlatado(
			EspecialidadesIncidenciaEnlatado eie) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(eie);// merge
			// obtengo y asigno el ultimo id ingresado en la tabla produccion

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
