package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_tiempos_descongelado database table.
 * 
 */
@Entity
@Table(name="estandar_tiempos_descongelado")
@NamedQuery(name="EstandarTiemposDescongelado.findAll", query="SELECT e FROM EstandarTiemposDescongelado e")
public class EstandarTiemposDescongelado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandartiemposdescongelado;
	private Integer tiempo;
	private Talla talla;

	public EstandarTiemposDescongelado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandartiemposdescongelado() {
		return this.idestandartiemposdescongelado;
	}

	public void setIdestandartiemposdescongelado(Integer idestandartiemposdescongelado) {
		this.idestandartiemposdescongelado = idestandartiemposdescongelado;
	}


	public Integer getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}


	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}