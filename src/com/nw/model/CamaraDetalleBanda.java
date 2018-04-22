package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the camara_detalle_banda database table.
 * 
 */
@Entity
@Table(name="camara_detalle_banda")
public class CamaraDetalleBanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcamaradetallebanda;

	private Timestamp fecharegistrollegadacamara;

	private Timestamp fecharegistrosalidamuelle;

	private Integer viaje;

	//bi-directional many-to-one association to Banda
	@ManyToOne
	@JoinColumn(name="idbanda")
	private Banda banda;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	private BarcoEstibaCuba barcoEstibaCuba;

	//bi-directional many-to-one association to Volqueta
	@ManyToOne
	@JoinColumn(name="idvolqueta")
	private Volqueta volqueta;

	public CamaraDetalleBanda() {
	}

	public Long getIdcamaradetallebanda() {
		return this.idcamaradetallebanda;
	}

	public void setIdcamaradetallebanda(Long idcamaradetallebanda) {
		this.idcamaradetallebanda = idcamaradetallebanda;
	}

	public Timestamp getFecharegistrollegadacamara() {
		return this.fecharegistrollegadacamara;
	}

	public void setFecharegistrollegadacamara(Timestamp fecharegistrollegadacamara) {
		this.fecharegistrollegadacamara = fecharegistrollegadacamara;
	}

	public Timestamp getFecharegistrosalidamuelle() {
		return this.fecharegistrosalidamuelle;
	}

	public void setFecharegistrosalidamuelle(Timestamp fecharegistrosalidamuelle) {
		this.fecharegistrosalidamuelle = fecharegistrosalidamuelle;
	}

	public Integer getViaje() {
		return this.viaje;
	}

	public void setViaje(Integer viaje) {
		this.viaje = viaje;
	}

	public Banda getBanda() {
		return this.banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}

	public Volqueta getVolqueta() {
		return this.volqueta;
	}

	public void setVolqueta(Volqueta volqueta) {
		this.volqueta = volqueta;
	}

}