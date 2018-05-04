package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the especialidades_receta_ingrediente database table.
 * 
 */
@Entity
@Table(name="especialidades_receta_ingrediente")
@NamedQuery(name="EspecialidadesRecetaIngrediente.findAll", query="SELECT e FROM EspecialidadesRecetaIngrediente e")
public class EspecialidadesRecetaIngrediente implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idespecialidadesrecetaingrediente;
	private double cantidad;
	private EspecialidadesIngrediente especialidadesIngrediente;
	private EspecialidadesReceta especialidadesReceta;

	public EspecialidadesRecetaIngrediente() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EspecialidadesIngrediente
	@ManyToOne
	@JoinColumn(name="idespecialidadesingrediente")
	public EspecialidadesIngrediente getEspecialidadesIngrediente() {
		return this.especialidadesIngrediente;
	}

	public void setEspecialidadesIngrediente(EspecialidadesIngrediente especialidadesIngrediente) {
		this.especialidadesIngrediente = especialidadesIngrediente;
	}


	//bi-directional many-to-one association to EspecialidadesReceta
	@ManyToOne
	@JoinColumn(name="idespecialidadesreceta")
	public EspecialidadesReceta getEspecialidadesReceta() {
		return this.especialidadesReceta;
	}

	public void setEspecialidadesReceta(EspecialidadesReceta especialidadesReceta) {
		this.especialidadesReceta = especialidadesReceta;
	}

}