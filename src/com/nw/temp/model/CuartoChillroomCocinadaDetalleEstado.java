package com.nw.temp.model;


import com.nw.model.CuartoChillroomCocinadaDetalle;

 
public class CuartoChillroomCocinadaDetalleEstado {

	private CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle; 
	private boolean eliminar;
	
	
	
	public CuartoChillroomCocinadaDetalleEstado() {
	 
	}

	public CuartoChillroomCocinadaDetalleEstado(CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle, boolean eliminar) 
	{
	 this.setEliminar(eliminar);
	 this.setCuartoChillroomCocinadaDetalle(cuartoChillroomCocinadaDetalle);
	}



	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public CuartoChillroomCocinadaDetalle getCuartoChillroomCocinadaDetalle() {
		return cuartoChillroomCocinadaDetalle;
	}

	public void setCuartoChillroomCocinadaDetalle(
			CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle) {
		this.cuartoChillroomCocinadaDetalle = cuartoChillroomCocinadaDetalle;
	}

}
