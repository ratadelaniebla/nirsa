package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Barco;
import com.nw.model.BarcoPropiedad;
import com.nw.model.dao.BarcoDAO;


@SuppressWarnings("unchecked")
public class BarcoDAOJpaImpl extends BaseDaoJpaImpl implements BarcoDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public BarcoDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public Barco getFindBarcobyId(Integer vid) {
		return em.find(Barco.class, vid);	
	}	    

    
    public List<Barco> getBarcos() {
		return em.createQuery("select b from Barco b order by b.nombre").getResultList();
	}
    
    public List<BarcoPropiedad> getPropietarios() {
		return em.createQuery("select bp from BarcoPropiedad bp order by bp.idpropiedad").getResultList();
	}
    public Barco getMaxIdBarco(){
    	Barco barco;
    	try {
    		Query qry = em.createQuery(" select b  from Barco b where b.idbarco = (Select max (ba.idbarco) from Barco ba )");
    		barco = (Barco) qry.getSingleResult(); 
    		return barco;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
    	
    }
   
	public void saveOrUpdate(Barco barco) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(barco);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	public void saveBarco(Barco barco) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						Query quy = em.createNativeQuery("INSERT INTO barco(idbarco, numbarco, nombre, idpropiedad, idnomina)" +
								"   VALUES (?, ?, ?, ?, ?)");
						quy.setParameter(1, barco.getIdbarco());
						quy.setParameter(2, barco.getNumbarco());
						quy.setParameter(3, barco.getNombre());
						quy.setParameter(4, barco.getBarcoPropiedad().getIdpropiedad());
						quy.setParameter(5, barco.getIdnomina());
						quy.executeUpdate();
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
}
