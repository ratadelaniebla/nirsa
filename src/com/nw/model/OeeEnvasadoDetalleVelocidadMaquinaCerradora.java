package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the oee_envasado_detalle_velocidad_maquina_cerradora database table.
 * 
 */
@Entity
@Table(name="oee_envasado_detalle_velocidad_maquina_cerradora")
@NamedQuery(name="OeeEnvasadoDetalleVelocidadMaquinaCerradora.findAll", query="SELECT o FROM OeeEnvasadoDetalleVelocidadMaquinaCerradora o")
public class OeeEnvasadoDetalleVelocidadMaquinaCerradora implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idOeeEnvasadoDetalleVelocidadMaquinaCerradora;
	private Timestamp fechaRegistro;
	private Luthy luthy;
	private OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	private Usuario usuario;

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_envasado_detalle_velocidad_maquina_cerradora")
	public Integer getIdOeeEnvasadoDetalleVelocidadMaquinaCerradora() {
		return this.idOeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}

	public void setIdOeeEnvasadoDetalleVelocidadMaquinaCerradora(Integer idOeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		this.idOeeEnvasadoDetalleVelocidadMaquinaCerradora = idOeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}


	@Column(name="fecha_registro")
	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	//bi-directional many-to-one association to Luthy
	@ManyToOne
	@JoinColumn(name="idluthy")
	public Luthy getLuthy() {
		return this.luthy;
	}

	public void setLuthy(Luthy luthy) {
		this.luthy = luthy;
	}


	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@ManyToOne
	@JoinColumn(name="id_oee_envasado_cabecera_velocidad_maquina_cerradora")
	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora getOeeEnvasadoCabeceraVelocidadMaquinaCerradora() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradora = oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}