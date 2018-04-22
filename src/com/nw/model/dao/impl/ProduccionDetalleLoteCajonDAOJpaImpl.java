package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.ProduccionDetalleLoteCajon;
import com.nw.model.dao.ProduccionDetalleLoteCajonDAO;

public class ProduccionDetalleLoteCajonDAOJpaImpl extends BaseDaoJpaImpl implements ProduccionDetalleLoteCajonDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProduccionDetalleLoteCajonDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	//select DISTINCT(c.name) c from Customer c

//	@SuppressWarnings("unchecked")
//	public List<ProduccionDetalleLoteCajon> getidLoteProduccionDetallelote(Long id) {
//		List <ProduccionDetalleLoteCajon> produccionDetalleLoteCajon= em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc " +
//				"inner join pdlc.produccionDetalleLote pdl " +
//				"inner join pdl.produccion p " +
//				"where p.estado = 1 and p.idproduccion = '"+id.toString() +"' "+
//				"order by pdl.idlote ")
//				.getResultList();
//		return produccionDetalleLoteCajon;
//		
//	}
	
	
	
	
	
//	@SuppressWarnings("unchecked")
//	public ProduccionDetalleLoteCajon getidLoteProduccionDetallelotePrimero(Long id) {
//		ProduccionDetalleLoteCajon produccionDetalleLoteCajon= em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc " +
//				"where pdlc.produccionDetalleLote.idproducciondetallelote = '"+id.toString() +"'")
//				.setFirstResult(1);
//		return produccionDetalleLoteCajon;
//		
//	}	


	//MUESTRA SOLO CAJONES CON FIN DE PROCESO INICIADO FORZADO (3)
	//TIENE SOLO HORA INICIO DE DUCHA
	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProceso> obtenerCajonesporPDLPorDuchaProcesoConProcesoFozado(Long id) {
		//Sistema.mensaje(id.toString());
		List <DescongeladoDetalleProceso> descongeladodetalleproceso; 
		Query qry = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
				" where ddp.descongeladoDuchaAperturaCierreDetalle2.iddescongeladoduchaaperturacierredetalle = :id and ddp.finforzado in (3)  order by ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon ");
		qry.setParameter("id", id);
		descongeladodetalleproceso = qry.getResultList();
		return descongeladodetalleproceso;
		
	}	
	
	
	
	
	//MUESTRA TODOS LOS CAJONES CORRESPONDIENTES A LA DUCHADA
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLoteCajon> obtenerCajonesDuchaAperturaCierreDetalleLista(Long id) {
		//Sistema.mensaje(id.toString());
		List <ProduccionDetalleLoteCajon> produccionDetalleLote; 
		Query qry = em.createQuery("select ddp.produccionDetalleLoteCajon from DescongeladoDetalleProceso ddp " +
				" where ddp.descongeladoDuchaAperturaCierreDetalle1.iddescongeladoduchaaperturacierredetalle = :id  and ddp.finforzado in (0) and ddp.horafindescongelado is null  order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.idlote ");
		qry.setParameter("id", id);
		produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;
		
	}
	
	
	
	
	//MUESTRA SOLO CAJONES CON FIN DE PROCESO NORMAL (0)
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLoteCajon> obtenerCajonesporPDLPorIdDuchaAperturaProcesoDatalle1(Long id) 
	{
		//Sistema.mensaje(id.toString());
		List <ProduccionDetalleLoteCajon> produccionDetalleLote; 
		Query qry = em.createQuery("select ddp.produccionDetalleLoteCajon " +
				" from DescongeladoDetalleProceso ddp " +
			  //" where ddp.descongeladoDuchaAperturaCierreDetalle2.iddescongeladoduchaaperturacierredetalle = :id and " +
			  //" ddp.finforzado = 0 and ddp.horafindescongelado is null " +
				" where ddp.descongeladoDuchaAperturaCierreDetalle1.iddescongeladoduchaaperturacierredetalle = :id and " +
				" ddp.finforzado = 0 and ddp.horafindescongelado IS NULL " +
				" order by ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon ");
		qry.setParameter("id", id);
		produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;

	}	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDetalleProceso> obtenerCajonesporPDLPorDuchaProcesoProcesoFozado1(Long id) {
		//Sistema.mensaje(id.toString());
		List <DescongeladoDetalleProceso> descongeladodetalleproceso; 
		Query qry = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
				" where ddp.descongeladoDuchaAperturaCierreDetalle2.iddescongeladoduchaaperturacierredetalle = :id and ddp.finforzado = 3 order by ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon ");
		qry.setParameter("id", id);
		descongeladodetalleproceso = qry.getResultList();
		return descongeladodetalleproceso;
	}
	

	
	
	
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLoteCajon> getidLoteProduccionDetalleloteXproducciondetalleloteRakeado(Long id) {
			//Sistema.mensaje(id.toString());
			List <ProduccionDetalleLoteCajon> produccionDetalleLote; 
			Query qry = em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc " +
					" where pdlc.produccionDetalleLote.idproducciondetallelote = :id " +
					" and pdlc.camaraCajon.estado = 4 " +
					" order by pdlc.idproducciondetallelotecajon ");
			qry.setParameter("id", id);
			produccionDetalleLote= qry.getResultList();
			return produccionDetalleLote;
			
		}	
	
	
	
	@Override
	public ProduccionDetalleLoteCajon getidLoteProduccionDetallelotePrimero1(Long id) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select pdlc from ProduccionDetalleLoteCajon pdlc  "); 
		sb.append("where pdlc.produccionDetalleLote.idproducciondetallelote = '"+id.toString() +"'"); 

		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (ProduccionDetalleLoteCajon) items.get(0);
        }	
	}	
	
	
