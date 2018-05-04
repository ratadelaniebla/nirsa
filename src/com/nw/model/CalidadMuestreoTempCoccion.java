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
@NamedQuery(name="CalidadMuestreoTempCoccion.findAll", query="SELECT c FROM CalidadMuestreoTempCoccion c")
public class CalidadMuestreoTempCoccion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestreotempcoccion;
	private Timestamp fechareg;
	private String observacion;
	private List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions;
	private EvisceradoProceso evisceradoProceso;
	private Turno turno;
	private Usuario usuario;

	public CalidadMuestreoTempCoccion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCoccion
	@OneToMany(mappedBy="calidadMuestreoTempCoccion")
	public List<CalidadDetalleMuestreoTempCoccion> getCalidadDetalleMuestreoTempCoccions() {
		return this.calidadDetalleMuestreoTempCoccions;
	}

	public void setCalidadDetalleMuestreoTempCoccions(List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions) {
		this.calidadDetalleMuestreoTempCoccions = calidadDetalleMuestreoTempCoccions;
	}

	public CalidadDetalleMuestreoTempCoccion addCalidadDetalleMuestreoTempCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion) {
		getCalidadDetalleMuestreoTempCoccions().add(calidadDetalleMuestreoTempCoccion);
		calidadDetalleMuestreoTempCoccion.setCalidadMuestreoTempCoccion(this);

		return calidadDetalleMuestreoTempCoccion;
	}

	public CalidadDetalleMuestreoTempCoccion removeCalidadDetalleMuestreoTempCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion) {
		getCalidadDetalleMuestreoTempCoccions().remove(calidadDetalleMuestreoTempCoccion);
		calidadDetalleMuestreoTempCoccion.setCalidadMuestreoTempCoccion(null);

		return calidadDetalleMuestreoTempCoccion;
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