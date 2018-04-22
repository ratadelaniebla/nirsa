package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CalidadDetalleMuestreoCocina;
import com.nw.model.EvisceradoAuditoriaReimpresion;
import com.nw.model.EvisceradoDetalleProceso;
import com.nw.model.EvisceradoDetalleProcesoCoche;
//import com.nw.model.LimpiezaDetalleProcesoLote;
//import com.nw.model.LonjasDetalleProcesoConteo;
import com.nw.model.Produccion;
//import com.nw.model.ProduccionDetalleLote;
import com.nw.model.dao.EvisceradoDetalleProcesoCocheDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class EvisceradoDetalleProcesoCocheDAOJpaImpl extends BaseDaoJpaImpl implements EvisceradoDetalleProcesoCocheDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public EvisceradoDetalleProcesoCocheDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

    /**
     * Devuelve un registro dado su ID
     * @author carper 
     * @param id
     * @return
     */
//    public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheById(Long id){
//    	return em.find(EvisceradoDetalleProcesoCoche.class, id);
//    }	
	
    
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheById(Long id) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From EvisceradoDetalleProcesoCoche o "); 
		sb.append("Where o.idevisceradodetalleprocesocoche = '" + String.valueOf(id) + "' "); 
		sb.append("AND o.idevisceradodetalleprocesocoche NOT IN (Select l.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from LimpiezaDetalleProcesoCoche l where l.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = '" + String.valueOf(id) + "' )");
		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (EvisceradoDetalleProcesoCoche) items.get(0);
        }	
	}	    

    /**
	 * Se obtiene el numero total de los coches que se encuentran en una cocina seleccionada
	 * se utiliza el siguiente query
	 * select count(eviscerado_detalle_proceso_coche.idcoche) from coccion_detalle_proceso_coche
inner join eviscerado_detalle_proceso_coche 
on eviscerado_detalle_proceso_coche.idevisceradodetalleprocesocoche = coccion_detalle_proceso_coche.evisceradodetalleprocesocoche
inner join coccion_proceso 
on coccion_proceso.idcoccionproceso = coccion_detalle_proceso_coche.idcoccionproceso
inner join produccion 
on produccion.idproduccion = coccion_proceso.idproduccion
where eviscerado_detalle_proceso_coche.idcocina = 1 and produccion.idproduccion = 19
	 * @return
	 * int
	 */
	
    
    /**
     * 
     * Aplicar la siguiente consulta
     * 
     * 
select eviscerado_detalle_proceso_coche.idevisceradodetalleprocesocoche from eviscerado_detalle_proceso_coche
where eviscerado_detalle_proceso_coche.idcocina = 1
except 
select coccion_detalle_proceso_coche.evisceradodetalleprocesocoche from coccion_detalle_proceso_coche 
where coccion_detalle_proceso_coche.peso = 0
     * 
     * @param idCocina
     * @param idprod
     * @return
     */
    
	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> getCocinadasPorProduccion(Long idcacd, Long vidproduccion){
		
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				"where edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"+ idcacd +"' and  edpc.peso > 0 and " +
				"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = '"+ vidproduccion +"' and " +
				"edpc.idevisceradodetalleprocesocoche not in (select cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cdpc ) ");
		
		return qry.getResultList();
	}    
    
	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> getCocinadasPorProduccion2(Long idcacd, Long vidproduccion){
		
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				"where edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"+ idcacd +"' and  edpc.peso > 0 and " +
				"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = '"+ vidproduccion +"' and " +
				"edpc.idevisceradodetalleprocesocoche not in (select cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cdpc ) ");
		
		return qry.getResultList();
	}    
    
	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> getCochesXCocinadaxProduccion(Long idcacd){
		
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				"where edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"+ idcacd +"' and  edpc.peso > 0 and " +
				"edpc.idcocheprincipal is null " );
		
		return qry.getResultList();
	}    


	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> getCochesXCocinadaXLote(Long idcacd, Long evisdetproc){
		return em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc, EvisceradoDetalleProceso edp,  CocinaAperturaCierreDetalle cacd " +
				" where edpc.evisceradoDetalleProceso.idevisceradodetalleproceso = edp.idevisceradodetalleproceso " +
				" and edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle " +
				" and cacd.idcocinaaperturacierredetalle = '" + idcacd.toString() +"' " +
				" and edpc.evisceradoDetalleProceso.idevisceradodetalleproceso = '" + evisdetproc.toString() +"' ").getResultList();
	}    

	public int getNumCochesXCocinadaXLote(Long idcacd, Long evisdetproc)
	{
		int rec = 0;
		
		Query query = em.createQuery("select count(edpc.idevisceradodetalleprocesocoche) from EvisceradoDetalleProcesoCoche edpc, EvisceradoDetalleProceso edp,  CocinaAperturaCierreDetalle cacd " +
				" where edpc.evisceradoDetalleProceso.idevisceradodetalleproceso = edp.idevisceradodetalleproceso " +
				" and edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle " +
				"and cacd.idcocinaaperturacierredetalle = :idCocinada " +
				"and edpc.evisceradoDetalleProceso.idevisceradodetalleproceso = :idEvisProc ");
		query.setParameter("idCocinada", idcacd);
		query.setParameter("idEvisProc", evisdetproc);
		String c = query.getSingleResult().toString();
		rec = Integer.valueOf(c);

		return rec;
	}
	
	
	
	
	
  	// Consultar la cantidad de registros de coches del lote seleccionado y
	// aumentar +1 al resultado
	// luego verificar si se asigna en el campo idcohe
	// select count(idevisceradodetalleprocesocoche) from
	// eviscerado_detalle_proceso_coche where idevisceradodetalleproceso = 1
	public Integer obtenerTotalCocheLote(Long idevisceradodetalleproceso) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em
				.createQuery("select max(edpc.idcochelote) from EvisceradoDetalleProcesoCoche edpc"
						+ " inner join edpc.evisceradoDetalleProceso edp "
						+ " where edp.idevisceradodetalleproceso =:idedp"); // :idedp
		query.setParameter("idedp", idevisceradodetalleproceso);
		// Object obj = query.getSingleResult();
		Integer resultado = (Integer) query.getSingleResult();
		// Sistema.mensaje("cantidad de registros-->"+resultado);
		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 
	 * METODO QUE OBTIENE LOS REGISTROS CON TARA 0  EN LA TABLA eviscerado_detalle_proceso_coche
	 * del lote seleccionado (de la tabla: eviscerado_detalle_proceso)
	 * select * from eviscerado_detalle_proceso_coche
	 * inner join eviscerado_detalle_proceso on eviscerado_detalle_proceso_coche.idevisceradodetalleproceso = eviscerado_detalle_proceso.idevisceradodetalleproceso
	 * where eviscerado_detalle_proceso_coche.tara = 0 and
	 * eviscerado_detalle_proceso.idevisceradodetalleproceso = (select max(eviscerado_detalle_proceso.idevisceradodetalleproceso) from eviscerado_detalle_proceso)
	 * 
	 * @return
	 */
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches(Long idevisceradodetalleproceso) { // --> parametro 
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesosCoches = new ArrayList<EvisceradoDetalleProcesoCoche>();

		try {
			Query query = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc"
							+ " inner join edpc.evisceradoDetalleProceso edp "
							+ " where edpc.tara = 0 and edp.idevisceradodetalleproceso = (select max(ed.idevisceradodetalleproceso) from EvisceradoDetalleProceso ed)  order by edpc.idevisceradodetalleprocesocoche  ");
			//query.setParameter("idedp", idevisceradodetalleproceso);
			evisceradoDetalleProcesosCoches = (List<EvisceradoDetalleProcesoCoche>) query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->" + e.getMessage());
		}
		return evisceradoDetalleProcesosCoches;
	}
	
	
	/**
	 * 
	 * select * from eviscerado_detalle_proceso_coche
	 * inner join eviscerado_detalle_proceso on eviscerado_detalle_proceso_coche.idevisceradodetalleproceso = eviscerado_detalle_proceso.idevisceradodetalleproceso
	 * inner join eviscerado_proceso on eviscerado_proceso.idevisceradoproceso = eviscerado_detalle_proceso.idevisceradoproceso
	 * inner join produccion on produccion.idproduccion = eviscerado_proceso.idproduccion
	 * where eviscerado_detalle_proceso_coche.tara = 0 and
	 * produccion.idproduccion = 166
	 * 
	 * @return
	 */
	public List<EvisceradoDetalleProcesoCoche> listaCocheTaraCero(Long idpro)
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesosCoches = new ArrayList<EvisceradoDetalleProcesoCoche>();

		try {
			Query query = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
					"where edpc.tara = 0 and " +
					"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc " +
					" order by edpc.idevisceradodetalleprocesocoche ");
			
			query.setParameter("idproduc", idpro);
			evisceradoDetalleProcesosCoches = (List<EvisceradoDetalleProcesoCoche>) query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->" + e.getMessage());
		}
		return evisceradoDetalleProcesosCoches;
	}

	
	public List<EvisceradoDetalleProcesoCoche> listaCocheSinIdentidficacion()
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesosCoches = new ArrayList<EvisceradoDetalleProcesoCoche>();

		try {
			Query query = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc where edpc.evisceradoDetalleProceso is null order by edpc.idevisceradodetalleprocesocoche ");
//			
//			"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc " +
//			" order by edpc.idevisceradodetalleprocesocoche ");			
			
			evisceradoDetalleProcesosCoches = (List<EvisceradoDetalleProcesoCoche>) query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->" + e.getMessage());
		}
		return evisceradoDetalleProcesosCoches;
	}

	
	public List<EvisceradoDetalleProcesoCoche> listaCocheSinIdentidficacionNormal()
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesosCoches = new ArrayList<EvisceradoDetalleProcesoCoche>();

		try {
			Query query = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc where edpc.evisceradoDetalleProceso is null and edpc.contingencia is null order by edpc.idevisceradodetalleprocesocoche ");
//			
//			"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc " +
//			" order by edpc.idevisceradodetalleprocesocoche ");			
			
			evisceradoDetalleProcesosCoches = (List<EvisceradoDetalleProcesoCoche>) query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->" + e.getMessage());
		}
		return evisceradoDetalleProcesosCoches;
	}
	
	public List<EvisceradoDetalleProcesoCoche> listaCocheSinIdentidficacionContingencia()
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesosCoches = new ArrayList<EvisceradoDetalleProcesoCoche>();

		try {
			Query query = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc where edpc.evisceradoDetalleProceso is null and edpc.contingencia = true order by edpc.idevisceradodetalleprocesocoche ");
//			
//			"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc " +
//			" order by edpc.idevisceradodetalleprocesocoche ");			
			
			evisceradoDetalleProcesosCoches = (List<EvisceradoDetalleProcesoCoche>) query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->" + e.getMessage());
		}
		return evisceradoDetalleProcesosCoches;
	}	
	/**
	 * Obtiene el promedio de todos los valores diferentes de CERO del canpo
	 * Tara de la tabla Eviscerado_detalle_proceso_coche
	 * 
	 * @return
	 */
	public double getPromedioSumatoriaTara() {
		// select avg(eviscerado_detalle_proceso_coche.tara) from
		// eviscerado_detalle_proceso_coche
		// where eviscerado_detalle_proceso_coche.tara != 0
		try {
			Query qry = em
					.createQuery("select avg(edpc.tara) from EvisceradoDetalleProcesoCoche edpc "
							+ "where edpc.tara != 0 ");

			return (Double) qry.getSingleResult();
		} catch (Exception e) {
			System.out
					.println("Error, no se pudo calcular el promedio de Peso: "
							+ e.getMessage());
			return 0;
		}

	}

	public double getPromedioSumatoriaPeso() {
		// select avg(eviscerado_detalle_proceso_coche.peso) from
		// eviscerado_detalle_proceso_coche
		// where eviscerado_detalle_proceso_coche.peso != 0
		try {
			Query qry = em
					.createQuery("select avg(edpc.peso) from EvisceradoDetalleProcesoCoche edpc "
							+ "where edpc.peso != 0 ");

			return (Double) qry.getSingleResult();
		} catch (Exception e) {
			System.out
					.println("Error, no se pudo calcular el promedio de Peso: "
							+ e.getMessage());
			return 0;
		}

	}

	/**
	 * Consulta todos los registros con tara o peso igual a CERO, la consulta
	 * sql que se utilizó es: select * from eviscerado_detalle_proceso_coche
	 * where eviscerado_detalle_proceso_coche.tara = 0 or
	 * eviscerado_detalle_proceso_coche.peso = 0
	 * 
	 * @return List<EvisceradoDetalleProcesoCoche>
	 */
	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoTaraPesoCero() {
		return em.createQuery(
				"select edpc from EvisceradoDetalleProcesoCoche edpc "
						+ "where edpc.tara = 0 or edpc.peso = 0 ")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoPesoCero() {
		return em.createQuery(
				"select edpc from EvisceradoDetalleProcesoCoche edpc "
						+ "where edpc.peso = 0 ").getResultList();
	}

	
	
	public Long getMaxId() {
		// select avg(eviscerado_detalle_proceso_coche.peso) from
		// eviscerado_detalle_proceso_coche
		// where eviscerado_detalle_proceso_coche.peso != 0
		try {
			Query qry = em
					.createQuery("select MAX(edpc.idevisceradodetalleprocesocoche) from EvisceradoDetalleProcesoCoche edpc  ");

			return (Long) qry.getSingleResult();
		} catch (Exception e) {
			System.out
					.println("Error, no se pudo calcular el maximo id: "
							+ e.getMessage());
			return (long) 0;
		}

	}	
	
	
	public Long getMaxIdevisceradoDetalleProcesoCoche(Long idevis) {
		try {
			
			System.out.println("valor idevisceradodetalleproceso-->" + idevis );
			
			
			Query qry = em.createQuery("select MAX(edpc.idevisceradodetalleprocesocoche) from EvisceradoDetalleProcesoCoche edpc " +
							"where edpc.evisceradoDetalleProceso.idevisceradodetalleproceso = :id ");
			qry.setParameter("id", idevis);

			if (qry.getSingleResult() == null) {
				return (long) 1;
			}
			else
			{
				return (Long) qry.getSingleResult();
			}
			
			
		} catch (Exception e) {
			System.out.println("Error, no se pudo calcular el maximo id: "
							+ e.getMessage());
			return (long) 0;
		}

	}	
	

	

	

	
	public EvisceradoDetalleProcesoCoche guardarEvisceradoDetalleProcesoCoche(
			EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		EvisceradoDetalleProcesoCoche eDPCoche;
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				eDPCoche=em.merge(evisceradoDetalleProcesoCoche);
				t.commit();
				return eDPCoche; 
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}

	@Override
	public EvisceradoDetalleProcesoCoche saveOrUpdate(
			EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {

		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EvisceradoDetalleProcesoCoche edpc = new EvisceradoDetalleProcesoCoche();
		
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				 edpc = em.merge(evisceradoDetalleProcesoCoche);
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


	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoCochesaCerrar() {
		List<EvisceradoDetalleProcesoCoche> edpc = new ArrayList<EvisceradoDetalleProcesoCoche>();
		try {
			Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
					" where edpc.estadouso = 0 and edpc.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 ");
			edpc = qry.getResultList();
			return edpc;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

public EvisceradoDetalleProcesoCoche obtenerSecuenciaCocheenProduccionActiva(){
		//List<EvisceradoDetalleProcesoCoche>
		EvisceradoDetalleProcesoCoche edp = new EvisceradoDetalleProcesoCoche();
		try {
			Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
					" where edpc.idevisceradodetalleprocesocoche=(select max(ep.idevisceradodetalleprocesocoche) from EvisceradoDetalleProcesoCoche ep )");
			edp = (EvisceradoDetalleProcesoCoche) qry.getSingleResult();
			return edp;
			//return qry.getResultList();
		} catch (Exception e) {
			System.out.println("Error, no se pudo calcular el maximo id: "
					+ e.getMessage());
			return null;
		}
		
	}  

//Editado 02-02-2017
public EvisceradoDetalleProcesoCoche obtenerMaxSecuenciaCocheenProduccionActiva(){
	EvisceradoDetalleProcesoCoche edp = new EvisceradoDetalleProcesoCoche();
	try {
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				" where edpc.idevisceradodetalleprocesocoche=" +
				"(select max(edpc2.idevisceradodetalleprocesocoche) from EvisceradoDetalleProcesoCoche edpc2" +
				" where edpc2.codbarra  = " +
				"(select max(ep.codbarra) from EvisceradoDetalleProcesoCoche ep" +
/*				" where ep.estadouso = 1  and " +*/
				" where " +
				"ep.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 ))");
		edp = (EvisceradoDetalleProcesoCoche) qry.getSingleResult();
		
		em.remove(edp);
		
		return edp;
		//return qry.getResultList();
	} catch (Exception e) {
		System.out.println("Error, no se pudo calcular el maximo id: "
				+ e.getMessage());
		return null;
	}
	
}  
//Editado 02-02-2017
public EvisceradoDetalleProcesoCoche obtenerMaxSecuenciaCocheconTara()
{
	EvisceradoDetalleProcesoCoche edp = new EvisceradoDetalleProcesoCoche();
	try {
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				" where edpc.idevisceradodetalleprocesocoche=" +
				"(select max(edpc2.idevisceradodetalleprocesocoche) from EvisceradoDetalleProcesoCoche edpc2" +
				" where edpc2.codbarra  = " +
				"(select max(ep.codbarra) from EvisceradoDetalleProcesoCoche ep" +
				" where ep.estadouso = 0  ))");
		edp = (EvisceradoDetalleProcesoCoche) qry.getSingleResult();
		
		em.refresh(edp);
		
		return edp;
		//return qry.getResultList();
	} catch (Exception e) {
		System.out.println("Error, no se pudo calcular el maximo id: "
				+ e.getMessage());
		return null;
	}
	
}  


@SuppressWarnings("unchecked")
	public Integer obtenerNumeroCocheProduccion(EvisceradoDetalleProceso idEDP){
		//List<EvisceradoDetalleProcesoCoche>
		try {
			Query qry = em.createQuery("select MAX(edpc.idcochedia) from EvisceradoDetalleProcesoCoche edpc " +
					" where edpc.evisceradoDetalleProceso = :idEDP  ");
			qry.setParameter("idEDP", idEDP);
			Integer resultado = (Integer) qry.getSingleResult();
			return resultado;
			//return qry.getResultList();
		} catch (Exception e) {
			System.out.println("Error, no se pudo calcular el maximo id: "
					+ e.getMessage());
			return null;
		}
		
	}	


//Editado 02-02-2017
public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarra(Long codbarra)
{

	System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 ");
	
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	List items =  em.createQuery(sb.toString()).getResultList();
	
	//em.refresh(items);
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProcesoCoche) items.get(0);
    }					
}



