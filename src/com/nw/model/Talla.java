package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the talla database table.
 * 
 */
@Entity
@NamedQuery(name="Talla.findAll", query="SELECT t FROM Talla t")
public class Talla implements Serializable {
	private static final long serialVersionUID = 1L;
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
	private String tallaKilos;
	private List<BiEstandarClasificacionTalla> biEstandarClasificacionTallas;
	private List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas;
	private List<EspecieTalla> especieTallas;
	private List<EstandarClasificacionProdTalla> estandarClasificacionProdTallas;
	private List<EstandarClasificacionTalla> estandarClasificacionTallas;
	private List<EstandarClasificacionTallaPlexus> estandarClasificacionTallaPlexuses;
	private List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses;
	private List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses;
	private List<EstandarEficienciaAtun> estandarEficienciaAtuns;
	private List<EstandarEficienciaAtunLimpio> estandarEficienciaAtunLimpios;
	private List<EstandarEficienciaAtunLimpioP> estandarEficienciaAtunLimpioPs;
	private List<EstandarEficienciaLimpiezaKilosPorHoraTalla> estandarEficienciaLimpiezaKilosPorHoraTallas;
	private List<EstandarEficienciaPonchadaPlexus> estandarEficienciaPonchadaPlexuses;
	private List<EstandarPonchadaTthh> estandarPonchadaTthhs;
	private List<EstandarTiemposDescongelado> estandarTiemposDescongelados;
	private List<EstandarTiemposPrecamara> estandarTiemposPrecamaras;
	private List<EvisceradoTiempoEstandarCajon> evisceradoTiempoEstandarCajons;
	private List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas;

