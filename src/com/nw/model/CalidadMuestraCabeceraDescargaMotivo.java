package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_muestra_cabecera_descarga_motivo database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_cabecera_descarga_motivo")
public class CalidadMuestraCabeceraDescargaMotivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestracabeceradescargamotivo;

	private Integer cantidad;

	private String comentario;

	private Timestamp fecharegistro;

	//bi-directional many-to-one association to CalidadMuestraAreaDetalle
	@OneToMany(mappedBy="calidadMuestraCabeceraDescargaMotivo")
	private List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraareacabecera")
	private CalidadMuestraAreaCabecera calidadMuestraAreaCabecera;

	//bi-directional many-to-one association to CalidadMuestraAreaMotivo
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraareamotivo")
	private CalidadMuestraAreaMotivo calidadMuestraAreaMotivo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadMuestraCabeceraDescargaMotivo() {
	}

	public Long getIdcalidadmuestracabeceradescargamotivo() {
		return this.idcalidadmuestracabeceradescargamotivo;
	}

	public void setIdcalidadmuestracabeceradescargamotivo(Long idcalidadmuestracabeceradescargamotivo) {
		this.idcalidadmuestracabeceradescargamotivo = idcalidadmuestracabeceradescargamotivo;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public List<CalidadMuestraAreaDetalle> getCalidadMuestraAreaDetalles() {
		return this.calidadMuestraAreaDetalles;
	}

	public void setCalidadMuestraAreaDetalles(List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles) {
		this.calidadMuestraAreaDetalles = calidadMuestraAreaDetalles;
	}

	public CalidadMuestraAreaCabecera getCalidadMuestraAreaCabecera() {
		return this.calidadMuestraAreaCabecera;
	}

	public void setCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		this.calidadMuestraAreaCabecera = calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaMotivo getCalidadMuestraAreaMotivo() {
		return this.calidadMuestraAreaMotivo;
	}

	public void setCalidadMuestraAreaMotivo(CalidadMuestraAreaMotivo calidadMuestraAreaMotivo) {
		this.calidadMuestraAreaMotivo = calidadMuestraAreaMotivo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}