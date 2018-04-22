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
public class CalidadPcc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadpcc;

	private String accion;

	private String desviacion;

	private Integer estado;

	private Integer turno;

	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="calidadPcc")
	private List<CalidadDetallePcc> calidadDetallePccs;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	public CalidadPcc() {
	}

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

	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

}