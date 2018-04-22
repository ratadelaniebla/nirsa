package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_proceso_empleado database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_empleado")
public class LimpiezaProcesoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaprocesoempleado;

	private Integer estado;

	private Timestamp fechaingreso;

	private Timestamp fechareg;

	private Timestamp fechasalidamarcacion;

	private Integer idlimpiezacargo;

	private String tarjetapersonalinea;

	private Integer ubicacion;

	private Boolean masivo;
	
	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleDesperdicio
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	private List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios;

	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejadoT
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	private List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaLineaGrupo
	@ManyToOne
	@JoinColumn(name="idlimpiezalineagrupo")
	private LimpiezaLineaGrupo limpiezaLineaGrupo;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoBonificacionPonchada
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	private List<LimpiezaProcesoEmpleadoBonificacionPonchada> limpiezaProcesoEmpleadoBonificacionPonchadas;

	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;

	//bi-directional many-to-one association to OeeDetalleParadaLimpieza
	@OneToMany(mappedBy="limpiezaProcesoEmpleado")
	private List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas;

	public LimpiezaProcesoEmpleado() {
	}

	public Long getIdlimpiezaprocesoempleado() {
		return this.idlimpiezaprocesoempleado;
	}

	public void setIdlimpiezaprocesoempleado(Long idlimpiezaprocesoempleado) {
		this.idlimpiezaprocesoempleado = idlimpiezaprocesoempleado;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Timestamp fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Timestamp getFechasalidamarcacion() {
		return this.fechasalidamarcacion;
	}

	public void setFechasalidamarcacion(Timestamp fechasalidamarcacion) {
		this.fechasalidamarcacion = fechasalidamarcacion;
	}

	public Integer getIdlimpiezacargo() {
		return this.idlimpiezacargo;
	}

	public void setIdlimpiezacargo(Integer idlimpiezacargo) {
		this.idlimpiezacargo = idlimpiezacargo;
	}

	public String getTarjetapersonalinea() {
		return this.tarjetapersonalinea;
	}

	public void setTarjetapersonalinea(String tarjetapersonalinea) {
		this.tarjetapersonalinea = tarjetapersonalinea;
	}

	public Integer getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public List<LimpiezaDetalleDesperdicio> getLimpiezaDetalleDesperdicios() {
		return this.limpiezaDetalleDesperdicios;
	}

	public void setLimpiezaDetalleDesperdicios(List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios) {
		this.limpiezaDetalleDesperdicios = limpiezaDetalleDesperdicios;
	}

	public List<LimpiezaDetallePesoDespellejadoT> getLimpiezaDetallePesoDespellejadoTs() {
		return this.limpiezaDetallePesoDespellejadoTs;
	}

	public void setLimpiezaDetallePesoDespellejadoTs(List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs) {
		this.limpiezaDetallePesoDespellejadoTs = limpiezaDetallePesoDespellejadoTs;
	}

	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public LimpiezaLineaGrupo getLimpiezaLineaGrupo() {
		return this.limpiezaLineaGrupo;
	}

	public void setLimpiezaLineaGrupo(LimpiezaLineaGrupo limpiezaLineaGrupo) {
		this.limpiezaLineaGrupo = limpiezaLineaGrupo;
	}

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LimpiezaProcesoEmpleadoBonificacionPonchada> getLimpiezaProcesoEmpleadoBonificacionPonchadas() {
		return this.limpiezaProcesoEmpleadoBonificacionPonchadas;
	}

	public void setLimpiezaProcesoEmpleadoBonificacionPonchadas(List<LimpiezaProcesoEmpleadoBonificacionPonchada> limpiezaProcesoEmpleadoBonificacionPonchadas) {
		this.limpiezaProcesoEmpleadoBonificacionPonchadas = limpiezaProcesoEmpleadoBonificacionPonchadas;
	}

	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public List<OeeDetalleParadaLimpieza> getOeeDetalleParadaLimpiezas() {
		return this.oeeDetalleParadaLimpiezas;
	}

	public void setOeeDetalleParadaLimpiezas(List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas) {
		this.oeeDetalleParadaLimpiezas = oeeDetalleParadaLimpiezas;
	}

	public Boolean getMasivo() {
		return masivo;
	}

	public void setMasivo(Boolean masivo) {
		this.masivo = masivo;
	}

}