package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.DesperdicioCajonHarina;
import com.nw.model.DesperdicioDetalle;
import com.nw.model.dao.DesperdicioDetalleDAO;

@SuppressWarnings("unchecked")
public class DesperdicioDetalleDAOJpaImpl extends BaseDaoJpaImpl implements DesperdicioDetalleDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public DesperdicioDetalleDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public DesperdicioDetalle getFindDesperdicioDetalleId(Integer vid) {
		return em.find(DesperdicioDetalle.class, vid);	
	}	    
   
    
//	public List<DesperdicioCajonHarina> getCajonesDesperdicioDetalle() {
//		return em.createQuery("select dch from DesperdicioCajonHarina dch, Cajon c where dch.cajon.idcajon = c.idcajon and c.estadocajon = 2 order by c.idcajon").getResultList();
//	}
	
	public List<DesperdicioDetalle> getCajonesAgrupadosDesperdicioDetalle(String id, String f1, boolean b, Long vIddesperdiciocajonharina) {

		System.out.println(String.valueOf(vIddesperdiciocajonharina));

		
		if(b == true)
		{
			//Creado
			//1 = Cajon reservado
			//2 = Cerrado por Desperdicio
			//3 = Cerrado por Harina
			return em.createQuery("Select o From DesperdicioDetalle o Where o.desperdicioCajonHarina.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"'").getResultList();
			
			//return em.createQuery("select dd from DesperdicioCajonHarina dch, DesperdicioDetalle dd where dch.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"' and (dch.pesoharina > 0 or dch.sello1desperdicio != '')  and dch.cajon.idcajon = '"+id+"' and dch.fechaproduccion = '"+f1+"' and dch.iddesperdiciocajonharina = dd.desperdicioCajonHarina.iddesperdiciocajonharina ").getResultList();			
		}
		else
		{
			//Creado
			//1 = Cajon reservado
			//2 = Cerrado por Desperdicio
			//3 = Cerrado por Harina
			return em.createQuery("Select o From DesperdicioDetalle o Where o.desperdicioCajonHarina.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"'").getResultList();
			
			//return em.createQuery("select dd from DesperdicioCajonHarina dch, DesperdicioDetalle dd where dch.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"' and dch.fechaselladodesperdicio is null and dch.cajon.idcajon = '"+id+"' and dch.fechaproduccion = '"+f1+"' and dch.iddesperdiciocajonharina = dd.desperdicioCajonHarina.iddesperdiciocajonharina ").getResultList();			
		}
		
//		if(b == true)
//		{
//			return em.createQuery("select dd from DesperdicioCajonHarina dch, DesperdicioDetalle dd where dch.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"' and  dch.cajon.estadocajon = 3 and dch.cajon.idcajon = '"+id+"' and dch.fechaproduccion = '"+f1+"' and dch.iddesperdiciocajonharina = dd.desperdicioCajonHarina.iddesperdiciocajonharina ").getResultList();			
//		}
//		else
//		{
//			return em.createQuery("select dd from DesperdicioCajonHarina dch, DesperdicioDetalle dd where dch.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"' and dch.cajon.estadocajon = 2 and dch.cajon.idcajon = '"+id+"' and dch.fechaproduccion = '"+f1+"' and dch.iddesperdiciocajonharina = dd.desperdicioCajonHarina.iddesperdiciocajonharina ").getResultList();			
//		}
		
	}

	
	public List<DesperdicioDetalle> getCajonesAgrupadosDesperdicioDetalleSinSello(String id, String f1, boolean b, Long vIddesperdiciocajonharina) {

		System.out.println(String.valueOf(vIddesperdiciocajonharina));
		
		if(b == true)
		{
			//Creado
			//1 = Cajon reservado
			//2 = Cerrado por Desperdicio
			//3 = Cerrado por Harina
			return em.createQuery("Select o From DesperdicioDetalle o Where o.desperdicioCajonHarina.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"'").getResultList();
			
			//return em.createQuery("select dd from DesperdicioCajonHarina dch, DesperdicioDetalle dd where dch.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"' and (dch.pesoharina > 0 or dch.sello1desperdicio != '')  and dch.cajon.idcajon = '"+id+"' and dch.fechaproduccion = '"+f1+"' and dch.iddesperdiciocajonharina = dd.desperdicioCajonHarina.iddesperdiciocajonharina ").getResultList();			
		}
		else
		{
			//Creado
			//1 = Cajon reservado
			//2 = Cerrado por Desperdicio
			//3 = Cerrado por Harina
			return em.createQuery("Select o From DesperdicioDetalle o Where o.desperdicioCajonHarina.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"'").getResultList();
			
			//return em.createQuery("select dd from DesperdicioCajonHarina dch, DesperdicioDetalle dd where dch.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"' and dch.fechaselladodesperdicio is null and dch.cajon.idcajon = '"+id+"' and dch.fechaproduccion = '"+f1+"' and dch.iddesperdiciocajonharina = dd.desperdicioCajonHarina.iddesperdiciocajonharina ").getResultList();			
		}
		
	}	
	
	
	
	public Long getMaxIdDesperdicioDetalle()
	{
		Query qry = em.createQuery("SELECT MAX(t.iddesperdiciodetalle) FROM DesperdicioDetalle t");
		Object obj = qry.getSingleResult();
	    if(obj==null) return (long) 0;
	    return (Long)obj;
	}
    

	public Double getTotalPesoNetoDesperdicio(Long vIddesperdiciocajonharina)
	{
		Query qry = em.createQuery("SELECT SUM(t.pesoneto) FROM DesperdicioDetalle t where t.desperdicioCajonHarina.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"'");
		Object obj = qry.getSingleResult();
	    if(obj==null) return (Double) 0.0;
	    return (Double)obj;
	}	
	

	public Double getTotalPesoNetoHarina(Long vIddesperdiciocajonharina)
	{
		Query qry = em.createQuery("SELECT t.pesoharina - t.tara FROM DesperdicioCajonHarina t where t.iddesperdiciocajonharina = '"+String.valueOf(vIddesperdiciocajonharina)+"'");
		Object obj = qry.getSingleResult();
	    if(obj==null) return (Double) 0.0;
	    return (Double)obj;
	}
	
	
	public DesperdicioDetalle getDesperdicioDetalleId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From DesperdicioDetalle o "); 
		sb.append("Where o.iddesperdiciodetalle = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (DesperdicioDetalle) items.get(0);
        }		
	}	
	
//	public List<DesperdicioDetalle> getCajonesDesperdicioDetalle() {
//		return em.createQuery("select dd from DesperdicioDetalle dd ").getResultList();
//	}
	
	/*
	 * Ejemplos de consultas nativas...
	 * 
	Query query = em.createNativeQuery("SELECT * FROM EMPLOYEE", Employee.class);
	List<Employee> result = query.getResultList();

	Query query = em.createNativeQuery("SELECT SYSDATE FROM DUAL");
	Date result = (Date)query.getSingleResult();

	Query query = em.createNativeQuery("SELECT MAX(SALARY), MIN(SALARY) FROM EMPLOYEE");
	List<Object[]> results = query.getResultList();
	int max = results.get(0)[0];
	int min = results.get(0)[1];

	Query query = em.createNativeQuery("DELETE FROM EMPLOYEE");
	int rowCount = query.executeUpdate();
	*/

	@Override
	public void saveOrUpdate(DesperdicioDetalle desperdiciodetalle) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(desperdiciodetalle);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	
	//Eliminamos el Objeto
	public void remove(DesperdicioDetalle desperdiciodetalle) {
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					DesperdicioDetalle o = (DesperdicioDetalle) em.find(DesperdicioDetalle.class, desperdiciodetalle.getIddesperdiciodetalle());
					if (o != null){
						em.remove(o);
						t.commit();
					}
		   	 } finally {
		   		 if (t.isActive()) t.rollback();
		   	 }
		}finally{
			em.close();
		}
	}	
	
}
