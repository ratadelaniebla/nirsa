package com.nw.temp.model;

import com.nw.model.HarinaComprobanteDetalleGrupoEspecie;
import com.nw.model.HarinaEspecie;
import com.nw.model.HarinaGrupo;


public class HarinaComprobanteDetalleGrupoEspecieEstado  {


	private HarinaComprobanteDetalleGrupoEspecie harinaComprobanteDetalleGrupoEspecie;
	private HarinaEspecie harinaEspecie;
	private HarinaGrupo harinaGrupo;
	private Integer numerogabetas;
	private Double porcentaje;
	private boolean eliminar;

	
	public HarinaComprobanteDetalleGrupoEspecieEstado() 
	{
	}
	
	
	public HarinaComprobanteDetalleGrupoEspecieEstado(HarinaComprobanteDetalleGrupoEspecie harinaComprobanteDetalleGrupoEspecie, HarinaEspecie harinaEspecie, HarinaGrupo harinaGrupo, Integer numerogabetas, boolean eliminar, Double porcentaje) 
	{

		this.setHarinaComprobanteDetalleGrupoEspecie(harinaComprobanteDetalleGrupoEspecie);
		this.setHarinaEspecie(harinaEspecie);
		this.setHarinaGrupo(harinaGrupo);
		this.setNumerogabetas(numerogabetas);
		this.setPorcentaje(porcentaje);
		this.setEliminar(eliminar);		
	}




	public boolean isEliminar() {
		return eliminar;
	}


	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}


	public HarinaComprobanteDetalleGrupoEspecie getHarinaComprobanteDetalleGrupoEspecie() {
		return harinaComprobanteDetalleGrupoEspecie;
	}


	public void setHarinaComprobanteDetalleGrupoEspecie(
			HarinaComprobanteDetalleGrupoEspecie harinaComprobanteDetalleGrupoEspecie) {
		this.harinaComprobanteDetalleGrupoEspecie = harinaComprobanteDetalleGrupoEspecie;
	}


	public HarinaEspecie getHarinaEspecie() {
		return harinaEspecie;
	}


	public void setHarinaEspecie(HarinaEspecie harinaEspecie) {
		this.harinaEspecie = harinaEspecie;
	}


	public HarinaGrupo getHarinaGrupo() {
		return harinaGrupo;
	}


	public void setHarinaGrupo(HarinaGrupo harinaGrupo) {
		this.harinaGrupo = harinaGrupo;
	}


	public Integer getNumerogabetas() {
		return numerogabetas;
	}


	public void setNumerogabetas(Integer numerogabetas) {
		this.numerogabetas = numerogabetas;
	}


	public Double getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}


}