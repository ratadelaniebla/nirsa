package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.avante.core.jpa.JPAPersistenceManager;


@SuppressWarnings({"unchecked"})
public class ExcelDAOJpaImpl extends BaseDaoJpaImpl{

	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public ExcelDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
    
    //TODO O EJEMPLO DE NATIVE QUERY
    /**
     * Devuelve la consulta nativa SQL de datos de desperdicios
     * @param fechaProduccion
     * @param turno
     * @return
     */
    public List<Object[]> getDatosDesperdicio(String fechaProduccion, int turno){
    	StringBuilder sb = new StringBuilder();
    	sb.append("select "); 
    	sb.append("d.iddesperdiciodetalle, "); 
    	sb.append("d.idlugardetalle, "); 
    	sb.append("dch.fechaproduccion, "); 
    	sb.append("(select nombre from area where area.idarea = d.idarea) descripcionarea, "); 
    	sb.append("(select descripcionlugar from lugar WHERE idlugar = d.idlugar) lugar, "); 
    	sb.append("(select descripcion from subproducto where idsubproducto = d.idsubproducto)descripcionsubproducto, "); 
    	sb.append("(select numerolugar from lugar_detalle WHERE idlugardetalle = d.idlugardetalle) linea, "); 
    	sb.append("d.pesoneto pesoneto, "); 
    	sb.append("(SELECT array_to_string(array_agg(lote) , ', ') "); 

    	sb.append("FROM detalle_lote_desperdicio "); 
    	sb.append("where iddesperdiciodetalle = d.iddesperdiciodetalle "); 
    	sb.append("GROUP BY iddesperdiciodetalle) lotes, ");
    	
    	sb.append(" to_char(d.fecharegistro, 'dd-mm-yyyy HH24:MI:SS') fecharegistro ");
    	
    	
    	sb.append("from desperdicio_cajon_harina dch inner join desperdicio_detalle d "); 
    	sb.append("on (dch.iddesperdiciocajonharina = d.iddesperdiciocajonharina) "); 
    	sb.append(String.format("where dch.fechaproduccion = '%s' and dch.idturnodesperdicio = %s ", fechaProduccion, turno));
    	sb.append("order by d.fecharegistro ");
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
    
    
    public List<Object[]> getDatosPesos(String fechaProduccion, int turno)
    {
    	StringBuilder sb = new StringBuilder();

    	sb.append(" select ");    
    	sb.append(" trim(to_char(to_date(to_char(p.fechaproduccion, 'YYYY/MM/DD'),'YYYY/MM/DD'), 'YYYYMMDD')::TEXT) fechapro,    ");
    	sb.append(" trim(pdl.idturno::TEXT) turno,    ");
    	sb.append(" trim(ldpb.idlinea::TEXT) mesa,   ");
    	sb.append(" trim(ldpb.codpersona) codtra,   ");

    	sb.append(" (select trim((to_char(gt.fechahoraincio,'HH24MI00')::NUMERIC)::TEXT) from gestion_turno gt WHERE gt.fechaproduccion = p.fechaproduccion and gt.idturno = 1) hordes,   ");
    	sb.append(" (select trim((to_char(gt.fechahorafin,'HH24MI00')::NUMERIC)::TEXT)   from gestion_turno gt WHERE gt.fechaproduccion = p.fechaproduccion and gt.idturno = 1) horhas,   ");

    	sb.append(" trim('SJ') especi,   ");
    	sb.append(" trim('L') tipoli,   ");

    	sb.append(" case when ldpl.idlimpiezatipo = 1 THEN trim('S') ELSE trim('D') END codlim,   ");
    	sb.append(" trim(ldpb.idgrupotalla::TEXT) canast,   ");

    	sb.append(" --------------------   ");
    	sb.append(" -- HORAS NORMALES --   ");
    	sb.append(" --------------------   ");
    	sb.append(" trim(((SUM(ldpb.peso))/1000)::TEXT) cannor, ");   

    	sb.append(" ------------------   ");
    	sb.append(" -- HORAS EXTRAS --   ");
    	sb.append(" ------------------   ");
    	sb.append(" trim(0::TEXT) canext,   ");

    	sb.append(" trim(0::TEXT) peso,   ");
    	sb.append(" trim(0::TEXT) pesope,   ");
    	sb.append(" '' timeep,   ");
    	sb.append(" '' empnue,   ");
    	sb.append(" trim('NMENDOZA') usring,   ");
    	sb.append(" trim(to_char(NOW()::date, 'YYYYMMDD')::TEXT) fecing,   ");
    	sb.append(" trim(to_char(current_timestamp, 'HH24:MI:SS')::TEXT) horing,   ");
    	sb.append(" '' usract,   ");
    	sb.append(" trim((-99999999)::TEXT) fecact,   ");
    	sb.append(" trim(('00:00:00')::TEXT) horact ");
    	sb.append(" -- relacionamos la tabla produccion con la produccion_detalle_lote (esta contiene los lotes cargados de la produccion)   ");
    	sb.append(" from produccion p inner join produccion_detalle_lote pdl   ");
    	sb.append(" on p.idproduccion = pdl.idproduccion   ");
    	sb.append(" -- la tabla limpieza_detalle_proceso_lote (contiene todo los lotes abiertos y cerrados de los turnos de produccion para ser usuados por los usuarioa de las lineas)   ");
    	sb.append(" inner join limpieza_detalle_proceso_lote ldpl    ");
    	sb.append(" on pdl.idproducciondetallelote = ldpl.idproducciondetallelote   ");
    	sb.append(" -- la limpieza_detalle_proceso_bandeja se encuentra relacionada con la tabla limpieza_detalle_proceso_lote,   ");
    	sb.append(" -- y contiene al al detalle los lotes usados peso a peso    ");
    	sb.append(" inner JOIN limpieza_detalle_proceso_bandeja ldpb    ");
    	sb.append(" on ldpl.idlimpiezadetalleprocesolote = ldpb.idlimpiezadetalleprocesolote   ");
    	sb.append(" -- FILTRAMOS POR LAA FECHA DE PRODUCCION QUE ESTEN CERRADAS (ESTADO = 2), LOS LOTES QUE ESTEN ABIERTOS/CERRADOS (ldpl.estado IN (1,0)) Y LOS LOTES DEL TURNO 1   ");
    	sb.append(" where p.fechaproduccion = '2014-04-10' and p.estado in (2) and ldpl.estado in (1,0) and pdl.idturno = 1    ");
    	sb.append(" AND ldpb.fechareg <= (select gt.fechahorafin from gestion_turno gt WHERE gt.fechaproduccion = p.fechaproduccion and gt.idturno = 1)   ");
    	sb.append(" GROUP BY ldpb.codpersona, ldpb.idgrupotalla, ldpl.idlimpiezatipo, ldpb.idlinea, pdl.idturno,p.idproduccion   ");

    	sb.append(" UNION ALL   ");

    	sb.append(" ---------------------------   ");
    	sb.append(" -- HORARIO EXTRA TURNO 1 --   ");
    	sb.append(" ---------------------------   ");
    	sb.append(" select     ");
    	sb.append(" trim(to_char(to_date(to_char(p.fechaproduccion, 'YYYY/MM/DD'),'YYYY/MM/DD'), 'YYYYMMDD')::TEXT) fechapro,    ");
    	sb.append(" trim(pdl.idturno::TEXT) turno,    ");
    	sb.append(" trim(ldpb.idlinea::TEXT) mesa,   ");
    	sb.append(" trim(ldpb.codpersona::TEXT) codtra, ");  

    	sb.append(" (select trim((to_char(gt.fechahoraincio,'HH24MI00')::NUMERIC)::TEXT) from gestion_turno gt WHERE gt.fechaproduccion = p.fechaproduccion and gt.idturno = 2)::TEXT hordes,   ");
    	sb.append(" (select trim((to_char(gt.fechahorafin,'HH24MI00')::NUMERIC)::TEXT)   from gestion_turno gt WHERE gt.fechaproduccion = p.fechaproduccion and gt.idturno = 2)::TEXT horhas,   ");

    	sb.append(" trim('SJ') especi,   ");
    	sb.append(" trim('L') tipoli,   ");

    	sb.append(" case when ldpl.idlimpiezatipo = 1 THEN trim('S') ELSE trim('D') END codlim,   ");
    	sb.append(" trim(ldpb.idgrupotalla::TEXT) canast,   ");

    	sb.append(" --------------------   ");
    	sb.append(" -- HORAS NORMALES --   ");
    	sb.append(" --------------------   ");
    	sb.append(" trim(0::TEXT) cannor,   ");

    	sb.append(" ------------------   ");
    	sb.append(" -- HORAS EXTRAS --   ");
    	sb.append(" ------------------   ");
    	sb.append(" trim(((SUM(ldpb.peso))/1000)::TEXT) canext, ");

    	sb.append(" trim(0::TEXT) peso,   ");
    	sb.append(" trim(0::TEXT) pesope,   ");
    	sb.append(" '' timeep,   ");
    	sb.append(" '' empnue,   ");
    	sb.append(" trim('NMENDOZA') usring,   ");

    	sb.append(" trim(to_char(NOW()::date, 'YYYYMMDD')::TEXT) fecing,   ");
    	sb.append(" trim(to_char(current_timestamp, 'HH24:MI:SS')::TEXT) horing,   ");
    	sb.append(" '' usract,   ");
    	sb.append(" trim((-99999999)::TEXT) fecact,   ");
    	sb.append(" trim(('00:00:00')::TEXT) horact  ");
    	sb.append(" -- relacionamos la tabla produccion con la produccion_detalle_lote (esta contiene los lotes cargados de la produccion)   ");
    	sb.append(" from produccion p inner join produccion_detalle_lote pdl   ");
    	sb.append(" on p.idproduccion = pdl.idproduccion   ");
    	sb.append(" -- la tabla limpieza_detalle_proceso_lote (contiene todo los lotes abiertos y cerrados de los turnos de produccion para ser usuados por los usuarioa de las lineas)   ");
    	sb.append(" inner join limpieza_detalle_proceso_lote ldpl    ");
    	sb.append(" on pdl.idproducciondetallelote = ldpl.idproducciondetallelote   ");
    	sb.append(" -- la limpieza_detalle_proceso_bandeja se encuentra relacionada con la tabla limpieza_detalle_proceso_lote,   ");
    	sb.append(" -- y contiene al al detalle los lotes usados peso a peso    ");
    	sb.append(" inner JOIN limpieza_detalle_proceso_bandeja ldpb    ");
    	sb.append(" on ldpl.idlimpiezadetalleprocesolote = ldpb.idlimpiezadetalleprocesolote   ");
    	sb.append(" -- FILTRAMOS POR LAA FECHA DE PRODUCCION QUE ESTEN CERRADAS (ESTADO = 2), LOS LOTES QUE ESTEN ABIERTOS/CERRADOS (ldpl.estado IN (1,0)) Y LOS LOTES DEL TURNO 1   ");
    	sb.append(" where p.fechaproduccion = '2014-04-10' and p.estado in (2) and ldpl.estado in (1,0) and pdl.idturno = 1    ");
    	sb.append(" AND ldpb.fechareg > (select gt.fechahorafin from gestion_turno gt WHERE gt.fechaproduccion = p.fechaproduccion and gt.idturno = 1)   ");
    	sb.append(" GROUP BY ldpb.codpersona, ldpb.idgrupotalla, ldpl.idlimpiezatipo, ldpb.idlinea, pdl.idturno,p.idproduccion  ");     	
    	    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }    
    
    
    /**
     * Devuelve la consulta nativa SQL de datos de limpieza
     * @param fechaProduccion
     * @param turno
     * @param mesa
     * @return
     */
    public List<Object[]> getDatosLimpieza(int formato, String fechaProduccion, int turno, int... mesa){
    	StringBuilder sb = new StringBuilder();
    	sb.append("select (select produccion.fechaproduccion from produccion where idproduccion = pdl.idproduccion) FechaProd, "); 
    	sb.append("ldpb.idturno Turno, "); 
    	sb.append("ldpb.idlinea Mesa, "); 
    	sb.append("ldpb.idusuario Usuario, "); 
    	sb.append("ldpb.fechareg Fechareg, "); 
    	sb.append("ldpb.ubicacionpersona Ubic, "); 
    	sb.append("ldpb.codpersona CodEmpleado, "); 
    	sb.append("(select nombres from empleado where  empleado.codpersona = ldpb.codpersona) Empleado, "); 
    	sb.append("pdl.idlote Lote, "); 
    	sb.append("pdl.peso PesoLote, "); 
    	
    	sb.append("(select especie.nombre from especie where especie.idespecie = (select idespecie from especie_talla where especie_talla.idespecietalla = pdl.idespecietalla)) Especie, "); 
    	sb.append("(select nombre from talla where talla.idtalla = (select idtalla from especie_talla where especie_talla.idespecietalla = pdl.idespecietalla)) Talla, ");
    	
    	//sb.append("(ldpb.peso)/1000 PesoLomo, ");     	 
    	//sb.append("(ldpb.pesorallado)/1000 PesoRallado, ");

    	//2 Columnas de pesos
    	if(formato == 1 || formato == 4)
    	{
//    		sb.append("(ldpb.peso)/1000 PesoLomo, ");
//    		sb.append("(ldpb.peso)/1000 PesoRallado, ");
    		
        	sb.append("(case when ldpb.idlimpiezamaterial = 1 then (ldpb.peso)/1000 else null end) PesoLomo, ");     		
        	sb.append("(case when ldpb.idlimpiezamaterial = 2 then (ldpb.peso)/1000 else null end) PesoRallado, ");        		
    		sb.append("(ldpb.peso)/1000 PesoTotal, ");
    		
    	}
    	else
    		// 1 Columna de Peso y otra de indicación
    		if(formato == 2)
    		{
        		sb.append("(ldpb.peso)/1000 Peso, ");    	
        		sb.append("(select nombre from limpieza_material where idlimpiezamaterial =  ldpb.idlimpiezamaterial2) tipo, ");
        		sb.append("(ldpb.peso)/1000 PesoTotal, ");
    		}
    		else
	    		{
	        		sb.append("(ldpb.peso)/1000 PesoLomo, ");     		
	        		sb.append("(ldpb.pesorallado)/1000 PesoRallado, ");
	        		sb.append("(ldpb.peso + ldpb.pesorallado)/1000 PesoTotal, "); 
	    		}
    	
    	//Total de bandejas por pesada
		if(formato == 4)
		{
//			sb.append("case when ldpb.idlimpiezadetalleprocesobandejareq = ldpb.idlimpiezadetalleprocesobandeja THEN ");						
//			sb.append("(select count (idlimpiezadetalleprocesobandejareq) - 1");
//			sb.append("from limpieza_detalle_proceso_bandeja ");
//			sb.append("where limpieza_detalle_proceso_bandeja.idlimpiezadetalleprocesobandejareq = ldpb.idlimpiezadetalleprocesobandeja) ");
//			sb.append("else ");
//			sb.append("		0 ");
//			sb.append("end numbandejas, ");


			sb.append("case when idlimpiezamaterial = 2 THEN "); 
			sb.append("numerobandejas -1 "); 
			sb.append("else  ");
			sb.append("	null "); 
			sb.append("end numbandejas, ");
			
			//sb.append("from limpieza_detalle_proceso_bandeja ldpb ");
		}
    	
    	
    	//sb.append("(ldpb.peso + ldpb.pesorallado)/1000 PesoTotal, "); 
    	//sb.append("(ldpb.peso)/1000 PesoTotal, ");
    	sb.append("ldpb.tarjetapersonalinea Tarjeta "); 
    	
    	sb.append("from limpieza_detalle_proceso_bandeja ldpb inner JOIN limpieza_detalle_proceso_lote ldpl "); 
    	sb.append("on ldpb.idlimpiezadetalleprocesolote = ldpl.idlimpiezadetalleprocesolote "); 
    	sb.append("inner JOIN  produccion_detalle_lote pdl "); 
    	sb.append("on ldpl.idproducciondetallelote = pdl.idproducciondetallelote "); 
    	sb.append("inner join produccion p "); 
    	sb.append("on pdl.idproduccion = p.idproduccion ");
    	sb.append(String.format("where p.fechaproduccion = '%s' and ldpb.idturno = %s ", fechaProduccion, turno) );

    	//Si viene el parámetro opcional, entonces usarlo...
    	if (mesa.length == 1)
    		sb.append(String.format("and ldpb.idlinea = %s ", mesa[0]));
    	
    	sb.append("order by ldpb.fechareg ");
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
    


    
    public List<Object[]> getDatosPonchadas(String fechaProduccion1, String fechaProduccion2)
    {
    	StringBuilder sb = new StringBuilder();
    	

    	sb.append("(select ");
    	sb.append("to_char(p.fechaproduccion, 'DD/MM/YYYY')::TEXT fechaproduccion, ");
    	
    	sb.append("lp.idturno, ");
    	sb.append("e.codigoevolution as codigoevolution, ");
    	sb.append("e.cedula, ");
    	sb.append("e.nombres, ");

    	sb.append("CASE WHEN ec.descripcion = 'PANZA' THEN ");
    	sb.append(" 'PANZA' ");
    	sb.append(" ELSE ");
    	sb.append(" 'FILETEADO' ");
    	sb.append("END  tipo, ");
    	sb.append("ec.descripcion corte, ");
    	sb.append("lt.descripcion, ");
    	sb.append("epl.especificacion, ");

    	sb.append("case when ldpc.horaextra = 0 or ldpc.horaextra is null then ");
    	sb.append(" ldpc.numponchada ");
    	sb.append(" ELSE ");
    	sb.append(" 0 ");
    	sb.append("end as numponchada_normal, ");

    	sb.append("case when ldpc.horaextra = 1 then ");
    	sb.append(" ldpc.numponchada ");
    	sb.append(" ELSE ");
    	sb.append(" 0 ");
    	sb.append("end as numponchada_extra, ");

    	sb.append("ldpc.idlinea linea, ");

    	sb.append("( ");
    	sb.append("select lpe1.ubicacion ");
    	sb.append("from limpieza_proceso_empleado lpe1 ");
    	sb.append("where lpe1.idempleado = e.idempleado ");
    	sb.append("and lpe1.idlimpiezaproceso = lp.idlimpiezaproceso limit 1 ");
    	sb.append(") ubicacion, ");
    	
    	sb.append("to_char(ldpc.fechareg , 'DD/MM/YYYY HH24:MI:SS')::TEXT fechareg ");

    	sb.append("from limpieza_fileteado_ponchada ldpc, limpieza_proceso lp, produccion p, eviscerado_corte ec, eviscerado_pescados_lata epl, empleado e, limpieza_tipo lt ");
    	sb.append("where ");
    	sb.append("ldpc.idlimpiezaproceso = lp.idlimpiezaproceso ");
    	sb.append("and lp.idproduccion = p.idproduccion ");
    	sb.append("and ldpc.idevisceradocorte = ec.idevisceradocorte ");
    	sb.append("and ldpc.idevisceradopescadoslata = epl.idevisceradopescadoslata ");
    	sb.append("and ldpc.idlimpiezatipo = lt.idlimpiezatipo ");
    	sb.append("and ldpc.idempleado = e.idempleado and ldpc.numponchada > 0 ");
    	sb.append(String.format("and p.fechaproduccion >= '%s' and p.fechaproduccion <= '%s' )", fechaProduccion1, fechaProduccion2));
    	
    	
    	sb.append("UNION ALL ");
    	   	
    	sb.append("(select ");
    	sb.append("to_char(p.fechaproduccion, 'DD/MM/YYYY')::TEXT fechaproduccion, ");
    	sb.append("lp.idturno, ");
    	sb.append("e.codigoevolution as codigoevolution, ");
    	sb.append("e.cedula, ");
    	sb.append("e.nombres, ");
    	
    	sb.append("CASE WHEN ec.descripcion = 'PANZA' THEN ");
    	sb.append("  'PANZA' ");
    	sb.append(" ELSE ");
    	sb.append(" 'DESPELLEJADO' ");
    	sb.append("END  tipo, ");

    	
    	sb.append("ec.descripcion corte, ");
    	sb.append("lt.descripcion, ");
    	sb.append("epl.especificacion, ");

    	sb.append("case when ldpc.horaextra = 0 or ldpc.horaextra is null then ");
    	sb.append("  ldpc.numponchada ");
    	sb.append(" ELSE ");
    	sb.append(" 0 ");
    	sb.append("end as numponchada_normal, ");

    	sb.append("case when ldpc.horaextra = 1 then ");
    	sb.append(" ldpc.numponchada ");
    	sb.append(" ELSE ");
    	sb.append(" 0 ");
    	sb.append("end as numponchada_extra, ");
    	sb.append("ldpc.idlinea linea, ");
    	sb.append("( ");
    	sb.append("select lpe1.ubicacion ");
    	sb.append("from limpieza_proceso_empleado lpe1 ");
    	sb.append("where lpe1.idempleado = e.idempleado ");
    	sb.append("and lpe1.idlimpiezaproceso = lp.idlimpiezaproceso limit 1 ");
    	sb.append(") ubicacion, ");
    	sb.append("to_char(ldpc.fechareg , 'DD/MM/YYYY HH24:MI:SS')::TEXT fechareg ");

    	sb.append("from limpieza_despellejado_ponchada ldpc, limpieza_proceso lp, produccion p, eviscerado_corte ec, eviscerado_pescados_lata epl, empleado e, limpieza_tipo lt ");
    	sb.append("where ");
    	sb.append("ldpc.idlimpiezaproceso = lp.idlimpiezaproceso ");
    	sb.append("and lp.idproduccion = p.idproduccion ");
    	sb.append("and ldpc.idevisceradocorte = ec.idevisceradocorte ");
    	sb.append("and ldpc.idevisceradopescadoslata = epl.idevisceradopescadoslata ");
    	sb.append("and ldpc.idlimpiezatipo = lt.idlimpiezatipo ");
    	sb.append("and ldpc.idempleado = e.idempleado and ldpc.numponchada > 0 ");
    	sb.append(String.format("and p.fechaproduccion >= '%s' and p.fechaproduccion <= '%s' ", fechaProduccion1, fechaProduccion2));
    	sb.append("order by p.idproduccion, ldpc.idturno, ldpc.idlinea, ubicacion, e.nombres, numponchada) ");

    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }    
    
    
    
    
    
    
    public List<Object[]> getDatosPonchadasFileteadoPanzas(String fechaProduccion1, String fechaProduccion2)
    {
    	StringBuilder sb = new StringBuilder();
    	

    	sb.append("(select ");
    	sb.append("to_char(p.fechaproduccion, 'DD/MM/YYYY')::TEXT fechaproduccion, ");
    	
    	sb.append("lp.idturno, ");
    	sb.append("e.codigoevolution as codigoevolution, ");
    	sb.append("e.cedula, ");
    	sb.append("e.nombres, ");

    	sb.append("CASE WHEN ec.descripcion = 'PANZA' THEN ");
    	sb.append(" 'PANZA' ");
    	sb.append(" ELSE ");
    	sb.append(" 'FILETEADO' ");
    	sb.append("END  tipo, ");
    	sb.append("ec.descripcion corte, ");
    	sb.append("lt.descripcion, ");
    	sb.append("epl.especificacion, ");

    	sb.append("case when ldpc.horaextra = 0 or ldpc.horaextra is null then ");
    	sb.append(" ldpc.numponchada ");
    	sb.append(" ELSE ");
    	sb.append(" 0 ");
    	sb.append("end as numponchada_normal, ");

    	sb.append("case when ldpc.horaextra = 1 then ");
    	sb.append(" ldpc.numponchada ");
    	sb.append(" ELSE ");
    	sb.append(" 0 ");
    	sb.append("end as numponchada_extra, ");

    	sb.append("ldpc.idlinea linea, ");

    	sb.append("( ");
    	sb.append("select lpe1.ubicacion ");
    	sb.append("from limpieza_proceso_empleado lpe1 ");
    	sb.append("where lpe1.idempleado = e.idempleado ");
    	sb.append("and lpe1.idlimpiezaproceso = lp.idlimpiezaproceso limit 1 ");
    	sb.append(") ubicacion, ");
    	
    	sb.append("to_char(ldpc.fechareg , 'DD/MM/YYYY HH24:MI:SS')::TEXT fechareg ");

    	sb.append("from limpieza_fileteado_ponchada ldpc, limpieza_proceso lp, produccion p, eviscerado_corte ec, eviscerado_pescados_lata epl, empleado e, limpieza_tipo lt ");
    	sb.append("where ");
    	sb.append("ldpc.idlimpiezaproceso = lp.idlimpiezaproceso ");
    	sb.append("and lp.idproduccion = p.idproduccion ");
    	sb.append("and ldpc.idevisceradocorte = ec.idevisceradocorte ");
    	sb.append("and ldpc.idevisceradopescadoslata = epl.idevisceradopescadoslata ");
    	sb.append("and ldpc.idlimpiezatipo = lt.idlimpiezatipo ");
    	sb.append("and ldpc.idempleado = e.idempleado and ldpc.numponchada > 0 ");
    	sb.append(String.format("and p.fechaproduccion >= '%s' and p.fechaproduccion <= '%s' ", fechaProduccion1, fechaProduccion2));
    	sb.append("order by p.idproduccion, ldpc.idturno, ldpc.idlinea, ubicacion, e.nombres, numponchada) ");
    	   	
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
    
    
    
    
    public List<Object[]> getDatosPonchadasDespellejado(String fechaProduccion1, String fechaProduccion2)
    {
    	StringBuilder sb = new StringBuilder();
    	

    	sb.append("(select ");
    	sb.append("to_char(p.fechaproduccion, 'DD/MM/YYYY')::TEXT fechaproduccion, ");
    	sb.append("lp.idturno, ");
    	sb.append("e.codigoevolution as codigoevolution, ");
    	sb.append("e.cedula, ");
    	sb.append("e.nombres, ");
    	
    	sb.append("CASE WHEN ec.descripcion = 'PANZA' THEN ");
    	sb.append("  'PANZA' ");
    	sb.append(" ELSE ");
    	sb.append(" 'DESPELLEJADO' ");
    	sb.append("END  tipo, ");

    	
    	sb.append("ec.descripcion corte, ");
    	sb.append("lt.descripcion, ");
    	sb.append("epl.especificacion, ");

    	sb.append("case when ldpc.horaextra = 0 or ldpc.horaextra is null then ");
    	sb.append("  ldpc.numponchada ");
    	sb.append(" ELSE ");
    	sb.append(" 0 ");
    	sb.append("end as numponchada_normal, ");

    	sb.append("case when ldpc.horaextra = 1 then ");
    	sb.append(" ldpc.numponchada ");
    	sb.append(" ELSE ");
    	sb.append(" 0 ");
    	sb.append("end as numponchada_extra, ");
    	sb.append("ldpc.idlinea linea, ");
    	sb.append("( ");
    	sb.append("select lpe1.ubicacion ");
    	sb.append("from limpieza_proceso_empleado lpe1 ");
    	sb.append("where lpe1.idempleado = e.idempleado ");
    	sb.append("and lpe1.idlimpiezaproceso = lp.idlimpiezaproceso limit 1 ");
    	sb.append(") ubicacion, ");
    	sb.append("to_char(ldpc.fechareg , 'DD/MM/YYYY HH24:MI:SS')::TEXT fechareg ");

    	sb.append("from limpieza_despellejado_ponchada ldpc, limpieza_proceso lp, produccion p, eviscerado_corte ec, eviscerado_pescados_lata epl, empleado e, limpieza_tipo lt ");
    	sb.append("where ");
    	sb.append("ldpc.idlimpiezaproceso = lp.idlimpiezaproceso ");
    	sb.append("and lp.idproduccion = p.idproduccion ");
    	sb.append("and ldpc.idevisceradocorte = ec.idevisceradocorte ");
    	sb.append("and ldpc.idevisceradopescadoslata = epl.idevisceradopescadoslata ");
    	sb.append("and ldpc.idlimpiezatipo = lt.idlimpiezatipo ");
    	sb.append("and ldpc.idempleado = e.idempleado and ldpc.numponchada > 0 ");
    	sb.append(String.format("and p.fechaproduccion >= '%s' and p.fechaproduccion <= '%s' ", fechaProduccion1, fechaProduccion2));
    	sb.append("order by p.idproduccion, ldpc.idturno, ldpc.idlinea, ubicacion, e.nombres, numponchada) ");
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
    
    
    


    /**
     * Devuelve la consulta nativa SQL de datos de calidad
     * 2014-02-19 
     * @param calidadPccId
     * @return
     */
    public List<Object[]> getDatosCalidadPcc1(long calidadPccId){
    	StringBuilder sb = new StringBuilder();

    	sb.append("select "); 
    	sb.append("(case when b.idpropiedad = 5 then "); 
    	sb.append("b.nombre || ' (' || (select descripcionmercante from  mercante where idmercante = (select idmercante from barco_descarga where idbarcodescarga = bd.idbarcodescarga)) || ')' "); 
    	sb.append("else "); 
    	sb.append("b.nombre "); 
    	sb.append("end) as barco, "); 
    	sb.append("b.numbarco, det.nummuestreo, ltrim(mues.descripcion,'#') as muestreo, "); 

    	sb.append("	case when det.lotecamara is null THEN ");
    	sb.append("	''  ");
    	sb.append("	else ");
    	sb.append("	det.lotecamara ");
    	sb.append("	end lotecamara, ");
    	
//    	sb.append("	(select 'L' || array_to_string(array_agg(haccp ), ', ') haccp "); 
//    	sb.append("	from ( select DISTINCT (cc.lotehaccp) haccp ");
//    	sb.append("	from camara_cajon cc  ");
//    	sb.append("	inner join barco_estiba_cuba_detalle_mezcla becdm "); 
//    	sb.append("	on cc.idcamaracajon = becdm.idcamaracajon   ");
//    	sb.append("	inner join barco_estiba_cuba bec   ");
//    	sb.append("	on becdm.idbarcoestibacuba = bec.idbarcoestibacuba "); 
//    	sb.append("	inner join calidad_detalle_pcc cdpp  ");
//    	sb.append("	on becdm.idbarcoestibacuba = cdpp.idbarcoestibacuba ");
//    	sb.append("	where cc.idbarcodescarga = cp.idcalidadpcc  ");
//    	sb.append("	and cdpp.lotecamara = det.lotecamara  ");
//    	sb.append("	order by cc.lotehaccp) t1) haccp,  ");
    	
   	
    	sb.append("	(select 'L' || array_to_string(array_agg(haccp ), ', ') haccp "); 
    	sb.append("	from (select DISTINCT (cc.lotehaccp) haccp   ");
    	sb.append("	from camara_cajon cc    ");
    	sb.append("	inner join barco_estiba_cuba_detalle_mezcla becdm "); 
    	sb.append("	on cc.idcamaracajon = becdm.idcamaracajon    ");
    	sb.append("	inner join barco_estiba_cuba bec     ");
    	sb.append("	on becdm.idbarcoestibacuba = bec.idbarcoestibacuba "); 
    	sb.append("	inner join calidad_detalle_pcc cdpp    ");
    	sb.append("	on becdm.idbarcoestibacuba = cdpp.idbarcoestibacuba ");  
    	sb.append("	where cc.idbarcodescarga = bd.idbarcodescarga and cdpp.lotecamara = cc.lotecamara and  cc.lotecamara = det.lotecamara) t1) haccp,  ");    	
    	
    	
   	sb.append("bd.fechadescarga fecha_descarga, ");    	
    	sb.append("det.fechareg as fecha_inicio_descarga, ");
    	sb.append("to_char (det.fechareg, 'DD.MM.YYYY') as fecha, to_char (det.fechareg, 'HH24:MI:SS') as hora, ");
    	sb.append("bd.registro, cp.idcalidadpcc, cu.nombrecuba, es.nombre as especie, tal.nombre as talla, "); 
/*    	sb.append("tal.nombre as idtalla, ");*/ 
    	sb.append("(case when (tal.idtalla < 10) THEN '0' || tal.idtalla::text else tal.idtalla::text end ) as idtalla, "); 
    	sb.append("(CASE WHEN det.temperatura isnull or det.temperatura = -1999.91 THEN ' - ' "); 
    	sb.append("ELSE round(det.temperatura::numeric,1)::text "); 
    	sb.append("END) temperatura, "); 

    	sb.append("(CASE WHEN det.sal isnull or det.sal = -1999.91 THEN  ' - ' "); 
    	sb.append("ELSE round(det.sal::numeric,2)::text "); 
    	sb.append("END) sal, ");
    	
    	sb.append("(CASE WHEN det.histamina isnull or det.histamina = -1999.91 THEN ' - ' "); 
    	sb.append("ELSE "); 
    	sb.append(" round((det.histamina/10)::numeric,2)::text "); 
    	sb.append("END) histamina, "); 
    	
    	sb.append("(CASE WHEN det.nitrogeno isnull  or det.nitrogeno = -1999.91 THEN ' - ' "); 
    	sb.append("ELSE round(det.nitrogeno::numeric,2)::text "); 
    	sb.append("END) nitrogeno, "); 

    	sb.append("(CASE WHEN det.ph isnull or det.ph = -1999.91 THEN ' - ' "); 
    	sb.append("ELSE round(det.ph::numeric,2)::text "); 
    	sb.append("END) ph, "); 
    	sb.append("det.idespecietalla, "); 
    	sb.append("bd.viaje, "); 
    	sb.append("( "); 
    	sb.append("  select cm.abreviatura from calidad_observaciones_muestra_cuba cm "); 
    	sb.append("  where cm.idcalidadobservacion = det.ojos "); 
    	sb.append(") as ojos, "); 
    	sb.append("( "); 
    	sb.append("  select cm.abreviatura from calidad_observaciones_muestra_cuba cm "); 
    	sb.append("  where cm.idcalidadobservacion = det.agalla "); 
    	sb.append(") as Agallas, "); 
    	sb.append("( "); 
    	sb.append("  select cm.abreviatura from calidad_observaciones_muestra_cuba cm "); 
    	sb.append("  where cm.idcalidadobservacion = det.piel "); 
    	sb.append(") as Piel, "); 
    	sb.append("( "); 
    	sb.append("  select cm.abreviatura from calidad_observaciones_muestra_cuba cm "); 
    	sb.append("  where cm.idcalidadobservacion = det.danofisico "); 
    	sb.append(") as Dano, "); 
    	sb.append("( "); 
    	sb.append("  select cm.abreviatura from calidad_observaciones_muestra_cuba cm "); 
    	sb.append("  where cm.idcalidadobservacion = det.idcalidadolormuestra "); 
    	sb.append(") as olor, "); 
    	sb.append("( "); 
    	sb.append("  select cm.abreviatura from calidad_observaciones_muestra_cuba cm "); 
    	sb.append("  where cm.idcalidadobservacion = det.idcalidadsabormuestra "); 
    	sb.append(") as sabor, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'X' "); 
    	sb.append("			else "); 
    	sb.append("			'OK' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("		case when det.temperatura <= cobmc.valordesde or det.temperatura = -1999.91 then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = 57) salida, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'X' "); 
    	sb.append("			else "); 
    	sb.append("			'OK' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("		case when det.sal = -1999.91 or (det.sal >= cobmc.valordesde and det.sal <= cobmc.valorhasta) then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = 53) salidasal, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'X' "); 
    	sb.append("			else "); 
    	sb.append("			'OK' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("		case when det.histamina = -1999.91 or (round((det.histamina/10)::numeric,3) >= cobmc.valordesde and round((det.histamina/10)::numeric,3) <= cobmc.valorhasta) then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = 54) salidahistamina, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'X' "); 
    	sb.append("			else "); 
    	sb.append("			'OK' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("		case when det.ph = -1999.91 or (det.ph >= cobmc.valordesde and det.ph <= cobmc.valorhasta) then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = 55) salidaph, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'X' "); 
    	sb.append("			else "); 
    	sb.append("			'OK' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("		case when round(det.nitrogeno::numeric,2) = -1999.91 or (round(det.nitrogeno::numeric,2) <= cobmc.valordesde) then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = 56) salidanitrogeno, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("			'N/A' "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = det.ojos) salidaojos, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("			'N/A' "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = det.agalla) salidaagalla, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("			'N/A' "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = det.piel) salidapiel, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("			'N/A' "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = det.danofisico) salidadano, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("			'N/A' "); 
    	sb.append("	end salida "); 
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = det.idcalidadolormuestra) salidaolor, "); 
    	sb.append("(select	case when cobmc.idcalidadtipoobservacion = 1 then "); 
    	sb.append("		case when cobmc.calificacion = 1 then "); 
    	sb.append("			'OK' "); 
    	sb.append("			else "); 
    	sb.append("			'X' "); 
    	sb.append("		end "); 
    	sb.append("	else "); 
    	sb.append("			'N/A' "); 
    	sb.append("	end salida "); 
    	
    	sb.append("from calidad_observaciones_muestra_cuba  cobmc "); 
    	sb.append("where cobmc.idcalidadobservacion = det.idcalidadsabormuestra) salidasabor, tal.codigoqm as codigoqm ");
    	
    	//sb.append("	det.lotecamara ");
    	

    	
    	
    	sb.append("from calidad_pcc as cp left join calidad_detalle_pcc as det on cp.idcalidadpcc = det.idcalidadpcc, "); 
    	sb.append("barco_descarga bd, barco b,calidad_numero_muestreo_pcc as mues,  barco_estiba_cuba bec, "); 
    	sb.append("barco_cuba bc, cuba cu, especie_talla et, especie as es, talla as tal "); 
    	sb.append("/*, calidad_observaciones_muestra_cuba as comc */ "); 
    	sb.append("where cp.idbarcodescarga =  bd.idbarcodescarga and bd.idbarco = b.idbarco "); 
    	sb.append("and det.nummuestreo = mues.idcalidadnumeromuestreopcc "); 
    	sb.append("and det.idbarcoestibacuba = bec.idbarcoestibacuba and bec.idbarcocuba = bc.idbarcocuba "); 
    	sb.append("and bc.idcuba = cu.idcuba and det.idespecietalla = et.idespecietalla "); 
    	sb.append("and et.idespecie = es.idespecie and et.idtalla = tal.idtalla "); 
    	sb.append("/*and det.idcalidadolormuestra = comc.idcalidadobservacion*/ "); 
    	sb.append(String.format("and cp.idcalidadpcc = %s ", calidadPccId)); 
    	sb.append("order by cu.idcuba, mues.idcalidadnumeromuestreopcc, det.idespecietalla, det.iddetallecalidadpcc ");
	    
		Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
    
    /**
     * Devuelve la consulta nativa SQL de datos de los cajones que se pesan
     * en el área de Descongelado para Contraloría.
     * @param fechaProduccion
     * @param turno
     * @return
     */
    public List<Object[]> getDatosDescongeladoPesoCajon(String fecha1, String fecha2){
    	StringBuilder sb = new StringBuilder();
    	sb.append("select ");
    	sb.append("d.iddescongeladodetalleproceso, ");
    	sb.append("d.fechajoracreacionregisto, ");
    	sb.append("d.idusuario, ");
    	sb.append("d.idturno, ");
    	sb.append("d.peso, ");
    	sb.append("d.tara, ");
    	sb.append("d.idcajon "); 
    	sb.append("from descongelado_detalle_proceso_contraloria d "); 
    	sb.append(String.format("where d.fechajoracreacionregisto between '%s' and '%s' ", fecha1, fecha2));
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
  
    /**
     * Devuelve la consulta nativa SQL de datos de los cajones que se pesan
     * en el área de Descongelado para Contraloría.
     * @param fechaProduccion
     * @param turno
     * @return
     */
    public List<Object[]> getDatosDescongeladoPesoCajon2(String fecha1, String fecha2){
    	StringBuilder sb = new StringBuilder();
    	sb.append("select ");
    	sb.append("ddp.iddescongeladodetalleproceso, ");
    	sb.append("cc.idcajon, "); 
    	sb.append("ddp.horaingreso, ");
    	sb.append("ddp.idusuario, ");
    	sb.append("ddp.idturno, ");
    	sb.append("ddp.peso, ");
    	sb.append("ddp.tara, ");
    	sb.append("ddp.peso - ddp.tara, ");
    	sb.append("cc.pesoneto, ");
    	sb.append("((ddp.peso - ddp.tara)-cc.pesoneto) ");
    	sb.append("from descongelado_detalle_proceso ddp, produccion_detalle_lote_cajon pdlc, camara_cajon cc "); 
    	sb.append(String.format("where ddp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon " +
    			"and pdlc.idcamaracajon = cc.idcamaracajon " +
    			"and ddp.estado >= 2 " +
    			"and ddp.horaingreso between '%s' and '%s' ", fecha1, fecha2));
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
    

	public List<Object[]> getDetallesCocinada(String dato, int tipo_busqueda) {
		System.out.println("Parametros pnumerococinadageneral :" + dato);

		StringBuilder sb = new StringBuilder();

		sb.append("select distinct (edpc.idevisceradodetalleproceso), cacd.numerococinadageneral, cacd.idcocina, pdl.pedidocamara, pdl.idlote, ");
		sb.append("pdl.observaciones, pdl.origen, b.nombre, bd.registro, pdl.destinos, e.nombre, t.nombre, ");

		sb.append("(select array_to_string(array_agg(canastillas), ' - ') ");
		sb.append("from (   ");
		sb.append("select epl.especificacion || '  (' ||  count(edpc1.idevisceradopescadoslata)::TEXT || ' ' || (select ec .descripcion from eviscerado_corte ec where ec.idevisceradocorte = edpc1.idevisceradocorte) || ')' canastillas ");
		sb.append("from eviscerado_detalle_proceso_coche edpc1 inner JOIN eviscerado_pescados_lata epl   ");
		sb.append("on edpc1.idevisceradopescadoslata = epl.idevisceradopescadoslata   ");
		sb.append("where edpc1.idevisceradodetalleproceso = edp.idevisceradodetalleproceso and edpc1.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle ");
		sb.append("GROUP BY epl.especificacion, epl.cantidad, edpc1.idevisceradocorte   ");
		sb.append("ORDER BY epl.cantidad) t1) clasificacion,  ");

		sb.append("(select cpced.temperatura temp_inicio_espina1 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 1 and cpced.idcocinaprocesocontrolespina = 1  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_inicio_espina1,  ");

		sb.append("(select cpced.temperatura temp_inicio_espina2 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 1 and cpced.idcocinaprocesocontrolespina = 2  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_inicio_espina2,  ");

		sb.append("(select cpced.temperatura temp_inicio_espina3 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 1 and cpced.idcocinaprocesocontrolespina = 3  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_inicio_espina3,  ");

		sb.append("(select cpced.temperatura temp_inicio_espina4 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 1 and cpced.idcocinaprocesocontrolespina = 4  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_inicio_espina4,  ");

		sb.append("(select cpced.temperatura temp_corte_espina1 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 2 and cpced.idcocinaprocesocontrolespina = 1  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_corte_espina1,  ");

		sb.append("(select cpced.temperatura temp_corte_espina2 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 2 and cpced.idcocinaprocesocontrolespina = 2  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_corte_espina2,  ");

		sb.append("(select cpced.temperatura temp_corte_espina3 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 2 and cpced.idcocinaprocesocontrolespina = 3  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_corte_espina3,  ");

		sb.append("(select cpced.temperatura temp_corte_espina4 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 2 and cpced.idcocinaprocesocontrolespina = 4  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_corte_espina4,  ");

		sb.append("(select cpced.temperatura temp_final_espina1 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 3 and cpced.idcocinaprocesocontrolespina = 1  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_final_espina1,  ");

		sb.append("(select cpced.temperatura temp_final_espina2 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 3 and cpced.idcocinaprocesocontrolespina = 2  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_final_espina2,  ");

		sb.append("(select cpced.temperatura temp_final_espina3 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 3 and cpced.idcocinaprocesocontrolespina = 3  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_final_espina3,  ");

		sb.append("(select cpced.temperatura temp_final_espina4 from cocina_proceso_control_espina_detalle cpced    ");
		sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 3 and cpced.idcocinaprocesocontrolespina = 4  ORDER BY cpced.idcocinaprocesocontrolespinadetalle desc LIMIT 1) temp_final_espina4,  ");

		sb.append("cacd.corte,  ");
		sb.append("cacd.temperatura,  ");

		sb.append("(SELECT cc.descripcion FROM  cocina_curva cc where cc.idcocinacurva = cacd.idcocinacurva)curva,   ");
		sb.append("cacd.horafin h_inicio,  ");
		sb.append("cacd.fechafincocinada h_fin,  ");
		sb.append("cacd.fechartdcocinada h_rtd,  ");

		sb.append("(select array_to_string(array_agg(descripcion ), ' - ')  ");
		sb.append("from( ");
		sb.append("select d.descripcion ");
		sb.append("from rociado_cocinada_detalle rcd inner join ducharociado d ");
		sb.append("on rcd.idducharociado = d.idducharociado ");
		sb.append("where rcd.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and rcd.idevisceradodetalleproceso = edp.idevisceradodetalleproceso ");
		sb.append("ORDER BY d.descripcion) t2) rociado,  ");

		sb.append("(SELECT cct.descripcion FROM  cocina_choque_termico cct where cct.idcocinachoquetermico = cacd.idcocinachoquetermico) choque_termico,  ");

		sb.append("(select rc.descripcion from rociado_ciclo_detalle rdc inner JOIN  rociado_ciclo rc ");
		sb.append("on rdc.idrociadocliclo = rc.idrociadocliclo ");
		sb.append("where rdc.idevisceradodetalleproceso = edpc.idevisceradodetalleproceso and rdc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle) ciclo, ");

		sb.append("(select array_to_string(array_agg(descripcion ), ' - ')  ");
		sb.append("from(    ");
		sb.append("select c.descripcion  ");
		sb.append("from cuarto_chillroom_cocinada_detalle crd inner join cuartochillroom c  ");
		sb.append("on crd.idcuartochillroom = c.idcuartochillroom    ");
		sb.append("where crd.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and crd.idevisceradodetalleproceso = edp.idevisceradodetalleproceso  ");
		sb.append("ORDER BY c.descripcion) t3) cuarto,  ");

		sb.append("case when cacd.graficada = NULL THEN  ");
		sb.append("'NO'  ");
		sb.append("ELSE  ");
		sb.append("case when cacd.graficada = 1 THEN  ");
		sb.append("'SI'  ");
		sb.append("ELSE  ");
		sb.append("'NO'  ");
		sb.append("END  ");
		sb.append("END graficada,  ");

		sb.append("pdl.idproduccion ");

		sb.append("from eviscerado_detalle_proceso_coche edpc, cocina_apertura_cierre_detalle cacd, cocina coc, eviscerado_detalle_proceso edp, eviscerado_proceso ep, proceso_apertura_cierre pac, ");
		//sb.append("produccion_detalle_lote_cajon pdlc, produccion_detalle_lote pdl, barco_descarga bd, barco b, barco_estiba_cuba bec, barco_cuba bc, cuba c,  ");
		sb.append("produccion_detalle_lote_cajon pdlc, produccion_detalle_lote pdl, barco_descarga bd, barco b,  ");
		sb.append("especie_talla et, especie e, talla t, produccion p ");

		if (tipo_busqueda == 1) {
			sb.append(String
					//.format(" where edpc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle  and cacd.idcocina = coc.idcocina and edpc.idevisceradodetalleproceso =  edp.idevisceradodetalleproceso and edp.idevisceradoproceso = ep.idevisceradoproceso and ep.idprocesoaperturacierre = pac.idprocesoaperturacierre and edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon and pdlc.idproducciondetallelote = pdl.idproducciondetallelote and pdl.idbarcodescarga = bd.idbarcodescarga and bd.idbarco = b.idbarco and pdl.idbarcoestibacuba = bec.idbarcoestibacuba and bec.idbarcocuba = bc.idbarcocuba and bc.idcuba = c.idcuba and pdl.idespecietalla = et.idespecietalla and et.idespecie = e.idespecie and et.idtalla = t.idtalla and pdl.idproduccion = p.idproduccion and cacd.idcocinaaperturacierredetalle = '%s' order by pdl.idlote  ",
					  .format(" where edpc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle  and cacd.idcocina = coc.idcocina and edpc.idevisceradodetalleproceso =  edp.idevisceradodetalleproceso and edp.idevisceradoproceso = ep.idevisceradoproceso and ep.idprocesoaperturacierre = pac.idprocesoaperturacierre and edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon and pdlc.idproducciondetallelote = pdl.idproducciondetallelote and pdl.idbarcodescarga = bd.idbarcodescarga and bd.idbarco = b.idbarco and pdl.idespecietalla = et.idespecietalla and et.idespecie = e.idespecie and et.idtalla = t.idtalla and pdl.idproduccion = p.idproduccion and cacd.idcocinaaperturacierredetalle = '%s' order by pdl.idlote  ",
							new Object[] { dato }));
		} else {
			sb.append(String
					//.format(" where edpc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle  and cacd.idcocina = coc.idcocina and edpc.idevisceradodetalleproceso =  edp.idevisceradodetalleproceso and edp.idevisceradoproceso = ep.idevisceradoproceso and ep.idprocesoaperturacierre = pac.idprocesoaperturacierre and edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon and pdlc.idproducciondetallelote = pdl.idproducciondetallelote and pdl.idbarcodescarga = bd.idbarcodescarga and bd.idbarco = b.idbarco and pdl.idbarcoestibacuba = bec.idbarcoestibacuba and bec.idbarcocuba = bc.idbarcocuba and bc.idcuba = c.idcuba and pdl.idespecietalla = et.idespecietalla and et.idespecie = e.idespecie and et.idtalla = t.idtalla and pdl.idproduccion = p.idproduccion and pdl.idproduccion = '%s' order by pdl.idproduccion, cacd.numerococinadageneral , pdl.idlote  ",
					  .format(" where edpc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle  and cacd.idcocina = coc.idcocina and edpc.idevisceradodetalleproceso =  edp.idevisceradodetalleproceso and edp.idevisceradoproceso = ep.idevisceradoproceso and ep.idprocesoaperturacierre = pac.idprocesoaperturacierre and edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon and pdlc.idproducciondetallelote = pdl.idproducciondetallelote and pdl.idbarcodescarga = bd.idbarcodescarga and bd.idbarco = b.idbarco and pdl.idespecietalla = et.idespecietalla and et.idespecie = e.idespecie and et.idtalla = t.idtalla and pdl.idproduccion = p.idproduccion and pdl.idproduccion = '%s' order by pdl.idproduccion, cacd.numerococinadageneral , pdl.idlote  ",
							new Object[] { dato }));
		}

		System.out.println("Salida :" + sb.toString());

		Query query = this.em.createNativeQuery(sb.toString());
		return query.getResultList();
	}
   
    
    
    ///////////////////////////////
    //MODIFICADO DESDE 04-06-2015//
    ///////////////////////////////
    //public List<Object[]> getDetallesCocinada(String pnumerococinadageneral, int tipo_busqueda){    	
    public List<Object[]> getDetallesCocinada_old(String dato, int tipo_busqueda){
    	// tipo_busqueda 1 = 'busqueda por cocinada y producción' 
    	// tipo_busqueda 2 = 'busqueda general de todas las cocinadas de la produccion'
    	System.out.println("Parametros pnumerococinadageneral :"+dato);
    	
    	StringBuilder sb = new StringBuilder();

    	sb.append("select distinct (edpc.idevisceradodetalleproceso), cacd.numerococinadageneral, cacd.idcocina, pdl.pedidocamara, pdl.idlote, "); 
    	sb.append("pdl.observaciones, pdl.origen, b.nombre, bd.registro, pdl.destinos, e.nombre, t.nombre, ");

/*    	
    	sb.append("(select array_to_string(array_agg(canastillas), ' - ') ");  
    	sb.append("from ( ");
    	sb.append("select epl.especificacion || '  (' ||  count(edpc1.idevisceradopescadoslata)::TEXT || ')' canastillas ");
    	sb.append("from eviscerado_detalle_proceso_coche edpc1 inner JOIN eviscerado_pescados_lata epl ");
    	sb.append("on edpc1.idevisceradopescadoslata = epl.idevisceradopescadoslata ");
    	sb.append("where edpc1.idevisceradodetalleproceso = edp.idevisceradodetalleproceso and edpc1.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle ");
    	sb.append("GROUP BY epl.especificacion, epl.cantidad ");
    	sb.append("ORDER BY epl.cantidad) t1) clasificacion, ");
*/
    	
    	sb.append("(select array_to_string(array_agg(canastillas), ' - ') ");   
    	sb.append("from (   ");
    	sb.append("select epl.especificacion || '  (' ||  count(edpc1.idevisceradopescadoslata)::TEXT || ' ' || (select ec .descripcion from eviscerado_corte ec where ec.idevisceradocorte = edpc1.idevisceradocorte) || ')' canastillas ");  
    	sb.append("from eviscerado_detalle_proceso_coche edpc1 inner JOIN eviscerado_pescados_lata epl   ");
    	sb.append("on edpc1.idevisceradopescadoslata = epl.idevisceradopescadoslata   ");
    	sb.append("where edpc1.idevisceradodetalleproceso = edp.idevisceradodetalleproceso and edpc1.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle ");  
    	sb.append("GROUP BY epl.especificacion, epl.cantidad, edpc1.idevisceradocorte   ");
    	sb.append("ORDER BY epl.cantidad) t1) clasificacion,  ");    	
 

    	/*--TEMP INICIO--   */
    	/*--temp_inicio_espina1 */
    	sb.append("(select cpced.temperatura temp_inicio_espina1 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 1 and cpced.idcocinaprocesocontrolespina = 1) temp_inicio_espina1,  ");  

    	/*--temp_inicio_espina2   */
    	sb.append("(select cpced.temperatura temp_inicio_espina2 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 1 and cpced.idcocinaprocesocontrolespina = 2) temp_inicio_espina2,  ");  

    	/* temp_inicio_espina3    */
    	sb.append("(select cpced.temperatura temp_inicio_espina3 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 1 and cpced.idcocinaprocesocontrolespina = 3) temp_inicio_espina3,  ");  

    	/*--temp_inicio_espina4   */
    	sb.append("(select cpced.temperatura temp_inicio_espina4 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 1 and cpced.idcocinaprocesocontrolespina = 4) temp_inicio_espina4,  ");  
    	/*FIN TEMP INICIO-- */


    	/*--TEMP CORTE--    */
    	/*--temp_corte_espina1 */
    	sb.append("(select cpced.temperatura temp_corte_espina1 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 2 and cpced.idcocinaprocesocontrolespina = 1) temp_corte_espina1,  ");  

    	/*--temp_corte_espina2   */
    	sb.append("(select cpced.temperatura temp_corte_espina2 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 2 and cpced.idcocinaprocesocontrolespina = 2) temp_corte_espina2,  ");  

    	/*--temp_corte_espina3   */
    	sb.append("(select cpced.temperatura temp_corte_espina3 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 2 and cpced.idcocinaprocesocontrolespina = 3) temp_corte_espina3,  ");  

    	/*--temp_corte_espina4  */
    	sb.append("(select cpced.temperatura temp_corte_espina4 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 2 and cpced.idcocinaprocesocontrolespina = 4) temp_corte_espina4,  ");  
    	/*--FIN TEMP CORTE--    */


    	/*--TEMP FINAL--  */
    	/*--temp_final_espina1 */
    	sb.append("(select cpced.temperatura temp_final_espina1 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 3 and cpced.idcocinaprocesocontrolespina = 1) temp_final_espina1,  ");  

    	/*--temp_final_espina2    */
    	sb.append("(select cpced.temperatura temp_final_espina2 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 3 and cpced.idcocinaprocesocontrolespina = 2) temp_final_espina2,  ");  

    	/*--temp_final_espina3  */  
    	sb.append("(select cpced.temperatura temp_final_espina3 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 3 and cpced.idcocinaprocesocontrolespina = 3) temp_final_espina3,  ");  

    	/*temp_final_espina4*/   
    	sb.append("(select cpced.temperatura temp_final_espina4 from cocina_proceso_control_espina_detalle cpced    ");
    	sb.append("where cpced.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and cpced.idcocinaprocesotipotemperatura = 3 and cpced.idcocinaprocesocontrolespina = 4) temp_final_espina4,  ");  
    	/*--FIN TEMP FINAL--  */
  
    	sb.append("cacd.corte,  ");
    	sb.append("cacd.temperatura,  ");    	
  
    	sb.append("(SELECT cc.descripcion FROM  cocina_curva cc where cc.idcocinacurva = cacd.idcocinacurva)curva,   ");
    	sb.append("cacd.horafin h_inicio,  ");
    	sb.append("cacd.fechafincocinada h_fin,  ");
    	sb.append("cacd.fechartdcocinada h_rtd,  ");
    	
    	
    	sb.append("(select array_to_string(array_agg(descripcion ), ' - ')  ");
    	sb.append("from( ");
    	sb.append("select d.descripcion "); 
    	sb.append("from rociado_cocinada_detalle rcd inner join ducharociado d ");
    	sb.append("on rcd.idducharociado = d.idducharociado ");
    	sb.append("where rcd.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and rcd.idevisceradodetalleproceso = edp.idevisceradodetalleproceso ");
    	sb.append("ORDER BY d.descripcion) t2) rociado,  ");
    	
    	sb.append("(SELECT cct.descripcion FROM  cocina_choque_termico cct where cct.idcocinachoquetermico = cacd.idcocinachoquetermico) choque_termico,  ");    	
    	   	
    	sb.append("(select rc.descripcion from rociado_ciclo_detalle rdc inner JOIN  rociado_ciclo rc ");
    	sb.append("on rdc.idrociadocliclo = rc.idrociadocliclo ");
    	sb.append("where rdc.idevisceradodetalleproceso = edpc.idevisceradodetalleproceso and rdc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle) ciclo, "); 


    	sb.append("(select array_to_string(array_agg(descripcion ), ' - ')  ");   
    	sb.append("from(    ");
    	sb.append("select c.descripcion  ");  
    	sb.append("from cuarto_chillroom_cocinada_detalle crd inner join cuartochillroom c  ");  
    	sb.append("on crd.idcuartochillroom = c.idcuartochillroom    ");
    	sb.append("where crd.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle and crd.idevisceradodetalleproceso = edp.idevisceradodetalleproceso  ");  
    	sb.append("ORDER BY c.descripcion) t3) cuarto,  ");

    	sb.append("case when cacd.graficada = NULL THEN  ");
    	sb.append("'NO'  ");
    	sb.append("ELSE  ");
    	sb.append("case when cacd.graficada = 1 THEN  ");
    	sb.append("'SI'  ");
    	sb.append("ELSE  ");
    	sb.append("'NO'  ");
    	sb.append("END  ");
    	sb.append("END graficada,  ");    	
    	
    	sb.append("pdl.idproduccion ");
    	
    	sb.append("from eviscerado_detalle_proceso_coche edpc, cocina_apertura_cierre_detalle cacd, cocina coc, eviscerado_detalle_proceso edp, eviscerado_proceso ep, proceso_apertura_cierre pac, "); 
    	sb.append("produccion_detalle_lote_cajon pdlc, produccion_detalle_lote pdl, barco_descarga bd, barco b, ");
//    	sb.append("-- produccion_detalle_lote_cajon pdlc, produccion_detalle_lote pdl, barco_descarga bd, barco b, barco_estiba_cuba bec, barco_cuba bc, cuba c,  ");
    	
    	sb.append("especie_talla et, especie e, talla t, produccion p ");

    	
    	// tipo_busqueda 1 = 'busqueda por cocinada y producción' 
    	if(tipo_busqueda == 1)
    	{
        	sb.append(String.format(" where edpc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle " +
        			" and cacd.idcocina = coc.idcocina " +
        			"and edpc.idevisceradodetalleproceso =  edp.idevisceradodetalleproceso " +
        			"and edp.idevisceradoproceso = ep.idevisceradoproceso " +
        			"and ep.idprocesoaperturacierre = pac.idprocesoaperturacierre " +
        			"and edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon " +
        			"and pdlc.idproducciondetallelote = pdl.idproducciondetallelote " +
        			"and pdl.idbarcodescarga = bd.idbarcodescarga " +
        			"and bd.idbarco = b.idbarco " +
//        			"-- and pdl.idbarcoestibacuba = bec.idbarcoestibacuba " +
//        			"-- and bec.idbarcocuba = bc.idbarcocuba and bc.idcuba = c.idcuba " +
        			"and pdl.idespecietalla = et.idespecietalla " +
        			"and et.idespecie = e.idespecie " +
        			"and et.idtalla = t.idtalla " +
        			"and pdl.idproduccion = p.idproduccion " +
        			"and cacd.idcocinaaperturacierredetalle = '%s' " +
        			"order by pdl.idlote  ", dato));
    	}
    	else
    	{
        	// tipo_busqueda 2 = 'busqueda general de todas las cocinadas de la produccion'
        	sb.append(String.format(" where edpc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle " +
        			" and cacd.idcocina = coc.idcocina " +
        			"and edpc.idevisceradodetalleproceso =  edp.idevisceradodetalleproceso " +
        			"and edp.idevisceradoproceso = ep.idevisceradoproceso " +
        			"and ep.idprocesoaperturacierre = pac.idprocesoaperturacierre " +
        			"and edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon " +
        			"and pdlc.idproducciondetallelote = pdl.idproducciondetallelote " +
        			"and pdl.idbarcodescarga = bd.idbarcodescarga " +
        			"and bd.idbarco = b.idbarco " +
//        			"-- and pdl.idbarcoestibacuba = bec.idbarcoestibacuba " +
//        			"-- and bec.idbarcocuba = bc.idbarcocuba and bc.idcuba = c.idcuba " +
        			"and pdl.idespecietalla = et.idespecietalla " +
        			"and et.idespecie = e.idespecie " +
        			"and et.idtalla = t.idtalla " +
        			"and pdl.idproduccion = p.idproduccion " +
        			"and pdl.idproduccion = '%s' " +
        			"order by pdl.idproduccion, cacd.numerococinadageneral , pdl.idlote  ", dato));
    	}
    	
    System.out.println("Salida :"+sb.toString());	
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
		
//		and p.idproduccion = 331 
//		and cacd.numerococinadageneral = 2  /* Parámetro de Entrada */

    }    
 
    
    //public List<Object[]> getDetallesInfoMuestras(Long dato, int muestreo, Integer idespecietalla)
    public List<Object[]> getDetallesCubasPorEspecieTalla(Long dato, Integer idespecietalla)
    {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("select 0 as ic, array_to_string(array_agg(cuba ), ', ') cuba "); 
    	sb.append("from ( ");
    	sb.append("select DISTINCT (c.nombrecuba) cuba from camara_cajon cc "); 
    	sb.append("inner join barco_estiba_cuba_detalle_mezcla becdm ");
    	sb.append("on cc.idcamaracajon = becdm.idcamaracajon  ");
    	sb.append("inner join barco_estiba_cuba bec  ");
    	sb.append("on becdm.idbarcoestibacuba = bec.idbarcoestibacuba ");
    	sb.append("inner join barco_cuba bc  ");
    	sb.append("on bec.idbarcocuba = bc.idbarcocuba ");
    	sb.append("inner join cuba c ");
    	sb.append("on bc.idcuba = c.idcuba ");
    	sb.append(String.format("where cc.idbarcodescarga = %s " ,dato));        	
    	sb.append(String.format("and cc.idmaterial = %s  " ,idespecietalla));    	
    	sb.append("order by c.nombrecuba) t1     ");
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }


    
    //Nuevo 31-01-2017
    public List<Object[]> getDetallesLote(Long iproduccion, Integer lote)
    {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("select  ");
    	sb.append("t2.idproduccion, "); 
    	sb.append("t2.idproducciondetallelote, "); 
    	sb.append("t2.total_coches,  ");
    	sb.append("t2.cocina_cocinada,  ");
    	sb.append("t2.total_ing_chillroom, ");
    	sb.append("(t2.total_coches - t2.total_ing_chillroom) pendientes ");
    	sb.append("from ( ");
    	sb.append("select "); 
    	sb.append("max(t1.idproduccion) idproduccion, ");
    	sb.append("max(t1.idproducciondetallelote) idproducciondetallelote, ");
    	sb.append("max(t1.total_coches) total_coches, ");
    	sb.append("array_to_string(array_agg(t1.cocina_cocinada), '\n') cocina_cocinada, "); 
    	sb.append("max(t1.total_ing_chillroom) total_ing_chillroom  ");
    	sb.append("from  ");
    	sb.append("( ");
    	sb.append("select "); 
    	sb.append("DISTINCT  'Cocina: ' || t0.cocina_cocinada ||' ' || ' Clasificacion: ' || t0.clasificacion  cocina_cocinada, "); 
    	sb.append("t0.idproduccion,  ");
    	sb.append("t0.idproducciondetallelote, "); 
    	sb.append("t0.total_coches,  ");
    	sb.append("t0.total_ing_chillroom ");
    	sb.append("from  ");
    	sb.append("( ");
    	sb.append("select cacd.idcocina::TEXT || '/' || cacd.numerococinadageneral::TEXT cocina_cocinada, "); 
    	sb.append("(select array_to_string(array_agg(canastillas), ' - ') ");
    	sb.append("from (   ");
    	sb.append("select epl.especificacion || '  (' ||  count(edpc1.idevisceradopescadoslata)::TEXT || ' ' || (select ec .descripcion from eviscerado_corte ec where ec.idevisceradocorte = edpc1.idevisceradocorte) || ')' canastillas ");
    	sb.append("from eviscerado_detalle_proceso_coche edpc1 inner JOIN eviscerado_pescados_lata epl   ");
    	sb.append("on edpc1.idevisceradopescadoslata = epl.idevisceradopescadoslata ");  
    	sb.append("where edpc1.idevisceradodetalleproceso = edp.idevisceradodetalleproceso and edpc1.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle ");
    	sb.append("GROUP BY epl.especificacion, epl.cantidad, edpc1.idevisceradocorte   ");
    	sb.append("ORDER BY epl.cantidad) t1) clasificacion,  ");
    	sb.append("pdl.idproduccion, "); 
    	sb.append("pdl.idproducciondetallelote, "); 
    	sb.append("( ");
    	sb.append("select count(edpc.idevisceradodetalleproceso) "); 
    	sb.append("from eviscerado_detalle_proceso_coche edpc  ");
    	sb.append("inner join eviscerado_detalle_proceso edp  ");
    	sb.append("on edpc.idevisceradodetalleproceso = edp.idevisceradodetalleproceso ");
    	sb.append("inner join produccion_detalle_lote_cajon pdlc  ");
    	sb.append("on edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon "); 
    	sb.append("inner join produccion_detalle_lote pdl1  ");
    	sb.append("on pdlc.idproducciondetallelote = pdl.idproducciondetallelote ");
    	sb.append("where pdl1.idproduccion = pdl.idproduccion and  pdl1.idlote = pdl.idlote and edpc.peso > 0 and edpc.tara > 0 ");
    	sb.append(") total_coches, ");
    	sb.append("(select count(rdpc.idrociadodetalleprocesocoche) ");
    	sb.append("from rociado_detalle_proceso_coche rdpc  ");
    	sb.append("inner join eviscerado_detalle_proceso_coche edpc "); 
    	sb.append("on rdpc.idevisceradodetalleprocesocoche = edpc.idevisceradodetalleprocesocoche ");
    	sb.append("inner join eviscerado_detalle_proceso edp ");
    	sb.append("on edpc.idevisceradodetalleproceso = edp.idevisceradodetalleproceso ");
    	sb.append("inner join produccion_detalle_lote_cajon pdlc ");
    	sb.append("on edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon "); 
    	sb.append("inner join produccion_detalle_lote pdl1 ");
    	sb.append("on pdlc.idproducciondetallelote = pdl1.idproducciondetallelote ");
    	sb.append("where pdl1.idproduccion = pdl.idproduccion and pdl1.idlote = pdl.idlote  and edpc.peso > 0 and edpc.tara > 0) total_ing_chillroom   ");
    	sb.append("from eviscerado_detalle_proceso_coche edpc, cocina_apertura_cierre_detalle cacd, cocina coc, eviscerado_detalle_proceso edp, eviscerado_proceso ep, proceso_apertura_cierre pac, ");
    	sb.append("produccion_detalle_lote_cajon pdlc, produccion_detalle_lote pdl, barco_descarga bd, barco b,  ");
    	sb.append("especie_talla et, especie e, talla t, produccion p ");
    	sb.append("where edpc.idcocinaaperturacierredetalle = cacd.idcocinaaperturacierredetalle ");   
    	sb.append("and cacd.idcocina = coc.idcocina  ");
    	sb.append("and edpc.idevisceradodetalleproceso =  edp.idevisceradodetalleproceso "); 
    	sb.append("and edp.idevisceradoproceso = ep.idevisceradoproceso  ");
    	sb.append("and ep.idprocesoaperturacierre = pac.idprocesoaperturacierre "); 
    	sb.append("and edp.idproducciondetallelotecajon = pdlc.idproducciondetallelotecajon "); 
    	sb.append("and pdlc.idproducciondetallelote = pdl.idproducciondetallelote "); 
    	sb.append("and pdl.idbarcodescarga = bd.idbarcodescarga  ");
    	sb.append("and bd.idbarco = b.idbarco  ");
    	sb.append("and pdl.idespecietalla = et.idespecietalla "); 
    	sb.append("and et.idespecie = e.idespecie "); 
    	sb.append("and et.idtalla = t.idtalla  ");
    	sb.append("and pdl.idproduccion = p.idproduccion ");
    	sb.append(String.format("and pdl.idproduccion = %s " ,iproduccion));        	
    	sb.append(String.format("and pdl.idlote = %s  " ,lote));
    	sb.append("order by pdl.idproduccion, cacd.numerococinadageneral , pdl.idlote ");  
    	sb.append(") t0 ");
    	sb.append(") t1 ");
    	sb.append(") t2 ");	
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }
    
    
    
    
    
    
    public List<Object[]> getDetallesCubasDescargaYLoteCamara(Long dato, String lotecamara)
    {
    	StringBuilder sb = new StringBuilder();
    	
//    	sb.append("select 0 as ic, array_to_string(array_agg(cuba ), ', ') cuba "); 
//    	sb.append("from ( ");
//    	sb.append("select DISTINCT (c.nombrecuba) cuba from camara_cajon cc "); 
//    	sb.append("inner join barco_estiba_cuba_detalle_mezcla becdm ");
//    	sb.append("on cc.idcamaracajon = becdm.idcamaracajon  ");
//    	sb.append("inner join barco_estiba_cuba bec  ");
//    	sb.append("on becdm.idbarcoestibacuba = bec.idbarcoestibacuba ");
//    	sb.append("inner join barco_cuba bc  ");
//    	sb.append("on bec.idbarcocuba = bc.idbarcocuba ");
//    	sb.append("inner join cuba c ");
//    	sb.append("on bc.idcuba = c.idcuba ");
//    	sb.append(String.format("where cc.idbarcodescarga = %s " ,dato));        	
//    	sb.append(String.format("and cc.idmaterial = %s  " ,idespecietalla));    	
//    	sb.append("order by c.nombrecuba) t1     ");

    	
    	sb.append("select 0 as ic, array_to_string(array_agg(cuba), ', ') cuba ");
    	sb.append("from ( ");
    	sb.append("select DISTINCT (c.nombrecuba) cuba from camara_cajon cc inner join barco_estiba_cuba_detalle_mezcla becm ");
    	sb.append("on  cc.idcamaracajon = becm.idcamaracajon  ");
    	sb.append("inner join barco_estiba_cuba bec ");
    	sb.append("on becm.idbarcoestibacuba = bec.idbarcoestibacuba ");
    	sb.append("inner join barco_cuba  bc ");
    	sb.append("on bec.idbarcocuba = bc.idbarcocuba ");
    	sb.append("inner join cuba c ");
    	sb.append("on bc.idcuba = c.idcuba ");
    	//sb.append("where cc.idbarcodescarga  = 471 "  );
    	sb.append(String.format("where cc.idbarcodescarga = %s " ,dato));
    	//sb.append("and cc.lotecamara = '006' "  );
    	sb.append(String.format("and cc.lotecamara = '%s' " , lotecamara));
    	sb.append("and cc.estado >= 0) t1 ");    	
    	
//    	sb.append("select 0 as ic, array_to_string(array_agg(cuba), ', ') cuba from ( ");
//    	sb.append("select DISTINCT(c.nombrecuba) cuba from camara_cajon cc ");
//    	sb.append("inner join barco_estiba_cuba_detalle_mezcla bedm ");
//    	sb.append("on cc.idcamaracajon = bedm.idcamaracajon ");
//    	sb.append("inner join barco_estiba_cuba bec  ");
//    	sb.append("on bedm.idbarcoestibacuba = bec.idbarcoestibacuba ");
//    	sb.append("inner join barco_cuba bc  ");
//    	sb.append("on bec.idbarcocuba = bc.idbarcocuba ");
//    	sb.append("inner join cuba c ");
//    	sb.append("on bc.idcuba = c.idcuba ");
//    	sb.append("inner join calidad_detalle_pcc cdpp ");
//    	sb.append("on bec.idbarcoestibacuba = cdpp.idbarcoestibacuba ");
//    	sb.append("inner join calidad_pcc cpp ");
//    	sb.append("on cdpp.idcalidadpcc = cpp.idcalidadpcc ");
//    	sb.append(String.format("where cc.idbarcodescarga = %s " ,dato));    	
//    	sb.append("and cc.estado >= 0 ");
//    	sb.append(String.format("and cc.lotecamara = '%s' " , lotecamara));      	
//    	sb.append("and cdpp.lotecamara is not null) t1 ");    	
    	
    	
    	
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }    


    public List<Object[]> getDetallesLotesCamaraPorEspecieTalla(Long dato, Integer idespecietalla)
    {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("select  0 as ic, array_to_string(array_agg(lotecamara ), ', ') lotecamara  "); 
    	sb.append("from (  ");
    	sb.append("select DISTINCT (cc.lotecamara) lotecamara from camara_cajon cc  "); 
    	sb.append(String.format("where cc.idbarcodescarga = %s " ,dato));        	
    	sb.append(String.format("and cc.idmaterial = %s  " ,idespecietalla));    	
    	sb.append("and cc.lotecamara  is not null  ");

    	sb.append("order by lotecamara) t1  ");
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
    }    
    
    
    //public List<Object[]> getDetallesInfoMuestras(Long dato, int muestreo, Integer idespecietalla)
    public List<Object[]> getDetallesInfoMuestras(Long dato, int muestreo, Integer idespecietalla)
    {
    	// tipo_busqueda 1 = 'Por un muestreo' 
    	// tipo_busqueda 2 = 'Todos los muestreo'

    	StringBuilder sb = new StringBuilder();

    	sb.append("select  ");
    	sb.append("cdpp.idcalidadpcc, ");
    	sb.append("cdpp.idbarcoestibacuba, ");
    	sb.append("cdpp.idespecietalla, ");
    	sb.append("c.nombrecuba || '  ' || ");
    	sb.append("(cdpp.nummuestreo -1)::CHARACTER || ' (' || ");
    	sb.append("(select ei.codigoqm as especie ");
    	sb.append("from especie_talla eti inner join especie ei ");
    	sb.append("on eti.idespecie =  ei.idespecie ");
    	sb.append("where eti.idespecietalla = cdpp.idespecietalla) || ' ' || ");
    	sb.append("(select ti.nombre as talla ");
    	sb.append("from especie_talla eti inner join talla ti ");
    	sb.append("on eti.idtalla =  ti.idtalla ");
    	sb.append("where eti.idespecietalla = cdpp.idespecietalla) || ')' as muestreo_cuba_especie_talla_cantmuestras, ");
    	sb.append("count (cdpp.idcalidadpcc) cant_muestras, ");
    	sb.append("cdpp.lotecamara, ");
    	sb.append("cdpp.nummuestreo ");
    	sb.append("from calidad_detalle_pcc cdpp  ");
    	sb.append("inner join  calidad_pcc cpcc ");
    	sb.append("on cdpp.idcalidadpcc = cpcc.idcalidadpcc ");
    	sb.append("inner join barco_estiba_cuba bsc ");
    	sb.append("on cdpp.idbarcoestibacuba = bsc.idbarcoestibacuba ");
    	sb.append("inner join barco_cuba bc ");
    	sb.append("on bsc.idbarcocuba = bc.idbarcocuba ");
    	sb.append("inner join cuba c ");
    	sb.append("on bc.idcuba = c.idcuba ");
    	
    	//Todos los muestreos
    	if (muestreo == -1)
    	{
        	sb.append(String.format("where cpcc.idbarcodescarga = %s " ,dato));
        	//sb.append("GROUP BY cdpp.idcalidadpcc asc, cdpp.idbarcoestibacuba, cdpp.nummuestreo, c.nombrecuba, cdpp.idespecietalla, cdpp.lotecamara ");
        	sb.append("GROUP BY cdpp.idcalidadpcc, cdpp.idbarcoestibacuba, cdpp.nummuestreo, c.nombrecuba, cdpp.idespecietalla, cdpp.lotecamara ");
        	sb.append("ORDER BY cdpp.lotecamara desc, cdpp.nummuestreo, cdpp.idbarcoestibacuba,  ");
        	sb.append("(select ei.codigoqm as especie ");
        	sb.append("from especie_talla eti inner join especie ei ");
        	sb.append("on eti.idespecie =  ei.idespecie ");
        	sb.append("where eti.idespecietalla = cdpp.idespecietalla) ");
    	}
    	else
    	{
    		//Busca por un muestreo en particular
        	sb.append(String.format("where cpcc.idbarcodescarga = %s " ,dato));
        	//----sb.append(String.format("and (cdpp.nummuestreo -1) = %s  " ,muestreo));        	
        	sb.append(String.format("and cdpp.idespecietalla = %s  " ,idespecietalla));
        	sb.append("GROUP BY cdpp.idcalidadpcc, cdpp.idbarcoestibacuba, cdpp.nummuestreo, c.nombrecuba, cdpp.idespecietalla, cdpp.lotecamara ");
        	sb.append("ORDER BY cdpp.lotecamara desc, cdpp.nummuestreo, cdpp.idbarcoestibacuba,  ");
        	sb.append("(select ei.codigoqm as especie ");
        	sb.append("from especie_talla eti inner join especie ei ");
        	sb.append("on eti.idespecie =  ei.idespecie ");
        	sb.append("where eti.idespecietalla = cdpp.idespecietalla) ");
    	}
    	
    	
    	
	
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
		
    }    
    
 
    
    
    
    public List<Object[]> getLotesCamatra(Long dato)
    {
    	// tipo_busqueda 1 = 'Por un muestreo' 
    	// tipo_busqueda 2 = 'Todos los muestreo'

    	StringBuilder sb = new StringBuilder();

//    	sb.append("select lco, ('L' || lc) lc from (	 ");
//    	sb.append("select lco, lc from (	 ");
//    	sb.append("select  DISTINCT (lotecamara) lc, lotecamara lco from barco_descarga bd inner join camara_cajon cc	 ");
//    	sb.append("on bd.idbarcodescarga = cc.idbarcodescarga	 ");
//    	sb.append(String.format("where  bd.idbarcodescarga  =  %s ) t1 " ,dato));
//    	sb.append("order by t1.lc ::INTEGER) t2    		 ");
    	
    	sb.append("select t1.lco, t1.idmaterial, t1.especie_talla from (	 ");
    	sb.append("select  DISTINCT (lotecamara)::INTEGER lc,  lotecamara lco, cc.idmaterial, e.codigoqm ||' '|| t.nombre especie_talla	 ");
    	sb.append("from barco_descarga bd inner join camara_cajon cc	 	 ");
    	sb.append("on bd.idbarcodescarga = cc.idbarcodescarga	 	 ");
    	sb.append("inner join especie_talla et 	 ");
    	sb.append("on et.idespecietalla = cc.idmaterial	 ");
    	sb.append("inner join especie e	 ");
    	sb.append("on et.idespecie = e.idespecie	 ");
    	sb.append("inner join talla t	 ");
    	sb.append("on et.idtalla = t.idtalla	 ");
    	sb.append(String.format("where  bd.idbarcodescarga  =  %s and cc.estado <> -1 ) t1 " ,dato));
    	sb.append("GROUP BY t1.lc, t1.lco, t1.idmaterial, t1.especie_talla	 ");
    	sb.append("order by t1.lc    		 ");
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
		
    }    
  
    
    public List<Object[]> getListaLotesCubasPorIdProduccionDetalleLote(Long dato)
    {
    	StringBuilder sb = new StringBuilder();

    	sb.append(String.format("select 1,  mescla_cubas_por_idproducciondetallelote(%s) " ,dato));
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
		
    }    
    
    
    
    
    public List<Object[]> getListaLotesCubasPorIdCamaraCajon(Long dato)
    {
    	StringBuilder sb = new StringBuilder();

    	sb.append(String.format("select 1,  mescla_cubas_por_idproducciondetallelote(%s) " ,dato));
    	
    	Query query = em.createNativeQuery(sb.toString());
		return query.getResultList();
		
    }    

    
    
    
    
}
