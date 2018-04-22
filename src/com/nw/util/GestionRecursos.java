package com.nw.util;

import org.zkoss.zul.Window;


/**
 * Parametros Gestion de Ingreso de Recursos por Proceso 
 * @author haroldnav
 */
@SuppressWarnings("unchecked")
public interface GestionRecursos {

	public void doNuevoRecurso(Window window) throws InterruptedException;
	
	public void doLimpiarRecurso(Window window);

	public void doLimpiarRecurso();

	public void doNuevoRecurso() throws InterruptedException;

}
