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
public class DispositivoLado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iddispositivolado;

	private String descripcion;

	private Integer estado;

	//bi-directional many-to-one association to DispositivoDestino
	@OneToMany(mappedBy="dispositivoLado")
	private List<DispositivoDestino> dispositivoDestinos;

	public DispositivoLado() {
	}

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

	public List<DispositivoDestino> getDispositivoDestinos() {
		return this.dispositivoDestinos;
	}

	public void setDispositivoDestinos(List<DispositivoDestino> dispositivoDestinos) {
		this.dispositivoDestinos = dispositivoDestinos;
	}

}