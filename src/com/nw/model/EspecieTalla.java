package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especie_talla database table.
 * 
 */
@Entity
@Table(name="especie_talla")
@NamedQuery(name="EspecieTalla.findAll", query="SELECT e FROM EspecieTalla e")
public class EspecieTalla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idespecietalla;
	private String descripcion;
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;
	private List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas;
	private List<CalidadDetallePcc> calidadDetallePccs;
	private List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps;
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;
	private List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas;
	private List<CamaraCajon> camaraCajons;
	private Especie especie;
	private Talla talla;
	private List<EstandarDesperdicioAtun> estandarDesperdicioAtuns;
	private List<EstandarRendimientoAtun> estandarRendimientoAtuns;
	private List<EstandarRendimientosAtun> estandarRendimientosAtuns;
	private List<GrupoTallaEspecieTalla> grupoTallaEspecieTallas;
	private List<LonjasEspecietalla> lonjasEspecietallas;
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	public EspecieTalla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdespecietalla() {
		return this.idespecietalla;
	}

	public void setIdespecietalla(Integer idespecietalla) {
		this.idespecietalla = idespecietalla;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="especieTalla")
	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

	public AtcProduccionDetalleLote addAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().add(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setEspecieTalla(this);

		return atcProduccionDetalleLote;
	}

	public AtcProduccionDetalleLote removeAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().remove(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setEspecieTalla(null);

		return atcProduccionDetalleLote;
	}


	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@OneToMany(mappedBy="especieTalla")
	public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargas() {
		return this.cajonDetalleBarcoDescargas;
	}

	public void setCajonDetalleBarcoDescargas(List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas) {
		this.cajonDetalleBarcoDescargas = cajonDetalleBarcoDescargas;
	}

	public CajonDetalleBarcoDescarga addCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		getCajonDetalleBarcoDescargas().add(cajonDetalleBarcoDescarga);
		cajonDetalleBarcoDescarga.setEspecieTalla(this);

		return cajonDetalleBarcoDescarga;
	}

	public CajonDetalleBarcoDescarga removeCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		getCajonDetalleBarcoDescargas().remove(cajonDetalleBarcoDescarga);
		cajonDetalleBarcoDescarga.setEspecieTalla(null);

		return cajonDetalleBarcoDescarga;
	}


	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="especieTalla")
	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public CalidadDetallePcc addCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().add(calidadDetallePcc);
		calidadDetallePcc.setEspecieTalla(this);

		return calidadDetallePcc;
	}

	public CalidadDetallePcc removeCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().remove(calidadDetallePcc);
		calidadDetallePcc.setEspecieTalla(null);

		return calidadDetallePcc;
	}


	//bi-directional many-to-one association to CalidadDetalleSensorialMp
	@OneToMany(mappedBy="especieTalla")
	public List<CalidadDetalleSensorialMp> getCalidadDetalleSensorialMps() {
		return this.calidadDetalleSensorialMps;
	}

	public void setCalidadDetalleSensorialMps(List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps) {
		this.calidadDetalleSensorialMps = calidadDetalleSensorialMps;
	}

	public CalidadDetalleSensorialMp addCalidadDetalleSensorialMp(CalidadDetalleSensorialMp calidadDetalleSensorialMp) {
		getCalidadDetalleSensorialMps().add(calidadDetalleSensorialMp);
		calidadDetalleSensorialMp.setEspecieTalla(this);

		return calidadDetalleSensorialMp;
	}

	public CalidadDetalleSensorialMp removeCalidadDetalleSensorialMp(CalidadDetalleSensorialMp calidadDetalleSensorialMp) {
		getCalidadDetalleSensorialMps().remove(calidadDetalleSensorialMp);
		calidadDetalleSensorialMp.setEspecieTalla(null);

		return calidadDetalleSensorialMp;
	}


	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="especieTalla")
	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public CalidadDetalleTemperaturaCajonBanda addCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().add(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setEspecieTalla(this);

		return calidadDetalleTemperaturaCajonBanda;
	}

	public CalidadDetalleTemperaturaCajonBanda removeCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().remove(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setEspecieTalla(null);

		return calidadDetalleTemperaturaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadEspecietallaCajonBanda
	@OneToMany(mappedBy="especieTalla")
	public List<CalidadEspecietallaCajonBanda> getCalidadEspecietallaCajonBandas() {
		return this.calidadEspecietallaCajonBandas;
	}

	public void setCalidadEspecietallaCajonBandas(List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas) {
		this.calidadEspecietallaCajonBandas = calidadEspecietallaCajonBandas;
	}

	public CalidadEspecietallaCajonBanda addCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		getCalidadEspecietallaCajonBandas().add(calidadEspecietallaCajonBanda);
		calidadEspecietallaCajonBanda.setEspecieTalla(this);

		return calidadEspecietallaCajonBanda;
	}

	public CalidadEspecietallaCajonBanda removeCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		getCalidadEspecietallaCajonBandas().remove(calidadEspecietallaCajonBanda);
		calidadEspecietallaCajonBanda.setEspecieTalla(null);

		return calidadEspecietallaCajonBanda;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="especieTalla")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setEspecieTalla(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setEspecieTalla(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to Especie
	@ManyToOne
	@JoinColumn(name="idespecie")
	public Especie getEspecie() {
		return this.especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}


	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}


	//bi-directional many-to-one association to EstandarDesperdicioAtun
	@OneToMany(mappedBy="especieTalla")
	public List<EstandarDesperdicioAtun> getEstandarDesperdicioAtuns() {
		return this.estandarDesperdicioAtuns;
	}

	public void setEstandarDesperdicioAtuns(List<EstandarDesperdicioAtun> estandarDesperdicioAtuns) {
		this.estandarDesperdicioAtuns = estandarDesperdicioAtuns;
	}

	public EstandarDesperdicioAtun addEstandarDesperdicioAtun(EstandarDesperdicioAtun estandarDesperdicioAtun) {
		getEstandarDesperdicioAtuns().add(estandarDesperdicioAtun);
		estandarDesperdicioAtun.setEspecieTalla(this);

		return estandarDesperdicioAtun;
	}

	public EstandarDesperdicioAtun removeEstandarDesperdicioAtun(EstandarDesperdicioAtun estandarDesperdicioAtun) {
		getEstandarDesperdicioAtuns().remove(estandarDesperdicioAtun);
		estandarDesperdicioAtun.setEspecieTalla(null);

		return estandarDesperdicioAtun;
	}


	//bi-directional many-to-one association to EstandarRendimientoAtun
	@OneToMany(mappedBy="especieTalla")
	public List<EstandarRendimientoAtun> getEstandarRendimientoAtuns() {
		return this.estandarRendimientoAtuns;
	}

	public void setEstandarRendimientoAtuns(List<EstandarRendimientoAtun> estandarRendimientoAtuns) {
		this.estandarRendimientoAtuns = estandarRendimientoAtuns;
	}

	public EstandarRendimientoAtun addEstandarRendimientoAtun(EstandarRendimientoAtun estandarRendimientoAtun) {
		getEstandarRendimientoAtuns().add(estandarRendimientoAtun);
		estandarRendimientoAtun.setEspecieTalla(this);

		return estandarRendimientoAtun;
	}

	public EstandarRendimientoAtun removeEstandarRendimientoAtun(EstandarRendimientoAtun estandarRendimientoAtun) {
		getEstandarRendimientoAtuns().remove(estandarRendimientoAtun);
		estandarRendimientoAtun.setEspecieTalla(null);

		return estandarRendimientoAtun;
	}


	//bi-directional many-to-one association to EstandarRendimientosAtun
	@OneToMany(mappedBy="especieTalla")
	public List<EstandarRendimientosAtun> getEstandarRendimientosAtuns() {
		return this.estandarRendimientosAtuns;
	}

	public void setEstandarRendimientosAtuns(List<EstandarRendimientosAtun> estandarRendimientosAtuns) {
		this.estandarRendimientosAtuns = estandarRendimientosAtuns;
	}

	public EstandarRendimientosAtun addEstandarRendimientosAtun(EstandarRendimientosAtun estandarRendimientosAtun) {
		getEstandarRendimientosAtuns().add(estandarRendimientosAtun);
		estandarRendimientosAtun.setEspecieTalla(this);

		return estandarRendimientosAtun;
	}

	public EstandarRendimientosAtun removeEstandarRendimientosAtun(EstandarRendimientosAtun estandarRendimientosAtun) {
		getEstandarRendimientosAtuns().remove(estandarRendimientosAtun);
		estandarRendimientosAtun.setEspecieTalla(null);

		return estandarRendimientosAtun;
	}


	//bi-directional many-to-one association to GrupoTallaEspecieTalla
	@OneToMany(mappedBy="especieTalla")
	public List<GrupoTallaEspecieTalla> getGrupoTallaEspecieTallas() {
		return this.grupoTallaEspecieTallas;
	}

	public void setGrupoTallaEspecieTallas(List<GrupoTallaEspecieTalla> grupoTallaEspecieTallas) {
		this.grupoTallaEspecieTallas = grupoTallaEspecieTallas;
	}

	public GrupoTallaEspecieTalla addGrupoTallaEspecieTalla(GrupoTallaEspecieTalla grupoTallaEspecieTalla) {
		getGrupoTallaEspecieTallas().add(grupoTallaEspecieTalla);
		grupoTallaEspecieTalla.setEspecieTalla(this);

		return grupoTallaEspecieTalla;
	}

	public GrupoTallaEspecieTalla removeGrupoTallaEspecieTalla(GrupoTallaEspecieTalla grupoTallaEspecieTalla) {
		getGrupoTallaEspecieTallas().remove(grupoTallaEspecieTalla);
		grupoTallaEspecieTalla.setEspecieTalla(null);

		return grupoTallaEspecieTalla;
	}


	//bi-directional many-to-one association to LonjasEspecietalla
	@OneToMany(mappedBy="especieTalla")
	public List<LonjasEspecietalla> getLonjasEspecietallas() {
		return this.lonjasEspecietallas;
	}

	public void setLonjasEspecietallas(List<LonjasEspecietalla> lonjasEspecietallas) {
		this.lonjasEspecietallas = lonjasEspecietallas;
	}

	public LonjasEspecietalla addLonjasEspecietalla(LonjasEspecietalla lonjasEspecietalla) {
		getLonjasEspecietallas().add(lonjasEspecietalla);
		lonjasEspecietalla.setEspecieTalla(this);

		return lonjasEspecietalla;
	}

	public LonjasEspecietalla removeLonjasEspecietalla(LonjasEspecietalla lonjasEspecietalla) {
		getLonjasEspecietallas().remove(lonjasEspecietalla);
		lonjasEspecietalla.setEspecieTalla(null);

		return lonjasEspecietalla;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="especieTalla")
	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

	public ProduccionDetalleLote addProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().add(produccionDetalleLote);
		produccionDetalleLote.setEspecieTalla(this);

		return produccionDetalleLote;
	}

	public ProduccionDetalleLote removeProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().remove(produccionDetalleLote);
		produccionDetalleLote.setEspecieTalla(null);

		return produccionDetalleLote;
	}

}