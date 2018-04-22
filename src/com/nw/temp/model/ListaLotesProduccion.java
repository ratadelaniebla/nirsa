package com.nw.temp.model;

import com.nw.model.Empleado;
import com.nw.model.LimpiezaLineaGrupo;

public class ListaLotesProduccion 
{

	

	private Integer lote;
	private Integer total;
	private Integer ingresado;
	private Integer pendiente;
	private String estado;

	public ListaLotesProduccion() {
	}

	public ListaLotesProduccion(Integer lote, Integer total, Integer ingresado, Integer pendiente, String estado) 
	{
		this.setLote(lote);
		this.setTotal(total);
		this.setIngresado(ingresado);
		this.setPendiente(pendiente);
		this.setEstado(estado);
	}

	public Integer getLote() {
		return lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getIngresado() {
		return ingresado;
	}

	public void setIngresado(Integer ingresado) {
		this.ingresado = ingresado;
	}

	public Integer getPendiente() {
		return pendiente;
	}

	public void setPendiente(Integer pendiente) {
		this.pendiente = pendiente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
