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
@NamedQuery(name="PanzasDetalleProcesoLote.findAll", query="SELECT p FROM PanzasDetalleProcesoLote p")
public class PanzasDetalleProcesoLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpanzasdetalleprocesolote;
	private Integer estado;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private List<PanzasDetalleProcesoCocheDetalle> panzasDetalleProcesoCocheDetalles;
	private List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;
	private PanzasProceso panzasProceso;
	private Turno turno;
	private Usuario usuario;

	public PanzasDetalleProcesoLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to PanzasDetalleProcesoCocheDetalle
	@OneToMany(mappedBy="panzasDetalleProcesoLote")
	public List<PanzasDetalleProcesoCocheDetalle> getPanzasDetalleProcesoCocheDetalles() {
		return this.panzasDetalleProcesoCocheDetalles;
	}

	public void setPanzasDetalleProcesoCocheDetalles(List<PanzasDetalleProcesoCocheDetalle> panzasDetalleProcesoCocheDetalles) {
		this.panzasDetalleProcesoCocheDetalles = panzasDetalleProcesoCocheDetalles;
	}

	public PanzasDetalleProcesoCocheDetalle addPanzasDetalleProcesoCocheDetalle(PanzasDetalleProcesoCocheDetalle panzasDetalleProcesoCocheDetalle) {
		getPanzasDetalleProcesoCocheDetalles().add(panzasDetalleProcesoCocheDetalle);
		panzasDetalleProcesoCocheDetalle.setPanzasDetalleProcesoLote(this);

		return panzasDetalleProcesoCocheDetalle;
	}

	public PanzasDetalleProcesoCocheDetalle removePanzasDetalleProcesoCocheDetalle(PanzasDetalleProcesoCocheDetalle panzasDetalleProcesoCocheDetalle) {
		getPanzasDetalleProcesoCocheDetalles().remove(panzasDetalleProcesoCocheDetalle);
		panzasDetalleProcesoCocheDetalle.setPanzasDetalleProcesoLote(null);

		return panzasDetalleProcesoCocheDetalle;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoConteo
	@OneToMany(mappedBy="panzasDetalleProcesoLote")
	public List<PanzasDetalleProcesoConteo> getPanzasDetalleProcesoConteos() {
		return this.panzasDetalleProcesoConteos;
	}

	public void setPanzasDetalleProcesoConteos(List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos) {
		this.panzasDetalleProcesoConteos = panzasDetalleProcesoConteos;
	}

	public PanzasDetalleProcesoConteo addPanzasDetalleProcesoConteo(PanzasDetalleProcesoConteo panzasDetalleProcesoConteo) {
		getPanzasDetalleProcesoConteos().add(panzasDetalleProcesoConteo);
		panzasDetalleProcesoConteo.setPanzasDetalleProcesoLote(this);

		return panzasDetalleProcesoConteo;
	}

	public PanzasDetalleProcesoConteo removePanzasDetalleProcesoConteo(PanzasDetalleProcesoConteo panzasDetalleProcesoConteo) {
		getPanzasDetalleProcesoConteos().remove(panzasDetalleProcesoConteo);
		panzasDetalleProcesoConteo.setPanzasDetalleProcesoLote(null);

		return panzasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}


	//bi-directional many-to-one association to PanzasProceso
	@ManyToOne
	@JoinColumn(name="idpanzasproceso")
	public PanzasProceso getPanzasProceso() {
		return this.panzasProceso;
	}

	public void setPanzasProceso(PanzasProceso panzasProceso) {
		this.panzasProceso = panzasProceso;
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