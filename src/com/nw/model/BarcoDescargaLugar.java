package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barco_descarga_lugar database table.
 * 
 */
@Entity
@Table(name="barco_descarga_lugar")
@NamedQuery(name="BarcoDescargaLugar.findAll", query="SELECT b FROM BarcoDescargaLugar b")
public class BarcoDescargaLugar implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idbarcodescargalugar;
	private String descripcion;
	private List<BarcoDescarga> barcoDescargas;

	public BarcoDescargaLugar() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdbarcodescargalugar() {
		return this.idbarcodescargalugar;
	}

	public void setIdbarcodescargalugar(Integer idbarcodescargalugar) {
		this.idbarcodescargalugar = idbarcodescargalugar;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="barcoDescargaLugar")
	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

	public BarcoDescarga addBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().add(barcoDescarga);
		barcoDescarga.setBarcoDescargaLugar(this);

		return barcoDescarga;
	}

	public BarcoDescarga removeBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().remove(barcoDescarga);
		barcoDescarga.setBarcoDescargaLugar(null);

		return barcoDescarga;
	}

}