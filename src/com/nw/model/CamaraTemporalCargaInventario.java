package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the camara_temporal_carga_inventario database table.
 * 
 */
@Entity
@Table(name="camara_temporal_carga_inventario")
@NamedQuery(name="CamaraTemporalCargaInventario.findAll", query="SELECT c FROM CamaraTemporalCargaInventario c")
public class CamaraTemporalCargaInventario implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcamaratemporalinv;
	private String camara;
	private String columna;
	private String fila;
	private String idcajon;
	private String idmaterial;
	private String lotesap;
	private String nombrecuba;
	private double pesobruto;
	private double pesoneto;
	private String registro;
	private double tara;
	private String ticket;
	private String tipocaptura;

	public CamaraTemporalCargaInventario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcamaratemporalinv() {
		return this.idcamaratemporalinv;
	}

	public void setIdcamaratemporalinv(Integer idcamaratemporalinv) {
		this.idcamaratemporalinv = idcamaratemporalinv;
	}


	public String getCamara() {
		return this.camara;
	}

	public void setCamara(String camara) {
		this.camara = camara;
	}


	public String getColumna() {
		return this.columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}


	public String getFila() {
		return this.fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}


	public String getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(String idcajon) {
		this.idcajon = idcajon;
	}


	public String getIdmaterial() {
		return this.idmaterial;
	}

	public void setIdmaterial(String idmaterial) {
		this.idmaterial = idmaterial;
	}


	public String getLotesap() {
		return this.lotesap;
	}

	public void setLotesap(String lotesap) {
		this.lotesap = lotesap;
	}


	public String getNombrecuba() {
		return this.nombrecuba;
	}

	public void setNombrecuba(String nombrecuba) {
		this.nombrecuba = nombrecuba;
	}


	public double getPesobruto() {
		return this.pesobruto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}


	public double getPesoneto() {
		return this.pesoneto;
	}

	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}


	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}


	public String getTipocaptura() {
		return this.tipocaptura;
	}

	public void setTipocaptura(String tipocaptura) {
		this.tipocaptura = tipocaptura;
	}

}