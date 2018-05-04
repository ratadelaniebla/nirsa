package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_linea_grupo database table.
 * 
 */
@Entity
@Table(name="limpieza_linea_grupo")
@NamedQuery(name="LimpiezaLineaGrupo.findAll", query="SELECT l FROM LimpiezaLineaGrupo l")
public class LimpiezaLineaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezalineagrupo;
	private String nombregrupo;
	private LimpiezaGrupo limpiezaGrupo;
	private LimpiezaLinea limpiezaLinea;
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;

	public LimpiezaLineaGrupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlimpiezalineagrupo() {
		return this.idlimpiezalineagrupo;
	}

	public void setIdlimpiezalineagrupo(Integer idlimpiezalineagrupo) {
		this.idlimpiezalineagrupo = idlimpiezalineagrupo;
	}


	public String getNombregrupo() {
		return this.nombregrupo;
	}

	public void setNombregrupo(String nombregrupo) {
		this.nombregrupo = nombregrupo;
	}


	//bi-directional many-to-one association to LimpiezaGrupo
	@ManyToOne
	@JoinColumn(name="idlimpiezagrupo")
	public LimpiezaGrupo getLimpiezaGrupo() {
		return this.limpiezaGrupo;
	}

	public void setLimpiezaGrupo(LimpiezaGrupo limpiezaGrupo) {
		this.limpiezaGrupo = limpiezaGrupo;
	}


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="limpiezaLineaGrupo")
	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoEmpleados() {
		return this.limpiezaProcesoEmpleados;
	}

	public void setLimpiezaProcesoEmpleados(List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados) {
		this.limpiezaProcesoEmpleados = limpiezaProcesoEmpleados;
	}

	public LimpiezaProcesoEmpleado addLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().add(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setLimpiezaLineaGrupo(this);

		return limpiezaProcesoEmpleado;
	}

	public LimpiezaProcesoEmpleado removeLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().remove(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setLimpiezaLineaGrupo(null);

		return limpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="limpiezaLineaGrupo")
	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento addLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().add(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setLimpiezaLineaGrupo(this);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento removeLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().remove(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setLimpiezaLineaGrupo(null);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}

}