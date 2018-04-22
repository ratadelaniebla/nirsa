package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pcc_parametros database table.
 * 
 */
@Entity
@Table(name="pcc_parametros")
public class PccParametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpccparametros;

	private String descripcion;

	@Column(name="hora_anticipacion")
	private Integer horaAnticipacion;

	@Column(name="hora_final")
	private Integer horaFinal;

	@Column(name="minuto_anticipacion")
	private Integer minutoAnticipacion;

	@Column(name="minuto_final")
	private Integer minutoFinal;

	private double temperatura;

	//bi-directional many-to-one association to CorreosPccParametro
	@OneToMany(mappedBy="pccParametro")
	private List<CorreosPccParametro> correosPccParametros;

	public PccParametro() {
	}

	public Integer getIdpccparametros() {
		return this.idpccparametros;
	}

	public void setIdpccparametros(Integer idpccparametros) {
		this.idpccparametros = idpccparametros;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getHoraAnticipacion() {
		return this.horaAnticipacion;
	}

	public void setHoraAnticipacion(Integer horaAnticipacion) {
		this.horaAnticipacion = horaAnticipacion;
	}

	public Integer getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(Integer horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Integer getMinutoAnticipacion() {
		return this.minutoAnticipacion;
	}

	public void setMinutoAnticipacion(Integer minutoAnticipacion) {
		this.minutoAnticipacion = minutoAnticipacion;
	}

	public Integer getMinutoFinal() {
		return this.minutoFinal;
	}

	public void setMinutoFinal(Integer minutoFinal) {
		this.minutoFinal = minutoFinal;
	}

	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public List<CorreosPccParametro> getCorreosPccParametros() {
		return this.correosPccParametros;
	}

	public void setCorreosPccParametros(List<CorreosPccParametro> correosPccParametros) {
		this.correosPccParametros = correosPccParametros;
	}

}