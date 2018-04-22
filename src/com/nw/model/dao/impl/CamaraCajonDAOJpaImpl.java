package com.nw.model.dao.impl;

 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraCajonUbicacion;
import com.nw.model.dao.CamaraCajonDAO;


public class CamaraCajonDAOJpaImpl extends BaseDaoJpaImpl implements CamaraCajonDAO {

	@PersistenceContext
	private EntityManagerFactory emf  ;
	private EntityManager em  ;

	 
	 
	
	public CamaraCajonDAOJpaImpl() {
		// emf = Persistence.createEntityManagerFactory("NW");
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

    @SuppressWarnings("unchecked")
    public List<CamaraCajon> getCajonesByCajonAndBarcoDescargaTemperatura(Long idbarcodescarga,String idcajon) { 
                     
     List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
        Query query =  em.createQuery(" select cc from CamaraCajon cc" +
                                                             " where cc.barcoDescarga.idbarcodescarga = :idbarcodes " +
                                                             "     and cc.cajon.idcajon = :idcajon " +
                                                             " and cc.estado in (0,1) order by cc.idcamaracajon desc   ");     
         query.setParameter("idbarcodes", idbarcodescarga);
         query.setParameter("idcajon", idcajon);
         listaCamaraCajon = query.getResultList();
              
      return listaCamaraCajon;
    }   

	
	///new
      public List<CamaraCajon> getEspecie(String lotehaccp) {//esta funcion se le agrego algo del estado
        
        List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
           //Muesra la lista de todos los cajons con estado 1
            Query query =  em.createQuery(" select cc from CamaraCajon cc where cc.lotehaccp=:loteh and cc.estado<>-1 order by cc.especieTalla.especie.nombre ");  
            query.setParameter("loteh", lotehaccp);
            listaCamaraCajon = query.getResultList();
           
           return listaCamaraCajon;
     }     
public List<CamaraCajon> getEspeciebyCamaraCajon(long idcamaracajon) {//esta funcion se le agrego algo del estado
        
        List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
           //Muesra la lista de todos los cajons con estado 1
            Query query =  em.createQuery(" select cc from CamaraCajon cc where cc.idcamaracajon=:loteh and cc.estado<>-1 order by cc.especieTalla.especie.nombre ");  
            query.setParameter("loteh", idcamaracajon);
            listaCamaraCajon = query.getResultList();
           
           return listaCamaraCajon;
     }
	
	//fin new
	
	
	public List<CamaraCajon> getCajonesEstadoUnoCamaraCajonBarcoDescargaorderbylotehaccp(Long idbarcodescarga) {//esta funcion se le agrego algo del estado
        
        List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
           //Muesra la lista de todos los cajons con estado 1
            Query query =  em.createQuery(" select cc from CamaraCajon cc" +
                       " inner join cc.cajon c " +
                       "inner join cc.barcoDescarga bd  " +
                       " where cc.estado in (0,1) and bd.idbarcodescarga = :idbarcodes order by cc.lotehaccp ");     
            query.setParameter("idbarcodes", idbarcodescarga);
            listaCamaraCajon = query.getResultList();
           
           return listaCamaraCajon;
     }     

	
	public List<CamaraCajon> getCajonesEstadoUnoCamaraCajonBarcoDescargaorderbylotehaccpTodos(Long idbarcodescarga) {//esta funcion se le agrego algo del estado

		//0 = Cajón Registrado
		//1 = Asignado a una camara
		//2 = Enviado ha Producción/Descongelado
		//3 = Receptado por Descongelado
		//4 = Salida de Descongelado /Cajón Volteado
		//5 = Cajón devuelto a Cámara

		
        List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
           //Muesra la lista de todos los cajons con estado 1
            Query query =  em.createQuery(" select cc from CamaraCajon cc" +
                       " inner join cc.cajon c " +
                       "inner join cc.barcoDescarga bd  " +
                       " where cc.estado in (0, 1, 2, 3, 4, 5) and bd.idbarcodescarga = :idbarcodes order by cc.lotehaccp ");     
            query.setParameter("idbarcodes", idbarcodescarga);
            listaCamaraCajon = query.getResultList();
           
           return listaCamaraCajon;
     }
	
//	public List<CamaraCajon> getEspecie(String lotehaccp) {//esta funcion se le agrego algo del estado
//        
//        List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
//           //Muesra la lista de todos los cajons con estado 1
//            Query query =  em.createQuery(" select cc from CamaraCajon cc where cc.lotehaccp=:loteh order by cc.especieTalla.especie.nombre ");  
//            query.setParameter("loteh", lotehaccp);
//            listaCamaraCajon = query.getResultList();
//           
//           return listaCamaraCajon;
//     }     


	
	@Override
	public void saveOrUpdate(CamaraCajon camaraCajon) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(camaraCajon);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}

	}

	
   @SuppressWarnings("unchecked")
   public List<CamaraCajon> getCajonesEstadoUnoCamaraCajon() 
   {
	   List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
		//Muesra la lista de todos los cajons con estado 1
		 Query query =  em.createQuery(" select cc from CamaraCajon cc" +
				" inner join cc.cajon c " +
				" where c.estadocajon = 1 and cc.estado= 1 order by c.idcajon ");	
		 listaCamaraCajon = query.getResultList();
		
		return listaCamaraCajon;
   }


	   public String obtenerMezclaCubas(String lotehaccp)
	   {
	         String resultado = "";
	
	         Query query = em.createNativeQuery("select mescla_cubas_por_lotehaccp(?1) ");
	         query.setParameter(1, lotehaccp);
	         resultado = (String) query.getSingleResult();
	         return resultado;
	   }     
  
   
   

	   @SuppressWarnings("unchecked")
	   public List<CamaraCajon> getCamaraCajonHaccp() 
	   {
		   List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select cc from CamaraCajon cc " +
					" Where cc.barcoDescarga.estado =  1 ");	
			 listaCamaraCajon = query.getResultList();
			
			return listaCamaraCajon;
	   }

	   
	   
	   
	
	
	
	
	
   
	public CamaraCajon getCamaraCajonId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select cc from CamaraCajon cc "); 
		sb.append("Where cc.cajon.idcajon = '" + id.trim() + "' and cc.estado in (0,1)");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

       if (items == null || items.isEmpty()) {
           return null;
       } else {
           return  (CamaraCajon) items.get(0);
       }		
	}   
	
	public CamaraCajon getCamaraCajonporidCC(Long id) 
	{ 
			CamaraCajon cc = new CamaraCajon();
			
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			
			try {
					
					Query qry = em.createQuery("select cc from CamaraCajon cc " +
							" Where cc.idcamaracajon = :idCC");
					qry.setParameter("idCC", id );
					cc=(CamaraCajon) qry.getSingleResult();
				    return  cc;
			} catch (RuntimeException e) {
				return null;
			}
			

		
	}   
