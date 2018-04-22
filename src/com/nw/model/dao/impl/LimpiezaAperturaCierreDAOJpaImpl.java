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
import com.nw.model.LimpiezaProceso;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.dao.LimpiezaAperturaCierreDAO;


@SuppressWarnings("unchecked")
public class LimpiezaAperturaCierreDAOJpaImpl extends BaseDaoJpaImpl implements LimpiezaAperturaCierreDAO {

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    private String usuario;
    
    public LimpiezaAperturaCierreDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
		
        //TODO 0 ELIMINAR DESPUES DE LAS PRUEBAS
        usuario = (String)Sessions.getCurrent().getAttribute("usuario"); //ON
        //usuario = "prueba"; //OFF
    }

	@Override
	public ProcesoAperturaCierre aperturar(Produccion produccion) {
		ProcesoAperturaCierre procesoAperturaCierre = null;
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				Timestamp fecha = new Timestamp(new Date().getTime());
				
				ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
				pac.setEstado(1);
				pac.setFechaapertura(fecha);
				
				Proceso p = new Proceso();
				p.setIdproceso(4);
				pac.setProceso(p);	
				
				//Proceso 7 = LIMPIEZA
/*				Proceso proceso = new ProcesoDAOJpaImpl().getProcesoById(7);
				if (proceso !=null )
					pac.setProceso(proceso);
*/
				//TODO 0 EJEMPLO DE CAPTURA DE SECUENCIA GENERADA EN UNA TRANSACCION
				em.persist(pac);
				em.flush();
				//System.out.println("pac: " + pac.getIdprocesoaperturacierre());
				
				LimpiezaProceso lp = new LimpiezaProceso();
				lp.setProduccion(produccion);
				lp.setEstado(1);
				//lp.setFechareg(produccion.getFechaproduccion());
				lp.setFechareg(fecha);
				lp.setProcesoAperturaCierre(pac);
				lp.setUsuario(new UsuarioDAOJpaImpl().getUser(usuario));
				
			
				
				em.merge(lp);
				procesoAperturaCierre = pac; //Este es el valor de retorno

				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		return procesoAperturaCierre;
	}
	
	public LimpiezaProceso aperturarProduccionTurno(Produccion produccion, Turno turno) {
//		ProcesoAperturaCierre procesoAperturaCierre = null;
		LimpiezaProceso lp = new LimpiezaProceso();
		try {
			EntityTransaction t = em.getTransaction();
			
			try {
				t.begin();
				
				Timestamp fecha = new Timestamp(new Date().getTime());
				
				ProcesoAperturaCierre pac = new ProcesoAperturaCierre();
				pac.setEstado(1);
				pac.setFechaapertura(fecha);
				
				Proceso p = new Proceso();
				p.setIdproceso(4);
				pac.setProceso(p);	
				
				//Proceso 7 = LIMPIEZA
/*				Proceso proceso = new ProcesoDAOJpaImpl().getProcesoById(7);
				if (proceso !=null )
					pac.setProceso(proceso);
*/
				//TODO 0 EJEMPLO DE CAPTURA DE SECUENCIA GENERADA EN UNA TRANSACCION
				em.persist(pac);
				em.flush();
				//System.out.println("pac: " + pac.getIdprocesoaperturacierre());
				
				
				lp.setProduccion(produccion);
				lp.setEstado(1);
				lp.setTurno(turno);
				//lp.setFechareg(produccion.getFechaproduccion());
				lp.setFechareg(fecha);
				lp.setProcesoAperturaCierre(pac);
				lp.setUsuario(new UsuarioDAOJpaImpl().getUser(usuario));
				
			
				
				lp=em.merge(lp);
//				procesoAperturaCierre = pac; //Este es el valor de retorno

				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		return lp;
	}
	@Override
	public ProcesoAperturaCierre getActivo() {
		String sql = "select o from ProcesoAperturaCierre o where o.estado=1 and o.proceso.idproceso = 4 ";
		List <ProcesoAperturaCierre>items = em.createQuery(sql).getResultList();
		return ( items == null || items.isEmpty() ) ? null: (ProcesoAperturaCierre) items.get(0);
	}

	@Override
	public void cerrar(ProcesoAperturaCierre procesoAperturaCierre) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				procesoAperturaCierre.setEstado(0);
				procesoAperturaCierre.setFechacierre(new Timestamp(new Date().getTime()));

				
				
				em.merge(procesoAperturaCierre);
				
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
	}

	public LimpiezaProceso getLimpiezaProcesoIdProduccion(long id, Turno turno) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaProceso o "); 
		sb.append("Where o.produccion.idproduccion= '" + id + "' and o.procesoAperturaCierre.estado=1 and  o.turno.idturno = '" + turno.getIdturno() + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (LimpiezaProceso) items.get(0);
	    }		
	}	

	public LimpiezaProceso getLimpiezaProcesoRegistrado(long id, Turno turno) 
	{ 
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select o "); 
		sb.append("From LimpiezaProceso o "); 
		sb.append("Where o.produccion.idproduccion= '" + id + "'  and o.procesoAperturaCierre.estado <>1 and  o.turno.idturno = '" + turno.getIdturno() + "'");
		
		//logger.info(CalidadBpmDesembarco.class +" -> "+sb.toString());

		List items =  em.createQuery(sb.toString()).getResultList();

	    if (items == null || items.isEmpty()) {
	        return null;
	    } else {
	        return  (LimpiezaProceso) items.get(0);
	    }		
	}		


	public int getNumCochesSinTara(long id, int turno)
	{
		int rec = 0;
		
		Query query = em.createQuery("select count(ldpc.idlimpiezadetalleprocesocoche) from LimpiezaDetalleProcesoCoche ldpc " +
				"where ldpc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
				"produccionDetalleLoteCajon.produccionDetalleLote." +
				"produccion.idproduccion = :idProduccion and " +
				"ldpc.evisceradoDetalleProcesoCoche.evisceradoDetalleProceso." +
				"produccionDetalleLoteCajon.produccionDetalleLote." +
				"turno.idturno = :idTurno and " +
				"ldpc.tara = 0");
		query.setParameter("idProduccion", id);
		query.setParameter("idTurno", turno);
		String c = query.getSingleResult().toString();
		rec = Integer.valueOf(c);

		return rec;
	}
	
}
