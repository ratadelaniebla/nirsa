package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Empleado;
import com.nw.model.LimpiezaDetalleProcesoLote;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LimpiezaProcesoEmpleado;
import com.nw.model.LimpiezaTipo;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.dao.LimpiezaProcesoDAO;


@SuppressWarnings({"rawtypes"})
public class LimpiezaProcesoDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaProcesoDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaProcesoDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    //TODO 0 EJEMPLO CONSULTA DE UN OBJETO POR UNA PROPIEDAD
//	@Override
//	public LimpiezaProceso getLimpiezaProcesoByProcesoAperturaCierreId(Long procesoAperturaCierreId, Long vip) {
//		String sql = "Select o from LimpiezaProceso o where o.procesoAperturaCierre.idprocesoaperturacierre=" + procesoAperturaCierreId +" and o.produccion.idproduccion = '"+vip+"'";
//		List lista = em.createQuery(sql).getResultList();
//		return ( lista==null || lista.isEmpty() ) ? null: (LimpiezaProceso)lista.get(0);
//	}

    //TODO 0 EJEMPLO CONSULTA DE UN OBJETO POR UNA PROPIEDAD
	@Override
	public LimpiezaProceso getLimpiezaProcesoByProcesoAperturaCierreId(Long procesoAperturaCierreId) {
		String jpql = "Select o from LimpiezaProceso o where o.procesoAperturaCierre.idprocesoaperturacierre=" + procesoAperturaCierreId;
		List lista = em.createQuery(jpql).getResultList();
		return ( lista==null || lista.isEmpty() ) ? null: (LimpiezaProceso)lista.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado>  obtenerlperetirados(LimpiezaProceso lp){
		try {
			List<LimpiezaProcesoEmpleado>  lpe = new ArrayList<LimpiezaProcesoEmpleado> ();
			Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
					" where lpe.limpiezaProceso=:limpiezaproceso and lpe.estado in(3)");
			
			System.out.println(query.toString());
			query.setParameter("limpiezaproceso", lp);
			lpe = (List<LimpiezaProcesoEmpleado>) query.getResultList();
			return (List<LimpiezaProcesoEmpleado>) lpe;
		} catch (Exception e) {
			return null;
		}
	}


	public LimpiezaProcesoEmpleado  obtenerlpe(LimpiezaProcesoEmpleado lpe1){
	    try {
	          System.out.println("Entro try");
	          LimpiezaProcesoEmpleado  lpe = new LimpiezaProcesoEmpleado();
	          Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe where lpe.idlimpiezaprocesoempleado=:idlimpiezaprocesoempleado and lpe.estado not in(2,3)");
	          query.setParameter("idlimpiezaprocesoempleado", lpe1.getIdlimpiezaprocesoempleado());
	          System.out.println(query.toString());
	          lpe = (LimpiezaProcesoEmpleado) query.getResultList().get(0);
	          return (LimpiezaProcesoEmpleado) lpe;
	    } catch (Exception e) {
	          return null;
	    }
	}


