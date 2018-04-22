package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_muestra_area_cabecera_aprobacion database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_area_cabecera_aprobacion")
public class CalidadMuestraAreaCabeceraAprobacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestraareacabeceraaprobacion;

	private Boolean accesoaprobacion;

	private Boolean accesorevision;

	private Boolean accesoverificado;

	private String comentario;

	private Timestamp fecharegistro;

	private Integer idarearevisionaprobacion;

	//bi-directional many-to-one association to CalidadMuestraArea
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraarea")
	private CalidadMuestraArea calidadMuestraArea;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraareacabecera")
	private CalidadMuestraAreaCabecera calidadMuestraAreaCabecera;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to UsuariosAprobacion
	@ManyToOne
	@JoinColumn(name="idusuarioaprobacion")
	private UsuariosAprobacion usuariosAprobacion;

	public CalidadMuestraAreaCabeceraAprobacion() {
	}

	public Long getIdcalidadmuestraareacabeceraaprobacion() {
		return this.idcalidadmuestraareacabeceraaprobacion;
	}

	public void setIdcalidadmuestraareacabeceraaprobacion(Long idcalidadmuestraareacabeceraaprobacion) {
		this.idcalidadmuestraareacabeceraaprobacion = idcalidadmuestraareacabeceraaprobacion;
	}

	public Boolean getAccesoaprobacion() {
		return this.accesoaprobacion;
	}

	public void setAccesoaprobacion(Boolean accesoaprobacion) {
		this.accesoaprobacion = accesoaprobacion;
	}

	public Boolean getAccesorevision() {
		return this.accesorevision;
	}

	public void setAccesorevision(Boolean accesorevision) {
		this.accesorevision = accesorevision;
	}

	public Boolean getAccesoverificado() {
		return this.accesoverificado;
	}

	public void setAccesoverificado(Boolean accesoverificado) {
		this.accesoverificado = accesoverificado;
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

	public Integer getIdarearevisionaprobacion() {
		return this.idarearevisionaprobacion;
	}

	public void setIdarearevisionaprobacion(Integer idarearevisionaprobacion) {
		this.idarearevisionaprobacion = idarearevisionaprobacion;
	}

	public CalidadMuestraArea getCalidadMuestraArea() {
		return this.calidadMuestraArea;
	}

	public void setCalidadMuestraArea(CalidadMuestraArea calidadMuestraArea) {
		this.calidadMuestraArea = calidadMuestraArea;
	}

	public CalidadMuestraAreaCabecera getCalidadMuestraAreaCabecera() {
		return this.calidadMuestraAreaCabecera;
	}

	public void setCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		this.calidadMuestraAreaCabecera = calidadMuestraAreaCabecera;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuariosAprobacion getUsuariosAprobacion() {
		return this.usuariosAprobacion;
	}

	public void setUsuariosAprobacion(UsuariosAprobacion usuariosAprobacion) {
		this.usuariosAprobacion = usuariosAprobacion;
	}

}