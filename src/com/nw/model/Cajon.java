package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cajon database table.
 * 
 */
@Entity
@NamedQuery(name="Cajon.findAll", query="SELECT c FROM Cajon c")
public class Cajon implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idcajon;
	private Integer estadocajon;
	private String observaciones;
	private double tara;
	private List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos;
	private List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos;
	private Area area;
	private List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas;
	private List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas;
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;
	private List<CamaraCajon> camaraCajons;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;
	private List<DesperdicioDetalle> desperdicioDetalles;
	private List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos;
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;

	public Cajon() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(String idcajon) {
		this.idcajon = idcajon;
	}


	public Integer getEstadocajon() {
		return this.estadocajon;
	}

	public void setEstadocajon(Integer estadocajon) {
		this.estadocajon = estadocajon;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	//bi-directional many-to-one association to AtcEvisceradoSubproductoCrudo
	@OneToMany(mappedBy="cajon")
	public List<AtcEvisceradoSubproductoCrudo> getAtcEvisceradoSubproductoCrudos() {
		return this.atcEvisceradoSubproductoCrudos;
	}

	public void setAtcEvisceradoSubproductoCrudos(List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos) {
		this.atcEvisceradoSubproductoCrudos = atcEvisceradoSubproductoCrudos;
	}

	public AtcEvisceradoSubproductoCrudo addAtcEvisceradoSubproductoCrudo(AtcEvisceradoSubproductoCrudo atcEvisceradoSubproductoCrudo) {
		getAtcEvisceradoSubproductoCrudos().add(atcEvisceradoSubproductoCrudo);
		atcEvisceradoSubproductoCrudo.setCajon(this);

		return atcEvisceradoSubproductoCrudo;
	}

	public AtcEvisceradoSubproductoCrudo removeAtcEvisceradoSubproductoCrudo(AtcEvisceradoSubproductoCrudo atcEvisceradoSubproductoCrudo) {
		getAtcEvisceradoSubproductoCrudos().remove(atcEvisceradoSubproductoCrudo);
		atcEvisceradoSubproductoCrudo.setCajon(null);

		return atcEvisceradoSubproductoCrudo;
	}


	//bi-directional many-to-one association to AtcLimpiezaSubproductoCrudo
	@OneToMany(mappedBy="cajon")
	public List<AtcLimpiezaSubproductoCrudo> getAtcLimpiezaSubproductoCrudos() {
		return this.atcLimpiezaSubproductoCrudos;
	}

	public void setAtcLimpiezaSubproductoCrudos(List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos) {
		this.atcLimpiezaSubproductoCrudos = atcLimpiezaSubproductoCrudos;
	}

	public AtcLimpiezaSubproductoCrudo addAtcLimpiezaSubproductoCrudo(AtcLimpiezaSubproductoCrudo atcLimpiezaSubproductoCrudo) {
		getAtcLimpiezaSubproductoCrudos().add(atcLimpiezaSubproductoCrudo);
		atcLimpiezaSubproductoCrudo.setCajon(this);

		return atcLimpiezaSubproductoCrudo;
	}

	public AtcLimpiezaSubproductoCrudo removeAtcLimpiezaSubproductoCrudo(AtcLimpiezaSubproductoCrudo atcLimpiezaSubproductoCrudo) {
		getAtcLimpiezaSubproductoCrudos().remove(atcLimpiezaSubproductoCrudo);
		atcLimpiezaSubproductoCrudo.setCajon(null);

		return atcLimpiezaSubproductoCrudo;
	}


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@OneToMany(mappedBy="cajon")
	public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargas() {
		return this.cajonDetalleBarcoDescargas;
	}

	public void setCajonDetalleBarcoDescargas(List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas) {
		this.cajonDetalleBarcoDescargas = cajonDetalleBarcoDescargas;
	}

	public CajonDetalleBarcoDescarga addCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		getCajonDetalleBarcoDescargas().add(cajonDetalleBarcoDescarga);
		cajonDetalleBarcoDescarga.setCajon(this);

		return cajonDetalleBarcoDescarga;
	}

	public CajonDetalleBarcoDescarga removeCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		getCajonDetalleBarcoDescargas().remove(cajonDetalleBarcoDescarga);
		cajonDetalleBarcoDescarga.setCajon(null);

		return cajonDetalleBarcoDescarga;
	}


	//bi-directional many-to-one association to CalidadDetalleEspecietallaCajonBanda
	@OneToMany(mappedBy="cajon")
	public List<CalidadDetalleEspecietallaCajonBanda> getCalidadDetalleEspecietallaCajonBandas() {
		return this.calidadDetalleEspecietallaCajonBandas;
	}

	public void setCalidadDetalleEspecietallaCajonBandas(List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas) {
		this.calidadDetalleEspecietallaCajonBandas = calidadDetalleEspecietallaCajonBandas;
	}

	public CalidadDetalleEspecietallaCajonBanda addCalidadDetalleEspecietallaCajonBanda(CalidadDetalleEspecietallaCajonBanda calidadDetalleEspecietallaCajonBanda) {
		getCalidadDetalleEspecietallaCajonBandas().add(calidadDetalleEspecietallaCajonBanda);
		calidadDetalleEspecietallaCajonBanda.setCajon(this);

		return calidadDetalleEspecietallaCajonBanda;
	}

	public CalidadDetalleEspecietallaCajonBanda removeCalidadDetalleEspecietallaCajonBanda(CalidadDetalleEspecietallaCajonBanda calidadDetalleEspecietallaCajonBanda) {
		getCalidadDetalleEspecietallaCajonBandas().remove(calidadDetalleEspecietallaCajonBanda);
		calidadDetalleEspecietallaCajonBanda.setCajon(null);

		return calidadDetalleEspecietallaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="cajon")
	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public CalidadDetalleTemperaturaCajonBanda addCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().add(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setCajon(this);

		return calidadDetalleTemperaturaCajonBanda;
	}

	public CalidadDetalleTemperaturaCajonBanda removeCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().remove(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setCajon(null);

		return calidadDetalleTemperaturaCajonBanda;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="cajon")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setCajon(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setCajon(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="cajon")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().add(desperdicioCajonHarina);
		desperdicioCajonHarina.setCajon(this);

		return desperdicioCajonHarina;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().remove(desperdicioCajonHarina);
		desperdicioCajonHarina.setCajon(null);

		return desperdicioCajonHarina;
	}


	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="cajon")
	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public DesperdicioDetalle addDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().add(desperdicioDetalle);
		desperdicioDetalle.setCajon(this);

		return desperdicioDetalle;
	}

	public DesperdicioDetalle removeDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().remove(desperdicioDetalle);
		desperdicioDetalle.setCajon(null);

		return desperdicioDetalle;
	}


	//bi-directional many-to-one association to EvisceradoSubproductoCrudo
	@OneToMany(mappedBy="cajon")
	public List<EvisceradoSubproductoCrudo> getEvisceradoSubproductoCrudos() {
		return this.evisceradoSubproductoCrudos;
	}

	public void setEvisceradoSubproductoCrudos(List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos) {
		this.evisceradoSubproductoCrudos = evisceradoSubproductoCrudos;
	}

	public EvisceradoSubproductoCrudo addEvisceradoSubproductoCrudo(EvisceradoSubproductoCrudo evisceradoSubproductoCrudo) {
		getEvisceradoSubproductoCrudos().add(evisceradoSubproductoCrudo);
		evisceradoSubproductoCrudo.setCajon(this);

		return evisceradoSubproductoCrudo;
	}

	public EvisceradoSubproductoCrudo removeEvisceradoSubproductoCrudo(EvisceradoSubproductoCrudo evisceradoSubproductoCrudo) {
		getEvisceradoSubproductoCrudos().remove(evisceradoSubproductoCrudo);
		evisceradoSubproductoCrudo.setCajon(null);

		return evisceradoSubproductoCrudo;
	}


	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="cajon")
	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

	public HarinaRecepcionDetallePescaComprobante addHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().add(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setCajon(this);

		return harinaRecepcionDetallePescaComprobante;
	}

	public HarinaRecepcionDetallePescaComprobante removeHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().remove(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setCajon(null);

		return harinaRecepcionDetallePescaComprobante;
	}

}