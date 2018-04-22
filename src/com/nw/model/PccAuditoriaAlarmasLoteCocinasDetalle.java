package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pcc_auditoria_alarmas_lote_cocinas_detalle database table.
 * 
 */
@Entity
@Table(name="pcc_auditoria_alarmas_lote_cocinas_detalle")
public class PccAuditoriaAlarmasLoteCocinasDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpccauditoriaalarmaslotecocinasdetalle;

	@Column(name="alarma_final")
	private Integer alarmaFinal;

	private Timestamp fechareg;

	private Long idcocinaaperturacierredetalle;

	//bi-directional many-to-one association to PccAuditoriaAlarmasLote
	@ManyToOne
	@JoinColumn(name="idpccauditoriaalarmaslote")
	private PccAuditoriaAlarmasLote pccAuditoriaAlarmasLote;

	public PccAuditoriaAlarmasLoteCocinasDetalle() {
	}

	public Long getIdpccauditoriaalarmaslotecocinasdetalle() {
		return this.idpccauditoriaalarmaslotecocinasdetalle;
	}

	public void setIdpccauditoriaalarmaslotecocinasdetalle(Long idpccauditoriaalarmaslotecocinasdetalle) {
		this.idpccauditoriaalarmaslotecocinasdetalle = idpccauditoriaalarmaslotecocinasdetalle;
	}

	public Integer getAlarmaFinal() {
		return this.alarmaFinal;
	}

	public void setAlarmaFinal(Integer alarmaFinal) {
		this.alarmaFinal = alarmaFinal;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Long getIdcocinaaperturacierredetalle() {
		return this.idcocinaaperturacierredetalle;
	}

	public void setIdcocinaaperturacierredetalle(Long idcocinaaperturacierredetalle) {
		this.idcocinaaperturacierredetalle = idcocinaaperturacierredetalle;
	}

	public PccAuditoriaAlarmasLote getPccAuditoriaAlarmasLote() {
		return this.pccAuditoriaAlarmasLote;
	}

	public void setPccAuditoriaAlarmasLote(PccAuditoriaAlarmasLote pccAuditoriaAlarmasLote) {
		this.pccAuditoriaAlarmasLote = pccAuditoriaAlarmasLote;
	}

}