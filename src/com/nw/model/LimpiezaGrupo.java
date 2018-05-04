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
@NamedQuery(name="LimpiezaGrupo.findAll", query="SELECT l FROM LimpiezaGrupo l")
public class LimpiezaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezagrupo;
	private String descripcion;
	private List<LimpiezaLineaGrupo> limpiezaLineaGrupos;

	public LimpiezaGrupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaLineaGrupo
	@OneToMany(mappedBy="limpiezaGrupo")
	public List<LimpiezaLineaGrupo> getLimpiezaLineaGrupos() {
		return this.limpiezaLineaGrupos;
	}

	public void setLimpiezaLineaGrupos(List<LimpiezaLineaGrupo> limpiezaLineaGrupos) {
		this.limpiezaLineaGrupos = limpiezaLineaGrupos;
	}

	public LimpiezaLineaGrupo addLimpiezaLineaGrupo(LimpiezaLineaGrupo limpiezaLineaGrupo) {
		getLimpiezaLineaGrupos().add(limpiezaLineaGrupo);
		limpiezaLineaGrupo.setLimpiezaGrupo(this);

		return limpiezaLineaGrupo;
	}

	public LimpiezaLineaGrupo removeLimpiezaLineaGrupo(LimpiezaLineaGrupo limpiezaLineaGrupo) {
		getLimpiezaLineaGrupos().remove(limpiezaLineaGrupo);
		limpiezaLineaGrupo.setLimpiezaGrupo(null);

		return limpiezaLineaGrupo;
	}

}