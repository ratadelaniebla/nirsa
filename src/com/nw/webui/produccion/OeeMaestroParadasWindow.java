package com.nw.webui.produccion;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.OeeParada;
import com.nw.model.Proceso;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.OeeParadaDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;

@SuppressWarnings("serial")
public class OeeMaestroParadasWindow extends GenericForwardComposer {

	private Listbox lbxListaProcesos;
	private Listbox lbxListaParadas;
	private Textbox txtDescripcion;
	private Listbox lbxTiempoMuerto;
	private Listbox lbxParadaProgramada;
	private Listbox lbxEquipoPersona;
	private Checkbox ChkEliminar;
	@SuppressWarnings("unused")
	private Toolbarbutton btnEliminar;

	Proceso proceso;
	List<OeeParada> oeeParadas;
	Usuario usuario = new Usuario();
	private OeeParada parada = new OeeParada();
	private boolean paradaProgramada;
	private boolean tipoEquipoPersona;
	private boolean tiempoMuerto;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		cargarProcesos();
		limpiarDatos();
	}

	public void cargarProcesos() {
		Util.cargarLista(Proceso.class,
				new ProcesoDAOJpaImpl().getProcesosMP(), lbxListaProcesos,
				"Error al Cargar procesos", false, "Proceso");
	}

	public void onSelect$lbxListaProcesos() throws InterruptedException {
		if (lbxListaProcesos.getSelectedIndex() > 0) {
			proceso = (Proceso) lbxListaProcesos.getSelectedItem().getValue();
			cargarParadas(proceso);
		} else {
			Sistema.mensaje("Seleccione un proceso");
			limpiarDatos();
		}
	}

	public void cargarParadas(Proceso proceso) {
		Util.cargarLista(OeeParada.class, new OeeParadaDAOJpaImpl()
				.getOeeParadaByIdProceso(proceso.getIdproceso()),
				lbxListaParadas, "", true, "Parada");
	}

	public void onSelect$lbxListaParadas() throws InterruptedException {
		if (lbxListaParadas.getSelectedIndex() > 0) {
			parada = (OeeParada) lbxListaParadas.getSelectedItem().getValue();
			
			if (parada.getTiempoMuerto()!= null) {
				if (parada.getTiempoMuerto()) {
					lbxTiempoMuerto.setSelectedIndex(1);
					lbxEquipoPersona.setSelectedIndex(2);
					lbxParadaProgramada.setSelectedIndex(2);
					lbxParadaProgramada.setDisabled(true);
					lbxEquipoPersona.setDisabled(true);
				} else {
					lbxTiempoMuerto.setSelectedIndex(2);
					lbxParadaProgramada.setDisabled(false);
					lbxEquipoPersona.setDisabled(false);
					if (parada.getProgramada()) {
						lbxTiempoMuerto.setDisabled(true);
						lbxParadaProgramada.setSelectedIndex(1);
					} else {
						lbxTiempoMuerto.setDisabled(false);
						lbxParadaProgramada.setSelectedIndex(2);
					}
					if (parada.getTipoEquipoPersona()) {
						lbxTiempoMuerto.setDisabled(true);
						lbxEquipoPersona.setSelectedIndex(1);
					} else {
						lbxTiempoMuerto.setDisabled(false);
						lbxEquipoPersona.setSelectedIndex(2);
					}
				 }
			}else{
				Sistema.mensaje("No se ha asignado un tiempo muerto...");
			}
			txtDescripcion.setValue(parada.getDescripcionParada());
		} else {
			ChkEliminar.setChecked(false);
			txtDescripcion.setValue("");
			lbxTiempoMuerto.setSelectedIndex(0);
			lbxEquipoPersona.setSelectedIndex(0);
			lbxParadaProgramada.setSelectedIndex(0);
			parada = new OeeParada();
			
		}
	}

	public void onSelect$lbxTiempoMuerto() throws InterruptedException {
		if (lbxTiempoMuerto.getSelectedIndex() > 0) {
			String valor = (String) lbxTiempoMuerto.getSelectedItem()
					.getValue();
			if (valor.equals("1")) {
				lbxParadaProgramada.setDisabled(true);
				lbxEquipoPersona.setDisabled(true);
				setParadaProgramada(false);
				setTipoEquipoPersona(false);
				setTiempoMuerto(true);
			} else {
				setTiempoMuerto(false);
				lbxParadaProgramada.setDisabled(false);
				lbxEquipoPersona.setDisabled(false);
			}
		} else {
			Sistema.mensaje("Seleccione un proceso");
		}
	}

	public void onSelect$lbxParadaProgramada() throws InterruptedException {
		if (lbxParadaProgramada.getSelectedIndex() > 0) {
			String valor = (String) lbxParadaProgramada.getSelectedItem()
					.getValue();
			if (valor.equals("1")) {
				lbxTiempoMuerto.setDisabled(true);
				setParadaProgramada(true);
				setTiempoMuerto(false);
			} else {
				lbxTiempoMuerto.setDisabled(false);
				setParadaProgramada(false);
			}
		} else {
			Sistema.mensaje("Seleccione un proceso");
		}
	}

	public void onSelect$lbxEquipoPersona() throws InterruptedException {
		if (lbxEquipoPersona.getSelectedIndex() > 0) {
			String valor = (String) lbxEquipoPersona.getSelectedItem()
					.getValue();
			if (valor.equals("1")) {
				lbxTiempoMuerto.setDisabled(true);
				setTipoEquipoPersona(true);
				setTiempoMuerto(false);
			} else {
				lbxTiempoMuerto.setDisabled(false);
				setTipoEquipoPersona(false);
			}
		} else {
			Sistema.mensaje("Seleccione un proceso");
		}
	}

	public void onClick$btnEliminar() throws InterruptedException {
		if (validarCampos()) {
			if (new OeeParadaDAOJpaImpl().delete(parada))
				Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			else
				Sistema.mensaje("Registro en uso");
			limpiarDatos();
		}
	}

	/* se corrigio este metodo para q guarde*/
	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
			
			if (txtDescripcion.getValue()==null || txtDescripcion.getValue().equals("")) {
				Sistema.mensaje("Debe ingresar una descripcion");
				return;
			}
			
			parada.setTiempoMuerto(isTiempoMuerto());
			parada.setProgramada(isParadaProgramada());
			parada.setTipoEquipoPersona(isTipoEquipoPersona());
			parada.setEstandarModificado(false);
			parada.setProceso(proceso);
			parada.setDescripcionParada(txtDescripcion.getValue());
			 
			if (parada.getIdOeeParada() == null || parada.getIdOeeParada().equals(0) ) {
				oeeParadas = new OeeParadaDAOJpaImpl().getOeeParadaList();
				int idOeeParada = 1;
				if (oeeParadas.isEmpty()) {
					parada.setIdOeeParada(idOeeParada);
				}else{
					idOeeParada = oeeParadas.get(oeeParadas.size() - 1) .getIdOeeParada() + 1;
					parada.setIdOeeParada(idOeeParada);
				}
				System.out.println("id parada nueva ->"+parada.getIdOeeParada());
				new OeeParadaDAOJpaImpl().saveOrUpdateNativo(parada);
			}else{
				System.out.println("id parada existente  ->"+parada.getIdOeeParada());
				new OeeParadaDAOJpaImpl().saveOrUpdate(parada);
			}
		
			
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			limpiarDatos();
		}
	}

	void limpiarDatos() {
		ChkEliminar.setChecked(false);
		txtDescripcion.setValue("");
		lbxTiempoMuerto.setSelectedIndex(0);
		lbxEquipoPersona.setSelectedIndex(0);
		lbxParadaProgramada.setSelectedIndex(0);
		lbxListaProcesos.setSelectedIndex(0);
		Util.cargarLista(OeeParada.class, null, lbxListaParadas, null, false,
				"Parada");
		parada = new OeeParada();
	}

	private boolean validarCampos() {
		if (!ChkEliminar.isChecked()) {
			Sistema.mensaje("Seleccione revisado");
			ChkEliminar.setFocus(true);
			return false;
		}
		if (lbxListaProcesos.getSelectedIndex() == 0) {
			Sistema.mensaje("Seleccione un proceso");
			lbxListaProcesos.setFocus(true);
			return false;
		}

		if (lbxTiempoMuerto.getSelectedIndex() == 0) {
			Sistema.mensaje("Seleccione un tiempo");
			lbxTiempoMuerto.setFocus(true);
			return false;
		}
		if (lbxTiempoMuerto.getSelectedIndex() == 2) {
			if (lbxParadaProgramada.getSelectedIndex() == 0) {
				Sistema.mensaje("Seleccione una parada programada");
				lbxParadaProgramada.setFocus(true);
				return false;
			}
			if (lbxEquipoPersona.getSelectedIndex() == 0) {
				Sistema.mensaje("Seleccione un equipo");
				lbxEquipoPersona.setFocus(true);
				return false;
			}
		}
		return true;
	}

	public boolean isParadaProgramada() {
		return paradaProgramada;
	}

	public void setParadaProgramada(boolean paradaProgramada) {
		this.paradaProgramada = paradaProgramada;
	}

	public boolean isTipoEquipoPersona() {
		return tipoEquipoPersona;
	}

	public void setTipoEquipoPersona(boolean tipoEquipoPersona) {
		this.tipoEquipoPersona = tipoEquipoPersona;
	}

	public boolean isTiempoMuerto() {
		return tiempoMuerto;
	}

	public void setTiempoMuerto(boolean tiempoMuerto) {
		this.tiempoMuerto = tiempoMuerto;
	}
}
