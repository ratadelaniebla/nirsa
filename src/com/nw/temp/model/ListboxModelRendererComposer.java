package com.nw.temp.model;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.nw.util.ListBoxRenderizador;


public class ListboxModelRendererComposer extends GenericForwardComposer {
	 
 
	private static final long serialVersionUID = 1L;
	Listbox lbThree;
	List listaConDatos = new ArrayList();

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// set models and render to listbox after comopsed
//		lbOne.setModel(getSimpleStringModel());
//		lbTwo.setModel(getPersonModel());
		
	
		
		ListBoxRenderizador rend = new ListBoxRenderizador();
		// AKI LE ENVIO UN 3 kemado para q cree 3 columnas 
		// la idea es q es donde va el 3 vayan los N cantidad de columnas segun 
		// la cantidad de espeacios q se generan en otra pantalla
		// esto fue la primer parte q hice ahy q adapatarla para q reciba uno o mas objeetos
		// segun la tabla
		// alguna cosa ahi q preguntarle a harold sobre esto 
		// y al final se debe recorrer la la lista y enviar a guardar
		// 
		rend.renderListheads(lbThree,5);
		lbThree.setModel(getPersonModel());
		lbThree.setItemRenderer(new ListBoxRenderizador());
		
	}

	public ListModel getSimpleStringModel() {
		List l = new ArrayList();
		// simply add some Strings to a list
		// than wrap the list by a ListModelList
		l.add("data one");
		l.add("data two");
		l.add("data three");
		//l.add("cuarto dato");
		//l.add("quinto dato");
		return new ListModelList(l);
	}

	public ListModel getPersonModel() {
		
		List<Double> porcentajeSales = new ArrayList<Double>();
		porcentajeSales.add(3.6);
		porcentajeSales.add(7.4);
		porcentajeSales.add(8.1);
		
		// simply add some Persons to a list
		// than wrap the list by a ListModelList
		listaConDatos.add(new Calidad("First Name One", "Last Name One", porcentajeSales,porcentajeSales));
		listaConDatos.add(new Calidad("First Name Two", "Last Name Two", porcentajeSales,porcentajeSales));
		listaConDatos.add(new Calidad("First Name Three", "Last Name Three", porcentajeSales,porcentajeSales));
		return new ListModelList(listaConDatos);
	}
}
