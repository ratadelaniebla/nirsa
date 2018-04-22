package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDetalleProcesoTempIng;
import com.nw.model.DescongeladoProceso;
import com.nw.model.dao.DescongeladoProcesoDAO;
import com.nw.temp.model.CajonDescongeladoDetalleProceso;

public class DescongeladoDetalleTemperaturaIngresoDAOJpaImpl extends BaseDaoJpaImpl implements DescongeladoProcesoDAO{

	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public DescongeladoDetalleTemperaturaIngresoDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	
	public List<Object[]> getCajonesIngresadosTemperatura() {
		   List<CajonDescongeladoDetalleProceso> listaDDPs = new ArrayList<CajonDescongeladoDetalleProceso>();
				//Muestra la lista de todos los cajons con estado 1
				Query query = em.createQuery("select ddp.iddescongeladodetalleproceso, ddp.idproducciondetallelotecajon, ddpt.temperatura, " +
						"(select count(ddpt.temperatura) from DescongeladoDetalleProcesoTempIng ddpt where ddpt.iddescongeladodetalleproceso = :idvalor), " +
						"(select avg(ddpt.temperatura) from DescongeladoDetalleProcesoTempIng ddpt where ddpt.iddescongeladodetalleproceso = :idvalor ) " +
						"from DescongeladoDetalleProcesoTempIng ddpt " +
						"inner join c.camaraCajons cc " +
						"inner join cc.produccionDetalleLoteCajons pdlc " +
						"inner join pdlc.descongeladoDetalleProcesos ddp " +
						"inner join ddp.descongeladoProceso dp " +
						"inner join pdlc.produccionDetalleLote pdl " +
						"inner join pdl.especieTalla et " +
						"inner join pdl.barcoDescarga bd " +
						"inner join ddp.descongeladoProceso dp " +
						"where ddp.estado= 1 ");

				List<Object[]> listDatos = query.getResultList();
				//System.out.println("Mensaje de la consulta realizada--> "+  obj.toString() + " idcajon " + idcajon);
				
				return listDatos;
				
		 }
		  
	
	
//	select avg(descongelado_detalle_proceso_temperatura.temperatura) 
//	from descongelado_detalle_proceso_temperatura
//	where descongelado_detalle_proceso_temperatura.iddescongeladodetalleproceso=1

	public double getTemperaturaPromedio(Long idDesDetPro)
	{
		double rec = 0;
		
		Query query = em.createQuery("select avg(ddpt.temperatura) from DescongeladoDetalleProcesoTempIng ddpt " +
				"inner join ddpt.descongeladoDetalleProceso ddp " +
				"where ddp.iddescongeladodetalleproceso= :idDescongelado ");
		query.setParameter("idDescongelado", idDesDetPro);

		String c = "";
		
		if (query.getSingleResult() != null) {
			c = query.getSingleResult().toString();
			rec = Double.valueOf(c);
			return rec;
		} 
		else
		{
			return rec = 0;
		}
		
		
//		rec = Double.valueOf(c);

//		return rec;
	}
	
	
//	select count(descongelado_detalle_proceso_temperatura.temperatura) 
//	from descongelado_detalle_proceso_temperatura
//	where descongelado_detalle_proceso_temperatura.iddescongeladodetalleproceso=2
	public int getNumMuestra(Long idDesDetPro)
	{
		int rec = 0;
		
		Query query = em.createQuery("select count(ddpt.temperatura) from DescongeladoDetalleProcesoTempIng ddpt " +
				"inner join ddpt.descongeladoDetalleProceso ddp " +
				"where ddp.iddescongeladodetalleproceso= :idDescongelado ");
		query.setParameter("idDescongelado", idDesDetPro);
		String c = query.getSingleResult().toString();
		rec = Integer.valueOf(c);

		return rec;
	}
	

	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProcesoTempIng> getTemperaturasCajonesEliminar(Long idDesDetPro) {
		List<DescongeladoDetalleProcesoTempIng> ddpt = new ArrayList<DescongeladoDetalleProcesoTempIng>();
		try {
			Query qry = em.createQuery("select ddpt from DescongeladoDetalleProcesoTempIng ddpt " +
					" where ddpt.descongeladoDetalleProceso.iddescongeladodetalleproceso= :idDescongelado ");
			qry.setParameter("idDescongelado", idDesDetPro);
			ddpt = qry.getResultList();
			return ddpt;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
		
	
	public void guardardescongeladoTempIngreso(DescongeladoDetalleProcesoTempIng descongeladoDetalleTemperatura){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		//dd.setIdducha(descongeladoDetalleProceso.getDescongeladoDucha().getIdducha());
		
		try {
				t.begin();
				em.merge(descongeladoDetalleTemperatura);
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		 
}
	
	@Override
	public void saveOrUpdate(DescongeladoProceso descongeladoProceso) {

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

	public void remove(Long vid) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					DescongeladoDetalleProcesoTempIng o = (DescongeladoDetalleProcesoTempIng) em.find(DescongeladoDetalleProcesoTempIng.class, vid);
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
