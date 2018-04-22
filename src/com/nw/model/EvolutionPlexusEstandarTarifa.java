package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evolution_plexus_estandar_tarifa database table.
 * 
 */
@Entity
@Table(name="evolution_plexus_estandar_tarifa")
public class EvolutionPlexusEstandarTarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idevolutionplexusestandartarifa;

	@Column(name="costo_kg")
	private double costoKg;

	@Column(name="diferencia_80")
	private double diferencia80;

	@Column(name="factor_equivalente")
	private double factorEquivalente;

	@Column(name="kilos_mes")
	private double kilosMes;

	private double promedio;

	private double vplexus;

	private double vsinapsis;

	//bi-directional many-to-one association to EvolutionPlexusEstandarParametro
	@ManyToOne
	@JoinColumn(name="idevolutionplexusestandar")
	private EvolutionPlexusEstandarParametro evolutionPlexusEstandarParametro;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EvolutionPlexusEstandarTarifa() {
	}

	public Integer getIdevolutionplexusestandartarifa() {
		return this.idevolutionplexusestandartarifa;
	}

	public void setIdevolutionplexusestandartarifa(Integer idevolutionplexusestandartarifa) {
		this.idevolutionplexusestandartarifa = idevolutionplexusestandartarifa;
	}

	public double getCostoKg() {
		return this.costoKg;
	}

	public void setCostoKg(double costoKg) {
		this.costoKg = costoKg;
	}

	public double getDiferencia80() {
		return this.diferencia80;
	}

	public void setDiferencia80(double diferencia80) {
		this.diferencia80 = diferencia80;
	}

	public double getFactorEquivalente() {
		return this.factorEquivalente;
	}

	public void setFactorEquivalente(double factorEquivalente) {
		this.factorEquivalente = factorEquivalente;
	}

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

	public EvolutionPlexusEstandarParametro getEvolutionPlexusEstandarParametro() {
		return this.evolutionPlexusEstandarParametro;
	}

	public void setEvolutionPlexusEstandarParametro(EvolutionPlexusEstandarParametro evolutionPlexusEstandarParametro) {
		this.evolutionPlexusEstandarParametro = evolutionPlexusEstandarParametro;
	}

	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
	}

	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}