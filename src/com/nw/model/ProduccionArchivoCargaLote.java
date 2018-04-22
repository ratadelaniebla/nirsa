package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the produccion_archivo_carga_lote database table.
 * 
 */
@Entity
@Table(name="produccion_archivo_carga_lote")
public class ProduccionArchivoCargaLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproduccionarchivocargalote;

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

	//bi-directional many-to-one association to ProduccionCargaLote
	@OneToMany(mappedBy="produccionArchivoCargaLote")
	private List<ProduccionCargaLote> produccionCargaLotes;

	public ProduccionArchivoCargaLote() {
	}

	public Long getIdproduccionarchivocargalote() {
		return this.idproduccionarchivocargalote;
	}

	public void setIdproduccionarchivocargalote(Long idproduccionarchivocargalote) {
		this.idproduccionarchivocargalote = idproduccionarchivocargalote;
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

	public List<ProduccionCargaLote> getProduccionCargaLotes() {
		return this.produccionCargaLotes;
	}

	public void setProduccionCargaLotes(List<ProduccionCargaLote> produccionCargaLotes) {
		this.produccionCargaLotes = produccionCargaLotes;
	}

}