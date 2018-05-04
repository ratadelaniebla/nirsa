package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_eviscerado_detalle_proceso_lote database table.
 * 
 */
@Entity
@Table(name="atc_eviscerado_detalle_proceso_lote")
@NamedQuery(name="AtcEvisceradoDetalleProcesoLote.findAll", query="SELECT a FROM AtcEvisceradoDetalleProcesoLote a")
public class AtcEvisceradoDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcevisceradodetalleprocesolote;
	private Integer estado;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private Timestamp fechareg;
	private AtcEvisceradoProceso atcEvisceradoProceso;
	private AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon;
	private AtcUsuario atcUsuario;
	private List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas;
	private List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos;

	public AtcEvisceradoDetalleProcesoLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcevisceradodetalleprocesolote() {
		return this.idatcevisceradodetalleprocesolote;
	}

	public void setIdatcevisceradodetalleprocesolote(Long idatcevisceradodetalleprocesolote) {
		this.idatcevisceradodetalleprocesolote = idatcevisceradodetalleprocesolote;
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


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to AtcEvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idatcevisceradoproceso")
	public AtcEvisceradoProceso getAtcEvisceradoProceso() {
		return this.atcEvisceradoProceso;
	}

	public void setAtcEvisceradoProceso(AtcEvisceradoProceso atcEvisceradoProceso) {
		this.atcEvisceradoProceso = atcEvisceradoProceso;
	}


	//bi-directional many-to-one association to AtcProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idatcproducciondetallelotecajon")
	public AtcProduccionDetalleLoteCajon getAtcProduccionDetalleLoteCajon() {
		return this.atcProduccionDetalleLoteCajon;
	}

	public void setAtcProduccionDetalleLoteCajon(AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon) {
		this.atcProduccionDetalleLoteCajon = atcProduccionDetalleLoteCajon;
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


	//bi-directional many-to-one association to AtcEvisceradoDetalleTempPanza
	@OneToMany(mappedBy="atcEvisceradoDetalleProcesoLote")
	public List<AtcEvisceradoDetalleTempPanza> getAtcEvisceradoDetalleTempPanzas() {
		return this.atcEvisceradoDetalleTempPanzas;
	}

	public void setAtcEvisceradoDetalleTempPanzas(List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas) {
		this.atcEvisceradoDetalleTempPanzas = atcEvisceradoDetalleTempPanzas;
	}

	public AtcEvisceradoDetalleTempPanza addAtcEvisceradoDetalleTempPanza(AtcEvisceradoDetalleTempPanza atcEvisceradoDetalleTempPanza) {
		getAtcEvisceradoDetalleTempPanzas().add(atcEvisceradoDetalleTempPanza);
		atcEvisceradoDetalleTempPanza.setAtcEvisceradoDetalleProcesoLote(this);

		return atcEvisceradoDetalleTempPanza;
	}

	public AtcEvisceradoDetalleTempPanza removeAtcEvisceradoDetalleTempPanza(AtcEvisceradoDetalleTempPanza atcEvisceradoDetalleTempPanza) {
		getAtcEvisceradoDetalleTempPanzas().remove(atcEvisceradoDetalleTempPanza);
		atcEvisceradoDetalleTempPanza.setAtcEvisceradoDetalleProcesoLote(null);

		return atcEvisceradoDetalleTempPanza;
	}


	//bi-directional many-to-one association to AtcEvisceradoSubproductoCrudo
	@OneToMany(mappedBy="atcEvisceradoDetalleProcesoLote")
	public List<AtcEvisceradoSubproductoCrudo> getAtcEvisceradoSubproductoCrudos() {
		return this.atcEvisceradoSubproductoCrudos;
	}

	public void setAtcEvisceradoSubproductoCrudos(List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos) {
		this.atcEvisceradoSubproductoCrudos = atcEvisceradoSubproductoCrudos;
	}

	public AtcEvisceradoSubproductoCrudo addAtcEvisceradoSubproductoCrudo(AtcEvisceradoSubproductoCrudo atcEvisceradoSubproductoCrudo) {
		getAtcEvisceradoSubproductoCrudos().add(atcEvisceradoSubproductoCrudo);
		atcEvisceradoSubproductoCrudo.setAtcEvisceradoDetalleProcesoLote(this);

		return atcEvisceradoSubproductoCrudo;
	}

	public AtcEvisceradoSubproductoCrudo removeAtcEvisceradoSubproductoCrudo(AtcEvisceradoSubproductoCrudo atcEvisceradoSubproductoCrudo) {
		getAtcEvisceradoSubproductoCrudos().remove(atcEvisceradoSubproductoCrudo);
		atcEvisceradoSubproductoCrudo.setAtcEvisceradoDetalleProcesoLote(null);

		return atcEvisceradoSubproductoCrudo;
	}

}