package com.nw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the envasado_tamano_envase database table.
 * 
 */
@Entity
@Table(name="envasado_tamano_envase")
@NamedQuery(name="EnvasadoTamanoEnvase.findAll", query="SELECT e FROM EnvasadoTamanoEnvase e")
public class EnvasadoTamanoEnvase implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idenvasadotamanoenvase;
	private String descripcion;
	private List<EsterilizadoCoche> esterilizadoCoches;

	public EnvasadoTamanoEnvase() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdenvasadotamanoenvase() {
		return this.idenvasadotamanoenvase;
	}

	public void setIdenvasadotamanoenvase(Integer idenvasadotamanoenvase) {
		this.idenvasadotamanoenvase = idenvasadotamanoenvase;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EsterilizadoCoche
	@OneToMany(mappedBy="envasadoTamanoEnvase")
	public List<EsterilizadoCoche> getEsterilizadoCoches() {
		return this.esterilizadoCoches;
	}

	public void setEsterilizadoCoches(List<EsterilizadoCoche> esterilizadoCoches) {
		this.esterilizadoCoches = esterilizadoCoches;
	}

	public EsterilizadoCoche addEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().add(esterilizadoCoch);
		esterilizadoCoch.setEnvasadoTamanoEnvase(this);

		return esterilizadoCoch;
	}

	public EsterilizadoCoche removeEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().remove(esterilizadoCoch);
		esterilizadoCoch.setEnvasadoTamanoEnvase(null);

		return esterilizadoCoch;
	}

}