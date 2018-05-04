package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cocina_parametros database table.
 * 
 */
@Entity
@Table(name="cocina_parametros")
@NamedQuery(name="CocinaParametro.findAll", query="SELECT c FROM CocinaParametro c")
public class CocinaParametro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcocinaparametros;
	private String habilitado;
	private Integer idcocina;
	private Integer numerococinadageneral;
	private Integer velocidadLectura;

	public CocinaParametro() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcocinaparametros() {
		return this.idcocinaparametros;
	}

	public void setIdcocinaparametros(Integer idcocinaparametros) {
		this.idcocinaparametros = idcocinaparametros;
	}


	public String getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}


	public Integer getIdcocina() {
		return this.idcocina;
	}

	public void setIdcocina(Integer idcocina) {
		this.idcocina = idcocina;
	}


	public Integer getNumerococinadageneral() {
		return this.numerococinadageneral;
	}

	public void setNumerococinadageneral(Integer numerococinadageneral) {
		this.numerococinadageneral = numerococinadageneral;
	}


	@Column(name="velocidad_lectura")
	public Integer getVelocidadLectura() {
		return this.velocidadLectura;
	}

	public void setVelocidadLectura(Integer velocidadLectura) {
		this.velocidadLectura = velocidadLectura;
	}

}