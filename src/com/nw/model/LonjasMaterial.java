package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lonjas_material database table.
 * 
 */
@Entity
@Table(name="lonjas_material")
@NamedQuery(name="LonjasMaterial.findAll", query="SELECT l FROM LonjasMaterial l")
public class LonjasMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlonjasmaterial;
	private String descripcion;
	private Integer estado;
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;

	public LonjasMaterial() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlonjasmaterial() {
		return this.idlonjasmaterial;
	}

	public void setIdlonjasmaterial(Integer idlonjasmaterial) {
		this.idlonjasmaterial = idlonjasmaterial;
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


	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasMaterial")
	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public LonjasDetalleProcesoConteo addLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().add(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasMaterial(this);

		return lonjasDetalleProcesoConteo;
	}

	public LonjasDetalleProcesoConteo removeLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().remove(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasMaterial(null);

		return lonjasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="lonjasMaterial")
	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public LonjasDetalleProcesoEmpaque addLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().add(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setLonjasMaterial(this);

		return lonjasDetalleProcesoEmpaque;
	}

	public LonjasDetalleProcesoEmpaque removeLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().remove(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setLonjasMaterial(null);

		return lonjasDetalleProcesoEmpaque;
	}

}