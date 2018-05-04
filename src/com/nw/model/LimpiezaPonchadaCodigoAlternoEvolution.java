package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the limpieza_ponchada_codigo_alterno_evolution database table.
 * 
 */
@Entity
@Table(name="limpieza_ponchada_codigo_alterno_evolution")
@NamedQuery(name="LimpiezaPonchadaCodigoAlternoEvolution.findAll", query="SELECT l FROM LimpiezaPonchadaCodigoAlternoEvolution l")
public class LimpiezaPonchadaCodigoAlternoEvolution implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcodigoalternoevolution;
	private String codigoevolutionasociado;
	private Integer idespecie;
	private Integer idevisceradopescadoporlata;
	private Integer idtipolimpieza;
	private Integer idturno;

	public LimpiezaPonchadaCodigoAlternoEvolution() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcodigoalternoevolution() {
		return this.idcodigoalternoevolution;
	}

	public void setIdcodigoalternoevolution(Integer idcodigoalternoevolution) {
		this.idcodigoalternoevolution = idcodigoalternoevolution;
	}


	public String getCodigoevolutionasociado() {
		return this.codigoevolutionasociado;
	}

	public void setCodigoevolutionasociado(String codigoevolutionasociado) {
		this.codigoevolutionasociado = codigoevolutionasociado;
	}


	public Integer getIdespecie() {
		return this.idespecie;
	}

	public void setIdespecie(Integer idespecie) {
		this.idespecie = idespecie;
	}


	public Integer getIdevisceradopescadoporlata() {
		return this.idevisceradopescadoporlata;
	}

	public void setIdevisceradopescadoporlata(Integer idevisceradopescadoporlata) {
		this.idevisceradopescadoporlata = idevisceradopescadoporlata;
	}


	public Integer getIdtipolimpieza() {
		return this.idtipolimpieza;
	}

	public void setIdtipolimpieza(Integer idtipolimpieza) {
		this.idtipolimpieza = idtipolimpieza;
	}


	public Integer getIdturno() {
		return this.idturno;
	}

	public void setIdturno(Integer idturno) {
		this.idturno = idturno;
	}

}