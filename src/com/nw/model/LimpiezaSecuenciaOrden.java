package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_secuencia_orden database table.
 * 
 */
@Entity
@Table(name="limpieza_secuencia_orden")
@NamedQuery(name="LimpiezaSecuenciaOrden.findAll", query="SELECT l FROM LimpiezaSecuenciaOrden l")
public class LimpiezaSecuenciaOrden implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idsecuenciaorden;
	private String codpersona;
	private Integer contador;
	private Long ordenBandeja;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	public LimpiezaSecuenciaOrden() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdsecuenciaorden() {
		return this.idsecuenciaorden;
	}

	public void setIdsecuenciaorden(Long idsecuenciaorden) {
		this.idsecuenciaorden = idsecuenciaorden;
	}


	public String getCodpersona() {
		return this.codpersona;
	}

	public void setCodpersona(String codpersona) {
		this.codpersona = codpersona;
	}


	public Integer getContador() {
		return this.contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}


	@Column(name="orden_bandeja")
	public Long getOrdenBandeja() {
		return this.ordenBandeja;
	}

	public void setOrdenBandeja(Long ordenBandeja) {
		this.ordenBandeja = ordenBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaSecuenciaOrden")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().add(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setLimpiezaSecuenciaOrden(this);

		return limpiezaDetalleProcesoBandeja;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().remove(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setLimpiezaSecuenciaOrden(null);

		return limpiezaDetalleProcesoBandeja;
	}

}