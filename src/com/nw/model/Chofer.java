package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chofer database table.
 * 
 */
@Entity
public class Chofer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idchofer;

	@Column(name="cedula_chofer")
	private String cedulaChofer;

	@Column(name="nombres_chofer")
	private String nombresChofer;

	//bi-directional many-to-one association to Carro
	@OneToMany(mappedBy="chofer")
	private List<Carro> carros;

	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="chofer")
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;

	public Chofer() {
	}

	public Long getIdchofer() {
		return this.idchofer;
	}

	public void setIdchofer(Long idchofer) {
		this.idchofer = idchofer;
	}

	public String getCedulaChofer() {
		return this.cedulaChofer;
	}

	public void setCedulaChofer(String cedulaChofer) {
		this.cedulaChofer = cedulaChofer;
	}

	public String getNombresChofer() {
		return this.nombresChofer;
	}

	public void setNombresChofer(String nombresChofer) {
		this.nombresChofer = nombresChofer;
	}

	public List<Carro> getCarros() {
		return this.carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

}