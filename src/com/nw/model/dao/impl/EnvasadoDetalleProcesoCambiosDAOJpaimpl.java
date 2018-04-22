package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.nw.model.EnvasadoDetalleProcesoCambio;
import com.nw.model.EnvasadoDetalleProcesoCambiosLuthy;
import com.nw.model.dao.EnvasadoDetalleProcesoCambioDAO;

public class EnvasadoDetalleProcesoCambiosDAOJpaimpl extends BaseDaoJpaImpl implements EnvasadoDetalleProcesoCambioDAO{
 
	@Override
	public List<EnvasadoDetalleProcesoCambiosLuthy> saveOrUpdate(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		EntityTransaction t = em.getTransaction();
		List<EnvasadoDetalleProcesoCambiosLuthy> edpcLuthy = new ArrayList<EnvasadoDetalleProcesoCambiosLuthy>();
		try {
			t.begin();
			em.merge(envasadoDetalleProcesoCambio);
			
			if (!envasadoDetalleProcesoCambio.getEnvasadoDetalleProcesoCambiosLuthies().isEmpty())
				for (EnvasadoDetalleProcesoCambiosLuthy edpcL : envasadoDetalleProcesoCambio.getEnvasadoDetalleProcesoCambiosLuthies())
					edpcLuthy.add((EnvasadoDetalleProcesoCambiosLuthy)em.merge(edpcL));
			
			t.commit();
			return edpcLuthy;
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
			return new ArrayList<EnvasadoDetalleProcesoCambiosLuthy>();
		} finally {
//			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambioByIdEProceso(Long idenvasadoproceso) {
		try {
			Query qryPro = em.createQuery(" SELECT edpc FROM EnvasadoDetalleProcesoCambio edpc " + 
					" where edpc.idenvasadoproceso = :idenvasadoproceso order by  edpc.idproducciondetalleorden");

			qryPro.setParameter("idenvasadoproceso", idenvasadoproceso);
			return (List<EnvasadoDetalleProcesoCambio>) qryPro.getResultList();
		} catch (Exception e) {
			return new ArrayList<EnvasadoDetalleProcesoCambio>();
		}
	}
	
	public EnvasadoDetalleProcesoCambio getEnvasadoDetalleProcesoCambioById(Long idproducciondetalleorden) {
		try {
			return em.find(EnvasadoDetalleProcesoCambio.class, idproducciondetalleorden);
		} catch (Exception e) {
			return new EnvasadoDetalleProcesoCambio();
		}
	}
	
	public boolean delete(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		EntityTransaction t = em.getTransaction();
		boolean result = true;
		try {
			t.begin();
			
			for (EnvasadoDetalleProcesoCambiosLuthy envasadoDetalleProcesoCambiosLuthy : envasadoDetalleProcesoCambio.getEnvasadoDetalleProcesoCambiosLuthies()) {
				
				
				if (!em.contains(envasadoDetalleProcesoCambiosLuthy)) {
					
					envasadoDetalleProcesoCambiosLuthy = em.merge(envasadoDetalleProcesoCambiosLuthy);
					em.remove(envasadoDetalleProcesoCambiosLuthy);
					
				}
				
				
			}

			EnvasadoDetalleProcesoCambio edpc = em.find(EnvasadoDetalleProcesoCambio.class,
					envasadoDetalleProcesoCambio.getIdenvasadodetalleprocesocambios());
			em.remove(edpc);
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			result = false;
		} finally {
			em.close();
		}
		return result;
	}
	
}
