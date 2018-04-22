package com.nw.model.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaProcesoEmpleadoBonificacionPonchada;


@SuppressWarnings({})
public class LimpiezaProcesoEmpleadoBonificacionPonchadasDAOJpaImpl extends BaseDaoJpaImpl{
	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public LimpiezaProcesoEmpleadoBonificacionPonchadasDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    public void grabar(LimpiezaProcesoEmpleadoBonificacionPonchada limpiezaBonificacionesPonchadas){

		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(limpiezaBonificacionesPonchadas);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	
    }	

	
	
/*	
	public List<LimpiezaLinea>getLimpiezaLineasGrupo(){
		return em.createQuery("select l from LimpiezaLinea l order by l.idlimpiezalinea").getResultList();
	}
*/	
	
}
