package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_proceso_empleado_total_inicial database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_empleado_total_inicial")
@NamedQuery(name="LimpiezaProcesoEmpleadoTotalInicial.findAll", query="SELECT l FROM LimpiezaProcesoEmpleadoTotalInicial l")
public class LimpiezaProcesoEmpleadoTotalInicial implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaprocesoempleadototalinicial;
	private Timestamp fechareg;
	private Integer totalempleados;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaProceso limpiezaProceso;
	private Usuario usuario;

	public LimpiezaProcesoEmpleadoTotalInicial() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezaprocesoempleadototalinicial() {
		return this.idlimpiezaprocesoempleadototalinicial;
	}

	public void setIdlimpiezaprocesoempleadototalinicial(Long idlimpiezaprocesoempleadototalinicial) {
		this.idlimpiezaprocesoempleadototalinicial = idlimpiezaprocesoempleadototalinicial;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getTotalempleados() {
		return this.totalempleados;
	}

	public void setTotalempleados(Integer totalempleados) {
		this.totalempleados = totalempleados;
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


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
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