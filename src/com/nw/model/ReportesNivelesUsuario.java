package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reportes_niveles_usuario database table.
 * 
 */
@Entity
@Table(name="reportes_niveles_usuario")
public class ReportesNivelesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idreportesnivelesusuario;

	private Integer activo;

	private String cargoreporte;

	private Integer nivel;

	//bi-directional many-to-one association to ReportesNivelAprobacion
	@OneToMany(mappedBy="reportesNivelesUsuario")
	private List<ReportesNivelAprobacion> reportesNivelAprobacions;

	//bi-directional many-to-one association to Reporte
	@ManyToOne
	@JoinColumn(name="idreportes")
	private Reporte reporte;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public ReportesNivelesUsuario() {
	}

	public Integer getIdreportesnivelesusuario() {
		return this.idreportesnivelesusuario;
	}

	public void setIdreportesnivelesusuario(Integer idreportesnivelesusuario) {
		this.idreportesnivelesusuario = idreportesnivelesusuario;
	}

	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getCargoreporte() {
		return this.cargoreporte;
	}

	public void setCargoreporte(String cargoreporte) {
		this.cargoreporte = cargoreporte;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public List<ReportesNivelAprobacion> getReportesNivelAprobacions() {
		return this.reportesNivelAprobacions;
	}

	public void setReportesNivelAprobacions(List<ReportesNivelAprobacion> reportesNivelAprobacions) {
		this.reportesNivelAprobacions = reportesNivelAprobacions;
	}

	public Reporte getReporte() {
		return this.reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}