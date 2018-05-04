package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_evaluadores_sensoriales database table.
 * 
 */
@Entity
@Table(name="calidad_evaluadores_sensoriales")
@NamedQuery(name="CalidadEvaluadoresSensoriale.findAll", query="SELECT c FROM CalidadEvaluadoresSensoriale c")
public class CalidadEvaluadoresSensoriale implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevaluador;
	private String cargo;
	private Integer estado;
	private String firmaDigital;
	private String idusuario;
	private String nombres;
	private List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras;

	public CalidadEvaluadoresSensoriale() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdevaluador() {
		return this.idevaluador;
	}

	public void setIdevaluador(Integer idevaluador) {
		this.idevaluador = idevaluador;
	}


	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	@Column(name="firma_digital")
	public String getFirmaDigital() {
		return this.firmaDigital;
	}

	public void setFirmaDigital(String firmaDigital) {
		this.firmaDigital = firmaDigital;
	}


	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}


	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaDetalleMuestra
	@OneToMany(mappedBy="calidadEvaluadoresSensoriale")
	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraAreaDetalleMuestras() {
		return this.calidadMuestraAreaDetalleMuestras;
	}

	public void setCalidadMuestraAreaDetalleMuestras(List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras) {
		this.calidadMuestraAreaDetalleMuestras = calidadMuestraAreaDetalleMuestras;
	}

	public CalidadMuestraAreaDetalleMuestra addCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().add(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setCalidadEvaluadoresSensoriale(this);

		return calidadMuestraAreaDetalleMuestra;
	}

	public CalidadMuestraAreaDetalleMuestra removeCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().remove(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setCalidadEvaluadoresSensoriale(null);

		return calidadMuestraAreaDetalleMuestra;
	}

}