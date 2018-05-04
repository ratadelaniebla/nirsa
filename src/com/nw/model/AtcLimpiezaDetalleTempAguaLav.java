package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_limpieza_detalle_temp_agua_lav database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_detalle_temp_agua_lav")
@NamedQuery(name="AtcLimpiezaDetalleTempAguaLav.findAll", query="SELECT a FROM AtcLimpiezaDetalleTempAguaLav a")
public class AtcLimpiezaDetalleTempAguaLav implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezadetalletempagualav;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestralote;
	private double temperatura;
	private String usuarioactualizacion;
	private AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote;
	private AtcLimpiezaTempAguaLav atcLimpiezaTempAguaLav;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcLimpiezaDetalleTempAguaLav() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatclimpiezadetalletempagualav() {
		return this.idatclimpiezadetalletempagualav;
	}

	public void setIdatclimpiezadetalletempagualav(Long idatclimpiezadetalletempagualav) {
		this.idatclimpiezadetalletempagualav = idatclimpiezadetalletempagualav;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Timestamp getFecharegactualizacion() {
		return this.fecharegactualizacion;
	}

	public void setFecharegactualizacion(Timestamp fecharegactualizacion) {
		this.fecharegactualizacion = fecharegactualizacion;
	}


	public Integer getNummuestralote() {
		return this.nummuestralote;
	}

	public void setNummuestralote(Integer nummuestralote) {
		this.nummuestralote = nummuestralote;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idatclimpiezadetalleprocesolote")
	public AtcLimpiezaDetalleProcesoLote getAtcLimpiezaDetalleProcesoLote() {
		return this.atcLimpiezaDetalleProcesoLote;
	}

	public void setAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		this.atcLimpiezaDetalleProcesoLote = atcLimpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcLimpiezaTempAguaLav
	@ManyToOne
	@JoinColumn(name="idatclimpiezatempagualav")
	public AtcLimpiezaTempAguaLav getAtcLimpiezaTempAguaLav() {
		return this.atcLimpiezaTempAguaLav;
	}

	public void setAtcLimpiezaTempAguaLav(AtcLimpiezaTempAguaLav atcLimpiezaTempAguaLav) {
		this.atcLimpiezaTempAguaLav = atcLimpiezaTempAguaLav;
	}


	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}


	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

}