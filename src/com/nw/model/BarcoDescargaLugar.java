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
public class BarcoDescargaLugar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbarcodescargalugar;

	private String descripcion;

	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="barcoDescargaLugar")
	private List<BarcoDescarga> barcoDescargas;

	public BarcoDescargaLugar() {
	}

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

	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

}