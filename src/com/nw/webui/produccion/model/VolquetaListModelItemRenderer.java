package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.Volqueta;

public class VolquetaListModelItemRenderer implements ListitemRenderer{

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(VolquetaListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		Volqueta co = (Volqueta) data;
				
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdvolqueta());
		}

		
		
//		lc.setTooltiptext(co.getIdvolqueta().toString());

		Listcell lc;
		//		if (co.getDescripcionvolqueta() == null)
		//{	
		//	lc = new Listcell(" ");
		//}
		//else
		//{
			lc = new Listcell(co.getDescripcionvolqueta());
			//}
		
		lc.setParent(item);
		item.setAttribute("data", data);			
		
//		lc.setParent(item);
//		item.setAttribute("data", data);
	}
	
}
