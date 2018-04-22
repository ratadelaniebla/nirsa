package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the maquina_cerradora database table.
 * 
 */
@Entity
@Table(name="maquina_cerradora")
public class MaquinaCerradora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idmaquinacerradora;

	private String descripcion;

	@Column(name="velocidad_nominal")
	private Integer velocidadNominal;

	@Column(name="velocidad_real")
	private Integer velocidadReal;

	//bi-directional many-to-one association to ControlDetalleBatchEsterilizado
	@OneToMany(mappedBy="maquinaCerradora")
	private List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados;

	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="maquinaCerradora")
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;

	//bi-directional many-to-one association to LuthyMaquinaCerradoraEstandar
	@OneToMany(mappedBy="maquinaCerradora")
	private List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars;

	//bi-directional many-to-one association to OeeDetalleMediosConDefectoEnvasado
	@OneToMany(mappedBy="maquinaCerradora")
	private List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados;

	//bi-directional many-to-one association to OeeDetalleParadaEnvasado
	@OneToMany(mappedBy="maquinaCerradora")
	private List<OeeDetalleParadaEnvasado> oeeDetalleParadaEnvasados;

	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@OneToMany(mappedBy="maquinaCerradora")
	private List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;

	public MaquinaCerradora() {
	}

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

	public Integer getVelocidadNominal() {
		return this.velocidadNominal;
	}

	public void setVelocidadNominal(Integer velocidadNominal) {
		this.velocidadNominal = velocidadNominal;
	}

	public Integer getVelocidadReal() {
		return this.velocidadReal;
	}

	public void setVelocidadReal(Integer velocidadReal) {
		this.velocidadReal = velocidadReal;
	}

	public List<ControlDetalleBatchEsterilizado> getControlDetalleBatchEsterilizados() {
		return this.controlDetalleBatchEsterilizados;
	}

	public void setControlDetalleBatchEsterilizados(List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados) {
		this.controlDetalleBatchEsterilizados = controlDetalleBatchEsterilizados;
	}

	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

	public List<LuthyMaquinaCerradoraEstandar> getLuthyMaquinaCerradoraEstandars() {
		return this.luthyMaquinaCerradoraEstandars;
	}

	public void setLuthyMaquinaCerradoraEstandars(List<LuthyMaquinaCerradoraEstandar> luthyMaquinaCerradoraEstandars) {
		this.luthyMaquinaCerradoraEstandars = luthyMaquinaCerradoraEstandars;
	}

	public List<OeeDetalleMediosConDefectoEnvasado> getOeeDetalleMediosConDefectoEnvasados() {
		return this.oeeDetalleMediosConDefectoEnvasados;
	}

	public void setOeeDetalleMediosConDefectoEnvasados(List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados) {
		this.oeeDetalleMediosConDefectoEnvasados = oeeDetalleMediosConDefectoEnvasados;
	}

	public List<OeeDetalleParadaEnvasado> getOeeDetalleParadaEnvasados() {
		return this.oeeDetalleParadaEnvasados;
	}

	public void setOeeDetalleParadaEnvasados(List<OeeDetalleParadaEnvasado> oeeDetalleParadaEnvasados) {
		this.oeeDetalleParadaEnvasados = oeeDetalleParadaEnvasados;
	}

	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradoras(List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras = oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

}