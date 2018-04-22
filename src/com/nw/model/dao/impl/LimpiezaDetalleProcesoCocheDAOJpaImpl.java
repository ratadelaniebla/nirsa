package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.LimpiezaDetalleProcesoCoche;
import com.nw.model.LimpiezaProceso;
//import com.nw.model.ProduccionDetalleLoteCajon;
import com.nw.model.dao.LimpiezaDetalleProcesoCocheDAO;
import com.nw.util.Sistema;


public class LimpiezaDetalleProcesoCocheDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaDetalleProcesoCocheDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Object[]> lista;
	private Integer idtalla;
	
	public LimpiezaDetalleProcesoCocheDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	/**
	 * Ejecuta la siguiente consulta
	 * 
	 * select produccion.idproduccion, eviscerado_detalle_proceso_coche.idcoche, eviscerado_detalle_proceso_coche.idcocheglobal, produccion_detalle_lote.idlote, cocina.descripcion, eviscerado_detalle_proceso_coche.canastillas, eviscerado_pescados_lata.especificacion from limpieza_detalle_proceso_coche
inner join eviscerado_detalle_proceso_coche on limpieza_detalle_proceso_coche.evisceradodetalleprocesocoche = eviscerado_detalle_proceso_coche.idevisceradodetalleprocesocoche
inner join limpieza_detalle_proceso_lote on limpieza_detalle_proceso_coche.idlimpiezadetalleprocesolote = limpieza_detalle_proceso_lote.idlimpiezadetalleprocesolote
inner join produccion_detalle_lote on produccion_detalle_lote.idproducciondetallelote = limpieza_detalle_proceso_lote.idproducciondetallelote
inner join produccion on produccion.idproduccion = produccion_detalle_lote.idproduccion
inner join eviscerado_pescados_lata on eviscerado_pescados_lata.idevisceradopescadoslata = eviscerado_detalle_proceso_coche.idevisceradopescadoslata
inner join cocina on cocina.idcocina = eviscerado_detalle_proceso_coche.idcocina
where eviscerado_detalle_proceso_coche.idcoche = 45 and produccion.estado = 2 and limpieza_detalle_proceso_coche.tara != 0

	 * @return
	 * LimpiezaDetalleProcesoCoche
	 */
	public LimpiezaDetalleProcesoCoche ObtenerLimpiezaDetalleProcesoCoche(Integer idcoche)
	{
		EntityManagerFactory emf;
		  EntityManager em;
		  emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			em = emf.createEntityManager();
		  
			LimpiezaDetalleProcesoCoche lddc = new LimpiezaDetalleProcesoCoche();
			
			List<LimpiezaDetalleProcesoCoche> listaResul = new ArrayList<LimpiezaDetalleProcesoCoche>();
			
			Query qry = em.createQuery("select ldpc from LimpiezaDetalleProcesoCoche ldpc " +
					"inner join ldpc.evisceradoDetalleProcesoCoche edpc " +
					"inner join ldpc.limpiezaDetalleProcesoLote ldpl " +
					"inner join ldpl.produccionDetalleLote pdl " +
					"inner join pdl.produccion p " +
					"inner join edpc.evisceradoPescadosLata epl " +
					"inner join edpc.cocina c " +
					"where edpc.idcoche = :idcoc " );
			
			qry.setParameter("idcoc", idcoche);
			 
			 
			//lddc =  (LimpiezaDetalleProcesoCoche) qry.getSingleResult();
			listaResul  =  (List<LimpiezaDetalleProcesoCoche>) qry.getResultList();
			
			if (listaResul.size()==0) {
				return null;
			}else {
				return listaResul.get(0);
			}
			
	}
	
	//ag 25-09-2014
	public LimpiezaDetalleProcesoCoche getLimpiezaDetalleProcesoCoche(Long id) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select o from LimpiezaDetalleProcesoCoche o ");
		sb.append("where o.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = '" + String.valueOf(id) + "' ");		
		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaDetalleProcesoCoche) items.get(0);
        }	
	}
	
	//ag 25-09-2014
	public LimpiezaDetalleProcesoCoche getLimpiezaDetalleProcesoCocheAsignarById(Long id) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select o from LimpiezaDetalleProcesoCoche o ");
		sb.append("where o.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = '" + String.valueOf(id) + "' ");
		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaDetalleProcesoCoche) items.get(0);
        }	
	}
	
	public int getNumCochesxBatch(Long idBatch)
	{
		int rec = 0;
		
		Query query = em.createQuery("select count(cdmc.idevisceradodetalleprocesocoche) from EvisceradoDetalleProcesoCoche cdmc " +
				"where cdmc.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :idProceso ");
		query.setParameter("idProceso", idBatch);
		String c = query.getSingleResult().toString();
		rec = Integer.valueOf(c);

		return rec;
	}

	public int getNumCochesLimpxBatch(Long idBatch)
	{
		int rec = 0;
		
		Query query = em.createQuery("select count(cdmc.idlimpiezadetalleprocesocoche) from LimpiezaDetalleProcesoCoche cdmc " +
				"where cdmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :idProceso ");
		query.setParameter("idProceso", idBatch);
		String c = query.getSingleResult().toString();
		rec = Integer.valueOf(c);

		return rec;
	}
	
	public int getNumCochesLimpxBatchxLinea(Long idBatch, Integer idLinea)
	{
		int rec = 0;
		
		Query query = em.createQuery("select count(cdmc.idlimpiezadetalleprocesocoche) from LimpiezaDetalleProcesoCoche cdmc " +
				"where cdmc.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :idProceso " +
				" and cdmc.limpiezaLinea.idlimpiezalinea = :idLin ");
		query.setParameter("idProceso", idBatch);
		query.setParameter("idLin", idLinea);
		String c = query.getSingleResult().toString();
		rec = Integer.valueOf(c);

		return rec;
	}
	
	
	public LimpiezaDetalleProcesoCoche getLimpiezaCocheBatchLinea(Long batch, Integer linea) { 
		StringBuffer sb = new StringBuffer();
		sb.append("Select o from LimpiezaDetalleProcesoCoche o ");
		sb.append("where o.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '" + String.valueOf(batch) + "' " +
				" and o.limpiezaLinea.idlimpiezalinea = '" + String.valueOf(linea) + "' " +
						" order by o.fechareg limit 1");
		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaDetalleProcesoCoche) items.get(0);
        }	
	}
	
