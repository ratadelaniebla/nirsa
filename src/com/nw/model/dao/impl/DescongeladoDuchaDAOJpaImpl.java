package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDucha;
import com.nw.model.Produccion;

 
import com.nw.model.dao.DescongeladoDuchaDAO;

public class DescongeladoDuchaDAOJpaImpl extends BaseDaoJpaImpl implements DescongeladoDuchaDAO {

	@SuppressWarnings("unchecked")
	/**
	 * METODO QUE OBTIENE LOS REGISTROS de LA TABLA eviscerado_pescados_lata
	 * @return
	 */
	@Override
	public List<DescongeladoDucha> getDescongeladoDuchas() {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DescongeladoDucha> descongeladoducha = new ArrayList<DescongeladoDucha>();

		try {
			Query query = em
					.createQuery("select c from DescongeladoDucha c ");
			descongeladoducha = (List<DescongeladoDucha>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return descongeladoducha;
	}


	@SuppressWarnings("unchecked")
	public List<DescongeladoDucha> obtenerDuchas(Produccion idPro) 
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DescongeladoDucha> descongeladoduchas = new ArrayList<DescongeladoDucha>();

		try {
			Query query = em
					.createQuery("select c from DescongeladoDucha c where c.idducha NOT IN (select cc.descongeladoDucha.idducha from DescongeladoDuchaAperturaCierreDetalle " +
							" cc where cc.produccion=:prod and cc.estado in(1,2,3)  group by cc.descongeladoDucha.idducha )  order by  c.idducha");
			query.setParameter("prod", idPro);
			descongeladoduchas = (List<DescongeladoDucha>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return descongeladoduchas;
	}


}
