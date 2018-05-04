package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evolution_procesos database table.
 * 
 */
@Entity
@Table(name="evolution_procesos")
@NamedQuery(name="EvolutionProceso.findAll", query="SELECT e FROM EvolutionProceso e")
public class EvolutionProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevolutionprocesos;
	private String codigoevolution;
	private String descripcion;
	private Integer estado;
	private Integer idevisceradocorte;
	private Integer idevisceradopescadoslata;
	private String idgrupoadam;
	private String idlimpiezaadam;
	private Integer idtipolimpieza;
	private Integer idtipotarifa;
	private Integer idturno;

	public EvolutionProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdevolutionprocesos() {
		return this.idevolutionprocesos;
	}

	public void setIdevolutionprocesos(Integer idevolutionprocesos) {
		this.idevolutionprocesos = idevolutionprocesos;
	}


	public String getCodigoevolution() {
		return this.codigoevolution;
	}

	public void setCodigoevolution(String codigoevolution) {
		this.codigoevolution = codigoevolution;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Integer getIdevisceradocorte() {
		return this.idevisceradocorte;
	}

	public void setIdevisceradocorte(Integer idevisceradocorte) {
		this.idevisceradocorte = idevisceradocorte;
	}


	public Integer getIdevisceradopescadoslata() {
		return this.idevisceradopescadoslata;
	}

	public void setIdevisceradopescadoslata(Integer idevisceradopescadoslata) {
		this.idevisceradopescadoslata = idevisceradopescadoslata;
	}


	public String getIdgrupoadam() {
		return this.idgrupoadam;
	}

	public void setIdgrupoadam(String idgrupoadam) {
		this.idgrupoadam = idgrupoadam;
	}


	public String getIdlimpiezaadam() {
		return this.idlimpiezaadam;
	}

	public void setIdlimpiezaadam(String idlimpiezaadam) {
		this.idlimpiezaadam = idlimpiezaadam;
	}


	public Integer getIdtipolimpieza() {
		return this.idtipolimpieza;
	}

	public void setIdtipolimpieza(Integer idtipolimpieza) {
		this.idtipolimpieza = idtipolimpieza;
	}


	public Integer getIdtipotarifa() {
		return this.idtipotarifa;
	}

	public void setIdtipotarifa(Integer idtipotarifa) {
		this.idtipotarifa = idtipotarifa;
	}


	public Integer getIdturno() {
		return this.idturno;
	}

	public void setIdturno(Integer idturno) {
		this.idturno = idturno;
	}

}