//Busca la lista de retirados
	public LimpiezaProcesoEmpleado  obtenerlpeRetirado(LimpiezaProcesoEmpleado lpe1){
	    try {
	          System.out.println("Entro try");
	          LimpiezaProcesoEmpleado  lpe = new LimpiezaProcesoEmpleado();
	          Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe where lpe.idlimpiezaprocesoempleado=:idlimpiezaprocesoempleado and lpe.estado = 3)");
	          query.setParameter("idlimpiezaprocesoempleado", lpe1.getIdlimpiezaprocesoempleado());
	          System.out.println(query.toString());
	          lpe = (LimpiezaProcesoEmpleado) query.getResultList().get(0);
	          return (LimpiezaProcesoEmpleado) lpe;
	    } catch (Exception e) {
	          
	          return null;
	    }
	    
	}


	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado>  obtenerlistalpe(LimpiezaProceso lp, int cargo, int linea){
	
		try {
			List<LimpiezaProcesoEmpleado>  lpe = new ArrayList<LimpiezaProcesoEmpleado> ();
			Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
					" where lpe.limpiezaProceso=:limpiezaproceso and lpe.limpiezaLinea.idlimpiezalinea=:linea and lpe.idlimpiezacargo=:cargo and (lpe.estado not in(2,3) or lpe.estado is null) ");
			
			System.out.println(query.toString());
			query.setParameter("limpiezaproceso", lp);
			query.setParameter("linea",linea);
			query.setParameter("cargo",cargo);
			lpe = (List<LimpiezaProcesoEmpleado>) query.getResultList();
			return (List<LimpiezaProcesoEmpleado>) lpe;
		} catch (Exception e) {
			return null;
		}
	
	}

	public LimpiezaProcesoEmpleado  obtenerexistencialpe(LimpiezaProceso lp, int cargo, int linea, int ubicacion){
		
		try {
			LimpiezaProcesoEmpleado  lpe = new LimpiezaProcesoEmpleado();
			Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
					" where lpe.limpiezaProceso=:limpiezaproceso and lpe.limpiezaLinea.idlimpiezalinea=:linea and lpe.idlimpiezacargo=:cargo and lpe.ubicacion=:ubicacion and (lpe.estado not in(2,3) or lpe.estado is null)");
			
			query.setParameter("limpiezaproceso", lp);
			query.setParameter("linea",linea);
			query.setParameter("cargo",cargo);
			query.setParameter("ubicacion",ubicacion);
			lpe = (LimpiezaProcesoEmpleado) query.getSingleResult();
			return (LimpiezaProcesoEmpleado) lpe;
		} catch (Exception e) {
			
			return null;
		}
		
	}

	public LimpiezaProcesoEmpleado  obtenerexistencialperetirado(Empleado emp,LimpiezaProceso lp, int cargo){
		try {
			System.out.println("Entro try");
			LimpiezaProcesoEmpleado  lpe = new LimpiezaProcesoEmpleado();
			Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe where lpe.limpiezaProceso=:limpiezaproceso and lpe.idlimpiezacargo=:cargo and lpe.empleado=:empleado ");
			query.setParameter("limpiezaproceso", lp);
			query.setParameter("cargo",cargo);
			query.setParameter("empleado",emp);
			System.out.println(query.toString());
			lpe = (LimpiezaProcesoEmpleado) query.getResultList().get(0);
			return (LimpiezaProcesoEmpleado) lpe;
		} catch (Exception e) {
			return null;
		}
	}


	public LimpiezaProcesoEmpleado  obtenerlpefuera(LimpiezaProcesoEmpleado lpe1){
		try {
			System.out.println("Entro try");
			LimpiezaProcesoEmpleado  lpe = new LimpiezaProcesoEmpleado();
			Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe where lpe.idlimpiezaprocesoempleado=:idlimpiezaprocesoempleado and lpe.estado in(2,3)");
			query.setParameter("idlimpiezaprocesoempleado", lpe1.getIdlimpiezaprocesoempleado());
			System.out.println(query.toString());
			lpe = (LimpiezaProcesoEmpleado) query.getResultList().get(0);
			return (LimpiezaProcesoEmpleado) lpe;
		} catch (Exception e) {
			return null;
		}
	}



	
    //TODO 0 EJEMPLO CONSULTA DE UN OBJETO POR UNA PROPIEDAD
