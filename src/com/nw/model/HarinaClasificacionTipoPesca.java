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
public class HarinaClasificacionTipoPesca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idharinaclasificaciontipopesca;

	private String descripcion;

	//bi-directional many-to-one association to HarinaDetalleEspeceRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaClasificacionTipoPesca")
	private List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes;

	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="harinaClasificacionTipoPesca")
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;

	public HarinaClasificacionTipoPesca() {
	}

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

	public List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> getHarinaDetalleEspeceRecepcionDetallePescaComprobantes() {
		return this.harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public void setHarinaDetalleEspeceRecepcionDetallePescaComprobantes(List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes) {
		this.harinaDetalleEspeceRecepcionDetallePescaComprobantes = harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

}