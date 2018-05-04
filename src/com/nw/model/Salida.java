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
@NamedQuery(name="Salida.findAll", query="SELECT s FROM Salida s")
public class Salida implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idempleadosalida;
	private String cedula;
	private Timestamp fechaSalida;

	public Salida() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="fecha_salida")
	public Timestamp getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}