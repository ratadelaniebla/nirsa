package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_parada_lonjas database table.
 * 
 */
@Entity
@Table(name="oee_detalle_parada_lonjas")
public class OeeDetalleParadaLonja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idoeedetalleparadalonjas;

	//bi-directional many-to-one association to LonjasLinea
	@ManyToOne
	@JoinColumn(name="idlonjaslinea")
	private LonjasLinea lonjasLinea;

	//bi-directional many-to-one association to OeeDetalleParada
	@ManyToOne
	@JoinColumn(name="idoeedetalleparada")
	private OeeDetalleParada oeeDetalleParada;

	public OeeDetalleParadaLonja() {
	}

	public Long getIdoeedetalleparadalonjas() {
		return this.idoeedetalleparadalonjas;
	}

	public void setIdoeedetalleparadalonjas(Long idoeedetalleparadalonjas) {
		this.idoeedetalleparadalonjas = idoeedetalleparadalonjas;
	}

	public LonjasLinea getLonjasLinea() {
		return this.lonjasLinea;
	}

	public void setLonjasLinea(LonjasLinea lonjasLinea) {
		this.lonjasLinea = lonjasLinea;
	}

	public OeeDetalleParada getOeeDetalleParada() {
		return this.oeeDetalleParada;
	}

	public void setOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		this.oeeDetalleParada = oeeDetalleParada;
	}

}