package com.nw.util;


import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.ListitemRenderer;

import com.nw.temp.model.Calidad;


public class ListBoxRenderizador implements ListitemRenderer {

 
	
	@Override
	public void render(Listitem listitem, Object value ) throws Exception {
	 
		 Calidad p = (Calidad)value;
	     
	        listitem.setValue(value);

	        addListcell(listitem, p.getMuestreo());
	        addListcell(listitem, p.getEspecieTalla());
	        //addListcell(listitem, p.getEspecieTalla());
	        
	        for (Double valorSal : p.getPorcentajeSales()) {
					addListcell(listitem, valorSal.toString());
			 }
	        
	        for (Double valorHis : p.getHistamina()) {
				addListcell(listitem, valorHis.toString());
		    }
	        
	       
	        
	       // renderListheads(listitem.getListbox());
		
	}
    
	
	
	private void addListcell (Listitem listitem, String value) {
        Listcell lc = new Listcell ();
        Label lb = new Label(value);
        lb.setParent(lc);
        lc.setParent(listitem);
    }
     
	
	public void renderListheads (Listbox listbox, int cantidadColumnaSal) {
        Listhead lh = new Listhead();

        //listbox.get
          lh.setWidth("10px");
          new Listheader("Muestreo").setParent(lh);
          new Listheader("Especie").setParent(lh);
        
        for (int i = 1; i <= cantidadColumnaSal; i++) {
        	lh.setWidth("30px");
        	new Listheader("Sal"+i).setParent(lh);
		}
        
        
        //new Listheader("Full Name").setParent(lh);

        lh.setParent(listbox);
    }
	
}
