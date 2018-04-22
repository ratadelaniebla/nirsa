package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_grupo database table.
 * 
 */
@Entity
@Table(name="limpieza_grupo")
public class LimpiezaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezagrupo;

	private String descripcion;

	//bi-directional many-to-one association to LimpiezaLineaGrupo
	@OneToMany(mappedBy="limpiezaGrupo")
	private List<LimpiezaLineaGrupo> limpiezaLineaGrupos;

	public LimpiezaGrupo() {
	}

	public Integer getIdlimpiezagrupo() {
		return this.idlimpiezagrupo;
	}

	public void setIdlimpiezagrupo(Integer idlimpiezagrupo) {
		this.idlimpiezagrupo = idlimpiezagrupo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LimpiezaLineaGrupo> getLimpiezaLineaGrupos() {
		return this.limpiezaLineaGrupos;
	}

	public void setLimpiezaLineaGrupos(List<LimpiezaLineaGrupo> limpiezaLineaGrupos) {
		this.limpiezaLineaGrupos = limpiezaLineaGrupos;
	}

}