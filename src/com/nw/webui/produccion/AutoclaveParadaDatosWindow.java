package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.dao.EsterilizadoProcesoParadaCocheDAO;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;
import com.nw.webui.HelperView;

/**
 * 
 * @author Cls Mbaque
 * @version 1.0
 * @since 04/06/2018
 */
public class AutoclaveParadaDatosWindow extends GenericForwardComposer{
	private static final long serialVersionUID = 1L;
	
	private Label 	lbAutoclaveParada,  lbTurno;
	private Listbox lbxAutoclaveParada, lbxTurno;
	
	private Label 						   lbBliderAbierto,	 lbFinProceso;
	private Checkbox chkVerParadasEnCurso, chkBliderAbierto, chkFinProceso;
	private Toolbar tbConsultar, tbTomarHoraSellado1raLata, tbTomarHoraAverturaVapor, tbTomarHoraCerradoVenteo, tbTomarHoraCerradoVenteo2, tbHoraInicioProceso, tbHoraFinProceso, tbHoraFinalEnfriamiento, tbHoraSalida, tbHoraRegistroPreManometro, tbHoraRegistroPreManometro2;
	private Toolbarbutton btnGrabar;
	private Longbox lobNumeroGrafica;
	private Label lbGuiaAbierta, lbGuiaIniciada, lbGuiaFinalizada, lbGuiaFinProceso; 
	private Label lbHoraInicioProceso, lbHoraFinProceso;
	private Datebox dteFechaProduccion, dteHoraSellado1raLata, dteHoraAverturaVapor, dteHoraCerradoVenteo, dteHoraCerradoVenteo2, dteHoraInicioProceso, dteHoraFinProceso, dteHoraFinalEnfriamiento, dteHoraSalida, dteHoraRegistroPreManometro, dteHoraRegistroPreManometro2;
//	private Label lbTotalCoches, lbTiempoProceso;
	private Label   lbPresionVaporPsi,  lbTempCerradoVenteo,  lbTempCerradoVenteo2,  lbFlujoAguaLS,  lbTempMercurio,                    lbTempGrafica,					 lbPresionManometro,  						lbTempInicio,  lbTempSalida;
	private Textbox dbxPresionVaporPsi, dbxTempCerradoVenteo, dbxTempCerradoVenteo2, dbxFlujoAguaLS, dbxTempMercurio, dbxTempMercurio2, dbxTempGrafica, dbxTempGrafica2, dbxPresionManometro, dbxPresionManometro2, dbxTempInicio, dbxTempSalida;
	private Textbox txtTiempoProceso;
	private Intbox itbTotalCoches;
	private Listbox lbxSales;
	
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy H:m:s");
	
	private EsterilizadoProcesoParada epp = null;
	private Produccion produccion = null;
	
	private Window winAutoclaveParadaDatos;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		System.out.println(winAutoclaveParadaDatos.getWidth());
		new HelperView().cargarTurnos(lbxTurno);
		
		onClick$btnActulizarParadas();

