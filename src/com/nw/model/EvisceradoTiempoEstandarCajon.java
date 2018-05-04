package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eviscerado_tiempo_estandar_cajon database table.
 * 
 */
@Entity
@Table(name="eviscerado_tiempo_estandar_cajon")
@NamedQuery(name="EvisceradoTiempoEstandarCajon.findAll", query="SELECT e FROM EvisceradoTiempoEstandarCajon e")
public class EvisceradoTiempoEstandarCajon implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevisceradotiempoestandarcajon;
	private double tiempoEstandar;
	private Talla talla;

	public EvisceradoTiempoEstandarCajon() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevisceradotiempoestandarcajon() {
		return this.idevisceradotiempoestandarcajon;
	}

	public void setIdevisceradotiempoestandarcajon(Long idevisceradotiempoestandarcajon) {
		this.idevisceradotiempoestandarcajon = idevisceradotiempoestandarcajon;
	}


	@Column(name="tiempo_estandar")
	public double getTiempoEstandar() {
		return this.tiempoEstandar;
	}

	public void setTiempoEstandar(double tiempoEstandar) {
		this.tiempoEstandar = tiempoEstandar;
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