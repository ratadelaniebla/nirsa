package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dispositivo database table.
 * 
 */
@Entity
@NamedQuery(name="Dispositivo.findAll", query="SELECT d FROM Dispositivo d")
public class Dispositivo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer iddispositivo;
	private String descripcion;
	private Integer estado;
	private List<DispositivoDestino> dispositivoDestinos;

	public Dispositivo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIddispositivo() {
		return this.iddispositivo;
	}

	public void setIddispositivo(Integer iddispositivo) {
		this.iddispositivo = iddispositivo;
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


	//bi-directional many-to-one association to DispositivoDestino
	@OneToMany(mappedBy="dispositivo")
	public List<DispositivoDestino> getDispositivoDestinos() {
		return this.dispositivoDestinos;
	}

	public void setDispositivoDestinos(List<DispositivoDestino> dispositivoDestinos) {
		this.dispositivoDestinos = dispositivoDestinos;
	}

	public DispositivoDestino addDispositivoDestino(DispositivoDestino dispositivoDestino) {
		getDispositivoDestinos().add(dispositivoDestino);
		dispositivoDestino.setDispositivo(this);

		return dispositivoDestino;
	}

	public DispositivoDestino removeDispositivoDestino(DispositivoDestino dispositivoDestino) {
		getDispositivoDestinos().remove(dispositivoDestino);
		dispositivoDestino.setDispositivo(null);

		return dispositivoDestino;
	}

}