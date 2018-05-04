package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barco_estiba_cuba database table.
 * 
 */
@Entity
@Table(name="barco_estiba_cuba")
@NamedQuery(name="BarcoEstibaCuba.findAll", query="SELECT b FROM BarcoEstibaCuba b")
public class BarcoEstibaCuba implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idbarcoestibacuba;
	private double capacidad;
	private double cardumenbrisa;
	private double cardumenplantado;
	private Integer estadocombobox;
	private Integer estadodescargacuba;
	private Long idbarcocubacombinada;
	private Integer zonafao;
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;
	private BarcoCuba barcoCuba;
	private BarcoDescarga barcoDescarga;
	private List<BarcoEstibaCubaDetalleMezcla> barcoEstibaCubaDetalleMezclas;
	private List<CalidadAprobacionDescargaCuba> calidadAprobacionDescargaCubas;
	private List<CalidadDetallePcc> calidadDetallePccs;
	private List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps;
	private List<CamaraCajon> camaraCajons;
	private List<CamaraDetalleBanda> camaraDetalleBandas;
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	public BarcoEstibaCuba() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdbarcoestibacuba() {
		return this.idbarcoestibacuba;
	}

	public void setIdbarcoestibacuba(Long idbarcoestibacuba) {
		this.idbarcoestibacuba = idbarcoestibacuba;
	}


	public double getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}


	public double getCardumenbrisa() {
		return this.cardumenbrisa;
	}

	public void setCardumenbrisa(double cardumenbrisa) {
		this.cardumenbrisa = cardumenbrisa;
	}


	public double getCardumenplantado() {
		return this.cardumenplantado;
	}

	public void setCardumenplantado(double cardumenplantado) {
		this.cardumenplantado = cardumenplantado;
	}


	public Integer getEstadocombobox() {
		return this.estadocombobox;
	}

	public void setEstadocombobox(Integer estadocombobox) {
		this.estadocombobox = estadocombobox;
	}


	public Integer getEstadodescargacuba() {
		return this.estadodescargacuba;
	}

	public void setEstadodescargacuba(Integer estadodescargacuba) {
		this.estadodescargacuba = estadodescargacuba;
	}


	public Long getIdbarcocubacombinada() {
		return this.idbarcocubacombinada;
	}

	public void setIdbarcocubacombinada(Long idbarcocubacombinada) {
		this.idbarcocubacombinada = idbarcocubacombinada;
	}


	public Integer getZonafao() {
		return this.zonafao;
	}

	public void setZonafao(Integer zonafao) {
		this.zonafao = zonafao;
	}


	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="barcoEstibaCuba")
	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

	public AtcProduccionDetalleLote addAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().add(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setBarcoEstibaCuba(this);

		return atcProduccionDetalleLote;
	}

	public AtcProduccionDetalleLote removeAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().remove(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setBarcoEstibaCuba(null);

		return atcProduccionDetalleLote;
	}


	//bi-directional many-to-one association to BarcoCuba
	@ManyToOne
	@JoinColumn(name="idbarcocuba")
	public BarcoCuba getBarcoCuba() {
		return this.barcoCuba;
	}

	public void setBarcoCuba(BarcoCuba barcoCuba) {
		this.barcoCuba = barcoCuba;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}


	//bi-directional many-to-one association to BarcoEstibaCubaDetalleMezcla
	@OneToMany(mappedBy="barcoEstibaCuba")
	public List<BarcoEstibaCubaDetalleMezcla> getBarcoEstibaCubaDetalleMezclas() {
		return this.barcoEstibaCubaDetalleMezclas;
	}

	public void setBarcoEstibaCubaDetalleMezclas(List<BarcoEstibaCubaDetalleMezcla> barcoEstibaCubaDetalleMezclas) {
		this.barcoEstibaCubaDetalleMezclas = barcoEstibaCubaDetalleMezclas;
	}

	public BarcoEstibaCubaDetalleMezcla addBarcoEstibaCubaDetalleMezcla(BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla) {
		getBarcoEstibaCubaDetalleMezclas().add(barcoEstibaCubaDetalleMezcla);
		barcoEstibaCubaDetalleMezcla.setBarcoEstibaCuba(this);

		return barcoEstibaCubaDetalleMezcla;
	}

	public BarcoEstibaCubaDetalleMezcla removeBarcoEstibaCubaDetalleMezcla(BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla) {
		getBarcoEstibaCubaDetalleMezclas().remove(barcoEstibaCubaDetalleMezcla);
		barcoEstibaCubaDetalleMezcla.setBarcoEstibaCuba(null);

		return barcoEstibaCubaDetalleMezcla;
	}


	//bi-directional many-to-one association to CalidadAprobacionDescargaCuba
	@OneToMany(mappedBy="barcoEstibaCuba")
	public List<CalidadAprobacionDescargaCuba> getCalidadAprobacionDescargaCubas() {
		return this.calidadAprobacionDescargaCubas;
	}

	public void setCalidadAprobacionDescargaCubas(List<CalidadAprobacionDescargaCuba> calidadAprobacionDescargaCubas) {
		this.calidadAprobacionDescargaCubas = calidadAprobacionDescargaCubas;
	}

	public CalidadAprobacionDescargaCuba addCalidadAprobacionDescargaCuba(CalidadAprobacionDescargaCuba calidadAprobacionDescargaCuba) {
		getCalidadAprobacionDescargaCubas().add(calidadAprobacionDescargaCuba);
		calidadAprobacionDescargaCuba.setBarcoEstibaCuba(this);

		return calidadAprobacionDescargaCuba;
	}

	public CalidadAprobacionDescargaCuba removeCalidadAprobacionDescargaCuba(CalidadAprobacionDescargaCuba calidadAprobacionDescargaCuba) {
		getCalidadAprobacionDescargaCubas().remove(calidadAprobacionDescargaCuba);
		calidadAprobacionDescargaCuba.setBarcoEstibaCuba(null);

		return calidadAprobacionDescargaCuba;
	}


	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="barcoEstibaCuba")
	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public CalidadDetallePcc addCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().add(calidadDetallePcc);
		calidadDetallePcc.setBarcoEstibaCuba(this);

		return calidadDetallePcc;
	}

	public CalidadDetallePcc removeCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().remove(calidadDetallePcc);
		calidadDetallePcc.setBarcoEstibaCuba(null);

		return calidadDetallePcc;
	}


	//bi-directional many-to-one association to CalidadDetalleSensorialMp
	@OneToMany(mappedBy="barcoEstibaCuba")
	public List<CalidadDetalleSensorialMp> getCalidadDetalleSensorialMps() {
		return this.calidadDetalleSensorialMps;
	}

	public void setCalidadDetalleSensorialMps(List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps) {
		this.calidadDetalleSensorialMps = calidadDetalleSensorialMps;
	}

	public CalidadDetalleSensorialMp addCalidadDetalleSensorialMp(CalidadDetalleSensorialMp calidadDetalleSensorialMp) {
		getCalidadDetalleSensorialMps().add(calidadDetalleSensorialMp);
		calidadDetalleSensorialMp.setBarcoEstibaCuba(this);

		return calidadDetalleSensorialMp;
	}

	public CalidadDetalleSensorialMp removeCalidadDetalleSensorialMp(CalidadDetalleSensorialMp calidadDetalleSensorialMp) {
		getCalidadDetalleSensorialMps().remove(calidadDetalleSensorialMp);
		calidadDetalleSensorialMp.setBarcoEstibaCuba(null);

		return calidadDetalleSensorialMp;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="barcoEstibaCuba")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setBarcoEstibaCuba(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setBarcoEstibaCuba(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to CamaraDetalleBanda
	@OneToMany(mappedBy="barcoEstibaCuba")
	public List<CamaraDetalleBanda> getCamaraDetalleBandas() {
		return this.camaraDetalleBandas;
	}

	public void setCamaraDetalleBandas(List<CamaraDetalleBanda> camaraDetalleBandas) {
		this.camaraDetalleBandas = camaraDetalleBandas;
	}

	public CamaraDetalleBanda addCamaraDetalleBanda(CamaraDetalleBanda camaraDetalleBanda) {
		getCamaraDetalleBandas().add(camaraDetalleBanda);
		camaraDetalleBanda.setBarcoEstibaCuba(this);

		return camaraDetalleBanda;
	}

	public CamaraDetalleBanda removeCamaraDetalleBanda(CamaraDetalleBanda camaraDetalleBanda) {
		getCamaraDetalleBandas().remove(camaraDetalleBanda);
		camaraDetalleBanda.setBarcoEstibaCuba(null);

		return camaraDetalleBanda;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="barcoEstibaCuba")
	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

	public ProduccionDetalleLote addProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().add(produccionDetalleLote);
		produccionDetalleLote.setBarcoEstibaCuba(this);

		return produccionDetalleLote;
	}

	public ProduccionDetalleLote removeProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().remove(produccionDetalleLote);
		produccionDetalleLote.setBarcoEstibaCuba(null);

		return produccionDetalleLote;
	}

}