//	@SuppressWarnings("unchecked")
//	public List<ProduccionDetalleLote> getidLoteProduccionDetallelote1(Long id) {
//		
//		Sistema.mensaje(evisceradoProceso.getProduccion().getIdproduccion().toString());
//		//Sistema.mensaje(id.toString());
//		List <ProduccionDetalleLote> produccionDetalleLote= em.createQuery("select pdl from ProduccionDetalleLote pdl ")
//				//+
//				//"where pdl.produccion.idproduccion = '"+id.toString() +"' order by pdl.idlote ")
//				.getResultList();
//		return produccionDetalleLote;
//		
//	}
	
//	public List<Area> getAreasDesperdicios() {
//		return em.createQuery("select a from Area a where a.desperdicio = 1 order by a.nombre").getResultList();
//	}

	public List<ProduccionDetalleLote> getidLoteProduccionDetallelote(Long id, Integer vturno) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select pdl from ProduccionDetalleLote pdl "); 
		sb.append("where pdl.produccion.idproduccion = '"+id.toString() +"' and pdl.turno.idturno = '"+vturno.toString() +"'  order by pdl.idlote "); 
		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		return  em.createQuery(sb.toString()).getResultList();

	}	

public List<ProduccionDetalleLote> getidLoteProduccionDetalleloteEviscerado(Long id, Integer vturno, Integer vAperturaCiere) {
		
		//vAperturaCiere
		//1 = Apertura
		//2 = Cierre
		
		//1 = Abierto
		//2 = Cerradp
		//3= Reapertura
		String cadena = "In ";
		
		//if (vAperturaCiere == 1)
		
		StringBuffer sb = new StringBuffer();
		
		//Apertura --> Muestras los que no esten "EvisceradoDetalleProcesoLote" y "DescongeladoDetalleProceso"  
		if (vAperturaCiere == 1)
		{ 
			sb.append("select pdl from ProduccionDetalleLote pdl "); 
			sb.append("where pdl.produccion.idproduccion = '"+id.toString() +"' " +
					  "and pdl.turno.idturno = '"+vturno.toString() +"' " +
					  "and pdl.idproducciondetallelote in (select dpd.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote from DescongeladoDetalleProceso dpd) " +
					  "and pdl.idproducciondetallelote not in (select edpl.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote from EvisceradoDetalleProceso edpl) " +
					  "order by pdl.idlote "); 
			
		}else
		//Cerrar
		if (vAperturaCiere == 2)
		{
			sb.append("select pdl from ProduccionDetalleLote pdl "); 
			sb.append("where pdl.produccion.idproduccion = '"+id.toString() +"' " +
					  "and pdl.turno.idturno = '"+vturno.toString() +"' " +
					  "and pdl.idproducciondetallelote in (select edpl.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote " +
					  " from EvisceradoDetalleProceso edpl where edpl.estado in (1,3)) " +
					  "order by pdl.idlote "); 
		}else
			if (vAperturaCiere == 3)
			{
				sb.append("select pdl from ProduccionDetalleLote pdl "); 
				sb.append("where pdl.produccion.idproduccion = '"+id.toString() +"' " +
						  "and pdl.turno.idturno = '"+vturno.toString() +"' " +
						  "and pdl.idproducciondetallelote in (select edpl.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote " +
						  " from EvisceradoDetalleProceso edpl where edpl.estado = 0) " +
						  "order by pdl.idlote "); 
			}
			
		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		return  em.createQuery(sb.toString()).getResultList();

	}
	
