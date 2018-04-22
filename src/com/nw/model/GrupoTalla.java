package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo_talla database table.
 * 
 */
@Entity
@Table(name="grupo_talla")
public class GrupoTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idgrupotalla;

	private String color;

	private String descripciongrupotalla;

	//bi-directional many-to-one association to GrupoTallaEspecieTalla
	@OneToMany(mappedBy="grupoTalla")
	private List<GrupoTallaEspecieTalla> grupoTallaEspecieTallas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="grupoTalla")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="grupoTalla")
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;

	public GrupoTalla() {
	}

	public Integer getIdgrupotalla() {
		return this.idgrupotalla;
	}

	public void setIdgrupotalla(Integer idgrupotalla) {
		this.idgrupotalla = idgrupotalla;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripciongrupotalla() {
		return this.descripciongrupotalla;
	}

	public void setDescripciongrupotalla(String descripciongrupotalla) {
		this.descripciongrupotalla = descripciongrupotalla;
	}

	public List<GrupoTallaEspecieTalla> getGrupoTallaEspecieTallas() {
		return this.grupoTallaEspecieTallas;
	}

	public void setGrupoTallaEspecieTallas(List<GrupoTallaEspecieTalla> grupoTallaEspecieTallas) {
		this.grupoTallaEspecieTallas = grupoTallaEspecieTallas;
	}

	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

}