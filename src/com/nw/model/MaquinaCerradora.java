package com.nw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the maquina_cerradora database table.
 * 
 */
@Entity
@Table(name="maquina_cerradora")
@NamedQuery(name="MaquinaCerradora.findAll", query="SELECT m FROM MaquinaCerradora m")
public class MaquinaCerradora implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idmaquinacerradora;
	private String descripcion;
	private Integer velocidadNominal;
	private Integer velocidadReal;
	private List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados;
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;
	private List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabecera;
	private List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars;
	private List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados;
	private List<OeeDetalleParadaEnvasado> oeeDetalleParadaEnvasados;
	private List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	private List<EsterilizadoCoche> esterilizadoCoches;
	
	public MaquinaCerradora() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdmaquinacerradora() {
		return this.idmaquinacerradora;
	}

	public void setIdmaquinacerradora(Integer idmaquinacerradora) {
		this.idmaquinacerradora = idmaquinacerradora;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name="velocidad_nominal")
	public Integer getVelocidadNominal() {
		return this.velocidadNominal;
	}

	public void setVelocidadNominal(Integer velocidadNominal) {
		this.velocidadNominal = velocidadNominal;
	}


	@Column(name="velocidad_real")
	public Integer getVelocidadReal() {
		return this.velocidadReal;
	}

	public void setVelocidadReal(Integer velocidadReal) {
		this.velocidadReal = velocidadReal;
	}


	//bi-directional many-to-one association to ControlDetalleBatchEsterilizado
	@OneToMany(mappedBy="maquinaCerradora")
	public List<ControlDetalleBatchEsterilizado> getControlDetalleBatchEsterilizados() {
		return this.controlDetalleBatchEsterilizados;
	}

	public void setControlDetalleBatchEsterilizados(List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados) {
		this.controlDetalleBatchEsterilizados = controlDetalleBatchEsterilizados;
	}

	public ControlDetalleBatchEsterilizado addControlDetalleBatchEsterilizado(ControlDetalleBatchEsterilizado controlDetalleBatchEsterilizado) {
		getControlDetalleBatchEsterilizados().add(controlDetalleBatchEsterilizado);
		controlDetalleBatchEsterilizado.setMaquinaCerradora(this);

		return controlDetalleBatchEsterilizado;
	}

	public ControlDetalleBatchEsterilizado removeControlDetalleBatchEsterilizado(ControlDetalleBatchEsterilizado controlDetalleBatchEsterilizado) {
		getControlDetalleBatchEsterilizados().remove(controlDetalleBatchEsterilizado);
		controlDetalleBatchEsterilizado.setMaquinaCerradora(null);

		return controlDetalleBatchEsterilizado;
	}


	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="maquinaCerradora")
	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

	public ControlDetalleBatchMaquina addControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().add(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setMaquinaCerradora(this);

		return controlDetalleBatchMaquina;
	}

	public ControlDetalleBatchMaquina removeControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().remove(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setMaquinaCerradora(null);

		return controlDetalleBatchMaquina;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="maquinaCerradora")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

	public EnvasadoDetalleProcesoCambio addEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().add(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setMaquinaCerradora(this);

		return envasadoDetalleProcesoCambio;
	}

	public EnvasadoDetalleProcesoCambio removeEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().remove(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setMaquinaCerradora(null);

		return envasadoDetalleProcesoCambio;
	}
	
	
	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="maquinaCerradora")
	public List<EnvasadoControlPesoNetoCabecera> getEnvasadoControlPesoNetoCabecera() {
		return this.envasadoControlPesoNetoCabecera;
	}

	public void setEnvasadoControlPesoNetoCabecera(List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabecera) {
		this.envasadoControlPesoNetoCabecera = envasadoControlPesoNetoCabecera;
	}

	public EnvasadoControlPesoNetoCabecera addEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabecera().add(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setMaquinaCerradora(this);

		return envasadoControlPesoNetoCabecera;
	}

	public EnvasadoControlPesoNetoCabecera removeEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabecera().remove(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setMaquinaCerradora(null);

		return envasadoControlPesoNetoCabecera;
	}


	//bi-directional many-to-one association to LuthyMaquinaCerradoraEstandar
	@OneToMany(mappedBy="maquinaCerradora")
	public List<LuthyMaquinaCerradoraEstandar> getLuthyMaquinaCerradoraEstandars() {
		return this.luthyMaquinaCerradoraEstandars;
	}

	public void setLuthyMaquinaCerradoraEstandars(List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars) {
		this.luthyMaquinaCerradoraEstandars = luthyMaquinaCerradoraEstandars;
	}

	public LuthyMaquinaCerradoraEstandar addLuthyMaquinaCerradoraEstandar(LuthyMaquinaCerradoraEstandar luthyMaquinaCerradoraEstandar) {
		getLuthyMaquinaCerradoraEstandars().add(luthyMaquinaCerradoraEstandar);
		luthyMaquinaCerradoraEstandar.setMaquinaCerradora(this);

		return luthyMaquinaCerradoraEstandar;
	}

	public LuthyMaquinaCerradoraEstandar removeLuthyMaquinaCerradoraEstandar(LuthyMaquinaCerradoraEstandar luthyMaquinaCerradoraEstandar) {
		getLuthyMaquinaCerradoraEstandars().remove(luthyMaquinaCerradoraEstandar);
		luthyMaquinaCerradoraEstandar.setMaquinaCerradora(null);

		return luthyMaquinaCerradoraEstandar;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoEnvasado
	@OneToMany(mappedBy="maquinaCerradora")
	public List<OeeDetalleMediosConDefectoEnvasado> getOeeDetalleMediosConDefectoEnvasados() {
		return this.oeeDetalleMediosConDefectoEnvasados;
	}

	public void setOeeDetalleMediosConDefectoEnvasados(List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados) {
		this.oeeDetalleMediosConDefectoEnvasados = oeeDetalleMediosConDefectoEnvasados;
	}

	public OeeDetalleMediosConDefectoEnvasado addOeeDetalleMediosConDefectoEnvasado(OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado) {
		getOeeDetalleMediosConDefectoEnvasados().add(oeeDetalleMediosConDefectoEnvasado);
		oeeDetalleMediosConDefectoEnvasado.setMaquinaCerradora(this);

		return oeeDetalleMediosConDefectoEnvasado;
	}

	public OeeDetalleMediosConDefectoEnvasado removeOeeDetalleMediosConDefectoEnvasado(OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado) {
		getOeeDetalleMediosConDefectoEnvasados().remove(oeeDetalleMediosConDefectoEnvasado);
		oeeDetalleMediosConDefectoEnvasado.setMaquinaCerradora(null);

		return oeeDetalleMediosConDefectoEnvasado;
	}


	//bi-directional many-to-one association to OeeDetalleParadaEnvasado
	@OneToMany(mappedBy="maquinaCerradora")
	public List<OeeDetalleParadaEnvasado> getOeeDetalleParadaEnvasados() {
		return this.oeeDetalleParadaEnvasados;
	}

	public void setOeeDetalleParadaEnvasados(List<OeeDetalleParadaEnvasado> oeeDetalleParadaEnvasados) {
		this.oeeDetalleParadaEnvasados = oeeDetalleParadaEnvasados;
	}

	public OeeDetalleParadaEnvasado addOeeDetalleParadaEnvasado(OeeDetalleParadaEnvasado oeeDetalleParadaEnvasado) {
		getOeeDetalleParadaEnvasados().add(oeeDetalleParadaEnvasado);
		oeeDetalleParadaEnvasado.setMaquinaCerradora(this);

		return oeeDetalleParadaEnvasado;
	}

	public OeeDetalleParadaEnvasado removeOeeDetalleParadaEnvasado(OeeDetalleParadaEnvasado oeeDetalleParadaEnvasado) {
		getOeeDetalleParadaEnvasados().remove(oeeDetalleParadaEnvasado);
		oeeDetalleParadaEnvasado.setMaquinaCerradora(null);

		return oeeDetalleParadaEnvasado;
	}


	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@OneToMany(mappedBy="maquinaCerradora")
	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradoras(List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras = oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora addOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras().add(oeeEnvasadoCabeceraVelocidadMaquinaCerradora);
		oeeEnvasadoCabeceraVelocidadMaquinaCerradora.setMaquinaCerradora(this);

		return oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora removeOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras().remove(oeeEnvasadoCabeceraVelocidadMaquinaCerradora);
		oeeEnvasadoCabeceraVelocidadMaquinaCerradora.setMaquinaCerradora(null);

		return oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	
	//bi-directional many-to-one association to EsterilizadoCoche
	@OneToMany(mappedBy="maquinaCerradora")
	public List<EsterilizadoCoche> getEsterilizadoCoches() {
		return this.esterilizadoCoches;
	}

	public void setEsterilizadoCoches(List<EsterilizadoCoche> esterilizadoCoches) {
		this.esterilizadoCoches = esterilizadoCoches;
	}

	public EsterilizadoCoche addEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().add(esterilizadoCoch);
		esterilizadoCoch.setMaquinaCerradora(this);

		return esterilizadoCoch;
	}

	public EsterilizadoCoche removeEsterilizadoCoch(EsterilizadoCoche esterilizadoCoch) {
		getEsterilizadoCoches().remove(esterilizadoCoch);
		esterilizadoCoch.setMaquinaCerradora(null);

		return esterilizadoCoch;
	}
}