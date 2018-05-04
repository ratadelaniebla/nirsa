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
@NamedQuery(name="PedidoProduccionCabecera.findAll", query="SELECT p FROM PedidoProduccionCabecera p")
public class PedidoProduccionCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idpedidoproduccioncabecera;
	private Timestamp fechreg;
	private PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera;
	private Produccion produccion;
	private Usuario usuario;
	private List<PedidoProduccionDetalle> pedidoProduccionDetalles;

	public PedidoProduccionCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to PedidoProduccionArchivoCargaCabecera
	@ManyToOne
	@JoinColumn(name="idpedidoproduccionarchivocargacabecera")
	public PedidoProduccionArchivoCargaCabecera getPedidoProduccionArchivoCargaCabecera() {
		return this.pedidoProduccionArchivoCargaCabecera;
	}

	public void setPedidoProduccionArchivoCargaCabecera(PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera) {
		this.pedidoProduccionArchivoCargaCabecera = pedidoProduccionArchivoCargaCabecera;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to PedidoProduccionDetalle
	@OneToMany(mappedBy="pedidoProduccionCabecera")
	public List<PedidoProduccionDetalle> getPedidoProduccionDetalles() {
		return this.pedidoProduccionDetalles;
	}

	public void setPedidoProduccionDetalles(List<PedidoProduccionDetalle> pedidoProduccionDetalles) {
		this.pedidoProduccionDetalles = pedidoProduccionDetalles;
	}

	public PedidoProduccionDetalle addPedidoProduccionDetalle(PedidoProduccionDetalle pedidoProduccionDetalle) {
		getPedidoProduccionDetalles().add(pedidoProduccionDetalle);
		pedidoProduccionDetalle.setPedidoProduccionCabecera(this);

		return pedidoProduccionDetalle;
	}

	public PedidoProduccionDetalle removePedidoProduccionDetalle(PedidoProduccionDetalle pedidoProduccionDetalle) {
		getPedidoProduccionDetalles().remove(pedidoProduccionDetalle);
		pedidoProduccionDetalle.setPedidoProduccionCabecera(null);

		return pedidoProduccionDetalle;
	}

}