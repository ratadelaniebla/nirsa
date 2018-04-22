package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_muestreo_temp_coches_eviscerado database table.
 * 
 */
@Entity
@Table(name="calidad_muestreo_temp_coches_eviscerado")
public class CalidadMuestreoTempCochesEviscerado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestreotempcocheseviscerado;

	private Timestamp fechareg;

	private String observacion;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="calidadMuestreoTempCochesEviscerado")
	private List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados;

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

	public CalidadMuestreoTempCochesEviscerado() {
	}

	public Long getIdcalidadmuestreotempcocheseviscerado() {
		return this.idcalidadmuestreotempcocheseviscerado;
	}

	public void setIdcalidadmuestreotempcocheseviscerado(Long idcalidadmuestreotempcocheseviscerado) {
		this.idcalidadmuestreotempcocheseviscerado = idcalidadmuestreotempcocheseviscerado;
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

	public List<CalidadDetalleMuestreoTempCochesEviscerado> getCalidadDetalleMuestreoTempCochesEviscerados() {
		return this.calidadDetalleMuestreoTempCochesEviscerados;
	}

	public void setCalidadDetalleMuestreoTempCochesEviscerados(List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados) {
		this.calidadDetalleMuestreoTempCochesEviscerados = calidadDetalleMuestreoTempCochesEviscerados;
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