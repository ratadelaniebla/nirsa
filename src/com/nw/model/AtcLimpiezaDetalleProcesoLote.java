package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_detalle_proceso_lote database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_detalle_proceso_lote")
public class AtcLimpiezaDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatclimpiezadetalleprocesolote;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcLimpiezaDetalleProcesoLote")
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;

	//bi-directional many-to-one association to AtcLimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idatclimpiezaproceso")
	private AtcLimpiezaProceso atcLimpiezaProceso;

	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idatcproducciondetallelote")
	private AtcProduccionDetalleLote atcProduccionDetalleLote;

	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	private AtcTurno atcTurno;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	//bi-directional many-to-one association to AtcLimpiezaDetalleTempAguaLav
	@OneToMany(mappedBy="atcLimpiezaDetalleProcesoLote")
	private List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs;

	//bi-directional many-to-one association to AtcLimpiezaDetalleTempLomo
	@OneToMany(mappedBy="atcLimpiezaDetalleProcesoLote")
	private List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos;

	//bi-directional many-to-one association to AtcLimpiezaSubproductoCrudo
	@OneToMany(mappedBy="atcLimpiezaDetalleProcesoLote")
	private List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos;

	public AtcLimpiezaDetalleProcesoLote() {
	}

	public Long getIdatclimpiezadetalleprocesolote() {
		return this.idatclimpiezadetalleprocesolote;
	}

	public void setIdatclimpiezadetalleprocesolote(Long idatclimpiezadetalleprocesolote) {
		this.idatclimpiezadetalleprocesolote = idatclimpiezadetalleprocesolote;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public AtcLimpiezaProceso getAtcLimpiezaProceso() {
		return this.atcLimpiezaProceso;
	}

	public void setAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		this.atcLimpiezaProceso = atcLimpiezaProceso;
	}

	public AtcProduccionDetalleLote getAtcProduccionDetalleLote() {
		return this.atcProduccionDetalleLote;
	}

	public void setAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		this.atcProduccionDetalleLote = atcProduccionDetalleLote;
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

	public List<AtcLimpiezaDetalleTempAguaLav> getAtcLimpiezaDetalleTempAguaLavs() {
		return this.atcLimpiezaDetalleTempAguaLavs;
	}

	public void setAtcLimpiezaDetalleTempAguaLavs(List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs) {
		this.atcLimpiezaDetalleTempAguaLavs = atcLimpiezaDetalleTempAguaLavs;
	}

	public List<AtcLimpiezaDetalleTempLomo> getAtcLimpiezaDetalleTempLomos() {
		return this.atcLimpiezaDetalleTempLomos;
	}

	public void setAtcLimpiezaDetalleTempLomos(List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos) {
		this.atcLimpiezaDetalleTempLomos = atcLimpiezaDetalleTempLomos;
	}

	public List<AtcLimpiezaSubproductoCrudo> getAtcLimpiezaSubproductoCrudos() {
		return this.atcLimpiezaSubproductoCrudos;
	}

	public void setAtcLimpiezaSubproductoCrudos(List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos) {
		this.atcLimpiezaSubproductoCrudos = atcLimpiezaSubproductoCrudos;
	}

}