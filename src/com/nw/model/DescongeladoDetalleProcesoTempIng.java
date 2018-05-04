package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the descongelado_detalle_proceso_temp_ing database table.
 * 
 */
@Entity
@Table(name="descongelado_detalle_proceso_temp_ing")
@NamedQuery(name="DescongeladoDetalleProcesoTempIng.findAll", query="SELECT d FROM DescongeladoDetalleProcesoTempIng d")
public class DescongeladoDetalleProcesoTempIng implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddescongeladodetalleprocesotemping;
	private Timestamp fechareg;
	private Integer tapado;
	private double temperatura;
	private DescongeladoDetalleProceso descongeladoDetalleProceso;
	private Turno turno;
	private Usuario usuario;

	public DescongeladoDetalleProcesoTempIng() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddescongeladodetalleprocesotemping() {
		return this.iddescongeladodetalleprocesotemping;
	}

	public void setIddescongeladodetalleprocesotemping(Long iddescongeladodetalleprocesotemping) {
		this.iddescongeladodetalleprocesotemping = iddescongeladodetalleprocesotemping;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getTapado() {
		return this.tapado;
	}

	public void setTapado(Integer tapado) {
		this.tapado = tapado;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleproceso")
	public DescongeladoDetalleProceso getDescongeladoDetalleProceso() {
		return this.descongeladoDetalleProceso;
	}

	public void setDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		this.descongeladoDetalleProceso = descongeladoDetalleProceso;
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