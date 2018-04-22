package com.nw.temp.model;

import com.nw.model.RackeoProcesoEmpleado;

public class RackeoProcesoEmpleadoEstado {

	private RackeoProcesoEmpleado rackeoProcesoEmpleado;
	private boolean seleccionado;
	private boolean estado;
	
	public RackeoProcesoEmpleadoEstado() {
	}
	
	public RackeoProcesoEmpleadoEstado(RackeoProcesoEmpleado rackeoProcesoEmpleado ,
									  boolean seleccionado ,  boolean estado ) {
		this.rackeoProcesoEmpleado = rackeoProcesoEmpleado;
		this.seleccionado 		   = seleccionado;
		this.estado 			   = estado; 
	}

	public RackeoProcesoEmpleado getRackeoProcesoEmpleado() {
		return rackeoProcesoEmpleado;
	}

	public void setRackeoProcesoEmpleado(RackeoProcesoEmpleado rackeoProcesoEmpleado) {
		this.rackeoProcesoEmpleado = rackeoProcesoEmpleado;
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
