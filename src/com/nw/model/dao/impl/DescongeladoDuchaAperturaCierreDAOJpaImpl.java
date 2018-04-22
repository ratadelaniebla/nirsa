package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Cocina;
import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.CuartoChillroomCocinadaDetalle;
import com.nw.model.DescongeladoDucha;
import com.nw.model.DescongeladoDuchaAperturaCierreDetalle;
import com.nw.model.Produccion;
import com.nw.model.RociadoCicloDetalle;
import com.nw.model.RociadoCocinadaDetalle;
//import com.nw.model.dao.CocinaAperturaCierreDAO;
import com.nw.model.dao.DescongeladoDuchaAperturaCierreDetalleDAO;


public class DescongeladoDuchaAperturaCierreDAOJpaImpl extends BaseDaoJpaImpl

	implements DescongeladoDuchaAperturaCierreDetalleDAO {



    private static Log logger = LogFactory.getLog(CamaraRegistroCajonBarcoDescargaDAOJpaImpl.class);

    @PersistenceContext
	 private EntityManagerFactory emf;
	 private EntityManager em;


    
	 public DescongeladoDuchaAperturaCierreDAOJpaImpl() 
	 {
	// emf = Persistence.createEntityManagerFactory("NW");
	   emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	   em = emf.createEntityManager();   
	 }
	
		
	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDuchaAperturaCierreDetalle> obtenerDuchasDetalle(Produccion idPro) 
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DescongeladoDuchaAperturaCierreDetalle> duchas = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		try {
			Query query = em.createQuery("select c from DescongeladoDuchaAperturaCierreDetalle c where c.estado IN (1,3) and c.produccion=:prod");
			query.setParameter("prod", idPro);
			duchas = (List<DescongeladoDuchaAperturaCierreDetalle>) query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return duchas;
	}
	

	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDuchaAperturaCierreDetalle> obtenerDuchasDetalleOrdenado(Produccion idPro) 
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DescongeladoDuchaAperturaCierreDetalle> duchas = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		try {
			Query query = em.createQuery("select c from DescongeladoDuchaAperturaCierreDetalle c " +
					" where c.estado IN (1,3) and c.produccion=:prod " +
					" order by c.descongeladoDucha.idducha ");
			query.setParameter("prod", idPro);
			duchas = (List<DescongeladoDuchaAperturaCierreDetalle>) query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return duchas;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDuchaAperturaCierreDetalle> obtenerDuchasReaperturar(Produccion idPro) 
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DescongeladoDuchaAperturaCierreDetalle> duchas = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		try {
			Query query = em.createQuery("select c from DescongeladoDuchaAperturaCierreDetalle c where c.produccion=:prod  and c.estadoduchada =1 and  c.estado =2");
			query.setParameter("prod", idPro);
			duchas = (List<DescongeladoDuchaAperturaCierreDetalle>) query.getResultList();
		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return duchas;
	}	

	
	@SuppressWarnings("unchecked")
	public List<CocinaAperturaCierreDetalle> obtenerCocinasReaperturarCerrar(Produccion idPro) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<CocinaAperturaCierreDetalle> cocinas = new ArrayList<CocinaAperturaCierreDetalle>();

		try {
			Query query = em
					.createQuery("select c from CocinaAperturaCierreDetalle c where c.estado IN (1,3) and c.produccion=:prod order by c.numerococinadageneral");
			query.setParameter("prod", idPro);
			cocinas = (List<CocinaAperturaCierreDetalle>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return cocinas;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<CocinaAperturaCierreDetalle> obtenerCocinasxProduccion(Produccion idPro) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<CocinaAperturaCierreDetalle> cocinas = new ArrayList<CocinaAperturaCierreDetalle>();

		try {
			Query query = em
					.createQuery("select c from CocinaAperturaCierreDetalle c where c.produccion=:prod order by c.numerococinadageneral");
			query.setParameter("prod", idPro);
			cocinas = (List<CocinaAperturaCierreDetalle>) query
					.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return cocinas;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDuchaAperturaCierreDetalle> obtenerFinalizarDuchada(Produccion idPro) 
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DescongeladoDuchaAperturaCierreDetalle> duchas = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		try {
			Query query = em.createQuery("select c from DescongeladoDuchaAperturaCierreDetalle c where c.estadoduchada=1 and c.produccion=:prod order by c.descongeladoDucha.idducha");
			query.setParameter("prod", idPro);
			duchas = (List<DescongeladoDuchaAperturaCierreDetalle>) query.getResultList();

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
		}
		return duchas;
	}
	
	 public Long obtenerTotalCocinas(Integer id, Produccion prod) {
			EntityManagerFactory emf = JPAPersistenceManager.getInstance()
					.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("select count(ca.cocina) from CocinaAperturaCierreDetalle ca"
							+ " where ca.cocina.idcocina =:id and ca.produccion=:prod "); // :idedp
			query.setParameter("id", id);
			query.setParameter("prod", prod);
			// Object obj = query.getSingleResult();
			Long resultado = (Long) query.getSingleResult();
			// Sistema.mensaje("cantidad de registros-->"+resultado);
			return resultado;
		}
	
	
	public CocinaAperturaCierreDetalle obtenerCocinaMaxNumero(Produccion idPro,Cocina cocina) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		CocinaAperturaCierreDetalle cocinas = new CocinaAperturaCierreDetalle();

		try {
			Query query = em
					.createQuery("select cacd from CocinaAperturaCierreDetalle cacd where cacd.idcocinaaperturacierredetalle = " +
							"(select max(c.idcocinaaperturacierredetalle) from CocinaAperturaCierreDetalle c where c.cocina=:cocina and c.produccion=:prod)");
			query.setParameter("cocina", cocina);
			query.setParameter("prod", idPro);
			cocinas = (CocinaAperturaCierreDetalle) query.getSingleResult();
			return cocinas;

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
			return null;
		}
		
	}
	
	@Override
	public void saveOrUpdate(DescongeladoDuchaAperturaCierreDetalle descongeladoduchaaperturacierredetalle) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.merge(descongeladoduchaaperturacierredetalle);
				t.commit();
			} finally {
				if (t.isActive())
					t.rollback();
			}
		} finally {
			em.close();
		}
		
	}

	public CocinaAperturaCierreDetalle obtenerCocinaNumero(Produccion idPro) {  //,Cocina cocina
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		CocinaAperturaCierreDetalle cocinas = new CocinaAperturaCierreDetalle();

		try {
			Query query = em
					.createQuery("select cacd from CocinaAperturaCierreDetalle cacd where cacd.idcocinaaperturacierredetalle = " +
							"(select max(c.idcocinaaperturacierredetalle) from CocinaAperturaCierreDetalle c where c.produccion=:prod)"); //c.cocina=:cocina and 
//			query.setParameter("cocina", cocina);
			query.setParameter("prod", idPro);
			cocinas = (CocinaAperturaCierreDetalle) query.getSingleResult();
			return cocinas;

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
			return null;
		}
		
	}	
	
	@SuppressWarnings("unchecked")
	public List<DescongeladoDuchaAperturaCierreDetalle> obtenerDuchaMaxNumero1(Produccion idPro,  DescongeladoDucha descongeladoducha) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DescongeladoDuchaAperturaCierreDetalle> duchas = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		try {
			Query query = em.createQuery("select cacd from DescongeladoDuchaAperturaCierreDetalle cacd where  cacd.descongeladoDucha=:descongeladoducha and " +
							" cacd.produccion=:prod");
			
//			Query query = em.createQuery("select cacd from DescongeladoDuchaAperturaCierreDetalle cacd where cacd.produccion=:prod" +
//					" and cacd.numeroduchadageneral is not null  "); //c.cocina=:cocina and 
//					query.setParameter("prod", idPro);			
			
			query.setParameter("descongeladoducha", descongeladoducha);
			query.setParameter("prod", idPro);
//			cocinas = (CocinaAperturaCierreDetalle) query.getSingleResult();
			duchas=query.getResultList();
			return duchas; 
			
			
			

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
			return null;
		}
}

	@SuppressWarnings("unchecked")
	public List<DescongeladoDuchaAperturaCierreDetalle> obtenerDuchaNumero1(Produccion idPro) 
	{  
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DescongeladoDuchaAperturaCierreDetalle> duchadas = new ArrayList<DescongeladoDuchaAperturaCierreDetalle>();

		try {
			Query query = em.createQuery("select cacd from DescongeladoDuchaAperturaCierreDetalle cacd where cacd.produccion=:prod" +
							" and cacd.numeroduchadageneral is not null  "); //c.cocina=:cocina and 
			query.setParameter("prod", idPro);
			duchadas=query.getResultList();			
			return duchadas;

		} catch (Exception e) {
			System.out.println("paso esto realizando la consulta-->"
					+ e.getMessage());
			return null;
		}		
	}

