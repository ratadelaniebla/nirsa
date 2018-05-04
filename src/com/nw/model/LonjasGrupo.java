package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lonjas_grupo database table.
 * 
 */
@Entity
@Table(name="lonjas_grupo")
@NamedQuery(name="LonjasGrupo.findAll", query="SELECT l FROM LonjasGrupo l")
public class LonjasGrupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlonjasgrupo;
	private String descripcion;
	private List<LonjasLineaGrupo> lonjasLineaGrupos;

	public LonjasGrupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlonjasgrupo() {
		return this.idlonjasgrupo;
	}

	public void setIdlonjasgrupo(Integer idlonjasgrupo) {
		this.idlonjasgrupo = idlonjasgrupo;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to LonjasLineaGrupo
	@OneToMany(mappedBy="lonjasGrupo")
	public List<LonjasLineaGrupo> getLonjasLineaGrupos() {
		return this.lonjasLineaGrupos;
	}

	public void setLonjasLineaGrupos(List<LonjasLineaGrupo> lonjasLineaGrupos) {
		this.lonjasLineaGrupos = lonjasLineaGrupos;
	}

	public LonjasLineaGrupo addLonjasLineaGrupo(LonjasLineaGrupo lonjasLineaGrupo) {
		getLonjasLineaGrupos().add(lonjasLineaGrupo);
		lonjasLineaGrupo.setLonjasGrupo(this);

		return lonjasLineaGrupo;
	}

	public LonjasLineaGrupo removeLonjasLineaGrupo(LonjasLineaGrupo lonjasLineaGrupo) {
		getLonjasLineaGrupos().remove(lonjasLineaGrupo);
		lonjasLineaGrupo.setLonjasGrupo(null);

		return lonjasLineaGrupo;
	}

}