package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the control_detalle_batch_limpieza database table.
 * 
 */
@Entity
@Table(name="control_detalle_batch_limpieza")
public class ControlDetalleBatchLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcontroldetallebatchlimpieza;

	private Integer estado;

	private Timestamp fechaactualizacion;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private String idusuarioactualizacion;

	private String idusuariofin;

	private String observaciones;

	//bi-directional many-to-one association to ControlFichaBatch
	@ManyToOne
	@JoinColumn(name="idcontrolfichabatch")
	private ControlFichaBatch controlFichaBatch;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to MaquinaLinea
	@ManyToOne
	@JoinColumn(name="idmaquinalinea")
	private MaquinaLinea maquinaLinea;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioinicio")
	private Usuario usuario;

	public ControlDetalleBatchLimpieza() {
	}

	public Long getIdcontroldetallebatchlimpieza() {
		return this.idcontroldetallebatchlimpieza;
	}

	public void setIdcontroldetallebatchlimpieza(Long idcontroldetallebatchlimpieza) {
		this.idcontroldetallebatchlimpieza = idcontroldetallebatchlimpieza;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}

	public String getIdusuariofin() {
		return this.idusuariofin;
	}

	public void setIdusuariofin(String idusuariofin) {
		this.idusuariofin = idusuariofin;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ControlFichaBatch getControlFichaBatch() {
		return this.controlFichaBatch;
	}

	public void setControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		this.controlFichaBatch = controlFichaBatch;
	}

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public MaquinaLinea getMaquinaLinea() {
		return this.maquinaLinea;
	}

	public void setMaquinaLinea(MaquinaLinea maquinaLinea) {
		this.maquinaLinea = maquinaLinea;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}