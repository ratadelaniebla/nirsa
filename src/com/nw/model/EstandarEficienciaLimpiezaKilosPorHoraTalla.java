package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_eficiencia_limpieza_kilos_por_hora_talla database table.
 * 
 */
@Entity
@Table(name="estandar_eficiencia_limpieza_kilos_por_hora_talla")
public class EstandarEficienciaLimpiezaKilosPorHoraTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idestandareficiencialimpiezakilosporhoratalla;

	private double kghorapersona;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EstandarEficienciaLimpiezaKilosPorHoraTalla() {
	}

	public Long getIdestandareficiencialimpiezakilosporhoratalla() {
		return this.idestandareficiencialimpiezakilosporhoratalla;
	}

	public void setIdestandareficiencialimpiezakilosporhoratalla(Long idestandareficiencialimpiezakilosporhoratalla) {
		this.idestandareficiencialimpiezakilosporhoratalla = idestandareficiencialimpiezakilosporhoratalla;
	}

	public double getKghorapersona() {
		return this.kghorapersona;
	}

	public void setKghorapersona(double kghorapersona) {
		this.kghorapersona = kghorapersona;
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