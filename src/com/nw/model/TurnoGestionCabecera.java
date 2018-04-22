package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the turno_gestion_cabecera database table.
 * 
 */
@Entity
@Table(name="turno_gestion_cabecera")
public class TurnoGestionCabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idturnogestion;

	@Temporal(TemporalType.DATE)
	private Date fechaproduccion;

	private Timestamp fecharegistro;

	private String idusuario;

	//bi-directional many-to-one association to TurnoGestionDetalle
	@OneToMany(mappedBy="turnoGestionCabecera")
	private List<TurnoGestionDetalle> turnoGestionDetalles;

	public TurnoGestionCabecera() {
	}

	public Long getIdturnogestion() {
		return this.idturnogestion;
	}

	public void setIdturnogestion(Long idturnogestion) {
		this.idturnogestion = idturnogestion;
	}

	public Date getFechaproduccion() {
		return this.fechaproduccion;
	}

	public void setFechaproduccion(Date fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public List<TurnoGestionDetalle> getTurnoGestionDetalles() {
		return this.turnoGestionDetalles;
	}

	public void setTurnoGestionDetalles(List<TurnoGestionDetalle> turnoGestionDetalles) {
		this.turnoGestionDetalles = turnoGestionDetalles;
	}

}