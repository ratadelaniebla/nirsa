package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cuarto_chillroom_cocinada_detalle database table.
 * 
 */
@Entity
@Table(name="cuarto_chillroom_cocinada_detalle")
public class CuartoChillroomCocinadaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcuartochillroomcocinadadetalle;

	private Timestamp fechareg;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;

	//bi-directional many-to-one association to Cuartochillroom
	@ManyToOne
	@JoinColumn(name="idcuartochillroom")
	private Cuartochillroom cuartochillroom;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleproceso")
	private EvisceradoDetalleProceso evisceradoDetalleProceso;

	public CuartoChillroomCocinadaDetalle() {
	}

	public Long getIdcuartochillroomcocinadadetalle() {
		return this.idcuartochillroomcocinadadetalle;
	}

	public void setIdcuartochillroomcocinadadetalle(Long idcuartochillroomcocinadadetalle) {
		this.idcuartochillroomcocinadadetalle = idcuartochillroomcocinadadetalle;
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

	public Cuartochillroom getCuartochillroom() {
		return this.cuartochillroom;
	}

	public void setCuartochillroom(Cuartochillroom cuartochillroom) {
		this.cuartochillroom = cuartochillroom;
	}

	public EvisceradoDetalleProceso getEvisceradoDetalleProceso() {
		return this.evisceradoDetalleProceso;
	}

	public void setEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		this.evisceradoDetalleProceso = evisceradoDetalleProceso;
	}

}