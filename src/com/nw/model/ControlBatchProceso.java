package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the control_batch_proceso database table.
 * 
 */
@Entity
@Table(name="control_batch_proceso")
@NamedQuery(name="ControlBatchProceso.findAll", query="SELECT c FROM ControlBatchProceso c")
public class ControlBatchProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcontrolbatchproceso;
	private Integer estado;
	private Timestamp fechareg;
	private ObservacionesProceso observacionesProceso;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;
	private List<ControlFichaBatch> controlFichaBatches;

	public ControlBatchProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcontrolbatchproceso() {
		return this.idcontrolbatchproceso;
	}

	public void setIdcontrolbatchproceso(Long idcontrolbatchproceso) {
		this.idcontrolbatchproceso = idcontrolbatchproceso;
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


	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
	}


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
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


	//bi-directional many-to-one association to ControlFichaBatch
	@OneToMany(mappedBy="controlBatchProceso")
	public List<ControlFichaBatch> getControlFichaBatches() {
		return this.controlFichaBatches;
	}

	public void setControlFichaBatches(List<ControlFichaBatch> controlFichaBatches) {
		this.controlFichaBatches = controlFichaBatches;
	}

	public ControlFichaBatch addControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		getControlFichaBatches().add(controlFichaBatch);
		controlFichaBatch.setControlBatchProceso(this);

		return controlFichaBatch;
	}

	public ControlFichaBatch removeControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		getControlFichaBatches().remove(controlFichaBatch);
		controlFichaBatch.setControlBatchProceso(null);

		return controlFichaBatch;
	}

}