package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rociado_ciclo_detalle database table.
 * 
 */
@Entity
@Table(name="rociado_ciclo_detalle")
@NamedQuery(name="RociadoCicloDetalle.findAll", query="SELECT r FROM RociadoCicloDetalle r")
public class RociadoCicloDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idrociadocliclodetalle;
	private Timestamp fechareg;
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;
	private RociadoCiclo rociadoCiclo;

	public RociadoCicloDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdrociadocliclodetalle() {
		return this.idrociadocliclodetalle;
	}

	public void setIdrociadocliclodetalle(Long idrociadocliclodetalle) {
		this.idrociadocliclodetalle = idrociadocliclodetalle;
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


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}


	//bi-directional many-to-one association to RociadoCiclo
	@ManyToOne
	@JoinColumn(name="idrociadocliclo")
	public RociadoCiclo getRociadoCiclo() {
		return this.rociadoCiclo;
	}

	public void setRociadoCiclo(RociadoCiclo rociadoCiclo) {
		this.rociadoCiclo = rociadoCiclo;
	}

}