	public Talla() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="talla_kilos")
	public String getTallaKilos() {
		return this.tallaKilos;
	}

	public void setTallaKilos(String tallaKilos) {
		this.tallaKilos = tallaKilos;
	}


	//bi-directional many-to-one association to BiEstandarClasificacionTalla
	@OneToMany(mappedBy="talla")
	public List<BiEstandarClasificacionTalla> getBiEstandarClasificacionTallas() {
		return this.biEstandarClasificacionTallas;
	}

	public void setBiEstandarClasificacionTallas(List<BiEstandarClasificacionTalla> biEstandarClasificacionTallas) {
		this.biEstandarClasificacionTallas = biEstandarClasificacionTallas;
	}

	public BiEstandarClasificacionTalla addBiEstandarClasificacionTalla(BiEstandarClasificacionTalla biEstandarClasificacionTalla) {
		getBiEstandarClasificacionTallas().add(biEstandarClasificacionTalla);
		biEstandarClasificacionTalla.setTalla(this);

		return biEstandarClasificacionTalla;
	}

	public BiEstandarClasificacionTalla removeBiEstandarClasificacionTalla(BiEstandarClasificacionTalla biEstandarClasificacionTalla) {
		getBiEstandarClasificacionTallas().remove(biEstandarClasificacionTalla);
		biEstandarClasificacionTalla.setTalla(null);

		return biEstandarClasificacionTalla;
	}


	//bi-directional many-to-one association to DescongeladoDetalleDuchaAperturaTalla
	@OneToMany(mappedBy="talla")
	public List<DescongeladoDetalleDuchaAperturaTalla> getDescongeladoDetalleDuchaAperturaTallas() {
		return this.descongeladoDetalleDuchaAperturaTallas;
	}

	public void setDescongeladoDetalleDuchaAperturaTallas(List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas) {
		this.descongeladoDetalleDuchaAperturaTallas = descongeladoDetalleDuchaAperturaTallas;
	}

	public DescongeladoDetalleDuchaAperturaTalla addDescongeladoDetalleDuchaAperturaTalla(DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla) {
		getDescongeladoDetalleDuchaAperturaTallas().add(descongeladoDetalleDuchaAperturaTalla);
		descongeladoDetalleDuchaAperturaTalla.setTalla(this);

		return descongeladoDetalleDuchaAperturaTalla;
	}

	public DescongeladoDetalleDuchaAperturaTalla removeDescongeladoDetalleDuchaAperturaTalla(DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla) {
		getDescongeladoDetalleDuchaAperturaTallas().remove(descongeladoDetalleDuchaAperturaTalla);
		descongeladoDetalleDuchaAperturaTalla.setTalla(null);

		return descongeladoDetalleDuchaAperturaTalla;
	}


	//bi-directional many-to-one association to EspecieTalla
	@OneToMany(mappedBy="talla")
	public List<EspecieTalla> getEspecieTallas() {
		return this.especieTallas;
	}

	public void setEspecieTallas(List<EspecieTalla> especieTallas) {
		this.especieTallas = especieTallas;
	}

	public EspecieTalla addEspecieTalla(EspecieTalla especieTalla) {
		getEspecieTallas().add(especieTalla);
		especieTalla.setTalla(this);

		return especieTalla;
	}

	public EspecieTalla removeEspecieTalla(EspecieTalla especieTalla) {
		getEspecieTallas().remove(especieTalla);
		especieTalla.setTalla(null);

		return especieTalla;
	}


	//bi-directional many-to-one association to EstandarClasificacionProdTalla
	@OneToMany(mappedBy="talla")
	public List<EstandarClasificacionProdTalla> getEstandarClasificacionProdTallas() {
		return this.estandarClasificacionProdTallas;
	}

	public void setEstandarClasificacionProdTallas(List<EstandarClasificacionProdTalla> estandarClasificacionProdTallas) {
		this.estandarClasificacionProdTallas = estandarClasificacionProdTallas;
	}

	public EstandarClasificacionProdTalla addEstandarClasificacionProdTalla(EstandarClasificacionProdTalla estandarClasificacionProdTalla) {
		getEstandarClasificacionProdTallas().add(estandarClasificacionProdTalla);
		estandarClasificacionProdTalla.setTalla(this);

		return estandarClasificacionProdTalla;
	}

	public EstandarClasificacionProdTalla removeEstandarClasificacionProdTalla(EstandarClasificacionProdTalla estandarClasificacionProdTalla) {
		getEstandarClasificacionProdTallas().remove(estandarClasificacionProdTalla);
		estandarClasificacionProdTalla.setTalla(null);

		return estandarClasificacionProdTalla;
	}


	//bi-directional many-to-one association to EstandarClasificacionTalla
	@OneToMany(mappedBy="talla")
	public List<EstandarClasificacionTalla> getEstandarClasificacionTallas() {
		return this.estandarClasificacionTallas;
	}

	public void setEstandarClasificacionTallas(List<EstandarClasificacionTalla> estandarClasificacionTallas) {
		this.estandarClasificacionTallas = estandarClasificacionTallas;
	}

	public EstandarClasificacionTalla addEstandarClasificacionTalla(EstandarClasificacionTalla estandarClasificacionTalla) {
		getEstandarClasificacionTallas().add(estandarClasificacionTalla);
		estandarClasificacionTalla.setTalla(this);

		return estandarClasificacionTalla;
	}

	public EstandarClasificacionTalla removeEstandarClasificacionTalla(EstandarClasificacionTalla estandarClasificacionTalla) {
		getEstandarClasificacionTallas().remove(estandarClasificacionTalla);
		estandarClasificacionTalla.setTalla(null);

		return estandarClasificacionTalla;
	}


	//bi-directional many-to-one association to EstandarClasificacionTallaPlexus
	@OneToMany(mappedBy="talla")
	public List<EstandarClasificacionTallaPlexus> getEstandarClasificacionTallaPlexuses() {
		return this.estandarClasificacionTallaPlexuses;
	}

	public void setEstandarClasificacionTallaPlexuses(List<EstandarClasificacionTallaPlexus> estandarClasificacionTallaPlexuses) {
		this.estandarClasificacionTallaPlexuses = estandarClasificacionTallaPlexuses;
	}

	public EstandarClasificacionTallaPlexus addEstandarClasificacionTallaPlexus(EstandarClasificacionTallaPlexus estandarClasificacionTallaPlexus) {
		getEstandarClasificacionTallaPlexuses().add(estandarClasificacionTallaPlexus);
		estandarClasificacionTallaPlexus.setTalla(this);

		return estandarClasificacionTallaPlexus;
	}

	public EstandarClasificacionTallaPlexus removeEstandarClasificacionTallaPlexus(EstandarClasificacionTallaPlexus estandarClasificacionTallaPlexus) {
		getEstandarClasificacionTallaPlexuses().remove(estandarClasificacionTallaPlexus);
		estandarClasificacionTallaPlexus.setTalla(null);

		return estandarClasificacionTallaPlexus;
	}


	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="talla")
	public List<EstandarDetalleEficienciaKilosPagoPlexus> getEstandarDetalleEficienciaKilosPagoPlexuses() {
		return this.estandarDetalleEficienciaKilosPagoPlexuses;
	}

	public void setEstandarDetalleEficienciaKilosPagoPlexuses(List<EstandarDetalleEficienciaKilosPagoPlexus> estandarDetalleEficienciaKilosPagoPlexuses) {
		this.estandarDetalleEficienciaKilosPagoPlexuses = estandarDetalleEficienciaKilosPagoPlexuses;
	}

	public EstandarDetalleEficienciaKilosPagoPlexus addEstandarDetalleEficienciaKilosPagoPlexus(EstandarDetalleEficienciaKilosPagoPlexus estandarDetalleEficienciaKilosPagoPlexus) {
		getEstandarDetalleEficienciaKilosPagoPlexuses().add(estandarDetalleEficienciaKilosPagoPlexus);
		estandarDetalleEficienciaKilosPagoPlexus.setTalla(this);

		return estandarDetalleEficienciaKilosPagoPlexus;
	}

	public EstandarDetalleEficienciaKilosPagoPlexus removeEstandarDetalleEficienciaKilosPagoPlexus(EstandarDetalleEficienciaKilosPagoPlexus estandarDetalleEficienciaKilosPagoPlexus) {
		getEstandarDetalleEficienciaKilosPagoPlexuses().remove(estandarDetalleEficienciaKilosPagoPlexus);
		estandarDetalleEficienciaKilosPagoPlexus.setTalla(null);

		return estandarDetalleEficienciaKilosPagoPlexus;
	}


	//bi-directional many-to-one association to EstandarDetalleEficienciaKilosPlexus
	@OneToMany(mappedBy="talla")
	public List<EstandarDetalleEficienciaKilosPlexus> getEstandarDetalleEficienciaKilosPlexuses() {
		return this.estandarDetalleEficienciaKilosPlexuses;
	}

	public void setEstandarDetalleEficienciaKilosPlexuses(List<EstandarDetalleEficienciaKilosPlexus> estandarDetalleEficienciaKilosPlexuses) {
		this.estandarDetalleEficienciaKilosPlexuses = estandarDetalleEficienciaKilosPlexuses;
	}

	public EstandarDetalleEficienciaKilosPlexus addEstandarDetalleEficienciaKilosPlexus(EstandarDetalleEficienciaKilosPlexus estandarDetalleEficienciaKilosPlexus) {
		getEstandarDetalleEficienciaKilosPlexuses().add(estandarDetalleEficienciaKilosPlexus);
		estandarDetalleEficienciaKilosPlexus.setTalla(this);

		return estandarDetalleEficienciaKilosPlexus;
	}

	public EstandarDetalleEficienciaKilosPlexus removeEstandarDetalleEficienciaKilosPlexus(EstandarDetalleEficienciaKilosPlexus estandarDetalleEficienciaKilosPlexus) {
		getEstandarDetalleEficienciaKilosPlexuses().remove(estandarDetalleEficienciaKilosPlexus);
		estandarDetalleEficienciaKilosPlexus.setTalla(null);

		return estandarDetalleEficienciaKilosPlexus;
	}


	//bi-directional many-to-one association to EstandarEficienciaAtun
	@OneToMany(mappedBy="talla")
	public List<EstandarEficienciaAtun> getEstandarEficienciaAtuns() {
		return this.estandarEficienciaAtuns;
	}

	public void setEstandarEficienciaAtuns(List<EstandarEficienciaAtun> estandarEficienciaAtuns) {
		this.estandarEficienciaAtuns = estandarEficienciaAtuns;
	}

	public EstandarEficienciaAtun addEstandarEficienciaAtun(EstandarEficienciaAtun estandarEficienciaAtun) {
		getEstandarEficienciaAtuns().add(estandarEficienciaAtun);
		estandarEficienciaAtun.setTalla(this);

		return estandarEficienciaAtun;
	}

	public EstandarEficienciaAtun removeEstandarEficienciaAtun(EstandarEficienciaAtun estandarEficienciaAtun) {
		getEstandarEficienciaAtuns().remove(estandarEficienciaAtun);
		estandarEficienciaAtun.setTalla(null);

		return estandarEficienciaAtun;
	}


	//bi-directional many-to-one association to EstandarEficienciaAtunLimpio
	@OneToMany(mappedBy="talla")
	public List<EstandarEficienciaAtunLimpio> getEstandarEficienciaAtunLimpios() {
		return this.estandarEficienciaAtunLimpios;
	}

	public void setEstandarEficienciaAtunLimpios(List<EstandarEficienciaAtunLimpio> estandarEficienciaAtunLimpios) {
		this.estandarEficienciaAtunLimpios = estandarEficienciaAtunLimpios;
	}

	public EstandarEficienciaAtunLimpio addEstandarEficienciaAtunLimpio(EstandarEficienciaAtunLimpio estandarEficienciaAtunLimpio) {
		getEstandarEficienciaAtunLimpios().add(estandarEficienciaAtunLimpio);
		estandarEficienciaAtunLimpio.setTalla(this);

		return estandarEficienciaAtunLimpio;
	}

	public EstandarEficienciaAtunLimpio removeEstandarEficienciaAtunLimpio(EstandarEficienciaAtunLimpio estandarEficienciaAtunLimpio) {
		getEstandarEficienciaAtunLimpios().remove(estandarEficienciaAtunLimpio);
		estandarEficienciaAtunLimpio.setTalla(null);

		return estandarEficienciaAtunLimpio;
	}


	//bi-directional many-to-one association to EstandarEficienciaAtunLimpioP
	@OneToMany(mappedBy="talla")
	public List<EstandarEficienciaAtunLimpioP> getEstandarEficienciaAtunLimpioPs() {
		return this.estandarEficienciaAtunLimpioPs;
	}

	public void setEstandarEficienciaAtunLimpioPs(List<EstandarEficienciaAtunLimpioP> estandarEficienciaAtunLimpioPs) {
		this.estandarEficienciaAtunLimpioPs = estandarEficienciaAtunLimpioPs;
	}

	public EstandarEficienciaAtunLimpioP addEstandarEficienciaAtunLimpioP(EstandarEficienciaAtunLimpioP estandarEficienciaAtunLimpioP) {
		getEstandarEficienciaAtunLimpioPs().add(estandarEficienciaAtunLimpioP);
		estandarEficienciaAtunLimpioP.setTalla(this);

		return estandarEficienciaAtunLimpioP;
	}

	public EstandarEficienciaAtunLimpioP removeEstandarEficienciaAtunLimpioP(EstandarEficienciaAtunLimpioP estandarEficienciaAtunLimpioP) {
		getEstandarEficienciaAtunLimpioPs().remove(estandarEficienciaAtunLimpioP);
		estandarEficienciaAtunLimpioP.setTalla(null);

		return estandarEficienciaAtunLimpioP;
	}


	//bi-directional many-to-one association to EstandarEficienciaLimpiezaKilosPorHoraTalla
	@OneToMany(mappedBy="talla")
	public List<EstandarEficienciaLimpiezaKilosPorHoraTalla> getEstandarEficienciaLimpiezaKilosPorHoraTallas() {
		return this.estandarEficienciaLimpiezaKilosPorHoraTallas;
	}

	public void setEstandarEficienciaLimpiezaKilosPorHoraTallas(List<EstandarEficienciaLimpiezaKilosPorHoraTalla> estandarEficienciaLimpiezaKilosPorHoraTallas) {
		this.estandarEficienciaLimpiezaKilosPorHoraTallas = estandarEficienciaLimpiezaKilosPorHoraTallas;
	}

	public EstandarEficienciaLimpiezaKilosPorHoraTalla addEstandarEficienciaLimpiezaKilosPorHoraTalla(EstandarEficienciaLimpiezaKilosPorHoraTalla estandarEficienciaLimpiezaKilosPorHoraTalla) {
		getEstandarEficienciaLimpiezaKilosPorHoraTallas().add(estandarEficienciaLimpiezaKilosPorHoraTalla);
		estandarEficienciaLimpiezaKilosPorHoraTalla.setTalla(this);

		return estandarEficienciaLimpiezaKilosPorHoraTalla;
	}

	public EstandarEficienciaLimpiezaKilosPorHoraTalla removeEstandarEficienciaLimpiezaKilosPorHoraTalla(EstandarEficienciaLimpiezaKilosPorHoraTalla estandarEficienciaLimpiezaKilosPorHoraTalla) {
		getEstandarEficienciaLimpiezaKilosPorHoraTallas().remove(estandarEficienciaLimpiezaKilosPorHoraTalla);
		estandarEficienciaLimpiezaKilosPorHoraTalla.setTalla(null);

		return estandarEficienciaLimpiezaKilosPorHoraTalla;
	}


	//bi-directional many-to-one association to EstandarEficienciaPonchadaPlexus
	@OneToMany(mappedBy="talla")
	public List<EstandarEficienciaPonchadaPlexus> getEstandarEficienciaPonchadaPlexuses() {
		return this.estandarEficienciaPonchadaPlexuses;
	}

	public void setEstandarEficienciaPonchadaPlexuses(List<EstandarEficienciaPonchadaPlexus> estandarEficienciaPonchadaPlexuses) {
		this.estandarEficienciaPonchadaPlexuses = estandarEficienciaPonchadaPlexuses;
	}

	public EstandarEficienciaPonchadaPlexus addEstandarEficienciaPonchadaPlexus(EstandarEficienciaPonchadaPlexus estandarEficienciaPonchadaPlexus) {
		getEstandarEficienciaPonchadaPlexuses().add(estandarEficienciaPonchadaPlexus);
		estandarEficienciaPonchadaPlexus.setTalla(this);

		return estandarEficienciaPonchadaPlexus;
	}

	public EstandarEficienciaPonchadaPlexus removeEstandarEficienciaPonchadaPlexus(EstandarEficienciaPonchadaPlexus estandarEficienciaPonchadaPlexus) {
		getEstandarEficienciaPonchadaPlexuses().remove(estandarEficienciaPonchadaPlexus);
		estandarEficienciaPonchadaPlexus.setTalla(null);

		return estandarEficienciaPonchadaPlexus;
	}


	//bi-directional many-to-one association to EstandarPonchadaTthh
	@OneToMany(mappedBy="talla")
	public List<EstandarPonchadaTthh> getEstandarPonchadaTthhs() {
		return this.estandarPonchadaTthhs;
	}

	public void setEstandarPonchadaTthhs(List<EstandarPonchadaTthh> estandarPonchadaTthhs) {
		this.estandarPonchadaTthhs = estandarPonchadaTthhs;
	}

	public EstandarPonchadaTthh addEstandarPonchadaTthh(EstandarPonchadaTthh estandarPonchadaTthh) {
		getEstandarPonchadaTthhs().add(estandarPonchadaTthh);
		estandarPonchadaTthh.setTalla(this);

		return estandarPonchadaTthh;
	}

	public EstandarPonchadaTthh removeEstandarPonchadaTthh(EstandarPonchadaTthh estandarPonchadaTthh) {
		getEstandarPonchadaTthhs().remove(estandarPonchadaTthh);
		estandarPonchadaTthh.setTalla(null);

		return estandarPonchadaTthh;
	}


	//bi-directional many-to-one association to EstandarTiemposDescongelado
	@OneToMany(mappedBy="talla")
	public List<EstandarTiemposDescongelado> getEstandarTiemposDescongelados() {
		return this.estandarTiemposDescongelados;
	}

	public void setEstandarTiemposDescongelados(List<EstandarTiemposDescongelado> estandarTiemposDescongelados) {
		this.estandarTiemposDescongelados = estandarTiemposDescongelados;
	}

	public EstandarTiemposDescongelado addEstandarTiemposDescongelado(EstandarTiemposDescongelado estandarTiemposDescongelado) {
		getEstandarTiemposDescongelados().add(estandarTiemposDescongelado);
		estandarTiemposDescongelado.setTalla(this);

		return estandarTiemposDescongelado;
	}

	public EstandarTiemposDescongelado removeEstandarTiemposDescongelado(EstandarTiemposDescongelado estandarTiemposDescongelado) {
		getEstandarTiemposDescongelados().remove(estandarTiemposDescongelado);
		estandarTiemposDescongelado.setTalla(null);

		return estandarTiemposDescongelado;
	}


	//bi-directional many-to-one association to EstandarTiemposPrecamara
	@OneToMany(mappedBy="talla")
	public List<EstandarTiemposPrecamara> getEstandarTiemposPrecamaras() {
		return this.estandarTiemposPrecamaras;
	}

	public void setEstandarTiemposPrecamaras(List<EstandarTiemposPrecamara> estandarTiemposPrecamaras) {
		this.estandarTiemposPrecamaras = estandarTiemposPrecamaras;
	}

	public EstandarTiemposPrecamara addEstandarTiemposPrecamara(EstandarTiemposPrecamara estandarTiemposPrecamara) {
		getEstandarTiemposPrecamaras().add(estandarTiemposPrecamara);
		estandarTiemposPrecamara.setTalla(this);

		return estandarTiemposPrecamara;
	}

	public EstandarTiemposPrecamara removeEstandarTiemposPrecamara(EstandarTiemposPrecamara estandarTiemposPrecamara) {
		getEstandarTiemposPrecamaras().remove(estandarTiemposPrecamara);
		estandarTiemposPrecamara.setTalla(null);

		return estandarTiemposPrecamara;
	}


	//bi-directional many-to-one association to EvisceradoTiempoEstandarCajon
	@OneToMany(mappedBy="talla")
	public List<EvisceradoTiempoEstandarCajon> getEvisceradoTiempoEstandarCajons() {
		return this.evisceradoTiempoEstandarCajons;
	}

	public void setEvisceradoTiempoEstandarCajons(List<EvisceradoTiempoEstandarCajon> evisceradoTiempoEstandarCajons) {
		this.evisceradoTiempoEstandarCajons = evisceradoTiempoEstandarCajons;
	}

	public EvisceradoTiempoEstandarCajon addEvisceradoTiempoEstandarCajon(EvisceradoTiempoEstandarCajon evisceradoTiempoEstandarCajon) {
		getEvisceradoTiempoEstandarCajons().add(evisceradoTiempoEstandarCajon);
		evisceradoTiempoEstandarCajon.setTalla(this);

		return evisceradoTiempoEstandarCajon;
	}

	public EvisceradoTiempoEstandarCajon removeEvisceradoTiempoEstandarCajon(EvisceradoTiempoEstandarCajon evisceradoTiempoEstandarCajon) {
		getEvisceradoTiempoEstandarCajons().remove(evisceradoTiempoEstandarCajon);
		evisceradoTiempoEstandarCajon.setTalla(null);

		return evisceradoTiempoEstandarCajon;
	}


	//bi-directional many-to-one association to EvolutionPlexusEstandarTarifa
	@OneToMany(mappedBy="talla")
	public List<EvolutionPlexusEstandarTarifa> getEvolutionPlexusEstandarTarifas() {
		return this.evolutionPlexusEstandarTarifas;
	}

	public void setEvolutionPlexusEstandarTarifas(List<EvolutionPlexusEstandarTarifa> evolutionPlexusEstandarTarifas) {
		this.evolutionPlexusEstandarTarifas = evolutionPlexusEstandarTarifas;
	}

	public EvolutionPlexusEstandarTarifa addEvolutionPlexusEstandarTarifa(EvolutionPlexusEstandarTarifa evolutionPlexusEstandarTarifa) {
		getEvolutionPlexusEstandarTarifas().add(evolutionPlexusEstandarTarifa);
		evolutionPlexusEstandarTarifa.setTalla(this);

		return evolutionPlexusEstandarTarifa;
	}

	public EvolutionPlexusEstandarTarifa removeEvolutionPlexusEstandarTarifa(EvolutionPlexusEstandarTarifa evolutionPlexusEstandarTarifa) {
		getEvolutionPlexusEstandarTarifas().remove(evolutionPlexusEstandarTarifa);
		evolutionPlexusEstandarTarifa.setTalla(null);

		return evolutionPlexusEstandarTarifa;
	}

}