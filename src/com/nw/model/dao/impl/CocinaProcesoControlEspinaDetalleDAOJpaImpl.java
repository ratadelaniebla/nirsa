package com.nw.model.dao.impl;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
//import java.util.Collections;
import org.zkoss.zk.ui.Sessions;

//import com.nw.model.CocinaProcesoControlEspina;
import com.nw.model.CocinaProcesoControlEspinaDetalle;
//import java.util.Comparator;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoCuba;
import com.nw.model.CocinaAperturaCierreDetalle;
//import com.nw.model.CocinaProcesoControlEspinaDetalle;
import com.nw.model.CocinaProcesoTipoTemperatura;
import com.nw.model.CuartoChillroomCocinadaDetalle;
import com.nw.model.RociadoCicloDetalle;
import com.nw.model.RociadoCocinadaDetalle;
import com.nw.model.Usuario;
import com.nw.model.dao.CocinaProcesoControlEspinaDetalleDAO;
import com.nw.temp.model.CocinaProcesoControlEspinaDetalleEstado;
import com.nw.temp.model.CuartoChillroomCocinadaDetalleEstado;
import com.nw.temp.model.CuartoChillroomCocinadaDetalleEstadoEliminado;
import com.nw.temp.model.RociadoCicloDetalleEstado;
import com.nw.temp.model.RociadoCicloDetalleEstadoEliminado;
import com.nw.temp.model.RociadoCocinadaDetalleEstado;
import com.nw.temp.model.RociadoCocinadaDetalleEstadoEliminado;
import com.nw.util.Sistema;


@SuppressWarnings("unchecked")
public class CocinaProcesoControlEspinaDetalleDAOJpaImpl extends BaseDaoJpaImpl implements CocinaProcesoControlEspinaDetalleDAO {

	//BarcoCubaDAO
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public CocinaProcesoControlEspinaDetalleDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public BarcoCuba getFindBarcobyId(Long long1) {
		return em.find(BarcoCuba.class, long1);	
	}	    

	public BarcoCuba getFindBarcoCubaId(Integer vid) {
		return em.find(BarcoCuba.class, vid);	
	}


	
    public List<CocinaProcesoControlEspinaDetalle> CocinaProcesoControlEspinaDetalle(Long id) {
		return em.createQuery("select b from CocinaProcesoControlEspinaDetalle b WHERE b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"  + id.toString() + "' ").getResultList();
	}
	
    public List<BarcoCuba> getBarcosCubas(Integer id) {
		return em.createQuery("select b from BarcoCuba b WHERE b.barco.idbarco = '"  + id.toString() + "' ").getResultList();
	}

    
    //Cubas aprobas para descargar (1) y cubas en proceso de descarga (2)
    public List<BarcoCuba> getBarcosCubasAprobadasParaDescarga(Integer id, Long long1) {
		return em.createQuery("select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = '"  + id.toString() + "' and b.idbarcocuba = bec.idbarcocuba and bec.barcoDescarga.idbarcodescarga = '"  + long1.toString() + "' and bec.estadodescargacuba in (1,2)").getResultList();
	}  
 
    		
    public List<BarcoCuba> getBarcosCubasTraladadasParaDescargaPorVolqueta(String id, String idvolqueta) {		
    	System.out.println("Ide barco :"+id);
	  //return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.barco.idbarco = '"  + id + "' and b.idbarcocuba = cam.barcoEstibaCuba.idbarcocuba and cam.volqueta.idvolqueta = '"  + idvolqueta + "' and cam.banda.idbanda is null").getResultList();
    	 
		//return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.barco.idbarco = '"  + id + "' and b.idbarcocuba = cam.barcoEstibaCuba.idbarcocuba and cam.volqueta.idvolqueta = '"  + idvolqueta + "' and cam.banda is null").getResultList();
    	return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE cam.banda  is not  null").getResultList();
    	
		//                     select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.idbarcocuba = '"  + "22" + "' and cam.barcoDescarga.idbarcodescarga = '"  + "22" + "' and cam.banda.idbanda is null "' and cam.barcoDescarga.idbarcodescarga = '"  + "3" + "'"
    	//return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.idbarcocuba = '"  + "22" + "' and cam.barcoDescarga.idbarcodescarga = '"  + "1" + "' and cam.banda.idbanda is null  and cam.volqueta.idvolqueta = '"  + "3" + "'").getResultList();
    	//return em.createQuery("select b from BarcoCuba b, CamaraDetalleBanda cam WHERE b.idbarcocuba = 22 and cam.barcoDescarga.idbarcodescarga = 1 and cam.volqueta.idvolqueta = 3").getResultList();
	}     
    
