package com.nw.model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query; 

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Barco;
import com.nw.model.BarcoCuba;
import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.Cajon;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraCajonCarga;
import com.nw.model.CamaraFilaColumna;
import com.nw.model.Cuba;
import com.nw.model.EspecieTalla;



/**
 * 
 * @author Carlos Holguin
 * @version 1.0
 * @since 21-09-2014
 *
 */
public class CamaraCajonCargaDAOJpaImpl {

	
	List<CamaraCajonCarga> CamaraCajonCargas;
	
	
	
	
	public CamaraCajonCargaDAOJpaImpl() {
	}
    
    /**
     * Obtiene una lista de CamaraCajonCargas
     * @return
     */
    @SuppressWarnings({ "unchecked" })   
    public List<CamaraCajonCarga> getCamaraCajonCargas() {
    	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query =  em.createQuery("Select c from CamaraCajonCarga c ");	
		CamaraCajonCargas = query.getResultList();
        return CamaraCajonCargas;
    }  
	  
    /**
     * Guarda o Edita un Objeto CamaraCajonCarga
     * @param CamaraCajonCarga
     */
	public CamaraCajonCarga saveOrUpdate(CamaraCajonCarga CamaraCajonCarga) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		CamaraCajonCarga CamaraCajonCargaDevuelto = null;

		try {
			t.begin();
			CamaraCajonCargaDevuelto=em.merge(CamaraCajonCarga);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		return CamaraCajonCargaDevuelto; 
		
	}
	
	
	 /**
     * Guarda o Edita un Objeto CamaraCajonCarga
     * @param CamaraCajon
     */
	public CamaraCajon saveOrUpdateCamaraCajon(CamaraCajon CamaraCajon) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		CamaraCajon CamaraCajonDevuelto = null;

		try {
			t.begin();
			CamaraCajonDevuelto=em.merge(CamaraCajon);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		return CamaraCajonDevuelto; 
		
	}
    
    /////////////////////////
	//Modificada 15-04-2015//
	/////////////////////////
	//Evitamos la duplicidad de los lotes SAP, al convertir el campo y el parametro a Long
	public CamaraCajon getCamaraCajonByLoteCajonSap(String lotesap) 
	{ 
			CamaraCajon cc = new CamaraCajon();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try 
			{ 
					Query qry = em.createQuery("select cc from CamaraCajon cc Where cc.lotecajonsap = :lote");
					//qry.setParameter("lote", Long.valueOf(lotesap));
					qry.setParameter("lote", lotesap);
					cc=(CamaraCajon) qry.getSingleResult();
				    return  cc;
			} 
			catch (RuntimeException e) 
				{
					return null;
				}
	}
	
	
	
