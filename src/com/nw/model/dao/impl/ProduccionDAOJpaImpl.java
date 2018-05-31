package com.nw.model.dao.impl;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraCajonUbicacion;
import com.nw.model.Produccion;
import com.nw.model.ProduccionArchivoCargaLote;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.ProduccionDetalleLoteCajon;
import com.nw.model.dao.ProduccionDAO;
//import com.sun.xml.internal.bind.v2.TODO;

public class ProduccionDAOJpaImpl extends BaseDaoJpaImpl implements ProduccionDAO {

	@PersistenceContext
	private EntityManagerFactory emf  ;
	private EntityManager em  ;

	 
	
	public ProduccionDAOJpaImpl() {
		emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}

	@Override                                                                             
	public List<Produccion> getProducciones() {
		String sql = "select o from Produccion o where o.estado=1";
		return em.createQuery(sql).getResultList();
	}
	
	/**
	 * Este metodo obtiene la produccion activa
	 * @return
	 */
	public List<Object[]> obtenerFecha()
	{
		//Date fecha;
		//Este metodo obtiene la produccion activa
		
		Query qry = em.createQuery("SELECT p.idproduccion, p.fechaproduccion FROM Produccion p " +
				"where p.estado = 2");  
		
		System.out.println("Fecha consultada");
		
		//Object obj = qry.getSingleResult();
		List<Object[]> listDatos = qry.getResultList();
		
	    return listDatos;
		
	}
	
	//NUEVO//
	public Produccion getProduccionById(long vid)
	{
		Produccion prod = new Produccion();

		try{

		Query qry = em.createQuery("SELECT p FROM Produccion p" +
		" where p.idproduccion = :vid ");
		
		qry.setParameter("vid", vid);
	
		prod = (Produccion) qry.getSingleResult();
		System.out.println("el resultado"+prod.getEstado()+"fecha"+prod.getFechaproduccion());
		}
		catch (RuntimeException e) {
			return prod;
		}		
		return prod; 		
	}
	
	
	public Produccion getFechaProduccionActiva()
	{
		
		Query qry = em.createQuery("SELECT p FROM Produccion p " +
				"where p.estado = 2");  
		
		System.out.println("Fecha consultada");
		
		return (Produccion) qry.getSingleResult();
		
	}

