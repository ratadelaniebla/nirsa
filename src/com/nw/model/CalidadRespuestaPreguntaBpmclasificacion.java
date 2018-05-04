package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_respuesta_pregunta_bpmclasificacion database table.
 * 
 */
@Entity
@Table(name="calidad_respuesta_pregunta_bpmclasificacion")
@NamedQuery(name="CalidadRespuestaPreguntaBpmclasificacion.findAll", query="SELECT c FROM CalidadRespuestaPreguntaBpmclasificacion c")
public class CalidadRespuestaPreguntaBpmclasificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadresppregbpmclasificacion;
	private Integer cumplimiento;
	private Timestamp fechareg;
	private String observaciones;
	private CalidadBpmClasificacion calidadBpmClasificacion;
	private CalidadPreguntaBpmclasificacion calidadPreguntaBpmclasificacion;
	private Usuario usuario;

	public CalidadRespuestaPreguntaBpmclasificacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadresppregbpmclasificacion() {
		return this.idcalidadresppregbpmclasificacion;
	}

	public void setIdcalidadresppregbpmclasificacion(Long idcalidadresppregbpmclasificacion) {
		this.idcalidadresppregbpmclasificacion = idcalidadresppregbpmclasificacion;
	}


	public Integer getCumplimiento() {
		return this.cumplimiento;
	}

	public void setCumplimiento(Integer cumplimiento) {
		this.cumplimiento = cumplimiento;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	//bi-directional many-to-one association to CalidadBpmClasificacion
	@ManyToOne
	@JoinColumn(name="idcalidadbpmclasificacion")
	public CalidadBpmClasificacion getCalidadBpmClasificacion() {
		return this.calidadBpmClasificacion;
	}

	public void setCalidadBpmClasificacion(CalidadBpmClasificacion calidadBpmClasificacion) {
		this.calidadBpmClasificacion = calidadBpmClasificacion;
	}


	//bi-directional many-to-one association to CalidadPreguntaBpmclasificacion
	@ManyToOne
	@JoinColumn(name="idpreguntacalidadbpmclasificacion")
	public CalidadPreguntaBpmclasificacion getCalidadPreguntaBpmclasificacion() {
		return this.calidadPreguntaBpmclasificacion;
	}

	public void setCalidadPreguntaBpmclasificacion(CalidadPreguntaBpmclasificacion calidadPreguntaBpmclasificacion) {
		this.calidadPreguntaBpmclasificacion = calidadPreguntaBpmclasificacion;
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

}