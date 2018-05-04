package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_detalle_sensorial_mp database table.
 * 
 */
@Entity
@Table(name="calidad_detalle_sensorial_mp")
@NamedQuery(name="CalidadDetalleSensorialMp.findAll", query="SELECT c FROM CalidadDetalleSensorialMp c")
public class CalidadDetalleSensorialMp implements Serializable {
	private static final long serialVersionUID = 1L;
	private CalidadDetalleSensorialMpPK id;
	private Timestamp fechareg;
	private Integer idobservacionapariencia;
	private Integer idobservacionolor;
	private Integer idobservacionsabor;
	private Integer numeromuestra;
	private String observaciones;
	private Long secuencialmuestra;
	private BarcoEstibaCuba barcoEstibaCuba;
	private CalidadNivelCuba calidadNivelCuba;
	private EspecieTalla especieTalla;
	private Usuario usuario;

	public CalidadDetalleSensorialMp() {
	}


	@EmbeddedId
	public CalidadDetalleSensorialMpPK getId() {
		return this.id;
	}

	public void setId(CalidadDetalleSensorialMpPK id) {
		this.id = id;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getIdobservacionapariencia() {
		return this.idobservacionapariencia;
	}

	public void setIdobservacionapariencia(Integer idobservacionapariencia) {
		this.idobservacionapariencia = idobservacionapariencia;
	}


	public Integer getIdobservacionolor() {
		return this.idobservacionolor;
	}

	public void setIdobservacionolor(Integer idobservacionolor) {
		this.idobservacionolor = idobservacionolor;
	}


	public Integer getIdobservacionsabor() {
		return this.idobservacionsabor;
	}

	public void setIdobservacionsabor(Integer idobservacionsabor) {
		this.idobservacionsabor = idobservacionsabor;
	}


	public Integer getNumeromuestra() {
		return this.numeromuestra;
	}

	public void setNumeromuestra(Integer numeromuestra) {
		this.numeromuestra = numeromuestra;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Long getSecuencialmuestra() {
		return this.secuencialmuestra;
	}

	public void setSecuencialmuestra(Long secuencialmuestra) {
		this.secuencialmuestra = secuencialmuestra;
	}


	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}


	//bi-directional many-to-one association to CalidadNivelCuba
	@ManyToOne
	@JoinColumn(name="idcalidadnivelcuba")
	public CalidadNivelCuba getCalidadNivelCuba() {
		return this.calidadNivelCuba;
	}

	public void setCalidadNivelCuba(CalidadNivelCuba calidadNivelCuba) {
		this.calidadNivelCuba = calidadNivelCuba;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
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