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
public class LimpiezaProcesoLineaTara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezaprocesolineatara;

	private Timestamp fechareg;

	private Integer idlimpiezamateriallomo;

	private Integer idlimpiezamaterialrallado;

	private double taralonjas;

	private double tararallado;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaProcesoLineaTara() {
	}

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

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}