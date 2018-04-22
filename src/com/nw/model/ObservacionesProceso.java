package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the observaciones_procesos database table.
 * 
 */
@Entity
@Table(name="observaciones_procesos")
public class ObservacionesProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idobservacionesprocesos;

	private Timestamp fechareg;

	//bi-directional many-to-one association to CoccionProceso
	@OneToMany(mappedBy="observacionesProceso")
	private List<CoccionProceso> coccionProcesos;

	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="observacionesProceso")
	private List<ControlBatchProceso> controlBatchProcesos;

	//bi-directional many-to-one association to DescongeladoProceso
	@OneToMany(mappedBy="observacionesProceso")
	private List<DescongeladoProceso> descongeladoProcesos;

	//bi-directional many-to-one association to EvisceradoProceso
	@OneToMany(mappedBy="observacionesProceso")
	private List<EvisceradoProceso> evisceradoProcesos;

	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="observacionesProceso")
	private List<LimpiezaProceso> limpiezaProcesos;

	//bi-directional many-to-one association to ObservacionesDetalleProceso
	@OneToMany(mappedBy="observacionesProceso")
	private List<ObservacionesDetalleProceso> observacionesDetalleProcesos;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to RociadoProceso
	@OneToMany(mappedBy="observacionesProceso")
	private List<RociadoProceso> rociadoProcesos;

	public ObservacionesProceso() {
	}

	public Long getIdobservacionesprocesos() {
		return this.idobservacionesprocesos;
	}

	public void setIdobservacionesprocesos(Long idobservacionesprocesos) {
		this.idobservacionesprocesos = idobservacionesprocesos;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<CoccionProceso> getCoccionProcesos() {
		return this.coccionProcesos;
	}

	public void setCoccionProcesos(List<CoccionProceso> coccionProcesos) {
		this.coccionProcesos = coccionProcesos;
	}

	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public List<DescongeladoProceso> getDescongeladoProcesos() {
		return this.descongeladoProcesos;
	}

	public void setDescongeladoProcesos(List<DescongeladoProceso> descongeladoProcesos) {
		this.descongeladoProcesos = descongeladoProcesos;
	}

	public List<EvisceradoProceso> getEvisceradoProcesos() {
		return this.evisceradoProcesos;
	}

	public void setEvisceradoProcesos(List<EvisceradoProceso> evisceradoProcesos) {
		this.evisceradoProcesos = evisceradoProcesos;
	}

	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public List<ObservacionesDetalleProceso> getObservacionesDetalleProcesos() {
		return this.observacionesDetalleProcesos;
	}

	public void setObservacionesDetalleProcesos(List<ObservacionesDetalleProceso> observacionesDetalleProcesos) {
		this.observacionesDetalleProcesos = observacionesDetalleProcesos;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<RociadoProceso> getRociadoProcesos() {
		return this.rociadoProcesos;
	}

	public void setRociadoProcesos(List<RociadoProceso> rociadoProcesos) {
		this.rociadoProcesos = rociadoProcesos;
	}

}