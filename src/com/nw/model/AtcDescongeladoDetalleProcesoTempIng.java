package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_descongelado_detalle_proceso_temp_ing database table.
 * 
 */
@Entity
@Table(name="atc_descongelado_detalle_proceso_temp_ing")
@NamedQuery(name="AtcDescongeladoDetalleProcesoTempIng.findAll", query="SELECT a FROM AtcDescongeladoDetalleProcesoTempIng a")
public class AtcDescongeladoDetalleProcesoTempIng implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcdescongeladodetalleprocesotemping;
	private Timestamp fechareg;
	private double temperatura;
	private AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcDescongeladoDetalleProcesoTempIng() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcdescongeladodetalleprocesotemping() {
		return this.idatcdescongeladodetalleprocesotemping;
	}

	public void setIdatcdescongeladodetalleprocesotemping(Long idatcdescongeladodetalleprocesotemping) {
		this.idatcdescongeladodetalleprocesotemping = idatcdescongeladodetalleprocesotemping;
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