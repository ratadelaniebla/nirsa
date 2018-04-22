package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the division database table.
 * 
 */
@Entity
public class Division implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iddivision;

	private String abreviacion;

	private String descripcion;

	//bi-directional many-to-one association to ObservacionesDetalleProceso
	@OneToMany(mappedBy="division")
	private List<ObservacionesDetalleProceso> observacionesDetalleProcesos;

	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="division")
	private List<ObservacionesPuntoControl> observacionesPuntoControls;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="division")
	private List<Reporte> reportes;

	public Division() {
	}

	public Integer getIddivision() {
		return this.iddivision;
	}

	public void setIddivision(Integer iddivision) {
		this.iddivision = iddivision;
	}

	public String getAbreviacion() {
		return this.abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ObservacionesDetalleProceso> getObservacionesDetalleProcesos() {
		return this.observacionesDetalleProcesos;
	}

	public void setObservacionesDetalleProcesos(List<ObservacionesDetalleProceso> observacionesDetalleProcesos) {
		this.observacionesDetalleProcesos = observacionesDetalleProcesos;
	}

	public List<ObservacionesPuntoControl> getObservacionesPuntoControls() {
		return this.observacionesPuntoControls;
	}

	public void setObservacionesPuntoControls(List<ObservacionesPuntoControl> observacionesPuntoControls) {
		this.observacionesPuntoControls = observacionesPuntoControls;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

}