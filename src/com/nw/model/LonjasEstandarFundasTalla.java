package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lonjas_estandar_fundas_tallas database table.
 * 
 */
@Entity
@Table(name="lonjas_estandar_fundas_tallas")
@NamedQuery(name="LonjasEstandarFundasTalla.findAll", query="SELECT l FROM LonjasEstandarFundasTalla l")
public class LonjasEstandarFundasTalla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlonjasestandarfundastallas;
	private Integer estandarfundasporhora;
	private String idtalla;
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	public LonjasEstandarFundasTalla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlonjasestandarfundastallas() {
		return this.idlonjasestandarfundastallas;
	}

	public void setIdlonjasestandarfundastallas(Integer idlonjasestandarfundastallas) {
		this.idlonjasestandarfundastallas = idlonjasestandarfundastallas;
	}


	public Integer getEstandarfundasporhora() {
		return this.estandarfundasporhora;
	}

	public void setEstandarfundasporhora(Integer estandarfundasporhora) {
		this.estandarfundasporhora = estandarfundasporhora;
	}


	public String getIdtalla() {
		return this.idtalla;
	}

	public void setIdtalla(String idtalla) {
		this.idtalla = idtalla;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasEstandarFundasTalla")
	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public LonjasDetalleProcesoConteo addLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().add(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasEstandarFundasTalla(this);

		return lonjasDetalleProcesoConteo;
	}

	public LonjasDetalleProcesoConteo removeLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().remove(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasEstandarFundasTalla(null);

		return lonjasDetalleProcesoConteo;
	}

}