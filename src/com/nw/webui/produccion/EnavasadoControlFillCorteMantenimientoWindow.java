package com.nw.webui.produccion;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.nw.model.EnvasadoControlFillCorteCabecera;
import com.nw.model.EnvasadoControlFillCorteDetalle;
import com.nw.model.EnvasadoProceso;
import com.nw.model.Produccion;
import com.nw.model.dao.EnvasadoControlFillCorteCabeceraDAO;
import com.nw.model.dao.impl.EnvasadoControlFillCorteCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;

public class EnavasadoControlFillCorteMantenimientoWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	AnnotateDataBinder binder;
	
	Produccion produccion;
	EnvasadoControlFillCorteCabecera ecfcc;
	
	Label lbFechaProduccion, lbTurnoProduccion;
	Datebox dteFechaProduccion;
	Listbox lbxLista, lbxTurnoProduccion;
	
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.loadAll();
	}
	
	public void onChange$dteFechaProduccion() {
		produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		List<EnvasadoProceso> listEProceso = new ArrayList<EnvasadoProceso>();
		
		if (produccion==null) {
			Sistema.mensaje("No existe una produccion configurada para la fecha seleccionada.");
			return;
		}
		
		listEProceso = new EnvasadoProcesoDAOJpaImpl().getEnvasadoProcesoByIdProduccion(produccion.getIdproduccion());
		
		if(listEProceso.isEmpty()) {
			Sistema.mensaje("No existe configuracion para la fecha seleccionada.");
			return;
		}
		
		cargaTurno(listEProceso);
		
	}
	
	private  void cargaTurno(List<EnvasadoProceso> listEProceso) {
	
		lbxTurnoProduccion.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoProceso());
		li.setParent(lbxTurnoProduccion);
		
		for (EnvasadoProceso eProceso : listEProceso) {
			li = new Listitem();
			li.setValue(eProceso);
			new Listcell(eProceso.getTurno().getNombre()).setParent(li);
			li.setParent(lbxTurnoProduccion);
		}
		
		lbxTurnoProduccion.setSelectedIndex(0);
		
	}
	
	public void onSelect$lbxTurnoProduccion() {
		lbxLista.getItems().clear();
		
		EnvasadoProceso ep = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		
		EnvasadoControlFillCorteCabeceraDAO ecfccDAO = new EnvasadoControlFillCorteCabeceraDAOJpaImpl(); 
		
		List<EnvasadoControlFillCorteDetalle> listaEcfcd = ecfccDAO.obtieneByIdEnvasadoProceso(ep.getIdenvasadoproceso()).getEnvasadoControlFillCorteDetalles();
		
		if (listaEcfcd != null)
			for (EnvasadoControlFillCorteDetalle ecfcd : listaEcfcd) {
				System.out.println(ecfcd.getCorte());;
			}
	}
	
}
