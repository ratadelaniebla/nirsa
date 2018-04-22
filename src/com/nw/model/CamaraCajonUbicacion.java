package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the camara_cajon_ubicacion database table.
 * 
 */
@Entity
@Table(name="camara_cajon_ubicacion")
public class CamaraCajonUbicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcamaracajonubicacion;

	private String columnapasillo;

	private Timestamp fechareg;

	private Integer idmovimiento;

	private String idusuario;

	private String ladopasillo;

	private String observaciones;

	//bi-directional many-to-one association to Camara
	@ManyToOne
	@JoinColumn(name="idcamara")
	private Camara camara;

	//bi-directional many-to-one association to CamaraArea
	@ManyToOne
	@JoinColumn(name="idcamaraarea")
	private CamaraArea camaraArea;

	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	private CamaraCajon camaraCajon;

	//bi-directional many-to-one association to CamaraFilaColumna
	@ManyToOne
	@JoinColumn(name="idfilacolumna")
	private CamaraFilaColumna camaraFilaColumna;

	public CamaraCajonUbicacion() {
	}

	public Long getIdcamaracajonubicacion() {
		return this.idcamaracajonubicacion;
	}

	public void setIdcamaracajonubicacion(Long idcamaracajonubicacion) {
		this.idcamaracajonubicacion = idcamaracajonubicacion;
	}

	public String getColumnapasillo() {
		return this.columnapasillo;
	}

	public void setColumnapasillo(String columnapasillo) {
		this.columnapasillo = columnapasillo;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getIdmovimiento() {
		return this.idmovimiento;
	}

	public void setIdmovimiento(Integer idmovimiento) {
		this.idmovimiento = idmovimiento;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getLadopasillo() {
		return this.ladopasillo;
	}

	public void setLadopasillo(String ladopasillo) {
		this.ladopasillo = ladopasillo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Camara getCamara() {
		return this.camara;
	}

	public void setCamara(Camara camara) {
		this.camara = camara;
	}

	public CamaraArea getCamaraArea() {
		return this.camaraArea;
	}

	public void setCamaraArea(CamaraArea camaraArea) {
		this.camaraArea = camaraArea;
	}

	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}

	public CamaraFilaColumna getCamaraFilaColumna() {
		return this.camaraFilaColumna;
	}

	public void setCamaraFilaColumna(CamaraFilaColumna camaraFilaColumna) {
		this.camaraFilaColumna = camaraFilaColumna;
	}

}