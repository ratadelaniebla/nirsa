package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the harina_detalle_espece_recepcion_detalle_pesca_comprobante database table.
 * 
 */
@Entity
@Table(name="harina_detalle_espece_recepcion_detalle_pesca_comprobante")
@NamedQuery(name="HarinaDetalleEspeceRecepcionDetallePescaComprobante.findAll", query="SELECT h FROM HarinaDetalleEspeceRecepcionDetallePescaComprobante h")
public class HarinaDetalleEspeceRecepcionDetallePescaComprobante implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idharinadetalleespecerecepciondetallepescacomprobante;
	private double pesobruto;
	private HarinaClasificacionTipoPesca harinaClasificacionTipoPesca;
	private HarinaEspecie harinaEspecie;
	private HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante;

	public HarinaDetalleEspeceRecepcionDetallePescaComprobante() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to HarinaClasificacionTipoPesca
	@ManyToOne
	@JoinColumn(name="idharinaclasificaciontipopesca")
	public HarinaClasificacionTipoPesca getHarinaClasificacionTipoPesca() {
		return this.harinaClasificacionTipoPesca;
	}

	public void setHarinaClasificacionTipoPesca(HarinaClasificacionTipoPesca harinaClasificacionTipoPesca) {
		this.harinaClasificacionTipoPesca = harinaClasificacionTipoPesca;
	}


	//bi-directional many-to-one association to HarinaEspecie
	@ManyToOne
	@JoinColumn(name="idharinaespecie")
	public HarinaEspecie getHarinaEspecie() {
		return this.harinaEspecie;
	}

	public void setHarinaEspecie(HarinaEspecie harinaEspecie) {
		this.harinaEspecie = harinaEspecie;
	}


	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@ManyToOne
	@JoinColumn(name="idharinarecepciondetallepescacomprobante")
	public HarinaRecepcionDetallePescaComprobante getHarinaRecepcionDetallePescaComprobante() {
		return this.harinaRecepcionDetallePescaComprobante;
	}

	public void setHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		this.harinaRecepcionDetallePescaComprobante = harinaRecepcionDetallePescaComprobante;
	}

}