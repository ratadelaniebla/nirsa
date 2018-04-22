package com.nw.model.dao.impl;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoDescarga;
import com.nw.model.Cuba;
import com.nw.model.Produccion;
import com.nw.model.ProduccionArchivoCargaLote;
import com.nw.model.ProduccionCargaLote;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.Turno;
import com.nw.model.dao.ProduccionCargaLoteDAO;

public class ProduccionCargaLoteDAOJpaImpl extends BaseDaoJpaImpl implements ProduccionCargaLoteDAO {

	@PersistenceContext
	private EntityManagerFactory emf  ;
	private EntityManager em  ;

	 
	
	public ProduccionCargaLoteDAOJpaImpl() {
		// emf = Persistence.createEntityManagerFactory("NW");
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}


	@Override
	public void saveOrUpdate(ProduccionCargaLote produccionCargaLote) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(produccionCargaLote);//merge
				t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
	}
	
	/**
	 * METODO  PARA GUARDAR EN TABLA PRODCCION ARCHIVO CARGA LOTE 
	 * @param produccionArchivoCargaLote
	 */
	public void guardarProduccionArchivoCargaLote( ProduccionArchivoCargaLote produccionArchivoCargaLote ){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Long idp;
		ProduccionArchivoCargaLote pacl = new ProduccionArchivoCargaLote();
		try {
				t.begin();
				em.merge(produccionArchivoCargaLote);
				
				Query qry = em.createQuery("SELECT MAX(p.idproduccionarchivocargalote) FROM ProduccionArchivoCargaLote p");
			    Object valorMaximoObjeto = qry.getSingleResult();
				idp = (Long.valueOf((Long) valorMaximoObjeto));
				pacl.setIdproduccionarchivocargalote(idp);//cambiar
				
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
	
	// este metodo deberia de guardar en 3 tablas ? 
	public void guardarProduccionCargaLote( ProduccionCargaLote produccionCargaLote  ,  Produccion produccion )  {   
		 
		Long i;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		//produccionCargaLote.setP
		
		try {
				t.begin();
				em.merge(produccionCargaLote);
				 
				
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
	
	public ProduccionArchivoCargaLote guardarCabeceraProduccionArchivoCargaLoteIdMax( ProduccionArchivoCargaLote produccionArchivoCargaLote ){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Long idp;
		ProduccionArchivoCargaLote pacl = new ProduccionArchivoCargaLote();
		try {
				t.begin();
				em.merge(produccionArchivoCargaLote);
				Query qry = em.createQuery("SELECT MAX(p.idproduccionarchivocargalote) FROM ProduccionArchivoCargaLote p");
			    Object valorMaximoObjeto = qry.getSingleResult();
				idp = (Long.valueOf((Long) valorMaximoObjeto));
				pacl.setIdproduccionarchivocargalote(idp); 		
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){  
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		return pacl;//retornamos el ultimo objeto  ingresado
	}
	
	public void actualizarArchivoCargaLote(ProduccionArchivoCargaLote pacl){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
				t.begin();
				
				em.merge(pacl);
				
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
	
	public BarcoDescarga obtenerBarcoDescarga(String registro ){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		BarcoDescarga bdescarga = new BarcoDescarga();
		try {
				t.begin();
				//em.merge(cc); 
				Query qry = em.createQuery("SELECT bd  FROM BarcoDescarga bd where bd.registro = '" + (registro.trim()) + "'");
				bdescarga = (BarcoDescarga) qry.getSingleResult();
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){  
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
		return bdescarga;
	}
	
	
	public Long guardarProduccionDetalleLote(ProduccionDetalleLote pdl){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		ProduccionDetalleLote pdlote = new ProduccionDetalleLote();
		Long idCamaraCaj=null;
		try {
				t.begin();
				em.merge(pdl); 
				Query qry = em.createQuery("select MAX(cc.idproducciondetallelote) from ProduccionDetalleLote  cc ");
					
				int codigo;
				Object valorMaximoObjeto = qry.getSingleResult();
				idCamaraCaj = (Long.valueOf((Long) valorMaximoObjeto));
				
				t.commit();
				
		} catch (RuntimeException e) {
			if (t.isActive()){  
				t.rollback();
				//return idCamaraCaj;
			}	 
		}
		finally {
			em.close();
		}
		return idCamaraCaj;
	}
	
	
	
	public ProduccionArchivoCargaLote consultarid()
	{
		Long idp;
		ProduccionArchivoCargaLote pacl = new ProduccionArchivoCargaLote();
		try {
			
			Query qry = em.createQuery("SELECT MAX(p.idproduccionarchivocargalote) FROM ProduccionArchivoCargaLote p");
		    Object valorMaximoObjeto = qry.getSingleResult();
			idp = (Long.valueOf((Long) valorMaximoObjeto));
			pacl.setIdproduccionarchivocargalote(idp+1); 
			return pacl;	
		} catch (Exception e) {
			// TODO: handle exception
			//Long i =;
			pacl.setIdproduccionarchivocargalote((long)1);
			return pacl;
		}
		
		
		
	}
	public void guardar(ProduccionCargaLote  pcl ){
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				//em.merge(cc); 
				em.createNativeQuery("insert into ...").setParameter(1, pcl.getIdproduccioncargalote()).executeUpdate();
				
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
	
	public Produccion guardarCabeceraProduccionIdMax(Produccion produccion )  {   
		Produccion prod = new Produccion();
		Long i;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(produccion);//merge
				 //obtengo y asigno el ultimo id ingresado en la tabla produccion 
				Query qry = em.createQuery("SELECT MAX(c.idproduccion) FROM Produccion c");
			    Object valorMaximoObjeto = qry.getSingleResult();
				i = (Long.valueOf((Long) valorMaximoObjeto));
				prod.setIdproduccion(i);
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		return prod;//retornamos el ultimo objeto ingresado

	}
	
	public Date obtenerFechaProduccion()
	{
		//Date fecha;
		Query qry = em.createQuery("SELECT MAX(p.fechaproduccion) FROM Produccion p");  
		Object obj = qry.getSingleResult();
	    return (Date)obj;
		
	}
	
	public ProduccionArchivoCargaLote consultarProduccionArchivo(Long para_idProduccion)
	{
		ProduccionArchivoCargaLote loc_pacl = new ProduccionArchivoCargaLote();
		// 
		long idp;
		Query qry = em.createQuery("SELECT pacl FROM ProduccionArchivoCargaLote pacl  where pacl.idproduccionarchivocargalote= :id_produccion ");
		qry.setParameter("id_produccion", para_idProduccion);
		//"select cc.idcamaracajon from CamaraCajon  cc inner join cc.cajon c  where c.idcajon= :id_cajon");
		//SELECT p FROM ProduccionArchivoCargaLote p inner join pcl.ProduccionCargaLote where pcl.= :id_produccion ");
	    Object valorMaximoObjeto = qry.getSingleResult();
		//idp = (Long.valueOf((Long) valorMaximoObjeto));
		loc_pacl=  (ProduccionArchivoCargaLote) valorMaximoObjeto;
				
		return loc_pacl;
	}
	public List<ProduccionCargaLote> consultarProduccionCargalote()
	{
		//ProduccionCargaLote loc_pcl = new ProduccionCargaLote();
		List <ProduccionCargaLote> loc_listapcl = new ArrayList<ProduccionCargaLote>();
		
		
		//Query qry = em.createQuery("SELECT pcl FROM ProduccionCargaLote pcl inner join pcl.produccionArchivoCargaLote palc inner join palc.produccion p where p.idproduccion= :id_produccion and palc.turnoarchivo= :turno ");
		Query qry = em.createQuery("SELECT pcl FROM ProduccionCargaLote pcl " +
						" inner join pcl.produccionArchivoCargaLote palc " +
						" inner join palc.produccion p " +
						" inner join p.limpiezaProcesos lp " +
						" inner join lp.procesoAperturaCierre pac" +
						" where pac.estado= 1 and lp.fechareg<= p.fechaproduccion ");
		//qry.setParameter("id_produccion", para_idProduccion);
		//qry.setParameter("turno", para_turno);
		
		loc_listapcl = qry.getResultList();
	    				
		return loc_listapcl;
	}
	public List<ProduccionDetalleLote> consultarListaProduccionDetallelote(Produccion produccion)
	{
		List <ProduccionDetalleLote> loc_listapdl = new ArrayList<ProduccionDetalleLote>();
		Query qry = em.createQuery("SELECT pcl FROM ProduccionDetalleLote pcl " +
				" inner join pcl.produccion p  where p.estado= 1 and p.idproduccion >= :id_produccion ");
		qry.setParameter("id_produccion", produccion.getIdproduccion());
		loc_listapdl = qry.getResultList();
	    				
		return loc_listapdl;
	}

	public ProduccionArchivoCargaLote consultarIdPorFechaTurno(Produccion produccion, Turno turno)
	{
		Long idp, idprod;
		Integer idturno;
		idprod = produccion.getIdproduccion();
		idturno = turno.getIdturno();
	 
		ProduccionArchivoCargaLote paclmax = new ProduccionArchivoCargaLote();
		try {
 
			Query qry = em.createQuery("SELECT MAX(p.idproduccionarchivocargalote) FROM ProduccionArchivoCargaLote p " +
					" where p.produccion.idproduccion = :idpro and p.turnoarchivo = :idt");
			
			qry.setParameter("idpro", idprod);
			qry.setParameter("idt", idturno);
			
		    Object valorMaximoObjeto = qry.getSingleResult();
			idp = (Long.valueOf((Long) valorMaximoObjeto));
			paclmax.setIdproduccionarchivocargalote(idp); 
			
			return paclmax;	
		} catch (Exception e) {
			//System.out.println("falla->"+e.getMessage());
			//pacl.setIdproduccionarchivocargalote((long)1);
			return null;
		}
	}
	
	//26-08-2014
	@SuppressWarnings({ "unchecked" })
	public List<ProduccionCargaLote> getProduccionCargaloteByIdArchivoCargaLote(ProduccionArchivoCargaLote pacl)
	{
		List <ProduccionCargaLote> produccionCargasLotes = new ArrayList<ProduccionCargaLote>();
		Long idarchivocargalote;
		idarchivocargalote = pacl.getIdproduccionarchivocargalote();
		Query qry = em.createQuery("SELECT pcl FROM ProduccionCargaLote pcl " +
						" where pcl.produccionArchivoCargaLote.idproduccionarchivocargalote = :idarchivocarga " +
						" order by pcl.idlote asc ");
		qry.setParameter("idarchivocarga", idarchivocargalote);
		produccionCargasLotes = qry.getResultList();
	    				
		return produccionCargasLotes;
	}

	public Cuba obtenerCubaporNombre(String nombreCuba)
	{
		Cuba loc_Cuba = new Cuba();
		try {
			Query qry = em.createQuery("SELECT c FROM Cuba c  where c.nombrecuba = :cuba ");
			qry.setParameter("cuba", nombreCuba);
		    loc_Cuba=  (Cuba) qry.getSingleResult();
			return loc_Cuba;
		} catch (Exception e) {
			return null;
		}		
	}	

	public List<ProduccionDetalleLote> consultarListaProduccionDetalleloteProduccionyTurno(Long idprd, Integer turno)
	{
		List <ProduccionDetalleLote> loc_listapdl = new ArrayList<ProduccionDetalleLote>();
		Query qry = em.createQuery("SELECT pcl FROM ProduccionDetalleLote pcl " +
				" inner join pcl.produccion p  where p.estado= 1 and p.idproduccion >= :id_produccion " +
				" and pcl.turno.idturno = :id_turno ");
		qry.setParameter("id_produccion", idprd);
		qry.setParameter("id_turno", turno);
		loc_listapdl = qry.getResultList();
	    				
		return loc_listapdl;
	}	

	public List<ProduccionDetalleLote> consultarListaProduccionDetalleloteByProduccion(Long idprd)
	{
		List <ProduccionDetalleLote> loc_listapdl = new ArrayList<ProduccionDetalleLote>();
		Query qry = em.createQuery("SELECT pcl FROM ProduccionDetalleLote pcl " +
				" inner join pcl.produccion p  where p.estado= 1 and p.idproduccion = :id_produccion ");
		qry.setParameter("id_produccion", idprd);
		loc_listapdl = qry.getResultList();
	    				
		return loc_listapdl;
	}	
	
	public List<ProduccionDetalleLote> consultarListaProduccionDetalleloteProduccionyLote(Long idprd, Integer Lote)
	{
		List <ProduccionDetalleLote> loc_listapdl = new ArrayList<ProduccionDetalleLote>();
		Query qry = em.createQuery("SELECT pcl FROM ProduccionDetalleLote pcl " +
				" inner join pcl.produccion p  where p.estado= 1 and p.idproduccion = :id_produccion " +
				" and pcl.idlote = :id_lote ");
		qry.setParameter("id_produccion", idprd);
		qry.setParameter("id_lote", Lote);
		loc_listapdl = qry.getResultList();
	    				
		return loc_listapdl;
	}
	

	
	//Busca el lote en una de las ultimas producciones activas
	public List<ProduccionDetalleLote> consultarUltimoLote(Integer Lote, Long Idproduccion)
	{
		List <ProduccionDetalleLote> loc_listapdl = new ArrayList<ProduccionDetalleLote>();
		Query qry = em.createQuery("SELECT pcl FROM ProduccionDetalleLote pcl inner join pcl.produccion p  " +
				" where p.idproduccion >= :pIdproduccion and pcl.idlote = :id_lote order by p.fechaproduccion asc ").setFirstResult(0);
		qry.setParameter("pIdproduccion", Idproduccion);
		qry.setParameter("id_lote", Lote);
		loc_listapdl = qry.getResultList();
	    				
		return loc_listapdl;
	}	
	
	
	
	//AGREGAR
	//13-07-2016
	public ProduccionDetalleLote getProduccionDetalleLoteByProduccionDetalleLoteCajonIdRegresh(Long idprd, Integer Lote) 
	{ 

		Query qry = em.createQuery("SELECT pcl FROM ProduccionDetalleLote pcl " +
				" inner join pcl.produccion p  where p.estado= 1 and p.idproduccion = '" + idprd.toString()+ "'" +
				" and pcl.idlote = '" + Lote.toString()+ "'").setFirstResult(0);	
		
		
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
	       return (ProduccionDetalleLote) lista;
	}	

	
	
	
	public ProduccionDetalleLote getProduccionDetalleLoteByIdRegresh(Long idprdlot) 
	{ 

		Query qry = em.createQuery("SELECT pcl FROM ProduccionDetalleLote pcl " +
				" where pcl.idproducciondetallelote = '" + idprdlot.toString()+ "'").setFirstResult(0);	
		
		
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
	       return (ProduccionDetalleLote) lista;
	}	
	
	
	
	
	@Override
	public void saveOrUpdateProduccionDetalleLote(ProduccionDetalleLote producciondetallelote) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(producciondetallelote);//merge
				t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
	}	
	
	
    public void DesactivarLotesNoAfectados (Long idprd, Integer turno) 
    {
    		
    	        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OpenJPASample");
    			EntityManagerFactory entityManagerFactory = JPAPersistenceManager.getInstance().getEntityManagerFactory();
    	        EntityManager entityManager = entityManagerFactory.createEntityManager();

//    			EntityManagerFactory entityManagerFactory = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//    			EntityManager entityManager = emf.createEntityManager();
    	        
    	        if (null != entityManager) {
    		
    	            EntityTransaction updateTransaction = entityManager.getTransaction();
    		
    	            updateTransaction.begin();
    	            
    	            Query query = entityManager.createQuery("update ProduccionDetalleLote pdl SET pdl.estado = 0 "
    	            		+ "WHERE pdl.produccion.idproduccion ='"+ String.valueOf(idprd) +"' " +
    	            		  "and pdl.turno.idturno = '"+ String.valueOf(turno) +"'"+
    	            		  "and pdl.estado = 1");
    	            
    	            
//    	            query.setParameter("idp", idprd);
//    	            query.setParameter("idt", turno);
    		
    	            int updateCount = 0;
					try {
						updateCount = query.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    		
    	            if (updateCount > 0) {
    		
    	                System.out.println("Done...");
    		
    	            }
    		
    	            updateTransaction.commit();
    		
    	        }
    		
    	    }    
	
    public void ActivarLotesAfectados (Long idprd, Integer turno) 
    {
    		
    	        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OpenJPASample");
    			EntityManagerFactory entityManagerFactory = JPAPersistenceManager.getInstance().getEntityManagerFactory();
    	        EntityManager entityManager = entityManagerFactory.createEntityManager();

//    			EntityManagerFactory entityManagerFactory = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//    			EntityManager entityManager = emf.createEntityManager();
    	        
    	        if (null != entityManager) {
    		
    	            EntityTransaction updateTransaction = entityManager.getTransaction();
    		
    	            updateTransaction.begin();
    	            
    	            Query query = entityManager.createQuery("update ProduccionDetalleLote pdl SET pdl.estado = 1 "
    	            		+ "WHERE pdl.produccion.idproduccion ='"+ String.valueOf(idprd) +"' " +
    	            		  "and pdl.turno.idturno = '"+ String.valueOf(turno) +"'"+
    	            		  "and pdl.estado = 2");
    	            
    	            
//    	            query.setParameter("idp", idprd);
//    	            query.setParameter("idt", turno);
    		
    	            int updateCount = 0;
					try {
						updateCount = query.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    		
    	            if (updateCount > 0) {
    		
    	                System.out.println("Done...");
    		
    	            }
    		
    	            updateTransaction.commit();
    		
    	        }
    		
    	    }    

    
    
}
