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
@NamedQuery(name="AtcLimpiezaLinea.findAll", query="SELECT a FROM AtcLimpiezaLinea a")
public class AtcLimpiezaLinea implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idatclimpiezalinea;
	private String descripcion;
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;
	private List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados;

	public AtcLimpiezaLinea() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcLimpiezaLinea")
	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public AtcLimpiezaDetalleBandeja addAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().add(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcLimpiezaLinea(this);

		return atcLimpiezaDetalleBandeja;
	}

	public AtcLimpiezaDetalleBandeja removeAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().remove(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcLimpiezaLinea(null);

		return atcLimpiezaDetalleBandeja;
	}


	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@OneToMany(mappedBy="atcLimpiezaLinea")
	public List<AtcLimpiezaProcesoEmpleado> getAtcLimpiezaProcesoEmpleados() {
		return this.atcLimpiezaProcesoEmpleados;
	}

	public void setAtcLimpiezaProcesoEmpleados(List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados) {
		this.atcLimpiezaProcesoEmpleados = atcLimpiezaProcesoEmpleados;
	}

	public AtcLimpiezaProcesoEmpleado addAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		getAtcLimpiezaProcesoEmpleados().add(atcLimpiezaProcesoEmpleado);
		atcLimpiezaProcesoEmpleado.setAtcLimpiezaLinea(this);

		return atcLimpiezaProcesoEmpleado;
	}

	public AtcLimpiezaProcesoEmpleado removeAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		getAtcLimpiezaProcesoEmpleados().remove(atcLimpiezaProcesoEmpleado);
		atcLimpiezaProcesoEmpleado.setAtcLimpiezaLinea(null);

		return atcLimpiezaProcesoEmpleado;
	}

}