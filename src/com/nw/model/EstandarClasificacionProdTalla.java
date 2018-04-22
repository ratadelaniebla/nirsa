package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_clasificacion_prod_talla database table.
 * 
 */
@Entity
@Table(name="estandar_clasificacion_prod_talla")
public class EstandarClasificacionProdTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandarclasificacionprodtalla;

	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	private EvisceradoPescadosLata evisceradoPescadosLata;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EstandarClasificacionProdTalla() {
	}

	public Integer getIdestandarclasificacionprodtalla() {
		return this.idestandarclasificacionprodtalla;
	}

	public void setIdestandarclasificacionprodtalla(Integer idestandarclasificacionprodtalla) {
		this.idestandarclasificacionprodtalla = idestandarclasificacionprodtalla;
	}

	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
	}

	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}