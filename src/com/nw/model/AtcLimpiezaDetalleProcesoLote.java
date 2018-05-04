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
@NamedQuery(name="AtcLimpiezaDetalleProcesoLote.findAll", query="SELECT a FROM AtcLimpiezaDetalleProcesoLote a")
public class AtcLimpiezaDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezadetalleprocesolote;
	private Integer estado;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;
	private AtcLimpiezaProceso atcLimpiezaProceso;
	private AtcProduccionDetalleLote atcProduccionDetalleLote;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;
	private List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs;
	private List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos;
	private List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos;

	public AtcLimpiezaDetalleProcesoLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcLimpiezaDetalleProcesoLote")
	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public AtcLimpiezaDetalleBandeja addAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().add(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcLimpiezaDetalleProcesoLote(this);

		return atcLimpiezaDetalleBandeja;
	}

	public AtcLimpiezaDetalleBandeja removeAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().remove(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcLimpiezaDetalleProcesoLote(null);

		return atcLimpiezaDetalleBandeja;
	}


	//bi-directional many-to-one association to AtcLimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idatclimpiezaproceso")
	public AtcLimpiezaProceso getAtcLimpiezaProceso() {
		return this.atcLimpiezaProceso;
	}

	public void setAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		this.atcLimpiezaProceso = atcLimpiezaProceso;
	}


	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idatcproducciondetallelote")
	public AtcProduccionDetalleLote getAtcProduccionDetalleLote() {
		return this.atcProduccionDetalleLote;
	}

	public void setAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		this.atcProduccionDetalleLote = atcProduccionDetalleLote;
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


	//bi-directional many-to-one association to AtcLimpiezaDetalleTempAguaLav
	@OneToMany(mappedBy="atcLimpiezaDetalleProcesoLote")
	public List<AtcLimpiezaDetalleTempAguaLav> getAtcLimpiezaDetalleTempAguaLavs() {
		return this.atcLimpiezaDetalleTempAguaLavs;
	}

	public void setAtcLimpiezaDetalleTempAguaLavs(List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs) {
		this.atcLimpiezaDetalleTempAguaLavs = atcLimpiezaDetalleTempAguaLavs;
	}

	public AtcLimpiezaDetalleTempAguaLav addAtcLimpiezaDetalleTempAguaLav(AtcLimpiezaDetalleTempAguaLav atcLimpiezaDetalleTempAguaLav) {
		getAtcLimpiezaDetalleTempAguaLavs().add(atcLimpiezaDetalleTempAguaLav);
		atcLimpiezaDetalleTempAguaLav.setAtcLimpiezaDetalleProcesoLote(this);

		return atcLimpiezaDetalleTempAguaLav;
	}

	public AtcLimpiezaDetalleTempAguaLav removeAtcLimpiezaDetalleTempAguaLav(AtcLimpiezaDetalleTempAguaLav atcLimpiezaDetalleTempAguaLav) {
		getAtcLimpiezaDetalleTempAguaLavs().remove(atcLimpiezaDetalleTempAguaLav);
		atcLimpiezaDetalleTempAguaLav.setAtcLimpiezaDetalleProcesoLote(null);

		return atcLimpiezaDetalleTempAguaLav;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleTempLomo
	@OneToMany(mappedBy="atcLimpiezaDetalleProcesoLote")
	public List<AtcLimpiezaDetalleTempLomo> getAtcLimpiezaDetalleTempLomos() {
		return this.atcLimpiezaDetalleTempLomos;
	}

	public void setAtcLimpiezaDetalleTempLomos(List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos) {
		this.atcLimpiezaDetalleTempLomos = atcLimpiezaDetalleTempLomos;
	}

	public AtcLimpiezaDetalleTempLomo addAtcLimpiezaDetalleTempLomo(AtcLimpiezaDetalleTempLomo atcLimpiezaDetalleTempLomo) {
		getAtcLimpiezaDetalleTempLomos().add(atcLimpiezaDetalleTempLomo);
		atcLimpiezaDetalleTempLomo.setAtcLimpiezaDetalleProcesoLote(this);

		return atcLimpiezaDetalleTempLomo;
	}

	public AtcLimpiezaDetalleTempLomo removeAtcLimpiezaDetalleTempLomo(AtcLimpiezaDetalleTempLomo atcLimpiezaDetalleTempLomo) {
		getAtcLimpiezaDetalleTempLomos().remove(atcLimpiezaDetalleTempLomo);
		atcLimpiezaDetalleTempLomo.setAtcLimpiezaDetalleProcesoLote(null);

		return atcLimpiezaDetalleTempLomo;
	}


	//bi-directional many-to-one association to AtcLimpiezaSubproductoCrudo
	@OneToMany(mappedBy="atcLimpiezaDetalleProcesoLote")
	public List<AtcLimpiezaSubproductoCrudo> getAtcLimpiezaSubproductoCrudos() {
		return this.atcLimpiezaSubproductoCrudos;
	}

	public void setAtcLimpiezaSubproductoCrudos(List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos) {
		this.atcLimpiezaSubproductoCrudos = atcLimpiezaSubproductoCrudos;
	}

	public AtcLimpiezaSubproductoCrudo addAtcLimpiezaSubproductoCrudo(AtcLimpiezaSubproductoCrudo atcLimpiezaSubproductoCrudo) {
		getAtcLimpiezaSubproductoCrudos().add(atcLimpiezaSubproductoCrudo);
		atcLimpiezaSubproductoCrudo.setAtcLimpiezaDetalleProcesoLote(this);

		return atcLimpiezaSubproductoCrudo;
	}

	public AtcLimpiezaSubproductoCrudo removeAtcLimpiezaSubproductoCrudo(AtcLimpiezaSubproductoCrudo atcLimpiezaSubproductoCrudo) {
		getAtcLimpiezaSubproductoCrudos().remove(atcLimpiezaSubproductoCrudo);
		atcLimpiezaSubproductoCrudo.setAtcLimpiezaDetalleProcesoLote(null);

		return atcLimpiezaSubproductoCrudo;
	}

}