package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the procesos_carga_evolution database table.
 * 
 */
@Entity
@Table(name="procesos_carga_evolution")
public class ProcesosCargaEvolution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idprocesocargaevolution;

	private String descripcion;

	private Integer estado;

	public ProcesosCargaEvolution() {
	}

	public Integer getIdprocesocargaevolution() {
		return this.idprocesocargaevolution;
	}

	public void setIdprocesocargaevolution(Integer idprocesocargaevolution) {
		this.idprocesocargaevolution = idprocesocargaevolution;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}