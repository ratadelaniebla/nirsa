package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the descongelado_detalle_ducha_talla_monitoreo database table.
 * 
 */
@Entity
@Table(name="descongelado_detalle_ducha_talla_monitoreo")
@NamedQuery(name="DescongeladoDetalleDuchaTallaMonitoreo.findAll", query="SELECT d FROM DescongeladoDetalleDuchaTallaMonitoreo d")
public class DescongeladoDetalleDuchaTallaMonitoreo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddescongeladodetalleduchatallamonitoreo;
	private Timestamp fechacreacionregistro;
	private String horafin;
	private String horainicio;
	private double tiempoperdido;
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle;
	private DescongeladoSemaforoControl descongeladoSemaforoControl;
	private Usuario usuario;

	public DescongeladoDetalleDuchaTallaMonitoreo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddescongeladodetalleduchatallamonitoreo() {
		return this.iddescongeladodetalleduchatallamonitoreo;
	}

	public void setIddescongeladodetalleduchatallamonitoreo(Long iddescongeladodetalleduchatallamonitoreo) {
		this.iddescongeladodetalleduchatallamonitoreo = iddescongeladodetalleduchatallamonitoreo;
	}


	public Timestamp getFechacreacionregistro() {
		return this.fechacreacionregistro;
	}

	public void setFechacreacionregistro(Timestamp fechacreacionregistro) {
		this.fechacreacionregistro = fechacreacionregistro;
	}


	public String getHorafin() {
		return this.horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}


	public String getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}


	public double getTiempoperdido() {
		return this.tiempoperdido;
	}

	public void setTiempoperdido(double tiempoperdido) {
		this.tiempoperdido = tiempoperdido;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="iddescongeladoduchaaperturacierredetalle")
	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle() {
		return this.descongeladoDuchaAperturaCierreDetalle;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		this.descongeladoDuchaAperturaCierreDetalle = descongeladoDuchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to DescongeladoSemaforoControl
	@ManyToOne
	@JoinColumn(name="iddescongeladosemaforocontrol")
	public DescongeladoSemaforoControl getDescongeladoSemaforoControl() {
		return this.descongeladoSemaforoControl;
	}

	public void setDescongeladoSemaforoControl(DescongeladoSemaforoControl descongeladoSemaforoControl) {
		this.descongeladoSemaforoControl = descongeladoSemaforoControl;
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