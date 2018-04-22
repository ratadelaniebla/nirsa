package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cocina_proceso_control_espina database table.
 * 
 */
@Entity
@Table(name="cocina_proceso_control_espina")
public class CocinaProcesoControlEspina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcocinaprocesocontrolespina;

	private Integer numeroespina;

	//bi-directional many-to-one association to CocinaProcesoControlEspinaDetalle
	@OneToMany(mappedBy="cocinaProcesoControlEspina")
	private List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles;

	public CocinaProcesoControlEspina() {
	}

	public Integer getIdcocinaprocesocontrolespina() {
		return this.idcocinaprocesocontrolespina;
	}

	public void setIdcocinaprocesocontrolespina(Integer idcocinaprocesocontrolespina) {
		this.idcocinaprocesocontrolespina = idcocinaprocesocontrolespina;
	}

	public Integer getNumeroespina() {
		return this.numeroespina;
	}

	public void setNumeroespina(Integer numeroespina) {
		this.numeroespina = numeroespina;
	}

	public List<CocinaProcesoControlEspinaDetalle> getCocinaProcesoControlEspinaDetalles() {
		return this.cocinaProcesoControlEspinaDetalles;
	}

	public void setCocinaProcesoControlEspinaDetalles(List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles) {
		this.cocinaProcesoControlEspinaDetalles = cocinaProcesoControlEspinaDetalles;
	}

}