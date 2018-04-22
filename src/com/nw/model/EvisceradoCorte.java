package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the eviscerado_corte database table.
 * 
 */
@Entity
@Table(name="eviscerado_corte")
public class EvisceradoCorte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idevisceradocorte;

	private String descripcion;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="evisceradoCorte")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoCorte")
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;

	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="evisceradoCorte")
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;

	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="evisceradoCorte")
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	public EvisceradoCorte() {
	}

	public Integer getIdevisceradocorte() {
		return this.idevisceradocorte;
	}

	public void setIdevisceradocorte(Integer idevisceradocorte) {
		this.idevisceradocorte = idevisceradocorte;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

}