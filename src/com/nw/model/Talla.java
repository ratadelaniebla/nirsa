package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the talla database table.
 * 
 */
@Entity
public class Talla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idtalla;

	private String codigoqm;

	private String codigosaptalla;

	private double desde;

	private double desdekilos;

	private double hasta;

	private double hastakilos;

	private String libras;

	private String librasinternacional;

	private String nombre;

	private Integer notificar;

	private String saptalla;

	@Column(name="talla_kilos")
	private String tallaKilos;

	//bi-directional many-to-one association to BiEstandarClasificacionTalla
	@OneToMany(mappedBy="talla")
	private List<BiEstandarClasificacionTalla> biEstandarClasificacionTallas;

	//bi-directional many-to-one association to DescongeladoDetalleDuchaAperturaTalla
	@OneToMany(mappedBy="talla")
	private List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas;

	//bi-directional many-to-one association to EspecieTalla
	@OneToMany(mappedBy="talla")
	private List<EspecieTalla> especieTallas;

	//bi-directional many-to-one association to EstandarClasificacionProdTalla
	@OneToMany(mappedBy="talla")
	private List<EstandarClasificacionProdTalla> estandarClasificacionProdTallas;

	//bi-directional many-to-one association to EstandarClasificacionTalla
	@OneToMany(mappedBy="talla")
	private List<EstandarClasificacionTalla> estandarClasificacionTallas;

	//bi-directional many-to-one association to EstandarClasificacionTallaPlexus
	@OneToMany(mappedBy="talla")
	private List<EstandarClasificacionTallaPlexus> estandarClasificacionTallaPlexuses;

	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="talla")
	private List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses;

	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPlexus
	@OneToMany(mappedBy="talla")
	private List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses;

	//bi-directional many-to-one association to EstandarEficienciaAtun
	@OneToMany(mappedBy="talla")
	private List<EstandarEficienciaAtun> estandarEficienciaAtuns;

	//bi-directional many-to-one association to EstandarEficienciaAtunLimpio
	@OneToMany(mappedBy="talla")
	private List<EstandarEficienciaAtunLimpio> estandarEficienciaAtunLimpios;

	//bi-directional many-to-one association to EstandarEficienciaAtunLimpioP
	@OneToMany(mappedBy="talla")
	private List<EstandarEficienciaAtunLimpioP> estandarEficienciaAtunLimpioPs;

	//bi-directional many-to-one association to EstandarEficienciaLimpiezaKilosPorHoraTalla
	@OneToMany(mappedBy="talla")
	private List<EstandarEficienciaLimpiezaKilosPorHoraTalla> estandarEficienciaLimpiezaKilosPorHoraTallas;

	//bi-directional many-to-one association to EstandarEficienciaPonchadaPlexus
	@OneToMany(mappedBy="talla")
	private List<EstandarEficienciaPonchadaPlexus> estandarEficienciaPonchadaPlexuses;

	//bi-directional many-to-one association to EstandarPonchadaTthh
	@OneToMany(mappedBy="talla")
	private List<EstandarPonchadaTthh> estandarPonchadaTthhs;

	//bi-directional many-to-one association to EstandarTiemposDescongelado
	@OneToMany(mappedBy="talla")
	private List<EstandarTiemposDescongelado> estandarTiemposDescongelados;

	//bi-directional many-to-one association to EstandarTiemposPrecamara
	@OneToMany(mappedBy="talla")
	private List<EstandarTiemposPrecamara> estandarTiemposPrecamaras;

	//bi-directional many-to-one association to EvisceradoTiempoEstandarCajon
	@OneToMany(mappedBy="talla")
	private List<EvisceradoTiempoEstandarCajon> evisceradoTiempoEstandarCajons;

	//bi-directional many-to-one association to EvolutionPlexusEstandarTarifa
	@OneToMany(mappedBy="talla")
	private List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas;

	public Talla() {
	}

	public Integer getIdtalla() {
		return this.idtalla;
	}

	public void setIdtalla(Integer idtalla) {
		this.idtalla = idtalla;
	}

	public String getCodigoqm() {
		return this.codigoqm;
	}

	public void setCodigoqm(String codigoqm) {
		this.codigoqm = codigoqm;
	}

	public String getCodigosaptalla() {
		return this.codigosaptalla;
	}

	public void setCodigosaptalla(String codigosaptalla) {
		this.codigosaptalla = codigosaptalla;
	}

	public double getDesde() {
		return this.desde;
	}

	public void setDesde(double desde) {
		this.desde = desde;
	}

	public double getDesdekilos() {
		return this.desdekilos;
	}

	public void setDesdekilos(double desdekilos) {
		this.desdekilos = desdekilos;
	}

	public double getHasta() {
		return this.hasta;
	}

	public void setHasta(double hasta) {
		this.hasta = hasta;
	}

	public double getHastakilos() {
		return this.hastakilos;
	}

	public void setHastakilos(double hastakilos) {
		this.hastakilos = hastakilos;
	}

	public String getLibras() {
		return this.libras;
	}

	public void setLibras(String libras) {
		this.libras = libras;
	}

	public String getLibrasinternacional() {
		return this.librasinternacional;
	}

	public void setLibrasinternacional(String librasinternacional) {
		this.librasinternacional = librasinternacional;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNotificar() {
		return this.notificar;
	}

	public void setNotificar(Integer notificar) {
		this.notificar = notificar;
	}

	public String getSaptalla() {
		return this.saptalla;
	}

	public void setSaptalla(String saptalla) {
		this.saptalla = saptalla;
	}

	public String getTallaKilos() {
		return this.tallaKilos;
	}

	public void setTallaKilos(String tallaKilos) {
		this.tallaKilos = tallaKilos;
	}

	public List<BiEstandarClasificacionTalla> getBiEstandarClasificacionTallas() {
		return this.biEstandarClasificacionTallas;
	}

	public void setBiEstandarClasificacionTallas(List<BiEstandarClasificacionTalla> biEstandarClasificacionTallas) {
		this.biEstandarClasificacionTallas = biEstandarClasificacionTallas;
	}

	public List<DescongeladoDetalleDuchaAperturaTalla> getDescongeladoDetalleDuchaAperturaTallas() {
		return this.descongeladoDetalleDuchaAperturaTallas;
	}

	public void setDescongeladoDetalleDuchaAperturaTallas(List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas) {
		this.descongeladoDetalleDuchaAperturaTallas = descongeladoDetalleDuchaAperturaTallas;
	}

	public List<EspecieTalla> getEspecieTallas() {
		return this.especieTallas;
	}

	public void setEspecieTallas(List<EspecieTalla> especieTallas) {
		this.especieTallas = especieTallas;
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

	public List<EstandarPonchadaTthh> getEstandarPonchadaTthhs() {
		return this.estandarPonchadaTthhs;
	}

	public void setEstandarPonchadaTthhs(List<EstandarPonchadaTthh> estandarPonchadaTthhs) {
		this.estandarPonchadaTthhs = estandarPonchadaTthhs;
	}

	public List<EstandarTiemposDescongelado> getEstandarTiemposDescongelados() {
		return this.estandarTiemposDescongelados;
	}

	public void setEstandarTiemposDescongelados(List<EstandarTiemposDescongelado> estandarTiemposDescongelados) {
		this.estandarTiemposDescongelados = estandarTiemposDescongelados;
	}

	public List<EstandarTiemposPrecamara> getEstandarTiemposPrecamaras() {
		return this.estandarTiemposPrecamaras;
	}

	public void setEstandarTiemposPrecamaras(List<EstandarTiemposPrecamara> estandarTiemposPrecamaras) {
		this.estandarTiemposPrecamaras = estandarTiemposPrecamaras;
	}

	public List<EvisceradoTiempoEstandarCajon> getEvisceradoTiempoEstandarCajons() {
		return this.evisceradoTiempoEstandarCajons;
	}

	public void setEvisceradoTiempoEstandarCajons(List<EvisceradoTiempoEstandarCajon> evisceradoTiempoEstandarCajons) {
		this.evisceradoTiempoEstandarCajons = evisceradoTiempoEstandarCajons;
	}

	public List<EvolutionPlexusEstandarTarifa> getEvolutionPlexusEstandarTarifas() {
		return this.evolutionPlexusEstandarTarifas;
	}

	public void setEvolutionPlexusEstandarTarifas(List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas) {
		this.evolutionPlexusEstandarTarifas = evolutionPlexusEstandarTarifas;
	}

}