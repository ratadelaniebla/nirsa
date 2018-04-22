package com.nw.webui.produccion.model;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.CalidadMuestraAreaDetalleMuestra;
//import com.nw.model.Proveedor;

public class PCC1BDetalleListModelItemRenderer implements ListitemRenderer{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(PCC1BDetalleListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		CalidadMuestraAreaDetalleMuestra co = (CalidadMuestraAreaDetalleMuestra) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdcalidadmuestraareadetallemuestra().toString());
		}

		Listcell lc;
		String d="",d1="",d2="";
		if(co.getNumerocaracteristicos()==null)
		{
			d=" ";
		}
		else
		{
			d=co.getNumerocaracteristicos().toString();
		}
		if(co.getNumeronocaracteristicos()==null)
		{
			d1=" ";
		}
		else
		{
			d1=co.getNumeronocaracteristicos().toString();
		}
		if(co.getNumerootros()==null)
		{
			d2=" ";
		}
		else
		{
			d2=co.getNumerootros().toString();
		}
		lc = new Listcell(d);
		lc.setParent(item);
		
		lc = new Listcell(d1);
		lc.setParent(item);
		
		lc = new Listcell(d2);
		lc.setParent(item);

		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}