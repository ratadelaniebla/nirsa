package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.DescongeladoDetalleProcesoFinForzado;

public class DescongeladoDetalleProcesoDAOJpaImpl extends BaseDaoJpaImpl {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DescongeladoDetalleProcesoDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
    public List<Object[]> getDetallesCubasPorEspecieTalla(Long viddescongeladoduchaaperturacierredetalle, Long viddescongeladodetalleproceso, Integer vidtalla)
    {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("select 1 item, array_to_string(array_agg(idlote ), ' - ') idlote, min (horainicio) "); 
    	sb.append("from ( ");
    	sb.append("select DISTINCT (pdl.idlote) idlote, min(ddp.horainicio) horainicio ");    	
    	sb.append("from descongelado_detalle_proceso ddp inner join produccion_detalle_lote_cajon pdlc "); 
    	sb.append("on ddp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon ");
    	sb.append("inner join produccion_detalle_lote pdl ");
    	sb.append("on pdlc.idproducciondetallelote = pdl.idproducciondetallelote ");
    	sb.append("inner join especie_talla et  ");
    	sb.append("on pdl.idespecietalla =  et.idespecietalla ");
    	sb.append(String.format("where ddp.iddescongeladoduchaaperturacierredetalle = %s and ", viddescongeladoduchaaperturacierredetalle)); 
    	sb.append(String.format("ddp.iddescongeladodetalleproceso >= %s and ", viddescongeladodetalleproceso));
    	sb.append("ddp.horainicio is not null and "); 
    	sb.append(String.format("et.idtalla = %s and ", vidtalla));
    	sb.append("ddp.horafin is null ");
    	
    	sb.append("GROUP BY pdl.idlote ");
    	sb.append("ORDER BY pdl.idlote ");
    	sb.append(") t1 ");   	
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
	
	public DescongeladoDetalleProceso getDescongeladoDetalleProcesoByProduccionDetalleLoteCajonId(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From DescongeladoDetalleProceso o "); 
		sb.append("Where o.produccionDetalleLoteCajon.idproducciondetallelotecajon = '" + id+ "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (DescongeladoDetalleProceso) items.get(0);
	    }		
	}	
	
	
	
	
    //NUEVO OKokokokok
    @SuppressWarnings("unchecked")
    public List<DescongeladoDetalleProceso>  getDescongeladoDetalleProcesoListaCajonesporIdproduccionDetalleLote(String id) 
    { 
           return em.createQuery("Select o From DescongeladoDetalleProceso o Where o.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote = '" + id + "'").getResultList();            
    }

    
    
    //NUEVO OKokokokok
    public DescongeladoDetalleProceso getDescongeladoDetalleProcesoId(String id) 
    { 
          
          StringBuffer sb = new StringBuffer();
          sb.append("Select o "); 
          sb.append("From DescongeladoDetalleProceso o "); 
          sb.append("Where o.iddescongeladodetalleproceso = '" + id+ "'");
          
          //logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

          List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (DescongeladoDetalleProceso) items.get(0);
        }        
    }

    
    //AGREGAR OKokokokokoko
    public void remove(Long vid) 
    {

          EntityManagerFactory emf = JPAPersistenceManager.getInstance()
                        .getEntityManagerFactory();
          EntityManager em = emf.createEntityManager();
          
          
          try{
                  EntityTransaction t = em.getTransaction();
                  try {
                               t.begin();
                               DescongeladoDetalleProceso o = (DescongeladoDetalleProceso) em.find(DescongeladoDetalleProceso.class, vid);
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
   
	
	
	public void saveOrUpdate(DescongeladoDetalleProceso descongeladodetalleproceso)
	{
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(descongeladodetalleproceso);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}

	//NUEVO 
	// 0 = Fin descongelado normal
	//1 = Fin forzado
	//3 =Incio nuevamente el proceso de descongelado despues de un fin forzado (ahora esta con ducha)
	//4 = Fin descongelado normal despues de fin forzado	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProceso>  getDescongeladoDetalleProcesoListaCajonesporProduccion(String id) 
	{ 
	 	return em.createQuery("Select o From DescongeladoDetalleProceso o " +
	 			"Where o.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = '" + id + "' and o.finforzado in (0,1,2,3,4 ) " +
	 				  //"or " +
	 				  //"(o.descongeladoDuchaAperturaCierreDetalle1.iddescongeladoduchaaperturacierredetalle = '" + id + "' and o.finforzado in (0, 1,3,4) ) " +
	 				  "order by o.produccionDetalleLoteCajon.produccionDetalleLote.idlote,  o.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon  ").getResultList();		
	}	
	
	//NUEVO 
	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProcesoFinForzado>  getDescongeladoDetalleProcesoListaCajonesFinForzado(String id) 
	{ 
	 	return em.createQuery("Select o From DescongeladoDetalleProcesoFinForzado o " +
	 				// 0 = Fin descongelado normal
	 			"Where " +
					//1 = Fin forzado
					//3 =Incio nuevamente el proceso de descongelado despues de un fin forzado (ahora esta con ducha)
					//4 = Fin descongelado normal despues de fin forzado	
	 				  "o.descongeladoDetalleProceso.iddescongeladodetalleproceso = '" + id + "' " +
	 				  "order by o.horainicio ").getResultList();		
	}
	
	
	
	
	//NUEVO 
	@SuppressWarnings("unchecked")
	public List<Object[]>  getDescongeladoDetalleProcesoListaDuchasEspecieTalla(String id)
	{

	 	return em.createQuery("Select MAX(o.iddescongeladodetalleproceso) iddescongeladodetalleproceso, " +
	 			" o.descongeladoDuchaAperturaCierreDetalle1.descongeladoDucha.idducha, " +
	 			" o.produccionDetalleLoteCajon.produccionDetalleLote.especieTalla.talla.nombre " +
	 			" From DescongeladoDetalleProceso o " +
	 			"Where o.iddescongeladodetalleproceso >= '" + id + "' and " +
	 					"o.descongeladoDuchaAperturaCierreDetalle1 is not null and " +
	 					"o.horainicio is not null and " +
	 					"o.horafin is null " +
	 					"GROUP BY o.descongeladoDuchaAperturaCierreDetalle1.descongeladoDucha.idducha, " +
	 					"o.produccionDetalleLoteCajon.produccionDetalleLote.especieTalla.talla.idtalla ").getResultList();
	 	
	 	/*
			select * from descongelado_detalle_proceso ddp
			where ddp.iddescongeladodetalleproceso >= 209529 and 
						ddp.iddescongeladoduchaaperturacierredetalle is not null and 
						ddp.horainicio is not null and 
						ddp.horafin is null 		
			order by ddp.iddescongeladodetalleproceso desc 
	 	 */
	}	
	

	//01-07-2016
	public DescongeladoDetalleProceso getDescongeladoDetalleProcesoByProduccionDetalleLoteCajonIdRegresh(String id) 
	{ 
		Query qry = em.createQuery("Select o " +
				"From DescongeladoDetalleProceso o " +
				"Where o.produccionDetalleLoteCajon.idproducciondetallelotecajon = '" + id+ "'").setFirstResult(0);;
		
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
	       return (DescongeladoDetalleProceso) lista;
	}

	
	
	

	//04-07-2016
	public DescongeladoDetalleProceso getDescongeladoDetalleProcesoByCamaraCajonIdLote(String vididcamaracajon)
	{
	       Query qry = em.createQuery("Select o From DescongeladoDetalleProceso o " +
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
	       return (DescongeladoDetalleProceso) lista;
	}	

	//NUEVO 06-07-2016 PENDIENTE -AGREGAR
	public DescongeladoDetalleProceso getDescongeladoDetalleProcesoByCamaraCajonIdRegresh(String id) 
	{ 
		Query qry = em.createQuery("Select o " +
				"From DescongeladoDetalleProceso o " +
				"Where o.produccionDetalleLoteCajon.camaraCajon.idcamaracajon = '" + id+ "'").setFirstResult(0);
		
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
	       return (DescongeladoDetalleProceso) lista;
	}

	
	public DescongeladoDetalleProceso getDescongeladoDetalleProcesoById(String id) 
	{ 
		Query qry = em.createQuery("Select o " +
				"From DescongeladoDetalleProceso o " +
				"Where o.iddescongeladodetalleproceso = '" + id+ "'").setFirstResult(0);
		
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
	       return (DescongeladoDetalleProceso) lista;
	}	
	
	
	//metodos creados por el proveedor 
	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProceso> getCajonesVolteadosByIdRackeoProceso(
			double idrackeoproceso) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT ddp ");
			sbuilder.append("FROM RackeoProceso rp, DescongeladoDetalleProceso ddp ");
			sbuilder.append("WHERE ddp.rackeoProceso.idrackeoproceso = rp.idrackeoproceso ");
			sbuilder.append("AND rp.idrackeoproceso = :idrackeoproceso ");
			sbuilder.append("ORDER BY ddp.horafin DESC ");
			return (List<DescongeladoDetalleProceso>) em
					.createQuery(sbuilder.toString())
					.setParameter("idrackeoproceso", idrackeoproceso)
					.getResultList();
		} catch (Exception e) {
			em.close();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProceso> getCajonesVolteadosLimit(
			int cajonesvolteados) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT ddp ");
			sbuilder.append("FROM DescongeladoDetalleProceso ddp, ProduccionDetalleLoteCajon pdlc, CamaraCajon cc ");
			sbuilder.append("WHERE cc.estado = 4 ");
			sbuilder.append("AND ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon ");
			sbuilder.append("AND pdlc.camaraCajon.idcamaracajon = cc.idcamaracajon ");
			sbuilder.append("ORDER BY ddp.iddescongeladodetalleproceso DESC "); // ddp.produccionDetalleLote horafin    pdlc.produccionDetalleLote.idlote
			return (List<DescongeladoDetalleProceso>) em
					.createQuery(sbuilder.toString())
					.setMaxResults(cajonesvolteados).getResultList(); //.setMaxResults(cajonesvolteados).getResultList();
			
		} catch (Exception e) {
			em.close();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProceso> getCajonesVolteadosByProduccion(
			long idproduccion) {
		List<DescongeladoDetalleProceso> lista = new ArrayList<>();
		
		String sql = "  SELECT ddp "+
						"FROM DescongeladoDetalleProceso ddp, ProduccionDetalleLoteCajon pdlc, CamaraCajon cc "+
						"WHERE cc.estado = 4 "+
						"AND ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon "+
						"AND pdlc.camaraCajon.idcamaracajon = cc.idcamaracajon " +
						"  AND pdlc.produccionDetalleLote.produccion.idproduccion =:idpro  "+
						"ORDER BY pdlc.produccionDetalleLote.idlote DESC ";
		
		    Query q1 = em.createQuery(sql);
		    q1.setParameter("idpro", idproduccion);
		    lista = q1.getResultList();
		
		 
		 return lista;
		 
	}
	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProceso> getCajonesVolteadosLimitUltimo() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT ddp ");
			sbuilder.append("FROM DescongeladoDetalleProceso ddp, ProduccionDetalleLoteCajon pdlc, CamaraCajon cc ");
			sbuilder.append("WHERE cc.estado = 4 ");
			sbuilder.append("AND ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon ");
			sbuilder.append("AND pdlc.camaraCajon.idcamaracajon = cc.idcamaracajon ");
			sbuilder.append("ORDER BY ddp.iddescongeladodetalleproceso DESC "); // horafin
			return (List<DescongeladoDetalleProceso>) em
					.createQuery(sbuilder.toString())
					.setMaxResults(1).getResultList();
		} catch (Exception e) {
			em.close();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public DescongeladoDetalleProceso findFirstByOrderByIdDescXXX() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT ddp ");
			sbuilder.append("FROM DescongeladoDetalleProceso ddp ");
			sbuilder.append("ORDER BY ddp.iddescongeladodetalleproceso DESC ");
			return ((List<DescongeladoDetalleProceso>) em
					.createQuery(sbuilder.toString()).setMaxResults(1)
					.getResultList()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public DescongeladoDetalleProceso getUltimoCajonVolteado() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT ddp ");
			sbuilder.append("FROM DescongeladoDetalleProceso ddp, ProduccionDetalleLoteCajon pdlc, CamaraCajon cc ");
			sbuilder.append("WHERE cc.estado = 4 ");
			sbuilder.append("AND ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon ");
			sbuilder.append("AND pdlc.camaraCajon.idcamaracajon = cc.idcamaracajon ");
			sbuilder.append("ORDER BY ddp.iddescongeladodetalleproceso DESC "); 
			return ((List<DescongeladoDetalleProceso>) em
					.createQuery(sbuilder.toString()).setMaxResults(1)
					.getResultList()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}

	public DescongeladoDetalleProceso findByIdRackeoProcesoAndIdDetalleParada(
			Long idrackeoproceso, Long idOeeDetalleParada) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT ddp ");
			sbuilder.append("FROM DescongeladoDetalleProceso ddp, OeeDetalleParadaRackeo odpr ");
			sbuilder.append("WHERE ddp.rackeoProceso.idrackeoproceso = :idrackeoproceso ");
			sbuilder.append("AND ddp.iddescongeladodetalleproceso = odpr.descongeladoDetalleProceso.iddescongeladodetalleproceso ");
			sbuilder.append("AND odpr.oeeDetalleParada.idOeeDetalleParada = :idOeeDetalleParada ");
			return (DescongeladoDetalleProceso) em
					.createQuery(sbuilder.toString())//
					.setParameter("idrackeoproceso", idrackeoproceso)//
					.setParameter("idOeeDetalleParada", idOeeDetalleParada)//
					.getSingleResult();
		} catch (Exception e) {
			em.close();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
