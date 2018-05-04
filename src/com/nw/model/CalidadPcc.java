package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_pcc database table.
 * 
 */
@Entity
@Table(name="calidad_pcc")
@NamedQuery(name="CalidadPcc.findAll", query="SELECT c FROM CalidadPcc c")
public class CalidadPcc implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadpcc;
	private String accion;
	private String desviacion;
	private Integer estado;
	private Integer turno;
	private List<CalidadDetallePcc> calidadDetallePccs;
	private BarcoDescarga barcoDescarga;

	public CalidadPcc() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadpcc() {
		return this.idcalidadpcc;
	}

	public void setIdcalidadpcc(Long idcalidadpcc) {
		this.idcalidadpcc = idcalidadpcc;
	}


	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}


	public String getDesviacion() {
		return this.desviacion;
	}

	public void setDesviacion(String desviacion) {
		this.desviacion = desviacion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Integer getTurno() {
		return this.turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}


	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="calidadPcc")
	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public CalidadDetallePcc addCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().add(calidadDetallePcc);
		calidadDetallePcc.setCalidadPcc(this);

		return calidadDetallePcc;
	}

	public CalidadDetallePcc removeCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().remove(calidadDetallePcc);
		calidadDetallePcc.setCalidadPcc(null);

		return calidadDetallePcc;
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

}