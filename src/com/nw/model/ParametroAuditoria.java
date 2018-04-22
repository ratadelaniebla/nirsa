package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the parametro_auditoria database table.
 * 
 */
@Entity
@Table(name="parametro_auditoria")
public class ParametroAuditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idparametroauditoria;

	private String accionparametro;

	private Timestamp fecharegistro;

	//bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name="idparametro")
	private Parametro parametro;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public ParametroAuditoria() {
	}

	public Long getIdparametroauditoria() {
		return this.idparametroauditoria;
	}

	public void setIdparametroauditoria(Long idparametroauditoria) {
		this.idparametroauditoria = idparametroauditoria;
	}

	public String getAccionparametro() {
		return this.accionparametro;
	}

	public void setAccionparametro(String accionparametro) {
		this.accionparametro = accionparametro;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Parametro getParametro() {
		return this.parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}