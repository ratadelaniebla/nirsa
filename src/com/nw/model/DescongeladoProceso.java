package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the descongelado_proceso database table.
 * 
 */
@Entity
@Table(name="descongelado_proceso")
public class DescongeladoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddescongeladoproceso;

	private Timestamp fechareg;

	private double objetivo;

	@Column(name="objetivo_general")
	private double objetivoGeneral;

	private double otif;

	@Column(name="periodo_base_cantidad_descongelado")
	private double periodoBaseCantidadDescongelado;

	@Column(name="periodo_base_tiempo_descongelado")
	private double periodoBaseTiempoDescongelado;

	@Column(name="rango1_entregacamara")
	private double rango1Entregacamara;

	@Column(name="rango1_ingresodescongelado")
	private double rango1Ingresodescongelado;

	@Column(name="rango2_entregacamara")
	private double rango2Entregacamara;

	@Column(name="rango2_ingresodescongelado")
	private double rango2Ingresodescongelado;

	@Column(name="rango3_entregacamara")
	private double rango3Entregacamara;

	@Column(name="rango3_ingresodescongelado")
	private double rango3Ingresodescongelado;

	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="descongeladoProceso")
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoProceso")
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;

	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	private ObservacionesProceso observacionesProceso;

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

	public DescongeladoProceso() {
	}

	public Long getIddescongeladoproceso() {
		return this.iddescongeladoproceso;
	}

	public void setIddescongeladoproceso(Long iddescongeladoproceso) {
		this.iddescongeladoproceso = iddescongeladoproceso;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public double getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(double objetivo) {
		this.objetivo = objetivo;
	}

	public double getObjetivoGeneral() {
		return this.objetivoGeneral;
	}

	public void setObjetivoGeneral(double objetivoGeneral) {
		this.objetivoGeneral = objetivoGeneral;
	}

	public double getOtif() {
		return this.otif;
	}

	public void setOtif(double otif) {
		this.otif = otif;
	}

	public double getPeriodoBaseCantidadDescongelado() {
		return this.periodoBaseCantidadDescongelado;
	}

	public void setPeriodoBaseCantidadDescongelado(double periodoBaseCantidadDescongelado) {
		this.periodoBaseCantidadDescongelado = periodoBaseCantidadDescongelado;
	}

	public double getPeriodoBaseTiempoDescongelado() {
		return this.periodoBaseTiempoDescongelado;
	}

	public void setPeriodoBaseTiempoDescongelado(double periodoBaseTiempoDescongelado) {
		this.periodoBaseTiempoDescongelado = periodoBaseTiempoDescongelado;
	}

	public double getRango1Entregacamara() {
		return this.rango1Entregacamara;
	}

	public void setRango1Entregacamara(double rango1Entregacamara) {
		this.rango1Entregacamara = rango1Entregacamara;
	}

	public double getRango1Ingresodescongelado() {
		return this.rango1Ingresodescongelado;
	}

	public void setRango1Ingresodescongelado(double rango1Ingresodescongelado) {
		this.rango1Ingresodescongelado = rango1Ingresodescongelado;
	}

	public double getRango2Entregacamara() {
		return this.rango2Entregacamara;
	}

	public void setRango2Entregacamara(double rango2Entregacamara) {
		this.rango2Entregacamara = rango2Entregacamara;
	}

	public double getRango2Ingresodescongelado() {
		return this.rango2Ingresodescongelado;
	}

	public void setRango2Ingresodescongelado(double rango2Ingresodescongelado) {
		this.rango2Ingresodescongelado = rango2Ingresodescongelado;
	}

	public double getRango3Entregacamara() {
		return this.rango3Entregacamara;
	}

	public void setRango3Entregacamara(double rango3Entregacamara) {
		this.rango3Entregacamara = rango3Entregacamara;
	}

	public double getRango3Ingresodescongelado() {
		return this.rango3Ingresodescongelado;
	}

	public void setRango3Ingresodescongelado(double rango3Ingresodescongelado) {
		this.rango3Ingresodescongelado = rango3Ingresodescongelado;
	}

	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
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

}