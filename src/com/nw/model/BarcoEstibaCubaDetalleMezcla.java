package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the barco_estiba_cuba_detalle_mezcla database table.
 * 
 */
@Entity
@Table(name="barco_estiba_cuba_detalle_mezcla")
public class BarcoEstibaCubaDetalleMezcla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbarcoestibacubadetallemezcla;

	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	private BarcoEstibaCuba barcoEstibaCuba;

	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	private CamaraCajon camaraCajon;

	public BarcoEstibaCubaDetalleMezcla() {
	}

	public Long getIdbarcoestibacubadetallemezcla() {
		return this.idbarcoestibacubadetallemezcla;
	}

	public void setIdbarcoestibacubadetallemezcla(Long idbarcoestibacubadetallemezcla) {
		this.idbarcoestibacubadetallemezcla = idbarcoestibacubadetallemezcla;
	}

	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}

	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}

}