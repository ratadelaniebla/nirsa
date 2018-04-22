package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grupo_balanza database table.
 * 
 */
@Entity
@Table(name="grupo_balanza")
public class GrupoBalanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idgrupobalanza;

	//bi-directional many-to-one association to Balanza
	@ManyToOne
	@JoinColumn(name="idbalanza")
	private Balanza balanza;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="idgrupo")
	private Grupo grupo;

	public GrupoBalanza() {
	}

	public Integer getIdgrupobalanza() {
		return this.idgrupobalanza;
	}

	public void setIdgrupobalanza(Integer idgrupobalanza) {
		this.idgrupobalanza = idgrupobalanza;
	}

	public Balanza getBalanza() {
		return this.balanza;
	}

	public void setBalanza(Balanza balanza) {
		this.balanza = balanza;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}