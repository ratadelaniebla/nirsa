package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the impresion database table.
 * 
 */
@Entity
public class Impresion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idimpresion;

	private String codimpresion;

	private String descripcionimpresion;

	//bi-directional many-to-one association to ImpresionDetalle
	@OneToMany(mappedBy="impresion")
	private List<ImpresionDetalle> impresionDetalles;

	public Impresion() {
	}

	public Long getIdimpresion() {
		return this.idimpresion;
	}

	public void setIdimpresion(Long idimpresion) {
		this.idimpresion = idimpresion;
	}

	public String getCodimpresion() {
		return this.codimpresion;
	}

	public void setCodimpresion(String codimpresion) {
		this.codimpresion = codimpresion;
	}

	public String getDescripcionimpresion() {
		return this.descripcionimpresion;
	}

	public void setDescripcionimpresion(String descripcionimpresion) {
		this.descripcionimpresion = descripcionimpresion;
	}

	public List<ImpresionDetalle> getImpresionDetalles() {
		return this.impresionDetalles;
	}

	public void setImpresionDetalles(List<ImpresionDetalle> impresionDetalles) {
		this.impresionDetalles = impresionDetalles;
	}

}