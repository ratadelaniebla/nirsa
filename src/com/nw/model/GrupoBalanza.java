package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grupo_balanza database table.
 * 
 */
@Entity
@Table(name="grupo_balanza")
@NamedQuery(name="GrupoBalanza.findAll", query="SELECT g FROM GrupoBalanza g")
public class GrupoBalanza implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idgrupobalanza;
	private Balanza balanza;
	private Grupo grupo;

	public GrupoBalanza() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdgrupobalanza() {
		return this.idgrupobalanza;
	}

	public void setIdgrupobalanza(Integer idgrupobalanza) {
		this.idgrupobalanza = idgrupobalanza;
	}


	//bi-directional many-to-one association to Balanza
	@ManyToOne
	@JoinColumn(name="idbalanza")
	public Balanza getBalanza() {
		return this.balanza;
	}

	public void setBalanza(Balanza balanza) {
		this.balanza = balanza;
	}


	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="idgrupo")
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}