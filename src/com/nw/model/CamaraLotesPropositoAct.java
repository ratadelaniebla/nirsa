package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the camara_lotes_proposito_act database table.
 * 
 */
@Entity
@Table(name="camara_lotes_proposito_act")
public class CamaraLotesPropositoAct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_camara_lotes_proposito_act")
	private Long idCamaraLotesPropositoAct;

	private String lotesap;

	private String proposito;

	public CamaraLotesPropositoAct() {
	}

	public Long getIdCamaraLotesPropositoAct() {
		return this.idCamaraLotesPropositoAct;
	}

	public void setIdCamaraLotesPropositoAct(Long idCamaraLotesPropositoAct) {
		this.idCamaraLotesPropositoAct = idCamaraLotesPropositoAct;
	}

	public String getLotesap() {
		return this.lotesap;
	}

	public void setLotesap(String lotesap) {
		this.lotesap = lotesap;
	}

	public String getProposito() {
		return this.proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

}