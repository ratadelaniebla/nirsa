package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.CalidadBpmClasificacion;
import com.nw.model.CalidadMuestraAreaCabecera;
import com.nw.model.CalidadMuestraAreaCabeceraAnalisisProtocolo;
import com.nw.model.CalidadMuestraAreaDetalleMuestra;
//import com.nw.model.CamaraCajon;
//import com.nw.model.dao.CalidadBpmclasificacionDAO;


public class CalidadMuestrasClasificacionDAOJpaImpl {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadMuestrasClasificacionDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

    
    
    public Integer sumarsiaplicaaccioncorrectiva(int idcabecera)
    {
          //Date fecha;
          Query qry = em.createNativeQuery("select sum(cm1.onocaracteristico::INTEGER)::INTEGER   " +
                                                               " from " +
                                                               " calidad_muestra_area_cabecera_analisis_protocolo cm1 " + 
                                                               " inner JOIN calidad_muestra_area_cabecera cm2 " +
                                                               " on cm1.idcalidadmuestraareacabecera::INTEGER=cm2.idcalidadmuestraareacabecera::INTEGER " + 
                                                               " inner join calidad_muestra_grupo_subcaracteristicas ddd " +
                                                               " on ddd.idcalidadmuestragruposubcaracteristicas::INTEGER= cm1.idonocaracteristico::INTEGER " +
                                                               " where cm1.idcalidadmuestraareacabecera::INTEGER="+idcabecera+" AND ddd.estado=2");  
    
          try {
                return  (Integer) qry.getResultList().get(0);
          } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
          }
        
          
    }


    
    public Integer sumarpescadosproblemas(Integer idcabecera)
    {
          //Date fecha;
          Query qry = em.createNativeQuery("select sum(cm1.numeronocaracteristicos::INTEGER)::INTEGER   from calidad_muestra_area_detalle_muestra cm1 inner JOIN calidad_muestra_area_cabecera cm2 on cm1.idcalidadmuestraareacabecera::INTEGER=cm2.idcalidadmuestraareacabecera::INTEGER where cm1.idcalidadmuestraareacabecera::INTEGER="+idcabecera+"");  
    
          try {
                return  (Integer) qry.getResultList().get(0);
          } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
          }
        
          
    }
    
    
    
//    public Integer sumarpescadosproblemas(Integer idcabecera)
//    {
//          //Date fecha;
//          Query qry = em.createNativeQuery("select sum(cm1.numeronocaracteristicos::INTEGER)::INTEGER   from calidad_muestra_area_detalle_muestra cm1 inner JOIN calidad_muestra_area_cabecera cm2 on cm1.idcalidadmuestraareacabecera::INTEGER=cm2.idcalidadmuestraareacabecera::INTEGER where cm1.idcalidadmuestraareacabecera::INTEGER="+idcabecera+"");  
//    
//          try {
//                return  (Integer) qry.getResultList().get(0);
//          } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                return null;
//          }
//        
//          
//    }

    
    
    
    public Integer sumarpescadosproblemasl(Long idcabecera)
    {
          //Date fecha;
          Query qry = em.createNativeQuery("select sum(cm1.numeronocaracteristicos::INTEGER)::INTEGER   from calidad_muestra_area_detalle_muestra cm1 inner JOIN calidad_muestra_area_cabecera cm2 on cm1.idcalidadmuestraareacabecera::INTEGER=cm2.idcalidadmuestraareacabecera::INTEGER where cm1.idcalidadmuestraareacabecera::BIGINT="+idcabecera+"");  
    
          try {
                return  (Integer) qry.getResultList().get(0);
          } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
          }
        
          
    }    
    
