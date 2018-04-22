package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.nw.model.Cuba;

public class CubaListModelItemRenderer implements ListitemRenderer{

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(CubaListModelItemRenderer.class);

	@Override
	public void render(Listitem item, Object data) throws Exception {

		Cuba co = (Cuba) data;
		
		//CalidadRespuestaPreguntaBpmdesembarco respuesta = new CalidadRespuestaPreguntaBpmdesembarco();
		
		//respuesta.setCalidadPreguntaBpmdesembarco(co);
		
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.getIdcuba());
		}

//		
//		final Checkbox chkestado = new Checkbox();
//		chkestado.addEventListener("onCheck", new org.zkoss.zk.ui.event.EventListener(){
//			public void onEvent(Event event){
//
//				//Verificamos el estado del objeto para ir seteando el campo
//				if(co.get.get.getEstado() == null)
//				{
//					uniformeestudiante.setEstado("S");
//				}
//				else
//				{
//					if(chkestado.isChecked() == true)
//					{
//						uniformeestudiante.setEstado("N");
//					}
//					else
//					{
//						uniformeestudiante.setEstado("S");
//					}
//					
//			}
//			}
//		});				
//		
		Listcell lc = new Listcell(co.getNombrecuba());
		lc.setParent(item);

		lc = new Listcell(co.getIdcuba().toString());
		lc.setParent(item);		
		
		item.setAttribute("data", data);
	}

	
	
}
