package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the envasado_control_peso_neto_detalle database table.
 * 
 */
@Entity
@Table(name="envasado_control_peso_neto_detalle")
@NamedQuery(name="EnvasadoControlPesoNetoDetalle.findAll", query="SELECT e FROM EnvasadoControlPesoNetoDetalle e")
public class EnvasadoControlPesoNetoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolpesonetodetalle;
	private Timestamp fechareg;
	private Timestamp fecharegusuario;
	private double pesoneto;
	private EnvasadoControlNetoCorteDetalle envasadoControlNetoCorteDetalle;
	private EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera;
	private Usuario usuario;

	public EnvasadoControlPesoNetoDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadocontrolpesonetodetalle() {
		return this.idenvasadocontrolpesonetodetalle;
	}

	public void setIdenvasadocontrolpesonetodetalle(Long idenvasadocontrolpesonetodetalle) {
		this.idenvasadocontrolpesonetodetalle = idenvasadocontrolpesonetodetalle;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFecharegusuario() {
		return this.fecharegusuario;
	}

	public void setFecharegusuario(Timestamp fecharegusuario) {
		this.fecharegusuario = fecharegusuario;
	}


	public double getPesoneto() {
		return this.pesoneto;
	}

	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}


	//bi-directional many-to-one association to EnvasadoControlFillCorteDetalle
	@ManyToOne
	@JoinColumn(name="idenvasadocontrolnetocortedetalle")
	public EnvasadoControlNetoCorteDetalle getEnvasadoControlNetoCorteDetalle() {
		return this.envasadoControlNetoCorteDetalle;
	}

	public void setEnvasadoControlNetoCorteDetalle(EnvasadoControlNetoCorteDetalle envasadoControlNetoCorteDetalle) {
		this.envasadoControlNetoCorteDetalle = envasadoControlNetoCorteDetalle;
	}
	
	
	//bi-directional many-to-one association to EnvasadoControlPesoNetoCabecera
	@ManyToOne
	@JoinColumn(name="idenvasadocontrolpesonetocabecera")
	public EnvasadoControlPesoNetoCabecera getEnvasadoControlPesoNetoCabecera() {
		return this.envasadoControlPesoNetoCabecera;
	}

	public void setEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		this.envasadoControlPesoNetoCabecera = envasadoControlPesoNetoCabecera;
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