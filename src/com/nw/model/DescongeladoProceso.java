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
@NamedQuery(name="DescongeladoProceso.findAll", query="SELECT d FROM DescongeladoProceso d")
public class DescongeladoProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddescongeladoproceso;
	private Timestamp fechareg;
	private double objetivo;
	private double objetivoGeneral;
	private double otif;
	private double periodoBaseCantidadDescongelado;
	private double periodoBaseTiempoDescongelado;
	private double rango1Entregacamara;
	private double rango1Ingresodescongelado;
	private double rango2Entregacamara;
	private double rango2Ingresodescongelado;
	private double rango3Entregacamara;
	private double rango3Ingresodescongelado;
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;
	private ObservacionesProceso observacionesProceso;
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;

	public DescongeladoProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="objetivo_general")
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


	@Column(name="periodo_base_cantidad_descongelado")
	public double getPeriodoBaseCantidadDescongelado() {
		return this.periodoBaseCantidadDescongelado;
	}

	public void setPeriodoBaseCantidadDescongelado(double periodoBaseCantidadDescongelado) {
		this.periodoBaseCantidadDescongelado = periodoBaseCantidadDescongelado;
	}


	@Column(name="periodo_base_tiempo_descongelado")
	public double getPeriodoBaseTiempoDescongelado() {
		return this.periodoBaseTiempoDescongelado;
	}

	public void setPeriodoBaseTiempoDescongelado(double periodoBaseTiempoDescongelado) {
		this.periodoBaseTiempoDescongelado = periodoBaseTiempoDescongelado;
	}


	@Column(name="rango1_entregacamara")
	public double getRango1Entregacamara() {
		return this.rango1Entregacamara;
	}

	public void setRango1Entregacamara(double rango1Entregacamara) {
		this.rango1Entregacamara = rango1Entregacamara;
	}


	@Column(name="rango1_ingresodescongelado")
	public double getRango1Ingresodescongelado() {
		return this.rango1Ingresodescongelado;
	}

	public void setRango1Ingresodescongelado(double rango1Ingresodescongelado) {
		this.rango1Ingresodescongelado = rango1Ingresodescongelado;
	}


	@Column(name="rango2_entregacamara")
	public double getRango2Entregacamara() {
		return this.rango2Entregacamara;
	}

	public void setRango2Entregacamara(double rango2Entregacamara) {
		this.rango2Entregacamara = rango2Entregacamara;
	}


	@Column(name="rango2_ingresodescongelado")
	public double getRango2Ingresodescongelado() {
		return this.rango2Ingresodescongelado;
	}

	public void setRango2Ingresodescongelado(double rango2Ingresodescongelado) {
		this.rango2Ingresodescongelado = rango2Ingresodescongelado;
	}


	@Column(name="rango3_entregacamara")
	public double getRango3Entregacamara() {
		return this.rango3Entregacamara;
	}

	public void setRango3Entregacamara(double rango3Entregacamara) {
		this.rango3Entregacamara = rango3Entregacamara;
	}


	@Column(name="rango3_ingresodescongelado")
	public double getRango3Ingresodescongelado() {
		return this.rango3Ingresodescongelado;
	}

	public void setRango3Ingresodescongelado(double rango3Ingresodescongelado) {
		this.rango3Ingresodescongelado = rango3Ingresodescongelado;
	}


	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="descongeladoProceso")
	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public DescongeladoCajonModificacion addDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().add(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setDescongeladoProceso(this);

		return descongeladoCajonModificacion;
	}

	public DescongeladoCajonModificacion removeDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().remove(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setDescongeladoProceso(null);

		return descongeladoCajonModificacion;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoProceso")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().add(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setDescongeladoProceso(this);

		return descongeladoDetalleProceso;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().remove(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setDescongeladoProceso(null);

		return descongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
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

}