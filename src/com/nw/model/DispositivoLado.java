package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dispositivo_lado database table.
 * 
 */
@Entity
@Table(name="dispositivo_lado")
@NamedQuery(name="DispositivoLado.findAll", query="SELECT d FROM DispositivoLado d")
public class DispositivoLado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer iddispositivolado;
	private String descripcion;
	private Integer estado;
	private List<DispositivoDestino> dispositivoDestinos;

	public DispositivoLado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIddispositivolado() {
		return this.iddispositivolado;
	}

	public void setIddispositivolado(Integer iddispositivolado) {
		this.iddispositivolado = iddispositivolado;
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
	@OneToMany(mappedBy="dispositivoLado")
	public List<DispositivoDestino> getDispositivoDestinos() {
		return this.dispositivoDestinos;
	}

	public void setDispositivoDestinos(List<DispositivoDestino> dispositivoDestinos) {
		this.dispositivoDestinos = dispositivoDestinos;
	}

	public DispositivoDestino addDispositivoDestino(DispositivoDestino dispositivoDestino) {
		getDispositivoDestinos().add(dispositivoDestino);
		dispositivoDestino.setDispositivoLado(this);

		return dispositivoDestino;
	}

	public DispositivoDestino removeDispositivoDestino(DispositivoDestino dispositivoDestino) {
		getDispositivoDestinos().remove(dispositivoDestino);
		dispositivoDestino.setDispositivoLado(null);

		return dispositivoDestino;
	}

}