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
@NamedQuery(name="AtcProduccion.findAll", query="SELECT a FROM AtcProduccion a")
public class AtcProduccion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcproduccion;
	private Integer estado;
	private Timestamp fechaproduccion;
	private List<AtcDescongeladoProceso> atcDescongeladoProcesos;
	private List<AtcEvisceradoProceso> atcEvisceradoProcesos;
	private List<AtcLimpiezaProceso> atcLimpiezaProcesos;
	private List<AtcProduccionArchivoCargaLote> atcProduccionArchivoCargaLotes;
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;

	public AtcProduccion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcDescongeladoProceso
	@OneToMany(mappedBy="atcProduccion")
	public List<AtcDescongeladoProceso> getAtcDescongeladoProcesos() {
		return this.atcDescongeladoProcesos;
	}

	public void setAtcDescongeladoProcesos(List<AtcDescongeladoProceso> atcDescongeladoProcesos) {
		this.atcDescongeladoProcesos = atcDescongeladoProcesos;
	}

	public AtcDescongeladoProceso addAtcDescongeladoProceso(AtcDescongeladoProceso atcDescongeladoProceso) {
		getAtcDescongeladoProcesos().add(atcDescongeladoProceso);
		atcDescongeladoProceso.setAtcProduccion(this);

		return atcDescongeladoProceso;
	}

	public AtcDescongeladoProceso removeAtcDescongeladoProceso(AtcDescongeladoProceso atcDescongeladoProceso) {
		getAtcDescongeladoProcesos().remove(atcDescongeladoProceso);
		atcDescongeladoProceso.setAtcProduccion(null);

		return atcDescongeladoProceso;
	}


	//bi-directional many-to-one association to AtcEvisceradoProceso
	@OneToMany(mappedBy="atcProduccion")
	public List<AtcEvisceradoProceso> getAtcEvisceradoProcesos() {
		return this.atcEvisceradoProcesos;
	}

	public void setAtcEvisceradoProcesos(List<AtcEvisceradoProceso> atcEvisceradoProcesos) {
		this.atcEvisceradoProcesos = atcEvisceradoProcesos;
	}

	public AtcEvisceradoProceso addAtcEvisceradoProceso(AtcEvisceradoProceso atcEvisceradoProceso) {
		getAtcEvisceradoProcesos().add(atcEvisceradoProceso);
		atcEvisceradoProceso.setAtcProduccion(this);

		return atcEvisceradoProceso;
	}

	public AtcEvisceradoProceso removeAtcEvisceradoProceso(AtcEvisceradoProceso atcEvisceradoProceso) {
		getAtcEvisceradoProcesos().remove(atcEvisceradoProceso);
		atcEvisceradoProceso.setAtcProduccion(null);

		return atcEvisceradoProceso;
	}


	//bi-directional many-to-one association to AtcLimpiezaProceso
	@OneToMany(mappedBy="atcProduccion")
	public List<AtcLimpiezaProceso> getAtcLimpiezaProcesos() {
		return this.atcLimpiezaProcesos;
	}

	public void setAtcLimpiezaProcesos(List<AtcLimpiezaProceso> atcLimpiezaProcesos) {
		this.atcLimpiezaProcesos = atcLimpiezaProcesos;
	}

	public AtcLimpiezaProceso addAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		getAtcLimpiezaProcesos().add(atcLimpiezaProceso);
		atcLimpiezaProceso.setAtcProduccion(this);

		return atcLimpiezaProceso;
	}

	public AtcLimpiezaProceso removeAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		getAtcLimpiezaProcesos().remove(atcLimpiezaProceso);
		atcLimpiezaProceso.setAtcProduccion(null);

		return atcLimpiezaProceso;
	}


	//bi-directional many-to-one association to AtcProduccionArchivoCargaLote
	@OneToMany(mappedBy="atcProduccion")
	public List<AtcProduccionArchivoCargaLote> getAtcProduccionArchivoCargaLotes() {
		return this.atcProduccionArchivoCargaLotes;
	}

	public void setAtcProduccionArchivoCargaLotes(List<AtcProduccionArchivoCargaLote> atcProduccionArchivoCargaLotes) {
		this.atcProduccionArchivoCargaLotes = atcProduccionArchivoCargaLotes;
	}

	public AtcProduccionArchivoCargaLote addAtcProduccionArchivoCargaLote(AtcProduccionArchivoCargaLote atcProduccionArchivoCargaLote) {
		getAtcProduccionArchivoCargaLotes().add(atcProduccionArchivoCargaLote);
		atcProduccionArchivoCargaLote.setAtcProduccion(this);

		return atcProduccionArchivoCargaLote;
	}

	public AtcProduccionArchivoCargaLote removeAtcProduccionArchivoCargaLote(AtcProduccionArchivoCargaLote atcProduccionArchivoCargaLote) {
		getAtcProduccionArchivoCargaLotes().remove(atcProduccionArchivoCargaLote);
		atcProduccionArchivoCargaLote.setAtcProduccion(null);

		return atcProduccionArchivoCargaLote;
	}


	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="atcProduccion")
	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

	public AtcProduccionDetalleLote addAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().add(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setAtcProduccion(this);

		return atcProduccionDetalleLote;
	}

	public AtcProduccionDetalleLote removeAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().remove(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setAtcProduccion(null);

		return atcProduccionDetalleLote;
	}

}