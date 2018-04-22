package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;


import com.nw.model.Banda;

public class BandaListModelItemRenderer implements ListitemRenderer{

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(BandaListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		Banda co = (Banda) data;
				
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdbanda());
		}

		
		
//		lc.setTooltiptext(co.getIdvolqueta().toString());

		Listcell lc;
//		if (co.getIdbanda() != null)
		//{	
		//	lc = new Listcell(" ");
		//}
		//else
//		{
			lc = new Listcell(co.getDescripcionbanda());
//		}
				
		lc.setParent(item);
		item.setAttribute("data", data);
	}
	
}