@SuppressWarnings("unchecked")
public List<Object[]> obtenerCocinasReaperturarCerrar1() {
	EntityManagerFactory emf = JPAPersistenceManager.getInstance()
			.getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();

	List<Object[]> results = null;
	try {
		Query query = em
				.createQuery("select max(c.idcocinaaperturacierredetalle), c.cocina.idcocina from CocinaAperturaCierreDetalle c where c.estado IN (1,3) and c.cocina.idcocina not in (88,99) group by c.cocina.idcocina order by c.cocina.idcocina asc");
		
		results =  query.getResultList();

	} catch (Exception e) {
		System.out.println("paso esto realizando la consulta-->"
				+ e.getMessage());
	}
	return results;
}	


public CocinaAperturaCierreDetalle CocinaAperturaCierreDetalleByID(CocinaAperturaCierreDetalle cacd) 
{
       Query qry = em.createQuery("select cacd from CocinaAperturaCierreDetalle cacd " +
       		"where cacd.idcocinaaperturacierredetalle = '" + cacd.getIdcocinaaperturacierredetalle().toString() + "' ")
       		.setFirstResult(0);    
       

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
       return (CocinaAperturaCierreDetalle) lista;
}



public RociadoCicloDetalle RociadoCicloDetalleByID(Long id) 
{
       Query qry = em.createQuery("select cacd from RociadoCicloDetalle cacd " +
       		"where cacd.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '" + id.toString() + "' order by cacd.idrociadocliclodetalle desc")
       		.setFirstResult(0);    
       

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
       return (RociadoCicloDetalle) lista;
}



