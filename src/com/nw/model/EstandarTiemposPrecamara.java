package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_tiempos_precamara database table.
 * 
 */
@Entity
@Table(name="estandar_tiempos_precamara")
public class EstandarTiemposPrecamara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandartiemposprecamara;

	private Integer tiempo;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EstandarTiemposPrecamara() {
	}

	public Integer getIdestandartiemposprecamara() {
		return this.idestandartiemposprecamara;
	}

	public void setIdestandartiemposprecamara(Integer idestandartiemposprecamara) {
		this.idestandartiemposprecamara = idestandartiemposprecamara;
	}

	public Integer getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}