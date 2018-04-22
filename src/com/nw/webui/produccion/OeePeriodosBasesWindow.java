package com.nw.webui.produccion;

import java.math.BigDecimal;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.OeePeriodoBaseObjetivo;
import com.nw.model.Proceso;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.OeePeriodoBaseObjetivoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;

@SuppressWarnings("serial")
public class OeePeriodosBasesWindow extends GenericForwardComposer {

	private Listbox lbxProceso;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;
	private Decimalbox DcbBasegeneral;
	private Decimalbox DcbTiempo;
	private Decimalbox DcbVelocidad;
	private Decimalbox DcbCalidad;
	private Decimalbox DcbCantidad;
	private Decimalbox DcbObjetivoGeneral;
	private Decimalbox DcbMinCumplimiento;
	private Decimalbox DcbMinProblemas;
	private Decimalbox DcbMinFueradeTiempo;
	private Decimalbox DcbMinCumplimientod;
	private Decimalbox DcbMinProblemasd;
	private Decimalbox DcbMinFueradeTiempod;

	Proceso proceso;

	Usuario usuario = new Usuario();
	private boolean flag;
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		cargarProcesos();
		limpiarDatos();
	}

	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
			// oeePeriodoBaseObjetivo = new OeePeriodoBaseObjetivo();
			oeePeriodoBaseObjetivo.setUsuario(usuario);
			oeePeriodoBaseObjetivo.setFechaRegistro(new java.sql.Timestamp(
					new Date().getTime()));
			oeePeriodoBaseObjetivo.setObjetivoGeneral(DcbObjetivoGeneral
					.getValue().doubleValue());
			oeePeriodoBaseObjetivo.setPeriodoBaseCalidad(DcbCalidad.getValue()
					.doubleValue());
			oeePeriodoBaseObjetivo.setPeriodoBaseCantidad(DcbCantidad
					.getValue().doubleValue());
			oeePeriodoBaseObjetivo.setPeriodoBaseGeneral(DcbBasegeneral
					.getValue().doubleValue());
			oeePeriodoBaseObjetivo.setPeriodoBaseTiempo(DcbTiempo.getValue()
					.doubleValue());
			oeePeriodoBaseObjetivo.setPeriodoBaseVelocidad(DcbVelocidad
					.getValue().doubleValue());
			oeePeriodoBaseObjetivo.setRango1Entregacamara(DcbMinCumplimiento
					.getValue().doubleValue());
			oeePeriodoBaseObjetivo.setRango2Entregacamara(DcbMinProblemas
					.getValue().doubleValue());
			oeePeriodoBaseObjetivo.setRango3Entregacamara(DcbMinFueradeTiempo
					.getValue().doubleValue());
			oeePeriodoBaseObjetivo
					.setRango1Ingresodescongelado(DcbMinCumplimientod
							.getValue().doubleValue());
			oeePeriodoBaseObjetivo
					.setRango2Ingresodescongelado(DcbMinProblemasd.getValue()
							.doubleValue());
			oeePeriodoBaseObjetivo
					.setRango3Ingresodescongelado(DcbMinFueradeTiempod
							.getValue().doubleValue());

			lbxProceso.setSelectedIndex(0);
			new OeePeriodoBaseObjetivoDAOJpaImpl()
					.saveOrUpdate(oeePeriodoBaseObjetivo);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			limpiarDatos();
		}
	}

	void limpiarDatos() {
		DcbBasegeneral.setValue(null);
		DcbTiempo.setValue(new BigDecimal(0));
		DcbVelocidad.setValue(new BigDecimal(0));
		DcbCalidad.setValue(new BigDecimal(0));
		DcbCantidad.setValue(new BigDecimal(0));
		DcbObjetivoGeneral.setValue(new BigDecimal(0));
		DcbMinCumplimiento.setValue(new BigDecimal(0));
		DcbMinProblemas.setValue(new BigDecimal(0));
		DcbMinFueradeTiempo.setValue(new BigDecimal(0));
		DcbMinCumplimientod.setValue(new BigDecimal(0));
		DcbMinProblemasd.setValue(new BigDecimal(0));
		DcbMinFueradeTiempod.setValue(new BigDecimal(0));
	}

	void cargarData(OeePeriodoBaseObjetivo oee, boolean flag) {
		DcbBasegeneral
				.setValue(BigDecimal.valueOf(oee.getPeriodoBaseGeneral()));
		DcbTiempo.setValue(BigDecimal.valueOf(oee.getPeriodoBaseTiempo()));
		DcbVelocidad
				.setValue(BigDecimal.valueOf(oee.getPeriodoBaseVelocidad()));
		DcbCalidad.setValue(BigDecimal.valueOf(oee.getPeriodoBaseCalidad()));
		DcbCantidad.setValue(BigDecimal.valueOf(oee.getPeriodoBaseCantidad()));
		DcbObjetivoGeneral
				.setValue(BigDecimal.valueOf(oee.getObjetivoGeneral()));
		if (flag) {
			DcbMinCumplimiento.setValue(BigDecimal.valueOf(oee
					.getRango1Entregacamara()));
			DcbMinProblemas.setValue(BigDecimal.valueOf(oee
					.getRango2Entregacamara()));
			DcbMinFueradeTiempo.setValue(BigDecimal.valueOf(oee
					.getRango3Entregacamara()));
			DcbMinCumplimientod.setValue(BigDecimal.valueOf(oee
					.getRango1Ingresodescongelado()));
			DcbMinProblemasd.setValue(BigDecimal.valueOf(oee
					.getRango2Ingresodescongelado()));
			DcbMinFueradeTiempod.setValue(BigDecimal.valueOf(oee
					.getRango3Ingresodescongelado()));
			DcbMinCumplimiento.setReadonly(!flag);
			DcbMinProblemas.setReadonly(!flag);
			DcbMinFueradeTiempo.setReadonly(!flag);
			DcbMinCumplimientod.setReadonly(!flag);
			DcbMinProblemasd.setReadonly(!flag);
			DcbMinFueradeTiempod.setReadonly(!flag);
		} else {
			DcbMinCumplimiento.setReadonly(!flag);
			DcbMinProblemas.setReadonly(!flag);
			DcbMinFueradeTiempo.setReadonly(!flag);
			DcbMinCumplimientod.setReadonly(!flag);
			DcbMinProblemasd.setReadonly(!flag);
			DcbMinFueradeTiempod.setReadonly(!flag);
		}
	}

	public void cargarProcesos() {
		Util.cargarLista(Proceso.class,
				new ProcesoDAOJpaImpl().getProcesosDLLRE(), lbxProceso, null,
				true, "Proceso");
	}

	public void onSelect$lbxProceso() throws InterruptedException {
		limpiarDatos();
		if (lbxProceso.getSelectedIndex() > 0) {
			proceso = (Proceso) lbxProceso.getSelectedItem().getValue();
			oeePeriodoBaseObjetivo = new OeePeriodoBaseObjetivoDAOJpaImpl()
					.getOeePeriodoBaseObjetivoByIdProceso(proceso
							.getIdproceso());
			if (proceso.getDescripcionproceso().equals("DESCONGELADO"))
				flag = true;
			else
				flag = false;
			cargarData(oeePeriodoBaseObjetivo, flag);
		} else {
			Sistema.mensaje("Seleccione un proceso");
		}
	}

	public void onBlur$DcbBasegeneral() throws InterruptedException {
		DcbBasegeneral.clearErrorMessage();
	}

	public void onBlur$DcbTiempo() throws InterruptedException {
		DcbTiempo.clearErrorMessage();
	}

	public void onBlur$DcbVelocidad() throws InterruptedException {
		DcbVelocidad.clearErrorMessage();
	}

	public void onBlur$DcbCalidad() throws InterruptedException {
		DcbCalidad.clearErrorMessage();
	}

	public void onBlur$DcbCantidad() throws InterruptedException {
		DcbCantidad.clearErrorMessage();
	}

	public void onBlur$DcbObjetivoGeneral() throws InterruptedException {
		DcbObjetivoGeneral.clearErrorMessage();
	}

	public void onBlur$DcbMinCumplimiento() throws InterruptedException {
		DcbMinCumplimiento.clearErrorMessage();
	}

	public void onBlur$DcbMinProblemas() throws InterruptedException {
		DcbMinProblemas.clearErrorMessage();
	}

	public void onBlur$DcbMinFueradeTiempo() throws InterruptedException {
		DcbMinFueradeTiempo.clearErrorMessage();
	}

	public void onBlur$DcbMinCumplimientod() throws InterruptedException {
		DcbMinCumplimientod.clearErrorMessage();
	}

	public void onBlur$DcbMinProblemasd() throws InterruptedException {
		DcbMinProblemasd.clearErrorMessage();
	}

	public void onBlur$DcbMinFueradeTiempod() throws InterruptedException {
		DcbMinFueradeTiempod.clearErrorMessage();
	}

	private boolean validarCampos() {
		if (lbxProceso.getSelectedIndex() == 0) {
			Sistema.mensaje("Seleccione un proceso");
			return false;
		}
		if (!Util.validarDecimalBox(DcbBasegeneral,
				"El campo Base General debe ser mayor a cero"))
			return false;

		if (!Util.validarDecimalBox(DcbTiempo,
				"El campo Tiempo debe ser mayor a cero"))
			return false;

		if (!Util.validarDecimalBox(DcbVelocidad,
				"El campo Velocidad debe ser mayor a cero"))
			return false;

		if (!Util.validarDecimalBox(DcbCalidad,
				"El campo Calidad debe ser mayor a cero"))
			return false;

		if (!Util.validarDecimalBox(DcbCantidad,
				"El campo Cantidad debe ser mayor a cero"))
			return false;

		if (!Util.validarDecimalBox(DcbObjetivoGeneral,
				"El campo Objetivo General debe ser mayor a cero"))
			return false;

		if (flag) {
			if (!Util.validarDecimalBox(DcbMinCumplimiento,
					"El campo Min. Cumplimiento debe ser mayor a cero"))
				return false;

			if (!Util.validarDecimalBox(DcbMinProblemas,
					"El campo Min. Problemas debe ser mayor a cero"))
				return false;

			if (!Util.validarDecimalBox(DcbMinFueradeTiempo,
					"El campo Min. Fuera de Tiempo debe ser mayor a cero"))
				return false;

			if (!Util.validarDecimalBox(DcbMinCumplimientod,
					"El campo Min. Cumplimiento - Ducha debe ser mayor a cero"))
				return false;

			if (!Util.validarDecimalBox(DcbMinProblemasd,
					"El campo Min. Problemas - Ducha debe ser mayor a cero"))
				return false;

			if (!Util
					.validarDecimalBox(DcbMinFueradeTiempod,
							"El campo Min. Fuera de Tiempo - Ducha debe ser mayor a cero"))
				return false;

		}
		return true;
	}
}
