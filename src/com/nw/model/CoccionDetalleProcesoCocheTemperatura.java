package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the coccion_detalle_proceso_coche_temperatura database table.
 * 
 */
@Entity
@Table(name="coccion_detalle_proceso_coche_temperatura")
public class CoccionDetalleProcesoCocheTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcocciondetalleprocesocochetemperatura;

	private Timestamp fechareg;

	private double temperatura;

	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idcocciondetalleprocesocoche")
	private CoccionDetalleProcesoCoche coccionDetalleProcesoCoche;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CoccionDetalleProcesoCocheTemperatura() {
	}

	public Long getIdcocciondetalleprocesocochetemperatura() {
		return this.idcocciondetalleprocesocochetemperatura;
	}

	public void setIdcocciondetalleprocesocochetemperatura(Long idcocciondetalleprocesocochetemperatura) {
		this.idcocciondetalleprocesocochetemperatura = idcocciondetalleprocesocochetemperatura;
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

	public CoccionDetalleProcesoCoche getCoccionDetalleProcesoCoche() {
		return this.coccionDetalleProcesoCoche;
	}

	public void setCoccionDetalleProcesoCoche(CoccionDetalleProcesoCoche coccionDetalleProcesoCoche) {
		this.coccionDetalleProcesoCoche = coccionDetalleProcesoCoche;
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