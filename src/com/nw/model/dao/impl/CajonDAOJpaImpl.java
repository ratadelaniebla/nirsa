package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Cajon;
import com.nw.model.CamaraCajon;
import com.nw.model.dao.CajonDAO;


/*import com.wm.model.MedioPeriodo;
import com.wm.model.MedioPeriodoPK;
import com.wm.model.dao.MedioPeriodoDAO;*/


@SuppressWarnings("unchecked")
public class CajonDAOJpaImpl extends BaseDaoJpaImpl implements CajonDAO {

	private static Log logger = LogFactory.getLog(CajonDAOJpaImpl.class);

	@PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;
	
    public CajonDAOJpaImpl() {

   //    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
     
//    public List<Cajon> getCajonyId1(String id) {
//		return em.createQuery("select c from Cajon c WHERE c.idcajon = '"  + id + "' ").getResultList();
//	}	

    
  public List<Cajon> getCajonesDesperdicio() {
	  
			//Muesra la lista de todos los cajons (menos los prederminados para el area de desperdicio)
			return em.createQuery("select c from Cajon c where c.estadocajon = 1 and c.area.idarea = 17 order by c.area.idarea ").getResultList();			
	}	    
    
  
  public List<Cajon> getCajonesEstadoUno() {
      //Muesra la lista de todos los cajons con estado 1
	  return em.createQuery("select c from Cajon c where c.estadocajon = 1 order by c.idcajon ").getResultList();   
      
  }
  
  
	public Cajon getCajonyId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From Cajon o "); 
		sb.append("Where o.idcajon = '" + id.trim() + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (Cajon) items.get(0);
        }		
	}   

	@Override
	public void saveOrUpdate(Cajon cajon) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(cajon);
	 			        t.commit();
   		  } finally {
   		    if (t.isActive()) t.rollback();
   		  }
			}finally{
				em.close();
				//emf.close();
			}
		
	}	
	
	  public List<Cajon> getCajonesporLote(Integer idlote) {
	      //Muesra la lista de todos los cajones relacionados al lote escogido
		  Query qry = em.createQuery("select c from Cajon c " +
			  		"inner join c.camaraCajons cc " +
			  		"inner join cc.produccionDetalleLoteCajons pdlc " +
			  		"inner join pdlc.produccionDetalleLote pdl " +
			  		"where pdl.idlote = :idlot");
		  qry.setParameter("idlot", idlote);
		  return qry.getResultList();
	  }
	  
	  public CamaraCajon getCajones(String idcaj) {
	        
		  Query qry = em.createQuery("select cc from CamaraCajon cc " +
		  		"inner join cc.cajon c " +
				  "where c.idcajon = :caj and cc.estado in (0,1,5) " +
				  " and cc.idcamaracajon not in (select ddp.produccionDetalleLoteCajon.camaraCajon.idcamaracajon from DescongeladoDetalleProceso ddp)  " +
				  " order by cc.idcamaracajon desc ");
		  qry.setParameter("caj", idcaj);
		  
		  
		  List<CamaraCajon> listaResul = new ArrayList<CamaraCajon>();
		  listaResul  =  (List<CamaraCajon>) qry.getResultList();
			
			if (listaResul.size()==0) {
				return null;
			}else {
				return listaResul.get(0);
			}
			
		  
		  //return (CamaraCajon) qry.getSingleResult();
	  }
	  
	  
	  public List<CamaraCajon> getListadoCajones(String idcajon) {
	        
		  Query qry = em.createQuery("select cc from CamaraCajon cc " +
		  		"inner join cc.cajon c " +
				  "where c.idcajon = :caj and cc.estado in (0,1,2,5) " +
				  " and cc.idcamaracajon not in (select ddp.produccionDetalleLoteCajon.camaraCajon.idcamaracajon from DescongeladoDetalleProceso ddp)  " +
				  " order by cc.idcamaracajon desc ");
		  qry.setParameter("caj", idcajon.trim());
		  
		  List<CamaraCajon> listaResul = new ArrayList<CamaraCajon>();
		  listaResul  =  (List<CamaraCajon>) qry.getResultList();
		  
		  return listaResul;
	  }
	
}	


