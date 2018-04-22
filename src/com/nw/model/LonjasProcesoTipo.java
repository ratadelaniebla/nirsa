package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lonjas_proceso_tipo database table.
 * 
 */
@Entity
@Table(name="lonjas_proceso_tipo")
public class LonjasProcesoTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlonjasprocesotipo;

	private String descripcion;

	private Integer estado;

	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasProcesoTipo")
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="lonjasProcesoTipo")
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;

	public LonjasProcesoTipo() {
	}

	public Integer getIdlonjasprocesotipo() {
		return this.idlonjasprocesotipo;
	}

	public void setIdlonjasprocesotipo(Integer idlonjasprocesotipo) {
		this.idlonjasprocesotipo = idlonjasprocesotipo;
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

	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

}