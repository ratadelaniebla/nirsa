package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


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
	private Long idproducciondetalleorden;
	private Integer idturnolabor;
	private String idusuario;
	private String observacion;
	private double pesoenvase;
	private double procentajelomos;
	private double procentajerallado;
	private double procentajetrozos;
	private double proteina;
	private EnvasadoCaldoVegetalProteina envasadoCaldoVegetalProteina;
	private EnvasadoLineaCerradora envasadoLineaCerradora;
	private List<EnvasadoControlPesoFillDetalle> envasadoControlPesoFillDetalles;
	private EnvasadoProceso envasadoProceso;
	private ProduccionDetalleOrden produccionDetalleOrden;

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


	public Long getIdproducciondetalleorden() {
		return this.idproducciondetalleorden;
	}

	public void setIdproducciondetalleorden(Long idproducciondetalleorden) {
		this.idproducciondetalleorden = idproducciondetalleorden;
	}


	public Integer getIdturnolabor() {
		return this.idturnolabor;
	}

	public void setIdturnolabor(Integer idturnolabor) {
		this.idturnolabor = idturnolabor;
	}


	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
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


	//bi-directional many-to-one association to EnvasadoProceso
	@ManyToOne
	@JoinColumn(name="idenvasadoproceso")
	public EnvasadoProceso getEnvasadoProceso() {
		return this.envasadoProceso;
	}

	public void setEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		this.envasadoProceso = envasadoProceso;
	}


	@ManyToOne
	@JoinColumn(name="idproducciondetalleorden")
	public ProduccionDetalleOrden getProduccionDetalleOrden() {
		return produccionDetalleOrden;
	}

	public void setProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		this.produccionDetalleOrden = produccionDetalleOrden;
	}
	
	
	

}