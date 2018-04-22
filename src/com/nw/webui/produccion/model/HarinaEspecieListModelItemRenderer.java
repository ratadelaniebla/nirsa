package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import com.nw.model.HarinaEspecie;

public class HarinaEspecieListModelItemRenderer implements ListitemRenderer{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(HarinaEspecieListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		HarinaEspecie co = (HarinaEspecie) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.toString());
		}

		Listcell lc;
		
		lc = new Listcell(co.getDescripcionespecie().toString());
		lc.setParent(item);
		
		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}