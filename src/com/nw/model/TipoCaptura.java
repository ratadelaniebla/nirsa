package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_captura database table.
 * 
 */
@Entity
@Table(name="tipo_captura")
@NamedQuery(name="TipoCaptura.findAll", query="SELECT t FROM TipoCaptura t")
public class TipoCaptura implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idtipocaptura;
	private String descripcion;
	private List<CamaraCajon> camaraCajons;

	public TipoCaptura() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getIdtipocaptura() {
		return this.idtipocaptura;
	}

	public void setIdtipocaptura(String idtipocaptura) {
		this.idtipocaptura = idtipocaptura;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="tipoCaptura")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setTipoCaptura(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setTipoCaptura(null);

		return camaraCajon;
	}

}