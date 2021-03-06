package com.nw.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the envasado_control_peso_fill_cabecera database table.
 * 
 */
@Entity
@Table(name="envasado_control_peso_fill_cabecera")
@NamedQuery(name="EnvasadoControlPesoFillCabecera.findAll", query="SELECT e FROM EnvasadoControlPesoFillCabecera e")
public class EnvasadoControlPesoFillCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadocontrolpesofillcabecera;
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
	private EnvasadoLineaCerradora envasadoLineaCerradora;
	private EnvasadoProceso envasadoProceso;
	private ProduccionDetalleOrden produccionDetalleOrden;
	private Turno turno;
	private Usuario usuario;
	private List<EnvasadoControlPesoFillDetalle> envasadoControlPesoFillDetalles;
	private Luthy luthy;
	private double tara;
	
	public EnvasadoControlPesoFillCabecera() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadocontrolpesofillcabecera() {
		return this.idenvasadocontrolpesofillcabecera;
	}

	public void setIdenvasadocontrolpesofillcabecera(Long idenvasadocontrolpesofillcabecera) {
		this.idenvasadocontrolpesofillcabecera = idenvasadocontrolpesofillcabecera;
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
	@JoinColumn(name="idenvasadolineacerradora")
	public EnvasadoLineaCerradora getEnvasadoLineaCerradora() {
		return this.envasadoLineaCerradora;
	}

	public void setEnvasadoLineaCerradora(EnvasadoLineaCerradora envasadoLineaCerradora) {
		this.envasadoLineaCerradora = envasadoLineaCerradora;
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


	//bi-directional many-to-one association to EnvasadoControlPesoFillDetalle
	@OneToMany(mappedBy="envasadoControlPesoFillCabecera")
	public List<EnvasadoControlPesoFillDetalle> getEnvasadoControlPesoFillDetalles() {
		return this.envasadoControlPesoFillDetalles;
	}

	public void setEnvasadoControlPesoFillDetalles(List<EnvasadoControlPesoFillDetalle> envasadoControlPesoFillDetalles) {
		this.envasadoControlPesoFillDetalles = envasadoControlPesoFillDetalles;
	}

	public EnvasadoControlPesoFillDetalle addEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle) {
		getEnvasadoControlPesoFillDetalles().add(envasadoControlPesoFillDetalle);
		envasadoControlPesoFillDetalle.setEnvasadoControlPesoFillCabecera(this);

		return envasadoControlPesoFillDetalle;
	}

	public EnvasadoControlPesoFillDetalle removeEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle) {
		getEnvasadoControlPesoFillDetalles().remove(envasadoControlPesoFillDetalle);
		envasadoControlPesoFillDetalle.setEnvasadoControlPesoFillCabecera(null);

		return envasadoControlPesoFillDetalle;
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


	public double getTara() {
		return tara;
	}


	public void setTara(double tara) {
		this.tara = tara;
	}

	
	
}