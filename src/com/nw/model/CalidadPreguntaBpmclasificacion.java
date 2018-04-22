package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_pregunta_bpmclasificacion database table.
 * 
 */
@Entity
@Table(name="calidad_pregunta_bpmclasificacion")
public class CalidadPreguntaBpmclasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpreguntabpmclasificacion;

	private String pregunta;

	//bi-directional many-to-one association to CalidadGrupoBpmclasificacion
	@ManyToOne
	@JoinColumn(name="idgrupobpmclasificacion")
	private CalidadGrupoBpmclasificacion calidadGrupoBpmclasificacion;

	//bi-directional many-to-one association to CalidadRespuestaPreguntaBpmclasificacion
	@OneToMany(mappedBy="calidadPreguntaBpmclasificacion")
	private List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions;

	public CalidadPreguntaBpmclasificacion() {
	}

	public Integer getIdpreguntabpmclasificacion() {
		return this.idpreguntabpmclasificacion;
	}

	public void setIdpreguntabpmclasificacion(Integer idpreguntabpmclasificacion) {
		this.idpreguntabpmclasificacion = idpreguntabpmclasificacion;
	}

	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public CalidadGrupoBpmclasificacion getCalidadGrupoBpmclasificacion() {
		return this.calidadGrupoBpmclasificacion;
	}

	public void setCalidadGrupoBpmclasificacion(CalidadGrupoBpmclasificacion calidadGrupoBpmclasificacion) {
		this.calidadGrupoBpmclasificacion = calidadGrupoBpmclasificacion;
	}

	public List<CalidadRespuestaPreguntaBpmclasificacion> getCalidadRespuestaPreguntaBpmclasificacions() {
		return this.calidadRespuestaPreguntaBpmclasificacions;
	}

	public void setCalidadRespuestaPreguntaBpmclasificacions(List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions) {
		this.calidadRespuestaPreguntaBpmclasificacions = calidadRespuestaPreguntaBpmclasificacions;
	}

}