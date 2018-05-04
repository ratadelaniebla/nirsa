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
@NamedQuery(name="OeeDetalleMediosConDefecto.findAll", query="SELECT o FROM OeeDetalleMediosConDefecto o")
public class OeeDetalleMediosConDefecto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idOeeDetalleMediosConDefecto;
	private Integer cantidadDefectos;
	private Timestamp fechaHoraRegistro;
	private Timestamp fechaRegistro;
	private String observacion;
	private Empleado empleado;
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;
	private OeeDefecto oeeDefecto;
	private Proceso proceso;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private ProduccionDetalleLote produccionDetalleLote;
	private Usuario usuario;
	private List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados;
	private List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas;
	private List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas;

	public OeeDetalleMediosConDefecto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_detalle_medios_con_defecto")
	public Long getIdOeeDetalleMediosConDefecto() {
		return this.idOeeDetalleMediosConDefecto;
	}

	public void setIdOeeDetalleMediosConDefecto(Long idOeeDetalleMediosConDefecto) {
		this.idOeeDetalleMediosConDefecto = idOeeDetalleMediosConDefecto;
	}


	@Column(name="cantidad_defectos")
	public Integer getCantidadDefectos() {
		return this.cantidadDefectos;
	}

	public void setCantidadDefectos(Integer cantidadDefectos) {
		this.cantidadDefectos = cantidadDefectos;
	}


	@Column(name="fecha_hora_registro")
	public Timestamp getFechaHoraRegistro() {
		return this.fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(Timestamp fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}


	@Column(name="fecha_registro")
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


	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoempleado")
	public LimpiezaProcesoEmpleado getLimpiezaProcesoEmpleado() {
		return this.limpiezaProcesoEmpleado;
	}

	public void setLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		this.limpiezaProcesoEmpleado = limpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to OeeDefecto
	@ManyToOne
	@JoinColumn(name="id_oee_defectos")
	public OeeDefecto getOeeDefecto() {
		return this.oeeDefecto;
	}

	public void setOeeDefecto(OeeDefecto oeeDefecto) {
		this.oeeDefecto = oeeDefecto;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
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


	//bi-directional many-to-one association to ProduccionDetalleLote
	@ManyToOne
	@JoinColumn(name="idproducciondetallelote")
	public ProduccionDetalleLote getProduccionDetalleLote() {
		return this.produccionDetalleLote;
	}

	public void setProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		this.produccionDetalleLote = produccionDetalleLote;
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


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoEnvasado
	@OneToMany(mappedBy="oeeDetalleMediosConDefecto")
	public List<OeeDetalleMediosConDefectoEnvasado> getOeeDetalleMediosConDefectoEnvasados() {
		return this.oeeDetalleMediosConDefectoEnvasados;
	}

	public void setOeeDetalleMediosConDefectoEnvasados(List<OeeDetalleMediosConDefectoEnvasado> oeeDetalleMediosConDefectoEnvasados) {
		this.oeeDetalleMediosConDefectoEnvasados = oeeDetalleMediosConDefectoEnvasados;
	}

	public OeeDetalleMediosConDefectoEnvasado addOeeDetalleMediosConDefectoEnvasado(OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado) {
		getOeeDetalleMediosConDefectoEnvasados().add(oeeDetalleMediosConDefectoEnvasado);
		oeeDetalleMediosConDefectoEnvasado.setOeeDetalleMediosConDefecto(this);

		return oeeDetalleMediosConDefectoEnvasado;
	}

	public OeeDetalleMediosConDefectoEnvasado removeOeeDetalleMediosConDefectoEnvasado(OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado) {
		getOeeDetalleMediosConDefectoEnvasados().remove(oeeDetalleMediosConDefectoEnvasado);
		oeeDetalleMediosConDefectoEnvasado.setOeeDetalleMediosConDefecto(null);

		return oeeDetalleMediosConDefectoEnvasado;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLimpieza
	@OneToMany(mappedBy="oeeDetalleMediosConDefecto")
	public List<OeeDetalleMediosConDefectoLimpieza> getOeeDetalleMediosConDefectoLimpiezas() {
		return this.oeeDetalleMediosConDefectoLimpiezas;
	}

	public void setOeeDetalleMediosConDefectoLimpiezas(List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas) {
		this.oeeDetalleMediosConDefectoLimpiezas = oeeDetalleMediosConDefectoLimpiezas;
	}

	public OeeDetalleMediosConDefectoLimpieza addOeeDetalleMediosConDefectoLimpieza(OeeDetalleMediosConDefectoLimpieza oeeDetalleMediosConDefectoLimpieza) {
		getOeeDetalleMediosConDefectoLimpiezas().add(oeeDetalleMediosConDefectoLimpieza);
		oeeDetalleMediosConDefectoLimpieza.setOeeDetalleMediosConDefecto(this);

		return oeeDetalleMediosConDefectoLimpieza;
	}

	public OeeDetalleMediosConDefectoLimpieza removeOeeDetalleMediosConDefectoLimpieza(OeeDetalleMediosConDefectoLimpieza oeeDetalleMediosConDefectoLimpieza) {
		getOeeDetalleMediosConDefectoLimpiezas().remove(oeeDetalleMediosConDefectoLimpieza);
		oeeDetalleMediosConDefectoLimpieza.setOeeDetalleMediosConDefecto(null);

		return oeeDetalleMediosConDefectoLimpieza;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLonja
	@OneToMany(mappedBy="oeeDetalleMediosConDefecto")
	public List<OeeDetalleMediosConDefectoLonja> getOeeDetalleMediosConDefectoLonjas() {
		return this.oeeDetalleMediosConDefectoLonjas;
	}

	public void setOeeDetalleMediosConDefectoLonjas(List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas) {
		this.oeeDetalleMediosConDefectoLonjas = oeeDetalleMediosConDefectoLonjas;
	}

	public OeeDetalleMediosConDefectoLonja addOeeDetalleMediosConDefectoLonja(OeeDetalleMediosConDefectoLonja oeeDetalleMediosConDefectoLonja) {
		getOeeDetalleMediosConDefectoLonjas().add(oeeDetalleMediosConDefectoLonja);
		oeeDetalleMediosConDefectoLonja.setOeeDetalleMediosConDefecto(this);

		return oeeDetalleMediosConDefectoLonja;
	}

	public OeeDetalleMediosConDefectoLonja removeOeeDetalleMediosConDefectoLonja(OeeDetalleMediosConDefectoLonja oeeDetalleMediosConDefectoLonja) {
		getOeeDetalleMediosConDefectoLonjas().remove(oeeDetalleMediosConDefectoLonja);
		oeeDetalleMediosConDefectoLonja.setOeeDetalleMediosConDefecto(null);

		return oeeDetalleMediosConDefectoLonja;
	}

}