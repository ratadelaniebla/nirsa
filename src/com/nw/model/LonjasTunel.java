package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lonjas_tunel database table.
 * 
 */
@Entity
@Table(name="lonjas_tunel")
public class LonjasTunel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlonjastunel;

	private String descripcion;

	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="lonjasTunel")
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;

	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasTunel")
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	public LonjasTunel() {
	}

	public Integer getIdlonjastunel() {
		return this.idlonjastunel;
	}

	public void setIdlonjastunel(Integer idlonjastunel) {
		this.idlonjastunel = idlonjastunel;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

}