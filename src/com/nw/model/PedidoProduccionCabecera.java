package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pedido_produccion_cabecera database table.
 * 
 */
@Entity
@Table(name="pedido_produccion_cabecera")
public class PedidoProduccionCabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpedidoproduccioncabecera;

	private Timestamp fechreg;

	//bi-directional many-to-one association to PedidoProduccionArchivoCargaCabecera
	@ManyToOne
	@JoinColumn(name="idpedidoproduccionarchivocargacabecera")
	private PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to PedidoProduccionDetalle
	@OneToMany(mappedBy="pedidoProduccionCabecera")
	private List<PedidoProduccionDetalle> pedidoProduccionDetalles;

	public PedidoProduccionCabecera() {
	}

	public Integer getIdpedidoproduccioncabecera() {
		return this.idpedidoproduccioncabecera;
	}

	public void setIdpedidoproduccioncabecera(Integer idpedidoproduccioncabecera) {
		this.idpedidoproduccioncabecera = idpedidoproduccioncabecera;
	}

	public Timestamp getFechreg() {
		return this.fechreg;
	}

	public void setFechreg(Timestamp fechreg) {
		this.fechreg = fechreg;
	}

	public PedidoProduccionArchivoCargaCabecera getPedidoProduccionArchivoCargaCabecera() {
		return this.pedidoProduccionArchivoCargaCabecera;
	}

	public void setPedidoProduccionArchivoCargaCabecera(PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera) {
		this.pedidoProduccionArchivoCargaCabecera = pedidoProduccionArchivoCargaCabecera;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<PedidoProduccionDetalle> getPedidoProduccionDetalles() {
		return this.pedidoProduccionDetalles;
	}

	public void setPedidoProduccionDetalles(List<PedidoProduccionDetalle> pedidoProduccionDetalles) {
		this.pedidoProduccionDetalles = pedidoProduccionDetalles;
	}

}