package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the envasado_control_peso_neto_cabecera database table.
 * 
 */
@Entity
@Table(name="envasado_control_peso_neto_cabecera")
@NamedQuery(name="EnvasadoControlPesoNetoCabecera.findAll", query="SELECT e FROM EnvasadoControlPesoNetoCabecera e")
public class EnvasadoControlPesoNetoCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolpesonetocabecera;
	private double aceite;
	private double agua;
	private double caldovegetal;
	private Timestamp fechareg;
	private String observacion;
	private double pesoenvase;
	private double procentajelomos;
	private double procentajerallado;
	private double procentajetrozos;
	private double proteina;
	private EnvasadoCaldoVegetalProteina envasadoCaldoVegetalProteina;
	private MaquinaCerradora maquinaCerradora;
	private EnvasadoProceso envasadoProceso;
	private ProduccionDetalleOrden produccionDetalleOrden;
	private Turno turno;
	private Usuario usuario;
	private List<EnvasadoControlPesoNetoDetalle> envasadoControlPesoNetoDetalles;

	public EnvasadoControlPesoNetoCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadocontrolpesonetocabecera() {
		return this.idenvasadocontrolpesonetocabecera;
	}

	public void setIdenvasadocontrolpesonetocabecera(Long idenvasadocontrolpesonetocabecera) {
		this.idenvasadocontrolpesonetocabecera = idenvasadocontrolpesonetocabecera;
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


	public double getCaldovegetal() {
		return this.caldovegetal;
	}

	public void setCaldovegetal(double caldovegetal) {
		this.caldovegetal = caldovegetal;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public double getPesoenvase() {
		return this.pesoenvase;
	}

	public void setPesoenvase(double pesoenvase) {
		this.pesoenvase = pesoenvase;
	}


	public double getProcentajelomos() {
		return this.procentajelomos;
	}

	public void setProcentajelomos(double procentajelomos) {
		this.procentajelomos = procentajelomos;
	}


	public double getProcentajerallado() {
		return this.procentajerallado;
	}

	public void setProcentajerallado(double procentajerallado) {
		this.procentajerallado = procentajerallado;
	}


	public double getProcentajetrozos() {
		return this.procentajetrozos;
	}

	public void setProcentajetrozos(double procentajetrozos) {
		this.procentajetrozos = procentajetrozos;
	}


	public double getProteina() {
		return this.proteina;
	}

	public void setProteina(double proteina) {
		this.proteina = proteina;
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


	//bi-directional many-to-one association to EnvasadoLineaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@ManyToOne
	@JoinColumn(name="idenvasadoproceso")
	public EnvasadoProceso getEnvasadoProceso() {
		return this.envasadoProceso;
	}

	public void setEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		this.envasadoProceso = envasadoProceso;
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


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturnolabor")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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


	//bi-directional many-to-one association to EnvasadoControlPesoNetoDetalle
	@OneToMany(mappedBy="envasadoControlPesoNetoCabecera")
	public List<EnvasadoControlPesoNetoDetalle> getEnvasadoControlPesoNetoDetalles() {
		return this.envasadoControlPesoNetoDetalles;
	}

	public void setEnvasadoControlPesoNetoDetalles(List<EnvasadoControlPesoNetoDetalle> envasadoControlPesoNetoDetalles) {
		this.envasadoControlPesoNetoDetalles = envasadoControlPesoNetoDetalles;
	}

	public EnvasadoControlPesoNetoDetalle addEnvasadoControlPesoNetoDetalle(EnvasadoControlPesoNetoDetalle envasadoControlPesoNetoDetalle) {
		getEnvasadoControlPesoNetoDetalles().add(envasadoControlPesoNetoDetalle);
		envasadoControlPesoNetoDetalle.setEnvasadoControlPesoNetoCabecera(this);

		return envasadoControlPesoNetoDetalle;
	}

	public EnvasadoControlPesoNetoDetalle removeEnvasadoControlPesoNetoDetalle(EnvasadoControlPesoNetoDetalle envasadoControlPesoNetoDetalle) {
		getEnvasadoControlPesoNetoDetalles().remove(envasadoControlPesoNetoDetalle);
		envasadoControlPesoNetoDetalle.setEnvasadoControlPesoNetoCabecera(null);

		return envasadoControlPesoNetoDetalle;
	}

}