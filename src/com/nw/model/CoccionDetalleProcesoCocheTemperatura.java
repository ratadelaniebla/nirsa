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
@NamedQuery(name="CoccionDetalleProcesoCocheTemperatura.findAll", query="SELECT c FROM CoccionDetalleProcesoCocheTemperatura c")
public class CoccionDetalleProcesoCocheTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcocciondetalleprocesocochetemperatura;
	private Timestamp fechareg;
	private double temperatura;
	private CoccionDetalleProcesoCoche coccionDetalleProcesoCoche;
	private Turno turno;
	private Usuario usuario;

	public CoccionDetalleProcesoCocheTemperatura() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idcocciondetalleprocesocoche")
	public CoccionDetalleProcesoCoche getCoccionDetalleProcesoCoche() {
		return this.coccionDetalleProcesoCoche;
	}

	public void setCoccionDetalleProcesoCoche(CoccionDetalleProcesoCoche coccionDetalleProcesoCoche) {
		this.coccionDetalleProcesoCoche = coccionDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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