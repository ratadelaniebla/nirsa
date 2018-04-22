package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grupo_talla_especie_talla database table.
 * 
 */
@Entity
@Table(name="grupo_talla_especie_talla")
public class GrupoTallaEspecieTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idgrupotallaespecietalla;

	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	private EspecieTalla especieTalla;

	//bi-directional many-to-one association to GrupoTalla
	@ManyToOne
	@JoinColumn(name="idgrupotalla")
	private GrupoTalla grupoTalla;

	public GrupoTallaEspecieTalla() {
	}

	public Integer getIdgrupotallaespecietalla() {
		return this.idgrupotallaespecietalla;
	}

	public void setIdgrupotallaespecietalla(Integer idgrupotallaespecietalla) {
		this.idgrupotallaespecietalla = idgrupotallaespecietalla;
	}

	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}

	public GrupoTalla getGrupoTalla() {
		return this.grupoTalla;
	}

	public void setGrupoTalla(GrupoTalla grupoTalla) {
		this.grupoTalla = grupoTalla;
	}

}