package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_tipo_subproducto database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_tipo_subproducto")
public class AtcLimpiezaTipoSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idatclimpiezatiposubproducto;

	private String nombre;

	private double taracoche;

	private double taramedio;

	//bi-directional many-to-one association to AtcLimpiezaSubproductoCrudo
	@OneToMany(mappedBy="atcLimpiezaTipoSubproducto")
	private List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos;

	public AtcLimpiezaTipoSubproducto() {
	}

	public Integer getIdatclimpiezatiposubproducto() {
		return this.idatclimpiezatiposubproducto;
	}

	public void setIdatclimpiezatiposubproducto(Integer idatclimpiezatiposubproducto) {
		this.idatclimpiezatiposubproducto = idatclimpiezatiposubproducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTaracoche() {
		return this.taracoche;
	}

	public void setTaracoche(double taracoche) {
		this.taracoche = taracoche;
	}

	public double getTaramedio() {
		return this.taramedio;
	}

	public void setTaramedio(double taramedio) {
		this.taramedio = taramedio;
	}

	public List<AtcLimpiezaSubproductoCrudo> getAtcLimpiezaSubproductoCrudos() {
		return this.atcLimpiezaSubproductoCrudos;
	}

	public void setAtcLimpiezaSubproductoCrudos(List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos) {
		this.atcLimpiezaSubproductoCrudos = atcLimpiezaSubproductoCrudos;
	}

}