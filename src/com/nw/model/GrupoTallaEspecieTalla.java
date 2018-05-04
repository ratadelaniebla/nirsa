package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grupo_talla_especie_talla database table.
 * 
 */
@Entity
@Table(name="grupo_talla_especie_talla")
@NamedQuery(name="GrupoTallaEspecieTalla.findAll", query="SELECT g FROM GrupoTallaEspecieTalla g")
public class GrupoTallaEspecieTalla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idgrupotallaespecietalla;
	private EspecieTalla especieTalla;
	private GrupoTalla grupoTalla;

	public GrupoTallaEspecieTalla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdgrupotallaespecietalla() {
		return this.idgrupotallaespecietalla;
	}

	public void setIdgrupotallaespecietalla(Integer idgrupotallaespecietalla) {
		this.idgrupotallaespecietalla = idgrupotallaespecietalla;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}


	//bi-directional many-to-one association to GrupoTalla
	@ManyToOne
	@JoinColumn(name="idgrupotalla")
	public GrupoTalla getGrupoTalla() {
		return this.grupoTalla;
	}

	public void setGrupoTalla(GrupoTalla grupoTalla) {
		this.grupoTalla = grupoTalla;
	}

}