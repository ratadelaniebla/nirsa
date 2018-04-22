package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.DescongeladoDetalleProcesoTempIng;
/*import com.nw.model.DescongeladoDetalleProcesoTemperatura;*/
/*import com.nw.model.dao.DescongeladoDetalleProcesoTemperaturaDAO;*/
import com.nw.model.dao.DescongeladoDetalleProcesoTemperaturaIngresoDAO;

public class DescongeladoDetalleProcesoTemperaturaIngresoDAOJpaImpl extends BaseDaoJpaImpl implements DescongeladoDetalleProcesoTemperaturaIngresoDAO{

	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public DescongeladoDetalleProcesoTemperaturaIngresoDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	

	
    public List<DescongeladoDetalleProcesoTempIng> getTemperaturasIngresadasPorCajon(long id) {
		return em.createQuery("select b from DescongeladoDetalleProcesoTempIng b WHERE b.descongeladoDetalleProceso.iddescongeladodetalleproceso = '"  +String.valueOf(id) + "' ").getResultList();
	}
	

	public DescongeladoDetalleProceso getDescongeladoDetalleProcesoByIdProDetLotCajon(String id) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From DescongeladoDetalleProceso o "); 
		sb.append("Where o.produccionDetalleLoteCajon.idproducciondetallelotecajon = '" + id + "' "); 

		//logger.info(CalidadSensorialMp.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (DescongeladoDetalleProceso) items.get(0);
        }		
	}    
    
	@Override
	public void saveOrUpdate(DescongeladoDetalleProcesoTempIng descongeladoProceso) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(descongeladoProceso);
	 			        t.commit();
  		  } finally {
  		    if (t.isActive()) t.rollback();
  		  }
			}finally{
				//em.close();
				//emf.close();
			}
		
	}	

	
	
	
}
