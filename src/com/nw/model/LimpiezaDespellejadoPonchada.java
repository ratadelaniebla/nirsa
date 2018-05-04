package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_despellejado_ponchada database table.
 * 
 */
@Entity
@Table(name="limpieza_despellejado_ponchada")
@NamedQuery(name="LimpiezaDespellejadoPonchada.findAll", query="SELECT l FROM LimpiezaDespellejadoPonchada l")
public class LimpiezaDespellejadoPonchada implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadespellejadoponchada;
	private Integer arrastrevalor;
	private Timestamp fechareg;
	private Integer horaextra;
	private Integer ingresopormantenimiento;
	private Integer numponchada;
	private Empleado empleado;
	private EvisceradoCorte evisceradoCorte;
	private EvisceradoPescadosLata evisceradoPescadosLata;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaProceso limpiezaProceso;
	private LimpiezaRangoHora limpiezaRangoHora;
	private LimpiezaTipo limpiezaTipo;
	private Turno turno;
	private Usuario usuario;

	public LimpiezaDespellejadoPonchada() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezadespellejadoponchada() {
		return this.idlimpiezadespellejadoponchada;
	}

	public void setIdlimpiezadespellejadoponchada(Long idlimpiezadespellejadoponchada) {
		this.idlimpiezadespellejadoponchada = idlimpiezadespellejadoponchada;
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


	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	//bi-directional many-to-one association to EvisceradoCorte
	@ManyToOne
	@JoinColumn(name="idevisceradocorte")
	public EvisceradoCorte getEvisceradoCorte() {
		return this.evisceradoCorte;
	}

	public void setEvisceradoCorte(EvisceradoCorte evisceradoCorte) {
		this.evisceradoCorte = evisceradoCorte;
	}


	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
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


	//bi-directional many-to-one association to LimpiezaRangoHora
	@ManyToOne
	@JoinColumn(name="idrangohora")
	public LimpiezaRangoHora getLimpiezaRangoHora() {
		return this.limpiezaRangoHora;
	}

	public void setLimpiezaRangoHora(LimpiezaRangoHora limpiezaRangoHora) {
		this.limpiezaRangoHora = limpiezaRangoHora;
	}


	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
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