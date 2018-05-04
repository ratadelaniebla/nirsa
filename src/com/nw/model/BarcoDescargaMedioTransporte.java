package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barco_descarga_medio_transporte database table.
 * 
 */
@Entity
@Table(name="barco_descarga_medio_transporte")
@NamedQuery(name="BarcoDescargaMedioTransporte.findAll", query="SELECT b FROM BarcoDescargaMedioTransporte b")
public class BarcoDescargaMedioTransporte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idbarcodescargamediotransporte;
	private String descripcion;
	private List<BarcoDescarga> barcoDescargas;

	public BarcoDescargaMedioTransporte() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdbarcodescargamediotransporte() {
		return this.idbarcodescargamediotransporte;
	}

	public void setIdbarcodescargamediotransporte(Integer idbarcodescargamediotransporte) {
		this.idbarcodescargamediotransporte = idbarcodescargamediotransporte;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="barcoDescargaMedioTransporte")
	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

	public BarcoDescarga addBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().add(barcoDescarga);
		barcoDescarga.setBarcoDescargaMedioTransporte(this);

		return barcoDescarga;
	}

	public BarcoDescarga removeBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().remove(barcoDescarga);
		barcoDescarga.setBarcoDescargaMedioTransporte(null);

		return barcoDescarga;
	}

}