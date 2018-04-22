package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the descongelado_detalle_proceso_temperatura database table.
 * 
 */
@Entity
@Table(name="descongelado_detalle_proceso_temperatura")
public class DescongeladoDetalleProcesoTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddescongeladodetalleprocesotemperatura;

	private Timestamp fechareg;

	private double temperatura;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleproceso")
	private DescongeladoDetalleProceso descongeladoDetalleProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public DescongeladoDetalleProcesoTemperatura() {
	}

	public Long getIddescongeladodetalleprocesotemperatura() {
		return this.iddescongeladodetalleprocesotemperatura;
	}

	public void setIddescongeladodetalleprocesotemperatura(Long iddescongeladodetalleprocesotemperatura) {
		this.iddescongeladodetalleprocesotemperatura = iddescongeladodetalleprocesotemperatura;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public DescongeladoDetalleProceso getDescongeladoDetalleProceso() {
		return this.descongeladoDetalleProceso;
	}

	public void setDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		this.descongeladoDetalleProceso = descongeladoDetalleProceso;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}