    //select b from BarcoCuba b, BarcoEstibaCuba bec WHERE b.barco.idbarco = 10 and b.idbarcocuba = bec.idbarcocuba and  bec.estadodescargacuba = 1
    
//	@Override
//	public List<BarcoCuba> getBarcosCubas() {
//		// TODO Auto-generated method stub
//		return null;
//	}

    public List<BarcoCuba> getBarcosCubasPorBarco(Integer id) {
    	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		//EntityTransaction t = em.getTransaction();
		
		List<BarcoCuba> barcoCubas = new ArrayList<BarcoCuba>();
		
			 Query query = em.createQuery("select b from BarcoCuba b WHERE b.barco.idbarco = :idbarco");
			 query.setParameter("idbarco", id);
		
		 barcoCubas = query.getResultList();
			 
		 return  barcoCubas;
	}
    
    public BarcoCuba getBarcoCuba(Long id){
		BarcoCuba cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoCuba b where b.idbarcocuba=:idbc");
    		qry.setParameter("idbc", id);
    		cuba = (BarcoCuba) qry.getSingleResult(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }
    
    public BarcoCuba getBarcoCubaporIdcuba(Integer id){
		BarcoCuba cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoCuba b where b.cuba.idcuba=:idc");
    		qry.setParameter("idc", id);
    		cuba = (BarcoCuba) qry.getSingleResult(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }
    

  /**
	 * Guarda o Edita un listado barcoCubaEstados
	 * @param barcoCubaEstados
	 */
	public void saveOrUpdateCocinaProcesoControlEspinaDetalleEstado(List<CocinaProcesoControlEspinaDetalleEstado> cocinaProcesoControlEspinaDetalleEstados, CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle, CocinaProcesoTipoTemperatura cocinaProcesoTipoTemperatura) 
	{

		Usuario usu = new Usuario();
		String usuario = (String) Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);

		
		
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			 t.begin();
			 
			for (CocinaProcesoControlEspinaDetalleEstado rde : cocinaProcesoControlEspinaDetalleEstados) {
			
				rde.getCocinaProcesoControlEspinaDetalle().setUsuario(usu);
				rde.getCocinaProcesoControlEspinaDetalle().setFechareg(new java.sql.Timestamp(new Date().getTime()));
				rde.getCocinaProcesoControlEspinaDetalle().setCocinaAperturaCierreDetalle(cocinaAperturaCierreDetalle);
				rde.getCocinaProcesoControlEspinaDetalle().setCocinaProcesoTipoTemperatura(cocinaProcesoTipoTemperatura);

				if (rde.isEstadoEspina()) // si es true guarda 
				{
					em.merge(rde.getCocinaProcesoControlEspinaDetalle());
					
				} 
				else// si es false modifica 
				{
					em.merge(rde.getCocinaProcesoControlEspinaDetalle());
				}

			}
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}   
	
    
    //////////////
    //17-02-2015//
	//////////////
    /**
	 * Elimina un Objeto CocinaProcesoControlEspinaDetalle y devuelve un entero: 0-exito ; 1-exeption
	 * @param barcoCuba
	 * @return 0 or 1
	 */
	public int delete(CocinaProcesoControlEspinaDetalle  cocinaProcesoControlEspinaDetalle) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
         int r= 0;
         Long id = cocinaProcesoControlEspinaDetalle.getIdcocinaprocesocontrolespinadetalle();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			 Query query = em.createQuery("Delete from CocinaProcesoControlEspinaDetalle where idcocinaprocesocontrolespinadetalle = :idbc");
			 query.setParameter("idbc", id);
			 query.executeUpdate();
		 	 t.commit();
		 	 r = 0;
			 
		} catch (RuntimeException e) {   
			if (t.isActive()) {
				t.rollback();
			}
		    
			r = 1;
		} finally {
			em.close();
		}
		return r;
		 
	}


	
	
    public List<CocinaProcesoControlEspinaDetalle> CocinaProcesoControlEspinaDetalle(Long id, Integer idtipo) 
    {
		return em.createQuery("select b from CocinaProcesoControlEspinaDetalle b WHERE b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"  + id.toString() + "' and b.cocinaProcesoTipoTemperatura.idcocinaprocesotipotemperatura  = '"  + idtipo.toString() + "'order by b.cocinaProcesoControlEspina.numeroespina ").getResultList();
	}


    public List<RociadoCicloDetalle> RociadoCicloDetallebyID(Long id) 
    {
		return em.createQuery("select b from RociadoCicloDetalle b WHERE b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"  + id.toString() + "' order by b.fechareg").getResultList();
	}
    


    
