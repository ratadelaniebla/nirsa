package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_tipo database table.
 * 
 */
@Entity
@Table(name="limpieza_tipo")
public class LimpiezaTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezatipo;

	private String descripcion;

	//bi-directional many-to-one association to BiEstandarClasificacionTalla
	@OneToMany(mappedBy="limpiezaTipo")
	private List<BiEstandarClasificacionTalla> biEstandarClasificacionTallas;

	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses;

	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPlexus
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses;

	//bi-directional many-to-one association to EstandarEficienciaAtun
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarEficienciaAtun> estandarEficienciaAtuns;

	//bi-directional many-to-one association to EstandarEficienciaAtunLimpio
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarEficienciaAtunLimpio> estandarEficienciaAtunLimpios;

	//bi-directional many-to-one association to EstandarEficienciaAtunLimpioP
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarEficienciaAtunLimpioP> estandarEficienciaAtunLimpioPs;

	//bi-directional many-to-one association to EstandarEficienciaLimpiezaKilosPorHoraTalla
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarEficienciaLimpiezaKilosPorHoraTalla> estandarEficienciaLimpiezaKilosPorHoraTallas;

	//bi-directional many-to-one association to EstandarEficienciaPonchadaPlexus
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarEficienciaPonchadaPlexus> estandarEficienciaPonchadaPlexuses;

	//bi-directional many-to-one association to EstandarIncentivoKilo
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarIncentivoKilo> estandarIncentivoKilos;

	//bi-directional many-to-one association to EstandarIncentivoKilosModelo2
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarIncentivoKilosModelo2> estandarIncentivoKilosModelo2s;

	//bi-directional many-to-one association to EstandarIncentivoKilosModelo3
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarIncentivoKilosModelo3> estandarIncentivoKilosModelo3s;

	//bi-directional many-to-one association to EstandarPonchadaTthh
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarPonchadaTthh> estandarPonchadaTthhs;

	//bi-directional many-to-one association to EstandarRalladoLinea
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EstandarRalladoLinea> estandarRalladoLineas;

	//bi-directional many-to-one association to EvolutionPlexusEstandarTarifa
	@OneToMany(mappedBy="limpiezaTipo")
	private List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas;

	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="limpiezaTipo")
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="limpiezaTipo")
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;

	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="limpiezaTipo")
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="limpiezaTipo")
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="limpiezaTipo")
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	public LimpiezaTipo() {
	}

	public Integer getIdlimpiezatipo() {
		return this.idlimpiezatipo;
	}

	public void setIdlimpiezatipo(Integer idlimpiezatipo) {
		this.idlimpiezatipo = idlimpiezatipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<BiEstandarClasificacionTalla> getBiEstandarClasificacionTallas() {
		return this.biEstandarClasificacionTallas;
	}

	public void setBiEstandarClasificacionTallas(List<BiEstandarClasificacionTalla> biEstandarClasificacionTallas) {
		this.biEstandarClasificacionTallas = biEstandarClasificacionTallas;
	}

	public List<EstandarDetalleEficienciaKilosPagoPlexus> getEstandarDetalleEficienciaKilosPagoPlexuses() {
		return this.estandarDetalleEficienciaKilosPagoPlexuses;
	}

	public void setEstandarDetalleEficienciaKilosPagoPlexuses(List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses) {
		this.estandarDetalleEficienciaKilosPagoPlexuses = estandarDetalleEficienciaKilosPagoPlexuses;
	}

	public List<EstandarDetalleEficienciaKilosPlexus> getEstandarDetalleEficienciaKilosPlexuses() {
		return this.estandarDetalleEficienciaKilosPlexuses;
	}

	public void setEstandarDetalleEficienciaKilosPlexuses(List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses) {
		this.estandarDetalleEficienciaKilosPlexuses = estandarDetalleEficienciaKilosPlexuses;
	}

	public List<EstandarEficienciaAtun> getEstandarEficienciaAtuns() {
		return this.estandarEficienciaAtuns;
	}

	public void setEstandarEficienciaAtuns(List<EstandarEficienciaAtun> estandarEficienciaAtuns) {
		this.estandarEficienciaAtuns = estandarEficienciaAtuns;
	}

	public List<EstandarEficienciaAtunLimpio> getEstandarEficienciaAtunLimpios() {
		return this.estandarEficienciaAtunLimpios;
	}

	public void setEstandarEficienciaAtunLimpios(List<EstandarEficienciaAtunLimpio> estandarEficienciaAtunLimpios) {
		this.estandarEficienciaAtunLimpios = estandarEficienciaAtunLimpios;
	}

	public List<EstandarEficienciaAtunLimpioP> getEstandarEficienciaAtunLimpioPs() {
		return this.estandarEficienciaAtunLimpioPs;
	}

	public void setEstandarEficienciaAtunLimpioPs(List<EstandarEficienciaAtunLimpioP> estandarEficienciaAtunLimpioPs) {
		this.estandarEficienciaAtunLimpioPs = estandarEficienciaAtunLimpioPs;
	}

	public List<EstandarEficienciaLimpiezaKilosPorHoraTalla> getEstandarEficienciaLimpiezaKilosPorHoraTallas() {
		return this.estandarEficienciaLimpiezaKilosPorHoraTallas;
	}

	public void setEstandarEficienciaLimpiezaKilosPorHoraTallas(List<EstandarEficienciaLimpiezaKilosPorHoraTalla> estandarEficienciaLimpiezaKilosPorHoraTallas) {
		this.estandarEficienciaLimpiezaKilosPorHoraTallas = estandarEficienciaLimpiezaKilosPorHoraTallas;
	}

	public List<EstandarEficienciaPonchadaPlexus> getEstandarEficienciaPonchadaPlexuses() {
		return this.estandarEficienciaPonchadaPlexuses;
	}

	public void setEstandarEficienciaPonchadaPlexuses(List<EstandarEficienciaPonchadaPlexus> estandarEficienciaPonchadaPlexuses) {
		this.estandarEficienciaPonchadaPlexuses = estandarEficienciaPonchadaPlexuses;
	}

	public List<EstandarIncentivoKilo> getEstandarIncentivoKilos() {
		return this.estandarIncentivoKilos;
	}

	public void setEstandarIncentivoKilos(List<EstandarIncentivoKilo> estandarIncentivoKilos) {
		this.estandarIncentivoKilos = estandarIncentivoKilos;
	}

	public List<EstandarIncentivoKilosModelo2> getEstandarIncentivoKilosModelo2s() {
		return this.estandarIncentivoKilosModelo2s;
	}

	public void setEstandarIncentivoKilosModelo2s(List<EstandarIncentivoKilosModelo2> estandarIncentivoKilosModelo2s) {
		this.estandarIncentivoKilosModelo2s = estandarIncentivoKilosModelo2s;
	}

	public List<EstandarIncentivoKilosModelo3> getEstandarIncentivoKilosModelo3s() {
		return this.estandarIncentivoKilosModelo3s;
	}

	public void setEstandarIncentivoKilosModelo3s(List<EstandarIncentivoKilosModelo3> estandarIncentivoKilosModelo3s) {
		this.estandarIncentivoKilosModelo3s = estandarIncentivoKilosModelo3s;
	}

	public List<EstandarPonchadaTthh> getEstandarPonchadaTthhs() {
		return this.estandarPonchadaTthhs;
	}

	public void setEstandarPonchadaTthhs(List<EstandarPonchadaTthh> estandarPonchadaTthhs) {
		this.estandarPonchadaTthhs = estandarPonchadaTthhs;
	}

	public List<EstandarRalladoLinea> getEstandarRalladoLineas() {
		return this.estandarRalladoLineas;
	}

	public void setEstandarRalladoLineas(List<EstandarRalladoLinea> estandarRalladoLineas) {
		this.estandarRalladoLineas = estandarRalladoLineas;
	}

	public List<EvolutionPlexusEstandarTarifa> getEvolutionPlexusEstandarTarifas() {
		return this.evolutionPlexusEstandarTarifas;
	}

	public void setEvolutionPlexusEstandarTarifas(List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas) {
		this.evolutionPlexusEstandarTarifas = evolutionPlexusEstandarTarifas;
	}

	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public List<LimpiezaDetalleProcesoLote> getLimpiezaDetalleProcesoLotes() {
		return this.limpiezaDetalleProcesoLotes;
	}

	public void setLimpiezaDetalleProcesoLotes(List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes) {
		this.limpiezaDetalleProcesoLotes = limpiezaDetalleProcesoLotes;
	}

	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public List<LimpiezaProcesoLoteActivo> getLimpiezaProcesoLoteActivos() {
		return this.limpiezaProcesoLoteActivos;
	}

	public void setLimpiezaProcesoLoteActivos(List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos) {
		this.limpiezaProcesoLoteActivos = limpiezaProcesoLoteActivos;
	}

	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

}