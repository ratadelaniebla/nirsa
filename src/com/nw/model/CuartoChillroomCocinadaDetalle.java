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
@NamedQuery(name="CuartoChillroomCocinadaDetalle.findAll", query="SELECT c FROM CuartoChillroomCocinadaDetalle c")
public class CuartoChillroomCocinadaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcuartochillroomcocinadadetalle;
	private Timestamp fechareg;
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;
	private Cuartochillroom cuartochillroom;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;

	public CuartoChillroomCocinadaDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to Cuartochillroom
	@ManyToOne
	@JoinColumn(name="idcuartochillroom")
	public Cuartochillroom getCuartochillroom() {
		return this.cuartochillroom;
	}

	public void setCuartochillroom(Cuartochillroom cuartochillroom) {
		this.cuartochillroom = cuartochillroom;
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