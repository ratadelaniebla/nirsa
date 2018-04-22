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
public class PouchDetalleProcesoConteo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpouchdetalleprocesoconteo;

	private Timestamp fechareg;

	private Integer idcoche;

	private Integer totalfundas;

	//bi-directional many-to-one association to PouchDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idpouchdetalleprocesolote")
	private PouchDetalleProcesoLote pouchDetalleProcesoLote;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public PouchDetalleProcesoConteo() {
	}

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

	public PouchDetalleProcesoLote getPouchDetalleProcesoLote() {
		return this.pouchDetalleProcesoLote;
	}

	public void setPouchDetalleProcesoLote(PouchDetalleProcesoLote pouchDetalleProcesoLote) {
		this.pouchDetalleProcesoLote = pouchDetalleProcesoLote;
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

}