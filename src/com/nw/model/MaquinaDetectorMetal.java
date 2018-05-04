package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the maquina_detector_metal database table.
 * 
 */
@Entity
@Table(name="maquina_detector_metal")
@NamedQuery(name="MaquinaDetectorMetal.findAll", query="SELECT m FROM MaquinaDetectorMetal m")
public class MaquinaDetectorMetal implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idmaquinadetectormetal;
	private String descripcion;
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;

	public MaquinaDetectorMetal() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdmaquinadetectormetal() {
		return this.idmaquinadetectormetal;
	}

	public void setIdmaquinadetectormetal(Integer idmaquinadetectormetal) {
		this.idmaquinadetectormetal = idmaquinadetectormetal;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="maquinaDetectorMetal")
	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

	public ControlDetalleBatchMaquina addControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().add(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setMaquinaDetectorMetal(this);

		return controlDetalleBatchMaquina;
	}

	public ControlDetalleBatchMaquina removeControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().remove(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setMaquinaDetectorMetal(null);

		return controlDetalleBatchMaquina;
	}

}