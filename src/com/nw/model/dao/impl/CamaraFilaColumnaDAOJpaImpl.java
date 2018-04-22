package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.CamaraFilaColumna;
import com.nw.model.dao.CamaraFilaColumnaDAO;

import com.nw.temp.model.ColumnaCamara;
import com.nw.temp.model.FilaCamara;

@SuppressWarnings("unchecked")
public class CamaraFilaColumnaDAOJpaImpl extends BaseDaoJpaImpl implements
		CamaraFilaColumnaDAO {

	@SuppressWarnings("unused")
	private static Log logger = LogFactory
			.getLog(CamaraFilaColumnaDAOJpaImpl.class);
   
	//private Session session;
	
	@PersistenceContext
	private EntityManagerFactory emf;
	private EntityManager em;

	public CamaraFilaColumnaDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	public List<CamaraFilaColumna> getCamaraFilas(int i) {// CamaraFilaColumna
		return em.createQuery(
				"select c from CamaraFilaColumna c where c.camara.idcamara ="
						+ i + "order by c.idfila ").getResultList();
	}

	public List<CamaraFilaColumna> getCamaraColumnas(int i) {
		return em.createQuery(
				"select c from CamaraFilaColumna c where c.camara.idcamara ="
						+ i + "order by c.idcolumna ").getResultList();
	}
	
//	SELECT  idfila  from camara_fila_columna 
//	 where camara_fila_columna.idcamara =1
//	group by idfila order by idfila
	public List<FilaCamara> obtenerFilas(int idcamara)
	{
		List<FilaCamara> filas = new ArrayList<FilaCamara>();

		 Query query =  em.createQuery(" select cfc.idfila from CamaraFilaColumna cfc " +
		 		" inner join cfc.camara c" +
					" where c.idcamara = :idcam " +
					"group by cfc.idfila order by cfc.idfila");
		      query.setParameter("idcam", idcamara);
		      List<Integer> listaFilas = (List<Integer>)  query.getResultList();
		      for (Integer dat : listaFilas) {
				//System.out.println("dat-->"+dat);
				FilaCamara fc = new FilaCamara();
				fc.setFila( dat );
				filas.add(fc);
			}
		
		return filas;
	}
	
	
//	SELECT  idfila  from camara_fila_columna 
//	 where camara_fila_columna.idcamara =1 and camara_fila_columna.idcolumna = 'A'
//	group by idfila order by idfila	
	public List<FilaCamara> obtenerFilasConIdColumna(int idcamara, String idcolumna)
	{
		List<FilaCamara> filas = new ArrayList<FilaCamara>();
		 System.out.println("ingrese ");
		 Query query =  em.createQuery(" select cfc.idfila from CamaraFilaColumna cfc " +
		 		" inner join cfc.camara c" +
					" where c.idcamara = :idcam  and cfc.idcolumna = :idcol " +
					"group by cfc.idfila order by cfc.idfila");
		      query.setParameter("idcam", idcamara);
		      query.setParameter("idcol", idcolumna);
		      List<Integer> listaFilas = (List<Integer>)  query.getResultList();
		      for (Integer dat : listaFilas) {
				//System.out.println("dat-->"+dat);
				FilaCamara fc = new FilaCamara();
				fc.setFila( dat );
				filas.add(fc);
			}
		
		return filas;
	}
	
	
	
	
//	SELECT  idcolumna  from camara_fila_columna 
//	 where camara_fila_columna.idcamara =1
//	group by idcolumna order by idcolumna
	public List<ColumnaCamara> obtenerColumnas (int idcamara)
	{
		List<ColumnaCamara> columnas = new ArrayList<ColumnaCamara>();
		
		 Query query =  em.createQuery(" select cfc.idcolumna from CamaraFilaColumna cfc " +
		 		" inner join cfc.camara c" +
					" where c.idcamara = :idcam " +
					"group by cfc.idcolumna order by cfc.idcolumna"); //cambiar aki 
		      query.setParameter("idcam", idcamara);
		      List<String> listaColumnas = (List<String>)  query.getResultList();
		      for (String dat : listaColumnas) {
				//System.out.println("dato de columna -->"+dat);
		    	 ColumnaCamara cc = new ColumnaCamara();
				cc.setColumna( dat );
				columnas.add(cc);
			}
		
		return columnas;
	}
	


//	SELECT  idcolumna  from camara_fila_columna 
//	 where camara_fila_columna.idcamara =1
//	group by idcolumna order by idcolumna
	public List<ColumnaCamara> obtenerColumnas2 (int idcamara)
	{
		List<ColumnaCamara> columnas = new ArrayList<ColumnaCamara>();
		
		 Query query =  em.createQuery(" select cfc.idcolumna from CamaraFilaColumna cfc " +
		 		" inner join cfc.camara c" +
					" where c.idcamara = :idcam and cfc.idcolumna is not null " +
					" group by cfc.idcolumna order by cfc.idcolumna"); //cambiar aki 
		      query.setParameter("idcam", idcamara);
		      List<String> listaColumnas = (List<String>)  query.getResultList();
		      for (String dat : listaColumnas) {
				//System.out.println("dato de columna -->"+dat);
		    	 ColumnaCamara cc = new ColumnaCamara();
				cc.setColumna( dat );
				columnas.add(cc);
			}
		
		return columnas;
	}
	
	
//	public List<FilaCamara> obtenerCamaraFilas(int i) {
//		//List<CamaraFilaColumna>	columnas = null;
//		List<FilaCamara> filas = null;
//		Query q1 = (Query) session.createSQLQuery("SELECT  idfila as fila from " +
//				"camara_fila_columna  where idcamara ="+ i +" group by idfila")
//				.addScalar("fila")
//				.setInteger(1, i)
//				.setResultTransformer(
//						Transformers
//								.aliasToBean(CamaraFilaColumna.class))
//				.setCacheMode(CacheMode.GET);
//		filas = q1.getResultList();
//		
//		return filas;
//		
//	}

	
	//SELECT  * from camara_fila_columna  where idcamara = 1 and idcolumna = 'B' and idfila = 2
	public CamaraFilaColumna getIdFilaColumna(Long idcamara, int idfila, String idcolumna) {
		CamaraFilaColumna cfc = new CamaraFilaColumna();
		Query query = em
				.createQuery("select cfc from CamaraFilaColumna cfc " +
						" inner join cfc.camara c" +
						"  where c.idcamara= :camara and cfc.idfila = :fila"
						+ " and cfc.idcolumna = :columna "
						+ "'order by cfc.idcamarafilacolumna ");
		      query.setParameter("camara", idcamara);
		      query.setParameter("fila", idfila);
		      query.setParameter("columna", idcolumna);
		         
		cfc = (CamaraFilaColumna) query.getSingleResult();
		return cfc;

	}

	public CamaraFilaColumna getIdFilaColumna2(Long idcamara, int idfila, String idcolumna) {
		CamaraFilaColumna cfc = new CamaraFilaColumna();
		Query query = em
				.createQuery("select cfc from CamaraFilaColumna cfc " +
						" inner join cfc.camara c" +
						"  where c.idcamara= :camara and cfc.idfila = :fila"
						+ " and cfc.idcolumna = :columna "
						+ "'order by cfc.idcamarafilacolumna ");
		      query.setParameter("camara", idcamara);
		      query.setParameter("fila", idfila);
		      query.setParameter("columna", idcolumna);
		         
		      
		    try {
		    	cfc = (CamaraFilaColumna) query.getSingleResult();
		    	return cfc;
			} catch (Exception e) {
				return null;
			}  
	
		

	}	
	
	@Override
	public void saveOrUpdate(CamaraFilaColumna camaraFilaColumna) {

	}

}
