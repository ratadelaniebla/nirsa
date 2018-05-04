package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the barco_estiba_cuba_detalle_mezcla database table.
 * 
 */
@Entity
@Table(name="barco_estiba_cuba_detalle_mezcla")
@NamedQuery(name="BarcoEstibaCubaDetalleMezcla.findAll", query="SELECT b FROM BarcoEstibaCubaDetalleMezcla b")
public class BarcoEstibaCubaDetalleMezcla implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idbarcoestibacubadetallemezcla;
	private BarcoEstibaCuba barcoEstibaCuba;
	private CamaraCajon camaraCajon;

	public BarcoEstibaCubaDetalleMezcla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdbarcoestibacubadetallemezcla() {
		return this.idbarcoestibacubadetallemezcla;
	}

	public void setIdbarcoestibacubadetallemezcla(Long idbarcoestibacubadetallemezcla) {
		this.idbarcoestibacubadetallemezcla = idbarcoestibacubadetallemezcla;
	}


	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}


	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}

}