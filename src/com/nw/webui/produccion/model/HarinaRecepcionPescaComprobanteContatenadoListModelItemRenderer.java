package com.nw.webui.produccion.model;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import com.nw.model.HarinaRecepcionPescaComprobante;

public class HarinaRecepcionPescaComprobanteContatenadoListModelItemRenderer implements ListitemRenderer{

	//private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(HarinaRecepcionPescaComprobanteContatenadoListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {
				
//				
//		HarinaRecepcionPescaComprobante co1 = (HarinaRecepcionPescaComprobante) data;
//		item.setValue(co1);
//		Listcell lc1;
//		
//		lc1 = new Listcell();
//		lc1.setParent(item);		
//		
////		item.setAttribute("data", data);			
//		item.setValue(co1);		
//		
		
		
		
		HarinaRecepcionPescaComprobante co = (HarinaRecepcionPescaComprobante) data;
		item.setValue(co);
		
		Listcell lc;

		if (co.getIdharinarecepcionpescacomprobante()!=null)
		{
			
			if (logger.isDebugEnabled()) {
				logger.debug("--> " + co.getIdharinarecepcionpescacomprobante().toString());
			}
			
			String codid;
			codid = co.getIdharinarecepcionpescacomprobante().toString();
			
			String prov;
			prov = co.getProveedor().getApellidosProveedor()+" "+co.getProveedor().getNombresProveedor();
			
			String Estado;
			if (co.getEstado() == 1)
			{
				Estado = "Creado";
			}
			else
			{
				if (co.getEstado() == 2)
				{
					Estado = "Pesando";
				}
				else
				{
					if (co.getEstado() == 3)
					{
						Estado = "Cerrado";
					}
					else
					{
						//Estado 4
						Estado = "Anulado";
					}
				}
			}
	
			lc = new Listcell(codid +" "+ prov +" ("+Estado+")");
		}
		else
		{
			lc = new Listcell();
		}
		
		lc.setParent(item);		
		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}
