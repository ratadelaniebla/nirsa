package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.EnvasadoControlFillCorteCabecera;
import com.nw.model.EnvasadoControlFillCorteDetalle;
import com.nw.model.EnvasadoProceso;
import com.nw.model.Produccion;
import com.nw.model.dao.EnvasadoControlFillCorteCabeceraDAO;
import com.nw.model.dao.EnvasadoControlFillCorteDetalleDAO;
import com.nw.model.dao.impl.EnvasadoControlFillCorteCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlFillCorteDetalleDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;

public class EnavasadoControlFillCorteMantenimientoWindow extends GenericForwardComposer {

	private static final String SELECT = "select";
	private static final long serialVersionUID = 1L;
	AnnotateDataBinder binder;
	
	Produccion produccion;
	EnvasadoProceso envasadoProceso;
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
		
		envasadoProceso = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		
		EnvasadoControlFillCorteCabeceraDAO ecfccDAO = new EnvasadoControlFillCorteCabeceraDAOJpaImpl(); 
		
		ecfcc = ecfccDAO.obtieneByIdEnvasadoProceso(envasadoProceso.getIdenvasadoproceso());
		List<EnvasadoControlFillCorteDetalle> listaEcfcd = ecfcc.getEnvasadoControlFillCorteDetalles();
		
		/**
		 * fragmento de codigo para ordenar la lista por item
		 */
		Collections.sort(listaEcfcd, new Comparator<EnvasadoControlFillCorteDetalle>() 		
		{
			@Override
			public int compare(EnvasadoControlFillCorteDetalle o1, EnvasadoControlFillCorteDetalle o2) {
				return new Integer(o1.getCorte()).compareTo(o2.getCorte());
			}
		});
		
		
		Listitem li;
		Listcell lc;
		Listbox lista = new Listbox();
		lista.setMold(SELECT);
		
