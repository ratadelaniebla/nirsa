package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProceso;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.dao.EsterilizadoDAO;

public class EsterilizadoDAOJpaImpl extends BaseDaoJpaImpl implements EsterilizadoDAO {

	

	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public EsterilizadoDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	/**
	 * se cambia metodo por obtenerProcesoAperturaEsterilizado() para agregar el idproceso 6
	 * @return
	 */
	@Deprecated
	public EsterilizadoProceso obtenerPanzasProcesoApertura() {
		try {
			EsterilizadoProceso lp = new EsterilizadoProceso();
			emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			em = emf.createEntityManager();
			Query query = em
					.createQuery("select pp from EsterilizadoProceso pp , ProcesoAperturaCierre pac  "
							+ "where pac.idprocesoaperturacierre = pp.procesoAperturaCierre.idprocesoaperturacierre "
							+ "and pac.estado = 1 ");
			lp = (EsterilizadoProceso) query.getSingleResult();
			return lp;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	
	/**
	 * obtiene el proceso aperturado para proceso esterilizado
	 * @param estado 1:Abierto	0:Cerrado
	 * @return
	 */
	public EsterilizadoProceso obtenerProcesoAperturaEsterilizado(Date fechareg, Integer idturno) {
		try {
			Query query = em
					.createQuery("SELECT pp FROM EsterilizadoProceso pp , ProcesoAperturaCierre pac "
							+ "WHERE pac.idprocesoaperturacierre = pp.procesoAperturaCierre.idprocesoaperturacierre "
							+ "AND pp.fechareg = :fechareg "
							+ "AND pp.turno.idturno = :idturno "
							+ "AND pac.proceso.idproceso = 6 ")
					.setParameter("fechareg", fechareg)
					.setParameter("idturno", idturno);
			return (EsterilizadoProceso) query.getResultList().get(0);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * obtiene el proceso aperturado para proceso esterilizado
	 * @param estado 1:Abierto	0:Cerrado
	 * @return
	 */
	public EsterilizadoProceso obtenerProcesoAperturaEsterilizadoAperturado() {
		try {
			Query query = em
					.createQuery("SELECT pp FROM EsterilizadoProceso pp , ProcesoAperturaCierre pac "
							+ "WHERE pac.idprocesoaperturacierre = pp.procesoAperturaCierre.idprocesoaperturacierre "
							+ "AND pac.estado = 1 "
							+ "AND pac.proceso.idproceso = 6 ");
			return  (EsterilizadoProceso) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return new EsterilizadoProceso();
		}
	}
	
	/**
	 * obtiene el proceso aperturado para proceso esterilizado
	 * @param estado 1:Abierto	0:Cerrado
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EsterilizadoProceso> obtenerProcesoAperturaEsterilizados(Integer estado) {
		try {
			Query query = em
					.createQuery("SELECT pp FROM EsterilizadoProceso pp , ProcesoAperturaCierre pac  "
							+ "WHERE pac.idprocesoaperturacierre = pp.procesoAperturaCierre.idprocesoaperturacierre "
							+ "AND pac.estado = :estado "
							+ "AND pac.proceso.idproceso = 6")
					.setParameter("estado", estado);
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<EsterilizadoProceso>();
		}
	}
	
	public EsterilizadoProcesoParadaCoche obtenerProcesoParadaCoche(Long ipProcesochoche) {
		try {
			EsterilizadoProcesoParadaCoche lp = new EsterilizadoProcesoParadaCoche();
			emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			em = emf.createEntityManager();
			Query query = em
					.createQuery("select pp from EsterilizadoProcesoParadaCoche pp "
							+ "where pp.esterilizadoCoche.idesterilizadocoche = :idPC ");
			query.setParameter("idPC", ipProcesochoche);
			lp = (EsterilizadoProcesoParadaCoche) query.getSingleResult();
			return lp;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	
	
	public EsterilizadoCoche obtenerEsterilizadoCoche(Long paraidpro,Integer paraturno) {
		try {
			emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT pp "
							+ "		FROM EsterilizadoCoche pp  "
							+ "		WHERE pp.idesterilizadocoche = (SELECT MAX(pac.idesterilizadocoche)"
							+ "										  FROM EsterilizadoCoche pac"
							+ "										 WHERE pac.turno.idturno= :turno"
							+ "										   AND pac.esterilizadoProceso.produccion.idproduccion= :idpro) ");
			query.setParameter("idpro", paraidpro);
			query.setParameter("turno", paraturno);
			return (EsterilizadoCoche) query.getSingleResult();

		} catch(NoResultException ne) {
			System.out.println("no hay registros....");
			return null;
		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<EsterilizadoCoche> obtenerListaCochesporProduccion(Long idproduccion) {
		try {
			Query qry = em.createQuery(" SELECT pop "
					+ "					   FROM EsterilizadoCoche pop "
					+ "					  WHERE pop.produccionDetalleOrden.produccion.idproduccion = :idproduccion "
					+ "					  ORDER BY pop.codbarra DESC");
			qry.setParameter("idproduccion", idproduccion);
			return qry.getResultList();
		} catch (NoResultException ne) {
			System.out.println("no hay resultado...");
			return new ArrayList<EsterilizadoCoche>();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<EsterilizadoCoche>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EsterilizadoCoche> obtenerListaCochesporProduccion(Long idproduccion, Integer idproducciondetalleorden) {
		try {
			Query qry = em.createQuery(" SELECT pop "
					+ "					   FROM EsterilizadoCoche pop "
					+ "					  WHERE pop.produccionDetalleOrden.produccion.idproduccion = :idproduccion "
					+ "					    AND pop.produccionDetalleOrden.idproducciondetalleorden = :idproducciondetalleorden "
					+ "					  ORDER BY pop.codbarra DESC");
			qry.setParameter("idproduccion", idproduccion);
			qry.setParameter("idproducciondetalleorden", idproducciondetalleorden);
			return qry.getResultList();
		} catch (NoResultException ne) {
			System.out.println("no hay resultado...");
			return new ArrayList<EsterilizadoCoche>();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<EsterilizadoCoche>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleOrden> obtenerListaClientesProduccionOrdenPedido(Long idproduccion, Integer idturno) {
		try {
			Query qry = em.createQuery("SELECT o "
					+ " FROM ProduccionDetalleOrden o "
					+ " WHERE o.idproducciondetalleorden in (SELECT DISTINCT p.produccionDetalleOrden.idproducciondetalleorden "
					+ "										   FROM EnvasadoDetalleProcesoCambio p "
					+ "										  WHERE p.produccionDetalleOrden.idproducciondetalleorden = (SELECT f.produccionDetalleOrden.idproducciondetalleorden "
					+ "				   																FROM EnvasadoControlPesoFillCabecera f "
					+ "																			   WHERE f.produccionDetalleOrden.idproducciondetalleorden = p.produccionDetalleOrden.idproducciondetalleorden)) "
					+ "AND o.produccion.idproduccion = :idproduccion " 
					+ "AND o.turno.idturno = :idturno " 
					+ "ORDER BY o.idproducciondetalleorden, o.cliente ")
					.setParameter("idproduccion", idproduccion)
					.setParameter("idturno", idturno);
			return qry.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<ProduccionDetalleOrden>();
		}
	}
	
	public void guardarActualizarEsterilizadoProceso(EsterilizadoProceso esteriProceso) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(esteriProceso);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	public EsterilizadoCoche guardarEsterilizadoCoche(EsterilizadoCoche esteriChoque) {
		EsterilizadoCoche ec;
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			ec = em.merge(esteriChoque);
			t.commit();
			return ec;
		} catch(Exception e) {
			e.printStackTrace();
			return new EsterilizadoCoche();
		} finally {
			if (t.isActive())
				t.rollback();
		}
	}
	
	public void guardarEsterilizadoProcesoParadaCoche(EsterilizadoProcesoParadaCoche esteriChoque) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(esteriChoque);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}
		
}
