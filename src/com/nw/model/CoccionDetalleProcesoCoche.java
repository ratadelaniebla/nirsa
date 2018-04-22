package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the coccion_detalle_proceso_coche database table.
 * 
 */
@Entity
@Table(name="coccion_detalle_proceso_coche")
public class CoccionDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcocciondetalleprocesocoche;

	private Timestamp fechaactualizacion;

	private Timestamp fechareg;

	private String idusuario;

	private String idusuarioactualizacion;

	private double peso;

	//bi-directional many-to-one association to CoccionProceso
	@ManyToOne
	@JoinColumn(name="idcoccionproceso")
	private CoccionProceso coccionProceso;

	//bi-directional many-to-one association to Ducharociado
	@ManyToOne
	@JoinColumn(name="ducharociado")
	private Ducharociado ducharociadoBean;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="evisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to CoccionDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="coccionDetalleProcesoCoche")
	private List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas;

	public CoccionDetalleProcesoCoche() {
	}

	public Long getIdcocciondetalleprocesocoche() {
		return this.idcocciondetalleprocesocoche;
	}

	public void setIdcocciondetalleprocesocoche(Long idcocciondetalleprocesocoche) {
		this.idcocciondetalleprocesocoche = idcocciondetalleprocesocoche;
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

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
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

	public CoccionProceso getCoccionProceso() {
		return this.coccionProceso;
	}

	public void setCoccionProceso(CoccionProceso coccionProceso) {
		this.coccionProceso = coccionProceso;
	}

	public Ducharociado getDucharociadoBean() {
		return this.ducharociadoBean;
	}

	public void setDucharociadoBean(Ducharociado ducharociadoBean) {
		this.ducharociadoBean = ducharociadoBean;
	}

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<CoccionDetalleProcesoCocheTemperatura> getCoccionDetalleProcesoCocheTemperaturas() {
		return this.coccionDetalleProcesoCocheTemperaturas;
	}

	public void setCoccionDetalleProcesoCocheTemperaturas(List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas) {
		this.coccionDetalleProcesoCocheTemperaturas = coccionDetalleProcesoCocheTemperaturas;
	}

}