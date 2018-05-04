package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the eviscerado_tipo_subproducto database table.
 * 
 */
@Entity
@Table(name="eviscerado_tipo_subproducto")
@NamedQuery(name="EvisceradoTipoSubproducto.findAll", query="SELECT e FROM EvisceradoTipoSubproducto e")
public class EvisceradoTipoSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevisceradotiposubproducto;
	private String nombre;
	private double taracoche;
	private double taramedio;
	private List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos;

	public EvisceradoTipoSubproducto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdevisceradotiposubproducto() {
		return this.idevisceradotiposubproducto;
	}

	public void setIdevisceradotiposubproducto(Integer idevisceradotiposubproducto) {
		this.idevisceradotiposubproducto = idevisceradotiposubproducto;
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


	//bi-directional many-to-one association to EvisceradoSubproductoCrudo
	@OneToMany(mappedBy="evisceradoTipoSubproducto")
	public List<EvisceradoSubproductoCrudo> getEvisceradoSubproductoCrudos() {
		return this.evisceradoSubproductoCrudos;
	}

	public void setEvisceradoSubproductoCrudos(List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos) {
		this.evisceradoSubproductoCrudos = evisceradoSubproductoCrudos;
	}

	public EvisceradoSubproductoCrudo addEvisceradoSubproductoCrudo(EvisceradoSubproductoCrudo evisceradoSubproductoCrudo) {
		getEvisceradoSubproductoCrudos().add(evisceradoSubproductoCrudo);
		evisceradoSubproductoCrudo.setEvisceradoTipoSubproducto(this);

		return evisceradoSubproductoCrudo;
	}

	public EvisceradoSubproductoCrudo removeEvisceradoSubproductoCrudo(EvisceradoSubproductoCrudo evisceradoSubproductoCrudo) {
		getEvisceradoSubproductoCrudos().remove(evisceradoSubproductoCrudo);
		evisceradoSubproductoCrudo.setEvisceradoTipoSubproducto(null);

		return evisceradoSubproductoCrudo;
	}

}