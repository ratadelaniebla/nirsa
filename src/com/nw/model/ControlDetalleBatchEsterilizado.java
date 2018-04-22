package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the control_detalle_batch_esterilizado database table.
 * 
 */
@Entity
@Table(name="control_detalle_batch_esterilizado")
public class ControlDetalleBatchEsterilizado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcontroldetallebatchesterilizado;

	private Integer cocheautoclave;

	private String codigoproducto;

	private Integer estado;

	private Timestamp fechaactualizacion;

	private Timestamp fechaesterilizado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private Integer idautoclave;

	private Integer idparadaautoclave;

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

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioinicio")
	private Usuario usuario;

	public ControlDetalleBatchEsterilizado() {
	}

	public Long getIdcontroldetallebatchesterilizado() {
		return this.idcontroldetallebatchesterilizado;
	}

	public void setIdcontroldetallebatchesterilizado(Long idcontroldetallebatchesterilizado) {
		this.idcontroldetallebatchesterilizado = idcontroldetallebatchesterilizado;
	}

	public Integer getCocheautoclave() {
		return this.cocheautoclave;
	}

	public void setCocheautoclave(Integer cocheautoclave) {
		this.cocheautoclave = cocheautoclave;
	}

	public String getCodigoproducto() {
		return this.codigoproducto;
	}

	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
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

	public Timestamp getFechaesterilizado() {
		return this.fechaesterilizado;
	}

	public void setFechaesterilizado(Timestamp fechaesterilizado) {
		this.fechaesterilizado = fechaesterilizado;
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

	public Integer getIdautoclave() {
		return this.idautoclave;
	}

	public void setIdautoclave(Integer idautoclave) {
		this.idautoclave = idautoclave;
	}

	public Integer getIdparadaautoclave() {
		return this.idparadaautoclave;
	}

	public void setIdparadaautoclave(Integer idparadaautoclave) {
		this.idparadaautoclave = idparadaautoclave;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}