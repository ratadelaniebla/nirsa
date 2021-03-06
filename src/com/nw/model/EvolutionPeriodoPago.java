package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the evolution_periodo_pago database table.
 * 
 */
@Entity
@Table(name="evolution_periodo_pago")
@NamedQuery(name="EvolutionPeriodoPago.findAll", query="SELECT e FROM EvolutionPeriodoPago e")
public class EvolutionPeriodoPago implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevolutionperiodopago;
	private Integer anio;
	private Boolean estado;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer mes;
	private List<EvolutionPlexusParametrosTarifasPesosLimpieza> evolutionPlexusParametrosTarifasPesosLimpiezas;

	public EvolutionPeriodoPago() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevolutionperiodopago() {
		return this.idevolutionperiodopago;
	}

	public void setIdevolutionperiodopago(Long idevolutionperiodopago) {
		this.idevolutionperiodopago = idevolutionperiodopago;
	}


	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}


	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_desde")
	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hasta")
	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}


	//bi-directional many-to-one association to EvolutionPlexusParametrosTarifasPesosLimpieza
	@OneToMany(mappedBy="evolutionPeriodoPago")
	public List<EvolutionPlexusParametrosTarifasPesosLimpieza> getEvolutionPlexusParametrosTarifasPesosLimpiezas() {
		return this.evolutionPlexusParametrosTarifasPesosLimpiezas;
	}

	public void setEvolutionPlexusParametrosTarifasPesosLimpiezas(List<EvolutionPlexusParametrosTarifasPesosLimpieza> evolutionPlexusParametrosTarifasPesosLimpiezas) {
		this.evolutionPlexusParametrosTarifasPesosLimpiezas = evolutionPlexusParametrosTarifasPesosLimpiezas;
	}

	public EvolutionPlexusParametrosTarifasPesosLimpieza addEvolutionPlexusParametrosTarifasPesosLimpieza(EvolutionPlexusParametrosTarifasPesosLimpieza evolutionPlexusParametrosTarifasPesosLimpieza) {
		getEvolutionPlexusParametrosTarifasPesosLimpiezas().add(evolutionPlexusParametrosTarifasPesosLimpieza);
		evolutionPlexusParametrosTarifasPesosLimpieza.setEvolutionPeriodoPago(this);

		return evolutionPlexusParametrosTarifasPesosLimpieza;
	}

	public EvolutionPlexusParametrosTarifasPesosLimpieza removeEvolutionPlexusParametrosTarifasPesosLimpieza(EvolutionPlexusParametrosTarifasPesosLimpieza evolutionPlexusParametrosTarifasPesosLimpieza) {
		getEvolutionPlexusParametrosTarifasPesosLimpiezas().remove(evolutionPlexusParametrosTarifasPesosLimpieza);
		evolutionPlexusParametrosTarifasPesosLimpieza.setEvolutionPeriodoPago(null);

		return evolutionPlexusParametrosTarifasPesosLimpieza;
	}

}