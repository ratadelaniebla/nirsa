package com.nw.model.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LonjasProceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.dao.ProcesoAperturaCierreDAO;
import com.nw.model.dao.ProcesoAperturaCierreLimpiezaDAO;

//import com.nw.model.DescongeladoDetalleProceso;

public class ProcesoAperturaCierreLimpiezaDAOJpaImpl extends BaseDaoJpaImpl implements
ProcesoAperturaCierreLimpiezaDAO 
		{

	private EntityManagerFactory emf;
	private EntityManager em;

	public ProcesoAperturaCierreLimpiezaDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}


	public ProcesoAperturaCierre getSeleccionProcesoAperturaCierreLimpieza() {
		try {
			ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
			Query query = em
					.createQuery("select pac from ProcesoAperturaCierre pac, LimpiezaProceso lp "
							+ "where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");
			pac = (ProcesoAperturaCierre) query.getSingleResult();
			return pac;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	public LimpiezaProceso getSeleccionProcesoAperturaFechaProduccionActivaCierreLimpieza() {
		try {
			LimpiezaProceso lp = new LimpiezaProceso();
			Query query = em
					.createQuery("select lp from ProcesoAperturaCierre pac, LimpiezaProceso lp "
							+ "where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");
			lp = (LimpiezaProceso) query.getSingleResult();
			return lp;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
	}

	
	

	
	
	
	
	
	public ProcesoAperturaCierre getSeleccionProcesoAperturaCierre(String id) {
		try {
			ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
			Query query = em
					.createQuery("select pac from ProcesoAperturaCierre pac "
							+ "where pac.estado = 1 and pac.proceso.idproceso = 3 and "
							+ "pac.idprocesoaperturacierre in "
							+ "(select ep.procesoAperturaCierre.idprocesoaperturacierre from EvisceradoProceso ep where ep.produccion.idproduccion = '"
							+ id + "') ");
			pac = (ProcesoAperturaCierre) query.getSingleResult();
			return pac;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}


	
	
	
	public LimpiezaProceso getSeleccionProcesoAperturaCierrePorFechaTutno(String idfecha, String idturno) 
	{
		try {
			LimpiezaProceso pac = new LimpiezaProceso();
			Query query = em
					.createQuery("select lp from LimpiezaProceso lp  "
							+ "where lp.produccion.idproduccion = "+idfecha+" and lp.turno.idturno = "+idturno+"");
			pac = (LimpiezaProceso) query.getSingleResult();
			return pac;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	
	
	public ProcesoAperturaCierre getSeleccionProcesoAperturaCierreDescongelado(
			String id) {
		try {
			ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
			Query query = em
					.createQuery("select pac from ProcesoAperturaCierre pac "
							+ "where pac.estado = 1 and pac.proceso.idproceso = 5 and "
							+ "pac.idprocesoaperturacierre in "
							+ "(select ep.procesoAperturaCierre.idprocesoaperturacierre from DescongeladoProceso ep where ep.produccion.idproduccion = '"
							+ id + "') ");
			pac = (ProcesoAperturaCierre) query.getSingleResult();
			return pac;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	// public ProcesoAperturaCierre getSeleccionProcesoAperturaCierre(String id)
	// {
	// try {
	// ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
	// Query query = em.createQuery("select pac from ProcesoAperturaCierre pac "
	// +
	// "where pac.estado = 1 and pac.proceso.idproceso = 3 ");
	// pac = (ProcesoAperturaCierre) query.getSingleResult();
	// return pac;

	// } catch (Exception e) {
	// System.out.println("Error en el proceso --> " + e.getMessage());
	// return null;
	// }

	// " (select ep.procesoAperturaCierre.idprocesoaperturacierre from EvisceradoProceso ep where  )"
	// }

	// public ProcesoAperturaCierre getSeleccionProcesoAperturaCierre()
	// {
	// try {
	// ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
	// Query query = em.createQuery("select pac from ProcesoAperturaCierre pac "
	// +
	// "where pac.estado = 1 ");
	// pac = (ProcesoAperturaCierre) query.getSingleResult();
	// return pac;
	//
	// } catch (Exception e) {
	// System.out.println("Error en el proceso --> " + e.getMessage());
	// return null;
	// }
	//
	// }

	/**
	 * METODO QUE OBTIENE LA PRODUCCION ACTIVA DE LA TABLA
	 * proceso_apertura_cierre CON estado 1
	 * 
	 * @return
	 */
	public ProcesoAperturaCierre obtenerProduccionActiva() {
		ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			Query qry = em
					.createQuery("SELECT p FROM ProcesoAperturaCierre p where p.estado = 1");
			pac = (ProcesoAperturaCierre) qry.getSingleResult();
			// return pac;
		} catch (Exception e) {
			System.out.println("paso lo siguiente -->" + e.getMessage());
		}
		return pac;
	}

	public void guardarprocesoAperturaCierre(
			ProcesoAperturaCierre procesoAperturaCierre) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(procesoAperturaCierre);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public ProcesoAperturaCierre guardarAperturaCierre(
			ProcesoAperturaCierre procesoAperturaCierre) {
		ProcesoAperturaCierre loc_proceso = new ProcesoAperturaCierre();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			loc_proceso = em.merge(procesoAperturaCierre);
			t.commit();
			return loc_proceso;

		} catch (Exception e) {
			// TODO: handle exception
			return loc_proceso = null;
		}
	}

	public LonjasProceso obtenerProcesoAperturaLonjas() {
		try {
			LonjasProceso lp = new LonjasProceso();
			Query query = em
					.createQuery("select lp from LonjasProceso lp , ProcesoAperturaCierre pac  "
							+ "where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");
			lp = (LonjasProceso) query.getSingleResult();
			return lp;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	public ProcesoAperturaCierre obtenerProcesoAperturaCierreEspecialidades() {
		try {
			ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
			Query query = em
					.createQuery("select pac from ProcesoAperturaCierre pac, EspecialidadesProceso ep "
							+ "where pac.idprocesoaperturacierre = ep.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");
			pac = (ProcesoAperturaCierre) query.getSingleResult();
			return pac;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<ProcesoAperturaCierre> obtenerProcesoAperturaCierreEvicerado() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<ProcesoAperturaCierre> pacs = new ArrayList<ProcesoAperturaCierre>();
		try {
			// ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
			Query query = em
					.createQuery("select pac from ProcesoAperturaCierre pac "
							+ "where pac.proceso.idproceso = 3  and pac.estado = 1 ");
			pacs = query.getResultList();
			return pacs;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<LimpiezaProceso> getListaProcesosActivosLimpieza() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<LimpiezaProceso> pacs = new ArrayList<LimpiezaProceso>();
		try {
			// ProcesoAperturaCierre pac = new ProcesoAperturaCierre();

			/*
			 * select lp.* from proceso_apertura_cierre pac INNER JOIN
			 * limpieza_proceso lp on pac.idprocesoaperturacierre =
			 * lp.idprocesoaperturacierre where pac.estado = 1 ORDER BY
			 * lp.idproduccion
			 */

			Query query = em
					.createQuery("select lp from ProcesoAperturaCierre pac, LimpiezaProceso lp "
							+ "where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");

			pacs = query.getResultList();
			return pacs;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<LimpiezaProceso> getListaProcesosActivosUltimosLimpieza() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<LimpiezaProceso> pacs = new ArrayList<LimpiezaProceso>();
		try {
			// ProcesoAperturaCierre pac = new ProcesoAperturaCierre();

			/*
			 * select lp.* from proceso_apertura_cierre pac INNER JOIN
			 * limpieza_proceso lp on pac.idprocesoaperturacierre =
			 * lp.idprocesoaperturacierre where pac.estado = 1 ORDER BY
			 * lp.idproduccion
			 */

			Query query = em
					.createQuery("select lp from ProcesoAperturaCierre pac, LimpiezaProceso lp "
							+ "where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre "
							+ "order by lp.idlimpiezaproceso desc ");

			pacs = query.getResultList().subList(0, 30);
			return pacs;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}

	public ProcesoAperturaCierre getSeleccionProcesoAperturaCierreByFechaCierre(
			Timestamp fechacierre) {
		// TODO Auto-generated method stub
		return null;
	}

}
