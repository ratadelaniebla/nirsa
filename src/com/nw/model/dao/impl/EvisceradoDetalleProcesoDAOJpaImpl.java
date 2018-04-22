package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.EvisceradoDetalleProceso;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.dao.EvisceradoDetalleProcesoDAO;

public class EvisceradoDetalleProcesoDAOJpaImpl extends BaseDaoJpaImpl implements EvisceradoDetalleProcesoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EvisceradoDetalleProcesoDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	/**
	 *Consulta a un objeto tipo ProcesoAperturaCierre con campo estado = 1 
	 * @return ProcesoAperturaCierre
	 */
	public EvisceradoDetalleProceso getSeleccionEvisceradoDetalleProceso(Long id, Long idproducciondetallelote)
	{
		try {
			EvisceradoDetalleProceso edp = new EvisceradoDetalleProceso();
			Query query = em.createQuery("select edp from EvisceradoDetalleProceso edp " +
					"where edp.estado = 1 and edp.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote = '"+idproducciondetallelote.toString()+"' edp.evisceradoProceso.produccion.idproduccion = '"+ id.toString() +"'");
			edp = (EvisceradoDetalleProceso) query.getSingleResult();

			return edp;		
			
		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;		
		}
	}
	
//METODO ANTERIOR
//@SuppressWarnings("unchecked")
//	/**
//	 * METODO QUE OBTIENE LOS REGISTROS CON VALOR 1 EN LA TABLA eviscerado_detalle_proceso
//	 * @return
//	 */
//	public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosEstadoUno() {
//		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
//				.getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		List<EvisceradoDetalleProceso> evisceradoDetalleProcesos = new ArrayList<EvisceradoDetalleProceso>();
//
//		try {
//			Query query = em
//					.createQuery("select edp from EvisceradoDetalleProceso edp " +
//							" inner join edp.produccionDetalleLoteCajon pdlc " +
//							"inner join pdlc.produccionDetalleLote pdl     " +
//							" where edp.estado = 1 order by pdl.idproducciondetallelote ");
//			evisceradoDetalleProcesos = (List<EvisceradoDetalleProceso>) query
//					.getResultList();
//
//		} catch (Exception e) {
//			System.out.println("paso esto realizando la consulta-->"
//					+ e.getMessage());
//		}
//		return evisceradoDetalleProcesos;
//	}

	//nuevo ajuste 14-01-2014

//	inner join eviscerado_proceso 
//	inner join produccion 
//	inner join produccion_detalle_lote_cajon 
//	inner join produccion_detalle_lote 
//
//	where produccion.idproduccion= 20 and eviscerado_detalle_proceso.estado = 1	
@SuppressWarnings("unchecked")
	/**
	 * METODO QUE OBTIENE LOS REGISTROS CON VALOR 1 EN LA TABLA eviscerado_detalle_proceso
	 * @return
	 */


public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosEstadoUno(Long idproduccion, Integer idturn ) {


	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	List<EvisceradoDetalleProceso> evisceradoDetalleProcesos = new ArrayList<EvisceradoDetalleProceso>();
	try {
		Query query = em
				.createQuery("select edp from EvisceradoDetalleProceso edp,  ProduccionDetalleLoteCajon pdlc" +
						"where edp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon " +	
						"order by pdl.idproducciondetallelote ");
		
		query.setParameter("idpro", idproduccion);
		query.setParameter("idtur", idturn);
		
		evisceradoDetalleProcesos = (List<EvisceradoDetalleProceso>) query
				.getResultList();

	} catch (Exception e) {
		System.out.println("paso esto realizando la consulta-->"
				+ e.getMessage());
	}
	return evisceradoDetalleProcesos;
}


@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosEstadoUno1(Long idproduccion, Integer idturn) {		
	return em.createQuery("select edp from EvisceradoDetalleProceso edp,  ProduccionDetalleLoteCajon pdlc " +
			" where edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = '" + idturn.toString() +"' " +
			" and edp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = '" + idproduccion.toString() +"' " +
			" and edp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon ").getResultList();
 	//return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
}

