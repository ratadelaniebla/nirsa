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
@NamedQuery(name="LimpiezaCalidadDetalleProcesoBandeja.findAll", query="SELECT l FROM LimpiezaCalidadDetalleProcesoBandeja l")
public class LimpiezaCalidadDetalleProcesoBandeja implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezacalidaddetalleprocesobandeja;
	private Boolean automatico;
	private String codpersona;
	private String dispositivo;
	private Timestamp fechareg;
	private Integer iddepartamento;
	private Long idlimpiezacalidaddetalleprocesobandejaprincipal;
	private String observacion;
	private double peso;
	private double tara;
	private String tarjetapersonalinea;
	private Integer ubicacionpersona;
	private String unidad;
	private Area area;
	private LimpiezaCalidadGrupoMaestroSubproducto limpiezaCalidadGrupoMaestroSubproducto;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaMaterial limpiezaMaterial;
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;
	private LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo;
	private Turno turno;
	private Usuario usuario;

	public LimpiezaCalidadDetalleProcesoBandeja() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	public Long getIdlimpiezacalidaddetalleprocesobandejaprincipal() {
		return this.idlimpiezacalidaddetalleprocesobandejaprincipal;
	}

	public void setIdlimpiezacalidaddetalleprocesobandejaprincipal(Long idlimpiezacalidaddetalleprocesobandejaprincipal) {
		this.idlimpiezacalidaddetalleprocesobandejaprincipal = idlimpiezacalidaddetalleprocesobandejaprincipal;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	//bi-directional many-to-one association to LimpiezaCalidadGrupoMaestroSubproducto
	@ManyToOne
	@JoinColumn(name="idlimpiezacalidadgrupomaestrosubproducto")
	public LimpiezaCalidadGrupoMaestroSubproducto getLimpiezaCalidadGrupoMaestroSubproducto() {
		return this.limpiezaCalidadGrupoMaestroSubproducto;
	}

	public void setLimpiezaCalidadGrupoMaestroSubproducto(LimpiezaCalidadGrupoMaestroSubproducto limpiezaCalidadGrupoMaestroSubproducto) {
		this.limpiezaCalidadGrupoMaestroSubproducto = limpiezaCalidadGrupoMaestroSubproducto;
	}


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}


	//bi-directional many-to-one association to LimpiezaMaterial
	@ManyToOne
	@JoinColumn(name="idlimpiezamaterial")
	public LimpiezaMaterial getLimpiezaMaterial() {
		return this.limpiezaMaterial;
	}

	public void setLimpiezaMaterial(LimpiezaMaterial limpiezaMaterial) {
		this.limpiezaMaterial = limpiezaMaterial;
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


	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoloteactivo")
	public LimpiezaProcesoLoteActivo getLimpiezaProcesoLoteActivo() {
		return this.limpiezaProcesoLoteActivo;
	}

	public void setLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		this.limpiezaProcesoLoteActivo = limpiezaProcesoLoteActivo;
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

}