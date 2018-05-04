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
@NamedQuery(name="EnvasadoCaldoVegetalProteina.findAll", query="SELECT e FROM EnvasadoCaldoVegetalProteina e")
public class EnvasadoCaldoVegetalProteina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idenvasadocaldovegetalproteina;
	private String descripcion;
	private List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras;
	private List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras;

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

	public EnvasadoControlPesoFillCabecera addEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().add(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setEnvasadoCaldoVegetalProteina(this);

		return envasadoControlPesoFillCabecera;
	}

	public EnvasadoControlPesoFillCabecera removeEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().remove(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setEnvasadoCaldoVegetalProteina(null);

		return envasadoControlPesoFillCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoNetoCabecera
	@OneToMany(mappedBy="envasadoCaldoVegetalProteina")
	public List<EnvasadoControlPesoNetoCabecera> getEnvasadoControlPesoNetoCabeceras() {
		return this.envasadoControlPesoNetoCabeceras;
	}

	public void setEnvasadoControlPesoNetoCabeceras(List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras) {
		this.envasadoControlPesoNetoCabeceras = envasadoControlPesoNetoCabeceras;
	}

	public EnvasadoControlPesoNetoCabecera addEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().add(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setEnvasadoCaldoVegetalProteina(this);

		return envasadoControlPesoNetoCabecera;
	}

	public EnvasadoControlPesoNetoCabecera removeEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().remove(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setEnvasadoCaldoVegetalProteina(null);

		return envasadoControlPesoNetoCabecera;
	}

}