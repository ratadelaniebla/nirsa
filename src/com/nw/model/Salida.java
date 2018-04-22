package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the salidas database table.
 * 
 */
@Entity
@Table(name="salidas")
public class Salida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idempleadosalida;

	private String cedula;

	@Column(name="fecha_salida")
	private Timestamp fechaSalida;

	public Salida() {
	}

	public Long getIdempleadosalida() {
		return this.idempleadosalida;
	}

	public void setIdempleadosalida(Long idempleadosalida) {
		this.idempleadosalida = idempleadosalida;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Timestamp getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}