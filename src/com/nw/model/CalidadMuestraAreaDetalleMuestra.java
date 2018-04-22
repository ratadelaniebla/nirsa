package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_muestra_area_detalle_muestra database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_area_detalle_muestra")
public class CalidadMuestraAreaDetalleMuestra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestraareadetallemuestra;

	@Column(name="\"Comentario\"")
	private String comentario;

	private Timestamp fecharegistro;

	private Integer numerocaracteristicos;

	private Integer numeronocaracteristicos;

	private Integer numerootros;

	//bi-directional many-to-one association to CalidadEvaluadoresSensoriale
	@ManyToOne
	@JoinColumn(name="idevaluador")
	private CalidadEvaluadoresSensoriale calidadEvaluadoresSensoriale;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraareacabecera")
	private CalidadMuestraAreaCabecera calidadMuestraAreaCabecera;

	//bi-directional many-to-one association to CalidadMuestraGrupoSubcaracteristica
	@ManyToOne
	@JoinColumn(name="idcalidadmuestragruposubcaracteristicas")
	private CalidadMuestraGrupoSubcaracteristica calidadMuestraGrupoSubcaracteristica;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadMuestraAreaDetalleMuestra() {
	}

	public Long getIdcalidadmuestraareadetallemuestra() {
		return this.idcalidadmuestraareadetallemuestra;
	}

	public void setIdcalidadmuestraareadetallemuestra(Long idcalidadmuestraareadetallemuestra) {
		this.idcalidadmuestraareadetallemuestra = idcalidadmuestraareadetallemuestra;
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

	public Integer getNumerocaracteristicos() {
		return this.numerocaracteristicos;
	}

	public void setNumerocaracteristicos(Integer numerocaracteristicos) {
		this.numerocaracteristicos = numerocaracteristicos;
	}

	public Integer getNumeronocaracteristicos() {
		return this.numeronocaracteristicos;
	}

	public void setNumeronocaracteristicos(Integer numeronocaracteristicos) {
		this.numeronocaracteristicos = numeronocaracteristicos;
	}

	public Integer getNumerootros() {
		return this.numerootros;
	}

	public void setNumerootros(Integer numerootros) {
		this.numerootros = numerootros;
	}

	public CalidadEvaluadoresSensoriale getCalidadEvaluadoresSensoriale() {
		return this.calidadEvaluadoresSensoriale;
	}

	public void setCalidadEvaluadoresSensoriale(CalidadEvaluadoresSensoriale calidadEvaluadoresSensoriale) {
		this.calidadEvaluadoresSensoriale = calidadEvaluadoresSensoriale;
	}

	public CalidadMuestraAreaCabecera getCalidadMuestraAreaCabecera() {
		return this.calidadMuestraAreaCabecera;
	}

	public void setCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		this.calidadMuestraAreaCabecera = calidadMuestraAreaCabecera;
	}

	public CalidadMuestraGrupoSubcaracteristica getCalidadMuestraGrupoSubcaracteristica() {
		return this.calidadMuestraGrupoSubcaracteristica;
	}

	public void setCalidadMuestraGrupoSubcaracteristica(CalidadMuestraGrupoSubcaracteristica calidadMuestraGrupoSubcaracteristica) {
		this.calidadMuestraGrupoSubcaracteristica = calidadMuestraGrupoSubcaracteristica;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}