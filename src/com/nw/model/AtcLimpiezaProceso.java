package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_proceso database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_proceso")
public class AtcLimpiezaProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatclimpiezaproceso;

	private Integer estado;

	private Timestamp fechareg;

	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="atcLimpiezaProceso")
	private List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes;

	//bi-directional many-to-one association to AtcProcesoAperturaCierreAtunCrudo
	@ManyToOne
	@JoinColumn(name="idatcprocesoaperturacierre")
	private AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo;

	//bi-directional many-to-one association to AtcProduccion
	@ManyToOne
	@JoinColumn(name="idatcproduccion")
	private AtcProduccion atcProduccion;

	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	private AtcTurno atcTurno;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@OneToMany(mappedBy="atcLimpiezaProceso")
	private List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados;

	//bi-directional many-to-one association to AtcLimpiezaTempAguaLav
	@OneToMany(mappedBy="atcLimpiezaProceso")
	private List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs;

	//bi-directional many-to-one association to AtcLimpiezaTempLomo
	@OneToMany(mappedBy="atcLimpiezaProceso")
	private List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos;

	public AtcLimpiezaProceso() {
	}

	public Long getIdatclimpiezaproceso() {
		return this.idatclimpiezaproceso;
	}

	public void setIdatclimpiezaproceso(Long idatclimpiezaproceso) {
		this.idatclimpiezaproceso = idatclimpiezaproceso;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<AtcLimpiezaDetalleProcesoLote> getAtcLimpiezaDetalleProcesoLotes() {
		return this.atcLimpiezaDetalleProcesoLotes;
	}

	public void setAtcLimpiezaDetalleProcesoLotes(List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes) {
		this.atcLimpiezaDetalleProcesoLotes = atcLimpiezaDetalleProcesoLotes;
	}

	public AtcProcesoAperturaCierreAtunCrudo getAtcProcesoAperturaCierreAtunCrudo() {
		return this.atcProcesoAperturaCierreAtunCrudo;
	}

	public void setAtcProcesoAperturaCierreAtunCrudo(AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo) {
		this.atcProcesoAperturaCierreAtunCrudo = atcProcesoAperturaCierreAtunCrudo;
	}

	public AtcProduccion getAtcProduccion() {
		return this.atcProduccion;
	}

	public void setAtcProduccion(AtcProduccion atcProduccion) {
		this.atcProduccion = atcProduccion;
	}

	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}

	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

	public List<AtcLimpiezaProcesoEmpleado> getAtcLimpiezaProcesoEmpleados() {
		return this.atcLimpiezaProcesoEmpleados;
	}

	public void setAtcLimpiezaProcesoEmpleados(List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados) {
		this.atcLimpiezaProcesoEmpleados = atcLimpiezaProcesoEmpleados;
	}

	public List<AtcLimpiezaTempAguaLav> getAtcLimpiezaTempAguaLavs() {
		return this.atcLimpiezaTempAguaLavs;
	}

	public void setAtcLimpiezaTempAguaLavs(List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs) {
		this.atcLimpiezaTempAguaLavs = atcLimpiezaTempAguaLavs;
	}

	public List<AtcLimpiezaTempLomo> getAtcLimpiezaTempLomos() {
		return this.atcLimpiezaTempLomos;
	}

	public void setAtcLimpiezaTempLomos(List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos) {
		this.atcLimpiezaTempLomos = atcLimpiezaTempLomos;
	}

}