//Obtiene el registro del ultimo coche hacia abajo apartir de la secuencia tope (inicio en modo automatico para continuar con los registros)
//public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraAntesDeContigencia(Long codbarra)
//{
//	StringBuffer sb = new StringBuffer();
//	sb.append("Select o "); 
//	sb.append("From EvisceradoDetalleProcesoCoche o "); 	
//	//sb.append("Where o.codbarra < '" + codbarra.toString().trim() + "' and  o.estadouso = 1 ");	
//	sb.append("Where o.codbarra < '" + codbarra.toString().trim() + "' ");
//	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
//	sb.append("order by o.codbarra desc ");
//	
////	.setMaxResults(1)
////    .getResultList();
//	
//	List items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();
//	
//    if (items == null || items.isEmpty()) 
//    {
//        return null;
//    } 
//    else 
//    {
//        return  (EvisceradoDetalleProcesoCoche) items.get(0);
//    }					
//}



////Obtiene el registro del ultimo coche hacia abajo apartir de la secuencia tope (inicio en modo automatico para continuar con los registros)
//public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraAntesDeContigencia(Long codbarra)
//{
//	StringBuffer sb = new StringBuffer();
//	sb.append("Select o "); 
//	sb.append("From EvisceradoDetalleProcesoCoche o "); 	
//	sb.append("Where o.codbarra < '" + codbarra.toString().trim() + "' ");
////	sb.append("and o.estadouso = 0 "); 
//	sb.append("order by o.fechareg desc, o.codbarra desc ");
//	
//	List items;
//	
//	try {
//		items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();
//		
//		  if (items == null || items.isEmpty()) 
//		  {
//		      return null;
//		  } 
//		  else 
//		  {
//		      return  (EvisceradoDetalleProcesoCoche) items.get(0);
//		  }
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		// e.printStackTrace();
//		return null;
//	}	
//}


