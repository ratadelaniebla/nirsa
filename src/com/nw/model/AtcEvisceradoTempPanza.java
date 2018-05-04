package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_eviscerado_temp_panza database table.
 * 
 */
@Entity
@Table(name="atc_eviscerado_temp_panza")
@NamedQuery(name="AtcEvisceradoTempPanza.findAll", query="SELECT a FROM AtcEvisceradoTempPanza a")
public class AtcEvisceradoTempPanza implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcevisceradotemppanza;
	private Timestamp fechareg;
	private List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas;
	private AtcEvisceradoProceso atcEvisceradoProceso;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcEvisceradoTempPanza() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcevisceradotemppanza() {
		return this.idatcevisceradotemppanza;
	}

	public void setIdatcevisceradotemppanza(Long idatcevisceradotemppanza) {
		this.idatcevisceradotemppanza = idatcevisceradotemppanza;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to AtcEvisceradoDetalleTempPanza
	@OneToMany(mappedBy="atcEvisceradoTempPanza")
	public List<AtcEvisceradoDetalleTempPanza> getAtcEvisceradoDetalleTempPanzas() {
		return this.atcEvisceradoDetalleTempPanzas;
	}

	public void setAtcEvisceradoDetalleTempPanzas(List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas) {
		this.atcEvisceradoDetalleTempPanzas = atcEvisceradoDetalleTempPanzas;
	}

	public AtcEvisceradoDetalleTempPanza addAtcEvisceradoDetalleTempPanza(AtcEvisceradoDetalleTempPanza atcEvisceradoDetalleTempPanza) {
		getAtcEvisceradoDetalleTempPanzas().add(atcEvisceradoDetalleTempPanza);
		atcEvisceradoDetalleTempPanza.setAtcEvisceradoTempPanza(this);

		return atcEvisceradoDetalleTempPanza;
	}

	public AtcEvisceradoDetalleTempPanza removeAtcEvisceradoDetalleTempPanza(AtcEvisceradoDetalleTempPanza atcEvisceradoDetalleTempPanza) {
		getAtcEvisceradoDetalleTempPanzas().remove(atcEvisceradoDetalleTempPanza);
		atcEvisceradoDetalleTempPanza.setAtcEvisceradoTempPanza(null);

		return atcEvisceradoDetalleTempPanza;
	}


	//bi-directional many-to-one association to AtcEvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idatcevisceradoproceso")
	public AtcEvisceradoProceso getAtcEvisceradoProceso() {
		return this.atcEvisceradoProceso;
	}

	public void setAtcEvisceradoProceso(AtcEvisceradoProceso atcEvisceradoProceso) {
		this.atcEvisceradoProceso = atcEvisceradoProceso;
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