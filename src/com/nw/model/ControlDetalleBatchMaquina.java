package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the control_detalle_batch_maquina database table.
 * 
 */
@Entity
@Table(name="control_detalle_batch_maquina")
public class ControlDetalleBatchMaquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcontroldetallebatchmaquina;

	private String codproducto;

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

	//bi-directional many-to-one association to MaquinaCerradora
	@ManyToOne
	@JoinColumn(name="idmaquinacerradora")
	private MaquinaCerradora maquinaCerradora;

	//bi-directional many-to-one association to MaquinaDetectorMetal
	@ManyToOne
	@JoinColumn(name="idmaquinadetectormetal")
	private MaquinaDetectorMetal maquinaDetectorMetal;

	//bi-directional many-to-one association to MaquinaLinea
	@ManyToOne
	@JoinColumn(name="idmaquinalinea")
	private MaquinaLinea maquinaLinea;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioinicio")
	private Usuario usuario;

	public ControlDetalleBatchMaquina() {
	}

	public Long getIdcontroldetallebatchmaquina() {
		return this.idcontroldetallebatchmaquina;
	}

	public void setIdcontroldetallebatchmaquina(Long idcontroldetallebatchmaquina) {
		this.idcontroldetallebatchmaquina = idcontroldetallebatchmaquina;
	}

	public String getCodproducto() {
		return this.codproducto;
	}

	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
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

	public MaquinaCerradora getMaquinaCerradora() {
		return this.maquinaCerradora;
	}

	public void setMaquinaCerradora(MaquinaCerradora maquinaCerradora) {
		this.maquinaCerradora = maquinaCerradora;
	}

	public MaquinaDetectorMetal getMaquinaDetectorMetal() {
		return this.maquinaDetectorMetal;
	}

	public void setMaquinaDetectorMetal(MaquinaDetectorMetal maquinaDetectorMetal) {
		this.maquinaDetectorMetal = maquinaDetectorMetal;
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