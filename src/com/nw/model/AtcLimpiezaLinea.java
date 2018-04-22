package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_linea database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_linea")
public class AtcLimpiezaLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idatclimpiezalinea;

	private String descripcion;

	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcLimpiezaLinea")
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;

	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@OneToMany(mappedBy="atcLimpiezaLinea")
	private List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados;

	public AtcLimpiezaLinea() {
	}

	public Integer getIdatclimpiezalinea() {
		return this.idatclimpiezalinea;
	}

	public void setIdatclimpiezalinea(Integer idatclimpiezalinea) {
		this.idatclimpiezalinea = idatclimpiezalinea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public List<AtcLimpiezaProcesoEmpleado> getAtcLimpiezaProcesoEmpleados() {
		return this.atcLimpiezaProcesoEmpleados;
	}

	public void setAtcLimpiezaProcesoEmpleados(List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados) {
		this.atcLimpiezaProcesoEmpleados = atcLimpiezaProcesoEmpleados;
	}

}