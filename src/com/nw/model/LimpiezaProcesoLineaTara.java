package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_proceso_linea_tara database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_linea_tara")
@NamedQuery(name="LimpiezaProcesoLineaTara.findAll", query="SELECT l FROM LimpiezaProcesoLineaTara l")
public class LimpiezaProcesoLineaTara implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezaprocesolineatara;
	private Timestamp fechareg;
	private Integer idlimpiezamateriallomo;
	private Integer idlimpiezamaterialrallado;
	private double taralonjas;
	private double tararallado;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaProceso limpiezaProceso;
	private Usuario usuario;

	public LimpiezaProcesoLineaTara() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlimpiezaprocesolineatara() {
		return this.idlimpiezaprocesolineatara;
	}

	public void setIdlimpiezaprocesolineatara(Integer idlimpiezaprocesolineatara) {
		this.idlimpiezaprocesolineatara = idlimpiezaprocesolineatara;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getIdlimpiezamateriallomo() {
		return this.idlimpiezamateriallomo;
	}

	public void setIdlimpiezamateriallomo(Integer idlimpiezamateriallomo) {
		this.idlimpiezamateriallomo = idlimpiezamateriallomo;
	}


	public Integer getIdlimpiezamaterialrallado() {
		return this.idlimpiezamaterialrallado;
	}

	public void setIdlimpiezamaterialrallado(Integer idlimpiezamaterialrallado) {
		this.idlimpiezamaterialrallado = idlimpiezamaterialrallado;
	}


	public double getTaralonjas() {
		return this.taralonjas;
	}

	public void setTaralonjas(double taralonjas) {
		this.taralonjas = taralonjas;
	}


	public double getTararallado() {
		return this.tararallado;
	}

	public void setTararallado(double tararallado) {
		this.tararallado = tararallado;
	}


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
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