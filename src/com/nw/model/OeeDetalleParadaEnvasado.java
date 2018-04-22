package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_parada_envasado database table.
 * 
 */
@Entity
@Table(name="oee_detalle_parada_envasado")
public class OeeDetalleParadaEnvasado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idoeedetalleparadaenvasado;

	private Integer idluthy;

	//bi-directional many-to-one association to MaquinaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	private MaquinaCerradora maquinaCerradora;

	//bi-directional many-to-one association to OeeDetalleParada
	@ManyToOne
	@JoinColumn(name="idoeedetalleparada")
	private OeeDetalleParada oeeDetalleParada;

	public OeeDetalleParadaEnvasado() {
	}

	public Long getIdoeedetalleparadaenvasado() {
		return this.idoeedetalleparadaenvasado;
	}

	public void setIdoeedetalleparadaenvasado(Long idoeedetalleparadaenvasado) {
		this.idoeedetalleparadaenvasado = idoeedetalleparadaenvasado;
	}

	public Integer getIdluthy() {
		return this.idluthy;
	}

	public void setIdluthy(Integer idluthy) {
		this.idluthy = idluthy;
	}

	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
	}

	public OeeDetalleParada getOeeDetalleParada() {
		return this.oeeDetalleParada;
	}

	public void setOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		this.oeeDetalleParada = oeeDetalleParada;
	}

}