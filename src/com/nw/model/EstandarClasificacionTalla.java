package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_clasificacion_talla database table.
 * 
 */
@Entity
@Table(name="estandar_clasificacion_talla")
@NamedQuery(name="EstandarClasificacionTalla.findAll", query="SELECT e FROM EstandarClasificacionTalla e")
public class EstandarClasificacionTalla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandarclasificaciontalla;
	private EvisceradoPescadosLata evisceradoPescadosLata;
	private Talla talla;

	public EstandarClasificacionTalla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandarclasificaciontalla() {
		return this.idestandarclasificaciontalla;
	}

	public void setIdestandarclasificaciontalla(Integer idestandarclasificaciontalla) {
		this.idestandarclasificaciontalla = idestandarclasificaciontalla;
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