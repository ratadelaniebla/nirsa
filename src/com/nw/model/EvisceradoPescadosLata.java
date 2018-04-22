package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the eviscerado_pescados_lata database table.
 * 
 */
@Entity
@Table(name="eviscerado_pescados_lata")
public class EvisceradoPescadosLata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idevisceradopescadoslata;

	private Integer cantidad;

	private String especificacion;

	//bi-directional many-to-one association to EstandarClasificacionProdTalla
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<EstandarClasificacionProdTalla> estandarClasificacionProdTallas;

	//bi-directional many-to-one association to EstandarClasificacionTalla
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<EstandarClasificacionTalla> estandarClasificacionTallas;

	//bi-directional many-to-one association to EstandarClasificacionTallaPlexus
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<EstandarClasificacionTallaPlexus> estandarClasificacionTallaPlexuses;

	//bi-directional many-to-one association to EstandarClasificacionXPeso
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<EstandarClasificacionXPeso> estandarClasificacionXPesos;

	//bi-directional many-to-one association to EstandarPonchadaTthh
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<EstandarPonchadaTthh> estandarPonchadaTthhs;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;

	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;

	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejadoT
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs;

	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="evisceradoPescadosLata")
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	public EvisceradoPescadosLata() {
	}

	public Integer getIdevisceradopescadoslata() {
		return this.idevisceradopescadoslata;
	}

	public void setIdevisceradopescadoslata(Integer idevisceradopescadoslata) {
		this.idevisceradopescadoslata = idevisceradopescadoslata;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getEspecificacion() {
		return this.especificacion;
	}

	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}

	public List<EstandarClasificacionProdTalla> getEstandarClasificacionProdTallas() {
		return this.estandarClasificacionProdTallas;
	}

	public void setEstandarClasificacionProdTallas(List<EstandarClasificacionProdTalla> estandarClasificacionProdTallas) {
		this.estandarClasificacionProdTallas = estandarClasificacionProdTallas;
	}

	public List<EstandarClasificacionTalla> getEstandarClasificacionTallas() {
		return this.estandarClasificacionTallas;
	}

	public void setEstandarClasificacionTallas(List<EstandarClasificacionTalla> estandarClasificacionTallas) {
		this.estandarClasificacionTallas = estandarClasificacionTallas;
	}

	public List<EstandarClasificacionTallaPlexus> getEstandarClasificacionTallaPlexuses() {
		return this.estandarClasificacionTallaPlexuses;
	}

	public void setEstandarClasificacionTallaPlexuses(List<EstandarClasificacionTallaPlexus> estandarClasificacionTallaPlexuses) {
		this.estandarClasificacionTallaPlexuses = estandarClasificacionTallaPlexuses;
	}

	public List<EstandarClasificacionXPeso> getEstandarClasificacionXPesos() {
		return this.estandarClasificacionXPesos;
	}

	public void setEstandarClasificacionXPesos(List<EstandarClasificacionXPeso> estandarClasificacionXPesos) {
		this.estandarClasificacionXPesos = estandarClasificacionXPesos;
	}

	public List<EstandarPonchadaTthh> getEstandarPonchadaTthhs() {
		return this.estandarPonchadaTthhs;
	}

	public void setEstandarPonchadaTthhs(List<EstandarPonchadaTthh> estandarPonchadaTthhs) {
		this.estandarPonchadaTthhs = estandarPonchadaTthhs;
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

	public List<LimpiezaDetallePesoDespellejadoT> getLimpiezaDetallePesoDespellejadoTs() {
		return this.limpiezaDetallePesoDespellejadoTs;
	}

	public void setLimpiezaDetallePesoDespellejadoTs(List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs) {
		this.limpiezaDetallePesoDespellejadoTs = limpiezaDetallePesoDespellejadoTs;
	}

	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

}