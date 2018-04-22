package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_temp_agua_lav database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_temp_agua_lav")
public class AtcLimpiezaTempAguaLav implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatclimpiezatempagualav;

	private Timestamp fechareg;

	//bi-directional many-to-one association to AtcLimpiezaDetalleTempAguaLav
	@OneToMany(mappedBy="atcLimpiezaTempAguaLav")
	private List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs;

	//bi-directional many-to-one association to AtcLimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idatclimpiezaproceso")
	private AtcLimpiezaProceso atcLimpiezaProceso;

	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	private AtcTurno atcTurno;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	public AtcLimpiezaTempAguaLav() {
	}

	public Long getIdatclimpiezatempagualav() {
		return this.idatclimpiezatempagualav;
	}

	public void setIdatclimpiezatempagualav(Long idatclimpiezatempagualav) {
		this.idatclimpiezatempagualav = idatclimpiezatempagualav;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<AtcLimpiezaDetalleTempAguaLav> getAtcLimpiezaDetalleTempAguaLavs() {
		return this.atcLimpiezaDetalleTempAguaLavs;
	}

	public void setAtcLimpiezaDetalleTempAguaLavs(List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs) {
		this.atcLimpiezaDetalleTempAguaLavs = atcLimpiezaDetalleTempAguaLavs;
	}

	public AtcLimpiezaProceso getAtcLimpiezaProceso() {
		return this.atcLimpiezaProceso;
	}

	public void setAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		this.atcLimpiezaProceso = atcLimpiezaProceso;
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