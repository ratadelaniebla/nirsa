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
public class AtcEvisceradoTempPanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcevisceradotemppanza;

	private Timestamp fechareg;

	//bi-directional many-to-one association to AtcEvisceradoDetalleTempPanza
	@OneToMany(mappedBy="atcEvisceradoTempPanza")
	private List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas;

	//bi-directional many-to-one association to AtcEvisceradoProceso
	@ManyToOne
	@JoinColumn(name="idatcevisceradoproceso")
	private AtcEvisceradoProceso atcEvisceradoProceso;

	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	private AtcTurno atcTurno;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	public AtcEvisceradoTempPanza() {
	}

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

	public List<AtcEvisceradoDetalleTempPanza> getAtcEvisceradoDetalleTempPanzas() {
		return this.atcEvisceradoDetalleTempPanzas;
	}

	public void setAtcEvisceradoDetalleTempPanzas(List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas) {
		this.atcEvisceradoDetalleTempPanzas = atcEvisceradoDetalleTempPanzas;
	}

	public AtcEvisceradoProceso getAtcEvisceradoProceso() {
		return this.atcEvisceradoProceso;
	}

	public void setAtcEvisceradoProceso(AtcEvisceradoProceso atcEvisceradoProceso) {
		this.atcEvisceradoProceso = atcEvisceradoProceso;
	}

	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}

	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

}