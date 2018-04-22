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
public class MaquinaLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idmaquinalinea;

	private String descripcion;

	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="maquinaLinea")
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;

	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="maquinaLinea")
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;

	public MaquinaLinea() {
	}

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

}