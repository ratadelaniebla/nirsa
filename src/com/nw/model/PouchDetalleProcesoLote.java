package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pouch_detalle_proceso_lote database table.
 * 
 */
@Entity
@Table(name="pouch_detalle_proceso_lote")
public class PouchDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpouchdetalleprocesolote;

	private Integer agua;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private Integer fill;

	private Integer flake;

	//bi-directional many-to-one association to PouchDetalleProcesoConteo
	@OneToMany(mappedBy="pouchDetalleProcesoLote")
	private List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;

	//bi-directional many-to-one association to PouchProceso
	@ManyToOne
	@JoinColumn(name="idpouchproceso")
	private PouchProceso pouchProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public PouchDetalleProcesoLote() {
	}

	public Long getIdpouchdetalleprocesolote() {
		return this.idpouchdetalleprocesolote;
	}

	public void setIdpouchdetalleprocesolote(Long idpouchdetalleprocesolote) {
		this.idpouchdetalleprocesolote = idpouchdetalleprocesolote;
	}

	public Integer getAgua() {
		return this.agua;
	}

	public void setAgua(Integer agua) {
		this.agua = agua;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
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

	public Integer getFill() {
		return this.fill;
	}

	public void setFill(Integer fill) {
		this.fill = fill;
	}

	public Integer getFlake() {
		return this.flake;
	}

	public void setFlake(Integer flake) {
		this.flake = flake;
	}

	public List<PouchDetalleProcesoConteo> getPouchDetalleProcesoConteos() {
		return this.pouchDetalleProcesoConteos;
	}

	public void setPouchDetalleProcesoConteos(List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos) {
		this.pouchDetalleProcesoConteos = pouchDetalleProcesoConteos;
	}

	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}

	public PouchProceso getPouchProceso() {
		return this.pouchProceso;
	}

	public void setPouchProceso(PouchProceso pouchProceso) {
		this.pouchProceso = pouchProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}