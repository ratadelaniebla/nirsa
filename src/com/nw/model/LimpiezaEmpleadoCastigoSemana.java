package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_empleado_castigo_semana database table.
 * 
 */
@Entity
@Table(name="limpieza_empleado_castigo_semana")
public class LimpiezaEmpleadoCastigoSemana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaempleadocastigosemana;

	private Boolean castigo;

	private String cedula;

	private Timestamp fecharegisto;

	private Integer idempleado;

	private Long idproduccion;

	private Integer semana;

	public LimpiezaEmpleadoCastigoSemana() {
	}

	public Long getIdlimpiezaempleadocastigosemana() {
		return this.idlimpiezaempleadocastigosemana;
	}

	public void setIdlimpiezaempleadocastigosemana(Long idlimpiezaempleadocastigosemana) {
		this.idlimpiezaempleadocastigosemana = idlimpiezaempleadocastigosemana;
	}

	public Boolean getCastigo() {
		return this.castigo;
	}

	public void setCastigo(Boolean castigo) {
		this.castigo = castigo;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Timestamp getFecharegisto() {
		return this.fecharegisto;
	}

	public void setFecharegisto(Timestamp fecharegisto) {
		this.fecharegisto = fecharegisto;
	}

	public Integer getIdempleado() {
		return this.idempleado;
	}

	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public Long getIdproduccion() {
		return this.idproduccion;
	}

	public void setIdproduccion(Long idproduccion) {
		this.idproduccion = idproduccion;
	}

	public Integer getSemana() {
		return this.semana;
	}

	public void setSemana(Integer semana) {
		this.semana = semana;
	}

}