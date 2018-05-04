package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carro database table.
 * 
 */
@Entity
@NamedQuery(name="Carro.findAll", query="SELECT c FROM Carro c")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcarro;
	private String detallesCarro;
	private String placaCarro;
	private Chofer chofer;

	public Carro() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcarro() {
		return this.idcarro;
	}

	public void setIdcarro(Long idcarro) {
		this.idcarro = idcarro;
	}


	@Column(name="detalles_carro")
	public String getDetallesCarro() {
		return this.detallesCarro;
	}

	public void setDetallesCarro(String detallesCarro) {
		this.detallesCarro = detallesCarro;
	}


	@Column(name="placa_carro")
	public String getPlacaCarro() {
		return this.placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}


	//bi-directional many-to-one association to Chofer
	@ManyToOne
	@JoinColumn(name="idchofer")
	public Chofer getChofer() {
		return this.chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

}