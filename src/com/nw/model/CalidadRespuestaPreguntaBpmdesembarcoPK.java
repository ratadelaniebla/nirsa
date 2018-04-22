package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the calidad_respuesta_pregunta_bpmdesembarco database table.
 * 
 */
@Embeddable
public class CalidadRespuestaPreguntaBpmdesembarcoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Long idcalidadbpmdesembarco;

	private Integer idpreguntacalidadbpmdesembarco;

	public CalidadRespuestaPreguntaBpmdesembarcoPK() {
	}
	public Long getIdcalidadbpmdesembarco() {
		return this.idcalidadbpmdesembarco;
	}
	public void setIdcalidadbpmdesembarco(Long idcalidadbpmdesembarco) {
		this.idcalidadbpmdesembarco = idcalidadbpmdesembarco;
	}
	public Integer getIdpreguntacalidadbpmdesembarco() {
		return this.idpreguntacalidadbpmdesembarco;
	}
	public void setIdpreguntacalidadbpmdesembarco(Integer idpreguntacalidadbpmdesembarco) {
		this.idpreguntacalidadbpmdesembarco = idpreguntacalidadbpmdesembarco;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CalidadRespuestaPreguntaBpmdesembarcoPK)) {
			return false;
		}
		CalidadRespuestaPreguntaBpmdesembarcoPK castOther = (CalidadRespuestaPreguntaBpmdesembarcoPK)other;
		return 
			this.idcalidadbpmdesembarco.equals(castOther.idcalidadbpmdesembarco)
			&& this.idpreguntacalidadbpmdesembarco.equals(castOther.idpreguntacalidadbpmdesembarco);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idcalidadbpmdesembarco.hashCode();
		hash = hash * prime + this.idpreguntacalidadbpmdesembarco.hashCode();
		
		return hash;
	}
}