/*++++++++++++++*/    

    public List<RociadoCocinadaDetalle> RociadoCocinadaDetallebyID(Long id) 
    {
		return em.createQuery("select b from RociadoCocinadaDetalle b WHERE b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"  + id.toString() + "' order by b.fechareg").getResultList();
	}    


    public List<CuartoChillroomCocinadaDetalle> CuartoCocinadaDetallebyID(Long id) 
    {
		return em.createQuery("select b from CuartoChillroomCocinadaDetalle b WHERE b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"  + id.toString() + "' order by b.fechareg").getResultList();
	}    
    

	public void saveOrUpdateRociadoCicloDetalleEstado(List<RociadoCicloDetalleEstado> rociadoCicloDetalleEstados) 
	{
		Usuario usu = new Usuario();
		String usuario = (String) Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);

		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			 t.begin();
			int index = 0; 
			for (RociadoCicloDetalleEstado rde : rociadoCicloDetalleEstados) 
			{
				rde = rociadoCicloDetalleEstados.get(index);
//				Long e = rde.getRociadoCicloDetalle().getEvisceradoDetalleProceso().getIdevisceradodetalleproceso(); 
//				Long c = rde.getRociadoCicloDetalle().getCocinaAperturaCierreDetalle().getIdcocinaaperturacierredetalle();					
//				RociadoCicloDetalle r = getValidarRegRociadoCicloDetalle(e, c);	
				rde.getRociadoCicloDetalle().setFechareg(new java.sql.Timestamp(new Date().getTime()));
				
				//Es Eliminar
				if (rde.isEliminar() == true)  
				{
					//El objeto a eliminar de la lista si existe en la base de datos
					if (rde.getRociadoCicloDetalle().getIdrociadocliclodetalle() != null)
					{
						//El objeto si existe en la base de datos y debe ser aliminado
						//Capturamos el registro de la base de datos
						RociadoCicloDetalle o = (RociadoCicloDetalle) em.find(RociadoCicloDetalle.class, rde.getRociadoCicloDetalle().getIdrociadocliclodetalle());
						//Lo Eliminamos
						em.remove(o);	
					}
				} 
				//Graba/Modifica
				else  
				{
					em.merge(rde.getRociadoCicloDetalle());
				}
				
				
				index = index + 1;	

			}
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}    






	public void saveOrUpdateRociadoCocinadaDetalleEstado(List<RociadoCocinadaDetalleEstado> rociadoCocinadaDetalleEstados) 
	{
		Usuario usu = new Usuario();
		String usuario = (String) Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);

		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			 t.begin();
			int index = 0; 
			for (RociadoCocinadaDetalleEstado rde : rociadoCocinadaDetalleEstados) 
			{
				rde = rociadoCocinadaDetalleEstados.get(index);
//				Long e = rde.getRociadoCicloDetalle().getEvisceradoDetalleProceso().getIdevisceradodetalleproceso(); 
//				Long c = rde.getRociadoCicloDetalle().getCocinaAperturaCierreDetalle().getIdcocinaaperturacierredetalle();					
//				RociadoCicloDetalle r = getValidarRegRociadoCicloDetalle(e, c);	
				rde.getRociadoCocinadaDetalle().setFechareg(new java.sql.Timestamp(new Date().getTime()));
				
				//Es Eliminar
				if (rde.isEliminar() == true)  
				{
					//El objeto a eliminar de la lista si existe en la base de datos
					if (rde.getRociadoCocinadaDetalle().getIdrociadococinadadetalle() != null)					
					{
						//El objeto si existe en la base de datos y debe ser aliminado
						//Capturamos el registro de la base de datos
						RociadoCocinadaDetalle o = (RociadoCocinadaDetalle) em.find(RociadoCocinadaDetalle.class, rde.getRociadoCocinadaDetalle().getIdrociadococinadadetalle());
						//Lo Eliminamos
						em.remove(o);	
					}
				} 
				//Graba/Modifica
				else  
				{
					em.merge(rde.getRociadoCocinadaDetalle());
				}
				
				index = index + 1;	
			}
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}	



	
	public void saveOrUpdateCuartoChillroomCocinadaDetalleEstado(List<CuartoChillroomCocinadaDetalleEstado> cuartoChillroomCocinadaDetalleEstados) 
	{
		Usuario usu = new Usuario();
		String usuario = (String) Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);

		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			 t.begin();
			int index = 0; 
			for (CuartoChillroomCocinadaDetalleEstado rde : cuartoChillroomCocinadaDetalleEstados) 
			{
				rde = cuartoChillroomCocinadaDetalleEstados.get(index);
//				Long e = rde.getRociadoCicloDetalle().getEvisceradoDetalleProceso().getIdevisceradodetalleproceso(); 
//				Long c = rde.getRociadoCicloDetalle().getCocinaAperturaCierreDetalle().getIdcocinaaperturacierredetalle();					
//				RociadoCicloDetalle r = getValidarRegRociadoCicloDetalle(e, c);	
				rde.getCuartoChillroomCocinadaDetalle().setFechareg(new java.sql.Timestamp(new Date().getTime()));
				
				//Es Eliminar
				if (rde.isEliminar() == true)  
				{
					//El objeto a eliminar de la lista si existe en la base de datos
					if (rde.getCuartoChillroomCocinadaDetalle().getIdcuartochillroomcocinadadetalle() != null)					
					{
						//El objeto si existe en la base de datos y debe ser aliminado
						//Capturamos el registro de la base de datos
						CuartoChillroomCocinadaDetalle o = (CuartoChillroomCocinadaDetalle) em.find(CuartoChillroomCocinadaDetalle.class, rde.getCuartoChillroomCocinadaDetalle().getIdcuartochillroomcocinadadetalle());
						//Lo Eliminamos
						em.remove(o);	
					}
				} 
				//Graba/Modifica
				else  
				{
					em.merge(rde.getCuartoChillroomCocinadaDetalle());
				}
				
				index = index + 1;	
			}
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}



    public RociadoCicloDetalle getValidarRegRociadoCicloDetalle(Long Idevisceradodetalleproceso, Long Idcocinaaperturacierredetalle)
    {
    	Sistema.mensaje("Funnn");
//    	RociadoCicloDetalle rociadoCicloDetalle = new RociadoCicloDetalle();
//    	try {
//    		Query qry = em.createQuery(" select b from RociadoCicloDetalle b where b.evisceradoDetalleProceso.idevisceradodetalleproceso=:ide and b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle=:idc");
//    		qry.setParameter("ide", Idevisceradodetalleproceso);
//    		qry.setParameter("idc", Idcocinaaperturacierredetalle);
//    		rociadoCicloDetalle = (RociadoCicloDetalle) qry.getSingleResult(); 
//    		return rociadoCicloDetalle;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
		StringBuffer sb = new StringBuffer();
		sb.append("Select b from RociadoCicloDetalle b "); 
		sb.append("From RociadoCicloDetalle b  "); 
		sb.append("Where b.evisceradoDetalleProceso.idevisceradodetalleproceso = '" + Idevisceradodetalleproceso.toString() + "' "); 
		sb.append("and b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '" + Idcocinaaperturacierredetalle.toString() + "' ");

		//logger.info(CalidadSensorialMp.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (RociadoCicloDetalle) items.get(0);
        }
        
    }





	public void saveOrUpdateRociadoCicloDetalleEstadoEliminados(List<RociadoCicloDetalleEstadoEliminado> rociadoCicloDetalleEstadoEliminados) 
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();

				for (RociadoCicloDetalleEstadoEliminado rde : rociadoCicloDetalleEstadoEliminados) 
				{			
					//Es Eliminar
//					if (rde.getRociadoCicloDetalleEstado().isEliminar())  
//					{
						//El objeto a eliminar de la lista si existe en la base de datos
						if (rde.getRociadoCicloDetalleEstado().getRociadoCicloDetalle().getIdrociadocliclodetalle() != null || rde.getRociadoCicloDetalleEstado().getRociadoCicloDetalle() != null)
						{
							//El objeto si existe en la base de datos y debe ser aliminado
							//Capturamos el registro de la base de datos
							RociadoCicloDetalle o = (RociadoCicloDetalle) em.find(RociadoCicloDetalle.class, rde.getRociadoCicloDetalleEstado().getRociadoCicloDetalle().getIdrociadocliclodetalle());
							//Lo Eliminamos
							em.remove(o);	
//						}
					} 
				}
			
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}    


	
	public void saveOrUpdateCuartoChillroomCocinadaDetalleEstadoEliminados(List<CuartoChillroomCocinadaDetalleEstadoEliminado> cuartoChillroomCocinadaDetalleEstadoEliminados)																											   
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();

				for (CuartoChillroomCocinadaDetalleEstadoEliminado rde : cuartoChillroomCocinadaDetalleEstadoEliminados) 
				{			
					//Es Eliminar
//					if (rde.getRociadoCicloDetalleEstado().isEliminar())  
//					{
						//El objeto a eliminar de la lista si existe en la base de datos
																																								   
						if (rde.getCuartoChillroomCocinadaDetalleEstado().getCuartoChillroomCocinadaDetalle().getIdcuartochillroomcocinadadetalle() != null || rde.getCuartoChillroomCocinadaDetalleEstado().getCuartoChillroomCocinadaDetalle() != null)
						{
							//El objeto si existe en la base de datos y debe ser aliminado
							//Capturamos el registro de la base de datos
																																			  
							CuartoChillroomCocinadaDetalle o = (CuartoChillroomCocinadaDetalle) em.find(CuartoChillroomCocinadaDetalle.class, rde.getCuartoChillroomCocinadaDetalleEstado().getCuartoChillroomCocinadaDetalle().getIdcuartochillroomcocinadadetalle());
							//Lo Eliminamos
							em.remove(o);	
//						}
					} 
				}
			
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}	

	

	public void saveOrUpdateRociadoCocinadaDetalleEstadoEliminados(List<RociadoCocinadaDetalleEstadoEliminado> rociadoCocinadaDetalleEstadoEliminados)																											   
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();

				for (RociadoCocinadaDetalleEstadoEliminado rde : rociadoCocinadaDetalleEstadoEliminados) 
				{			
					//Es Eliminar
//					if (rde.getRociadoCicloDetalleEstado().isEliminar())  
//					{
						//El objeto a eliminar de la lista si existe en la base de datos
						if (rde.getRociadoCocinadaDetalleEstado().getRociadoCocinadaDetalle().getIdrociadococinadadetalle() != null || rde.getRociadoCocinadaDetalleEstado().getRociadoCocinadaDetalle() != null)
						{
							//El objeto si existe en la base de datos y debe ser aliminado
							//Capturamos el registro de la base de datos
							RociadoCocinadaDetalle o = (RociadoCocinadaDetalle) em.find(RociadoCocinadaDetalle.class, rde.getRociadoCocinadaDetalleEstado().getRociadoCocinadaDetalle().getIdrociadococinadadetalle());
							//Lo Eliminamos
							em.remove(o);	
//						}
					} 
				}
			
			t.commit();

		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}	