//	
//	public List<ProduccionDetalleLote> getidLoteProduccionDetallelote(Long id) { 
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append("select pdl from ProduccionDetalleLote pdl "); 
//		sb.append("where pdl.produccion.idproduccion = '"+id.toString() +"' order by pdl.idlote "); 
//		//logger.info(CalidadPcc.class +" -> "+sb.toString());
//
//		//List items =  em.createQuery(sb.toString()).getResultList();
//		return  em.createQuery(sb.toString()).getResultList();
//
//	}	
	
	
//	@SuppressWarnings("unchecked")
//	public List<ProduccionDetalleLote> getidLoteProduccionDetallelote(Long id) {
//		//Sistema.mensaje(id.toString());
//		List <ProduccionDetalleLote> produccionDetalleLote= em.createQuery("select pdl from ProduccionDetalleLote pdl " +
//				"inner join pdl.produccion p " +
//				"where p.idproduccion = '"+id.toString() +"' order by pdl.idlote ")
//				.getResultList();
//		return produccionDetalleLote;
//		
//	}

	
//	@Override
//	public void saveOrUpdate(
//			ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
//		// TODO Auto-generated method stub
//		
//	}

	public void remove(Long vid) {
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					ProduccionDetalleLoteCajon o = (ProduccionDetalleLoteCajon) em.find(ProduccionDetalleLoteCajon.class, vid);
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

	
	
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLoteCajon> obtenerCajonesporPDL(Long id) {
		//Sistema.mensaje(id.toString());
		List <ProduccionDetalleLoteCajon> produccionDetalleLote; 
		Query qry = em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc " +
				" where pdlc.produccionDetalleLote.idproducciondetallelote = :id order by pdlc.idproducciondetallelotecajon ");
		qry.setParameter("id", id);
		produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;		
	}

	
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLoteCajon> obtenerCajonesporPDLVolteado(Long id) {
		//Sistema.mensaje(id.toString());
		List <ProduccionDetalleLoteCajon> produccionDetalleLote; 
		Query qry = em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc " +
				" where pdlc.produccionDetalleLote.idproducciondetallelote = :id and " +
				" pdlc.camaraCajon.estado = 4 " +
				" order by pdlc.idproducciondetallelotecajon ");
		qry.setParameter("id", id);
		produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;		
	}	
	
	
	
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLoteCajon> obtenerCajonesporPDL_Estado(Long id, Integer estado) {
		//Sistema.mensaje(id.toString());
		List <ProduccionDetalleLoteCajon> produccionDetalleLote; 
		Query qry;
		
		
		if (estado == 4)
		{
			qry = em.createQuery("select ddp.produccionDetalleLoteCajon from DescongeladoDetalleProceso ddp " +
					" where ddp.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote = :id and " +
					" ddp.produccionDetalleLoteCajon.camaraCajon.estado = 4 " +
					"order by ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon ");
			qry.setParameter("id", id);
		}
		else
		{
			qry = em.createQuery("select ddp.produccionDetalleLoteCajon from DescongeladoDetalleProceso ddp " +
					" where ddp.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote = :id and " +
					" ddp.produccionDetalleLoteCajon.camaraCajon.estado <> 4 " +
					"order by ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon ");
			qry.setParameter("id", id);
		}
			
		produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;
		
	}	
	
