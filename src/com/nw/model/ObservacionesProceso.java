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
@NamedQuery(name="ObservacionesProceso.findAll", query="SELECT o FROM ObservacionesProceso o")
public class ObservacionesProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idobservacionesprocesos;
	private Timestamp fechareg;
	private List<CoccionProceso> coccionProcesos;
	private List<ControlBatchProceso> controlBatchProcesos;
	private List<DescongeladoProceso> descongeladoProcesos;
	private List<EvisceradoProceso> evisceradoProcesos;
	private List<LimpiezaProceso> limpiezaProcesos;
	private List<ObservacionesDetalleProceso> observacionesDetalleProcesos;
	private Proceso proceso;
	private Usuario usuario;
	private List<RociadoProceso> rociadoProcesos;

	public ObservacionesProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CoccionProceso
	@OneToMany(mappedBy="observacionesProceso")
	public List<CoccionProceso> getCoccionProcesos() {
		return this.coccionProcesos;
	}

	public void setCoccionProcesos(List<CoccionProceso> coccionProcesos) {
		this.coccionProcesos = coccionProcesos;
	}

	public CoccionProceso addCoccionProceso(CoccionProceso coccionProceso) {
		getCoccionProcesos().add(coccionProceso);
		coccionProceso.setObservacionesProceso(this);

		return coccionProceso;
	}

	public CoccionProceso removeCoccionProceso(CoccionProceso coccionProceso) {
		getCoccionProcesos().remove(coccionProceso);
		coccionProceso.setObservacionesProceso(null);

		return coccionProceso;
	}


	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="observacionesProceso")
	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public ControlBatchProceso addControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().add(controlBatchProceso);
		controlBatchProceso.setObservacionesProceso(this);

		return controlBatchProceso;
	}

	public ControlBatchProceso removeControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().remove(controlBatchProceso);
		controlBatchProceso.setObservacionesProceso(null);

		return controlBatchProceso;
	}


	//bi-directional many-to-one association to DescongeladoProceso
	@OneToMany(mappedBy="observacionesProceso")
	public List<DescongeladoProceso> getDescongeladoProcesos() {
		return this.descongeladoProcesos;
	}

	public void setDescongeladoProcesos(List<DescongeladoProceso> descongeladoProcesos) {
		this.descongeladoProcesos = descongeladoProcesos;
	}

	public DescongeladoProceso addDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		getDescongeladoProcesos().add(descongeladoProceso);
		descongeladoProceso.setObservacionesProceso(this);

		return descongeladoProceso;
	}

	public DescongeladoProceso removeDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		getDescongeladoProcesos().remove(descongeladoProceso);
		descongeladoProceso.setObservacionesProceso(null);

		return descongeladoProceso;
	}


	//bi-directional many-to-one association to EvisceradoProceso
	@OneToMany(mappedBy="observacionesProceso")
	public List<EvisceradoProceso> getEvisceradoProcesos() {
		return this.evisceradoProcesos;
	}

	public void setEvisceradoProcesos(List<EvisceradoProceso> evisceradoProcesos) {
		this.evisceradoProcesos = evisceradoProcesos;
	}

	public EvisceradoProceso addEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		getEvisceradoProcesos().add(evisceradoProceso);
		evisceradoProceso.setObservacionesProceso(this);

		return evisceradoProceso;
	}

	public EvisceradoProceso removeEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		getEvisceradoProcesos().remove(evisceradoProceso);
		evisceradoProceso.setObservacionesProceso(null);

		return evisceradoProceso;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="observacionesProceso")
	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public LimpiezaProceso addLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().add(limpiezaProceso);
		limpiezaProceso.setObservacionesProceso(this);

		return limpiezaProceso;
	}

	public LimpiezaProceso removeLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().remove(limpiezaProceso);
		limpiezaProceso.setObservacionesProceso(null);

		return limpiezaProceso;
	}


	//bi-directional many-to-one association to ObservacionesDetalleProceso
	@OneToMany(mappedBy="observacionesProceso")
	public List<ObservacionesDetalleProceso> getObservacionesDetalleProcesos() {
		return this.observacionesDetalleProcesos;
	}

	public void setObservacionesDetalleProcesos(List<ObservacionesDetalleProceso> observacionesDetalleProcesos) {
		this.observacionesDetalleProcesos = observacionesDetalleProcesos;
	}

	public ObservacionesDetalleProceso addObservacionesDetalleProceso(ObservacionesDetalleProceso observacionesDetalleProceso) {
		getObservacionesDetalleProcesos().add(observacionesDetalleProceso);
		observacionesDetalleProceso.setObservacionesProceso(this);

		return observacionesDetalleProceso;
	}

	public ObservacionesDetalleProceso removeObservacionesDetalleProceso(ObservacionesDetalleProceso observacionesDetalleProceso) {
		getObservacionesDetalleProcesos().remove(observacionesDetalleProceso);
		observacionesDetalleProceso.setObservacionesProceso(null);

		return observacionesDetalleProceso;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
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


	//bi-directional many-to-one association to RociadoProceso
	@OneToMany(mappedBy="observacionesProceso")
	public List<RociadoProceso> getRociadoProcesos() {
		return this.rociadoProcesos;
	}

	public void setRociadoProcesos(List<RociadoProceso> rociadoProcesos) {
		this.rociadoProcesos = rociadoProcesos;
	}

	public RociadoProceso addRociadoProceso(RociadoProceso rociadoProceso) {
		getRociadoProcesos().add(rociadoProceso);
		rociadoProceso.setObservacionesProceso(this);

		return rociadoProceso;
	}

	public RociadoProceso removeRociadoProceso(RociadoProceso rociadoProceso) {
		getRociadoProcesos().remove(rociadoProceso);
		rociadoProceso.setObservacionesProceso(null);

		return rociadoProceso;
	}

}