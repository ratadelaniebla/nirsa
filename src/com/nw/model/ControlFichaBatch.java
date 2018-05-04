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
@NamedQuery(name="ControlFichaBatch.findAll", query="SELECT c FROM ControlFichaBatch c")
public class ControlFichaBatch implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcontrolfichabatch;
	private Integer estado;
	private Timestamp fechaactualizacion;
	private Timestamp fechareg;
	private Integer idmaterial;
	private String idusuarioactualizacion;
	private String observaciones;
	private String tarjetacodigo;
	private List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados;
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados;
	private Area area;
	private CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle;
	private ControlBatchProceso controlBatchProceso;
	private Usuario usuario;
	private List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos;
	private List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches;

	public ControlFichaBatch() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to ControlDetalleBatchEsterilizado
	@OneToMany(mappedBy="controlFichaBatch")
	public List<ControlDetalleBatchEsterilizado> getControlDetalleBatchEsterilizados() {
		return this.controlDetalleBatchEsterilizados;
	}

	public void setControlDetalleBatchEsterilizados(List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados) {
		this.controlDetalleBatchEsterilizados = controlDetalleBatchEsterilizados;
	}

	public ControlDetalleBatchEsterilizado addControlDetalleBatchEsterilizado(ControlDetalleBatchEsterilizado controlDetalleBatchEsterilizado) {
		getControlDetalleBatchEsterilizados().add(controlDetalleBatchEsterilizado);
		controlDetalleBatchEsterilizado.setControlFichaBatch(this);

		return controlDetalleBatchEsterilizado;
	}

	public ControlDetalleBatchEsterilizado removeControlDetalleBatchEsterilizado(ControlDetalleBatchEsterilizado controlDetalleBatchEsterilizado) {
		getControlDetalleBatchEsterilizados().remove(controlDetalleBatchEsterilizado);
		controlDetalleBatchEsterilizado.setControlFichaBatch(null);

		return controlDetalleBatchEsterilizado;
	}


	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="controlFichaBatch")
	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
	}

	public ControlDetalleBatchLimpieza addControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().add(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setControlFichaBatch(this);

		return controlDetalleBatchLimpieza;
	}

	public ControlDetalleBatchLimpieza removeControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().remove(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setControlFichaBatch(null);

		return controlDetalleBatchLimpieza;
	}


	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="controlFichaBatch")
	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

	public ControlDetalleBatchMaquina addControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().add(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setControlFichaBatch(this);

		return controlDetalleBatchMaquina;
	}

	public ControlDetalleBatchMaquina removeControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().remove(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setControlFichaBatch(null);

		return controlDetalleBatchMaquina;
	}


	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="controlFichaBatch")
	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados() {
		return this.controlDetalleBatchRallados;
	}

	public void setControlDetalleBatchRallados(List<ControlDetalleBatchRallado> controlDetalleBatchRallados) {
		this.controlDetalleBatchRallados = controlDetalleBatchRallados;
	}

	public ControlDetalleBatchRallado addControlDetalleBatchRallado(ControlDetalleBatchRallado controlDetalleBatchRallado) {
		getControlDetalleBatchRallados().add(controlDetalleBatchRallado);
		controlDetalleBatchRallado.setControlFichaBatch(this);

		return controlDetalleBatchRallado;
	}

	public ControlDetalleBatchRallado removeControlDetalleBatchRallado(ControlDetalleBatchRallado controlDetalleBatchRallado) {
		getControlDetalleBatchRallados().remove(controlDetalleBatchRallado);
		controlDetalleBatchRallado.setControlFichaBatch(null);

		return controlDetalleBatchRallado;
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


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idcocinaaperturacierredetalle")
	public CocinaAperturaCierreDetalle getCocinaAperturaCierreDetalle() {
		return this.cocinaAperturaCierreDetalle;
	}

	public void setCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		this.cocinaAperturaCierreDetalle = cocinaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to ControlBatchProceso
	@ManyToOne
	@JoinColumn(name="idcontrolbatchproceso")
	public ControlBatchProceso getControlBatchProceso() {
		return this.controlBatchProceso;
	}

	public void setControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		this.controlBatchProceso = controlBatchProceso;
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


	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@OneToMany(mappedBy="controlFichaBatch")
	public List<LimpiezaRalladoDetallePeso> getLimpiezaRalladoDetallePesos() {
		return this.limpiezaRalladoDetallePesos;
	}

	public void setLimpiezaRalladoDetallePesos(List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos) {
		this.limpiezaRalladoDetallePesos = limpiezaRalladoDetallePesos;
	}

	public LimpiezaRalladoDetallePeso addLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		getLimpiezaRalladoDetallePesos().add(limpiezaRalladoDetallePeso);
		limpiezaRalladoDetallePeso.setControlFichaBatch(this);

		return limpiezaRalladoDetallePeso;
	}

	public LimpiezaRalladoDetallePeso removeLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		getLimpiezaRalladoDetallePesos().remove(limpiezaRalladoDetallePeso);
		limpiezaRalladoDetallePeso.setControlFichaBatch(null);

		return limpiezaRalladoDetallePeso;
	}


	//bi-directional many-to-one association to LimpiezaRalladoGabetaMezclaBatch
	@OneToMany(mappedBy="controlFichaBatch")
	public List<LimpiezaRalladoGabetaMezclaBatch> getLimpiezaRalladoGabetaMezclaBatches() {
		return this.limpiezaRalladoGabetaMezclaBatches;
	}

	public void setLimpiezaRalladoGabetaMezclaBatches(List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches) {
		this.limpiezaRalladoGabetaMezclaBatches = limpiezaRalladoGabetaMezclaBatches;
	}

	public LimpiezaRalladoGabetaMezclaBatch addLimpiezaRalladoGabetaMezclaBatch(LimpiezaRalladoGabetaMezclaBatch limpiezaRalladoGabetaMezclaBatch) {
		getLimpiezaRalladoGabetaMezclaBatches().add(limpiezaRalladoGabetaMezclaBatch);
		limpiezaRalladoGabetaMezclaBatch.setControlFichaBatch(this);

		return limpiezaRalladoGabetaMezclaBatch;
	}

	public LimpiezaRalladoGabetaMezclaBatch removeLimpiezaRalladoGabetaMezclaBatch(LimpiezaRalladoGabetaMezclaBatch limpiezaRalladoGabetaMezclaBatch) {
		getLimpiezaRalladoGabetaMezclaBatches().remove(limpiezaRalladoGabetaMezclaBatch);
		limpiezaRalladoGabetaMezclaBatch.setControlFichaBatch(null);

		return limpiezaRalladoGabetaMezclaBatch;
	}

}