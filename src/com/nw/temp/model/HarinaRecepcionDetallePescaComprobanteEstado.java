package com.nw.temp.model;

import com.nw.model.HarinaRecepcionDetallePescaComprobante;

public class HarinaRecepcionDetallePescaComprobanteEstado  {


	private HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante;
	private boolean eliminar;

	
	public HarinaRecepcionDetallePescaComprobanteEstado() 
	{
	}
	
	
	public HarinaRecepcionDetallePescaComprobanteEstado(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante, boolean eliminar) 
	{

		this.setHarinaRecepcionDetallePescaComprobante(harinaRecepcionDetallePescaComprobante);
		this.setEliminar(eliminar);		
	}




	public boolean isEliminar() {
		return eliminar;
	}


	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}


	public HarinaRecepcionDetallePescaComprobante getHarinaRecepcionDetallePescaComprobante() {
		return harinaRecepcionDetallePescaComprobante;
	}


	public void setHarinaRecepcionDetallePescaComprobante(
			HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		this.harinaRecepcionDetallePescaComprobante = harinaRecepcionDetallePescaComprobante;
	}





}