/*++++++++++++++*/	
	
	public int compare(CocinaProcesoControlEspinaDetalle e1,
			CocinaProcesoControlEspinaDetalle e2) {
		if (e2.getCocinaProcesoControlEspina().getNumeroespina().intValue() < e1
				.getCocinaProcesoControlEspina().getNumeroespina().intValue()) {
			return 1;
		}
		return -1;
	}
	
	public List<CocinaProcesoControlEspinaDetalle> CocinaProcesoControlEspinaDetalleAutomatico(
			Long id, Integer idtipo) {
		int r = this.em
				.createQuery(
						"select b from CocinaProcesoControlEspinaDetalle b WHERE b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"
								+ id.toString()
								+ "' and b.cocinaProcesoTipoTemperatura.idcocinaprocesotipotemperatura  = '"
								+ idtipo.toString()
								+ "'order by b.idcocinaprocesocontrolespinadetalle desc, b.cocinaProcesoControlEspina.numeroespina ")
 
				.getResultList().size();
		if (r > 0) {
			List r1 = this.em
					.createQuery(
							"select b from CocinaProcesoControlEspinaDetalle b WHERE b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"
									+ id.toString()
									+ "' and b.cocinaProcesoTipoTemperatura.idcocinaprocesotipotemperatura  = '"
									+ idtipo.toString()
									+ "'order by b.idcocinaprocesocontrolespinadetalle desc, b.cocinaProcesoControlEspina.numeroespina ")
									    
					.getResultList().subList(0, 4);
			
			
			//Collections.sort(r1, new OrdenarTemperaturas(this));
			//Collections.sort(r1);
			
			
			
			return r1;
		}

		return this.em
				.createQuery(
						"select b from CocinaProcesoControlEspinaDetalle b WHERE b.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '"
								+ id.toString()
								+ "' and b.cocinaProcesoTipoTemperatura.idcocinaprocesotipotemperatura  = '"
								+ idtipo.toString()
								+ "'order by b.idcocinaprocesocontrolespinadetalle desc, b.cocinaProcesoControlEspina.numeroespina ")
				.getResultList();
	}	
	
	
}
