package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idparametro;
	private String descripcionparametro;
	private String permiso;
	private double valor;
	private double valor2;
	private List<ParametroAuditoria> parametroAuditorias;

	public Parametro() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdparametro() {
		return this.idparametro;
	}

	public void setIdparametro(Integer idparametro) {
		this.idparametro = idparametro;
	}


	public String getDescripcionparametro() {
		return this.descripcionparametro;
	}

	public void setDescripcionparametro(String descripcionparametro) {
		this.descripcionparametro = descripcionparametro;
	}


	public String getPermiso() {
		return this.permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}


	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public double getValor2() {
		return this.valor2;
	}

	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}


	//bi-directional many-to-one association to ParametroAuditoria
	@OneToMany(mappedBy="parametro")
	public List<ParametroAuditoria> getParametroAuditorias() {
		return this.parametroAuditorias;
	}

	public void setParametroAuditorias(List<ParametroAuditoria> parametroAuditorias) {
		this.parametroAuditorias = parametroAuditorias;
	}

	public ParametroAuditoria addParametroAuditoria(ParametroAuditoria parametroAuditoria) {
		getParametroAuditorias().add(parametroAuditoria);
		parametroAuditoria.setParametro(this);

		return parametroAuditoria;
	}

	public ParametroAuditoria removeParametroAuditoria(ParametroAuditoria parametroAuditoria) {
		getParametroAuditorias().remove(parametroAuditoria);
		parametroAuditoria.setParametro(null);

		return parametroAuditoria;
	}

}