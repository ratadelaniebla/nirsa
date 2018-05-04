package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the reportes_nivel_aprobacion database table.
 * 
 */
@Entity
@Table(name="reportes_nivel_aprobacion")
@NamedQuery(name="ReportesNivelAprobacion.findAll", query="SELECT r FROM ReportesNivelAprobacion r")
public class ReportesNivelAprobacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idreportesnivelaprobacion;
	private Integer estado;
	private Timestamp fechareg;
	private ReportesNivelesUsuario reportesNivelesUsuario;
	private ReportesPuntoControl reportesPuntoControl;

	public ReportesNivelAprobacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdreportesnivelaprobacion() {
		return this.idreportesnivelaprobacion;
	}

	public void setIdreportesnivelaprobacion(Long idreportesnivelaprobacion) {
		this.idreportesnivelaprobacion = idreportesnivelaprobacion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to ReportesNivelesUsuario
	@ManyToOne
	@JoinColumn(name="idreportesnivelesusuario")
	public ReportesNivelesUsuario getReportesNivelesUsuario() {
		return this.reportesNivelesUsuario;
	}

	public void setReportesNivelesUsuario(ReportesNivelesUsuario reportesNivelesUsuario) {
		this.reportesNivelesUsuario = reportesNivelesUsuario;
	}


	//bi-directional many-to-one association to ReportesPuntoControl
	@ManyToOne
	@JoinColumn(name="idreportespuntocontrol")
	public ReportesPuntoControl getReportesPuntoControl() {
		return this.reportesPuntoControl;
	}

	public void setReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		this.reportesPuntoControl = reportesPuntoControl;
	}

}