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
public class TipoCaptura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idtipocaptura;

	private String descripcion;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="tipoCaptura")
	private List<CamaraCajon> camaraCajons;

	public TipoCaptura() {
	}

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

	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

}