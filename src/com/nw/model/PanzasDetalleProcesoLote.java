package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the panzas_detalle_proceso_lote database table.
 * 
 */
@Entity
@Table(name="panzas_detalle_proceso_lote")
public class PanzasDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpanzasdetalleprocesolote;

	private Integer estado;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	//bi-directional many-to-one association to PanzasDetalleProcesoConteo
	@OneToMany(mappedBy="panzasDetalleProcesoLote")
	private List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	private EvisceradoDetalleProceso evisceradoDetalleProceso;

	//bi-directional many-to-one association to PanzasProceso
	@ManyToOne
	@JoinColumn(name="idpanzasproceso")
	private PanzasProceso panzasProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public PanzasDetalleProcesoLote() {
	}

	public Long getIdpanzasdetalleprocesolote() {
		return this.idpanzasdetalleprocesolote;
	}

	public void setIdpanzasdetalleprocesolote(Long idpanzasdetalleprocesolote) {
		this.idpanzasdetalleprocesolote = idpanzasdetalleprocesolote;
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

	public List<PanzasDetalleProcesoConteo> getPanzasDetalleProcesoConteos() {
		return this.panzasDetalleProcesoConteos;
	}

	public void setPanzasDetalleProcesoConteos(List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos) {
		this.panzasDetalleProcesoConteos = panzasDetalleProcesoConteos;
	}

	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}

	public PanzasProceso getPanzasProceso() {
		return this.panzasProceso;
	}

	public void setPanzasProceso(PanzasProceso panzasProceso) {
		this.panzasProceso = panzasProceso;
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