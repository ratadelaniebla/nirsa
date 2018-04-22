package com.nw.webui.produccion.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zul.Decimalbox;
//import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;
//import com.nw.model.HarinaEspecie;
import com.nw.temp.model.CalidadMuestraAreaDetalleEstado;

public class CalidadMuestraAreaDetalleEstadoListModelItemRenderer implements ListitemRenderer{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(CalidadMuestraAreaDetalleEstadoListModelItemRenderer.class);
//	String color_cldhoras = "background-color:#A9BCF5; color: black;";
//	String color_cldeficiencias = "background-color:#FFFF00; color: black;";
	String color_cldhoras = "";
	String color_cldeficiencias = "";
	
	String estilo;
	int control = 0;
	int controlindividual = 0;
	int pintar = 1;
//	private Textbox txtOrden;
//	private Textbox txtCi;
//	private Textbox txtCg;
//	private Textbox txtCg;
	
	@Override
	public void render(Listitem item, Object data) throws Exception {

		CalidadMuestraAreaDetalleEstado co = (CalidadMuestraAreaDetalleEstado) data;
		item.setValue(co);
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + co.toString());
		}

		controlindividual ++; 

		Label label;
		//Textbox txtC;
		label = new Label(); 		
		label.setValue(co.getCalidadMuestraAreaDetalle().getOrdenregistro().toString());
		//.setReadonly(true);
		
		//Si son compositas de 1 o menores (0 para casos de protocolo por sal)
		if (co.getCompositas() <= 1)
		{
			color_cldhoras = "";
			color_cldeficiencias = "";			
		}
		else
		{
			//Valida si en contador llego al tope de las individuales para empezar a pintar los grupos
			if (controlindividual > co.getPescadosindividual())
			{
				color_cldhoras = "background-color:#A9BCF5; color: black;";
				color_cldeficiencias = "background-color:#FFFF00; color: black;";

				control ++;


				if (control <= co.getCompositas())
				{
					//txtC.setStyle(color_cldhoras);
					estilo = color_cldhoras;
				}
				else
				{
					//txtC.setStyle(color_cldeficiencias);
					estilo = color_cldeficiencias;
				}

				if (control == co.getCompositas() * 2)
				{
					control = 0;
				}
				
			}
			else
			{
				//Mantiene sin pintar los grupos para el caso de la individuales por olor no caracteristico (hasta llegar a su base y comenzar con las grupales)
				color_cldhoras = "";
				color_cldeficiencias = "";			
			}
			
		}
			

		

		
		
		Listcell lc;		
		lc = new Listcell();
		label.setStyle(estilo);
		label.setParent(lc);	
		lc.setStyle(estilo);
		lc.setParent(item);

		Decimalbox decimalbox;
		//Intbox intbox;
		Textbox txtC;
		
//		txtC = new Textbox(); 		
//		txtC.setText(co.getCalidadMuestraAreaDetalle().getOrdenregistro().toString());
		
		decimalbox = new Decimalbox();
		decimalbox.setFormat(".##");
		
		System.out.println(co.getCalidadMuestraAreaDetalle().getHistaminaporgrupo());
		
		if (co.getCalidadMuestraAreaDetalle().getHistaminaporgrupo() == 0.0)
		{
			decimalbox.setRawValue(null);			
		}
		else
		{
			decimalbox.setRawValue(co.getCalidadMuestraAreaDetalle().getHistaminaporgrupo());
		}
		
		decimalbox.setStyle(estilo);
		lc = new Listcell();

		
		if (controlindividual <= co.getPescadosindividual() || co.getCompositas() <= 1)
		{
			decimalbox.setRawValue(null);
			decimalbox.setReadonly(true);
			decimalbox.setVisible(false);
		}
		
		decimalbox.setParent(lc);
		lc.setStyle(estilo);
		lc.setParent(item);
		

		decimalbox = new Decimalbox();
		decimalbox.setFormat(".##");
		System.out.println(co.getCalidadMuestraAreaDetalle().getHistaminaporgrupo());
		
		if (co.getCalidadMuestraAreaDetalle().getHistaminaindividual() == 0.0)
		{
			decimalbox.setRawValue(null);			
		}
		else
		{
			decimalbox.setRawValue(co.getCalidadMuestraAreaDetalle().getHistaminaindividual());
		}
		decimalbox.setStyle(estilo);
		lc = new Listcell();
		decimalbox.setParent(lc);
		lc.setStyle(estilo);
		lc.setParent(item);
		

		txtC = new Textbox(); 		
		txtC.setText(co.getCalidadMuestraAreaDetalle().getComentario());
		txtC.setWidth("99%");
		//lc = new Listcell(co.getDescripcionespecie().toString());		
		lc = new Listcell();
		txtC.setStyle(estilo);
		txtC.setParent(lc);
		lc.setStyle(estilo);
		lc.setParent(item);
		item.setFocus(true);
		
		
		
		item.setAttribute("data", data);			
		item.setValue(co);
	}	
}