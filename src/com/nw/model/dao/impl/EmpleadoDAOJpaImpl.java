package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
/*import javax.persistence.Query;*/

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
/*import com.nw.model.Barco;
import com.nw.model.BarcoCuba;
import com.nw.model.CalidadDetallePcc;*/
import com.nw.model.CalidadSensorialMp;
import com.nw.model.Empleado;
/*import com.nw.model.LimpiezaSecuenciaOrden;*/
import com.nw.model.dao.EmpleadoDAO;

@SuppressWarnings("unchecked")
public class EmpleadoDAOJpaImpl extends BaseDaoJpaImpl implements EmpleadoDAO {

 
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public EmpleadoDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

//	public Empleado getFinEmpleadoId(String id) {
//		return em.find(Empleado.class, id);	
//	}

	
/*    
    public Empleado getFinEmpleadoId(String id){
    	Empleado empleado;
    	try {
    		Query qry = em.createQuery(" select b from Empleado b where b.codpersona=:idbc");
    		qry.setParameter("idbc", id);
    		empleado = (Empleado) qry.getSingleResult(); 
    		return empleado;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }    
*/    
    
	public Empleado getFinEmpleadoId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select b "); 
		sb.append("from Empleado b "); 
		sb.append("where b.codpersona = '" + id + "'"); 
		
 

		List items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (Empleado) items.get(0);
        }		
	}    
    
 
	
	
	public Empleado getFinEmpleadoCedula(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select b "); 
		sb.append("from Empleado b "); 
		sb.append("where b.cedula = '" + id.trim() + "'"); 
		
 

		List items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (Empleado) items.get(0);
        }		
	}	
	
    
	
	
	@Override
	public List<Empleado> getEmpleados() {
		return em.createQuery("select e from Empleado e ").getResultList(); //order by e.nombres
	}

	public List<Empleado> getEmpleados2() {
		return em.createQuery("select e from Empleado e order by e.codpersona").getResultList(); //order by e.nombres
	}	
	
	public void saveOrUpdate(Empleado empleado) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(empleado);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	
	
    public Empleado getFinEmpleadoByCedula(String id) 
    { 
          
          StringBuffer sb = new StringBuffer();
          sb.append("select b "); 
          sb.append("from Empleado b "); 
          sb.append("where b.cedula = '" + id.trim() + "'"); 
          

          List items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();

     if (items == null || items.isEmpty()) {
         return null;
     } else {
         return  (Empleado) items.get(0);
     }           
    }    
	
    public Empleado getFinEmpleadoByCodigo(String id) 
    { 
          
          StringBuffer sb = new StringBuffer();
          sb.append("select b "); 
          sb.append("from Empleado b "); 
          sb.append("where b.codpersona = '" + id.trim() + "'"); 
          

          List items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();

     if (items == null || items.isEmpty()) {
         return null;
     } else {
         return  (Empleado) items.get(0);
     }           
    }    

    public Empleado getFinEmpleadoCodigoEvolution(String id) 
    { 
          
          StringBuffer sb = new StringBuffer();
          sb.append("select b "); 
          sb.append("from Empleado b "); 
          sb.append("where b.codigoevolution = '" + id.trim() + "'"); 
          

          List items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();

      if (items == null || items.isEmpty()) {
          return null;
      } else {
          return  (Empleado) items.get(0);
      }         
    }     
    

    
}
