package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_clasificacion_talla_plexus database table.
 * 
 */
@Entity
@Table(name="estandar_clasificacion_talla_plexus")
@NamedQuery(name="EstandarClasificacionTallaPlexus.findAll", query="SELECT e FROM EstandarClasificacionTallaPlexus e")
public class EstandarClasificacionTallaPlexus implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandarclasificaciontallaplexus;
	private EvisceradoPescadosLata evisceradoPescadosLata;
	private Talla talla;

	public EstandarClasificacionTallaPlexus() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandarclasificaciontallaplexus() {
		return this.idestandarclasificaciontallaplexus;
	}

	public void setIdestandarclasificaciontallaplexus(Integer idestandarclasificaciontallaplexus) {
		this.idestandarclasificaciontallaplexus = idestandarclasificaciontallaplexus;
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