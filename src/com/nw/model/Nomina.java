package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nomina database table.
 * 
 */
@Entity
public class Nomina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idnomina;

	private String nombrenomina;

	//bi-directional many-to-one association to CentroCosto
	@ManyToOne
	@JoinColumn(name="idcentrocosto")
	private CentroCosto centroCosto;

	public Nomina() {
	}

	public Long getIdnomina() {
		return this.idnomina;
	}

	public void setIdnomina(Long idnomina) {
		this.idnomina = idnomina;
	}

	public String getNombrenomina() {
		return this.nombrenomina;
	}

	public void setNombrenomina(String nombrenomina) {
		this.nombrenomina = nombrenomina;
	}

	public CentroCosto getCentroCosto() {
		return this.centroCosto;
	}

	public void setCentroCosto(CentroCosto centroCosto) {
		this.centroCosto = centroCosto;
	}

}