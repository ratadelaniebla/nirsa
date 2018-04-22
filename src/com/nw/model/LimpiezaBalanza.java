package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the limpieza_balanza database table.
 * 
 */
@Entity
@Table(name="limpieza_balanza")
public class LimpiezaBalanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezabalanza;

	private String descripcion;

	private Integer estado;

	private String idbalanza;

	private String ipbalanza;

	private Boolean lado1;

	private Boolean lado2;

	private Integer linea;

	private Integer puertobalanza;

	public LimpiezaBalanza() {
	}

	public Integer getIdlimpiezabalanza() {
		return this.idlimpiezabalanza;
	}

	public void setIdlimpiezabalanza(Integer idlimpiezabalanza) {
		this.idlimpiezabalanza = idlimpiezabalanza;
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

	public String getIdbalanza() {
		return this.idbalanza;
	}

	public void setIdbalanza(String idbalanza) {
		this.idbalanza = idbalanza;
	}

	public String getIpbalanza() {
		return this.ipbalanza;
	}

	public void setIpbalanza(String ipbalanza) {
		this.ipbalanza = ipbalanza;
	}

	public Boolean getLado1() {
		return this.lado1;
	}

	public void setLado1(Boolean lado1) {
		this.lado1 = lado1;
	}

	public Boolean getLado2() {
		return this.lado2;
	}

	public void setLado2(Boolean lado2) {
		this.lado2 = lado2;
	}

	public Integer getLinea() {
		return this.linea;
	}

	public void setLinea(Integer linea) {
		this.linea = linea;
	}

	public Integer getPuertobalanza() {
		return this.puertobalanza;
	}

	public void setPuertobalanza(Integer puertobalanza) {
		this.puertobalanza = puertobalanza;
	}

}