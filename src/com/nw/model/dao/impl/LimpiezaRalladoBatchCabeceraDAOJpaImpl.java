package com.nw.model.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.zkoss.zk.ui.Sessions;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.HarinaComprobanteDetalleGrupoEspecie;
import com.nw.model.HarinaRecepcionPescaComprobante;
import com.nw.model.LimpiezaDetalleProcesoBandeja;
import com.nw.model.LimpiezaRalladoBatchCabecera;
import com.nw.model.LimpiezaRalladoMezclaBatchCabecera;
import com.nw.model.LimpiezaRalladoMezclaBatchDetalle;
import com.nw.model.Usuario;
import com.nw.model.dao.LimpiezaRalladoBatchCabeceraDAO;
import com.nw.temp.model.HarinaComprobanteDetalleGrupoEspecieEstado;
import com.nw.temp.model.LimpiezaRalladoMezclaBatchEstado;


public class LimpiezaRalladoBatchCabeceraDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaRalladoBatchCabeceraDAO 
{

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;
    
    public LimpiezaRalladoBatchCabeceraDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    
    
	public LimpiezaRalladoBatchCabecera getLimpiezaRalladoBatchCabecera(String id) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaRalladoBatchCabecera o "); 
		sb.append("Where o.idlimpiezaralladobatchcabecera = '" + id.trim() + "'");
		
