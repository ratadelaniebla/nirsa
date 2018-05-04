package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_grupo_bpmdesembarco database table.
 * 
 */
@Entity
@Table(name="calidad_grupo_bpmdesembarco")
@NamedQuery(name="CalidadGrupoBpmdesembarco.findAll", query="SELECT c FROM CalidadGrupoBpmdesembarco c")
public class CalidadGrupoBpmdesembarco implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idgrupobpmdesembarco;
	private String nombre;
	private List<CalidadPreguntaBpmdesembarco> calidadPreguntaBpmdesembarcos;

	public CalidadGrupoBpmdesembarco() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdgrupobpmdesembarco() {
		return this.idgrupobpmdesembarco;
	}

	public void setIdgrupobpmdesembarco(Integer idgrupobpmdesembarco) {
		this.idgrupobpmdesembarco = idgrupobpmdesembarco;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to CalidadPreguntaBpmdesembarco
	@OneToMany(mappedBy="calidadGrupoBpmdesembarco")
	public List<CalidadPreguntaBpmdesembarco> getCalidadPreguntaBpmdesembarcos() {
		return this.calidadPreguntaBpmdesembarcos;
	}

	public void setCalidadPreguntaBpmdesembarcos(List<CalidadPreguntaBpmdesembarco> calidadPreguntaBpmdesembarcos) {
		this.calidadPreguntaBpmdesembarcos = calidadPreguntaBpmdesembarcos;
	}

	public CalidadPreguntaBpmdesembarco addCalidadPreguntaBpmdesembarco(CalidadPreguntaBpmdesembarco calidadPreguntaBpmdesembarco) {
		getCalidadPreguntaBpmdesembarcos().add(calidadPreguntaBpmdesembarco);
		calidadPreguntaBpmdesembarco.setCalidadGrupoBpmdesembarco(this);

		return calidadPreguntaBpmdesembarco;
	}

	public CalidadPreguntaBpmdesembarco removeCalidadPreguntaBpmdesembarco(CalidadPreguntaBpmdesembarco calidadPreguntaBpmdesembarco) {
		getCalidadPreguntaBpmdesembarcos().remove(calidadPreguntaBpmdesembarco);
		calidadPreguntaBpmdesembarco.setCalidadGrupoBpmdesembarco(null);

		return calidadPreguntaBpmdesembarco;
	}

}