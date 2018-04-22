package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the evolution_archivo_carga_adam database table.
 * 
 */
@Entity
@Table(name="evolution_archivo_carga_adam")
public class EvolutionArchivoCargaAdam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevolutionarchivocargaadam;

	private Timestamp fecharegistro;

	private String usuario;

	public EvolutionArchivoCargaAdam() {
	}

	public Long getIdevolutionarchivocargaadam() {
		return this.idevolutionarchivocargaadam;
	}

	public void setIdevolutionarchivocargaadam(Long idevolutionarchivocargaadam) {
		this.idevolutionarchivocargaadam = idevolutionarchivocargaadam;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}