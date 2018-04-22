package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the luthy database table.
 * 
 */
@Entity
public class Luthy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idluthy;

	private Integer estado;

	private Integer numeroluthy;

	//bi-directional many-to-one association to LuthyMaquinaCerradoraEstandar
	@OneToMany(mappedBy="luthy")
	private List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars;

	//bi-directional many-to-one association to OeeDetalleMediosConDefectoEnvasado
	@OneToMany(mappedBy="luthy")
	private List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados;

	//bi-directional many-to-one association to OeeEnvasadoDetalleVelocidadMaquinaCerradora
	@OneToMany(mappedBy="luthy")
	private List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras;

	public Luthy() {
	}

	public Integer getIdluthy() {
		return this.idluthy;
	}

	public void setIdluthy(Integer idluthy) {
		this.idluthy = idluthy;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getNumeroluthy() {
		return this.numeroluthy;
	}

	public void setNumeroluthy(Integer numeroluthy) {
		this.numeroluthy = numeroluthy;
	}

	public List<LuthyMaquinaCerradoraEstandar> getLuthyMaquinaCerradoraEstandars() {
		return this.luthyMaquinaCerradoraEstandars;
	}

	public void setLuthyMaquinaCerradoraEstandars(List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars) {
		this.luthyMaquinaCerradoraEstandars = luthyMaquinaCerradoraEstandars;
	}

	public List<OeeDetalleMediosConDefectoEnvasado> getOeeDetalleMediosConDefectoEnvasados() {
		return this.oeeDetalleMediosConDefectoEnvasados;
	}

	public void setOeeDetalleMediosConDefectoEnvasados(List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados) {
		this.oeeDetalleMediosConDefectoEnvasados = oeeDetalleMediosConDefectoEnvasados;
	}

	public List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoDetalleVelocidadMaquinaCerradoras(List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras = oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

}