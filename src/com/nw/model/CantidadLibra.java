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
@NamedQuery(name="CantidadLibra.findAll", query="SELECT c FROM CantidadLibra c")
public class CantidadLibra implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcantidadlibras;
	private String descripcion;
	private double pesoGramos;
	private List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars;
	private List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;

	public CantidadLibra() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="peso_gramos")
	public double getPesoGramos() {
		return this.pesoGramos;
	}

	public void setPesoGramos(double pesoGramos) {
		this.pesoGramos = pesoGramos;
	}


	//bi-directional many-to-one association to LuthyMaquinaCerradoraEstandar
	@OneToMany(mappedBy="cantidadLibra")
	public List<LuthyMaquinaCerradoraEstandar> getLuthyMaquinaCerradoraEstandars() {
		return this.luthyMaquinaCerradoraEstandars;
	}

	public void setLuthyMaquinaCerradoraEstandars(List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars) {
		this.luthyMaquinaCerradoraEstandars = luthyMaquinaCerradoraEstandars;
	}

	public LuthyMaquinaCerradoraEstandar addLuthyMaquinaCerradoraEstandar(LuthyMaquinaCerradoraEstandar luthyMaquinaCerradoraEstandar) {
		getLuthyMaquinaCerradoraEstandars().add(luthyMaquinaCerradoraEstandar);
		luthyMaquinaCerradoraEstandar.setCantidadLibra(this);

		return luthyMaquinaCerradoraEstandar;
	}

	public LuthyMaquinaCerradoraEstandar removeLuthyMaquinaCerradoraEstandar(LuthyMaquinaCerradoraEstandar luthyMaquinaCerradoraEstandar) {
		getLuthyMaquinaCerradoraEstandars().remove(luthyMaquinaCerradoraEstandar);
		luthyMaquinaCerradoraEstandar.setCantidadLibra(null);

		return luthyMaquinaCerradoraEstandar;
	}


	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@OneToMany(mappedBy="cantidadLibra")
	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradoras(List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras = oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora addOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras().add(oeeEnvasadoCabeceraVelocidadMaquinaCerradora);
		oeeEnvasadoCabeceraVelocidadMaquinaCerradora.setCantidadLibra(this);

		return oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora removeOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras().remove(oeeEnvasadoCabeceraVelocidadMaquinaCerradora);
		oeeEnvasadoCabeceraVelocidadMaquinaCerradora.setCantidadLibra(null);

		return oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

}