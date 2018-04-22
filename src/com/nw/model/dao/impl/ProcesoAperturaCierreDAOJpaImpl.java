package com.nw.model.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EnvasadoProceso;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LonjasProceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.RackeoProceso;
import com.nw.model.dao.ProcesoAperturaCierreDAO;

//import com.nw.model.DescongeladoDetalleProceso;

public class ProcesoAperturaCierreDAOJpaImpl extends BaseDaoJpaImpl implements
		ProcesoAperturaCierreDAO {

	public ProcesoAperturaCierreDAOJpaImpl() {
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
			LimpiezaProceso pac = new LimpiezaProceso();
			Query query = em
					.createQuery("select lp from ProcesoAperturaCierre pac, LimpiezaProceso lp "
							+ "where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");
			pac = (LimpiezaProceso) query.getSingleResult();
			return pac;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			e.printStackTrace();
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

	// Adicionado por Manexware

	public ProcesoAperturaCierre getSeleccionProcesoAperturaCierreByFechaCierre(
			Timestamp fechacierre) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT pac ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, OeeDetalleParada odp, OeeParada op  ");
		sbuilder.append("WHERE pac.proceso.idproceso = 12 ");
		sbuilder.append("AND odp.fechahorafin = null ");
		sbuilder.append("AND pac.idprocesoaperturacierre = odp.procesoAperturaCierre.idprocesoaperturacierre ");
		sbuilder.append("AND odp.idoeeparada = op.idoeeparada ");

		return (ProcesoAperturaCierre) em.createQuery(sbuilder.toString())//
				.getSingleResult();
	}

	public void saveOrUpdate(ProcesoAperturaCierre procesoAperturaCierre) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(procesoAperturaCierre);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public ProcesoAperturaCierre getProcesoAperturaCierreById(long idproceso) {
		StringBuilder sbuilder = new StringBuilder();
		// try {
		sbuilder.append("SELECT pac ");
		sbuilder.append("FROM ProcesoAperturaCierre pac ");
		sbuilder.append("WHERE pac.idprocesoaperturacierre = :idproceso ");

		@SuppressWarnings("rawtypes")
		List list = em.createQuery(sbuilder.toString())
				.setParameter("idproceso", idproceso)//
				.getResultList();
		if (list == null || list.isEmpty())
			return null;
		else
			return (ProcesoAperturaCierre) list.get(0);
	}

	@SuppressWarnings("unchecked")
	public int countProcesoAperturaCierreByFechaAperturaAndIdProcesoAndIdTurnoo(
			Timestamp fechaapertura, Timestamp fechaaperturazero,
			int idproceso, int idturno) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT pac ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, RackeoProceso rp ");
		sbuilder.append("WHERE pac.proceso.idproceso =:idproceso ");
		sbuilder.append("AND pac.fechaapertura < :fechaapertura ");
		sbuilder.append("AND pac.fechaapertura > :fechaaperturazero ");
		sbuilder.append("AND rp.turno.idturno = :idturno ");
		sbuilder.append("AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");

		try {
			List<ProcesoAperturaCierre> result = (List<ProcesoAperturaCierre>) em
					.createQuery(sbuilder.toString())
					.setParameter("fechaapertura", fechaapertura)//
					.setParameter("fechaaperturazero", fechaaperturazero)//
					.setParameter("idproceso", idproceso)//
					.setParameter("idturno", idturno)//
					.getResultList();
			return result.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	/* Rackeo - turno */
	@SuppressWarnings("unchecked")
	public int countProcesoAperturaCierreByFechaAperturaAndIdProcesoAndIdTurnoRackeo(
			Timestamp fechaapertura, Timestamp fechaaperturazero,
			int idproceso, int idturno) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT pac ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, RackeoProceso rp ");
		sbuilder.append("WHERE pac.proceso.idproceso =:idproceso ");
		sbuilder.append("AND pac.fechaapertura < :fechaapertura ");
		sbuilder.append("AND pac.fechaapertura > :fechaaperturazero ");
		sbuilder.append("AND rp.turno.idturno = :idturno ");
		sbuilder.append("AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");

		try {
			List<ProcesoAperturaCierre> result = (List<ProcesoAperturaCierre>) em
					.createQuery(sbuilder.toString())
					.setParameter("fechaapertura", fechaapertura) 
					.setParameter("fechaaperturazero", fechaaperturazero) 
					.setParameter("idproceso", idproceso) 
					.setParameter("idturno", idturno) 
					.getResultList();
			return result.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	/* EnvasadoProceso - turno */
	@SuppressWarnings("unchecked")
	public int countProcesoAperturaCierreByFechaAperturaAndIdProcesoAndIdTurnoEnvasadoProceso(
			Timestamp fechaapertura, Timestamp fechaaperturazero,
			int idproceso, int idturno) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT pac ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, EnvasadoProceso rp ");
		sbuilder.append("WHERE pac.proceso.idproceso =:idproceso ");
		sbuilder.append("AND pac.fechaapertura < :fechaapertura ");
		sbuilder.append("AND pac.fechaapertura > :fechaaperturazero ");
		sbuilder.append("AND rp.turno.idturno = :idturno ");
		sbuilder.append("AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");

		try {
			List<ProcesoAperturaCierre> result = (List<ProcesoAperturaCierre>) em
					.createQuery(sbuilder.toString())
					.setParameter("fechaapertura", fechaapertura) 
					.setParameter("fechaaperturazero", fechaaperturazero) 
					.setParameter("idproceso", idproceso) 
					.setParameter("idturno", idturno) 
					.getResultList();
			return result.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	
	/* LonjasProceso - turno */
	@SuppressWarnings("unchecked")
	public int countProcesoAperturaCierreByFechaAperturaAndIdProcesoAndIdTurnoLonjasProceso(
			Timestamp fechaapertura, Timestamp fechaaperturazero,
			int idproceso, int idturno) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT pac ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, LonjasProceso rp ");
		sbuilder.append("WHERE pac.proceso.idproceso =:idproceso ");
		sbuilder.append("AND pac.fechaapertura < :fechaapertura ");
		sbuilder.append("AND pac.fechaapertura > :fechaaperturazero ");
		sbuilder.append("AND rp.turno.idturno = :idturno ");
		sbuilder.append("AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");

		try {
			List<ProcesoAperturaCierre> result = (List<ProcesoAperturaCierre>) em
					.createQuery(sbuilder.toString())
					.setParameter("fechaapertura", fechaapertura) 
					.setParameter("fechaaperturazero", fechaaperturazero) 
					.setParameter("idproceso", idproceso) 
					.setParameter("idturno", idturno) 
					.getResultList();
			return result.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	
	public RackeoProceso getProcesoAperturaCierreRackeoActivo() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT rp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, RackeoProceso rp ");
		sbuilder.append("WHERE pac.estado = 1 ");
		sbuilder.append("AND pac.proceso.idproceso = 12 ");
		sbuilder.append("AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");
		try {
			RackeoProceso rackeoProceso = (RackeoProceso) em.createQuery(
					sbuilder.toString()).getSingleResult();
			return rackeoProceso;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/* Si el metodo devuelve mas de uno entonces no se han cerrado los otros procesos aperturados*/
	@SuppressWarnings("unchecked")
	public List<RackeoProceso> getListaProcesoAperturaCierreRackeoActivo() {
		StringBuilder sbuilder = new StringBuilder();
		List<RackeoProceso> listaProcesos = new ArrayList<>();
		sbuilder.append("SELECT rp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, RackeoProceso rp ");
		sbuilder.append("WHERE pac.estado = 1 ");
		sbuilder.append("AND pac.proceso.idproceso = 12 ");
		sbuilder.append("AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");
		try {
			listaProcesos =   em.createQuery( sbuilder.toString()).getResultList();
			 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
		return listaProcesos;
	}
	
	
	/* Si el metodo devuelve mas de uno entonces no se han cerrado los otros procesos aperturados*/
	@SuppressWarnings("unchecked")
	public List<LonjasProceso> getListaProcesoAperturaCierreLonjasActivo() {
		StringBuilder sbuilder = new StringBuilder();
		List<LonjasProceso> listaProcesos = new ArrayList<>();
		sbuilder.append("SELECT rp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, LonjasProceso rp ");
		sbuilder.append("WHERE pac.estado = 1 ");
		sbuilder.append("AND pac.proceso.idproceso = 9 ");
		sbuilder.append(" AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");
		try {
			listaProcesos =   em.createQuery( sbuilder.toString()).getResultList();
			 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
		return listaProcesos;
	}
	
	//TODO metodo nuevo para req. NW-03 */
	public RackeoProceso getProcesoAperturaCierreRackeoActivoByFechaAndTurno(Timestamp fechaapertura, Integer idturno) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT rp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, RackeoProceso rp ");
		//sbuilder.append("WHERE pac.estado = 1 AND ");
		sbuilder.append("WHERE pac.proceso.idproceso = 12 ");
		sbuilder.append("AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre ");
		sbuilder.append("AND func('DATE', pac.fechaapertura) = func('DATE', :fecha) AND rp.turno.idturno =:iddeturno ");
		try {
			RackeoProceso rackeoProceso = (RackeoProceso) em.createQuery(
					sbuilder.toString())
					.setParameter("fecha", fechaapertura)
					.setParameter("iddeturno", idturno)
					.getSingleResult();
			return rackeoProceso;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	/* NW-10.1  obtener la fecha de labor  */
	public RackeoProceso getProcesoAperturaCierreRackeoActivoByFecha(Timestamp fechaapertura) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT rp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, RackeoProceso rp ");
		sbuilder.append("WHERE pac.estado = 1 ");
		sbuilder.append(" AND pac.proceso.idproceso = 12 AND func('DATE', pac.fechaapertura) = func('DATE', :fecha)");
		sbuilder.append(" AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");
		try {
			RackeoProceso rackeoProceso = (RackeoProceso) em.createQuery(
					sbuilder.toString())
					.setParameter("fecha", fechaapertura)
					.getSingleResult();
			return rackeoProceso;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}

	public ProcesoAperturaCierre getProcesoAperturaCierreRackeoByFechaAperturaAndTurno(
			String fechaapertura, Integer idturno) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT pac ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, RackeoProceso rp ");
		sbuilder.append("WHERE func('DATE', pac.fechaapertura) = func('DATE', :fechaapertura) ");
		sbuilder.append("AND rp.turno.idturno = :idturno ");
		sbuilder.append("AND pac.proceso.idproceso = 12 ");
		sbuilder.append("AND pac.idprocesoaperturacierre = rp.procesoAperturaCierre.idprocesoaperturacierre");
		System.out.println(String.format("%s - %s", fechaapertura.toString(),
				idturno));
		try {
			ProcesoAperturaCierre pac = (ProcesoAperturaCierre) em
					.createQuery(sbuilder.toString())//
					.setParameter("fechaapertura", fechaapertura)//
					.setParameter("idturno", idturno)//
					.getSingleResult();
			return pac;
		} catch (Exception e) {
			System.out
					.println("ProcesoAperturaCierreDAO --> " + e.getMessage());
			return null;
		}finally{
			em.close();
		}
	}
	
	
	public ProcesoAperturaCierre saveAndUpdate(
			ProcesoAperturaCierre procesoAperturaCierre) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		ProcesoAperturaCierre proceso = null;
		try {
			t.begin();
			proceso = em.merge(procesoAperturaCierre);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			
		}
		return proceso;	
	}

	public EnvasadoProceso getProcesoAperturaCierreEnvasadoActivo() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT ep ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, EnvasadoProceso ep ");
		sbuilder.append("WHERE pac.estado = 1 ");
		sbuilder.append("AND pac.proceso.idproceso = 13 ");
		sbuilder.append("AND pac.idprocesoaperturacierre = ep.procesoAperturaCierre.idprocesoaperturacierre");
		try {
			EnvasadoProceso envasadoProceso = (EnvasadoProceso) em.createQuery(
					sbuilder.toString()).getSingleResult();
			return envasadoProceso;
		} catch (Exception e) {
			return null;
		}finally{
			em.close();
		}
	}

	public LonjasProceso getProcesoAperturaCierreLonjasActivo() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT lp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, LonjasProceso lp ");
		sbuilder.append("WHERE pac.estado = 1 ");
		sbuilder.append("AND pac.proceso.idproceso = 9 ");
		sbuilder.append("AND pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre");
		try {
			LonjasProceso lonjasProceso = (LonjasProceso) em.createQuery(
					sbuilder.toString()).getSingleResult();
			return lonjasProceso;
		} catch (Exception e) {
			return null;
		}finally{
			em.close();
		}
	}
	
	//nuevo metodo para obtencion de lonjas proceso activo por turno y fecha
	public LonjasProceso getProcesoAperturaCierreLonjasActivoByTurno(Timestamp fechaapertura, Integer idturno) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT lp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, LonjasProceso lp ");
		//sbuilder.append("WHERE pac.estado = 1  AND");
		sbuilder.append("WHERE pac.proceso.idproceso = 9 ");
		sbuilder.append("AND pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre ");
		sbuilder.append(" AND func('DATE', pac.fechaapertura) = func('DATE', :fecha) AND lp.turno.idturno =:iddeturno ");
		
		try {
			LonjasProceso lonjasProceso = (LonjasProceso) em.createQuery(
					sbuilder.toString())
					.setParameter("fecha", fechaapertura)
					.setParameter("iddeturno", idturno)
					.getSingleResult();
			return lonjasProceso;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	//nuevo metodo para obtencion de Envasado Proceso activo por turno y fecha
	public EnvasadoProceso getProcesoAperturaCierreEnvasadoActivoByTurno(Timestamp fechaapertura, Integer idturno) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT lp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, EnvasadoProceso lp ");
		//sbuilder.append("WHERE pac.estado = 1  AND");
		sbuilder.append("WHERE pac.proceso.idproceso = 13 ");
		sbuilder.append("AND pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre ");
		sbuilder.append(" AND func('DATE', pac.fechaapertura) = func('DATE', :fecha) AND lp.turno.idturno =:iddeturno ");
		
		try {
			EnvasadoProceso envasadoProceso = (EnvasadoProceso) em.createQuery(
					sbuilder.toString())
					.setParameter("fecha", fechaapertura)
					.setParameter("iddeturno", idturno)
					.getSingleResult();
			return envasadoProceso;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	public ProcesoAperturaCierre getProcesoAperturaCierreByFechaAndTurno(Timestamp fechaapertura , int idturno , int idproceso) {  
		ProcesoAperturaCierre procesoAperturaCierre = null;
		 
		/*   ID DE PROCESOS   */
		/*   4   -> LIMPIEZA  */
		/*   9   -> LONJAS    */
		/*   12  -> RACKEO    */
		/*   13  -> ENVASADO  */        
		
		try {
			
			if (idproceso == 4) {
				
				String sql = "SELECT rp  " +
						"      FROM  LimpiezaProceso rp , ProcesoAperturaCierre pac  " +
						"    	WHERE rp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre" +
						"        AND pac.proceso.idproceso           =:idproce " +
						"    	 AND func('DATE', pac.fechaapertura) = func('DATE', :fecha) " +
						"	 	 AND rp.turno.idturno 				 =:iddeturno  "; 
				
				Query q1 =  em.createQuery(sql);
				      q1 .setParameter("idproce", idproceso);
				      q1 .setParameter("fecha", fechaapertura);
				      q1 .setParameter("iddeturno", idturno);
				      
				      procesoAperturaCierre =  ( ( LimpiezaProceso ) q1.getSingleResult() ).getProcesoAperturaCierre();
			}
			
			if (idproceso == 9) {
				
				String sql = "SELECT rp  " +
						"      FROM  LonjasProceso rp , ProcesoAperturaCierre pac  " +
						"    	WHERE rp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre" +
						"        AND pac.proceso.idproceso           =:idproce " +
						"    	 AND func('DATE', pac.fechaapertura) = func('DATE', :fecha) " +
						"	 	 AND rp.turno.idturno 				 =:iddeturno  "; 
				
				Query q1 =  em.createQuery(sql);
				      q1 .setParameter("idproce", idproceso);
				      q1 .setParameter("fecha", fechaapertura);
				      q1 .setParameter("iddeturno", idturno);
				      
				      procesoAperturaCierre =  ( ( LonjasProceso ) q1.getSingleResult() ).getProcesoAperturaCierre();
			}
			
			if (idproceso == 12) {
				
				String sql = "SELECT rp  " +
						"      FROM  RackeoProceso rp , ProcesoAperturaCierre pac  " +
						"    	WHERE rp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre " +
						"        AND pac.proceso.idproceso           =:idproce " +
						"    	 AND func('DATE', pac.fechaapertura) = func('DATE', :fecha) " +
						"	 	 AND rp.turno.idturno 				 =:iddeturno  " ;
						//"      order by rp.idrackeoproceso desc    ";
				
				Query q1 =  em.createQuery(sql);
				      q1 .setParameter("idproce", idproceso);
				      q1 .setParameter("fecha", fechaapertura);
				      q1 .setParameter("iddeturno", idturno);
				      
				      procesoAperturaCierre =  ( ( RackeoProceso ) q1.getSingleResult() ).getProcesoAperturaCierre();
			}
			
			if (idproceso == 13) {
				
				String sql = "SELECT rp  " +
						"      FROM  EnvasadoProceso rp , ProcesoAperturaCierre pac  " +
						"    	WHERE rp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre" +
						"        AND pac.proceso.idproceso           =:idproce " +
						"    	 AND func('DATE', pac.fechaapertura) = func('DATE', :fecha) " +
						"	 	 AND rp.turno.idturno 				 =:iddeturno  "; 
				
				Query q1 =  em.createQuery(sql);
				      q1 .setParameter("idproce", idproceso);
				      q1 .setParameter("fecha", fechaapertura);
				      q1 .setParameter("iddeturno", idturno);
				      
				      procesoAperturaCierre =  ( ( EnvasadoProceso ) q1.getSingleResult() ).getProcesoAperturaCierre();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
		return procesoAperturaCierre;
	}
	
	
	 
	
	
}
