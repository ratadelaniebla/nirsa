package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the direccion_sistemas database table.
 * 
 */
@Entity
@Table(name="direccion_sistemas")
@NamedQuery(name="DireccionSistema.findAll", query="SELECT d FROM DireccionSistema d")
public class DireccionSistema implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddireccionsistema;
	private String base;
	private String clave;
	private String descripcion;
	private Integer estado;
	private Integer idsistema;
	private String ip;
	private String puerto;
	private String usuario;

	public DireccionSistema() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddireccionsistema() {
		return this.iddireccionsistema;
	}

	public void setIddireccionsistema(Long iddireccionsistema) {
		this.iddireccionsistema = iddireccionsistema;
	}


	public String getBase() {
		return this.base;
	}

	public void setBase(String base) {
		this.base = base;
	}


	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Integer getIdsistema() {
		return this.idsistema;
	}

	public void setIdsistema(Integer idsistema) {
		this.idsistema = idsistema;
	}


	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getPuerto() {
		return this.puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}


	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}