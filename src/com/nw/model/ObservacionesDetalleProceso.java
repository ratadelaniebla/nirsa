package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the observaciones_detalle_procesos database table.
 * 
 */
@Entity
@Table(name="observaciones_detalle_procesos")
@NamedQuery(name="ObservacionesDetalleProceso.findAll", query="SELECT o FROM ObservacionesDetalleProceso o")
public class ObservacionesDetalleProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idobservacionesdetalleprocesos;
	private Timestamp fechareg;
	private String observaciones;
	private Division division;
	private ObservacionesProceso observacionesProceso;
	private Usuario usuario;

	public ObservacionesDetalleProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdobservacionesdetalleprocesos() {
		return this.idobservacionesdetalleprocesos;
	}

	public void setIdobservacionesdetalleprocesos(Long idobservacionesdetalleprocesos) {
		this.idobservacionesdetalleprocesos = idobservacionesdetalleprocesos;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	//bi-directional many-to-one association to Division
	@ManyToOne
	@JoinColumn(name="iddivision")
	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}


	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
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