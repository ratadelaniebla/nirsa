package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the especialidades_receta database table.
 * 
 */
@Entity
@Table(name="especialidades_receta")
public class EspecialidadesReceta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idespecialidadesreceta;

	private Integer estado;

	@Column(name="fecha_fin")
	private Timestamp fechaFin;

	@Column(name="fecha_inicio")
	private Timestamp fechaInicio;

	//bi-directional many-to-one association to EspecialidadesProceso
	@OneToMany(mappedBy="especialidadesReceta")
	private List<EspecialidadesProceso> especialidadesProcesos;

	//bi-directional many-to-one association to EspecialidadesProducto
	@ManyToOne
	@JoinColumn(name="idespecialidadesproducto")
	private EspecialidadesProducto especialidadesProducto;

	//bi-directional many-to-one association to EspecialidadesRecetaIngrediente
	@OneToMany(mappedBy="especialidadesReceta")
	private List<EspecialidadesRecetaIngrediente> especialidadesRecetaIngredientes;

	public EspecialidadesReceta() {
	}

	public Integer getIdespecialidadesreceta() {
		return this.idespecialidadesreceta;
	}

	public void setIdespecialidadesreceta(Integer idespecialidadesreceta) {
		this.idespecialidadesreceta = idespecialidadesreceta;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<EspecialidadesProceso> getEspecialidadesProcesos() {
		return this.especialidadesProcesos;
	}

	public void setEspecialidadesProcesos(List<EspecialidadesProceso> especialidadesProcesos) {
		this.especialidadesProcesos = especialidadesProcesos;
	}

	public EspecialidadesProducto getEspecialidadesProducto() {
		return this.especialidadesProducto;
	}

	public void setEspecialidadesProducto(EspecialidadesProducto especialidadesProducto) {
		this.especialidadesProducto = especialidadesProducto;
	}

	public List<EspecialidadesRecetaIngrediente> getEspecialidadesRecetaIngredientes() {
		return this.especialidadesRecetaIngredientes;
	}

	public void setEspecialidadesRecetaIngredientes(List<EspecialidadesRecetaIngrediente> especialidadesRecetaIngredientes) {
		this.especialidadesRecetaIngredientes = especialidadesRecetaIngredientes;
	}

}