//Obtiene el registro del ultimo coche hacia abajo apartir de la secuencia tope (inicio en modo automatico para continuar con los registros)
public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraAntesDeContigencia(Long codbarra) throws SQLException
{
StringBuffer sb = new StringBuffer();


//Nuevo 31-01-2017
return null;
}



public List<Object[]> getSecuenciaContingencia(Long codbarra)
{
	StringBuilder sb = new StringBuilder();
	sb.append("select 0 idp, ");
	sb.append("(select eviscerado_generar_secuencia_contingencia ("+codbarra+"))");
	
	Query query = em.createNativeQuery(sb.toString());
	return query.getResultList();
}




public List<Object[]> getValidarSecuenciaCompleta(Long codbarra)
{
	StringBuilder sb = new StringBuilder();
	sb.append("select 0 idp, ");
	sb.append("(select eviscerado_validar_secuencia_completa ("+codbarra+"))");
	
	Query query = em.createNativeQuery(sb.toString());
	return query.getResultList();
}



public List<Object[]> getValidarSecuenciaTarada(Long codbarra)
{
	StringBuilder sb = new StringBuilder();
	sb.append("select 0 idp, ");
	sb.append("(select eviscerado_validar_secuencia_tarada ("+codbarra+"))");
	
	Query query = em.createNativeQuery(sb.toString());
	return query.getResultList();
}



