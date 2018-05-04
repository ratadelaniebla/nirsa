package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_eviscerado_detalle_temp_panza database table.
 * 
 */
@Entity
@Table(name="atc_eviscerado_detalle_temp_panza")
@NamedQuery(name="AtcEvisceradoDetalleTempPanza.findAll", query="SELECT a FROM AtcEvisceradoDetalleTempPanza a")
public class AtcEvisceradoDetalleTempPanza implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcevisceradodetalletemppanza;
	private Timestamp fechareg;
	private Timestamp fecharegactualizacion;
	private Integer nummuestralote;
	private double temperatura;
	private String usuarioactualizacion;
	private AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote;
	private AtcEvisceradoTempPanza atcEvisceradoTempPanza;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcEvisceradoDetalleTempPanza() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcevisceradodetalletemppanza() {
		return this.idatcevisceradodetalletemppanza;
	}

	public void setIdatcevisceradodetalletemppanza(Long idatcevisceradodetalletemppanza) {
		this.idatcevisceradodetalletemppanza = idatcevisceradodetalletemppanza;
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


	//bi-directional many-to-one association to AtcEvisceradoDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idatcevisceradodetalleprocesolote")
	public AtcEvisceradoDetalleProcesoLote getAtcEvisceradoDetalleProcesoLote() {
		return this.atcEvisceradoDetalleProcesoLote;
	}

	public void setAtcEvisceradoDetalleProcesoLote(AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote) {
		this.atcEvisceradoDetalleProcesoLote = atcEvisceradoDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcEvisceradoTempPanza
	@ManyToOne
	@JoinColumn(name="idatcevisceradotemppanza")
	public AtcEvisceradoTempPanza getAtcEvisceradoTempPanza() {
		return this.atcEvisceradoTempPanza;
	}

	public void setAtcEvisceradoTempPanza(AtcEvisceradoTempPanza atcEvisceradoTempPanza) {
		this.atcEvisceradoTempPanza = atcEvisceradoTempPanza;
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