////////////
//Agregada//
///////////   
@SuppressWarnings("unchecked")
public List<CamaraCajon> getCajonesEnCamaraCajonDisponibles() {

List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
//Muesra la lista de todos los cajons con estado 1
Query query =  em.createQuery(" select cc from CamaraCajon cc" +
	" inner join cc.cajon c " +
	" where cc.estado= 1 order by c.idcajon ");	
listaCamaraCajon = query.getResultList();

return listaCamaraCajon;
}     
	
	public void guardarCabeceraCamaraCajon(CamaraCajon camaraCajon, CamaraCajonUbicacion ccu)  {   
		CamaraCajon cc = new CamaraCajon();
		Long i;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(camaraCajon);//merge
				 //obtengo y asigno el ultimo id ingresado en la tabla camara_cajon 
				//y lo devuelvo asignado en un objeto del tipo CamaraCajon para q se pueda utilizar 
				// en el otro metodo "guardarCabeceraCabeceraDetalle"
				Query qry = em.createQuery("SELECT MAX(c.idcamaracajon) FROM CamaraCajon c");
			    Object valorMaximoObjeto = qry.getSingleResult();
				i = (Long.valueOf((Long) valorMaximoObjeto));
				cc.setIdcamaracajon(i);
				//asigno el id maximo
				ccu.setCamaraCajon(cc);
				em.merge(ccu);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		//return cc;

	}
	
	/**
	 * Metodo que guarda un Objeto CamaraCajon y devuelve un Objeto
	 * del mismo tipo el cual contiene el idcamaracajon Maximo 
	 * del ultimo objeto ingresado el cual sera asignado en otro metodo 
	 * que guarda un objeto de tipo CamaraCajonUbicacion
	 * esto es xq al guardar se ejecutan ambos metodos al mismo tiempo
	 * por la relacion entre CamaraCajonUbicacion q depende de CamaraCajon  
	 * @param camaraCajon
	 * @return
	 */
	public CamaraCajon guardarCabeceraCamaraCajonIdMax(CamaraCajon camaraCajon )  {   
		CamaraCajon cc = new CamaraCajon();
		Long i;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(camaraCajon);//merge
				 //obtengo y asigno el ultimo id ingresado en la tabla camara_cajon 
				//y lo devuelvo asignado en un objeto del tipo CamaraCajon para q se pueda utilizar 
				// en el otro metodo  "guardarCamaraCajonUbicacion" de la clase CamaraCajonUbicacionDAOJpaImpl
				Query qry = em.createQuery("SELECT MAX(c.idcamaracajon) FROM CamaraCajon c");
			    Object valorMaximoObjeto = qry.getSingleResult();
				i = (Long.valueOf((Long) valorMaximoObjeto));
				cc.setIdcamaracajon(i);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		return cc;

	}
	
	
	public void guardar(CamaraCajon  cc ){
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				//em.merge(cc); 
				em.createNativeQuery("insert into ...").setParameter(1, cc.getIdcamaracajon()).executeUpdate();
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){  
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
	}
	
 	
	public Long getMaxIdCamaraCajon()
	{
		Query qry = em.createQuery("SELECT MAX(c.idcamaracajon) FROM CamaraCajon c");
		Object obj = qry.getSingleResult();
	    if(obj==null) return (long) 0;
	    return (Long)obj;
	}
	
	public Long getidCamaraCajon(String idcajon)//x
	{
		Query qry = em.createQuery("select cc.idcamaracajon from CamaraCajon cc " +
				"inner join cc.cajon c " +
				"where c.idcajon = :caj");
		qry.setParameter("caj", idcajon);
		Object obj = qry.getSingleResult();
		
		 if(obj==null) return (long) 0;
		    return (Long)obj;
		
	}
	
	//c.estadocajon = 1 and
	
	   @SuppressWarnings("unchecked")
	   /**
	    * METODO QUE OBTIENE UN LISTADO DE LOS CAJONES EN CAMARA CON ESTADO UNO esto es para CamaraCajonUbicacion
	    * @param idbarcodescarga
	    * @return
	    */
	   public List<CamaraCajon> getCajonesEstadoUnoCamaraCajonBarcoDescarga(Long idbarcodescarga) {//esta funcion se le agrego algo del estado
	   	 
	   	   List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
	   		//Muesra la lista de todos los cajons con estado 1
	   		 Query query =  em.createQuery(" select cc from CamaraCajon cc" +
	   				" inner join cc.cajon c " +
	   				"inner join cc.barcoDescarga bd  " +
	   				" where cc.estado = 1 and bd.idbarcodescarga = :idbarcodes order by c.idcajon ");	
	   		 query.setParameter("idbarcodes", idbarcodescarga);
	   		 listaCamaraCajon = query.getResultList();
	   		
	   		return listaCamaraCajon;
	      }	
	
	
	   
	   @SuppressWarnings("unchecked")
	   /**
	    * METODO QUE OBTIENE UN LISTADO DE LOS CAJONES EN CAMARA CON ESTADO CERO 
	    * @param idbarcodescarga
	    * @return
	    */
	   public List<CamaraCajon> getCajonesEstadoCeroCamaraCajonBarcoDescarga(Long idbarcodescarga) {//esta funcion se le agrego algo del estado
	   	 
	   	   List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
	   		//Muesra la lista de todos los cajons con estado 0
	   		 Query query =  em.createQuery(" select cc from CamaraCajon cc" +
	   				" inner join cc.cajon c " +
	   				"inner join cc.barcoDescarga bd  " +
	   				" where cc.estado = 0 and bd.idbarcodescarga = :idbarcodes order by c.idcajon ");	
	   		 query.setParameter("idbarcodes", idbarcodescarga);
	   		 listaCamaraCajon = query.getResultList();
	   		
	   		return listaCamaraCajon;
	      }	
	   
