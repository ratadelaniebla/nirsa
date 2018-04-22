package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cantidad_libras database table.
 * 
 */
@Entity
@Table(name="cantidad_libras")
public class CantidadLibra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcantidadlibras;

	private String descripcion;

	@Column(name="peso_gramos")
	private double pesoGramos;

	//bi-directional many-to-one association to LuthyMaquinaCerradoraEstandar
	@OneToMany(mappedBy="cantidadLibra")
	private List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars;

	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@OneToMany(mappedBy="cantidadLibra")
	private List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;

	public CantidadLibra() {
	}

	public Integer getIdcantidadlibras() {
		return this.idcantidadlibras;
	}

	public void setIdcantidadlibras(Integer idcantidadlibras) {
		this.idcantidadlibras = idcantidadlibras;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPesoGramos() {
		return this.pesoGramos;
	}

	public void setPesoGramos(double pesoGramos) {
		this.pesoGramos = pesoGramos;
	}

	public List<LuthyMaquinaCerradoraEstandar> getLuthyMaquinaCerradoraEstandars() {
		return this.luthyMaquinaCerradoraEstandars;
	}

	public void setLuthyMaquinaCerradoraEstandars(List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars) {
		this.luthyMaquinaCerradoraEstandars = luthyMaquinaCerradoraEstandars;
	}

	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradoras(List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras = oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

}