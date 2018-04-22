package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.EvolutionPlexusEstandarParametro;

public class EvolutionPlexusEstandaresListModelItemRenderer implements ListitemRenderer{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(EvolutionPlexusEstandaresListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		EvolutionPlexusEstandarParametro co = (EvolutionPlexusEstandarParametro) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.toString());
		}

		Listcell lc;
		
		lc = new Listcell(co.getDescripcion().toString());
		lc.setParent(item);
		
		lc = new Listcell(String.valueOf(co.getValor()));
		lc.setParent(item);
		
		
		String estado="OK";
		if(co.getEstado()==1)
		{
			estado="OK";
		}
		else
		{
			estado="NO";
		}
		lc = new Listcell(estado);
		lc.setParent(item);
		
		lc = new Listcell(String.valueOf(co.getIncremento()));
		lc.setParent(item);
		
		lc = new Listcell(String.valueOf(co.getDesde()));
		lc.setParent(item);
		
		lc = new Listcell(String.valueOf(co.getHasta()));
		lc.setParent(item);
		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}