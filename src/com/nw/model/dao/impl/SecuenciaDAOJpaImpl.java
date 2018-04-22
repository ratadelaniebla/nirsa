package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.dao.SecuenciaDAO;

public class SecuenciaDAOJpaImpl extends BaseDaoJpaImpl implements SecuenciaDAO{

	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public SecuenciaDAOJpaImpl(){
    	//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

    /**
     * Obtiene el siguiente ID de la tabla
     */
	public Long getSiguienteId(String tabla, String campo) {
		
		//SELECT a.idcalidadpcc FROM ( 
		//  SELECT idcalidadpcc, ROW_NUMBER() OVER (order by idcalidadpcc desc) as row FROM calidad_pcc 
		// ) a WHERE a.row = 1

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a.%s FROM ( "); 
		sb.append("  SELECT %s, ROW_NUMBER() OVER (order by %s desc) as row FROM %s "); 
		sb.append(" ) a WHERE a.row = 1 ");
		
		Query query = em.createNativeQuery(String.format(sb.toString(), campo, campo, campo, tabla ));
		List result = (List)query.getResultList();
		
		Long resultado = (long) 0; 
		resultado = (long) (result.size() > 0 ? ((Long)result.get(0)).intValue() +1:  1);
		
		return resultado;
	}

}
