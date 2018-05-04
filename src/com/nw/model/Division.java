package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the division database table.
 * 
 */
@Entity
@NamedQuery(name="Division.findAll", query="SELECT d FROM Division d")
public class Division implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer iddivision;
	private String abreviacion;
	private String descripcion;
	private List<ObservacionesDetalleProceso> observacionesDetalleProcesos;
	private List<ObservacionesPuntoControl> observacionesPuntoControls;
	private List<Reporte> reportes;

	public Division() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to ObservacionesDetalleProceso
	@OneToMany(mappedBy="division")
	public List<ObservacionesDetalleProceso> getObservacionesDetalleProcesos() {
		return this.observacionesDetalleProcesos;
	}

	public void setObservacionesDetalleProcesos(List<ObservacionesDetalleProceso> observacionesDetalleProcesos) {
		this.observacionesDetalleProcesos = observacionesDetalleProcesos;
	}

	public ObservacionesDetalleProceso addObservacionesDetalleProceso(ObservacionesDetalleProceso observacionesDetalleProceso) {
		getObservacionesDetalleProcesos().add(observacionesDetalleProceso);
		observacionesDetalleProceso.setDivision(this);

		return observacionesDetalleProceso;
	}

	public ObservacionesDetalleProceso removeObservacionesDetalleProceso(ObservacionesDetalleProceso observacionesDetalleProceso) {
		getObservacionesDetalleProcesos().remove(observacionesDetalleProceso);
		observacionesDetalleProceso.setDivision(null);

		return observacionesDetalleProceso;
	}


	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="division")
	public List<ObservacionesPuntoControl> getObservacionesPuntoControls() {
		return this.observacionesPuntoControls;
	}

	public void setObservacionesPuntoControls(List<ObservacionesPuntoControl> observacionesPuntoControls) {
		this.observacionesPuntoControls = observacionesPuntoControls;
	}

	public ObservacionesPuntoControl addObservacionesPuntoControl(ObservacionesPuntoControl observacionesPuntoControl) {
		getObservacionesPuntoControls().add(observacionesPuntoControl);
		observacionesPuntoControl.setDivision(this);

		return observacionesPuntoControl;
	}

	public ObservacionesPuntoControl removeObservacionesPuntoControl(ObservacionesPuntoControl observacionesPuntoControl) {
		getObservacionesPuntoControls().remove(observacionesPuntoControl);
		observacionesPuntoControl.setDivision(null);

		return observacionesPuntoControl;
	}


	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="division")
	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setDivision(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setDivision(null);

		return reporte;
	}

}