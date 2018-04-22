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
public class LonjasGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlonjasgrupo;

	private String descripcion;

	//bi-directional many-to-one association to LonjasLineaGrupo
	@OneToMany(mappedBy="lonjasGrupo")
	private List<LonjasLineaGrupo> lonjasLineaGrupos;

	public LonjasGrupo() {
	}

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

	public List<LonjasLineaGrupo> getLonjasLineaGrupos() {
		return this.lonjasLineaGrupos;
	}

	public void setLonjasLineaGrupos(List<LonjasLineaGrupo> lonjasLineaGrupos) {
		this.lonjasLineaGrupos = lonjasLineaGrupos;
	}

}