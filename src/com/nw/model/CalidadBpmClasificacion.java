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
public class CalidadBpmClasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbpmclasificacion;

	private Integer estado;

	private Timestamp fecha;

	private String observaciones;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	//bi-directional many-to-one association to CalidadRespuestaPreguntaBpmclasificacion
	@OneToMany(mappedBy="calidadBpmClasificacion")
	private List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions;

	public CalidadBpmClasificacion() {
	}

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

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

	public List<CalidadRespuestaPreguntaBpmclasificacion> getCalidadRespuestaPreguntaBpmclasificacions() {
		return this.calidadRespuestaPreguntaBpmclasificacions;
	}

	public void setCalidadRespuestaPreguntaBpmclasificacions(List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions) {
		this.calidadRespuestaPreguntaBpmclasificacions = calidadRespuestaPreguntaBpmclasificacions;
	}

}