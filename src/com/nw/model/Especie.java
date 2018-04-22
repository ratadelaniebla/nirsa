package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especie database table.
 * 
 */
@Entity
public class Especie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idespecie;

	private String codigoqm;

	private String codigosapespecie;

	private String nombre;

	//bi-directional many-to-one association to EspecieTalla
	@OneToMany(mappedBy="especie")
	private List<EspecieTalla> especieTallas;

	public Especie() {
	}

	public Integer getIdespecie() {
		return this.idespecie;
	}

	public void setIdespecie(Integer idespecie) {
		this.idespecie = idespecie;
	}

	public String getCodigoqm() {
		return this.codigoqm;
	}

	public void setCodigoqm(String codigoqm) {
		this.codigoqm = codigoqm;
	}

	public String getCodigosapespecie() {
		return this.codigosapespecie;
	}

	public void setCodigosapespecie(String codigosapespecie) {
		this.codigosapespecie = codigosapespecie;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EspecieTalla> getEspecieTallas() {
		return this.especieTallas;
	}

	public void setEspecieTallas(List<EspecieTalla> especieTallas) {
		this.especieTallas = especieTallas;
	}

}