public CocinaAperturaCierreDetalle CocinaAperturaCierreDetalleByID1(CocinaAperturaCierreDetalle cacd) {  //,Cocina cocina
	EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
	EntityManager em = emf.createEntityManager();
	CocinaAperturaCierreDetalle cocinas = new CocinaAperturaCierreDetalle();

	try {
		Query query = em.createQuery("select cacd from CocinaAperturaCierreDetalle cacd where cacd.idcocinaaperturacierredetalle =:prod)"); //c.cocina=:cocina and 
		query.setParameter("prod", cacd.getIdcocinaaperturacierredetalle());
		cocinas = (CocinaAperturaCierreDetalle) query.getSingleResult();
		return cocinas;

	} catch (Exception e) {
		System.out.println("paso esto realizando la consulta-->"
				+ e.getMessage());
		return null;
	}
	
}


public RociadoCocinadaDetalle RociadoCocinadaDetalleByID(Long id) 
{
       Query qry = em.createQuery("select cacd from RociadoCocinadaDetalle cacd " +
       		"where cacd.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '" + id.toString() + "' order by cacd.idrociadococinadadetalle desc")
       		.setFirstResult(0);    
       

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
       return (RociadoCocinadaDetalle) lista;
}	

public CuartoChillroomCocinadaDetalle CuartoCocinadaDetalleByID(Long id) 
{
       Query qry = em.createQuery("select cacd from CuartoChillroomCocinadaDetalle cacd " +
                    "where cacd.cocinaAperturaCierreDetalle.idcocinaaperturacierredetalle = '" + id.toString() + "' order by cacd.idcuartochillroomcocinadadetalle desc")
                    .setFirstResult(0);    
       

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
       return (CuartoChillroomCocinadaDetalle) lista;
}



}
