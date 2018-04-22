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
public class AtcGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idatcgrupo;

	private String grupo;

	//bi-directional many-to-many association to AtcOpcion
	@ManyToMany(mappedBy="atcGrupos")
	private List<AtcOpcion> atcOpcions;

	//bi-directional many-to-one association to AtcUsuario
	@OneToMany(mappedBy="atcGrupo")
	private List<AtcUsuario> atcUsuarios;

	public AtcGrupo() {
	}

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

	public List<AtcOpcion> getAtcOpcions() {
		return this.atcOpcions;
	}

	public void setAtcOpcions(List<AtcOpcion> atcOpcions) {
		this.atcOpcions = atcOpcions;
	}

	public List<AtcUsuario> getAtcUsuarios() {
		return this.atcUsuarios;
	}

	public void setAtcUsuarios(List<AtcUsuario> atcUsuarios) {
		this.atcUsuarios = atcUsuarios;
	}

}