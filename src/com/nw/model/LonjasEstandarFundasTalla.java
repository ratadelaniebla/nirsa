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
public class LonjasEstandarFundasTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlonjasestandarfundastallas;

	private Integer estandarfundasporhora;

	private String idtalla;

	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasEstandarFundasTalla")
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	public LonjasEstandarFundasTalla() {
	}

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

	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

}