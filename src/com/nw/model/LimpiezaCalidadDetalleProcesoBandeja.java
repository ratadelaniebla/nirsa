package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_calidad_detalle_proceso_bandeja database table.
 * 
 */
@Entity
@Table(name="limpieza_calidad_detalle_proceso_bandeja")
public class LimpiezaCalidadDetalleProcesoBandeja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezacalidaddetalleprocesobandeja;

	private Long idlimpiezacalidaddetalleprocesobandejaprincipal;
	
	private Boolean automatico;

	private String codpersona;

	private String dispositivo;

	private Timestamp fechareg;

	private Integer iddepartamento;

	private double peso;

	private double tara;

	
	private String tarjetapersonalinea;
	
	private String observacion;

	private Integer ubicacionpersona;

	private String unidad;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to LimpiezaCalidadGrupoMaestroSubproducto
	@ManyToOne
	@JoinColumn(name="idlimpiezacalidadgrupomaestrosubproducto")
	private LimpiezaCalidadGrupoMaestroSubproducto limpiezaCalidadGrupoMaestroSubproducto;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaMaterial
	@ManyToOne
	@JoinColumn(name="idlimpiezamaterial")
	private LimpiezaMaterial limpiezaMaterial;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoempleado")
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;

	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoloteactivo")
	private LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaCalidadDetalleProcesoBandeja() {
	}

	public Long getIdlimpiezacalidaddetalleprocesobandeja() {
		return this.idlimpiezacalidaddetalleprocesobandeja;
	}

	public void setIdlimpiezacalidaddetalleprocesobandeja(Long idlimpiezacalidaddetalleprocesobandeja) {
		this.idlimpiezacalidaddetalleprocesobandeja = idlimpiezacalidaddetalleprocesobandeja;
	}

	public Boolean getAutomatico() {
		return this.automatico;
	}

	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
	}

	public String getCodpersona() {
		return this.codpersona;
	}

	public void setCodpersona(String codpersona) {
		this.codpersona = codpersona;
	}

	public String getDispositivo() {
		return this.dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public String getTarjetapersonalinea() {
		return this.tarjetapersonalinea;
	}

	public void setTarjetapersonalinea(String tarjetapersonalinea) {
		this.tarjetapersonalinea = tarjetapersonalinea;
	}

	public Integer getUbicacionpersona() {
		return this.ubicacionpersona;
	}

	public void setUbicacionpersona(Integer ubicacionpersona) {
		this.ubicacionpersona = ubicacionpersona;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public LimpiezaCalidadGrupoMaestroSubproducto getLimpiezaCalidadGrupoMaestroSubproducto() {
		return this.limpiezaCalidadGrupoMaestroSubproducto;
	}

	public void setLimpiezaCalidadGrupoMaestroSubproducto(LimpiezaCalidadGrupoMaestroSubproducto limpiezaCalidadGrupoMaestroSubproducto) {
		this.limpiezaCalidadGrupoMaestroSubproducto = limpiezaCalidadGrupoMaestroSubproducto;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public LimpiezaMaterial getLimpiezaMaterial() {
		return this.limpiezaMaterial;
	}

	public void setLimpiezaMaterial(LimpiezaMaterial limpiezaMaterial) {
		this.limpiezaMaterial = limpiezaMaterial;
	}

	public LimpiezaProcesoEmpleado getLimpiezaProcesoEmpleado() {
		return this.limpiezaProcesoEmpleado;
	}

	public void setLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		this.limpiezaProcesoEmpleado = limpiezaProcesoEmpleado;
	}

	public LimpiezaProcesoLoteActivo getLimpiezaProcesoLoteActivo() {
		return this.limpiezaProcesoLoteActivo;
	}

	public void setLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		this.limpiezaProcesoLoteActivo = limpiezaProcesoLoteActivo;
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

	public Long getIdlimpiezacalidaddetalleprocesobandejaprincipal() {
		return idlimpiezacalidaddetalleprocesobandejaprincipal;
	}

	public void setIdlimpiezacalidaddetalleprocesobandejaprincipal(
			Long idlimpiezacalidaddetalleprocesobandejaprincipal) {
		this.idlimpiezacalidaddetalleprocesobandejaprincipal = idlimpiezacalidaddetalleprocesobandejaprincipal;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}