package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the envasado_proceso database table.
 * 
 */
@Entity
@Table(name="envasado_proceso")
@NamedQuery(name="EnvasadoProceso.findAll", query="SELECT e FROM EnvasadoProceso e")
public class EnvasadoProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idenvasadoproceso;
	private Integer estado;
	private Timestamp fechareg;
	private double objetivoGeneral;
	private double oee;
	private double periodoBaseCalidadEnvasado;
	private double periodoBaseGeneral;
	private double periodoBaseTiempoEnvasado;
	private double periodoBaseVelocidadEnvasado;
	private List<EnvasadoControlFillCorteCabecera> envasadoControlFillCorteCabeceras;
	private List<EnvasadoControlNetoCorteCabecera> envasadoControlNetoCorteCabeceras;
	private List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras;
	private List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;
	private LimpiezaProceso limpiezaProceso;
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;

	public EnvasadoProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdenvasadoproceso() {
		return this.idenvasadoproceso;
	}

	public void setIdenvasadoproceso(Long idenvasadoproceso) {
		this.idenvasadoproceso = idenvasadoproceso;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	@Column(name="objetivo_general")
	public double getObjetivoGeneral() {
		return this.objetivoGeneral;
	}

	public void setObjetivoGeneral(double objetivoGeneral) {
		this.objetivoGeneral = objetivoGeneral;
	}


	public double getOee() {
		return this.oee;
	}

	public void setOee(double oee) {
		this.oee = oee;
	}


	@Column(name="periodo_base_calidad_envasado")
	public double getPeriodoBaseCalidadEnvasado() {
		return this.periodoBaseCalidadEnvasado;
	}

	public void setPeriodoBaseCalidadEnvasado(double periodoBaseCalidadEnvasado) {
		this.periodoBaseCalidadEnvasado = periodoBaseCalidadEnvasado;
	}


	@Column(name="periodo_base_general")
	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}


	@Column(name="periodo_base_tiempo_envasado")
	public double getPeriodoBaseTiempoEnvasado() {
		return this.periodoBaseTiempoEnvasado;
	}

	public void setPeriodoBaseTiempoEnvasado(double periodoBaseTiempoEnvasado) {
		this.periodoBaseTiempoEnvasado = periodoBaseTiempoEnvasado;
	}


	@Column(name="periodo_base_velocidad_envasado")
	public double getPeriodoBaseVelocidadEnvasado() {
		return this.periodoBaseVelocidadEnvasado;
	}

	public void setPeriodoBaseVelocidadEnvasado(double periodoBaseVelocidadEnvasado) {
		this.periodoBaseVelocidadEnvasado = periodoBaseVelocidadEnvasado;
	}


	//bi-directional many-to-one association to EnvasadoControlFillCorteCabecera
	@OneToMany(mappedBy="envasadoProceso")
	public List<EnvasadoControlFillCorteCabecera> getEnvasadoControlFillCorteCabeceras() {
		return this.envasadoControlFillCorteCabeceras;
	}

	public void setEnvasadoControlFillCorteCabeceras(List<EnvasadoControlFillCorteCabecera> envasadoControlFillCorteCabeceras) {
		this.envasadoControlFillCorteCabeceras = envasadoControlFillCorteCabeceras;
	}

	public EnvasadoControlFillCorteCabecera addEnvasadoControlFillCorteCabecera(EnvasadoControlFillCorteCabecera envasadoControlFillCorteCabecera) {
		getEnvasadoControlFillCorteCabeceras().add(envasadoControlFillCorteCabecera);
		envasadoControlFillCorteCabecera.setEnvasadoProceso(this);

		return envasadoControlFillCorteCabecera;
	}

	public EnvasadoControlFillCorteCabecera removeEnvasadoControlFillCorteCabecera(EnvasadoControlFillCorteCabecera envasadoControlFillCorteCabecera) {
		getEnvasadoControlFillCorteCabeceras().remove(envasadoControlFillCorteCabecera);
		envasadoControlFillCorteCabecera.setEnvasadoProceso(null);

		return envasadoControlFillCorteCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlNetoCorteCabecera
	@OneToMany(mappedBy="envasadoProceso")
	public List<EnvasadoControlNetoCorteCabecera> getEnvasadoControlNetoCorteCabeceras() {
		return this.envasadoControlNetoCorteCabeceras;
	}

	public void setEnvasadoControlNetoCorteCabeceras(List<EnvasadoControlNetoCorteCabecera> envasadoControlNetoCorteCabeceras) {
		this.envasadoControlNetoCorteCabeceras = envasadoControlNetoCorteCabeceras;
	}

	public EnvasadoControlNetoCorteCabecera addEnvasadoControlNetoCorteCabecera(EnvasadoControlNetoCorteCabecera envasadoControlNetoCorteCabecera) {
		getEnvasadoControlNetoCorteCabeceras().add(envasadoControlNetoCorteCabecera);
		envasadoControlNetoCorteCabecera.setEnvasadoProceso(this);

		return envasadoControlNetoCorteCabecera;
	}

	public EnvasadoControlNetoCorteCabecera removeEnvasadoControlNetoCorteCabecera(EnvasadoControlNetoCorteCabecera envasadoControlNetoCorteCabecera) {
		getEnvasadoControlNetoCorteCabeceras().remove(envasadoControlNetoCorteCabecera);
		envasadoControlNetoCorteCabecera.setEnvasadoProceso(null);

		return envasadoControlNetoCorteCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillCabecera
	@OneToMany(mappedBy="envasadoProceso")
	public List<EnvasadoControlPesoFillCabecera> getEnvasadoControlPesoFillCabeceras() {
		return this.envasadoControlPesoFillCabeceras;
	}

	public void setEnvasadoControlPesoFillCabeceras(List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras) {
		this.envasadoControlPesoFillCabeceras = envasadoControlPesoFillCabeceras;
	}

	public EnvasadoControlPesoFillCabecera addEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().add(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setEnvasadoProceso(this);

		return envasadoControlPesoFillCabecera;
	}

	public EnvasadoControlPesoFillCabecera removeEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().remove(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setEnvasadoProceso(null);

		return envasadoControlPesoFillCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoNetoCabecera
	@OneToMany(mappedBy="envasadoProceso")
	public List<EnvasadoControlPesoNetoCabecera> getEnvasadoControlPesoNetoCabeceras() {
		return this.envasadoControlPesoNetoCabeceras;
	}

	public void setEnvasadoControlPesoNetoCabeceras(List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras) {
		this.envasadoControlPesoNetoCabeceras = envasadoControlPesoNetoCabeceras;
	}

	public EnvasadoControlPesoNetoCabecera addEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().add(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setEnvasadoProceso(this);

		return envasadoControlPesoNetoCabecera;
	}

	public EnvasadoControlPesoNetoCabecera removeEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().remove(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setEnvasadoProceso(null);

		return envasadoControlPesoNetoCabecera;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="envasadoProceso")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

	public EnvasadoDetalleProcesoCambio addEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().add(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setEnvasadoProceso(this);

		return envasadoDetalleProcesoCambio;
	}

	public EnvasadoDetalleProcesoCambio removeEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().remove(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setEnvasadoProceso(null);

		return envasadoDetalleProcesoCambio;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}


	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@ManyToOne
	@JoinColumn(name="id_oee_periodo_base_objetivo")
	public OeePeriodoBaseObjetivo getOeePeriodoBaseObjetivo() {
		return this.oeePeriodoBaseObjetivo;
	}

	public void setOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		this.oeePeriodoBaseObjetivo = oeePeriodoBaseObjetivo;
	}


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}