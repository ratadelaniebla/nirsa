package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_descongelado_detalle_temp_pescado database table.
 * 
 */
@Entity
@Table(name="calidad_descongelado_detalle_temp_pescado")
@NamedQuery(name="CalidadDescongeladoDetalleTempPescado.findAll", query="SELECT c FROM CalidadDescongeladoDetalleTempPescado c")
public class CalidadDescongeladoDetalleTempPescado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddescongeladodetalletemppescado;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestra;
	private double temperaturapescado;
	private String usuarioactualizacion;
	private CalidadDescongeladoTempPescado calidadDescongeladoTempPescado;
	private Turno turno;
	private Usuario usuario;

	public CalidadDescongeladoDetalleTempPescado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddescongeladodetalletemppescado() {
		return this.iddescongeladodetalletemppescado;
	}

	public void setIddescongeladodetalletemppescado(Long iddescongeladodetalletemppescado) {
		this.iddescongeladodetalletemppescado = iddescongeladodetalletemppescado;
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


	public Integer getNummuestra() {
		return this.nummuestra;
	}

	public void setNummuestra(Integer nummuestra) {
		this.nummuestra = nummuestra;
	}


	public double getTemperaturapescado() {
		return this.temperaturapescado;
	}

	public void setTemperaturapescado(double temperaturapescado) {
		this.temperaturapescado = temperaturapescado;
	}


	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}


	//bi-directional many-to-one association to CalidadDescongeladoTempPescado
	@ManyToOne
	@JoinColumn(name="iddescongeladotemppescado")
	public CalidadDescongeladoTempPescado getCalidadDescongeladoTempPescado() {
		return this.calidadDescongeladoTempPescado;
	}

	public void setCalidadDescongeladoTempPescado(CalidadDescongeladoTempPescado calidadDescongeladoTempPescado) {
		this.calidadDescongeladoTempPescado = calidadDescongeladoTempPescado;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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