package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDetalleProceso;
/*import com.nw.model.EvisceradoDetalleProceso;*/
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.ProduccionDetalleLoteCajon;
import com.nw.model.dao.ProducccionDetalleLoteDAO;
import com.nw.util.Sistema;

public class ProduccionDetalleLoteDAOJpaImpl extends BaseDaoJpaImpl implements ProducccionDetalleLoteDAO {

	
	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public ProduccionDetalleLoteDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	@Override
	public List<ProduccionDetalleLote> getLotesAperturados() {
		StringBuilder sb = new StringBuilder();

		sb.append ("Select p from ProduccionDetalleLote p ");
		sb.append ("where p.idproducciondetallelote IN ");
		sb.append(" (select d.produccionDetalleLote.idproducciondetallelote from LimpiezaDetalleProcesoLote d where d.estado=1) order by p.idlote ");
		
		return em.createQuery(sb.toString()).getResultList();
	}

/*	
	@Override
	public List<ProduccionDetalleLote> getLotesAperturadosPorTurno(int viturno ) {
		StringBuilder sb = new StringBuilder();

		sb.append ("Select p from ProduccionDetalleLote p ");
		sb.append ("where p.idproducciondetallelote IN ");
		sb.append(" (select d.produccionDetalleLote.idproducciondetallelote from LimpiezaDetalleProcesoLote d where d.estado=1) and p.turno.idturno = '"+String.valueOf(viturno)+"' order by p.idlote ");
		
		return em.createQuery(sb.toString()).getResultList();
	}	
*/
	
	
	//Nuevo 27-03-2015
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLote> obtenerLotes(Long idproduccion, Integer idturn) {		
		return em.createQuery("select edp.produccionDetalleLoteCajon.produccionDetalleLote pdl from EvisceradoDetalleProceso edp,  ProduccionDetalleLoteCajon pdlc " +
				" where edp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = '" + idturn.toString() +"' " +
				" and edp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = '" + idproduccion.toString() +"' " +
				" and edp.produccionDetalleLoteCajon.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon ").getResultList();
	 	//return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
	}
	
	
	
	@Override
	public List<ProduccionDetalleLote> getLotesCerrados(Long vip) {
		StringBuilder sb = new StringBuilder();

		Sistema.mensaje("El di es :"+ vip.toString());
		sb.append ("Select p from ProduccionDetalleLote p ");
		sb.append ("where p.idproducciondetallelote IN ");
		sb.append(" (select d.produccionDetalleLote.idproducciondetallelote from LimpiezaDetalleProcesoLote d where d.estado=0) AND p.produccion.idproduccion = '"+vip+"' order by p.idlote ");
		
		return em.createQuery(sb.toString()).getResultList();
	}
	
/*
	
	@Override
	public List<ProduccionDetalleLote> getLotesCerradosPorTurno(Long vip, int viturno) {
		StringBuilder sb = new StringBuilder();

		Sistema.mensaje("El di es :"+ vip.toString());
		sb.append ("Select p from ProduccionDetalleLote p ");
		sb.append ("where p.idproducciondetallelote IN ");
		sb.append(" (select d.produccionDetalleLote.idproducciondetallelote from LimpiezaDetalleProcesoLote d where d.estado=0) AND p.produccion.idproduccion = '"+vip+"' and p.turno.idturno = '"+String.valueOf(viturno)+"' order by p.idlote ");
		
		return em.createQuery(sb.toString()).getResultList();
	}	
*/	
	
