package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especialidades_ingredientes database table.
 * 
 */
@Entity
@Table(name="especialidades_ingredientes")
@NamedQuery(name="EspecialidadesIngrediente.findAll", query="SELECT e FROM EspecialidadesIngrediente e")
public class EspecialidadesIngrediente implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idespecialidadesingrediente;
	private String descripcion;
	private List<EspecialidadesRecetaIngrediente> especialidadesRecetaIngredientes;

	public EspecialidadesIngrediente() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdespecialidadesingrediente() {
		return this.idespecialidadesingrediente;
	}

	public void setIdespecialidadesingrediente(Integer idespecialidadesingrediente) {
		this.idespecialidadesingrediente = idespecialidadesingrediente;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EspecialidadesRecetaIngrediente
	@OneToMany(mappedBy="especialidadesIngrediente")
	public List<EspecialidadesRecetaIngrediente> getEspecialidadesRecetaIngredientes() {
		return this.especialidadesRecetaIngredientes;
	}

	public void setEspecialidadesRecetaIngredientes(List<EspecialidadesRecetaIngrediente> especialidadesRecetaIngredientes) {
		this.especialidadesRecetaIngredientes = especialidadesRecetaIngredientes;
	}

	public EspecialidadesRecetaIngrediente addEspecialidadesRecetaIngrediente(EspecialidadesRecetaIngrediente especialidadesRecetaIngrediente) {
		getEspecialidadesRecetaIngredientes().add(especialidadesRecetaIngrediente);
		especialidadesRecetaIngrediente.setEspecialidadesIngrediente(this);

		return especialidadesRecetaIngrediente;
	}

	public EspecialidadesRecetaIngrediente removeEspecialidadesRecetaIngrediente(EspecialidadesRecetaIngrediente especialidadesRecetaIngrediente) {
		getEspecialidadesRecetaIngredientes().remove(especialidadesRecetaIngrediente);
		especialidadesRecetaIngrediente.setEspecialidadesIngrediente(null);

		return especialidadesRecetaIngrediente;
	}

}