package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_calidad_maestro_subproducto database table.
 * 
 */
@Entity
@Table(name="limpieza_calidad_maestro_subproducto")
@NamedQuery(name="LimpiezaCalidadMaestroSubproducto.findAll", query="SELECT l FROM LimpiezaCalidadMaestroSubproducto l")
public class LimpiezaCalidadMaestroSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezacalidadmaestrosubproducto;
	private Boolean aplicataralomo;
	private Boolean aplicatararallado;
	private String descripcion;
	private double otratara;
	private List<LimpiezaCalidadGrupoMaestroSubproducto> limpiezaCalidadGrupoMaestroSubproductos;

	public LimpiezaCalidadMaestroSubproducto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlimpiezacalidadmaestrosubproducto() {
		return this.idlimpiezacalidadmaestrosubproducto;
	}

	public void setIdlimpiezacalidadmaestrosubproducto(Integer idlimpiezacalidadmaestrosubproducto) {
		this.idlimpiezacalidadmaestrosubproducto = idlimpiezacalidadmaestrosubproducto;
	}


	public Boolean getAplicataralomo() {
		return this.aplicataralomo;
	}

	public void setAplicataralomo(Boolean aplicataralomo) {
		this.aplicataralomo = aplicataralomo;
	}


	public Boolean getAplicatararallado() {
		return this.aplicatararallado;
	}

	public void setAplicatararallado(Boolean aplicatararallado) {
		this.aplicatararallado = aplicatararallado;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getOtratara() {
		return this.otratara;
	}

	public void setOtratara(double otratara) {
		this.otratara = otratara;
	}


	//bi-directional many-to-one association to LimpiezaCalidadGrupoMaestroSubproducto
	@OneToMany(mappedBy="limpiezaCalidadMaestroSubproducto")
	public List<LimpiezaCalidadGrupoMaestroSubproducto> getLimpiezaCalidadGrupoMaestroSubproductos() {
		return this.limpiezaCalidadGrupoMaestroSubproductos;
	}

	public void setLimpiezaCalidadGrupoMaestroSubproductos(List<LimpiezaCalidadGrupoMaestroSubproducto> limpiezaCalidadGrupoMaestroSubproductos) {
		this.limpiezaCalidadGrupoMaestroSubproductos = limpiezaCalidadGrupoMaestroSubproductos;
	}

	public LimpiezaCalidadGrupoMaestroSubproducto addLimpiezaCalidadGrupoMaestroSubproducto(LimpiezaCalidadGrupoMaestroSubproducto limpiezaCalidadGrupoMaestroSubproducto) {
		getLimpiezaCalidadGrupoMaestroSubproductos().add(limpiezaCalidadGrupoMaestroSubproducto);
		limpiezaCalidadGrupoMaestroSubproducto.setLimpiezaCalidadMaestroSubproducto(this);

		return limpiezaCalidadGrupoMaestroSubproducto;
	}

	public LimpiezaCalidadGrupoMaestroSubproducto removeLimpiezaCalidadGrupoMaestroSubproducto(LimpiezaCalidadGrupoMaestroSubproducto limpiezaCalidadGrupoMaestroSubproducto) {
		getLimpiezaCalidadGrupoMaestroSubproductos().remove(limpiezaCalidadGrupoMaestroSubproducto);
		limpiezaCalidadGrupoMaestroSubproducto.setLimpiezaCalidadMaestroSubproducto(null);

		return limpiezaCalidadGrupoMaestroSubproducto;
	}

}