package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.BarcoCuba;

public class BarcoCubaListModelItemRenderer implements ListitemRenderer{

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(BarcoCubaListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		BarcoCuba co = (BarcoCuba) data;
		item.setValue(co);
		//CalidadRespuestaPreguntaBpmdesembarco respuesta = new CalidadRespuestaPreguntaBpmdesembarco();
		
		//respuesta.setCalidadPreguntaBpmdesembarco(co);
		
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdbarcocuba());
		}

		Listcell lc = new Listcell(co.getCuba().getNombrecuba());
		//lc.setTooltiptext(co.getCuba().getIdcuba().toString());
		lc.setTooltiptext(co.getIdbarcocuba().toString());
		lc.setParent(item);
		item.setAttribute("data", data);
	}
}
