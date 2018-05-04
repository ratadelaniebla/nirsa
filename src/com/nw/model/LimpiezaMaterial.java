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
@NamedQuery(name="LimpiezaMaterial.findAll", query="SELECT l FROM LimpiezaMaterial l")
public class LimpiezaMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezamaterial;
	private String nombre;
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas1;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas2;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions1;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions2;

	public LimpiezaMaterial() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaMaterial")
	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public LimpiezaCalidadDetalleProcesoBandeja addLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().add(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setLimpiezaMaterial(this);

		return limpiezaCalidadDetalleProcesoBandeja;
	}

	public LimpiezaCalidadDetalleProcesoBandeja removeLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().remove(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setLimpiezaMaterial(null);

		return limpiezaCalidadDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaMaterial1")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas1() {
		return this.limpiezaDetalleProcesoBandejas1;
	}

	public void setLimpiezaDetalleProcesoBandejas1(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas1) {
		this.limpiezaDetalleProcesoBandejas1 = limpiezaDetalleProcesoBandejas1;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandejas1(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandejas1) {
		getLimpiezaDetalleProcesoBandejas1().add(limpiezaDetalleProcesoBandejas1);
		limpiezaDetalleProcesoBandejas1.setLimpiezaMaterial1(this);

		return limpiezaDetalleProcesoBandejas1;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandejas1(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandejas1) {
		getLimpiezaDetalleProcesoBandejas1().remove(limpiezaDetalleProcesoBandejas1);
		limpiezaDetalleProcesoBandejas1.setLimpiezaMaterial1(null);

		return limpiezaDetalleProcesoBandejas1;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaMaterial2")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas2() {
		return this.limpiezaDetalleProcesoBandejas2;
	}

	public void setLimpiezaDetalleProcesoBandejas2(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas2) {
		this.limpiezaDetalleProcesoBandejas2 = limpiezaDetalleProcesoBandejas2;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandejas2(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandejas2) {
		getLimpiezaDetalleProcesoBandejas2().add(limpiezaDetalleProcesoBandejas2);
		limpiezaDetalleProcesoBandejas2.setLimpiezaMaterial2(this);

		return limpiezaDetalleProcesoBandejas2;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandejas2(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandejas2) {
		getLimpiezaDetalleProcesoBandejas2().remove(limpiezaDetalleProcesoBandejas2);
		limpiezaDetalleProcesoBandejas2.setLimpiezaMaterial2(null);

		return limpiezaDetalleProcesoBandejas2;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaMaterial1")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions1() {
		return this.limpiezaDetalleProcesoBandejaAprobacions1;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions1(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions1) {
		this.limpiezaDetalleProcesoBandejaAprobacions1 = limpiezaDetalleProcesoBandejaAprobacions1;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacions1(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacions1) {
		getLimpiezaDetalleProcesoBandejaAprobacions1().add(limpiezaDetalleProcesoBandejaAprobacions1);
		limpiezaDetalleProcesoBandejaAprobacions1.setLimpiezaMaterial1(this);

		return limpiezaDetalleProcesoBandejaAprobacions1;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacions1(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacions1) {
		getLimpiezaDetalleProcesoBandejaAprobacions1().remove(limpiezaDetalleProcesoBandejaAprobacions1);
		limpiezaDetalleProcesoBandejaAprobacions1.setLimpiezaMaterial1(null);

		return limpiezaDetalleProcesoBandejaAprobacions1;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaMaterial2")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions2() {
		return this.limpiezaDetalleProcesoBandejaAprobacions2;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions2(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions2) {
		this.limpiezaDetalleProcesoBandejaAprobacions2 = limpiezaDetalleProcesoBandejaAprobacions2;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacions2(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacions2) {
		getLimpiezaDetalleProcesoBandejaAprobacions2().add(limpiezaDetalleProcesoBandejaAprobacions2);
		limpiezaDetalleProcesoBandejaAprobacions2.setLimpiezaMaterial2(this);

		return limpiezaDetalleProcesoBandejaAprobacions2;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacions2(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacions2) {
		getLimpiezaDetalleProcesoBandejaAprobacions2().remove(limpiezaDetalleProcesoBandejaAprobacions2);
		limpiezaDetalleProcesoBandejaAprobacions2.setLimpiezaMaterial2(null);

		return limpiezaDetalleProcesoBandejaAprobacions2;
	}

}