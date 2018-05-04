package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cajon_detalle_muestreo database table.
 * 
 */
@Entity
@Table(name="cajon_detalle_muestreo")
@NamedQuery(name="CajonDetalleMuestreo.findAll", query="SELECT c FROM CajonDetalleMuestreo c")
public class CajonDetalleMuestreo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcajondetallemuestreo;
	private Integer numeromuestreo;
	private double pesomuestreo;
	private CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga;

	public CajonDetalleMuestreo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@ManyToOne
	@JoinColumn(name="idcajondetallebarcodescarga")
	public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescarga() {
		return this.cajonDetalleBarcoDescarga;
	}

	public void setCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		this.cajonDetalleBarcoDescarga = cajonDetalleBarcoDescarga;
	}

}