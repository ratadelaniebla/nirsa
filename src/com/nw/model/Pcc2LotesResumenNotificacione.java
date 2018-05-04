package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pcc2_lotes_resumen_notificaciones database table.
 * 
 */
@Entity
@Table(name="pcc2_lotes_resumen_notificaciones")
@NamedQuery(name="Pcc2LotesResumenNotificacione.findAll", query="SELECT p FROM Pcc2LotesResumenNotificacione p")
public class Pcc2LotesResumenNotificacione implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idPcc2LotesResumenNotificaciones;
	private String cocinaCocinada;
	private String especieTalla;
	private Integer idlote;
	private Integer notificar;
	private String proceso;
	private String tiempoAlarma;
	private Integer tipoAlarma;
	private Integer tipoProceso;

	public Pcc2LotesResumenNotificacione() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pcc2_lotes_resumen_notificaciones")
	public Long getIdPcc2LotesResumenNotificaciones() {
		return this.idPcc2LotesResumenNotificaciones;
	}

	public void setIdPcc2LotesResumenNotificaciones(Long idPcc2LotesResumenNotificaciones) {
		this.idPcc2LotesResumenNotificaciones = idPcc2LotesResumenNotificaciones;
	}


	@Column(name="cocina_cocinada")
	public String getCocinaCocinada() {
		return this.cocinaCocinada;
	}

	public void setCocinaCocinada(String cocinaCocinada) {
		this.cocinaCocinada = cocinaCocinada;
	}


	@Column(name="especie_talla")
	public String getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(String especieTalla) {
		this.especieTalla = especieTalla;
	}


	public Integer getIdlote() {
		return this.idlote;
	}

	public void setIdlote(Integer idlote) {
		this.idlote = idlote;
	}


	public Integer getNotificar() {
		return this.notificar;
	}

	public void setNotificar(Integer notificar) {
		this.notificar = notificar;
	}


	public String getProceso() {
		return this.proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
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