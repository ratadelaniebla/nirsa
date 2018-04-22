package com.avante.core.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import org.zkoss.zk.ui.Sessions;

public class JPAPersistenceManager {

	  public static final boolean DEBUG = true;    
	  private static final JPAPersistenceManager singleton = new JPAPersistenceManager();    
	  protected EntityManagerFactory emf;
	  @SuppressWarnings("unused")
	  private static String vDBMS = (String) Sessions.getCurrent().getAttribute("MSSQL"); 
	  
	  public static JPAPersistenceManager getInstance() 
	  {        
		  return singleton;  
	  }
	  
	  public JPAPersistenceManager() { 
		  
	  }   
	  
	  public EntityManagerFactory getEntityManagerFactory() {        
		  if (emf == null)      
			  	createEntityManagerFactory();    
		  		return emf;  
		  }
	  
	  public void closeEntityManagerFactory() {        
		
		  if (emf != null) {      
			  	emf.close();      
			  	emf = null;      
			  	if (DEBUG)        
			  		System.out.println("n*** Persistence finished at " + new java.util.Date());    
		  		}  
		  }  
	  
	  protected void createEntityManagerFactory() {        
		  this.emf = Persistence.createEntityManagerFactory("NW", new java.util.HashMap());    
		  if (DEBUG)      
			  System.out.println("n*** Persistence started at " + new java.util.Date());  
		  }
   	   
	 	public List getList(String sql){

	 		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
 		    EntityManager em = emf.createEntityManager();        
	 		try { 
		        Query query = em.createQuery(sql);	
		        List results = query.getResultList();
		        return results; 
	 		} finally {            
	 			em.close();
	 			//emf.close();        
	    	}
	 	}


		public List getList(String sql,String tipo){
	        Query query;

	        EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	        EntityManager em = emf.createEntityManager();        
	        //entityManager.getTransaction().begin();
	 		try { 
		        if (tipo.equals("NATIVO")) {
			        query = em.createNativeQuery(sql);	
		        }
		        else {
			        query = em.createQuery(sql);	
		        };
				List results = query.getResultList();
		        return results; 
	 		} finally {            
	 			em.close();
	 			//emf.close();        
	 		}
	 	}

	    public int getCount(String sql,String tipo) {   
	        Query query;
 			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
 		    EntityManager em = emf.createEntityManager();        
	        //entityManager.getTransaction().begin();
	 		try { 
		        if (tipo.equals("NATIVO")) {
			        query = em.createNativeQuery(sql);	
		        }
		        else {
			        query = em.createQuery(sql);	
		        };
		        List results = query.getResultList();
		        //return Sistema.parseInt(results.get(0).toString());
		        return 0;
	 		} finally {            
		        em.close();
	 			//emf.close();        
	    	}
	    }

}
