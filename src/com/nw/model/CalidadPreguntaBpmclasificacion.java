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
@NamedQuery(name="CalidadPreguntaBpmclasificacion.findAll", query="SELECT c FROM CalidadPreguntaBpmclasificacion c")
public class CalidadPreguntaBpmclasificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idpreguntabpmclasificacion;
	private String pregunta;
	private CalidadGrupoBpmclasificacion calidadGrupoBpmclasificacion;
	private List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions;

	public CalidadPreguntaBpmclasificacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadGrupoBpmclasificacion
	@ManyToOne
	@JoinColumn(name="idgrupobpmclasificacion")
	public CalidadGrupoBpmclasificacion getCalidadGrupoBpmclasificacion() {
		return this.calidadGrupoBpmclasificacion;
	}

	public void setCalidadGrupoBpmclasificacion(CalidadGrupoBpmclasificacion calidadGrupoBpmclasificacion) {
		this.calidadGrupoBpmclasificacion = calidadGrupoBpmclasificacion;
	}


	//bi-directional many-to-one association to CalidadRespuestaPreguntaBpmclasificacion
	@OneToMany(mappedBy="calidadPreguntaBpmclasificacion")
	public List<CalidadRespuestaPreguntaBpmclasificacion> getCalidadRespuestaPreguntaBpmclasificacions() {
		return this.calidadRespuestaPreguntaBpmclasificacions;
	}

	public void setCalidadRespuestaPreguntaBpmclasificacions(List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions) {
		this.calidadRespuestaPreguntaBpmclasificacions = calidadRespuestaPreguntaBpmclasificacions;
	}

	public CalidadRespuestaPreguntaBpmclasificacion addCalidadRespuestaPreguntaBpmclasificacion(CalidadRespuestaPreguntaBpmclasificacion calidadRespuestaPreguntaBpmclasificacion) {
		getCalidadRespuestaPreguntaBpmclasificacions().add(calidadRespuestaPreguntaBpmclasificacion);
		calidadRespuestaPreguntaBpmclasificacion.setCalidadPreguntaBpmclasificacion(this);

		return calidadRespuestaPreguntaBpmclasificacion;
	}

	public CalidadRespuestaPreguntaBpmclasificacion removeCalidadRespuestaPreguntaBpmclasificacion(CalidadRespuestaPreguntaBpmclasificacion calidadRespuestaPreguntaBpmclasificacion) {
		getCalidadRespuestaPreguntaBpmclasificacions().remove(calidadRespuestaPreguntaBpmclasificacion);
		calidadRespuestaPreguntaBpmclasificacion.setCalidadPreguntaBpmclasificacion(null);

		return calidadRespuestaPreguntaBpmclasificacion;
	}

}