public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheUltimoIngresado(Long codbarra)
{

	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 	
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' ");
	sb.append("order by o.fechareg desc "); 	
	
	List items;
	try {
		items =  em.createQuery(sb.toString()).setMaxResults(1).getResultList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return null;
	}	
	//em.refresh(items);
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProcesoCoche) items.get(0);
    }					
}




//public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraAntesDeContigencia(Long codbarra)
//{
//	EvisceradoDetalleProcesoCoche edp = new EvisceradoDetalleProcesoCoche();
//	try {
//		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
//				" where edpc.codbarra < '" + codbarra.toString().trim() + "' " +
//				" and edpc.estadouso = 0 ");
//		
//		List items =  em.createQuery(qry.toString()).setMaxResults(1).getResultList();
//		
//		edp =  (EvisceradoDetalleProcesoCoche) items.get(0);
//		//edp = (EvisceradoDetalleProcesoCoche) qry.setMaxResults(1).getResultList();
//		
//		em.refresh(edp);
//		
//		return edp;
//		//return qry.getResultList();
//	} catch (Exception e) {
//		System.out.println("Error, no se pudo calcular el maximo id: "
//				+ e.getMessage());
//		return null;
//	}
//	
//}  



@SuppressWarnings("unchecked")
public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraCalidad(Long codbarra)
{
//	, Long idprod, Integer idtur
	//List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();

	Query qry = em.createQuery("Select o "+ 
	"From EvisceradoDetalleProcesoCoche o "+ 
	"Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 "+ 
	"and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "+ 
	"order by o.idevisceradodetalleprocesocoche desc ").setFirstResult(0);	
	
//	Query qry = em.createQuery("select ev from EvisceradoDetalleProcesoCoche ev " +
//			"where ev.codbarra = "+ idcoche +" and ev.estadouso = 1 " +
//			"and ev.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
//			"and ev.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 order by ev.idevisceradodetalleprocesocoche desc").setFirstResult(0);
	//lista =  qry.getResultList();
	
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
	return (EvisceradoDetalleProcesoCoche) lista;
}

