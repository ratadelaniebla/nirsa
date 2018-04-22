package com.nw.model.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Barco;
import com.nw.model.BarcoDescarga;
import com.nw.model.CajonDetalleMuestreo;
import com.nw.model.dao.BarcoDescargaDAO;

@SuppressWarnings("unchecked")
public class BarcoDescargaDAOJpaImpl extends BaseDaoJpaImpl implements BarcoDescargaDAO {

	
	@PersistenceContext

	private EntityManagerFactory emf;
    private EntityManager em;
    
    public BarcoDescargaDAOJpaImpl(){
//    	emf = Persistence.createEntityManagerFactory("NW");
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }

	public BarcoDescarga getFindBarcoDescargabyId(Long siguienteId) {
		return em.find(BarcoDescarga.class, siguienteId);	
	}	    
   
    
	public List<BarcoDescarga> getBarcosDescarga() {
		return em.createQuery("select b from BarcoDescarga b where b.estado=1 order by b.idbarcodescarga").getResultList();
	}
	
	
	public List<BarcoDescarga> getBarcosDescargaEntreFechasHabiertaCerradas(String f1, String f2) {
		return em.createQuery("select b from BarcoDescarga b where b.fechadescarga >= '"+f1+"' and b.fechadescarga <= '"+f2+"' and  b.estado in (0,1) order by b.idbarcodescarga").getResultList();
	}	

//	public List<BarcoDescarga> getBarcosDescargadosByRegistroNumeroBarco(String numbraco, String registro) {
//		return em.createQuery("select b from BarcoDescarga b where b.barco.numbarco = '" + numbraco + "' and b.registro = '" + registro + "' and  b.estado = 0  order by b.idbarcodescarga").getResultList();
//	}	
	
	public List<BarcoDescarga> getBarcosDescargadosByEntreFechas1(String f1, String f2) {
		return em.createQuery("select b from BarcoDescarga b where b.fechadescarga >= '"+f1+"' and b.fechadescarga <= '"+f2+"' and b.estado = 0  order by b.fechadescarga").getResultList();
	}
	
	public List<Barco> getBarcosDescargadosByEntreFechas(String f1, String f2) {
		return em.createQuery("select distinct(b.barco) from BarcoDescarga b where b.fechadescarga >= '"+f1+"' and b.fechadescarga <= '"+f2+"' and b.estado = 0  order by b.barco.nombre").getResultList();
	}	
	
	public List<Barco> getBarcosDescargadosByEntreFechasEnDescargaDescargados(String f1, String f2) {
		return em.createQuery("select distinct(b.barco) from BarcoDescarga b where b.fechadescarga >= '"+f1+"' and b.fechadescarga <= '"+f2+"' and b.estado in (0,1)  order by b.barco.nombre").getResultList();
	}	
	
	
	public List<Barco> getBarcosDescargadosProcesodeCargaByEntreFechas(String f1, String f2) {
		return em.createQuery("select distinct(b.barco) from BarcoDescarga b where b.fechadescarga >= '"+f1+"' and b.fechadescarga <= '"+f2+"' and b.estado in (1,0)  order by b.barco.nombre").getResultList();
	}	
	
	public List<BarcoDescarga> getBarcosDescargadosByBarcoEntreFechas(Integer idbarco, String f1, String f2) {
		return em.createQuery("select b from BarcoDescarga b where b.barco.idbarco = '"+idbarco.toString()+"'  and b.fechadescarga >= '"+f1+"' and b.fechadescarga <= '"+f2+"' and b.estado = 0  order by b.viaje").getResultList();
	}	
	

	public List<BarcoDescarga> getBarcosDescargadosByBarcoEntreFechasSinImportarEstado(Integer idbarco, String f1, String f2) {
		return em.createQuery("select b from BarcoDescarga b where b.barco.idbarco = '"+idbarco.toString()+"'  and b.fechadescarga >= '"+f1+"' and b.fechadescarga <= '"+f2+"' and b.estado in (0,1)  order by b.viaje").getResultList();
	}
	

	public List<BarcoDescarga> getValidarIdBarcoRegistro(Integer idbarco, String registro) {
		return em.createQuery("select b from BarcoDescarga b where b.barco.idbarco = '"+idbarco.toString()+"'  and b.registro= '"+registro+"'").getResultList();
	}	
	
	public List<BarcoDescarga> getValidarRegistro(String registro) {
		return em.createQuery("select b from BarcoDescarga b where  b.registro= '"+registro+"'").getResultList();
	}	
	//27-07-2013 00:00:00.000 27-09-2013 23:59:59.999
	
	public List<CajonDetalleMuestreo> getListCajonDetalleMuestreoById(String id) {
		return em.createQuery("Select c From CajonDetalleMuestreo c where c.cajonDetalleBarcoDescarga.idcajondetallebarcodescarga = '" + id + "'").getResultList();
	}   	
	/*
	 * Ejemplos de consultas nativas...
	 * 
	Query query = em.createNativeQuery("SELECT * FROM EMPLOYEE", Employee.class);
	List<Employee> result = query.getResultList();

	Query query = em.createNativeQuery("SELECT SYSDATE FROM DUAL");
	Date result = (Date)query.getSingleResult();

	Query query = em.createNativeQuery("SELECT MAX(SALARY), MIN(SALARY) FROM EMPLOYEE");
	List<Object[]> results = query.getResultList();
	int max = results.get(0)[0];
	int min = results.get(0)[1];

	Query query = em.createNativeQuery("DELETE FROM EMPLOYEE");
	int rowCount = query.executeUpdate();
	*/

