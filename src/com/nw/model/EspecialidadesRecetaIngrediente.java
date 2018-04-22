package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the especialidades_receta_ingrediente database table.
 * 
 */
@Entity
@Table(name="especialidades_receta_ingrediente")
public class EspecialidadesRecetaIngrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idespecialidadesrecetaingrediente;

	private double cantidad;

	//bi-directional many-to-one association to EspecialidadesIngrediente
	@ManyToOne
	@JoinColumn(name="idespecialidadesingrediente")
	private EspecialidadesIngrediente especialidadesIngrediente;

	//bi-directional many-to-one association to EspecialidadesReceta
	@ManyToOne
	@JoinColumn(name="idespecialidadesreceta")
	private EspecialidadesReceta especialidadesReceta;

	public EspecialidadesRecetaIngrediente() {
	}

	public Integer getIdespecialidadesrecetaingrediente() {
		return this.idespecialidadesrecetaingrediente;
	}

	public void setIdespecialidadesrecetaingrediente(Integer idespecialidadesrecetaingrediente) {
		this.idespecialidadesrecetaingrediente = idespecialidadesrecetaingrediente;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public EspecialidadesIngrediente getEspecialidadesIngrediente() {
		return this.especialidadesIngrediente;
	}

	public void setEspecialidadesIngrediente(EspecialidadesIngrediente especialidadesIngrediente) {
		this.especialidadesIngrediente = especialidadesIngrediente;
	}

	public EspecialidadesReceta getEspecialidadesReceta() {
		return this.especialidadesReceta;
	}

	public void setEspecialidadesReceta(EspecialidadesReceta especialidadesReceta) {
		this.especialidadesReceta = especialidadesReceta;
	}

}