package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the descongelado_detalle_proceso_contraloria database table.
 * 
 */
@Entity
@Table(name="descongelado_detalle_proceso_contraloria")
@NamedQuery(name="DescongeladoDetalleProcesoContraloria.findAll", query="SELECT d FROM DescongeladoDetalleProcesoContraloria d")
public class DescongeladoDetalleProcesoContraloria implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddescongeladodetalleproceso;
	private Timestamp fechajoracreacionregisto;
	private String idcajon;
	private Integer idducha;
	private String observaciones;
	private double peso;
	private double tara;
	private Turno turno;
	private Usuario usuario;

	public DescongeladoDetalleProcesoContraloria() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddescongeladodetalleproceso() {
		return this.iddescongeladodetalleproceso;
	}

	public void setIddescongeladodetalleproceso(Long iddescongeladodetalleproceso) {
		this.iddescongeladodetalleproceso = iddescongeladodetalleproceso;
	}


	public Timestamp getFechajoracreacionregisto() {
		return this.fechajoracreacionregisto;
	}

	public void setFechajoracreacionregisto(Timestamp fechajoracreacionregisto) {
		this.fechajoracreacionregisto = fechajoracreacionregisto;
	}


	public String getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(String idcajon) {
		this.idcajon = idcajon;
	}


	public Integer getIdducha() {
		return this.idducha;
	}

	public void setIdducha(Integer idducha) {
		this.idducha = idducha;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
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