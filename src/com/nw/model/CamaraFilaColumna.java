package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the camara_fila_columna database table.
 * 
 */
@Entity
@Table(name="camara_fila_columna")
@NamedQuery(name="CamaraFilaColumna.findAll", query="SELECT c FROM CamaraFilaColumna c")
public class CamaraFilaColumna implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcamarafilacolumna;
	private Integer estado;
	private String idcolumna;
	private Integer idfila;
	private Integer idnivel;
	private List<CamaraCajon> camaraCajons;
	private List<CamaraCajonUbicacion> camaraCajonUbicacions;
	private Camara camara;

	public CamaraFilaColumna() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcamarafilacolumna() {
		return this.idcamarafilacolumna;
	}

	public void setIdcamarafilacolumna(Long idcamarafilacolumna) {
		this.idcamarafilacolumna = idcamarafilacolumna;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public String getIdcolumna() {
		return this.idcolumna;
	}

	public void setIdcolumna(String idcolumna) {
		this.idcolumna = idcolumna;
	}


	public Integer getIdfila() {
		return this.idfila;
	}

	public void setIdfila(Integer idfila) {
		this.idfila = idfila;
	}


	public Integer getIdnivel() {
		return this.idnivel;
	}

	public void setIdnivel(Integer idnivel) {
		this.idnivel = idnivel;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="camaraFilaColumna")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setCamaraFilaColumna(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setCamaraFilaColumna(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to CamaraCajonUbicacion
	@OneToMany(mappedBy="camaraFilaColumna")
	public List<CamaraCajonUbicacion> getCamaraCajonUbicacions() {
		return this.camaraCajonUbicacions;
	}

	public void setCamaraCajonUbicacions(List<CamaraCajonUbicacion> camaraCajonUbicacions) {
		this.camaraCajonUbicacions = camaraCajonUbicacions;
	}

	public CamaraCajonUbicacion addCamaraCajonUbicacion(CamaraCajonUbicacion camaraCajonUbicacion) {
		getCamaraCajonUbicacions().add(camaraCajonUbicacion);
		camaraCajonUbicacion.setCamaraFilaColumna(this);

		return camaraCajonUbicacion;
	}

	public CamaraCajonUbicacion removeCamaraCajonUbicacion(CamaraCajonUbicacion camaraCajonUbicacion) {
		getCamaraCajonUbicacions().remove(camaraCajonUbicacion);
		camaraCajonUbicacion.setCamaraFilaColumna(null);

		return camaraCajonUbicacion;
	}


	//bi-directional many-to-one association to Camara
	@ManyToOne
	@JoinColumn(name="idcamara")
	public Camara getCamara() {
		return this.camara;
	}

	public void setCamara(Camara camara) {
		this.camara = camara;
	}

}