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
@NamedQuery(name="DescongeladoDucha.findAll", query="SELECT d FROM DescongeladoDucha d")
public class DescongeladoDucha implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idducha;
	private String descripcion;
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;
	private List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles;
	private List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles;

	public DescongeladoDucha() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoDucha")
	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public AtcDescongeladoDetalleProceso addAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().add(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setDescongeladoDucha(this);

		return atcDescongeladoDetalleProceso;
	}

	public AtcDescongeladoDetalleProceso removeAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().remove(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setDescongeladoDucha(null);

		return atcDescongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="descongeladoDucha")
	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public DescongeladoCajonModificacion addDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().add(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setDescongeladoDucha(this);

		return descongeladoCajonModificacion;
	}

	public DescongeladoCajonModificacion removeDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().remove(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setDescongeladoDucha(null);

		return descongeladoCajonModificacion;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="descongeladoDucha")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().add(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setDescongeladoDucha(this);

		return descongeladoDetalleProceso;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().remove(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setDescongeladoDucha(null);

		return descongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@OneToMany(mappedBy="descongeladoDucha")
	public List<DescongeladoDuchaAperturaCierreDetalle> getDescongeladoDuchaAperturaCierreDetalles() {
		return this.descongeladoDuchaAperturaCierreDetalles;
	}

	public void setDescongeladoDuchaAperturaCierreDetalles(List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles) {
		this.descongeladoDuchaAperturaCierreDetalles = descongeladoDuchaAperturaCierreDetalles;
	}

	public DescongeladoDuchaAperturaCierreDetalle addDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		getDescongeladoDuchaAperturaCierreDetalles().add(descongeladoDuchaAperturaCierreDetalle);
		descongeladoDuchaAperturaCierreDetalle.setDescongeladoDucha(this);

		return descongeladoDuchaAperturaCierreDetalle;
	}

	public DescongeladoDuchaAperturaCierreDetalle removeDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		getDescongeladoDuchaAperturaCierreDetalles().remove(descongeladoDuchaAperturaCierreDetalle);
		descongeladoDuchaAperturaCierreDetalle.setDescongeladoDucha(null);

		return descongeladoDuchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@OneToMany(mappedBy="descongeladoDucha")
	public List<DuchaAperturaCierreDetalle> getDuchaAperturaCierreDetalles() {
		return this.duchaAperturaCierreDetalles;
	}

	public void setDuchaAperturaCierreDetalles(List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles) {
		this.duchaAperturaCierreDetalles = duchaAperturaCierreDetalles;
	}

	public DuchaAperturaCierreDetalle addDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		getDuchaAperturaCierreDetalles().add(duchaAperturaCierreDetalle);
		duchaAperturaCierreDetalle.setDescongeladoDucha(this);

		return duchaAperturaCierreDetalle;
	}

	public DuchaAperturaCierreDetalle removeDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		getDuchaAperturaCierreDetalles().remove(duchaAperturaCierreDetalle);
		duchaAperturaCierreDetalle.setDescongeladoDucha(null);

		return duchaAperturaCierreDetalle;
	}

}