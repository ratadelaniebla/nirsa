package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cajon database table.
 * 
 */
@Entity
public class Cajon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idcajon;

	private Integer estadocajon;

	private String observaciones;

	private double tara;

	//bi-directional many-to-one association to AtcEvisceradoSubproductoCrudo
	@OneToMany(mappedBy="cajon")
	private List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos;

	//bi-directional many-to-one association to AtcLimpiezaSubproductoCrudo
	@OneToMany(mappedBy="cajon")
	private List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@OneToMany(mappedBy="cajon")
	private List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas;

	//bi-directional many-to-one association to CalidadDetalleEspecietallaCajonBanda
	@OneToMany(mappedBy="cajon")
	private List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas;

	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="cajon")
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="cajon")
	private List<CamaraCajon> camaraCajons;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="cajon")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;

	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="cajon")
	private List<DesperdicioDetalle> desperdicioDetalles;

	//bi-directional many-to-one association to EvisceradoSubproductoCrudo
	@OneToMany(mappedBy="cajon")
	private List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos;

	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="cajon")
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;

	public Cajon() {
	}

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

	public List<AtcEvisceradoSubproductoCrudo> getAtcEvisceradoSubproductoCrudos() {
		return this.atcEvisceradoSubproductoCrudos;
	}

	public void setAtcEvisceradoSubproductoCrudos(List<AtcEvisceradoSubproductoCrudo> atcEvisceradoSubproductoCrudos) {
		this.atcEvisceradoSubproductoCrudos = atcEvisceradoSubproductoCrudos;
	}

	public List<AtcLimpiezaSubproductoCrudo> getAtcLimpiezaSubproductoCrudos() {
		return this.atcLimpiezaSubproductoCrudos;
	}

	public void setAtcLimpiezaSubproductoCrudos(List<AtcLimpiezaSubproductoCrudo> atcLimpiezaSubproductoCrudos) {
		this.atcLimpiezaSubproductoCrudos = atcLimpiezaSubproductoCrudos;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargas() {
		return this.cajonDetalleBarcoDescargas;
	}

	public void setCajonDetalleBarcoDescargas(List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas) {
		this.cajonDetalleBarcoDescargas = cajonDetalleBarcoDescargas;
	}

	public List<CalidadDetalleEspecietallaCajonBanda> getCalidadDetalleEspecietallaCajonBandas() {
		return this.calidadDetalleEspecietallaCajonBandas;
	}

	public void setCalidadDetalleEspecietallaCajonBandas(List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas) {
		this.calidadDetalleEspecietallaCajonBandas = calidadDetalleEspecietallaCajonBandas;
	}

	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
	}

	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public List<EvisceradoSubproductoCrudo> getEvisceradoSubproductoCrudos() {
		return this.evisceradoSubproductoCrudos;
	}

	public void setEvisceradoSubproductoCrudos(List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos) {
		this.evisceradoSubproductoCrudos = evisceradoSubproductoCrudos;
	}

	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

}