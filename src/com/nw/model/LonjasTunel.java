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
@NamedQuery(name="LonjasTunel.findAll", query="SELECT l FROM LonjasTunel l")
public class LonjasTunel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlonjastunel;
	private String descripcion;
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	public LonjasTunel() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="lonjasTunel")
	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public LonjasDetalleProcesoCocheEmpacado addLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().add(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setLonjasTunel(this);

		return lonjasDetalleProcesoCocheEmpacado;
	}

	public LonjasDetalleProcesoCocheEmpacado removeLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().remove(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setLonjasTunel(null);

		return lonjasDetalleProcesoCocheEmpacado;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasTunel")
	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public LonjasDetalleProcesoConteo addLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().add(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasTunel(this);

		return lonjasDetalleProcesoConteo;
	}

	public LonjasDetalleProcesoConteo removeLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().remove(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasTunel(null);

		return lonjasDetalleProcesoConteo;
	}

}