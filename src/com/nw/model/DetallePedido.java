package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_pedido database table.
 * 
 */
@Entity
@Table(name="detalle_pedido")
@NamedQuery(name="DetallePedido.findAll", query="SELECT d FROM DetallePedido d")
public class DetallePedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long iddetallepedido;
	private Integer caldovegetal;
	private double cantidad;
	private String codigomaterial;
	private Integer envasepresentacion;
	private Integer especie;
	private double flakemaximo;
	private double pesodrenado;
	private double pesodrenadopouch;
	private Integer posicion;
	private Integer presentacion;
	private Integer ratioaceiteagua;
	private Pedido pedido;

	public DetallePedido() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIddetallepedido() {
		return this.iddetallepedido;
	}

	public void setIddetallepedido(Long iddetallepedido) {
		this.iddetallepedido = iddetallepedido;
	}


	public Integer getCaldovegetal() {
		return this.caldovegetal;
	}

	public void setCaldovegetal(Integer caldovegetal) {
		this.caldovegetal = caldovegetal;
	}


	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public String getCodigomaterial() {
		return this.codigomaterial;
	}

	public void setCodigomaterial(String codigomaterial) {
		this.codigomaterial = codigomaterial;
	}


	public Integer getEnvasepresentacion() {
		return this.envasepresentacion;
	}

	public void setEnvasepresentacion(Integer envasepresentacion) {
		this.envasepresentacion = envasepresentacion;
	}


	public Integer getEspecie() {
		return this.especie;
	}

	public void setEspecie(Integer especie) {
		this.especie = especie;
	}


	public double getFlakemaximo() {
		return this.flakemaximo;
	}

	public void setFlakemaximo(double flakemaximo) {
		this.flakemaximo = flakemaximo;
	}


	public double getPesodrenado() {
		return this.pesodrenado;
	}

	public void setPesodrenado(double pesodrenado) {
		this.pesodrenado = pesodrenado;
	}


	public double getPesodrenadopouch() {
		return this.pesodrenadopouch;
	}

	public void setPesodrenadopouch(double pesodrenadopouch) {
		this.pesodrenadopouch = pesodrenadopouch;
	}


	public Integer getPosicion() {
		return this.posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}


	public Integer getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(Integer presentacion) {
		this.presentacion = presentacion;
	}


	public Integer getRatioaceiteagua() {
		return this.ratioaceiteagua;
	}

	public void setRatioaceiteagua(Integer ratioaceiteagua) {
		this.ratioaceiteagua = ratioaceiteagua;
	}


	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}