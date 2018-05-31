package com.nw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.nw.model.EnvasadoDetalleProcesoCambio;


/**
 * The persistent class for the envasado_motivo_cambios database table.
 * 
 */
@Entity
@Table(name="envasado_motivo_cambios")
@NamedQuery(name="EnvasadoMotivoCambio.findAll", query="SELECT e FROM EnvasadoMotivoCambio e")
public class EnvasadoMotivoCambio implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadomotivocambios;
	private String descripcion;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;

	public EnvasadoMotivoCambio() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadomotivocambios() {
		return this.idenvasadomotivocambios;
	}

	public void setIdenvasadomotivocambios(Long idenvasadomotivocambios) {
		this.idenvasadomotivocambios = idenvasadomotivocambios;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="envasadoMotivoCambio")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

	public EnvasadoDetalleProcesoCambio addEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().add(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setEnvasadoMotivoCambio(this);

		return envasadoDetalleProcesoCambio;
	}

	public EnvasadoDetalleProcesoCambio removeEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().remove(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setEnvasadoMotivoCambio(null);

		return envasadoDetalleProcesoCambio;
	}
}