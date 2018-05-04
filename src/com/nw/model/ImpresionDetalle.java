package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the impresion_detalle database table.
 * 
 */
@Entity
@Table(name="impresion_detalle")
@NamedQuery(name="ImpresionDetalle.findAll", query="SELECT i FROM ImpresionDetalle i")
public class ImpresionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idimpresiondetalle;
	private Timestamp fechahoraimpresion;
	private Long iddato;
	private Impresion impresion;
	private Usuario usuario;

	public ImpresionDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdimpresiondetalle() {
		return this.idimpresiondetalle;
	}

	public void setIdimpresiondetalle(Long idimpresiondetalle) {
		this.idimpresiondetalle = idimpresiondetalle;
	}


	public Timestamp getFechahoraimpresion() {
		return this.fechahoraimpresion;
	}

	public void setFechahoraimpresion(Timestamp fechahoraimpresion) {
		this.fechahoraimpresion = fechahoraimpresion;
	}


	public Long getIddato() {
		return this.iddato;
	}

	public void setIddato(Long iddato) {
		this.iddato = iddato;
	}


	//bi-directional many-to-one association to Impresion
	@ManyToOne
	@JoinColumn(name="idimpresion")
	public Impresion getImpresion() {
		return this.impresion;
	}

	public void setImpresion(Impresion impresion) {
		this.impresion = impresion;
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