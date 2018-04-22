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
public class PedidoProduccionArchivoCargaCabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpedidoproduccionarchivocargacabecera;

	private Timestamp fechaarchivo;

	private Timestamp fechacarga;

	private String nombrearchivo;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to PedidoProduccionArchivoCargaDetalle
	@OneToMany(mappedBy="pedidoProduccionArchivoCargaCabecera")
	private List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles;

	//bi-directional many-to-one association to PedidoProduccionCabecera
	@OneToMany(mappedBy="pedidoProduccionArchivoCargaCabecera")
	private List<PedidoProduccionCabecera> pedidoProduccionCabeceras;

	public PedidoProduccionArchivoCargaCabecera() {
	}

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

	public List<PedidoProduccionArchivoCargaDetalle> getPedidoProduccionArchivoCargaDetalles() {
		return this.pedidoProduccionArchivoCargaDetalles;
	}

	public void setPedidoProduccionArchivoCargaDetalles(List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles) {
		this.pedidoProduccionArchivoCargaDetalles = pedidoProduccionArchivoCargaDetalles;
	}

	public List<PedidoProduccionCabecera> getPedidoProduccionCabeceras() {
		return this.pedidoProduccionCabeceras;
	}

	public void setPedidoProduccionCabeceras(List<PedidoProduccionCabecera> pedidoProduccionCabeceras) {
		this.pedidoProduccionCabeceras = pedidoProduccionCabeceras;
	}

}