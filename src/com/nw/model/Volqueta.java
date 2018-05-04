package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the volqueta database table.
 * 
 */
@Entity
@NamedQuery(name="Volqueta.findAll", query="SELECT v FROM Volqueta v")
public class Volqueta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idvolqueta;
	private String descripcionvolqueta;
	private Integer estadovolqueta;
	private List<CamaraDetalleBanda> camaraDetalleBandas;

	public Volqueta() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdvolqueta() {
		return this.idvolqueta;
	}

	public void setIdvolqueta(Integer idvolqueta) {
		this.idvolqueta = idvolqueta;
	}


	public String getDescripcionvolqueta() {
		return this.descripcionvolqueta;
	}

	public void setDescripcionvolqueta(String descripcionvolqueta) {
		this.descripcionvolqueta = descripcionvolqueta;
	}


	public Integer getEstadovolqueta() {
		return this.estadovolqueta;
	}

	public void setEstadovolqueta(Integer estadovolqueta) {
		this.estadovolqueta = estadovolqueta;
	}


	//bi-directional many-to-one association to CamaraDetalleBanda
	@OneToMany(mappedBy="volqueta")
	public List<CamaraDetalleBanda> getCamaraDetalleBandas() {
		return this.camaraDetalleBandas;
	}

	public void setCamaraDetalleBandas(List<CamaraDetalleBanda> camaraDetalleBandas) {
		this.camaraDetalleBandas = camaraDetalleBandas;
	}

	public CamaraDetalleBanda addCamaraDetalleBanda(CamaraDetalleBanda camaraDetalleBanda) {
		getCamaraDetalleBandas().add(camaraDetalleBanda);
		camaraDetalleBanda.setVolqueta(this);

		return camaraDetalleBanda;
	}

	public CamaraDetalleBanda removeCamaraDetalleBanda(CamaraDetalleBanda camaraDetalleBanda) {
		getCamaraDetalleBandas().remove(camaraDetalleBanda);
		camaraDetalleBanda.setVolqueta(null);

		return camaraDetalleBanda;
	}

}