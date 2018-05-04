package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the seguridad_auditoria_consulta_documento database table.
 * 
 */
@Entity
@Table(name="seguridad_auditoria_consulta_documento")
@NamedQuery(name="SeguridadAuditoriaConsultaDocumento.findAll", query="SELECT s FROM SeguridadAuditoriaConsultaDocumento s")
public class SeguridadAuditoriaConsultaDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idauditoriaconsultadocumento;
	private String encontrado;
	private Timestamp fechareg;
	private String ip;
	private String nombreequipo;
	private String numerodocumento;
	private String observacion;
	private String sistemaoperativo;
	private Usuario usuario;

	public SeguridadAuditoriaConsultaDocumento() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdauditoriaconsultadocumento() {
		return this.idauditoriaconsultadocumento;
	}

	public void setIdauditoriaconsultadocumento(Long idauditoriaconsultadocumento) {
		this.idauditoriaconsultadocumento = idauditoriaconsultadocumento;
	}


	public String getEncontrado() {
		return this.encontrado;
	}

	public void setEncontrado(String encontrado) {
		this.encontrado = encontrado;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getNombreequipo() {
		return this.nombreequipo;
	}

	public void setNombreequipo(String nombreequipo) {
		this.nombreequipo = nombreequipo;
	}


	public String getNumerodocumento() {
		return this.numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getSistemaoperativo() {
		return this.sistemaoperativo;
	}

	public void setSistemaoperativo(String sistemaoperativo) {
		this.sistemaoperativo = sistemaoperativo;
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