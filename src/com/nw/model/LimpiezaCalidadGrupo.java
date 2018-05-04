package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_calidad_grupo database table.
 * 
 */
@Entity
@Table(name="limpieza_calidad_grupo")
@NamedQuery(name="LimpiezaCalidadGrupo.findAll", query="SELECT l FROM LimpiezaCalidadGrupo l")
public class LimpiezaCalidadGrupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezacalidadgrupo;
	private String descripcion;
	private List<LimpiezaCalidadGrupoMaestroSubproducto> limpiezaCalidadGrupoMaestroSubproductos;

	public LimpiezaCalidadGrupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlimpiezacalidadgrupo() {
		return this.idlimpiezacalidadgrupo;
	}

	public void setIdlimpiezacalidadgrupo(Integer idlimpiezacalidadgrupo) {
		this.idlimpiezacalidadgrupo = idlimpiezacalidadgrupo;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to LimpiezaCalidadGrupoMaestroSubproducto
	@OneToMany(mappedBy="limpiezaCalidadGrupo")
	public List<LimpiezaCalidadGrupoMaestroSubproducto> getLimpiezaCalidadGrupoMaestroSubproductos() {
		return this.limpiezaCalidadGrupoMaestroSubproductos;
	}

	public void setLimpiezaCalidadGrupoMaestroSubproductos(List<LimpiezaCalidadGrupoMaestroSubproducto> limpiezaCalidadGrupoMaestroSubproductos) {
		this.limpiezaCalidadGrupoMaestroSubproductos = limpiezaCalidadGrupoMaestroSubproductos;
	}

	public LimpiezaCalidadGrupoMaestroSubproducto addLimpiezaCalidadGrupoMaestroSubproducto(LimpiezaCalidadGrupoMaestroSubproducto limpiezaCalidadGrupoMaestroSubproducto) {
		getLimpiezaCalidadGrupoMaestroSubproductos().add(limpiezaCalidadGrupoMaestroSubproducto);
		limpiezaCalidadGrupoMaestroSubproducto.setLimpiezaCalidadGrupo(this);

		return limpiezaCalidadGrupoMaestroSubproducto;
	}

	public LimpiezaCalidadGrupoMaestroSubproducto removeLimpiezaCalidadGrupoMaestroSubproducto(LimpiezaCalidadGrupoMaestroSubproducto limpiezaCalidadGrupoMaestroSubproducto) {
		getLimpiezaCalidadGrupoMaestroSubproductos().remove(limpiezaCalidadGrupoMaestroSubproducto);
		limpiezaCalidadGrupoMaestroSubproducto.setLimpiezaCalidadGrupo(null);

		return limpiezaCalidadGrupoMaestroSubproducto;
	}

}