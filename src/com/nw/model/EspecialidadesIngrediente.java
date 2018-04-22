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
public class EspecialidadesIngrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idespecialidadesingrediente;

	private String descripcion;

	//bi-directional many-to-one association to EspecialidadesRecetaIngrediente
	@OneToMany(mappedBy="especialidadesIngrediente")
	private List<EspecialidadesRecetaIngrediente> especialidadesRecetaIngredientes;

	public EspecialidadesIngrediente() {
	}

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

	public List<EspecialidadesRecetaIngrediente> getEspecialidadesRecetaIngredientes() {
		return this.especialidadesRecetaIngredientes;
	}

	public void setEspecialidadesRecetaIngredientes(List<EspecialidadesRecetaIngrediente> especialidadesRecetaIngredientes) {
		this.especialidadesRecetaIngredientes = especialidadesRecetaIngredientes;
	}

}