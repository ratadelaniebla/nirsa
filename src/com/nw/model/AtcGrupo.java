package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_grupo database table.
 * 
 */
@Entity
@Table(name="atc_grupo")
@NamedQuery(name="AtcGrupo.findAll", query="SELECT a FROM AtcGrupo a")
public class AtcGrupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idatcgrupo;
	private String grupo;
	private List<AtcOpcion> atcOpcions;
	private List<AtcUsuario> atcUsuarios;

	public AtcGrupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdatcgrupo() {
		return this.idatcgrupo;
	}

	public void setIdatcgrupo(Integer idatcgrupo) {
		this.idatcgrupo = idatcgrupo;
	}


	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	//bi-directional many-to-many association to AtcOpcion
	@ManyToMany(mappedBy="atcGrupos")
	public List<AtcOpcion> getAtcOpcions() {
		return this.atcOpcions;
	}

	public void setAtcOpcions(List<AtcOpcion> atcOpcions) {
		this.atcOpcions = atcOpcions;
	}


	//bi-directional many-to-one association to AtcUsuario
	@OneToMany(mappedBy="atcGrupo")
	public List<AtcUsuario> getAtcUsuarios() {
		return this.atcUsuarios;
	}

	public void setAtcUsuarios(List<AtcUsuario> atcUsuarios) {
		this.atcUsuarios = atcUsuarios;
	}

	public AtcUsuario addAtcUsuario(AtcUsuario atcUsuario) {
		getAtcUsuarios().add(atcUsuario);
		atcUsuario.setAtcGrupo(this);

		return atcUsuario;
	}

	public AtcUsuario removeAtcUsuario(AtcUsuario atcUsuario) {
		getAtcUsuarios().remove(atcUsuario);
		atcUsuario.setAtcGrupo(null);

		return atcUsuario;
	}

}