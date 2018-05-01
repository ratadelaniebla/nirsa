package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the envasado_proceso database table.
 * 
 */
@Entity
@Table(name="envasado_proceso")
public class EnvasadoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idenvasadoproceso;

	private Integer estado;

	private Timestamp fechareg;

	@Column(name="objetivo_general")
	private double objetivoGeneral;

	private double oee;

	@Column(name="periodo_base_calidad_envasado")
	private double periodoBaseCalidadEnvasado;

	@Column(name="periodo_base_general")
	private double periodoBaseGeneral;

	@Column(name="periodo_base_tiempo_envasado")
	private double periodoBaseTiempoEnvasado;

	@Column(name="periodo_base_velocidad_envasado")
	private double periodoBaseVelocidadEnvasado;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@ManyToOne
	@JoinColumn(name="id_oee_periodo_base_objetivo")
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public EnvasadoProceso() {
	}

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

	public double getPeriodoBaseCalidadEnvasado() {
		return this.periodoBaseCalidadEnvasado;
	}

	public void setPeriodoBaseCalidadEnvasado(double periodoBaseCalidadEnvasado) {
		this.periodoBaseCalidadEnvasado = periodoBaseCalidadEnvasado;
	}

	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}

	public double getPeriodoBaseTiempoEnvasado() {
		return this.periodoBaseTiempoEnvasado;
	}

	public void setPeriodoBaseTiempoEnvasado(double periodoBaseTiempoEnvasado) {
		this.periodoBaseTiempoEnvasado = periodoBaseTiempoEnvasado;
	}

	public double getPeriodoBaseVelocidadEnvasado() {
		return this.periodoBaseVelocidadEnvasado;
	}

	public void setPeriodoBaseVelocidadEnvasado(double periodoBaseVelocidadEnvasado) {
		this.periodoBaseVelocidadEnvasado = periodoBaseVelocidadEnvasado;
	}

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public OeePeriodoBaseObjetivo getOeePeriodoBaseObjetivo() {
		return this.oeePeriodoBaseObjetivo;
	}

	public void setOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		this.oeePeriodoBaseObjetivo = oeePeriodoBaseObjetivo;
	}

	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}