//    public List<LimpiezaDetalleProcesoCoche> getListaLimpiezaCocheBatchLinea(Long batch) {  //,Cocina cocina
//        EntityManagerFactory emf = JPAPersistenceManager.getInstance()
//                .getEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            Query query = em
//                    .createQuery("Select o from LimpiezaDetalleProcesoCoche o " +
//                            " where o.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :lp and " +
//                            " o.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in " +
//                            "(select cdb.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from ControlDetalleBatchLimpieza cdb )" +
//                            " order by o.fechareg ");  
//            query.setParameter("lp", batch);
//            return query.getResultList();
//
//        } catch (Exception e) {
//            System.out.println("paso esto: "
//                    + e.getMessage());
//            return null;
//        }
//        
//    }
	
		//Actualizado 21-09-2017
	   //Actualizado 10-11-2016
		public List<LimpiezaDetalleProcesoCoche> getListaLimpiezaCocheBatchLinea(Long batch) {  //,Cocina cocina
	        EntityManagerFactory emf = JPAPersistenceManager.getInstance()
	                .getEntityManagerFactory();
	        EntityManager em = emf.createEntityManager();

	        try {
	            Query query = em
	/*                    .createQuery("Select o from LimpiezaDetalleProcesoCoche o " +
	                            " where o.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = :lp and " +
	                            " o.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in " +
	                            "(select cdb.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from ControlDetalleBatchLimpieza cdb )" +
	                            " order by o.fechareg ");*/  
			            .createQuery("Select o from LimpiezaDetalleProcesoCoche o " +
			                    " where o.evisceradoDetalleProcesoCoche.cocinaAperturaCierreDetalle." +
			                    "idcocinaaperturacierredetalle = :lp order by o.fechareg ");  
	            query.setParameter("lp", batch);
	            return query.getResultList();

	        } catch (Exception e) {
	            System.out.println("paso esto: "
	                    + e.getMessage());
	            return null;
	        }
	        
	    }
	
	
	@Override
	public void saveOrUpdate(
			LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(limpiezaDetalleProcesoCoche);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		
	}

	
	//SVN NUEVO 20-09-2017
    @SuppressWarnings("unchecked")
	public List<Object[]> getTallaAjustada(Long pidproducciondetallelote, int pidlinea)
    {
    	StringBuilder sb = new StringBuilder();

    	try {
			sb.append(String.format("select 1,  limpieza_ajustar_talla(%s, %s) " ,pidproducciondetallelote, pidlinea));
			
			Query query = em.createNativeQuery(sb.toString());
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}
    }
	
	
	public void ReajustarTallasLotesPorLinea(Long pidproducciondetallelote, Integer pidlinea, LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche) 
	{
		
    	String mensaje = "";
    	try
    	{
			lista = getTallaAjustada(pidproducciondetallelote, pidlinea);    	
			for (Object[] l : lista) 
			{
				idtalla = (Integer) l[1];
				mensaje =("Talla Reajustada :"+idtalla);
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			idtalla = limpiezaDetalleProcesoCoche.getLimpiezaDetalleProcesoLote().getProduccionDetalleLote().getEspecieTalla().getTalla().getIdtalla();
			mensaje = ("Dejando la talla por defecto 1 "+ idtalla);
			//e.printStackTrace();
		}
			
    	if (idtalla == null)
    	{
    		
    		idtalla = limpiezaDetalleProcesoCoche.getEvisceradoDetalleProcesoCoche().getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getEspecieTalla().getTalla().getIdtalla();
    		mensaje  = ("Dejando la talla por defecto 2 " + idtalla);
    	}
    	
		System.out.println("idtalla :"+idtalla);
		System.out.println("pidproducciondetallelote :"+pidproducciondetallelote);
    	Sistema.mensaje("Salida :"+mensaje);		
		
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();

			Query qry = em
					.createNativeQuery(" update limpieza_detalle_proceso_coche " +
							" set idtalla_ajustada = "+idtalla.toString() +
							" where idlimpiezadetalleprocesocoche in ( " +
							" select ldpc.idlimpiezadetalleprocesocoche " +
							" from limpieza_detalle_proceso_coche ldpc " +
							" inner join limpieza_detalle_proceso_lote ldpl " +
							" on ldpc.idlimpiezadetalleprocesolote = ldpl.idlimpiezadetalleprocesolote " +
							" inner join produccion_detalle_lote pdl " +
							" on ldpl.idproducciondetallelote = pdl.idproducciondetallelote " +
							" where ldpl.idproducciondetallelote = "+pidproducciondetallelote.toString()+" and ldpc.idlinea = "+pidlinea.toString()+")");
			qry.executeUpdate();

			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive())
				t.rollback();
		} finally {
			em.close();
		}
	}	

	
	//AGREGAR CARLOS 26-09-2017
	public void ReajustarTallasPorProceso(Long pidlimpiezaproceso) 
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();

			Query qry = em
			.createNativeQuery(" update limpieza_detalle_proceso_coche ldpc1 " +
			" set idtalla_ajustada = limpieza_ajustar_talla((select idproducciondetallelote from limpieza_detalle_proceso_lote ldpl " + 
			" where idlimpiezadetalleprocesolote = ldpc1.idlimpiezadetalleprocesolote), ldpc1.idlinea) " +
			" where ldpc1.idlimpiezadetalleprocesocoche in (select ldpc.idlimpiezadetalleprocesocoche  " +
			" from limpieza_detalle_proceso_coche ldpc  " +
			" inner join limpieza_detalle_proceso_lote ldpl " +
			" on ldpc.idlimpiezadetalleprocesolote = ldpl.idlimpiezadetalleprocesolote " + 
			" inner join limpieza_proceso lp  " +
			" on ldpl.idlimpiezaproceso = lp.idlimpiezaproceso " +
			" where ldpl.idlimpiezaproceso = "+pidlimpiezaproceso.toString()+")");
			
			qry.executeUpdate();

			t.commit();
		} catch (RuntimeException e) {
			if (t.isActive())
				t.rollback();
		} finally {
			em.close();
		}
	}	
	
	
	
	
	

	//SVN REEMPLAZAR 20-09-2017
    //public void grabar(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche, Long pidproducciondetallelote, Integer pidlote)
	public void grabar(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche)
    {
		
    	
    	
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(limpiezaDetalleProcesoCoche);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
    }	



    public List<LimpiezaDetalleProcesoCoche> obtenerMaxLimpiezaDPC(LimpiezaProceso lp) 
    {  
    	

    	
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
//		LimpiezaDetalleProcesoCoche lpdc = new LimpiezaDetalleProcesoCoche();

		try {
			Query query = em
					.createQuery("select cacd from LimpiezaDetalleProcesoCoche cacd " +
							" where cacd.limpiezaDetalleProcesoLote.limpiezaProceso = :lp " +
							" order by cacd.idlimpiezadetalleprocesocoche desc" +
							" ").setMaxResults(20);// 
//							"(select max(c.idlimpiezadetalleprocesocoche) from LimpiezaDetalleProcesoCoche c )"); //c.cocina=:cocina and 
			query.setParameter("lp", lp);
//			query.setParameter("prod", idPro);
//			lpdc = (LimpiezaDetalleProcesoCoche) query.getSingleResult();
			return query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
			return null;
		}
		
	}    

    public List<LimpiezaDetalleProcesoCoche> obtenerAllLimpiezaDPC(LimpiezaProceso lp) {  //,Cocina cocina
        EntityManagerFactory emf = JPAPersistenceManager.getInstance()
                .getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em
                    .createQuery("select cacd from LimpiezaDetalleProcesoCoche cacd " +
                            " where cacd.limpiezaDetalleProcesoLote.limpiezaProceso = :lp " +
                            " order by cacd.idlimpiezadetalleprocesocoche desc");  
            query.setParameter("lp", lp);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("paso esto realizando la consulta-->"
                    + e.getMessage());
            return null;
        }
        
    }


    
    //Nuevo 12-03-2017 agregar
	public void remove(Long vid) 
	{
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					LimpiezaDetalleProcesoCoche o = (LimpiezaDetalleProcesoCoche) em.find(LimpiezaDetalleProcesoCoche.class, vid);
					if (o != null)
					{
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
	
    public LimpiezaDetalleProcesoCoche saveOrUpdateRecuperar(
            LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche) {

      EntityManagerFactory emf = JPAPersistenceManager.getInstance()
                  .getEntityManagerFactory();
      EntityManager em = emf.createEntityManager();
      
      LimpiezaDetalleProcesoCoche ldpc = new LimpiezaDetalleProcesoCoche();
      
      try {
            EntityTransaction t = em.getTransaction();
            try {
                  t.begin();
                  ldpc = em.merge(limpiezaDetalleProcesoCoche);
                  t.commit();
            } finally {
                  if (t.isActive())
                        t.rollback();
            }
      } finally {
            em.close();
      }
      
      return ldpc;
}

    
    
}
