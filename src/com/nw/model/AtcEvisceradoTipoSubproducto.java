package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_eviscerado_tipo_subproducto database table.
 * 
 */
@Entity
@Table(name="atc_eviscerado_tipo_subproducto")
public class AtcEvisceradoTipoSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idatcevisceradotiposubproducto;

	private String nombre;

	private double taracoche;

	private double taramedio;

	//bi-directional many-to-one association to AtcEvisceradoSubproductoCrudo
	@OneToMany(mappedBy="atcEvisceradoTipoSubproducto")
	private List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos;

	public AtcEvisceradoTipoSubproducto() {
	}

	public Integer getIdatcevisceradotiposubproducto() {
		return this.idatcevisceradotiposubproducto;
	}

	public void setIdatcevisceradotiposubproducto(Integer idatcevisceradotiposubproducto) {
		this.idatcevisceradotiposubproducto = idatcevisceradotiposubproducto;
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

	public List<AtcEvisceradoSubproductoCrudo> getAtcEvisceradoSubproductoCrudos() {
		return this.atcEvisceradoSubproductoCrudos;
	}

	public void setAtcEvisceradoSubproductoCrudos(List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos) {
		this.atcEvisceradoSubproductoCrudos = atcEvisceradoSubproductoCrudos;
	}

}