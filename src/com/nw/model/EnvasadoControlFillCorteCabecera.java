package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the envasado_control_fill_corte_cabecera database table.
 * 
 */
@Entity
@Table(name="envasado_control_fill_corte_cabecera")
@NamedQuery(name="EnvasadoControlFillCorteCabecera.findAll", query="SELECT e FROM EnvasadoControlFillCorteCabecera e")
public class EnvasadoControlFillCorteCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolfillcortecabecera;
	private Timestamp fechareg;
	private String idusuario;
	private EnvasadoProceso envasadoProceso;
	private List<EnvasadoControlFillCorteDetalle> envasadoControlFillCorteDetalles;

	public EnvasadoControlFillCorteCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadocontrolfillcortecabecera() {
		return this.idenvasadocontrolfillcortecabecera;
	}

	public void setIdenvasadocontrolfillcortecabecera(Long idenvasadocontrolfillcortecabecera) {
		this.idenvasadocontrolfillcortecabecera = idenvasadocontrolfillcortecabecera;
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


	//bi-directional many-to-one association to EnvasadoControlFillCorteDetalle
	@OneToMany(mappedBy="envasadoControlFillCorteCabecera")
	public List<EnvasadoControlFillCorteDetalle> getEnvasadoControlFillCorteDetalles() {
		return this.envasadoControlFillCorteDetalles;
	}

	public void setEnvasadoControlFillCorteDetalles(List<EnvasadoControlFillCorteDetalle> envasadoControlFillCorteDetalles) {
		this.envasadoControlFillCorteDetalles = envasadoControlFillCorteDetalles;
	}

	public EnvasadoControlFillCorteDetalle addEnvasadoControlFillCorteDetalle(EnvasadoControlFillCorteDetalle envasadoControlFillCorteDetalle) {
		getEnvasadoControlFillCorteDetalles().add(envasadoControlFillCorteDetalle);
		envasadoControlFillCorteDetalle.setEnvasadoControlFillCorteCabecera(this);

		return envasadoControlFillCorteDetalle;
	}

	public EnvasadoControlFillCorteDetalle removeEnvasadoControlFillCorteDetalle(EnvasadoControlFillCorteDetalle envasadoControlFillCorteDetalle) {
		getEnvasadoControlFillCorteDetalles().remove(envasadoControlFillCorteDetalle);
		envasadoControlFillCorteDetalle.setEnvasadoControlFillCorteCabecera(null);

		return envasadoControlFillCorteDetalle;
	}

}