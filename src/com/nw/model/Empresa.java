package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idempresa;

	private String codigosap;

	private String direccion;

	private Integer estado;

	private String nombre;

	private String razonsocial;

	private Integer ruc;

	private Integer telefono;

	//bi-directional many-to-one association to DispositivoDestino
	@OneToMany(mappedBy="empresa")
	private List<DispositivoDestino> dispositivoDestinos;

	public Empresa() {
	}

	public Integer getIdempresa() {
		return this.idempresa;
	}

	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}

	public String getCodigosap() {
		return this.codigosap;
	}

	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazonsocial() {
		return this.razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public Integer getRuc() {
		return this.ruc;
	}

	public void setRuc(Integer ruc) {
		this.ruc = ruc;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<DispositivoDestino> getDispositivoDestinos() {
		return this.dispositivoDestinos;
	}

	public void setDispositivoDestinos(List<DispositivoDestino> dispositivoDestinos) {
		this.dispositivoDestinos = dispositivoDestinos;
	}

}