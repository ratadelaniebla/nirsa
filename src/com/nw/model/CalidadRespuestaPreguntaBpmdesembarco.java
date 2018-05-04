package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_respuesta_pregunta_bpmdesembarco database table.
 * 
 */
@Entity
@Table(name="calidad_respuesta_pregunta_bpmdesembarco")
@NamedQuery(name="CalidadRespuestaPreguntaBpmdesembarco.findAll", query="SELECT c FROM CalidadRespuestaPreguntaBpmdesembarco c")
public class CalidadRespuestaPreguntaBpmdesembarco implements Serializable {
	private static final long serialVersionUID = 1L;
	private CalidadRespuestaPreguntaBpmdesembarcoPK id;
	private Integer cumplimiento;
	private Timestamp fechareg;
	private String observaciones;
	private Integer turnolabor;
	private Usuario usuario;

	public CalidadRespuestaPreguntaBpmdesembarco() {
	}


	@EmbeddedId
	public CalidadRespuestaPreguntaBpmdesembarcoPK getId() {
		return this.id;
	}

	public void setId(CalidadRespuestaPreguntaBpmdesembarcoPK id) {
		this.id = id;
	}


	public Integer getCumplimiento() {
		return this.cumplimiento;
	}

	public void setCumplimiento(Integer cumplimiento) {
		this.cumplimiento = cumplimiento;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Integer getTurnolabor() {
		return this.turnolabor;
	}

	public void setTurnolabor(Integer turnolabor) {
		this.turnolabor = turnolabor;
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