	@Override
	public void saveOrUpdate(BarcoDescarga barcodescarga) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(barcodescarga);
	 			        t.commit();
    		  }catch (RuntimeException e) {
    				e.printStackTrace();
    				if (t.isActive()){    
    					t.rollback();
    				}	 
    			}
			}finally{
				em.close();
			}
	}
	
	
 	public void saveNative(BarcoDescarga barcodescarga){
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		String sql_conmercante = " INSERT INTO barco_descarga( " +
					"  idbarcodescarga, idbarco, registro, estado, fechadescarga, idordenfabricacion,  " +
					"  viaje, origen, idusuario, fechareg ,   " +
					" idbarcodescargamediotransporte, idbarcodescargalugar , idmercante) " +
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
		
		String sql_sinmercante = " INSERT INTO barco_descarga( " +
					"  idbarcodescarga, idbarco, registro, estado, fechadescarga, idordenfabricacion,  " +
					"  viaje, origen, idusuario, fechareg ,   " +
					" idbarcodescargamediotransporte, idbarcodescargalugar  ) " +
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ); ";

		try {
			t.begin();
			Query query;
				if (barcodescarga.getMercante()!=null) {
					  query = em.createNativeQuery(sql_conmercante);
					  query.setParameter(13, barcodescarga.getMercante().getIdmercante() );
				}else{
					  query = em.createNativeQuery(sql_sinmercante);
				}
			
				    query.setParameter(1, barcodescarga.getIdbarcodescarga() );
			        query.setParameter(2, barcodescarga.getBarco().getIdbarco());
			        query.setParameter(3, barcodescarga.getRegistro().trim());
			        query.setParameter(4, barcodescarga.getEstado() );
			        query.setParameter(5, barcodescarga.getFechadescarga() );
			        query.setParameter(6, barcodescarga.getIdordenfabricacion() );
			        query.setParameter(7, barcodescarga.getViaje() );
			        query.setParameter(8, barcodescarga.getOrigen() );
			        query.setParameter(9, barcodescarga.getUsuario().getIdusuario() );
			        query.setParameter(10, barcodescarga.getFechareg() );
			        query.setParameter(11, barcodescarga.getBarcoDescargaMedioTransporte().getIdbarcodescargamediotransporte());
			        query.setParameter(12, barcodescarga.getBarcoDescargaLugar().getIdbarcodescargalugar() );
			        //query.setParameter(13, barcodescarga.getMercante().getIdmercante() );
		        query.executeUpdate();
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	 
	

 public List<BarcoDescarga> getBarcoDescargaporFecha(Timestamp desde, Timestamp hasta){
		List<BarcoDescarga> cuba;
    	try {
    		Query qry = em.createQuery(" select b from BarcoDescarga b where b.fechadescarga between :desde and :hasta and   b.estado>=0 order by b.idbarcodescarga");
    		qry.setParameter("desde", desde);
    		qry.setParameter("hasta", hasta);
    		cuba = qry.getResultList(); 
    		return cuba;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }
 
 public List<BarcoDescarga> getBarcoDescargaByRegistro(String numeroregistro){
		List<BarcoDescarga> barcosDescargas = new ArrayList<BarcoDescarga>();
 	try {
 		Query qry = em.createQuery(" select b from BarcoDescarga b where b.registro = :reg order by b.idbarcodescarga");
 		qry.setParameter("reg", numeroregistro);
 		barcosDescargas = qry.getResultList(); 
 		return barcosDescargas;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
 	
 }

  public BarcoDescarga consultarRegistro(String para_barco,Long idBarcoD){
	BarcoDescarga barcodescarga =  new BarcoDescarga();
	try{

		Query qry = em.createQuery("Select bd  from BarcoDescarga bd  where bd.registro = :nombre and bd.idbarcodescarga != :idBarcoD");
		
		qry.setParameter("nombre", para_barco);
		qry.setParameter("idBarcoD", idBarcoD);
		barcodescarga = (BarcoDescarga) qry.getSingleResult();

		return barcodescarga;
		}
		catch (RuntimeException e) {

			System.out.println(e.getMessage());
			return null;
		}
  }

	public BarcoDescarga consultarporRegistro(String registro){
		BarcoDescarga barcodescarga =  new BarcoDescarga();
		try{
	
			Query qry = em.createQuery("Select bd  from BarcoDescarga bd  where bd.registro = :reg ");
			
			qry.setParameter("reg", registro);
			barcodescarga = (BarcoDescarga) qry.getSingleResult();
	
			return barcodescarga;
			}
			catch (RuntimeException e) {
	
				System.out.println(e.getMessage());
				return null;
			}
    }

	public List<BarcoDescarga> getBarcoDescargaporFechaTodos(Timestamp desde, Timestamp hasta)
	{
        List<BarcoDescarga> cuba;
        try {
	       Query qry = em.createQuery(" select b from BarcoDescarga b where b.fechadescarga between :desde and :hasta  order by b.idbarcodescarga");
	       qry.setParameter("desde", desde);
	       qry.setParameter("hasta", hasta);
	       cuba = qry.getResultList(); 
	        return cuba;
	        } catch (Exception e) {
	              // TODO: handle exception
	              return null;
        }
    }



}
