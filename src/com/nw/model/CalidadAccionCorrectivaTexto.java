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
@NamedQuery(name="CalidadAccionCorrectivaTexto.findAll", query="SELECT c FROM CalidadAccionCorrectivaTexto c")
public class CalidadAccionCorrectivaTexto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadaccioncorrectivatexto;
	private String descripcion;
	private List<CalidadVariable> calidadVariables;

	public CalidadAccionCorrectivaTexto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadVariable
	@OneToMany(mappedBy="calidadAccionCorrectivaTexto")
	public List<CalidadVariable> getCalidadVariables() {
		return this.calidadVariables;
	}

	public void setCalidadVariables(List<CalidadVariable> calidadVariables) {
		this.calidadVariables = calidadVariables;
	}

	public CalidadVariable addCalidadVariable(CalidadVariable calidadVariable) {
		getCalidadVariables().add(calidadVariable);
		calidadVariable.setCalidadAccionCorrectivaTexto(this);

		return calidadVariable;
	}

	public CalidadVariable removeCalidadVariable(CalidadVariable calidadVariable) {
		getCalidadVariables().remove(calidadVariable);
		calidadVariable.setCalidadAccionCorrectivaTexto(null);

		return calidadVariable;
	}

}