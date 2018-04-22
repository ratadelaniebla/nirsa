package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lonjas_especietalla database table.
 * 
 */
@Entity
@Table(name="lonjas_especietalla")
public class LonjasEspecietalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlonjasespecietalla;

	private String tallalonjas;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="lonjasEspecietalla")
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;

	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	private EspecieTalla especieTalla;

	public LonjasEspecietalla() {
	}

	public Integer getIdlonjasespecietalla() {
		return this.idlonjasespecietalla;
	}

	public void setIdlonjasespecietalla(Integer idlonjasespecietalla) {
		this.idlonjasespecietalla = idlonjasespecietalla;
	}

	public String getTallalonjas() {
		return this.tallalonjas;
	}

	public void setTallalonjas(String tallalonjas) {
		this.tallalonjas = tallalonjas;
	}

	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}

}