package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_produccion database table.
 * 
 */
@Entity
@Table(name="atc_produccion")
public class AtcProduccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcproduccion;

	private Integer estado;

	private Timestamp fechaproduccion;

	//bi-directional many-to-one association to AtcDescongeladoProceso
	@OneToMany(mappedBy="atcProduccion")
	private List<AtcDescongeladoProceso> atcDescongeladoProcesos;

	//bi-directional many-to-one association to AtcEvisceradoProceso
	@OneToMany(mappedBy="atcProduccion")
	private List<AtcEvisceradoProceso> atcEvisceradoProcesos;

	//bi-directional many-to-one association to AtcLimpiezaProceso
	@OneToMany(mappedBy="atcProduccion")
	private List<AtcLimpiezaProceso> atcLimpiezaProcesos;

	//bi-directional many-to-one association to AtcProduccionArchivoCargaLote
	@OneToMany(mappedBy="atcProduccion")
	private List<AtcProduccionArchivoCargaLote> atcProduccionArchivoCargaLotes;

	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="atcProduccion")
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;

	public AtcProduccion() {
	}

	public Long getIdatcproduccion() {
		return this.idatcproduccion;
	}

	public void setIdatcproduccion(Long idatcproduccion) {
		this.idatcproduccion = idatcproduccion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaproduccion() {
		return this.fechaproduccion;
	}

	public void setFechaproduccion(Timestamp fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
	}

	public List<AtcDescongeladoProceso> getAtcDescongeladoProcesos() {
		return this.atcDescongeladoProcesos;
	}

	public void setAtcDescongeladoProcesos(List<AtcDescongeladoProceso> atcDescongeladoProcesos) {
		this.atcDescongeladoProcesos = atcDescongeladoProcesos;
	}

	public List<AtcEvisceradoProceso> getAtcEvisceradoProcesos() {
		return this.atcEvisceradoProcesos;
	}

	public void setAtcEvisceradoProcesos(List<AtcEvisceradoProceso> atcEvisceradoProcesos) {
		this.atcEvisceradoProcesos = atcEvisceradoProcesos;
	}

	public List<AtcLimpiezaProceso> getAtcLimpiezaProcesos() {
		return this.atcLimpiezaProcesos;
	}

	public void setAtcLimpiezaProcesos(List<AtcLimpiezaProceso> atcLimpiezaProcesos) {
		this.atcLimpiezaProcesos = atcLimpiezaProcesos;
	}

	public List<AtcProduccionArchivoCargaLote> getAtcProduccionArchivoCargaLotes() {
		return this.atcProduccionArchivoCargaLotes;
	}

	public void setAtcProduccionArchivoCargaLotes(List<AtcProduccionArchivoCargaLote> atcProduccionArchivoCargaLotes) {
		this.atcProduccionArchivoCargaLotes = atcProduccionArchivoCargaLotes;
	}

	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

}