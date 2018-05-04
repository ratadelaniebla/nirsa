package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the estandar_eficiencia_kilos_pago_plexus database table.
 * 
 */
@Entity
@Table(name="estandar_eficiencia_kilos_pago_plexus")
@NamedQuery(name="EstandarEficienciaKilosPagoPlexus.findAll", query="SELECT e FROM EstandarEficienciaKilosPagoPlexus e")
public class EstandarEficienciaKilosPagoPlexus implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandareficienciakilospagoplexus;
	private Integer estado;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses;
	private Usuario usuario1;
	private Usuario usuario2;

	public EstandarEficienciaKilosPagoPlexus() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandareficienciakilospagoplexus() {
		return this.idestandareficienciakilospagoplexus;
	}

	public void setIdestandareficienciakilospagoplexus(Integer idestandareficienciakilospagoplexus) {
		this.idestandareficienciakilospagoplexus = idestandareficienciakilospagoplexus;
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


	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="estandarEficienciaKilosPagoPlexus")
	public List<EstandarDetalleEficienciaKilosPagoPlexus> getEstandarDetalleEficienciaKilosPagoPlexuses() {
		return this.estandarDetalleEficienciaKilosPagoPlexuses;
	}

	public void setEstandarDetalleEficienciaKilosPagoPlexuses(List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses) {
		this.estandarDetalleEficienciaKilosPagoPlexuses = estandarDetalleEficienciaKilosPagoPlexuses;
	}

	public EstandarDetalleEficienciaKilosPagoPlexus addEstandarDetalleEficienciaKilosPagoPlexus(EstandarDetalleEficienciaKilosPagoPlexus estandarDetalleEficienciaKilosPagoPlexus) {
		getEstandarDetalleEficienciaKilosPagoPlexuses().add(estandarDetalleEficienciaKilosPagoPlexus);
		estandarDetalleEficienciaKilosPagoPlexus.setEstandarEficienciaKilosPagoPlexus(this);

		return estandarDetalleEficienciaKilosPagoPlexus;
	}

	public EstandarDetalleEficienciaKilosPagoPlexus removeEstandarDetalleEficienciaKilosPagoPlexus(EstandarDetalleEficienciaKilosPagoPlexus estandarDetalleEficienciaKilosPagoPlexus) {
		getEstandarDetalleEficienciaKilosPagoPlexuses().remove(estandarDetalleEficienciaKilosPagoPlexus);
		estandarDetalleEficienciaKilosPagoPlexus.setEstandarEficienciaKilosPagoPlexus(null);

		return estandarDetalleEficienciaKilosPagoPlexus;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioapertura")
	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariocierre")
	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}