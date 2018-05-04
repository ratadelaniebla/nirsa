package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chofer database table.
 * 
 */
@Entity
@NamedQuery(name="Chofer.findAll", query="SELECT c FROM Chofer c")
public class Chofer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idchofer;
	private String cedulaChofer;
	private String nombresChofer;
	private List<Carro> carros;
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;

	public Chofer() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdchofer() {
		return this.idchofer;
	}

	public void setIdchofer(Long idchofer) {
		this.idchofer = idchofer;
	}


	@Column(name="cedula_chofer")
	public String getCedulaChofer() {
		return this.cedulaChofer;
	}

	public void setCedulaChofer(String cedulaChofer) {
		this.cedulaChofer = cedulaChofer;
	}


	@Column(name="nombres_chofer")
	public String getNombresChofer() {
		return this.nombresChofer;
	}

	public void setNombresChofer(String nombresChofer) {
		this.nombresChofer = nombresChofer;
	}


	//bi-directional many-to-one association to Carro
	@OneToMany(mappedBy="chofer")
	public List<Carro> getCarros() {
		return this.carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public Carro addCarro(Carro carro) {
		getCarros().add(carro);
		carro.setChofer(this);

		return carro;
	}

	public Carro removeCarro(Carro carro) {
		getCarros().remove(carro);
		carro.setChofer(null);

		return carro;
	}


	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="chofer")
	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

	public HarinaRecepcionPescaComprobante addHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().add(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setChofer(this);

		return harinaRecepcionPescaComprobante;
	}

	public HarinaRecepcionPescaComprobante removeHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().remove(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setChofer(null);

		return harinaRecepcionPescaComprobante;
	}

}