//	   SELECT barco.nombre from camara_cajon  
//	   inner join barco_descarga
//	   on (camara_cajon.idbarcodescarga=barco_descarga.idbarcodescarga)
//	   inner join barco 
//	   on (barco_descarga.idbarco=barco.idbarco)
//	   inner join cajon 
//	   on (camara_cajon.idcajon=cajon.idcajon)
//	   where cajon.idcajon = '21050'  
    
	  public String obtenerDescripcionEspecieBarco(String idcajon)
	  {
		  String resultado = "";

		  Query query = em.createQuery("select b.nombre from CamaraCajon cc" +
		  		" inner join cc.barcoDescarga bd " +
		  		"inner join bd.barco b " +
		  		" inner join cc.cajon c " +
		  		"where c.idcajon = :idcajon ");
		  query.setParameter("idcajon", idcajon);
		  resultado = (String) query.getSingleResult();
		  return resultado;
	  }

	  
	  public String obtenerDescripcionEspecieBarcoCajonEstadoCero(String idcajon)
	  {
		  String resultado = "";

		  Query query = em.createQuery("select b.nombre from CamaraCajon cc" +
		  		" inner join cc.barcoDescarga bd " +
		  		"inner join bd.barco b " +
		  		" inner join cc.cajon c " +
		  		"where cc.cajon.idcajon = :idcajon and cc.estado = 0 ");
		  query.setParameter("idcajon", idcajon);
		  resultado = (String) query.getSingleResult();
		  return resultado;
	  }	  

