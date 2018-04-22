package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_muestra_area_cabecera_analisis_protocolo database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_area_cabecera_analisis_protocolo")
public class CalidadMuestraAreaCabeceraAnalisisProtocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestraareacabeceraanalisisprotocolo;

	private Integer ccaracteristico;

	private Integer cnocaracteristico;

	private Timestamp fecharegistro;

	private Integer idcnocaracteristico;

	private Integer idonocaracteristico;

	private Integer idsnocaracteristico;

	private Integer npiezasproteinadegradada;

	private Integer ocaracteristico;

	private Integer onocaracteristico;

	private double pesopastoso;

	private double pesopiezaspastoso;

	private Integer scaracteristico;

	private Integer snocaracteristico;

	private Integer texturafirme;

	private Integer texturapastosa;

	private Integer texturasuave;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraareacabecera")
	private CalidadMuestraAreaCabecera calidadMuestraAreaCabecera;

	public CalidadMuestraAreaCabeceraAnalisisProtocolo() {
	}

	public Long getIdcalidadmuestraareacabeceraanalisisprotocolo() {
		return this.idcalidadmuestraareacabeceraanalisisprotocolo;
	}

	public void setIdcalidadmuestraareacabeceraanalisisprotocolo(Long idcalidadmuestraareacabeceraanalisisprotocolo) {
		this.idcalidadmuestraareacabeceraanalisisprotocolo = idcalidadmuestraareacabeceraanalisisprotocolo;
	}

	public Integer getCcaracteristico() {
		return this.ccaracteristico;
	}

	public void setCcaracteristico(Integer ccaracteristico) {
		this.ccaracteristico = ccaracteristico;
	}

	public Integer getCnocaracteristico() {
		return this.cnocaracteristico;
	}

	public void setCnocaracteristico(Integer cnocaracteristico) {
		this.cnocaracteristico = cnocaracteristico;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Integer getIdcnocaracteristico() {
		return this.idcnocaracteristico;
	}

	public void setIdcnocaracteristico(Integer idcnocaracteristico) {
		this.idcnocaracteristico = idcnocaracteristico;
	}

	public Integer getIdonocaracteristico() {
		return this.idonocaracteristico;
	}

	public void setIdonocaracteristico(Integer idonocaracteristico) {
		this.idonocaracteristico = idonocaracteristico;
	}

	public Integer getIdsnocaracteristico() {
		return this.idsnocaracteristico;
	}

	public void setIdsnocaracteristico(Integer idsnocaracteristico) {
		this.idsnocaracteristico = idsnocaracteristico;
	}

	public Integer getNpiezasproteinadegradada() {
		return this.npiezasproteinadegradada;
	}

	public void setNpiezasproteinadegradada(Integer npiezasproteinadegradada) {
		this.npiezasproteinadegradada = npiezasproteinadegradada;
	}

	public Integer getOcaracteristico() {
		return this.ocaracteristico;
	}

	public void setOcaracteristico(Integer ocaracteristico) {
		this.ocaracteristico = ocaracteristico;
	}

	public Integer getOnocaracteristico() {
		return this.onocaracteristico;
	}

	public void setOnocaracteristico(Integer onocaracteristico) {
		this.onocaracteristico = onocaracteristico;
	}

	public double getPesopastoso() {
		return this.pesopastoso;
	}

	public void setPesopastoso(double pesopastoso) {
		this.pesopastoso = pesopastoso;
	}

	public double getPesopiezaspastoso() {
		return this.pesopiezaspastoso;
	}

	public void setPesopiezaspastoso(double pesopiezaspastoso) {
		this.pesopiezaspastoso = pesopiezaspastoso;
	}

	public Integer getScaracteristico() {
		return this.scaracteristico;
	}

	public void setScaracteristico(Integer scaracteristico) {
		this.scaracteristico = scaracteristico;
	}

	public Integer getSnocaracteristico() {
		return this.snocaracteristico;
	}

	public void setSnocaracteristico(Integer snocaracteristico) {
		this.snocaracteristico = snocaracteristico;
	}

	public Integer getTexturafirme() {
		return this.texturafirme;
	}

	public void setTexturafirme(Integer texturafirme) {
		this.texturafirme = texturafirme;
	}

	public Integer getTexturapastosa() {
		return this.texturapastosa;
	}

	public void setTexturapastosa(Integer texturapastosa) {
		this.texturapastosa = texturapastosa;
	}

	public Integer getTexturasuave() {
		return this.texturasuave;
	}

	public void setTexturasuave(Integer texturasuave) {
		this.texturasuave = texturasuave;
	}

	public CalidadMuestraAreaCabecera getCalidadMuestraAreaCabecera() {
		return this.calidadMuestraAreaCabecera;
	}

	public void setCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		this.calidadMuestraAreaCabecera = calidadMuestraAreaCabecera;
	}

}