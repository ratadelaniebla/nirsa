package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;
 

public class CalidadMuestraResultadoDAOJpaImpl {

	
	public CalidadMuestraResultadoDAOJpaImpl() {
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getCalidadResultadosClasificaiconByIdBarcoDescarga( long idbarcodescarga ) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<Object[]> lista = new ArrayList<>();
		String consulta =" select t1.*  " +
				" ,(select muestracantidad  from calidad_muestra_clasificacion (t1.idcalidadmuestraareacabecera , t1.idcalidadmuestracabeceradescargamotivo )   ) muestracantidad " +
				" ,(select muestravalor     from calidad_muestra_clasificacion (t1.idcalidadmuestraareacabecera , t1.idcalidadmuestracabeceradescargamotivo )   ) muestravalor " +
				" ,(select resultadomuestra from calidad_muestra_clasificacion (t1.idcalidadmuestraareacabecera , t1.idcalidadmuestracabeceradescargamotivo )   ) resultadomuestra " +
				"  from  (   select cmacc.idcalidadmuestraareacabecera, " +
				"   0::bigint idcalidadmuestracabeceradescargamotivo, " +
				"  (select barco.nombre from barco where barco.idbarco=(select barco_descarga.idbarco from barco_descarga where barco_descarga.idbarcodescarga=cmacc.idbarcodescarga ))as barco, " +
				"  (select registro from barco_descarga where idbarcodescarga=cmacc.idbarcodescarga) as registro, " +
				"   (cmacc.lotehaccp) as lotehaccp, " +
				"	(select especie.codigoqm from especie where especie.idespecie=(select especie_talla.idespecie from especie_talla where especie_talla.idespecietalla::INTEGER=cc.idmaterial::INTEGER LIMIT 1 )), " +
				" 	cmacc.totalnetohaccp as cantidad, " +
				"	row_number() OVER () as numero " +
				"	FROM calidad_muestra_area_cabecera cmacc " +
				"	inner join calidad_muestra_area cma " +
				"	on cmacc.idcalidadmuestraarea = cma.idcalidadmuestraarea " +
				"   inner join camara_cajon cc " +
				"	on cc.idcamaracajon=cmacc.idcamaracajon " +
				"	left join calidad_muestra_area_cabecera_aprobacion cmacap " +
				"		on(cmacap.idcalidadmuestraareacabecera = cmacc.idcalidadmuestraareacabecera) " +
				"		WHERE  cmacc.idbarcodescarga = ?1 " +
				"		 and cmacc.idcalidadmuestraarea <> 4 " +
				"			and (select count(cmad1.idcalidadmuestraareadetalle) from calidad_muestra_area_detalle cmad1 " +
				"					where cmad1.idcalidadmuestraareacabecera = cmacc.idcalidadmuestraareacabecera and cmad1.idcalidadmuestragrupoanalisis = 2) > 0 " +
				"  ) t1  " +
				" ORDER BY lotehaccp asc "; 
				 Query query = em.createNativeQuery(consulta);
				 query.setParameter(1, idbarcodescarga);
			
				 lista = (List<Object[]>)query.getResultList();
			 
		 return  lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getCalidadResultadosAccionCorrectivaByIdBarcoDescarga( long idbarcodescarga ) {
		EntityManagerFactory emf = JPAPersistenceManager.getInstance()
				.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<Object[]> lista = new ArrayList<>();
		String consulta =" select t1.*  " +
				" ,(select muestracantidad  from calidad_muestra_accion_correctiva (t1.idcalidadmuestraareacabecera , t1.idcalidadmuestracabeceradescargamotivo )   ) muestracantidad " +
				" ,(select muestravalor     from calidad_muestra_accion_correctiva (t1.idcalidadmuestraareacabecera , t1.idcalidadmuestracabeceradescargamotivo )   ) muestravalor " +
				" ,(select resultadomuestra from calidad_muestra_accion_correctiva (t1.idcalidadmuestraareacabecera , t1.idcalidadmuestracabeceradescargamotivo )   ) resultadomuestra " +
				"  from  (   select cmacc.idcalidadmuestraareacabecera, " +
				"   cmdm.idcalidadmuestracabeceradescargamotivo, " +
				"  (select barco.nombre from barco where barco.idbarco=(select barco_descarga.idbarco from barco_descarga where barco_descarga.idbarcodescarga=cmacc.idbarcodescarga ))as barco, " +
				"  (select registro from barco_descarga where idbarcodescarga=cmacc.idbarcodescarga) as registro, " +
				"   (cmacc.lotehaccp) as lotehaccp, " +
				"	(select especie.codigoqm from especie where especie.idespecie=(select especie_talla.idespecie from especie_talla where especie_talla.idespecietalla::INTEGER=cc.idmaterial::INTEGER LIMIT 1 )), " +
				" 	cmacc.totalnetohaccp as cantidad, " +
				"	row_number() OVER () as numero " +
				"	FROM calidad_muestra_area_cabecera cmacc " +
				"	inner join calidad_muestra_area cma " +
				"	on cmacc.idcalidadmuestraarea = cma.idcalidadmuestraarea " +
				"   inner join camara_cajon cc " +
				"	on cc.idcamaracajon=cmacc.idcamaracajon " +
				"	left join calidad_muestra_area_cabecera_aprobacion cmacap " +
				"		on(cmacap.idcalidadmuestraareacabecera = cmacc.idcalidadmuestraareacabecera) " +
				"	  inner join calidad_muestra_cabecera_descarga_motivo cmdm  " +
				"		on cmacc.idcalidadmuestraareacabecera = cmdm.idcalidadmuestraareacabecera "+
				"		WHERE  cmacc.idbarcodescarga = ?1 " +
				"		 and cmacc.idcalidadmuestraarea = 4 " +
				"			and (select count(cmad1.idcalidadmuestraareadetalle) from calidad_muestra_area_detalle cmad1 " +
				"					where cmad1.idcalidadmuestraareacabecera = cmacc.idcalidadmuestraareacabecera and cmad1.idcalidadmuestragrupoanalisis = 2) > 0 " +
				"  ) t1  " +
				" ORDER BY lotehaccp asc "; 
				 Query query = em.createNativeQuery(consulta);
				 query.setParameter(1, idbarcodescarga);
			
				 lista = (List<Object[]>)query.getResultList();
			 
		 return  lista;
	}
}
