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
@NamedQuery(name="EspecialidadesReceta.findAll", query="SELECT e FROM EspecialidadesReceta e")
public class EspecialidadesReceta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idespecialidadesreceta;
	private Integer estado;
	private Timestamp fechaFin;
	private Timestamp fechaInicio;
	private List<EspecialidadesProceso> especialidadesProcesos;
	private EspecialidadesProducto especialidadesProducto;
	private List<EspecialidadesRecetaIngrediente> especialidadesRecetaIngredientes;

	public EspecialidadesReceta() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="fecha_fin")
	public Timestamp getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}


	@Column(name="fecha_inicio")
	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	//bi-directional many-to-one association to EspecialidadesProceso
	@OneToMany(mappedBy="especialidadesReceta")
	public List<EspecialidadesProceso> getEspecialidadesProcesos() {
		return this.especialidadesProcesos;
	}

	public void setEspecialidadesProcesos(List<EspecialidadesProceso> especialidadesProcesos) {
		this.especialidadesProcesos = especialidadesProcesos;
	}

	public EspecialidadesProceso addEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		getEspecialidadesProcesos().add(especialidadesProceso);
		especialidadesProceso.setEspecialidadesReceta(this);

		return especialidadesProceso;
	}

	public EspecialidadesProceso removeEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		getEspecialidadesProcesos().remove(especialidadesProceso);
		especialidadesProceso.setEspecialidadesReceta(null);

		return especialidadesProceso;
	}


	//bi-directional many-to-one association to EspecialidadesProducto
	@ManyToOne
	@JoinColumn(name="idespecialidadesproducto")
	public EspecialidadesProducto getEspecialidadesProducto() {
		return this.especialidadesProducto;
	}

	public void setEspecialidadesProducto(EspecialidadesProducto especialidadesProducto) {
		this.especialidadesProducto = especialidadesProducto;
	}


	//bi-directional many-to-one association to EspecialidadesRecetaIngrediente
	@OneToMany(mappedBy="especialidadesReceta")
	public List<EspecialidadesRecetaIngrediente> getEspecialidadesRecetaIngredientes() {
		return this.especialidadesRecetaIngredientes;
	}

	public void setEspecialidadesRecetaIngredientes(List<EspecialidadesRecetaIngrediente> especialidadesRecetaIngredientes) {
		this.especialidadesRecetaIngredientes = especialidadesRecetaIngredientes;
	}

	public EspecialidadesRecetaIngrediente addEspecialidadesRecetaIngrediente(EspecialidadesRecetaIngrediente especialidadesRecetaIngrediente) {
		getEspecialidadesRecetaIngredientes().add(especialidadesRecetaIngrediente);
		especialidadesRecetaIngrediente.setEspecialidadesReceta(this);

		return especialidadesRecetaIngrediente;
	}

	public EspecialidadesRecetaIngrediente removeEspecialidadesRecetaIngrediente(EspecialidadesRecetaIngrediente especialidadesRecetaIngrediente) {
		getEspecialidadesRecetaIngredientes().remove(especialidadesRecetaIngrediente);
		especialidadesRecetaIngrediente.setEspecialidadesReceta(null);

		return especialidadesRecetaIngrediente;
	}

}