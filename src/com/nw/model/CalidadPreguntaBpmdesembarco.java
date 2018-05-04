package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calidad_pregunta_bpmdesembarco database table.
 * 
 */
@Entity
@Table(name="calidad_pregunta_bpmdesembarco")
@NamedQuery(name="CalidadPreguntaBpmdesembarco.findAll", query="SELECT c FROM CalidadPreguntaBpmdesembarco c")
public class CalidadPreguntaBpmdesembarco implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idpreguntabpmdesembarco;
	private String pregunta;
	private CalidadGrupoBpmdesembarco calidadGrupoBpmdesembarco;

	public CalidadPreguntaBpmdesembarco() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdpreguntabpmdesembarco() {
		return this.idpreguntabpmdesembarco;
	}

	public void setIdpreguntabpmdesembarco(Integer idpreguntabpmdesembarco) {
		this.idpreguntabpmdesembarco = idpreguntabpmdesembarco;
	}


	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}


	//bi-directional many-to-one association to CalidadGrupoBpmdesembarco
	@ManyToOne
	@JoinColumn(name="idgrupobpmdesembarco")
	public CalidadGrupoBpmdesembarco getCalidadGrupoBpmdesembarco() {
		return this.calidadGrupoBpmdesembarco;
	}

	public void setCalidadGrupoBpmdesembarco(CalidadGrupoBpmdesembarco calidadGrupoBpmdesembarco) {
		this.calidadGrupoBpmdesembarco = calidadGrupoBpmdesembarco;
	}

}