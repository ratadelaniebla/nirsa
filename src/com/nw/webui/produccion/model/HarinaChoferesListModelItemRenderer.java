package com.nw.webui.produccion.model;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.Chofer;

public class HarinaChoferesListModelItemRenderer implements ListitemRenderer{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(HarinaChoferesListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		Chofer co = (Chofer) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdchofer().toString());
		}

		Listcell lc;
		
		lc = new Listcell(co.getCedulaChofer().toString());
		lc.setParent(item);
		
		lc = new Listcell(co.getNombresChofer().toString());
		lc.setParent(item);
		
		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}