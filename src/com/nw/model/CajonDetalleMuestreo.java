package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cajon_detalle_muestreo database table.
 * 
 */
@Entity
@Table(name="cajon_detalle_muestreo")
public class CajonDetalleMuestreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcajondetallemuestreo;

	private Integer numeromuestreo;

	private double pesomuestreo;

	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@ManyToOne
	@JoinColumn(name="idcajondetallebarcodescarga")
	private CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga;

	public CajonDetalleMuestreo() {
	}

	public Long getIdcajondetallemuestreo() {
		return this.idcajondetallemuestreo;
	}

	public void setIdcajondetallemuestreo(Long idcajondetallemuestreo) {
		this.idcajondetallemuestreo = idcajondetallemuestreo;
	}

	public Integer getNumeromuestreo() {
		return this.numeromuestreo;
	}

	public void setNumeromuestreo(Integer numeromuestreo) {
		this.numeromuestreo = numeromuestreo;
	}

	public double getPesomuestreo() {
		return this.pesomuestreo;
	}

	public void setPesomuestreo(double pesomuestreo) {
		this.pesomuestreo = pesomuestreo;
	}

	public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescarga() {
		return this.cajonDetalleBarcoDescarga;
	}

	public void setCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		this.cajonDetalleBarcoDescarga = cajonDetalleBarcoDescarga;
	}

}