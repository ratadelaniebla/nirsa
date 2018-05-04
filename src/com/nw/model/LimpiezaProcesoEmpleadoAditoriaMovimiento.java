package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_proceso_empleado_aditoria_movimiento database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_empleado_aditoria_movimiento")
@NamedQuery(name="LimpiezaProcesoEmpleadoAditoriaMovimiento.findAll", query="SELECT l FROM LimpiezaProcesoEmpleadoAditoriaMovimiento l")
public class LimpiezaProcesoEmpleadoAditoriaMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaprocesoempleadoaditoriamovimiento;
	private Integer estado;
	private Timestamp fechareg;
	private Integer idlimpiezacargo;
	private Integer idlimpiezacargoorigen;
	private Integer idlineaorigen;
	private Integer secuencialmovimiento;
	private String tarjetapersonalinea;
	private Integer ubicacion;
	private Integer ubicacionorigen;
	private Empleado empleado;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaLineaGrupo limpiezaLineaGrupo;
	private LimpiezaMotivoMovimiento limpiezaMotivoMovimiento;
	private LimpiezaProceso limpiezaProceso;
	private OeeParada oeeParada;
	private Usuario usuario;

	public LimpiezaProcesoEmpleadoAditoriaMovimiento() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezaprocesoempleadoaditoriamovimiento() {
		return this.idlimpiezaprocesoempleadoaditoriamovimiento;
	}

	public void setIdlimpiezaprocesoempleadoaditoriamovimiento(Long idlimpiezaprocesoempleadoaditoriamovimiento) {
		this.idlimpiezaprocesoempleadoaditoriamovimiento = idlimpiezaprocesoempleadoaditoriamovimiento;
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


	public Integer getIdlimpiezacargo() {
		return this.idlimpiezacargo;
	}

	public void setIdlimpiezacargo(Integer idlimpiezacargo) {
		this.idlimpiezacargo = idlimpiezacargo;
	}


	public Integer getIdlimpiezacargoorigen() {
		return this.idlimpiezacargoorigen;
	}

	public void setIdlimpiezacargoorigen(Integer idlimpiezacargoorigen) {
		this.idlimpiezacargoorigen = idlimpiezacargoorigen;
	}


	public Integer getIdlineaorigen() {
		return this.idlineaorigen;
	}

	public void setIdlineaorigen(Integer idlineaorigen) {
		this.idlineaorigen = idlineaorigen;
	}


	public Integer getSecuencialmovimiento() {
		return this.secuencialmovimiento;
	}

	public void setSecuencialmovimiento(Integer secuencialmovimiento) {
		this.secuencialmovimiento = secuencialmovimiento;
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


	public Integer getUbicacionorigen() {
		return this.ubicacionorigen;
	}

	public void setUbicacionorigen(Integer ubicacionorigen) {
		this.ubicacionorigen = ubicacionorigen;
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


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}


	//bi-directional many-to-one association to LimpiezaLineaGrupo
	@ManyToOne
	@JoinColumn(name="idlimpiezalineagrupo")
	public LimpiezaLineaGrupo getLimpiezaLineaGrupo() {
		return this.limpiezaLineaGrupo;
	}

	public void setLimpiezaLineaGrupo(LimpiezaLineaGrupo limpiezaLineaGrupo) {
		this.limpiezaLineaGrupo = limpiezaLineaGrupo;
	}


	//bi-directional many-to-one association to LimpiezaMotivoMovimiento
	@ManyToOne
	@JoinColumn(name="idlimpiezamotivomovimiento")
	public LimpiezaMotivoMovimiento getLimpiezaMotivoMovimiento() {
		return this.limpiezaMotivoMovimiento;
	}

	public void setLimpiezaMotivoMovimiento(LimpiezaMotivoMovimiento limpiezaMotivoMovimiento) {
		this.limpiezaMotivoMovimiento = limpiezaMotivoMovimiento;
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


	//bi-directional many-to-one association to OeeParada
	@ManyToOne
	@JoinColumn(name="id_oee_parada")
	public OeeParada getOeeParada() {
		return this.oeeParada;
	}

	public void setOeeParada(OeeParada oeeParada) {
		this.oeeParada = oeeParada;
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