	public List<Produccion> getListaFechaProduccionActiva()
	{
		
		Query qry = em.createQuery("SELECT p FROM Produccion p " +
				"where p.estado = 1");  
		
		List<Produccion> lista = qry.getResultList();
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Produccion> getListaUltimasDosProduccionesActivas() {
		Query qry = em.createQuery("SELECT p FROM Produccion p " +
				"where p.estado = 1 order by p.fechaproduccion desc ");  
		qry.setMaxResults(3);
		List<Produccion> lista = qry.getResultList(); 
		
		return lista;
	}
	
	public List<Produccion> getListaFechaProduccionActivaNoActiva()
	{
		
		Query qry = em.createQuery("SELECT p FROM Produccion p " +
				"where p.estado in (0,1) ");  
		
		List<Produccion> lista = qry.getResultList();
		
		return lista;
	}

	
	public List<Produccion> getListaFechaProduccionUnoCero(Integer select)
	{
		Query qry;
		if (select == 1)
		{
			qry = em.createQuery("SELECT p FROM Produccion p " +
					"where p.estado in (0,1) and p.idproduccion not in (select ep.produccion.idproduccion from EvisceradoProceso ep ) ");  
		}
		else
		{
			qry = em.createQuery("SELECT p FROM Produccion p " +
					"where p.idproduccion " +
					"in (select ep.produccion.idproduccion from EvisceradoProceso ep where ep.procesoAperturaCierre.estado = 1) ");  
		}
			
		
		List<Produccion> lista = qry.getResultList();
		
		return lista;
		
	}	
	
	
	
	
	public List<Produccion> getListaFechaProduccionUnoCeroDescongelado(Integer select)
	{
		Query qry;
		if (select == 1)
		{
			qry = em.createQuery("SELECT p FROM Produccion p " +
					"where p.estado in (0,1) and p.idproduccion not in (select ep.produccion.idproduccion from DescongeladoProceso ep ) ");  
		}
		else
		{
			qry = em.createQuery("SELECT p FROM Produccion p " +
					"where p.idproduccion " +
					"in (select ep.produccion.idproduccion from DescongeladoProceso ep where ep.procesoAperturaCierre.estado = 1) ");  
		}
			
		
		List<Produccion> lista = qry.getResultList();
		
		return lista;
		
	}	
	
	
//	select p.* from proceso_apertura_cierre pac, eviscerado_proceso ev, produccion p
//	where pac.estado = 1 and pac.idproceso = 3 
//	and pac.idprocesoaperturacierre = ev.idprocesoaperturacierre 
//	and ev.idproduccion = p.idproduccion
	
	
	
	public List<Produccion> getListaFechaProduccionActivaEviscerdo()
	{
		
		Query qry = em.createQuery("SELECT p FROM ProcesoAperturaCierre pac,  EvisceradoProceso ev, Produccion p  " +
				"where pac.estado = 1 and pac.proceso.idproceso = 3 " +
				"and pac.idprocesoaperturacierre = ev.procesoAperturaCierre.idprocesoaperturacierre " +
				"and ev.produccion.idproduccion = p.idproduccion" +
				" order by p.idproduccion ");  
		
		List<Produccion> lista = qry.getResultList();
		
		return lista;
		
	}
	
	public List<Produccion> getListaFechaProduccionActivaDescongelado()
	{
		
		Query qry = em.createQuery("SELECT p FROM ProcesoAperturaCierre pac,  DescongeladoProceso ev, Produccion p  " +
				"where pac.estado = 1 and pac.proceso.idproceso = 5 " +
				"and pac.idprocesoaperturacierre = ev.procesoAperturaCierre.idprocesoaperturacierre " +
				"and ev.produccion.idproduccion = p.idproduccion");  
		
		List<Produccion> lista = qry.getResultList();
		
		return lista;
		
	}	
	
	
	public List<Produccion> getListaFechaProduccionActivaCoccion()
	{
		
		Query qry = em.createQuery("SELECT p FROM ProcesoAperturaCierre pac,  EvisceradoProceso ev, Produccion p  " +
				"where pac.estado = 1 and pac.proceso.idproceso = 3 " +
				"and pac.idprocesoaperturacierre = ev.procesoAperturaCierre.idprocesoaperturacierre " +
				"and ev.produccion.idproduccion = p.idproduccion");  
		
		List<Produccion> lista = qry.getResultList();
		
		return lista;
		
	}	
	
	
	public List<Produccion> getListaFechaProduccionActivaRociado()
	{
		
		Query qry = em.createQuery("SELECT p FROM ProcesoAperturaCierre pac,  EvisceradoProceso ev, Produccion p  " +
				"where pac.estado = 1 and pac.proceso.idproceso = 3 " +
				"and pac.idprocesoaperturacierre = ev.procesoAperturaCierre.idprocesoaperturacierre " +
				"and ev.produccion.idproduccion = p.idproduccion");  
		
		List<Produccion> lista = qry.getResultList();
		
		return lista;
		
	}	
	
	public Date obtenerFechaProduccion()
	{
		//Date fecha;
		Query qry = em.createQuery("SELECT MAX(p.fechaproduccion) FROM Produccion p");  
		Object obj = qry.getSingleResult();
	    return (Date)obj;
		
	}
	
	
	
	
	public int ObtenerUltimoestado()
	{
		Query qry = em.createQuery("SELECT MAX(p.estado) FROM Produccion p");  
		Object objEst = qry.getSingleResult();
		return (Integer)objEst;
	}
	
//	SELECT MAX(Produccion.idproduccion) FROM Produccion inner join produccion_archivo_carga_lote on 
//	(Produccion.idproduccion=produccion_archivo_carga_lote.idproduccion)
//	where turnoarchivo=2
	public Produccion obtenerUltimoproduccion()
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Produccion prod = new Produccion();
		//SELECT * FROM produccion ORDER BY idproduccion DESC LIMIT 1
		long codigo;
		Query qry = em.createQuery("SELECT MAX(p.idproduccion) FROM Produccion p " );
//				"inner join " +
//				"p.produccionArchivoCargaLotes acp where acp.turnoarchivo= :Idturno ");
		//qry.setParameter("Idturno", para_idturno);
		Object objCod = qry.getSingleResult();
		codigo = (Long)objCod;
		Query qryPro = em.createQuery("SELECT p FROM Produccion p " + 
									" where p.idproduccion = :idpro ");
	
		qryPro.setParameter("idpro", codigo);
		
		prod = (Produccion) qryPro.getSingleResult();
		return prod;
	}
	
