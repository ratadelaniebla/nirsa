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
public class AtcLimpiezaMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idatclimpiezamaterial;

	private String nombre;

	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcLimpiezaMaterial")
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;

	public AtcLimpiezaMaterial() {
	}

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

	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

}