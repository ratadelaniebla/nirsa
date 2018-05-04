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
@NamedQuery(name="RociadoDetalleProcesoCoche.findAll", query="SELECT r FROM RociadoDetalleProcesoCoche r")
public class RociadoDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idrociadodetalleprocesocoche;
	private Timestamp fechaactualizacion;
	private Timestamp fechareg;
	private String idusuarioactualizacion;
	private double peso;
	private double temperatura;
	private Cuartochillroom cuartochillroom;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private RociadoProceso rociadoProceso;
	private Turno turno;
	private Usuario usuario;
	private List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas;

	public RociadoDetalleProcesoCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to Cuartochillroom
	@ManyToOne
	@JoinColumn(name="idcuartochillroom")
	public Cuartochillroom getCuartochillroom() {
		return this.cuartochillroom;
	}

	public void setCuartochillroom(Cuartochillroom cuartochillroom) {
		this.cuartochillroom = cuartochillroom;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to RociadoProceso
	@ManyToOne
	@JoinColumn(name="idrociadoproceso")
	public RociadoProceso getRociadoProceso() {
		return this.rociadoProceso;
	}

	public void setRociadoProceso(RociadoProceso rociadoProceso) {
		this.rociadoProceso = rociadoProceso;
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


	//bi-directional many-to-one association to RociadoDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="rociadoDetalleProcesoCoche")
	public List<RociadoDetalleProcesoCocheTemperatura> getRociadoDetalleProcesoCocheTemperaturas() {
		return this.rociadoDetalleProcesoCocheTemperaturas;
	}

	public void setRociadoDetalleProcesoCocheTemperaturas(List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas) {
		this.rociadoDetalleProcesoCocheTemperaturas = rociadoDetalleProcesoCocheTemperaturas;
	}

	public RociadoDetalleProcesoCocheTemperatura addRociadoDetalleProcesoCocheTemperatura(RociadoDetalleProcesoCocheTemperatura rociadoDetalleProcesoCocheTemperatura) {
		getRociadoDetalleProcesoCocheTemperaturas().add(rociadoDetalleProcesoCocheTemperatura);
		rociadoDetalleProcesoCocheTemperatura.setRociadoDetalleProcesoCoche(this);

		return rociadoDetalleProcesoCocheTemperatura;
	}

	public RociadoDetalleProcesoCocheTemperatura removeRociadoDetalleProcesoCocheTemperatura(RociadoDetalleProcesoCocheTemperatura rociadoDetalleProcesoCocheTemperatura) {
		getRociadoDetalleProcesoCocheTemperaturas().remove(rociadoDetalleProcesoCocheTemperatura);
		rociadoDetalleProcesoCocheTemperatura.setRociadoDetalleProcesoCoche(null);

		return rociadoDetalleProcesoCocheTemperatura;
	}

}