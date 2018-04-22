package com.nw.webui.produccion;

 
 
import java.util.ArrayList;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.Especie;
import com.nw.model.EspecieTalla;
import com.nw.model.OeeDefecto;
import com.nw.model.OeeDetalleMediosConDefecto;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.RackeoProceso;
import com.nw.model.Talla;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.OeeDefectoDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleMediosConDefectoDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleLoteDAOJpaImpl;
import com.nw.model.dao.impl.RackeoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;
import com.nwl.mapeo.Util.DateStruct;

@SuppressWarnings("serial")
public class EvisceradoDetalleDefectosWindow extends GenericForwardComposer {
	Usuario usuario = new Usuario();

	private Listbox lbxProduccion;
	private Listbox lbxTurno;
	private Textbox txtFechaLabor;
	private Textbox txtTurnoLabor;
	private Listbox lbxLote;
	@SuppressWarnings("unused")
	private Toolbarbutton btnActualizarLotes;
	private Textbox txtEspecieTalla;
	private Intbox DcbCantidad;
	@SuppressWarnings("unused")
	private Toolbarbutton btnTomarTiempoi;
	private Listbox lbxMi;
	private Listbox lbxDi;
	private Listbox lbxHi;
	private Listbox lbxMin;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;

	private DateStruct fechai;

	private Produccion produccion;

	private Turno turno;

	private RackeoProceso rackeoProceso;

