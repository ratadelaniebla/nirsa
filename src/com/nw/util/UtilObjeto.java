package com.nw.util;

import com.nw.model.CantidadLibra;
import com.nw.model.LimpiezaTipo;
import com.nw.model.Luthy;
import com.nw.model.MaquinaCerradora;
import com.nw.model.OeeDefecto;
import com.nw.model.OeeParada;
import com.nw.model.Proceso;
import com.nw.model.Turno;
import com.nw.model.Talla;

public class UtilObjeto {

	
	public static String getPropiedad(String nombreObjeto , Object obj){
		String itemTexto = "";
		switch (nombreObjeto) {
		
		case "Turno":
			itemTexto = ((Turno) obj).getNombre();
			break;
		
		case "Talla":
			itemTexto = ((Talla) obj).getNombre();
			break;
			
		case "MaquinaCerradora":
			itemTexto = ((MaquinaCerradora) obj).getDescripcion();
			break;
			
		case "Proceso":
			 Proceso p = (Proceso) obj;
			 itemTexto = p.getDescripcionproceso();
			 break;
				
		case "Parada":
			OeeParada oeep = (OeeParada) obj;
			itemTexto = oeep.getDescripcionParada();
			break;
			
		case "CantidadLibra":
			CantidadLibra cl = (CantidadLibra) obj;
			itemTexto = cl.getDescripcion();	
			break;
		
		case "Luthy":
			Luthy luty = (Luthy) obj;
			itemTexto = String.valueOf(luty.getNumeroluthy()) ;		
			break;
			
		case "LimpiezaTipo":
			LimpiezaTipo limpiezaTipo = (LimpiezaTipo) obj;
			itemTexto = String.valueOf(limpiezaTipo.getDescripcion()) ;		
			break;
			
		case "OeeDefecto":
			OeeDefecto oeedefecto = (OeeDefecto) obj;
			itemTexto = oeedefecto.getDescripcionDefecto();
			break;
		
		default:
			itemTexto ="";
			break;
		}
		return itemTexto;
		
	}
	
}
