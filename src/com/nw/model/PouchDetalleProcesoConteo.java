package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pouch_detalle_proceso_conteo database table.
 * 
 */
@Entity
@Table(name="pouch_detalle_proceso_conteo")
@NamedQuery(name="PouchDetalleProcesoConteo.findAll", query="SELECT p FROM PouchDetalleProcesoConteo p")
public class PouchDetalleProcesoConteo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpouchdetalleprocesoconteo;
	private Timestamp fechareg;
	private Integer idcoche;
	private Integer totalfundas;
	private PouchDetalleProcesoLote pouchDetalleProcesoLote;
	private Turno turno;
	private Usuario usuario;

	public PouchDetalleProcesoConteo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdpouchdetalleprocesoconteo() {
		return this.idpouchdetalleprocesoconteo;
	}

	public void setIdpouchdetalleprocesoconteo(Long idpouchdetalleprocesoconteo) {
		this.idpouchdetalleprocesoconteo = idpouchdetalleprocesoconteo;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getIdcoche() {
		return this.idcoche;
	}

	public void setIdcoche(Integer idcoche) {
		this.idcoche = idcoche;
	}


	public Integer getTotalfundas() {
		return this.totalfundas;
	}

	public void setTotalfundas(Integer totalfundas) {
		this.totalfundas = totalfundas;
	}


	//bi-directional many-to-one association to PouchDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idpouchdetalleprocesolote")
	public PouchDetalleProcesoLote getPouchDetalleProcesoLote() {
		return this.pouchDetalleProcesoLote;
	}

	public void setPouchDetalleProcesoLote(PouchDetalleProcesoLote pouchDetalleProcesoLote) {
		this.pouchDetalleProcesoLote = pouchDetalleProcesoLote;
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

}