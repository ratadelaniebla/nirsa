package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcliente;

	@Column(name="apellidos_cliente")
	private String apellidosCliente;

	@Column(name="cedula_cliente")
	private String cedulaCliente;

	@Column(name="nombres_cliente")
	private String nombresCliente;

	public Cliente() {
	}

	public Long getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getApellidosCliente() {
		return this.apellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}

	public String getCedulaCliente() {
		return this.cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getNombresCliente() {
		return this.nombresCliente;
	}

	public void setNombresCliente(String nombresCliente) {
		this.nombresCliente = nombresCliente;
	}

}