//	public List<ProduccionDetalleLoteCajon> obtenerCajonesporPDL_Estado_old(Long id, Integer estado) 
//	{
//		//Sistema.mensaje(id.toString());
//		List <ProduccionDetalleLoteCajon> produccionDetalleLote = null;
//		
//
//		//RAKEADO
//		if (estado == 4)
//		{
//			Query qry = em.createQuery("select ddp.produccionDetalleLoteCajon from DescongeladoDetalleProceso ddp " +
//					" where ddp.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote = :id and ddp.produccionDetalleLoteCajon.camaraCajon.estado = 4  order by ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon ");
//			qry.setParameter("id", id);		}
//		else
//		{
//			//EN DESCONGELADO
//			Query qry = em.createQuery("select ddp.produccionDetalleLoteCajon from DescongeladoDetalleProceso ddp " +
//					" where ddp.produccionDetalleLoteCajon.produccionDetalleLote.idproducciondetallelote = :id and ddp.produccionDetalleLoteCajon.camaraCajon.estado <> 4  order by ddp.produccionDetalleLoteCajon.idproducciondetallelotecajon ");
//			qry.setParameter("id", id);
//			produccionDetalleLote= qry.getResultList();
//		}
//			
//		
//		
//		return produccionDetalleLote;
//	}	
	
	
	public List<ProduccionDetalleLoteCajon> getListaCajonesByidLoteProduccionDetallelote(Long id) { 
		
		StringBuffer sb = new StringBuffer();
		sb.append("select pdlc from ProduccionDetalleLoteCajon pdlc "); 
		sb.append("where pdlc.produccionDetalleLote.idproducciondetallelote = '"+id.toString() +"'"); 
		//logger.info(CalidadPcc.class +" -> "+sb.toString());

		//List items =  em.createQuery(sb.toString()).getResultList();
		return  em.createQuery(sb.toString()).getResultList();
	}	
	
@Override
	public void saveOrUpdate(ProduccionDetalleLoteCajon pdlc) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(pdlc);//merge
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
	}	

public ProduccionDetalleLoteCajon getidLoteProduccionDetallelotebyIdcamaraCajon(Long id) { 
    
    StringBuffer sb = new StringBuffer();
    sb.append("select pdlc from ProduccionDetalleLoteCajon pdlc  "); 
    sb.append("where pdlc.camaraCajon.idcamaracajon = '"+id.toString() +"'"); 

    //logger.info(CalidadPcc.class +" -> "+sb.toString());

    List items =  em.createQuery(sb.toString()).getResultList();

if (items == null || items.isEmpty()) {
   return null;
} else {
   return  (ProduccionDetalleLoteCajon) items.get(0);
}    
}      

//NUEVO 29-06-2016
public ProduccionDetalleLoteCajon getidProduccionDetalleloteCajon(Long id)
{
	
	Query qry = em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc " +
			"where pdlc.idproducciondetallelotecajon = "+id.toString() +"").setFirstResult(0);

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
	return (ProduccionDetalleLoteCajon) lista;
}	

	//05-07-2016 
	public ProduccionDetalleLoteCajon getProduccionDetalleLoteCajonByCamaraCajon(String vididcamaracajon)
	{
	    Query qry = em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc  " +
	    		"where pdlc.camaraCajon.idcamaracajon = '"+vididcamaracajon.toString() +"'")
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
	       return (ProduccionDetalleLoteCajon) lista;
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLoteCajon> getListaLonjasDetalleProcesoLote(long idproducciondetallelote) 
	{
		List<ProduccionDetalleLoteCajon> lista = new ArrayList<>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
		try {
			 Query qry  = em.createQuery("select ep from ProduccionDetalleLoteCajon ep " +
					" where ep.produccionDetalleLote.idproducciondetallelote = :idpdl and ep.estado = 1 " +
					" order by  ep.idproducciondetallelotecajon desc ");
			
			 qry.setParameter("idpdl",  idproducciondetallelote ); 
			 lista = qry.getResultList();
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			lista = new ArrayList<>();
			return lista;
		}finally{
			em.close();
		}
	}	
	
    public List<ProduccionDetalleLoteCajon> getListaCajoneByidLoteProduccionDetalleloteIdCamaraCajon(Long idcc, Long idpdl) 
    { 
          
          StringBuffer sb = new StringBuffer();
          sb.append("select pdlc from ProduccionDetalleLoteCajon pdlc "); 
          sb.append("where pdlc.produccionDetalleLote.idproducciondetallelote = '"+idcc.toString() +"' "); 
          sb.append("and pdlc.camaraCajon.idcamaracajon = '"+idpdl.toString() +"' ");
          //logger.info(CalidadPcc.class +" -> "+sb.toString());

          //List items =  em.createQuery(sb.toString()).getResultList();
          return  em.createQuery(sb.toString()).getResultList();
    }     

}
