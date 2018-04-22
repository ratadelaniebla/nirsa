package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rociado_detalle_proceso_coche_temperatura database table.
 * 
 */
@Entity
@Table(name="rociado_detalle_proceso_coche_temperatura")
public class RociadoDetalleProcesoCocheTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrociadodetalleprocesocochetemperatura;

	private Timestamp fechareg;

	private double temperatura;

	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idrociadodetalleprocesocoche")
	private RociadoDetalleProcesoCoche rociadoDetalleProcesoCoche;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public RociadoDetalleProcesoCocheTemperatura() {
	}

	public Long getIdrociadodetalleprocesocochetemperatura() {
		return this.idrociadodetalleprocesocochetemperatura;
	}

	public void setIdrociadodetalleprocesocochetemperatura(Long idrociadodetalleprocesocochetemperatura) {
		this.idrociadodetalleprocesocochetemperatura = idrociadodetalleprocesocochetemperatura;
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

	public RociadoDetalleProcesoCoche getRociadoDetalleProcesoCoche() {
		return this.rociadoDetalleProcesoCoche;
	}

	public void setRociadoDetalleProcesoCoche(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoche) {
		this.rociadoDetalleProcesoCoche = rociadoDetalleProcesoCoche;
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