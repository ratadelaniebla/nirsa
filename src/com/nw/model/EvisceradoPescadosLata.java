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
@NamedQuery(name="EvisceradoPescadosLata.findAll", query="SELECT e FROM EvisceradoPescadosLata e")
public class EvisceradoPescadosLata implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevisceradopescadoslata;
	private Integer cantidad;
	private String especificacion;
	private List<EstandarClasificacionProdTalla> estandarClasificacionProdTallas;
	private List<EstandarClasificacionTalla> estandarClasificacionTallas;
	private List<EstandarClasificacionTallaPlexus> estandarClasificacionTallaPlexuses;
	private List<EstandarClasificacionXPeso> estandarClasificacionXPesos;
	private List<EstandarPonchadaTthh> estandarPonchadaTthhs;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;
	private List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs;
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	public EvisceradoPescadosLata() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EstandarClasificacionProdTalla
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<EstandarClasificacionProdTalla> getEstandarClasificacionProdTallas() {
		return this.estandarClasificacionProdTallas;
	}

	public void setEstandarClasificacionProdTallas(List<EstandarClasificacionProdTalla> estandarClasificacionProdTallas) {
		this.estandarClasificacionProdTallas = estandarClasificacionProdTallas;
	}

	public EstandarClasificacionProdTalla addEstandarClasificacionProdTalla(EstandarClasificacionProdTalla estandarClasificacionProdTalla) {
		getEstandarClasificacionProdTallas().add(estandarClasificacionProdTalla);
		estandarClasificacionProdTalla.setEvisceradoPescadosLata(this);

		return estandarClasificacionProdTalla;
	}

	public EstandarClasificacionProdTalla removeEstandarClasificacionProdTalla(EstandarClasificacionProdTalla estandarClasificacionProdTalla) {
		getEstandarClasificacionProdTallas().remove(estandarClasificacionProdTalla);
		estandarClasificacionProdTalla.setEvisceradoPescadosLata(null);

		return estandarClasificacionProdTalla;
	}


	//bi-directional many-to-one association to EstandarClasificacionTalla
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<EstandarClasificacionTalla> getEstandarClasificacionTallas() {
		return this.estandarClasificacionTallas;
	}

	public void setEstandarClasificacionTallas(List<EstandarClasificacionTalla> estandarClasificacionTallas) {
		this.estandarClasificacionTallas = estandarClasificacionTallas;
	}

	public EstandarClasificacionTalla addEstandarClasificacionTalla(EstandarClasificacionTalla estandarClasificacionTalla) {
		getEstandarClasificacionTallas().add(estandarClasificacionTalla);
		estandarClasificacionTalla.setEvisceradoPescadosLata(this);

		return estandarClasificacionTalla;
	}

	public EstandarClasificacionTalla removeEstandarClasificacionTalla(EstandarClasificacionTalla estandarClasificacionTalla) {
		getEstandarClasificacionTallas().remove(estandarClasificacionTalla);
		estandarClasificacionTalla.setEvisceradoPescadosLata(null);

		return estandarClasificacionTalla;
	}


	//bi-directional many-to-one association to EstandarClasificacionTallaPlexus
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<EstandarClasificacionTallaPlexus> getEstandarClasificacionTallaPlexuses() {
		return this.estandarClasificacionTallaPlexuses;
	}

	public void setEstandarClasificacionTallaPlexuses(List<EstandarClasificacionTallaPlexus> estandarClasificacionTallaPlexuses) {
		this.estandarClasificacionTallaPlexuses = estandarClasificacionTallaPlexuses;
	}

	public EstandarClasificacionTallaPlexus addEstandarClasificacionTallaPlexus(EstandarClasificacionTallaPlexus estandarClasificacionTallaPlexus) {
		getEstandarClasificacionTallaPlexuses().add(estandarClasificacionTallaPlexus);
		estandarClasificacionTallaPlexus.setEvisceradoPescadosLata(this);

		return estandarClasificacionTallaPlexus;
	}

	public EstandarClasificacionTallaPlexus removeEstandarClasificacionTallaPlexus(EstandarClasificacionTallaPlexus estandarClasificacionTallaPlexus) {
		getEstandarClasificacionTallaPlexuses().remove(estandarClasificacionTallaPlexus);
		estandarClasificacionTallaPlexus.setEvisceradoPescadosLata(null);

		return estandarClasificacionTallaPlexus;
	}


	//bi-directional many-to-one association to EstandarClasificacionXPeso
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<EstandarClasificacionXPeso> getEstandarClasificacionXPesos() {
		return this.estandarClasificacionXPesos;
	}

	public void setEstandarClasificacionXPesos(List<EstandarClasificacionXPeso> estandarClasificacionXPesos) {
		this.estandarClasificacionXPesos = estandarClasificacionXPesos;
	}

	public EstandarClasificacionXPeso addEstandarClasificacionXPeso(EstandarClasificacionXPeso estandarClasificacionXPeso) {
		getEstandarClasificacionXPesos().add(estandarClasificacionXPeso);
		estandarClasificacionXPeso.setEvisceradoPescadosLata(this);

		return estandarClasificacionXPeso;
	}

	public EstandarClasificacionXPeso removeEstandarClasificacionXPeso(EstandarClasificacionXPeso estandarClasificacionXPeso) {
		getEstandarClasificacionXPesos().remove(estandarClasificacionXPeso);
		estandarClasificacionXPeso.setEvisceradoPescadosLata(null);

		return estandarClasificacionXPeso;
	}


	//bi-directional many-to-one association to EstandarPonchadaTthh
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<EstandarPonchadaTthh> getEstandarPonchadaTthhs() {
		return this.estandarPonchadaTthhs;
	}

	public void setEstandarPonchadaTthhs(List<EstandarPonchadaTthh> estandarPonchadaTthhs) {
		this.estandarPonchadaTthhs = estandarPonchadaTthhs;
	}

	public EstandarPonchadaTthh addEstandarPonchadaTthh(EstandarPonchadaTthh estandarPonchadaTthh) {
		getEstandarPonchadaTthhs().add(estandarPonchadaTthh);
		estandarPonchadaTthh.setEvisceradoPescadosLata(this);

		return estandarPonchadaTthh;
	}

	public EstandarPonchadaTthh removeEstandarPonchadaTthh(EstandarPonchadaTthh estandarPonchadaTthh) {
		getEstandarPonchadaTthhs().remove(estandarPonchadaTthh);
		estandarPonchadaTthh.setEvisceradoPescadosLata(null);

		return estandarPonchadaTthh;
	}


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().add(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setEvisceradoPescadosLata(this);

		return evisceradoCocheModificacion;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().remove(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setEvisceradoPescadosLata(null);

		return evisceradoCocheModificacion;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public EvisceradoDetalleProcesoCoche addEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().add(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setEvisceradoPescadosLata(this);

		return evisceradoDetalleProcesoCoch;
	}

	public EvisceradoDetalleProcesoCoche removeEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().remove(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setEvisceradoPescadosLata(null);

		return evisceradoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public LimpiezaDespellejadoPonchada addLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().add(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setEvisceradoPescadosLata(this);

		return limpiezaDespellejadoPonchada;
	}

	public LimpiezaDespellejadoPonchada removeLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().remove(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setEvisceradoPescadosLata(null);

		return limpiezaDespellejadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejadoT
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<LimpiezaDetallePesoDespellejadoT> getLimpiezaDetallePesoDespellejadoTs() {
		return this.limpiezaDetallePesoDespellejadoTs;
	}

	public void setLimpiezaDetallePesoDespellejadoTs(List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs) {
		this.limpiezaDetallePesoDespellejadoTs = limpiezaDetallePesoDespellejadoTs;
	}

	public LimpiezaDetallePesoDespellejadoT addLimpiezaDetallePesoDespellejadoT(LimpiezaDetallePesoDespellejadoT limpiezaDetallePesoDespellejadoT) {
		getLimpiezaDetallePesoDespellejadoTs().add(limpiezaDetallePesoDespellejadoT);
		limpiezaDetallePesoDespellejadoT.setEvisceradoPescadosLata(this);

		return limpiezaDetallePesoDespellejadoT;
	}

	public LimpiezaDetallePesoDespellejadoT removeLimpiezaDetallePesoDespellejadoT(LimpiezaDetallePesoDespellejadoT limpiezaDetallePesoDespellejadoT) {
		getLimpiezaDetallePesoDespellejadoTs().remove(limpiezaDetallePesoDespellejadoT);
		limpiezaDetallePesoDespellejadoT.setEvisceradoPescadosLata(null);

		return limpiezaDetallePesoDespellejadoT;
	}


	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="evisceradoPescadosLata")
	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public LimpiezaFileteadoPonchada addLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().add(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setEvisceradoPescadosLata(this);

		return limpiezaFileteadoPonchada;
	}

	public LimpiezaFileteadoPonchada removeLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().remove(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setEvisceradoPescadosLata(null);

		return limpiezaFileteadoPonchada;
	}

}