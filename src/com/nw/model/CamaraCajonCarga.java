package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the camara_cajon_carga database table.
 * 
 */
@Entity
@Table(name="camara_cajon_carga")
public class CamaraCajonCarga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcamaracajoncarga;

	private String columna;

	@Column(name="descripcion_material")
	private String descripcionMaterial;

	private Timestamp fechacreacion;

	private Timestamp fechareg;

	private Integer fila;

	private String idbarco;

	private String idcajon;

	private String idcuba;

	private String idmaterial;

	private String idorigen;

	private String idtipocaptura;

	private String idviaje;

	private String lotecajonsap;

	private String numregistro;

	private double pesobruto;

	private double pesolibreutilizacion;

	private double pesoneto;

	private String referencia;

	private double tara;

	private String ticket;

	@Column(name="ubicacion_camara")
	private Integer ubicacionCamara;

	private String usuario;

	private String zonafao;

	public CamaraCajonCarga() {
	}

	public Long getIdcamaracajoncarga() {
		return this.idcamaracajoncarga;
	}

	public void setIdcamaracajoncarga(Long idcamaracajoncarga) {
		this.idcamaracajoncarga = idcamaracajoncarga;
	}

	public String getColumna() {
		return this.columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public String getDescripcionMaterial() {
		return this.descripcionMaterial;
	}

	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}

	public Timestamp getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getFila() {
		return this.fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public String getIdbarco() {
		return this.idbarco;
	}

	public void setIdbarco(String idbarco) {
		this.idbarco = idbarco;
	}

	public String getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(String idcajon) {
		this.idcajon = idcajon;
	}

	public String getIdcuba() {
		return this.idcuba;
	}

	public void setIdcuba(String idcuba) {
		this.idcuba = idcuba;
	}

	public String getIdmaterial() {
		return this.idmaterial;
	}

	public void setIdmaterial(String idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getIdorigen() {
		return this.idorigen;
	}

	public void setIdorigen(String idorigen) {
		this.idorigen = idorigen;
	}

	public String getIdtipocaptura() {
		return this.idtipocaptura;
	}

	public void setIdtipocaptura(String idtipocaptura) {
		this.idtipocaptura = idtipocaptura;
	}

	public String getIdviaje() {
		return this.idviaje;
	}

	public void setIdviaje(String idviaje) {
		this.idviaje = idviaje;
	}

	public String getLotecajonsap() {
		return this.lotecajonsap;
	}

	public void setLotecajonsap(String lotecajonsap) {
		this.lotecajonsap = lotecajonsap;
	}

	public String getNumregistro() {
		return this.numregistro;
	}

	public void setNumregistro(String numregistro) {
		this.numregistro = numregistro;
	}

	public double getPesobruto() {
		return this.pesobruto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public double getPesolibreutilizacion() {
		return this.pesolibreutilizacion;
	}

	public void setPesolibreutilizacion(double pesolibreutilizacion) {
		this.pesolibreutilizacion = pesolibreutilizacion;
	}

	public double getPesoneto() {
		return this.pesoneto;
	}

	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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

	public Integer getUbicacionCamara() {
		return this.ubicacionCamara;
	}

	public void setUbicacionCamara(Integer ubicacionCamara) {
		this.ubicacionCamara = ubicacionCamara;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getZonafao() {
		return this.zonafao;
	}

	public void setZonafao(String zonafao) {
		this.zonafao = zonafao;
	}

}