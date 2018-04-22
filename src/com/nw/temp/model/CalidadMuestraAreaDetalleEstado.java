package com.nw.temp.model;

import  com.nw.model.CalidadMuestraAreaDetalle;
 

public class CalidadMuestraAreaDetalleEstado 
{

	private CalidadMuestraAreaDetalle CalidadMuestraAreaDetalle;
	private Integer compositas;
	private Integer pescadosindividual;

	public CalidadMuestraAreaDetalleEstado(CalidadMuestraAreaDetalle CalidadMuestraAreaDetalle, Integer compositas, Integer pescadosindividual) 
	{
		this.setCalidadMuestraAreaDetalle(CalidadMuestraAreaDetalle);
		this.compositas = compositas;
		this.pescadosindividual = pescadosindividual;
	}

	public CalidadMuestraAreaDetalle getCalidadMuestraAreaDetalle() {
		return CalidadMuestraAreaDetalle;
	}

	public void setCalidadMuestraAreaDetalle(CalidadMuestraAreaDetalle calidadMuestraAreaDetalle) {
		CalidadMuestraAreaDetalle = calidadMuestraAreaDetalle;
	}

	public Integer getCompositas() {
		return compositas;
	}

	public void setCompositas(Integer compositas) {
		this.compositas = compositas;
	}

	public Integer getPescadosindividual() {
		return pescadosindividual;
	}

	public void setPescadosindividual(Integer pescadosindividual) {
		this.pescadosindividual = pescadosindividual;
	}





}
