package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the maquina_linea database table.
 * 
 */
@Entity
@Table(name="maquina_linea")
@NamedQuery(name="MaquinaLinea.findAll", query="SELECT m FROM MaquinaLinea m")
public class MaquinaLinea implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idmaquinalinea;
	private String descripcion;
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;

	public MaquinaLinea() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdmaquinalinea() {
		return this.idmaquinalinea;
	}

	public void setIdmaquinalinea(Integer idmaquinalinea) {
		this.idmaquinalinea = idmaquinalinea;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="maquinaLinea")
	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
	}

	public ControlDetalleBatchLimpieza addControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().add(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setMaquinaLinea(this);

		return controlDetalleBatchLimpieza;
	}

	public ControlDetalleBatchLimpieza removeControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().remove(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setMaquinaLinea(null);

		return controlDetalleBatchLimpieza;
	}


	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="maquinaLinea")
	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

	public ControlDetalleBatchMaquina addControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().add(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setMaquinaLinea(this);

		return controlDetalleBatchMaquina;
	}

	public ControlDetalleBatchMaquina removeControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().remove(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setMaquinaLinea(null);

		return controlDetalleBatchMaquina;
	}

}