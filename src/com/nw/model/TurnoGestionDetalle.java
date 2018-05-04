package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the turno_gestion_detalle database table.
 * 
 */
@Entity
@Table(name="turno_gestion_detalle")
@NamedQuery(name="TurnoGestionDetalle.findAll", query="SELECT t FROM TurnoGestionDetalle t")
public class TurnoGestionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idturnogestiondetalle;
	private Timestamp fechadesde;
	private Timestamp fechahasta;
	private Timestamp fecharegistro;
	private Area area;
	private Turno turno;
	private TurnoGestionCabecera turnoGestionCabecera;
	private Usuario usuario;

	public TurnoGestionDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdturnogestiondetalle() {
		return this.idturnogestiondetalle;
	}

	public void setIdturnogestiondetalle(Long idturnogestiondetalle) {
		this.idturnogestiondetalle = idturnogestiondetalle;
	}


	public Timestamp getFechadesde() {
		return this.fechadesde;
	}

	public void setFechadesde(Timestamp fechadesde) {
		this.fechadesde = fechadesde;
	}


	public Timestamp getFechahasta() {
		return this.fechahasta;
	}

	public void setFechahasta(Timestamp fechahasta) {
		this.fechahasta = fechahasta;
	}


	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
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


	//bi-directional many-to-one association to TurnoGestionCabecera
	@ManyToOne
	@JoinColumn(name="idturnogestion")
	public TurnoGestionCabecera getTurnoGestionCabecera() {
		return this.turnoGestionCabecera;
	}

	public void setTurnoGestionCabecera(TurnoGestionCabecera turnoGestionCabecera) {
		this.turnoGestionCabecera = turnoGestionCabecera;
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