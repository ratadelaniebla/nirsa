package com.nw.webui.produccion;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
 
import com.nw.model.OeeParada;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Turno;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.GenericNw;
import com.nw.util.ReporteExcel;
import com.nw.util.Sistema;


/**
 *  Copyright 2017 Nirsa. All rights reserved.
 *
 *  @author crholguin on 30/10/2017.
 *  Checkin Date   : 	 30/10/2017.
 *
 *  @Requerimiento : R20
 *  
 *  @Objetivo      : Reporte de paradas 
 *             
 *  @Nota          :               
 *
 */
public class OeeDetalleParadaReporteWindow extends GenericNw {
 
	private static final long serialVersionUID = 8742891156063829607L;
	
	Proceso    proceso;
	OeeParada  parada;
	Turno 	   turno;
	Boolean    tipoParada;		    // T -> programada    F -> no programada
	Boolean    tipoEquipoPersona;  //  T =  Por equipo;   F =  Por Persona	
	
	Datebox    dteFechaInicial;
	Datebox    dteFechaFinal;
	Listbox    lbxTipoEquipoPersona;
	
	ProcesoAperturaCierre pac;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		cargarListados();
		cargarListboxTurnoAll();
	}
	
	public void cargarListados(){
		
		List<Proceso> 				  procesos 		= 	new ProcesoDAOJpaImpl().getProcesosMP();
		cargarListbox(new Proceso() , procesos   ,  lbxProceso   , "Proceso" );
	}
	
	public void cargarListboxTurnoAll(){
		  
		List<Turno>  turnos = new TurnoDAOJpaImpl().getTurnos();
		lbxTurno.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Turno());
			new Listcell("TODOS").setParent(li);
			li.setParent(lbxTurno);
			try {
				for (Turno t : turnos) {
					li = new Listitem();
					li.setValue(t);
					new Listcell(t.getNombre()).setParent(li);
					li.setParent(lbxTurno);
				}
			} catch (Exception e) {
				 e.printStackTrace();
				System.out.println("Error al cargar  listbox lbxTurno");
			}
			lbxTurno.setSelectedIndex(0);
		 
	}
	
	
	public void onBlur$dteFechaInicial(){
		if (dteFechaInicial.getValue() != null) {
			if (lbxProceso.getSelectedIndex()>0) {
				 lbxProceso.setSelectedIndex(0);
				 proceso = null;
			 }
			
			if (lbxTurno.getSelectedIndex()>0) {
				lbxTurno.setSelectedIndex(0);
				 turno = null;
			 }
		}
    }
	
	public void onChange$dteFechaInicial(){
		if (dteFechaInicial.getValue() != null) {
			if (lbxProceso.getSelectedIndex()>0) {
				 lbxProceso.setSelectedIndex(0);
				 proceso = null;
			 }
			
			if (lbxTurno.getSelectedIndex()>0) {
				lbxTurno.setSelectedIndex(0);
				 turno = null;
			 }
		}
    }
	
	@Override
	public void onSelect$lbxTurno() throws InterruptedException {
		 if (lbxTurno.getSelectedIndex()>0) {
			 turno = (Turno) lbxTurno.getSelectedItem().getValue();
		 }else{
			 turno = null;
			 if (lbxProceso.getSelectedIndex()>0) {
				 lbxProceso.setSelectedIndex(0);
				 proceso = null;
			 }
		 }
	}
	
	@Override
	public void onSelect$lbxProceso() throws InterruptedException {
		 if (lbxProceso.getSelectedIndex()>0) {
			 proceso = (Proceso) lbxProceso.getSelectedItem().getValue(); 
			 
			 if (turno != null) {
				 
				 if (dteFechaInicial.getValue()==null) {
					 Sistema.mensaje("Debe escoger una fecha ");
					 return;
				 }
				    /* 1.- buscar el proceso apertura cierre segun el proceso , turno , y fecha_apertura */
				 pac = new ProcesoAperturaCierreDAOJpaImpl().
						   getProcesoAperturaCierreByFechaAndTurno(tiempo.toTimestamp(dteFechaInicial.getValue()) ,
								   								   turno.getIdturno().intValue() ,
								   								   proceso.getIdproceso().intValue());
				 
				 if (pac!=null) {
					 //Sistema.mensaje("proceso apertura cierre ->" + pac.getIdprocesoaperturacierre() +" con fecha: " + pac.getFechaapertura());
				     System.out.println("proceso apertura cierre ->" + pac.getIdprocesoaperturacierre() +" con fecha: " + pac.getFechaapertura());
				 }else{
					 Sistema.mensaje("No existe proceso apertura para la fecha escogida ");
				 }
				 
			 }else{
				 /*  buscar sin incluir el turno */
				 if (dteFechaInicial.getValue()==null) {
					 Sistema.mensaje("Debe escoger una fecha ");
					 return;
				 }
				 
				 System.out.println("todos los turnos"); 
				 
				 
			 }
			 
			 /* List<OeeParada>  paradas  =  new OeeParadaDAOJpaImpl()
					 		.getOeeParadaByIdProcesoAndTipoParadaAndTipoEquipo(proceso.getIdproceso() , tipoParada , tipoEquipoPersona );
			 cargarListbox(new OeeParada()   		, paradas      		  ,  lbxParadas    	     , "Parada" ); */
		 }else{
			 proceso = null;
			 parada  = null;
			 lbxParadas.getItems().clear();
		 }
	}
	
	
	@Override
	public void onSelect$lbxParadas() throws InterruptedException {
		 if (lbxParadas.getSelectedIndex()>0) {
			 parada = (OeeParada) lbxParadas.getSelectedItem().getValue();
		 }else{
			 parada = null;
		 }
	}
	
	@Override
	public void onSelect$lbxTipoParada() throws InterruptedException {
		 if (lbxTipoParada.getSelectedIndex()>0) {
			 tipoParada = (Boolean) lbxTipoParada.getSelectedItem().getValue();
		 }else{
			 tipoParada = null;
		 }
	}
	
	public void onSelect$lbxTipoEquipoPersona() throws InterruptedException {
		 if (lbxTipoEquipoPersona.getSelectedIndex()>0) {
			 tipoEquipoPersona = (Boolean) lbxTipoEquipoPersona.getSelectedItem().getValue();
		 }else{
			 tipoEquipoPersona = null;
		 }
	}
	
	@Override
	public void onClick$btnPdf() throws InterruptedException, SuspendNotAllowedException, JRException {
	    
		 if (dteFechaInicial.getValue()==null) {
			 Sistema.mensaje("Debe escoger una fecha ");
			 return;
		 }
		
		if (proceso == null) {
			Sistema.mensaje("Debe escojer un proceso");
			return;
		}
		
	  /* 	if (parada == null) {
			Sistema.mensaje("Debe escojer una Parada");
			return;
		}
		
		if (tipoParada == null) {
			Sistema.mensaje("Debe escojer un Tipo de Parada");
			return;
		}
		
		if (tipoEquipoPersona == null) {
			Sistema.mensaje("Debe especificar si es por Equipo o Persona ");
			return;
		}  */
		
		Map<String,Object> parameters = new HashMap<String,Object>();
		
		if (turno != null) {
			 //if (pac!=null) {
				 //Sistema.mensaje("proceso apertura cierre ->" + pac.getIdprocesoaperturacierre() +" con fecha: " + pac.getFechaapertura());
				 System.out.println("tipo 1 -> por turno individual");
				 parameters.put("tipo", 1);
				 //parameters.put("idpac", pac.getIdprocesoaperturacierre());
				 parameters.put("idturno", turno.getIdturno());
				 parameters.put("idproceso", proceso.getIdproceso());
				 parameters.put("proceso", proceso.getDescripcionproceso());
				 //parameters.put("fecha_proceso", pac.getFechaapertura());
				 parameters.put("fecha_proceso", dteFechaInicial.getValue());
				 doImprimir("OeeDetalleParadaReporteBi.jasper", parameters );
			/* }else{
				 Sistema.mensaje("No existe proceso apertura para el turno y la fecha  escogida ");
			 } */
		}else{
			
			 System.out.println("tipo 0 -> carga todos los turnos ");
			 parameters.put("tipo", 0);
			 parameters.put("proceso", proceso.getDescripcionproceso());
			 parameters.put("fecha_proceso", dteFechaInicial.getValue());
			 parameters.put("idproceso", proceso.getIdproceso());
			 doImprimir("OeeDetalleParadaReporteBi.jasper", parameters );
		}
		
	}
	
	@Override
	public void onClick$btnExcel() throws InterruptedException, FileNotFoundException, JRException {
		 if (dteFechaInicial.getValue()==null) {
			 Sistema.mensaje("Debe escoger una fecha ");
			 return;
		 }
		
		if (proceso == null) {
			Sistema.mensaje("Debe escojer un proceso");
			return;
		}
		
	   Map<String,Object> parameters = new HashMap<String,Object>();
	   String logo = "logo_nirsa.gif";
		
		if (turno != null) {
			// if (pac!=null) {
				 //Sistema.mensaje("proceso apertura cierre ->" + pac.getIdprocesoaperturacierre() +" con fecha: " + pac.getFechaapertura());
				 System.out.println("tipo 1 -> por turno individual");
				 parameters.put("tipo", 1);
				 //parameters.put("idpac", pac.getIdprocesoaperturacierre());
				 parameters.put("idturno", turno.getIdturno());
				 parameters.put("idproceso", proceso.getIdproceso());
				 parameters.put("proceso", proceso.getDescripcionproceso());
				 //parameters.put("fecha_proceso", pac.getFechaapertura());
				 parameters.put("fecha_proceso", dteFechaInicial.getValue());
				 new ReporteExcel().generarExcelJasper("OeeDetalleParadaReporteBiExcel", "OeeDetalleParadaReporteBiExcel.jasper", logo, parameters);
			/* }else{
				 Sistema.mensaje("No existe proceso apertura para el turno y la fecha  escogida ");
			 }*/
		}else{
			
			 System.out.println("tipo 0 -> carga todos los turnos ");
			 parameters.put("tipo", 0);
			 parameters.put("proceso", proceso.getDescripcionproceso());
			 parameters.put("fecha_proceso", dteFechaInicial.getValue());
			 parameters.put("idproceso", proceso.getIdproceso());
			 new ReporteExcel().generarExcelJasper("OeeDetalleParadaReporteBiExcel", "OeeDetalleParadaReporteBiExcel.jasper", logo, parameters);
		}
		
		
	}

	
	
}
