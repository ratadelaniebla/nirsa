package com.nw.model.dao.impl;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.DescongeladoDetalleProcesoContraloria;
import com.nw.model.DescongeladoDetalleProcesoFinForzado;
import com.nw.model.DescongeladoDucha;
import com.nw.model.DescongeladoDuchaAperturaCierreDetalle;
import com.nw.model.DescongeladoProceso;
import com.nw.model.dao.DescongeladoDetalleIngresoDAO;
import com.nw.temp.model.CajonDescongeladoDetalleProceso;

public class DescongeladoDetalleIngresoDAOJpaImpl extends BaseDaoJpaImpl implements DescongeladoDetalleIngresoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public DescongeladoDetalleIngresoDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	
	public List<DescongeladoDetalleProcesoFinForzado> ListaCajonesFinProcesoForzadoParaActualizar(Long id)
	{
		List<DescongeladoDetalleProcesoFinForzado> lista = new ArrayList<DescongeladoDetalleProcesoFinForzado>();

		Query query = em.createQuery("select ddp from DescongeladoDetalleProcesoFinForzado ddp " +
				"where ddp.descongeladoDetalleProceso.iddescongeladodetalleproceso = :id " +
				"order by ddp.iddescongeladodetalleprocesofinforzado desc");
		
		query.setParameter("id", id);
		lista = query.getResultList();
		
		return lista;
		
	}		
	
	
	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDuchaAperturaCierreDetalle> getDuchasDisponiblesParaTranslado(Long idproduccion) 
	{
		List<DescongeladoDuchaAperturaCierreDetalle> lista = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		Query query = em.createQuery("select d from DescongeladoDuchaAperturaCierreDetalle d " +
					"where d.produccion.idproduccion = :idpro and d.estado in (1,3) " +
					"order by d.descongeladoDucha.descripcion ");
				query.setParameter("idpro", idproduccion);
				lista = query.getResultList();
				return lista;								
	}	
	
	
	
	public List<DescongeladoDetalleProceso> ListaCajonesIngresados7(Long iddescongeladoduchaaperturacierredetalle)
	{
		List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

		Query query = em.createQuery(
				"select ddp from DescongeladoDetalleProceso ddp " +
				" where ( " +
				//" ddp.descongeladoDuchaAperturaCierreDetalle2.iddescongeladoduchaaperturacierredetalle = :iddpacd and ddp.finforzado = 0 and ddp.horafindescongelado IS NULL  " +
				//" or " +
				" ddp.descongeladoDuchaAperturaCierreDetalle2.iddescongeladoduchaaperturacierredetalle = :iddpacd1 and ddp.finforzado = 3) " +
				" order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
		//query.setParameter("iddpacd", iddescongeladoduchaaperturacierredetalle);
		query.setParameter("iddpacd1", iddescongeladoduchaaperturacierredetalle);
		
		lista = query.getResultList();
		
		return lista;
		
	}		

	
	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDuchaAperturaCierreDetalle> getDuchasIniciadas(Long idproduccion) 
	{
		List<DescongeladoDuchaAperturaCierreDetalle> lista = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		Query query = em.createQuery("select d from DescongeladoDuchaAperturaCierreDetalle d " +
					"where d.produccion.idproduccion = :idpro and d.estado in (1) " +
					"order by d.descongeladoDucha.descripcion ");
				query.setParameter("idpro", idproduccion);
				lista = query.getResultList();
				return lista;								
	}
	
	
	
	
	public List<DescongeladoDetalleProceso> ListaCajonesIngresados8(Long iddescongeladoduchaaperturacierredetalle)
	{
		List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

		Query query = em.createQuery(
				"select ddp from DescongeladoDetalleProceso ddp " +
				" where ( " +
				" ddp.descongeladoDuchaAperturaCierreDetalle1.iddescongeladoduchaaperturacierredetalle = :iddpacd and ddp.finforzado = 0 and ddp.horafindescongelado IS NULL ) " +
				//" or " +
				//" ddp.descongeladoDuchaAperturaCierreDetalle1.iddescongeladoduchaaperturacierredetalle = :iddpacd1 and ddp.finforzado = 3) " +
				" order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
		query.setParameter("iddpacd", iddescongeladoduchaaperturacierredetalle);
		//query.setParameter("iddpacd1", iddescongeladoduchaaperturacierredetalle);
		
		lista = query.getResultList();
		
		return lista;
		
	}		
	
	
	
	
	
	
	public List<DescongeladoDuchaAperturaCierreDetalle> getDuchasDisponibles(Long idproduccion) 
	{
		List<DescongeladoDuchaAperturaCierreDetalle> lista = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		Query query = em.createQuery("select d from DescongeladoDuchaAperturaCierreDetalle d " +
					"where d.produccion.idproduccion = :idpro and d.estado in (1,3) " +
					"order by d.descongeladoDucha.descripcion ");
				query.setParameter("idpro", idproduccion);
				lista = query.getResultList();
				return lista;								
	}	


	public List<DescongeladoDetalleProceso> ListaCajonesCerradosForzosamente(Long idprod, Integer idtur)
	{
		List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

		Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
				"where ddp.estado = 2 and ddp.finforzado in (1,2) and " +
				"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
				"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
/*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
				"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
		
		query.setParameter("idproduc", idprod);
		query.setParameter("idturn", idtur);
		
		lista = query.getResultList();
		
		return lista;			
	}	


	
	public List<DescongeladoDetalleProceso> ListaCajonesCerradosForzosamentePorCajon(Long idprod, Integer idtur)
	{
		List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

		Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
				"where ddp.estado = 2 and ddp.finforzado in (1,2) and " +
				"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
				"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
/*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
				"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
		
		query.setParameter("idproduc", idprod);
		query.setParameter("idturn", idtur);
		
		lista = query.getResultList();
		
		return lista;			
	}	
	
	
	
	
	
	public List<DescongeladoDetalleProcesoFinForzado> ListaCajonesFinProcesoForzado(Long id)
	{
		List<DescongeladoDetalleProcesoFinForzado> lista = new ArrayList<DescongeladoDetalleProcesoFinForzado>();

		Query query = em.createQuery("select ddp from DescongeladoDetalleProcesoFinForzado ddp " +
				"where ddp.descongeladoDetalleProceso.iddescongeladodetalleproceso = :id and ddp.horafin IS NULL " +
				"order by ddp.iddescongeladodetalleprocesofinforzado desc");
		
		query.setParameter("id", id);
		lista = query.getResultList();
		
		return lista;
		
	}		
	

	@Override
	public void saveOrUpdateDescongeladoDetalleProcesoFinForzado(DescongeladoDetalleProcesoFinForzado descongeladodetalleprocesofinforzado) 
	{

	  	EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			
			//EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(descongeladodetalleprocesofinforzado);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}		
	
	
//	select cajon.idcajon from  cajon
//	inner join camara_cajon on 
//	cajon.idcajon=camara_cajon.idcajon
//	inner join produccion_detalle_lote_cajon on 
//	produccion_detalle_lote_cajon.idcamaracajon=camara_cajon.idcamaracajon
//	inner join descongelado_detalle_proceso on 
//	descongelado_detalle_proceso.idproducciondetallelotecajon=produccion_detalle_lote_cajon.idproducciondetallelotecajon
//	where descongelado_detalle_proceso.estado = '1' 
	
	
//	select descongelado_detalle_proceso.iddescongeladodetalleproceso, cajon.idcajon, descongelado_detalle_proceso.cajonrevolteo, produccion_detalle_lote.idlote, especie_talla.descripcion, barco_descarga.origen, produccion_detalle_lote.pedidocamara, descongelado_detalle_proceso.idducha, descongelado_proceso.iddescongeladoproceso, descongelado_detalle_proceso.idproducciondetallelotecajon from  cajon
//	inner join camara_cajon on 
//	cajon.idcajon=camara_cajon.idcajon
//	inner join produccion_detalle_lote_cajon on 
//	produccion_detalle_lote_cajon.idcamaracajon=camara_cajon.idcamaracajon
//	inner join descongelado_detalle_proceso on 
//	descongelado_detalle_proceso.idproducciondetallelotecajon=produccion_detalle_lote_cajon.idproducciondetallelotecajon
//	inner join produccion_detalle_lote
//	on produccion_detalle_lote.idproducciondetallelote = produccion_detalle_lote_cajon.idproducciondetallelote
//	inner join especie_talla
//	on produccion_detalle_lote.idespecietalla = especie_talla.idespecietalla
//	inner join barco_descarga
//	on barco_descarga.idbarcodescarga = camara_cajon.idbarcodescarga
//	inner join descongelado_proceso
//	on descongelado_proceso.iddescongeladoproceso = descongelado_detalle_proceso.iddescongeladoproceso
//	where descongelado_detalle_proceso.estado = '1'
//	
	
	/**
	 * Devuelve el listado de los cajones ingresados en base a la produccion y al idturno
	 * 
	 * select * from descongelado_detalle_proceso 
	 * inner join descongelado_proceso on descongelado_proceso.iddescongeladoproceso = descongelado_detalle_proceso.iddescongeladodetalleproceso
	 * inner join produccion on descongelado_proceso.idproduccion = produccion.idproduccion
	 * where descongelado_detalle_proceso.estado=1 and produccion.idproduccion = 12 and descongelado_detalle_proceso.idturno =2
	 * 
	 * @param idproduccion
	 * @return
	 * List<DescongeladoDetalleProceso>
	 * 
	 */
		public List<DescongeladoDetalleProceso> ListaCajonesIngresados(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado = 1 and " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
		//"ddp.turno.idturno = :idturn ");
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}

		
		
		public List<DescongeladoDetalleProceso> ListaCajonesEnviadosProduccion(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.produccionDetalleLoteCajon.camaraCajon.estado = 4 and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idproduc " +
					"order by ddp.horafin desc ");
			
//			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
//					"where ddp.produccionDetalleLoteCajon.camaraCajon.estado = 4 and " +
//					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idproduc and " +
//					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
			query.setParameter("idproduc", idprod);
//			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}
		
		

		public List<DescongeladoDetalleProceso> ListaCajonesEnviadosXProduccion(Long idprod)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.produccionDetalleLoteCajon.camaraCajon.estado = 4 and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idproduc " +
					"order by ddp.horafin desc ");
			
//			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
//					"where ddp.produccionDetalleLoteCajon.camaraCajon.estado = 4 and " +
//					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idproduc and " +
//					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
			query.setParameter("idproduc", idprod);
//			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}
		
		
		
		
		public List<DescongeladoDetalleProceso> ListaCajonesIngresados11(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado = 1 and ddp.cajonrevolteo is null and " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
/*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
		//"ddp.turno.idturno = :idturn ");
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}		


		public List<DescongeladoDetalleProceso> ListaCajonesIngresados1(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado = 1 and  ddp.horainicio is null and " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
/*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
			
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}		
		

		
		public List<DescongeladoDetalleProceso> ListaCajonesIngresados1PorCajon(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado = 1 and  ddp.horainicio is null and " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
/*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
			
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}		
		
		
		
//		public List<DescongeladoDetalleProceso> ListaCajonesIngresados1(Long idprod, Integer idtur)
//		{
//			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();
//
//			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
//					"where ddp.estado = 1 and " +
//					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
//					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
///*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
//					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
//			
//			query.setParameter("idproduc", idprod);
//			query.setParameter("idturn", idtur);
//			
//			lista = query.getResultList();
//			
//			return lista;
//			
//		}		

		
		///Actualizado 08-03-2017 Cambio
		public List<DescongeladoDetalleProceso> ListaCajonesParaDevolucion(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado in (1,2) and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
/*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
			
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}		
		
		
		
//		public List<DescongeladoDetalleProceso> ListaCajonesParaDevolucion(Long idprod, Integer idtur)
//		{
//			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();
//
//			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
//					"where ddp.estado in (1,2) and " +
//					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
//					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
///*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
//					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
//			
//			query.setParameter("idproduc", idprod);
//			query.setParameter("idturn", idtur);
//			
//			lista = query.getResultList();
//			
//			return lista;
//			
//		}		

		
		public List<DescongeladoDetalleProceso> ListaCajonesIngresados2(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

//			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
//					"inner join ddp.descongeladoProceso dp " +
//					"inner join dp.produccion p " +
//					"where ddp.estado= 2 and p.idproduccion = :idpro ");
//			query.setParameter("idpro", idproduccion);
			
			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado in (2) and " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
/*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
			
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}

		
		
		
		public List<DescongeladoDetalleProceso> ListaCajonesDescongelado(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			
			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado in (1, 2,3) and " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
			
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}
		
		
		
		
		public List<DescongeladoDetalleProceso> ListaCajonesParaBajaTemperaturas(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			
			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado in (2,3) and " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
			
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}

		
		public List<DescongeladoDetalleProceso> ListaCajonesParaBajaTemperaturasLotes(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			
			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where ddp.estado in (2,3) and " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.idlote ");
			
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}		
		
		public List<DescongeladoDetalleProceso> ListaCajonesIngresadosTodos(Long idprod, Integer idtur)
		{
			List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

			Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
					"where " +
					"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
					"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
/*					"order by ddp.produccionDetalleLoteCajon.produccionDetalleLote.pedidocamara ");*/
					"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
			
			query.setParameter("idproduc", idprod);
			query.setParameter("idturn", idtur);
			
			lista = query.getResultList();
			
			return lista;
			
		}
		
		
		
	  public List<CajonDescongeladoDetalleProceso> getCajonesIngresados(Long idproduccion) {
	   List<CajonDescongeladoDetalleProceso> listaDDPs = new ArrayList<CajonDescongeladoDetalleProceso>();
			//Muestra la lista de todos los cajons con estado 1
			Query query = em.createQuery("select ddp.iddescongeladodetalleproceso, c.idcajon, ddp.cajonrevolteo, pdl.idlote, et.descripcion, bd.origen, pdl.pedidocamara, dp.iddescongeladoproceso, pdlc.idproducciondetallelotecajon, ddp.horaingreso from Cajon c " +
					"inner join c.camaraCajons cc " +
					"inner join cc.produccionDetalleLoteCajons pdlc " +
					"inner join pdlc.descongeladoDetalleProcesos ddp " +
					"inner join pdlc.produccionDetalleLote pdl " +
					"inner join pdl.especieTalla et " +
					"inner join pdl.barcoDescarga bd " +
					"inner join ddp.descongeladoProceso dp " +
					"inner join pdl.produccion p " +
					"where ddp.estado= 1 and p.idproduccion = :idpro ");
			query.setParameter("idpro", idproduccion);

			List<Object[]> listDatos = query.getResultList();
			
			for (Object[] obj : listDatos) {
//				listaDDPs.add(new CajonDescongeladoDetalleProceso(idCajonDescongelado, idCajon, 
//						cajonRevolteo, idLote,
//						descripcionEspecieTalla, 
//						origen, pedido))
				CajonDescongeladoDetalleProceso cddp = new CajonDescongeladoDetalleProceso();
				
				if (obj[4] == null) {
					cddp.setDescripcionEspecieTalla("");
				}
				else
				{
					cddp.setDescripcionEspecieTalla(String.valueOf(obj[4]));
				}
				
				cddp.setIdCajonDescongelado(Integer.valueOf( String.valueOf(obj[0]) ));
				cddp.setIdCajon( String.valueOf(obj[1]));
				cddp.setCajonRevolteo(String.valueOf(obj[2]));
				cddp.setIdLote(Integer.valueOf(String.valueOf(obj[3])));
				
				cddp.setOrigen(Integer.valueOf(String.valueOf(obj[5])));
				cddp.setPedido(Integer.valueOf(String.valueOf(obj[6])));
				cddp.setIddescongeladoProceso(Integer.valueOf(String.valueOf(obj[7])));
				cddp.setIdproduccionDetalleLoteCajon(Integer.valueOf(String.valueOf(obj[8])));
				cddp.setHoraIngreso(obtenerStringEnTime(String.valueOf(obj[9])));
				
				listaDDPs.add(cddp);
				
				
			}
			
			
			
			//System.out.println("Mensaje de la consulta realizada--> "+  obj.toString() + " idcajon " + idcajon);
			
			return listaDDPs;
			
	 }
	  
	  public Timestamp obtenerStringEnTime(String f) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
			Timestamp mifecha = null;
			Date fecha = df.parse(f, new ParsePosition(0));
			mifecha =  new Timestamp(fecha.getTime());
		    return mifecha;
		}
	  
	  
	  /**
	   * Se utiliza el siguiente query
	   * 
	   * 
select * from cajon
inner join camara_cajon on cajon.idcajon = camara_cajon.idcajon
inner join produccion_detalle_lote_cajon on camara_cajon.idcamaracajon = produccion_detalle_lote_cajon.idcamaracajon
inner join descongelado_detalle_proceso on produccion_detalle_lote_cajon.idproducciondetallelotecajon = descongelado_detalle_proceso.idproducciondetallelotecajon
inner join produccion_detalle_lote on produccion_detalle_lote.idproducciondetallelote = produccion_detalle_lote_cajon.idproducciondetallelote
inner join especie_talla on especie_talla.idespecietalla = produccion_detalle_lote.idespecietalla
inner join barco_descarga on barco_descarga.idbarcodescarga = produccion_detalle_lote.idbarcodescarga
inner join descongelado_ducha on descongelado_ducha.idducha = descongelado_detalle_proceso.idducha
inner join produccion on produccion.idproduccion = produccion_detalle_lote.idproduccion
where descongelado_detalle_proceso.estado = 2 and produccion.idproduccion = 20
	   * @param idproduccion
	   * @return
	   */
	  public List<CajonDescongeladoDetalleProceso> getCajonesIngresadosVolteado(Long idproduccion) {
		  List<CajonDescongeladoDetalleProceso> listaDDPs = new ArrayList<CajonDescongeladoDetalleProceso>();
			//Muestra la lista de todos los cajons con estado 2
			Query query = em.createQuery("select ddp.iddescongeladodetalleproceso, c.idcajon, ddp.cajonrevolteo, pdl.idlote, et.descripcion, bd.origen, pdl.pedidocamara, dd.idducha from Cajon c " +
					"inner join c.camaraCajons cc " +
					"inner join cc.produccionDetalleLoteCajons pdlc " +
					"inner join pdlc.descongeladoDetalleProcesos ddp " +
					"inner join pdlc.produccionDetalleLote pdl " +
					"inner join pdl.especieTalla et " +
					"inner join pdl.barcoDescarga bd " +
					"inner join ddp.descongeladoDucha dd " +
					"inner join pdl.produccion p " +
					"where ddp.estado=2 and p.idproduccion=:idpro ");
			query.setParameter("idpro",idproduccion);
			
			List<Object[]> listDatos = query.getResultList();
			
			for (Object[] obj : listDatos) {

				CajonDescongeladoDetalleProceso cddp = new CajonDescongeladoDetalleProceso();
				
				if (obj[2]== null) {
					cddp.setCajonRevolteo("");
				} else {
					cddp.setCajonRevolteo(String.valueOf(obj[2]));
				}
				
				if (obj[4] == null) {
					cddp.setDescripcionEspecieTalla("");
				} else {
					cddp.setDescripcionEspecieTalla(String.valueOf(obj[4]));
				}
				
				cddp.setIdCajonDescongelado(Integer.valueOf( String.valueOf(obj[0]) ));
				cddp.setIdCajon( String.valueOf(obj[1]));
				
				cddp.setIdLote(Integer.valueOf(String.valueOf(obj[3])));
				
				cddp.setOrigen(Integer.valueOf(String.valueOf(obj[5])));
				cddp.setPedido(Integer.valueOf(String.valueOf(obj[6])));
				cddp.setIdDucha(Integer.valueOf(String.valueOf(obj[7])));

				listaDDPs.add(cddp);
			}

			return listaDDPs;
			
	 }
	  
	  
	//  select cajon.idcajon from descongelado_detalle_proceso
	//  inner join produccion_detalle_lote_cajon on produccion_detalle_lote_cajon.idproducciondetallelotecajon = descongelado_detalle_proceso.idproducciondetallelotecajon
	//  inner join produccion_detalle_lote on produccion_detalle_lote.idproducciondetallelote = produccion_detalle_lote_cajon.idproducciondetallelote
	//  inner join produccion on produccion.idproduccion = produccion_detalle_lote.idproduccion
	//  inner join camara_cajon on produccion_detalle_lote_cajon.idcamaracajon = camara_cajon.idcamaracajon
	//  inner join cajon on cajon.idcajon = camara_cajon.idcajon
	//  where produccion.estado = 2 and descongelado_detalle_proceso.estado = 2
	  public List<CajonDescongeladoDetalleProceso> getCajonesconProduccion(Long idpro) {
		   List<CajonDescongeladoDetalleProceso> listaDDPs = new ArrayList<CajonDescongeladoDetalleProceso>();
				//Muestra la lista de todos los cajons con estado 1
		   	Query query = em.createQuery("select ddp.iddescongeladodetalleproceso, c.idcajon, ddp.cajonrevolteo, pdl.idlote, et.descripcion, bd.origen, pdl.pedidocamara, dp.iddescongeladoproceso, pdlc.idproducciondetallelotecajon, dd.idducha from Cajon c " +
						"inner join c.camaraCajons cc " +
						"inner join cc.produccionDetalleLoteCajons pdlc " +
						"inner join pdlc.descongeladoDetalleProcesos ddp " +
						"inner join pdlc.produccionDetalleLote pdl " +
						"inner join pdl.especieTalla et " +
						"inner join pdl.barcoDescarga bd " +
						"inner join ddp.descongeladoProceso dp " +
						"inner join ddp.descongeladoDucha dd " +
						"inner join dp.produccion p " +
						"where p.idproduccion= :idproduc and ddp.estado = 2 ");
		   	query.setParameter("idproduc", idpro);

				List<Object[]> listDatos = query.getResultList();

				for (Object[] obj : listDatos) {

					CajonDescongeladoDetalleProceso cddp = new CajonDescongeladoDetalleProceso();
					
					if (obj[4] == null) {
						cddp.setDescripcionEspecieTalla("");
					}
					else{
						cddp.setDescripcionEspecieTalla(String.valueOf(obj[4]));
					}
					
					cddp.setIdCajonDescongelado(Integer.valueOf( String.valueOf(obj[0]) ));
					cddp.setIdCajon( String.valueOf(obj[1]));
					cddp.setCajonRevolteo(String.valueOf(obj[2]));
					cddp.setIdLote(Integer.valueOf(String.valueOf(obj[3])));
					
					cddp.setOrigen(Integer.valueOf(String.valueOf(obj[5])));
					cddp.setPedido(Integer.valueOf(String.valueOf(obj[6])));
					cddp.setIddescongeladoProceso(Integer.valueOf(String.valueOf(obj[7])));
					cddp.setIdproduccionDetalleLoteCajon(Integer.valueOf(String.valueOf(obj[8])));
					cddp.setIdDucha(Integer.valueOf(String.valueOf(obj[9])));
					
					
					
					listaDDPs.add(cddp);
					
				}

				return listaDDPs;
				
		 }
	  
	  //select ddp from DescongeladoDetalleProceso  ddp where ddp.descongeladoProceso. ")
	public DescongeladoDetalleProceso getDescongeladoDetalleProceso(Long iddescongeladoProceso) {
		DescongeladoDetalleProceso ddp = new DescongeladoDetalleProceso();
		Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
				"inner join ddp.descongeladoProceso dp " +
				"where dp.iddescongeladoproceso = :parametro ");
		
		query.setParameter("parametro", iddescongeladoProceso);
		ddp = (DescongeladoDetalleProceso) query.getSingleResult();
		return ddp;
		
	}	  
	  
	public DescongeladoDetalleProceso getDescongeladoCajon(Long iddescongeladoDetalleProceso) {
		DescongeladoDetalleProceso ddp = new DescongeladoDetalleProceso();
		Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
				"where ddp.iddescongeladodetalleproceso = :parametro ");
		
		query.setParameter("parametro", iddescongeladoDetalleProceso);
		ddp = (DescongeladoDetalleProceso) query.getSingleResult();
		return ddp;
		
	}	  

	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDucha> getDuchas() {
		return em.createQuery("select d from DescongeladoDucha d order by d.descripcion")
				.getResultList();
	}


	
	
	
	  public void guardarDescongeladoDetallProceso(DescongeladoDetalleProceso detalleDP, DescongeladoProceso cabeceraDP )
	  {
		  	EntityManagerFactory emf  = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			Long i;

			try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
				t.begin();  

				//i = cabeceraDP.getIddescongeladoproceso();
				//System.out.println("iddescongeladoproceso --> " + i);
				detalleDP.setDescongeladoProceso(cabeceraDP);
				//cabeceraDP.setIddescongeladoproceso(i);
				em.merge(detalleDP);
		        t.commit();
	   		  } finally {
	   		    if (t.isActive()) t.rollback();
	   		  }
				}finally{
					em.close();
			  }
	  	}
	  
	  public void actualizarDescongeladoDetalle(DescongeladoDetalleProceso descongeladoDetalleProceso , Long id){
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			DescongeladoDucha dd = new DescongeladoDucha();
			
			System.out.println("Antes de idducha ");
			dd.setIdducha(descongeladoDetalleProceso.getDescongeladoDucha().getIdducha());
			System.out.println("Valor de idducha " +dd.getIdducha());
			
			try {
					t.begin();
					
					DescongeladoDetalleProceso miObjeto = em.find(DescongeladoDetalleProceso.class, id);
					
					System.out.println("descongelado" + descongeladoDetalleProceso.getDescongeladoDucha());
					
					miObjeto.setEstado(descongeladoDetalleProceso.getEstado());
					miObjeto.setHorainicio(descongeladoDetalleProceso.getHorainicio());
					miObjeto.setDescongeladoDucha(dd);
					miObjeto.setObservaciones(descongeladoDetalleProceso.getObservaciones());
					t.commit();
			} catch (RuntimeException e) {
				if (t.isActive()){   
					t.rollback();
				}	 
			}
			finally {
				em.close();
			}
			 
	}
	  
	  public void actualizarDescongeladoDetalle2(DescongeladoDetalleProceso descongeladoDetalleProceso , Long id){
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			
			DescongeladoDetalleProceso ddp = new DescongeladoDetalleProceso();
			ddp.setIddescongeladodetalleproceso(id);
			ddp.setEstado(descongeladoDetalleProceso.getEstado());
			ddp.setHorainicio(descongeladoDetalleProceso.getHorainicio());
			ddp.setDescongeladoDucha(descongeladoDetalleProceso.getDescongeladoDucha());
			ddp.setObservaciones(descongeladoDetalleProceso.getObservaciones());
			ddp.setDescongeladoProceso(descongeladoDetalleProceso.getDescongeladoProceso());
			ddp.setProduccionDetalleLoteCajon(descongeladoDetalleProceso.getProduccionDetalleLoteCajon());
			ddp.setHoraingreso(descongeladoDetalleProceso.getHoraingreso());
			
			try {
					t.begin();
					//DescongeladoDetalleProceso miObjeto = em.find(DescongeladoDetalleProceso.class, id);
					em.merge(ddp);
					t.commit();
					System.out.println("datos actualzados");
			} catch (RuntimeException e) {
				if (t.isActive()){   
					t.rollback();
				}	 
			}
			finally {
				em.close();
			}
			 
	} 
	  
	  
	  public void actualizarDescongeladoDetalleSalidaDescongelado(DescongeladoDetalleProceso descongeladoDetalleProceso , Long id){
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			DescongeladoDucha dd = new DescongeladoDucha();
			//dd.setIdducha(descongeladoDetalleProceso.getDescongeladoDucha().getIdducha());
			
			try {
					t.begin();
					
					DescongeladoDetalleProceso miObjeto = em.find(DescongeladoDetalleProceso.class, id);
					
					System.out.println("descongelado" + descongeladoDetalleProceso.getDescongeladoDucha());
					
					miObjeto.setEstado(descongeladoDetalleProceso.getEstado());
					miObjeto.setHorafin(descongeladoDetalleProceso.getHorafin());
					
					t.commit();
			} catch (RuntimeException e) {
				if (t.isActive()){   
					t.rollback();
				}	 
			}
			finally {
				em.close();
			}
			 
	}
	  
	  public void actualizarDescongeladoDetalleCajonRevolteo(DescongeladoDetalleProceso descongeladoDetalleProceso , Long id){
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			DescongeladoDucha dd = new DescongeladoDucha();
			//dd.setIdducha(descongeladoDetalleProceso.getDescongeladoDucha().getIdducha());
			
			try {
					t.begin();
					
					DescongeladoDetalleProceso miObjeto = em.find(DescongeladoDetalleProceso.class, id);
					
					System.out.println("descongelado" + descongeladoDetalleProceso.getDescongeladoDucha());
					
					miObjeto.setCajonrevolteo(descongeladoDetalleProceso.getCajonrevolteo());
					
					t.commit();
			} catch (RuntimeException e) {
				if (t.isActive()){   
					t.rollback();
				}	 
			}
			finally {
				em.close();
			}
			 
	}
	  
	@Override
	public void saveOrUpdate(
			DescongeladoDetalleProceso descongeladoDetalleProceso) {
		try {
			
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			
			//EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(descongeladoDetalleProceso);
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
	public void saveOrUpdateContraloria(DescongeladoDetalleProcesoContraloria descongeladoDetalleProcesoContraloria) {
		try {
			
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();
			
			//EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(descongeladoDetalleProcesoContraloria);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}	

	public List<DescongeladoDetalleProceso> getListadoCajones(Long idprod, Integer idtur)
	{
		List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

		Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
				"where " +
				"ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
				"ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
				"order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon asc");
	//"ddp.turno.idturno = :idturn ");
		query.setParameter("idproduc", idprod);
		query.setParameter("idturn", idtur);
		lista = query.getResultList();
		return lista;
	}

    public List<DescongeladoDetalleProceso> ListaCajonesParaDevolucionDesdeProduccion(Long idprod, Integer idtur)
    {
           List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

           Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
                         "where ddp.estado in (3) and " +
                         //"where ddp.produccionDetalleLoteCajon.camaraCajon.estado in (4) and " +
                         "ddp.descongeladoProceso.produccion.idproduccion = :idproduc and " +
                         "ddp.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn " +
                         "order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
           
           query.setParameter("idproduc", idprod);
           query.setParameter("idturn", idtur);
           
           lista = query.getResultList();
           
           return lista;
           
    }             

    
    
    public List<DescongeladoDetalleProceso> ListaCajonesReceptadosEnDescongelado()
    {
           List<DescongeladoDetalleProceso> lista = new ArrayList<DescongeladoDetalleProceso>();

           Query query = em.createQuery("select ddp from DescongeladoDetalleProceso ddp " +
                         "where ddp.horainicio IS NULL or ddp.horafin IS NULL " +
                         "order by ddp.produccionDetalleLoteCajon.camaraCajon.cajon.idcajon ");
           
           lista = query.getResultList();
           
           return lista;
           
    }    
    
    
    
    
	//nuevo
	public List<DescongeladoDetalleProcesoFinForzado> ListaCajonesFinProcesoForzadoDetalle(Long id)
	{
		List<DescongeladoDetalleProcesoFinForzado> lista = new ArrayList<DescongeladoDetalleProcesoFinForzado>();

		Query query = em.createQuery("select ddp from DescongeladoDetalleProcesoFinForzado ddp " +
				"where ddp.descongeladoDetalleProceso.iddescongeladodetalleproceso = :id and ddp.horafinforzado IS NULL  and ddp.horafin IS NOT NULL " +
				"order by ddp.iddescongeladodetalleprocesofinforzado desc");
		
		query.setParameter("id", id);
		lista = query.getResultList();
		
		return lista;
		
	}
	
	//NUEVO 10-05-2016 AGREGAR
	public List<DescongeladoDetalleProcesoFinForzado> ListaCajonesFinProcesoForzadoDetalleMov(Long id)
	{
		List<DescongeladoDetalleProcesoFinForzado> lista = new ArrayList<DescongeladoDetalleProcesoFinForzado>();

		Query query = em.createQuery("select ddp from DescongeladoDetalleProcesoFinForzado ddp " +
				"where ddp.descongeladoDetalleProceso.iddescongeladodetalleproceso = :id  " +
				"order by ddp.iddescongeladodetalleprocesofinforzado desc");
		
		query.setParameter("id", id);
		lista = query.getResultList();
		
		return lista;
		
	}	
	
	
	
	//NUEVO 10-05-2016 AGREGAR
	public List<DescongeladoDetalleProcesoFinForzado> ListaCajonesFinProcesoForzadoDetalleFin(Long id)
	{
		List<DescongeladoDetalleProcesoFinForzado> lista = new ArrayList<DescongeladoDetalleProcesoFinForzado>();

		Query query = em.createQuery("select ddp from DescongeladoDetalleProcesoFinForzado ddp " +
				"where ddp.descongeladoDetalleProceso.iddescongeladodetalleproceso = :id and ddp.horafinforzado IS NULL  and ddp.horafin IS NOT NULL " +
				"order by ddp.iddescongeladodetalleprocesofinforzado desc");
		
		query.setParameter("id", id);
		lista = query.getResultList();
		
		return lista;
		
	}	

    public List<DescongeladoDetalleProcesoFinForzado> ListaCajonesFinProcesoForzadoDetalle1(Long id)
    {
          List<DescongeladoDetalleProcesoFinForzado> lista = new ArrayList<DescongeladoDetalleProcesoFinForzado>();

          Query query = em.createQuery("select ddp from DescongeladoDetalleProcesoFinForzado ddp " +
                        "where ddp.descongeladoDetalleProceso.iddescongeladodetalleproceso = :id and ddp.horafinforzado IS NULL  and ddp.horafin IS NULL " +
                        "order by ddp.iddescongeladodetalleprocesofinforzado desc");
          
          query.setParameter("id", id);
          lista = query.getResultList();
          
          return lista;
          
    }
	
	
}
