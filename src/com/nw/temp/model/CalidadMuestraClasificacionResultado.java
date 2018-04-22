package com.nw.temp.model;

public class CalidadMuestraClasificacionResultado {

	private String 	lotehaccp;
	private String 	especieqm;
	private Integer peso;
	private Integer	muestra    ;
	private Integer  valor;
	private String  resultado ;
	
	public CalidadMuestraClasificacionResultado() {
	}

	public String getLotehaccp() {
		return lotehaccp;
	}

	public void setLotehaccp(String lotehaccp) {
		this.lotehaccp = lotehaccp;
	}

	public String getEspecieqm() {
		return especieqm;
	}

	public void setEspecieqm(String especieqm) {
		this.especieqm = especieqm;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getMuestra() {
		return muestra;
	}

	public void setMuestra(Integer muestra) {
		this.muestra = muestra;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
