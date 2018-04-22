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
public class RociadoCocinadaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrociadococinadadetalle;

	private Timestamp fechareg;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;

	//bi-directional many-to-one association to Ducharociado
	@ManyToOne
	@JoinColumn(name="idducharociado")
	private Ducharociado ducharociado;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	private EvisceradoDetalleProceso evisceradoDetalleProceso;

	public RociadoCocinadaDetalle() {
	}

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

	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}

	public Ducharociado getDucharociado() {
		return this.ducharociado;
	}

	public void setDucharociado(Ducharociado ducharociado) {
		this.ducharociado = ducharociado;
	}

	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}

}