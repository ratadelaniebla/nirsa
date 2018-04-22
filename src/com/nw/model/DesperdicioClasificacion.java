package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the desperdicio_clasificacion database table.
 * 
 */
@Entity
@Table(name="desperdicio_clasificacion")
public class DesperdicioClasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iddesperdicioclasificacion;

	private String descripcion;

	public DesperdicioClasificacion() {
	}

	public Integer getIddesperdicioclasificacion() {
		return this.iddesperdicioclasificacion;
	}

	public void setIddesperdicioclasificacion(Integer iddesperdicioclasificacion) {
		this.iddesperdicioclasificacion = iddesperdicioclasificacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}