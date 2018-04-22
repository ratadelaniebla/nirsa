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
public class AtcLimpiezaTempLomo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatclimpiezatemplomo;

	private Timestamp fechareg;

	//bi-directional many-to-one association to AtcLimpiezaDetalleTempLomo
	@OneToMany(mappedBy="atcLimpiezaTempLomo")
	private List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos;

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

	public AtcLimpiezaTempLomo() {
	}

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

	public List<AtcLimpiezaDetalleTempLomo> getAtcLimpiezaDetalleTempLomos() {
		return this.atcLimpiezaDetalleTempLomos;
	}

	public void setAtcLimpiezaDetalleTempLomos(List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos) {
		this.atcLimpiezaDetalleTempLomos = atcLimpiezaDetalleTempLomos;
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