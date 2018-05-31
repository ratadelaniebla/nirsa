package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EnvasadoControlPesoFillCabecera;
import com.nw.model.EnvasadoControlPesoFillDetalle;
import com.nw.model.dao.EnvasadoControlPesoFillCabeceraDAO;

public class EnvasadoControlPesoFillCabeceraDAOJpaImpl extends BaseDaoJpaImpl implements EnvasadoControlPesoFillCabeceraDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;
	public EnvasadoControlPesoFillCabeceraDAOJpaImpl(){
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		//emf = Persistence.createEntityManagerFactory("NW");
        em = emf.createEntityManager();
        t = em.getTransaction();
	}
	
	public EnvasadoControlPesoFillCabecera updateEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		
		EnvasadoControlPesoFillCabecera ecpfc = null;
		t = em.getTransaction();
		List<EnvasadoControlPesoFillDetalle> listEcpfd = new ArrayList<EnvasadoControlPesoFillDetalle>();
		try {
			
			t.begin();
			for( EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle : envasadoControlPesoFillCabecera.getEnvasadoControlPesoFillDetalles() ) {
				listEcpfd.add(em.merge(envasadoControlPesoFillDetalle));
			}
			envasadoControlPesoFillCabecera.setEnvasadoControlPesoFillDetalles(listEcpfd);
			ecpfc =	em.merge(envasadoControlPesoFillCabecera);
			t.commit();
			
		} catch(Exception e) {
			try {
				t.rollback();
			}catch(Exception er) {
				e.printStackTrace();
				return null;
			}
			e.printStackTrace();
		}
		
		return ecpfc;
		
	}
	
	public EnvasadoControlPesoFillCabecera getByProduccionTurnoOrden(Long idenvasadoproceso, Integer idproducciondetalleorden) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoFillCabecera e "
					+ "WHERE e.envasadoProceso.idenvasadoproceso = :idenvasadoproceso "
					+ "AND e.produccionDetalleOrden.idproducciondetalleorden= :idproducciondetalleorden	";
			return (EnvasadoControlPesoFillCabecera) em
					.createQuery(sql)
					.setParameter("idenvasadoproceso", idenvasadoproceso)
					.setParameter("idproducciondetalleorden", idproducciondetalleorden)
					.getSingleResult();
		} catch( NoResultException e) {
			return new EnvasadoControlPesoFillCabecera();
		} catch( Exception e) {
			e.printStackTrace();
			return new EnvasadoControlPesoFillCabecera();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EnvasadoControlPesoFillCabecera> getByProduccion(Long idenvasadoproceso) {
		try {
			String sql = "SELECT e FROM EnvasadoControlPesoFillCabecera e "
					+ "WHERE e.envasadoProceso.idenvasadoproceso = :idenvasadoproceso ";
			return em
					.createQuery(sql)
					.setParameter("idenvasadoproceso", idenvasadoproceso)
					.getResultList();
		} catch( NoResultException e) {
			return new ArrayList<EnvasadoControlPesoFillCabecera>();
		} catch( Exception e) {
			e.printStackTrace();
			return new ArrayList<EnvasadoControlPesoFillCabecera>();
		}
	}
	
	public boolean eliminaEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera ecpfc) {
		
		try {
			t.begin();
			if (!em.contains(ecpfc))
				em.remove(em.merge(ecpfc));
			else
				em.remove(ecpfc);
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
