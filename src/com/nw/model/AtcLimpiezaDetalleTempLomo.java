package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_limpieza_detalle_temp_lomo database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_detalle_temp_lomo")
@NamedQuery(name="AtcLimpiezaDetalleTempLomo.findAll", query="SELECT a FROM AtcLimpiezaDetalleTempLomo a")
public class AtcLimpiezaDetalleTempLomo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezadetalletemplomo;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestralote;
	private double temperatura;
	private String usuarioactualizacion;
	private AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote;
	private AtcLimpiezaTempLomo atcLimpiezaTempLomo;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcLimpiezaDetalleTempLomo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatclimpiezadetalletemplomo() {
		return this.idatclimpiezadetalletemplomo;
	}

	public void setIdatclimpiezadetalletemplomo(Long idatclimpiezadetalletemplomo) {
		this.idatclimpiezadetalletemplomo = idatclimpiezadetalletemplomo;
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


	//bi-directional many-to-one association to AtcLimpiezaTempLomo
	@ManyToOne
	@JoinColumn(name="idatclimpiezatemplomo")
	public AtcLimpiezaTempLomo getAtcLimpiezaTempLomo() {
		return this.atcLimpiezaTempLomo;
	}

	public void setAtcLimpiezaTempLomo(AtcLimpiezaTempLomo atcLimpiezaTempLomo) {
		this.atcLimpiezaTempLomo = atcLimpiezaTempLomo;
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