package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idparametro;

	private String descripcionparametro;

	private String permiso;

	private double valor;

	private double valor2;

	//bi-directional many-to-one association to ParametroAuditoria
	@OneToMany(mappedBy="parametro")
	private List<ParametroAuditoria> parametroAuditorias;

	public Parametro() {
	}

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

	public List<ParametroAuditoria> getParametroAuditorias() {
		return this.parametroAuditorias;
	}

	public void setParametroAuditorias(List<ParametroAuditoria> parametroAuditorias) {
		this.parametroAuditorias = parametroAuditorias;
	}

}