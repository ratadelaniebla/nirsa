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
@NamedQuery(name="LimpiezaTipo.findAll", query="SELECT l FROM LimpiezaTipo l")
public class LimpiezaTipo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezatipo;
	private String descripcion;
	private List<BiEstandarClasificacionTalla> biEstandarClasificacionTallas;
	private List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses;
	private List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses;
	private List<EstandarEficienciaAtun> estandarEficienciaAtuns;
	private List<EstandarEficienciaAtunLimpio> estandarEficienciaAtunLimpios;
	private List<EstandarEficienciaAtunLimpioP> estandarEficienciaAtunLimpioPs;
	private List<EstandarEficienciaLimpiezaKilosPorHoraTalla> estandarEficienciaLimpiezaKilosPorHoraTallas;
	private List<EstandarEficienciaPonchadaPlexus> estandarEficienciaPonchadaPlexuses;
	private List<EstandarIncentivoKilo> estandarIncentivoKilos;
	private List<EstandarIncentivoKilosModelo2> estandarIncentivoKilosModelo2s;
	private List<EstandarIncentivoKilosModelo3> estandarIncentivoKilosModelo3s;
	private List<EstandarPonchadaTthh> estandarPonchadaTthhs;
	private List<EstandarRalladoLinea> estandarRalladoLineas;
	private List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas;
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	public LimpiezaTipo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to BiEstandarClasificacionTalla
	@OneToMany(mappedBy="limpiezaTipo")
	public List<BiEstandarClasificacionTalla> getBiEstandarClasificacionTallas() {
		return this.biEstandarClasificacionTallas;
	}

	public void setBiEstandarClasificacionTallas(List<BiEstandarClasificacionTalla> biEstandarClasificacionTallas) {
		this.biEstandarClasificacionTallas = biEstandarClasificacionTallas;
	}

	public BiEstandarClasificacionTalla addBiEstandarClasificacionTalla(BiEstandarClasificacionTalla biEstandarClasificacionTalla) {
		getBiEstandarClasificacionTallas().add(biEstandarClasificacionTalla);
		biEstandarClasificacionTalla.setLimpiezaTipo(this);

		return biEstandarClasificacionTalla;
	}

	public BiEstandarClasificacionTalla removeBiEstandarClasificacionTalla(BiEstandarClasificacionTalla biEstandarClasificacionTalla) {
		getBiEstandarClasificacionTallas().remove(biEstandarClasificacionTalla);
		biEstandarClasificacionTalla.setLimpiezaTipo(null);

		return biEstandarClasificacionTalla;
	}


	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarDetalleEficienciaKilosPagoPlexus> getEstandarDetalleEficienciaKilosPagoPlexuses() {
		return this.estandarDetalleEficienciaKilosPagoPlexuses;
	}

	public void setEstandarDetalleEficienciaKilosPagoPlexuses(List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses) {
		this.estandarDetalleEficienciaKilosPagoPlexuses = estandarDetalleEficienciaKilosPagoPlexuses;
	}

	public EstandarDetalleEficienciaKilosPagoPlexus addEstandarDetalleEficienciaKilosPagoPlexus(EstandarDetalleEficienciaKilosPagoPlexus estandarDetalleEficienciaKilosPagoPlexus) {
		getEstandarDetalleEficienciaKilosPagoPlexuses().add(estandarDetalleEficienciaKilosPagoPlexus);
		estandarDetalleEficienciaKilosPagoPlexus.setLimpiezaTipo(this);

		return estandarDetalleEficienciaKilosPagoPlexus;
	}

	public EstandarDetalleEficienciaKilosPagoPlexus removeEstandarDetalleEficienciaKilosPagoPlexus(EstandarDetalleEficienciaKilosPagoPlexus estandarDetalleEficienciaKilosPagoPlexus) {
		getEstandarDetalleEficienciaKilosPagoPlexuses().remove(estandarDetalleEficienciaKilosPagoPlexus);
		estandarDetalleEficienciaKilosPagoPlexus.setLimpiezaTipo(null);

		return estandarDetalleEficienciaKilosPagoPlexus;
	}


	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPlexus
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarDetalleEficienciaKilosPlexus> getEstandarDetalleEficienciaKilosPlexuses() {
		return this.estandarDetalleEficienciaKilosPlexuses;
	}

	public void setEstandarDetalleEficienciaKilosPlexuses(List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses) {
		this.estandarDetalleEficienciaKilosPlexuses = estandarDetalleEficienciaKilosPlexuses;
	}

	public EstandarDetalleEficienciaKilosPlexus addEstandarDetalleEficienciaKilosPlexus(EstandarDetalleEficienciaKilosPlexus estandarDetalleEficienciaKilosPlexus) {
		getEstandarDetalleEficienciaKilosPlexuses().add(estandarDetalleEficienciaKilosPlexus);
		estandarDetalleEficienciaKilosPlexus.setLimpiezaTipo(this);

		return estandarDetalleEficienciaKilosPlexus;
	}

	public EstandarDetalleEficienciaKilosPlexus removeEstandarDetalleEficienciaKilosPlexus(EstandarDetalleEficienciaKilosPlexus estandarDetalleEficienciaKilosPlexus) {
		getEstandarDetalleEficienciaKilosPlexuses().remove(estandarDetalleEficienciaKilosPlexus);
		estandarDetalleEficienciaKilosPlexus.setLimpiezaTipo(null);

		return estandarDetalleEficienciaKilosPlexus;
	}


	//bi-directional many-to-one association to EstandarEficienciaAtun
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarEficienciaAtun> getEstandarEficienciaAtuns() {
		return this.estandarEficienciaAtuns;
	}

	public void setEstandarEficienciaAtuns(List<EstandarEficienciaAtun> estandarEficienciaAtuns) {
		this.estandarEficienciaAtuns = estandarEficienciaAtuns;
	}

	public EstandarEficienciaAtun addEstandarEficienciaAtun(EstandarEficienciaAtun estandarEficienciaAtun) {
		getEstandarEficienciaAtuns().add(estandarEficienciaAtun);
		estandarEficienciaAtun.setLimpiezaTipo(this);

		return estandarEficienciaAtun;
	}

	public EstandarEficienciaAtun removeEstandarEficienciaAtun(EstandarEficienciaAtun estandarEficienciaAtun) {
		getEstandarEficienciaAtuns().remove(estandarEficienciaAtun);
		estandarEficienciaAtun.setLimpiezaTipo(null);

		return estandarEficienciaAtun;
	}


	//bi-directional many-to-one association to EstandarEficienciaAtunLimpio
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarEficienciaAtunLimpio> getEstandarEficienciaAtunLimpios() {
		return this.estandarEficienciaAtunLimpios;
	}

	public void setEstandarEficienciaAtunLimpios(List<EstandarEficienciaAtunLimpio> estandarEficienciaAtunLimpios) {
		this.estandarEficienciaAtunLimpios = estandarEficienciaAtunLimpios;
	}

	public EstandarEficienciaAtunLimpio addEstandarEficienciaAtunLimpio(EstandarEficienciaAtunLimpio estandarEficienciaAtunLimpio) {
		getEstandarEficienciaAtunLimpios().add(estandarEficienciaAtunLimpio);
		estandarEficienciaAtunLimpio.setLimpiezaTipo(this);

		return estandarEficienciaAtunLimpio;
	}

	public EstandarEficienciaAtunLimpio removeEstandarEficienciaAtunLimpio(EstandarEficienciaAtunLimpio estandarEficienciaAtunLimpio) {
		getEstandarEficienciaAtunLimpios().remove(estandarEficienciaAtunLimpio);
		estandarEficienciaAtunLimpio.setLimpiezaTipo(null);

		return estandarEficienciaAtunLimpio;
	}


	//bi-directional many-to-one association to EstandarEficienciaAtunLimpioP
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarEficienciaAtunLimpioP> getEstandarEficienciaAtunLimpioPs() {
		return this.estandarEficienciaAtunLimpioPs;
	}

	public void setEstandarEficienciaAtunLimpioPs(List<EstandarEficienciaAtunLimpioP> estandarEficienciaAtunLimpioPs) {
		this.estandarEficienciaAtunLimpioPs = estandarEficienciaAtunLimpioPs;
	}

	public EstandarEficienciaAtunLimpioP addEstandarEficienciaAtunLimpioP(EstandarEficienciaAtunLimpioP estandarEficienciaAtunLimpioP) {
		getEstandarEficienciaAtunLimpioPs().add(estandarEficienciaAtunLimpioP);
		estandarEficienciaAtunLimpioP.setLimpiezaTipo(this);

		return estandarEficienciaAtunLimpioP;
	}

	public EstandarEficienciaAtunLimpioP removeEstandarEficienciaAtunLimpioP(EstandarEficienciaAtunLimpioP estandarEficienciaAtunLimpioP) {
		getEstandarEficienciaAtunLimpioPs().remove(estandarEficienciaAtunLimpioP);
		estandarEficienciaAtunLimpioP.setLimpiezaTipo(null);

		return estandarEficienciaAtunLimpioP;
	}


	//bi-directional many-to-one association to EstandarEficienciaLimpiezaKilosPorHoraTalla
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarEficienciaLimpiezaKilosPorHoraTalla> getEstandarEficienciaLimpiezaKilosPorHoraTallas() {
		return this.estandarEficienciaLimpiezaKilosPorHoraTallas;
	}

	public void setEstandarEficienciaLimpiezaKilosPorHoraTallas(List<EstandarEficienciaLimpiezaKilosPorHoraTalla> estandarEficienciaLimpiezaKilosPorHoraTallas) {
		this.estandarEficienciaLimpiezaKilosPorHoraTallas = estandarEficienciaLimpiezaKilosPorHoraTallas;
	}

	public EstandarEficienciaLimpiezaKilosPorHoraTalla addEstandarEficienciaLimpiezaKilosPorHoraTalla(EstandarEficienciaLimpiezaKilosPorHoraTalla estandarEficienciaLimpiezaKilosPorHoraTalla) {
		getEstandarEficienciaLimpiezaKilosPorHoraTallas().add(estandarEficienciaLimpiezaKilosPorHoraTalla);
		estandarEficienciaLimpiezaKilosPorHoraTalla.setLimpiezaTipo(this);

		return estandarEficienciaLimpiezaKilosPorHoraTalla;
	}

	public EstandarEficienciaLimpiezaKilosPorHoraTalla removeEstandarEficienciaLimpiezaKilosPorHoraTalla(EstandarEficienciaLimpiezaKilosPorHoraTalla estandarEficienciaLimpiezaKilosPorHoraTalla) {
		getEstandarEficienciaLimpiezaKilosPorHoraTallas().remove(estandarEficienciaLimpiezaKilosPorHoraTalla);
		estandarEficienciaLimpiezaKilosPorHoraTalla.setLimpiezaTipo(null);

		return estandarEficienciaLimpiezaKilosPorHoraTalla;
	}


	//bi-directional many-to-one association to EstandarEficienciaPonchadaPlexus
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarEficienciaPonchadaPlexus> getEstandarEficienciaPonchadaPlexuses() {
		return this.estandarEficienciaPonchadaPlexuses;
	}

	public void setEstandarEficienciaPonchadaPlexuses(List<EstandarEficienciaPonchadaPlexus> estandarEficienciaPonchadaPlexuses) {
		this.estandarEficienciaPonchadaPlexuses = estandarEficienciaPonchadaPlexuses;
	}

	public EstandarEficienciaPonchadaPlexus addEstandarEficienciaPonchadaPlexus(EstandarEficienciaPonchadaPlexus estandarEficienciaPonchadaPlexus) {
		getEstandarEficienciaPonchadaPlexuses().add(estandarEficienciaPonchadaPlexus);
		estandarEficienciaPonchadaPlexus.setLimpiezaTipo(this);

		return estandarEficienciaPonchadaPlexus;
	}

	public EstandarEficienciaPonchadaPlexus removeEstandarEficienciaPonchadaPlexus(EstandarEficienciaPonchadaPlexus estandarEficienciaPonchadaPlexus) {
		getEstandarEficienciaPonchadaPlexuses().remove(estandarEficienciaPonchadaPlexus);
		estandarEficienciaPonchadaPlexus.setLimpiezaTipo(null);

		return estandarEficienciaPonchadaPlexus;
	}


	//bi-directional many-to-one association to EstandarIncentivoKilo
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarIncentivoKilo> getEstandarIncentivoKilos() {
		return this.estandarIncentivoKilos;
	}

	public void setEstandarIncentivoKilos(List<EstandarIncentivoKilo> estandarIncentivoKilos) {
		this.estandarIncentivoKilos = estandarIncentivoKilos;
	}

	public EstandarIncentivoKilo addEstandarIncentivoKilo(EstandarIncentivoKilo estandarIncentivoKilo) {
		getEstandarIncentivoKilos().add(estandarIncentivoKilo);
		estandarIncentivoKilo.setLimpiezaTipo(this);

		return estandarIncentivoKilo;
	}

	public EstandarIncentivoKilo removeEstandarIncentivoKilo(EstandarIncentivoKilo estandarIncentivoKilo) {
		getEstandarIncentivoKilos().remove(estandarIncentivoKilo);
		estandarIncentivoKilo.setLimpiezaTipo(null);

		return estandarIncentivoKilo;
	}


	//bi-directional many-to-one association to EstandarIncentivoKilosModelo2
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarIncentivoKilosModelo2> getEstandarIncentivoKilosModelo2s() {
		return this.estandarIncentivoKilosModelo2s;
	}

	public void setEstandarIncentivoKilosModelo2s(List<EstandarIncentivoKilosModelo2> estandarIncentivoKilosModelo2s) {
		this.estandarIncentivoKilosModelo2s = estandarIncentivoKilosModelo2s;
	}

	public EstandarIncentivoKilosModelo2 addEstandarIncentivoKilosModelo2(EstandarIncentivoKilosModelo2 estandarIncentivoKilosModelo2) {
		getEstandarIncentivoKilosModelo2s().add(estandarIncentivoKilosModelo2);
		estandarIncentivoKilosModelo2.setLimpiezaTipo(this);

		return estandarIncentivoKilosModelo2;
	}

	public EstandarIncentivoKilosModelo2 removeEstandarIncentivoKilosModelo2(EstandarIncentivoKilosModelo2 estandarIncentivoKilosModelo2) {
		getEstandarIncentivoKilosModelo2s().remove(estandarIncentivoKilosModelo2);
		estandarIncentivoKilosModelo2.setLimpiezaTipo(null);

		return estandarIncentivoKilosModelo2;
	}


	//bi-directional many-to-one association to EstandarIncentivoKilosModelo3
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarIncentivoKilosModelo3> getEstandarIncentivoKilosModelo3s() {
		return this.estandarIncentivoKilosModelo3s;
	}

	public void setEstandarIncentivoKilosModelo3s(List<EstandarIncentivoKilosModelo3> estandarIncentivoKilosModelo3s) {
		this.estandarIncentivoKilosModelo3s = estandarIncentivoKilosModelo3s;
	}

	public EstandarIncentivoKilosModelo3 addEstandarIncentivoKilosModelo3(EstandarIncentivoKilosModelo3 estandarIncentivoKilosModelo3) {
		getEstandarIncentivoKilosModelo3s().add(estandarIncentivoKilosModelo3);
		estandarIncentivoKilosModelo3.setLimpiezaTipo(this);

		return estandarIncentivoKilosModelo3;
	}

	public EstandarIncentivoKilosModelo3 removeEstandarIncentivoKilosModelo3(EstandarIncentivoKilosModelo3 estandarIncentivoKilosModelo3) {
		getEstandarIncentivoKilosModelo3s().remove(estandarIncentivoKilosModelo3);
		estandarIncentivoKilosModelo3.setLimpiezaTipo(null);

		return estandarIncentivoKilosModelo3;
	}


	//bi-directional many-to-one association to EstandarPonchadaTthh
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarPonchadaTthh> getEstandarPonchadaTthhs() {
		return this.estandarPonchadaTthhs;
	}

	public void setEstandarPonchadaTthhs(List<EstandarPonchadaTthh> estandarPonchadaTthhs) {
		this.estandarPonchadaTthhs = estandarPonchadaTthhs;
	}

	public EstandarPonchadaTthh addEstandarPonchadaTthh(EstandarPonchadaTthh estandarPonchadaTthh) {
		getEstandarPonchadaTthhs().add(estandarPonchadaTthh);
		estandarPonchadaTthh.setLimpiezaTipo(this);

		return estandarPonchadaTthh;
	}

	public EstandarPonchadaTthh removeEstandarPonchadaTthh(EstandarPonchadaTthh estandarPonchadaTthh) {
		getEstandarPonchadaTthhs().remove(estandarPonchadaTthh);
		estandarPonchadaTthh.setLimpiezaTipo(null);

		return estandarPonchadaTthh;
	}


	//bi-directional many-to-one association to EstandarRalladoLinea
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EstandarRalladoLinea> getEstandarRalladoLineas() {
		return this.estandarRalladoLineas;
	}

	public void setEstandarRalladoLineas(List<EstandarRalladoLinea> estandarRalladoLineas) {
		this.estandarRalladoLineas = estandarRalladoLineas;
	}

	public EstandarRalladoLinea addEstandarRalladoLinea(EstandarRalladoLinea estandarRalladoLinea) {
		getEstandarRalladoLineas().add(estandarRalladoLinea);
		estandarRalladoLinea.setLimpiezaTipo(this);

		return estandarRalladoLinea;
	}

	public EstandarRalladoLinea removeEstandarRalladoLinea(EstandarRalladoLinea estandarRalladoLinea) {
		getEstandarRalladoLineas().remove(estandarRalladoLinea);
		estandarRalladoLinea.setLimpiezaTipo(null);

		return estandarRalladoLinea;
	}


	//bi-directional many-to-one association to EvolutionPlexusEstandarTarifa
	@OneToMany(mappedBy="limpiezaTipo")
	public List<EvolutionPlexusEstandarTarifa> getEvolutionPlexusEstandarTarifas() {
		return this.evolutionPlexusEstandarTarifas;
	}

	public void setEvolutionPlexusEstandarTarifas(List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas) {
		this.evolutionPlexusEstandarTarifas = evolutionPlexusEstandarTarifas;
	}

	public EvolutionPlexusEstandarTarifa addEvolutionPlexusEstandarTarifa(EvolutionPlexusEstandarTarifa evolutionPlexusEstandarTarifa) {
		getEvolutionPlexusEstandarTarifas().add(evolutionPlexusEstandarTarifa);
		evolutionPlexusEstandarTarifa.setLimpiezaTipo(this);

		return evolutionPlexusEstandarTarifa;
	}

	public EvolutionPlexusEstandarTarifa removeEvolutionPlexusEstandarTarifa(EvolutionPlexusEstandarTarifa evolutionPlexusEstandarTarifa) {
		getEvolutionPlexusEstandarTarifas().remove(evolutionPlexusEstandarTarifa);
		evolutionPlexusEstandarTarifa.setLimpiezaTipo(null);

		return evolutionPlexusEstandarTarifa;
	}


	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="limpiezaTipo")
	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public LimpiezaDespellejadoPonchada addLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().add(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setLimpiezaTipo(this);

		return limpiezaDespellejadoPonchada;
	}

	public LimpiezaDespellejadoPonchada removeLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().remove(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setLimpiezaTipo(null);

		return limpiezaDespellejadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="limpiezaTipo")
	public List<LimpiezaDetalleProcesoLote> getLimpiezaDetalleProcesoLotes() {
		return this.limpiezaDetalleProcesoLotes;
	}

	public void setLimpiezaDetalleProcesoLotes(List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes) {
		this.limpiezaDetalleProcesoLotes = limpiezaDetalleProcesoLotes;
	}

	public LimpiezaDetalleProcesoLote addLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().add(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setLimpiezaTipo(this);

		return limpiezaDetalleProcesoLote;
	}

	public LimpiezaDetalleProcesoLote removeLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().remove(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setLimpiezaTipo(null);

		return limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="limpiezaTipo")
	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public LimpiezaFileteadoPonchada addLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().add(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setLimpiezaTipo(this);

		return limpiezaFileteadoPonchada;
	}

	public LimpiezaFileteadoPonchada removeLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().remove(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setLimpiezaTipo(null);

		return limpiezaFileteadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="limpiezaTipo")
	public List<LimpiezaProcesoLoteActivo> getLimpiezaProcesoLoteActivos() {
		return this.limpiezaProcesoLoteActivos;
	}

	public void setLimpiezaProcesoLoteActivos(List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos) {
		this.limpiezaProcesoLoteActivos = limpiezaProcesoLoteActivos;
	}

	public LimpiezaProcesoLoteActivo addLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().add(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setLimpiezaTipo(this);

		return limpiezaProcesoLoteActivo;
	}

	public LimpiezaProcesoLoteActivo removeLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().remove(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setLimpiezaTipo(null);

		return limpiezaProcesoLoteActivo;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="limpiezaTipo")
	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

	public ProduccionDetalleLote addProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().add(produccionDetalleLote);
		produccionDetalleLote.setLimpiezaTipo(this);

		return produccionDetalleLote;
	}

	public ProduccionDetalleLote removeProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().remove(produccionDetalleLote);
		produccionDetalleLote.setLimpiezaTipo(null);

		return produccionDetalleLote;
	}

}