		@SuppressWarnings("rawtypes")
		List items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaRalladoBatchCabecera) items.get(0);
        }		
	}

	
	
	
	
	public LimpiezaRalladoBatchCabecera getLimpiezaRalladoBatchCabeceraActivaPorTipo(Integer tipo, Long idlp) 
	{ 
		
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("Select o "); 
			sb.append("From LimpiezaRalladoBatchCabecera o "); 
			sb.append("Where o.tipo = " + tipo + " and o.estado = 1 ");
			sb.append("and o.limpiezaProceso.idlimpiezaproceso = "+idlp);
			@SuppressWarnings("rawtypes")
			List items =  em.createQuery(sb.toString()).getResultList();

			if (items == null || items.isEmpty()) {
			    return null;
			} else {
			    return  (LimpiezaRalladoBatchCabecera) items.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}		
	}	
	
	
	
	
	
	public Integer validarRegistrosLimpiezaRalladoBatchCabecera(Long idlproceso, int vtipo)
	{	
		try {
			//LimpiezaDetalleProcesoLote lp = new LimpiezaDetalleProcesoLote();
			Query query = em.createQuery("select lp from LimpiezaRalladoBatchCabecera lp " +
					"where lp.limpiezaProceso.idlimpiezaproceso=:idlproceso " +
					"and lp.tipo=:vtipo " +
					"and lp.estado in (1,2,3) ");
			query.setParameter("vtipo", vtipo);
			 query.setParameter("idlproceso", idlproceso);			
			return query.getResultList().size();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}		
	}	
	
	
	
	
	 public Integer getMaxLimpiezaRalladoBatchCabecera(Long idlp, Integer tipo) 
	 { 
			
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select max(o.batch) "); 
			sb.append("from LimpiezaRalladoBatchCabecera o ");
			sb.append("where o.limpiezaProceso.idlimpiezaproceso = "+idlp.toString());
			sb.append("and o.tipo = " + String.valueOf(tipo) + "");
			 
			//List items =  em.createQuery(sb.toString()).getResultList();
			Integer maxResult=(Integer) em.createQuery(sb.toString()).getSingleResult();

			return  maxResult + 1;
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}	
	
	

	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoBatchCabecera> validarLimpiezaRalladoBatchCabecera1(Long idlproceso)
	{	
		try {
			//LimpiezaDetalleProcesoLote lp = new LimpiezaDetalleProcesoLote();
			Query query = em.createQuery("select   lp from LimpiezaRalladoBatchCabecera lp " +
					"where lp.limpiezaProceso.idlimpiezaproceso=:idproceso and lp.estado in (1,2,3) ");
			 query.setParameter("idlproceso", idlproceso);			
			return query.getResultList();
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		}		
	}

	
	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoBatchCabecera> ListaBatchRalladoPorTipo(Integer tipo, Long idlproceso)
	{	
		try {
			//LimpiezaDetalleProcesoLote lp = new LimpiezaDetalleProcesoLote();
			Query query = em.createQuery("select lp from LimpiezaRalladoBatchCabecera lp " +
					"where lp.tipo=:tip and lp.limpiezaProceso.idlimpiezaproceso=:idlproceso and lp.estado in (1,2) ");
			 query.setParameter("tip", tipo);			
			 query.setParameter("idlproceso", idlproceso);
			 
			 
			 
			return query.getResultList();
		} catch (Exception e) {		
			e.printStackTrace();
			return null;
		}		
	}
	
		
	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoBatchCabecera> ListaBatchRalladoAbiertos(Long idproceso)
	{	
		try {
			Query query = em.createQuery("select lp from LimpiezaRalladoBatchCabecera lp " +
					"where lp.limpiezaProceso.idlimpiezaproceso=:idproceso and lp.estado = 1 ");
			 query.setParameter("idproceso", idproceso);			
			return query.getResultList();
		} catch (Exception e) {	
			e.printStackTrace();
			return null;
		}		
	}	
	

	
	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoBatchCabecera> ListaBatchRalladoAbiertos1(Long idproceso, int tipo)
	{	
		
		if (tipo == 1)
		{
			//Cerrados
			try {
				Query query = em.createQuery("select lp from LimpiezaRalladoBatchCabecera lp " +
						"where lp.limpiezaProceso.idlimpiezaproceso=:idproceso and lp.estado = 2 ");
				 query.setParameter("idproceso", idproceso);			
				return query.getResultList();
			} catch (Exception e) {	
				e.printStackTrace();
				return null;
			}				
		}
		else
		{
			//Abiertos
			try {
				Query query = em.createQuery("select lp from LimpiezaRalladoBatchCabecera lp " +
						"where lp.limpiezaProceso.idlimpiezaproceso=:idproceso and lp.estado = 1 ");
				 query.setParameter("idproceso", idproceso);			
				return query.getResultList();
			} catch (Exception e) {	
				e.printStackTrace();
				return null;
			}		
			
		}
			
		
	}	
	
	
	
	@SuppressWarnings("unchecked")
	public List<LimpiezaRalladoBatchCabecera> ListaBatchRalladoCerrados(Long idproceso, int tipo)
	{	
		
		if(tipo == 1)
		{
			//Cerrados
			try {
				Query query = em.createQuery("select lp from LimpiezaRalladoBatchCabecera lp " +
						"where lp.limpiezaProceso.idlimpiezaproceso=:idproceso and lp.estado = 2 ");
				 query.setParameter("idproceso", idproceso);			
				return query.getResultList();
			} catch (Exception e) {	
				e.printStackTrace();
				return null;
			}		
		}
		else
		{
			//ABIERTOS
			try {
				Query query = em.createQuery("select lp from LimpiezaRalladoBatchCabecera lp " +
						"where lp.limpiezaProceso.idlimpiezaproceso=:idproceso and lp.estado = 1 ");
				 query.setParameter("idproceso", idproceso);			
				return query.getResultList();
			} catch (Exception e) {	
				e.printStackTrace();
				return null;
			}		
		}
	}	
	
	
