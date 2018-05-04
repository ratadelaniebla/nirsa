package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_temp_lomo database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_temp_lomo")
@NamedQuery(name="AtcLimpiezaTempLomo.findAll", query="SELECT a FROM AtcLimpiezaTempLomo a")
public class AtcLimpiezaTempLomo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezatemplomo;
	private Timestamp fechareg;
	private List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos;
	private AtcLimpiezaProceso atcLimpiezaProceso;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcLimpiezaTempLomo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatclimpiezatemplomo() {
		return this.idatclimpiezatemplomo;
	}

	public void setIdatclimpiezatemplomo(Long idatclimpiezatemplomo) {
		this.idatclimpiezatemplomo = idatclimpiezatemplomo;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleTempLomo
	@OneToMany(mappedBy="atcLimpiezaTempLomo")
	public List<AtcLimpiezaDetalleTempLomo> getAtcLimpiezaDetalleTempLomos() {
		return this.atcLimpiezaDetalleTempLomos;
	}

	public void setAtcLimpiezaDetalleTempLomos(List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos) {
		this.atcLimpiezaDetalleTempLomos = atcLimpiezaDetalleTempLomos;
	}

	public AtcLimpiezaDetalleTempLomo addAtcLimpiezaDetalleTempLomo(AtcLimpiezaDetalleTempLomo atcLimpiezaDetalleTempLomo) {
		getAtcLimpiezaDetalleTempLomos().add(atcLimpiezaDetalleTempLomo);
		atcLimpiezaDetalleTempLomo.setAtcLimpiezaTempLomo(this);

		return atcLimpiezaDetalleTempLomo;
	}

	public AtcLimpiezaDetalleTempLomo removeAtcLimpiezaDetalleTempLomo(AtcLimpiezaDetalleTempLomo atcLimpiezaDetalleTempLomo) {
		getAtcLimpiezaDetalleTempLomos().remove(atcLimpiezaDetalleTempLomo);
		atcLimpiezaDetalleTempLomo.setAtcLimpiezaTempLomo(null);

		return atcLimpiezaDetalleTempLomo;
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