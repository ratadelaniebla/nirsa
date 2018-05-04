package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_detalle_pcc_remuestreo_cajon database table.
 * 
 */
@Entity
@Table(name="calidad_detalle_pcc_remuestreo_cajon")
@NamedQuery(name="CalidadDetallePccRemuestreoCajon.findAll", query="SELECT c FROM CalidadDetallePccRemuestreoCajon c")
public class CalidadDetallePccRemuestreoCajon implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidaddetallepccremuestreocajon;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private double histamina;
	private Integer nummuestra;
	private double sal;
	private String usuarioactualizacion;
	private CalidadPccRemuestreoCajon calidadPccRemuestreoCajon;
	private CamaraCajon camaraCajon;
	private Usuario usuario;

	public CalidadDetallePccRemuestreoCajon() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidaddetallepccremuestreocajon() {
		return this.idcalidaddetallepccremuestreocajon;
	}

	public void setIdcalidaddetallepccremuestreocajon(Long idcalidaddetallepccremuestreocajon) {
		this.idcalidaddetallepccremuestreocajon = idcalidaddetallepccremuestreocajon;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFecharegactualizacion() {
		return this.fecharegactualizacion;
	}

	public void setFecharegactualizacion(Timestamp fecharegactualizacion) {
		this.fecharegactualizacion = fecharegactualizacion;
	}


	public double getHistamina() {
		return this.histamina;
	}

	public void setHistamina(double histamina) {
		this.histamina = histamina;
	}


	public Integer getNummuestra() {
		return this.nummuestra;
	}

	public void setNummuestra(Integer nummuestra) {
		this.nummuestra = nummuestra;
	}


	public double getSal() {
		return this.sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}


	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}


	//bi-directional many-to-one association to CalidadPccRemuestreoCajon
	@ManyToOne
	@JoinColumn(name="idcalidadpccremuestreocajon")
	public CalidadPccRemuestreoCajon getCalidadPccRemuestreoCajon() {
		return this.calidadPccRemuestreoCajon;
	}

	public void setCalidadPccRemuestreoCajon(CalidadPccRemuestreoCajon calidadPccRemuestreoCajon) {
		this.calidadPccRemuestreoCajon = calidadPccRemuestreoCajon;
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


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}