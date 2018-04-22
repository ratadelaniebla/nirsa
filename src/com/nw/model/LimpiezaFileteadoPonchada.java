package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_fileteado_ponchada database table.
 * 
 */
@Entity
@Table(name="limpieza_fileteado_ponchada")
public class LimpiezaFileteadoPonchada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezafileteadoponchada;

	private Integer arrastrevalor;

	private Timestamp fechareg;

	private Integer horaextra;

	private Integer ingresopormantenimiento;

	private Integer numponchada;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	//bi-directional many-to-one association to EvisceradoCorte
	@ManyToOne
	@JoinColumn(name="idevisceradocorte")
	private EvisceradoCorte evisceradoCorte;

	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	private EvisceradoPescadosLata evisceradoPescadosLata;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to LimpiezaRangoHora
	@ManyToOne
	@JoinColumn(name="idrangohora")
	private LimpiezaRangoHora limpiezaRangoHora;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaFileteadoPonchada() {
	}

	public Long getIdlimpiezafileteadoponchada() {
		return this.idlimpiezafileteadoponchada;
	}

	public void setIdlimpiezafileteadoponchada(Long idlimpiezafileteadoponchada) {
		this.idlimpiezafileteadoponchada = idlimpiezafileteadoponchada;
	}

	public Integer getArrastrevalor() {
		return this.arrastrevalor;
	}

	public void setArrastrevalor(Integer arrastrevalor) {
		this.arrastrevalor = arrastrevalor;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getHoraextra() {
		return this.horaextra;
	}

	public void setHoraextra(Integer horaextra) {
		this.horaextra = horaextra;
	}

	public Integer getIngresopormantenimiento() {
		return this.ingresopormantenimiento;
	}

	public void setIngresopormantenimiento(Integer ingresopormantenimiento) {
		this.ingresopormantenimiento = ingresopormantenimiento;
	}

	public Integer getNumponchada() {
		return this.numponchada;
	}

	public void setNumponchada(Integer numponchada) {
		this.numponchada = numponchada;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public EvisceradoCorte getEvisceradoCorte() {
		return this.evisceradoCorte;
	}

	public void setEvisceradoCorte(EvisceradoCorte evisceradoCorte) {
		this.evisceradoCorte = evisceradoCorte;
	}

	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public LimpiezaRangoHora getLimpiezaRangoHora() {
		return this.limpiezaRangoHora;
	}

	public void setLimpiezaRangoHora(LimpiezaRangoHora limpiezaRangoHora) {
		this.limpiezaRangoHora = limpiezaRangoHora;
	}

	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
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

}