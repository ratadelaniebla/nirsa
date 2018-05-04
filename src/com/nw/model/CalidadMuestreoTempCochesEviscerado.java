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
@NamedQuery(name="CalidadMuestreoTempCochesEviscerado.findAll", query="SELECT c FROM CalidadMuestreoTempCochesEviscerado c")
public class CalidadMuestreoTempCochesEviscerado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestreotempcocheseviscerado;
	private Timestamp fechareg;
	private String observacion;
	private List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados;
	private EvisceradoProceso evisceradoProceso;
	private Turno turno;
	private Usuario usuario;

	public CalidadMuestreoTempCochesEviscerado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="calidadMuestreoTempCochesEviscerado")
	public List<CalidadDetalleMuestreoTempCochesEviscerado> getCalidadDetalleMuestreoTempCochesEviscerados() {
		return this.calidadDetalleMuestreoTempCochesEviscerados;
	}

	public void setCalidadDetalleMuestreoTempCochesEviscerados(List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados) {
		this.calidadDetalleMuestreoTempCochesEviscerados = calidadDetalleMuestreoTempCochesEviscerados;
	}

	public CalidadDetalleMuestreoTempCochesEviscerado addCalidadDetalleMuestreoTempCochesEviscerado(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCochesEviscerado) {
		getCalidadDetalleMuestreoTempCochesEviscerados().add(calidadDetalleMuestreoTempCochesEviscerado);
		calidadDetalleMuestreoTempCochesEviscerado.setCalidadMuestreoTempCochesEviscerado(this);

		return calidadDetalleMuestreoTempCochesEviscerado;
	}

	public CalidadDetalleMuestreoTempCochesEviscerado removeCalidadDetalleMuestreoTempCochesEviscerado(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCochesEviscerado) {
		getCalidadDetalleMuestreoTempCochesEviscerados().remove(calidadDetalleMuestreoTempCochesEviscerado);
		calidadDetalleMuestreoTempCochesEviscerado.setCalidadMuestreoTempCochesEviscerado(null);

		return calidadDetalleMuestreoTempCochesEviscerado;
	}


	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
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
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}