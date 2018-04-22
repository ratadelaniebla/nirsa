package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.DescongeladoDetalleProceso;
//import com.nw.model.LimpiezaDetalleProcesoBandeja;
import com.nw.model.LimpiezaLinea;
import com.nw.model.LimpiezaLineaGrupo;


@SuppressWarnings({"unchecked"})
public class LimpiezaLineaDAOJpaImpl extends BaseDaoJpaImpl{
	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public LimpiezaLineaDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
	
	public List<LimpiezaLinea>getLimpiezaLineas()
	{
		return em.createQuery("select l from LimpiezaLinea l order by l.idlimpiezalinea").getResultList();
	}

	
	public List<LimpiezaLinea>getLimpiezaLineasValidas()
	{
		return em.createQuery("select l from LimpiezaLinea l where l.idlimpiezalinea <> 99 order by l.idlimpiezalinea").getResultList();
	}
	
	
	public List<LimpiezaLineaGrupo> getLimpiezaLineasGrupo(Integer idlinea)
	{
		List<LimpiezaLineaGrupo> lista = new ArrayList<LimpiezaLineaGrupo>();

		Query query = em.createQuery("select l from LimpiezaLineaGrupo l " +
				"where l.limpiezaLinea.idlimpiezalinea = :idlineal ");
		query.setParameter("idlineal", idlinea);
		
		lista = query.getResultList();
		
		return lista;
		
	}
	
	
	
	
	
	
	//Nuevo 26-01-2017
	public LimpiezaLinea LimpiezaLineaPorID(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaLinea o "); 
		sb.append("Where o.idlimpiezalinea = '" + id + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList().subList(0, 1);

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaLinea) items.get(0);
        }		
	} 
	
	
	
	
	
/*	
	public List<LimpiezaLinea>getLimpiezaLineasGrupo(){
		return em.createQuery("select l from LimpiezaLinea l order by l.idlimpiezalinea").getResultList();
	}
*/	
	
}
