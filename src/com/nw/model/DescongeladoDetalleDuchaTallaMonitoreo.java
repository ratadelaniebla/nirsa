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
public class DescongeladoDetalleDuchaTallaMonitoreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddescongeladodetalleduchatallamonitoreo;

	private Timestamp fechacreacionregistro;

	private String horafin;

	private String horainicio;

	private double tiempoperdido;

	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="iddescongeladoduchaaperturacierredetalle")
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle;

	//bi-directional many-to-one association to DescongeladoSemaforoControl
	@ManyToOne
	@JoinColumn(name="iddescongeladosemaforocontrol")
	private DescongeladoSemaforoControl descongeladoSemaforoControl;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public DescongeladoDetalleDuchaTallaMonitoreo() {
	}

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

	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle() {
		return this.descongeladoDuchaAperturaCierreDetalle;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		this.descongeladoDuchaAperturaCierreDetalle = descongeladoDuchaAperturaCierreDetalle;
	}

	public DescongeladoSemaforoControl getDescongeladoSemaforoControl() {
		return this.descongeladoSemaforoControl;
	}

	public void setDescongeladoSemaforoControl(DescongeladoSemaforoControl descongeladoSemaforoControl) {
		this.descongeladoSemaforoControl = descongeladoSemaforoControl;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}