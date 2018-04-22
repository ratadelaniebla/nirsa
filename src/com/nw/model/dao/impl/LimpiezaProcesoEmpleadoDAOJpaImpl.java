package com.nw.model.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
//import com.nw.model.CalidadDetallePcc;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LimpiezaProcesoEmpleado;
import com.nw.model.LimpiezaProcesoEmpleadoAditoriaMovimiento;
import com.nw.model.Produccion;
import com.nw.model.dao.LimpiezaProcesoDAO;


public class LimpiezaProcesoEmpleadoDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaProcesoDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

        
    public LimpiezaProcesoEmpleadoDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
	   
    }

	@Override
	public LimpiezaProceso getLimpiezaProcesoByProcesoAperturaCierreId(
			Long procesoAperturaCierreId, Long vip) {
		// TODO Auto-generated method stub
		return null;
	}

	//Nuevo 20-01-2017
		public void remove(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
			try{
			   	 EntityTransaction t = em.getTransaction();
			   	 try {
						t.begin();
						LimpiezaProcesoEmpleado o = (LimpiezaProcesoEmpleado) em.find(LimpiezaProcesoEmpleado.class, limpiezaProcesoEmpleado.getIdlimpiezaprocesoempleado());
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
	public LimpiezaProceso getLimpiezaProcesoByProcesoAperturaCierreId(
			Long procesoAperturaCierreId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	public LimpiezaProcesoEmpleado obtenerLpEmpleado(LimpiezaProceso lproceso, Long Idempleado) {
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
					" where ep.limpiezaProceso= :lp and  ep.empleado.idempleado =:idEmp  ");
		
			qry.setParameter("lp", lproceso);
			qry.setParameter("idEmp", Idempleado);
			ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
			
			return ep;
		} catch (Exception e) {
			return null;
		}
		
		
	}

public LimpiezaProcesoEmpleado obtenerDatosEmpleado(LimpiezaProceso lproceso, int linea,int cargo) {
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
					" where ep.limpiezaProceso= :lp and  ep.limpiezaLinea.idlimpiezalinea =:idEmp  and ep.idlimpiezacargo=:idcargo ");
		
			qry.setParameter("lp", lproceso);
			qry.setParameter("idEmp", linea);
			qry.setParameter("idcargo", cargo);
			ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
			
			return ep;
		} catch (Exception e) {
			return null;
		}
		
		
	}

  public LimpiezaProcesoEmpleado obtenerDatosEmpleado1(LimpiezaProceso lproceso, int linea) {
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
					" where ep.limpiezaProceso =:lp and  ep.limpiezaLinea.idlimpiezalinea =:idEmp  ");
		
			qry.setParameter("lp", lproceso);
			qry.setParameter("idEmp", linea);
			ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
			
			return ep;
		} catch (Exception e) {
			return null;
		}
	}



 public LimpiezaProcesoEmpleado obtenerLpEmpleadonuevo(LimpiezaProceso lproceso, Long Idempleado,int cargo) {
    LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
    EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    try {             
          Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
                      " where ep.limpiezaProceso= :lp and  ep.empleado.idempleado =:idEmp  and ep.idlimpiezacargo=:idcargo");
    
          qry.setParameter("lp", lproceso);
          qry.setParameter("idEmp", Idempleado);
          qry.setParameter("idcargo", cargo);
          ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
          
          return ep;
    } catch (Exception e) {
          return null;
    }
    
 }




public LimpiezaProcesoEmpleado obtenerLpEmpleadonuevoActivo(LimpiezaProceso lproceso, Long Idempleado) {
    LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
    EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    try {             
          Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
                      " where ep.limpiezaProceso= :lp and  ep.empleado.idempleado =:idEmp and (ep.estado = 1 or ep.estado is null) ");
    
          qry.setParameter("lp", lproceso);
          qry.setParameter("idEmp", Idempleado);
          ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
          
          return ep;
    } catch (Exception e) {
          return null;
    }
    
    
}




public LimpiezaProcesoEmpleado obtenerLpEmpleadonuevoNoActivo(LimpiezaProceso lproceso, Long Idempleado) {
    LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
    EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    try {             
          Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
                      " where ep.limpiezaProceso= :lp and  ep.empleado.idempleado =:idEmp and (ep.estado = 2 or ep.estado = 3) ");
    
          qry.setParameter("lp", lproceso);
          qry.setParameter("idEmp", Idempleado);
          ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
          
          return ep;
    } catch (Exception e) {
          return null;
    }
    
    
}




