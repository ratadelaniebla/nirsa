package com.nw.model.dao.impl;

 


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraCajonUbicacion;
import com.nw.model.dao.CamaraCajonUbicacionDAO;
 

public class CamaraCajonUbicacionDAOJpaImpl extends BaseDaoJpaImpl implements CamaraCajonUbicacionDAO {

	@PersistenceContext
	private EntityManagerFactory emf ;
	private EntityManager em ;
	
	public CamaraCajonUbicacionDAOJpaImpl() {
		// emf = Persistence.createEntityManagerFactory("NW");
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	public void actualizarCamaraCajon (CamaraCajon cc)
	{
		 EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		 EntityManager em = emf.createEntityManager();
		 
			try{
		    	 EntityTransaction t = em.getTransaction();
		    	  try {
						t.begin();  
						em.merge(cc);
				        t.commit();
		   		  } finally {
		   		    if (t.isActive()) t.rollback();
		   		  }
					}finally{
						em.close();
				   }
		 
	}
 
	//este metodo recive el id max de camaracajon
	/**
	 * Este metodo recibe dos objetos CamaraCajonUbicacion y CamaraCajon
	 * la idea es q en donde esta el CamaraCajon se invoque otro metodo q me devuelve un objeto
	 * CamaraCajon con el id max del mismo y con esto lo asigno a CamaraCajonUbicacion para guardarlo
	 * @param ccu
	 * @param cc
	 */
	public void guardarCamaraCajonUbicacion(CamaraCajonUbicacion ccu, CamaraCajon cc )
	{
		 EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		 EntityManager em = emf.createEntityManager();
		 Long i;
		//asgino el ultimo id de camaraCajon
		ccu.setCamaraCajon(cc);
		try{
    	 EntityTransaction t = em.getTransaction();
    	  try {
			t.begin();  
//			Query qry = em.createQuery("SELECT MAX(c.idcamaracajonubicacion) FROM CamaraCajonUbicacion c");
//		    Object valorMaximoObjeto = qry.getSingleResult();
//			if (valorMaximoObjeto==null) {//pregunto esto x si la tabla esta vacia 
//				i=(long) 0;
//			}
//			i = (Long.valueOf((Long) valorMaximoObjeto));
//			ccu.setIdcamaracajonubicacion(i+1);//aumento en uno para guardar el registro con la secuencia correspondiente
			em.merge(ccu);
	        t.commit();
   		  } finally {
   		    if (t.isActive()) t.rollback();
   		  }
			}finally{
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

	@Override
	public void saveOrUpdate(CamaraCajonUbicacion camaraCajonUbicacion) {
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
				t.begin();  
				em.merge(camaraCajonUbicacion);
		        t.commit();
	   		  } finally {
	   		    if (t.isActive()) t.rollback();
	   		  }
				}finally{
					em.close();
			   }
		
	}
	
	
	// public DesperdicioCajonHarina getFindDesperdicioCajonHarinaId(Integer
	// vid) {
	// return em.find(DesperdicioCajonHarina.class, vid);
	// }
	//
	// public List<DesperdicioCajonHarina> getCajonesRecepcionHarina(
	// Integer diajuliano) {
	// return em
	// .createQuery(
	// "select dch from DesperdicioCajonHarina dch, Cajon c where dch.diajuliano = :vdiajuliano and dch.cajon.idcajon = c.idcajon and c.estadocajon = 3 and dch.turno3 is null order by c.idcajon")
	// .setParameter("vdiajuliano", diajuliano).getResultList();
	// }
	//
	// public DesperdicioCajonHarina getDesperdicioCajonHarinaId(String id) {
	//
	// StringBuffer sb = new StringBuffer();
	// sb.append("Select o ");
	// sb.append("From DesperdicioCajonHarina o ");
	// sb.append("Where o.iddesperdiciocajonharina = '" + id + "'");
	//
	// // logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());
	//
	// List items = em.createQuery(sb.toString()).getResultList();
	//
	// if (items == null || items.isEmpty()) {
	// return null;
	// } else {
	// return (DesperdicioCajonHarina) items.get(0);
	// }
	// }

}
