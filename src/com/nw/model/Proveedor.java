package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproveedor;
	private String apellidosProveedor;
	private String cedulaProveedor;
	private String codigosap;
	private String nombresProveedor;
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;

	public Proveedor() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdproveedor() {
		return this.idproveedor;
	}

	public void setIdproveedor(Long idproveedor) {
		this.idproveedor = idproveedor;
	}


	@Column(name="apellidos_proveedor")
	public String getApellidosProveedor() {
		return this.apellidosProveedor;
	}

	public void setApellidosProveedor(String apellidosProveedor) {
		this.apellidosProveedor = apellidosProveedor;
	}


	@Column(name="cedula_proveedor")
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


	@Column(name="nombres_proveedor")
	public String getNombresProveedor() {
		return this.nombresProveedor;
	}

	public void setNombresProveedor(String nombresProveedor) {
		this.nombresProveedor = nombresProveedor;
	}


	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="proveedor")
	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

	public HarinaRecepcionPescaComprobante addHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().add(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setProveedor(this);

		return harinaRecepcionPescaComprobante;
	}

	public HarinaRecepcionPescaComprobante removeHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().remove(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setProveedor(null);

		return harinaRecepcionPescaComprobante;
	}

}