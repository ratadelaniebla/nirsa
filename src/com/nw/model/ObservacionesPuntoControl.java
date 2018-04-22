package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the observaciones_punto_control database table.
 * 
 */
@Entity
@Table(name="observaciones_punto_control")
public class ObservacionesPuntoControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idobservacionespuntocontrol;

	private String accion;

	private Integer aprobado1;

	private Integer aprobado2;

	private String desviacion;

	private Timestamp fechaaprobado1;

	private Timestamp fechaaprobado2;

	private Timestamp fechareg;

	private Integer secuenciaobservacion;

	//bi-directional many-to-one association to Division
	@ManyToOne
	@JoinColumn(name="iddivision")
	private Division division;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario1")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario2")
	private Usuario usuario2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario3;

	public ObservacionesPuntoControl() {
	}

	public Long getIdobservacionespuntocontrol() {
		return this.idobservacionespuntocontrol;
	}

	public void setIdobservacionespuntocontrol(Long idobservacionespuntocontrol) {
		this.idobservacionespuntocontrol = idobservacionespuntocontrol;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Integer getAprobado1() {
		return this.aprobado1;
	}

	public void setAprobado1(Integer aprobado1) {
		this.aprobado1 = aprobado1;
	}

	public Integer getAprobado2() {
		return this.aprobado2;
	}

	public void setAprobado2(Integer aprobado2) {
		this.aprobado2 = aprobado2;
	}

	public String getDesviacion() {
		return this.desviacion;
	}

	public void setDesviacion(String desviacion) {
		this.desviacion = desviacion;
	}

	public Timestamp getFechaaprobado1() {
		return this.fechaaprobado1;
	}

	public void setFechaaprobado1(Timestamp fechaaprobado1) {
		this.fechaaprobado1 = fechaaprobado1;
	}

	public Timestamp getFechaaprobado2() {
		return this.fechaaprobado2;
	}

	public void setFechaaprobado2(Timestamp fechaaprobado2) {
		this.fechaaprobado2 = fechaaprobado2;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getSecuenciaobservacion() {
		return this.secuenciaobservacion;
	}

	public void setSecuenciaobservacion(Integer secuenciaobservacion) {
		this.secuenciaobservacion = secuenciaobservacion;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public Usuario getUsuario3() {
		return this.usuario3;
	}

	public void setUsuario3(Usuario usuario3) {
		this.usuario3 = usuario3;
	}

}