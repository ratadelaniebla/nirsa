package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carro database table.
 * 
 */
@Entity
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcarro;

	@Column(name="detalles_carro")
	private String detallesCarro;

	@Column(name="placa_carro")
	private String placaCarro;

	//bi-directional many-to-one association to Chofer
	@ManyToOne
	@JoinColumn(name="idchofer")
	private Chofer chofer;

	public Carro() {
	}

	public Long getIdcarro() {
		return this.idcarro;
	}

	public void setIdcarro(Long idcarro) {
		this.idcarro = idcarro;
	}

	public String getDetallesCarro() {
		return this.detallesCarro;
	}

	public void setDetallesCarro(String detallesCarro) {
		this.detallesCarro = detallesCarro;
	}

	public String getPlacaCarro() {
		return this.placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public Chofer getChofer() {
		return this.chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

}