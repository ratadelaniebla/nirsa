package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_detalle_eficiencia_kilos_plexus database table.
 * 
 */
@Entity
@Table(name="estandar_detalle_eficiencia_kilos_plexus")
public class EstandarDetalleEficienciaKilosPlexus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandardetalleeficienciakilosplexus;

	private double eficiencia;

	//bi-directional many-to-one association to EstandarEficienciaKilosPlexus
	@ManyToOne
	@JoinColumn(name="idestandareficienciakilosplexus")
	private EstandarEficienciaKilosPlexus estandarEficienciaKilosPlexus;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EstandarDetalleEficienciaKilosPlexus() {
	}

	public Integer getIdestandardetalleeficienciakilosplexus() {
		return this.idestandardetalleeficienciakilosplexus;
	}

	public void setIdestandardetalleeficienciakilosplexus(Integer idestandardetalleeficienciakilosplexus) {
		this.idestandardetalleeficienciakilosplexus = idestandardetalleeficienciakilosplexus;
	}

	public double getEficiencia() {
		return this.eficiencia;
	}

	public void setEficiencia(double eficiencia) {
		this.eficiencia = eficiencia;
	}

	public EstandarEficienciaKilosPlexus getEstandarEficienciaKilosPlexus() {
		return this.estandarEficienciaKilosPlexus;
	}

	public void setEstandarEficienciaKilosPlexus(EstandarEficienciaKilosPlexus estandarEficienciaKilosPlexus) {
		this.estandarEficienciaKilosPlexus = estandarEficienciaKilosPlexus;
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