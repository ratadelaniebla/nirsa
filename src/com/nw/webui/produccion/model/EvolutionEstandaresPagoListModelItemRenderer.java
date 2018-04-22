package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.EvolutionPlexusEstandarTarifa;

public class EvolutionEstandaresPagoListModelItemRenderer implements ListitemRenderer{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(EvolutionEstandaresPagoListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		EvolutionPlexusEstandarTarifa co = (EvolutionPlexusEstandarTarifa) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.toString());
		}

		Listcell lc;
		
		lc = new Listcell(co.getEvolutionPlexusEstandarParametro().getDescripcion());
		lc.setParent(item);
		
		lc = new Listcell(co.getTalla().getTallaKilos());
		lc.setParent(item);
		
		lc = new Listcell(co.getTalla().getNombre());
		lc.setParent(item);

		lc = new Listcell(co.getLimpiezaTipo().getDescripcion());
		lc.setParent(item);
		
		lc = new Listcell(String.valueOf(co.getPromedio()));
		lc.setParent(item);
		
		lc = new Listcell(String.valueOf(co.getCostoKg()));
		lc.setParent(item);
		
			
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}