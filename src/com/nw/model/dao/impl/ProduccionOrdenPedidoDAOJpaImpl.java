package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.nw.model.ProduccionCargaArchivoPedido;
import com.nw.model.ProduccionOrdenPedido;
import com.nw.util.Sistema;

/**
 * Clase para manejar la entidad ProduccionOrdenPedido
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-04-08, 09, 10
 */
@SuppressWarnings("unchecked")
public class ProduccionOrdenPedidoDAOJpaImpl extends BaseDaoJpaImpl {
	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public ProduccionOrdenPedidoDAOJpaImpl(){
    	//emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		emf = Persistence.createEntityManagerFactory("NW");
        em = emf.createEntityManager();
    }
    
    public ProduccionOrdenPedido getProduccionOrdenPedido(String fecha, int turnoId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p FROM ProduccionOrdenPedido p ");
		sb.append("WHERE p.produccion.fechaproduccion = :fecha ");
		sb.append("AND p.turno.idturno = :turnoId ");

		//TODO: 0 EJEMPLO PARAMETROS JPQL
		//TODO: 0 EJEMPLO COMPLETO TIMESTAMP
		
		List <ProduccionOrdenPedido>items = em.createQuery(sb.toString())
				.setParameter("fecha", Sistema.getFecha(fecha))
				.setParameter("turnoId", turnoId)   
				.getResultList();
		return ( items == null || items.isEmpty() ) ? null: (ProduccionOrdenPedido) items.get(0);
    }
    
    /**
     * Eliminar registros de acuerdo a los parámetros ingresados
     * @param fecha
     * @param turnoId
     */
    public int eliminarProduccionOrdenPedido(String fecha, int turnoId){
    	int valor = 0;
    
    	//TODO: 0 EJEMPLO DE BORRADO DE REGISTROS CON JPQL
    	StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ProduccionOrdenPedido p ");
		sb.append("WHERE p.produccion.fechaproduccion = ?1 ");
		sb.append("AND p.turno.idturno = ?2 ");
    	
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				valor = em.createQuery(sb.toString())
						.setParameter(1, Sistema.getFecha(fecha))
						.setParameter(2, turnoId).executeUpdate();
				
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		return valor;
	}
    
    public void grabar(ProduccionOrdenPedido produccionOrdenPedido){
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(produccionOrdenPedido);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
    }

    public void grabar(ProduccionCargaArchivoPedido produccionCargaArchivoPedido){
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(produccionCargaArchivoPedido);
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
