package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the envasado_control_peso_fill_detalle database table.
 * 
 */
@Entity
@Table(name="envasado_control_peso_fill_detalle")
@NamedQuery(name="EnvasadoControlPesoFillDetalle.findAll", query="SELECT e FROM EnvasadoControlPesoFillDetalle e")
public class EnvasadoControlPesoFillDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolpesofilldetalle;
	private Timestamp fechareg;
	private Timestamp fecharegusuario;
	private double pesofill;
	private EnvasadoControlFillCorteDetalle envasadoControlFillCorteDetalle;
	private EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera;
	private Usuario usuario;

	public EnvasadoControlPesoFillDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadocontrolpesofilldetalle() {
		return this.idenvasadocontrolpesofilldetalle;
	}

	public void setIdenvasadocontrolpesofilldetalle(Long idenvasadocontrolpesofilldetalle) {
		this.idenvasadocontrolpesofilldetalle = idenvasadocontrolpesofilldetalle;
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


	public double getPesofill() {
		return this.pesofill;
	}

	public void setPesofill(double pesofill) {
		this.pesofill = pesofill;
	}


	//bi-directional many-to-one association to EnvasadoControlFillCorteDetalle
	@ManyToOne
	@JoinColumn(name="idenvasadocontrolfillcortedetalle")
	public EnvasadoControlFillCorteDetalle getEnvasadoControlFillCorteDetalle() {
		return this.envasadoControlFillCorteDetalle;
	}

	public void setEnvasadoControlFillCorteDetalle(EnvasadoControlFillCorteDetalle envasadoControlFillCorteDetalle) {
		this.envasadoControlFillCorteDetalle = envasadoControlFillCorteDetalle;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillCabecera
	@ManyToOne
	@JoinColumn(name="idenvasadocontrolpesofillcabecera")
	public EnvasadoControlPesoFillCabecera getEnvasadoControlPesoFillCabecera() {
		return this.envasadoControlPesoFillCabecera;
	}

	public void setEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		this.envasadoControlPesoFillCabecera = envasadoControlPesoFillCabecera;
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