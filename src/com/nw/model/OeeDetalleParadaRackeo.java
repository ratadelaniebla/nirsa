package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_parada_rackeo database table.
 * 
 */
@Entity
@Table(name="oee_detalle_parada_rackeo")
public class OeeDetalleParadaRackeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idoeedetalleparadarackeo;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleproceso")
	private DescongeladoDetalleProceso descongeladoDetalleProceso;

	//bi-directional many-to-one association to OeeDetalleParada
	@ManyToOne
	@JoinColumn(name="idoeedetalleparada")
	private OeeDetalleParada oeeDetalleParada;

	public OeeDetalleParadaRackeo() {
	}

	public Long getIdoeedetalleparadarackeo() {
		return this.idoeedetalleparadarackeo;
	}

	public void setIdoeedetalleparadarackeo(Long idoeedetalleparadarackeo) {
		this.idoeedetalleparadarackeo = idoeedetalleparadarackeo;
	}

	public DescongeladoDetalleProceso getDescongeladoDetalleProceso() {
		return this.descongeladoDetalleProceso;
	}

	public void setDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		this.descongeladoDetalleProceso = descongeladoDetalleProceso;
	}

	public OeeDetalleParada getOeeDetalleParada() {
		return this.oeeDetalleParada;
	}

	public void setOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		this.oeeDetalleParada = oeeDetalleParada;
	}

}