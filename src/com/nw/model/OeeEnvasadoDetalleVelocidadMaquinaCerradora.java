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
public class OeeEnvasadoDetalleVelocidadMaquinaCerradora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_envasado_detalle_velocidad_maquina_cerradora")
	private Integer idOeeEnvasadoDetalleVelocidadMaquinaCerradora;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	//bi-directional many-to-one association to Luthy
	@ManyToOne
	@JoinColumn(name="idluthy")
	private Luthy luthy;

	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@ManyToOne
	@JoinColumn(name="id_oee_envasado_cabecera_velocidad_maquina_cerradora")
	private OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora() {
	}

	public Integer getIdOeeEnvasadoDetalleVelocidadMaquinaCerradora() {
		return this.idOeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}

	public void setIdOeeEnvasadoDetalleVelocidadMaquinaCerradora(Integer idOeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		this.idOeeEnvasadoDetalleVelocidadMaquinaCerradora = idOeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Luthy getLuthy() {
		return this.luthy;
	}

	public void setLuthy(Luthy luthy) {
		this.luthy = luthy;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora getOeeEnvasadoCabeceraVelocidadMaquinaCerradora() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradora = oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}