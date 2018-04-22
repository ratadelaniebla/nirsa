package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the estandar_eficiencia_kilos_plexus database table.
 * 
 */
@Entity
@Table(name="estandar_eficiencia_kilos_plexus")
public class EstandarEficienciaKilosPlexus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandareficienciakilosplexus;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPlexus
	@OneToMany(mappedBy="estandarEficienciaKilosPlexus")
	private List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariocierre")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioapertura")
	private Usuario usuario2;

	public EstandarEficienciaKilosPlexus() {
	}

	public Integer getIdestandareficienciakilosplexus() {
		return this.idestandareficienciakilosplexus;
	}

	public void setIdestandareficienciakilosplexus(Integer idestandareficienciakilosplexus) {
		this.idestandareficienciakilosplexus = idestandareficienciakilosplexus;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public List<EstandarDetalleEficienciaKilosPlexus> getEstandarDetalleEficienciaKilosPlexuses() {
		return this.estandarDetalleEficienciaKilosPlexuses;
	}

	public void setEstandarDetalleEficienciaKilosPlexuses(List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses) {
		this.estandarDetalleEficienciaKilosPlexuses = estandarDetalleEficienciaKilosPlexuses;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}