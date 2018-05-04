package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_parada_rackeo database table.
 * 
 */
@Entity
@Table(name="oee_detalle_parada_rackeo")
@NamedQuery(name="OeeDetalleParadaRackeo.findAll", query="SELECT o FROM OeeDetalleParadaRackeo o")
public class OeeDetalleParadaRackeo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idoeedetalleparadarackeo;
	private DescongeladoDetalleProceso descongeladoDetalleProceso;
	private OeeDetalleParada oeeDetalleParada;

	public OeeDetalleParadaRackeo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdoeedetalleparadarackeo() {
		return this.idoeedetalleparadarackeo;
	}

	public void setIdoeedetalleparadarackeo(Long idoeedetalleparadarackeo) {
		this.idoeedetalleparadarackeo = idoeedetalleparadarackeo;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleproceso")
	public DescongeladoDetalleProceso getDescongeladoDetalleProceso() {
		return this.descongeladoDetalleProceso;
	}

	public void setDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		this.descongeladoDetalleProceso = descongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to OeeDetalleParada
	@ManyToOne
	@JoinColumn(name="idoeedetalleparada")
	public OeeDetalleParada getOeeDetalleParada() {
		return this.oeeDetalleParada;
	}

	public void setOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		this.oeeDetalleParada = oeeDetalleParada;
	}

}