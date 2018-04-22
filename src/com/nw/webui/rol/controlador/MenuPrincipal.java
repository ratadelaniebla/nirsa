package com.nw.webui.rol.controlador;

import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.*;
import org.zkoss.zul.*;

import java.util.*;

//import com.nw.model.service.impl.WMServiceImpl;
import com.avante.core.webui.util.GFCBaseCtrl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.AreaMarco;
import com.nw.util.Controles;
import com.nw.util.Sistema;
/**
 * Menu principal de la aplicacion
 * @author haroldnav
 */
@SuppressWarnings("unchecked")
public class MenuPrincipal extends GFCBaseCtrl implements Controles{

	private static final long serialVersionUID = 1L;
	private Rows filas;
	public AreaMarco area;
	protected Window winMenPri;
	
	// ServiceDAOs / Domain Classes
	//private transient WMServiceImpl wmService;
	
	public void onCreate() throws InterruptedException {
		area = (AreaMarco)Sessions.getCurrent().getAttribute("areaMarco");
		winMenPri.setWidth(area.anchoInterno);
		filas.setStyle("color:blue;font-size:13px;font-weight:bold");
		
		
    	String usuarioId = (String)Sessions.getCurrent().getAttribute("usuario");
    	short grupoId = Sistema.parseShort((String)Sessions.getCurrent().getAttribute("grupo"));
    	
    	List opciones = new UsuarioDAOJpaImpl().getOpcionesAsignadas(usuarioId);
    	if (opciones.size()==0){
    		Sistema.mensaje("El usuario no tiene opciones asignadas");
    		Sistema.terminarSesion();
    	}else{
    		
	    	// Barrer la lista y asignar los iconos y el formulario a cada item del menu. 
	    	for(Iterator i=opciones.iterator(); i.hasNext(); ){
	    		final Object []lista = (Object[])i.next();
	    		
	    		Row fila = new Row();
		    	fila.setStyle("color:blue;font-size:13px;font-weight");
	    		
	    		Toolbarbutton itm = new Toolbarbutton(lista[0].toString());
	    		itm.setStyle("color:blue;font-size:13px;font-weight");
	    		
	    		// Asignar el formulario a ejecutar
	    		if ( lista[1] != null ) {
					final String formulario = lista[1].toString();
					final String titulo = lista[0].toString();
					itm.addEventListener("onClick", new org.zkoss.zk.ui.event.EventListener(){
						public void onEvent(Event event){
							//ejecutar(formulario);
							
							int ind = formulario.indexOf(',');
							if (ind>=0){
								Sessions.getCurrent().setAttribute("OPCION_REPORTE", formulario.substring(ind+1)); //de la coma, hacia la derecha
								final String forma = formulario.substring(0, ind); //de la coma, hacia la izquierda
								Sessions.getCurrent().setAttribute("TITULO_REPORTE", titulo);
								Sistema.ejecutar(forma);
							}else Sistema.ejecutar(formulario);
						}
					});
				}

	    		itm.setParent(fila);
	    		fila.setParent(filas);
	    	}
    	}
	}

	public void enviar() {}
	public void limpiarControles() {}
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	// ++++++++++++++++++ getter / setter +++++++++++++++++++//
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	

}
