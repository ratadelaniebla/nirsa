package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.EnvasadoDetalleProcesoCambiosLuthy;
import com.nw.model.dao.EnvasadoDetalleProcesoCambiosLuthyDAO;

public class EnvasadoDetalleProcesoCambiosLuthyDAOJpaimpl extends BaseDaoJpaImpl implements EnvasadoDetalleProcesoCambiosLuthyDAO{
 
	public boolean eliminaCambiosLuthy(List<EnvasadoDetalleProcesoCambiosLuthy> listacambiosLuthy) {
		EntityTransaction t = em.getTransaction();
		try {
			
			t.begin();
			for (EnvasadoDetalleProcesoCambiosLuthy envasadoDetalleProcesoCambiosLuthy : listacambiosLuthy) {
				if (!em.contains(envasadoDetalleProcesoCambiosLuthy)) {
					em.remove(em.merge(envasadoDetalleProcesoCambiosLuthy));
				} else
					em.remove(envasadoDetalleProcesoCambiosLuthy);
			}
			t.commit();			
			return true;
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
//			em.close();
		}
	}
}
