package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the lonjas_proceso database table.
 * 
 */
@Entity
@Table(name="lonjas_proceso")
public class LonjasProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlonjasproceso;

	private String codigomaterial;

	private Integer diajuliano;

	private Timestamp fechareg;

	private String nombrematerial;

	@Column(name="objetivo_general")
	private double objetivoGeneral;

	private double oee;

	private Long ordenfabricacion;

	private String ordenproduccion;

	@Column(name="periodo_base_calidad_lonjas")
	private double periodoBaseCalidadLonjas;

	@Column(name="periodo_base_general")
	private double periodoBaseGeneral;

	@Column(name="periodo_base_tiempo_lonjas")
	private double periodoBaseTiempoLonjas;

	@Column(name="periodo_base_velocidad_lonjas")
	private double periodoBaseVelocidadLonjas;

	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasProceso")
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;

	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="lonjasProceso")
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="lonjasProceso")
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;

	//bi-directional many-to-one association to LonjasOrdenProduccion
	@OneToMany(mappedBy="lonjasProceso")
	private List<LonjasOrdenProduccion> lonjasOrdenProduccions;

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

	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="lonjasProceso")
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;

	public LonjasProceso() {
	}

	public Long getIdlonjasproceso() {
		return this.idlonjasproceso;
	}

	public void setIdlonjasproceso(Long idlonjasproceso) {
		this.idlonjasproceso = idlonjasproceso;
	}

	public String getCodigomaterial() {
		return this.codigomaterial;
	}

	public void setCodigomaterial(String codigomaterial) {
		this.codigomaterial = codigomaterial;
	}

	public Integer getDiajuliano() {
		return this.diajuliano;
	}

	public void setDiajuliano(Integer diajuliano) {
		this.diajuliano = diajuliano;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public String getNombrematerial() {
		return this.nombrematerial;
	}

	public void setNombrematerial(String nombrematerial) {
		this.nombrematerial = nombrematerial;
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

	public Long getOrdenfabricacion() {
		return this.ordenfabricacion;
	}

	public void setOrdenfabricacion(Long ordenfabricacion) {
		this.ordenfabricacion = ordenfabricacion;
	}

	public String getOrdenproduccion() {
		return this.ordenproduccion;
	}

	public void setOrdenproduccion(String ordenproduccion) {
		this.ordenproduccion = ordenproduccion;
	}

	public double getPeriodoBaseCalidadLonjas() {
		return this.periodoBaseCalidadLonjas;
	}

	public void setPeriodoBaseCalidadLonjas(double periodoBaseCalidadLonjas) {
		this.periodoBaseCalidadLonjas = periodoBaseCalidadLonjas;
	}

	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}

	public double getPeriodoBaseTiempoLonjas() {
		return this.periodoBaseTiempoLonjas;
	}

	public void setPeriodoBaseTiempoLonjas(double periodoBaseTiempoLonjas) {
		this.periodoBaseTiempoLonjas = periodoBaseTiempoLonjas;
	}

	public double getPeriodoBaseVelocidadLonjas() {
		return this.periodoBaseVelocidadLonjas;
	}

	public void setPeriodoBaseVelocidadLonjas(double periodoBaseVelocidadLonjas) {
		this.periodoBaseVelocidadLonjas = periodoBaseVelocidadLonjas;
	}

	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public List<LonjasOrdenProduccion> getLonjasOrdenProduccions() {
		return this.lonjasOrdenProduccions;
	}

	public void setLonjasOrdenProduccions(List<LonjasOrdenProduccion> lonjasOrdenProduccions) {
		this.lonjasOrdenProduccions = lonjasOrdenProduccions;
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

	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

}