package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_opcion database table.
 * 
 */
@Entity
@Table(name="atc_opcion")
public class AtcOpcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idatcopcion;

	private String formulario;

	private String imagen;

	private String opcion;

	//bi-directional many-to-many association to AtcGrupo
	@ManyToMany
	@JoinTable(
		name="atc_grupo_opcion"
		, joinColumns={
			@JoinColumn(name="idatcopcion")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idatcgrupo")
			}
		)
	private List<AtcGrupo> atcGrupos;

	public AtcOpcion() {
	}

	public Integer getIdatcopcion() {
		return this.idatcopcion;
	}

	public void setIdatcopcion(Integer idatcopcion) {
		this.idatcopcion = idatcopcion;
	}

	public String getFormulario() {
		return this.formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getOpcion() {
		return this.opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public List<AtcGrupo> getAtcGrupos() {
		return this.atcGrupos;
	}

	public void setAtcGrupos(List<AtcGrupo> atcGrupos) {
		this.atcGrupos = atcGrupos;
	}

}