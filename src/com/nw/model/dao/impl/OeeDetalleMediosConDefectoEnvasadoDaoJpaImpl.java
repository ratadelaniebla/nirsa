package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.EnvasadoProceso;
import com.nw.model.OeeDetalleMediosConDefectoEnvasado;
import com.nw.model.dao.OeeDetalleMediosConDefectoEnvasadoDAO;

public class OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl extends
		BaseDaoJpaImpl implements OeeDetalleMediosConDefectoEnvasadoDAO {

	public OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl() {
	}

	public void saveOrUpdate(
			OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado) {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(oeeDetalleMediosConDefectoEnvasado);
			em.flush();
			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}

	}

	/* ajuste en este metodo */
	@SuppressWarnings("unchecked")
	public List<OeeDetalleMediosConDefectoEnvasado> findByIdPacAndIdMaquina(
			Long idPac, Integer idMaquina) {
		StringBuilder sbuilder = new StringBuilder();
		List<OeeDetalleMediosConDefectoEnvasado> oeeDefectoEnvasados = new ArrayList<>();
		try {
			sbuilder.append("SELECT odmde ");
			sbuilder.append("FROM OeeDetalleMediosConDefectoEnvasado odmde, OeeDetalleMediosConDefecto edmd ");
			sbuilder.append("WHERE odmde.oeeDetalleMediosConDefecto.idOeeDetalleMediosConDefecto = edmd.idOeeDetalleMediosConDefecto ");
			sbuilder.append("AND odmde.maquinaCerradora.idmaquinacerradora = :idMaquina ");
			sbuilder.append("AND edmd.procesoAperturaCierre.idprocesoaperturacierre = :idPac ");
			oeeDefectoEnvasados =  (List<OeeDetalleMediosConDefectoEnvasado>) em
					.createQuery(sbuilder.toString()) 
					.setParameter("idMaquina", idMaquina) 
					.setParameter("idPac", idPac) 
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		return oeeDefectoEnvasados;
	}

	public boolean delete(
			OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado) {
		boolean flag;
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				OeeDetalleMediosConDefectoEnvasado def = em.find(
						OeeDetalleMediosConDefectoEnvasado.class,
						oeeDetalleMediosConDefectoEnvasado
								.getIdoeedetallemedioscondefectoenvasado());
				em.remove(def);
				t.commit();
				flag = true;
			} finally {
				if (t.isActive())
					t.rollback();
				flag = false;
			}
		} finally {
			em.close();
			flag = false;
		}
		return flag;
	}
}
