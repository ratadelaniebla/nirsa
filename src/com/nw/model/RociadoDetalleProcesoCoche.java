package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the rociado_detalle_proceso_coche database table.
 * 
 */
@Entity
@Table(name="rociado_detalle_proceso_coche")
public class RociadoDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrociadodetalleprocesocoche;

	private Timestamp fechaactualizacion;

	private Timestamp fechareg;

	private String idusuarioactualizacion;

	private double peso;

	private double temperatura;

	//bi-directional many-to-one association to Cuartochillroom
	@ManyToOne
	@JoinColumn(name="idcuartochillroom")
	private Cuartochillroom cuartochillroom;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to RociadoProceso
	@ManyToOne
	@JoinColumn(name="idrociadoproceso")
	private RociadoProceso rociadoProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to RociadoDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="rociadoDetalleProcesoCoche")
	private List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas;

	public RociadoDetalleProcesoCoche() {
	}

	public Long getIdrociadodetalleprocesocoche() {
		return this.idrociadodetalleprocesocoche;
	}

	public void setIdrociadodetalleprocesocoche(Long idrociadodetalleprocesocoche) {
		this.idrociadodetalleprocesocoche = idrociadodetalleprocesocoche;
	}

	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public Cuartochillroom getCuartochillroom() {
		return this.cuartochillroom;
	}

	public void setCuartochillroom(Cuartochillroom cuartochillroom) {
		this.cuartochillroom = cuartochillroom;
	}

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public RociadoProceso getRociadoProceso() {
		return this.rociadoProceso;
	}

	public void setRociadoProceso(RociadoProceso rociadoProceso) {
		this.rociadoProceso = rociadoProceso;
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

	public List<RociadoDetalleProcesoCocheTemperatura> getRociadoDetalleProcesoCocheTemperaturas() {
		return this.rociadoDetalleProcesoCocheTemperaturas;
	}

	public void setRociadoDetalleProcesoCocheTemperaturas(List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas) {
		this.rociadoDetalleProcesoCocheTemperaturas = rociadoDetalleProcesoCocheTemperaturas;
	}

}