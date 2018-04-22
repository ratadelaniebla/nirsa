package com.nw.temp.model;

import com.nw.model.CamaraCajon;


public class MuestreoEstado {

	
	
	private Long idcalidadpcc;
	private Long idbarcoestibacuba;
	private Integer idespecietalla;
	private String info;
	private Long cantmuestras;	
	private String lotecamara;
	private Integer nummuestreo;
	
	private boolean estado;
	private boolean eliminar;

	
	
	public MuestreoEstado() 
	{
	}	
	
	
	public MuestreoEstado(Long idcalidadpcc, Long idbarcoestibacuba, Integer idespecietalla, String info, Long cantmuestras ,String lotecamara, Integer nummuestreo,boolean estado , boolean eliminar) 
	{
	 this.idcalidadpcc = idcalidadpcc;
	 this.idbarcoestibacuba = idbarcoestibacuba;
	 this.idespecietalla = idespecietalla;
	 this.info = info;
	 this.cantmuestras = cantmuestras;
	 this.lotecamara = lotecamara;	 
	 this.nummuestreo = nummuestreo;
	 this.estado = estado;
	 this.eliminar = eliminar;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}


	public Long getIdcalidadpcc() {
		return idcalidadpcc;
	}


	public void setIdcalidadpcc(Long idcalidadpcc) {
		this.idcalidadpcc = idcalidadpcc;
	}


	public Long getIdbarcoestibacuba() {
		return idbarcoestibacuba;
	}


	public void setIdbarcoestibacuba(Long idbarcoestibacuba) {
		this.idbarcoestibacuba = idbarcoestibacuba;
	}


	public Integer getIdespecietalla() {
		return idespecietalla;
	}


	public void setIdespecietalla(Integer idespecietalla) {
		this.idespecietalla = idespecietalla;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public Long getCantmuestras() {
		return cantmuestras;
	}


	public void setCantmuestras(Long cantmuestras) {
		this.cantmuestras = cantmuestras;
	}


	public String getLotecamara() {
		return lotecamara;
	}


	public void setLotecamara(String lotecamara) {
		this.lotecamara = lotecamara;
	}


	public Integer getNummuestreo() {
		return nummuestreo;
	}


	public void setNummuestreo(Integer nummuestreo) {
		this.nummuestreo = nummuestreo;
	}








	
	
	
	
}
