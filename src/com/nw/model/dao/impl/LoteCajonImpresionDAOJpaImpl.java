package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.ProduccionDetalleLote;

/**
 * 
 * @author Carlos Holguin
 * @since 24-07-2014
 *
 */
public class LoteCajonImpresionDAOJpaImpl extends BaseDaoJpaImpl {

	
	public LoteCajonImpresionDAOJpaImpl() {
	
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<ProduccionDetalleLote> getProduccionDetalleLotePorFechaProduccionTurno(Long idproduccion,int idturno) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<ProduccionDetalleLote> produccionDetalleLotes = new ArrayList<ProduccionDetalleLote>();
		 
	 
			   String consulta ="SELECT pdl FROM ProduccionDetalleLote pdl" +
			   		" where pdl.produccion.idproduccion = :id and pdl.turno.idturno = :idtur order by pdl.idlote asc";
			   
				 Query query = em.createQuery(consulta);
				 query.setParameter("id", idproduccion);
				 query.setParameter("idtur", idturno);
				 produccionDetalleLotes = (List<ProduccionDetalleLote>)query.getResultList();
			 
		 return  produccionDetalleLotes;
	}

	
	@SuppressWarnings({ "unchecked" })
	public List<Object[]> getCajonesPorFechaProduccionTurnoLote(Long idproduccion,
			int idturno, Long iddetallelote) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		 
		//List<Object> lotescajones = new ArrayList<Object>();
	 
			  	   
			   StringBuilder sb = new StringBuilder();
			   sb.append("SELECT  pdl.idlote,c.idcajon,b.nombre,e.nombre || ' ' || t.nombre as especietalla ");
			   sb.append("from produccion_detalle_lote pdl ");
			   sb.append("inner join produccion_detalle_lote_cajon pdlc ");
			   sb.append(" on (pdl.idproducciondetallelote = pdlc.idproducciondetallelote) ");
			   sb.append("inner join camara_cajon cc ");
			   sb.append("on (pdlc.idcamaracajon = cc.idcamaracajon) ");
			   sb.append("inner join cajon c ");
			   sb.append("on cc.idcajon = c.idcajon ");
			   sb.append("inner join barco_descarga bd ");
			   sb.append("on (cc.idbarcodescarga = bd.idbarcodescarga) ");
			   sb.append("inner join barco b ");
			   sb.append("on (bd.idbarco = b.idbarco) ");
			   sb.append("inner join especie_talla et ");
			   sb.append("on (cc.idmaterial=et.idespecietalla) ");
			   sb.append("inner join especie e ");
			   sb.append("on (et.idespecie=e.idespecie) ");
			   sb.append("inner join talla t ");
			   sb.append("on (et.idtalla = t.idtalla) ");
			   sb.append(String.format("where pdl.idproduccion = %s and pdl.idturno = %s and pdl.idproducciondetallelote = %s ", idproduccion, idturno, iddetallelote)); 
			   //sb.append(String.format("where pdl.idproduccion = %s and pdl.idturno = %s ", idproduccion, idturno));
			   sb.append(" GROUP BY pdl.idlote,b.nombre,especietalla ,c.idcajon ");
			   sb.append(" order by  c.idcajon asc");
			   //sb.append("");
			   
				 Query query = em.createNativeQuery(sb.toString());
				  
				 return query.getResultList();
			 
		 
	}
	
 
	
	
	
}
