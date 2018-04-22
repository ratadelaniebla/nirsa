package com.nw.temp.model;


import com.nw.model.HarinaClasificacionTipoPesca;
import com.nw.model.HarinaDetalleEspeceRecepcionDetallePescaComprobante;
import com.nw.model.HarinaEspecie;
import com.nw.model.HarinaRecepcionDetallePescaComprobante;
import com.nw.model.HarinaRecepcionPescaComprobante;
 
public class HarinaEspecieDetalleEstado {

	private HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante;
	private HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante;	
	private HarinaDetalleEspeceRecepcionDetallePescaComprobante harinaDetalleEspeceRecepcionDetallePescaComprobante;
	private HarinaEspecie harinaEspecie;
	private HarinaClasificacionTipoPesca harinaClasificacionTipoPesca;
	private boolean eliminar;
	
	public HarinaEspecieDetalleEstado() {
	 
	}

	public HarinaEspecieDetalleEstado(HarinaRecepcionPescaComprobante harinarpdc, HarinaEspecie harinaEspecie, boolean eliminar,HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante, HarinaDetalleEspeceRecepcionDetallePescaComprobante harinaDetalleEspeceRecepcionDetallePescaComprobante, HarinaClasificacionTipoPesca hClasificacionTipoPesca) 
	{
	 this.setHarinaRecepcionPescaComprobante(harinarpdc);
	 this.setHarinaRecepcionDetallePescaComprobante(harinaRecepcionDetallePescaComprobante);
	 this.setHarinaDetalleEspeceRecepcionDetallePescaComprobante(harinaDetalleEspeceRecepcionDetallePescaComprobante);
	 this.setHarinaClasificacionTipoPesca(hClasificacionTipoPesca);
	 this.setHarinaEspecie(harinaEspecie);
	 this.setEliminar(eliminar);
	}



	public HarinaEspecie getHarinaEspecie() {
		return harinaEspecie;
	}

	public void setHarinaEspecie(HarinaEspecie harinaEspecie) {
		this.harinaEspecie = harinaEspecie;
	}

	
	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public HarinaRecepcionPescaComprobante getHarinaRecepcionPescaComprobante() {
		return harinaRecepcionPescaComprobante;
	}

	public void setHarinaRecepcionPescaComprobante(
			HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		this.harinaRecepcionPescaComprobante = harinaRecepcionPescaComprobante;
	}

	public HarinaRecepcionDetallePescaComprobante getHarinaRecepcionDetallePescaComprobante() {
		return harinaRecepcionDetallePescaComprobante;
	}

	public void setHarinaRecepcionDetallePescaComprobante(
			HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		this.harinaRecepcionDetallePescaComprobante = harinaRecepcionDetallePescaComprobante;
	}

	public HarinaDetalleEspeceRecepcionDetallePescaComprobante getHarinaDetalleEspeceRecepcionDetallePescaComprobante() {
		return harinaDetalleEspeceRecepcionDetallePescaComprobante;
	}

	public void setHarinaDetalleEspeceRecepcionDetallePescaComprobante(
			HarinaDetalleEspeceRecepcionDetallePescaComprobante harinaDetalleEspeceRecepcionDetallePescaComprobante) {
		this.harinaDetalleEspeceRecepcionDetallePescaComprobante = harinaDetalleEspeceRecepcionDetallePescaComprobante;
	}

	public HarinaClasificacionTipoPesca getHarinaClasificacionTipoPesca() {
		return harinaClasificacionTipoPesca;
	}

	public void setHarinaClasificacionTipoPesca(
			HarinaClasificacionTipoPesca harinaClasificacionTipoPesca) {
		this.harinaClasificacionTipoPesca = harinaClasificacionTipoPesca;
	}
	


}
