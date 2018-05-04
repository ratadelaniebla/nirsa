package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the luthy_maquina_cerradora_estandar database table.
 * 
 */
@Entity
@Table(name="luthy_maquina_cerradora_estandar")
@NamedQuery(name="LuthyMaquinaCerradoraEstandar.findAll", query="SELECT l FROM LuthyMaquinaCerradoraEstandar l")
public class LuthyMaquinaCerradoraEstandar implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idLuthyMaquinaCerradoraEstandar;
	private double aprovechamiento;
	private Integer numeroMaquinasLlenadoras;
	private Integer velocidadMaxima;
	private Integer velocidadNominal;
	private CantidadLibra cantidadLibra;
	private Luthy luthy;
	private MaquinaCerradora maquinaCerradora;

	public LuthyMaquinaCerradoraEstandar() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_luthy_maquina_cerradora_estandar")
	public Integer getIdLuthyMaquinaCerradoraEstandar() {
		return this.idLuthyMaquinaCerradoraEstandar;
	}

	public void setIdLuthyMaquinaCerradoraEstandar(Integer idLuthyMaquinaCerradoraEstandar) {
		this.idLuthyMaquinaCerradoraEstandar = idLuthyMaquinaCerradoraEstandar;
	}


	public double getAprovechamiento() {
		return this.aprovechamiento;
	}

	public void setAprovechamiento(double aprovechamiento) {
		this.aprovechamiento = aprovechamiento;
	}


	@Column(name="numero_maquinas_llenadoras")
	public Integer getNumeroMaquinasLlenadoras() {
		return this.numeroMaquinasLlenadoras;
	}

	public void setNumeroMaquinasLlenadoras(Integer numeroMaquinasLlenadoras) {
		this.numeroMaquinasLlenadoras = numeroMaquinasLlenadoras;
	}


	@Column(name="velocidad_maxima")
	public Integer getVelocidadMaxima() {
		return this.velocidadMaxima;
	}

	public void setVelocidadMaxima(Integer velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}


	@Column(name="velocidad_nominal")
	public Integer getVelocidadNominal() {
		return this.velocidadNominal;
	}

	public void setVelocidadNominal(Integer velocidadNominal) {
		this.velocidadNominal = velocidadNominal;
	}


	//bi-directional many-to-one association to CantidadLibra
	@ManyToOne
	@JoinColumn(name="idcantidadlibras")
	public CantidadLibra getCantidadLibra() {
		return this.cantidadLibra;
	}

	public void setCantidadLibra(CantidadLibra cantidadLibra) {
		this.cantidadLibra = cantidadLibra;
	}


	//bi-directional many-to-one association to Luthy
	@ManyToOne
	@JoinColumn(name="idluthy")
	public Luthy getLuthy() {
		return this.luthy;
	}

	public void setLuthy(Luthy luthy) {
		this.luthy = luthy;
	}


	//bi-directional many-to-one association to MaquinaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
	}

}