//	@Override
//	public void saveOrUpdate111(LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) 
//	{
//		try{
//	    	 EntityTransaction t = em.getTransaction();
//	    	  try {
//					t.begin();  
//						em.merge(limpiezaRalladoBatchCabecera);
//	 			        t.commit();
//   		  } finally {
//   		    if (t.isActive()) t.rollback();
//   		  }
//			}finally{
//				em.close();
//				//emf.close();
//			}		
//	}	

	
    public LimpiezaRalladoBatchCabecera saveOrUpdate (LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) 
    {
    	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
    	EntityManager em = emf.createEntityManager();
    	LimpiezaRalladoBatchCabecera LimpiezaRalladoBatchCabeceraDevuelto = new LimpiezaRalladoBatchCabecera();
     try {
            
            
            
            EntityTransaction t = em.getTransaction();
            try {
                   t.begin();
                   LimpiezaRalladoBatchCabeceraDevuelto = em.merge(limpiezaRalladoBatchCabecera);
                   t.commit();
            } finally {
                   if (t.isActive())
                          t.rollback();
            }
     } finally {
            em.close();
     }
     return LimpiezaRalladoBatchCabeceraDevuelto;
}

    
    
    
    
    
    
	public void saveOrUpdateDeleteMezclaBatch(List<LimpiezaRalladoMezclaBatchEstado> limpiezaRalladoMezclaBatchEstados, LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera) 
	{

		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		
		
		t.begin();
			try {
				int index = 0;
				int i=0;
				for (LimpiezaRalladoMezclaBatchEstado rde : limpiezaRalladoMezclaBatchEstados) 
				{	
					i++;
					rde = limpiezaRalladoMezclaBatchEstados.get(index);

//				System.out.println("1 ::"+rde.getHarinaRecepcionPescaComprobante().getIdharinarecepcionpescacomprobante().toString());
//				System.out.println("2 ::"+rde.getHarinaEspecie().getIdharinaespecie().toString());
					
					System.out.println("Vuelta en grabada/Eliminada :"+String.valueOf(i));
					
					//System.out.println("1 ::"+rde.getHarinaRecepcionPescaComprobante().getIdharinarecepcionpescacomprobante().toString());
					//harinaRecepcionDetallePescaComprobante
					
					if(rde.getLimpiezaRalladoBatchCabecera() != null)
					{
						System.out.println("1 ::"+rde.getLimpiezaRalladoBatchCabecera().getIdlimpiezaralladobatchcabecera().toString());	
					}
					else
					{
						System.out.println("1 NO EXISTE HarinaComprobanteDetalleGrupoEspecie().getHarinaRecepcionPescaComprobante()");
					}
					
					
					//System.out.println("2 ::"+rde.get.getHarinaComprobanteDetalleGrupoEspecie().getHarinaGrupoEspecie().toString());
					
					LimpiezaRalladoMezclaBatchDetalle he = null;
					try {
						
//						System.out.println("Eviados para busqueda de la especie en el detalle");
//						System.out.println("rde.getHarinaRecepcionPescaComprobante().getIdharinarecepcionpescacomprobante() "+rde.getHarinaRecepcionPescaComprobante().getIdharinarecepcionpescacomprobante().toString());
//						System.out.println("rde.getHarinaEspecie().getIdharinaespecie() "+rde.getHarinaEspecie().getIdharinaespecie().toString());
						
						//he = getHarinaDetalleEspeceRecepcionDetallePescaComprobante(rde.getHarinaRecepcionPescaComprobante().getIdharinarecepcionpescacomprobante().toString(),rde.getHarinaEspecie().getIdharinaespecie().toString());
						//he = getHarinaComprobanteDetalleGrupoEspecie(harinaRecepcionPescaComprobante.getIdharinarecepcionpescacomprobante().toString(), rde.getHarinaComprobanteDetalleGrupoEspecie().getHarinaGrupoEspecie().getIdharinagrupoespecie().toString());
						rde.setLimpiezaRalladoMezclaBatchCabecera(limpiezaRalladoMezclaBatchCabecera);
						he = getLimpiezaRalladoMezclaBatchDetalle(rde.getLimpiezaRalladoBatchCabecera().getIdlimpiezaralladobatchcabecera().toString(), rde.getLimpiezaRalladoMezclaBatchCabecera().getIdlimpiezaralladomezclabatchcabecera().toString());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int ban = 0;
					System.out.println("DATO");
					//if(rde.getHarinaDetalleEspeceRecepcionDetallePescaComprobante() == null)
					if(he == null)
					{
						System.out.println("NULL");
						ban = 1;
					}	
					else
					{
						//System.out.println(rde.getHarinaComprobanteDetalleGrupoEspecie().getIdharinacomprobantedetallegrupoespecie());					
					}
					
				
					//Es Eliminar
					if (rde.isEliminar() == true)  
					{
						//El objeto a eliminar de la lista si no existe en la base de datos
						if (rde.getLimpiezaRalladoBatchCabecera() != null)					
						{
							
//							//Recuperamos el reg. del detalle												
//							//Capturamos el registro de la base de datos
//							he = getHarinaComprobanteDetalleGrupoEspecie(harinaRecepcionPescaComprobante.getIdharinarecepcionpescacomprobante().toString(), rde.getHarinaComprobanteDetalleGrupoEspecie().getHarinaGrupoEspecie().getIdharinagrupoespecie().toString());
						
						
						
							he = getLimpiezaRalladoMezclaBatchDetalle(rde.getLimpiezaRalladoBatchCabecera().getIdlimpiezaralladobatchcabecera().toString(), rde.getLimpiezaRalladoMezclaBatchCabecera().getIdlimpiezaralladomezclabatchcabecera().toString());
//							
//							System.out.println("Para eliminar ");
//							System.out.println("1 :"+harinaRecepcionPescaComprobante.getIdharinarecepcionpescacomprobante().toString()); 
//							System.out.println("2 :"+rde.getHarinaComprobanteDetalleGrupoEspecie().getHarinaGrupoEspecie().getIdharinagrupoespecie().toString());
//							
//							if(he == null)
//							{
//								System.out.println("HE ESTA VACIO");
//							}	
//							
//							System.out.println("ID he.getIdharinacomprobantedetallegrupoespecie() :"+he.getIdharinacomprobantedetallegrupoespecie().toString());
							
							LimpiezaRalladoMezclaBatchDetalle o = (LimpiezaRalladoMezclaBatchDetalle) em.find(LimpiezaRalladoMezclaBatchDetalle.class, he.getIdlimpiezaralladomezclabatchdetalle());
							//HarinaDetalleEspeceRecepcionDetallePescaComprobante o = (HarinaDetalleEspeceRecepcionDetallePescaComprobante) em.find(HarinaDetalleEspeceRecepcionDetallePescaComprobante.class, he.getIdharinadetalleespecerecepciondetallepescacomprobante());
							//Lo Eliminamos
							em.remove(o);
						}
					} 
					//Graba/Modifica
					else  
					{
						
						//El objeto a eliminar de la lista si no existe en la base de datos
						//if (rde.getHarinaDetalleEspeceRecepcionDetallePescaComprobante() == null && rde.isEliminar() == false)
						//if(ban == 1)
					
						// && rde.isEliminar() == false
						if(he == null && rde.isEliminar() == false)
						{
							System.out.println("Grabando modificando pos index :"+ String.valueOf(index));
							//Creamos un nuevo objeto
							LimpiezaRalladoMezclaBatchDetalle h = new LimpiezaRalladoMezclaBatchDetalle();
							h.setLimpiezaRalladoBatchCabecera(rde.getLimpiezaRalladoBatchCabecera());
							h.setLimpiezaRalladoMezclaBatchCabecera(rde.getLimpiezaRalladoMezclaBatchCabecera());

							
							//////////////////
							h.setFechareg(new Timestamp(new Date().getTime()));
							String usuarioSession = (String) Sessions.getCurrent().getAttribute("usuario");
							Usuario usuario = new Usuario();
							usuario.setIdusuario(usuarioSession); 
							h.setUsuario(usuario);							
							//////////////////
							
							
							em.merge(h);
						}
						else
						{
							//Modificamos
							//Completar codigo
							//em.merge(h);
						}
					}
					
					index = index + 1;	
				}
				t.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}    
    
    

	
    public LimpiezaRalladoMezclaBatchDetalle getLimpiezaRalladoMezclaBatchDetalle(String idlimpiezaralladobatchcabecera, String idlimpiezaralladomezclabatchcabecera)
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaRalladoMezclaBatchDetalle o ");
		sb.append("Where o.limpiezaRalladoMezclaBatchCabecera.idlimpiezaralladomezclabatchcabecera = '" + idlimpiezaralladomezclabatchcabecera + "'");
		sb.append("and o.limpiezaRalladoBatchCabecera.idlimpiezaralladobatchcabecera = '" + idlimpiezaralladobatchcabecera + "'");
		

		List<LimpiezaRalladoMezclaBatchDetalle> items =  em.createQuery(sb.toString()).getResultList();

        if (items == null || items.isEmpty()) {
            return null;
        } else {
            return  (LimpiezaRalladoMezclaBatchDetalle) items.get(0);
        }		
	}    
	
	
	
	
}
