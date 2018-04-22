package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadObservacionesMuestraCuba;
import com.nw.model.dao.CalidadObservacionesMuestraCubaDAO;

@SuppressWarnings("unchecked")
public class CalidadObservacionesMuestraCubaDAOJpaImpl extends BaseDaoJpaImpl implements CalidadObservacionesMuestraCubaDAO {

	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CalidadObservacionesMuestraCubaDAOJpaImpl(){
 //   	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCuba() {
		return em.createQuery("select comc from CalidadObservacionesMuestraCuba comc order by comc.idcalidadobservacion").getResultList();
	}
	
//	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCubaGrupo(String grupo) {
//		return em.createQuery("select comc from CalidadObservacionesMuestraCuba comc " +
//				"where comc.calidadGrupoObservacionesMuestraCuba.idcalidadgrupoobservaciones = :grup order by comc.idcalidadobservacion")
//				.setParameter("grup", Integer.valueOf(grupo))
//				.getResultList();
//	}
//
//	
//	
//	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCubaGrupo1(String grupo1, String grupo2) {
//		return em.createQuery("select comc from CalidadObservacionesMuestraCuba comc " +
//				"where comc.calidadGrupoObservacionesMuestraCuba.idcalidadgrupoobservaciones in (:grup1,:grup2) order by comc.idcalidadobservacion")
//				.setParameter("grup1", Integer.valueOf(grupo1))
//				.setParameter("grup2", Integer.valueOf(grupo2))
//				.getResultList();
//	}

	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCubaGrupo(String grupo) {
		return em.createQuery("select comc from CalidadObservacionesMuestraCuba comc " +
				"where comc.calidadGrupoObservacionesMuestraCuba.idcalidadgrupoobservaciones = :grup " +
				"  and comc.estado = 1 order by comc.idcalidadobservacion")
				.setParameter("grup", Integer.valueOf(grupo))
				.getResultList();
	}

	 
	
	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCubaGrupo1(String grupo1, String grupo2) {
		return em.createQuery("select comc from CalidadObservacionesMuestraCuba comc " +
				"where comc.calidadGrupoObservacionesMuestraCuba.idcalidadgrupoobservaciones in (:grup1,:grup2)" +
				"  and comc.estado = 1 order by comc.idcalidadobservacion")
				.setParameter("grup1", Integer.valueOf(grupo1))
				.setParameter("grup2", Integer.valueOf(grupo2))
				.getResultList();
	}	
	@Override
	public CalidadObservacionesMuestraCuba findById(Integer idcalidadobservacion) {
		// TODO Auto-generated method stub
		return em.find(CalidadObservacionesMuestraCuba.class, idcalidadobservacion);
	}	
	
	
}
