package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eviscerado_tiempo_estandar_cajon database table.
 * 
 */
@Entity
@Table(name="eviscerado_tiempo_estandar_cajon")
public class EvisceradoTiempoEstandarCajon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevisceradotiempoestandarcajon;

	@Column(name="tiempo_estandar")
	private double tiempoEstandar;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EvisceradoTiempoEstandarCajon() {
	}

	public Long getIdevisceradotiempoestandarcajon() {
		return this.idevisceradotiempoestandarcajon;
	}

	public void setIdevisceradotiempoestandarcajon(Long idevisceradotiempoestandarcajon) {
		this.idevisceradotiempoestandarcajon = idevisceradotiempoestandarcajon;
	}

	public double getTiempoEstandar() {
		return this.tiempoEstandar;
	}

	public void setTiempoEstandar(double tiempoEstandar) {
		this.tiempoEstandar = tiempoEstandar;
	}

	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}