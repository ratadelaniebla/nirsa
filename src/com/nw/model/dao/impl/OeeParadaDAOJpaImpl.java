package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.OeeParada;
import com.nw.model.dao.OeeParadaDAO;

/**
 * Clase para manejar los procesos
 * 
 * @author Manexware S.A.
 * 
 */
public class OeeParadaDAOJpaImpl extends BaseDaoJpaImpl implements OeeParadaDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public OeeParadaDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	@Override
	public OeeParada getOeeParadaById(Integer id) {
		return em.find(OeeParada.class, id);
	}

	public void saveOrUpdate(OeeParada pbo) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(pbo);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}

	}
	
	public void saveOrUpdateNativo(OeeParada oeeParada) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		 

		try {
			t.begin();
			//oeeParadaDevuelto=em.merge(oeeParada);
			Query query = em.createNativeQuery(" INSERT INTO oee_parada( " +
					" id_oee_parada, idproceso, descripcion_parada, programada, tipo_equipo_persona,  " +
					"  estandar_modificado, tiempo_muerto) " +
					"  VALUES (?, ?, ?, ?, ?, ?, ?);");
		        query.setParameter(1, oeeParada.getIdOeeParada());
		        query.setParameter(2, oeeParada.getProceso().getIdproceso());
		        query.setParameter(3, oeeParada.getDescripcionParada());
		        query.setParameter(4, oeeParada.getProgramada() );
		        query.setParameter(5, oeeParada.getTipoEquipoPersona() );
		        query.setParameter(6, oeeParada.getEstandarModificado() );
		        query.setParameter(7, oeeParada.getTiempoMuerto());
		        query.executeUpdate();
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<OeeParada> getOeeParadaByIdProceso(int idproceso) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT op ");
			sbuilder.append("FROM OeeParada op ");
			sbuilder.append("WHERE op.proceso.idproceso = :idproceso ");
			sbuilder.append("ORDER BY op.descripcionParada");
			return (List<OeeParada>) em.createQuery(sbuilder.toString())
					.setParameter("idproceso", idproceso)//
					.getResultList();
		} catch (Exception e) {
			return null;
		}finally{
			em.close();
		}
	}
	
	/**
	 * Lista de paradas segun el tipo(programada/no programada)
	 *  y el tipoEquipoPersona
	 *  
	 *  30-10-2017
	 * @param idproceso
	 * @param tipoprogramada
	 * @param tipoequipopersona
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OeeParada> getOeeParadaByIdProcesoAndTipoParadaAndTipoEquipo(int    idproceso, 
																			Boolean tipoprogramada ,
																			Boolean tipoequipopersona) {
		
		List<OeeParada> paradas = new ArrayList<OeeParada>();
		String sql = " SELECT op FROM OeeParada op " +
				     "	 WHERE op.proceso.idproceso = :idproceso and op.programada =:tipoprogramada " +
				     "  	and op.tipoEquipoPersona =:tipoequipo ORDER BY op.descripcionParada  ";
		try {
		 
			paradas =  (List<OeeParada>) em.createQuery(sql)
					.setParameter("idproceso", idproceso) 
					.setParameter("tipoprogramada", tipoprogramada) 
					.setParameter("tipoequipo", tipoequipopersona) 
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		return paradas;
	}

	public boolean delete(OeeParada parada) {
		EntityTransaction t = em.getTransaction();
		boolean result = true;
		try {
			t.begin();
			OeeParada oeeparada = em.find(OeeParada.class,
					parada.getIdOeeParada());
			em.remove(oeeparada);
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

	@SuppressWarnings("unchecked")
	public List<OeeParada> getOeeParadaByIdAndType(int idproceso, boolean tipo) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT op ");
			sbuilder.append("FROM OeeParada op ");
			sbuilder.append("WHERE op.proceso.idproceso = :idproceso ");
			sbuilder.append("AND op.tipoEquipoPersona = :tipo ");
			sbuilder.append("ORDER BY op.descripcionParada");
			return (List<OeeParada>) em.createQuery(sbuilder.toString())
					.setParameter("idproceso", idproceso)//
					.setParameter("tipo", tipo)//
					.getResultList();
		} catch (Exception e) {
			return null;
		}finally{
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<OeeParada> getOeeParadaList() {
		 StringBuilder sbuilder = new StringBuilder();
		 List<OeeParada> oeeParadas = new ArrayList<>();
		 sbuilder.append("SELECT op FROM OeeParada op ORDER BY op.idOeeParada ");
		 oeeParadas =  em.createQuery(sbuilder.toString()).getResultList();
		 em.close();
		return oeeParadas;
	}

	public List<OeeParada> getOeeParadaXLonjas(boolean tipo) {
		return getOeeParadaByIdAndType(9, tipo);
	}
	

}
