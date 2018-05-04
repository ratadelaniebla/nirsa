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
@NamedQuery(name="PccAuditoriaAlarmasLote.findAll", query="SELECT p FROM PccAuditoriaAlarmasLote p")
public class PccAuditoriaAlarmasLote implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpccauditoriaalarmaslote;
	private Integer estadoAlarmaFinal;
	private Integer estadoAlarmaInicial;
	private Timestamp fecharegAlarmaFinal;
	private Timestamp fecharegAlarmaInicial;
	private Long idcocinaaperturacierredetalle;
	private Long idproducciondetallelote;
	private Integer proceso;
	private List<PccAuditoriaAlarmasLoteCocinasDetalle> pccAuditoriaAlarmasLoteCocinasDetalles;

	public PccAuditoriaAlarmasLote() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdpccauditoriaalarmaslote() {
		return this.idpccauditoriaalarmaslote;
	}

	public void setIdpccauditoriaalarmaslote(Long idpccauditoriaalarmaslote) {
		this.idpccauditoriaalarmaslote = idpccauditoriaalarmaslote;
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


	//bi-directional many-to-one association to PccAuditoriaAlarmasLoteCocinasDetalle
	@OneToMany(mappedBy="pccAuditoriaAlarmasLote")
	public List<PccAuditoriaAlarmasLoteCocinasDetalle> getPccAuditoriaAlarmasLoteCocinasDetalles() {
		return this.pccAuditoriaAlarmasLoteCocinasDetalles;
	}

	public void setPccAuditoriaAlarmasLoteCocinasDetalles(List<PccAuditoriaAlarmasLoteCocinasDetalle> pccAuditoriaAlarmasLoteCocinasDetalles) {
		this.pccAuditoriaAlarmasLoteCocinasDetalles = pccAuditoriaAlarmasLoteCocinasDetalles;
	}

	public PccAuditoriaAlarmasLoteCocinasDetalle addPccAuditoriaAlarmasLoteCocinasDetalle(PccAuditoriaAlarmasLoteCocinasDetalle pccAuditoriaAlarmasLoteCocinasDetalle) {
		getPccAuditoriaAlarmasLoteCocinasDetalles().add(pccAuditoriaAlarmasLoteCocinasDetalle);
		pccAuditoriaAlarmasLoteCocinasDetalle.setPccAuditoriaAlarmasLote(this);

		return pccAuditoriaAlarmasLoteCocinasDetalle;
	}

	public PccAuditoriaAlarmasLoteCocinasDetalle removePccAuditoriaAlarmasLoteCocinasDetalle(PccAuditoriaAlarmasLoteCocinasDetalle pccAuditoriaAlarmasLoteCocinasDetalle) {
		getPccAuditoriaAlarmasLoteCocinasDetalles().remove(pccAuditoriaAlarmasLoteCocinasDetalle);
		pccAuditoriaAlarmasLoteCocinasDetalle.setPccAuditoriaAlarmasLote(null);

		return pccAuditoriaAlarmasLoteCocinasDetalle;
	}

}