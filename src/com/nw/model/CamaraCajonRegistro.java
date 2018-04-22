package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the camara_cajon_registro database table.
 * 
 */
@Entity
@Table(name="camara_cajon_registro")
public class CamaraCajonRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcajonregistro;

	private String calidadapariencia;

	private String calidadcontaminante;

	private String calidadolor;

	@Temporal(TemporalType.DATE)
	private Date fechacreacion;

	private String idcajon;

	private String idcuba;

	private Integer idmaterial;

	private String idtipocaptura;

	private String numregistro;

	private double pesobruto;

	private double pesoneto;

	public CamaraCajonRegistro() {
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

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
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

	public Integer getIdmaterial() {
		return this.idmaterial;
	}

	public void setIdmaterial(Integer idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getIdtipocaptura() {
		return this.idtipocaptura;
	}

	public void setIdtipocaptura(String idtipocaptura) {
		this.idtipocaptura = idtipocaptura;
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

}