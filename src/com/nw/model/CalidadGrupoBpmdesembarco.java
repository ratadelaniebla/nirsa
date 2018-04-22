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
public class CalidadGrupoBpmdesembarco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idgrupobpmdesembarco;

	private String nombre;

	//bi-directional many-to-one association to CalidadPreguntaBpmdesembarco
	@OneToMany(mappedBy="calidadGrupoBpmdesembarco")
	private List<CalidadPreguntaBpmdesembarco> calidadPreguntaBpmdesembarcos;

	public CalidadGrupoBpmdesembarco() {
	}

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

	public List<CalidadPreguntaBpmdesembarco> getCalidadPreguntaBpmdesembarcos() {
		return this.calidadPreguntaBpmdesembarcos;
	}

	public void setCalidadPreguntaBpmdesembarcos(List<CalidadPreguntaBpmdesembarco> calidadPreguntaBpmdesembarcos) {
		this.calidadPreguntaBpmdesembarcos = calidadPreguntaBpmdesembarcos;
	}

}