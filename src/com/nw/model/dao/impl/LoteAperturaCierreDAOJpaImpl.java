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
import com.nw.model.LimpiezaDetalleProcesoLote;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LimpiezaTipo;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.dao.LoteAperturaCierreDAO;

/**
 * Controlador para manejar la apertura y el cierre de lote (limpieza_detalle_proceso_lote)
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-01-13, 14, 18
 */
@SuppressWarnings("unchecked")
public class LoteAperturaCierreDAOJpaImpl extends BaseDaoJpaImpl implements LoteAperturaCierreDAO{ 

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    private String usuario;
    
    public LoteAperturaCierreDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
		
        //TODO 0 ELIMINAR DESPUES DE LAS PRUEBAS
        //usuario = (String)Sessions.getCurrent().getAttribute("usuario"); //ON
        //usuario = "prueba"; //OFF
        
		usuario = (String)Sessions.getCurrent().getAttribute("usuario");
    }

	@Override
	public LimpiezaDetalleProcesoLote aperturar(LimpiezaProceso limpiezaProceso, ProduccionDetalleLote produccionDetalleLote, LimpiezaTipo limpiezatipo) {
		
		LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote = null;
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				Timestamp fecha = new Timestamp(new Date().getTime());
				LimpiezaDetalleProcesoLote ldpl = new LimpiezaDetalleProcesoLote();
				ldpl.setEstado(1);
				ldpl.setFechainicio(fecha);
				ldpl.setFechareg(fecha);
				//Sale del proceso apertura cierre activo
				ldpl.setLimpiezaProceso(limpiezaProceso);
				ldpl.setLimpiezaTipo(limpiezatipo);
				ldpl.setProduccionDetalleLote(produccionDetalleLote);
				ldpl.setUsuario( new UsuarioDAOJpaImpl().getUser(usuario) );
				ldpl.setTurno( new TurnoDAOJpaImpl().getFindTurnoId(1) );
				
				em.merge(ldpl);

				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		return limpiezaDetalleProcesoLote;
	}

	
	
	@Override
	public LimpiezaDetalleProcesoLote anular(LimpiezaProceso limpiezaProceso, ProduccionDetalleLote produccionDetalleLote) {
		
		LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote = null;
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				Timestamp fecha = new Timestamp(new Date().getTime());
				LimpiezaDetalleProcesoLote ldpl = new LimpiezaDetalleProcesoLote();
				ldpl.setEstado(-2);
				ldpl.setFechareg(fecha);
				ldpl.setUsuario( new UsuarioDAOJpaImpl().getUser(usuario) );
				em.merge(ldpl);

				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		return limpiezaDetalleProcesoLote;
	}

	
	@Override
	public void saveOrUpdate(LimpiezaDetalleProcesoLote limpiezadetalleprocesolote) {

		try{
	    	 EntityTransaction t = em.getTransaction();
	    	  try {
					t.begin();  
						em.merge(limpiezadetalleprocesolote);
	 			        t.commit();
    		  } finally {
    		    if (t.isActive()) t.rollback();
    		  }
			}finally{
				em.close();
			}
	}	
	
	
	@Override
	public void cerrar(ProduccionDetalleLote produccionDetalleLote) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				// Del combo lote se obtiene ProduccionDetalleLote
				// Se saca del detalle con el dato de la cabecera
				String jpql = "Select o from LimpiezaDetalleProcesoLote o where o.produccionDetalleLote.idproducciondetallelote = "+produccionDetalleLote.getIdproducciondetallelote();

				List <LimpiezaDetalleProcesoLote>items = em.createQuery(jpql).getResultList();
				LimpiezaDetalleProcesoLote ldpl = (LimpiezaDetalleProcesoLote)items.get(0);
				ldpl.setEstado(0);
				ldpl.setFechafin(new Timestamp(new Date().getTime()));
				em.merge(ldpl);
				
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
	public void reaperturar(ProduccionDetalleLote produccionDetalleLote) {
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				// Del combo lote se obtiene ProduccionDetalleLote
				// Se saca del detalle con el dato de la cabecera
				String jpql = "Select o from LimpiezaDetalleProcesoLote o where o.produccionDetalleLote.idproducciondetallelote = "+produccionDetalleLote.getIdproducciondetallelote();

				List <LimpiezaDetalleProcesoLote>items = em.createQuery(jpql).getResultList();
				LimpiezaDetalleProcesoLote ldpl = (LimpiezaDetalleProcesoLote)items.get(0);
				ldpl.setEstado(1);
				ldpl.setFechafin(new Timestamp(new Date().getTime()));
				em.merge(ldpl);
				
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
	public LimpiezaDetalleProcesoLote getActivo(ProduccionDetalleLote produccionDetalleLote) {
		String sql = "Select o from LimpiezaDetalleProcesoLote o where o.estado=1 and o.produccionDetalleLote.idproducciondetallelote = "+produccionDetalleLote.getIdproducciondetallelote();
		List <LimpiezaDetalleProcesoLote>items = em.createQuery(sql).getResultList();
		return ( items == null || items.isEmpty() ) ? null: (LimpiezaDetalleProcesoLote) items.get(0);
	}

	public LimpiezaDetalleProcesoLote getLimpiezaProcesoAperturado(ProduccionDetalleLote produccionDetalleLote, LimpiezaProceso lp ) {
		try {
			Query qry = em.createQuery("Select o from LimpiezaDetalleProcesoLote o where o.estado=1 and " +
					" o.produccionDetalleLote = :pdl and o.limpiezaProceso= :lp");
			qry.setParameter("pdl", produccionDetalleLote);
			qry.setParameter("lp", lp);
			return (LimpiezaDetalleProcesoLote) qry.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
				
	}	

	
	public LimpiezaDetalleProcesoLote aperturar2(LimpiezaProceso limpiezaProceso, ProduccionDetalleLote produccionDetalleLote, LimpiezaTipo limpiezatipo) {
		
		LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote = null;
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				Timestamp fecha = new Timestamp(new Date().getTime());
				LimpiezaDetalleProcesoLote ldpl = new LimpiezaDetalleProcesoLote();
				ldpl.setEstado(1);
				ldpl.setFechainicio(fecha);
				ldpl.setFechareg(fecha);
				//Sale del proceso apertura cierre activo
				ldpl.setLimpiezaProceso(limpiezaProceso);
				ldpl.setLimpiezaTipo(limpiezatipo);
				ldpl.setProduccionDetalleLote(produccionDetalleLote);
				ldpl.setUsuario( new UsuarioDAOJpaImpl().getUser(usuario) );
				ldpl.setTurno( new TurnoDAOJpaImpl().getFindTurnoId(1) );
				
				limpiezaDetalleProcesoLote=	em.merge(ldpl);

				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		return limpiezaDetalleProcesoLote;
	}	
	
	
}
