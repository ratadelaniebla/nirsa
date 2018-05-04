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
@NamedQuery(name="LimpiezaTipoCorte.findAll", query="SELECT l FROM LimpiezaTipoCorte l")
public class LimpiezaTipoCorte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezatipocorte;
	private String descripcion;
	private List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes;

	public LimpiezaTipoCorte() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaDetalleTipoCorte
	@OneToMany(mappedBy="limpiezaTipoCorte")
	public List<LimpiezaDetalleTipoCorte> getLimpiezaDetalleTipoCortes() {
		return this.limpiezaDetalleTipoCortes;
	}

	public void setLimpiezaDetalleTipoCortes(List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes) {
		this.limpiezaDetalleTipoCortes = limpiezaDetalleTipoCortes;
	}

	public LimpiezaDetalleTipoCorte addLimpiezaDetalleTipoCorte(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		getLimpiezaDetalleTipoCortes().add(limpiezaDetalleTipoCorte);
		limpiezaDetalleTipoCorte.setLimpiezaTipoCorte(this);

		return limpiezaDetalleTipoCorte;
	}

	public LimpiezaDetalleTipoCorte removeLimpiezaDetalleTipoCorte(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		getLimpiezaDetalleTipoCortes().remove(limpiezaDetalleTipoCorte);
		limpiezaDetalleTipoCorte.setLimpiezaTipoCorte(null);

		return limpiezaDetalleTipoCorte;
	}

}