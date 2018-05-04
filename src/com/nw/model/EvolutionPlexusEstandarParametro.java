package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evolution_plexus_estandar_parametro database table.
 * 
 */
@Entity
@Table(name="evolution_plexus_estandar_parametro")
@NamedQuery(name="EvolutionPlexusEstandarParametro.findAll", query="SELECT e FROM EvolutionPlexusEstandarParametro e")
public class EvolutionPlexusEstandarParametro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevolutionplexusestandar;
	private String descripcion;
	private double desde;
	private Integer estado;
	private double hasta;
	private double incremento;
	private double valor;
	private List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas;

	public EvolutionPlexusEstandarParametro() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdevolutionplexusestandar() {
		return this.idevolutionplexusestandar;
	}

	public void setIdevolutionplexusestandar(Integer idevolutionplexusestandar) {
		this.idevolutionplexusestandar = idevolutionplexusestandar;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getDesde() {
		return this.desde;
	}

	public void setDesde(double desde) {
		this.desde = desde;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public double getHasta() {
		return this.hasta;
	}

	public void setHasta(double hasta) {
		this.hasta = hasta;
	}


	public double getIncremento() {
		return this.incremento;
	}

	public void setIncremento(double incremento) {
		this.incremento = incremento;
	}


	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to EvolutionPlexusEstandarTarifa
	@OneToMany(mappedBy="evolutionPlexusEstandarParametro")
	public List<EvolutionPlexusEstandarTarifa> getEvolutionPlexusEstandarTarifas() {
		return this.evolutionPlexusEstandarTarifas;
	}

	public void setEvolutionPlexusEstandarTarifas(List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas) {
		this.evolutionPlexusEstandarTarifas = evolutionPlexusEstandarTarifas;
	}

	public EvolutionPlexusEstandarTarifa addEvolutionPlexusEstandarTarifa(EvolutionPlexusEstandarTarifa evolutionPlexusEstandarTarifa) {
		getEvolutionPlexusEstandarTarifas().add(evolutionPlexusEstandarTarifa);
		evolutionPlexusEstandarTarifa.setEvolutionPlexusEstandarParametro(this);

		return evolutionPlexusEstandarTarifa;
	}

	public EvolutionPlexusEstandarTarifa removeEvolutionPlexusEstandarTarifa(EvolutionPlexusEstandarTarifa evolutionPlexusEstandarTarifa) {
		getEvolutionPlexusEstandarTarifas().remove(evolutionPlexusEstandarTarifa);
		evolutionPlexusEstandarTarifa.setEvolutionPlexusEstandarParametro(null);

		return evolutionPlexusEstandarTarifa;
	}

}