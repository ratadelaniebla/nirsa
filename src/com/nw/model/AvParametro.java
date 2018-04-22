package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the av_parametros database table.
 * 
 */
@Entity
@Table(name="av_parametros")
public class AvParametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String vidparametro;

	private Integer ivalorentero;

	private String vvalorcadena;

	public AvParametro() {
	}

	public String getVidparametro() {
		return this.vidparametro;
	}

	public void setVidparametro(String vidparametro) {
		this.vidparametro = vidparametro;
	}

	public Integer getIvalorentero() {
		return this.ivalorentero;
	}

	public void setIvalorentero(Integer ivalorentero) {
		this.ivalorentero = ivalorentero;
	}

	public String getVvalorcadena() {
		return this.vvalorcadena;
	}

	public void setVvalorcadena(String vvalorcadena) {
		this.vvalorcadena = vvalorcadena;
	}

}