@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosxCocinada(Long idcocapertcierredet) {		
	return em.createQuery("select edp from EvisceradoDetalleProcesoCoche edpc, EvisceradoDetalleProceso edp,  CocinaAperturaCierreDetalle cacd " +
			" where edpc.evisceradoDetalleProceso.idevisceradodetalleproceso = edp.idevisceradodetalleproceso " +
			" and edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle " +
			" and cacd.idcocinaaperturacierredetalle = '" + idcocapertcierredet.toString() +"' " +
			" group by edp.idevisceradodetalleproceso").getResultList();
 	//return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
}


@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosOrdenados(Long idproduccion, Integer idturn) {		
	return em.createQuery("select edp from EvisceradoDetalleProceso edp,  ProduccionDetalleLoteCajon pdlc " +
			" where edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = '" + idturn.toString() +"' " +
			" and edp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = '" + idproduccion.toString() +"' " +
			" and edp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon " +
			" order by edp.produccionDetalleLoteCajon.produccionDetalleLote.idlote ").getResultList();
}



@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosAbiertos(Long idproduccion, Integer idturn) {		
	return em.createQuery("select edp from EvisceradoDetalleProceso edp,  ProduccionDetalleLoteCajon pdlc " +
			" where edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = '" + idturn.toString() +"' " +
			" and edp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = '" + idproduccion.toString() +"' " +
			" and edp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon "
			+ "and edp.estado in (1,3) " +
			"order by edp.fechainiciorackeo desc ").getResultList();
 	//return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
}


//Nuevo 03-03-2017
@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosAbiertosOrdenados(Long idproduccion, Integer idturn) {		
	return em.createQuery("select edp from EvisceradoDetalleProceso edp,  ProduccionDetalleLoteCajon pdlc " +
			" where edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = '" + idturn.toString() +"' " +
			" and edp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = '" + idproduccion.toString() +"' " +
			" and edp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon "
			+ "and edp.estado in (1,3) " +
			"order by edp.produccionDetalleLoteCajon.produccionDetalleLote.idlote desc ").getResultList();
 	//return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
}



//@SuppressWarnings("unchecked")
//public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosEstadoUno1Aux(Long idproduccion, Integer idturn) {		
//	return em.createQuery("select edp.produccionDetalleLoteCajon.produccionDetalleLote pdl from EvisceradoDetalleProceso edp,  ProduccionDetalleLoteCajon pdlc " +
//			" where edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = '" + idturn.toString() +"' " +
//			" and edp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = '" + idproduccion.toString() +"' " +
//			" and edp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon ").getResultList();
// 	//return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
//}

//@Override
public EvisceradoDetalleProceso getEvisceradoDetalleProcesoIdidproducciondetallelotecajon(String id) 
{ 
	
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProceso o "); 
	sb.append("Where o.produccionDetalleLoteCajon.idproducciondetallelotecajon = '" + id + "'");
	
	//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

	List items =  em.createQuery(sb.toString()).getResultList();

    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProceso) items.get(0);
    }		
}

//and edp.estado = 1
//	public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesosEstadoUno(Long idproduccion, Integer idturn ) {
//	
//
//		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
//				.getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		List<EvisceradoDetalleProceso> evisceradoDetalleProcesos = new ArrayList<EvisceradoDetalleProceso>();
//		try {
//			Query query = em
//					.createQuery("select edp from EvisceradoDetalleProceso edp " +
//							"inner join edp.produccionDetalleLoteCajon pdlc " +	
//							"order by pdl.idproducciondetallelote ");
////			
////			query.setParameter("idpro", idproduccion);
////			query.setParameter("idtur", idturn);
//			
//			evisceradoDetalleProcesos = (List<EvisceradoDetalleProceso>) query
//					.getResultList();
//
//		} catch (Exception e) {
//			System.out.println("paso esto realizando la consulta-->"
//					+ e.getMessage());
//		}
//		return evisceradoDetalleProcesos;
//	}
	
//"where p.idproduccion =:idpro " +	

