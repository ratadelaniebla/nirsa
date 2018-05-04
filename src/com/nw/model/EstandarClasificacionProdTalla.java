package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_clasificacion_prod_talla database table.
 * 
 */
@Entity
@Table(name="estandar_clasificacion_prod_talla")
@NamedQuery(name="EstandarClasificacionProdTalla.findAll", query="SELECT e FROM EstandarClasificacionProdTalla e")
public class EstandarClasificacionProdTalla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandarclasificacionprodtalla;
	private EvisceradoPescadosLata evisceradoPescadosLata;
	private Talla talla;

	public EstandarClasificacionProdTalla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandarclasificacionprodtalla() {
		return this.idestandarclasificacionprodtalla;
	}

	public void setIdestandarclasificacionprodtalla(Integer idestandarclasificacionprodtalla) {
		this.idestandarclasificacionprodtalla = idestandarclasificacionprodtalla;
	}


	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
	}


	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}