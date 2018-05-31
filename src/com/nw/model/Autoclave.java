package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autoclave database table.
 * 
 */
@Entity
@NamedQuery(name="Autoclave.findAll", query="SELECT a FROM Autoclave a")
public class Autoclave implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idautoclave;
	private String descripcion;
	private List<EsterilizadoProcesoParada> esterilizadoProcesoParadas;

	public Autoclave() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdautoclave() {
		return this.idautoclave;
	}

	public void setIdautoclave(Integer idautoclave) {
		this.idautoclave = idautoclave;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EsterilizadoProcesoParada
	@OneToMany(mappedBy="autoclave")
	public List<EsterilizadoProcesoParada> getEsterilizadoProcesoParadas() {
		return this.esterilizadoProcesoParadas;
	}

	public void setEsterilizadoProcesoParadas(List<EsterilizadoProcesoParada> esterilizadoProcesoParadas) {
		this.esterilizadoProcesoParadas = esterilizadoProcesoParadas;
	}

	public EsterilizadoProcesoParada addEsterilizadoProcesoParada(EsterilizadoProcesoParada esterilizadoProcesoParada) {
		getEsterilizadoProcesoParadas().add(esterilizadoProcesoParada);
		esterilizadoProcesoParada.setAutoclave(this);

		return esterilizadoProcesoParada;
	}

	public EsterilizadoProcesoParada removeEsterilizadoProcesoParada(EsterilizadoProcesoParada esterilizadoProcesoParada) {
		getEsterilizadoProcesoParadas().remove(esterilizadoProcesoParada);
		esterilizadoProcesoParada.setAutoclave(null);

		return esterilizadoProcesoParada;
	}

}