public LimpiezaProcesoEmpleado obtenerEstadoLpEmpleado(LimpiezaProceso lproceso, Long Idempleado) {
    LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
    EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    try {             
          Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
                      " where ep.limpiezaProceso= :lp and  ep.empleado.idempleado =:idEmp");
    
          qry.setParameter("lp", lproceso);
          qry.setParameter("idEmp", Idempleado);
          ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
          
          return ep;
    } catch (Exception e) {
          return null;
    }
    
    
}


//	public List<LimpiezaProcesoEmpleado> obtenerEmpleadosxLinea(Long idproduccion, Integer Turno) {
//		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
//		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {			
//			Query qry  = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
//					" where lpe.limpiezaProceso.produccion.idproduccion= :idProd and  lpe.limpiezaProceso.turno.idturno =:idTurn  ");
//		
//			qry.setParameter("idProd", idproduccion);
//			qry.setParameter("idTurn", Turno);
////			ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
//			
//			return qry.getResultList();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//		
//		
//	}
	
	
	public void saveOrUpdate(LimpiezaProcesoEmpleado lpEmpleado) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(lpEmpleado);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}

	
	
	public void saveOrUpdateAuditoria(LimpiezaProcesoEmpleadoAditoriaMovimiento lpaem) {
		EntityManagerFactory emf= JPAPersistenceManager.getInstance().getEntityManagerFactory();
	    EntityManager em = emf.createEntityManager();   
		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(lpaem);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado> obtenerLpEmpleados(LimpiezaProceso lproceso, Long Idempleado) 
	{
		List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
					" where ep.limpiezaProceso= :lp and  ep.empleado.idempleado =:idEmp  ");
		
			qry.setParameter("lp", lproceso);
			qry.setParameter("idEmp", Idempleado);
			ep = qry.getResultList();
			
			return ep;
		} catch (Exception e) {
			return null;
		}
	}	


	
	
	//Nuevo 17-01-2017
	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado> obtenerLpEmpleadoPorLinea(LimpiezaProceso lproceso, Long Idempleado, Integer Idlinea) 
	{
		List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
					" where ep.limpiezaProceso= :lp and  ep.empleado.idempleado =:idEmp  " +
					" and ep.limpiezaLinea.idlimpiezalinea =:pIdlinea");
		
			qry.setParameter("lp", lproceso);
			qry.setParameter("idEmp", Idempleado);
			qry.setParameter("pIdlinea", Idlinea);
			ep = qry.getResultList();
			
			return ep;
		} 
		catch (Exception e) 
		{
			return null;
		}
	}	
	
	
	
	
		
	
	
	


