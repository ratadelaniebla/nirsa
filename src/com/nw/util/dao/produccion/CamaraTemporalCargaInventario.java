package com.nw.util.dao.produccion;

/**
 * Clase POJO usada en el proceso de actualización de los datos en la tabla camara_cajon por carga de inventario
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-02-14
 */
public class CamaraTemporalCargaInventario {

	private String camara;
	private String columna;
	private String fila;
	private String cajonId;
	private String cubaNombre;
	private String materialId;
	private String loteSap;
	private double pesobruto;
	private double pesoneto;
	private String registro;
	private double tara;
	private String ticket;
	private String tipoCaptura;
	
	public String getCamara() {
		return camara;
	}
	public void setCamara(String camara) {
		this.camara = camara;
	}
	public String getColumna() {
		return columna;
	}
	public void setColumna(String columna) {
		this.columna = columna;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}
	public String getCajonId() {
		return cajonId;
	}
	public void setCajonId(String cajonId) {
		this.cajonId = cajonId;
	}
	public String getCubaNombre() {
		return cubaNombre;
	}
	public void setCubaNombre(String cubaNombre) {
		this.cubaNombre = cubaNombre;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getLoteSap() {
		return loteSap;
	}
	public void setLoteSap(String loteSap) {
		this.loteSap = loteSap;
	}
	public double getPesobruto() {
		return pesobruto;
	}
	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}
	public double getPesoneto() {
		return pesoneto;
	}
	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public double getTara() {
		return tara;
	}
	public void setTara(double tara) {
		this.tara = tara;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getTipoCaptura() {
		return tipoCaptura;
	}
	public void setTipoCaptura(String tipoCaptura) {
		this.tipoCaptura = tipoCaptura;
	}

}