	public EspecieTalla getEspecieTallaById(Integer idespecietalla) 
	{ 
			EspecieTalla et = new EspecieTalla();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select e from EspecieTalla e" +
							" Where e.idespecietalla = :ides");
					qry.setParameter("ides", idespecietalla );
					et=(EspecieTalla) qry.getSingleResult();
				    return  et;
			} catch (RuntimeException e) {
				return null;
			}
		
	} 
	
	public Cajon getCajonById(String idcajon) 
	{ 
			Cajon cajon = new Cajon();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select c from Cajon c" +
							" Where c.idcajon = :idc");
					qry.setParameter("idc", idcajon );
					cajon=(Cajon) qry.getSingleResult();
				    return  cajon;
			} catch (RuntimeException e) {
				return null;
			}
		
	} 
	
	public Cuba getCubaByNombre(String nombrecuba) 
	{ 
			Cuba c = new Cuba();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select c from Cuba c" +
							" Where c.nombrecuba = :cub");
					qry.setParameter("cub", nombrecuba );
					c=(Cuba) qry.getSingleResult();
				    return  c;
			} catch (RuntimeException e) {
				return null;
			}
		
	} 
	
	public Barco getBarcoByNombre(String numerobarco) 
	{ 
			Barco b = new Barco();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select b from Barco b " +
							" Where b.numbarco = :bar");
					qry.setParameter("bar", numerobarco );
					b=(Barco) qry.getSingleResult();
				    return  b;
			} catch (RuntimeException e) {
				return null;
			}
	} 
	
	public BarcoCuba getBarcoCubaByIdBarcoIdCuba(Integer idbarco,Integer idcuba) 
	{ 
			BarcoCuba b = new BarcoCuba();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select bc from BarcoCuba bc " +
							" Where bc.barco.idbarco = :bar and bc.cuba.idcuba = :cub");
					qry.setParameter("bar", idbarco );
					qry.setParameter("cub", idcuba );
					b=(BarcoCuba) qry.getSingleResult();
				    return  b;
			} catch (RuntimeException e) {
				return null;
			}
	} 
	
	public BarcoEstibaCuba getBarcoEstibaCubaByBarcoCuba(Long idbarcocuba) 
	{ 
			BarcoEstibaCuba b = new BarcoEstibaCuba();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select b from BarcoEstibaCuba b " +
							" Where b.barcoCuba.idbarcocuba = :bar");
					qry.setParameter("bar", idbarcocuba );
					b=(BarcoEstibaCuba) qry.getSingleResult();
				    return  b;
			} catch (RuntimeException e) {
				return null;
			}
	}
	
	//25-09-2014
	public BarcoEstibaCuba getBarcoEstibaCubaByBarcoCubaBarcoDescarga(Long idbarcocuba,Long idbarcodescarga) 
	{ 
			BarcoEstibaCuba b = new BarcoEstibaCuba();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select b from BarcoEstibaCuba b " +
							" Where b.idbarcocuba = :bar and b.barcoDescarga.idbarcodescarga = :bardes");
					qry.setParameter("bar", idbarcocuba );
					qry.setParameter("bardes", idbarcodescarga );
					b=(BarcoEstibaCuba) qry.getSingleResult();
				    return  b;
			} catch (RuntimeException e) {
				return null;
			}
	}
	
	public CamaraFilaColumna getCamaraFilaColumnaByIdCamaraFilaColumna(Long idcamara,String idcolumna, Integer idfila) 
	{ 
			CamaraFilaColumna cfc = new CamaraFilaColumna();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select cfc from CamaraFilaColumna cfc " +
							" Where cfc.camara.idcamara = :idcar and cfc.idcolumna = :col and cfc.idfila = :fil");
					qry.setParameter("idcar", idcamara );
					qry.setParameter("col", idcolumna );
					qry.setParameter("fil", idfila );
					cfc=(CamaraFilaColumna) qry.getSingleResult();
				    return  cfc;
			} catch (RuntimeException e) {
				return null;
			}
	} 

	public BarcoDescarga getBarcoDescargaByViajeOrigenRegistro(Integer origen, String registro , Integer viaje) 
	{ 
			BarcoDescarga cfc = new BarcoDescarga();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select bd from BarcoDescarga bd " +
							" Where bd.origen = :ori and bd.registro = :reg and bd.viaje = :viaj");
					qry.setParameter("ori", origen );
					qry.setParameter("reg", registro );
					qry.setParameter("viaj", viaje );
					cfc=(BarcoDescarga) qry.getSingleResult();
				    return  cfc;
			} catch (RuntimeException e) {
				return null;
			}
	} 
	
	
	public BarcoDescarga getBarcoDescargaByRegistro(String registro) 
	{ 
			BarcoDescarga cfc = new BarcoDescarga();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select bd from BarcoDescarga bd " +
							" Where bd.registro = :reg ");
					qry.setParameter("reg", registro.trim() );
					cfc=(BarcoDescarga) qry.getSingleResult();
				    return  cfc;
			} catch (RuntimeException e) {
				return null;
			}
	}
	
	
	
	/**
	 * Elimina un Objeto CamaraCajonCarga y devuelve un entero: 0-exito ; 1-exeption
	 * @param CamaraCajonCarga
	 * @return 0 or 1
	 */
	public int delete(CamaraCajonCarga CamaraCajonCarga) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		 Long id = CamaraCajonCarga.getIdcamaracajoncarga();
         int r= 0;

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from CamaraCajonCarga where idcamaracajoncarga = :idCamaraCajonCarga ");
			 query.setParameter("idCamaraCajonCarga", id);
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
		
	
	
}
