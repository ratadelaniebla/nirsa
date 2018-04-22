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
public class ProduccionArchivoCargaOrden implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproduccionarchivocargaorden;
	private Timestamp fechaarchivo;
	private Timestamp fechacarga;
	private Long idproduccion;
	private String idusuario;
	private String nombrearchivo;
	private String observacion;
	private Integer semana;
	private List<ProduccionArchivoCargaOrdenDetalle> produccionArchivoCargaOrdenDetalles;

	public ProduccionArchivoCargaOrden() {
	}


	@Id
	@SequenceGenerator(name="PRODUCCION_ARCHIVO_CARGA_ORDEN_IDPRODUCCIONARCHIVOCARGAORDEN_GENERATOR", sequenceName="PRODUCCION_ARCHIVO_CARGA_ORDE_IDPRODUCCIONARCHIVOCARGAORDEN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCCION_ARCHIVO_CARGA_ORDEN_IDPRODUCCIONARCHIVOCARGAORDEN_GENERATOR")
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


	public Long getIdproduccion() {
		return this.idproduccion;
	}

	public void setIdproduccion(Long idproduccion) {
		this.idproduccion = idproduccion;
	}


	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
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


	//bi-directional many-to-one association to ProduccionArchivoCargaOrdenDetalle
	@OneToMany(mappedBy="produccionArchivoCargaOrden")
	public List<ProduccionArchivoCargaOrdenDetalle> getProduccionArchivoCargaOrdenDetalles() {
		return this.produccionArchivoCargaOrdenDetalles;
	}

	public void setProduccionArchivoCargaOrdenDetalles(List<ProduccionArchivoCargaOrdenDetalle> produccionArchivoCargaOrdenDetalles) {
		this.produccionArchivoCargaOrdenDetalles = produccionArchivoCargaOrdenDetalles;
	}

}