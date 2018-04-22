package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pcc_auditoria_alarmas_lote database table.
 * 
 */
@Entity
@Table(name="pcc_auditoria_alarmas_lote")
public class PccAuditoriaAlarmasLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpccauditoriaalarmaslote;

	@Column(name="estado_alarma_final")
	private Integer estadoAlarmaFinal;

	@Column(name="estado_alarma_inicial")
	private Integer estadoAlarmaInicial;

	@Column(name="fechareg_alarma_final")
	private Timestamp fecharegAlarmaFinal;

	@Column(name="fechareg_alarma_inicial")
	private Timestamp fecharegAlarmaInicial;

	private Long idcocinaaperturacierredetalle;

	private Long idproducciondetallelote;

	private Integer proceso;

	//bi-directional many-to-one association to PccAuditoriaAlarmasLoteCocinasDetalle
	@OneToMany(mappedBy="pccAuditoriaAlarmasLote")
	private List<PccAuditoriaAlarmasLoteCocinasDetalle> pccAuditoriaAlarmasLoteCocinasDetalles;

	public PccAuditoriaAlarmasLote() {
	}

	public Long getIdpccauditoriaalarmaslote() {
		return this.idpccauditoriaalarmaslote;
	}

	public void setIdpccauditoriaalarmaslote(Long idpccauditoriaalarmaslote) {
		this.idpccauditoriaalarmaslote = idpccauditoriaalarmaslote;
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

	public Long getIdcocinaaperturacierredetalle() {
		return this.idcocinaaperturacierredetalle;
	}

	public void setIdcocinaaperturacierredetalle(Long idcocinaaperturacierredetalle) {
		this.idcocinaaperturacierredetalle = idcocinaaperturacierredetalle;
	}

	public Long getIdproducciondetallelote() {
		return this.idproducciondetallelote;
	}

	public void setIdproducciondetallelote(Long idproducciondetallelote) {
		this.idproducciondetallelote = idproducciondetallelote;
	}

	public Integer getProceso() {
		return this.proceso;
	}

	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}

	public List<PccAuditoriaAlarmasLoteCocinasDetalle> getPccAuditoriaAlarmasLoteCocinasDetalles() {
		return this.pccAuditoriaAlarmasLoteCocinasDetalles;
	}

	public void setPccAuditoriaAlarmasLoteCocinasDetalles(List<PccAuditoriaAlarmasLoteCocinasDetalle> pccAuditoriaAlarmasLoteCocinasDetalles) {
		this.pccAuditoriaAlarmasLoteCocinasDetalles = pccAuditoriaAlarmasLoteCocinasDetalles;
	}

}