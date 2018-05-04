package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the contraloria_detalle_rackeo_proceso_temperatura database table.
 * 
 */
@Entity
@Table(name="contraloria_detalle_rackeo_proceso_temperatura")
@NamedQuery(name="ContraloriaDetalleRackeoProcesoTemperatura.findAll", query="SELECT c FROM ContraloriaDetalleRackeoProcesoTemperatura c")
public class ContraloriaDetalleRackeoProcesoTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcontraloriadetallerackeoprocesotemperatura;
	private Timestamp fechareg;
	private Integer nivel;
	private double temperatura;
	private DescongeladoDetalleProceso descongeladoDetalleProceso;
	private Turno turno;
	private Usuario usuario;

	public ContraloriaDetalleRackeoProcesoTemperatura() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcontraloriadetallerackeoprocesotemperatura() {
		return this.idcontraloriadetallerackeoprocesotemperatura;
	}

	public void setIdcontraloriadetallerackeoprocesotemperatura(Long idcontraloriadetallerackeoprocesotemperatura) {
		this.idcontraloriadetallerackeoprocesotemperatura = idcontraloriadetallerackeoprocesotemperatura;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
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