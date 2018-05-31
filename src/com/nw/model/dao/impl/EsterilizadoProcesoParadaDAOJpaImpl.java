package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EsterilizadoProcesoParada;

/**
 * Clase para manejar la Entidad EsterilizadoProcesoParada
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-03-24, 25, 31
 */
@SuppressWarnings("unchecked")
public class EsterilizadoProcesoParadaDAOJpaImpl extends BaseDaoJpaImpl {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

	public EsterilizadoProcesoParadaDAOJpaImpl() {
		//TODO: 0 TEST DEFINITIVO, ALTERNANDO EL emf
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		//emf = Persistence.createEntityManagerFactory("NW");
        em = emf.createEntityManager();
	}

	/**
	 * Obtiene la siguiente parada del autoclave especificado...
	 * @param idproduccion
	 * @param autoclaveId
	 * @return
	 */
	public Integer getSiguienteParada(Long idproduccion, Integer autoclaveId){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT MAX(e.numparada) FROM EsterilizadoProcesoParada e ");
		sb.append(String.format("WHERE e.produccion.idproduccion = %s ", idproduccion) );
		sb.append(String.format("AND e.autoclave.idautoclave = %s ", autoclaveId));
		Integer resultado = (Integer) em.createQuery(sb.toString()).getSingleResult(); 
		return resultado==null ? 1: resultado+1;
	}
	
	/**
	 * Obtiene un objeto EsterilizadoProcesoParada según los parámetros especificados
	 * @param esterilizadoProcesoId
	 * @param autoclaveId
	 * @return
	 */
	public EsterilizadoProcesoParada getEsterilizadoProcesoParada(Long idproduccion, Integer autoclaveId){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT e FROM EsterilizadoProcesoParada e ");
		sb.append(String.format("WHERE e.produccion.idproduccion = %s ", idproduccion) );
		sb.append(String.format("AND e.autoclave.idautoclave = %s ", autoclaveId));
		sb.append("AND e.estado = 1 ");
		List <EsterilizadoProcesoParada>items = em.createQuery(sb.toString()).getResultList();
		return ( items == null || items.isEmpty() ) ? null: (EsterilizadoProcesoParada) items.get(0);
	}
	
	public List<EsterilizadoProcesoParada> getEsterilizadoProcesoParada(){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT e FROM EsterilizadoProcesoParada e ");
		sb.append("WHERE e.estado = 1 ");
		sb.append("ORDER BY e.autoclave.descripcion ");
		List <EsterilizadoProcesoParada>items = em.createQuery(sb.toString()).getResultList();
		return ( items == null || items.isEmpty() ) ? null:items;
	}
	
	public List<EsterilizadoProcesoParada> getEsterilizadoProcesoParada(Long idproduccion){
		String sb = new StringBuilder()
				.append("SELECT e FROM EsterilizadoProcesoParada e ")
				.append(String.format("WHERE e.produccion.idproduccion = %s ", idproduccion))
				.append("AND e.estado = 1 ")
				.append("ORDER BY e.autoclave.descripcion ")
				.toString();
		List <EsterilizadoProcesoParada>items = em.createQuery(sb).getResultList();
		return ( items == null || items.isEmpty() ) ? null:items;
	}
	
	/**
	 * Se agrego consulta para alzar ambiente de EsterilizadoPareturaCierre
	 * @autor Cls MBaque
	 * @param estado : 1-abierto, 0-cerrado
	 * @return
	 */
	public List<EsterilizadoProcesoParada> obtenerProduccionEsterilizado(Integer estado, Integer limit) {
		try {
			String sqlDistinct = "SELECT DISTINCT e.produccion.idproduccion "
					+ "FROM EsterilizadoProcesoParada e "
					+ "ORDER BY e.idesterilizadoprocesoparada DESC";
			
			String sqlMax = "SELECT MAX ( lc.idesterilizadoprocesoparada ) "
					+ "	FROM EsterilizadoProcesoParada lc "
					+ "	WHERE lc.produccion.idproduccion = :idDistinctProduccion "
					+ "	GROUP BY lc.produccion.idproduccion "
					+ "	ORDER BY 1 DESC";
			String sqlEsterilizadoProcesoParada = "SELECT l FROM EsterilizadoProcesoParada l WHERE l.idesterilizadoprocesoparada = :lSqlMax";
			
			List<Long> lista = em.createQuery(sqlDistinct).getResultList();
			List<Long> listSqlDistinctProduccion = lista.subList(0, lista.size()<limit?lista.size():limit);
			List<Long> listSqlMax = new ArrayList<Long>();
			List<EsterilizadoProcesoParada> listEsterilizadoProcesoParada = new ArrayList<EsterilizadoProcesoParada>();
			
			for (Long idDistinctProduccion : listSqlDistinctProduccion)
				listSqlMax.add((Long)em.createQuery(sqlMax).setParameter("idDistinctProduccion", idDistinctProduccion).getResultList().get(0));
			
			for (Long lSqlMax : listSqlMax)
				listEsterilizadoProcesoParada.add((EsterilizadoProcesoParada)em.createQuery(sqlEsterilizadoProcesoParada).setParameter("lSqlMax", lSqlMax).getResultList().get(0));


			return listEsterilizadoProcesoParada;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<EsterilizadoProcesoParada>();
		}
	}
	
	/**
	 * Grabar una entidad
	 * @param esterilizadoProcesoParada
	 */
	public void grabar(EsterilizadoProcesoParada esterilizadoProcesoParada){
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(esterilizadoProcesoParada);
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
