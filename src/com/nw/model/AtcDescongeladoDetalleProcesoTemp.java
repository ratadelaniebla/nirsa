package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_descongelado_detalle_proceso_temp database table.
 * 
 */
@Entity
@Table(name="atc_descongelado_detalle_proceso_temp")
@NamedQuery(name="AtcDescongeladoDetalleProcesoTemp.findAll", query="SELECT a FROM AtcDescongeladoDetalleProcesoTemp a")
public class AtcDescongeladoDetalleProcesoTemp implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcdescongeladodetalleprocesotemp;
	private Timestamp fechareg;
	private double temperatura;
	private AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcDescongeladoDetalleProcesoTemp() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcdescongeladodetalleprocesotemp() {
		return this.idatcdescongeladodetalleprocesotemp;
	}

	public void setIdatcdescongeladodetalleprocesotemp(Long idatcdescongeladodetalleprocesotemp) {
		this.idatcdescongeladodetalleprocesotemp = idatcdescongeladodetalleprocesotemp;
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


	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idatcdescongeladodetalleproceso")
	public AtcDescongeladoDetalleProceso getAtcDescongeladoDetalleProceso() {
		return this.atcDescongeladoDetalleProceso;
	}

	public void setAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		this.atcDescongeladoDetalleProceso = atcDescongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}


	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

}