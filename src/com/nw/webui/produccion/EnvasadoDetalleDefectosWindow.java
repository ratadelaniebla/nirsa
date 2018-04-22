package com.nw.webui.produccion;

import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EnvasadoProceso;
import com.nw.model.Especie;
import com.nw.model.EspecieTalla;
import com.nw.model.Luthy;
import com.nw.model.LuthyMaquinaCerradoraEstandar;
import com.nw.model.OeeDefecto;
import com.nw.model.OeeDetalleMediosConDefecto;
import com.nw.model.OeeDetalleMediosConDefectoEnvasado;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.Talla;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LuthyDAOJpaImpl;
import com.nw.model.dao.impl.LuthyMaquinaCerradoraEstandarDAOJpaImpl;
import com.nw.model.dao.impl.OeeDefectoDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleMediosConDefectoDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleLoteDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;
import com.nwl.mapeo.Util.DateStruct;

// nw-9.3 
@SuppressWarnings("serial")
public class EnvasadoDetalleDefectosWindow extends GenericForwardComposer {
	Usuario usuario = new Usuario();

	private Textbox txtFechaLaborTurno;
	private Textbox txtProduccionTurno;
	private Listbox lbxLuthy;
	private Listbox lbxMaquina;
	private Listbox lbxLote;
	private Textbox txtEspecieTalla;
	private Listbox lbxDefectos;
	@SuppressWarnings("unused")
	private Toolbarbutton btnActualizarLotes;

	private Intbox intLatas;
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

	private ProduccionDetalleLote lote;

	private EnvasadoProceso envasadoProceso;

	private Luthy luthy;

	private OeeDefecto defecto;

