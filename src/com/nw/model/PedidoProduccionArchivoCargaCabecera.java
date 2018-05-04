package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pedido_produccion_archivo_carga_cabecera database table.
 * 
 */
@Entity
@Table(name="pedido_produccion_archivo_carga_cabecera")
@NamedQuery(name="PedidoProduccionArchivoCargaCabecera.findAll", query="SELECT p FROM PedidoProduccionArchivoCargaCabecera p")
public class PedidoProduccionArchivoCargaCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpedidoproduccionarchivocargacabecera;
	private Timestamp fechaarchivo;
	private Timestamp fechacarga;
	private String nombrearchivo;
	private Produccion produccion;
	private Usuario usuario;
	private List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles;
	private List<PedidoProduccionCabecera> pedidoProduccionCabeceras;

	public PedidoProduccionArchivoCargaCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdpedidoproduccionarchivocargacabecera() {
		return this.idpedidoproduccionarchivocargacabecera;
	}

	public void setIdpedidoproduccionarchivocargacabecera(Long idpedidoproduccionarchivocargacabecera) {
		this.idpedidoproduccionarchivocargacabecera = idpedidoproduccionarchivocargacabecera;
	}


	public Timestamp getFechaarchivo() {
		return this.fechaarchivo;
	}

	public void setFechaarchivo(Timestamp fechaarchivo) {
		this.fechaarchivo = fechaarchivo;
	}


	public Timestamp getFechacarga() {
		return this.fechacarga;
	}

	public void setFechacarga(Timestamp fechacarga) {
		this.fechacarga = fechacarga;
	}


	public String getNombrearchivo() {
		return this.nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
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


	//bi-directional many-to-one association to PedidoProduccionArchivoCargaDetalle
	@OneToMany(mappedBy="pedidoProduccionArchivoCargaCabecera")
	public List<PedidoProduccionArchivoCargaDetalle> getPedidoProduccionArchivoCargaDetalles() {
		return this.pedidoProduccionArchivoCargaDetalles;
	}

	public void setPedidoProduccionArchivoCargaDetalles(List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles) {
		this.pedidoProduccionArchivoCargaDetalles = pedidoProduccionArchivoCargaDetalles;
	}

	public PedidoProduccionArchivoCargaDetalle addPedidoProduccionArchivoCargaDetalle(PedidoProduccionArchivoCargaDetalle pedidoProduccionArchivoCargaDetalle) {
		getPedidoProduccionArchivoCargaDetalles().add(pedidoProduccionArchivoCargaDetalle);
		pedidoProduccionArchivoCargaDetalle.setPedidoProduccionArchivoCargaCabecera(this);

		return pedidoProduccionArchivoCargaDetalle;
	}

	public PedidoProduccionArchivoCargaDetalle removePedidoProduccionArchivoCargaDetalle(PedidoProduccionArchivoCargaDetalle pedidoProduccionArchivoCargaDetalle) {
		getPedidoProduccionArchivoCargaDetalles().remove(pedidoProduccionArchivoCargaDetalle);
		pedidoProduccionArchivoCargaDetalle.setPedidoProduccionArchivoCargaCabecera(null);

		return pedidoProduccionArchivoCargaDetalle;
	}


	//bi-directional many-to-one association to PedidoProduccionCabecera
	@OneToMany(mappedBy="pedidoProduccionArchivoCargaCabecera")
	public List<PedidoProduccionCabecera> getPedidoProduccionCabeceras() {
		return this.pedidoProduccionCabeceras;
	}

	public void setPedidoProduccionCabeceras(List<PedidoProduccionCabecera> pedidoProduccionCabeceras) {
		this.pedidoProduccionCabeceras = pedidoProduccionCabeceras;
	}

	public PedidoProduccionCabecera addPedidoProduccionCabecera(PedidoProduccionCabecera pedidoProduccionCabecera) {
		getPedidoProduccionCabeceras().add(pedidoProduccionCabecera);
		pedidoProduccionCabecera.setPedidoProduccionArchivoCargaCabecera(this);

		return pedidoProduccionCabecera;
	}

	public PedidoProduccionCabecera removePedidoProduccionCabecera(PedidoProduccionCabecera pedidoProduccionCabecera) {
		getPedidoProduccionCabeceras().remove(pedidoProduccionCabecera);
		pedidoProduccionCabecera.setPedidoProduccionArchivoCargaCabecera(null);

		return pedidoProduccionCabecera;
	}

}