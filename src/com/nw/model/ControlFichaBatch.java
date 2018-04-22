package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the control_ficha_batch database table.
 * 
 */
@Entity
@Table(name="control_ficha_batch")
public class ControlFichaBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcontrolfichabatch;

	private Integer estado;

	private Timestamp fechaactualizacion;

	private Timestamp fechareg;

	private Integer idmaterial;

	private String idusuarioactualizacion;

	private String observaciones;

	private String tarjetacodigo;

	//bi-directional many-to-one association to ControlDetalleBatchEsterilizado
	@OneToMany(mappedBy="controlFichaBatch")
	private List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados;

	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="controlFichaBatch")
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;

	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="controlFichaBatch")
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;

	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="controlFichaBatch")
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;

	//bi-directional many-to-one association to ControlBatchProceso
	@ManyToOne
	@JoinColumn(name="idcontrolbatchproceso")
	private ControlBatchProceso controlBatchProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@OneToMany(mappedBy="controlFichaBatch")
	private List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos;

	//bi-directional many-to-one association to LimpiezaRalladoGabetaMezclaBatch
	@OneToMany(mappedBy="controlFichaBatch")
	private List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches;

	public ControlFichaBatch() {
	}

	public Long getIdcontrolfichabatch() {
		return this.idcontrolfichabatch;
	}

	public void setIdcontrolfichabatch(Long idcontrolfichabatch) {
		this.idcontrolfichabatch = idcontrolfichabatch;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
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

	public Integer getIdmaterial() {
		return this.idmaterial;
	}

	public void setIdmaterial(Integer idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTarjetacodigo() {
		return this.tarjetacodigo;
	}

	public void setTarjetacodigo(String tarjetacodigo) {
		this.tarjetacodigo = tarjetacodigo;
	}

	public List<ControlDetalleBatchEsterilizado> getControlDetalleBatchEsterilizados() {
		return this.controlDetalleBatchEsterilizados;
	}

	public void setControlDetalleBatchEsterilizados(List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados) {
		this.controlDetalleBatchEsterilizados = controlDetalleBatchEsterilizados;
	}

	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
	}

	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados() {
		return this.controlDetalleBatchRallados;
	}

	public void setControlDetalleBatchRallados(List<ControlDetalleBatchRallado> controlDetalleBatchRallados) {
		this.controlDetalleBatchRallados = controlDetalleBatchRallados;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}

	public ControlBatchProceso getControlBatchProceso() {
		return this.controlBatchProceso;
	}

	public void setControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		this.controlBatchProceso = controlBatchProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LimpiezaRalladoDetallePeso> getLimpiezaRalladoDetallePesos() {
		return this.limpiezaRalladoDetallePesos;
	}

	public void setLimpiezaRalladoDetallePesos(List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos) {
		this.limpiezaRalladoDetallePesos = limpiezaRalladoDetallePesos;
	}

	public List<LimpiezaRalladoGabetaMezclaBatch> getLimpiezaRalladoGabetaMezclaBatches() {
		return this.limpiezaRalladoGabetaMezclaBatches;
	}

	public void setLimpiezaRalladoGabetaMezclaBatches(List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches) {
		this.limpiezaRalladoGabetaMezclaBatches = limpiezaRalladoGabetaMezclaBatches;
	}

}