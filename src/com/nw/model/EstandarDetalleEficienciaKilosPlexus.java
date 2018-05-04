package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_detalle_eficiencia_kilos_plexus database table.
 * 
 */
@Entity
@Table(name="estandar_detalle_eficiencia_kilos_plexus")
@NamedQuery(name="EstandarDetalleEficienciaKilosPlexus.findAll", query="SELECT e FROM EstandarDetalleEficienciaKilosPlexus e")
public class EstandarDetalleEficienciaKilosPlexus implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandardetalleeficienciakilosplexus;
	private double eficiencia;
	private EstandarEficienciaKilosPlexus estandarEficienciaKilosPlexus;
	private LimpiezaTipo limpiezaTipo;
	private Talla talla;

	public EstandarDetalleEficienciaKilosPlexus() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EstandarEficienciaKilosPlexus
	@ManyToOne
	@JoinColumn(name="idestandareficienciakilosplexus")
	public EstandarEficienciaKilosPlexus getEstandarEficienciaKilosPlexus() {
		return this.estandarEficienciaKilosPlexus;
	}

	public void setEstandarEficienciaKilosPlexus(EstandarEficienciaKilosPlexus estandarEficienciaKilosPlexus) {
		this.estandarEficienciaKilosPlexus = estandarEficienciaKilosPlexus;
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