public List<EvisceradoDetalleProcesoCoche> getListaEvisceradoDetalleProcesoCocheByCodBarra(Long idEviscerado)
{

	List<EvisceradoDetalleProcesoCoche> edpc;
	 
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
/*	Query q1 = em
			.createQuery("Select edpc From EvisceradoDetalleProcesoCoche edpc " +
					"where edpc.idevisceradodetalleprocesocoche = :id or edpc.idcocheprincipal=:id " +
					"and edpc.estadouso = 1 " +
					"and edpc.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " +
					"or edpc.idcocheprincipal=:id"); 
	     q1.setParameter("id", idEviscerado);
*/
	 Query q1 = em
			.createQuery("Select edpc From EvisceradoDetalleProcesoCoche edpc " +
					"where edpc.idevisceradodetalleprocesocoche = :id or edpc.idcocheprincipal=:id " +
					"and edpc.estadouso = 1 " );
	     q1.setParameter("id", idEviscerado);
	     
	
	try {
		edpc = q1.getResultList();
		return edpc;
	} catch (Exception e) {
		return null;
	}
				
}

public List<EvisceradoDetalleProcesoCoche> getListaPadreEvisceradoDetalleProcesoCocheByCodBarra(Long idEviscerado)
{

	List<EvisceradoDetalleProcesoCoche> edpc;
	 
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	Query q1 = em
			.createQuery("Select edpc From EvisceradoDetalleProcesoCoche edpc " +
					"where edpc.idevisceradodetalleprocesocoche = :id or edpc.idcocheprincipal=:id " +
					"and edpc.estadouso = 1 " +
					"and edpc.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " +
					"or edpc.idcocheprincipal=:id"); 
	     q1.setParameter("id", idEviscerado);
	     
	
	try {
		edpc = q1.getResultList();
		return edpc;
	} catch (Exception e) {
		return null;
	}
				
}

public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheDuplicado(Long codbarra)
{

		System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' "); 
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
/*	sb.append("order by o.idevisceradodetalleprocesocoche desc ");*/ 
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	List items =  em.createQuery(sb.toString()).getResultList();
	
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProcesoCoche) items.get(0);
    }	
				
}


public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarra2(Long codbarra)
{

		System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 "); 
//	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	List items =  em.createQuery(sb.toString()).getResultList();
	
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProcesoCoche) items.get(0);
    }	
				
}

public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCochexProcesoActivo(Long codbarra)
{

		System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 "); 
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	List items =  em.createQuery(sb.toString()).getResultList();
	
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProcesoCoche) items.get(0);
    }	
				
}


/*
public Produccion getEDPCochePorCodBarra(Long codbarra)
{

	StringBuffer sb = new StringBuffer();
	sb.append("Select o.evisceradoDetalleProceso.evisceradoProceso.produccion "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + String.valueOf(codbarra) + "'"); //and  o.estadouso = 1 order by o.idevisceradodetalleprocesocoche desc 
	
	List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);

    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (Produccion) items.get(0);
    }	
				
}
*/

public Produccion getEDPCochePorCodBarra(Long codbarra)
{

	StringBuffer sb = new StringBuffer();
	sb.append("Select o.evisceradoDetalleProceso.evisceradoProceso.produccion "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + String.valueOf(codbarra).trim() + "'"); //and  o.estadouso = 1 order by o.idevisceradodetalleprocesocoche desc 
	
	List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);

    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (Produccion) items.get(0);
    }	
				
}

public Produccion getEDPCochePorCodBarra2(Long codbarra)
{

	StringBuffer sb = new StringBuffer();
	sb.append("Select o.evisceradoDetalleProceso.evisceradoProceso.produccion "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.idevisceradodetalleprocesocoche = '" + String.valueOf(codbarra).trim() + "'"); //and  o.estadouso = 1 order by o.idevisceradodetalleprocesocoche desc 
	
	List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);

    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (Produccion) items.get(0);
    }	
				
}


/*
public Produccion getEDPCochePorCodBarra(Long codbarra)
{
	List items= null; 
	
	try {
		StringBuffer sb = new StringBuffer();
		sb.append("Select o.evisceradoDetalleProceso.evisceradoProceso.produccion "); 
		sb.append("From EvisceradoDetalleProcesoCoche o "); 
		sb.append("Where o.codbarra = '" + String.valueOf(codbarra) + "' " +
				" and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); //and  o.estadouso = 1 order by o.idevisceradodetalleprocesocoche desc 
		
		items =  em.createQuery(sb.toString()).getResultList().subList(0,1);
	
	} catch (Exception e) {
		// TODO: handle exception
	}
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (Produccion) items.get(0);
    }			
}
*/

