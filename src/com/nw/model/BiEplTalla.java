package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bi_epl_talla database table.
 * 
 */
@Entity
@Table(name="bi_epl_talla")
public class BiEplTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbiepltallas;

	private Integer idevisceradopescadoslata;

	private Integer idtalla;

	public BiEplTalla() {
	}

	public Integer getIdbiepltallas() {
		return this.idbiepltallas;
	}

	public void setIdbiepltallas(Integer idbiepltallas) {
		this.idbiepltallas = idbiepltallas;
	}

	public Integer getIdevisceradopescadoslata() {
		return this.idevisceradopescadoslata;
	}

	public void setIdevisceradopescadoslata(Integer idevisceradopescadoslata) {
		this.idevisceradopescadoslata = idevisceradopescadoslata;
	}

	public Integer getIdtalla() {
		return this.idtalla;
	}

	public void setIdtalla(Integer idtalla) {
		this.idtalla = idtalla;
	}

}