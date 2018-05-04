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
@NamedQuery(name="GrupoTalla.findAll", query="SELECT g FROM GrupoTalla g")
public class GrupoTalla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idgrupotalla;
	private String color;
	private String descripciongrupotalla;
	private List<GrupoTallaEspecieTalla> grupoTallaEspecieTallas;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;

	public GrupoTalla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to GrupoTallaEspecieTalla
	@OneToMany(mappedBy="grupoTalla")
	public List<GrupoTallaEspecieTalla> getGrupoTallaEspecieTallas() {
		return this.grupoTallaEspecieTallas;
	}

	public void setGrupoTallaEspecieTallas(List<GrupoTallaEspecieTalla> grupoTallaEspecieTallas) {
		this.grupoTallaEspecieTallas = grupoTallaEspecieTallas;
	}

	public GrupoTallaEspecieTalla addGrupoTallaEspecieTalla(GrupoTallaEspecieTalla grupoTallaEspecieTalla) {
		getGrupoTallaEspecieTallas().add(grupoTallaEspecieTalla);
		grupoTallaEspecieTalla.setGrupoTalla(this);

		return grupoTallaEspecieTalla;
	}

	public GrupoTallaEspecieTalla removeGrupoTallaEspecieTalla(GrupoTallaEspecieTalla grupoTallaEspecieTalla) {
		getGrupoTallaEspecieTallas().remove(grupoTallaEspecieTalla);
		grupoTallaEspecieTalla.setGrupoTalla(null);

		return grupoTallaEspecieTalla;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="grupoTalla")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().add(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setGrupoTalla(this);

		return limpiezaDetalleProcesoBandeja;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().remove(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setGrupoTalla(null);

		return limpiezaDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="grupoTalla")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().add(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setGrupoTalla(this);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().remove(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setGrupoTalla(null);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}

}