	@Override
	public Produccion saveOrUpdate(Produccion produccion) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Produccion ProduccionDevuelto = null;
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				ProduccionDevuelto = em.merge(produccion); 
				t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			ProduccionDevuelto = null;
			if (t.isActive()){    
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		
		return ProduccionDevuelto;
	}
	
 
	
	public void guardarCabeceraCamaraCajon(CamaraCajon camaraCajon, CamaraCajonUbicacion ccu)  {   
		CamaraCajon cc = new CamaraCajon();
		Long i;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(camaraCajon);//merge
				 //obtengo y asigno el ultimo id ingresado en la tabla camara_cajon 
				//y lo devuelvo asignado en un objeto del tipo CamaraCajon para q se pueda utilizar 
				// en el otro metodo "guardarCabeceraCabeceraDetalle"
				Query qry = em.createQuery("SELECT MAX(c.idcamaracajon) FROM CamaraCajon c");
			    Object valorMaximoObjeto = qry.getSingleResult();
				i = (Long.valueOf((Long) valorMaximoObjeto));
				cc.setIdcamaracajon(i);
				//asigno el id maximo
				ccu.setCamaraCajon(cc);
				em.merge(ccu);
				
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		//return cc;

	}
	
	/**
	 * Metodo que guarda un Objeto Produccion y devuelve un Objeto
	 * del mismo tipo el cual contiene el idproduccion Maximo 
	 * del ultimo objeto ingresado el cual sera asignado en otro metodo 
	 * que guarda un objeto de tipo ProduccionCargaLote
	 * esto es xq al guardar se ejecutan ambos metodos al mismo tiempo
	 * por la relacion entre ProduccionCargaLote q depende de Produccion  
	 * @param produccion
	 * @return
	 */
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
	//TODO 
	
