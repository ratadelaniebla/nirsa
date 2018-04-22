package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoDescarga;
import com.nw.model.CalidadDetalleEspecietallaCajonBanda;
import com.nw.model.Especie;
import com.nw.model.EspecieTalla;
import com.nw.model.dao.EspecieTallaDAO;

@SuppressWarnings("unchecked")
public class EspecieTallaDAOJpaImpl extends BaseDaoJpaImpl implements EspecieTallaDAO {

	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public EspecieTallaDAOJpaImpl(){
    	//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
	public List<EspecieTalla> getEspecieTalla() {
		return em.createQuery("select et from EspecieTalla et order by et.idespecietalla").getResultList();
	}

 	public List<Especie> getEspecieSJYFBE() 
	{
	   String sql =  "select et from Especie et where et.idespecie in (1,2,3) order by et.idespecie ";	
		return em.createQuery(sql).getResultList();
	}
 	
	public List<EspecieTalla> getEspecieTalla(String condicion, boolean checked) 
	{
		
		String cad;
		if (checked == true)
		{
			cad =  "select et from EspecieTalla et where et.especie.idespecie in (1,2,3, 15, 31) ";
			
			if (condicion == "1" || condicion == "2") {
				return em.createQuery(cad + " and  et.idespecietalla > 300000 order by et.idespecietalla").getResultList();
			}
			else
/*				return em.createQuery(cad + " and ((et.idespecietalla < 302736) or (et.idespecietalla >= 305058)) order by et.idespecietalla").getResultList();*/
				return em.createQuery(cad + " and ((et.idespecietalla < 302746) or (et.idespecietalla >= 305058)) " +
						" and (et.idespecietalla <> 765) order by et.idespecietalla").getResultList();
		}
		else
			{
			cad =  "select et from EspecieTalla et ";
			
			if (condicion == "1" || condicion == "2") {
				return em.createQuery(cad + " where et.idespecietalla > 300000 order by et.idespecietalla").getResultList();
			}
			else
				return em.createQuery(cad + " where ((et.idespecietalla < 302746) or (et.idespecietalla >= 305058)) " +
						" and (et.idespecietalla <> 765) order by et.idespecietalla").getResultList();
			}
		
	}


	public List<CalidadDetalleEspecietallaCajonBanda> getEspecieTallaByCajon(BarcoDescarga Barcodescarga,String cajon) 
	{
	    List<CalidadDetalleEspecietallaCajonBanda> listaCdcb = new ArrayList<CalidadDetalleEspecietallaCajonBanda>();
		
		   try {
		Query query =  em.createQuery("select cet from CalidadDetalleEspecietallaCajonBanda cet "+
		  "WHERE cet.calidadEspecietallaCajonBanda.barcoDescarga=:barco and cet.cajon.idcajon=:cajon ");

		 query.setParameter("barco", Barcodescarga);
		  query.setParameter("cajon", cajon);
		  listaCdcb = query.getResultList();
		return listaCdcb;
		   }
		   catch (Exception e) {
		System.out.println(e);
		return null;
		}
		
	}
	

	/* 16-03-2018  */
	public List<EspecieTalla> getEspecieTallaByIdespecie(int idespecie) 
	{
	   String sql =  "select et from EspecieTalla et where et.especie.idespecie =:idesp order by et.especie.idespecie asc ";	
		return em.createQuery(sql).setParameter("idesp",idespecie ).getResultList();
	}

}	