@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProceso> ListarEvisceradoDPCoche()
{
//	, Long idprod, Integer idtur
	List<EvisceradoDetalleProceso> lista = new ArrayList<EvisceradoDetalleProceso>();
	
	Query qry = em.createQuery("select ev from EvisceradoDetalleProceso ev " +
			"where ev.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
			"and ev.evisceradoProceso.procesoAperturaCierre.estado = 1 ");
			
//	qry.setParameter("idcoc", idcoche);  ev.codbarra = :idcoc 
	lista =  qry.getResultList();

	return lista;
}



@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProcesoCoche> ListaCochesTaradosContingencia()
{
//	, Long idprod, Integer idtur
	List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
	
	Query qry = em.createQuery("select ev from EvisceradoDetalleProcesoCoche ev " +
			"where ev.estadouso = 0 and ev.contingencia = true ");
			
//	qry.setParameter("idcoc", idcoche);  ev.codbarra = :idcoc 
	lista =  qry.getResultList();

	return lista;
}





public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraAndProduccion(Long codbarra, Long idprod){
	
	EvisceradoDetalleProcesoCoche edpc = new EvisceradoDetalleProcesoCoche();
	 
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	Query q1 = em
			.createQuery("Select edpc From EvisceradoDetalleProcesoCoche edpc " +
					"where edpc.codbarra = :codba and edpc.estadouso = 1 " +
					"and edpc.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " +
					"and edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idpro"); 
	     q1.setParameter("codba", codbarra);
	     q1.setParameter("idpro", idprod);
	
	try {
		edpc = (EvisceradoDetalleProcesoCoche) q1.getSingleResult();
		return edpc;
	} catch (Exception e) {
		return null;
	}
}


public EvisceradoDetalleProcesoCoche getCocheByCodBarraProduccionTurno(Long codbarra, Long idprod, Integer idturno){
	
	EvisceradoDetalleProcesoCoche edpc = new EvisceradoDetalleProcesoCoche();
	 
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	Query q1 = em
			.createQuery("Select edpc From EvisceradoDetalleProcesoCoche edpc " +
					"where edpc.codbarra = :codba and edpc.estadouso = 1 " +
					"and edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idpro " +
					" and edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idtur "); 
	     q1.setParameter("codba", codbarra);
	     q1.setParameter("idpro", idprod);
	     q1.setParameter("idtur", idturno);
	
	try {
		edpc = (EvisceradoDetalleProcesoCoche) q1.getSingleResult();
		return edpc;
	} catch (Exception e) {
		return null;
	}
}



public EvisceradoDetalleProcesoCoche getCocheByCodBarraProduccion(Long codbarra, Long idprod){
	
	EvisceradoDetalleProcesoCoche edpc = new EvisceradoDetalleProcesoCoche();
	 
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	Query q1 = em
			.createQuery("Select edpc From EvisceradoDetalleProcesoCoche edpc " +
					"where edpc.codbarra = :codba and edpc.estadouso = 1 " +
					"and edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idpro "); 
	     q1.setParameter("codba", codbarra);
	     q1.setParameter("idpro", idprod);
	
	try {
		edpc = (EvisceradoDetalleProcesoCoche) q1.getSingleResult();
		return edpc;
	} catch (Exception e) {
		return null;
	}
}




@SuppressWarnings("unchecked")
public List<CalidadDetalleMuestreoCocina> getEvisceradoDetalleProcesoCocheByMuestra(Long nummuestra) {
	try {
		Query qry= em.createQuery("select cdmC from CalidadDetalleMuestreoCocina cdmC " +
				"where cdmC.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote = :idlotes  order by cdmC.nummuestralote asc ");
//		Query qry= em.createQuery("select cdmC from EvisceradoDetalleProcesoCoche cdmC " +
//				" where cdmC.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.idlote = :idlotes  ");// order by cdmC.nummuestralote asc 

		qry.setParameter("idlotes", nummuestra);
		List <CalidadDetalleMuestreoCocina> evisceradomuestra= qry.getResultList();
		return evisceradomuestra;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
		return null;
	}
	
}

public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByNumMuestra(long ideviscerado)
{

		System.out.println("Paranetro :"+ideviscerado);
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.idevisceradodetalleprocesocoche = '" + ideviscerado + "'  "); 
	
	List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);

    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProcesoCoche) items.get(0);
    }	
				
}

@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProceso> ListarEvisceradoDPCoche(long idProduccion,int idTurno)
{
//	, Long idprod, Integer idtur
	List<EvisceradoDetalleProceso> lista = new ArrayList<EvisceradoDetalleProceso>();
	
	Query qry = em.createQuery("select ev from EvisceradoDetalleProceso ev " +
			"where ev.evisceradoProceso.produccion.idproduccion = :idpro" +
			" and ev.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :turno" +
			" order by ev.produccionDetalleLoteCajon.produccionDetalleLote.idlote ");
			
	qry.setParameter("idpro", idProduccion);
	qry.setParameter("turno", idTurno); 
	lista =  qry.getResultList();

	return lista;
}	

public EvisceradoAuditoriaReimpresion guardarEvisceradoAuditoria(
		EvisceradoAuditoriaReimpresion evisceradoAduditoriaReimpresion) {
	EvisceradoAuditoriaReimpresion eAReimpresion;
	try {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			eAReimpresion=em.merge(evisceradoAduditoriaReimpresion);
			t.commit();
			return eAReimpresion; 
		} finally {
			if (t.isActive())
				t.rollback();
		}
	} finally {
		em.close();
	}
}

