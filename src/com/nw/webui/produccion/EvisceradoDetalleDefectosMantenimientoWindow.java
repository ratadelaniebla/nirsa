package com.nw.webui.produccion;

import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.Especie;
import com.nw.model.EspecieTalla;
import com.nw.model.OeeDefecto;
import com.nw.model.OeeDetalleMediosConDefecto;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.RackeoProceso;
import com.nw.model.Talla;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.OeeDefectoDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleMediosConDefectoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleLoteDAOJpaImpl;
import com.nw.model.dao.impl.RackeoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;
import com.nwl.mapeo.Util.DateStruct;

// 10.1 
@SuppressWarnings("serial")
public class EvisceradoDetalleDefectosMantenimientoWindow extends
		GenericForwardComposer {
	Usuario usuario = new Usuario();
	private Datebox dteFechaLabor;
	private Listbox lbxDefectos;
	private Listbox lbxTurno;
	private Datebox dteProduccion;
	private Listbox lbxTurnoProd;
	private Listbox lbxLote;
	private Textbox txtLote;
	private Textbox txtEspecieTalla;
	private Intbox DcbCantidad;

	@SuppressWarnings("unused")
	private Toolbarbutton btnActualizarLotes;

	@SuppressWarnings("unused")
	private Toolbarbutton btnTomarTiempoi;
	private Listbox lbxMi;
	private Listbox lbxDi;
	private Listbox lbxHi;
	private Listbox lbxMin;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;
	private Checkbox ChkEliminar;
	@SuppressWarnings("unused")
	private Toolbarbutton btnEliminar;

	private DateStruct fechai;

	private Produccion produccion;

	private Turno turno;
	private Turno turnopro;

	private RackeoProceso rackeoProceso;

	private ProduccionDetalleLote lote;
	private ProcesoAperturaCierre procesoaperturacierre;
	private OeeDetalleMediosConDefecto detallemedioscondefecto;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		limpiarDatos();
		cargarListas();
		
	}
	
	void limpiarDatos() {
		//fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		txtEspecieTalla.setValue("");
		txtLote.setValue("");
		DcbCantidad.setValue(0);
		turno = null;
		turnopro = null;
	}
	
	private void cargarListas() {
		Util.cargarLista(Turno.class, new TurnoDAOJpaImpl().getTurnos(),
				lbxTurno, "Error al cargar data de Turno Labor", false, "Turno");
		
		Util.cargarLista(Turno.class, new TurnoDAOJpaImpl().getTurnos(),
				lbxTurnoProd, "Error al cargar data de Turno Labor", false, "Turno");

	}
	
	/* Punto 1)     29-09-2017 correcion de esto q no funcionaba */
	public void onChange$dteFechaLabor() throws InterruptedException {
		Date fechaapertura = dteFechaLabor.getValue();
		RackeoProceso rackeoProceso   = new ProcesoAperturaCierreDAOJpaImpl()
		 .getProcesoAperturaCierreRackeoActivoByFecha(  Util.toTimestamp(fechaapertura));
		
		if (rackeoProceso == null){
			//Sistema.mensaje("No existe proceso en esta fecha -> " +" " 
			//		+  Util.toTimestamp(fechaapertura));
			procesoaperturacierre = null;
		}else{
			procesoaperturacierre = rackeoProceso.getProcesoAperturaCierre();
		}
	}
	
	/* Punto 2) y 3)   */
	public void onSelect$lbxTurno() throws InterruptedException {
		if (lbxTurno.getSelectedIndex() > 0) {
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
			if (procesoaperturacierre != null) {
				rackeoProceso = new RackeoProcesoDAOJpaImpl()
						.getRackeoProcesoByIdPacAndIdTurno(
								procesoaperturacierre
										.getIdprocesoaperturacierre(), turno
										.getIdturno());
				if (rackeoProceso != null) {
					OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto = null;//new OeeDetalleMediosConDefecto();
					List<OeeDetalleMediosConDefecto> listaLotes = new OeeDetalleMediosConDefectoDAOJpaImpl()
					.getOeeDetalleMediosConDefectoByIds(
							rackeoProceso .getProcesoAperturaCierre() .getIdprocesoaperturacierre(), 12);
					  Util.cargarListboxOeeMediosConDefecto(
							  oeeDetalleMediosConDefecto, listaLotes, lbxDefectos, null, false);//, "OeeDetalleMediosConDefecto"  
					  detallemedioscondefecto = null;
				} else{
					Sistema.mensaje("No existe turno en la tabla de rackeo");
				}
			} else{
				Sistema.mensaje("No existe Proceso Apertura Cierre");
			}
		} else {
			Sistema.mensaje("Seleccione un Turno");
			turno = null;
		}
	}
	
	public void onSelect$lbxDefectos() throws InterruptedException {
		if (lbxDefectos.getSelectedIndex() > 0) {
			detallemedioscondefecto = (OeeDetalleMediosConDefecto) lbxDefectos
					.getSelectedItem().getValue();
			txtLote.setValue(String.valueOf(detallemedioscondefecto.getProduccionDetalleLote()
					.getIdlote()));
			
			EspecieTalla especieTalla = detallemedioscondefecto.getProduccionDetalleLote().getEspecieTalla();
			Especie especie           = especieTalla.getEspecie();
			Talla talla     		  =  especieTalla.getTalla();
					 
			txtEspecieTalla.setValue(String.format("%s %s",
					especie.getNombre(), talla.getNombre()));
			
			if (detallemedioscondefecto.getCantidadDefectos() != null) {
				DcbCantidad.setValue(detallemedioscondefecto.getCantidadDefectos());
			}
			
			fechai = Util.getAnioProduccionMesDiaActual( detallemedioscondefecto.getFechaHoraRegistro()  
					           , detallemedioscondefecto.getFechaHoraRegistro(), lbxMi, lbxDi, lbxHi, lbxMin);
			
		} else {
			//Sistema.mensaje("Seleccione un Defecto");
			txtLote.setValue("");
			limpiarDatos();
			detallemedioscondefecto= null;
		}
	}
	
	/* Punto 4 correcion de este metodo */
	public void onChange$dteProduccion() throws InterruptedException {
		Date fechaproduccion = dteProduccion.getValue();
		produccion = new ProduccionDAOJpaImpl().getProduccionByFecha(Util
				.toTimestamp(fechaproduccion));
		/*if (produccion == null){
			Sistema.mensaje("No existe produccion en esta fecha");
		} */
	}
	
	/* Punto 5 */
	public void onSelect$lbxTurnoProd() throws InterruptedException {
		if (lbxTurnoProd.getSelectedIndex() > 0) {
			if (produccion == null) {
				Sistema.mensaje("No se ha buscado una produccion");
				lbxTurnoProd.setSelectedIndex(0);
				turnopro = null;
			}else{
				turnopro = (Turno) lbxTurno.getSelectedItem().getValue();
				cargarLote();
			}
		
		} else {
			Sistema.mensaje("Seleccione un Turno Prod.");
			turnopro = null;
		}
	}
	
	private void cargarLote() {
		if (turnopro != null && produccion != null)
			Util.cargarLista(
					ProduccionDetalleLote.class,
					new ProduccionDetalleLoteDAOJpaImpl().getProduccionDetallelote(
							  produccion.getIdproduccion() , turnopro.getIdturno()),
					lbxLote, "Error al cargar data de Lote", false, "ProduccionDetalleLote");  //getLotes   turnopro.getIdturno(), produccion.getIdproduccion()
	}
	
	public void onSelect$lbxLote() throws InterruptedException {
		if (lbxLote.getSelectedIndex() > 0) {
			lote = (ProduccionDetalleLote) lbxLote.getSelectedItem().getValue();
			
			EspecieTalla especieTalla = lote.getEspecieTalla();
			Especie especie           = especieTalla.getEspecie();
			Talla talla     		  =  especieTalla.getTalla();
					 
			txtEspecieTalla.setValue(String.format("%s %s",
					especie.getNombre(), talla.getNombre()));
			
			//txtLote.setValue(String.valueOf(defecto.getProduccionDetalleLote()
				//	.getIdlote()));
			if (produccion != null) {
				fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(), new Date(),lbxMi, lbxDi, lbxHi, lbxMin);
				//Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
			}
		
		} else {
			lote = null;
			Sistema.mensaje("Seleccione un Lote");
		}
	}
	

	private boolean validarCampos() {
	   /*	if (!Util.validarDecimalBox(DcbCantidad,
				"El campo Cantidad debe ser mayor a cero"))
			return false; */
		if (DcbCantidad == null ){
			Sistema.mensaje("Debe ingresar una cantidad");
			return false;
		}
		
		if ( DcbCantidad.getValue() == null){
			Sistema.mensaje("Debe ingresar una cantidad.");
			return false;
		}
		
		if (DcbCantidad.getValue() <= 0) {
			Sistema.mensaje("El campo Cantidad debe ser mayor a cero");
			return false;
		}
		
	    if (Util.validarListboxFecha(lbxMi,lbxDi,lbxHi,lbxMin)) {
			  Sistema.mensaje("Seleccione bien la fecha ");
			  return false;
		}
		
		if (!ChkEliminar.isChecked()) {
			Sistema.mensaje("Seleccione revisado");
			ChkEliminar.setFocus(true);
			return false;
		}
		return true;
	}

	public void onSelect$lbxMi() throws InterruptedException {
		//Util.alSeleccionarMes(lbxMi, fechai, "Seleccione un mes");
		if (lbxMi.getSelectedIndex() > 0) {
			fechai.month = (String) lbxMi.getSelectedItem().getValue();
			Util.alSeleccionarMes(lbxDi, fechai, "Seleccione un mes");
		}else{
			fechai.month = null;
			Sistema.mensaje("Seleccione un mes");
		}
	}

	public void onSelect$lbxDi() throws InterruptedException {
		if (lbxDi.getSelectedIndex() > 0) {
			fechai.day = (String) lbxDi.getSelectedItem().getValue();
		} else {
			fechai.day = null;
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHi() throws InterruptedException {
		if (lbxHi.getSelectedIndex() > 0) {
			fechai.hour = (String) lbxHi.getSelectedItem().getValue();
		} else {
			fechai.hour = null;
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMin() throws InterruptedException {
		if (lbxMin.getSelectedIndex() > 0) {
			fechai.minute = (String) lbxMin.getSelectedItem().getValue();
		} else {
			fechai.minute = null;
			Sistema.mensaje("Seleccione un minuto");
		}
	}

	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
		
			if (produccion == null){
				Sistema.mensaje("No existe produccion en esta fecha");
				return;
			}
			
		   if (procesoaperturacierre == null) {
			   Sistema.mensaje("No existe un proceso para la Fecha de Labor ");
			   return;
		   }		
			
		   if (turno == null) {
			   Sistema.mensaje("Seleccione un turno ");
			   return;
		   }	
		   
		   if (turnopro == null) {
			   Sistema.mensaje("Seleccione un turno produccion");
			   return;
		   }	 
		   
		   if (fechai==null) {
			   Sistema.mensaje("No se ha tomado una fecha - hora de defecto ");
			   return;
		   }
			
	       if (detallemedioscondefecto != null) {
			   /* actualizar registro */
	    	   System.out.println("ACTUALIZAR      .......................................");
	    	   detallemedioscondefecto.setCantidadDefectos(DcbCantidad.getValue());
				detallemedioscondefecto.setFechaHoraRegistro(fechai.toTimestamp());
				//detallemedioscondefecto.setFechaRegistro(new java.sql.Timestamp(new Date().getTime()));
				detallemedioscondefecto.setProcesoAperturaCierre(rackeoProceso
						.getProcesoAperturaCierre());
				if (lote!=null) {
					detallemedioscondefecto.setProduccionDetalleLote(lote);
				}
				detallemedioscondefecto.setUsuario(usuario);
				new OeeDetalleMediosConDefectoDAOJpaImpl()
						.saveOrUpdate(detallemedioscondefecto);
		   }else{
			   if (lote == null) {
				   Sistema.mensaje("Seleccione un lote");
				   return;
			   }	
			   /* nuevo registro */  
			   System.out.println("NUEVO REGISTRO  .......................................");
				OeeDetalleMediosConDefecto detallemedioscondefecto = new OeeDetalleMediosConDefecto();
				detallemedioscondefecto.setCantidadDefectos(DcbCantidad.getValue());
				detallemedioscondefecto.setFechaHoraRegistro(fechai.toTimestamp());
				detallemedioscondefecto.setFechaRegistro(new java.sql.Timestamp(
						new Date().getTime()));
				detallemedioscondefecto.setProcesoAperturaCierre(rackeoProceso
						.getProcesoAperturaCierre());
				detallemedioscondefecto.setProduccionDetalleLote(lote);
				detallemedioscondefecto.setUsuario(usuario);
				OeeDefecto  oeeDefecto = new OeeDefectoDAOJpaImpl().findByIdproceso(12).get(0);
				if (oeeDefecto != null) {
					detallemedioscondefecto.setOeeDefecto(oeeDefecto);
				}
				
				new OeeDetalleMediosConDefectoDAOJpaImpl()
						.saveOrUpdate(detallemedioscondefecto);
				
				limpiarDatos();
				onSelect$lbxTurno();
				encerarListbox();
		   }
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			
		}
	}

	public void encerarListbox(){
		if (lbxLote.getSelectedIndex()>0) {
			lbxLote.setSelectedIndex(0);
		}
		lote = null;
	}
	
	public void onClick$btnEliminar() throws InterruptedException {
		if (validarCampos()) {
			int res = new OeeDetalleMediosConDefectoDAOJpaImpl().delete(detallemedioscondefecto);
			if (res == 1) {
				Sistema.mensaje("Registro en Uso ");
				return;
			}
			
			if (res == 0) {
				Sistema.mensaje("Datos Eliminados ");
				onSelect$lbxTurno();
				limpiarDatos();
			}
			
		}
	}

	public void onBlur$DcbCantidad() throws InterruptedException {
		DcbCantidad.clearErrorMessage();
	}

	public void onClick$btnTomarTiempoi() throws InterruptedException {
		if (DcbCantidad == null ){
			Sistema.mensaje("Debe ingresar una cantidad");
			return;
		}
		
		if ( DcbCantidad.getValue() == null){
			Sistema.mensaje("Debe ingresar una cantidad.");
			return;
		}
		
		if ( DcbCantidad.getValue() == 0){
			Sistema.mensaje("Debe ingresar una cantidad.");
			return;
		}
		
		if (produccion == null) {
			Sistema.mensaje("Debe buscar una fecha de produccon");
			return;
		}
		
		fechai = Util.getAnioProduccionMesDiaActual( produccion.getFechaproduccion()  , new Date(), lbxMi, lbxDi, lbxHi, lbxMin);
	    //Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
	}

	public void onClick$btnActualizarLotes() throws InterruptedException {
		if (produccion == null) {
			Sistema.mensaje("Debe buscar una fecha de produccon");
			return;
		}
		if (turnopro == null) {
			Sistema.mensaje("Debe escoger un Turno Produccion");
			return;
		}
		
		
		cargarLote();
	}
}