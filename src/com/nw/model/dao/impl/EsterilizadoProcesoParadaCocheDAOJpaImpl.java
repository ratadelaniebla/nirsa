package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.Produccion;
import com.nw.model.dao.EsterilizadoProcesoParadaCocheDAO;

/**
 * Clase para manejar la Entidad EsterilizadoProcesoParadaCoche
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-04-03, 04
 */
/**
 * 
 * @author Cls Mbaque
 * @version 2.0
 */
@SuppressWarnings("unchecked")
public class EsterilizadoProcesoParadaCocheDAOJpaImpl extends BaseDaoJpaImpl implements EsterilizadoProcesoParadaCocheDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public EsterilizadoProcesoParadaCocheDAOJpaImpl() {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
	}

    /**
     * Determina si existe un registro según los parámetros ingresados
     * @param esterilizadoProcesoParadaId
     * @param esterilizadoCocheId
     * @return
     */
    public boolean isExiste(Long esterilizadoProcesoParadaId, Long esterilizadoCocheId){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT e FROM EsterilizadoProcesoParadaCoche e ");
		sb.append(String.format("WHERE e.esterilizadoProcesoParada.idesterilizadoprocesoparada = %s ", esterilizadoProcesoParadaId) );
		sb.append(String.format("AND e.esterilizadoCoche.idesterilizadocoche = %s ", esterilizadoCocheId));
		List <EsterilizadoProcesoParadaCoche>items = em.createQuery(sb.toString()).getResultList();
		return ( items == null || items.isEmpty() ) ? false: true;
    }
    
    /**
     * Recupera los coches que tienen asignacion del proceso activo
     * @param idproduccion
     * @param intCocheId
     * @return
     */
    public EsterilizadoProcesoParadaCoche obtieneCochesAsignadosProduccion(Long idproduccion, Integer intCocheId) {
    	String sql = new StringBuilder("SELECT e")
    			.append(" FROM EsterilizadoProcesoParadaCoche e ")
    			.append("WHERE e.esterilizadoProcesoParada.produccion.idproduccion = :idproduccion")
    			.append(" AND e.esterilizadoCoche.codbarra = :intCocheId ")
    			.toString();
    	try {
	    	return (EsterilizadoProcesoParadaCoche) em.createQuery(sql)
	    			.setParameter("idproduccion", idproduccion)
	    			.setParameter("intCocheId", intCocheId)
	    			.getSingleResult();
    	} catch (NoResultException ne) {
    		System.out.println("no hay datos...");
    		return null;
    	} catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public List<EsterilizadoProcesoParada> obtieneParadasAsignadosProduccion(Long idproduccion) {
    	String sql = new StringBuilder("SELECT distinct e.esterilizadoProcesoParada ")
    			.append(" FROM EsterilizadoProcesoParadaCoche e ")
    			.append("WHERE e.esterilizadoProcesoParada.produccion.idproduccion = :idproduccion ")
    			.append( "ORDER BY e.esterilizadoProcesoParada.numparada ")
    			.toString();
    	try {
	    	return (List<EsterilizadoProcesoParada>) em.createQuery(sql)
	    			.setParameter("idproduccion", idproduccion)
	    			.getResultList();
    	} catch (NoResultException ne) {
    		System.out.println("no hay datos...");
    		return null;
    	} catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public List<EsterilizadoCoche> obtieneCochesAsignadosProduccion(Long idesterilizadoprocesoparada) {
    	String sql = new StringBuilder("SELECT distinct e.esterilizadoCoche ")
    			.append(" FROM EsterilizadoProcesoParadaCoche e ")
    			.append("WHERE e.esterilizadoProcesoParada.idesterilizadoprocesoparada = :idesterilizadoprocesoparada ")
    			.append( "ORDER BY e.esterilizadoCoche.codbarra ")
    			.toString();
    	try {
	    	return (List<EsterilizadoCoche>) em.createQuery(sql)
	    			.setParameter("idesterilizadoprocesoparada", idesterilizadoprocesoparada)
	    			.getResultList();
    	} catch (NoResultException ne) {
    		System.out.println("no hay datos...");
    		return null;
    	} catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public List<EsterilizadoProcesoParadaCoche> obtieneCochesAsignadosParada(Long idesterilizadoprocesoparada) {
    	String sql = new StringBuilder("SELECT e")
    			.append(" FROM EsterilizadoProcesoParadaCoche e ")
    			.append(" WHERE e.esterilizadoProcesoParada.idesterilizadoprocesoparada = :idesterilizadoprocesoparada ")
    			.append(" ORDER BY e.esterilizadoCoche.produccionDetalleOrden.orden, e.esterilizadoCoche.codbarra ")
    			.toString();
    	try {
	    	return (List<EsterilizadoProcesoParadaCoche>) em.createQuery(sql)
	    			.setParameter("idesterilizadoprocesoparada", idesterilizadoprocesoparada)
	    			.getResultList();
    	} catch (NoResultException ne) {
    		System.out.println("no hay datos...");
    		return new ArrayList<EsterilizadoProcesoParadaCoche>();
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ArrayList<EsterilizadoProcesoParadaCoche>();
    	}
    }
    
    public EsterilizadoProcesoParadaCoche obtieneCocheAsignadoParada(Long idesterilizadoprocesoparada) {
    	String sql = new StringBuilder("SELECT e")
    			.append(" FROM EsterilizadoProcesoParadaCoche e ")
    			.append(" WHERE e.esterilizadoProcesoParada.idesterilizadoprocesoparada = :idesterilizadoprocesoparada ")
    			.append(" ORDER BY e.esterilizadoCoche.horaselladolata desc ")
    			.toString();
    	try {
	    	return (EsterilizadoProcesoParadaCoche) em.createQuery(sql)
	    			.setParameter("idesterilizadoprocesoparada", idesterilizadoprocesoparada)
	    			.getResultList().get(0);
    	} catch (NoResultException ne) {
    		System.out.println("no hay datos...");
    		return null;
    	} catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public List<Produccion> obtieneParadasAsignadasProduccion() {
    	String sql = new StringBuilder("SELECT distinct epp.produccion")
    			.append(" FROM EsterilizadoProcesoParada epp, EsterilizadoProcesoParadaCoche eppc, EsterilizadoCoche ec ")
    			.append(" WHERE eppc.esterilizadoProcesoParada.idesterilizadoprocesoparada = epp.idesterilizadoprocesoparada ")
    			.append(" AND   eppc.esterilizadoCoche.idesterilizadocoche = ec.idesterilizadocoche ")
    			.append(" ORDER BY epp.produccion.fechaproduccion desc ")
    			.toString();
    	try {
	    	return (List<Produccion>) em.createQuery(sql)
	    			.getResultList();
    	} catch (NoResultException ne) {
    		System.out.println("no hay datos...");
    		return null;
    	} catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}	
    }
    
	/**
	 * Grabar una entidad
	 * @param esterilizadoProcesoParada
	 */
	public void grabar(EsterilizadoProcesoParadaCoche esterilizadoProcesoParadaCoche){
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(esterilizadoProcesoParadaCoche);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
	}

}
