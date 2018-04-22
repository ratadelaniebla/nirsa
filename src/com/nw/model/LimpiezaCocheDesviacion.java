package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_coche_desviacion database table.
 * 
 */
@Entity
@Table(name="limpieza_coche_desviacion")
public class LimpiezaCocheDesviacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezacochedesviacion;

	private String descripcion;

	private String scriptcomparacion;

	//bi-directional many-to-one association to LimpiezaCocheObservacione
	@OneToMany(mappedBy="limpiezaCocheDesviacion")
	private List<LimpiezaCocheObservacione> limpiezaCocheObservaciones;

	public LimpiezaCocheDesviacion() {
	}

	public Integer getIdlimpiezacochedesviacion() {
		return this.idlimpiezacochedesviacion;
	}

	public void setIdlimpiezacochedesviacion(Integer idlimpiezacochedesviacion) {
		this.idlimpiezacochedesviacion = idlimpiezacochedesviacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getScriptcomparacion() {
		return this.scriptcomparacion;
	}

	public void setScriptcomparacion(String scriptcomparacion) {
		this.scriptcomparacion = scriptcomparacion;
	}

	public List<LimpiezaCocheObservacione> getLimpiezaCocheObservaciones() {
		return this.limpiezaCocheObservaciones;
	}

	public void setLimpiezaCocheObservaciones(List<LimpiezaCocheObservacione> limpiezaCocheObservaciones) {
		this.limpiezaCocheObservaciones = limpiezaCocheObservaciones;
	}

}