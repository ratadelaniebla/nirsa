package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especie database table.
 * 
 */
@Entity
@NamedQuery(name="Especie.findAll", query="SELECT e FROM Especie e")
public class Especie implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idespecie;
	private String codigoqm;
	private String codigosapespecie;
	private String nombre;
	private List<EspecieTalla> especieTallas;

	public Especie() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EspecieTalla
	@OneToMany(mappedBy="especie")
	public List<EspecieTalla> getEspecieTallas() {
		return this.especieTallas;
	}

	public void setEspecieTallas(List<EspecieTalla> especieTallas) {
		this.especieTallas = especieTallas;
	}

	public EspecieTalla addEspecieTalla(EspecieTalla especieTalla) {
		getEspecieTallas().add(especieTalla);
		especieTalla.setEspecie(this);

		return especieTalla;
	}

	public EspecieTalla removeEspecieTalla(EspecieTalla especieTalla) {
		getEspecieTallas().remove(especieTalla);
		especieTalla.setEspecie(null);

		return especieTalla;
	}

}