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
public class MaquinaDetectorMetal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idmaquinadetectormetal;

	private String descripcion;

	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="maquinaDetectorMetal")
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;

	public MaquinaDetectorMetal() {
	}

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

	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

}