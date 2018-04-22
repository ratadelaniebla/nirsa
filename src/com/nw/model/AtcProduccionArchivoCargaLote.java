package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_produccion_archivo_carga_lote database table.
 * 
 */
@Entity
@Table(name="atc_produccion_archivo_carga_lote")
public class AtcProduccionArchivoCargaLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcproduccionarchivocargalote;

	private Timestamp fechaarchivo;

	private Timestamp fechacarga;

	private String nombrearchivo;

	private Integer turnoarchivo;

	//bi-directional many-to-one association to AtcProduccion
	@ManyToOne
	@JoinColumn(name="idatcproduccion")
	private AtcProduccion atcProduccion;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	//bi-directional many-to-one association to AtcProduccionCargaLote
	@OneToMany(mappedBy="atcProduccionArchivoCargaLote")
	private List<AtcProduccionCargaLote> atcProduccionCargaLotes;

	public AtcProduccionArchivoCargaLote() {
	}

	public Long getIdatcproduccionarchivocargalote() {
		return this.idatcproduccionarchivocargalote;
	}

	public void setIdatcproduccionarchivocargalote(Long idatcproduccionarchivocargalote) {
		this.idatcproduccionarchivocargalote = idatcproduccionarchivocargalote;
	}

	public Timestamp getFechaarchivo() {
		return this.fechaarchivo;
	}

	public void setFechaarchivo(Timestamp fechaarchivo) {
		this.fechaarchivo = fechaarchivo;
	}

	public Timestamp getFechacarga() {
		return this.fechacarga;
	}

	public void setFechacarga(Timestamp fechacarga) {
		this.fechacarga = fechacarga;
	}

	public String getNombrearchivo() {
		return this.nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	public Integer getTurnoarchivo() {
		return this.turnoarchivo;
	}

	public void setTurnoarchivo(Integer turnoarchivo) {
		this.turnoarchivo = turnoarchivo;
	}

	public AtcProduccion getAtcProduccion() {
		return this.atcProduccion;
	}

	public void setAtcProduccion(AtcProduccion atcProduccion) {
		this.atcProduccion = atcProduccion;
	}

	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

	public List<AtcProduccionCargaLote> getAtcProduccionCargaLotes() {
		return this.atcProduccionCargaLotes;
	}

	public void setAtcProduccionCargaLotes(List<AtcProduccionCargaLote> atcProduccionCargaLotes) {
		this.atcProduccionCargaLotes = atcProduccionCargaLotes;
	}

}