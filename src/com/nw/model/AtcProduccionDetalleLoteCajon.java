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
@NamedQuery(name="AtcProduccionDetalleLoteCajon.findAll", query="SELECT a FROM AtcProduccionDetalleLoteCajon a")
public class AtcProduccionDetalleLoteCajon implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcproducciondetallelotecajon;
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;
	private List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes;
	private AtcProduccionDetalleLote atcProduccionDetalleLote;
	private CamaraCajon camaraCajon;

	public AtcProduccionDetalleLoteCajon() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcproducciondetallelotecajon() {
		return this.idatcproducciondetallelotecajon;
	}

	public void setIdatcproducciondetallelotecajon(Long idatcproducciondetallelotecajon) {
		this.idatcproducciondetallelotecajon = idatcproducciondetallelotecajon;
	}


	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="atcProduccionDetalleLoteCajon")
	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public AtcDescongeladoDetalleProceso addAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().add(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setAtcProduccionDetalleLoteCajon(this);

		return atcDescongeladoDetalleProceso;
	}

	public AtcDescongeladoDetalleProceso removeAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().remove(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setAtcProduccionDetalleLoteCajon(null);

		return atcDescongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to AtcEvisceradoDetalleProcesoLote
	@OneToMany(mappedBy="atcProduccionDetalleLoteCajon")
	public List<AtcEvisceradoDetalleProcesoLote> getAtcEvisceradoDetalleProcesoLotes() {
		return this.atcEvisceradoDetalleProcesoLotes;
	}

	public void setAtcEvisceradoDetalleProcesoLotes(List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes) {
		this.atcEvisceradoDetalleProcesoLotes = atcEvisceradoDetalleProcesoLotes;
	}

	public AtcEvisceradoDetalleProcesoLote addAtcEvisceradoDetalleProcesoLote(AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote) {
		getAtcEvisceradoDetalleProcesoLotes().add(atcEvisceradoDetalleProcesoLote);
		atcEvisceradoDetalleProcesoLote.setAtcProduccionDetalleLoteCajon(this);

		return atcEvisceradoDetalleProcesoLote;
	}

	public AtcEvisceradoDetalleProcesoLote removeAtcEvisceradoDetalleProcesoLote(AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote) {
		getAtcEvisceradoDetalleProcesoLotes().remove(atcEvisceradoDetalleProcesoLote);
		atcEvisceradoDetalleProcesoLote.setAtcProduccionDetalleLoteCajon(null);

		return atcEvisceradoDetalleProcesoLote;
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


	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}

}