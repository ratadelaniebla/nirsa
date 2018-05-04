package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rociado_cocinada_detalle database table.
 * 
 */
@Entity
@Table(name="rociado_cocinada_detalle")
@NamedQuery(name="RociadoCocinadaDetalle.findAll", query="SELECT r FROM RociadoCocinadaDetalle r")
public class RociadoCocinadaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idrociadococinadadetalle;
	private Timestamp fechareg;
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;
	private Ducharociado ducharociado;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;

	public RociadoCocinadaDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdrociadococinadadetalle() {
		return this.idrociadococinadadetalle;
	}

	public void setIdrociadococinadadetalle(Long idrociadococinadadetalle) {
		this.idrociadococinadadetalle = idrociadococinadadetalle;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to Ducharociado
	@ManyToOne
	@JoinColumn(name="idducharociado")
	public Ducharociado getDucharociado() {
		return this.ducharociado;
	}

	public void setDucharociado(Ducharociado ducharociado) {
		this.ducharociado = ducharociado;
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

}