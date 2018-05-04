package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_detalle_eficiencia_kilos_pago_plexus database table.
 * 
 */
@Entity
@Table(name="estandar_detalle_eficiencia_kilos_pago_plexus")
@NamedQuery(name="EstandarDetalleEficienciaKilosPagoPlexus.findAll", query="SELECT e FROM EstandarDetalleEficienciaKilosPagoPlexus e")
public class EstandarDetalleEficienciaKilosPagoPlexus implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandardetalleeficienciakilospagoplexus;
	private double costo;
	private double eficiencia;
	private double eficienciames;
	private double porceficiencia;
	private double porcincentivo;
	private EstandarEficienciaKilosPagoPlexus estandarEficienciaKilosPagoPlexus;
	private LimpiezaTipo limpiezaTipo;
	private Talla talla;

	public EstandarDetalleEficienciaKilosPagoPlexus() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EstandarEficienciaKilosPagoPlexus
	@ManyToOne
	@JoinColumn(name="idestandareficienciakilospagoplexus")
	public EstandarEficienciaKilosPagoPlexus getEstandarEficienciaKilosPagoPlexus() {
		return this.estandarEficienciaKilosPagoPlexus;
	}

	public void setEstandarEficienciaKilosPagoPlexus(EstandarEficienciaKilosPagoPlexus estandarEficienciaKilosPagoPlexus) {
		this.estandarEficienciaKilosPagoPlexus = estandarEficienciaKilosPagoPlexus;
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