public LimpiezaProcesoEmpleado obtenerLpEmpleadoPorIdlimpiezaprocesoempleado(Long pidlimpiezaprocesoempleado) {
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.idlimpiezaprocesoempleado =:idEmp  ");
	
		qry.setParameter("idEmp", pidlimpiezaprocesoempleado);
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
}





	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado> obtenerLpEmpleadoPuestos(String lproceso, String idlinea) 
	{
		List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
			try {
				Query qry  = em.createQuery("select DISTINCT ep from LimpiezaProcesoEmpleado ep " +
						" where ep.limpiezaProceso.idlimpiezaproceso = :lp and ep.limpiezaLinea.idlimpiezalinea = :pidlinea and (ep.estado is null or ep.estado = 1) " +
						" order by ep.idlimpiezacargo, ep.ubicacion ");
				
				/*
				 select * from limpieza_proceso_empleado
				 where idlimpiezaproceso = 1122 and idlinea = 1 
				 */
				
				qry.setParameter("lp", Long.valueOf(lproceso));
				qry.setParameter("pidlinea", Integer.valueOf(idlinea));
				ep = qry.getResultList();
				
				return ep;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

	}	
	

	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado> obtenerLpEmpleadoPuestosActivosPorLinea(String lproceso, String idlinea) 
	{
		List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
			try {
				Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
						" where ep.limpiezaProceso.idlimpiezaproceso = :lp and ep.limpiezaLinea.idlimpiezalinea = :pidlinea and ep.estado <> 2 " +
						" order by ep.idlimpiezacargo, ep.ubicacion ");
				
				/*
				 select * from limpieza_proceso_empleado
				 where idlimpiezaproceso = 1122 and idlinea = 1 
				 */
				
				qry.setParameter("lp", Long.valueOf(lproceso));
				qry.setParameter("pidlinea", Integer.valueOf(idlinea));
				ep = qry.getResultList();
				
				return ep;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

	}	
	

	//Nuevo
	//24-02-2017
	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado> obtenerListaEmpleadoPuestosActivosPorLinea(String lproceso, String idlinea) 
	{
		List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
				
			try {
				Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
						" where ep.limpiezaProceso.idlimpiezaproceso = :lp and ep.limpiezaLinea.idlimpiezalinea = :pidlinea and ep.estado = 1 " +
						" order by ep.idlimpiezacargo, ep.ubicacion ");
				
				/*
				 select * from limpieza_proceso_empleado
				 where idlimpiezaproceso = 1122 and idlinea = 1 
				 */
				
				qry.setParameter("lp", Long.valueOf(lproceso));
				qry.setParameter("pidlinea", Integer.valueOf(idlinea));
				ep = qry.getResultList();
				
				return ep;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado> obtenerLpEmpleadoPuestosOcupado(String lproceso, String idlinea, String idcargo, String ubicacion) 
	{
		List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			
			//Busca la ubicación en la linea por el estado activo (1)
			try {
				Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
						" where ep.limpiezaProceso.idlimpiezaproceso = :lp and " +
						" ep.limpiezaLinea.idlimpiezalinea = :pidlinea and " +
						" ep.idlimpiezacargo = :pidcargo and " +
						" ep.ubicacion = :pubicacion and " +
						" (ep.estado = 1 or ep.estado is null) " +
						" order by ep.idlimpiezacargo, ep.ubicacion ");
				
				/*
				 select * from limpieza_proceso_empleado
				 where idlimpiezaproceso = 1122 and idlinea = 1 
				 */
				
				qry.setParameter("lp", Long.valueOf(lproceso));
				qry.setParameter("pidlinea", Integer.valueOf(idlinea));
				qry.setParameter("pidcargo", Integer.valueOf(idcargo));
				qry.setParameter("pubicacion", Integer.valueOf(ubicacion));
				
				
				ep = qry.getResultList();
				
				return ep;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

	}	
	
	
	public LimpiezaProcesoEmpleado obtenerLpEmpleadoLineaCargo(String idEmpleado, String pIdlimpiezaproceso, String pidcargo) 
	{
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		try {			
			Query qry  = em.createQuery("select ep from " +
					" LimpiezaProcesoEmpleado ep " +
					" where ep.empleado.idempleado =:idEmp and " +
					" ep.limpiezaProceso.idlimpiezaproceso =:pIdlimpiezaproceso and " +
					" ep.idlimpiezacargo = :pidcargo " +
					" order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
		
			qry.setParameter("idEmp", idEmpleado.trim());
			qry.setParameter("pIdlimpiezaproceso", Long.valueOf(pIdlimpiezaproceso));
			qry.setParameter("pidcargo", Integer.valueOf(pidcargo));
			ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
			
			return ep;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

	
	//Nuevo 24-01-2017
	public LimpiezaProcesoEmpleado obtenerLpEmpleadoLineaCargoReg(String idEmpleado, String pIdlimpiezaproceso, String pidcargo) 
	{
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		try {			
			Query qry  = em.createQuery("select ep from " +
					" LimpiezaProcesoEmpleado ep " +
					" where ep.empleado.idempleado =:idEmp and " +
					" ep.limpiezaProceso.idlimpiezaproceso =:pIdlimpiezaproceso and " +
					" ep.idlimpiezacargo = :pidcargo " +
					" order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
		
			qry.setParameter("idEmp",  Long.valueOf(idEmpleado));
			qry.setParameter("pIdlimpiezaproceso", Long.valueOf(pIdlimpiezaproceso));
			qry.setParameter("pidcargo", Integer.valueOf(pidcargo));
			ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
			
			return ep;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	
	
	
//	@SuppressWarnings("unchecked")
//	public List<LimpiezaProcesoEmpleado> obtenerLpEmpleadoLineaargo(String lproceso, String idlinea, String idcargo) 
//	{
//		List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
//		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//			
//			//Busca la ubicación en la linea por el estado activo (1)
//			try {
//				Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
//						" where ep.limpiezaProceso.idlimpiezaproceso = :lp and " +
//						" ep.limpiezaLinea.idlimpiezalinea = :pidlinea and " +
//						" ep.idlimpiezacargo = :pidcargo " +
//						" order by ep.idlimpiezacargo, ep.ubicacion ");
//				
//				qry.setParameter("lp", Long.valueOf(lproceso));
//				qry.setParameter("pidlinea", Integer.valueOf(idlinea));
//				qry.setParameter("pidcargo", Integer.valueOf(idcargo));
//				
//				ep = qry.getResultList();
//				
//				return ep;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return null;
//			}
//
//	}	
	
	
	
	
	public LimpiezaProcesoEmpleado obtenerDatosEmpleadoNuevo(int linea,int cargo) {
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
					" where  ep.limpiezaLinea.idlimpiezalinea =:idEmp  and ep.idlimpiezacargo=:idcargo order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
		
			qry.setParameter("idEmp", linea);
			qry.setParameter("idcargo", cargo);
			ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
			
			return ep;
		} catch (Exception e) {
			return null;
		}
	}


public LimpiezaProcesoEmpleado obtenerDatosEmpleadoNuevo1( int linea) {
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
					" where   ep.limpiezaLinea.idlimpiezalinea =:idEmp   order by ep.limpiezaProceso.idlimpiezaproceso desc ");
		
			qry.setParameter("idEmp", linea);
			ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
			
			return ep;
		} catch (Exception e) {
			return null;
		}
		
		
	}

public LimpiezaProcesoEmpleado obtenerDatosEmpleadoxCodigo(String Codigo) {
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.empleado.codpersona=:idEmp order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
	
		qry.setParameter("idEmp", Codigo);
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
	}


public List<LimpiezaProcesoEmpleado> obtenerDatosEmpleadoxCodigoProceso(String Codigo, String lproceso) {
	List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where ep.limpiezaProceso.idlimpiezaproceso = :lp and " +
				" (ep.estado is null or ep.estado = 1) and " +
				" ep.empleado.codpersona=:idEmp ");
	
		qry.setParameter("lp", Long.valueOf(lproceso));
		qry.setParameter("idEmp", Codigo);
		
		ep = qry.getResultList();
		
		return ep;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}






public LimpiezaProcesoEmpleado obtenerDatosEmpleadoxCedula(String Codigo) {
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.empleado.cedula=:idEmp order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
	
		qry.setParameter("idEmp", Codigo.trim());
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
	}


public LimpiezaProcesoEmpleado obtenerDatosEmpleadoActivoxCedula(String Codigo, String pIdlimpiezaproceso) {
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	
	// Estados
	// 1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
	// 2 = Retirado de la linea (se puede usar esta estado para el reingreso a la linea)
	// 3 = Estuvo activo anteriormente (no se considera este estado para el reingreso a linea)
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.empleado.cedula=:idEmp and (ep.estado is null or ep.estado = 1) and " +
				" ep.limpiezaProceso.idlimpiezaproceso =:pIdlimpiezaproceso " +
				" order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
	
		qry.setParameter("idEmp", Codigo.trim());
		qry.setParameter("pIdlimpiezaproceso", Long.valueOf(pIdlimpiezaproceso));
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
	}



public LimpiezaProcesoEmpleado obtenerDatosEmpleadoActivoxCedulaEstados(String Codigo, String pIdlimpiezaproceso, String pIdlimpiezacargo) {
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	
	// Estados
	// 1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
	// 2 = Retirado de la linea (se puede usar esta estado para el reingreso a la linea)
	// 3 = Estuvo activo anteriormente (no se considera este estado para el reingreso a linea)
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.empleado.cedula=:idEmp and " +
				" ep.idlimpiezacargo=: pIdlimpiezacargo and " +
				" (ep.estado = 1 or ep.estado is null) and " +
				" ep.limpiezaProceso.idlimpiezaproceso =:pIdlimpiezaproceso" +
				" order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
	
		qry.setParameter("idEmp", Codigo.trim());
		qry.setParameter("pIdlimpiezaproceso", Long.valueOf(pIdlimpiezaproceso));
		qry.setParameter("pIdlimpiezacargo", Integer.valueOf(pIdlimpiezacargo));
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
	}





public LimpiezaProcesoEmpleado obtenerDatosEmpleadoActivoxCedulaEstadosNoActivos(String Codigo, String pIdlimpiezaproceso) {
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	
	// Estados
	// 1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
	// 2 = Retirado de la linea (se puede usar esta estado para el reingreso a la linea)
	// 3 = Estuvo activo anteriormente (no se considera este estado para el reingreso a linea)
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.empleado.cedula=:idEmp and " +
				" (ep.estado <> 1 and ep.estado is not null) and " +
				" ep.limpiezaProceso.idlimpiezaproceso =:pIdlimpiezaproceso " +
				" order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
	
		qry.setParameter("idEmp", Codigo.trim());
		qry.setParameter("pIdlimpiezaproceso", Long.valueOf(pIdlimpiezaproceso));
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
	}




// Estados
// 1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
public LimpiezaProcesoEmpleado obtenerDatosEmpleadoActivoxCedulaEstadosPuesto(String Codigo, String pIdlimpiezaproceso, Integer pEstado) 
{
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	
	// Estados
	// 1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
	// 2 = Retirado de la linea (se puede usar esta estado para el reingreso a la linea)
	// 3 = Estuvo activo anteriormente (no se considera este estado para el reingreso a linea)
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.empleado.cedula=:idEmp and " +
				" ep.limpiezaProceso.idlimpiezaproceso =: pIdlimpiezaproceso and " +
				" ep.estado =: pEstado " +
				" order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
	
		qry.setParameter("idEmp", Codigo.trim());
		qry.setParameter("pIdlimpiezaproceso", Long.valueOf(pIdlimpiezaproceso));
		qry.setParameter("pEstado", pEstado);
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
	}

//Estados
//1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
public LimpiezaProcesoEmpleado obtenerDatosEmpleadoActivoxCedulaEstadosPuesto_1(String Codigo, String pIdlimpiezaproceso) 
{
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	
	System.out.println("RECEPTADOS");
	System.out.println("txtEmpleado.getValue().trim() :"+Codigo);
	System.out.println("limpiezaproceso_activo.getIdlimpiezaproceso().toString() "+pIdlimpiezaproceso);
	
	
	
	// Estados
	// 1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
	// 2 = Retirado de la linea (se puede usar esta estado para el reingreso a la linea)
	// 3 = Estuvo activo anteriormente (no se considera este estado para el reingreso a linea)
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.empleado.cedula='1310106248' and " +
				" ep.limpiezaProceso.idlimpiezaproceso=1122 and " +
				" (ep.estado = 1 or ep.estado is null) " +
				" order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
	
//		qry.setParameter("idEmp", Codigo.trim());
//		qry.setParameter("pIdlimpiezaproceso", pIdlimpiezaproceso);
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
	}




public int retirarEmpleadoexterno (LimpiezaProcesoEmpleado  RC) {
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
     int r= 0;
     long id = RC.getIdlimpiezaprocesoempleado();
	EntityTransaction t = em.getTransaction();
	try {
		t.begin();
		 Query query = em.createQuery("Update LimpiezaProcesoEmpleado set estado=3 where idlimpiezaprocesoempleado = :idbc");
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


public int reintegrarEmpleado (LimpiezaProcesoEmpleado  RC) {
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
     int r= 0;
     long id = RC.getIdlimpiezaprocesoempleado();
	EntityTransaction t = em.getTransaction();
	try {
		t.begin();
		 Query query = em.createQuery("Update LimpiezaProcesoEmpleado set estado=1 where idlimpiezaprocesoempleado = :idbc");
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
public int reubicarEmpleado (LimpiezaProcesoEmpleado  RC, int idlinea, int idubicacion, int cargo, Integer idgrupo) {
	System.out.println("Entro metodo");
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
     int r= 0;
     long id = RC.getIdlimpiezaprocesoempleado();
	EntityTransaction t = em.getTransaction();
	try {
		System.out.println("Entro try");
		t.begin();
		 Query query = em.createNativeQuery("Update limpieza_proceso_empleado  set idlinea="+idlinea+" , ubicacion="+idubicacion+", idlimpiezacargo="+cargo+ ", idlimpiezalineagrupo = " + idgrupo +" where idlimpiezaprocesoempleado = "+id);
		 query.setParameter("idbc", id);
		 query.setParameter("idlinea", idlinea);
		 query.setParameter("idubicacion", idubicacion);
		 query.setParameter("idcargo", cargo);
		 query.setParameter("idgrupo", idgrupo);
		 		 
		 System.out.println(query.toString());
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

public int retirarEmpleado (LimpiezaProcesoEmpleado  RC) {
      EntityManagerFactory emf = JPAPersistenceManager.getInstance()
                  .getEntityManagerFactory();
      EntityManager em = emf.createEntityManager();
     int r= 0;
     long id = RC.getIdlimpiezaprocesoempleado();
      EntityTransaction t = em.getTransaction();
      try {
            t.begin();
            Query query = em.createQuery("Update LimpiezaProcesoEmpleado set estado=2 where idlimpiezaprocesoempleado = :idbc");
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

public LimpiezaProcesoEmpleado obtenerDatosEmpleadoActivoxCedulaEstado(String Codigo, String pIdlimpiezaproceso) {
	LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	
	// Estados
	// 1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
	// 2 = Retirado de la linea (se puede usar esta estado para el reingreso a la linea)
	// 3 = Estuvo activo anteriormente (no se considera este estado para el reingreso a linea)
	try {			
		Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
				" where  ep.empleado.cedula=:idEmp and " +
				" ep.limpiezaProceso.idlimpiezaproceso =:pIdlimpiezaproceso " +
				" order by ep.limpiezaProceso.idlimpiezaproceso desc  ");
	
		qry.setParameter("idEmp", Codigo.trim());
		qry.setParameter("pIdlimpiezaproceso", Long.valueOf(pIdlimpiezaproceso));
		ep = (LimpiezaProcesoEmpleado) qry.getResultList().get(0);
		
		return ep;
	} catch (Exception e) {
		return null;
	}
	}

    /* buscar empleado por LimpiezaProceso , ubicacion y linea  */
	public LimpiezaProcesoEmpleado getDatosEmpleadoByUbicacionAndLinea(LimpiezaProceso lproceso, int linea , int ubicacion) {
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		long idlproceso = lproceso.getIdlimpiezaproceso();
		try {			
			Query qry  = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
					" where lpe.limpiezaProceso.idlimpiezaproceso =:lp " +
					"    and lpe.limpiezaLinea.idlimpiezalinea =:idEmp" +
					"        and lpe.ubicacion =:ubicacion and lpe.idlimpiezacargo = 1 ");
		
			qry.setParameter("lp", idlproceso);
			qry.setParameter("idEmp", linea);
			qry.setParameter("ubicacion", ubicacion);
			ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
			
			return ep;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    /* buscar empleado por LimpiezaProceso y linea  */
	public LimpiezaProcesoEmpleado getDatosEmpleadoByLineaAndLimpiezaProceso(LimpiezaProceso lproceso, int linea , long idempleado) {
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		long idlproceso = lproceso.getIdlimpiezaproceso();
		try {			
			Query qry  = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
					" where lpe.limpiezaProceso.idlimpiezaproceso =:lp " +
					"    and lpe.limpiezaLinea.idlimpiezalinea =:idline" +
					"        and lpe.empleado.idempleado =:idemple and lpe.idlimpiezacargo = 1 ");
		
			qry.setParameter("lp", idlproceso);
			qry.setParameter("idline", linea);
			qry.setParameter("idemple", idempleado);
			ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
			
			return ep;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//LISTA DE EMPLEADOS POR PRODUCCIONES 18-10-2017
	@SuppressWarnings("unchecked")
	public List<LimpiezaProcesoEmpleado> obtenerLpEmpleadosPorProducciones(Produccion p1, Produccion p2) 
	{
		List<LimpiezaProcesoEmpleado> ep = new ArrayList<LimpiezaProcesoEmpleado>();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleado ep " +
					" where ep.limpiezaProceso.produccion.idproduccion >= :id1 and ep.limpiezaProceso.produccion.idproduccion <= :id2 ");
		
			qry.setParameter("id1", p1.getIdproduccion());
			qry.setParameter("id2", p2.getIdproduccion());
			ep = qry.getResultList();
			
			return ep;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	

	
	/**
	   * 12-10-2017 Busca en la tabla de movimeinto el empleado por su ID y por el ID limpiezaproceso
	   * y su estado 
	   * @param idempleado
	   * @param idlimpiezaproceso
	   * @param estado
	   * @return
	   */
	  public LimpiezaProcesoEmpleadoAditoriaMovimiento getLpEmpleadoAudiMovByIdLimpiezaProceso(long idempleado, 
			  																				   long idlimpiezaproceso, 
			  																				   int estado) {
		  LimpiezaProcesoEmpleadoAditoriaMovimiento ep = new LimpiezaProcesoEmpleadoAditoriaMovimiento();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		// Estados
		// 1 = Activo ingresado a una ubicación (usaddo para registrar las ponchadas)
		// 2 = Retirado de la linea (se puede usar esta estado para el reingreso a la linea)
		// 3 = Estuvo activo anteriormente (no se considera este estado para el reingreso a linea)
		try {			
			Query qry  = em.createQuery("select ep from LimpiezaProcesoEmpleadoAditoriaMovimiento ep " +
										" where  ep.empleado.idempleado =:idEmp and " +
										" 	ep.limpiezaProceso.idlimpiezaproceso =:pIdlimpiezaproceso and ep.estado =:pEstado " +
										" 		order by ep.idlimpiezaprocesoempleadoaditoriamovimiento desc  ");
		
			qry.setParameter("idEmp", idempleado);
			qry.setParameter("pIdlimpiezaproceso", idlimpiezaproceso);
			qry.setParameter("pEstado", estado);
			ep = (LimpiezaProcesoEmpleadoAditoriaMovimiento) qry.getResultList().get(0);
			
			return ep;
		  } catch (Exception e) {
			e.printStackTrace();
			return null;
		  }finally{
			  em.close();
		  }
	   }

	  
//	  /*15-02-2018 */
//      public LimpiezaProcesoEmpleado getDatosEmpleadoByUbicacionAndLineaAndTipo(LimpiezaProceso lproceso, int linea , int ubicacion, int tipo) {
//            LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
//            EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
//            EntityManager em = emf.createEntityManager();
//            long idlproceso = lproceso.getIdlimpiezaproceso();
//            try {             
//                  Query qry  = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
//                              " where lpe.limpiezaProceso.idlimpiezaproceso =:lp " +
//                              "    and lpe.limpiezaLinea.idlimpiezalinea =:idEmp" +
//                              "        and lpe.ubicacion =:ubicacion and lpe.idlimpiezacargo =:idtipo ");
//            
//                  qry.setParameter("lp", idlproceso);
//                  qry.setParameter("idEmp", linea);
//                  qry.setParameter("ubicacion", ubicacion);
//                  qry.setParameter("idtipo", tipo);
//                  ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
//                  
//                  return ep;
//            } catch (Exception e) {
//                  e.printStackTrace();
//                  return null;
//            }
//      }

      
		/*15-02-2018 */
	public LimpiezaProcesoEmpleado getDatosEmpleadoByUbicacionAndLineaAndTipo(LimpiezaProceso lproceso, int linea , int ubicacion, int tipo) {
		LimpiezaProcesoEmpleado ep = new LimpiezaProcesoEmpleado();
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		long idlproceso = lproceso.getIdlimpiezaproceso();
		try {			
			Query qry  = em.createQuery("select lpe from LimpiezaProcesoEmpleado lpe " +
					" where lpe.limpiezaProceso.idlimpiezaproceso =:lp " +
					"    and lpe.limpiezaLinea.idlimpiezalinea =:idEmp" +
					"        and lpe.ubicacion =:ubicacion and lpe.idlimpiezacargo =:idtipo" +
					"           and lpe.estado <> 2 ");
		
			qry.setParameter("lp", idlproceso);
			qry.setParameter("idEmp", linea);
			qry.setParameter("ubicacion", ubicacion);
			qry.setParameter("idtipo", tipo);
			ep = (LimpiezaProcesoEmpleado) qry.getSingleResult();
			
			return ep;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}      
	  
}
