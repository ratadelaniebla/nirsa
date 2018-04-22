package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_detalle_peso_despellejado database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_peso_despellejado")
public class LimpiezaDetallePesoDespellejado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezadetallepesodespellejado;

	private Timestamp fechareg;

	private double peso;

	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@ManyToOne
	@JoinColumn(name="idlimpiezaasignacioncanastilla")
	private LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaDetallePesoDespellejado() {
	}

	public Long getIdlimpiezadetallepesodespellejado() {
		return this.idlimpiezadetallepesodespellejado;
	}

	public void setIdlimpiezadetallepesodespellejado(Long idlimpiezadetallepesodespellejado) {
		this.idlimpiezadetallepesodespellejado = idlimpiezadetallepesodespellejado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public LimpiezaAsignacionCanastilla getLimpiezaAsignacionCanastilla() {
		return this.limpiezaAsignacionCanastilla;
	}

	public void setLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		this.limpiezaAsignacionCanastilla = limpiezaAsignacionCanastilla;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}