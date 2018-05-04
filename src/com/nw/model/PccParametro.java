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
@NamedQuery(name="PccParametro.findAll", query="SELECT p FROM PccParametro p")
public class PccParametro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idpccparametros;
	private String descripcion;
	private Integer horaAnticipacion;
	private Integer horaFinal;
	private Integer minutoAnticipacion;
	private Integer minutoFinal;
	private double temperatura;
	private List<CorreosPccParametro> correosPccParametros;

	public PccParametro() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="hora_anticipacion")
	public Integer getHoraAnticipacion() {
		return this.horaAnticipacion;
	}

	public void setHoraAnticipacion(Integer horaAnticipacion) {
		this.horaAnticipacion = horaAnticipacion;
	}


	@Column(name="hora_final")
	public Integer getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(Integer horaFinal) {
		this.horaFinal = horaFinal;
	}


	@Column(name="minuto_anticipacion")
	public Integer getMinutoAnticipacion() {
		return this.minutoAnticipacion;
	}

	public void setMinutoAnticipacion(Integer minutoAnticipacion) {
		this.minutoAnticipacion = minutoAnticipacion;
	}


	@Column(name="minuto_final")
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


	//bi-directional many-to-one association to CorreosPccParametro
	@OneToMany(mappedBy="pccParametro")
	public List<CorreosPccParametro> getCorreosPccParametros() {
		return this.correosPccParametros;
	}

	public void setCorreosPccParametros(List<CorreosPccParametro> correosPccParametros) {
		this.correosPccParametros = correosPccParametros;
	}

	public CorreosPccParametro addCorreosPccParametro(CorreosPccParametro correosPccParametro) {
		getCorreosPccParametros().add(correosPccParametro);
		correosPccParametro.setPccParametro(this);

		return correosPccParametro;
	}

	public CorreosPccParametro removeCorreosPccParametro(CorreosPccParametro correosPccParametro) {
		getCorreosPccParametros().remove(correosPccParametro);
		correosPccParametro.setPccParametro(null);

		return correosPccParametro;
	}

}