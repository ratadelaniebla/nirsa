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
@NamedQuery(name="CocinaProcesoControlEspina.findAll", query="SELECT c FROM CocinaProcesoControlEspina c")
public class CocinaProcesoControlEspina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcocinaprocesocontrolespina;
	private Integer numeroespina;
	private List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles;

	public CocinaProcesoControlEspina() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CocinaProcesoControlEspinaDetalle
	@OneToMany(mappedBy="cocinaProcesoControlEspina")
	public List<CocinaProcesoControlEspinaDetalle> getCocinaProcesoControlEspinaDetalles() {
		return this.cocinaProcesoControlEspinaDetalles;
	}

	public void setCocinaProcesoControlEspinaDetalles(List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles) {
		this.cocinaProcesoControlEspinaDetalles = cocinaProcesoControlEspinaDetalles;
	}

	public CocinaProcesoControlEspinaDetalle addCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		getCocinaProcesoControlEspinaDetalles().add(cocinaProcesoControlEspinaDetalle);
		cocinaProcesoControlEspinaDetalle.setCocinaProcesoControlEspina(this);

		return cocinaProcesoControlEspinaDetalle;
	}

	public CocinaProcesoControlEspinaDetalle removeCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		getCocinaProcesoControlEspinaDetalles().remove(cocinaProcesoControlEspinaDetalle);
		cocinaProcesoControlEspinaDetalle.setCocinaProcesoControlEspina(null);

		return cocinaProcesoControlEspinaDetalle;
	}

}