	private LuthyMaquinaCerradoraEstandar maquinaCerradoraEstandar;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		intLatas.setValue(0);
		cargarFechaTurno();
		cargarLote();
		cargarListas();
		limpiarDatos();
		 
	}

	public void onSelect$lbxMi() throws InterruptedException {
	
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

	public void onSelect$lbxDefectos() throws InterruptedException {
		if (lbxDefectos.getSelectedIndex() > 0) {
			defecto = (OeeDefecto) lbxDefectos.getSelectedItem().getValue();
		} else {
			defecto = null;
			Sistema.mensaje("Seleccione un defecto");
		}
	} 

	public void onSelect$lbxLuthy() throws InterruptedException {
		if (lbxLuthy.getSelectedIndex() > 0) {
			luthy = (Luthy) lbxLuthy.getSelectedItem().getValue();
			Util.cargarLista(LuthyMaquinaCerradoraEstandar.class,
					new LuthyMaquinaCerradoraEstandarDAOJpaImpl()
							.getMceByLuthy(luthy.getIdluthy()), lbxMaquina,
					"Error al cargar data de Maquina cerradora", false,
					"LuthyMaquina");
		} else {
			luthy = null;
			Sistema.mensaje("Seleccione un Luthy");
		}
	}

	public void onSelect$lbxMaquina() throws InterruptedException {
		if (lbxMaquina.getSelectedIndex() > 0) {
			maquinaCerradoraEstandar = (LuthyMaquinaCerradoraEstandar) lbxMaquina
					.getSelectedItem().getValue();
		} else {
			maquinaCerradoraEstandar = null;
			Sistema.mensaje("Seleccione una Maquina");
		}
	}

	public void onSelect$lbxLote() throws InterruptedException {
		if (lbxLote.getSelectedIndex() > 0) {
			lote = (ProduccionDetalleLote) lbxLote.getSelectedItem().getValue();
			EspecieTalla especieTalla = lote.getEspecieTalla();
					//new EspecieTallaDAOJpaImpl()
					//.getById(lote.getIdespecietalla());
			Especie especie = especieTalla.getEspecie();
					//new EspecieDAOJpaImpl().getById(especieTalla
					//.getIdespecie());
			Talla talla =  especieTalla.getTalla();
					//new TallaDAOJpaImpl().getById(especieTalla
					//.getIdtalla());
			txtEspecieTalla.setValue(String.format("%s %s",
					especie.getNombre(), talla.getNombre()));
			fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		} else {
			lote = null;
			Sistema.mensaje("Seleccione un Lote");
		}
	}

	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
			
			if (envasadoProceso == null) {
				Sistema.mensaje("No existe un proceso de Envasado Activo");
				return;
			}
			
			if (lote == null) {
				Sistema.mensaje("debe escoger un Lote");
				return;
			}
			
			if (maquinaCerradoraEstandar == null) {
				Sistema.mensaje("debe escoger una Maquina cerradora");
				return;
			}
			
			if (luthy == null) {
				Sistema.mensaje("debe escoger un Luthy");
				return;
			}
			
			if (defecto == null) {
				Sistema.mensaje("debe escoger un Defecto");
				return;
			}
			
			if (Util.validarListboxFecha(lbxMi,lbxDi,lbxHi,lbxMin)) {
				 Sistema.mensaje("Seleccione bien la fecha..");
				 return;
			}
			
			OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto = new OeeDetalleMediosConDefecto();
			oeeDetalleMediosConDefecto.setCantidadDefectos(intLatas.getValue());
			oeeDetalleMediosConDefecto.setEmpleado(null);
			oeeDetalleMediosConDefecto.setFechaHoraRegistro(fechai.toTimestamp());
			oeeDetalleMediosConDefecto.setFechaRegistro(new java.sql.Timestamp(new Date().getTime()));
			oeeDetalleMediosConDefecto.setOeeDefecto(defecto);
			oeeDetalleMediosConDefecto.setProcesoAperturaCierre(envasadoProceso.getProcesoAperturaCierre());
			oeeDetalleMediosConDefecto.setProduccionDetalleLote(lote);
			oeeDetalleMediosConDefecto.setUsuario(usuario);
			oeeDetalleMediosConDefecto = new OeeDetalleMediosConDefectoDAOJpaImpl()
					.saveOrUpdate(oeeDetalleMediosConDefecto);

			OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado = new OeeDetalleMediosConDefectoEnvasado();
			oeeDetalleMediosConDefectoEnvasado.setLuthy(luthy);
			oeeDetalleMediosConDefectoEnvasado.setMaquinaCerradora(maquinaCerradoraEstandar.getMaquinaCerradora());
			oeeDetalleMediosConDefectoEnvasado.setOeeDetalleMediosConDefecto(oeeDetalleMediosConDefecto);
			new OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl()
					.saveOrUpdate(oeeDetalleMediosConDefectoEnvasado);
			encerarObjetos();
			limpiarDatos();
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		}
	}

	public void encerarObjetos(){
		maquinaCerradoraEstandar = null;
		luthy 					 = null;
		defecto 				 = null;
		lote 					 = null;
		/* deseleccionar los listbox  */
		if (lbxLuthy.getSelectedIndex()>0) {
			lbxLuthy.setSelectedIndex(0);
		}
		 
		if (lbxDefectos.getSelectedIndex()>0) {
			lbxDefectos.setSelectedIndex(0);
		}
		if (lbxLote.getSelectedIndex()>0) {
			lbxLote.setSelectedIndex(0);
		}
		
		lbxMaquina.getItems().clear();
		
	}
	
	
	public void onBlur$IntLatas() throws InterruptedException {
		intLatas.clearErrorMessage();
	}

	public void onClick$btnTomarTiempoi() throws InterruptedException {
		/*if (intLatas != null && intLatas.getValue() != null
				&& produccion != null) { */
		if (intLatas == null ) {
			Sistema.mensaje("El campo #Latas no puede estar vacio");
			return  ;
		}
		
		if (intLatas.getValue() == null ) {
			Sistema.mensaje("El campo #Latas no puede estar vacio..");
			return  ;
		}
		
		if (intLatas.getValue() <= 0) { // intLatas != null && 
			Sistema.mensaje("El campo #Latas debe ser mayor a cero");
			return  ;
		}
		
		if (produccion != null){
			fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(),new Date(), lbxMi,
					lbxDi, lbxHi, lbxMin);
		}
		 
	}

	public void onClick$btnActualizarLotes() throws InterruptedException {
		
		if (envasadoProceso == null) {
			Sistema.mensaje("No existe un proceso de envasado activo");
			return;
		}
		
		cargarLote();
		
		//lbxDefectos.setDisabled(true);
		//intLatas.setDisabled(true);
		//fechai = Util.limpiarMesDiaHoraMin(produccion.getFechaproduccion(), lbxMi,
			//		lbxDi, lbxHi, lbxMin);
		if (produccion != null){
			fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(),new Date(), lbxMi,
					lbxDi, lbxHi, lbxMin);
		}
	}

	private void cargarFechaTurno() {
		/* obtiene el proceso activo(aperturado ) por el estado(1) y el id de proceso envasado(13)*/
	    envasadoProceso = new EnvasadoProcesoDAOJpaImpl().getEnvasadoProcesoAperturado();
				//.getEnvasadoProcesoByEstado(1);
		
		if (envasadoProceso != null) {
			String valueFechaLaborTurno = String.format("%s - %s", Util
					.formatearFechaDDMMYYYY(envasadoProceso
							.getProcesoAperturaCierre().getFechaapertura()),
					envasadoProceso.getTurno().getIdturno());
			
			produccion = envasadoProceso.getProduccion(); //getLimpiezaProceso()
			/* produccion = new ProduccionDAOJpaImpl()
					.getProduccionById(envasadoProceso.getLimpiezaProceso()
							.getIdproduccion()); */
			turno = envasadoProceso.getTurno(); //getLimpiezaProceso()
			/*turno = new TurnoDAOJpaImpl().findById(envasadoProceso
					.getLimpiezaProceso().getIdturno()); */
			
			String valueProduccionTurno = String.format("%s - %s", Util
					.formatearFechaDDMMYYYY(produccion.getFechaproduccion()),
					turno.getIdturno());
			
			txtFechaLaborTurno.setValue(valueFechaLaborTurno);
			txtProduccionTurno.setValue(valueProduccionTurno);
			
			if (produccion != null){
				fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(),new Date(), lbxMi,
						lbxDi, lbxHi, lbxMin);
			}
		}else{
			txtFechaLaborTurno.setValue("");
			txtProduccionTurno.setValue("");
			Sistema.mensaje("No existe un proceso activo de Envasado");
		}
	}

	private void cargarLote() {
		if (turno != null && produccion != null)
			Util.cargarLista(
					ProduccionDetalleLote.class,
					new ProduccionDetalleLoteDAOJpaImpl()
					   //.getLotes( turno.getIdturno(), produccion.getIdproduccion()),
					.getProduccionDetallelote(  produccion.getIdproduccion() , turno.getIdturno()),
					lbxLote, "Error al cargar data de Lote", true,
					"ProduccionDetalleLote");
	}

	void limpiarDatos() {
		//fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		txtEspecieTalla.setValue("");
		intLatas.setValue(0);
	}

	private void cargarListas() {
		Util.cargarLista(Luthy.class, new LuthyDAOJpaImpl().getAll(), lbxLuthy,
				 "", true, "Luthy");
		
		Util.cargarLista(OeeDefecto.class,
				new OeeDefectoDAOJpaImpl().findByIdproceso(13), lbxDefectos,
				"Error al cargar data de Defectos", true, "OeeDefectos");//findById

	}

	private boolean validarCampos() {
		if (intLatas == null ) {
			Sistema.mensaje("El campo #Latas no puede estar vacio");
			return false;
		}
		
		if (intLatas.getValue() == null ) {
			Sistema.mensaje("El campo #Latas no puede estar vacio..");
			return false;
		}
		
		if (intLatas.getValue() <= 0) { // intLatas != null && 
			Sistema.mensaje("El campo #Latas debe ser mayor a cero");
			return false;
		}
		return true;
	}
}
