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
@NamedQuery(name="CamaraDetalleBanda.findAll", query="SELECT c FROM CamaraDetalleBanda c")
public class CamaraDetalleBanda implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcamaradetallebanda;
	private Timestamp fecharegistrollegadacamara;
	private Timestamp fecharegistrosalidamuelle;
	private Integer viaje;
	private Banda banda;
	private BarcoDescarga barcoDescarga;
	private BarcoEstibaCuba barcoEstibaCuba;
	private Volqueta volqueta;

	public CamaraDetalleBanda() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to Banda
	@ManyToOne
	@JoinColumn(name="idbanda")
	public Banda getBanda() {
		return this.banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
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


	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}


	//bi-directional many-to-one association to Volqueta
	@ManyToOne
	@JoinColumn(name="idvolqueta")
	public Volqueta getVolqueta() {
		return this.volqueta;
	}

	public void setVolqueta(Volqueta volqueta) {
		this.volqueta = volqueta;
	}

}