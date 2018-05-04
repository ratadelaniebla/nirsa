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
@NamedQuery(name="EvisceradoCorte.findAll", query="SELECT e FROM EvisceradoCorte e")
public class EvisceradoCorte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevisceradocorte;
	private String descripcion;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	public EvisceradoCorte() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="evisceradoCorte")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().add(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setEvisceradoCorte(this);

		return evisceradoCocheModificacion;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().remove(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setEvisceradoCorte(null);

		return evisceradoCocheModificacion;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoCorte")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public EvisceradoDetalleProcesoCoche addEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().add(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setEvisceradoCorte(this);

		return evisceradoDetalleProcesoCoch;
	}

	public EvisceradoDetalleProcesoCoche removeEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().remove(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setEvisceradoCorte(null);

		return evisceradoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="evisceradoCorte")
	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public LimpiezaDespellejadoPonchada addLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().add(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setEvisceradoCorte(this);

		return limpiezaDespellejadoPonchada;
	}

	public LimpiezaDespellejadoPonchada removeLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().remove(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setEvisceradoCorte(null);

		return limpiezaDespellejadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="evisceradoCorte")
	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public LimpiezaFileteadoPonchada addLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().add(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setEvisceradoCorte(this);

		return limpiezaFileteadoPonchada;
	}

	public LimpiezaFileteadoPonchada removeLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().remove(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setEvisceradoCorte(null);

		return limpiezaFileteadoPonchada;
	}

}