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
import com.nw.model.CalidadMuestraArea;
import com.nw.model.CalidadMuestraAreaCabecera;
import com.nw.model.CalidadMuestraAreaCabeceraAprobacion;
import com.nw.model.CalidadMuestraAreaDetalle;
import com.nw.model.CalidadMuestraTipoAnalisi;
import com.nw.model.dao.CalidadMuestraAreaDetalleDAO;


public class CalidadMuestraAreaDetalleDAOJpaImpl extends BaseDaoJpaImpl implements CalidadMuestraAreaDetalleDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadMuestraAreaDetalleDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }


    
//	public CalidadMuestraAreaDetalle getFindCalidadMuestraAreaDetallebyId(Long Id) {
//		return em.find(CalidadMuestraAreaDetalle.class, Id);	
//	}    
	
	
	//@Override
	public CalidadMuestraAreaDetalle getCalidadMuestraAreaDetallebyId(String id, String reg, String idg) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraAreaDetalle o "); 
		sb.append("Where o.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera = '" + id + "' ");
		sb.append("and o.ordenregistro = '" + reg + "' and o.idcalidadmuestragrupoanalisis = '" + idg + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaDetalle) items.get(0);
        }		
	}	
    
    
	
	//@Override
	public CalidadMuestraAreaDetalle getCalidadMuestraAreaDetallebyIdMotivo(String id, String reg, String idg, String idmotivo) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraAreaDetalle o "); 
		sb.append("Where o.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera = '" + id + "' ");
		sb.append("and o.ordenregistro = '" + reg + "' and o.idcalidadmuestragrupoanalisis = '" + idg + "'");		
		sb.append("and o.calidadMuestraCabeceraDescargaMotivo.idcalidadmuestracabeceradescargamotivo = '" + idmotivo + "'");
		
		
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaDetalle) items.get(0);
        }		
	}	
	

	
	
	 @SuppressWarnings("unchecked")
	 public List<CalidadMuestraArea> getCalidadMuestraAreas() 
	 {
		   List<CalidadMuestraArea> lista = new ArrayList<CalidadMuestraArea>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select cc from CalidadMuestraArea cc " +
					" order by cc.descripcion ");	
			 lista = query.getResultList();
			
			return lista;
	 }    
    

		@SuppressWarnings("unchecked")
		public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraHaccp(Long idcma)
		{
			List<CalidadMuestraAreaCabecera> ddpt = new ArrayList<CalidadMuestraAreaCabecera>();
			try {
				Query qry = em.createQuery("select cc from CalidadMuestraAreaCabecera cc " +
						" where cc.calidadMuestraArea.idcalidadmuestraarea= :pidcma and cc.aplicaaccioncorrectiva = true and " +
						" cc.barcoDescarga.idbarcodescarga >= 839 " +
						" order by cc.barcoDescarga.idbarcodescarga, cc.lotehaccp ");
				qry.setParameter("pidcma", idcma);
				ddpt = qry.getResultList();
				return ddpt;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}			
		}	 

		
		
		@SuppressWarnings("unchecked")
		public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraByHaccp(String lot)
		{
			List<CalidadMuestraAreaCabecera> ddpt = new ArrayList<CalidadMuestraAreaCabecera>();
			try {
				Query qry = em.createQuery("select cc from CalidadMuestraAreaCabecera cc " +
						" where cc.lotehaccp = :plot ");
				qry.setParameter("plot", lot);
				ddpt = qry.getResultList();
				return ddpt;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
			
		}		
		
		
		
		
		
		
		
		
		
		@SuppressWarnings("unchecked")
		public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraByBarcoDescarga(Long id)
		{
			List<CalidadMuestraAreaCabecera> ddpt = new ArrayList<CalidadMuestraAreaCabecera>();
			try {
				Query qry = em.createQuery("select cc from CalidadMuestraAreaCabecera cc " +
						" where cc.barcoDescarga.idbarcodescarga= :pid order by cc.lotehaccp, cc.calidadMuestraArea.ordenArea ");
				qry.setParameter("pid", id);
				ddpt = qry.getResultList();
				return ddpt;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
			
		}		

		
		@SuppressWarnings("unchecked")
		public List<CalidadMuestraAreaDetalle> getCalidadMuestraAreaDetalles(Long id, Integer idcalidadmuestragrupoanalisis)
		{
			// idcalidadmuestragrupoanalisis; 1= SAL; 2=HISTAMINA
			
			List<CalidadMuestraAreaDetalle> ddpt = new ArrayList<CalidadMuestraAreaDetalle>();
			try {
				Query qry = em.createQuery("select cc from CalidadMuestraAreaDetalle cc " +
						" where cc.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera= :pid and " +
						" cc.idcalidadmuestragrupoanalisis= :pig order by cc.ordenregistro ");
				qry.setParameter("pid", id);
				qry.setParameter("pig", idcalidadmuestragrupoanalisis);
				ddpt = qry.getResultList();
				return ddpt;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
			
		}		

		
		
		@SuppressWarnings("unchecked")
		public List<CalidadMuestraAreaDetalle> getCalidadMuestraAreaDetallesPorMotivo(Long id, Integer idcalidadmuestragrupoanalisis, Long idmotivo)
		{
			// idcalidadmuestracabeceradescargamotivo; MOTIVO EN DESCARGA
			
			List<CalidadMuestraAreaDetalle> ddpt = new ArrayList<CalidadMuestraAreaDetalle>();
			try {
				Query qry = em.createQuery("select cc from CalidadMuestraAreaDetalle cc " +
						" where cc.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera= :pid and " +
						" cc.idcalidadmuestragrupoanalisis= :pig and cc.calidadMuestraCabeceraDescargaMotivo.idcalidadmuestracabeceradescargamotivo =:pidmotivo " +
						" order by cc.ordenregistro ");
				qry.setParameter("pid", id);
				qry.setParameter("pig", idcalidadmuestragrupoanalisis);
				qry.setParameter("pidmotivo", idmotivo);
				ddpt = qry.getResultList();
				return ddpt;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
			
		}		
		
	 
	 
	 @SuppressWarnings("unchecked")
	 public List<CalidadMuestraTipoAnalisi> getCalidadMuestraTipoAnalisi() 
	 {
		   List<CalidadMuestraTipoAnalisi> lista = new ArrayList<CalidadMuestraTipoAnalisi>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select cc from CalidadMuestraTipoAnalisi cc order by cc.compositas ");	
			 lista = query.getResultList();
			
			return lista;
	 }	 
	 
	 

	 
	 
		//@Override
		public CalidadMuestraAreaCabecera getListaCalidadMuestraAreaCabecerabyId(String id) 
		{ 
			
			StringBuffer sb = new StringBuffer();
			sb.append("Select o "); 
			sb.append("From CalidadMuestraAreaCabecera o "); 
			sb.append("Where o.idcalidadmuestraareacabecera = '" + id + "'");
			
			//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

			List items =  em.createQuery(sb.toString()).getResultList();

	        if (items == null || items.isEmpty()) {
	            return null;
	        } else {
	            return  (CalidadMuestraAreaCabecera) items.get(0);
	        }		
		}
		

	
	//@Override
	public CalidadMuestraAreaCabecera getCalidadMuestraAreaCabecerabyId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From CalidadMuestraClasificacionCabecera o "); 
		sb.append("Where o.idcalidadmuestraclasificacioncabecera = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (CalidadMuestraAreaCabecera) items.get(0);
        }		
	}	
	
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraByBarcoDescargaArea1(Long id) 
	{ 
		
		  List<CalidadMuestraAreaCabecera> lista = new ArrayList<CalidadMuestraAreaCabecera>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select o from CalidadMuestraAreaCabecera o Where o.barcoDescarga.idbarcodescarga = " + id + " and o.calidadMuestraArea.idcalidadmuestraarea=3 and o.aprobado is NULL");	
			 lista = query.getResultList();
			
			return lista;
		
	}	
	
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraByBarcoDescargaArea11(Long id) 
	{ 
		
		  List<CalidadMuestraAreaCabecera> lista = new ArrayList<CalidadMuestraAreaCabecera>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select o from CalidadMuestraAreaCabecera o Where o.barcoDescarga.idbarcodescarga = " + id + " and o.calidadMuestraArea.idcalidadmuestraarea in (1,4) and o.aprobado is NULL");	
			 lista = query.getResultList();
			
			return lista;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraByBarcoDescargaArea2(Long id) 
	{ 
		
		  List<CalidadMuestraAreaCabecera> lista = new ArrayList<CalidadMuestraAreaCabecera>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select o from CalidadMuestraAreaCabecera o Where o.barcoDescarga.idbarcodescarga = " + id + " and o.calidadMuestraArea.idcalidadmuestraarea=2 and o.aprobado is NULL ");	
			 lista = query.getResultList();
			
			return lista;
		
	}	
	
	
	/* Sin estado de aprobacion , para el metodo*/
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraByBarcoDescargaArea11SinAp(Long id) 
	{ 
	    List<CalidadMuestraAreaCabecera> lista = new ArrayList<CalidadMuestraAreaCabecera>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select o from CalidadMuestraAreaCabecera o Where o.barcoDescarga.idbarcodescarga = " + id + " and o.calidadMuestraArea.idcalidadmuestraarea in (1,4) ");	
			 lista = query.getResultList();
	    return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraByBarcoDescargaArea1SinAp(Long id) 
	{ 
		  List<CalidadMuestraAreaCabecera> lista = new ArrayList<CalidadMuestraAreaCabecera>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select o from CalidadMuestraAreaCabecera o Where o.barcoDescarga.idbarcodescarga = " + id + " and o.calidadMuestraArea.idcalidadmuestraarea=3 ");	
			 lista = query.getResultList();
	     return lista;
	}	
	
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceraByBarcoDescargaArea2SinAp(Long id) 
	{ 
		  List<CalidadMuestraAreaCabecera> lista = new ArrayList<CalidadMuestraAreaCabecera>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select o from CalidadMuestraAreaCabecera o Where o.barcoDescarga.idbarcodescarga = " + id + " and o.calidadMuestraArea.idcalidadmuestraarea=2 ");	
			 lista = query.getResultList();
			
			return lista;
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<CalidadMuestraAreaCabeceraAprobacion> getCalidadMuestraAreaCabeceraAprobacionByIdCmac(Long id) 
	{ 
		  List<CalidadMuestraAreaCabeceraAprobacion> lista = new ArrayList<CalidadMuestraAreaCabeceraAprobacion>();  
			//Muesra la lista de todos los cajons con estado 1
			 Query query =  em.createQuery(" select o from CalidadMuestraAreaCabeceraAprobacion o Where o.calidadMuestraAreaCabecera.idcalidadmuestraareacabecera = " + id );	
			 lista = query.getResultList();
			return lista;
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

	public void saveOrUpdateAprobacion(CalidadMuestraAreaCabeceraAprobacion cmcc) {

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
	public void saveOrUpdateDetalle(CalidadMuestraAreaDetalle cmcd) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cmcd);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	
	
	


}
