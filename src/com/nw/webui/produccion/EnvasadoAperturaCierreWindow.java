package com.nw.webui.produccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EnvasadoProceso;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LonjasProceso;
import com.nw.model.OeePeriodoBaseObjetivo;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LimpiezaProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LonjasProcesoDAOJpaImpl;
import com.nw.model.dao.impl.OeePeriodoBaseObjetivoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;
import com.nwl.mapeo.Util.DateStruct;

@SuppressWarnings("serial")
public class EnvasadoAperturaCierreWindow extends GenericForwardComposer {

	private Listbox lbxProduccionTurno;
	private Textbox TxtAnio;
	private Listbox lbxMr;
	private Listbox lbxDir;
	private Listbox lbxHi;
	private Listbox lbxMin;
	private Listbox lbxTurno;
	private Listbox lbxAperturaCierre;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;
	private Checkbox chkRevisado, chkModoAp;
	Label labelModo;

	Usuario usuario = new Usuario();
	private Turno turno;
	private EnvasadoProceso envasadoProceso;
	private DateStruct fecha1;
	private String flag;
	private LimpiezaProceso limpiezaproceso;
	private Produccion produccion;
	private ProcesoAperturaCierre pac;
	private Turno turnoLimpieza;
	String  opcionAperturaCierre;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		//cargarListas();
		lbxMr.setDisabled(true);
		lbxDir.setDisabled(true);
		chkModoAp.setChecked(true);
		cargarTurno();
		onCheck$chkModoAp();
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
				Produccion produccion = new ProduccionDAOJpaImpl()
						.getProduccionById(lp.getProduccion().getIdproduccion());
				Turno turno = new TurnoDAOJpaImpl().getFindTurnoId(lp.getTurno()
						.getIdturno());
				String texto = produccion.getFechaproduccion().toString()
						.substring(0, 10)
						+ " Turno: " + turno.getIdturno();
				liProduccionTurno.setTooltiptext(texto);
				new Listcell(texto).setParent(liProduccionTurno);
				liProduccionTurno.setParent(lbxProduccionTurno);
			}
			lbxProduccionTurno.setSelectedIndex(0);
		} else {
			Sistema.mensaje("No existen Produccion/Turno aperturadas");
		}
		
	}
	
	int ESTADO_APERTURADO = 1;
	private void cargarProcesosEnvasadosAperturados() {
		lbxProduccionTurno.getItems().clear();
		
		Listitem item = new Listitem();
		 item.setValue(new Proceso());
		 item.setParent(lbxProduccionTurno);
		 List<EnvasadoProceso> listaEnvasadoProceso = new EnvasadoProcesoDAOJpaImpl().getEnvasadoProcesoByEstado(ESTADO_APERTURADO);
		
			if (! listaEnvasadoProceso.isEmpty()) {
				for (EnvasadoProceso ep : listaEnvasadoProceso) {
					item = new Listitem();
					item.setValue(ep);
					Produccion produccion = ep.getProduccion();
					
					Turno turno = new TurnoDAOJpaImpl().getFindTurnoId(ep.getTurno()
							.getIdturno());
					String texto = produccion.getFechaproduccion().toString().substring(0, 10)
							+ " Turno: " + turno.getIdturno();
					item.setTooltiptext(texto);
					new Listcell(texto).setParent(item);
					item.setParent(lbxProduccionTurno);
				}
				lbxProduccionTurno.setSelectedIndex(0);
			} else {
				Sistema.mensaje("No existen procesos Produccion/Turno aperturados");
			}
		
		
	}
	
	public void cargarTurno(){
		Util.cargarLista(Turno.class, new TurnoDAOJpaImpl().getTurnos(),
				lbxTurno, "Error al cargar data de Turno Labor", false, "Turno");
		
		lbxTurno.setSelectedIndex(1);//0
		
		if (lbxTurno.getSelectedIndex() > 0) {
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
		}	
		
	}

	public void onSelect$lbxProduccionTurno() throws InterruptedException {
		if (lbxProduccionTurno.getSelectedIndex() > 0) {
			if (chkModoAp.isChecked()) {
				limpiezaproceso = (LimpiezaProceso) lbxProduccionTurno.getSelectedItem()
						.getValue();
				cargarEnvasadoActivo();
			}else{
				envasadoProceso = (EnvasadoProceso) lbxProduccionTurno.getSelectedItem().getValue();
				
				produccion = envasadoProceso.getProduccion();
				
				DateStruct fecha = Util.limpiarMesDiaHoraMin(
						Util.toTimestamp(new Date()), lbxMr, lbxDir,
						lbxHi, lbxMin);
				fecha1 = fecha;
				System.out.println("turno ->" + turno.getIdturno());
				System.out.println("fecha actual ->"+fecha1.toTimestamp());
				TxtAnio.setValue(String.valueOf(fecha.year));
			}

		} else {
			Sistema.mensaje("Seleccione un Turno");
			limpiezaproceso = null;
			TxtAnio.setValue("");
			fecha1 = null;
		}
	}

	private void cargarEnvasadoActivo() {
		produccion = limpiezaproceso.getProduccion(); //new ProduccionDAOJpaImpl().getProduccionById(lp.getProduccion() .getIdproduccion());
		
		if (lbxTurno.getSelectedIndex() > 0) {
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
		}	
		
		DateStruct fecha = Util.limpiarMesDiaHoraMin(
				Util.toTimestamp(new Date()), lbxMr, lbxDir,
				lbxHi, lbxMin);
		fecha1 = fecha;
		System.out.println("turno ->" + turno.getIdturno());
		System.out.println("fecha actual ->"+fecha1.toTimestamp());
		TxtAnio.setValue(String.valueOf(fecha.year));
		
		//envasadoProceso = new ProcesoAperturaCierreDAOJpaImpl()
		//.getProcesoAperturaCierreEnvasadoActivo();
		
		envasadoProceso =  new ProcesoAperturaCierreDAOJpaImpl()
        .getProcesoAperturaCierreEnvasadoActivoByTurno(fecha1.toTimestamp(), turno.getIdturno());
		
		/* 
		pac = envasadoProceso.getProcesoAperturaCierre();
		DateStruct fecha = Util.limpiarMesDiaHoraMin(
				Util.toTimestamp(pac.getFechaapertura()), lbxMr,
				lbxDir, lbxHi, lbxMin);
		fecha1 = fecha;
		TxtAnio.setValue(String.valueOf(fecha.year)); */
			 
		 
		
		/*
		
		if (produccion == null) {
			pac = new ProcesoAperturaCierre();
			lp = new LimpiezaProceso();
			envasadoProceso = new EnvasadoProceso();
			turnoLimpieza = null;
			limpiarDatos();
		} else {
			envasadoProceso = new ProcesoAperturaCierreDAOJpaImpl()
					.getProcesoAperturaCierreEnvasadoActivo();
			
			if (envasadoProceso != null) {
				pac = envasadoProceso.getProcesoAperturaCierre();
				DateStruct fecha = Util.limpiarMesDiaHoraMin(
						Util.toTimestamp(pac.getFechaapertura()), lbxMr,
						lbxDir, lbxHi, lbxMin);
				fecha1 = fecha;
				TxtAnio.setValue(String.valueOf(fecha.year));
				//setLbxTurno();
			} else {
				pac = new ProcesoAperturaCierre();
				envasadoProceso = new EnvasadoProceso();
				turnoLimpieza = null;
				limpiarDatos();
			}
		} */
	}

    void setLbxTurno() {
		turnoLimpieza = new TurnoDAOJpaImpl().getFindTurnoId(limpiezaproceso.getTurno().getIdturno());
		turno = turnoLimpieza;
		int index = Util.findIndexItemByValue(lbxTurno, turno);
		lbxTurno.setSelectedIndex(index);
	}

	public void onSelect$lbxTurno() throws InterruptedException {
		if (lbxTurno.getSelectedIndex() > 0) {
			setTurno((Turno) lbxTurno.getSelectedItem().getValue());
		} else {
			Sistema.mensaje("Seleccione un Turno");
		}
	}

	public void onSelect$lbxMr() throws InterruptedException {
		if (lbxMr.getSelectedIndex() > 0) {
			fecha1.month = (String) lbxMr.getSelectedItem().getValue();
		} else {
			fecha1.month = null;
			Sistema.mensaje("Seleccione un mes");
		}
	  /*	if (lbxMr.getSelectedIndex() > 0) {
			fecha1.month = (String) lbxMr.getSelectedItem().getValue();
			ArrayList<String> days = new ArrayList<String>();
			int daysMonth = Util.diasDelMes(Integer.parseInt(fecha1.month),
					fecha1.year);
			for (int i = 1; i <= daysMonth; i++) {
				days.add(Integer.toString(i));
			}
			ListModelList lml = new ListModelList(days);

			lbxDir.setModel(lml);
			lbxDir.setSelectedIndex(0);
		} else {
			Sistema.mensaje("Seleccione un mes");
		} */
	}

	public void onSelect$lbxDir() throws InterruptedException {
		if (lbxDir.getSelectedIndex() > 0) {
			fecha1.day = (String) lbxDir.getSelectedItem().getValue();
		} else {
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHi() throws InterruptedException {
		if (lbxHi.getSelectedIndex() > 0) {
			fecha1.hour = (String) lbxHi.getSelectedItem().getValue();

		} else {
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMin() throws InterruptedException {
		if (lbxMin.getSelectedIndex() > 0) {
			fecha1.minute = (String) lbxMin.getSelectedItem().getValue();

		} else {
			Sistema.mensaje("Seleccione un minuto");
		}
	}

	private void limpiarDatos() {
		fecha1 = Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHi, lbxMin);
		TxtAnio.setValue(String.valueOf(fecha1.year));
		lbxTurno.setSelectedIndex(0);
		lbxAperturaCierre.setSelectedIndex(0);
		chkRevisado.setChecked(false);
	}
	
	
	

	public void onClick$btnGrabarAnterior() throws InterruptedException {
		if (validarCampos()) {
			OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo = new OeePeriodoBaseObjetivoDAOJpaImpl()
					.getOeePeriodoBaseObjetivoByIdProcesoAndEstado(13, true);
			
			
			flag = (String) lbxAperturaCierre.getSelectedItem().getValue();

			switch (flag) {
			case "1":
				if (pac.getEstado() == null) {
					if (new ProcesoAperturaCierreDAOJpaImpl()
							.countProcesoAperturaCierreByFechaAperturaAndIdProcesoAndIdTurnoEnvasadoProceso(
									fecha1.toTimestamp(),
									fecha1.toTimestampZero(), 13,
									turno.getIdturno()) == 0) {
						pac.setFechaapertura(fecha1.toTimestamp());
						//pac.setIdproceso(13);
						Proceso proceso = new Proceso();
						proceso.setIdproceso(13);
						pac.setProceso(proceso);
						pac.setEstado(1);

						ProcesoAperturaCierre procesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl()
								.guardarAperturaCierre(pac);

						envasadoProceso.setUsuario(usuario);
						envasadoProceso.setFechareg(new java.sql.Timestamp(
								new Date().getTime()));
						envasadoProceso
								.setProcesoAperturaCierre(procesoAperturaCierre);
						double oee = oeePeriodoBaseObjetivo
								.getPeriodoBaseTiempo()
								* oeePeriodoBaseObjetivo
										.getPeriodoBaseVelocidad()
								* oeePeriodoBaseObjetivo
										.getPeriodoBaseCalidad();
						envasadoProceso.setOee(oee);
						envasadoProceso.setTurno(turno);
						envasadoProceso.setEstado(1);
						//corr.req-nw-02 : asignar el objeto produccion y el limpieza_proceso
						if (produccion!=null) {
							envasadoProceso.setProduccion(produccion);	
						}
						if (limpiezaproceso!=null) {
							envasadoProceso.setLimpiezaProceso(limpiezaproceso);	
						}
						envasadoProceso
								.setOeePeriodoBaseObjetivo(oeePeriodoBaseObjetivo);
						new EnvasadoProcesoDAOJpaImpl()
								.saveOrUpdate(envasadoProceso);
						Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
						cargarEnvasadoActivo();
						lbxAperturaCierre.setSelectedIndex(0);
						chkRevisado.setChecked(false);
					} else {
						Sistema.mensaje("Existe un proceso en esta fecha");
						limpiarDatos();
					}
				} else
					Sistema.mensaje("Existe un proceso aperturado");
				break;
			case "0":
				if (pac.getEstado() != null
						&& envasadoProceso.getEstado() != null)
					if (pac.getEstado() == 1
							&& envasadoProceso.getEstado() == 1) {
						pac.setFechacierre(fecha1.toTimestamp());
						//pac.setIdproceso(13);
						Proceso proceso = new Proceso();
						proceso.setIdproceso(13);
						pac.setProceso(proceso);
						pac.setEstado(0);
						ProcesoAperturaCierre procesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl()
								.guardarAperturaCierre(pac);

						envasadoProceso.setUsuario(usuario);
						envasadoProceso
								.setProcesoAperturaCierre(procesoAperturaCierre);
						envasadoProceso
								.setPeriodoBaseTiempoEnvasado(oeePeriodoBaseObjetivo
										.getPeriodoBaseTiempo());
						envasadoProceso
								.setPeriodoBaseVelocidadEnvasado(oeePeriodoBaseObjetivo
										.getPeriodoBaseVelocidad());
						envasadoProceso
								.setPeriodoBaseCalidadEnvasado(oeePeriodoBaseObjetivo
										.getPeriodoBaseCalidad());
						envasadoProceso
								.setPeriodoBaseGeneral(oeePeriodoBaseObjetivo
										.getPeriodoBaseGeneral());
						envasadoProceso
								.setObjetivoGeneral(oeePeriodoBaseObjetivo
										.getObjetivoGeneral());
						double oee = oeePeriodoBaseObjetivo
								.getPeriodoBaseTiempo()
								* oeePeriodoBaseObjetivo
										.getPeriodoBaseVelocidad()
								* oeePeriodoBaseObjetivo
										.getPeriodoBaseCalidad();
						envasadoProceso.setOee(oee);
						envasadoProceso.setTurno(turno);
						envasadoProceso.setEstado(0);
						//corr.req-nw-02 : asignar el objeto produccion y el limpieza_proceso
						if (produccion!=null) {
							envasadoProceso.setProduccion(produccion);	
						}
						if (limpiezaproceso!=null) {
							envasadoProceso.setLimpiezaProceso(limpiezaproceso);	
						}
						envasadoProceso
								.setOeePeriodoBaseObjetivo(oeePeriodoBaseObjetivo);
						new EnvasadoProcesoDAOJpaImpl()
								.saveOrUpdate(envasadoProceso);
						Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
						cargarEnvasadoActivo();
						lbxAperturaCierre.setSelectedIndex(0);
						chkRevisado.setChecked(false);
					} else
						Sistema.mensaje("No existe un proceso aperturado en la fecha y turno indicado");
				else
					Sistema.mensaje("El proceso en la fecha y turno indicado ya fue cerrado");
				break;
			default:
				break;
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
		if (fecha1 == null) {  //!fecha1.hasValue()
			Sistema.mensaje("Ingrese la fecha completa");
			return false;
		}
		return true;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	
	/* Nuevo metodo para guardar  */
	
	public void gestionEnvasadoProceso( OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo ,
			  ProcesoAperturaCierre  procesoAperturaCierre, 
			  Integer				 estado){
		envasadoProceso.setUsuario(usuario);
		envasadoProceso.setFechareg(new java.sql.Timestamp(
				new Date().getTime()));
		envasadoProceso.setEstado(estado);
		/*envasadoProceso
		.setIdprocesoaperturacierre(procesoAperturaCierre
		.getIdprocesoaperturacierre()); */
		envasadoProceso.setProcesoAperturaCierre(procesoAperturaCierre);

		envasadoProceso.setPeriodoBaseTiempoEnvasado(oeePeriodoBaseObjetivo .getPeriodoBaseTiempo());
		envasadoProceso.setPeriodoBaseVelocidadEnvasado(oeePeriodoBaseObjetivo.getPeriodoBaseVelocidad());
		envasadoProceso.setPeriodoBaseCalidadEnvasado(oeePeriodoBaseObjetivo.getPeriodoBaseCalidad());
		envasadoProceso.setPeriodoBaseGeneral(oeePeriodoBaseObjetivo .getPeriodoBaseGeneral());
		envasadoProceso.setObjetivoGeneral(oeePeriodoBaseObjetivo.getObjetivoGeneral());
		double oee = oeePeriodoBaseObjetivo .getPeriodoBaseTiempo()
						* oeePeriodoBaseObjetivo .getPeriodoBaseVelocidad() * oeePeriodoBaseObjetivo.getPeriodoBaseCalidad();
		envasadoProceso.setOee(oee);
		envasadoProceso.setTurno(turno);
		//corr.req-nw-03 : asignar el objeto produccion y el limpieza_proceso
		if (produccion!=null) {
			envasadoProceso.setProduccion(produccion);	
		}
		if (limpiezaproceso!=null) {
			envasadoProceso.setLimpiezaProceso(limpiezaproceso);	
		}
		envasadoProceso.setOeePeriodoBaseObjetivo(oeePeriodoBaseObjetivo);

		//envasadoProceso.setOrdenproduccion(txtOProduccion.getValue());
		//envasadoProceso.setNombrematerial(txtNomMaterial.getValue());

		new EnvasadoProcesoDAOJpaImpl() .saveOrUpdate(envasadoProceso);
		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		 if (chkModoAp.isChecked()) {
			 cargarEnvasadoActivo();
		 }else{
			 cargarProcesosEnvasadosAperturados();
			 asignarTurno();
		 }
		//cargarEnvasadoActivo();
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
			
			flag = (String) lbxAperturaCierre.getSelectedItem().getValue();
			opcionAperturaCierre = (String) lbxAperturaCierre.getSelectedItem().getValue();
			
			if (opcionAperturaCierre == null) {
				Sistema.mensaje("Debe escojer una opcion de Apertura/Cierre");
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
		
		
		   if (chkModoAp.isChecked()) {
			   envasadoProceso =  new ProcesoAperturaCierreDAOJpaImpl()
		        .getProcesoAperturaCierreEnvasadoActivoByTurno(fecha1.toTimestamp(), turno.getIdturno());
				//new ProcesoAperturaCierreDAOJpaImpl().getProcesoAperturaCierreEnvasadoActivo();
		   } 
			
			
			if (envasadoProceso != null) {
				System.out.println("ENVASADO APC EXISTENTE");
				pac = envasadoProceso.getProcesoAperturaCierre();
				//en este punto el objeto  envasadoProceso esta con un ProcesoAperturaCierre abierto 
				//habria q validar q si es asi y el usuario escoge apertura no permita hacerlo xq no se ha cerrado
				// y solo se puede abrir uno x fecha y turno
				opcionAperturaCierre = (String) lbxAperturaCierre.getSelectedItem().getValue();
				
				
				System.out.println("opcionAperturaCierre 					 ->" + opcionAperturaCierre);
				System.out.println("lonjasProceso.getTurno().getIdturno()    ->" + envasadoProceso.getTurno().getIdturno());
				System.out.println("turno.getIdturno() 					     ->" + turno.getIdturno());
				
				if (opcionAperturaCierre.equals("1") && turno.getIdturno().equals(envasadoProceso.getTurno().getIdturno()) ) {// 1.- Aperturado y turno 1
					Sistema.mensaje("Existe un proceso para la Fecha actual y el Turno ");
					return;
				}
				
				//cerrar el proceso apertura cierre 
				if (opcionAperturaCierre.equals("0") ){ // && turno.getIdturno().equals(lonjasProceso.getTurno().getIdturno()) ) {
					
					if (envasadoProceso.getProcesoAperturaCierre().getEstado() == 0) {
						Sistema.mensaje("El proceso ya ha sido cerrado");
						return;
					}
					
					System.out.println("cierre del proceso");
					pac.setFechacierre(fecha1.toTimestamp());
					Proceso proceso = new Proceso();
					proceso.setIdproceso(13);
					pac.setProceso(proceso);
					pac.setEstado(0);
					  new ProcesoAperturaCierreDAOJpaImpl()
							.saveAndUpdate(pac);
					gestionEnvasadoProceso(oeePeriodoBaseObjetivo, pac,  0);
					
				}
				
				//validar un  cierre de proceso no valido
				if (opcionAperturaCierre.equals("0") && (! turno.getIdturno().equals(envasadoProceso.getTurno().getIdturno()) ) ) {
					Sistema.mensaje("Solo se puede cerrar un proceso para el turno :  " +" " + envasadoProceso.getTurno().getIdturno());
					return;
				}
				
			}else{
				 
				if (opcionAperturaCierre.equals("0") ){
					Sistema.mensaje("No puede cerrar un proceso que no ha sido Aperturado");
					return;
				}
				
				System.out.println("NUEVO ENVASADO PROCESO Y PAC");
				//debe permitir registrar la apertura del proceso, no importa el turno xq no existe el registro de rackeo 
				pac = new ProcesoAperturaCierre();
				pac.setFechaapertura(fecha1.toTimestamp());
				Proceso proceso = new Proceso();
				proceso.setIdproceso(13);
				pac.setProceso(proceso);
				pac.setEstado(1);
				ProcesoAperturaCierre procesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl()
						.saveAndUpdate(pac);
				envasadoProceso = new EnvasadoProceso();
				gestionEnvasadoProceso(oeePeriodoBaseObjetivo,procesoAperturaCierre, 1);
				
			}

		}
	}
	
	
	public void onCheck$chkModoAp(){
		if (chkModoAp.isChecked()) {
			labelModo.setValue("Aperturar");
			cargarListas();
			asignarTurno();
		}else{
			labelModo.setValue("Cerrar");
			cargarProcesosEnvasadosAperturados();
			asignarTurno();
		}
		
	}
	
	public void asignarTurno(){
		if (! lbxTurno.getItems().isEmpty()) {
			lbxTurno.setSelectedIndex(1); 
		    turno = (Turno) lbxTurno.getSelectedItem().getValue();
		}
	}

}
