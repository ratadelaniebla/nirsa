package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_produccion_detalle_lote_cajon database table.
 * 
 */
@Entity
@Table(name="atc_produccion_detalle_lote_cajon")
public class AtcProduccionDetalleLoteCajon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcproducciondetallelotecajon;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="atcProduccionDetalleLoteCajon")
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;

	//bi-directional many-to-one association to AtcEvisceradoDetalleProcesoLote
	@OneToMany(mappedBy="atcProduccionDetalleLoteCajon")
	private List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes;

	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idatcproducciondetallelote")
	private AtcProduccionDetalleLote atcProduccionDetalleLote;

	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	private CamaraCajon camaraCajon;

	public AtcProduccionDetalleLoteCajon() {
	}

	public Long getIdatcproducciondetallelotecajon() {
		return this.idatcproducciondetallelotecajon;
	}

	public void setIdatcproducciondetallelotecajon(Long idatcproducciondetallelotecajon) {
		this.idatcproducciondetallelotecajon = idatcproducciondetallelotecajon;
	}

	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public List<AtcEvisceradoDetalleProcesoLote> getAtcEvisceradoDetalleProcesoLotes() {
		return this.atcEvisceradoDetalleProcesoLotes;
	}

	public void setAtcEvisceradoDetalleProcesoLotes(List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes) {
		this.atcEvisceradoDetalleProcesoLotes = atcEvisceradoDetalleProcesoLotes;
	}

	public AtcProduccionDetalleLote getAtcProduccionDetalleLote() {
		return this.atcProduccionDetalleLote;
	}

	public void setAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		this.atcProduccionDetalleLote = atcProduccionDetalleLote;
	}

	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}

}