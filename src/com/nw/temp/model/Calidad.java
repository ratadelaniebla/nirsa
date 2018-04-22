package com.nw.temp.model;

import java.util.ArrayList;
import java.util.List;

public class Calidad {

	private String muestreo;
	private String especieTalla;
	private List<Double> porcentajeSales = new ArrayList<Double>();
	private List<Double> histamina = new ArrayList<Double>();
	
	
	
	public Calidad() {
	 
	}
	
	public Calidad(String muestreo,String especieTalla,List<Double> porcentajeSales,List<Double> histamina ) {
	    this.muestreo = muestreo;
	    this.especieTalla = especieTalla;
	    this.porcentajeSales = porcentajeSales;
	    this.histamina=histamina;
	    
	}


	public List<Double> getPorcentajeSales() {
		return porcentajeSales;
	}


	public void setPorcentajeSales(List<Double> porcentajeSales) {
		this.porcentajeSales = porcentajeSales;
	}


	public String getMuestreo() {
		return muestreo;
	}


	public void setMuestreo(String muestreo) {
		this.muestreo = muestreo;
	}


	public String getEspecieTalla() {
		return especieTalla;
	}


	public void setEspecieTalla(String especieTalla) {
		this.especieTalla = especieTalla;
	}

	public List<Double> getHistamina() {
		return histamina;
	}

	public void setHistamina(List<Double> histamina) {
		this.histamina = histamina;
	}
	
}
