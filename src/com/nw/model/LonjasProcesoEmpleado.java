package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the lonjas_proceso_empleado database table.
 * 
 */
@Entity
@Table(name="lonjas_proceso_empleado")
public class LonjasProcesoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlonjasprocesoempleado;

	private Integer estado;

	private Timestamp fechaingreso;

	private Timestamp fechareg;

	private Integer idlonjascargo;

	private String tarjetapersonalinea;

	private Integer ubicacion;

	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasProcesoEmpleado")
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="lonjasProcesoEmpleado")
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	//bi-directional many-to-one association to LonjasLinea
	@ManyToOne
	@JoinColumn(name="idlonjaslinea")
	private LonjasLinea lonjasLinea;

	//bi-directional many-to-one association to LonjasLineaGrupo
	@ManyToOne
	@JoinColumn(name="idlonjaslineagrupo")
	private LonjasLineaGrupo lonjasLineaGrupo;

	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	private LonjasProceso lonjasProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LonjasProcesoEmpleado() {
	}

	public Long getIdlonjasprocesoempleado() {
		return this.idlonjasprocesoempleado;
	}

	public void setIdlonjasprocesoempleado(Long idlonjasprocesoempleado) {
		this.idlonjasprocesoempleado = idlonjasprocesoempleado;
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

	public Integer getIdlonjascargo() {
		return this.idlonjascargo;
	}

	public void setIdlonjascargo(Integer idlonjascargo) {
		this.idlonjascargo = idlonjascargo;
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

	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LonjasLinea getLonjasLinea() {
		return this.lonjasLinea;
	}

	public void setLonjasLinea(LonjasLinea lonjasLinea) {
		this.lonjasLinea = lonjasLinea;
	}

	public LonjasLineaGrupo getLonjasLineaGrupo() {
		return this.lonjasLineaGrupo;
	}

	public void setLonjasLineaGrupo(LonjasLineaGrupo lonjasLineaGrupo) {
		this.lonjasLineaGrupo = lonjasLineaGrupo;
	}

	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}