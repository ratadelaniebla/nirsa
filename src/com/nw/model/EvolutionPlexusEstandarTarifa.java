package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evolution_plexus_estandar_tarifa database table.
 * 
 */
@Entity
@Table(name="evolution_plexus_estandar_tarifa")
@NamedQuery(name="EvolutionPlexusEstandarTarifa.findAll", query="SELECT e FROM EvolutionPlexusEstandarTarifa e")
public class EvolutionPlexusEstandarTarifa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevolutionplexusestandartarifa;
	private double costoKg;
	private double diferencia80;
	private double factorEquivalente;
	private double kilosMes;
	private double promedio;
	private double vplexus;
	private double vsinapsis;
	private EvolutionPlexusEstandarParametro evolutionPlexusEstandarParametro;
	private LimpiezaTipo limpiezaTipo;
	private Talla talla;

	public EvolutionPlexusEstandarTarifa() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdevolutionplexusestandartarifa() {
		return this.idevolutionplexusestandartarifa;
	}

	public void setIdevolutionplexusestandartarifa(Integer idevolutionplexusestandartarifa) {
		this.idevolutionplexusestandartarifa = idevolutionplexusestandartarifa;
	}


	@Column(name="costo_kg")
	public double getCostoKg() {
		return this.costoKg;
	}

	public void setCostoKg(double costoKg) {
		this.costoKg = costoKg;
	}


	@Column(name="diferencia_80")
	public double getDiferencia80() {
		return this.diferencia80;
	}

	public void setDiferencia80(double diferencia80) {
		this.diferencia80 = diferencia80;
	}


	@Column(name="factor_equivalente")
	public double getFactorEquivalente() {
		return this.factorEquivalente;
	}

	public void setFactorEquivalente(double factorEquivalente) {
		this.factorEquivalente = factorEquivalente;
	}


	@Column(name="kilos_mes")
	public double getKilosMes() {
		return this.kilosMes;
	}

	public void setKilosMes(double kilosMes) {
		this.kilosMes = kilosMes;
	}


	public double getPromedio() {
		return this.promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}


	public double getVplexus() {
		return this.vplexus;
	}

	public void setVplexus(double vplexus) {
		this.vplexus = vplexus;
	}


	public double getVsinapsis() {
		return this.vsinapsis;
	}

	public void setVsinapsis(double vsinapsis) {
		this.vsinapsis = vsinapsis;
	}


	//bi-directional many-to-one association to EvolutionPlexusEstandarParametro
	@ManyToOne
	@JoinColumn(name="idevolutionplexusestandar")
	public EvolutionPlexusEstandarParametro getEvolutionPlexusEstandarParametro() {
		return this.evolutionPlexusEstandarParametro;
	}

	public void setEvolutionPlexusEstandarParametro(EvolutionPlexusEstandarParametro evolutionPlexusEstandarParametro) {
		this.evolutionPlexusEstandarParametro = evolutionPlexusEstandarParametro;
	}


	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
	}


	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}