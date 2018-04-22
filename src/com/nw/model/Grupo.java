package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idgrupo;

	private String grupo;

	//bi-directional many-to-one association to GrupoBalanza
	@OneToMany(mappedBy="grupo")
	private List<GrupoBalanza> grupoBalanzas;

	//bi-directional many-to-many association to Opcion
	@ManyToMany
	@JoinTable(
		name="grupo_opcion"
		, joinColumns={
			@JoinColumn(name="idgrupo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idopcion")
			}
		)
	private List<Opcion> opcions;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="grupo")
	private List<Usuario> usuarios;

	public Grupo() {
	}

	public Integer getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<GrupoBalanza> getGrupoBalanzas() {
		return this.grupoBalanzas;
	}

	public void setGrupoBalanzas(List<GrupoBalanza> grupoBalanzas) {
		this.grupoBalanzas = grupoBalanzas;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}