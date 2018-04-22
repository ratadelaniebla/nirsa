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
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idreporte;

	private String codigoreporte;

	private String descripcion;

	private String nombrereporte;

	//bi-directional many-to-one association to Division
	@ManyToOne
	@JoinColumn(name="iddivision")
	private Division division;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	//bi-directional many-to-one association to ReportesNivelesUsuario
	@OneToMany(mappedBy="reporte")
	private List<ReportesNivelesUsuario> reportesNivelesUsuarios;

	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="reporte")
	private List<ReportesPuntoControl> reportesPuntoControls;

	public Reporte() {
	}

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

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public List<ReportesNivelesUsuario> getReportesNivelesUsuarios() {
		return this.reportesNivelesUsuarios;
	}

	public void setReportesNivelesUsuarios(List<ReportesNivelesUsuario> reportesNivelesUsuarios) {
		this.reportesNivelesUsuarios = reportesNivelesUsuarios;
	}

	public List<ReportesPuntoControl> getReportesPuntoControls() {
		return this.reportesPuntoControls;
	}

	public void setReportesPuntoControls(List<ReportesPuntoControl> reportesPuntoControls) {
		this.reportesPuntoControls = reportesPuntoControls;
	}

}