package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the panzas_detalle_proceso_conteo database table.
 * 
 */
@Entity
@Table(name="panzas_detalle_proceso_conteo")
public class PanzasDetalleProcesoConteo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpanzasdetalleprocesoconteo;

	private Timestamp fechareg;

	private Integer idcoche;

	private Integer latas;

	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idpanzasdetalleprocesolote")
	private PanzasDetalleProcesoLote panzasDetalleProcesoLote;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public PanzasDetalleProcesoConteo() {
	}

	public Long getIdpanzasdetalleprocesoconteo() {
		return this.idpanzasdetalleprocesoconteo;
	}

	public void setIdpanzasdetalleprocesoconteo(Long idpanzasdetalleprocesoconteo) {
		this.idpanzasdetalleprocesoconteo = idpanzasdetalleprocesoconteo;
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

	public Integer getLatas() {
		return this.latas;
	}

	public void setLatas(Integer latas) {
		this.latas = latas;
	}

	public PanzasDetalleProcesoLote getPanzasDetalleProcesoLote() {
		return this.panzasDetalleProcesoLote;
	}

	public void setPanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		this.panzasDetalleProcesoLote = panzasDetalleProcesoLote;
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