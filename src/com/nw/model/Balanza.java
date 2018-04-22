package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the balanza database table.
 * 
 */
@Entity
public class Balanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbalanza;

	private String descripcionbalanza;

	private Integer estadobalanza;

	private String ipbalanza;

	private String proveedorbalanza;

	private String puertobalanza;

	private String serie;

	private String tiempoesperabalanza;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to GrupoBalanza
	@OneToMany(mappedBy="balanza")
	private List<GrupoBalanza> grupoBalanzas;

	public Balanza() {
	}

	public Integer getIdbalanza() {
		return this.idbalanza;
	}

	public void setIdbalanza(Integer idbalanza) {
		this.idbalanza = idbalanza;
	}

	public String getDescripcionbalanza() {
		return this.descripcionbalanza;
	}

	public void setDescripcionbalanza(String descripcionbalanza) {
		this.descripcionbalanza = descripcionbalanza;
	}

	public Integer getEstadobalanza() {
		return this.estadobalanza;
	}

	public void setEstadobalanza(Integer estadobalanza) {
		this.estadobalanza = estadobalanza;
	}

	public String getIpbalanza() {
		return this.ipbalanza;
	}

	public void setIpbalanza(String ipbalanza) {
		this.ipbalanza = ipbalanza;
	}

	public String getProveedorbalanza() {
		return this.proveedorbalanza;
	}

	public void setProveedorbalanza(String proveedorbalanza) {
		this.proveedorbalanza = proveedorbalanza;
	}

	public String getPuertobalanza() {
		return this.puertobalanza;
	}

	public void setPuertobalanza(String puertobalanza) {
		this.puertobalanza = puertobalanza;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTiempoesperabalanza() {
		return this.tiempoesperabalanza;
	}

	public void setTiempoesperabalanza(String tiempoesperabalanza) {
		this.tiempoesperabalanza = tiempoesperabalanza;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<GrupoBalanza> getGrupoBalanzas() {
		return this.grupoBalanzas;
	}

	public void setGrupoBalanzas(List<GrupoBalanza> grupoBalanzas) {
		this.grupoBalanzas = grupoBalanzas;
	}

}