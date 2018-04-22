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
public class LimpiezaSecuenciaOrden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsecuenciaorden;

	private String codpersona;

	private Integer contador;

	@Column(name="orden_bandeja")
	private Long ordenBandeja;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaSecuenciaOrden")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	public LimpiezaSecuenciaOrden() {
	}

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

	public Long getOrdenBandeja() {
		return this.ordenBandeja;
	}

	public void setOrdenBandeja(Long ordenBandeja) {
		this.ordenBandeja = ordenBandeja;
	}

	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

}