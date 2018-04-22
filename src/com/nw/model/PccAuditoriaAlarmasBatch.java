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
public class PccAuditoriaAlarmasBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpccauditoriaalarmasbatch;

	@Column(name="estado_alarma_final")
	private Integer estadoAlarmaFinal;

	@Column(name="estado_alarma_inicial")
	private Integer estadoAlarmaInicial;

	@Column(name="fechareg_alarma_final")
	private Timestamp fecharegAlarmaFinal;

	@Column(name="fechareg_alarma_inicial")
	private Timestamp fecharegAlarmaInicial;

	private Long idcontrolfichabatch;

	private Integer pcc;

	private Integer proceso;

	public PccAuditoriaAlarmasBatch() {
	}

	public Long getIdpccauditoriaalarmasbatch() {
		return this.idpccauditoriaalarmasbatch;
	}

	public void setIdpccauditoriaalarmasbatch(Long idpccauditoriaalarmasbatch) {
		this.idpccauditoriaalarmasbatch = idpccauditoriaalarmasbatch;
	}

	public Integer getEstadoAlarmaFinal() {
		return this.estadoAlarmaFinal;
	}

	public void setEstadoAlarmaFinal(Integer estadoAlarmaFinal) {
		this.estadoAlarmaFinal = estadoAlarmaFinal;
	}

	public Integer getEstadoAlarmaInicial() {
		return this.estadoAlarmaInicial;
	}

	public void setEstadoAlarmaInicial(Integer estadoAlarmaInicial) {
		this.estadoAlarmaInicial = estadoAlarmaInicial;
	}

	public Timestamp getFecharegAlarmaFinal() {
		return this.fecharegAlarmaFinal;
	}

	public void setFecharegAlarmaFinal(Timestamp fecharegAlarmaFinal) {
		this.fecharegAlarmaFinal = fecharegAlarmaFinal;
	}

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