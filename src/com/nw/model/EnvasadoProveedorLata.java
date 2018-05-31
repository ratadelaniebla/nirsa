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
 * The persistent class for the envasado_proveedor_latas database table.
 * 
 */
@Entity
@Table(name="envasado_proveedor_latas")
@NamedQuery(name="EnvasadoProveedorLata.findAll", query="SELECT e FROM EnvasadoProveedorLata e")
public class EnvasadoProveedorLata implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idenvasadoproveedorlatas;
	private String descripcion;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;
	private List<EnvasadoFichaTecnica> envasadoFichaTecnicas;

	public EnvasadoProveedorLata() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdenvasadoproveedorlatas() {
		return this.idenvasadoproveedorlatas;
	}

	public void setIdenvasadoproveedorlatas(Integer idenvasadoproveedorlatas) {
		this.idenvasadoproveedorlatas = idenvasadoproveedorlatas;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="envasadoProveedorLata")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

	public EnvasadoDetalleProcesoCambio addEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().add(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setEnvasadoProveedorLata(this);

		return envasadoDetalleProcesoCambio;
	}

	public EnvasadoDetalleProcesoCambio removeEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().remove(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setEnvasadoProveedorLata(null);

		return envasadoDetalleProcesoCambio;
	}


	//bi-directional many-to-one association to EnvasadoFichaTecnica
	@OneToMany(mappedBy="envasadoProveedorLata")
	public List<EnvasadoFichaTecnica> getEnvasadoFichaTecnicas() {
		return this.envasadoFichaTecnicas;
	}

	public void setEnvasadoFichaTecnicas(List<EnvasadoFichaTecnica> envasadoFichaTecnicas) {
		this.envasadoFichaTecnicas = envasadoFichaTecnicas;
	}

	public EnvasadoFichaTecnica addEnvasadoFichaTecnica(EnvasadoFichaTecnica envasadoFichaTecnica) {
		getEnvasadoFichaTecnicas().add(envasadoFichaTecnica);
		envasadoFichaTecnica.setEnvasadoProveedorLata(this);

		return envasadoFichaTecnica;
	}

	public EnvasadoFichaTecnica removeEnvasadoFichaTecnica(EnvasadoFichaTecnica envasadoFichaTecnica) {
		getEnvasadoFichaTecnicas().remove(envasadoFichaTecnica);
		envasadoFichaTecnica.setEnvasadoProveedorLata(null);

		return envasadoFichaTecnica;
	}

}