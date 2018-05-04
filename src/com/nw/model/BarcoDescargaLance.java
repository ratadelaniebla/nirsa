package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the barco_descarga_lance database table.
 * 
 */
@Entity
@Table(name="barco_descarga_lance")
@NamedQuery(name="BarcoDescargaLance.findAll", query="SELECT b FROM BarcoDescargaLance b")
public class BarcoDescargaLance implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idbarcodescargalance;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private Integer idbarcodescarga;
	private Integer latitudgrados;
	private Integer latitudminutos;
	private Integer latitudorientacion;
	private Integer longitudgrados;
	private Integer longitudminutos;
	private Integer longitudorientacion;
	private Integer zonafao;

	public BarcoDescargaLance() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdbarcodescargalance() {
		return this.idbarcodescargalance;
	}

	public void setIdbarcodescargalance(Long idbarcodescargalance) {
		this.idbarcodescargalance = idbarcodescargalance;
	}


	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}


	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}


	public Integer getIdbarcodescarga() {
		return this.idbarcodescarga;
	}

	public void setIdbarcodescarga(Integer idbarcodescarga) {
		this.idbarcodescarga = idbarcodescarga;
	}


	public Integer getLatitudgrados() {
		return this.latitudgrados;
	}

	public void setLatitudgrados(Integer latitudgrados) {
		this.latitudgrados = latitudgrados;
	}


	public Integer getLatitudminutos() {
		return this.latitudminutos;
	}

	public void setLatitudminutos(Integer latitudminutos) {
		this.latitudminutos = latitudminutos;
	}


	public Integer getLatitudorientacion() {
		return this.latitudorientacion;
	}

	public void setLatitudorientacion(Integer latitudorientacion) {
		this.latitudorientacion = latitudorientacion;
	}


	public Integer getLongitudgrados() {
		return this.longitudgrados;
	}

	public void setLongitudgrados(Integer longitudgrados) {
		this.longitudgrados = longitudgrados;
	}


	public Integer getLongitudminutos() {
		return this.longitudminutos;
	}

	public void setLongitudminutos(Integer longitudminutos) {
		this.longitudminutos = longitudminutos;
	}


	public Integer getLongitudorientacion() {
		return this.longitudorientacion;
	}

	public void setLongitudorientacion(Integer longitudorientacion) {
		this.longitudorientacion = longitudorientacion;
	}


	public Integer getZonafao() {
		return this.zonafao;
	}

	public void setZonafao(Integer zonafao) {
		this.zonafao = zonafao;
	}

}