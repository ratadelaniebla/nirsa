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
@NamedQuery(name="DispositivoPuestoTrabajo.findAll", query="SELECT d FROM DispositivoPuestoTrabajo d")
public class DispositivoPuestoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer iddispositivopuestotrabajo;
	private String descripcionpuestotrabajo;
	private List<DispositivoDestino> dispositivoDestinos;

	public DispositivoPuestoTrabajo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to DispositivoDestino
	@OneToMany(mappedBy="dispositivoPuestoTrabajo")
	public List<DispositivoDestino> getDispositivoDestinos() {
		return this.dispositivoDestinos;
	}

	public void setDispositivoDestinos(List<DispositivoDestino> dispositivoDestinos) {
		this.dispositivoDestinos = dispositivoDestinos;
	}

	public DispositivoDestino addDispositivoDestino(DispositivoDestino dispositivoDestino) {
		getDispositivoDestinos().add(dispositivoDestino);
		dispositivoDestino.setDispositivoPuestoTrabajo(this);

		return dispositivoDestino;
	}

	public DispositivoDestino removeDispositivoDestino(DispositivoDestino dispositivoDestino) {
		getDispositivoDestinos().remove(dispositivoDestino);
		dispositivoDestino.setDispositivoPuestoTrabajo(null);

		return dispositivoDestino;
	}

}