//	  select especie.nombre, talla.nombre from camara_cajon 
//	  inner join especie_talla
//	  on (camara_cajon.idmaterial = especie_talla.idespecietalla)
//	  inner join especie
//	  on (especie_talla.idespecie=especie.idespecie)
//	  inner join talla 
//	  on (especie_talla.idtalla = talla.idtalla)
//	  inner join cajon
//	  on (camara_cajon.idcajon = cajon.idcajon)
//	  where cajon.idcajon = '21050' 
	  public List<Object[]> obtenerEspecieTallaDescripcion(String idcajon) throws InterruptedException
	  {
		  List<Object[]> resultado = null;

		  Query query = em.createQuery("select e.nombre ,t.nombre from CamaraCajon cc" +
		  		" inner join cc.especieTalla et " +
			    " inner join et.especie e"+
		  		" inner join et.talla t "+
		  		" inner join cc.cajon c " +
		  		"where c.idcajon = :idcajon ");
		  query.setParameter("idcajon", idcajon);
		  resultado =   (List<Object[]>) query.getResultList();
		  
			// Messagebox.show( "resultado-->"+resultado);
		  
		  return resultado;
	  }
	  

	  public Long obtenerTotalCocinas(Long id) {
			EntityManagerFactory emf = JPAPersistenceManager.getInstance()
					.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("select count(ca.cocina) from CocinaAperturaCierreDetalle ca"
							+ " where ca.cocina.idcocina =:id"); // :idedp
			query.setParameter("id", id);
			// Object obj = query.getSingleResult();
			Long resultado = (Long) query.getSingleResult();
			// Sistema.mensaje("cantidad de registros-->"+resultado);
			return resultado;
		}

	  
	  
	  public List<Object[]> obtenerEspecieTallaDescripcionCajonEstadoCero(String idcajon) throws InterruptedException
	  {
		  List<Object[]> resultado = null;

		  Query query = em.createQuery("select e.nombre ,t.nombre from CamaraCajon cc" +
		  		" inner join cc.especieTalla et " +
			    " inner join et.especie e"+
		  		" inner join et.talla t "+
		  		" inner join cc.cajon c " +
		  		"where cc.cajon.idcajon = :idcajon and cc.estado = 0 ");
		  query.setParameter("idcajon", idcajon);
		  resultado =   (List<Object[]>) query.getResultList();
		  
			// Messagebox.show( "resultado-->"+resultado);
		  
		  return resultado;
	  }
