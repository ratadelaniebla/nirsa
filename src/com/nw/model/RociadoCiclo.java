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
@NamedQuery(name="RociadoCiclo.findAll", query="SELECT r FROM RociadoCiclo r")
public class RociadoCiclo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idrociadocliclo;
	private String descripcion;
	private List<RociadoCicloDetalle> rociadoCicloDetalles;

	public RociadoCiclo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to RociadoCicloDetalle
	@OneToMany(mappedBy="rociadoCiclo")
	public List<RociadoCicloDetalle> getRociadoCicloDetalles() {
		return this.rociadoCicloDetalles;
	}

	public void setRociadoCicloDetalles(List<RociadoCicloDetalle> rociadoCicloDetalles) {
		this.rociadoCicloDetalles = rociadoCicloDetalles;
	}

	public RociadoCicloDetalle addRociadoCicloDetalle(RociadoCicloDetalle rociadoCicloDetalle) {
		getRociadoCicloDetalles().add(rociadoCicloDetalle);
		rociadoCicloDetalle.setRociadoCiclo(this);

		return rociadoCicloDetalle;
	}

	public RociadoCicloDetalle removeRociadoCicloDetalle(RociadoCicloDetalle rociadoCicloDetalle) {
		getRociadoCicloDetalles().remove(rociadoCicloDetalle);
		rociadoCicloDetalle.setRociadoCiclo(null);

		return rociadoCicloDetalle;
	}

}