package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the eviscerado_rackeo_lote database table.
 * 
 */
@Entity
@Table(name="eviscerado_rackeo_lote")
public class EvisceradoRackeoLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevisceradorackeolote;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	private Timestamp fechareg;

	//bi-directional many-to-one association to EvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idevisceradoproceso")
	private EvisceradoProceso evisceradoProceso;

	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idproducciondetallelotecajon")
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public EvisceradoRackeoLote() {
	}

	public Long getIdevisceradorackeolote() {
		return this.idevisceradorackeolote;
	}

	public void setIdevisceradorackeolote(Long idevisceradorackeolote) {
		this.idevisceradorackeolote = idevisceradorackeolote;
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

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public EvisceradoProceso getEvisceradoProceso() {
		return this.evisceradoProceso;
	}

	public void setEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		this.evisceradoProceso = evisceradoProceso;
	}

	public ProduccionDetalleLoteCajon getProduccionDetalleLoteCajon() {
		return this.produccionDetalleLoteCajon;
	}

	public void setProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		this.produccionDetalleLoteCajon = produccionDetalleLoteCajon;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}