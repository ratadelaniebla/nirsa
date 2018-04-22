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
public class EnvasadoControlPesoFillDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolpesofilldetalle;
	private Timestamp fechareg;
	private Timestamp fecharegusuario;
	private String idusuario;
	private double pesofill;
	private EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera;

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


	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}


	public double getPesofill() {
		return this.pesofill;
	}

	public void setPesofill(double pesofill) {
		this.pesofill = pesofill;
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

}