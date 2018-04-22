package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the luthy_maquina_cerradora_estandar database table.
 * 
 */
@Entity
@Table(name="luthy_maquina_cerradora_estandar")
public class LuthyMaquinaCerradoraEstandar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_luthy_maquina_cerradora_estandar")
	private Integer idLuthyMaquinaCerradoraEstandar;

	private double aprovechamiento;

	@Column(name="numero_maquinas_llenadoras")
	private Integer numeroMaquinasLlenadoras;

	@Column(name="velocidad_maxima")
	private Integer velocidadMaxima;

	@Column(name="velocidad_nominal")
	private Integer velocidadNominal;

	//bi-directional many-to-one association to CantidadLibra
	@ManyToOne
	@JoinColumn(name="idcantidadlibras")
	private CantidadLibra cantidadLibra;

	//bi-directional many-to-one association to Luthy
	@ManyToOne
	@JoinColumn(name="idluthy")
	private Luthy luthy;

	//bi-directional many-to-one association to MaquinaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	private MaquinaCerradora maquinaCerradora;

	public LuthyMaquinaCerradoraEstandar() {
	}

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

	public Integer getNumeroMaquinasLlenadoras() {
		return this.numeroMaquinasLlenadoras;
	}

	public void setNumeroMaquinasLlenadoras(Integer numeroMaquinasLlenadoras) {
		this.numeroMaquinasLlenadoras = numeroMaquinasLlenadoras;
	}

	public Integer getVelocidadMaxima() {
		return this.velocidadMaxima;
	}

	public void setVelocidadMaxima(Integer velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public Integer getVelocidadNominal() {
		return this.velocidadNominal;
	}

	public void setVelocidadNominal(Integer velocidadNominal) {
		this.velocidadNominal = velocidadNominal;
	}

	public CantidadLibra getCantidadLibra() {
		return this.cantidadLibra;
	}

	public void setCantidadLibra(CantidadLibra cantidadLibra) {
		this.cantidadLibra = cantidadLibra;
	}

	public Luthy getLuthy() {
		return this.luthy;
	}

	public void setLuthy(Luthy luthy) {
		this.luthy = luthy;
	}

	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
	}

}