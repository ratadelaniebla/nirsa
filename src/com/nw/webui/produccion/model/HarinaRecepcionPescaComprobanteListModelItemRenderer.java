package com.nw.webui.produccion.model;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import com.nw.model.HarinaRecepcionPescaComprobante;

public class HarinaRecepcionPescaComprobanteListModelItemRenderer implements ListitemRenderer{

	//private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(HarinaRecepcionPescaComprobanteListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {
		
		HarinaRecepcionPescaComprobante co = (HarinaRecepcionPescaComprobante) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdharinarecepcionpescacomprobante().toString());
		}

		Listcell lc;
		lc = new Listcell(co.getIdharinarecepcionpescacomprobante().toString());
		lc.setParent(item);
		
		lc = new Listcell(co.getProveedor().getApellidosProveedor()+" "+co.getProveedor().getNombresProveedor());
		lc.setParent(item);

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

		
		lc = new Listcell(Estado);
		lc.setParent(item);		
		
//		lc = new Listcell(co.getCarro().getPlacaCarro());
//		lc.setParent(item);
		
		
		/*
		DecimalFormatSymbols dfs;
	      DecimalFormat df;

	      dfs = new DecimalFormatSymbols();
	    dfs.setDecimalSeparator('.');
	      df = new DecimalFormat("#0.0000",dfs);
		//txtValor1.setValue(df.format(tarifa.getValor()));
		lc = new Listcell(df.format(co.getValor()));
		lc.setParent(item);
		*/
		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}
