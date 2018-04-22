package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the calidad_detalle_sensorial_mp database table.
 * 
 */
@Embeddable
public class CalidadDetalleSensorialMpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Long idcalidadnumeromuestrasensorialmp;

	private Long idcalidadsensorialmp;

	public CalidadDetalleSensorialMpPK() {
	}
	public Long getIdcalidadnumeromuestrasensorialmp() {
		return this.idcalidadnumeromuestrasensorialmp;
	}
	public void setIdcalidadnumeromuestrasensorialmp(Long idcalidadnumeromuestrasensorialmp) {
		this.idcalidadnumeromuestrasensorialmp = idcalidadnumeromuestrasensorialmp;
	}
	public Long getIdcalidadsensorialmp() {
		return this.idcalidadsensorialmp;
	}
	public void setIdcalidadsensorialmp(Long idcalidadsensorialmp) {
		this.idcalidadsensorialmp = idcalidadsensorialmp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CalidadDetalleSensorialMpPK)) {
			return false;
		}
		CalidadDetalleSensorialMpPK castOther = (CalidadDetalleSensorialMpPK)other;
		return 
			this.idcalidadnumeromuestrasensorialmp.equals(castOther.idcalidadnumeromuestrasensorialmp)
			&& this.idcalidadsensorialmp.equals(castOther.idcalidadsensorialmp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idcalidadnumeromuestrasensorialmp.hashCode();
		hash = hash * prime + this.idcalidadsensorialmp.hashCode();
		
		return hash;
	}
}