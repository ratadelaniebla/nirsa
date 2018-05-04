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
@NamedQuery(name="RackeoProceso.findAll", query="SELECT r FROM RackeoProceso r")
public class RackeoProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idrackeoproceso;
	private Integer estado;
	private Timestamp fechareg;
	private double objetivoGeneral;
	private double oee;
	private double periodoBaseCalidadRackeo;
	private double periodoBaseGeneral;
	private double periodoBaseTiempoRackeo;
	private double periodoBaseVelocidadRackeo;
	private Integer piezas;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;
	private List<RackeoProcesoEmpleado> rackeoProcesoEmpleados;

	public RackeoProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="periodo_base_calidad_rackeo")
	public double getPeriodoBaseCalidadRackeo() {
		return this.periodoBaseCalidadRackeo;
	}

	public void setPeriodoBaseCalidadRackeo(double periodoBaseCalidadRackeo) {
		this.periodoBaseCalidadRackeo = periodoBaseCalidadRackeo;
	}


	@Column(name="periodo_base_general")
	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}


	@Column(name="periodo_base_tiempo_rackeo")
	public double getPeriodoBaseTiempoRackeo() {
		return this.periodoBaseTiempoRackeo;
	}

	public void setPeriodoBaseTiempoRackeo(double periodoBaseTiempoRackeo) {
		this.periodoBaseTiempoRackeo = periodoBaseTiempoRackeo;
	}


	@Column(name="periodo_base_velocidad_rackeo")
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


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="rackeoProceso")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().add(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setRackeoProceso(this);

		return descongeladoDetalleProceso;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().remove(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setRackeoProceso(null);

		return descongeladoDetalleProceso;
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


	//bi-directional many-to-one association to RackeoProcesoEmpleado
	@OneToMany(mappedBy="rackeoProceso")
	public List<RackeoProcesoEmpleado> getRackeoProcesoEmpleados() {
		return this.rackeoProcesoEmpleados;
	}

	public void setRackeoProcesoEmpleados(List<RackeoProcesoEmpleado> rackeoProcesoEmpleados) {
		this.rackeoProcesoEmpleados = rackeoProcesoEmpleados;
	}

	public RackeoProcesoEmpleado addRackeoProcesoEmpleado(RackeoProcesoEmpleado rackeoProcesoEmpleado) {
		getRackeoProcesoEmpleados().add(rackeoProcesoEmpleado);
		rackeoProcesoEmpleado.setRackeoProceso(this);

		return rackeoProcesoEmpleado;
	}

	public RackeoProcesoEmpleado removeRackeoProcesoEmpleado(RackeoProcesoEmpleado rackeoProcesoEmpleado) {
		getRackeoProcesoEmpleados().remove(rackeoProcesoEmpleado);
		rackeoProcesoEmpleado.setRackeoProceso(null);

		return rackeoProcesoEmpleado;
	}

}