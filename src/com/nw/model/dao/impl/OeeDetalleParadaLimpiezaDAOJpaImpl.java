package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoCuba;
import com.nw.model.CalidadDetallePcc;
import com.nw.model.Empleado;
import com.nw.model.OeeDetalleParada;
import com.nw.model.OeeDetalleParadaLimpieza;
import com.nw.model.dao.OeeDetalleParadaLimpiezaDAO;


public class OeeDetalleParadaLimpiezaDAOJpaImpl extends BaseDaoJpaImpl implements OeeDetalleParadaLimpiezaDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public OeeDetalleParadaLimpiezaDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

//	@Override
//	public OeeParada getOeeParadaById(Integer id) {
//		return em.find(OeeParada.class, id);
//	}

	public void saveOrUpdateOeeDetalleParadaLimpieza(OeeDetalleParadaLimpieza pbo) {
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
	
	
	
//	public OeeDetalleParadaLimpieza getOeeDetalleParadaLimpieza(Long id) 
//	{ 
//		System.out.println("Datos :"+String.valueOf(id));
//		StringBuffer sb = new StringBuffer();
//		sb.append("select b "); 
//		sb.append("from OeeDetalleParadaLimpieza b "); 
//		sb.append("where b.idoeedetalleparadalimpieza = 11 "); 	
//	
//		List items = null;
//		try {
//			items = em.createQuery(sb.toString()).setMaxResults(1).getResultList();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        if (items == null || items.isEmpty()) {
//            return null;
//        } else {
//            return  (OeeDetalleParadaLimpieza) items.get(0);
//        }		
//	}	

	
    public OeeDetalleParadaLimpieza getOeeDetalleParadaLimpiezaRegistrado(Long id)
    {
    OeeDetalleParadaLimpieza oeeDetalleParadaLimpieza;
    	try {
    		Query qry = em.createQuery(" select b from OeeDetalleParadaLimpieza b where b.oeeDetalleParada.idOeeDetalleParada=:idc");
    		qry.setParameter("idc", id);
    		oeeDetalleParadaLimpieza = (OeeDetalleParadaLimpieza) qry.getSingleResult(); 
    		return oeeDetalleParadaLimpieza;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<OeeDetalleParada> getOeeDetalleParadaLimpieza(Long id, int idl) 
	{
		try {
			return (List<OeeDetalleParada>) em
					.createQuery(

							"select c from OeeDetalleParada c " +
							"inner join c.oeeDetalleParadaLimpiezas oedpl " +
							"Where c.procesoAperturaCierre.idprocesoaperturacierre =:pid and  " +
							"oedpl.limpiezaLinea.idlimpiezalinea =:pil and " +
							"c.procesoAperturaCierre.proceso.idproceso = 4 and " +
							"c.fechaHoraFin is null " +
							"order by c.fechaHoraInicio ")

//							"where c.procesoAperturaCierre.idprocesoaperturacierre =:pid and  " +
//							"oedpl.limpiezaLinea.idlimpiezalinea =:pil and  " +
							
							.setParameter("pid", id)
							.setParameter("pil", idl)
							.getResultList();

/*
		  Query qry = em.createQuery("select c from Cajon c " +
			  		"inner join c.camaraCajons cc " +
			  		"inner join cc.produccionDetalleLoteCajons pdlc " +
			  		"inner join pdlc.produccionDetalleLote pdl " +
			  		"where pdl.idlote = :idlot");							
 */
							
							
//							"select c from OeeDetalleParada c " +
//							"where c.procesoAperturaCierre.idprocesoaperturacierre =:pid and  " +
//							"c.oeeDetalleParadaLimpiezas.limpiezaLinea.idlimpiezalinea =:pil and  " +
//							"c.procesoAperturaCierre.proceso.idproceso = 4 and " +
//							"c.fechaHoraFin is null order by c.fechaHoraInicio ")
							
//					.setParameter("pid", id)
//					.setParameter("pil", idl)
//					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			return null;
		}
	}	
	

	@SuppressWarnings("unchecked")
	public List<OeeDetalleParada> getOeeDetalleParadaLimpiezaPorProceso(Long id, int idl) 
	{
		try {
			return (List<OeeDetalleParada>) em
					.createQuery(

							"select c from OeeDetalleParada c " +
							"inner join c.oeeDetalleParadaLimpiezas oedpl " +
							"Where c.procesoAperturaCierre.idprocesoaperturacierre =:pid and  " +
							"oedpl.limpiezaLinea.idlimpiezalinea =:pil and " +
							"c.procesoAperturaCierre.proceso.idproceso = 4 " +
							"order by c.fechaHoraInicio ")

//							"where c.procesoAperturaCierre.idprocesoaperturacierre =:pid and  " +
//							"oedpl.limpiezaLinea.idlimpiezalinea =:pil and  " +
							
							.setParameter("pid", id)
							.setParameter("pil", idl)
							.getResultList();

/*
		  Query qry = em.createQuery("select c from Cajon c " +
			  		"inner join c.camaraCajons cc " +
			  		"inner join cc.produccionDetalleLoteCajons pdlc " +
			  		"inner join pdlc.produccionDetalleLote pdl " +
			  		"where pdl.idlote = :idlot");							
 */
							
							
//							"select c from OeeDetalleParada c " +
//							"where c.procesoAperturaCierre.idprocesoaperturacierre =:pid and  " +
//							"c.oeeDetalleParadaLimpiezas.limpiezaLinea.idlimpiezalinea =:pil and  " +
//							"c.procesoAperturaCierre.proceso.idproceso = 4 and " +
//							"c.fechaHoraFin is null order by c.fechaHoraInicio ")
							
//					.setParameter("pid", id)
//					.setParameter("pil", idl)
//					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			return null;
		}
	}	

	
	
	@Override
	public OeeDetalleParada saveOrUpdate(
			OeeDetalleParada oeeDetalleParada) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		OeeDetalleParada edpc = new OeeDetalleParada();
		
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				 edpc = em.merge(oeeDetalleParada);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		
		return edpc;
	}	
	
	
	
	public Empleado getFinEmpleadoId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select b "); 
		sb.append("from Empleado b "); 
		sb.append("where b.codpersona = '" + id + "'"); 
		
	
		List items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (Empleado) items.get(0);
        }		
	}	

//	@SuppressWarnings("unchecked")
//	public List<OeeParada> getOeeParadaByIdProceso(int idproceso) {
//		try {
//			return (List<OeeParada>) em
//					.createQuery(
//							"select c from OeeParada c where c.proceso.idproceso = :param order by c.descripcionParada")
//					.setParameter("param", idproceso).getResultList();
//		} catch (Exception e) {
//			em.close();
//			return null;
//		}
//	}

	
	public void eliminarOeeDetalleParadaLimpieza(OeeDetalleParadaLimpieza parada) {
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					OeeDetalleParadaLimpieza o = (OeeDetalleParadaLimpieza) em.find(OeeDetalleParadaLimpieza.class, parada.getIdoeedetalleparadalimpieza());
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
	
	
	public void eliminarOeeDetalleParada(OeeDetalleParada parada) 
	{
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					OeeDetalleParada o = (OeeDetalleParada) em.find(OeeDetalleParada.class, parada.getIdOeeDetalleParada());
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
