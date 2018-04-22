package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_tipo_corte database table.
 * 
 */
@Entity
@Table(name="limpieza_tipo_corte")
public class LimpiezaTipoCorte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezatipocorte;

	private String descripcion;

	//bi-directional many-to-one association to LimpiezaDetalleTipoCorte
	@OneToMany(mappedBy="limpiezaTipoCorte")
	private List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes;

	public LimpiezaTipoCorte() {
	}

	public Integer getIdlimpiezatipocorte() {
		return this.idlimpiezatipocorte;
	}

	public void setIdlimpiezatipocorte(Integer idlimpiezatipocorte) {
		this.idlimpiezatipocorte = idlimpiezatipocorte;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LimpiezaDetalleTipoCorte> getLimpiezaDetalleTipoCortes() {
		return this.limpiezaDetalleTipoCortes;
	}

	public void setLimpiezaDetalleTipoCortes(List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes) {
		this.limpiezaDetalleTipoCortes = limpiezaDetalleTipoCortes;
	}

}