package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcliente;
	private String apellidosCliente;
	private String cedulaCliente;
	private String nombresCliente;

	public Cliente() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}


	@Column(name="apellidos_cliente")
	public String getApellidosCliente() {
		return this.apellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}


	@Column(name="cedula_cliente")
	public String getCedulaCliente() {
		return this.cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}


	@Column(name="nombres_cliente")
	public String getNombresCliente() {
		return this.nombresCliente;
	}

	public void setNombresCliente(String nombresCliente) {
		this.nombresCliente = nombresCliente;
	}

}