//	@Override
//	public LimpiezaProceso getLimpiezaProcesoByProcesoAperturaCierreId1(Long procesoAperturaCierreId) {
//		String jpql = "Select o from LimpiezaProceso o where o.procesoAperturaCierre.idprocesoaperturacierre=" + procesoAperturaCierreId;
//		List lista = em.createQuery(jpql).getResultList();
//		return ( lista==null || lista.isEmpty() ) ? null: (LimpiezaProceso)lista.get(0);
//	}
	
	@Override
	public LimpiezaProceso getLimpiezaProcesoByProcesoAperturaCierreId(Long procesoAperturaCierreId, Long vip) {
		String sql = "SELECT o FROM LimpiezaProceso o "
				+ "WHERE o.procesoAperturaCierre.idprocesoaperturacierre=" + procesoAperturaCierreId 
				+ " AND o.produccion.idproduccion = '"+vip+"'";
		List lista = em.createQuery(sql).getResultList();
		return ( lista==null || lista.isEmpty() ) ? null: (LimpiezaProceso)lista.get(0);
	}
	
	public LimpiezaProceso obtenerLimpiezaPac(){
		
		try {
			LimpiezaProceso lp = new LimpiezaProceso();
			Query query = em.createQuery("select lp from LimpiezaProceso lp , ProcesoAperturaCierre pac  " +
					"where pac.idprocesoaperturacierre = lp.procesoAperturaCierre.idprocesoaperturacierre and pac.estado = 1 ");
			lp = (LimpiezaProceso) query.getSingleResult();
			return lp;
		} catch (Exception e) {
			
			return null;
		}
		
	}	

	public LimpiezaProceso obtenerLimpiezaMax(){
		
		try {
			LimpiezaProceso lp = new LimpiezaProceso();
			Query query = em.createQuery("select lp from LimpiezaProceso lp " +
					"where lp.idlimpiezaproceso = (select max(l.idlimpiezaproceso) from LimpiezaProceso l )");
			lp = (LimpiezaProceso) query.getSingleResult();
			return lp;
		} catch (Exception e) {
			
			return null;
		}
		
	}


	@SuppressWarnings({ "unchecked" })   
	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoByFechaTurnoLinea(Date fechaProduccion, int idturno , int idlimpiezalinea) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			 List<LimpiezaProcesoEmpleado> limpiezasProcesos = new ArrayList<LimpiezaProcesoEmpleado>();
			 Query query =  em.createQuery("Select lpe from LimpiezaProcesoEmpleado lpe " +
			 		" where lpe.limpiezaProceso.produccion.fechaproduccion = :fecha and lpe.limpiezaProceso.turno.idturno =:turno and lpe.limpiezaLinea.idlimpiezalinea =:linea");	
			 query.setParameter("fecha", fechaProduccion);
			 query.setParameter("turno",idturno);
			 query.setParameter("linea",idlimpiezalinea);
			 
			limpiezasProcesos = query.getResultList();
	    return limpiezasProcesos;
	}  

	@SuppressWarnings("unchecked")
	public List<LimpiezaDetalleProcesoLote> obtenerLimpiezaTipo(Long idproceso, Integer idturno){
		
		try {
			//LimpiezaDetalleProcesoLote lp = new LimpiezaDetalleProcesoLote();
			Query query = em.createQuery("select lp from LimpiezaDetalleProcesoLote lp " +
					"where lp.limpiezaProceso.idlimpiezaproceso=:idproceso and lp.turno.idturno=:idturno order by lp.idlimpiezadetalleprocesolote  ");
			 query.setParameter("idproceso", idproceso);
			 query.setParameter("idturno", idturno);
			
			return query.getResultList();
		} catch (Exception e) {		
			System.out.println(""+e.getMessage());
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<LimpiezaDetalleProcesoLote> obtenerLotesLimpieza(Long idproceso, Integer idturno){
		
		try {
			//LimpiezaDetalleProcesoLote lp = new LimpiezaDetalleProcesoLote();
			Query query = em.createQuery("select lp from LimpiezaDetalleProcesoLote lp " +
					"where lp.limpiezaProceso.idlimpiezaproceso=:idproceso and lp.turno.idturno=:idturno order by lp.produccionDetalleLote.idlote  ");
			 query.setParameter("idproceso", idproceso);
			 query.setParameter("idturno", idturno);
			
			return query.getResultList();
		} catch (Exception e) {		
			System.out.println(""+e.getMessage());
			return null;
		}
		
	}	
	
    @SuppressWarnings("unchecked")
	public List<LimpiezaProceso> BuscarAntioresLimpiezaProcesoPlanta(Long idp, Integer ultimas) 
    { 
  		Query qryPro = em.createQuery("SELECT p FROM LimpiezaProceso p " + 
  				" Where p.procesoAperturaCierre.estado in (0,1) " +
  				"   and p.procesoAperturaCierre.proceso.idproceso = 4 " +
  				"   and p.produccion.idproduccion >=:idp " +
  				"   order by p.produccion.idproduccion desc");
  		
  				idp = idp - 1;
  				System.out.println("idp :"+idp);
  				
  				qryPro.setParameter("idp", idp);
  				
  		//return qryPro.getResultList().subList(0, ultimas * 2);
  				return qryPro.getResultList();
    }	

    //MODIFICADO 06/03/2017 CAMBIO
    //NUEVO 11-01-2017
    @SuppressWarnings("unchecked")
	public List<LimpiezaProceso> BuscarAntioresLimpiezaProcesoPlanta1(Long idp, Integer ultimas) 
    { 
  		Query qryPro = em.createQuery("SELECT p FROM LimpiezaProceso p " + 
  				" Where p.procesoAperturaCierre.estado in (0,1) " +
  				"   and p.procesoAperturaCierre.proceso.idproceso = 4 " +
  				"   and p.produccion.idproduccion >=:idp and p.produccion.idproduccion <:idpo  " +
  				"   order by p.produccion.idproduccion desc");
  		
		Long idpo = idp;
		
		idp = idp - ultimas;
		
		
		System.out.println("idp :"+idp);
		
		
		qryPro.setParameter("idpo", idpo);
		qryPro.setParameter("idp", idp);
		
		return qryPro.getResultList();
    }    
	
	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaTipo> getTipoLimpieza(int idlimpieza) {
		return em.createQuery("select c from LimpiezaTipo c where c.idlimpiezatipo  order by c.descripcion ")
				.getResultList();
	}
	

	public  LimpiezaProceso obtenerLimpiezabyProduccionTurno(Produccion Prod,Turno Turno){
		
		try {
			LimpiezaProceso lp = new LimpiezaProceso();
			Query query = em.createQuery("select lp from LimpiezaProceso lp " +
					"where lp.produccion=:produccion and lp.turno=:turno");
			query.setParameter("produccion", Prod);
			 query.setParameter("turno", Turno);
			lp = (LimpiezaProceso) query.getResultList().get(0);
			return lp;
		} catch (Exception e) {
			
			return null;
		}
		
	}
	
	public LimpiezaProceso obtenerLimpiezabyProduccionTurnoNuevo(Long Prod,Integer Turno){
		
		LimpiezaProceso lp = new LimpiezaProceso();
		Query query = em.createQuery("select lp from LimpiezaProceso lp " +
				" where lp.produccion.idproduccion=:produccion and lp.turno.idturno=:turno");
		query.setParameter("produccion", Prod);
		query.setParameter("turno", Turno);
		lp = (LimpiezaProceso) query.getSingleResult();
		
		if(lp!=null)
			return lp;
		else
			return null;
	}

	//Nuevo 20-03-2017
	public LimpiezaProcesoEmpleado  obtenerlpebyUbicacion(LimpiezaProceso lp, int cargo, int linea,int ubicacion){
	      
		try {
			LimpiezaProcesoEmpleado  lpe = new LimpiezaProcesoEmpleado();
            Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
                        " where lpe.limpiezaProceso=:limpiezaproceso and lpe.limpiezaLinea.idlimpiezalinea=:linea and lpe.idlimpiezacargo=:cargo and (lpe.estado not in(2,3) or lpe.estado is null) and lpe.ubicacion=:ubicacion ");
            
            query.setParameter("limpiezaproceso", lp);
            query.setParameter("linea",linea);
            query.setParameter("ubicacion",ubicacion);
            query.setParameter("cargo",cargo);
            lpe = (LimpiezaProcesoEmpleado) query.getResultList().get(0);
            return (LimpiezaProcesoEmpleado) lpe;
		} catch (Exception e) {
            return null;
		}
	      
	}

	
	//Nuevo 20-03-2017
	public LimpiezaProcesoEmpleado  obtenerlpeActivo(LimpiezaProcesoEmpleado lpe){
	      
	      try {
	            
//	            Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
//	                        " where lpe.limpiezaProceso=:limpiezaproceso and lpe.limpiezaLinea.idlimpiezalinea=:linea and lpe.idlimpiezacargo=:cargo and (lpe.estado not in(2,3) or lpe.estado is null) and lpe.ubicacion=:ubicacion ");

	            
	    		Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
	    				" where lpe.limpiezaProceso=:limpiezaproceso and lpe.idlimpiezaprocesoempleado=:idlimpiezaprocesoempleado and (lpe.estado not in(2,3) or lpe.estado is null) ");
	            
	    		
//	    		Query query = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe where lpe.idlimpiezaprocesoempleado=:idlimpiezaprocesoempleado and lpe.estado in(2,3)");
//	   		 query.setParameter("idlimpiezaprocesoempleado", lpe1.getIdlimpiezaprocesoempleado());	    		
	    		
	            
	            System.out.println(query.toString());
	            query.setParameter("idlimpiezaprocesoempleado", lpe.getIdlimpiezaprocesoempleado() );
	            
	            lpe = (LimpiezaProcesoEmpleado) query.getResultList().get(0);
	            return (LimpiezaProcesoEmpleado) lpe;
	      } catch (Exception e) {
	            
	            return null;
	      }	      
	}
	
	
	// Adicionado por Manexware

	@SuppressWarnings("unchecked")
	public List<LimpiezaProceso> getProduccionesAperturadasAreaLimpieza() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("SELECT lp ");
		sbuilder.append("FROM LimpiezaProceso lp, ProcesoAperturaCierre pac, Produccion p  ");
		sbuilder.append("WHERE pac.estado = 1 ");
		sbuilder.append("AND lp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
		sbuilder.append("AND lp.produccion.idproduccion = p.idproduccion");
		try {
			List<LimpiezaProceso> resultList = (List<LimpiezaProceso>) em
					.createQuery(sbuilder.toString())
					.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getHorasbyProduccionandTurno(long idproduccion,int idturno)
	{


		StringBuilder sb = new StringBuilder();
		sb.append(" select distinct (EXTRACT(HOUR FROM ldpb.fechareg))::VARCHAR AS hora,'we' as s ,to_char(ldpb.fechareg, 'YYYY-MM-DD HH24')  AS hora1");
		sb.append(" FROM ");
		sb.append(" limpieza_detalle_proceso_bandeja ldpb ");
		sb.append(" inner join limpieza_detalle_proceso_lote ldpl on ldpl.idlimpiezadetalleprocesolote=ldpb.idlimpiezadetalleprocesolote ");
		sb.append(" inner join produccion_detalle_lote pdl on pdl.idproducciondetallelote=ldpl.idproducciondetallelote ");
		sb.append(" where pdl.idproduccion="+idproduccion+" and pdl.idturno="+idturno+" " );
		sb.append(" order by 3 ");
		System.out.println(sb.toString());
		Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
	}
	
	/**
	 * extrae los ultimos n registros dediferente produccion
	 * @author Cls MBaque
	 */
	@SuppressWarnings("unchecked")
	public List<LimpiezaProceso> obtieneLimpiezaProcesoNUltimos (Integer limit) {
		try {
			String sqlDistinct = "SELECT DISTINCT lcp.produccion.idproduccion FROM LimpiezaProceso lcp  ORDER BY lcp.idlimpiezaproceso DESC ";
			String sqlMax = "SELECT MAX ( lc.idlimpiezaproceso ) "
					+ "	FROM LimpiezaProceso lc "
					+ "	WHERE lc.produccion.idproduccion = :idDistinctProduccion "
					+ "	GROUP BY lc.produccion.idproduccion "
					+ "	ORDER BY 1 DESC";
			String sqlLimpiezaProceso = "SELECT l FROM LimpiezaProceso l WHERE l.idlimpiezaproceso = :lSqlMax";
	
			List<Long> lista = em.createQuery(sqlDistinct).getResultList();
			List<Long> listSqlDistinctProduccion = lista.subList(0, lista.size()<limit?lista.size():limit);
			
			List<Long> listSqlMax = new ArrayList<Long>();
			List<LimpiezaProceso> listLimpiezaProceso = new ArrayList<LimpiezaProceso>();
			
			for (Long idDistinctProduccion : listSqlDistinctProduccion)
				listSqlMax.add((Long)em.createQuery(sqlMax).setParameter("idDistinctProduccion", idDistinctProduccion).getResultList().get(0));
			
			for (Long lSqlMax : listSqlMax)
				listLimpiezaProceso.add((LimpiezaProceso)em.createQuery(sqlLimpiezaProceso).setParameter("lSqlMax", lSqlMax).getResultList().get(0));
		
			return listLimpiezaProceso;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<LimpiezaProceso>();
		}
	}
	 
	/**
	 * 05-10-2017
	 * Guarda o Edita un Objeto LimpiezaProceso 
	 * y devuelve el registro generado o actualizado
	 * @param limpiezaProceso
	 * @return
	 */
	public LimpiezaProceso saveOrUpdate(LimpiezaProceso limpiezaProceso) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();  
		EntityTransaction t = em.getTransaction();
		LimpiezaProceso limpiezaProcesoDevuelto = null;
		try {
			t.begin();
			limpiezaProcesoDevuelto = em.merge(limpiezaProceso);
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
		return limpiezaProcesoDevuelto;
	}
	
}
