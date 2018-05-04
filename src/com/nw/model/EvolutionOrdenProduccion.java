package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evolution_orden_produccion database table.
 * 
 */
@Entity
@Table(name="evolution_orden_produccion")
@NamedQuery(name="EvolutionOrdenProduccion.findAll", query="SELECT e FROM EvolutionOrdenProduccion e")
public class EvolutionOrdenProduccion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevolutionordenproduccion;
	private String descripcion;
	private Integer estado;
	private Integer idlinea;
	private String ordenproduccion;
	private List<EvolutionPlexusParametrosTarifasPesosLimpieza> evolutionPlexusParametrosTarifasPesosLimpiezas;

	public EvolutionOrdenProduccion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdevolutionordenproduccion() {
		return this.idevolutionordenproduccion;
	}

	public void setIdevolutionordenproduccion(Integer idevolutionordenproduccion) {
		this.idevolutionordenproduccion = idevolutionordenproduccion;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Integer getIdlinea() {
		return this.idlinea;
	}

	public void setIdlinea(Integer idlinea) {
		this.idlinea = idlinea;
	}


	public String getOrdenproduccion() {
		return this.ordenproduccion;
	}

	public void setOrdenproduccion(String ordenproduccion) {
		this.ordenproduccion = ordenproduccion;
	}


	//bi-directional many-to-one association to EvolutionPlexusParametrosTarifasPesosLimpieza
	@OneToMany(mappedBy="evolutionOrdenProduccion")
	public List<EvolutionPlexusParametrosTarifasPesosLimpieza> getEvolutionPlexusParametrosTarifasPesosLimpiezas() {
		return this.evolutionPlexusParametrosTarifasPesosLimpiezas;
	}

	public void setEvolutionPlexusParametrosTarifasPesosLimpiezas(List<EvolutionPlexusParametrosTarifasPesosLimpieza> evolutionPlexusParametrosTarifasPesosLimpiezas) {
		this.evolutionPlexusParametrosTarifasPesosLimpiezas = evolutionPlexusParametrosTarifasPesosLimpiezas;
	}

	public EvolutionPlexusParametrosTarifasPesosLimpieza addEvolutionPlexusParametrosTarifasPesosLimpieza(EvolutionPlexusParametrosTarifasPesosLimpieza evolutionPlexusParametrosTarifasPesosLimpieza) {
		getEvolutionPlexusParametrosTarifasPesosLimpiezas().add(evolutionPlexusParametrosTarifasPesosLimpieza);
		evolutionPlexusParametrosTarifasPesosLimpieza.setEvolutionOrdenProduccion(this);

		return evolutionPlexusParametrosTarifasPesosLimpieza;
	}

	public EvolutionPlexusParametrosTarifasPesosLimpieza removeEvolutionPlexusParametrosTarifasPesosLimpieza(EvolutionPlexusParametrosTarifasPesosLimpieza evolutionPlexusParametrosTarifasPesosLimpieza) {
		getEvolutionPlexusParametrosTarifasPesosLimpiezas().remove(evolutionPlexusParametrosTarifasPesosLimpieza);
		evolutionPlexusParametrosTarifasPesosLimpieza.setEvolutionOrdenProduccion(null);

		return evolutionPlexusParametrosTarifasPesosLimpieza;
	}

}