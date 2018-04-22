package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evolution_plexus_parametros_tarifas_pesos_limpieza database table.
 * 
 */
@Entity
@Table(name="evolution_plexus_parametros_tarifas_pesos_limpieza")
public class EvolutionPlexusParametrosTarifasPesosLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevolutionplexusparametrostarifaspesos;

	@Column(name="dias_mes")
	private Integer diasMes;

	private Boolean estado;

	@Column(name="horas_diarias")
	private Integer horasDiarias;

	private double incremento100;

	private double incremento110;

	private double incremento80;

	private double incremento90;

	@Column(name="sueldo_basico")
	private double sueldoBasico;

	@Column(name="sueldo_dia")
	private double sueldoDia;

	private String unidad;

	//bi-directional many-to-one association to EvolutionOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idevolutionordenproduccion")
	private EvolutionOrdenProduccion evolutionOrdenProduccion;

	//bi-directional many-to-one association to EvolutionPeriodoPago
	@ManyToOne
	@JoinColumn(name="idevolutionperiodopago")
	private EvolutionPeriodoPago evolutionPeriodoPago;

	public EvolutionPlexusParametrosTarifasPesosLimpieza() {
	}

	public Long getIdevolutionplexusparametrostarifaspesos() {
		return this.idevolutionplexusparametrostarifaspesos;
	}

	public void setIdevolutionplexusparametrostarifaspesos(Long idevolutionplexusparametrostarifaspesos) {
		this.idevolutionplexusparametrostarifaspesos = idevolutionplexusparametrostarifaspesos;
	}

	public Integer getDiasMes() {
		return this.diasMes;
	}

	public void setDiasMes(Integer diasMes) {
		this.diasMes = diasMes;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getHorasDiarias() {
		return this.horasDiarias;
	}

	public void setHorasDiarias(Integer horasDiarias) {
		this.horasDiarias = horasDiarias;
	}

	public double getIncremento100() {
		return this.incremento100;
	}

	public void setIncremento100(double incremento100) {
		this.incremento100 = incremento100;
	}

	public double getIncremento110() {
		return this.incremento110;
	}

	public void setIncremento110(double incremento110) {
		this.incremento110 = incremento110;
	}

	public double getIncremento80() {
		return this.incremento80;
	}

	public void setIncremento80(double incremento80) {
		this.incremento80 = incremento80;
	}

	public double getIncremento90() {
		return this.incremento90;
	}

	public void setIncremento90(double incremento90) {
		this.incremento90 = incremento90;
	}

	public double getSueldoBasico() {
		return this.sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public double getSueldoDia() {
		return this.sueldoDia;
	}

	public void setSueldoDia(double sueldoDia) {
		this.sueldoDia = sueldoDia;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public EvolutionOrdenProduccion getEvolutionOrdenProduccion() {
		return this.evolutionOrdenProduccion;
	}

	public void setEvolutionOrdenProduccion(EvolutionOrdenProduccion evolutionOrdenProduccion) {
		this.evolutionOrdenProduccion = evolutionOrdenProduccion;
	}

	public EvolutionPeriodoPago getEvolutionPeriodoPago() {
		return this.evolutionPeriodoPago;
	}

	public void setEvolutionPeriodoPago(EvolutionPeriodoPago evolutionPeriodoPago) {
		this.evolutionPeriodoPago = evolutionPeriodoPago;
	}

}