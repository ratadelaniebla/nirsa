package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the envasado_caldo_vegetal_proteina database table.
 * 
 */
@Entity
@Table(name="envasado_caldo_vegetal_proteina")
public class EnvasadoCaldoVegetalProteina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idenvasadocaldovegetalproteina;
	private String descripcion;
	private List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras;

	public EnvasadoCaldoVegetalProteina() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdenvasadocaldovegetalproteina() {
		return this.idenvasadocaldovegetalproteina;
	}

	public void setIdenvasadocaldovegetalproteina(Integer idenvasadocaldovegetalproteina) {
		this.idenvasadocaldovegetalproteina = idenvasadocaldovegetalproteina;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillCabecera
	@OneToMany(mappedBy="envasadoCaldoVegetalProteina")
	public List<EnvasadoControlPesoFillCabecera> getEnvasadoControlPesoFillCabeceras() {
		return this.envasadoControlPesoFillCabeceras;
	}

	public void setEnvasadoControlPesoFillCabeceras(List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras) {
		this.envasadoControlPesoFillCabeceras = envasadoControlPesoFillCabeceras;
	}

}