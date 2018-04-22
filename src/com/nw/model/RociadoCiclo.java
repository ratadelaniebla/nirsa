package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rociado_ciclo database table.
 * 
 */
@Entity
@Table(name="rociado_ciclo")
public class RociadoCiclo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idrociadocliclo;

	private String descripcion;

	//bi-directional many-to-one association to RociadoCicloDetalle
	@OneToMany(mappedBy="rociadoCiclo")
	private List<RociadoCicloDetalle> rociadoCicloDetalles;

	public RociadoCiclo() {
	}

	public Integer getIdrociadocliclo() {
		return this.idrociadocliclo;
	}

	public void setIdrociadocliclo(Integer idrociadocliclo) {
		this.idrociadocliclo = idrociadocliclo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<RociadoCicloDetalle> getRociadoCicloDetalles() {
		return this.rociadoCicloDetalles;
	}

	public void setRociadoCicloDetalles(List<RociadoCicloDetalle> rociadoCicloDetalles) {
		this.rociadoCicloDetalles = rociadoCicloDetalles;
	}

}