	private ProduccionDetalleLote lote;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		cargarListas();
		limpiarDatos();
		obtenerRackeoProcesoActivo();
	}
	
	
	public boolean obtenerRackeoProcesoActivo(){
		rackeoProceso = new RackeoProcesoDAOJpaImpl().getRackeoProcesoActivo();
		 //.getRackeoProcesoByIdProduccion(produccion .getIdproduccion());
		
		if (rackeoProceso == null) {
			txtFechaLabor.setValue("");
			txtTurnoLabor.setValue("");
			Sistema.mensaje("No existe un Proceso de Rackeo Activo");
			return false;
		} 
		
		txtFechaLabor.setValue(Util.formatearFecha(rackeoProceso
				.getProcesoAperturaCierre().getFechaapertura()));
		txtTurnoLabor.setValue(String.valueOf(rackeoProceso.getTurno()
				.getIdturno()));
		//lbxTurno.setSelectedIndex(lbxTurno.getItems().indexOf(
			//	rackeoProceso.getTurno()));
		
		return true;
	}

	void limpiarDatos() {
		fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		txtEspecieTalla.setValue("");
		txtFechaLabor.setValue("");
		txtTurnoLabor.setValue("");
	}

	private void cargarListas() {
		//Timestamp fecha = Util.toTimestamp(new java.util.Date());
		 Util.cargarLista(Produccion.class, new ProduccionDAOJpaImpl().getListaFechaProduccionActivaEviscerdo(),
				//.getProduccionActivaEviscerado(fecha, turno.getIdturno()),
			 	lbxProduccion, null, false, "Produccion");
		Util.cargarLista(Turno.class, new TurnoDAOJpaImpl().getTurnos(),
				lbxTurno, null, false, "Turno");
	}

	private boolean validarCampos() {
		
	    if (Util.validarListboxFecha(lbxMi,lbxDi,lbxHi,lbxMin)) {
			  Sistema.mensaje("Seleccione bien la fecha ");
			  return false;
		}
	    
	    
		if (DcbCantidad == null ) {
			Sistema.mensaje("El campo #Latas no puede estar vacio");
			return false;
		}
		
		if (DcbCantidad.getValue() == null ) {
			Sistema.mensaje("El campo #Latas no puede estar vacio..");
			return false;
		}
		
		if (DcbCantidad.getValue() <= 0) { // intLatas != null && 
			Sistema.mensaje("El campo #Latas debe ser mayor a cero");
			return false;
		}
	    
	    
		/* if (!fechai.hasValue()) {
			Sistema.mensaje("Ingrese la fecha completa");
			return false;
		} */
		
		return true;
	}

	public void onSelect$lbxMi() throws InterruptedException {
		/* Util.alSeleccionarMes(lbxMi, fechai, "Seleccione un mes"); */
		
		if (lbxMi.getSelectedIndex() > 0) {
			fechai.month = (String) lbxMi.getSelectedItem().getValue();
			ArrayList<String> days = new ArrayList<String>();
			int daysMonth = Util.diasDelMes(Integer.parseInt(fechai.month),
					fechai.year);
			days.add("");
			for (int i = 1; i <= daysMonth; i++) {
				days.add(Integer.toString(i));
			}
			ListModelList lml = new ListModelList(days);
			lbxDi.setModel(lml);
		} else {
			Sistema.mensaje("Seleccione un mes");
		}
		
	}

	public void onSelect$lbxDi() throws InterruptedException {
		if (lbxDi.getSelectedIndex() > 0) {
			fechai.day = (String) lbxDi.getSelectedItem().getValue();
		} else {
			//fechai.day = null;
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHi() throws InterruptedException {
		if (lbxHi.getSelectedIndex() > 0) {
			fechai.hour = (String) lbxHi.getSelectedItem().getValue();
		} else {
			//fechai.hour = null;
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMin() throws InterruptedException {
		if (lbxMin.getSelectedIndex() > 0) {
			fechai.minute = (String) lbxMin.getSelectedItem().getValue();
		} else {
			//fechai.minute = null;
			Sistema.mensaje("Seleccione un minuto");
		}
	}

	public void onSelect$lbxProduccion() throws InterruptedException {
		if (lbxProduccion.getSelectedIndex() > 0) {
			produccion = (Produccion) lbxProduccion.getSelectedItem()
					.getValue();
			//cargarLote(); 
			fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(),new Date(), lbxMi,lbxDi,lbxHi,lbxMin);
			//fechai = Util.limpiarMesDiaHoraMin(new Date(), lbxMi,lbxDi,lbxHi,lbxMin);
			System.out.println("fechai.day ->"  + fechai.day);
			System.out.println("fechai.hour ->"  + fechai.hour);
			System.out.println("fechai.minute ->"  + fechai.minute);
			
		} else {
			Sistema.mensaje("Seleccione una Produccion");
			produccion = null;
		}
	}

	public void onSelect$lbxTurno() throws InterruptedException {
		if (lbxTurno.getSelectedIndex() > 0) {
			if (produccion == null) {
				Sistema.mensaje("Debe escoger una produccion");
				turno = null;
				lbxTurno.setSelectedIndex(0);
				return;
			}
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
			cargarLote();
		} else {
			Sistema.mensaje("Seleccione un Turno");
			turno = null;
		}
	}

	private void cargarLote() {
		if (produccion == null) {
			Sistema.mensaje("Seleccione una Produccion");
			return;
		}
		
		if (turno == null) {
			Sistema.mensaje("Seleccione un Turno");
			return;
		}
		 
		Util.cargarLista(
				ProduccionDetalleLote.class,
				new ProduccionDetalleLoteDAOJpaImpl().getProduccionDetallelote (
						 produccion.getIdproduccion() , turno.getIdturno()),
				lbxLote, null, false, "ProduccionDetalleLote"); // getLotes
			
	}

	public void onSelect$lbxLote() throws InterruptedException {
		if (lbxLote.getSelectedIndex() > 0) {
			lote = (ProduccionDetalleLote) lbxLote.getSelectedItem().getValue();
			EspecieTalla especieTalla =  lote.getEspecieTalla();   //new EspecieTallaDAOJpaImpl() .getById(lote.getIdespecietalla());
			
			Especie especie = especieTalla.getEspecie(); //    new EspecieDAOJpaImpl().getById(especieTalla .getIdespecie());
			Talla talla     = especieTalla.getTalla();   //    new TallaDAOJpaImpl().getById(especieTalla .getIdtalla());
			
			txtEspecieTalla.setValue(String.format("%s %s",
					especie.getNombre(), talla.getNombre()));
			//Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		} else {
			Sistema.mensaje("Seleccione un Lote");
			lote = null;
		}
	}

	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
			
			if (obtenerRackeoProcesoActivo()) {
				
				if (produccion == null) {
					Sistema.mensaje("Seleccione una Produccion");
					return;
				}
				
				if (turno == null) {
					Sistema.mensaje("Seleccione un Turno");
					return;
				}
				
				if (lote == null) {
					Sistema.mensaje("Seleccione un Lote");
					return;
				}
				
				OeeDetalleMediosConDefecto detallemedioscondefecto = new OeeDetalleMediosConDefecto();
				detallemedioscondefecto.setCantidadDefectos(DcbCantidad.getValue()
						.intValue());
				//detallemedioscondefecto.setEmpleado(null);
				detallemedioscondefecto.setFechaHoraRegistro(fechai.toTimestamp());
				detallemedioscondefecto.setFechaRegistro(new java.sql.Timestamp(
						new Date().getTime()));
				OeeDefecto  oeeDefecto = new OeeDefectoDAOJpaImpl().findByIdproceso(12).get(0);
				if (oeeDefecto != null) {
					detallemedioscondefecto.setOeeDefecto(oeeDefecto);
				}
				 
				detallemedioscondefecto.setProcesoAperturaCierre(rackeoProceso
						.getProcesoAperturaCierre());
				detallemedioscondefecto.setProduccionDetalleLote(lote);
				detallemedioscondefecto.setUsuario(usuario);
				new OeeDetalleMediosConDefectoDAOJpaImpl()
						.saveOrUpdate(detallemedioscondefecto);
				encerarDatos();
				Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			} 
			
			
		}
	}
	
	public void encerarDatos(){
		if (lbxLote.getSelectedIndex() > 0) {
			lbxLote.setSelectedIndex(0);
			lote = null;
		}
		txtEspecieTalla.setValue("");
		DcbCantidad.setValue(0);
		lote = null;
	}

	public void onBlur$DcbCantidad() throws InterruptedException {
		//DcbCantidad.clearErrorMessage();
	}

	public void onClick$btnTomarTiempoi() throws InterruptedException {
		 if (produccion==null) {
			Sistema.mensaje("Debe escoger una produccion");
			return;
		 }
		 if (DcbCantidad.getValue() == null || DcbCantidad.getValue() <= 0  ){
			 Sistema.mensaje("Debe ingresar una cantidad mayor a Cero");
				return;
		 }
		 
		 fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(),new Date(), lbxMi,lbxDi,lbxHi,lbxMin);
		 //if (DcbCantidad != null && DcbCantidad.getValue() != null)
			//Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
	}

	public void onClick$btnActualizarLotes() throws InterruptedException {
		cargarLote();
	}
}
