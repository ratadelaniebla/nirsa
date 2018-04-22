package com.nw.temp.model;


import com.nw.model.RociadoCocinadaDetalle;
 
public class RociadoCocinadaDetalleEstado {

	private RociadoCocinadaDetalle rociadoCocinadaDetalle; 
	private boolean eliminar;
	
	
	
	public RociadoCocinadaDetalleEstado() {
	 
	}

	public RociadoCocinadaDetalleEstado(RociadoCocinadaDetalle rociadoCocinadaDetalle, boolean eliminar) 
	{
	 this.setEliminar(eliminar);
	 this.setRociadoCocinadaDetalle(rociadoCocinadaDetalle);
	}



	public RociadoCocinadaDetalle getRociadoCocinadaDetalle() {
		return rociadoCocinadaDetalle;
	}

	public void setRociadoCocinadaDetalle(RociadoCocinadaDetalle rociadoCocinadaDetalle) {
		this.rociadoCocinadaDetalle = rociadoCocinadaDetalle;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}
	


}
