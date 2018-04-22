package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_rallado_detalle_pesos database table.
 * 
 */
@Entity
@Table(name="limpieza_rallado_detalle_pesos")
public class LimpiezaRalladoDetallePeso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaralladodetallepesos;

	private Boolean almacenarpeso;

	private Boolean automatico;

	private Timestamp fechareg;

	private Integer gaveta;

	private Long idlimpiezadetalleprocesolote;

	private double peso;

	private double tara;

	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="limpiezaRalladoDetallePeso")
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados;

	//bi-directional many-to-one association to LimpiezaRalladoBatchDetalle
	@OneToMany(mappedBy="limpiezaRalladoDetallePeso")
	private List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles;

	//bi-directional many-to-one association to ControlFichaBatch
	@ManyToOne
	@JoinColumn(name="idcontrolfichabatch")
	private ControlFichaBatch controlFichaBatch;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to LimpiezaRalladoTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladotipo")
	private LimpiezaRalladoTipo limpiezaRalladoTipo;

	public LimpiezaRalladoDetallePeso() {
	}

	public Long getIdlimpiezaralladodetallepesos() {
		return this.idlimpiezaralladodetallepesos;
	}

	public void setIdlimpiezaralladodetallepesos(Long idlimpiezaralladodetallepesos) {
		this.idlimpiezaralladodetallepesos = idlimpiezaralladodetallepesos;
	}

	public Boolean getAlmacenarpeso() {
		return this.almacenarpeso;
	}

	public void setAlmacenarpeso(Boolean almacenarpeso) {
		this.almacenarpeso = almacenarpeso;
	}

	public Boolean getAutomatico() {
		return this.automatico;
	}

	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getGaveta() {
		return this.gaveta;
	}

	public void setGaveta(Integer gaveta) {
		this.gaveta = gaveta;
	}

	public Long getIdlimpiezadetalleprocesolote() {
		return this.idlimpiezadetalleprocesolote;
	}

	public void setIdlimpiezadetalleprocesolote(Long idlimpiezadetalleprocesolote) {
		this.idlimpiezadetalleprocesolote = idlimpiezadetalleprocesolote;
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

	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados() {
		return this.controlDetalleBatchRallados;
	}

	public void setControlDetalleBatchRallados(List<ControlDetalleBatchRallado> controlDetalleBatchRallados) {
		this.controlDetalleBatchRallados = controlDetalleBatchRallados;
	}

	public List<LimpiezaRalladoBatchDetalle> getLimpiezaRalladoBatchDetalles() {
		return this.limpiezaRalladoBatchDetalles;
	}

	public void setLimpiezaRalladoBatchDetalles(List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles) {
		this.limpiezaRalladoBatchDetalles = limpiezaRalladoBatchDetalles;
	}

	public ControlFichaBatch getControlFichaBatch() {
		return this.controlFichaBatch;
	}

	public void setControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		this.controlFichaBatch = controlFichaBatch;
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

	public LimpiezaRalladoTipo getLimpiezaRalladoTipo() {
		return this.limpiezaRalladoTipo;
	}

	public void setLimpiezaRalladoTipo(LimpiezaRalladoTipo limpiezaRalladoTipo) {
		this.limpiezaRalladoTipo = limpiezaRalladoTipo;
	}

}