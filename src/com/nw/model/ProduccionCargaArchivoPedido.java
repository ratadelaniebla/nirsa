package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the produccion_carga_archivo_pedidos database table.
 * 
 */
@Entity
@Table(name="produccion_carga_archivo_pedidos")
public class ProduccionCargaArchivoPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproduccionarchivocargapedidos;

	private Timestamp fechaarchivo;

	private Timestamp fechacarga;

	private String nombrearchivo;

	private Integer turnoarchivo;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to ProduccionDetalleArchivoPedido
	@OneToMany(mappedBy="produccionCargaArchivoPedido")
	private List<ProduccionDetalleArchivoPedido> produccionDetalleArchivoPedidos;

	public ProduccionCargaArchivoPedido() {
	}

	public Long getIdproduccionarchivocargapedidos() {
		return this.idproduccionarchivocargapedidos;
	}

	public void setIdproduccionarchivocargapedidos(Long idproduccionarchivocargapedidos) {
		this.idproduccionarchivocargapedidos = idproduccionarchivocargapedidos;
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

	public Integer getTurnoarchivo() {
		return this.turnoarchivo;
	}

	public void setTurnoarchivo(Integer turnoarchivo) {
		this.turnoarchivo = turnoarchivo;
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

	public List<ProduccionDetalleArchivoPedido> getProduccionDetalleArchivoPedidos() {
		return this.produccionDetalleArchivoPedidos;
	}

	public void setProduccionDetalleArchivoPedidos(List<ProduccionDetalleArchivoPedido> produccionDetalleArchivoPedidos) {
		this.produccionDetalleArchivoPedidos = produccionDetalleArchivoPedidos;
	}

}