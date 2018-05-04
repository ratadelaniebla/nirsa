package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_rallado_tipo database table.
 * 
 */
@Entity
@Table(name="limpieza_rallado_tipo")
@NamedQuery(name="LimpiezaRalladoTipo.findAll", query="SELECT l FROM LimpiezaRalladoTipo l")
public class LimpiezaRalladoTipo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezaralladotipo;
	private Boolean almacenarpeso;
	private String descripcion;
	private Boolean produccionanterior;
	private Boolean requierelinea;
	private Boolean requierelote;
	private double tara;
	private double taradobleproposito;
	private List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos;

	public LimpiezaRalladoTipo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlimpiezaralladotipo() {
		return this.idlimpiezaralladotipo;
	}

	public void setIdlimpiezaralladotipo(Integer idlimpiezaralladotipo) {
		this.idlimpiezaralladotipo = idlimpiezaralladotipo;
	}


	public Boolean getAlmacenarpeso() {
		return this.almacenarpeso;
	}

	public void setAlmacenarpeso(Boolean almacenarpeso) {
		this.almacenarpeso = almacenarpeso;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Boolean getProduccionanterior() {
		return this.produccionanterior;
	}

	public void setProduccionanterior(Boolean produccionanterior) {
		this.produccionanterior = produccionanterior;
	}


	public Boolean getRequierelinea() {
		return this.requierelinea;
	}

	public void setRequierelinea(Boolean requierelinea) {
		this.requierelinea = requierelinea;
	}


	public Boolean getRequierelote() {
		return this.requierelote;
	}

	public void setRequierelote(Boolean requierelote) {
		this.requierelote = requierelote;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}


	public double getTaradobleproposito() {
		return this.taradobleproposito;
	}

	public void setTaradobleproposito(double taradobleproposito) {
		this.taradobleproposito = taradobleproposito;
	}


	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@OneToMany(mappedBy="limpiezaRalladoTipo")
	public List<LimpiezaRalladoDetallePeso> getLimpiezaRalladoDetallePesos() {
		return this.limpiezaRalladoDetallePesos;
	}

	public void setLimpiezaRalladoDetallePesos(List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos) {
		this.limpiezaRalladoDetallePesos = limpiezaRalladoDetallePesos;
	}

	public LimpiezaRalladoDetallePeso addLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		getLimpiezaRalladoDetallePesos().add(limpiezaRalladoDetallePeso);
		limpiezaRalladoDetallePeso.setLimpiezaRalladoTipo(this);

		return limpiezaRalladoDetallePeso;
	}

	public LimpiezaRalladoDetallePeso removeLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		getLimpiezaRalladoDetallePesos().remove(limpiezaRalladoDetallePeso);
		limpiezaRalladoDetallePeso.setLimpiezaRalladoTipo(null);

		return limpiezaRalladoDetallePeso;
	}

}