@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProcesoCoche> getEvisceradoCochesaActivos() {
	List<EvisceradoDetalleProcesoCoche> edpc = new ArrayList<EvisceradoDetalleProcesoCoche>();
	try {
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				" where edpc.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " +
				" and edpc.estadouso = 1 " +
				" order by edpc.codbarra "); //edpc.estadouso = 1 and 
		edpc = qry.getResultList();
		return edpc;
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
	
}

public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheId(Long id)
{
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.idevisceradodetalleprocesocoche = '" + id.toString().trim() + "'"); 
	
	List items =  em.createQuery(sb.toString()).getResultList();
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProcesoCoche) items.get(0);
    }	
}	


@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProcesoCoche> getTotalCochesEnCocina(Long id){
	System.out.println("DATOOOOOOOOO :"+id.toString());
	Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
			"where edpc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"+ id.toString() +"' and edpc.idcocinaaperturacierredetallerecepcocheconica IS NOT NULL ");
	
	return qry.getResultList();
} 



@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCocheByCodBarraLista(Long codbarra)
{

		System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 "); 
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	List items =  em.createQuery(sb.toString()).getResultList();
	
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
    		return   (List<EvisceradoDetalleProcesoCoche>) items;
		  	
    }	
				
}

@SuppressWarnings({ "rawtypes", "unchecked" })
public List<EvisceradoDetalleProcesoCoche>  getEvisceradoDetalleProcesoCocheByCodBarraListaC(long codbarra)
{

	//System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o ");
	sb.append("Where o.codbarra = '" + String.valueOf(codbarra).trim() + "' and  o.estadouso = 1 "); 
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("and  o.idevisceradodetalleprocesocoche not in(select ldpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from LimpiezaDetalleProcesoCoche ldpc where ldpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche=o.idevisceradodetalleprocesocoche) ");
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
	List items = em.createQuery(sb.toString()).getResultList();
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
    		return   items;
		 }	
				
}


public List<EvisceradoDetalleProcesoCoche>  getEvisceradoDetalleProcesoCocheByCodBarraListaPresentes(long codbarra)
{

	//System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o ");
	sb.append("Where o.codbarra = '" + String.valueOf(codbarra).trim() + "' and  o.estadouso = 1 "); 
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("and  o.idevisceradodetalleprocesocoche  in(select ldpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from LimpiezaDetalleProcesoCoche ldpc where ldpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche=o.idevisceradodetalleprocesocoche) ");
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
	List items = em.createQuery(sb.toString()).getResultList();
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
    		return   items;
		 }	
				
}


public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraListaSimple(Long codbarra)
{

	
	StringBuilder sb = new StringBuilder();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o ");
	sb.append("Where o.codbarra = '" + String.valueOf(codbarra).trim() + "' and  o.estadouso = 1 "); 
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("and  o.idevisceradodetalleprocesocoche not in(select ldpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from LimpiezaDetalleProcesoCoche ldpc where ldpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche=o.idevisceradodetalleprocesocoche) ");
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
	List items = em.createQuery(sb.toString()).getResultList();
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	
	
    if (items == null || items.isEmpty()) {
        return null;
    } 
    else {
    	
    	return  (EvisceradoDetalleProcesoCoche) items.get(0);
    	}    	
		  	
    }	
				

public int getEvisceradoDetalleProcesoCocheByCodBarraListaContador(long codbarra)
{

	StringBuilder sb = new StringBuilder();
	sb.append("select edpc "); 
	sb.append("from eviscerado_detalle_proceso_coche edpc "); 
	sb.append(" left join limpieza_detalle_proceso_coche ldpc on edpc.idevisceradodetalleprocesocoche=ldpc.evisceradodetalleprocesocoche "); 
	sb.append("inner JOIN eviscerado_detalle_proceso edp on edp.idevisceradodetalleproceso=edpc.idevisceradodetalleproceso  "); 
	sb.append("inner join eviscerado_proceso ep on ep.idevisceradoproceso=edp.idevisceradoproceso "); 
	sb.append("INNER JOIN proceso_apertura_cierre pac on pac.idprocesoaperturacierre=ep.idprocesoaperturacierre "); 
	sb.append(String.format(" where edpc.codbarra=%s and pac.estado=1 ", codbarra));
	sb.append(" and edpc.idevisceradodetalleprocesocoche not in(select ldpc1.evisceradodetalleprocesocoche from limpieza_detalle_proceso_coche ldpc1 where ldpc1.evisceradodetalleprocesocoche=edpc.idevisceradodetalleprocesocoche) order by edpc.idevisceradodetalleprocesocoche desc "); 
	List items = em.createNativeQuery(sb.toString()).getResultList();
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	
	
    if (items == null || items.isEmpty()) {
        return 0;
    } else {
    		return   items.size();
		  	
    }	
				
}


public int getEvisceradoDetalleProcesoCocheByCodBarraListaContadorPresentes(long codbarra)
{

	StringBuilder sb = new StringBuilder();
	sb.append("select edpc "); 
	sb.append("from eviscerado_detalle_proceso_coche edpc "); 
	sb.append(" left join limpieza_detalle_proceso_coche ldpc on edpc.idevisceradodetalleprocesocoche=ldpc.evisceradodetalleprocesocoche "); 
	sb.append("inner JOIN eviscerado_detalle_proceso edp on edp.idevisceradodetalleproceso=edpc.idevisceradodetalleproceso  "); 
	sb.append("inner join eviscerado_proceso ep on ep.idevisceradoproceso=edp.idevisceradoproceso "); 
	sb.append("INNER JOIN proceso_apertura_cierre pac on pac.idprocesoaperturacierre=ep.idprocesoaperturacierre "); 
	sb.append(String.format(" where edpc.codbarra=%s and pac.estado=1 ", codbarra));
	sb.append(" and edpc.idevisceradodetalleprocesocoche in(select ldpc1.evisceradodetalleprocesocoche from limpieza_detalle_proceso_coche ldpc1 where ldpc1.evisceradodetalleprocesocoche=edpc.idevisceradodetalleprocesocoche) order by edpc.idevisceradodetalleprocesocoche desc "); 
	List items = em.createNativeQuery(sb.toString()).getResultList();
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	
	
    if (items == null || items.isEmpty()) {
        return 0;
    } else {
    		return   items.size();
		  	
    }	
				
}


