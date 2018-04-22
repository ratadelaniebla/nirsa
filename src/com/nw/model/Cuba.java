package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuba database table.
 * 
 */
@Entity
public class Cuba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcuba;

	private String especificacion;

	private String nombrecuba;

	//bi-directional many-to-one association to BarcoCuba
	@OneToMany(mappedBy="cuba")
	private List<BarcoCuba> barcoCubas;

	public Cuba() {
	}

	public Integer getIdcuba() {
		return this.idcuba;
	}

	public void setIdcuba(Integer idcuba) {
		this.idcuba = idcuba;
	}

	public String getEspecificacion() {
		return this.especificacion;
	}

	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}

	public String getNombrecuba() {
		return this.nombrecuba;
	}

	public void setNombrecuba(String nombrecuba) {
		this.nombrecuba = nombrecuba;
	}

	public List<BarcoCuba> getBarcoCubas() {
		return this.barcoCubas;
	}

	public void setBarcoCubas(List<BarcoCuba> barcoCubas) {
		this.barcoCubas = barcoCubas;
	}

}