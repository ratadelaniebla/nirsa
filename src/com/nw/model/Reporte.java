package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reportes database table.
 * 
 */
@Entity
@Table(name="reportes")
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idreporte;
	private String codigoreporte;
	private String descripcion;
	private String nombrereporte;
	private Division division;
	private Proceso proceso;
	private List<ReportesNivelesUsuario> reportesNivelesUsuarios;
	private List<ReportesPuntoControl> reportesPuntoControls;

	public Reporte() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdreporte() {
		return this.idreporte;
	}

	public void setIdreporte(Integer idreporte) {
		this.idreporte = idreporte;
	}


	public String getCodigoreporte() {
		return this.codigoreporte;
	}

	public void setCodigoreporte(String codigoreporte) {
		this.codigoreporte = codigoreporte;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombrereporte() {
		return this.nombrereporte;
	}

	public void setNombrereporte(String nombrereporte) {
		this.nombrereporte = nombrereporte;
	}


	//bi-directional many-to-one association to Division
	@ManyToOne
	@JoinColumn(name="iddivision")
	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}


	//bi-directional many-to-one association to ReportesNivelesUsuario
	@OneToMany(mappedBy="reporte")
	public List<ReportesNivelesUsuario> getReportesNivelesUsuarios() {
		return this.reportesNivelesUsuarios;
	}

	public void setReportesNivelesUsuarios(List<ReportesNivelesUsuario> reportesNivelesUsuarios) {
		this.reportesNivelesUsuarios = reportesNivelesUsuarios;
	}

	public ReportesNivelesUsuario addReportesNivelesUsuario(ReportesNivelesUsuario reportesNivelesUsuario) {
		getReportesNivelesUsuarios().add(reportesNivelesUsuario);
		reportesNivelesUsuario.setReporte(this);

		return reportesNivelesUsuario;
	}

	public ReportesNivelesUsuario removeReportesNivelesUsuario(ReportesNivelesUsuario reportesNivelesUsuario) {
		getReportesNivelesUsuarios().remove(reportesNivelesUsuario);
		reportesNivelesUsuario.setReporte(null);

		return reportesNivelesUsuario;
	}


	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="reporte")
	public List<ReportesPuntoControl> getReportesPuntoControls() {
		return this.reportesPuntoControls;
	}

	public void setReportesPuntoControls(List<ReportesPuntoControl> reportesPuntoControls) {
		this.reportesPuntoControls = reportesPuntoControls;
	}

	public ReportesPuntoControl addReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		getReportesPuntoControls().add(reportesPuntoControl);
		reportesPuntoControl.setReporte(this);

		return reportesPuntoControl;
	}

	public ReportesPuntoControl removeReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		getReportesPuntoControls().remove(reportesPuntoControl);
		reportesPuntoControl.setReporte(null);

		return reportesPuntoControl;
	}

}