/**
 * Copyright 2010 the original author or authors.
 * 
 * This file is part of Zksample2. http://zksample2.sourceforge.net/
 *
 * Zksample2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Zksample2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zksample2.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package com.nw.core;

import java.io.Serializable;
import java.util.Map;


import org.zkoss.zk.ui.event.CreateEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.avante.core.UserWorkspace;

import com.nw.util.Sistema;

/**
 * Base controller for creating the controllers of the zul files with the spring
 * framework.
 * 
 * @author bbruhns
 * @author sgerth
 */
abstract public class GFCBaseCtrlWM extends GenericForwardComposer implements Serializable {

	private static final long serialVersionUID = -1171206258809472640L;
	//private static Log logger = LogFactory.getLog(DescongeladoWindow.class);

	protected transient AnnotateDataBinder binder;

	protected transient Map<String, Object> args;

	protected Window winDescongelado; // autowired
	protected Tabbox tboxPrincipal;

	protected Toolbarbutton btnNuevo;  // autowire
	protected Toolbarbutton btnCargar; // autowire
	protected Toolbarbutton btnBuscar; // autowire
	protected Toolbarbutton btnGrabar; // autowire
	protected Toolbarbutton btnActualizar;// autowire
	protected Toolbarbutton btnEliminar; // autowire
	protected Toolbarbutton btnEnviar;
	protected Toolbarbutton btnLimpiar;
	protected Toolbarbutton btnVerTara; // autowire
	protected Listbox lbxOrd; // autowire
	protected Listbox lbxRecursos; // autowire
	protected Listbox lbxTipoRecursos; // autowire

/*	protected Decimalbox txtCantidad;*/
	protected Intbox txtUnidades;
	protected Textbox txtDescRecurso;// autowire
	protected Datebox dteFecPro; // autowire
	protected Textbox txtObs;// autowire

	
	protected Checkbox chkEst;

	/**
	 * Get the params map that are overhanded at creation time. <br>
	 * Reading the params that are binded to the createEvent.<br>
	 * 
	 * @param event
	 * @return params map
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCreationArgsMap(Event event) {
		CreateEvent ce = (CreateEvent) ((ForwardEvent) event).getOrigin();
		return ce.getArg();
	}

	public void doSetComposerName(Window w) throws Exception {
		w.setVariable("controller", this, false); // make models visible for the
													// databinder
//		binder = new AnnotateDataBinder(w);
//		binder.loadAll();
	}

	public void doOnCreateCommon(Window w) throws Exception {
		binder = new AnnotateDataBinder(w);
		binder.loadAll();
	}

	@SuppressWarnings("unchecked")
	public void doOnCreateCommon(Window w, Event fe) throws Exception {
		doOnCreateCommon(w);
		CreateEvent ce = (CreateEvent) ((ForwardEvent) fe).getOrigin();
		args = ce.getArg();
	}

	private transient UserWorkspace userWorkspace;

	final protected UserWorkspace getUserWorkspace() {
		return userWorkspace;
	}

	public void setUserWorkspace(UserWorkspace userWorkspace) {
		this.userWorkspace = userWorkspace;
	}
	

    public void onClick$btnEnviar(Event event) { 

	    }

    public void onClick$btnLimpiar(Event event) { 

    }
    
	/**
	 * when the "cargar" button is clicked. <br>
	 * 
	 * @param event
	 * @throws InterruptedException
	 */
	public void onClick$btnCargar(Event event) throws InterruptedException {

		
		doCargar();
	}
	
	public void doLimpiarRecurso(){

/*		txtCantidad.setText("");*/
		txtUnidades.setText("");
		txtDescRecurso.setText("");
	}

	public void doNuevoRecurso(int proceso) throws InterruptedException {
		
		
		/* if a recurso is selected get the object from the listbox */
		@SuppressWarnings("unused")
		Listitem tr = lbxTipoRecursos.getSelectedItem();

		
		doLimpiarRecurso();

	}

	@SuppressWarnings("unused")
	public void doLoadItemRecurso(){

		Listitem item = lbxRecursos.getSelectedItem();
		if (item != null) {
			
			ListModelList lml1 = (ListModelList) lbxRecursos.getListModel();
			
					
		}

	}

	@SuppressWarnings("unused")
	public void doGrabarRecurso(int proceso) throws InterruptedException {
		
		
		/* if a recurso is selected get the object from the listbox */
		Listitem tr = lbxTipoRecursos.getSelectedItem();
		
		// fill the object with the components data
		// save it to database
		
	}

	@SuppressWarnings("unused")
	public void doLoadOrdenFabricacionC(int proceso){

		Listitem item = lbxOrd.getSelectedItem();

		if (item != null) {
			ListModelList lml1 = (ListModelList) lbxOrd.getListModel();
			
			
			//Si la orden esta cerrada permite buscar datos 
			// desabilita el boton Grabar
					
		}


	}
	

	public void doLoadOrdenFabricacionC2(int proceso, long vIdordenfab){

/*		Listitem item = lbxOrd.getSelectedItem();*/

/*		if (item != null) {*/
				
/*			OrdenFabricacionUp vordenfabricacionup = (OrdenFabricacionUp) lml1.get(item.getIndex());*/

/*			OrdenFabricacionL vordenfabricacionl = new OrdenFabricacionLJpaImpl().getMedioByIdAndFOP(vIdMedio, new Fecha(dteFecPro.getValue()).toCadena());*/
/*			setOrdenfabricacionl(vordenfabricacionl);*/

/*			long a = vordenfabricacionl.getId().getIordenfabricacion();*/
		
			//Si la orden esta cerrada permite buscar datos 
			// desabilita el boton Grabar
							
/*		}*/

	}
	
	
	public void doCheckProcStatus(String sttsproc){
		
		if (sttsproc.equals(Sistema.STTSPROC_CERRADO)){
			btnGrabar.setDisabled(true);
			btnGrabar.setImage("/img/grabard.gif");
			chkEst.setChecked(true);
			chkEst.setDisabled(true);
		}else{
			btnGrabar.setDisabled(false);
			btnGrabar.setImage("/img/grabar.gif");
			chkEst.setChecked(false);
			chkEst.setDisabled(false);
		}

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// +++++++++++++++++++++++++ crud operations +++++++++++++++++++++++
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * Load the components to table. <br>
	 * 
	 * @throws InterruptedException
	 */
	public void doCargar() throws InterruptedException {

		// +++++++++ DropDown ListBox
		// set listModel and itemRenderer for the dropdown listbox
		
		
			
				
	}

	public void doSetInfoProc() {
		
	} 
	
	/**
	 * Load the components to table. <br>
	 * 
	 * @throws InterruptedException
	 */
	public void doCargarRecursosListBox(int proceso) throws InterruptedException {

		// +++++++++ DropDown ListBox
		// set listModel and itemRenderer for the dropdown listbox
		
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	// ++++++++++++++++++ getter / setter +++++++++++++++++++//
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++//


	
	
	public void onClick$btnNuevo(Event event) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	

}

