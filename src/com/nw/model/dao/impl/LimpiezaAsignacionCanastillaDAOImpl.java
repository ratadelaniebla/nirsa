package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaAsignacionCanastilla;
import com.nw.model.dao.LimpiezaAsignacionCanastillaDAO;
import com.nw.util.Sistema;

public class LimpiezaAsignacionCanastillaDAOImpl extends BaseDaoJpaImpl implements LimpiezaAsignacionCanastillaDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
    public LimpiezaAsignacionCanastillaDAOImpl() {
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//    	emf = Persistence.createEntityManagerFactory("NW");
    	em = emf.createEntityManager();
    }
    
	@Override
	public void saveOrUpdate(LimpiezaAsignacionCanastilla limpiezapilotocanastilla) 
	{
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			  EntityManager em = emf.createEntityManager();
			try {
				EntityTransaction t = em.getTransaction();
				try {
					t.begin();
					em.merge(limpiezapilotocanastilla);
					t.commit();
				} finally {
					if (t.isActive())
						t.rollback();
				}
			} finally {
				em.close();
			}
		
	}


	

	public LimpiezaAsignacionCanastilla LimpiezaAsignacionCanastillaByCodigoDeBarras(String codigo) 
	{ 
		StringBuffer sb = new StringBuffer();
		sb.append("Select l "); 
		sb.append("From LimpiezaAsignacionCanastilla l  "); 
		sb.append("where l.codigodebarras = '" + String.valueOf(codigo) + "' ");

		//logger.info(CalidadDetalleSensorialMp.class +" -> "+sb.toString());
		List items =  em.createQuery(sb.toString()).getResultList().subList(0, 1);

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaAsignacionCanastilla) items.get(0);
        }		
	}	

	
	public LimpiezaAsignacionCanastilla LimpiezaAsignacionCanastillaByCodigoDeBarrasDESC(String codigo, Integer secuencia) 
	{ 
		StringBuffer sb = new StringBuffer();
		sb.append("Select l "); 
		sb.append("From LimpiezaAsignacionCanastilla l  "); 
		sb.append("where l.codigoempleado = '" + String.valueOf(codigo) + "' ");
		sb.append("and l.secuencia = '" + String.valueOf(secuencia) + "' order by l.idlimpiezaasignacioncanastilla DESC");

		//logger.info(CalidadDetalleSensorialMp.class +" -> "+sb.toString());
		List items;
		try {
			items = em.createQuery(sb.toString()).getResultList().subList(0, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Sistema.mensaje("No se puede obtener número de coche");
			return null;
		}

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaAsignacionCanastilla) items.get(0);
        }		
	}	
	
}
