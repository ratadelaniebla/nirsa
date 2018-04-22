package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.EspecialidadesProceso;
import com.nw.model.EspecialidadesIncidencia;
//import com.nw.model.EspecialidadesIncidencia;
//import com.nw.model.EspecialidadesIncidenciaEnlatado;
//import com.nw.model.EspecialidadesProcesoEnlatado;
//import com.nw.model.EspecialidadesProducto;
//import com.nw.model.EvisceradoProceso;
import com.nw.model.LimpiezaDetalleProcesoLote;
//import com.nw.model.LimpiezaProceso;
import com.nw.model.LonjasDetalleProcesoConteo;
import com.nw.model.LonjasDetalleProcesoLote;
import com.nw.model.LonjasEspecietalla;
import com.nw.model.LonjasProceso;
import com.nw.model.LonjasTunel;
//import com.nw.model.ProcesoAperturaCierre;
//import com.nw.model.Produccion;
//import com.nw.model.EspecialidadesProceso;
//import com.nw.model.dao.EspecialidadesProcesoEnlatadoDAO;

import com.nw.model.dao.LonjaDAO;

public class LonjasProcesoDAOJpaImpl extends BaseDaoJpaImpl implements LonjaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public LonjasProcesoDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	public List<LonjasProceso> obtenerSeleccionLonjasProceso(
			Long paraidproducion) {
		try {
			LonjasProceso pac = new LonjasProceso();
			Query query = em
					.createQuery("select ep from LonjasProceso ep "
							+ " inner join ep.produccion pr where pr.idproduccion = :idpro and ep.procesoAperturaCierre.estado = 1  ");
			query.setParameter("idpro", paraidproducion);

			return query.getResultList();

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

	public EspecialidadesProceso obtenerActualizarEspecidadesProceso(
			long idproAC) {
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

	public List<LimpiezaDetalleProcesoLote> obtenerListaLotesenLimpieza(Long paraIdpro,Integer paraTurno) {

		try {
			LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
			Query query = em
					.createQuery("select limdpl from LimpiezaDetalleProcesoLote limdpl  "
							+ " where limdpl.idlimpiezadetalleprocesolote NOT IN " +
							"  (Select ldp.limpiezaDetalleProcesoLote.idlimpiezadetalleprocesolote" +
							" from  LonjasDetalleProcesoLote ldp  where ldp.turno.idturno = :turno and ldp.estado=1) " +
							" AND limdpl.limpiezaProceso.produccion.idproduccion = :idpro" +
							" order by limdpl.produccionDetalleLote.idlote ");
			query.setParameter("turno", paraTurno);
			query.setParameter("idpro", paraIdpro);
			return query.getResultList();

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
		// List items = em.createQuery(sb.toString()).getResultList();
	}

	public List<LonjasDetalleProcesoLote> obtenerListaLotesenProcesoLonjas(
			Long paraidpro,Integer paraTurno) {

		try {
			LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
			Query query = em
					.createQuery("select ldp from LonjasDetalleProcesoLote ldp  "
							+ " inner join  ldp.lonjasProceso lp where lp.produccion.idproduccion = :idpro " +
							" and ldp.estado= 1 and ldp.turno.idturno= :turno");
			query.setParameter("idpro", paraidpro);
			query.setParameter("turno", paraTurno);
			return query.getResultList();

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
		// List items = em.createQuery(sb.toString()).getResultList();

	}

	public List<LonjasTunel> obtenerListaTunel() {

		try {
			LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
			Query query = em.createQuery("select ldp from LonjasTunel ldp  ");

			return query.getResultList();

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
		// List items = em.createQuery(sb.toString()).getResultList();

	}

	public LonjasDetalleProcesoLote obtenerLonjaDetpl(Long paraidpro,
			Integer praridLote) {

		try {
			LonjasDetalleProcesoLote let = new LonjasDetalleProcesoLote();

			LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
			Query query = em
					.createQuery("select ldp from LonjasDetalleProcesoLote ldp  "
							+ " where ldp.limpiezaDetalleProcesoLote.produccionDetalleLote.produccion.idproduccion = :idpro and ldp.limpiezaDetalleProcesoLote.produccionDetalleLote.idlote= :idlote ");
			query.setParameter("idpro", paraidpro);
			query.setParameter("idlote", praridLote);
			let = (LonjasDetalleProcesoLote) query.getSingleResult();
			return let;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
		// List items = em.createQuery(sb.toString()).getResultList();
	}

	public LonjasEspecietalla obtenerLonjaEspecietalla(Integer paraidpro) {

		try {
			LonjasEspecietalla let = new LonjasEspecietalla();

			LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
			Query query = em
					.createQuery("select ldp from LonjasEspecietalla ldp  "
							+ " where ldp.especieTalla.idespecietalla = :idpro ");
			query.setParameter("idpro", paraidpro);
			let = (LonjasEspecietalla) query.getSingleResult();
			return let;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
		// List items = em.createQuery(sb.toString()).getResultList();
	}

	public LonjasDetalleProcesoConteo obtenerNumCoche() {

		try {
			LonjasDetalleProcesoConteo let = new LonjasDetalleProcesoConteo();

			LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
			Query query = em
					.createQuery("select ldp from LonjasDetalleProcesoConteo ldp  "
							+ " where ldp.idlonjasdetalleprocesoconteo = (select max(ldpc.idlonjasdetalleprocesoconteo) from LonjasDetalleProcesoConteo ldpc)");

			let = (LonjasDetalleProcesoConteo) query.getSingleResult();
			return let;

		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;
		}
		// List items = em.createQuery(sb.toString()).getResultList();
	}

	public void guardarActualizarLonjasProcesoConteo(
			LonjasDetalleProcesoConteo ldpc) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(ldpc);// merge
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

	public void guardarActualizarLonjasProcesoLote(LonjasDetalleProcesoLote ldpl) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(ldpl);// merge
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

	public void guardarActualizarLonjasProceso(LonjasProceso lp) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(lp);// merge
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
	
	//metodo creados por el proveedor 
	@SuppressWarnings("finally")
	public LonjasProceso saveOrUpdate(LonjasProceso lonjasProceso) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		LonjasProceso proceso = null;
		try {
			t.begin();
			proceso = em.merge(lonjasProceso);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
			return proceso;
		}
	}
	
	public LonjasProceso getLonjasProcesoByIdAndStatus(int idproceso, int estado) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT lp ");
		sbuilder.append("FROM ProcesoAperturaCierre pac, LonjasProceso lp ");
		sbuilder.append("WHERE pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre ");
		sbuilder.append("AND pac.proceso.idproceso =:idproceso ");
		sbuilder.append("AND pac.estado =:estado");
		@SuppressWarnings("rawtypes")
		List list = em.createQuery(sbuilder.toString())
				.setParameter("idproceso", idproceso)//
				.setParameter("estado", estado)//
				.getResultList();
		if (list == null || list.isEmpty())
			return null;
		else
			return (LonjasProceso) list.get(0);
	}
	
	public LonjasProceso getLonjasProcesoAperturado() {
		return getLonjasProcesoByIdAndStatus(9, 1);
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
	
	@SuppressWarnings("unchecked")
	public List<LonjasProceso> getLonjasProcesoByIdProduccion(Long idproduccion) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT lp ");
			sbuilder.append("FROM LonjasProceso lp, ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE lp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			//sbuilder.append("AND lp.fechareg BETWEEN :param1 AND :param2 ");
			sbuilder.append("AND lp.produccion.idproduccion = :idproduccion ");
			return (List<LonjasProceso>) em.createQuery(sbuilder.toString()) 
					.setParameter("idproduccion", idproduccion) 
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			new LonjasProceso();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LonjasProceso> getLonjasProcesoByIdProduccionAndTurno(Long idproduccion, int idturno) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
		StringBuilder sbuilder = new StringBuilder();
		List<LonjasProceso> lista = new ArrayList<LonjasProceso>();
		
		try {
			sbuilder.append("SELECT lp ");
			sbuilder.append("FROM LonjasProceso lp, ProcesoAperturaCierre pac ");
			sbuilder.append("WHERE lp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			//sbuilder.append("AND lp.fechareg BETWEEN :param1 AND :param2 ");
			sbuilder.append("AND lp.produccion.idproduccion = :idproduccion ");
			sbuilder.append(" AND lp.turno.idturno = :idturno order by lp.fechareg desc ");
			
			Query q1 =  em.createQuery(sbuilder.toString());
		      q1.setParameter("idproduccion", idproduccion);
		      q1.setParameter("idturno",      idturno);
		      
		      lista =  (List<LonjasProceso>) q1.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			lista = new ArrayList<>();
		}
		return lista;	
	}
	



	/**
	 * Devuelve los ultimos N registros de rackeo 
	 * @fecha 30-10-2017 
	 * @param cantidad_registros
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<LonjasProceso> getLonjasProcesoAllDesc(int cantidad_registros ) {
		List<LonjasProceso>  lista = new ArrayList<>();
		try {
			String sql = "SELECT rp  " +
					"    FROM LonjasProceso rp, ProcesoAperturaCierre pac " +
					"    WHERE rp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre " +
					"    order by rp.idlonjasproceso desc    ";
			
			Query q1 =  em.createQuery(sql);
			      q1.setMaxResults(cantidad_registros);
					
			lista =  (List<LonjasProceso>) q1.getResultList();
					
		} catch (Exception e) {
			e.printStackTrace();
			lista = new ArrayList<>();
			return lista;
		}finally{
			em.close();
		}
		
		return lista;
	}

}
