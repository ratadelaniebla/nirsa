package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
 
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoCuba;
import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.Cajon;
import com.nw.model.CamaraCajon;
import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.EspecieTalla;
import com.nw.model.TipoCaptura;
import com.nw.model.dao.CamaraCajonBarcoDescargaMantenimientoDAO;




public class CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl extends BaseDaoJpaImpl implements CamaraCajonBarcoDescargaMantenimientoDAO{

	
	public CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl() {
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public List<CocinaAperturaCierreDetalle> getCocinasAperturaCierreDetallePorFechaProduccion(Long idproduccion) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles = new ArrayList<CocinaAperturaCierreDetalle>();

		     String consulta ="SELECT cacd FROM CocinaAperturaCierreDetalle cacd" +
			   		" where cacd.produccion.idproduccion = :id and cacd.estadococinada = 0 or cacd.estadococinada = 1 order by cacd.cocina.idcocina asc";
			   
				 Query query = em.createQuery(consulta);
				 query.setParameter("id", idproduccion);
			
				 cocinasAperturaCierreDetalles = (List<CocinaAperturaCierreDetalle>)query.getResultList();
			 
		 return  cocinasAperturaCierreDetalles;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<CamaraCajon> getCamaraCajonPorBarcoDescarga(BarcoDescarga barcodescarga) {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<CamaraCajon> camaraCajones = new ArrayList<CamaraCajon>();
 	
		 
			     String consulta ="SELECT cc from CamaraCajon cc " +
			     		"where cc.barcoDescarga.idbarcodescarga =:idbarcodesc and cc.estado = 0 " +
			     		"or cc.estado = 1 or cc.estado = 3 or cc.estado = 5 order by cc.cajon.idcajon asc";
						 Query query = em.createQuery(consulta);
						 query.setParameter("idbarcodesc", barcodescarga.getIdbarcodescarga());
					
						 camaraCajones = (List<CamaraCajon>) query.getResultList();
		
		return camaraCajones;
	}

	public CamaraCajon getCamaraCajonPorBarcoDescargaUnico(BarcoDescarga barcodescarga, String idcajon) {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		 CamaraCajon camaraCajon = new CamaraCajon();
		 
		 try {
			     String consulta ="SELECT cc from CamaraCajon cc " +
			     		"where cc.barcoDescarga.idbarcodescarga =:idbarcodesc and cc.cajon.idcajon =:idc ";
			     
						 Query query = em.createQuery(consulta);
						 query.setParameter("idbarcodesc", barcodescarga.getIdbarcodescarga());
						 query.setParameter("idc", idcajon);
						 
						 camaraCajon = (CamaraCajon) query.getSingleResult();
						 
		 	   } catch (Exception e) {
				 return null;
		 	   }
		return camaraCajon;
	}


	public BarcoCuba getCubaPorBarcoCuba(Long idbarcoCuba ) {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		BarcoCuba barcoCuba = new BarcoCuba();
		 
		 try {
			     String consulta ="SELECT bc from BarcoCuba bc " +
			     		"where bc.idbarcocuba =:idbc order by bc.cuba.nombrecuba";
			     
						 Query query = em.createQuery(consulta);
						 query.setParameter("idbc", idbarcoCuba);
						 
						 barcoCuba = (BarcoCuba) query.getSingleResult();
						 
		 	   } catch (Exception e) {
				 return null;
		 	   }
		return barcoCuba;
	}
	
	
	public EspecieTalla getEspecieTallaPorId(Integer idespecietalla ) {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EspecieTalla especietalla = new EspecieTalla();
		 
		 try {
			     String consulta ="SELECT et from EspecieTalla et " +
			     		"where et.idespecietalla =:idesp ";
			     
						 Query query = em.createQuery(consulta);
						 query.setParameter("idesp", idespecietalla);
						 
						 especietalla = (EspecieTalla) query.getSingleResult();
						 
		 	   } catch (Exception e) {
				 return null;
		 	   }
		return especietalla;
	}
	
	
	public Cajon getCajonPorId(String idcajon) {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Cajon cajon = new Cajon();
		 
		 try {
			     String consulta ="SELECT c from Cajon c " +
			     		"where c.idcajon =:idc ";
						 Query query = em.createQuery(consulta);
						 query.setParameter("idc", idcajon);
						 
						 cajon = (Cajon) query.getSingleResult();
						 
		 	   } catch (Exception e) {
				 return null;
		 	 }
		return cajon;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoCaptura> getTiposCapturas() {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<TipoCaptura> tipoCapturas = new ArrayList<TipoCaptura>();
 	
		 
			     String consulta ="SELECT tc from TipoCaptura tc " +
			     		"order by tc.idtipocaptura ";
						 Query query = em.createQuery(consulta);
					
						 tipoCapturas = (List<TipoCaptura>) query.getResultList();
		
		return tipoCapturas;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<BarcoEstibaCuba> getBarcoEstibaCubaBarcoDescarga(BarcoDescarga barcodescarga) {
		 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<BarcoEstibaCuba> barcosEstibaCubas = new ArrayList<BarcoEstibaCuba>();
 	
		 
			     String consulta ="SELECT bec from BarcoEstibaCuba bec " +
			     		"where bec.barcoDescarga.idbarcodescarga =:idbarcodesc ";
						 Query query = em.createQuery(consulta);
						 query.setParameter("idbarcodesc", barcodescarga.getIdbarcodescarga());
					
						 barcosEstibaCubas = (List<BarcoEstibaCuba>) query.getResultList();
		
		return barcosEstibaCubas;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BarcoDescarga> getBarcoDescargaPorFechaDescarga(
			Date fechaInicio, Date fechaFin) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<BarcoDescarga> barcosDescargas = new ArrayList<BarcoDescarga>();
	   
		String consulta ="SELECT bd from BarcoDescarga bd " +
		     		"where bd.fechadescarga >=:fechaInicial and bd.fechadescarga <=:fechaFinal and bd.estado >= 0  order by bd.registro asc"; //bd.fechadescarga
	     
				 Query query = em.createQuery(consulta);
				 
				 query.setParameter("fechaInicial", fechaInicio);
				 query.setParameter("fechaFinal", fechaFin);
			
				 barcosDescargas = (List<BarcoDescarga>)query.getResultList();
			 
		 return  barcosDescargas;
	}


	@Override
	public void saveOrUpdate(CamaraCajon camaraCajon) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			 t.begin();
				em.merge(camaraCajon);
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
	
	
	
	
	
	

//  Nuevo 30-07-2015//
    public List<CamaraCajon> getCamaraCajonRepetidosPorBarcoDescarga(BarcoDescarga barcodescarga, String idcajon) {
          
          EntityManagerFactory emf = JPAPersistenceManager.getInstance()
                        .getEntityManagerFactory();
          EntityManager em = emf.createEntityManager();
          
          List<CamaraCajon> camaraCajones = new ArrayList<CamaraCajon>();
   
           
          String consulta ="SELECT cc from CamaraCajon cc " +
                                       "where cc.barcoDescarga.idbarcodescarga =:idbarcodesc and cc.cajon.idcajon =:idc ";
                                          
          Query query = em.createQuery(consulta);
          query.setParameter("idbarcodesc", barcodescarga.getIdbarcodescarga());
          query.setParameter("idc", idcajon);                                       
                               
          camaraCajones = (List<CamaraCajon>) query.getResultList();
          
          return camaraCajones;
    }      
	
    public List<CamaraCajon> getCamaraCajonRepetidosPor3Id(String idcajon, String registro, String cuba) 
    {
        
        EntityManagerFactory emf = JPAPersistenceManager.getInstance()
                      .getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        
        List<CamaraCajon> camaraCajones = new ArrayList<CamaraCajon>();
        String consulta = null;
        
        Query query = null;
        
        
        
        //Busca por el registro
        if(idcajon.trim().isEmpty()  && registro.trim().isEmpty() == false  && cuba.trim().isEmpty())
        {
        	consulta ="SELECT cc from CamaraCajon cc where  cc.barcoDescarga.registro =:reg order by cc.cajon.idcajon asc ";
            query = em.createQuery(consulta);
            query.setParameter("reg", registro.trim());
            
        	camaraCajones = (List<CamaraCajon>) query.getResultList();
        	System.out.println("SOLO REGISTRO");
        	return camaraCajones;
            
        }	
        
         
        //Busca solo el cajón
        if(idcajon.trim().isEmpty() == false && registro.trim().isEmpty() && cuba.trim().isEmpty())
        {
        	consulta ="SELECT cc from CamaraCajon cc where cc.cajon.idcajon =:idc order by cc.idcamaracajon desc ";
            query = em.createQuery(consulta);
            query.setParameter("idc", idcajon);
            
            int tama = (int) query.getResultList().size();
            
            if(tama != 0 && registro.trim().isEmpty() && cuba.trim().isEmpty())
            {
    	        if (tama > 100)
    	        {
    	        	camaraCajones = (List<CamaraCajon>) query.getResultList().subList(0, 100);	
    	        }
    	        else
    	        {
    	        	camaraCajones = (List<CamaraCajon>) query.getResultList().subList(0, tama);
    	        }
            }	
            System.out.println("SOLO CAJON");
            return camaraCajones;
            
        }	

        
        //Busca por el cajón y registro
        if(idcajon.trim().isEmpty() == false && registro.trim().isEmpty() == false  && cuba.trim().isEmpty())
        {
        	consulta ="SELECT cc from CamaraCajon cc where cc.cajon.idcajon =:idc and cc.barcoDescarga.registro =:reg order by cc.idcamaracajon desc ";
            query = em.createQuery(consulta);
            query.setParameter("idc", idcajon);                                       
            query.setParameter("reg", registro.trim());
            
        	camaraCajones = (List<CamaraCajon>) query.getResultList();
        	System.out.println("CON REGISTRO");
        	return camaraCajones;
            
        }	

        
        //Busca por el cajón, registro y cuba
        if(idcajon.trim().isEmpty() == false && registro.trim().isEmpty() == false  && cuba.trim().isEmpty() == false)
        {
        	consulta ="SELECT cc from CamaraCajon cc where cc.cajon.idcajon =:idc and cc.barcoDescarga.registro =:reg and cc.barcoEstibaCuba.idbarcocuba =:cub  order by cc.idcamaracajon desc ";
            query = em.createQuery(consulta);
            query.setParameter("idc", idcajon);                                       
            query.setParameter("reg", registro.trim());
            query.setParameter("cub",  Long.valueOf(cuba));

            System.out.println("CON CUBBBBAAAA");
        	camaraCajones = (List<CamaraCajon>) query.getResultList();
        	return camaraCajones;
        }
                             
        return camaraCajones;
  }     
    	



	public List<BarcoDescarga> getBarcoDescargaAnos(Date fechaInicio, Date fechaFin) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<BarcoDescarga> barcosDescargas = new ArrayList<BarcoDescarga>();
	   
		String consulta ="SELECT bd from BarcoDescarga bd " +
		     		"where bd.fechadescarga >=:fechaInicial and bd.fechadescarga <=:fechaFinal and bd.estado >= 0  order by bd.registro asc"; //bd.fechadescarga
	     
				 Query query = em.createQuery(consulta);
				 
				 query.setParameter("fechaInicial", fechaInicio);
				 query.setParameter("fechaFinal", fechaFin);
			
				 barcosDescargas = (List<BarcoDescarga>)query.getResultList();
			 
		 return  barcosDescargas;
	}
	
	/* 07-03-2018 */
	@SuppressWarnings("unchecked")
	public List<BarcoDescarga> getBarcoDescargaPorFechaDescargaDate(
			Date fechaInicio, Date fechaFin) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<BarcoDescarga> barcosDescargas = new ArrayList<BarcoDescarga>();
		String consulta ="SELECT bd from BarcoDescarga bd " +
		     		"  		where func('DATE', bd.fechadescarga) between func('DATE',:fechaInicial) and  func('DATE',:fechaFinal) " +
		     		"			and bd.estado >= 0  order by bd.registro asc"; 
				 Query query = em.createQuery(consulta);
				 query.setParameter("fechaInicial", fechaInicio);
				 query.setParameter("fechaFinal", fechaFin);
			
				 barcosDescargas = (List<BarcoDescarga>)query.getResultList();
			 
		 return  barcosDescargas;
	}

    
}
