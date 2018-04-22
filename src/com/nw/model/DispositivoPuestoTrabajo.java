package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dispositivo_puesto_trabajo database table.
 * 
 */
@Entity
@Table(name="dispositivo_puesto_trabajo")
public class DispositivoPuestoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iddispositivopuestotrabajo;

	private String descripcionpuestotrabajo;

	//bi-directional many-to-one association to DispositivoDestino
	@OneToMany(mappedBy="dispositivoPuestoTrabajo")
	private List<DispositivoDestino> dispositivoDestinos;

	public DispositivoPuestoTrabajo() {
	}

	public Integer getIddispositivopuestotrabajo() {
		return this.iddispositivopuestotrabajo;
	}

	public void setIddispositivopuestotrabajo(Integer iddispositivopuestotrabajo) {
		this.iddispositivopuestotrabajo = iddispositivopuestotrabajo;
	}

	public String getDescripcionpuestotrabajo() {
		return this.descripcionpuestotrabajo;
	}

	public void setDescripcionpuestotrabajo(String descripcionpuestotrabajo) {
		this.descripcionpuestotrabajo = descripcionpuestotrabajo;
	}

	public List<DispositivoDestino> getDispositivoDestinos() {
		return this.dispositivoDestinos;
	}

	public void setDispositivoDestinos(List<DispositivoDestino> dispositivoDestinos) {
		this.dispositivoDestinos = dispositivoDestinos;
	}

}