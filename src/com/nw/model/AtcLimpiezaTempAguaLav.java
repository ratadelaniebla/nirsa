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
@NamedQuery(name="AtcLimpiezaTempAguaLav.findAll", query="SELECT a FROM AtcLimpiezaTempAguaLav a")
public class AtcLimpiezaTempAguaLav implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezatempagualav;
	private Timestamp fechareg;
	private List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs;
	private AtcLimpiezaProceso atcLimpiezaProceso;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcLimpiezaTempAguaLav() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcLimpiezaDetalleTempAguaLav
	@OneToMany(mappedBy="atcLimpiezaTempAguaLav")
	public List<AtcLimpiezaDetalleTempAguaLav> getAtcLimpiezaDetalleTempAguaLavs() {
		return this.atcLimpiezaDetalleTempAguaLavs;
	}

	public void setAtcLimpiezaDetalleTempAguaLavs(List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs) {
		this.atcLimpiezaDetalleTempAguaLavs = atcLimpiezaDetalleTempAguaLavs;
	}

	public AtcLimpiezaDetalleTempAguaLav addAtcLimpiezaDetalleTempAguaLav(AtcLimpiezaDetalleTempAguaLav atcLimpiezaDetalleTempAguaLav) {
		getAtcLimpiezaDetalleTempAguaLavs().add(atcLimpiezaDetalleTempAguaLav);
		atcLimpiezaDetalleTempAguaLav.setAtcLimpiezaTempAguaLav(this);

		return atcLimpiezaDetalleTempAguaLav;
	}

	public AtcLimpiezaDetalleTempAguaLav removeAtcLimpiezaDetalleTempAguaLav(AtcLimpiezaDetalleTempAguaLav atcLimpiezaDetalleTempAguaLav) {
		getAtcLimpiezaDetalleTempAguaLavs().remove(atcLimpiezaDetalleTempAguaLav);
		atcLimpiezaDetalleTempAguaLav.setAtcLimpiezaTempAguaLav(null);

		return atcLimpiezaDetalleTempAguaLav;
	}


	//bi-directional many-to-one association to AtcLimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idatclimpiezaproceso")
	public AtcLimpiezaProceso getAtcLimpiezaProceso() {
		return this.atcLimpiezaProceso;
	}

	public void setAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		this.atcLimpiezaProceso = atcLimpiezaProceso;
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