/**
 * Consulta los lotes aperturados en base a la produccion activa y al turno seleccionado
 * 
 * select * from eviscerado_detalle_proceso
 * inner join produccion_detalle_lote_cajon
 * on produccion_detalle_lote_cajon.idproducciondetallelotecajon = eviscerado_detalle_proceso.idproducciondetallelotecajon
 * inner join produccion_detalle_lote
 * on produccion_detalle_lote.idproducciondetallelote = produccion_detalle_lote_cajon.idproducciondetallelotecajon
 * inner join turno on turno.idturno = produccion_detalle_lote.idturno
 * inner join eviscerado_proceso on eviscerado_proceso.idevisceradoproceso = eviscerado_detalle_proceso.idevisceradoproceso
 * inner join proceso_apertura_cierre on proceso_apertura_cierre.idprocesoaperturacierre = eviscerado_proceso.idprocesoaperturacierre
 * where proceso_apertura_cierre.estado = 1 and turno.idturno= 2
 * 
 * @param idprod
 * @return
 * List<EvisceradoDetalleProceso>
 */
	public List<EvisceradoDetalleProceso> getLotesAperturados(Long idprod, Integer idturn)
	{
		try {
			
//			edp.evisceradoProceso.procesoAperturaCierre.estado = 1
			List<EvisceradoDetalleProceso> edp = new ArrayList<EvisceradoDetalleProceso>();
			//and edp.evisceradoProceso.produccion.idproduccion = :idproduc
			Query query = em.createQuery("select edp from EvisceradoDetalleProceso edp " +
					"where edp.estado = 1 and " +
					"edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idtur ");
			
			query.setParameter("idtur", idturn);
			
			edp = (List<EvisceradoDetalleProceso>) query.getResultList();

			return edp;		
			
		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;		
		}
	}
	
	
	/**
	 * Obtiene los lotes que se encuentran aperturados, es decir lo registros que tiene estado 1 
	 * en la tabla eviscerado_detalle_proceso
	 * 
	 * select * from eviscerado_detalle_proceso_coche
	 * inner join eviscerado_detalle_proceso on eviscerado_detalle_proceso.idevisceradodetalleproceso = eviscerado_detalle_proceso_coche.idevisceradodetalleproceso
	 * where eviscerado_detalle_proceso.estado = 1
	 * 
	 * @param idprod
	 * @param idturn
	 * @return
	 * List<EvisceradoDetalleProcesoCoche>
	 */
	public List<EvisceradoDetalleProcesoCoche> obtenerLotesAperturados(Long idprod, Integer idturn)
	{
		try {
			
//			edp.evisceradoProceso.procesoAperturaCierre.estado = 1
			List<EvisceradoDetalleProcesoCoche> edpc = new ArrayList<EvisceradoDetalleProcesoCoche>();
			//and edp.evisceradoProceso.produccion.idproduccion = :idproduc
			Query query = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
					"where edpc.evisceradoDetalleProceso.estado = 1 and " +
					"edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idtur and " +
					"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc ");
			
			query.setParameter("idtur", idturn);
			query.setParameter("idproduc", idprod);
			
			edpc = (List<EvisceradoDetalleProcesoCoche>) query.getResultList();

			return edpc;		
			
		} catch (Exception e) {
			System.out.println("Error en el proceso --> " + e.getMessage());
			return null;		
		}
	}
	
	public void guardarEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso)
	{
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(evisceradoDetalleProceso);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	@Override
	public void saveOrUpdate(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		// TODO Auto-generated method stub
		
	}


	 @SuppressWarnings("unchecked")
	  public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesosByEvisceradoProceso(Long ideviscerado) {		

		  EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
		
			List<EvisceradoDetalleProceso> evisceradosDetallesProcesos = new ArrayList<EvisceradoDetalleProceso>();
		 
			Query q1 = em
				.createQuery("Select edp from EvisceradoDetalleProceso edp " +
						"where edp.evisceradoProceso.idevisceradoproceso = :idevi " +
						"order by edp.produccionDetalleLoteCajon.produccionDetalleLote.idlote asc ");  
		    q1.setParameter("idevi", ideviscerado);
		    	evisceradosDetallesProcesos = q1.getResultList();
			return evisceradosDetallesProcesos; 
	   }

	 
	 
	 @SuppressWarnings("unchecked")
	  public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesosByEvisceradoProcesoXProduccion(Long idprod) {		

		  EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
		
			List<EvisceradoDetalleProceso> evisceradosDetallesProcesos = new ArrayList<EvisceradoDetalleProceso>();
		 
			Query q1 = em
				.createQuery("Select edp from EvisceradoDetalleProceso edp " +
						"where edp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idprod " +
						"order by edp.produccionDetalleLoteCajon.produccionDetalleLote.idlote asc ");  
		    q1.setParameter("idprod", idprod);
		    	evisceradosDetallesProcesos = q1.getResultList();
			return evisceradosDetallesProcesos; 
	   }
	 
	 
	 
	 
	 
	 
	 @SuppressWarnings("unchecked")
	 public List<EvisceradoDetalleProceso> obtenerEvisceradoDetalleProcesos(Long idproduccion, Integer idturn) {		
	 	return em.createQuery("select edp from EvisceradoDetalleProceso edp,  ProduccionDetalleLoteCajon pdlc " +
	 			" where edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = '" + idturn.toString() +"' " +
	 			" and edp.estado in (1,2,3,0,4) and edp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = '" + idproduccion.toString() +"' " +
	 			" and edp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon ").getResultList();
	  	//return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
	 }

	 public EvisceradoDetalleProceso getEvisceradoDetalleProcesoByID(String id) 
	 { 
	 	
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("Select o "); 
	 	sb.append("From EvisceradoDetalleProceso o "); 
	 	sb.append("Where o.idevisceradodetalleproceso = '" + id + "'");
	 	
	 	//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

	 	List items =  em.createQuery(sb.toString()).getResultList();

	 	  if (items == null || items.isEmpty()) {
	 	      return null;
	 	  } else {
	 	      return  (EvisceradoDetalleProceso) items.get(0);
	 	  }		
	 }

	 public EvisceradoDetalleProceso getEvisceradoDetalleProcesoByPdlc(String id) 
	 { 
	 	
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("Select o "); 
	 	sb.append("From EvisceradoDetalleProceso o "); 
	 	sb.append("Where o.produccionDetalleLoteCajon.idproducciondetallelotecajon = '" + id + "'");
	 	
	 	List items =  em.createQuery(sb.toString()).getResultList();

	 	  if (items == null || items.isEmpty()) {
	 	      return null;
	 	  } else {
	 	      return  (EvisceradoDetalleProceso) items.get(0);
	 	  }		
	 }

	 public Long getMaxEvisceradoDetalleProcesoRackeo() 
	 { 
	 	
	 	StringBuffer sb = new StringBuffer();
	 	sb.append("Select max (o.idevisceradodetalleproceso) "); 
	 	sb.append("From EvisceradoDetalleProceso o "); 
	 	sb.append("where o.evisceradoProceso.procesoAperturaCierre.estado = 1 ");
	 	sb.append("and o.fechafinrackeo is null ");
	 	
	 	List items =  em.createQuery(sb.toString()).getResultList();

	 	  if (items == null || items.isEmpty()) {
	 	      return null;
	 	  } else {
	 	      return  (Long) items.get(0);
	 	  }		
	 }

		//AGREGAR
		//05-07-2016
		public EvisceradoDetalleProceso getEvisceradoDetalleProcesoByProduccionDetalleLoteCajonIdRegresh(String id) 
		{ 
			Query qry = em.createQuery("Select o " +
					"From EvisceradoDetalleProceso o " +
					"Where o.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote = '" + id+ "'").setFirstResult(0);
			
			//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());
		       Object lista;
		       try {
		             lista = qry.getSingleResult();
		       } catch (Exception e) {
		             // TODO Auto-generated catch block
		             return null;
		       }
		       
		       em.refresh(lista);

		       if(lista == null)
		       {
		             return null;
		       }
		       return (EvisceradoDetalleProceso) lista;
		}	 
	 
	 

		//AGREGAR
		//05-07-2016
		public EvisceradoDetalleProceso getEvisceradoDetalleProcesoByCamaraCajonIdLote(String vididcamaracajon)
		{
		       Query qry = em.createQuery("Select o From EvisceradoDetalleProceso o " +
			 			"Where o.produccionDetalleLoteCajon.camaraCajon.idcamaracajon = '" + vididcamaracajon + "' ")
		       		.setFirstResult(0);    
		       

		       Object lista;
		       try {
		             lista = qry.getSingleResult();
		       } catch (Exception e) {
		             // TODO Auto-generated catch block
		             return null;
		       }
		       
		       em.refresh(lista);

		       if(lista == null)
		       {
		             return null;
		       }
		       return (EvisceradoDetalleProceso) lista;
		}	 
}
