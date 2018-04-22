package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the especialidades_incidencia_enlatado database table.
 * 
 */
@Entity
@Table(name="especialidades_incidencia_enlatado")
public class EspecialidadesIncidenciaEnlatado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idespecialidadesincidenciaenlatado;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private String observaciones;

	//bi-directional many-to-one association to EspecialidadesIncidencia
	@ManyToOne
	@JoinColumn(name="idespecialidadesincidencia")
	private EspecialidadesIncidencia especialidadesIncidencia;

	//bi-directional many-to-one association to EspecialidadesProcesoEnlatado
	@ManyToOne
	@JoinColumn(name="idespecialidadesenlatado")
	private EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado;

	public EspecialidadesIncidenciaEnlatado() {
	}

	public Long getIdespecialidadesincidenciaenlatado() {
		return this.idespecialidadesincidenciaenlatado;
	}

	public void setIdespecialidadesincidenciaenlatado(Long idespecialidadesincidenciaenlatado) {
		this.idespecialidadesincidenciaenlatado = idespecialidadesincidenciaenlatado;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public EspecialidadesIncidencia getEspecialidadesIncidencia() {
		return this.especialidadesIncidencia;
	}

	public void setEspecialidadesIncidencia(EspecialidadesIncidencia especialidadesIncidencia) {
		this.especialidadesIncidencia = especialidadesIncidencia;
	}

	public EspecialidadesProcesoEnlatado getEspecialidadesProcesoEnlatado() {
		return this.especialidadesProcesoEnlatado;
	}

	public void setEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		this.especialidadesProcesoEnlatado = especialidadesProcesoEnlatado;
	}

}