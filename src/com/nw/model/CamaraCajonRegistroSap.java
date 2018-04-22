package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the camara_cajon_registro_sap database table.
 * 
 */
@Entity
@Table(name="camara_cajon_registro_sap")
public class CamaraCajonRegistroSap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcajonregistro;

	private String calidadapariencia;

	private String calidadcontaminante;

	private String calidadolor;

	private Timestamp fechacreacion;

	private String idbarco;

	private String idcajon;

	private String idcuba;

	private String idcuba2;

	private String idmaterial;

	private String idmaterialanterior;

	private String idorigen;

	private String idtipocaptura;

	private String idviaje;

	private String lotecajonsap;

	private String lotecamara;

	private String lotehaccp;

	private String numregistro;

	private double pesobruto;

	private double pesoneto;

	private String proposito;

	private String referencia;

	private double tara;

	private String temperatura;

	private String ticket;

	private String zonafao;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="camaraCajonRegistroSap")
	private List<CamaraCajon> camaraCajons;

	public CamaraCajonRegistroSap() {
	}

	public Long getIdcajonregistro() {
		return this.idcajonregistro;
	}

	public void setIdcajonregistro(Long idcajonregistro) {
		this.idcajonregistro = idcajonregistro;
	}

	public String getCalidadapariencia() {
		return this.calidadapariencia;
	}

	public void setCalidadapariencia(String calidadapariencia) {
		this.calidadapariencia = calidadapariencia;
	}

	public String getCalidadcontaminante() {
		return this.calidadcontaminante;
	}

	public void setCalidadcontaminante(String calidadcontaminante) {
		this.calidadcontaminante = calidadcontaminante;
	}

	public String getCalidadolor() {
		return this.calidadolor;
	}

	public void setCalidadolor(String calidadolor) {
		this.calidadolor = calidadolor;
	}

	public Timestamp getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
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

	public String getIdcuba2() {
		return this.idcuba2;
	}

	public void setIdcuba2(String idcuba2) {
		this.idcuba2 = idcuba2;
	}

	public String getIdmaterial() {
		return this.idmaterial;
	}

	public void setIdmaterial(String idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getIdmaterialanterior() {
		return this.idmaterialanterior;
	}

	public void setIdmaterialanterior(String idmaterialanterior) {
		this.idmaterialanterior = idmaterialanterior;
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

	public String getLotecamara() {
		return this.lotecamara;
	}

	public void setLotecamara(String lotecamara) {
		this.lotecamara = lotecamara;
	}

	public String getLotehaccp() {
		return this.lotehaccp;
	}

	public void setLotehaccp(String lotehaccp) {
		this.lotehaccp = lotehaccp;
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

	public double getPesoneto() {
		return this.pesoneto;
	}

	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}

	public String getProposito() {
		return this.proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
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

	public String getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getZonafao() {
		return this.zonafao;
	}

	public void setZonafao(String zonafao) {
		this.zonafao = zonafao;
	}

	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

}