package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calidad_observaciones_cuba database table.
 * 
 */
@Entity
@Table(name="calidad_observaciones_cuba")
@NamedQuery(name="CalidadObservacionesCuba.findAll", query="SELECT c FROM CalidadObservacionesCuba c")
public class CalidadObservacionesCuba implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcalidadobservacioncuba;
	private Integer idcalidadobservacionmuestracuba;
	private Integer idcalidadsensorialmp;

	public CalidadObservacionesCuba() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcalidadobservacioncuba() {
		return this.idcalidadobservacioncuba;
	}

	public void setIdcalidadobservacioncuba(Integer idcalidadobservacioncuba) {
		this.idcalidadobservacioncuba = idcalidadobservacioncuba;
	}


	public Integer getIdcalidadobservacionmuestracuba() {
		return this.idcalidadobservacionmuestracuba;
	}

	public void setIdcalidadobservacionmuestracuba(Integer idcalidadobservacionmuestracuba) {
		this.idcalidadobservacionmuestracuba = idcalidadobservacionmuestracuba;
	}


	public Integer getIdcalidadsensorialmp() {
		return this.idcalidadsensorialmp;
	}

	public void setIdcalidadsensorialmp(Integer idcalidadsensorialmp) {
		this.idcalidadsensorialmp = idcalidadsensorialmp;
	}

}