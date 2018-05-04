package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the correos_pcc_parametros database table.
 * 
 */
@Entity
@Table(name="correos_pcc_parametros")
@NamedQuery(name="CorreosPccParametro.findAll", query="SELECT c FROM CorreosPccParametro c")
public class CorreosPccParametro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcorreopccparametros;
	private Boolean enviar;
	private Correo correo;
	private PccParametro pccParametro;

	public CorreosPccParametro() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcorreopccparametros() {
		return this.idcorreopccparametros;
	}

	public void setIdcorreopccparametros(Long idcorreopccparametros) {
		this.idcorreopccparametros = idcorreopccparametros;
	}


	public Boolean getEnviar() {
		return this.enviar;
	}

	public void setEnviar(Boolean enviar) {
		this.enviar = enviar;
	}


	//bi-directional many-to-one association to Correo
	@ManyToOne
	@JoinColumn(name="idcorreo")
	public Correo getCorreo() {
		return this.correo;
	}

	public void setCorreo(Correo correo) {
		this.correo = correo;
	}


	//bi-directional many-to-one association to PccParametro
	@ManyToOne
	@JoinColumn(name="idpccparametros")
	public PccParametro getPccParametro() {
		return this.pccParametro;
	}

	public void setPccParametro(PccParametro pccParametro) {
		this.pccParametro = pccParametro;
	}

}