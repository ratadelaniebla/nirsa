package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the produccion_archivo_carga_orden database table.
 * 
 */
@Entity
@Table(name="produccion_archivo_carga_orden")
@NamedQuery(name="ProduccionArchivoCargaOrden.findAll", query="SELECT p FROM ProduccionArchivoCargaOrden p")
public class ProduccionArchivoCargaOrden implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproduccionarchivocargaorden;
	private Timestamp fechaarchivo;
	private Timestamp fechacarga;
	private String nombrearchivo;
	private String observacion;
	private Integer semana;
	private Produccion produccion;
	private Usuario usuario;
	private List<ProduccionArchivoCargaOrdenDetalle> produccionArchivoCargaOrdenDetalles;

	public ProduccionArchivoCargaOrden() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdproduccionarchivocargaorden() {
		return this.idproduccionarchivocargaorden;
	}

	public void setIdproduccionarchivocargaorden(Long idproduccionarchivocargaorden) {
		this.idproduccionarchivocargaorden = idproduccionarchivocargaorden;
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


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Integer getSemana() {
		return this.semana;
	}

	public void setSemana(Integer semana) {
		this.semana = semana;
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


	//bi-directional many-to-one association to ProduccionArchivoCargaOrdenDetalle
	@OneToMany(mappedBy="produccionArchivoCargaOrden")
	public List<ProduccionArchivoCargaOrdenDetalle> getProduccionArchivoCargaOrdenDetalles() {
		return this.produccionArchivoCargaOrdenDetalles;
	}

	public void setProduccionArchivoCargaOrdenDetalles(List<ProduccionArchivoCargaOrdenDetalle> produccionArchivoCargaOrdenDetalles) {
		this.produccionArchivoCargaOrdenDetalles = produccionArchivoCargaOrdenDetalles;
	}

	public ProduccionArchivoCargaOrdenDetalle addProduccionArchivoCargaOrdenDetalle(ProduccionArchivoCargaOrdenDetalle produccionArchivoCargaOrdenDetalle) {
		getProduccionArchivoCargaOrdenDetalles().add(produccionArchivoCargaOrdenDetalle);
		produccionArchivoCargaOrdenDetalle.setProduccionArchivoCargaOrden(this);

		return produccionArchivoCargaOrdenDetalle;
	}

	public ProduccionArchivoCargaOrdenDetalle removeProduccionArchivoCargaOrdenDetalle(ProduccionArchivoCargaOrdenDetalle produccionArchivoCargaOrdenDetalle) {
		getProduccionArchivoCargaOrdenDetalles().remove(produccionArchivoCargaOrdenDetalle);
		produccionArchivoCargaOrdenDetalle.setProduccionArchivoCargaOrden(null);

		return produccionArchivoCargaOrdenDetalle;
	}

}