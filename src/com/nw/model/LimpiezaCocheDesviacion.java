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
@NamedQuery(name="LimpiezaCocheDesviacion.findAll", query="SELECT l FROM LimpiezaCocheDesviacion l")
public class LimpiezaCocheDesviacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezacochedesviacion;
	private String descripcion;
	private String scriptcomparacion;
	private List<LimpiezaCocheObservacione> limpiezaCocheObservaciones;

	public LimpiezaCocheDesviacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaCocheObservacione
	@OneToMany(mappedBy="limpiezaCocheDesviacion")
	public List<LimpiezaCocheObservacione> getLimpiezaCocheObservaciones() {
		return this.limpiezaCocheObservaciones;
	}

	public void setLimpiezaCocheObservaciones(List<LimpiezaCocheObservacione> limpiezaCocheObservaciones) {
		this.limpiezaCocheObservaciones = limpiezaCocheObservaciones;
	}

	public LimpiezaCocheObservacione addLimpiezaCocheObservacione(LimpiezaCocheObservacione limpiezaCocheObservacione) {
		getLimpiezaCocheObservaciones().add(limpiezaCocheObservacione);
		limpiezaCocheObservacione.setLimpiezaCocheDesviacion(this);

		return limpiezaCocheObservacione;
	}

	public LimpiezaCocheObservacione removeLimpiezaCocheObservacione(LimpiezaCocheObservacione limpiezaCocheObservacione) {
		getLimpiezaCocheObservaciones().remove(limpiezaCocheObservacione);
		limpiezaCocheObservacione.setLimpiezaCocheDesviacion(null);

		return limpiezaCocheObservacione;
	}

}