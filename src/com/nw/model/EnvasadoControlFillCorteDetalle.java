package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


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
	private Long hora;
	private Long minuto;
	private EnvasadoControlFillCorteCabecera envasadoControlFillCorteCabecera;
	private List<EnvasadoControlPesoFillDetalle> envasadoControlPesoFillDetalles;

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


	//bi-directional many-to-one association to EnvasadoControlFillCorteCabecera
	@ManyToOne
	@JoinColumn(name="idenvasadocontrolfillcortecabecera")
	public EnvasadoControlFillCorteCabecera getEnvasadoControlFillCorteCabecera() {
		return this.envasadoControlFillCorteCabecera;
	}

	public void setEnvasadoControlFillCorteCabecera(EnvasadoControlFillCorteCabecera envasadoControlFillCorteCabecera) {
		this.envasadoControlFillCorteCabecera = envasadoControlFillCorteCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillDetalle
	@OneToMany(mappedBy="envasadoControlFillCorteDetalle")
	public List<EnvasadoControlPesoFillDetalle> getEnvasadoControlPesoFillDetalles() {
		return this.envasadoControlPesoFillDetalles;
	}

	public void setEnvasadoControlPesoFillDetalles(List<EnvasadoControlPesoFillDetalle> envasadoControlPesoFillDetalles) {
		this.envasadoControlPesoFillDetalles = envasadoControlPesoFillDetalles;
	}

	public EnvasadoControlPesoFillDetalle addEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle) {
		getEnvasadoControlPesoFillDetalles().add(envasadoControlPesoFillDetalle);
		envasadoControlPesoFillDetalle.setEnvasadoControlFillCorteDetalle(this);

		return envasadoControlPesoFillDetalle;
	}

	public EnvasadoControlPesoFillDetalle removeEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle) {
		getEnvasadoControlPesoFillDetalles().remove(envasadoControlPesoFillDetalle);
		envasadoControlPesoFillDetalle.setEnvasadoControlFillCorteDetalle(null);

		return envasadoControlPesoFillDetalle;
	}

}