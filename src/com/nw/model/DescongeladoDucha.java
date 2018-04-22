package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the descongelado_ducha database table.
 * 
 */
@Entity
@Table(name="descongelado_ducha")
public class DescongeladoDucha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idducha;

	private String descripcion;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoDucha")
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;

	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="descongeladoDucha")
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoDucha")
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;

	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@OneToMany(mappedBy="descongeladoDucha")
	private List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles;

	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@OneToMany(mappedBy="descongeladoDucha")
	private List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles;

	public DescongeladoDucha() {
	}

	public Integer getIdducha() {
		return this.idducha;
	}

	public void setIdducha(Integer idducha) {
		this.idducha = idducha;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public List<DescongeladoDuchaAperturaCierreDetalle> getDescongeladoDuchaAperturaCierreDetalles() {
		return this.descongeladoDuchaAperturaCierreDetalles;
	}

	public void setDescongeladoDuchaAperturaCierreDetalles(List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles) {
		this.descongeladoDuchaAperturaCierreDetalles = descongeladoDuchaAperturaCierreDetalles;
	}

	public List<DuchaAperturaCierreDetalle> getDuchaAperturaCierreDetalles() {
		return this.duchaAperturaCierreDetalles;
	}

	public void setDuchaAperturaCierreDetalles(List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles) {
		this.duchaAperturaCierreDetalles = duchaAperturaCierreDetalles;
	}

}