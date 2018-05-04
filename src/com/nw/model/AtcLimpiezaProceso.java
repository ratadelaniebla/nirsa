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
@NamedQuery(name="AtcLimpiezaProceso.findAll", query="SELECT a FROM AtcLimpiezaProceso a")
public class AtcLimpiezaProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezaproceso;
	private Integer estado;
	private Timestamp fechareg;
	private List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes;
	private AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo;
	private AtcProduccion atcProduccion;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;
	private List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados;
	private List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs;
	private List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos;

	public AtcLimpiezaProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="atcLimpiezaProceso")
	public List<AtcLimpiezaDetalleProcesoLote> getAtcLimpiezaDetalleProcesoLotes() {
		return this.atcLimpiezaDetalleProcesoLotes;
	}

	public void setAtcLimpiezaDetalleProcesoLotes(List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes) {
		this.atcLimpiezaDetalleProcesoLotes = atcLimpiezaDetalleProcesoLotes;
	}

	public AtcLimpiezaDetalleProcesoLote addAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		getAtcLimpiezaDetalleProcesoLotes().add(atcLimpiezaDetalleProcesoLote);
		atcLimpiezaDetalleProcesoLote.setAtcLimpiezaProceso(this);

		return atcLimpiezaDetalleProcesoLote;
	}

	public AtcLimpiezaDetalleProcesoLote removeAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		getAtcLimpiezaDetalleProcesoLotes().remove(atcLimpiezaDetalleProcesoLote);
		atcLimpiezaDetalleProcesoLote.setAtcLimpiezaProceso(null);

		return atcLimpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcProcesoAperturaCierreAtunCrudo
	@ManyToOne
	@JoinColumn(name="idatcprocesoaperturacierre")
	public AtcProcesoAperturaCierreAtunCrudo getAtcProcesoAperturaCierreAtunCrudo() {
		return this.atcProcesoAperturaCierreAtunCrudo;
	}

	public void setAtcProcesoAperturaCierreAtunCrudo(AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo) {
		this.atcProcesoAperturaCierreAtunCrudo = atcProcesoAperturaCierreAtunCrudo;
	}


	//bi-directional many-to-one association to AtcProduccion
	@ManyToOne
	@JoinColumn(name="idatcproduccion")
	public AtcProduccion getAtcProduccion() {
		return this.atcProduccion;
	}

	public void setAtcProduccion(AtcProduccion atcProduccion) {
		this.atcProduccion = atcProduccion;
	}


	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}


	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}


	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@OneToMany(mappedBy="atcLimpiezaProceso")
	public List<AtcLimpiezaProcesoEmpleado> getAtcLimpiezaProcesoEmpleados() {
		return this.atcLimpiezaProcesoEmpleados;
	}

	public void setAtcLimpiezaProcesoEmpleados(List<AtcLimpiezaProcesoEmpleado> atcLimpiezaProcesoEmpleados) {
		this.atcLimpiezaProcesoEmpleados = atcLimpiezaProcesoEmpleados;
	}

	public AtcLimpiezaProcesoEmpleado addAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		getAtcLimpiezaProcesoEmpleados().add(atcLimpiezaProcesoEmpleado);
		atcLimpiezaProcesoEmpleado.setAtcLimpiezaProceso(this);

		return atcLimpiezaProcesoEmpleado;
	}

	public AtcLimpiezaProcesoEmpleado removeAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		getAtcLimpiezaProcesoEmpleados().remove(atcLimpiezaProcesoEmpleado);
		atcLimpiezaProcesoEmpleado.setAtcLimpiezaProceso(null);

		return atcLimpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to AtcLimpiezaTempAguaLav
	@OneToMany(mappedBy="atcLimpiezaProceso")
	public List<AtcLimpiezaTempAguaLav> getAtcLimpiezaTempAguaLavs() {
		return this.atcLimpiezaTempAguaLavs;
	}

	public void setAtcLimpiezaTempAguaLavs(List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs) {
		this.atcLimpiezaTempAguaLavs = atcLimpiezaTempAguaLavs;
	}

	public AtcLimpiezaTempAguaLav addAtcLimpiezaTempAguaLav(AtcLimpiezaTempAguaLav atcLimpiezaTempAguaLav) {
		getAtcLimpiezaTempAguaLavs().add(atcLimpiezaTempAguaLav);
		atcLimpiezaTempAguaLav.setAtcLimpiezaProceso(this);

		return atcLimpiezaTempAguaLav;
	}

	public AtcLimpiezaTempAguaLav removeAtcLimpiezaTempAguaLav(AtcLimpiezaTempAguaLav atcLimpiezaTempAguaLav) {
		getAtcLimpiezaTempAguaLavs().remove(atcLimpiezaTempAguaLav);
		atcLimpiezaTempAguaLav.setAtcLimpiezaProceso(null);

		return atcLimpiezaTempAguaLav;
	}


	//bi-directional many-to-one association to AtcLimpiezaTempLomo
	@OneToMany(mappedBy="atcLimpiezaProceso")
	public List<AtcLimpiezaTempLomo> getAtcLimpiezaTempLomos() {
		return this.atcLimpiezaTempLomos;
	}

	public void setAtcLimpiezaTempLomos(List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos) {
		this.atcLimpiezaTempLomos = atcLimpiezaTempLomos;
	}

	public AtcLimpiezaTempLomo addAtcLimpiezaTempLomo(AtcLimpiezaTempLomo atcLimpiezaTempLomo) {
		getAtcLimpiezaTempLomos().add(atcLimpiezaTempLomo);
		atcLimpiezaTempLomo.setAtcLimpiezaProceso(this);

		return atcLimpiezaTempLomo;
	}

	public AtcLimpiezaTempLomo removeAtcLimpiezaTempLomo(AtcLimpiezaTempLomo atcLimpiezaTempLomo) {
		getAtcLimpiezaTempLomos().remove(atcLimpiezaTempLomo);
		atcLimpiezaTempLomo.setAtcLimpiezaProceso(null);

		return atcLimpiezaTempLomo;
	}

}