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
@NamedQuery(name="CamaraCajonUbicacion.findAll", query="SELECT c FROM CamaraCajonUbicacion c")
public class CamaraCajonUbicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcamaracajonubicacion;
	private String columnapasillo;
	private Timestamp fechareg;
	private Integer idmovimiento;
	private String idusuario;
	private String ladopasillo;
	private String observaciones;
	private Camara camara;
	private CamaraArea camaraArea;
	private CamaraCajon camaraCajon;
	private CamaraFilaColumna camaraFilaColumna;

	public CamaraCajonUbicacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to Camara
	@ManyToOne
	@JoinColumn(name="idcamara")
	public Camara getCamara() {
		return this.camara;
	}

	public void setCamara(Camara camara) {
		this.camara = camara;
	}


	//bi-directional many-to-one association to CamaraArea
	@ManyToOne
	@JoinColumn(name="idcamaraarea")
	public CamaraArea getCamaraArea() {
		return this.camaraArea;
	}

	public void setCamaraArea(CamaraArea camaraArea) {
		this.camaraArea = camaraArea;
	}


	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}


	//bi-directional many-to-one association to CamaraFilaColumna
	@ManyToOne
	@JoinColumn(name="idfilacolumna")
	public CamaraFilaColumna getCamaraFilaColumna() {
		return this.camaraFilaColumna;
	}

	public void setCamaraFilaColumna(CamaraFilaColumna camaraFilaColumna) {
		this.camaraFilaColumna = camaraFilaColumna;
	}

}