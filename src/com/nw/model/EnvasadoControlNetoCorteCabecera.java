package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the envasado_control_neto_corte_cabecera database table.
 * 
 */
@Entity
@Table(name="envasado_control_neto_corte_cabecera")
@NamedQuery(name="EnvasadoControlNetoCorteCabecera.findAll", query="SELECT e FROM EnvasadoControlNetoCorteCabecera e")
public class EnvasadoControlNetoCorteCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolnetocortecabecera;
	private Timestamp fechareg;
	private String idusuario;
	private EnvasadoProceso envasadoProceso;
	private List<EnvasadoControlNetoCorteDetalle> envasadoControlNetoCorteDetalles;

	public EnvasadoControlNetoCorteCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadocontrolnetocortecabecera() {
		return this.idenvasadocontrolnetocortecabecera;
	}

	public void setIdenvasadocontrolnetocortecabecera(Long idenvasadocontrolnetocortecabecera) {
		this.idenvasadocontrolnetocortecabecera = idenvasadocontrolnetocortecabecera;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@ManyToOne
	@JoinColumn(name="idenvasadoproceso")
	public EnvasadoProceso getEnvasadoProceso() {
		return this.envasadoProceso;
	}

	public void setEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		this.envasadoProceso = envasadoProceso;
	}


	//bi-directional many-to-one association to EnvasadoControlNetoCorteDetalle
	@OneToMany(mappedBy="envasadoControlNetoCorteCabecera")
	public List<EnvasadoControlNetoCorteDetalle> getEnvasadoControlNetoCorteDetalles() {
		return this.envasadoControlNetoCorteDetalles;
	}

	public void setEnvasadoControlNetoCorteDetalles(List<EnvasadoControlNetoCorteDetalle> envasadoControlNetoCorteDetalles) {
		this.envasadoControlNetoCorteDetalles = envasadoControlNetoCorteDetalles;
	}

	public EnvasadoControlNetoCorteDetalle addEnvasadoControlNetoCorteDetalle(EnvasadoControlNetoCorteDetalle envasadoControlNetoCorteDetalle) {
		getEnvasadoControlNetoCorteDetalles().add(envasadoControlNetoCorteDetalle);
		envasadoControlNetoCorteDetalle.setEnvasadoControlNetoCorteCabecera(this);

		return envasadoControlNetoCorteDetalle;
	}

	public EnvasadoControlNetoCorteDetalle removeEnvasadoControlNetoCorteDetalle(EnvasadoControlNetoCorteDetalle envasadoControlNetoCorteDetalle) {
		getEnvasadoControlNetoCorteDetalles().remove(envasadoControlNetoCorteDetalle);
		envasadoControlNetoCorteDetalle.setEnvasadoControlNetoCorteCabecera(null);

		return envasadoControlNetoCorteDetalle;
	}

}