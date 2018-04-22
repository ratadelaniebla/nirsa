package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the harina_detalle_espece_recepcion_detalle_pesca_comprobante database table.
 * 
 */
@Entity
@Table(name="harina_detalle_espece_recepcion_detalle_pesca_comprobante")
public class HarinaDetalleEspeceRecepcionDetallePescaComprobante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idharinadetalleespecerecepciondetallepescacomprobante;

	private double pesobruto;

	//bi-directional many-to-one association to HarinaClasificacionTipoPesca
	@ManyToOne
	@JoinColumn(name="idharinaclasificaciontipopesca")
	private HarinaClasificacionTipoPesca harinaClasificacionTipoPesca;

	//bi-directional many-to-one association to HarinaEspecie
	@ManyToOne
	@JoinColumn(name="idharinaespecie")
	private HarinaEspecie harinaEspecie;

	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@ManyToOne
	@JoinColumn(name="idharinarecepciondetallepescacomprobante")
	private HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante;

	public HarinaDetalleEspeceRecepcionDetallePescaComprobante() {
	}

	public Long getIdharinadetalleespecerecepciondetallepescacomprobante() {
		return this.idharinadetalleespecerecepciondetallepescacomprobante;
	}

	public void setIdharinadetalleespecerecepciondetallepescacomprobante(Long idharinadetalleespecerecepciondetallepescacomprobante) {
		this.idharinadetalleespecerecepciondetallepescacomprobante = idharinadetalleespecerecepciondetallepescacomprobante;
	}

	public double getPesobruto() {
		return this.pesobruto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public HarinaClasificacionTipoPesca getHarinaClasificacionTipoPesca() {
		return this.harinaClasificacionTipoPesca;
	}

	public void setHarinaClasificacionTipoPesca(HarinaClasificacionTipoPesca harinaClasificacionTipoPesca) {
		this.harinaClasificacionTipoPesca = harinaClasificacionTipoPesca;
	}

	public HarinaEspecie getHarinaEspecie() {
		return this.harinaEspecie;
	}

	public void setHarinaEspecie(HarinaEspecie harinaEspecie) {
		this.harinaEspecie = harinaEspecie;
	}

	public HarinaRecepcionDetallePescaComprobante getHarinaRecepcionDetallePescaComprobante() {
		return this.harinaRecepcionDetallePescaComprobante;
	}

	public void setHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		this.harinaRecepcionDetallePescaComprobante = harinaRecepcionDetallePescaComprobante;
	}

}