package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproveedor;

	@Column(name="apellidos_proveedor")
	private String apellidosProveedor;

	@Column(name="cedula_proveedor")
	private String cedulaProveedor;

	private String codigosap;

	@Column(name="nombres_proveedor")
	private String nombresProveedor;

	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="proveedor")
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;

	public Proveedor() {
	}

	public Long getIdproveedor() {
		return this.idproveedor;
	}

	public void setIdproveedor(Long idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getApellidosProveedor() {
		return this.apellidosProveedor;
	}

	public void setApellidosProveedor(String apellidosProveedor) {
		this.apellidosProveedor = apellidosProveedor;
	}

	public String getCedulaProveedor() {
		return this.cedulaProveedor;
	}

	public void setCedulaProveedor(String cedulaProveedor) {
		this.cedulaProveedor = cedulaProveedor;
	}

	public String getCodigosap() {
		return this.codigosap;
	}

	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}

	public String getNombresProveedor() {
		return this.nombresProveedor;
	}

	public void setNombresProveedor(String nombresProveedor) {
		this.nombresProveedor = nombresProveedor;
	}

	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

}