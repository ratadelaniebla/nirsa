package com.nw.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the envasado_ficha_tecnica database table.
 * 
 */
@Entity
@Table(name="envasado_ficha_tecnica")
@NamedQuery(name="EnvasadoFichaTecnica.findAll", query="SELECT e FROM EnvasadoFichaTecnica e")
public class EnvasadoFichaTecnica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadofichatecnica;
	private double aceite;
	private double agua;
	private double caldoVegetal;
	private double concentracion;
	private Timestamp fechareg;
	private double fillPromedio;
	private double fillRango1;
	private double fillRango2;
	private double lomo;
	private String observacion;
	private double pesoNetoFormulado;
	private double rallado;
	private double sal;
	private double densidad;
	private double trozos;
	private String proveedorloteenvase;
	private String proveedorlotetapa;
	private EnvasadoCaldoVegetalProteina envasadoCaldoVegetalProteina;
	private ProduccionDetalleOrden produccionDetalleOrden;
	private EnvasadoProveedorLata envasadoProveedorLata;
	private EnvasadoProveedorTapa envasadoProveedorTapa;
	private Usuario usuario;

	public EnvasadoFichaTecnica() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadofichatecnica() {
		return this.idenvasadofichatecnica;
	}

	public void setIdenvasadofichatecnica(Long idenvasadofichatecnica) {
		this.idenvasadofichatecnica = idenvasadofichatecnica;
	}


	public double getAceite() {
		return this.aceite;
	}

	public void setAceite(double aceite) {
		this.aceite = aceite;
	}


	public double getAgua() {
		return this.agua;
	}

	public void setAgua(double agua) {
		this.agua = agua;
	}


	public double getDensidad() {
		return densidad;
	}

	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}


	@Column(name="caldo_vegetal")
	public double getCaldoVegetal() {
		return this.caldoVegetal;
	}

	public void setCaldoVegetal(double caldoVegetal) {
		this.caldoVegetal = caldoVegetal;
	}


	public double getConcentracion() {
		return this.concentracion;
	}

	public void setConcentracion(double concentracion) {
		this.concentracion = concentracion;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}
	
	@Column(name="fill_promedio")
	public double getFillPromedio() { 
		return fillPromedio;
	}


	public void setFillPromedio(double fillPromedio) {
		this.fillPromedio = fillPromedio;
	}

	@Column(name="fill_rango1")
	public double getFillRango1() {
		return fillRango1;
	}


	public void setFillRango1(double fillRango1) {
		this.fillRango1 = fillRango1;
	}

	@Column(name="fill_rango2")
	public double getFillRango2() {
		return fillRango2;
	}


	public void setFillRango2(double fillRango2) {
		this.fillRango2 = fillRango2;
	}


	public double getLomo() {
		return this.lomo;
	}

	public void setLomo(double lomo) {
		this.lomo = lomo;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	@Column(name="peso_neto_formulado")
	public double getPesoNetoFormulado() {
		return this.pesoNetoFormulado;
	}

	public void setPesoNetoFormulado(double pesoNetoFormulado) {
		this.pesoNetoFormulado = pesoNetoFormulado;
	}


	public double getRallado() {
		return this.rallado;
	}

	public void setRallado(double rallado) {
		this.rallado = rallado;
	}


	public double getSal() {
		return this.sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}


	public double getTrozos() {
		return this.trozos;
	}

	public void setTrozos(double trozos) {
		this.trozos = trozos;
	}
	
	
	public String getProveedorloteenvase() {
		return proveedorloteenvase;
	}


	public void setProveedorloteenvase(String proveedorloteenvase) {
		this.proveedorloteenvase = proveedorloteenvase;
	}


	public String getProveedorlotetapa() {
		return proveedorlotetapa;
	}


	public void setProveedorlotetapa(String proveedorlotetapa) {
		this.proveedorlotetapa = proveedorlotetapa;
	}


	//bi-directional many-to-one association to EnvasadoCaldoVegetalProteina
	@ManyToOne
	@JoinColumn(name="idenvasadocaldovegetalproteina")
	public EnvasadoCaldoVegetalProteina getEnvasadoCaldoVegetalProteina() {
		return this.envasadoCaldoVegetalProteina;
	}

	public void setEnvasadoCaldoVegetalProteina(EnvasadoCaldoVegetalProteina envasadoCaldoVegetalProteina) {
		this.envasadoCaldoVegetalProteina = envasadoCaldoVegetalProteina;
	}


	//bi-directional many-to-one association to ProduccionDetalleOrden
	@ManyToOne
	@JoinColumn(name="idproducciondetalleorden")
	public ProduccionDetalleOrden getProduccionDetalleOrden() {
		return this.produccionDetalleOrden;
	}

	public void setProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		this.produccionDetalleOrden = produccionDetalleOrden;
	}


	//bi-directional many-to-one association to EnvasadoProveedorLata
	@ManyToOne
	@JoinColumn(name="idenvasadoproveedorlatas")
	public EnvasadoProveedorLata getEnvasadoProveedorLata() {
		return this.envasadoProveedorLata;
	}

	public void setEnvasadoProveedorLata(EnvasadoProveedorLata envasadoProveedorLata) {
		this.envasadoProveedorLata = envasadoProveedorLata;
	}


	//bi-directional many-to-one association to EnvasadoProveedorTapa
	@ManyToOne
	@JoinColumn(name="idenvasadoproveedortapa")
	public EnvasadoProveedorTapa getEnvasadoProveedorTapa() {
		return this.envasadoProveedorTapa;
	}

	public void setEnvasadoProveedorTapa(EnvasadoProveedorTapa envasadoProveedorTapa) {
		this.envasadoProveedorTapa = envasadoProveedorTapa;
	}
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}