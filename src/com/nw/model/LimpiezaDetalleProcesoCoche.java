package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_detalle_proceso_coche database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_proceso_coche")
public class LimpiezaDetalleProcesoCoche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezadetalleprocesocoche;

	private Timestamp fechaactualizacion;

	private Timestamp fechareg;

	private Timestamp fecharegtara;

	@Column(name="idtalla_ajustada")
	private Integer idtallaAjustada;

	private String idusuarioactualizacion;

	private String idusuariotara;

	private double peso;

	private double tara;

	private String tipoingreso;

	private String tipoingresotara;

	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@OneToMany(mappedBy="limpiezaDetalleProcesoCoche")
	private List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas;

	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="limpiezaDetalleProcesoCoche")
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;

	//bi-directional many-to-one association to LimpiezaCocheObservacione
	@OneToMany(mappedBy="limpiezaDetalleProcesoCoche")
	private List<LimpiezaCocheObservacione> limpiezaCocheObservaciones;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="evisceradodetalleprocesocoche")
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCocheTemperaturaBatch
	@OneToMany(mappedBy="limpiezaDetalleProcesoCoche")
	private List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches;

	public LimpiezaDetalleProcesoCoche() {
	}

	public Long getIdlimpiezadetalleprocesocoche() {
		return this.idlimpiezadetalleprocesocoche;
	}

	public void setIdlimpiezadetalleprocesocoche(Long idlimpiezadetalleprocesocoche) {
		this.idlimpiezadetalleprocesocoche = idlimpiezadetalleprocesocoche;
	}

	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Timestamp getFecharegtara() {
		return this.fecharegtara;
	}

	public void setFecharegtara(Timestamp fecharegtara) {
		this.fecharegtara = fecharegtara;
	}

	public Integer getIdtallaAjustada() {
		return this.idtallaAjustada;
	}

	public void setIdtallaAjustada(Integer idtallaAjustada) {
		this.idtallaAjustada = idtallaAjustada;
	}

	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}

	public String getIdusuariotara() {
		return this.idusuariotara;
	}

	public void setIdusuariotara(String idusuariotara) {
		this.idusuariotara = idusuariotara;
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

	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}

	public String getTipoingresotara() {
		return this.tipoingresotara;
	}

	public void setTipoingresotara(String tipoingresotara) {
		this.tipoingresotara = tipoingresotara;
	}

	public List<LimpiezaAsignacionCanastilla> getLimpiezaAsignacionCanastillas() {
		return this.limpiezaAsignacionCanastillas;
	}

	public void setLimpiezaAsignacionCanastillas(List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas) {
		this.limpiezaAsignacionCanastillas = limpiezaAsignacionCanastillas;
	}

	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public List<LimpiezaCocheObservacione> getLimpiezaCocheObservaciones() {
		return this.limpiezaCocheObservaciones;
	}

	public void setLimpiezaCocheObservaciones(List<LimpiezaCocheObservacione> limpiezaCocheObservaciones) {
		this.limpiezaCocheObservaciones = limpiezaCocheObservaciones;
	}

	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}

	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
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

	public List<LimpiezaDetalleProcesoCocheTemperaturaBatch> getLimpiezaDetalleProcesoCocheTemperaturaBatches() {
		return this.limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public void setLimpiezaDetalleProcesoCocheTemperaturaBatches(List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches) {
		this.limpiezaDetalleProcesoCocheTemperaturaBatches = limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

}