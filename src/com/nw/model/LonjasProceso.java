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
@NamedQuery(name="LonjasProceso.findAll", query="SELECT l FROM LonjasProceso l")
public class LonjasProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjasproceso;
	private String codigomaterial;
	private Integer diajuliano;
	private Timestamp fechareg;
	private String nombrematerial;
	private double objetivoGeneral;
	private double oee;
	private Long ordenfabricacion;
	private String ordenproduccion;
	private double periodoBaseCalidadLonjas;
	private double periodoBaseGeneral;
	private double periodoBaseTiempoLonjas;
	private double periodoBaseVelocidadLonjas;
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;
	private List<LonjasOrdenProduccion> lonjasOrdenProduccions;
	private LimpiezaProceso limpiezaProceso;
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;

	public LonjasProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="periodo_base_calidad_lonjas")
	public double getPeriodoBaseCalidadLonjas() {
		return this.periodoBaseCalidadLonjas;
	}

	public void setPeriodoBaseCalidadLonjas(double periodoBaseCalidadLonjas) {
		this.periodoBaseCalidadLonjas = periodoBaseCalidadLonjas;
	}


	@Column(name="periodo_base_general")
	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}


	@Column(name="periodo_base_tiempo_lonjas")
	public double getPeriodoBaseTiempoLonjas() {
		return this.periodoBaseTiempoLonjas;
	}

	public void setPeriodoBaseTiempoLonjas(double periodoBaseTiempoLonjas) {
		this.periodoBaseTiempoLonjas = periodoBaseTiempoLonjas;
	}


	@Column(name="periodo_base_velocidad_lonjas")
	public double getPeriodoBaseVelocidadLonjas() {
		return this.periodoBaseVelocidadLonjas;
	}

	public void setPeriodoBaseVelocidadLonjas(double periodoBaseVelocidadLonjas) {
		this.periodoBaseVelocidadLonjas = periodoBaseVelocidadLonjas;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasProceso")
	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public LonjasDetalleProcesoCoche addLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().add(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setLonjasProceso(this);

		return lonjasDetalleProcesoCoch;
	}

	public LonjasDetalleProcesoCoche removeLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().remove(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setLonjasProceso(null);

		return lonjasDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="lonjasProceso")
	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public LonjasDetalleProcesoCocheEmpacado addLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().add(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setLonjasProceso(this);

		return lonjasDetalleProcesoCocheEmpacado;
	}

	public LonjasDetalleProcesoCocheEmpacado removeLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().remove(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setLonjasProceso(null);

		return lonjasDetalleProcesoCocheEmpacado;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="lonjasProceso")
	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public LonjasDetalleProcesoLote addLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().add(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setLonjasProceso(this);

		return lonjasDetalleProcesoLote;
	}

	public LonjasDetalleProcesoLote removeLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().remove(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setLonjasProceso(null);

		return lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LonjasOrdenProduccion
	@OneToMany(mappedBy="lonjasProceso")
	public List<LonjasOrdenProduccion> getLonjasOrdenProduccions() {
		return this.lonjasOrdenProduccions;
	}

	public void setLonjasOrdenProduccions(List<LonjasOrdenProduccion> lonjasOrdenProduccions) {
		this.lonjasOrdenProduccions = lonjasOrdenProduccions;
	}

	public LonjasOrdenProduccion addLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		getLonjasOrdenProduccions().add(lonjasOrdenProduccion);
		lonjasOrdenProduccion.setLonjasProceso(this);

		return lonjasOrdenProduccion;
	}

	public LonjasOrdenProduccion removeLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		getLonjasOrdenProduccions().remove(lonjasOrdenProduccion);
		lonjasOrdenProduccion.setLonjasProceso(null);

		return lonjasOrdenProduccion;
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


	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="lonjasProceso")
	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

	public LonjasProcesoEmpleado addLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().add(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setLonjasProceso(this);

		return lonjasProcesoEmpleado;
	}

	public LonjasProcesoEmpleado removeLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().remove(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setLonjasProceso(null);

		return lonjasProcesoEmpleado;
	}

}