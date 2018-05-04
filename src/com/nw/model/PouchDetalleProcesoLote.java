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
@NamedQuery(name="PouchDetalleProcesoLote.findAll", query="SELECT p FROM PouchDetalleProcesoLote p")
public class PouchDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpouchdetalleprocesolote;
	private Integer agua;
	private Integer estado;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private Integer fill;
	private Integer flake;
	private List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos;
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;
	private PouchProceso pouchProceso;
	private Usuario usuario;

	public PouchDetalleProcesoLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to PouchDetalleProcesoConteo
	@OneToMany(mappedBy="pouchDetalleProcesoLote")
	public List<PouchDetalleProcesoConteo> getPouchDetalleProcesoConteos() {
		return this.pouchDetalleProcesoConteos;
	}

	public void setPouchDetalleProcesoConteos(List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos) {
		this.pouchDetalleProcesoConteos = pouchDetalleProcesoConteos;
	}

	public PouchDetalleProcesoConteo addPouchDetalleProcesoConteo(PouchDetalleProcesoConteo pouchDetalleProcesoConteo) {
		getPouchDetalleProcesoConteos().add(pouchDetalleProcesoConteo);
		pouchDetalleProcesoConteo.setPouchDetalleProcesoLote(this);

		return pouchDetalleProcesoConteo;
	}

	public PouchDetalleProcesoConteo removePouchDetalleProcesoConteo(PouchDetalleProcesoConteo pouchDetalleProcesoConteo) {
		getPouchDetalleProcesoConteos().remove(pouchDetalleProcesoConteo);
		pouchDetalleProcesoConteo.setPouchDetalleProcesoLote(null);

		return pouchDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to PouchProceso
	@ManyToOne
	@JoinColumn(name="idpouchproceso")
	public PouchProceso getPouchProceso() {
		return this.pouchProceso;
	}

	public void setPouchProceso(PouchProceso pouchProceso) {
		this.pouchProceso = pouchProceso;
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