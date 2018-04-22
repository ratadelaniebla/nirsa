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
public class LimpiezaCalidadMaestroSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezacalidadmaestrosubproducto;

	private Boolean aplicataralomo;

	private Boolean aplicatararallado;

	private String descripcion;

	private double otratara;
	
	//bi-directional many-to-one association to LimpiezaCalidadGrupoMaestroSubproducto
	@OneToMany(mappedBy="limpiezaCalidadMaestroSubproducto")
	private List<LimpiezaCalidadGrupoMaestroSubproducto> limpiezaCalidadGrupoMaestroSubproductos;

	public LimpiezaCalidadMaestroSubproducto() {
	}

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

	public List<LimpiezaCalidadGrupoMaestroSubproducto> getLimpiezaCalidadGrupoMaestroSubproductos() {
		return this.limpiezaCalidadGrupoMaestroSubproductos;
	}

	public void setLimpiezaCalidadGrupoMaestroSubproductos(List<LimpiezaCalidadGrupoMaestroSubproducto> limpiezaCalidadGrupoMaestroSubproductos) {
		this.limpiezaCalidadGrupoMaestroSubproductos = limpiezaCalidadGrupoMaestroSubproductos;
	}

	public double getOtratara() {
		return otratara;
	}

	public void setOtratara(double otratara) {
		this.otratara = otratara;
	}

}