package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ducharociado database table.
 * 
 */
@Entity
@NamedQuery(name="Ducharociado.findAll", query="SELECT d FROM Ducharociado d")
public class Ducharociado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idducharociado;
	private String descripcion;
	private List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches;
	private List<RociadoCocinadaDetalle> rociadoCocinadaDetalles;

	public Ducharociado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdducharociado() {
		return this.idducharociado;
	}

	public void setIdducharociado(Integer idducharociado) {
		this.idducharociado = idducharociado;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@OneToMany(mappedBy="ducharociadoBean")
	public List<CoccionDetalleProcesoCoche> getCoccionDetalleProcesoCoches() {
		return this.coccionDetalleProcesoCoches;
	}

	public void setCoccionDetalleProcesoCoches(List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches) {
		this.coccionDetalleProcesoCoches = coccionDetalleProcesoCoches;
	}

	public CoccionDetalleProcesoCoche addCoccionDetalleProcesoCoch(CoccionDetalleProcesoCoche coccionDetalleProcesoCoch) {
		getCoccionDetalleProcesoCoches().add(coccionDetalleProcesoCoch);
		coccionDetalleProcesoCoch.setDucharociadoBean(this);

		return coccionDetalleProcesoCoch;
	}

	public CoccionDetalleProcesoCoche removeCoccionDetalleProcesoCoch(CoccionDetalleProcesoCoche coccionDetalleProcesoCoch) {
		getCoccionDetalleProcesoCoches().remove(coccionDetalleProcesoCoch);
		coccionDetalleProcesoCoch.setDucharociadoBean(null);

		return coccionDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to RociadoCocinadaDetalle
	@OneToMany(mappedBy="ducharociado")
	public List<RociadoCocinadaDetalle> getRociadoCocinadaDetalles() {
		return this.rociadoCocinadaDetalles;
	}

	public void setRociadoCocinadaDetalles(List<RociadoCocinadaDetalle> rociadoCocinadaDetalles) {
		this.rociadoCocinadaDetalles = rociadoCocinadaDetalles;
	}

	public RociadoCocinadaDetalle addRociadoCocinadaDetalle(RociadoCocinadaDetalle rociadoCocinadaDetalle) {
		getRociadoCocinadaDetalles().add(rociadoCocinadaDetalle);
		rociadoCocinadaDetalle.setDucharociado(this);

		return rociadoCocinadaDetalle;
	}

	public RociadoCocinadaDetalle removeRociadoCocinadaDetalle(RociadoCocinadaDetalle rociadoCocinadaDetalle) {
		getRociadoCocinadaDetalles().remove(rociadoCocinadaDetalle);
		rociadoCocinadaDetalle.setDucharociado(null);

		return rociadoCocinadaDetalle;
	}

}