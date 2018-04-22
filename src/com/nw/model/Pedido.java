package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpedido;

	private String contenedor;

	private Timestamp fechaembarque;

	private Timestamp fechaentrega;

	private Timestamp fechapedido;

	@Column(name="id_ciudad")
	private Integer idCiudad;

	@Column(name="id_cliente")
	private Integer idCliente;

	@Column(name="id_puerto")
	private Integer idPuerto;

	private String instrucciones;

	private String observaciones;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="pedido")
	private List<DetallePedido> detallePedidos;

	public Pedido() {
	}

	public Long getIdpedido() {
		return this.idpedido;
	}

	public void setIdpedido(Long idpedido) {
		this.idpedido = idpedido;
	}

	public String getContenedor() {
		return this.contenedor;
	}

	public void setContenedor(String contenedor) {
		this.contenedor = contenedor;
	}

	public Timestamp getFechaembarque() {
		return this.fechaembarque;
	}

	public void setFechaembarque(Timestamp fechaembarque) {
		this.fechaembarque = fechaembarque;
	}

	public Timestamp getFechaentrega() {
		return this.fechaentrega;
	}

	public void setFechaentrega(Timestamp fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public Timestamp getFechapedido() {
		return this.fechapedido;
	}

	public void setFechapedido(Timestamp fechapedido) {
		this.fechapedido = fechapedido;
	}

	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPuerto() {
		return this.idPuerto;
	}

	public void setIdPuerto(Integer idPuerto) {
		this.idPuerto = idPuerto;
	}

	public String getInstrucciones() {
		return this.instrucciones;
	}

	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

}