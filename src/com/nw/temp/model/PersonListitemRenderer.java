package com.nw.temp.model;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Label;

import com.nw.temp.model.LoteTemp;


/**
 * Tested with ZK 6.0.2
 * @author benbai
 *
 */
//implements ListitemRenderer
public class PersonListitemRenderer implements ListitemRenderer, Serializable {
    /**
     * The method to implements of a renderer,
     * will be called by listbox automatically while render items
     */
	private static final long serialVersionUID = 1L;	  
	private static Log logger = LogFactory.getLog(PersonListitemRenderer.class);
	

	@Override
	public void render(final Listitem listitem, Object value) throws Exception {	

		LoteTemp lotetemp = (LoteTemp)value;
		
        listitem.setValue(value);
        
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + lotetemp.getFirstName());
		}        
        
        // create list headers while render first item
		// if (index == 0) {
		//   renderListheads(listitem.getListbox());
		// }
		
		
		Toolbarbutton btneliminar = new Toolbarbutton();
		
		btneliminar.addEventListener("onClick", new org.zkoss.zk.ui.event.EventListener(){
			public void onEvent(Event event){
						Listbox lbx = (Listbox)listitem.getParent();
						ListModelList lml1 = (ListModelList)lbx.getListModel();						
						lml1.remove(listitem.getIndex());
			}				
		});		
		
		Listcell lc = new Listcell ();
		Label lb = new Label(lotetemp.getFirstName());
		lb.setParent(lc);
		lc.setParent(listitem);
		
		btneliminar.setLabel("X");
		lc = new Listcell();		
		btneliminar.setParent(lc);
		lc.setParent(listitem);	

//		final Checkbox chkestado = new Checkbox();
//		chkestado.addEventListener("onCheck", new org.zkoss.zk.ui.event.EventListener(){
//			public void onEvent(Event event){
//
//			}
//		});		
//				
//		lc = new Listcell();		
//		chkestado.setParent(lc);
//		lc.setParent(listitem);	
		
		
		listitem.setAttribute("value", value);
}

//    private void renderListheads (Listbox listbox) {
//        Listhead lh = new Listhead();
//
//        new Listheader("First Name").setParent(lh);
//        lh.setParent(listbox);
//    }
}
