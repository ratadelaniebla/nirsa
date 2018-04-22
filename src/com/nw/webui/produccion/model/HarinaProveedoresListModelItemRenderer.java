package com.nw.webui.produccion.model;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.Proveedor;

public class HarinaProveedoresListModelItemRenderer implements ListitemRenderer{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(HarinaProveedoresListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		Proveedor co = (Proveedor) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdproveedor().toString());
		}

		Listcell lc;
		
		lc = new Listcell(co.getCedulaProveedor().toString());
		lc.setParent(item);
		
		lc = new Listcell(co.getNombresProveedor().toString());
		lc.setParent(item);
		
		lc = new Listcell(co.getApellidosProveedor().toString());
		lc.setParent(item);

		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}