		if (listaEcfcd != null)
			for (EnvasadoControlFillCorteDetalle ecfcd : listaEcfcd) {
				li = new Listitem();
				
				lc = new Listcell();
					Label lb = new Label("N. Corte");
					lb.setWidth("100%");
				lc.appendChild(lb);
				lc.setParent(li);
				
				lc = new Listcell();
					Textbox tbx = new Textbox();
					tbx.setWidth("50%");
					tbx.setValue(ecfcd.getCorte().toString());
					tbx.setReadonly(false);
				lc.appendChild(tbx);
				lc.setParent(li);
				
				lc = new Listcell();
				lc.appendChild(new Label("Hora"));
				lc.setParent(li);
				
				lc = new Listcell();
				lc.appendChild(cargaHora(ecfcd.getHora().toString()));
				lc.setParent(li);
			
				
				lc = new Listcell();
				lc.appendChild(new Label("Min."));
				lc.setParent(li);
				
				lc = new Listcell();
				lc.appendChild(cargaMinutos(ecfcd.getMinuto().toString()));
				lc.setParent(li);
				
				
				lc = new Listcell();
					Checkbox cbx = new Checkbox();
				lc.appendChild(cbx);
				lc.setParent(li);
				
			li.setValue(ecfcd);
			li.setParent(lbxLista);
				
			}
	}
	
	public void onClick$btnAgregarItem() {
		
		Listitem li;
		Listcell lc;
		
		Listbox lista = new Listbox();
		lista.setMold(SELECT);
		
		li = new Listitem();
		
			lc = new Listcell();
				Label lb = new Label("N. Corte");
				lb.setWidth("100%");
			lc.appendChild(lb);
			lc.setParent(li);
		
			lc = new Listcell();
				Textbox tbx = new Textbox();
				tbx.setWidth("100%");
				tbx.setValue(String.valueOf(lbxLista.getItems().size()+1));
				tbx.setReadonly(true);
			lc.appendChild(tbx);
			lc.setParent(li);
		
			lc = new Listcell();
			lc.appendChild(new Label("Hora"));
			lc.setParent(li);
			
			lc = new Listcell();
			lc.appendChild(cargaHora(""));
			lc.setParent(li);
		
			
			lc = new Listcell();
			lc.appendChild(new Label("Min."));
			lc.setParent(li);
			
			lc = new Listcell();
			lc.appendChild(cargaMinutos(""));
			lc.setParent(li);
			
			
			lc = new Listcell();
				Checkbox cbx = new Checkbox();
				cbx.setChecked(false);
			lc.appendChild(cbx);
			lc.setParent(li);
			
		li.setValue(null);
		li.setParent(lbxLista);
	}
	
	private Listbox cargaHora(String valorSeleccionado) {
		try {
			Listbox lbxHora = new Listbox();
			Listitem li;
			int selectedIndex=0;
			lbxHora.setId("lbxHora"+lbxLista.getItems().size());
			lbxHora.setMold(SELECT);
			
			li = new Listitem();
			li.setParent(lbxHora);
			
			for (int i=0 ; i<24 ; i++) {
				li = new Listitem();
				if (i<10) {
					li.setLabel("0"+i);li.setValue("0"+i);
				} else {
					li.setLabel(String.valueOf(i));li.setValue(String.valueOf(i));
				}
				if (valorSeleccionado.equals(String.valueOf(i)))
					selectedIndex = i+1;
				li.setParent(lbxHora);
			}
			lbxHora.setSelectedIndex(selectedIndex);
			return lbxHora;
		} catch (Exception e) {
			return new Listbox();
		}
	}
	
	private Listbox cargaMinutos(String valorSeleccionado) {
		try {
			Listbox lbxMinutos = new Listbox();
			Listitem  li;
			int selectedIndex=0;
			
			lbxMinutos.setId("lbxMinuto"+lbxLista.getItems().size());
			lbxMinutos.setMold(SELECT);
			
			li = new Listitem();
			li.setParent(lbxMinutos);
			
			for (int i=0 ; i<60 ; i++) {
				li = new Listitem();
				if (i<10) {
					li.setLabel("0"+i);
					li.setValue("0"+i);
				} else {
					li.setLabel(String.valueOf(i));
					li.setValue(String.valueOf(i));
				}
				if (valorSeleccionado.equals(String.valueOf(i)))
					selectedIndex = i+1;
				li.setParent(lbxMinutos);
			}
			
			lbxMinutos.setSelectedIndex(selectedIndex);
			
			return lbxMinutos;
		} catch (Exception e) {
			return new Listbox();
		}
	}
	
	public void onClick$btnGrabar() {
		if (envasadoProceso.getIdenvasadoproceso()==null) {
			Sistema.mensaje("No se ha encontrado una produccion activa");
			return;
		}
		
		EnvasadoControlFillCorteCabeceraDAO ecfccDAO = new  EnvasadoControlFillCorteCabeceraDAOJpaImpl();
		
		if (this.ecfcc.getIdenvasadocontrolfillcortecabecera()==null)
			this.ecfcc = new EnvasadoControlFillCorteCabecera();
		ecfcc.setEnvasadoProceso(envasadoProceso);
		ecfcc.setFechareg(new Timestamp(System.currentTimeMillis()));
		
		//valida la informacion del usuario logueado
		String idUsurio = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsurio==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		ecfcc.setIdusuario(idUsurio);
		
		//setean el detalle en la cabecera
		ecfcc.setEnvasadoControlFillCorteDetalles(procesaEnvasadoControlFillCorteDetalle(ecfcc));
		if (ecfcc.getEnvasadoControlFillCorteDetalles()==null)
			return;

		//inserta la cabecera
		if (ecfccDAO.updateEnvasadoControlFillCorteCabecera(ecfcc)==null) {
			Sistema.mensaje("Error al intentar guardar la informacion.");
			return;
		}
		
		Sistema.mensaje("Cambios guardados exitosamente.");
		
		limpiarFormulario();
		binder.loadAll();
//		iniciaFormulario();
	}
	
	public void onClick$btnEliminarItem() {
		@SuppressWarnings({ "unchecked" })
		List<Listitem> listaLI = (List<Listitem>)lbxLista.getItems();
		List<Listitem> listaLIEliminados = new ArrayList<Listitem>();

		for (Listitem li : listaLI) {
			System.out.println(listaLI.size());
			Listcell liCell = (Listcell)li.getChildren().get(6);
			Checkbox cbx = (Checkbox)liCell.getChildren().get(0);
			if (cbx.isChecked())
				listaLIEliminados.add(li);
		}
		
		EnvasadoControlFillCorteDetalleDAO ecfcdDAO = new EnvasadoControlFillCorteDetalleDAOJpaImpl();
		EnvasadoControlFillCorteDetalle ecfcd;
		for (Listitem li : listaLIEliminados) {
			
			ecfcd = (EnvasadoControlFillCorteDetalle)li.getValue();
			
			if ( ecfcdDAO.elimina( ecfcd ) )
				lbxLista.getItems().remove(li);
			else {
				Sistema.mensaje("El detalle del corte "+ecfcd.getCorte()+" se encuentra en uso.");
				return;
			}
		}
		
		binder.loadComponent(lbxLista);
	}

	private List<EnvasadoControlFillCorteDetalle> procesaEnvasadoControlFillCorteDetalle(EnvasadoControlFillCorteCabecera ecfcc) {
		try {
			@SuppressWarnings("unchecked")
			List<Listitem> listaDetalle = lbxLista.getItems();
			Listcell lcCorte;
			Listcell lcHora;
			Listcell lcMinuto;
			
			Textbox txtCorte;
			Listbox lbxHora;
			Listbox lbxMinuto;
			
			EnvasadoControlFillCorteDetalle ecfcd;
			List<EnvasadoControlFillCorteDetalle> listaECFCD = new ArrayList<EnvasadoControlFillCorteDetalle>();
			ecfcc.setEnvasadoControlFillCorteDetalles(new ArrayList<EnvasadoControlFillCorteDetalle>());
			for(Listitem li : listaDetalle) {
				lcCorte = (Listcell)li.getChildren().get(1);//textbox
				lcHora = (Listcell)li.getChildren().get(3);//hora
				lcMinuto = (Listcell)li.getChildren().get(5);//minuto
				
				txtCorte = (Textbox)lcCorte.getChildren().get(0);
				lbxHora = (Listbox)lcHora.getChildren().get(0);
				lbxMinuto = (Listbox)lcMinuto.getChildren().get(0);
				
				if (li.getValue()!=null)
					ecfcd = (EnvasadoControlFillCorteDetalle)li.getValue();
				else
					ecfcd = new EnvasadoControlFillCorteDetalle();
				
				ecfcd.setCorte(Integer.valueOf(txtCorte.getValue()));
				if (lbxHora.getSelectedItem().getValue()==null) {
					Sistema.mensaje("El valor del campo hora es obligatorio para el corte #"+txtCorte.getValue()+".");
					return null;
				}
				ecfcd.setHora(Long.valueOf(lbxHora.getSelectedItem().getValue().toString()));
				
				
				if (lbxMinuto.getSelectedItem().getValue()==null) {
					Sistema.mensaje("El valor del campo minuto es obligatorio para el corte #"+txtCorte.getValue()+".");
					return null;
				}
				ecfcd.setMinuto(Long.valueOf(lbxMinuto.getSelectedItem().getValue().toString()));
				
				ecfcd.setEnvasadoControlFillCorteCabecera(ecfcc);

				listaECFCD.add(ecfcd);
			}
			
			return listaECFCD;
		} catch (Exception e) {
			
			Sistema.mensaje("Ocurrio un error no esperado.");
			e.printStackTrace();
			
			return null;
			
		}
	}

	private void limpiarFormulario() {
//		dteFechaProduccion.setValue(null);
//		lbxTurnoProduccion.getItems().clear();
//		lbxLista.getItems().clear();
		onSelect$lbxTurnoProduccion();
		binder.loadComponent(lbxLista);
	}
	
	
}
