package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the rackeo_proceso database table.
 * 
 */
@Entity
@Table(name="rackeo_proceso")
public class RackeoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrackeoproceso;

	private Integer estado;

	private Timestamp fechareg;

	@Column(name="objetivo_general")
	private double objetivoGeneral;

	private double oee;

	@Column(name="periodo_base_calidad_rackeo")
	private double periodoBaseCalidadRackeo;

	@Column(name="periodo_base_general")
	private double periodoBaseGeneral;

	@Column(name="periodo_base_tiempo_rackeo")
	private double periodoBaseTiempoRackeo;

	@Column(name="periodo_base_velocidad_rackeo")
	private double periodoBaseVelocidadRackeo;

	private Integer piezas;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="rackeoProceso")
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;

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

	//bi-directional many-to-one association to RackeoProcesoEmpleado
	@OneToMany(mappedBy="rackeoProceso")
	private List<RackeoProcesoEmpleado> rackeoProcesoEmpleados;

	public RackeoProceso() {
	}

	public Long getIdrackeoproceso() {
		return this.idrackeoproceso;
	}

	public void setIdrackeoproceso(Long idrackeoproceso) {
		this.idrackeoproceso = idrackeoproceso;
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

	public double getPeriodoBaseCalidadRackeo() {
		return this.periodoBaseCalidadRackeo;
	}

	public void setPeriodoBaseCalidadRackeo(double periodoBaseCalidadRackeo) {
		this.periodoBaseCalidadRackeo = periodoBaseCalidadRackeo;
	}

	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}

	public double getPeriodoBaseTiempoRackeo() {
		return this.periodoBaseTiempoRackeo;
	}

	public void setPeriodoBaseTiempoRackeo(double periodoBaseTiempoRackeo) {
		this.periodoBaseTiempoRackeo = periodoBaseTiempoRackeo;
	}

	public double getPeriodoBaseVelocidadRackeo() {
		return this.periodoBaseVelocidadRackeo;
	}

	public void setPeriodoBaseVelocidadRackeo(double periodoBaseVelocidadRackeo) {
		this.periodoBaseVelocidadRackeo = periodoBaseVelocidadRackeo;
	}

	public Integer getPiezas() {
		return this.piezas;
	}

	public void setPiezas(Integer piezas) {
		this.piezas = piezas;
	}

	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
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

	public List<RackeoProcesoEmpleado> getRackeoProcesoEmpleados() {
		return this.rackeoProcesoEmpleados;
	}

	public void setRackeoProcesoEmpleados(List<RackeoProcesoEmpleado> rackeoProcesoEmpleados) {
		this.rackeoProcesoEmpleados = rackeoProcesoEmpleados;
	}

}