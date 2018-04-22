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
public class AtcEvisceradoDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcevisceradodetalleprocesolote;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private Timestamp fechareg;

	//bi-directional many-to-one association to AtcEvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idatcevisceradoproceso")
	private AtcEvisceradoProceso atcEvisceradoProceso;

	//bi-directional many-to-one association to AtcProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idatcproducciondetallelotecajon")
	private AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	//bi-directional many-to-one association to AtcEvisceradoDetalleTempPanza
	@OneToMany(mappedBy="atcEvisceradoDetalleProcesoLote")
	private List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas;

	//bi-directional many-to-one association to AtcEvisceradoSubproductoCrudo
	@OneToMany(mappedBy="atcEvisceradoDetalleProcesoLote")
	private List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos;

	public AtcEvisceradoDetalleProcesoLote() {
	}

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

	public AtcEvisceradoProceso getAtcEvisceradoProceso() {
		return this.atcEvisceradoProceso;
	}

	public void setAtcEvisceradoProceso(AtcEvisceradoProceso atcEvisceradoProceso) {
		this.atcEvisceradoProceso = atcEvisceradoProceso;
	}

	public AtcProduccionDetalleLoteCajon getAtcProduccionDetalleLoteCajon() {
		return this.atcProduccionDetalleLoteCajon;
	}

	public void setAtcProduccionDetalleLoteCajon(AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon) {
		this.atcProduccionDetalleLoteCajon = atcProduccionDetalleLoteCajon;
	}

	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

	public List<AtcEvisceradoDetalleTempPanza> getAtcEvisceradoDetalleTempPanzas() {
		return this.atcEvisceradoDetalleTempPanzas;
	}

	public void setAtcEvisceradoDetalleTempPanzas(List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas) {
		this.atcEvisceradoDetalleTempPanzas = atcEvisceradoDetalleTempPanzas;
	}

	public List<AtcEvisceradoSubproductoCrudo> getAtcEvisceradoSubproductoCrudos() {
		return this.atcEvisceradoSubproductoCrudos;
	}

	public void setAtcEvisceradoSubproductoCrudos(List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos) {
		this.atcEvisceradoSubproductoCrudos = atcEvisceradoSubproductoCrudos;
	}

}