public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarra3(Long codbarra)
{

		System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 "); 
//	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	List items =  em.createQuery(sb.toString()).getResultList();
	
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
    	
	    
	        return  (EvisceradoDetalleProcesoCoche) items.get(0);
	    	
    }	
				
}

public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraProcesosActivo(Long codbarra)
{

		System.out.println("Paranetro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 "); 
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
/*	hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
	List items =  em.createQuery(sb.toString()).getResultList();
	
	
    if (items == null || items.isEmpty()) {
        return null;
    } else {
    	
	    	
	        return  (EvisceradoDetalleProcesoCoche) items.get(0);
	    		    	
    }	
				
}


public int getEvisceradoDetalleProcesoCocheByCodBarraVerifica(Long codbarra)
{

             System.out.println("Paranetro :"+codbarra.toString());
       StringBuffer sb = new StringBuffer();
       sb.append("Select o "); 
       sb.append("From EvisceradoDetalleProcesoCoche o "); 
       sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 "); 
       sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
       sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
       
/*     hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
       List items =  em.createQuery(sb.toString()).getResultList();
       
       
    if (items == null || items.isEmpty()) {
        return 0;
    } else {
       
              if(items.size()==1)
              {
               return  1;
              }
              else
              {
                    return   2;
                          
                    
              }
    }  
                           
}



//NUEVO 02-02-2017
public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarraDisponible(Long codbarra)
{
	System.out.println("Parametro :"+codbarra.toString());
	StringBuffer sb = new StringBuffer();
	sb.append("Select o "); 
	sb.append("From EvisceradoDetalleProcesoCoche o "); 
	sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' "); 
	sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 "); 
	sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
	
	List items =  em.createQuery(sb.toString()).getResultList();
	
	
    if (items == null || items.isEmpty()) 
    {
    return null;
    } 
    else 
    {
    	return  (EvisceradoDetalleProcesoCoche) items.get(0);
    }	
}


//public EvisceradoDetalleProcesoCoche obtenerNumCocheMaximo() 
//{
//	try {
//		EvisceradoDetalleProcesoCoche let = new EvisceradoDetalleProcesoCoche();
//
//		//LimpiezaDetalleProcesoLote pac = new LimpiezaDetalleProcesoLote();
//		Query query = em
//				.createQuery("select ldp from EvisceradoDetalleProcesoCoche ldp  "
//						+" where ldp.idevisceradodetalleprocesocoche = " +						
//						" (select max(ldpc.idevisceradodetalleprocesocoche) " +
//						" from EvisceradoDetalleProcesoCoche ldpc)");
//		
//		let = (EvisceradoDetalleProcesoCoche) query.getSingleResult();
//		return let;
//
//	} catch (Exception e) {
//		System.out.println("Error en el proceso --> " + e.getMessage());
//		return null;
//	}
//}    


public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCocheByCodBarra3UltimosProcesos(Long codbarra,Long idevisceradoproceso)
{

            System.out.println("Paranetro :"+codbarra.toString());
      StringBuffer sb = new StringBuffer();
      sb.append("Select o "); 
      sb.append("From EvisceradoDetalleProcesoCoche o "); 
      sb.append("Where o.codbarra = '" + codbarra.toString().trim() + "' and  o.estadouso = 1 "); 
      sb.append("and o.evisceradoDetalleProceso.evisceradoProceso.idevisceradoproceso in("+idevisceradoproceso+","+(idevisceradoproceso-1)+","+(idevisceradoproceso-2)+")"); 
      sb.append("order by o.idevisceradodetalleprocesocoche desc "); 
      System.out.println(sb.toString());
/*    hn List items =  em.createQuery(sb.toString()).getResultList().subList(0,1);*/
      List items =  em.createQuery(sb.toString()).getResultList();
      
      
    if (items == null || items.isEmpty()) {
        return null;
    } else {
        return  (EvisceradoDetalleProcesoCoche) items.get(0);
    } 
                        
}


//Nuevo 02-02-2017
public EvisceradoDetalleProcesoCoche obtenerNumCocheMaximo() 
{ 

	Query query = em
			.createQuery("select ldp from EvisceradoDetalleProcesoCoche ldp  "
					+" where ldp.idevisceradodetalleprocesocoche = " +						
					" (select max(ldpc.idevisceradodetalleprocesocoche) " +
					" from EvisceradoDetalleProcesoCoche ldpc)");
	
	
	//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());
       Object lista;
       try {
             lista = query.getSingleResult();
       } catch (Exception e) {
             // TODO Auto-generated catch block
             return null;
       }
       
       em.refresh(lista);

       if(lista == null)
       {
             return null;
       }
       return (EvisceradoDetalleProcesoCoche) lista;
}	



@SuppressWarnings("unchecked")
public List<EvisceradoDetalleProcesoCoche> getTotalCochesEnBatch(Long id)
{
      System.out.println("Parametro :"+id.toString());
      StringBuffer sb = new StringBuffer();
      sb.append("Select o "); 
      sb.append("From EvisceradoDetalleProcesoCoche o "); 
      sb.append("Where o.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '" + id.toString().trim() + "'"); 
      
      List items =  em.createQuery(sb.toString()).getResultList();
      
    if (items == null || items.isEmpty()) {
        return null;
    } else {
            return   (List<EvisceradoDetalleProcesoCoche>) items;
                  
    } 
                        
}




}
