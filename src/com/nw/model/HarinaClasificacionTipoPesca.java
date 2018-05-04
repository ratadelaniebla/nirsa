package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the harina_clasificacion_tipo_pesca database table.
 * 
 */
@Entity
@Table(name="harina_clasificacion_tipo_pesca")
@NamedQuery(name="HarinaClasificacionTipoPesca.findAll", query="SELECT h FROM HarinaClasificacionTipoPesca h")
public class HarinaClasificacionTipoPesca implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idharinaclasificaciontipopesca;
	private String descripcion;
	private List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;

	public HarinaClasificacionTipoPesca() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdharinaclasificaciontipopesca() {
		return this.idharinaclasificaciontipopesca;
	}

	public void setIdharinaclasificaciontipopesca(Long idharinaclasificaciontipopesca) {
		this.idharinaclasificaciontipopesca = idharinaclasificaciontipopesca;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to HarinaDetalleEspeceRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaClasificacionTipoPesca")
	public List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> getHarinaDetalleEspeceRecepcionDetallePescaComprobantes() {
		return this.harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public void setHarinaDetalleEspeceRecepcionDetallePescaComprobantes(List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes) {
		this.harinaDetalleEspeceRecepcionDetallePescaComprobantes = harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public HarinaDetalleEspeceRecepcionDetallePescaComprobante addHarinaDetalleEspeceRecepcionDetallePescaComprobante(HarinaDetalleEspeceRecepcionDetallePescaComprobante harinaDetalleEspeceRecepcionDetallePescaComprobante) {
		getHarinaDetalleEspeceRecepcionDetallePescaComprobantes().add(harinaDetalleEspeceRecepcionDetallePescaComprobante);
		harinaDetalleEspeceRecepcionDetallePescaComprobante.setHarinaClasificacionTipoPesca(this);

		return harinaDetalleEspeceRecepcionDetallePescaComprobante;
	}

	public HarinaDetalleEspeceRecepcionDetallePescaComprobante removeHarinaDetalleEspeceRecepcionDetallePescaComprobante(HarinaDetalleEspeceRecepcionDetallePescaComprobante harinaDetalleEspeceRecepcionDetallePescaComprobante) {
		getHarinaDetalleEspeceRecepcionDetallePescaComprobantes().remove(harinaDetalleEspeceRecepcionDetallePescaComprobante);
		harinaDetalleEspeceRecepcionDetallePescaComprobante.setHarinaClasificacionTipoPesca(null);

		return harinaDetalleEspeceRecepcionDetallePescaComprobante;
	}


	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="harinaClasificacionTipoPesca")
	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

	public HarinaRecepcionPescaComprobante addHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().add(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setHarinaClasificacionTipoPesca(this);

		return harinaRecepcionPescaComprobante;
	}

	public HarinaRecepcionPescaComprobante removeHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().remove(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setHarinaClasificacionTipoPesca(null);

		return harinaRecepcionPescaComprobante;
	}

}