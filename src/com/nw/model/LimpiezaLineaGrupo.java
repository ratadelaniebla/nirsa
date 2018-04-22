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
public class LimpiezaLineaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezalineagrupo;

	private String nombregrupo;

	//bi-directional many-to-one association to LimpiezaGrupo
	@ManyToOne
	@JoinColumn(name="idlimpiezagrupo")
	private LimpiezaGrupo limpiezaGrupo;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="limpiezaLineaGrupo")
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="limpiezaLineaGrupo")
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;

	public LimpiezaLineaGrupo() {
	}

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

	public LimpiezaGrupo getLimpiezaGrupo() {
		return this.limpiezaGrupo;
	}

	public void setLimpiezaGrupo(LimpiezaGrupo limpiezaGrupo) {
		this.limpiezaGrupo = limpiezaGrupo;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoEmpleados() {
		return this.limpiezaProcesoEmpleados;
	}

	public void setLimpiezaProcesoEmpleados(List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados) {
		this.limpiezaProcesoEmpleados = limpiezaProcesoEmpleados;
	}

	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

}