package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_accion_correctiva_texto database table.
 * 
 */
@Entity
@Table(name="calidad_accion_correctiva_texto")
public class CalidadAccionCorrectivaTexto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadaccioncorrectivatexto;

	private String descripcion;

	//bi-directional many-to-one association to CalidadVariable
	@OneToMany(mappedBy="calidadAccionCorrectivaTexto")
	private List<CalidadVariable> calidadVariables;

	public CalidadAccionCorrectivaTexto() {
	}

	public Long getIdcalidadaccioncorrectivatexto() {
		return this.idcalidadaccioncorrectivatexto;
	}

	public void setIdcalidadaccioncorrectivatexto(Long idcalidadaccioncorrectivatexto) {
		this.idcalidadaccioncorrectivatexto = idcalidadaccioncorrectivatexto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CalidadVariable> getCalidadVariables() {
		return this.calidadVariables;
	}

	public void setCalidadVariables(List<CalidadVariable> calidadVariables) {
		this.calidadVariables = calidadVariables;
	}

}