		chkVerParadasEnCurso.setChecked(true);
		cargachkVerParadasEnCurso();
		
//		btnActulizarParadas.addEventListener("onClick", new EventListener(){
//			public void onEvent(Event arg0) throws Exception {
//				cargalbxAutoclaveParada(new EsterilizadoProcesoParadaDAOJpaImpl().getEsterilizadoProcesoParada());
//			}
//		});
	}
	
	public void onClick$btnActulizarParadas() {
		List<EsterilizadoProcesoParada> listaEPP;
		if (produccion==null) {
			if (!chkVerParadasEnCurso.isChecked())
				listaEPP = new ArrayList<EsterilizadoProcesoParada>();
			else
				listaEPP = new EsterilizadoProcesoParadaDAOJpaImpl().getEsterilizadoProcesoParada();
		} else
			listaEPP = new EsterilizadoProcesoParadaDAOJpaImpl().getEsterilizadoProcesoParada(produccion.getIdproduccion());
		
		cargalbxAutoclaveParada(listaEPP);
		onSelect$lbxAutoclaveParada();
	}
	
	@SuppressWarnings("unchecked")
	private void cargalbxAutoclaveParada(List<EsterilizadoProcesoParada> listaEsterilizadoProcesoParada) {
		EsterilizadoProcesoParada eppSeleccionado = null;
		
		if (lbxAutoclaveParada.getSelectedItem()!=null && lbxAutoclaveParada.getSelectedItem().getValue()!=null)
			eppSeleccionado = (EsterilizadoProcesoParada)lbxAutoclaveParada.getSelectedItem().getValue();
		lbxAutoclaveParada.getItems().clear();
		Sistema.agregarListitemEnBlanco(lbxAutoclaveParada);
		Sistema.setPosicionPrimerItem(lbxAutoclaveParada);
		Listitem li;
		String descripcion;
		String color;
		for (EsterilizadoProcesoParada epp : listaEsterilizadoProcesoParada) {
			li = new Listitem();
			li.setValue(epp);
			color = cargaColor(epp, li);
			descripcion =
					epp.getAutoclave().getDescripcion()
					+ "/" +
					epp.getNumparada()
					+ " - " +
					formato.format(epp.getProduccion().getFechaproduccion())
					+ (color.isEmpty()?"":" - "+color);
			li.setLabel(descripcion);

			li.setParent(lbxAutoclaveParada);
		}
		EsterilizadoProcesoParada epp;
		for (Listitem liAutoclaveParada : (List<Listitem>)lbxAutoclaveParada.getItems()) {
			if (liAutoclaveParada.getValue()==null)continue;
			
			epp = (EsterilizadoProcesoParada)liAutoclaveParada.getValue();
			
			if (eppSeleccionado!=null)
				if(eppSeleccionado.getIdesterilizadoprocesoparada().equals(epp.getIdesterilizadoprocesoparada())) {
					lbxAutoclaveParada.setSelectedItem(liAutoclaveParada);
					break;
				}
		}
		
	}
	
	private String cargaColor(EsterilizadoProcesoParada epp, Listitem li) {
		String etiqueta = "";
		if (new Integer("1").equals(epp.getFinproceso())) {
			etiqueta = lbGuiaFinProceso.getValue();
			li.setStyle("color:green;font-size:12px;font-weight:bold");
		} else if (epp.getHorafinproceso()!=null) {
			etiqueta = lbGuiaFinalizada.getValue();
			li.setStyle("color:red;font-size:12px;font-weight:bold");
		} else if(epp.getHorainicioproceso()!=null) {
			etiqueta = lbGuiaIniciada.getValue();
			li.setStyle("color:blue;font-size:12px;font-weight:bold");
		}else if (new Integer("1").equals(epp.getBlider())) {
			etiqueta = lbGuiaAbierta.getValue();
			li.setStyle("color:black;font-size:12px;font-weight:bold");
		}
		
		return etiqueta;
	}
	
	public void onClick$btnConsultar() {
		if (dteFechaProduccion.getValue()==null) {
			Sistema.mensaje("Debe seleccionar una fecha.");
			return;
		}
		Timestamp fechaProduccion = new Timestamp(dteFechaProduccion.getValue().getTime());
		produccion = new ProduccionDAOJpaImpl().getProduccionByFecha(fechaProduccion);
		if (produccion == null) {
			Sistema.mensaje("No existe produccion para la fecha "+formato.format(dteFechaProduccion.getValue())+".");
			return;
		}
//		else {
//			Sistema.mensaje("Produccion para la fecha "+formato.format(dteFechaProduccion.getValue())+" cargada con exito.");
//		}
		onClick$btnActulizarParadas();
	}
	
	public void onSelect$lbxAutoclaveParada() {
		epp = (EsterilizadoProcesoParada)lbxAutoclaveParada.getSelectedItem().getValue();
		
		if (epp!=null)
			cargaInformacionFomrulario();
		else
			cargaInformacionNULL();
		
		bloqueaformulario(chkFinProceso.isChecked());
		
	}
	
	public void onCheck$chkVerParadasEnCurso() {
		cargachkVerParadasEnCurso();
	}
	
	private void cargachkVerParadasEnCurso() {
		if (chkVerParadasEnCurso.isChecked()) {
			dteFechaProduccion.setValue(null);
			dteFechaProduccion.setDisabled(true);
			tbConsultar.setVisible(false);
			onClick$btnActulizarParadas();
		} else {
			dteFechaProduccion.setDisabled(false);
			tbConsultar.setVisible(true);
			lbxAutoclaveParada.getItems().clear();
			cargaInformacionNULL();
		}
		bloqueaformulario(chkFinProceso.isChecked());
	}
	
	@SuppressWarnings("unchecked")
	private void cargaInformacionFomrulario() {
		Turno turno;
		lbxTurno.setSelectedIndex(0);
		for (Listitem liTurno : (List<Listitem>)lbxTurno.getItems()) {
			if (liTurno.getValue()==null) continue;
			if (epp.getTurno()==null) continue;
			turno = (Turno)liTurno.getValue();
			if(turno.getIdturno().equals(epp.getTurno().getIdturno()))
				lbxTurno.setSelectedItem(liTurno);
		}
		
		chkBliderAbierto.setChecked(new Integer(1).equals(epp.getBlider())?true:false);
		lobNumeroGrafica.setValue(epp.getNumerografica());
		
		
		EsterilizadoProcesoParadaCocheDAO eppcDAO = new EsterilizadoProcesoParadaCocheDAOJpaImpl();
		EsterilizadoProcesoParadaCoche esterilizadoProcesoParadaCoche = eppcDAO.obtieneCocheAsignadoParada(epp.getIdesterilizadoprocesoparada());
		
		if (esterilizadoProcesoParadaCoche!=null) {
			Date horaSellado1raLata= esterilizadoProcesoParadaCoche.getEsterilizadoCoche().getHoraselladolata();
			dteHoraSellado1raLata.setValue(horaSellado1raLata);
		} else {
			dteHoraSellado1raLata.setValue(null);
		}
		dbxPresionVaporPsi.setValue(epp.getPresionvaporpsi());
		dteHoraAverturaVapor.setValue(epp.getHorainiciovapor());
		dteHoraCerradoVenteo.setValue(epp.getHoracerradoventeo());
		dteHoraCerradoVenteo2.setValue(epp.getHoracerradoventeo2());
		dbxTempCerradoVenteo.setValue(epp.getTemperaturacerradoventeo());
		dbxTempCerradoVenteo2.setValue(epp.getTemperaturacerradoventeo2());
		dteHoraInicioProceso.setValue(epp.getHorainicioproceso());
		dteHoraFinProceso.setValue(epp.getHorafinproceso());
		//Tiempo Proceso (*)
		dteHoraFinalEnfriamiento.setValue(epp.getHorafinalenfriamiento());
		dteHoraSalida.setValue(epp.getHorasalida());
		dbxFlujoAguaLS.setValue(epp.getFlujoaguals());
		dbxTempMercurio.setValue(epp.getTemperaturamercurio());
		dbxTempMercurio2.setValue(epp.getTemperaturamercurio2());
		dbxTempGrafica.setValue(epp.getTemperaturagrafica());
		dbxTempGrafica2.setValue(epp.getTemperaturagrafica2());
		dbxPresionManometro.setValue(epp.getPresionmanometro());
		dbxPresionManometro2.setValue(epp.getPresionmanometro2());
		dteHoraRegistroPreManometro.setValue(epp.getHoraregmanometro());
		dteHoraRegistroPreManometro2.setValue(epp.getHoraregmanometro2());
		dbxTempInicio.setValue(epp.getTemperaturainicial());
		dbxTempSalida.setValue(epp.getTemperaturasalida());
		chkFinProceso.setChecked(new Integer(1).equals(epp.getFinproceso()));
		
		calcularTiempoProceso();
		
		cargaInfoCoches();
		
	}
	
	private void cargaInformacionNULL() {
		chkBliderAbierto.setChecked(false);
		lbxTurno.setSelectedIndex(0);
		lobNumeroGrafica.setValue(null);
		dteHoraSellado1raLata.setValue(null);
		dbxPresionVaporPsi.setValue(null);
		dteHoraAverturaVapor.setValue(null);
		dteHoraCerradoVenteo.setValue(null);
		dteHoraCerradoVenteo2.setValue(null);
		dbxTempCerradoVenteo.setValue(null);
		dbxTempCerradoVenteo2.setValue(null);
		dteHoraInicioProceso.setValue(null);
		dteHoraFinProceso.setValue(null);
		txtTiempoProceso.setValue(null);
		dteHoraFinalEnfriamiento.setValue(null);
		dteHoraSalida.setValue(null);
		dbxFlujoAguaLS.setValue(null);
		dbxTempMercurio.setValue(null);
		dbxTempMercurio2.setValue(null);
		dbxTempGrafica.setValue(null);
		dbxTempGrafica2.setValue(null);
		dbxPresionManometro.setValue(null);
		dbxPresionManometro2.setValue(null);
		dteHoraRegistroPreManometro.setValue(null);
		dteHoraRegistroPreManometro2.setValue(null);
		dbxTempInicio.setValue(null);
		dbxTempSalida.setValue(null);
		chkFinProceso.setChecked(false);
		lbxSales.getItems().clear();
		itbTotalCoches.setValue(null);
	}
	
	private void bloqueaformulario(boolean isDisabled) {
		btnGrabar.setDisabled(isDisabled);
		lbxTurno.setDisabled(isDisabled);
		chkBliderAbierto.setDisabled(isDisabled);
		lobNumeroGrafica.setReadonly(isDisabled);
		dteHoraSellado1raLata.setDisabled(isDisabled);
		dbxPresionVaporPsi.setReadonly(isDisabled);
		dteHoraAverturaVapor.setDisabled(isDisabled);
		dteHoraCerradoVenteo.setDisabled(isDisabled);
		dteHoraCerradoVenteo2.setDisabled(isDisabled);
		dbxTempCerradoVenteo.setReadonly(isDisabled);
		dbxTempCerradoVenteo2.setReadonly(isDisabled);
		dteHoraInicioProceso.setDisabled(isDisabled);
		dteHoraFinProceso.setDisabled(isDisabled);
		if (dteHoraInicioProceso.getValue()==null || dteHoraFinProceso.getValue()==null)
			txtTiempoProceso.setValue(null);
		dteHoraFinalEnfriamiento.setDisabled(isDisabled);
		dteHoraSalida.setDisabled(isDisabled);
		dbxFlujoAguaLS.setReadonly(isDisabled);
		dbxTempMercurio.setReadonly(isDisabled);
		dbxTempMercurio2.setReadonly(isDisabled);
		dbxTempGrafica.setReadonly(isDisabled);
		dbxTempGrafica2.setReadonly(isDisabled);
		dbxPresionManometro.setReadonly(isDisabled);
		dbxPresionManometro2.setReadonly(isDisabled);
		dteHoraRegistroPreManometro.setDisabled(isDisabled);
		dteHoraRegistroPreManometro2.setDisabled(isDisabled);
		dbxTempInicio.setReadonly(isDisabled);
		dbxTempSalida.setReadonly(isDisabled);
		chkFinProceso.setDisabled(isDisabled);
		
		tbTomarHoraSellado1raLata.setVisible(!isDisabled);
		tbTomarHoraAverturaVapor.setVisible(!isDisabled);
		tbTomarHoraCerradoVenteo.setVisible(!isDisabled);
		tbTomarHoraCerradoVenteo2.setVisible(!isDisabled);
		tbHoraInicioProceso.setVisible(!isDisabled);
		tbHoraFinProceso.setVisible(!isDisabled);
		tbHoraFinalEnfriamiento.setVisible(!isDisabled);
		tbHoraSalida.setVisible(!isDisabled);
		tbHoraRegistroPreManometro.setVisible(!isDisabled);
		tbHoraRegistroPreManometro2.setVisible(!isDisabled);
	}
	
	private void calcularTiempoProceso() {
		try {
			if(dteHoraInicioProceso.getValue()==null || dteHoraFinProceso.getValue()==null) {
				txtTiempoProceso.setValue(null);
				return;
			}
			if (dteHoraInicioProceso.getValue().getTime()>dteHoraFinProceso.getValue().getTime()) {
				dteHoraInicioProceso.setValue(null);
				txtTiempoProceso.setRawValue("Fecha de inicio de proceso no puede ser mayor a la fecha de fin de proceso.");
				txtTiempoProceso.setRows(2);
				return;
			}
			txtTiempoProceso.setRows(1);
			Date horaInicioProceso = formato2.parse(formato2.format(dteHoraInicioProceso.getValue()));
			Date horaFinProceso = formato2.parse(formato2.format(dteHoraFinProceso.getValue()));
			
			Long calculado = horaFinProceso.getTime()-horaInicioProceso.getTime();
			
			Long diaMilisegundos 	= new Long(86400000);
			Long horaMilisegundos 	= new Long(diaMilisegundos/24);
			Long minutoMilisegundos = new Long(horaMilisegundos/60);
			Long segundoMilisegundos = new Long(minutoMilisegundos/60);
			
			Long totalDias 			= new Long(calculado/diaMilisegundos);
			Long residuoDias		= new Long(calculado%diaMilisegundos);
			
			Long totalHoras			= new Long(residuoDias/horaMilisegundos);
			Long residuoHoras		= new Long(residuoDias%horaMilisegundos);
			
			Long totalMinutos		= new Long(residuoHoras/minutoMilisegundos);
			Long residuoMinutos		= new Long(residuoHoras%minutoMilisegundos);
			
			Long totalSegundos		= new Long(residuoMinutos/segundoMilisegundos);
			
			String msgDias = totalDias+(totalDias<2?"Dia":"Dias");
			String msgHoras = totalHoras<10?"0".concat(totalHoras.toString()): totalHoras.toString();
			String msgMinutos = totalMinutos<10?"0".concat(totalMinutos.toString()): totalMinutos.toString();
			String msgSegundos = totalSegundos<10?"0".concat(totalSegundos.toString()): totalSegundos.toString();
			
			txtTiempoProceso.setValue((totalDias>0?msgDias+" ":"")+msgHoras+":"+msgMinutos+":"+msgSegundos);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cargaInfoCoches() {
		EsterilizadoProcesoParadaCocheDAO eppcDAO = new EsterilizadoProcesoParadaCocheDAOJpaImpl();
		List<EsterilizadoProcesoParadaCoche> listaEPPC = eppcDAO.obtieneCochesAsignadosParada(epp.getIdesterilizadoprocesoparada());
		Listitem li;
		Listcell lc;
		lbxSales.getItems().clear();
		for (EsterilizadoProcesoParadaCoche eppc : listaEPPC) {
			li = new Listitem();
			li.setValue(eppc);
			
			lc = new Listcell();
			lc.setLabel(String.valueOf(eppc.getEsterilizadoCoche().getCodbarra()));
			lc.setParent(li);
			
			lc = new Listcell();
			lc.setLabel(eppc.getEsterilizadoCoche().getProduccionDetalleOrden().getOrden());
			lc.setParent(li);
			
			lc = new Listcell();
			lc.setLabel(eppc.getEsterilizadoCoche().getProduccionDetalleOrden().getCliente());
			lc.setParent(li);
			
			lc = new Listcell();
			lc.setLabel(eppc.getEsterilizadoCoche().getEnvasadoTamanoEnvase().getDescripcion());
			lc.setParent(li);
			
			lc = new Listcell();
			lc.setLabel(eppc.getEsterilizadoCoche().getProduccionDetalleOrden().getVideo());
			lc.setParent(li);
			li.setParent(lbxSales);
		}
		itbTotalCoches.setValue(listaEPPC.size());
	}
	
	public void onChange$dteHoraInicioProceso() {
		calcularTiempoProceso();
	}
	
	public void onChange$dteHoraFinProceso() {
		calcularTiempoProceso();
	}
	
	public void onClick$btnTomarHoraSellado1raLata() {
		dteHoraSellado1raLata.setValue(cargaFechaSistema());
	}
	
	public void onClick$btnTomarHoraAverturaVapor() {
		dteHoraAverturaVapor.setValue(cargaFechaSistema());
	}
	
	public void onClick$btnTomarHoraCerradoVenteo() {
		dteHoraCerradoVenteo.setValue(cargaFechaSistema());
	}
	
	public void onClick$btnTomarHoraCerradoVenteo2() {
		dteHoraCerradoVenteo2.setValue(cargaFechaSistema());
	}
	
	public void onClick$btnHoraInicioProceso() {
		dteHoraInicioProceso.setValue(cargaFechaSistema());
		calcularTiempoProceso();
	}
	
	public void onClick$btnHoraFinProceso() {
		dteHoraFinProceso.setValue(cargaFechaSistema());
		calcularTiempoProceso();
	}
	
	public void onClick$btnHoraFinalEnfriamiento() {
		dteHoraFinalEnfriamiento.setValue(cargaFechaSistema());
	}
	
	public void onClick$btnHoraSalida() {
		dteHoraSalida.setValue(cargaFechaSistema());
	}
	
	public void onClick$btnHoraRegistroPreManometro() {
		dteHoraRegistroPreManometro.setValue(cargaFechaSistema());
	}
	
	public void onClick$btnHoraRegistroPreManometro2() {
		dteHoraRegistroPreManometro2.setValue(cargaFechaSistema());
	}
	
	private Timestamp cargaFechaSistema() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	
	public void onClick$btnGrabar() {
		try {
			if (!validaCampos()) return;
			if (!validaCamposObligatorios()) return;
			if (!validaEstadoCocina()) return;
			if (epp==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo "+lbAutoclaveParada.getValue());
				return;
			}
			
			
			epp.setBlider(chkBliderAbierto.isChecked()?1:0);
			epp.setNumerografica(lobNumeroGrafica.getValue());
			if (dteHoraSellado1raLata.getValue()!=null)
				epp.setHoraselladolata(new Timestamp(dteHoraSellado1raLata.getValue().getTime()));
			epp.setPresionvaporpsi(dbxPresionVaporPsi.getValue());
			if(dteHoraAverturaVapor.getValue()!=null)
				epp.setHorainiciovapor(new Timestamp(dteHoraAverturaVapor.getValue().getTime()));
			if(dteHoraCerradoVenteo.getValue()!=null)
				epp.setHoracerradoventeo(new Timestamp(dteHoraCerradoVenteo.getValue().getTime()));
			if(dteHoraCerradoVenteo2.getValue()!=null)
				epp.setHoracerradoventeo2(new Timestamp(dteHoraCerradoVenteo2.getValue().getTime()));
			epp.setTemperaturacerradoventeo(dbxTempCerradoVenteo.getValue());
			epp.setTemperaturacerradoventeo2(dbxTempCerradoVenteo2.getValue());
			if(dteHoraInicioProceso.getValue()!=null)
				epp.setHorainicioproceso(new Timestamp(dteHoraInicioProceso.getValue().getTime()));
			if(dteHoraFinProceso.getValue()!=null)
			epp.setHorafinproceso(new Timestamp(dteHoraFinProceso.getValue().getTime()));
			//Tiempo Proceso (*)
			if(dteHoraFinalEnfriamiento.getValue()!=null)
				epp.setHorafinalenfriamiento(new Timestamp(dteHoraFinalEnfriamiento.getValue().getTime()));
			if(dteHoraSalida.getValue()!=null)
				epp.setHorasalida(new Timestamp(dteHoraSalida.getValue().getTime()));
			epp.setFlujoaguals(dbxFlujoAguaLS.getValue());
			epp.setTemperaturamercurio(dbxTempMercurio.getValue());
			epp.setTemperaturamercurio2(dbxTempMercurio2.getValue());
			epp.setTemperaturagrafica(dbxTempGrafica.getValue());
			epp.setTemperaturagrafica2(dbxTempGrafica2.getValue());
			epp.setPresionmanometro(dbxPresionManometro.getValue());
			epp.setPresionmanometro2(dbxPresionManometro2.getValue());
			if(dteHoraRegistroPreManometro.getValue()!=null)
				epp.setHoraregmanometro(new Timestamp(dteHoraRegistroPreManometro.getValue().getTime()));
			if(dteHoraRegistroPreManometro2.getValue()!=null)
				epp.setHoraregmanometro2(new Timestamp(dteHoraRegistroPreManometro2.getValue().getTime()));
			epp.setTemperaturainicial(dbxTempInicio.getValue());
			epp.setTemperaturasalida(dbxTempSalida.getValue());
			epp.setFinproceso(chkFinProceso.isChecked()?1:0);
			epp.setTurno((Turno)lbxTurno.getSelectedItem().getValue());
			
			String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
			if (idUsuario==null) {
				Sistema.mensaje("Error. Usuario no logueado.");
				return;
			}
			epp.setIdusuariomod(idUsuario);
			
			
			int res = 1;
			if(chkFinProceso.isChecked()) {
				res = Messagebox.show(String.format("¿Desea cerrar la parada %s del autoclave %s de la produccion %s?",
						epp.getNumparada(), epp.getAutoclave().getDescripcion(), formato.format(epp.getProduccion().getFechaproduccion())),
						"Grabar parada", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
			}
				
			if(res==1) {
				new EsterilizadoProcesoParadaDAOJpaImpl().grabar(epp);
				Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			}
		} catch(Exception e) {
			e.printStackTrace();
			Sistema.mensaje("Ocurrio un error al guardar la informacion.");
		}
		
		try {
			onSelect$lbxAutoclaveParada();
			onClick$btnActulizarParadas();
		} catch(Exception e) {
			e.printStackTrace();
			Sistema.mensaje("Ocurrio un error al cargar la informacion del formulario.");
		} 
	}
	
	/************************/
	/**valida string double**/
	/************************/

	private boolean validaEstadoCocina() {
		chkBliderAbierto.isChecked();
		dteHoraInicioProceso.getValue();
		dteHoraFinProceso.getValue();
		chkFinProceso.isChecked();
		
		String msg= null;
		if (chkFinProceso.isChecked()) {
			if(!chkBliderAbierto.isChecked())
				msg = "Debe chequear el campo "+lbBliderAbierto.getValue()+" cuando esta activo el campo "+lbFinProceso.getValue()+".";
			else if (dteHoraInicioProceso.getValue()==null)
				msg = "Debe ingresar valores en el campo "+lbHoraInicioProceso.getValue()+" cuando esta activo el campo "+lbFinProceso.getValue()+".";
			else if (dteHoraFinProceso.getValue()==null)
				msg = "Debe ingresar valores en el campo "+lbHoraFinProceso.getValue()+" cuando esta activo el campo "+lbFinProceso.getValue()+".";
		}
		
		if (dteHoraFinProceso.getValue()!=null) {
			if(!chkBliderAbierto.isChecked())
				msg = "Debe chequear el campo "+lbBliderAbierto.getValue()+" cuando esta activo el campo "+lbHoraFinProceso.getValue()+".";
			else if (dteHoraInicioProceso.getValue()==null)
				msg = "Debe ingresar valores en el campo "+lbHoraInicioProceso.getValue()+" cuando esta activo el campo "+lbHoraFinProceso.getValue()+".";
		}
		
		if (dteHoraInicioProceso.getValue()!=null) {
			if(!chkBliderAbierto.isChecked())
				msg = "Debe chequear el campo "+lbBliderAbierto.getValue()+" cuando esta activo el campo "+lbHoraInicioProceso.getValue()+".";
		}
		
		if (dteHoraFinProceso.getValue()!=null && dteHoraInicioProceso.getValue()!=null)
			if (dteHoraFinProceso.getValue().getTime()<dteHoraInicioProceso.getValue().getTime())
				msg = "La fecha fin de proceso debe ser mayor a la fecha de inicio de proceso.";
		
		if(msg!=null) {
			Sistema.mensaje(msg);
			return false;
		}
		return true;
	}
	
	private boolean validaCampos() {
		List<Object> listaEtiquetas = new ArrayList<Object>();
		List<Object> camposNumericos = new ArrayList<Object>();
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPresionVaporPsi);
		listaEtiquetas.add(dbxPresionVaporPsi);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTempCerradoVenteo);
		listaEtiquetas.add(dbxTempCerradoVenteo);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTempCerradoVenteo2);
		listaEtiquetas.add(dbxTempCerradoVenteo2);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbFlujoAguaLS);
		listaEtiquetas.add(dbxFlujoAguaLS);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTempMercurio);
		listaEtiquetas.add(dbxTempMercurio);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTempMercurio);
		listaEtiquetas.add(dbxTempMercurio2);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTempGrafica);
		listaEtiquetas.add(dbxTempGrafica);
		camposNumericos.add(listaEtiquetas);

		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTempGrafica);
		listaEtiquetas.add(dbxTempGrafica2);
		camposNumericos.add(listaEtiquetas);

		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPresionManometro);
		listaEtiquetas.add(dbxPresionManometro);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPresionManometro);
		listaEtiquetas.add(dbxPresionManometro2);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTempInicio);
		listaEtiquetas.add(dbxTempInicio);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTempSalida);
		listaEtiquetas.add(dbxTempSalida);
		camposNumericos.add(listaEtiquetas);
		
		Label etiqueta;
		for (Object object : camposNumericos) {
			@SuppressWarnings("unchecked")
			List<Object> valores = (List<Object>) object;
			etiqueta = (Label) valores.get(0);
			if (valores.get(1) instanceof Textbox) {
				if (!validaCamposNumericos(etiqueta, (Textbox) valores.get(1)))
					return false;
			} else if (valores.get(1) instanceof Listbox) {
				if(!validaValorObligatorios(etiqueta, (Listbox) valores.get(1)))
					return false;
			}
		}
		return true;
	}

	private static boolean validaCamposNumericos(Label etiqueta, Textbox valor) {
		try {
			if (valor.getValue() == null) {
				return true;
			} else if (valor.getValue().isEmpty()) {
				return true;
			} else if (parseDouble(valor.getValue()) < 0) {
				Sistema.mensaje("El campo " + etiqueta.getValue() + " no permite numeros negativos.");
				valor.setValue(null);
				valor.setFocus(true);
				return false;
			}
		} catch (Exception e) {
			Sistema.mensaje("El campo " + etiqueta.getValue() + " solo acepta numeros.");
			valor.setValue(null);
			valor.setFocus(true);
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private boolean validaCamposObligatorios() {
		List<Object> listaEtiquetasValor = new ArrayList<Object>();
		List<Object> listaValores = new  ArrayList<Object>();
		
		listaEtiquetasValor = new ArrayList<Object>();
		listaEtiquetasValor.add(lbTurno);
		listaEtiquetasValor.add(lbxTurno);
		listaValores.add(listaEtiquetasValor);
		
		listaEtiquetasValor = new ArrayList<Object>();
		listaEtiquetasValor.add(lbAutoclaveParada);
		listaEtiquetasValor.add(lbxAutoclaveParada);
		listaValores.add(listaEtiquetasValor);
		
		List<Object> valores;
		for (Object object : listaValores) {
			valores = (List<Object>) object;
			if (valores.get(1) instanceof Listbox)
				return validaValorObligatorios((Label)valores.get(0), (Listbox)valores.get(1));
			else if (valores.get(1) instanceof Textbox)
				return validaValorObligatorios((Label)valores.get(0), (Textbox)valores.get(1));
		}
		return true;
	}
	
	private static boolean validaValorObligatorios(Label etiqueta, Textbox valor) {
		try {
			if (valor.getValue() == null ? true : valor.getValue().isEmpty() ? true : false) {
				Sistema.mensaje("Se debe agrega un valor para el campo "+ etiqueta.getValue());
				valor.setFocus(true);
				return false;
			}
		}catch (Exception e) {
			Sistema.mensaje("Se debe agrega un valor para el campo "+ etiqueta.getValue());
			valor.setFocus(true);
			return false;
		}
		return true;
	}
	
	private static boolean validaValorObligatorios(Label etiqueta, Listbox valor) {
		if (valor.getSelectedIndex() == 0) {
			Sistema.mensaje("Debe seleccionar un valor para el campo "+etiqueta.getValue()+".");
			return false;
		}
		return true;
	}
	/**
	 * valida el valor del punto o la coma para el tipo de dato Double
	 * @param valor
	 * @return
	 */
	private static Double parseDouble(String valor) {
		try {
			//retorna el valor recibido
			return Double.valueOf(valor);
		} catch(Exception e){
			try {
				//retorna el valor reemplazando el punto por la coma.
				if (valor !=null)
					if (!valor.isEmpty())
						return new Double(valor.replaceAll("\\.", ","));
				return Double.valueOf(valor);
			}catch(Exception e1) {
				try {
					if (valor !=null)
						if (!valor.isEmpty())
							return new Double(valor.replaceAll(",", "\\."));
					return Double.valueOf(valor);
				}catch(Exception e2) {
//					e.printStackTrace();
					return new Double("");
				}
			}
		}
	}

	

}