	@Override
	public List<ProduccionDetalleLote> getLotes(Integer vturno, Long pidproducciondetallelot) {
		StringBuilder sb = new StringBuilder();
		
//		SELECT e 
//		FROM Employee e 
//		WHERE e.id IN (SELECT emp.id
//		                 FROM Project p JOIN p.employees emp 
//		                WHERE p.name = :project)
		
		//TODO 0 EJEMPLO DE USO DE SUBQUERY EN JPA
		sb.append(" select c from ProduccionDetalleLote c ");
		sb.append(" where c.idproducciondetallelote NOT IN ");
		sb.append(" (select d.produccionDetalleLote.idproducciondetallelote from LimpiezaDetalleProcesoLote d) AND c.turno.idturno = '"+vturno.toString()+"'  AND c.produccion.idproduccion = '"+pidproducciondetallelot.toString()+"' order by c.idlote");
		
		return em.createQuery(sb.toString()).getResultList();
	}	
	
	
	@Override
	public List<ProduccionDetalleLote> getLotesCarryOver(Integer vturno, Long pidproducciondetallelot) {
		StringBuilder sb = new StringBuilder();
		
		//TODO 0 EJEMPLO DE USO DE SUBQUERY EN JPA
		sb.append(" select c from ProduccionDetalleLote c ");
		sb.append(" where  c.turno.idturno = '"+vturno.toString()+"'  AND c.produccion.idproduccion = '"+pidproducciondetallelot.toString()+"' order by c.idlote");
		
		return em.createQuery(sb.toString()).getResultList();
	}

	
	//Nuevo 04-04-2016
	public List<ProduccionDetalleLote> getLotesPorProduccionTurnoYLote(Integer vturno, Long pidprod, Integer pidlote) 
	{
		StringBuilder sb = new StringBuilder();
		
		//TODO 0 EJEMPLO DE USO DE SUBQUERY EN JPA
		sb.append(" select c from ProduccionDetalleLote c ");
		sb.append(" where  c.turno.idturno = '"+vturno.toString()+"'  AND c.produccion.idproduccion = '"+pidprod.toString()+"'  AND c.idlote = '"+pidlote.toString()+"'  order by c.idlote");
		
		return em.createQuery(sb.toString()).getResultList();
	}
	
	
//	@SuppressWarnings("unchecked")
//	public List<ProduccionDetalleLote> getProduccionDetallelote() {
//		List <ProduccionDetalleLote> produccionDetalleLote= em.createQuery("select p from ProduccionDetalleLote p order by p.idlote ")
//				.getResultList();
//		return produccionDetalleLote;
//		
//	}
	
	

