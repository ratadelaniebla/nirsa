package com.nw.webui.produccion;

import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.LimpiezaProceso;
import com.nw.model.LonjasProceso;
import com.nw.model.OeePeriodoBaseObjetivo;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.LimpiezaProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LonjasProcesoDAOJpaImpl;
import com.nw.model.dao.impl.OeePeriodoBaseObjetivoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;
import com.nwl.mapeo.Util.DateStruct;

//nw -04
@SuppressWarnings("serial")
public class LonjasAperturaCierreWindow extends GenericForwardComposer {

	private Listbox lbxProduccionTurno;
	private Textbox Txtanio;
	private Listbox lbxMr;
	private Listbox lbxDir;
	private Listbox lbxHi;
	private Listbox lbxMin;

	private Listbox lbxTurno;
	private Listbox lbxAperturaCierre;
	private Textbox txtOProduccion;
	private Textbox txtNomMaterial;

	private Checkbox chkRevisado;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;

	Usuario usuario = new Usuario();
	private LonjasProceso lonjasProceso;

	private DateStruct fecha1;
	@SuppressWarnings("unused")
	private String flag;
	String  opcionAperturaCierre;
	private Turno turno;
	private ProcesoAperturaCierre pac;
	private LimpiezaProceso lp;
	private Produccion produccion;
	@SuppressWarnings("unused")
	private Turno turnoLimpieza;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		cargarListas();
		lbxMr.setDisabled(true);
		lbxDir.setDisabled(true);
	}

	void limpiarDatos() {
		fecha1 = Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHi, lbxMin);
		Txtanio.setValue(String.valueOf(fecha1.year));
		chkRevisado.setChecked(false);
		txtOProduccion.setValue("");
		txtNomMaterial.setValue("");
	}

	private void cargarListas() {
		lbxProduccionTurno.getItems().clear();
		Listitem liProduccionTurno = new Listitem();
		liProduccionTurno.setValue(new Proceso());
		liProduccionTurno.setParent(lbxProduccionTurno);
		List<LimpiezaProceso> listalimpiezaProceso = new LimpiezaProcesoDAOJpaImpl()
				.getProduccionesAperturadasAreaLimpieza();
		if (listalimpiezaProceso != null) {
			for (LimpiezaProceso lp : listalimpiezaProceso) {
				liProduccionTurno = new Listitem();
				liProduccionTurno.setValue(lp);
				//Produccion produccion = new ProduccionDAOJpaImpl()
				//		.getProduccionById(lp.getProduccion().getIdproduccion());
				produccion = lp.getProduccion();
				
				Turno turno = new TurnoDAOJpaImpl().getFindTurnoId(lp.getTurno()
						.getIdturno());
				String texto = produccion.getFechaproduccion().toString()
						.substring(0, 10)
						+ " Turno: " + turno.getIdturno();
				liProduccionTurno.setTooltiptext(texto);
				new Listcell(texto).setParent(liProduccionTurno);
				liProduccionTurno.setParent(lbxProduccionTurno);
				// lbxProduccionTurno.setSelectedIndex(0);
			}
			lbxProduccionTurno.setSelectedIndex(0);
		} else {
			Sistema.mensaje("Error al cargar data de Produccion/Turno");
		}

		Util.cargarLista(Turno.class, new TurnoDAOJpaImpl().getTurnos(),
				lbxTurno, "Error al cargar data de Turno Labor", false, "Turno");
		
		lbxTurno.setSelectedIndex(1);//0
		
		if (lbxTurno.getSelectedIndex() > 0) {
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
		}	
	}

	public void onSelect$lbxProduccionTurno() throws InterruptedException {
		if (lbxProduccionTurno.getSelectedIndex() > 0) {
			lp = (LimpiezaProceso) lbxProduccionTurno.getSelectedItem()
					.getValue();
			cargarLonjasActiva();
		} else {
			Sistema.mensaje("Seleccione un Turno");
		}
	}

	private void cargarLonjasActiva() {
		//produccion = new ProduccionDAOJpaImpl().getProduccionById(lp.getProduccion()
		//		.getIdproduccion());
		produccion = lp.getProduccion();
		
		if (lbxTurno.getSelectedIndex() > 0) {
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
		}	
		
		DateStruct fecha = Util.limpiarMesDiaHoraMin(
				Util.toTimestamp(new Date()), lbxMr, lbxDir,
				lbxHi, lbxMin);
		fecha1 = fecha;
		System.out.println("turno ->" + turno.getIdturno());
		System.out.println("fecha actual ->"+fecha1.toTimestamp());
		Txtanio.setValue(String.valueOf(fecha.year));
		
		lonjasProceso =  new ProcesoAperturaCierreDAOJpaImpl()
		   .getProcesoAperturaCierreLonjasActivoByTurno(fecha1.toTimestamp(), turno.getIdturno());
		
		if (lonjasProceso != null) {
			if (lonjasProceso.getNombrematerial()!= null) {
				txtNomMaterial.setValue(lonjasProceso.getNombrematerial());
			}
			if (lonjasProceso.getOrdenproduccion()!= null) {
				txtOProduccion.setValue(lonjasProceso.getOrdenproduccion());
			}
		}else{
			txtNomMaterial.setValue("");
			txtOProduccion.setValue("");
		}
		
		
		/* if (produccion == null) {
			pac = new ProcesoAperturaCierre();
			lp = new LimpiezaProceso();
			lonjasProceso = new LonjasProceso();
			turnoLimpieza = null;
			limpiarDatos();
		} else {
			lonjasProceso = new ProcesoAperturaCierreDAOJpaImpl()
					.getProcesoAperturaCierreLonjasActivo();
			if (lonjasProceso != null) {
				 //pac = new ProcesoAperturaCierreDAOJpaImpl()
					//	.getProcesoAperturaCierreById(lonjasProceso
						//		.getIdprocesoaperturacierre());  
								
				pac = lonjasProceso.getProcesoAperturaCierre();
				DateStruct fecha = Util.limpiarMesDiaHoraMin(
						Util.toTimestamp(pac.getFechaapertura()), lbxMr,
						lbxDir, lbxHi, lbxMin);
				fecha1 = fecha;
				Txtanio.setValue(String.valueOf(fecha.year));
				setLbxTurno();
			} else {
				pac = new ProcesoAperturaCierre();
				lonjasProceso = new LonjasProceso();
				turnoLimpieza = null;
				limpiarDatos();
			}
		} */
	}

    /*	private void setLbxTurno() {
		turnoLimpieza = new TurnoDAOJpaImpl().getFindTurnoId(lp.getTurno().getIdturno());
		turno = turnoLimpieza;
		int index = Util.findIndexItemByValue(lbxTurno, turno);
		lbxTurno.setSelectedIndex(index);
	} */

	public void onSelect$lbxTurno() throws InterruptedException {
		if (lbxTurno.getSelectedIndex() > 0) {
			setTurno((Turno) lbxTurno.getSelectedItem().getValue());
			cargarLonjasActiva();
		} else {
			Sistema.mensaje("Seleccione un Turno");
			turno = null;
		}
	}

	public void onSelect$lbxMr() throws InterruptedException {
		//Util.alSeleccionarMes(lbxMr, fecha1, "Seleccione un mes");
		if (lbxMr.getSelectedIndex() > 0) {
			fecha1.month = (String) lbxMr.getSelectedItem().getValue();
		} else {
			fecha1.month = null;
			Sistema.mensaje("Seleccione un mes");
		}
	}

	public void onSelect$lbxDir() throws InterruptedException {
		if (lbxDir.getSelectedIndex() > 0) {
			fecha1.day = (String) lbxDir.getSelectedItem().getValue();
		} else {
			fecha1.day = null;
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHi() throws InterruptedException {
		if (lbxHi.getSelectedIndex() > 0) {
			fecha1.hour = (String) lbxHi.getSelectedItem().getValue();
		} else {
			fecha1.hour = null;
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMin() throws InterruptedException {
		if (lbxMin.getSelectedIndex() > 0) {
			fecha1.minute = (String) lbxMin.getSelectedItem().getValue();
		} else {
			fecha1.minute = null;
			Sistema.mensaje("Seleccione un minuto");
		}
	}
	
	public void gestionLonjasProceso( OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo ,
									  ProcesoAperturaCierre  procesoAperturaCierre, 
									  Integer				 estado){
		lonjasProceso.setUsuario(usuario);
		lonjasProceso.setFechareg(new java.sql.Timestamp(
				new Date().getTime()));
		//lonjasProceso.setEstado(estado);
		/*lonjasProceso
		.setIdprocesoaperturacierre(procesoAperturaCierre
				.getIdprocesoaperturacierre()); */
		lonjasProceso.setProcesoAperturaCierre(procesoAperturaCierre);

		lonjasProceso
				.setPeriodoBaseTiempoLonjas(oeePeriodoBaseObjetivo
						.getPeriodoBaseTiempo());
		lonjasProceso
				.setPeriodoBaseVelocidadLonjas(oeePeriodoBaseObjetivo
						.getPeriodoBaseVelocidad());
		lonjasProceso
				.setPeriodoBaseCalidadLonjas(oeePeriodoBaseObjetivo
						.getPeriodoBaseCalidad());
		lonjasProceso
				.setPeriodoBaseGeneral(oeePeriodoBaseObjetivo
						.getPeriodoBaseGeneral());
		lonjasProceso.setObjetivoGeneral(oeePeriodoBaseObjetivo
				.getObjetivoGeneral());
		double oee = oeePeriodoBaseObjetivo
				.getPeriodoBaseTiempo()
				* oeePeriodoBaseObjetivo
						.getPeriodoBaseVelocidad()
				* oeePeriodoBaseObjetivo
						.getPeriodoBaseCalidad();
		lonjasProceso.setOee(oee);
		lonjasProceso.setTurno(turno);
		//corr.req-nw-04 : asignar el objeto produccion y el limpieza_proceso
		if (produccion!=null) {
			lonjasProceso.setProduccion(produccion);	
		}
		if (lp!=null) {
			lonjasProceso.setLimpiezaProceso(lp);	
		}
		lonjasProceso
				.setOeePeriodoBaseObjetivo(oeePeriodoBaseObjetivo);
		
		lonjasProceso.setOrdenproduccion(txtOProduccion.getValue());
		lonjasProceso.setNombrematerial(txtNomMaterial.getValue());
		
		new LonjasProcesoDAOJpaImpl()
				.saveOrUpdate(lonjasProceso);
		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		cargarLonjasActiva();
		lbxAperturaCierre.setSelectedIndex(0);
		chkRevisado.setChecked(false);
	}

	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
			OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo = new OeePeriodoBaseObjetivoDAOJpaImpl()
					.getOeePeriodoBaseObjetivoByIdProcesoAndEstado(9, true);
			
			if (oeePeriodoBaseObjetivo==null) {
				Sistema.mensaje("No se han registrado datos en tabla: oee_periodo_base_objetivo");
				return;
			}
			
			if (turno == null) {
				Sistema.mensaje("Debe escojer un turno");
				return;
			}
			
		   /*TODO Este metodo valida q se escoja la fecha ( mes, dia , hora , minuto) */
		   if (Util.validarObjetoFecha(fecha1)) {
			   Sistema.mensaje("Seleccione bien la fecha");
			   return;
		   }
		   
		   
		   if (Util.validarListboxFecha(lbxMr,lbxDir,lbxHi,lbxMin)) {
			 Sistema.mensaje("Seleccione bien la fecha defecto");
			 return;
		   }
			
			flag = (String) lbxAperturaCierre.getSelectedItem().getValue();
			opcionAperturaCierre = (String) lbxAperturaCierre.getSelectedItem().getValue();
			
			lonjasProceso =  new ProcesoAperturaCierreDAOJpaImpl()
			   .getProcesoAperturaCierreLonjasActivoByTurno(fecha1.toTimestamp(), turno.getIdturno());
			
			
			if (lonjasProceso != null) {
				System.out.println("LONJAS EXISTENTE");
				pac = lonjasProceso.getProcesoAperturaCierre();
				//en este punto el objeto  lonjasProceso esta con un ProcesoAperturaCierre abierto 
				//abria q validar q si es asi y el usuario escoge apertura no permita hacerlo xq no se ha cerrado
				// y solo se puede abrir uno x fecha y turno
				opcionAperturaCierre = (String) lbxAperturaCierre.getSelectedItem().getValue();
				
				System.out.println("opcionAperturaCierre 					 ->" + opcionAperturaCierre);
				System.out.println("lonjasProceso.getTurno().getIdturno()    ->" + lonjasProceso.getTurno().getIdturno());
				System.out.println("turno.getIdturno() 					     ->" + turno.getIdturno());
				
				if (opcionAperturaCierre.equals("1") && turno.getIdturno().equals(lonjasProceso.getTurno().getIdturno()) ) {// 1.- Aperturado y turno 1
					Sistema.mensaje("Existe un proceso para la Fecha actual y el Turno ");
					return;
				}
				
				//cerrar el proceso apertura cierre 
				if (opcionAperturaCierre.equals("0") ){ // && turno.getIdturno().equals(lonjasProceso.getTurno().getIdturno()) ) {
					
					if (lonjasProceso.getProcesoAperturaCierre().getEstado() == 0) {
						Sistema.mensaje("El proceso ya ha sido cerrado");
						return;
					}
					
					System.out.println("cierre del proceso");
					pac.setFechacierre(fecha1.toTimestamp());
					Proceso proceso = new Proceso();
					proceso.setIdproceso(9);
					pac.setProceso(proceso);
					pac.setEstado(0);
					  new ProcesoAperturaCierreDAOJpaImpl()
							.saveAndUpdate(pac);
					gestionLonjasProceso(oeePeriodoBaseObjetivo, pac,  0);
					
				}
				
				//validar un  cierre de proceso no valido
				if (opcionAperturaCierre.equals("0") && (! turno.getIdturno().equals(lonjasProceso.getTurno().getIdturno()) ) ) {
					Sistema.mensaje("Solo se puede cerrar un proceso para el turno :  " +" " + lonjasProceso.getTurno().getIdturno());
					return;
				}
				
			}else{
				 
				if (opcionAperturaCierre.equals("0") ){
					Sistema.mensaje("No puede cerrar un proceso que no ha sido Aperturado");
					return;
				}
				
				System.out.println("NUEVO LONJAS Y PAC");
				//debe permitir registrar la apertura del proceso, no importa el turno xq no existe el registro de rackeo 
				pac = new ProcesoAperturaCierre();
				pac.setFechaapertura(fecha1.toTimestamp());
				Proceso proceso = new Proceso();
				proceso.setIdproceso(9);
				pac.setProceso(proceso);
				pac.setEstado(1);
				ProcesoAperturaCierre procesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl()
						.saveAndUpdate(pac);
				lonjasProceso = new LonjasProceso();
				gestionLonjasProceso(oeePeriodoBaseObjetivo,procesoAperturaCierre, 1);
				
			}

		}
	}

	private boolean validarCampos() {
		if (lbxProduccionTurno.getSelectedIndex() == 0) {
			Sistema.mensaje("Seleccione Produccion/turno");
			lbxProduccionTurno.setFocus(true);
			return false;
		}
		if (lbxTurno.getSelectedIndex() == 0) {
			Sistema.mensaje("Seleccione un turno");
			lbxTurno.setFocus(true);
			return false;
		}
		if (!chkRevisado.isChecked()) {
			Sistema.mensaje("Seleccione revisado");
			chkRevisado.setFocus(true);
			return false;
		}
		/*if (!fecha1.hasValue()) {
			Sistema.mensaje("Ingrese la fecha completa");
			return false;
		} */
		return true;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
