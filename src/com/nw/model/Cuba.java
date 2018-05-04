package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuba database table.
 * 
 */
@Entity
@NamedQuery(name="Cuba.findAll", query="SELECT c FROM Cuba c")
public class Cuba implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcuba;
	private String especificacion;
	private String nombrecuba;
	private List<BarcoCuba> barcoCubas;

	public Cuba() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to BarcoCuba
	@OneToMany(mappedBy="cuba")
	public List<BarcoCuba> getBarcoCubas() {
		return this.barcoCubas;
	}

	public void setBarcoCubas(List<BarcoCuba> barcoCubas) {
		this.barcoCubas = barcoCubas;
	}

	public BarcoCuba addBarcoCuba(BarcoCuba barcoCuba) {
		getBarcoCubas().add(barcoCuba);
		barcoCuba.setCuba(this);

		return barcoCuba;
	}

	public BarcoCuba removeBarcoCuba(BarcoCuba barcoCuba) {
		getBarcoCubas().remove(barcoCuba);
		barcoCuba.setCuba(null);

		return barcoCuba;
	}

}