	/**
	 * Devuelve los lotes de produccion activos dependiendo del turno seleccionado
	 * utilizando la siguiente consulta sql
	 * 
	 * select * from produccion_detalle_lote
	 * inner join produccion on produccion.idproduccion = produccion_detalle_lote.idproduccion
	 * where produccion.estado = 2 and produccion_detalle_lote.idturno = 1
	 * order by produccion_detalle_lote.idlote
	 * 
	 * @return
	 * List<ProduccionDetalleLote>
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLote> getProduccionDetallelote(Long idprod, Integer idtur) {
		Query qry= em.createQuery("select pdl from ProduccionDetalleLote pdl " +
				"where pdl.produccion.idproduccion = :idproduc and pdl.turno.idturno = :idturn " +
				"order by pdl.idlote ");
		
		qry.setParameter("idproduc", idprod);
		qry.setParameter("idturn", idtur);
		
		List <ProduccionDetalleLote> produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;
		
	}
	

	public List<ProduccionDetalleLote> getProduccionDetalleloteEnDescongelado(Long idprod, Integer idtur) {
		Query qry= em.createQuery("select DISTINCT pdl.produccionDetalleLoteCajon.produccionDetalleLote from DescongeladoDetalleProceso pdl " +
				"where pdl.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idproduc and pdl.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
				"order by pdl.produccionDetalleLoteCajon.produccionDetalleLote.idlote ");
		
		qry.setParameter("idproduc", idprod);
		qry.setParameter("idturn", idtur);
		
		List <ProduccionDetalleLote> produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;
		
	}	
	
	
//	public List<ProduccionDetalleLote> getProduccionDetalleloteEnDescongelado(Long idprod, Integer idtur) {
//		Query qry= em.createQuery("select DISTINCT pdl from ProduccionDetalleLote pdl " +
//				"inner join pdl.produccionDetalleLoteCajons pdlc " +
//				"inner join pdlc.descongeladoDetalleProcesos ddp " +
//				"where pdl.produccion.idproduccion = :idproduc and pdl.turno.idturno = :idturn " +
//				"order by pdl.idlote ");
//		
//		qry.setParameter("idproduc", idprod);
//		qry.setParameter("idturn", idtur);
//		
//		List <ProduccionDetalleLote> produccionDetalleLote= qry.getResultList();
//		return produccionDetalleLote;
//		
//	}	
	
	public String idespecieTalla(int idcajon)
	{
		//idcajon = 1;  
		
		Query query =   em.createQuery("Select t.descripcion from EspecieTalla t join " +
		  		" t.produccionDetalleLotes pdl ");
				
				
//				em.createQuery("select et.descripcion from EspecieTalla et " +
//				"inner join ProduccionDetalleLote pdl " +
//				"on pdl.idespecietalla = et.idespecietalla " +
//				"where pdl.idproducciondetallelote = 1");
		
		
		
		  //query.setParameter("idcamaracajon", idcajon);
		
		
		//Query qry = em.createQuery("SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2");
		Object obj = query.getSingleResult();
		System.out.println("obj especie-->"+obj);
		
	    if(obj==null)
	    {
	    	return "";
	    }
	    else
	    {
	    	return (String)obj;
	    }
	}
	
//	Query query = em.createQuery("select et.descripcion From EspecieTalla et " +
//			"inner join ProduccionDetalleLote pdl " +
//			"on pdl.idespecietalla = et.idespecietalla "+
//			"inner join  ProduccionDetalleLoteCajon pdlc " +
//			"on pdl.idproducciondetallelote = pdlc.idproducciondetallelotecajon "+
//			"where pdlc.idcamaracajon = :idcamaracajon ");
//	
//	query.setParameter("idcamaracajon", idcajon);
//	
	
	public Long getIdDescongeladoProceso(Long idproduccion)
	{
		Query query = em.createQuery("select dp.iddescongeladoproceso from DescongeladoProceso dp " +
				"where dp.idproduccion = :idpro");
		query.setParameter("idpro", idproduccion);
		
		Object obj = query.getSingleResult();
		
		System.out.println("El valor de idproduccion: " + obj);
		
		return (Long) obj;
	}
	
	
	
//	select produccion_detalle_lote_cajon.idproducciondetallelotecajon, especie.nombre  from produccion_detalle_lote_cajon
//	inner join camara_cajon on camara_cajon.idcamaracajon = produccion_detalle_lote_cajon.idcamaracajon
//	inner join especie_talla on camara_cajon.idmaterial =  especie_talla.idespecietalla
//	inner join especie on especie_talla.idespecie = especie.idespecie
//	inner join talla on especie_talla.idtalla = talla.idtalla
//	where  camara_cajon.idcajon = '21050' - 21051 - 21052
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getDevuelveEspecietalla(String idcajon) throws InterruptedException
	{
		//Query query =   em.createQuery("Select t.descripcion from EspecieTalla t where t.idespecietalla = 765 ");

		Query query = em.createQuery("select pdlc.idproducciondetallelotecajon, e.nombre, t.nombre from ProduccionDetalleLoteCajon pdlc " +
		"inner join pdlc.camaraCajon cc " +
		"inner join cc.especieTalla et " +
		"inner join et.especie e " +
		"inner join cc.cajon c " +
		"inner join et.talla t " +
		"where c.idcajon = :idcaj");
		
//		Query query = em.createQuery("select pdlc.idproducciondetallelotecajon, et.descripcion from EspecieTalla et " +
//				"inner join et.produccionDetalleLotes pdl " +
//				"inner join pdl.produccionDetalleLoteCajons pdlc " +
//				"inner join pdlc.camaraCajon cc " +
//				"where cc.idcamaracajon = :cc");

		query.setParameter("idcaj", idcajon);
	
		List<Object[]> listDatos = query.getResultList();

		
		return  listDatos;
	}
	
	public ProduccionDetalleLoteCajon getEspecieTallaCajones(String idcajon)
	{
		ProduccionDetalleLoteCajon produccionDetalleLoteCajon = new ProduccionDetalleLoteCajon();

		Query query = em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc " +
				"inner join pdlc.camaraCajon cc " +
				"inner join cc.especieTalla et " +
				"inner join et.especie e " +
				"inner join cc.cajon c " +
				"inner join et.talla t " +
				"where c.idcajon = :idcaj");
		query.setParameter("idcaj", idcajon);
		
		produccionDetalleLoteCajon = (ProduccionDetalleLoteCajon) query.getSingleResult();
		
		return produccionDetalleLoteCajon;
		
	}
	
	
	public List<Object[]> getDevuelvePedido(int idlote)
	{
		Query query = em.createQuery("select bd.origen, pdl.pedidocamara from ProduccionDetalleLote pdl " +
				"inner join pdl.produccion p " +
				"inner join pdl.barcoDescarga bd " +
				"where pdl.idlote = :idlot and p.estado = 2");
		query.setParameter("idlot", idlote);
		
		System.out.println("VARIABLE idlote -->"+idlote);
		//Object obj = query.getSingleResult();
		
		//System.out.println("Mensaje de la consulta realizada--> "+  obj.toString());
		
		List<Object[]> listDatos = query.getResultList();
		
        if (listDatos == null) 
        {
            return null;
        } 
        else {
            return  listDatos;
        }	
	}
	
	
	public void guardarDescongeladodetalleproceso(DescongeladoDetalleProceso ddp)
	{
		EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();  
			Query qry = em.createQuery("SELECT MAX(c.idcamaracajonubicacion) FROM CamaraCajonUbicacion c");
		    Object valorMaximoObjeto = qry.getSingleResult();
			
		    em.merge(ddp);
	        t.commit();
	        
	        
	        
		} catch (Exception e) {

		}
	}
	

	public void remove(ProduccionDetalleLote produccionDetalleLote) {
		try{
		   	 EntityTransaction t = em.getTransaction();
		   	 try {
					t.begin();
					ProduccionDetalleLote o = (ProduccionDetalleLote) em.find(ProduccionDetalleLote.class, produccionDetalleLote.getIdproducciondetallelote());
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
	
	
	@Override
	public void saveOrUpdate(ProduccionDetalleLote produccionDetalleLote) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(produccionDetalleLote);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	



public ProduccionDetalleLoteCajon getProduccionDetalleloteByCamaraCajon(Long idcamaracajon) {
		Query qry= em.createQuery("select pdlc from ProduccionDetalleLoteCajon pdlc " +
				"where pdlc.camaraCajon.idcamaracajon = :idpro ");
		
		    qry.setParameter("idpro", idcamaracajon);
		    
		    try {
		    	 ProduccionDetalleLoteCajon produccionDetalleLote = (ProduccionDetalleLoteCajon) qry.getSingleResult();
		    	 return produccionDetalleLote;
		    
		    } catch (Exception e) {
				return null;
			}
	}		


@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLote> getProduccionDetallelote1(Long idprod) {
		Query qry= em.createQuery("select pdl from ProduccionDetalleLote pdl " +
				"where pdl.produccion.idproduccion = :idproduc  order by pdl.idlote "  //and pdl.turno.idturno = :idturn
				); //"order by pdl.idlote "
		
		qry.setParameter("idproduc", idprod);
		//qry.setParameter("idturn", idtur);
		
		List <ProduccionDetalleLote> produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProduccionDetalleLote> getPesosSubproducto(Long idprod) {
		Query qry= em.createQuery("select pdl from ProduccionDetalleLote pdl " +
				"where pdl.produccion.idproduccion = :idproduc  order by pdl.idlote "  //and pdl.turno.idturno = :idturn
				); //"order by pdl.idlote "
		
		qry.setParameter("idproduc", idprod);
		//qry.setParameter("idturn", idtur);
		
		List <ProduccionDetalleLote> produccionDetalleLote= qry.getResultList();
		return produccionDetalleLote;
		
	}

	//Nuevo 06-04-2016
	public List<ProduccionDetalleLote> getLotesPorProduccionTYLote(Long pidprod, Integer pidlote) 
	{
		StringBuilder sb = new StringBuilder();
		
		//TODO 0 EJEMPLO DE USO DE SUBQUERY EN JPA
		sb.append(" select c from ProduccionDetalleLote c ");
		sb.append(" where c.produccion.idproduccion = '"+pidprod.toString()+"'  AND c.idlote = '"+pidlote.toString()+"'  order by c.idlote");
		
		return em.createQuery(sb.toString()).getResultList();
	}


    public List<ProduccionDetalleLote> getLotesPorProduccionTYLoteDisponible(Long pidprod, Integer pidlote, Integer pidturno) 
    {
          StringBuilder sb = new StringBuilder();
          
          //TODO 0 EJEMPLO DE USO DE SUBQUERY EN JPA
          
          sb.append(" select c from ProduccionDetalleLote c ");
          sb.append(" where c.produccion.idproduccion = '"+pidprod.toString()+"'  AND c.idlote = '"+pidlote.toString()+"'  order by c.idlote");
          //sb.append(" where c.produccion.idproduccion = '"+pidprod.toString()+"'  AND c.idlote = '"+pidlote.toString()+"' AND c.turno.idturno = '" +pidturno.toString()  +"' order by c.idlote");
          
          return em.createQuery(sb.toString()).getResultList();
    }      

	
}
