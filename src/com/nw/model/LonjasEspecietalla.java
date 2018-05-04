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
@NamedQuery(name="LonjasEspecietalla.findAll", query="SELECT l FROM LonjasEspecietalla l")
public class LonjasEspecietalla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlonjasespecietalla;
	private String tallalonjas;
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;
	private EspecieTalla especieTalla;

	public LonjasEspecietalla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="lonjasEspecietalla")
	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public LonjasDetalleProcesoLote addLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().add(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setLonjasEspecietalla(this);

		return lonjasDetalleProcesoLote;
	}

	public LonjasDetalleProcesoLote removeLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().remove(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setLonjasEspecietalla(null);

		return lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}

}