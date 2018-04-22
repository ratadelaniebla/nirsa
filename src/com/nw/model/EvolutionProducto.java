package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evolution_productos database table.
 * 
 */
@Entity
@Table(name="evolution_productos")
public class EvolutionProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idevolutionproductos;

	private String codigoapariencia;

	private String codigoevolution;

	private String codigotalla;

	private String codigounidad;

	@Column(name="\"descripcion evolution\"")
	private String descripcion_evolution;

	private Integer estado;

	private Integer idevisceradocorte;

	private String idgrupoadam;

	private Integer idturno;

	public EvolutionProducto() {
	}

	public Integer getIdevolutionproductos() {
		return this.idevolutionproductos;
	}

	public void setIdevolutionproductos(Integer idevolutionproductos) {
		this.idevolutionproductos = idevolutionproductos;
	}

	public String getCodigoapariencia() {
		return this.codigoapariencia;
	}

	public void setCodigoapariencia(String codigoapariencia) {
		this.codigoapariencia = codigoapariencia;
	}

	public String getCodigoevolution() {
		return this.codigoevolution;
	}

	public void setCodigoevolution(String codigoevolution) {
		this.codigoevolution = codigoevolution;
	}

	public String getCodigotalla() {
		return this.codigotalla;
	}

	public void setCodigotalla(String codigotalla) {
		this.codigotalla = codigotalla;
	}

	public String getCodigounidad() {
		return this.codigounidad;
	}

	public void setCodigounidad(String codigounidad) {
		this.codigounidad = codigounidad;
	}

	public String getDescripcion_evolution() {
		return this.descripcion_evolution;
	}

	public void setDescripcion_evolution(String descripcion_evolution) {
		this.descripcion_evolution = descripcion_evolution;
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

	public String getIdgrupoadam() {
		return this.idgrupoadam;
	}

	public void setIdgrupoadam(String idgrupoadam) {
		this.idgrupoadam = idgrupoadam;
	}

	public Integer getIdturno() {
		return this.idturno;
	}

	public void setIdturno(Integer idturno) {
		this.idturno = idturno;
	}

}