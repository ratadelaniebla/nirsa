package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_nivel_cuba database table.
 * 
 */
@Entity
@Table(name="calidad_nivel_cuba")
public class CalidadNivelCuba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcalidadnivelcuba;

	private String descripcion;

	private String nivel;

	//bi-directional many-to-one association to CalidadDetalleSensorialMp
	@OneToMany(mappedBy="calidadNivelCuba")
	private List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps;

	public CalidadNivelCuba() {
	}

	public Integer getIdcalidadnivelcuba() {
		return this.idcalidadnivelcuba;
	}

	public void setIdcalidadnivelcuba(Integer idcalidadnivelcuba) {
		this.idcalidadnivelcuba = idcalidadnivelcuba;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<CalidadDetalleSensorialMp> getCalidadDetalleSensorialMps() {
		return this.calidadDetalleSensorialMps;
	}

	public void setCalidadDetalleSensorialMps(List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps) {
		this.calidadDetalleSensorialMps = calidadDetalleSensorialMps;
	}

}