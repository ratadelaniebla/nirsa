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
public class ObservacionesDetalleProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idobservacionesdetalleprocesos;

	private Timestamp fechareg;

	private String observaciones;

	//bi-directional many-to-one association to Division
	@ManyToOne
	@JoinColumn(name="iddivision")
	private Division division;

	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	private ObservacionesProceso observacionesProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public ObservacionesDetalleProceso() {
	}

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

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}