package com.nw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the envasado_control_neto_corte_detalle database table.
 * 
 */
@Entity
@Table(name="envasado_control_neto_corte_detalle")
@NamedQuery(name="EnvasadoControlNetoCorteDetalle.findAll", query="SELECT e FROM EnvasadoControlNetoCorteDetalle e")
public class EnvasadoControlNetoCorteDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolnetocortedetalle;
	private Integer corte;
	private Long hora;
	private Long minuto;
	private EnvasadoControlNetoCorteCabecera envasadoControlNetoCorteCabecera;
	private List<EnvasadoControlPesoNetoDetalle> envasadoControlPesoNetoDetalles;

	public EnvasadoControlNetoCorteDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadocontrolnetocortedetalle() {
		return this.idenvasadocontrolnetocortedetalle;
	}

	public void setIdenvasadocontrolnetocortedetalle(Long idenvasadocontrolnetocortedetalle) {
		this.idenvasadocontrolnetocortedetalle = idenvasadocontrolnetocortedetalle;
	}


	public Integer getCorte() {
		return this.corte;
	}

	public void setCorte(Integer corte) {
		this.corte = corte;
	}


	public Long getHora() {
		return this.hora;
	}

	public void setHora(Long hora) {
		this.hora = hora;
	}


	public Long getMinuto() {
		return this.minuto;
	}

	public void setMinuto(Long minuto) {
		this.minuto = minuto;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillDetalle
	@OneToMany(mappedBy="envasadoControlNetoCorteDetalle")
	public List<EnvasadoControlPesoNetoDetalle> getEnvasadoControlPesoNetoDetalles() {
		return this.envasadoControlPesoNetoDetalles;
	}

	public void setEnvasadoControlPesoNetoDetalles(List<EnvasadoControlPesoNetoDetalle> envasadoControlPesoNetoDetalles) {
		this.envasadoControlPesoNetoDetalles = envasadoControlPesoNetoDetalles;
	}
	
	
	//bi-directional many-to-one association to EnvasadoControlNetoCorteCabecera
	@ManyToOne
	@JoinColumn(name="idenvasadocontrolnetocortecabecera")
	public EnvasadoControlNetoCorteCabecera getEnvasadoControlNetoCorteCabecera() {
		return this.envasadoControlNetoCorteCabecera;
	}

	public void setEnvasadoControlNetoCorteCabecera(EnvasadoControlNetoCorteCabecera envasadoControlNetoCorteCabecera) {
		this.envasadoControlNetoCorteCabecera = envasadoControlNetoCorteCabecera;
	}

}