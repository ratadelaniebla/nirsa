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
@NamedQuery(name="ProduccionArchivoCargaLote.findAll", query="SELECT p FROM ProduccionArchivoCargaLote p")
public class ProduccionArchivoCargaLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproduccionarchivocargalote;
	private Timestamp fechaarchivo;
	private Timestamp fechacarga;
	private String nombrearchivo;
	private Integer turnoarchivo;
	private Produccion produccion;
	private Usuario usuario;
	private List<ProduccionCargaLote> produccionCargaLotes;

	public ProduccionArchivoCargaLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to ProduccionCargaLote
	@OneToMany(mappedBy="produccionArchivoCargaLote")
	public List<ProduccionCargaLote> getProduccionCargaLotes() {
		return this.produccionCargaLotes;
	}

	public void setProduccionCargaLotes(List<ProduccionCargaLote> produccionCargaLotes) {
		this.produccionCargaLotes = produccionCargaLotes;
	}

	public ProduccionCargaLote addProduccionCargaLote(ProduccionCargaLote produccionCargaLote) {
		getProduccionCargaLotes().add(produccionCargaLote);
		produccionCargaLote.setProduccionArchivoCargaLote(this);

		return produccionCargaLote;
	}

	public ProduccionCargaLote removeProduccionCargaLote(ProduccionCargaLote produccionCargaLote) {
		getProduccionCargaLotes().remove(produccionCargaLote);
		produccionCargaLote.setProduccionArchivoCargaLote(null);

		return produccionCargaLote;
	}

}