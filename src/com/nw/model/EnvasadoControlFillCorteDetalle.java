package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the envasado_control_fill_corte_detalle database table.
 * 
 */
@Entity
@Table(name="envasado_control_fill_corte_detalle")
@NamedQuery(name="EnvasadoControlFillCorteDetalle.findAll", query="SELECT e FROM EnvasadoControlFillCorteDetalle e")
public class EnvasadoControlFillCorteDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolfillcortedetalle;
	private Integer corte;
	private Timestamp fechaCorte;
	private Timestamp fechaFinCorteAnterior;
	private EnvasadoControlFillCorteCabecera envasadoControlFillCorteCabecera;

	public EnvasadoControlFillCorteDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadocontrolfillcortedetalle() {
		return this.idenvasadocontrolfillcortedetalle;
	}

	public void setIdenvasadocontrolfillcortedetalle(Long idenvasadocontrolfillcortedetalle) {
		this.idenvasadocontrolfillcortedetalle = idenvasadocontrolfillcortedetalle;
	}


	public Integer getCorte() {
		return this.corte;
	}

	public void setCorte(Integer corte) {
		this.corte = corte;
	}


	@Column(name="fecha_corte")
	public Timestamp getFechaCorte() {
		return this.fechaCorte;
	}

	public void setFechaCorte(Timestamp fechaCorte) {
		this.fechaCorte = fechaCorte;
	}


	@Column(name="fecha_fin_corte_anterior")
	public Timestamp getFechaFinCorteAnterior() {
		return this.fechaFinCorteAnterior;
	}

	public void setFechaFinCorteAnterior(Timestamp fechaFinCorteAnterior) {
		this.fechaFinCorteAnterior = fechaFinCorteAnterior;
	}


	//bi-directional many-to-one association to EnvasadoControlFillCorteCabecera
	@ManyToOne
	@JoinColumn(name="idenvasadocontrolfillcortecabecera")
	public EnvasadoControlFillCorteCabecera getEnvasadoControlFillCorteCabecera() {
		return this.envasadoControlFillCorteCabecera;
	}

	public void setEnvasadoControlFillCorteCabecera(EnvasadoControlFillCorteCabecera envasadoControlFillCorteCabecera) {
		this.envasadoControlFillCorteCabecera = envasadoControlFillCorteCabecera;
	}

}