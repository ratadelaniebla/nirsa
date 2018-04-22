package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the oee_detalle_medios_con_defecto database table.
 * 
 */
@Entity
@Table(name="oee_detalle_medios_con_defecto")
public class OeeDetalleMediosConDefecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_detalle_medios_con_defecto")
	private Long idOeeDetalleMediosConDefecto;

	@Column(name="cantidad_defectos")
	private Integer cantidadDefectos;

	@Column(name="fecha_hora_registro")
	private Timestamp fechaHoraRegistro;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	private String observacion;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoempleado")
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;

	//bi-directional many-to-one association to OeeDefecto
	@ManyToOne
	@JoinColumn(name="id_oee_defectos")
	private OeeDefecto oeeDefecto;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	private ProduccionDetalleLote produccionDetalleLote;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to OeeDetalleMediosConDefectoEnvasado
	@OneToMany(mappedBy="oeeDetalleMediosConDefecto")
	private List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados;

	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLimpieza
	@OneToMany(mappedBy="oeeDetalleMediosConDefecto")
	private List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas;

	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLonja
	@OneToMany(mappedBy="oeeDetalleMediosConDefecto")
	private List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas;

	public OeeDetalleMediosConDefecto() {
	}

	public Long getIdOeeDetalleMediosConDefecto() {
		return this.idOeeDetalleMediosConDefecto;
	}

	public void setIdOeeDetalleMediosConDefecto(Long idOeeDetalleMediosConDefecto) {
		this.idOeeDetalleMediosConDefecto = idOeeDetalleMediosConDefecto;
	}

	public Integer getCantidadDefectos() {
		return this.cantidadDefectos;
	}

	public void setCantidadDefectos(Integer cantidadDefectos) {
		this.cantidadDefectos = cantidadDefectos;
	}

	public Timestamp getFechaHoraRegistro() {
		return this.fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(Timestamp fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LimpiezaProcesoEmpleado getLimpiezaProcesoEmpleado() {
		return this.limpiezaProcesoEmpleado;
	}

	public void setLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		this.limpiezaProcesoEmpleado = limpiezaProcesoEmpleado;
	}

	public OeeDefecto getOeeDefecto() {
		return this.oeeDefecto;
	}

	public void setOeeDefecto(OeeDefecto oeeDefecto) {
		this.oeeDefecto = oeeDefecto;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}

	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<OeeDetalleMediosConDefectoEnvasado> getOeeDetalleMediosConDefectoEnvasados() {
		return this.oeeDetalleMediosConDefectoEnvasados;
	}

	public void setOeeDetalleMediosConDefectoEnvasados(List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados) {
		this.oeeDetalleMediosConDefectoEnvasados = oeeDetalleMediosConDefectoEnvasados;
	}

	public List<OeeDetalleMediosConDefectoLimpieza> getOeeDetalleMediosConDefectoLimpiezas() {
		return this.oeeDetalleMediosConDefectoLimpiezas;
	}

	public void setOeeDetalleMediosConDefectoLimpiezas(List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas) {
		this.oeeDetalleMediosConDefectoLimpiezas = oeeDetalleMediosConDefectoLimpiezas;
	}

	public List<OeeDetalleMediosConDefectoLonja> getOeeDetalleMediosConDefectoLonjas() {
		return this.oeeDetalleMediosConDefectoLonjas;
	}

	public void setOeeDetalleMediosConDefectoLonjas(List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas) {
		this.oeeDetalleMediosConDefectoLonjas = oeeDetalleMediosConDefectoLonjas;
	}

}