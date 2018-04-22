package com.nw.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CoccionDetalleProcesoCoche;
import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.dao.CoccionDetalleProcesoCocheDAO;
import com.nw.temp.model.CoccionRociadoProcesoCoche;
import com.nw.util.Sistema;

public class CoccionDetalleProcesoCocheDAOJpaImpl extends BaseDaoJpaImpl implements CoccionDetalleProcesoCocheDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public CoccionDetalleProcesoCocheDAOJpaImpl()
	{
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	
	
//	SELECT eviscerado_detalle_proceso_coche.idcocheglobal, eviscerado_detalle_proceso_coche.idcoche, eviscerado_detalle_proceso_coche.idcocina, eviscerado_detalle_proceso_coche.canastillas, eviscerado_detalle_proceso_coche.idevisceradopescadoslata, coccion_detalle_proceso_coche.idcocciondetalleprocesocoche 
//	FROM eviscerado_detalle_proceso_coche 
//	inner join coccion_detalle_proceso_coche
//	on eviscerado_detalle_proceso_coche.idevisceradodetalleprocesocoche = coccion_detalle_proceso_coche.evisceradodetalleprocesocoche
//	WHERE eviscerado_detalle_proceso_coche.idcoche = 100
	public CoccionRociadoProcesoCoche ListarCoccionRociadoDetalleProceso(int idcoche)
	{
		CoccionRociadoProcesoCoche cddp = new CoccionRociadoProcesoCoche();
		
		Query qry = em.createQuery("select edpc.idcocheglobal, edpc.idcoche, c.idcocina, edpc.canastillas, epl.idevisceradopescadoslata, t.idturno, cdpc.idcocciondetalleprocesocoche from EvisceradoDetalleProcesoCoche edpc " +
				"inner join edpc.cocina c " +
				"inner join edpc.evisceradoPescadosLata epl " +
				"inner join edpc.turno t " +
				"inner join edpc.coccionDetalleProcesoCoches cdpc " +
				"where edpc.idcoche = :idcoc ");
		qry.setParameter("idcoc", idcoche);
		
		List<Object[]> listaDatos = qry.getResultList();
		
		for (Object[] obj : listaDatos) {
			
			cddp.setIdCocheGlobal(Integer.valueOf( String.valueOf(obj[0]) ));
			cddp.setIdCoche(Integer.valueOf(String.valueOf(obj[1])));
			cddp.setIdCocina(Integer.valueOf(String.valueOf(obj[2])));
			cddp.setCanastillas(Integer.valueOf(String.valueOf(obj[3])));
			cddp.setIdEvisceradopescadoLata(Integer.valueOf(String.valueOf(obj[4])));
			
			cddp.setIdLote(getIdLote(Integer.valueOf(String.valueOf(obj[5])))); //--> Obtiene a traves del metodo getidLote el valor
			
			cddp.setIdCoccionDetalleProcesoCoche(Integer.valueOf(String.valueOf(obj[6]))); 
		}

		return cddp;
	}
	
	
	public List<EvisceradoDetalleProcesoCoche> ListarCoccionDetalleProcesoCoche(int idcoche, Long idprod, Integer idtur )
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();

		
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				"where edpc.idevisceradodetalleprocesocoche = :idcoc and " +
				"edpc.idevisceradodetalleprocesocoche not in (select cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cdpc) and " +
				"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
				"edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
		
		
//		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
//				"where edpc.idevisceradodetalleprocesocoche = :idcoc and edpc.peso > 0 and " +
//				"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
//				"edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
				 
		qry.setParameter("idcoc", idcoche);
		qry.setParameter("idproduc", idprod);
		qry.setParameter("idturn", idtur);
		
		lista =  qry.getResultList();

		return lista;
	}
	
	public List<EvisceradoDetalleProcesoCoche> ListarCoccionDetalleProcesoCocheCoccion(Long idcoche)
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();

		//, Long idprod, Integer idtur 
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				"where edpc.idevisceradodetalleprocesocoche = :idcoc and " +
				"edpc.peso > 0 and " +
				"edpc.idevisceradodetalleprocesocoche not in (select cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cdpc) ");
//				"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and "+
//				"edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
		
		
//		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
//				"where edpc.idevisceradodetalleprocesocoche = :idcoc and edpc.peso > 0 and " +
//				"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
//				"edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
				 
		qry.setParameter("idcoc", idcoche);
