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
@NamedQuery(name="LonjasProcesoEmpleado.findAll", query="SELECT l FROM LonjasProcesoEmpleado l")
public class LonjasProcesoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjasprocesoempleado;
	private Integer estado;
	private Timestamp fechaingreso;
	private Timestamp fechareg;
	private Integer idlonjascargo;
	private String tarjetapersonalinea;
	private Integer ubicacion;
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;
	private Empleado empleado;
	private LonjasLinea lonjasLinea;
	private LonjasLineaGrupo lonjasLineaGrupo;
	private LonjasProceso lonjasProceso;
	private Usuario usuario;

	public LonjasProcesoEmpleado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="lonjasProcesoEmpleado")
	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public LonjasDetalleProcesoConteo addLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().add(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasProcesoEmpleado(this);

		return lonjasDetalleProcesoConteo;
	}

	public LonjasDetalleProcesoConteo removeLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().remove(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setLonjasProcesoEmpleado(null);

		return lonjasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="lonjasProcesoEmpleado")
	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public LonjasDetalleProcesoEmpaque addLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().add(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setLonjasProcesoEmpleado(this);

		return lonjasDetalleProcesoEmpaque;
	}

	public LonjasDetalleProcesoEmpaque removeLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().remove(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setLonjasProcesoEmpleado(null);

		return lonjasDetalleProcesoEmpaque;
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


	//bi-directional many-to-one association to LonjasLinea
	@ManyToOne
	@JoinColumn(name="idlonjaslinea")
	public LonjasLinea getLonjasLinea() {
		return this.lonjasLinea;
	}

	public void setLonjasLinea(LonjasLinea lonjasLinea) {
		this.lonjasLinea = lonjasLinea;
	}


	//bi-directional many-to-one association to LonjasLineaGrupo
	@ManyToOne
	@JoinColumn(name="idlonjaslineagrupo")
	public LonjasLineaGrupo getLonjasLineaGrupo() {
		return this.lonjasLineaGrupo;
	}

	public void setLonjasLineaGrupo(LonjasLineaGrupo lonjasLineaGrupo) {
		this.lonjasLineaGrupo = lonjasLineaGrupo;
	}


	//bi-directional many-to-one association to LonjasProceso
	@ManyToOne
	@JoinColumn(name="idlonjasproceso")
	public LonjasProceso getLonjasProceso() {
		return this.lonjasProceso;
	}

	public void setLonjasProceso(LonjasProceso lonjasProceso) {
		this.lonjasProceso = lonjasProceso;
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