package com.nw.temp.model;

import com.nw.model.LonjasProcesoEmpleado;

public class LonjasProcesoEmpleadoEstado {

	private LonjasProcesoEmpleado lonjasProcesoEmpleado;
	private boolean seleccionado;
	private boolean estado;
	
	public LonjasProcesoEmpleadoEstado() {
	}
	
	public LonjasProcesoEmpleadoEstado(LonjasProcesoEmpleado lonjasProcesoEmpleado ,
									  boolean seleccionado ,  boolean estado ) {
		this.lonjasProcesoEmpleado = lonjasProcesoEmpleado;
		this.seleccionado 		   = seleccionado;
		this.estado 			   = estado; 
	}

	public LonjasProcesoEmpleado getLonjasProcesoEmpleado() {
		return lonjasProcesoEmpleado;
	}

	public void setLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		this.lonjasProcesoEmpleado = lonjasProcesoEmpleado;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
