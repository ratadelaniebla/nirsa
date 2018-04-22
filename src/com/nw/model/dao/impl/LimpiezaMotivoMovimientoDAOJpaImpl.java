package com.nw.model.dao.impl;
 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaMotivoMovimiento;
 

public class LimpiezaMotivoMovimientoDAOJpaImpl   {

    public LimpiezaMotivoMovimientoDAOJpaImpl() {
	 
    }
 
   
	List<LimpiezaMotivoMovimiento> limpiezaMotivoMovimientos;
    
    @SuppressWarnings({ "unchecked" })   
    public List<LimpiezaMotivoMovimiento> getAll() {
    	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager 		 em  = emf.createEntityManager();
		Query query =  em.createQuery("Select lmm from LimpiezaMotivoMovimiento lmm order by lmm.idlimpiezamotivomovimiento");
		limpiezaMotivoMovimientos = query.getResultList();
		em.close();
        return limpiezaMotivoMovimientos;
    } 

    /**
     * carga un listado segun el tipo:  1.- retiro    2.- reubicacion
     * @param tipo
     * @return
     */
    @SuppressWarnings({ "unchecked" })   
    public List<LimpiezaMotivoMovimiento> getAllByTipo(int tipo) {
    	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager 		 em  = emf.createEntityManager();
		Query query =  em.createQuery("Select lmm from LimpiezaMotivoMovimiento lmm where lmm.tipo =:tipo order by lmm.idlimpiezamotivomovimiento");
		query.setParameter("tipo", tipo);
		limpiezaMotivoMovimientos = query.getResultList();
		em.close();
        return limpiezaMotivoMovimientos;
    } 
   
	
	  /**
     * Guarda o Edita un Objeto LimpiezaMotivoMovimiento
     * @param limpiezaMotivoMovimiento
     */
   public LimpiezaMotivoMovimiento saveOrUpdate(LimpiezaMotivoMovimiento limpiezaMotivoMovimiento) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		LimpiezaMotivoMovimiento limpiezaMotivoMovimientoDevuelto = null;

		try {
			t.begin();
			limpiezaMotivoMovimientoDevuelto=em.merge(limpiezaMotivoMovimiento);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		return limpiezaMotivoMovimientoDevuelto; 
   }
   
   /**
	 * Elimina un Objeto LimpiezaMotivoMovimiento y devuelve un entero: 0-exito ; 1-exeption
	 * @param limpiezaMotivoMovimiento
	 * @return 0 or 1
	 */
	public int delete(LimpiezaMotivoMovimiento limpiezaMotivoMovimiento) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		int id = limpiezaMotivoMovimiento.getIdlimpiezamotivomovimiento();
        int r= 0;

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from LimpiezaMotivoMovimiento where idlimpiezamotivomovimiento =:id ");
			 query.setParameter("id", id);
			 query.executeUpdate();
		 	 t.commit();
		 	 r = 0;
		} catch (RuntimeException e) {   
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
			r = 1;
		} finally {
			em.close();
		}
		return r;
	}
		

}
