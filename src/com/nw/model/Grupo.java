package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idgrupo;
	private String grupo;
	private List<Opcion> opcions;
	private List<GrupoBalanza> grupoBalanzas;
	private List<Usuario> usuarios;

	public Grupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}


	//bi-directional many-to-one association to GrupoBalanza
	@OneToMany(mappedBy="grupo")
	public List<GrupoBalanza> getGrupoBalanzas() {
		return this.grupoBalanzas;
	}

	public void setGrupoBalanzas(List<GrupoBalanza> grupoBalanzas) {
		this.grupoBalanzas = grupoBalanzas;
	}

	public GrupoBalanza addGrupoBalanza(GrupoBalanza grupoBalanza) {
		getGrupoBalanzas().add(grupoBalanza);
		grupoBalanza.setGrupo(this);

		return grupoBalanza;
	}

	public GrupoBalanza removeGrupoBalanza(GrupoBalanza grupoBalanza) {
		getGrupoBalanzas().remove(grupoBalanza);
		grupoBalanza.setGrupo(null);

		return grupoBalanza;
	}


	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="grupo")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setGrupo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setGrupo(null);

		return usuario;
	}

}