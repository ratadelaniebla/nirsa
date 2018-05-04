package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evolution_plexus_parametros_tarifas_pesos_limpieza database table.
 * 
 */
@Entity
@Table(name="evolution_plexus_parametros_tarifas_pesos_limpieza")
@NamedQuery(name="EvolutionPlexusParametrosTarifasPesosLimpieza.findAll", query="SELECT e FROM EvolutionPlexusParametrosTarifasPesosLimpieza e")
public class EvolutionPlexusParametrosTarifasPesosLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevolutionplexusparametrostarifaspesos;
	private Integer diasMes;
	private Boolean estado;
	private Integer horasDiarias;
	private double incremento100;
	private double incremento110;
	private double incremento80;
	private double incremento90;
	private double sueldoBasico;
	private double sueldoDia;
	private String unidad;
	private EvolutionOrdenProduccion evolutionOrdenProduccion;
	private EvolutionPeriodoPago evolutionPeriodoPago;

	public EvolutionPlexusParametrosTarifasPesosLimpieza() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevolutionplexusparametrostarifaspesos() {
		return this.idevolutionplexusparametrostarifaspesos;
	}

	public void setIdevolutionplexusparametrostarifaspesos(Long idevolutionplexusparametrostarifaspesos) {
		this.idevolutionplexusparametrostarifaspesos = idevolutionplexusparametrostarifaspesos;
	}


	@Column(name="dias_mes")
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


	@Column(name="horas_diarias")
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


	@Column(name="sueldo_basico")
	public double getSueldoBasico() {
		return this.sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}


	@Column(name="sueldo_dia")
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


	//bi-directional many-to-one association to EvolutionOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idevolutionordenproduccion")
	public EvolutionOrdenProduccion getEvolutionOrdenProduccion() {
		return this.evolutionOrdenProduccion;
	}

	public void setEvolutionOrdenProduccion(EvolutionOrdenProduccion evolutionOrdenProduccion) {
		this.evolutionOrdenProduccion = evolutionOrdenProduccion;
	}


	//bi-directional many-to-one association to EvolutionPeriodoPago
	@ManyToOne
	@JoinColumn(name="idevolutionperiodopago")
	public EvolutionPeriodoPago getEvolutionPeriodoPago() {
		return this.evolutionPeriodoPago;
	}

	public void setEvolutionPeriodoPago(EvolutionPeriodoPago evolutionPeriodoPago) {
		this.evolutionPeriodoPago = evolutionPeriodoPago;
	}

}