	@Override
	public void guardarPrducionDetlotCajon(ProduccionDetalleLoteCajon pdlCajon)
	{
		//ProduccionDetalleLoteCajon pdlCajon = new 	ProduccionDetalleLoteCajon();
		//Long i;
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				em.merge(pdlCajon);//merge
				t.commit();
		} catch (RuntimeException e) {
			if (t.isActive()){   //isActive()
				t.rollback();
			}	 
		}
		finally {
			em.close();
		}
		//return prod;

	}
	
	public Produccion consultarEstado(Timestamp fecha,Timestamp fecha2)
	{
		Produccion prod = new Produccion();

		try{

		Query qry = em.createQuery("SELECT p FROM Produccion p" +
		" where p.fechaproduccion >= :fec1 and p.fechaproduccion<= :fec2");
		
		qry.setParameter("fec1", fecha);
		qry.setParameter("fec2", fecha2);
	
		prod = (Produccion) qry.getSingleResult();
		System.out.println("el resultado"+prod.getEstado()+"fecha"+prod.getFechaproduccion());
		}
		catch (RuntimeException e) {
			return prod;
		}
		
		return prod; 
		
	}

	public BarcoDescarga  ConsultaIdBarco(String para_barco)
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		BarcoDescarga bd=new BarcoDescarga();
		try{
			Query qry = em.createQuery("Select bd from BarcoDescarga bd  where bd.registro = :nombre");
			qry.setParameter("nombre", para_barco);


//			Object valorObjeto = qry.getSingleResult();
//			i = (String.valueOf(valorObjeto));
			bd =(BarcoDescarga) qry.getSingleResult();
			System.out.println("cod barco  "+bd.getIdbarcodescarga());

			return bd;
		}
		catch (RuntimeException e) {
			return null;
		}
		
	}

	public BarcoDescarga consultarIdBarco(String para_barco,String idBarco){
		BarcoDescarga barcodescarga =  new BarcoDescarga();
		try{

			Query qry = em.createQuery("Select bd  from BarcoDescarga bd  where bd.registro = :nombre and bd.barco.numbarco= :idBarco");
			
			qry.setParameter("nombre", para_barco);
			qry.setParameter("idBarco", idBarco);
			barcodescarga = (BarcoDescarga) qry.getSingleResult();

			return barcodescarga;
			}
			catch (RuntimeException e) {

				System.out.println(e.getMessage());
				return null;
			}
	}
	
	public boolean consultarEspecie(int para_id)
	{
		boolean consulta= false;
		try{

			Query qry = em.createQuery("Select et.idespecietalla from EspecieTalla et " +
					"where et.idespecietalla = :id_especie");
			
			
			qry.setParameter("id_especie", para_id);
			String i;
			int codigo;
			Object valorMaximoObjeto = qry.getSingleResult();
			i = (String.valueOf(valorMaximoObjeto));
			codigo= (Integer.valueOf(i));
			System.out.println("el resultado"+codigo);
			consulta= true;
			}
			catch (RuntimeException e) {
				System.out.println(e.getMessage());
				return consulta;
			}
		return consulta;
	}
	
	public Long consultarIdCamaraCajon(String idcajon)
	{
		CamaraCajon camaracajo = new CamaraCajon();
		Long idCamaraCaj = null;
		boolean consulta= false;
		//try{

			Query qry = em.createQuery("select cc.idcamaracajon from CamaraCajon  cc inner join cc.cajon c  where c.idcajon= :id_cajon");
			qry.setParameter("id_cajon", idcajon);
			
			int codigo;
			Object valorMaximoObjeto = qry.getSingleResult();
			idCamaraCaj = (Long.valueOf((Long) valorMaximoObjeto));
			
			System.out.println("el resultado///-->"+idCamaraCaj);
			
			//camaracajo=(CamaraCajon)qry.getSingleResult(); 
			/*}
			catch (RuntimeException e) {
				//return PDLoteCajon;
			}*/
		return idCamaraCaj;
	}
	
	public void guardar(CamaraCajon  cc ){
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				//em.merge(cc); 
				em.createNativeQuery("insert into ...").setParameter(1, cc.getIdcamaracajon()).executeUpdate();
				
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
	
	public Produccion consultarfechadeProduccion(Timestamp fecha)
	{
		Produccion prod = new Produccion();
		boolean validar=true;
		try{

		Query qry = em.createQuery("SELECT p FROM Produccion p" +
		" where p.produccionArchivoCargaLotes.fechaarchivo = :fec1 ");
		
		qry.setParameter("fec1", fecha);
		
		prod = (Produccion) qry.getSingleResult();
		System.out.println("el resultado"+prod.getEstado()+"fecha"+prod.getFechaproduccion());
		return prod;
		}
		catch (RuntimeException e) {
			return prod;
		}
		
		
	}
	
	public List<Produccion> consultarProduccionporFecha(Timestamp fecha)
	{
		List<Produccion> pro = new ArrayList<Produccion>();
		boolean validar=true;
		try{

		Query qry = em.createQuery("SELECT p FROM Produccion p" +
		" where p.produccionArchivoCargaLotes.fechaarchivo = :fec1 ");
		
		qry.setParameter("fec1", fecha);
		
		pro = qry.getResultList();
		
		return pro;
		}
		catch (RuntimeException e) {
			return pro;
		}
	}
	public List<Produccion> consultarfechaTurnodeProduccion(Timestamp fecha, Integer turno)
	{
		List<Produccion> prod =  new ArrayList<Produccion>();
		boolean validar=true;
		try{

		Query qry = em.createQuery("SELECT p FROM Produccion p inner join p.produccionArchivoCargaLotes pacl where p.fechaproduccion = :fec1 and pacl.turnoarchivo= :turno ");
		//Query qry = em.createQuery("SELECT p FROM ProduccionArchivoCargaLote p inner join p.produccion pacl where p.fechaarchivo = :fec1 and p.turnoarchivo= :turno ");
		qry.setParameter("fec1", fecha);
		qry.setParameter("turno", turno);
		
		
		
		return qry.getResultList();
		}
		catch (RuntimeException e) {
			return prod;
		}
		
	}

	
	public List<Produccion> consultarfechaProduccion(Timestamp fecha)
	{
		List<Produccion> prod =  new ArrayList<Produccion>();
		boolean validar=true;
		try{

		Query qry = em.createQuery("SELECT p FROM Produccion p where p.fechaproduccion = :fec1  and p.estado in (0, 1) ");
		//Query qry = em.createQuery("SELECT p FROM ProduccionArchivoCargaLote p inner join p.produccion pacl where p.fechaarchivo = :fec1 and p.turnoarchivo= :turno ");
			//Query qry = em.createQuery("SELECT p FROM Produccion p  inner join p.ProduccionArchivoCargaLote pa where p.fechaproduccion = :fec1  and p.estado in (0, 1) ");
		qry.setParameter("fec1", fecha);
		
		return qry.getResultList();
		}
		catch (RuntimeException e) {
			return prod;
		}
		
	}	
	
	
	public ProduccionArchivoCargaLote obtenerTurno(Long codigo)
	{
		ProduccionArchivoCargaLote prod = new ProduccionArchivoCargaLote();
		//SELECT * FROM produccion ORDER BY idproduccion DESC LIMIT 1
		long idp;
		try {
			
			
			Query qryPro = em.createQuery("SELECT pacl FROM ProduccionArchivoCargaLote pacl inner join pacl.produccion p  " + 
										" where p.idproduccion = :idpro ");
		
			qryPro.setParameter("idpro", codigo);
			
			prod = (ProduccionArchivoCargaLote) qryPro.getSingleResult();
			return prod;
		} catch (Exception e) {

			return prod;
		}

	}
	
public List<ProduccionArchivoCargaLote> ListaProduccionArchivoLote(Long codigo, Integer idturno){
		
		List<ProduccionArchivoCargaLote> lista = new ArrayList<ProduccionArchivoCargaLote>();
		Query qryPro = em.createQuery("SELECT pacl FROM ProduccionArchivoCargaLote pacl inner join pacl.produccion p  " + 
				" where p.idproduccion = :idpro and pacl.turnoarchivo= :turno ");

		qryPro.setParameter("idpro", codigo);
		qryPro.setParameter("turno", idturno);
		return qryPro.getResultList();
		
		
	}


    public Produccion BurcarFechaProduccionporFecha(String fecha) 
    { 
          
          StringBuffer sb = new StringBuffer();
          sb.append("Select p "); 
          sb.append("From Produccion p "); 
          sb.append("Where p.fechaproduccion = '" + fecha + "' and p.estado in (0, 1, 2)"); 
          
          //logger.info(CalidadSensorialMp.class +" -> "+sb.toString());

          List items =  em.createQuery(sb.toString()).getResultList();

     if (items == null || items.isEmpty()) {
         return null;
     } else {
         return  (Produccion) items.get(0);
     }           
    }

    //Nuevo 06-04-2016
    public List<Produccion> BurcarUltimasProducciones(Integer ultimas) 
    { 
          
           
  		List<Produccion> lista = new ArrayList<Produccion>();
  		Query qryPro = em.createQuery("SELECT p FROM Produccion p " + 
  				" Where p.estado in (0, 1, 2) order by p.idproduccion desc");

  		return qryPro.getResultList().subList(0, ultimas);          
    } 


    
    
    
	
    @SuppressWarnings("unchecked")
    public List<ProduccionDetalleLote> obtenerProduccionDetalleloteEspecialidades(Long idprod, Integer idtur) {
            Query qry= em.createQuery("select pdl from ProduccionDetalleLote pdl " +
                            "where pdl.produccion.idproduccion = :idproduc and pdl.turno.idturno = :idturn " +
                            "order by pdl.idlote ");
            
            qry.setParameter("idproduc", idprod);
            qry.setParameter("idturn", idtur);
            
            List <ProduccionDetalleLote> produccionDetalleLote= qry.getResultList();
            return produccionDetalleLote;
            
    }
    
    public List<Produccion> obtenerListaFechaProduccionAperturaCierre(Integer paraEstado)
	{
    	List<Produccion> lista;
		try {
			Query qry = em.createQuery("SELECT p FROM Produccion p " +
					"where p.estado = :estado");  
			qry.setParameter("estado", paraEstado);
			
			lista = qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			lista = null;
		}
		
		
		return lista;
		
	}


    public List<Produccion> obtenerListaFechaProduccionAnular(Integer paraEstado)
	{
    	List<Produccion> lista;
		try {
			Query qry = em.createQuery("SELECT p FROM Produccion p " +
					"where p.estado <= :estado ");  
			qry.setParameter("estado", paraEstado);
			lista = qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			lista = null;
		}
		return lista;
		
	}

    public List<ProduccionArchivoCargaLote> listaProduccionArchivoLotexFecha(Date fecha, Integer idturno){
		List<ProduccionArchivoCargaLote> lista = new ArrayList<ProduccionArchivoCargaLote>();
		try {
			Query qryPro = em.createQuery("SELECT pacl FROM ProduccionArchivoCargaLote pacl " + 
					" where pacl.produccion.fechaproduccion = :fecha and pacl.turnoarchivo= :turno order by pacl.idproduccionarchivocargalote");

			qryPro.setParameter("fecha", fecha);
			qryPro.setParameter("turno", idturno);
			lista= qryPro.getResultList();
			 return lista;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

    public Produccion consultarfechadeProduccionReporte(Timestamp fecha)
	{
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Produccion prod = new Produccion();
		boolean validar=true;
		try{

		Query qry = em.createQuery("SELECT p FROM Produccion p" +
		" where p.fechaproduccion = :fec1 ");
		
		qry.setParameter("fec1", fecha);
		
		prod = (Produccion) qry.getSingleResult();
		System.out.println("el resultado"+prod.getEstado()+"fecha"+prod.getFechaproduccion());
		return prod;
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return prod;
		}
		
		
	}    

    public Produccion getProduccionPorFecha(Date fecha)
   	{
   		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
   				.getEntityManagerFactory();
   		EntityManager em = emf.createEntityManager();
   		Produccion prod = new Produccion();
   		try{

   			Query qry = em.createQuery("SELECT p FROM Produccion p" +
   			" where p.fechaproduccion = :fec1 ");
   			qry.setParameter("fec1", fecha);
   			prod = (Produccion) qry.getSingleResult();
   			return prod;
   		}
   		catch (RuntimeException e) {
   			 
   			return null;
   		}finally{
   			em.close();
   		}
   	}  

    
    //NUEVO 04-04-2016//
    public Produccion getProduccionPorFechaDespedicio(Date fecha)
   	{
   		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
   				.getEntityManagerFactory();
   		EntityManager em = emf.createEntityManager();
   		Produccion prod = new Produccion();
   		try{

   			Query qry = em.createQuery("SELECT p FROM Produccion p" +
   			" where p.fechaproduccion = :fec1 ");
   			qry.setParameter("fec1", fecha);
   			prod = (Produccion) qry.getSingleResult();
   			return prod;
   		}
   		catch (RuntimeException e) {
   			 
   			return null;
   		}
   	}

    
    public BarcoEstibaCuba consultarBarcoEstibaCuba(Long idBarcoDes, Long idbCuba){
    	BarcoEstibaCuba barcoEstibaCuba =  new BarcoEstibaCuba();
		try{

			Query qry = em.createQuery("SELECT bec FROM BarcoEstibaCuba bec" +
					" where bec.barcoDescarga.idbarcodescarga = :idBarcoDescarga  " +
					" and bec.idbarcocuba = :idBCuba");
			qry.setParameter("idBarcoDescarga", idBarcoDes);
			qry.setParameter("idBCuba", idbCuba);
			barcoEstibaCuba = (BarcoEstibaCuba) qry.getSingleResult();

			return barcoEstibaCuba;
			}
			catch (RuntimeException e) {

				System.out.println(e.getMessage());
				return null;
			}
	}    

    
	public Produccion getProduccionByFecha(Timestamp fecha) 
	{ 
			Produccion produccion = null ;//new Produccion();
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select p from Produccion p " +
							" where p.fechaproduccion = :fecha");
					qry.setParameter("fecha", fecha );
					produccion=(Produccion) qry.getSingleResult();
				    return  produccion;
			} catch (RuntimeException e) {
				//e.printStackTrace();
				return null;
			}finally{
	   			em.close();
	   		}
		
	} 
	
	//22-12-2017
	public Produccion getProduccionByFechaDate(Date fecha) 
	{ 
			Produccion produccion = null ;
			EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			try {
					Query qry = em.createQuery("select p from Produccion p " +
							" where func('DATE', p.fechaproduccion ) = func('DATE', :fecha )");
					qry.setParameter("fecha", fecha );
					produccion=(Produccion) qry.getSingleResult();
				    return  produccion;
			} catch (NoResultException ne) {
				System.out.println("No existe produccion para la fecha -> " + fecha);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No existe produccion para la fecha -> " + fecha);
				return null;
			}finally{
	   			em.close();
	   		}
		
	} 
	
	public String getSProduccionById(long vid)
	{
		String prod = "";
		EntityManagerFactory emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		try{

		Query qry = em.createNativeQuery("SELECT to_char(p.fechaproduccion,'YYYY-mm-dd') FROM produccion p" +
		" where p.idproduccion = '"+vid+"' ");
		

	
		prod = (String) qry.getSingleResult();
		
		}
		catch (RuntimeException e) {
			return prod;
		}		
		em.close();
		return prod; 		
	}
}
