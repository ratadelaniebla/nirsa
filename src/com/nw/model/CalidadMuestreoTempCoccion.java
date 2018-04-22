package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_muestreo_temp_coccion database table.
 * 
 */
@Entity
@Table(name="calidad_muestreo_temp_coccion")
public class CalidadMuestreoTempCoccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestreotempcoccion;

	private Timestamp fechareg;

	private String observacion;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCoccion
	@OneToMany(mappedBy="calidadMuestreoTempCoccion")
	private List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions;

	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	private EvisceradoProceso evisceradoProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadMuestreoTempCoccion() {
	}

	public Long getIdcalidadmuestreotempcoccion() {
		return this.idcalidadmuestreotempcoccion;
	}

	public void setIdcalidadmuestreotempcoccion(Long idcalidadmuestreotempcoccion) {
		this.idcalidadmuestreotempcoccion = idcalidadmuestreotempcoccion;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<CalidadDetalleMuestreoTempCoccion> getCalidadDetalleMuestreoTempCoccions() {
		return this.calidadDetalleMuestreoTempCoccions;
	}

	public void setCalidadDetalleMuestreoTempCoccions(List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions) {
		this.calidadDetalleMuestreoTempCoccions = calidadDetalleMuestreoTempCoccions;
	}

	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}