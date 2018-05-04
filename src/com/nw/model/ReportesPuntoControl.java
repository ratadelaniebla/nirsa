package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the reportes_punto_control database table.
 * 
 */
@Entity
@Table(name="reportes_punto_control")
@NamedQuery(name="ReportesPuntoControl.findAll", query="SELECT r FROM ReportesPuntoControl r")
public class ReportesPuntoControl implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idreportepuntocontrol;
	private Integer aprobado1;
	private Integer aprobado2;
	private Timestamp fechaaprobado1;
	private Timestamp fechaaprobado2;
	private Integer secuenciareporte;
	private List<ReportesNivelAprobacion> reportesNivelAprobacions;
	private BarcoDescarga barcoDescarga;
	private Produccion produccion;
	private Reporte reporte;
	private Turno turno;
	private Usuario usuario1;
	private Usuario usuario2;

	public ReportesPuntoControl() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdreportepuntocontrol() {
		return this.idreportepuntocontrol;
	}

	public void setIdreportepuntocontrol(Long idreportepuntocontrol) {
		this.idreportepuntocontrol = idreportepuntocontrol;
	}


	public Integer getAprobado1() {
		return this.aprobado1;
	}

	public void setAprobado1(Integer aprobado1) {
		this.aprobado1 = aprobado1;
	}


	public Integer getAprobado2() {
		return this.aprobado2;
	}

	public void setAprobado2(Integer aprobado2) {
		this.aprobado2 = aprobado2;
	}


	public Timestamp getFechaaprobado1() {
		return this.fechaaprobado1;
	}

	public void setFechaaprobado1(Timestamp fechaaprobado1) {
		this.fechaaprobado1 = fechaaprobado1;
	}


	public Timestamp getFechaaprobado2() {
		return this.fechaaprobado2;
	}

	public void setFechaaprobado2(Timestamp fechaaprobado2) {
		this.fechaaprobado2 = fechaaprobado2;
	}


	public Integer getSecuenciareporte() {
		return this.secuenciareporte;
	}

	public void setSecuenciareporte(Integer secuenciareporte) {
		this.secuenciareporte = secuenciareporte;
	}


	//bi-directional many-to-one association to ReportesNivelAprobacion
	@OneToMany(mappedBy="reportesPuntoControl")
	public List<ReportesNivelAprobacion> getReportesNivelAprobacions() {
		return this.reportesNivelAprobacions;
	}

	public void setReportesNivelAprobacions(List<ReportesNivelAprobacion> reportesNivelAprobacions) {
		this.reportesNivelAprobacions = reportesNivelAprobacions;
	}

	public ReportesNivelAprobacion addReportesNivelAprobacion(ReportesNivelAprobacion reportesNivelAprobacion) {
		getReportesNivelAprobacions().add(reportesNivelAprobacion);
		reportesNivelAprobacion.setReportesPuntoControl(this);

		return reportesNivelAprobacion;
	}

	public ReportesNivelAprobacion removeReportesNivelAprobacion(ReportesNivelAprobacion reportesNivelAprobacion) {
		getReportesNivelAprobacions().remove(reportesNivelAprobacion);
		reportesNivelAprobacion.setReportesPuntoControl(null);

		return reportesNivelAprobacion;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}


	//bi-directional many-to-one association to Reporte
	@ManyToOne
	@JoinColumn(name="idreporte")
	public Reporte getReporte() {
		return this.reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario1")
	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario2")
	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}