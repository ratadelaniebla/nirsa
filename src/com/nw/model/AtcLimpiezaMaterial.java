package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_material database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_material")
@NamedQuery(name="AtcLimpiezaMaterial.findAll", query="SELECT a FROM AtcLimpiezaMaterial a")
public class AtcLimpiezaMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idatclimpiezamaterial;
	private String nombre;
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;

	public AtcLimpiezaMaterial() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdatclimpiezamaterial() {
		return this.idatclimpiezamaterial;
	}

	public void setIdatclimpiezamaterial(Integer idatclimpiezamaterial) {
		this.idatclimpiezamaterial = idatclimpiezamaterial;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcLimpiezaMaterial")
	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public AtcLimpiezaDetalleBandeja addAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().add(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcLimpiezaMaterial(this);

		return atcLimpiezaDetalleBandeja;
	}

	public AtcLimpiezaDetalleBandeja removeAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().remove(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcLimpiezaMaterial(null);

		return atcLimpiezaDetalleBandeja;
	}

}