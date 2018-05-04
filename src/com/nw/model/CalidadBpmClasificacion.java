package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_bpm_clasificacion database table.
 * 
 */
@Entity
@Table(name="calidad_bpm_clasificacion")
@NamedQuery(name="CalidadBpmClasificacion.findAll", query="SELECT c FROM CalidadBpmClasificacion c")
public class CalidadBpmClasificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idbpmclasificacion;
	private Integer estado;
	private Timestamp fecha;
	private String observaciones;
	private BarcoDescarga barcoDescarga;
	private List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions;

	public CalidadBpmClasificacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdbpmclasificacion() {
		return this.idbpmclasificacion;
	}

	public void setIdbpmclasificacion(Long idbpmclasificacion) {
		this.idbpmclasificacion = idbpmclasificacion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}


	//bi-directional many-to-one association to CalidadRespuestaPreguntaBpmclasificacion
	@OneToMany(mappedBy="calidadBpmClasificacion")
	public List<CalidadRespuestaPreguntaBpmclasificacion> getCalidadRespuestaPreguntaBpmclasificacions() {
		return this.calidadRespuestaPreguntaBpmclasificacions;
	}

	public void setCalidadRespuestaPreguntaBpmclasificacions(List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions) {
		this.calidadRespuestaPreguntaBpmclasificacions = calidadRespuestaPreguntaBpmclasificacions;
	}

	public CalidadRespuestaPreguntaBpmclasificacion addCalidadRespuestaPreguntaBpmclasificacion(CalidadRespuestaPreguntaBpmclasificacion calidadRespuestaPreguntaBpmclasificacion) {
		getCalidadRespuestaPreguntaBpmclasificacions().add(calidadRespuestaPreguntaBpmclasificacion);
		calidadRespuestaPreguntaBpmclasificacion.setCalidadBpmClasificacion(this);

		return calidadRespuestaPreguntaBpmclasificacion;
	}

	public CalidadRespuestaPreguntaBpmclasificacion removeCalidadRespuestaPreguntaBpmclasificacion(CalidadRespuestaPreguntaBpmclasificacion calidadRespuestaPreguntaBpmclasificacion) {
		getCalidadRespuestaPreguntaBpmclasificacions().remove(calidadRespuestaPreguntaBpmclasificacion);
		calidadRespuestaPreguntaBpmclasificacion.setCalidadBpmClasificacion(null);

		return calidadRespuestaPreguntaBpmclasificacion;
	}

}