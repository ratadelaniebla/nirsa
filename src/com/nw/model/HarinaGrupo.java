package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the harina_grupo database table.
 * 
 */
@Entity
@Table(name="harina_grupo")
@NamedQuery(name="HarinaGrupo.findAll", query="SELECT h FROM HarinaGrupo h")
public class HarinaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idharinagrupo;
	private String decripcion;
	private Integer orden;
	private List<HarinaGrupoEspecie> harinaGrupoEspecies;

	public HarinaGrupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdharinagrupo() {
		return this.idharinagrupo;
	}

	public void setIdharinagrupo(Long idharinagrupo) {
		this.idharinagrupo = idharinagrupo;
	}


	public String getDecripcion() {
		return this.decripcion;
	}

	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}


	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}


	//bi-directional many-to-one association to HarinaGrupoEspecie
	@OneToMany(mappedBy="harinaGrupo")
	public List<HarinaGrupoEspecie> getHarinaGrupoEspecies() {
		return this.harinaGrupoEspecies;
	}

	public void setHarinaGrupoEspecies(List<HarinaGrupoEspecie> harinaGrupoEspecies) {
		this.harinaGrupoEspecies = harinaGrupoEspecies;
	}

	public HarinaGrupoEspecie addHarinaGrupoEspecy(HarinaGrupoEspecie harinaGrupoEspecy) {
		getHarinaGrupoEspecies().add(harinaGrupoEspecy);
		harinaGrupoEspecy.setHarinaGrupo(this);

		return harinaGrupoEspecy;
	}

	public HarinaGrupoEspecie removeHarinaGrupoEspecy(HarinaGrupoEspecie harinaGrupoEspecy) {
		getHarinaGrupoEspecies().remove(harinaGrupoEspecy);
		harinaGrupoEspecy.setHarinaGrupo(null);

		return harinaGrupoEspecy;
	}

}