//		qry.setParameter("idproduc", idprod);
//		qry.setParameter("idturn", idtur);
		
		lista =  qry.getResultList();

		return lista;
	}	

	
	@SuppressWarnings("unchecked")
	public List<CoccionDetalleProcesoCoche> ListarCoccionDetalleProcesoCoche1(int idcoche, Long idprod, Integer idtur)
	{
		List<CoccionDetalleProcesoCoche> lista = new ArrayList<CoccionDetalleProcesoCoche>();
		
		Query qry = em.createQuery("select cdpc from CoccionDetalleProcesoCoche cdpc " +
				"where cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idcoc and " +
				"cdpc.coccionProceso.produccion.idproduccion = :idproduc and " +
				"cdpc.turno.idturno = :idturn ");
		
		qry.setParameter("idcoc", idcoche);
		qry.setParameter("idproduc", idprod);
		qry.setParameter("idturn", idtur);

		lista =  qry.getResultList();

		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CoccionDetalleProcesoCoche> ListarCoccionDetalleProcesoCoche2(long idcoche, Long idprod, Integer idtur)
	{

		List<CoccionDetalleProcesoCoche> lista = new ArrayList<CoccionDetalleProcesoCoche>();
		
		Query qry = em.createQuery("select coc from CoccionDetalleProcesoCoche coc " +
				"where coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idcoc and " +
				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in (select r.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from RociadoDetalleProcesoCoche r) and " +
				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche in (select cd.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cd) and " +
				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");

		
		
//		Query qry = em.createQuery("select cdpc from CoccionDetalleProcesoCoche cdpc " +
//				"where cdpc.idcocciondetalleprocesocoche = :idcoc and " +				
//				"cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in (select r.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from RociadoDetalleProcesoCoche r) and " +			
//				"cdpc.coccionProceso.produccion.idproduccion = :idproduc and " +
//			    "cdpc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
		
		qry.setParameter("idcoc", idcoche);
		qry.setParameter("idproduc", idprod);
		qry.setParameter("idturn", idtur);

		lista =  qry.getResultList();

		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CoccionDetalleProcesoCoche> ListarCoccionDetalleProcesoCoche3(long idcoche, Long idprod, Integer idtur)
	{

		List<CoccionDetalleProcesoCoche> lista = new ArrayList<CoccionDetalleProcesoCoche>();
		
//		Query qry = em.createQuery("select coc from CoccionDetalleProcesoCoche coc " +
//				"where coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idcoc and " +
//				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in (select r.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from RociadoDetalleProcesoCoche r) and " +
//				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche in (select cd.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cd) and " +
//				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
//				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");

		
		Query qry = em.createQuery("select coc from CoccionDetalleProcesoCoche coc " +
				"where coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idcoc and " +
				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche in (select cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cdpc) and " +
				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in (select rdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from RociadoDetalleProcesoCoche rdpc) and " +
				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");

		
		
//		Query qry = em.createQuery("select cdpc from CoccionDetalleProcesoCoche cdpc " +
//				"where cdpc.idcocciondetalleprocesocoche = :idcoc and " +				
//				"cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in (select r.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from RociadoDetalleProcesoCoche r) and " +			
//				"cdpc.coccionProceso.produccion.idproduccion = :idproduc and " +
//			    "cdpc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
		
		qry.setParameter("idcoc", idcoche);
		qry.setParameter("idproduc", idprod);
		qry.setParameter("idturn", idtur);

		lista =  qry.getResultList();

		return lista;
	}	
	
	
	
	@SuppressWarnings("unchecked")
	public List<CoccionDetalleProcesoCoche> ListarCoccionDetalleProcesoCoche4(long idcoche)
	{
//		, Long idprod, Integer idtur
		List<CoccionDetalleProcesoCoche> lista = new ArrayList<CoccionDetalleProcesoCoche>();
		
		Query qry = em.createQuery("select coc from CoccionDetalleProcesoCoche coc " +
				"where coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idcoc and " +
				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche in (select cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cdpc) and " +
				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in (select rdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from RociadoDetalleProcesoCoche rdpc)");
//				" and " +
//				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
//				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");

		qry.setParameter("idcoc", idcoche);
//		qry.setParameter("idproduc", idprod);
//		qry.setParameter("idturn", idtur);

		lista =  qry.getResultList();

		return lista;
	}	
	
	public List<EvisceradoDetalleProcesoCoche> ListarCoccionDetalleProcesoCocheCoccionbyId(Long idcoche)
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();

		//, Long idprod, Integer idtur 
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				"where edpc.idevisceradodetalleprocesocoche = :idcoc ");
				 
		qry.setParameter("idcoc", idcoche);
		lista =  qry.getResultList();

		return lista;
	}	
	
//	select produccion_detalle_lote.idlote 
//	from produccion_detalle_lote
//	where produccion_detalle_lote.idturno = 'valor'
	public int getIdLote(int idturno){
		Query qry = em.createQuery("select pdl.idlote from ProduccionDetalleLote pdl " +
				"inner join pdl.turno t " +
				"where t.idturno = :tur");
		qry.setParameter("tur", idturno);
		
		return (Integer) qry.getSingleResult();

	}
	
	public void guardarCoccionProcesoCoche (CoccionDetalleProcesoCoche coccionDetalleProcesoCoche)
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(coccionDetalleProcesoCoche);
				
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


	public List<EvisceradoDetalleProcesoCoche> ListarCoccionDetalleProcesoCocheCoccion1(Long idcoche)
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
		// anterior se buscaba por el idevisceradodetalleprocesocoche ahora es por codbarra y estadouso

		//, Long idprod, Integer idtur 
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				"where edpc.codbarra =:idcoc and edpc.estadouso = 1 and " +
				"edpc.peso > 0 " +
				"and edpc.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
				"and edpc.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " +
				"and edpc.idevisceradodetalleprocesocoche not in (select cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cdpc) ");
//				"edpc.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and "+
//				"edpc.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");
		
				 
		qry.setParameter("idcoc", idcoche);
//		qry.setParameter("idproduc", idprod);
//		qry.setParameter("idturn", idtur);
		
		lista =  qry.getResultList();

		return lista;
	}	


	@SuppressWarnings("unchecked")
	public List<CoccionDetalleProcesoCoche> ListarCoccionDetalleProcesoCoche5(long idcoche)
	{
//		, Long idprod, Integer idtur
		List<CoccionDetalleProcesoCoche> lista = new ArrayList<CoccionDetalleProcesoCoche>();
		
		Query qry = em.createQuery("select coc from CoccionDetalleProcesoCoche coc " +
				"where coc.evisceradoDetalleProcesoCoche.codbarra = :idcoc and coc.evisceradoDetalleProcesoCoche.estadouso = 1 " +
				"and coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
				"and coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " +
				"and coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche in (select cdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from CoccionDetalleProcesoCoche cdpc) and " +
				"coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche not in (select rdpc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche from RociadoDetalleProcesoCoche rdpc)");
//				" and " +
//				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.produccion.idproduccion = :idproduc and " +
//				"coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.produccionDetalleLoteCajon.produccionDetalleLote.turno.idturno = :idturn ");

		qry.setParameter("idcoc", idcoche);
//		qry.setParameter("idproduc", idprod);
//		qry.setParameter("idturn", idtur);

		lista =  qry.getResultList();

		return lista;
	}

	public List<EvisceradoDetalleProcesoCoche> ListarCoccionDetalleProcesoCocheCoccionbyId1(Long coche)
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();

		//, Long idprod, Integer idtur 
		Query qry = em.createQuery("select edpc from EvisceradoDetalleProcesoCoche edpc " +
				"where edpc.codbarra = :idcoc order by edpc.idevisceradodetalleprocesocoche desc  ");
				 
		qry.setParameter("idcoc", coche);
		lista =  qry.getResultList().subList(0, 1);

		return lista;
	}	


	
	
	@Override
	public void saveorUpdate(
			CoccionDetalleProcesoCoche coccionDetalleProcesoCoche) {
		// TODO Auto-generated method stub
		
	}
	
	public List<EvisceradoDetalleProcesoCoche> ListarRociadoDetalleProcesoCoche(Long valorCocheCodigoBarra)
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();

		try {
			Query qry = em.createQuery("select c.evisceradoDetalleProcesoCoche from CoccionDetalleProcesoCoche c " +
					" where c.evisceradoDetalleProcesoCoche.codbarra = :idcoc "+
					//" and c.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
					" and c.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " );
		 // "and c.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " +
			qry.setParameter("idcoc", valorCocheCodigoBarra);
			
			lista =  qry.getResultList();

			return lista;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> ListarRociadoDetalleProcesoCoche2(Long idevisceradodetalleprocesocoche)
	{
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		

		Query qry = em.createQuery("select c from CoccionDetalleProcesoCoche c " +
				" where c.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idcoc ");
		qry.setParameter("idcoc", idevisceradodetalleprocesocoche);
			
			lista =  qry.getResultList();
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EvisceradoDetalleProcesoCoche> ListarCDPCoche(long idcoche)
	{
//		, Long idprod, Integer idtur
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
		
		Query qry = em.createQuery("select ev from EvisceradoDetalleProcesoCoche ev " +
				"where ev.codbarra = :idcoc and ev.estadouso = 1 " +
/*HN				"and ev.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
				"and ev.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 ");*/

				"order by ev.idevisceradodetalleprocesocoche desc  ");

		
		qry.setParameter("idcoc", idcoche);
		lista =  qry.getResultList();

		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CoccionDetalleProcesoCoche> ListarCocionDPCoche(long idcoche)
	{
//		, Long idprod, Integer idtur
		List<CoccionDetalleProcesoCoche> lista = new ArrayList<CoccionDetalleProcesoCoche>();
		
/*HN		Query qry = em.createQuery("select coc from CoccionDetalleProcesoCoche coc " +
				"where coc.evisceradoDetalleProcesoCoche.codbarra = :idcoc and coc.evisceradoDetalleProcesoCoche.estadouso = 1 " +
				"and coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
				"and coc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 ");
*/				
		Query qry = em.createQuery("select coc from CoccionDetalleProcesoCoche coc " +
				"where coc.evisceradoDetalleProcesoCoche.codbarra = :idcoc and coc.evisceradoDetalleProcesoCoche.estadouso = 1 " +
				"order by coc.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche desc  ");

		
		qry.setParameter("idcoc", idcoche);
		lista =  qry.getResultList();

		return lista;
	}

	// agregada el 28-11-2014 cocion-rociado
		public CoccionDetalleProcesoCoche getCocionDetalleProcesoCoche(Long idevisceradodetalleprocesocoche)
		{
			EntityManagerFactory emf = JPAPersistenceManager.getInstance()
					.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			
			CoccionDetalleProcesoCoche cdpc = new CoccionDetalleProcesoCoche();
			try {
				Query qry = em.createQuery("select c from CoccionDetalleProcesoCoche c " +
						" where c.evisceradoDetalleProcesoCoche.idevisceradodetalleprocesocoche = :idev " );
				//"and c.ducharociado.idducharociado = :idroc and c.turno.idturno =:idtur
			 
				qry.setParameter("idev", idevisceradodetalleprocesocoche);
				//qry.setParameter("idroc", idrociado);
				//qry.setParameter("idtur", idturno);
				
				cdpc =  (CoccionDetalleProcesoCoche) qry.getSingleResult();
				return cdpc;
				
			} catch (Exception e) {
				return null;
			}
			
		}
		
		@SuppressWarnings("unchecked")
		public EvisceradoDetalleProcesoCoche ListarCDPCocheByCodBarra(long idcoche)
		{
//			, Long idprod, Integer idtur
			//List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
			
			Query qry = em.createQuery("select ev from EvisceradoDetalleProcesoCoche ev " +
					"where ev.codbarra = "+ idcoche +" and ev.estadouso = 1 " +
					"and ev.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.proceso.idproceso = 3 " +
					"and ev.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 order by ev.idevisceradodetalleprocesocoche desc").setFirstResult(0);
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


		public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalleById(Long id)
		{
			StringBuffer sb = new StringBuffer();
			sb.append("Select o "); 
			sb.append("From CocinaAperturaCierreDetalle o "); 
			sb.append("Where o.idcocinaaperturacierredetalle = '" + id.toString().trim() + "'"); 
			
			List items =  em.createQuery(sb.toString()).getResultList();
			
		    if (items == null || items.isEmpty()) {
		        return null;
		    } else {
		        return  (CocinaAperturaCierreDetalle) items.get(0);
		    }	
		}		


		public EvisceradoDetalleProcesoCoche VerificarCocheReceptadoEnCocina11(Long valorCocheCodigoBarra)
		{
			Sistema.mensaje("Paametro :"+valorCocheCodigoBarra.toString());
			EvisceradoDetalleProcesoCoche edpc = new EvisceradoDetalleProcesoCoche();

			try {
				Query qry = em.createQuery("select c from EvisceradoDetalleProcesoCoche c " +
				" where c.codbarra = :idcoc "+
				" and c.evisceradoDetalleProceso.evisceradoProceso.procesoAperturaCierre.estado = 1 " );
				qry.setParameter("idcoc", valorCocheCodigoBarra);
				
				edpc = (EvisceradoDetalleProcesoCoche) qry.getResultList();

				return edpc;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}		
		
	
}
