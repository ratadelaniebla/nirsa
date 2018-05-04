package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pcc_auditoria_alarmas_batch database table.
 * 
 */
@Entity
@Table(name="pcc_auditoria_alarmas_batch")
@NamedQuery(name="PccAuditoriaAlarmasBatch.findAll", query="SELECT p FROM PccAuditoriaAlarmasBatch p")
public class PccAuditoriaAlarmasBatch implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpccauditoriaalarmasbatch;
	private Integer estadoAlarmaFinal;
	private Integer estadoAlarmaInicial;
	private Timestamp fecharegAlarmaFinal;
	private Timestamp fecharegAlarmaInicial;
	private Long idcontrolfichabatch;
	private Integer pcc;
	private Integer proceso;

	public PccAuditoriaAlarmasBatch() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdpccauditoriaalarmasbatch() {
		return this.idpccauditoriaalarmasbatch;
	}

	public void setIdpccauditoriaalarmasbatch(Long idpccauditoriaalarmasbatch) {
		this.idpccauditoriaalarmasbatch = idpccauditoriaalarmasbatch;
	}


	@Column(name="estado_alarma_final")
	public Integer getEstadoAlarmaFinal() {
		return this.estadoAlarmaFinal;
	}

	public void setEstadoAlarmaFinal(Integer estadoAlarmaFinal) {
		this.estadoAlarmaFinal = estadoAlarmaFinal;
	}


	@Column(name="estado_alarma_inicial")
	public Integer getEstadoAlarmaInicial() {
		return this.estadoAlarmaInicial;
	}

	public void setEstadoAlarmaInicial(Integer estadoAlarmaInicial) {
		this.estadoAlarmaInicial = estadoAlarmaInicial;
	}


	@Column(name="fechareg_alarma_final")
	public Timestamp getFecharegAlarmaFinal() {
		return this.fecharegAlarmaFinal;
	}

	public void setFecharegAlarmaFinal(Timestamp fecharegAlarmaFinal) {
		this.fecharegAlarmaFinal = fecharegAlarmaFinal;
	}


	@Column(name="fechareg_alarma_inicial")
	public Timestamp getFecharegAlarmaInicial() {
		return this.fecharegAlarmaInicial;
	}

	public void setFecharegAlarmaInicial(Timestamp fecharegAlarmaInicial) {
		this.fecharegAlarmaInicial = fecharegAlarmaInicial;
	}


	public Long getIdcontrolfichabatch() {
		return this.idcontrolfichabatch;
	}

	public void setIdcontrolfichabatch(Long idcontrolfichabatch) {
		this.idcontrolfichabatch = idcontrolfichabatch;
	}


	public Integer getPcc() {
		return this.pcc;
	}

	public void setPcc(Integer pcc) {
		this.pcc = pcc;
	}


	public Integer getProceso() {
		return this.proceso;
	}

	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}

}