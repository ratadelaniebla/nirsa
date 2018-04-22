package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_material database table.
 * 
 */
@Entity
@Table(name="limpieza_material")
public class LimpiezaMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezamaterial;

	private String nombre;

	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaMaterial")
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaMaterial1")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas1;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaMaterial2")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas2;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaMaterial1")
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions1;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaMaterial2")
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions2;

	public LimpiezaMaterial() {
	}

	public Integer getIdlimpiezamaterial() {
		return this.idlimpiezamaterial;
	}

	public void setIdlimpiezamaterial(Integer idlimpiezamaterial) {
		this.idlimpiezamaterial = idlimpiezamaterial;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas1() {
		return this.limpiezaDetalleProcesoBandejas1;
	}

	public void setLimpiezaDetalleProcesoBandejas1(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas1) {
		this.limpiezaDetalleProcesoBandejas1 = limpiezaDetalleProcesoBandejas1;
	}

	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas2() {
		return this.limpiezaDetalleProcesoBandejas2;
	}

	public void setLimpiezaDetalleProcesoBandejas2(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas2) {
		this.limpiezaDetalleProcesoBandejas2 = limpiezaDetalleProcesoBandejas2;
	}

	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions1() {
		return this.limpiezaDetalleProcesoBandejaAprobacions1;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions1(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions1) {
		this.limpiezaDetalleProcesoBandejaAprobacions1 = limpiezaDetalleProcesoBandejaAprobacions1;
	}

	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions2() {
		return this.limpiezaDetalleProcesoBandejaAprobacions2;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions2(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions2) {
		this.limpiezaDetalleProcesoBandejaAprobacions2 = limpiezaDetalleProcesoBandejaAprobacions2;
	}

}