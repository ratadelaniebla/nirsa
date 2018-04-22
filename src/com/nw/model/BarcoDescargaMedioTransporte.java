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
public class BarcoDescargaMedioTransporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbarcodescargamediotransporte;

	private String descripcion;

	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="barcoDescargaMedioTransporte")
	private List<BarcoDescarga> barcoDescargas;

	public BarcoDescargaMedioTransporte() {
	}

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

	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

}