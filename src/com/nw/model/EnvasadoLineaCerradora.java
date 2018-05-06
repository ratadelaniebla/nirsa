package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the envasado_linea_cerradora database table.
 * 
 */
@Entity
@Table(name="envasado_linea_cerradora")
@NamedQuery(name="EnvasadoLineaCerradora.findAll", query="SELECT e FROM EnvasadoLineaCerradora e")
public class EnvasadoLineaCerradora implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idenvasadolineacerradora;
	private Integer numeroenvasadolineacerradora;
	private List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras;

	public EnvasadoLineaCerradora() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdenvasadolineacerradora() {
		return this.idenvasadolineacerradora;
	}

	public void setIdenvasadolineacerradora(Integer idenvasadolineacerradora) {
		this.idenvasadolineacerradora = idenvasadolineacerradora;
	}


	public Integer getNumeroenvasadolineacerradora() {
		return this.numeroenvasadolineacerradora;
	}

	public void setNumeroenvasadolineacerradora(Integer numeroenvasadolineacerradora) {
		this.numeroenvasadolineacerradora = numeroenvasadolineacerradora;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillCabecera
	@OneToMany(mappedBy="envasadoLineaCerradora")
	public List<EnvasadoControlPesoFillCabecera> getEnvasadoControlPesoFillCabeceras() {
		return this.envasadoControlPesoFillCabeceras;
	}

	public void setEnvasadoControlPesoFillCabeceras(List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras) {
		this.envasadoControlPesoFillCabeceras = envasadoControlPesoFillCabeceras;
	}

	public EnvasadoControlPesoFillCabecera addEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().add(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setEnvasadoLineaCerradora(this);

		return envasadoControlPesoFillCabecera;
	}

	public EnvasadoControlPesoFillCabecera removeEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().remove(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setEnvasadoLineaCerradora(null);

		return envasadoControlPesoFillCabecera;
	}

}