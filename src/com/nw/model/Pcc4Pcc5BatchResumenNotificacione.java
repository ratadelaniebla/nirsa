package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pcc4_pcc5_batch_resumen_notificaciones database table.
 * 
 */
@Entity
@Table(name="pcc4_pcc5_batch_resumen_notificaciones")
@NamedQuery(name="Pcc4Pcc5BatchResumenNotificacione.findAll", query="SELECT p FROM Pcc4Pcc5BatchResumenNotificacione p")
public class Pcc4Pcc5BatchResumenNotificacione implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idPcc4Pcc5BatchResumenNotificaciones;
	private String batch;
	private String especieTalla;
	private Integer notificar;
	private Integer pcc;
	private String proceso;
	private String tarjetaBatch;
	private String tiempoAlarma;
	private Integer tipoAlarma;
	private Integer tipoProceso;

	public Pcc4Pcc5BatchResumenNotificacione() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pcc4_pcc5_batch_resumen_notificaciones")
	public Long getIdPcc4Pcc5BatchResumenNotificaciones() {
		return this.idPcc4Pcc5BatchResumenNotificaciones;
	}

	public void setIdPcc4Pcc5BatchResumenNotificaciones(Long idPcc4Pcc5BatchResumenNotificaciones) {
		this.idPcc4Pcc5BatchResumenNotificaciones = idPcc4Pcc5BatchResumenNotificaciones;
	}


	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}


	@Column(name="especie_talla")
	public String getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(String especieTalla) {
		this.especieTalla = especieTalla;
	}


	public Integer getNotificar() {
		return this.notificar;
	}

	public void setNotificar(Integer notificar) {
		this.notificar = notificar;
	}


	public Integer getPcc() {
		return this.pcc;
	}

	public void setPcc(Integer pcc) {
		this.pcc = pcc;
	}


	public String getProceso() {
		return this.proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}


	@Column(name="tarjeta_batch")
	public String getTarjetaBatch() {
		return this.tarjetaBatch;
	}

	public void setTarjetaBatch(String tarjetaBatch) {
		this.tarjetaBatch = tarjetaBatch;
	}


	@Column(name="tiempo_alarma")
	public String getTiempoAlarma() {
		return this.tiempoAlarma;
	}

	public void setTiempoAlarma(String tiempoAlarma) {
		this.tiempoAlarma = tiempoAlarma;
	}


	@Column(name="tipo_alarma")
	public Integer getTipoAlarma() {
		return this.tipoAlarma;
	}

	public void setTipoAlarma(Integer tipoAlarma) {
		this.tipoAlarma = tipoAlarma;
	}


	@Column(name="tipo_proceso")
	public Integer getTipoProceso() {
		return this.tipoProceso;
	}

	public void setTipoProceso(Integer tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

}