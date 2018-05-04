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
@NamedQuery(name="AtcEvisceradoTipoSubproducto.findAll", query="SELECT a FROM AtcEvisceradoTipoSubproducto a")
public class AtcEvisceradoTipoSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idatcevisceradotiposubproducto;
	private String nombre;
	private double taracoche;
	private double taramedio;
	private List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos;

	public AtcEvisceradoTipoSubproducto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcEvisceradoSubproductoCrudo
	@OneToMany(mappedBy="atcEvisceradoTipoSubproducto")
	public List<AtcEvisceradoSubproductoCrudo> getAtcEvisceradoSubproductoCrudos() {
		return this.atcEvisceradoSubproductoCrudos;
	}

	public void setAtcEvisceradoSubproductoCrudos(List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos) {
		this.atcEvisceradoSubproductoCrudos = atcEvisceradoSubproductoCrudos;
	}

	public AtcEvisceradoSubproductoCrudo addAtcEvisceradoSubproductoCrudo(AtcEvisceradoSubproductoCrudo atcEvisceradoSubproductoCrudo) {
		getAtcEvisceradoSubproductoCrudos().add(atcEvisceradoSubproductoCrudo);
		atcEvisceradoSubproductoCrudo.setAtcEvisceradoTipoSubproducto(this);

		return atcEvisceradoSubproductoCrudo;
	}

	public AtcEvisceradoSubproductoCrudo removeAtcEvisceradoSubproductoCrudo(AtcEvisceradoSubproductoCrudo atcEvisceradoSubproductoCrudo) {
		getAtcEvisceradoSubproductoCrudos().remove(atcEvisceradoSubproductoCrudo);
		atcEvisceradoSubproductoCrudo.setAtcEvisceradoTipoSubproducto(null);

		return atcEvisceradoSubproductoCrudo;
	}

}