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
@NamedQuery(name="ProduccionCargaArchivoPedido.findAll", query="SELECT p FROM ProduccionCargaArchivoPedido p")
public class ProduccionCargaArchivoPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproduccionarchivocargapedidos;
	private Timestamp fechaarchivo;
	private Timestamp fechacarga;
	private String nombrearchivo;
	private Integer turnoarchivo;
	private Produccion produccion;
	private Usuario usuario;
	private List<ProduccionDetalleArchivoPedido> produccionDetalleArchivoPedidos;

	public ProduccionCargaArchivoPedido() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to ProduccionDetalleArchivoPedido
	@OneToMany(mappedBy="produccionCargaArchivoPedido")
	public List<ProduccionDetalleArchivoPedido> getProduccionDetalleArchivoPedidos() {
		return this.produccionDetalleArchivoPedidos;
	}

	public void setProduccionDetalleArchivoPedidos(List<ProduccionDetalleArchivoPedido> produccionDetalleArchivoPedidos) {
		this.produccionDetalleArchivoPedidos = produccionDetalleArchivoPedidos;
	}

	public ProduccionDetalleArchivoPedido addProduccionDetalleArchivoPedido(ProduccionDetalleArchivoPedido produccionDetalleArchivoPedido) {
		getProduccionDetalleArchivoPedidos().add(produccionDetalleArchivoPedido);
		produccionDetalleArchivoPedido.setProduccionCargaArchivoPedido(this);

		return produccionDetalleArchivoPedido;
	}

	public ProduccionDetalleArchivoPedido removeProduccionDetalleArchivoPedido(ProduccionDetalleArchivoPedido produccionDetalleArchivoPedido) {
		getProduccionDetalleArchivoPedidos().remove(produccionDetalleArchivoPedido);
		produccionDetalleArchivoPedido.setProduccionCargaArchivoPedido(null);

		return produccionDetalleArchivoPedido;
	}

}