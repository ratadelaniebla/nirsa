package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the panzas_detalle_proceso_coche_detalle database table.
 * 
 */
@Entity
@Table(name="panzas_detalle_proceso_coche_detalle")
@NamedQuery(name="PanzasDetalleProcesoCocheDetalle.findAll", query="SELECT p FROM PanzasDetalleProcesoCocheDetalle p")
public class PanzasDetalleProcesoCocheDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpanzasdetalleprocesocochedetalle;
	private Integer cantidadpanzas;
	private Integer numcanastillas;
	private PanzasDetalleProcesoCoche panzasDetalleProcesoCoche;
	private PanzasDetalleProcesoLote panzasDetalleProcesoLote;

	public PanzasDetalleProcesoCocheDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdpanzasdetalleprocesocochedetalle() {
		return this.idpanzasdetalleprocesocochedetalle;
	}

	public void setIdpanzasdetalleprocesocochedetalle(Long idpanzasdetalleprocesocochedetalle) {
		this.idpanzasdetalleprocesocochedetalle = idpanzasdetalleprocesocochedetalle;
	}


	public Integer getCantidadpanzas() {
		return this.cantidadpanzas;
	}

	public void setCantidadpanzas(Integer cantidadpanzas) {
		this.cantidadpanzas = cantidadpanzas;
	}


	public Integer getNumcanastillas() {
		return this.numcanastillas;
	}

	public void setNumcanastillas(Integer numcanastillas) {
		this.numcanastillas = numcanastillas;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idpanzasdetalleprocesocoche")
	public PanzasDetalleProcesoCoche getPanzasDetalleProcesoCoche() {
		return this.panzasDetalleProcesoCoche;
	}

	public void setPanzasDetalleProcesoCoche(PanzasDetalleProcesoCoche panzasDetalleProcesoCoche) {
		this.panzasDetalleProcesoCoche = panzasDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idpanzasdetalleprocesolote")
	public PanzasDetalleProcesoLote getPanzasDetalleProcesoLote() {
		return this.panzasDetalleProcesoLote;
	}

	public void setPanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		this.panzasDetalleProcesoLote = panzasDetalleProcesoLote;
	}

}