package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the evolution_auditoria_detalle database table.
 * 
 */
@Entity
@Table(name="evolution_auditoria_detalle")
@NamedQuery(name="EvolutionAuditoriaDetalle.findAll", query="SELECT e FROM EvolutionAuditoriaDetalle e")
public class EvolutionAuditoriaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevolutionauditoriadetalle;
	private Integer area;
	private String cedula;
	private String codccosto;
	private String codproceso;
	private String codproducto;
	private String codtalla;
	private Timestamp fechadesde;
	private String fechaenvio;
	private Timestamp fechahasta;
	private Integer idevolutionauditoria;
	private Integer idpeso;
	private String ordenproduccion;
	private String unidad;
	private double valor;
	private Produccion produccion;
	private Usuario usuario;

	public EvolutionAuditoriaDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevolutionauditoriadetalle() {
		return this.idevolutionauditoriadetalle;
	}

	public void setIdevolutionauditoriadetalle(Long idevolutionauditoriadetalle) {
		this.idevolutionauditoriadetalle = idevolutionauditoriadetalle;
	}


	public Integer getArea() {
		return this.area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}


	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getCodccosto() {
		return this.codccosto;
	}

	public void setCodccosto(String codccosto) {
		this.codccosto = codccosto;
	}


	public String getCodproceso() {
		return this.codproceso;
	}

	public void setCodproceso(String codproceso) {
		this.codproceso = codproceso;
	}


	public String getCodproducto() {
		return this.codproducto;
	}

	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
	}


	public String getCodtalla() {
		return this.codtalla;
	}

	public void setCodtalla(String codtalla) {
		this.codtalla = codtalla;
	}


	public Timestamp getFechadesde() {
		return this.fechadesde;
	}

	public void setFechadesde(Timestamp fechadesde) {
		this.fechadesde = fechadesde;
	}


	public String getFechaenvio() {
		return this.fechaenvio;
	}

	public void setFechaenvio(String fechaenvio) {
		this.fechaenvio = fechaenvio;
	}


	public Timestamp getFechahasta() {
		return this.fechahasta;
	}

	public void setFechahasta(Timestamp fechahasta) {
		this.fechahasta = fechahasta;
	}


	public Integer getIdevolutionauditoria() {
		return this.idevolutionauditoria;
	}

	public void setIdevolutionauditoria(Integer idevolutionauditoria) {
		this.idevolutionauditoria = idevolutionauditoria;
	}


	public Integer getIdpeso() {
		return this.idpeso;
	}

	public void setIdpeso(Integer idpeso) {
		this.idpeso = idpeso;
	}


	public String getOrdenproduccion() {
		return this.ordenproduccion;
	}

	public void setOrdenproduccion(String ordenproduccion) {
		this.ordenproduccion = ordenproduccion;
	}


	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
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