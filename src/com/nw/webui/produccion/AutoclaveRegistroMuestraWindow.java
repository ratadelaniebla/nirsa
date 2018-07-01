package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.Produccion;
import com.nw.model.dao.EsterilizadoProcesoParadaCocheDAO;
import com.nw.model.dao.impl.EsterilizadoCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaDAOJpaImpl;
import com.nw.util.Sistema;

public class AutoclaveRegistroMuestraWindow  extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(AutoclaveRegistroMuestraWindow.class);
	AnnotateDataBinder binder;
	public Listbox lbxProduccion, lbxParada, lbxCoches, lbxMuestrasDetalle;
	public Label lbHoraFinProcesoValor, lbClienteValor, lbCodigoValor;
	public Intbox intMuestras;
	public Textbox txtObservacion;
	public Datebox dteHoraDescarga;
	
	public AutoclaveRegistroMuestraWindow() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		cargalbxProduccion();
		binder.loadAll();
	}
	
	private void inicializaListBox(Listbox listBox) {
		listBox.getItems().clear();
		Sistema.setPosicionPrimerItem(listBox);
		Sistema.agregarListitemEnBlanco(listBox);
	}
	
	private void cargalbxProduccion() {
		inicializaListBox(lbxProduccion);
		
		EsterilizadoProcesoParadaCocheDAO eppcDAO = new EsterilizadoProcesoParadaCocheDAOJpaImpl();
		List<Produccion> listaEPPC = eppcDAO.obtieneParadasAsignadasProduccion();
		
		if (listaEPPC==null) return;
		Listitem li;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (Produccion produccion : listaEPPC) {
			li = new Listitem();
			li.setValue(produccion);
			li.setLabel(sdf.format(produccion.getFechaproduccion()));
			li.setParent(lbxProduccion);
		}
	}
	
	public void onSelect$lbxProduccion() {
		cargalbxParada();
		onSelect$lbxParada();
	}
	
	private void cargalbxParada() {
		inicializaListBox(lbxParada);
		
		Produccion produccion = (Produccion)lbxProduccion.getSelectedItem().getValue();
		if (produccion==null)return;
		EsterilizadoProcesoParadaCocheDAO eppcDAO = new EsterilizadoProcesoParadaCocheDAOJpaImpl();
		List<EsterilizadoProcesoParada> listaEPPC = eppcDAO.obtieneParadasAsignadosProduccion(produccion.getIdproduccion());
		if(listaEPPC==null) return;
		
		Listitem li;
		
		for (EsterilizadoProcesoParada esterilizadoProcesoParada : listaEPPC) {
			li = new Listitem();
			li.setValue(esterilizadoProcesoParada);
			li.setLabel(esterilizadoProcesoParada.getNumparada().toString());
			li.setParent(lbxParada);
		}
	}
	private List<EsterilizadoCoche> listaEC = null;
	public void onSelect$lbxParada() {
		inicializaListBox(lbxCoches);
		
		lbClienteValor.setValue(null);
		lbCodigoValor.setValue(null);
		intMuestras.setValue(null);
		intMuestras.setDisabled(true);
		lbxMuestrasDetalle.getItems().clear();
		txtObservacion.setValue(null);
		txtObservacion.setDisabled(true);
		dteHoraDescarga.setValue(null);
		lbHoraFinProcesoValor.setValue(null);
		
		if (lbxParada.getSelectedItem()==null)return;
		
		EsterilizadoProcesoParada esterilizadoProcesoParada = (EsterilizadoProcesoParada)lbxParada.getSelectedItem().getValue();
		
		if (esterilizadoProcesoParada==null)return;
		
		dteHoraDescarga.setValue(esterilizadoProcesoParada.getHoradescarga());
		String horaFinProceso = esterilizadoProcesoParada.getHorafinproceso()!=null?new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(esterilizadoProcesoParada.getHorafinproceso()):"";
		lbHoraFinProcesoValor.setValue(horaFinProceso);
		
		EsterilizadoProcesoParadaCocheDAO eppcDAO = new EsterilizadoProcesoParadaCocheDAOJpaImpl();
		listaEC = eppcDAO.obtieneCochesAsignadosProduccion(esterilizadoProcesoParada.getIdesterilizadoprocesoparada());
		
		if(listaEC==null) return;
		
		Listitem li;
		
		for (EsterilizadoCoche esterilizadoCoche : listaEC) {
			li = new Listitem();
			li.setValue(esterilizadoCoche);
			li.setLabel(esterilizadoCoche.getCodbarra().toString());
			li.setParent(lbxCoches);
			
			cargaCochesMuestras(esterilizadoCoche);
		}
	}
	
	public void onSelect$lbxCoches() {
		
		EsterilizadoCoche esterilizadoCoche = (EsterilizadoCoche)lbxCoches.getSelectedItem().getValue();
		if (esterilizadoCoche==null) {
			lbClienteValor.setValue(null);
			lbCodigoValor.setValue(null);
			intMuestras.setDisabled(true);
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
		} else {
			lbClienteValor.setValue(esterilizadoCoche.getProduccionDetalleOrden().getCliente());
			lbCodigoValor.setValue(esterilizadoCoche.getProduccionDetalleOrden().getVideo());
			intMuestras.setDisabled(false);
			txtObservacion.setValue(esterilizadoCoche.getObservacion());
			txtObservacion.setDisabled(false);
		}
		intMuestras.setValue(null);
	}
	
	private void cargaCochesMuestras(EsterilizadoCoche esterilizadoCoche) {
		
		if (esterilizadoCoche.getCantidadmuestras()==null)
			return;
		
		if (esterilizadoCoche.getCantidadmuestras().equals(0))
			return;
		
		Listitem li = new Listitem();
		Listcell lcCoches = new Listcell();
		Listcell lcCantidadMuestras = new Listcell();
		
		lcCoches.setLabel(
				esterilizadoCoche.getCodbarra()==null?"":esterilizadoCoche.getCodbarra().toString());
		lcCantidadMuestras.setLabel(
				esterilizadoCoche.getCantidadmuestras()==null?"0":esterilizadoCoche.getCantidadmuestras().toString());
		
		lcCoches.setParent(li);
		lcCantidadMuestras.setParent(li);
		li.setValue(esterilizadoCoche);
		li.setParent(lbxMuestrasDetalle);
		
	}
	
	@SuppressWarnings("unchecked")
	public void onClick$btnAgregarItem() {
		try {
			
			Integer muestras = intMuestras.getValue();
			if (muestras<0) {
				Sistema.mensaje("No puede ingresar una cantidad de muestras negativas.");
				intMuestras.focus();
				return;
			}
			
			EsterilizadoCoche esterilizadoCoche = (EsterilizadoCoche)lbxCoches.getSelectedItem().getValue();
			
			List<Listitem> listaLI = lbxMuestrasDetalle.getItems();
			EsterilizadoCoche esterilizadoCocheLI;
			boolean nuevoCoche = true;
			for(Listitem li:listaLI) {
				if(li.getValue()==null) continue;
				esterilizadoCocheLI = (EsterilizadoCoche)li.getValue();
				if (esterilizadoCocheLI.getIdesterilizadocoche().equals(esterilizadoCoche.getIdesterilizadocoche())) {
					esterilizadoCocheLI.setCantidadmuestras((esterilizadoCocheLI.getCantidadmuestras() == null ? 0
							: esterilizadoCocheLI.getCantidadmuestras()) + intMuestras.getValue());
					lbxMuestrasDetalle.removeItemFromSelection(li);
					li.setValue(esterilizadoCocheLI);
					li.getChildren().clear();
					new Listcell(esterilizadoCocheLI.getCodbarra().toString()).setParent(li);
					new Listcell(esterilizadoCocheLI.getCantidadmuestras().toString()).setParent(li);
					lbxMuestrasDetalle.addItemToSelection(li);
					nuevoCoche=false;
					break;
				}
			}
			if (nuevoCoche) {
				Listitem li = new Listitem();
				li.setValue(esterilizadoCoche);
				esterilizadoCoche.setCantidadmuestras(
						(esterilizadoCoche.getCantidadmuestras() == null ? 0 : esterilizadoCoche.getCantidadmuestras())
								+ intMuestras.getValue());
				new Listcell(esterilizadoCoche.getCodbarra().toString()).setParent(li);
				new Listcell(esterilizadoCoche.getCantidadmuestras().toString()).setParent(li);
				li.setParent(lbxMuestrasDetalle);
				nuevoCoche=false;
			}
//			binder.loadComponent(lbxMuestrasDetalle);
		} catch(Exception e) {
			e.printStackTrace();
			Sistema.mensaje("Ocurrio un erro al guardar la informacion...");
		} finally {
			intMuestras.setValue(null);
		}
	}
	
	public void onClick$btnEliminarItem() {
		try {
			List<Object> listaLI = Arrays.asList(lbxMuestrasDetalle.getSelectedItems().toArray());
			for (Object listitem : listaLI)
				lbxMuestrasDetalle.getItems().remove(listitem);
			lbxMuestrasDetalle.setCheckmark(false);
			lbxMuestrasDetalle.setCheckmark(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onClick$btnGrabar() {
		try {
			@SuppressWarnings("unchecked")
			List<Listitem> listaLI = lbxMuestrasDetalle.getItems();
			EsterilizadoCoche esterilizadoCoche;
			
			List<EsterilizadoCoche> listaEC = new ArrayList<EsterilizadoCoche>();
			List<EsterilizadoCoche> listaECAUX = new ArrayList<EsterilizadoCoche>();
			listaECAUX.addAll(this.listaEC);
			
			/*****************/
			if (!grabaInfoParada()) return;
			
			//guarda las muestras
			for (Listitem listitem : listaLI) {
				if(listitem.getValue()==null)continue;
				esterilizadoCoche = (EsterilizadoCoche)listitem.getValue();
				esterilizadoCoche.setObservacion(txtObservacion.getValue());
				/*********************************/
				grabaInfoCoche(esterilizadoCoche);
				listaEC.add(esterilizadoCoche);
			}
			
			//remueve de la lista los coches con valor muestras
			for (EsterilizadoCoche ec:this.listaEC) {
				if (listaEC.contains(ec))
					listaECAUX.remove(ec);
			}
			
			//elimina las muestras
			for (EsterilizadoCoche ec:listaECAUX) {
				ec.setCantidadmuestras(null);
				new EsterilizadoDAOJpaImpl().guardarEsterilizadoCoche(ec);	
			}
			
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			intMuestras.setValue(null);
			onSelect$lbxParada();
		} catch(Exception e) {
			e.printStackTrace();
			Sistema.mensaje("Ocurrio un erro al guardar la informacion...");
		}
	}
	
	private void grabaInfoCoche(EsterilizadoCoche esterilizadoCoche) {
		EsterilizadoCoche esterilizadoCocheOLD = (EsterilizadoCoche) new EsterilizadoCocheDAOJpaImpl()
				.getObject(EsterilizadoCoche.class, esterilizadoCoche.getIdesterilizadocoche());
		
		if (esterilizadoCoche.getCantidadmuestras().equals(esterilizadoCocheOLD.getCantidadmuestras()))
			return;
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		
		esterilizadoCoche.setFecharegcantidadmuestras(new Timestamp(System.currentTimeMillis()));
		esterilizadoCoche.setIdusuariomuestras(idUsuario);
		
		new EsterilizadoDAOJpaImpl().guardarEsterilizadoCoche(esterilizadoCoche);
	}

	private boolean grabaInfoParada() {
		if(dteHoraDescarga.getValue()==null) {
			Sistema.mensaje("Debe ingresar el valor para el campo Hora Descarga");
			return false;
		}
		EsterilizadoProcesoParada esterilizadoProcesoParada = (EsterilizadoProcesoParada)lbxParada.getSelectedItem().getValue();
		esterilizadoProcesoParada.setHoradescarga(new Timestamp(dteHoraDescarga.getValue().getTime()));
		new EsterilizadoProcesoParadaDAOJpaImpl().grabar(esterilizadoProcesoParada);
		return true;
	}
}