//    public Integer sumarpescadosproblemas(Long idcabecera)
//	{
//		//Date fecha;
//		Query qry = em.createNativeQuery("select sum(cm1.numeronocaracteristicos::INTEGER)::INTEGER   from calidad_muestra_area_detalle_muestra cm1 inner JOIN calidad_muestra_area_cabecera cm2 on cm1.idcalidadmuestraareacabecera::INTEGER=cm2.idcalidadmuestraareacabecera::INTEGER where cm1.idcalidadmuestraareacabecera::INTEGER="+idcabecera+"");  
//	
//		try {
//			return  (Integer) qry.getResultList().get(0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	    
//		
//	}
    
    public Integer sumarsiaplicaaccioncorrectiva(Long idcabecera)
	{
    	System.out.println("AAAAAAA"+idcabecera);
		//Date fecha;
		Query qry = em.createNativeQuery("select sum(cm1.onocaracteristico::INTEGER)::INTEGER   " +
											" from " +
											" calidad_muestra_area_cabecera_analisis_protocolo cm1 " + 
											" inner JOIN calidad_muestra_area_cabecera cm2 " +
											" on cm1.idcalidadmuestraareacabecera::BIGINT=cm2.idcalidadmuestraareacabecera::BIGINT " + 
											" inner join calidad_muestra_grupo_subcaracteristicas ddd " +
											" on ddd.idcalidadmuestragruposubcaracteristicas::INTEGER= cm1.idonocaracteristico::INTEGER " +
											" where cm1.idcalidadmuestraareacabecera::BIGINT="+idcabecera+" AND ddd.estado=2");  
	
		try {
			return  (Integer) qry.getResultList().get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    
		
	}
    
    
    public Integer sumarsiaplicaaccioncorrectival(Long idcabecera)
	{
		//Date fecha;
		Query qry = em.createNativeQuery("select sum(cm1.onocaracteristico::INTEGER)::INTEGER   " +
											" from " +
											" calidad_muestra_area_cabecera_analisis_protocolo cm1 " + 
											" inner JOIN calidad_muestra_area_cabecera cm2 " +
											" on cm1.idcalidadmuestraareacabecera=cm2.idcalidadmuestraareacabecera " + 
											" inner join calidad_muestra_grupo_subcaracteristicas ddd " +
											" on ddd.idcalidadmuestragruposubcaracteristicas::INTEGER= cm1.idonocaracteristico::INTEGER " +
											" where cm1.idcalidadmuestraareacabecera::BIGINT="+idcabecera+" AND ddd.estado=2");  
	
		try {
			return  (Integer) qry.getResultList().get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    
		
	}    
    
    
    
    public Integer totalmuestras(int idcabecera)
    {
          //Date fecha;
          Query qry = em.createNativeQuery("select count(cm1.idcalidadmuestraareadetallemuestra::INTEGER)::INTEGER  from calidad_muestra_area_detalle_muestra cm1 inner JOIN calidad_muestra_area_cabecera cm2 on cm1.idcalidadmuestraareacabecera::INTEGER=cm2.idcalidadmuestraareacabecera::INTEGER where cm1.idcalidadmuestraareacabecera::INTEGER="+idcabecera+"");  
    
          try {
                return  (Integer) qry.getResultList().get(0);
          } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
          }
        
          
    }

    
//    public Integer totalmuestras(int idcabecera)
//  	{
//  		//Date fecha;
//  		Query qry = em.createNativeQuery("select sum(cm1.numeronocaracteristicos::INTEGER)::INTEGER + sum(cm1.numerocaracteristicos::INTEGER)::INTEGER+sum(cm1.numerootros::INTEGER)::INTEGER  from calidad_muestra_area_detalle_muestra cm1 inner JOIN calidad_muestra_area_cabecera cm2 on cm1.idcalidadmuestraareacabecera::INTEGER=cm2.idcalidadmuestraareacabecera::INTEGER where cm1.idcalidadmuestraareacabecera::INTEGER="+idcabecera+"");  
//  	
//  		try {
//  			return  (Integer) qry.getResultList().get(0);
//  		} catch (Exception e) {
//  			// TODO Auto-generated catch block
//  			e.printStackTrace();
//  			return null;
//  		}
//  	    
//  		
//  	}
	
	//@Override
	public CalidadMuestraAreaCabecera getCalidadMuestraClasificacionCabecerabyId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraAreaCabecera o "); 
		sb.append("Where o.idcalidadmuestraarea = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaCabecera) items.get(0);
        }		
	}	
	
	public CalidadMuestraAreaCabecera getCalidadMuestraClasificacionCabecerabyLoteHaccp(String loteHaccp, Long idarea, Integer idturno) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraAreaCabecera o "); 
		sb.append("Where o.lotehaccp = '" + loteHaccp + "'  and o.calidadMuestraArea.idcalidadmuestraarea="+idarea+" and o.turno.idturno="+idturno+"");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaCabecera) items.get(0);
        }		
	}	
	public CalidadMuestraAreaCabecera getCalidadMuestraClasificacionCabecerabyLoteHaccpandLotePlanta(String loteHaccp, Long idarea, Integer idturno,Integer idlote) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraAreaCabecera o "); 
		sb.append("Where o.lotehaccp = '" + loteHaccp + "'  and o.calidadMuestraArea.idcalidadmuestraarea="+idarea+" and o.turno.idturno="+idturno+" and o.produccionDetalleLote.idlote="+idlote+" ");
		System.out.println(sb.toString());
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaCabecera) items.get(0);
        }		
	}	
	public CalidadMuestraAreaCabeceraAnalisisProtocolo getCMACAPbyidCabecera(Long idcabecera) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraAreaCabeceraAnalisisProtocolo o "); 
		sb.append("Where o.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera = " + idcabecera + "  ");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaCabeceraAnalisisProtocolo) items.get(0);
        }		
	}	
	

	public void saveOrUpdate(CalidadMuestraAreaCabecera cmcc) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cmcc);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	public void saveOrUpdateCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra cmcc) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cmcc);
						
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				
				em.close();
			}
	}
	public void saveOrUpdateCalidadMuestraAreaCabeceraAnalisisProtocolo(CalidadMuestraAreaCabeceraAnalisisProtocolo cmcc) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cmcc);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

	 public int deletedetallemuestra(CalidadMuestraAreaDetalleMuestra  RC) {
			EntityManagerFactory emf = JPAPersistenceManager.getInstance()
					.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
	         int r= 0;
	         Long id = RC.getIdcalidadmuestraareadetallemuestra();
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				 Query query = em.createQuery("Delete from CalidadMuestraAreaDetalleMuestra where idcalidadmuestraareadetallemuestra = :idbc");
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

	@SuppressWarnings("unchecked")
	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraDetalle(Long idcabecera) {
		// TODO Auto-generated method stub
		List<CalidadMuestraAreaDetalleMuestra> listaCalidadMuestraDetalle = new ArrayList<CalidadMuestraAreaDetalleMuestra>();  
		Query query =  em.createQuery(" select becm from CalidadMuestraAreaDetalleMuestra becm" +
				" where becm.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera=:idcalidadmuestraareacabecera   ");
				query.setParameter("idcalidadmuestraareacabecera", idcabecera);		  			
	  			listaCalidadMuestraDetalle = query.getResultList();
	  			
		return listaCalidadMuestraDetalle;
	}



 	/*27-02-2018 */
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraDetalleDescendente(Long idcabecera) {
		// TODO Auto-generated method stub
		List<CalidadMuestraAreaDetalleMuestra> listaCalidadMuestraDetalle = new ArrayList<CalidadMuestraAreaDetalleMuestra>();  
		Query query =  em.createQuery(" select becm from CalidadMuestraAreaDetalleMuestra becm" +
				" where becm.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera=:idcalidadmuestraareacabecera  " +
				" order by becm.idcalidadmuestraareadetallemuestra desc ");
				query.setParameter("idcalidadmuestraareacabecera", idcabecera);		  			
	  			listaCalidadMuestraDetalle = query.getResultList();
	  			
		return listaCalidadMuestraDetalle;
	}



}
