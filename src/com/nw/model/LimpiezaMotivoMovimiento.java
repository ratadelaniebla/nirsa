package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_motivo_movimiento database table.
 * 
 */
@Entity
@Table(name="limpieza_motivo_movimiento")
public class LimpiezaMotivoMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezamotivomovimiento;

	private String descripcion;

	private Integer tipo;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="limpiezaMotivoMovimiento")
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;

	public LimpiezaMotivoMovimiento() {
	}

	public Integer getIdlimpiezamotivomovimiento() {
		return this.idlimpiezamotivomovimiento;
	}

	public void setIdlimpiezamotivomovimiento(Integer idlimpiezamotivomovimiento) {
		this.idlimpiezamotivomovimiento = idlimpiezamotivomovimiento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

}