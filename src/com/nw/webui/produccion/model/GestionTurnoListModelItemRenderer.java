package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.GestionTurno;

public class GestionTurnoListModelItemRenderer implements ListitemRenderer{

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(GestionTurnoListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		GestionTurno co = (GestionTurno) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdgestionturno().toString());
		}

		Listcell lc;
		lc = new Listcell(co.getTurno().getIdturno().toString());
		lc.setParent(item);
		
		lc = new Listcell(co.getFechahoraincio().toString());
		lc.setParent(item);

		lc = new Listcell(co.getFechahorafin().toString());
		lc.setParent(item);

		lc = new Listcell(co.getObservacion());
		lc.setParent(item);		
		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}
