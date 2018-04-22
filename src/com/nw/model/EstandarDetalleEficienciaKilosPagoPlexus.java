package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_detalle_eficiencia_kilos_pago_plexus database table.
 * 
 */
@Entity
@Table(name="estandar_detalle_eficiencia_kilos_pago_plexus")
public class EstandarDetalleEficienciaKilosPagoPlexus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandardetalleeficienciakilospagoplexus;

	private double costo;

	private double eficiencia;

	private double eficienciames;

	private double porceficiencia;

	private double porcincentivo;

	//bi-directional many-to-one association to EstandarEficienciaKilosPagoPlexus
	@ManyToOne
	@JoinColumn(name="idestandareficienciakilospagoplexus")
	private EstandarEficienciaKilosPagoPlexus estandarEficienciaKilosPagoPlexus;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EstandarDetalleEficienciaKilosPagoPlexus() {
	}

	public Integer getIdestandardetalleeficienciakilospagoplexus() {
		return this.idestandardetalleeficienciakilospagoplexus;
	}

	public void setIdestandardetalleeficienciakilospagoplexus(Integer idestandardetalleeficienciakilospagoplexus) {
		this.idestandardetalleeficienciakilospagoplexus = idestandardetalleeficienciakilospagoplexus;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getEficiencia() {
		return this.eficiencia;
	}

	public void setEficiencia(double eficiencia) {
		this.eficiencia = eficiencia;
	}

	public double getEficienciames() {
		return this.eficienciames;
	}

	public void setEficienciames(double eficienciames) {
		this.eficienciames = eficienciames;
	}

	public double getPorceficiencia() {
		return this.porceficiencia;
	}

	public void setPorceficiencia(double porceficiencia) {
		this.porceficiencia = porceficiencia;
	}

	public double getPorcincentivo() {
		return this.porcincentivo;
	}

	public void setPorcincentivo(double porcincentivo) {
		this.porcincentivo = porcincentivo;
	}

	public EstandarEficienciaKilosPagoPlexus getEstandarEficienciaKilosPagoPlexus() {
		return this.estandarEficienciaKilosPagoPlexus;
	}

	public void setEstandarEficienciaKilosPagoPlexus(EstandarEficienciaKilosPagoPlexus estandarEficienciaKilosPagoPlexus) {
		this.estandarEficienciaKilosPagoPlexus = estandarEficienciaKilosPagoPlexus;
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