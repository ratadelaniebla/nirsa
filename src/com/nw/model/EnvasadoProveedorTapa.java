package com.nw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the envasado_proveedor_tapa database table.
 * 
 */
@Entity
@Table(name="envasado_proveedor_tapa")
@NamedQuery(name="EnvasadoProveedorTapa.findAll", query="SELECT e FROM EnvasadoProveedorTapa e")
public class EnvasadoProveedorTapa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idenvasadoproveedortapa;
	private String descripcion;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;
	private List<EnvasadoFichaTecnica> envasadoFichaTecnicas;

	public EnvasadoProveedorTapa() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdenvasadoproveedortapa() {
		return this.idenvasadoproveedortapa;
	}

	public void setIdenvasadoproveedortapa(Integer idenvasadoproveedortapa) {
		this.idenvasadoproveedortapa = idenvasadoproveedortapa;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="envasadoProveedorTapa")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

	public EnvasadoDetalleProcesoCambio addEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().add(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setEnvasadoProveedorTapa(this);

		return envasadoDetalleProcesoCambio;
	}

	public EnvasadoDetalleProcesoCambio removeEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().remove(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setEnvasadoProveedorTapa(null);

		return envasadoDetalleProcesoCambio;
	}


	//bi-directional many-to-one association to EnvasadoFichaTecnica
	@OneToMany(mappedBy="envasadoProveedorTapa")
	public List<EnvasadoFichaTecnica> getEnvasadoFichaTecnicas() {
		return this.envasadoFichaTecnicas;
	}

	public void setEnvasadoFichaTecnicas(List<EnvasadoFichaTecnica> envasadoFichaTecnicas) {
		this.envasadoFichaTecnicas = envasadoFichaTecnicas;
	}

	public EnvasadoFichaTecnica addEnvasadoFichaTecnica(EnvasadoFichaTecnica envasadoFichaTecnica) {
		getEnvasadoFichaTecnicas().add(envasadoFichaTecnica);
		envasadoFichaTecnica.setEnvasadoProveedorTapa(this);

		return envasadoFichaTecnica;
	}

	public EnvasadoFichaTecnica removeEnvasadoFichaTecnica(EnvasadoFichaTecnica envasadoFichaTecnica) {
		getEnvasadoFichaTecnicas().remove(envasadoFichaTecnica);
		envasadoFichaTecnica.setEnvasadoProveedorTapa(null);

		return envasadoFichaTecnica;
	}

}