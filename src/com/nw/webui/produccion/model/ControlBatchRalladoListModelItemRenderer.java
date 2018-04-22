package com.nw.webui.produccion.model;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Style;


public class ControlBatchRalladoListModelItemRenderer implements ListitemRenderer{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(ControlBatchRalladoListModelItemRenderer.class);

	public void render(Listitem item, Object data ) throws Exception {

		@SuppressWarnings("unchecked")
		Object[] co =  (Object[]) data;
		item.setValue(co);
		
		
		Listcell lc;
		
			lc = new Listcell( co[6].toString());
			lc.setHeight("40px");
		
			lc.setParent(item);
			lc.setStyle("border-width=1px;border-color:black");
			
			lc = new Listcell(co[7].toString());
			lc.setStyle("border-width=1px;border-color:black");
			
			
			lc.setParent(item);
			lc = new Listcell(co[3].toString());
			lc.setStyle("border-width=1px;border-color:black");
			
			
			lc.setParent(item);
			lc = new Listcell(co[2].toString());
			lc.setStyle("border-width=1px;border-color:black");
			
			
			lc.setParent(item);
			lc = new Listcell(co[4].toString());
			lc.setStyle("border-width=1px;border-color:black");
			
			lc.setParent(item);
			lc = new Listcell(co[4].toString());
			lc.setStyle("border-width=1px;border-color:black");
			lc.setParent(item);
			
			lc = new Listcell(co[5].toString());
			lc.setStyle("border-width=1px;border-color:black");
			lc.setParent(item);
			
			String estado="",color="";
			
			System.out.println("12:"+co[12]);
				
			String pcc4_alarma, pcc4_caida,pcc5_alarma,pcc5_caida;
			pcc4_alarma=(String) co[9];
			pcc4_caida=(String) co[11];
			pcc5_alarma=(String) co[13];
			pcc5_caida=(String) co[15];
			
			/*c2final=Double.valueOf(co[11].toString());
			c2alarma=Double.valueOf(co[10].toString());
			*/
			estado="OK";
			color="green";
			if(pcc4_alarma.equals("SI"))
			{
				estado="ALARMA (PCC4)";
				color="yellow";
			}
			if(pcc4_caida.equals("SI"))
			{
				estado="Excedido (PCC4)";
				color="orange";
			}
			if(pcc5_alarma.equals("SI"))
				{
				estado="ALARMA (PCC5)";
				color="yellow";
			}
			if(pcc5_caida.equals("SI"))
				{
				estado="Excedido (PCC5)";
				color="orange";
			}
			
			if(pcc4_alarma.equals("SI") && pcc5_alarma.equals("SI"))
			{
				estado="ALARMA (PCC4 PCC5)";
				color="yellow";
			}
			if(pcc4_caida.equals("SI") && pcc5_caida.equals("SI"))
			{
				estado="Excedido (PCC4 PCC5)";
				color="orange";
			}
			
			lc = new Listcell(estado);
			//lc.setStyle("border-width=1px;border-color:black");
			lc.setStyle("text-align:center;background-color:"+color+";border-width=1px;border-color:black");
			lc.setParent(item);
		item.setAttribute("data", data);
		item.setValue(co);
	}

	
}