/*	  
	  @SuppressWarnings("unchecked")
		public List<CamaraCajon> getCajonesxCubaBarcoDescarga(Long idbarcodescarga,Long idBarcoCuba) {//esta funcion se le agrego algo del estado
			  	 
		  	  List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
		  		Query query =  em.createQuery(" select cc from CamaraCajon cc" +
		  				" where cc.barcoDescarga.idbarcodescarga= :idbarcodes and cc.barcoEstibaCuba.idbarcocuba = :idcuba and  cc.estado IN (0,1,5) ");	
		  		query.setParameter("idbarcodes", idbarcodescarga);
		  		query.setParameter("idcuba", idBarcoCuba);
		  		listaCamaraCajon = query.getResultList();
		  		
		  		return listaCamaraCajon;
		}	
*/
	  @SuppressWarnings("unchecked")
			public List<CamaraCajon> getCajonesxCubaBarcoDescarga(Long idbarcodescarga,Long idBarcoCuba, int idEspecieTalla) {//esta funcion se le agrego algo del estado
				  	 
			  	  List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
			  		Query query =  em.createQuery(" select cc from CamaraCajon cc" +
			  				" where cc.barcoDescarga.idbarcodescarga= :idbarcodes and cc.barcoEstibaCuba.idbarcocuba = :idcuba and cc.especieTalla.idespecietalla = :idesp and  cc.estado IN (0,1,5) " +
			  				"order by cc.cajon.idcajon asc ");	
			  		query.setParameter("idbarcodes", idbarcodescarga);
			  		query.setParameter("idcuba", idBarcoCuba);
			  		query.setParameter("idesp", idEspecieTalla);
			  		
			  		listaCamaraCajon = query.getResultList();
			  		
			  		return listaCamaraCajon;
			}	
		
	  
	  
	  @SuppressWarnings("unchecked")
			public List<CamaraCajon> getCajonesxCubaBarcoDescargaMescla(Long idbarcodescarga,Long idBarcoCuba, int idEspecieTalla) {//esta funcion se le agrego algo del estado
				  	 
			  	  List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
			  	  
			  	  
			  		try {
			  			
						Query query =  em.createQuery(" select becm.camaraCajon from BarcoEstibaCubaDetalleMezcla becm" +
						" where becm.camaraCajon.barcoDescarga.idbarcodescarga= :idbarcodes" +
						" and becm.camaraCajon.especieTalla.idespecietalla = :idesp and  becm.camaraCajon.estado IN (0,1,5) " +
						" and becm.barcoEstibaCuba.idbarcocuba = :idcuba " +
						" order by becm.camaraCajon.cajon.idcajon asc  ");
						
						query.setParameter("idbarcodes", idbarcodescarga);
						query.setParameter("idcuba", idBarcoCuba);
						query.setParameter("idesp", idEspecieTalla);			  			
			  			
			  			
//						Query query =  em.createQuery(" select cc from CamaraCajon cc" +
//								" where cc.barcoDescarga.idbarcodescarga= :idbarcodes and cc.especieTalla.idespecietalla = :idesp and  cc.estado IN (0,1,5) " +
//								" and cc.barcoEstibaCubaDetalleMezclas.barcoEstibaCuba.idbarcocuba = :idcuba " +
//								"order by cc.cajon.idcajon asc ");	
//						query.setParameter("idbarcodes", idbarcodescarga);
//						query.setParameter("idcuba", idBarcoCuba);
//						query.setParameter("idesp", idEspecieTalla);
						
						listaCamaraCajon = query.getResultList();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  		
			  		return listaCamaraCajon;
			}	  


	   @SuppressWarnings("unchecked")
	public List<CamaraCajon> getCajonesxCubaBarcoDescarga(Long idbarcodescarga,Long idBarcoCuba) {//esta funcion se le agrego algo del estado
		   	 
	   	   List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
	   		Query query =  em.createQuery(" select cc from CamaraCajon cc" +
	   				" where cc.barcoDescarga.idbarcodescarga= :idbarcodes and cc.barcoEstibaCuba.idbarcocuba = :idcuba and  cc.estado IN (0,1,5) ");	
	   		 query.setParameter("idbarcodes", idbarcodescarga);
	   		query.setParameter("idcuba", idBarcoCuba);
	   		 listaCamaraCajon = query.getResultList();
	   		
	   		return listaCamaraCajon;
	      }	

		//05-07-2016
		public CamaraCajon getCamaraCajonIdRegresh(String vididcamaracajon)
		{
		       Query qry = em.createQuery("select cc from CamaraCajon cc " +
			 			"Where cc.idcamaracajon = '" + vididcamaracajon.trim() + "'")
		       		.setFirstResult(0);    
		       
		       Object lista;
		       try {
		             lista = qry.getSingleResult();
		       } catch (Exception e) {
		             // TODO Auto-generated catch block
		             return null;
		       }
		       
		       em.refresh(lista);

		       if(lista == null)
		       {
		             return null;
		       }
		       return (CamaraCajon) lista;
		}	   
	   
		
		 
	  /**
	   * Listado de camara cajon ordenados de manera descendente 
	   * 09-11-2017
	   * @param idbarcodescarga
	   * @param idcajon
	   * @return
	   */
	  @SuppressWarnings("unchecked")
	  public List<CamaraCajon> getCajonesByCajonAndBarcoDescarga(Long idbarcodescarga,String idcajon) { 
			   	 
   	   List<CamaraCajon> listaCamaraCajon = new ArrayList<CamaraCajon>();  
   		Query query =  em.createQuery(" select cc from CamaraCajon cc" +
   											" where cc.barcoDescarga.idbarcodescarga = :idbarcodes " +
   											"	and cc.cajon.idcajon = :idcajon order by cc.idcamaracajon desc   ");	
   		 query.setParameter("idbarcodes", idbarcodescarga);
   		 query.setParameter("idcajon", idcajon);
   		 listaCamaraCajon = query.getResultList();
	   		
	    return listaCamaraCajon;
	  }	
		 
}
