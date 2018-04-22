package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoCuba;
import com.nw.model.dao.BarcoCubaDAO;
import com.nw.temp.model.BarcoCubaEstado;

@SuppressWarnings("unchecked")
public class BarcoCubaDAOJpaImpl extends BaseDaoJpaImpl implements BarcoCubaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public BarcoCubaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public BarcoCuba getFindBarcobyId(Long long1) {
		return em.find(BarcoCuba.class, long1);	
	}	    

	public BarcoCuba getFindBarcoCubaId(Integer vid) {
		return em.find(BarcoCuba.class, vid);	
	}

	
	public BarcoCuba getFindBarcoCubaIdLong(Long vid) {
		return em.find(BarcoCuba.class, vid);	
	}	
	
	
    public List<BarcoCuba> getBarcosCubas(Integer id) {
		return em.createQuery("select b from BarcoCuba b WHERE b.barco.idbarco = '"  + id.toString() + "' ").getResultList();
	}

    
    //Cubas aprobas para descargar (1) y cubas en proceso de descarga (2)
    public List<BarcoCuba> getBarcosCubasAprobadasParaDescarga(Integer id, Long long1) {
		return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
	}  
 
    		
    public List<BarcoCuba> getBarcosCubasTraladadasParaDescargaPorVolqueta(String id, String idvolqueta) {		
    	System.out.println("Ide barco :"+id);
	  //return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.barco.idbarco = '"  + id + "' and b.idbarcocuba = cam.barcoEstibaCuba.idbarcocuba and cam.volqueta.idvolqueta = '"  + idvolqueta + "' and cam.banda.idbanda is null").getResultList();
    	 
		//return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.barco.idbarco = '"  + id + "' and b.idbarcocuba = cam.barcoEstibaCuba.idbarcocuba and cam.volqueta.idvolqueta = '"  + idvolqueta + "' and cam.banda is null").getResultList();
    	return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE cam.banda  is not  null").getResultList();
    	
		//                     select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.idbarcocuba = '"  + "22" + "' and cam.barcoDescarga.idbarcodescarga = '"  + "22" + "' and cam.banda.idbanda is null "' and cam.barcoDescarga.idbarcodescarga = '"  + "3" + "'"
    	//return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.idbarcocuba = '"  + "22" + "' and cam.barcoDescarga.idbarcodescarga = '"  + "1" + "' and cam.banda.idbanda is null  and cam.volqueta.idvolqueta = '"  + "3" + "'").getResultList();
    	//return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.idbarcocuba = 22 and cam.barcoDescarga.idbarcodescarga = 1 and cam.volqueta.idvolqueta = 3").getResultList();
	}     
    
    //select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = 10 and b.idbarcocuba = bec.idbarcocuba and  bec.estadodescargacuba = 1
    
//	@Override
//	public List<BarcoCuba> getBarcosCubas() {
//		// TODO Auto-generated method stub
//		return null;
//	}

    public List<BarcoCuba> getBarcosCubasPorBarco(Integer id) {
    	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		//EntityTransaction t = em.getTransaction();
		
		List<BarcoCuba> barcoCubas = new ArrayList<BarcoCuba>();
		
			 Query query = em.createQuery("select b from BarcoCuba b WHERE b.barco.idbarco = :idbarco");
			 query.setParameter("idbarco", id);
		
		 barcoCubas = query.getResultList();
			 
		 return  barcoCubas;
	}
    
    public BarcoCuba getBarcoCuba(Long id){
		BarcoCuba cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoCuba b where b.idbarcocuba=:idbc");
    		qry.setParameter("idbc", id);
    		cuba = (BarcoCuba) qry.getSingleResult(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }
    
    public BarcoCuba getBarcoCubaporIdcuba(Integer id){
		BarcoCuba cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoCuba b where b.cuba.idcuba=:idc");
    		qry.setParameter("idc", id);
    		cuba = (BarcoCuba) qry.getSingleResult(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }
    

  /**
	 * Guarda o Edita un listado barcoCubaEstados
	 * @param barcoCubaEstados
	 */
	public void saveOrUpdateBarcoCubaEstado(List<BarcoCubaEstado> barcoCubaEstados) {
 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			 t.begin();
			 
			for (BarcoCubaEstado rde : barcoCubaEstados) {

				if (rde.isEstadoCuba()) { // si es true guarda
					em.merge(rde.getBarcoCuba());
					
				} else {// si es false modifica
					em.merge(rde.getBarcoCuba());
				}

			}
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}
    
    
    
    /**
	 * Elimina un Objeto BarcoCuba y devuelve un entero: 0-exito ; 1-exeption
	 * @param barcoCuba
	 * @return 0 or 1
	 */
	public int delete(BarcoCuba  barcoCuba) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
         int r= 0;
         Long id = barcoCuba.getIdbarcocuba();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from BarcoCuba where idbarcocuba = :idbc");
			 query.setParameter("idbc", id);
			 query.executeUpdate();
		 	 t.commit();
		 	 r = 0;
			 
		} catch (RuntimeException e) {   
			if (t.isActive()) {
				t.rollback();
			}
		    
			r = 1;
		} finally {
			em.close();
		}
		return r;
		 
	}    

	public List<BarcoCuba> getBarcoCubaporBarco(Integer id){
    	List<BarcoCuba> bc;
    	try {
    		Query qry = em.createQuery(" select b from BarcoCuba b where b.barco.idbarco= :idbarco");
    		qry.setParameter("idbarco", id);
    		bc = qry.getResultList(); 
    		return bc;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }	

	public BarcoCuba getBarcoCubaBarco(Integer id,String para_barco){
		BarcoCuba cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoCuba b where b.cuba.idcuba=:idc and b.barco.numbarco= :barco");
    		qry.setParameter("idc", id);
    		qry.setParameter("barco", para_barco);
    		cuba = (BarcoCuba) qry.getSingleResult(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }	

    public BarcoCuba getBarcoCubaporIdBarco(Integer idb, String scuba){
		BarcoCuba cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoCuba b where b.barco.idbarco=:idb and b.cuba.nombrecuba=:scuba");
    		qry.setParameter("idb", idb);
    		qry.setParameter("scuba", scuba.trim());
    		cuba = (BarcoCuba) qry.getSingleResult(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }


	
}
