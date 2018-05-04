package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_nivel_cuba database table.
 * 
 */
@Entity
@Table(name="calidad_nivel_cuba")
@NamedQuery(name="CalidadNivelCuba.findAll", query="SELECT c FROM CalidadNivelCuba c")
public class CalidadNivelCuba implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcalidadnivelcuba;
	private String descripcion;
	private String nivel;
	private List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps;

	public CalidadNivelCuba() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcalidadnivelcuba() {
		return this.idcalidadnivelcuba;
	}

	public void setIdcalidadnivelcuba(Integer idcalidadnivelcuba) {
		this.idcalidadnivelcuba = idcalidadnivelcuba;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	//bi-directional many-to-one association to CalidadDetalleSensorialMp
	@OneToMany(mappedBy="calidadNivelCuba")
	public List<CalidadDetalleSensorialMp> getCalidadDetalleSensorialMps() {
		return this.calidadDetalleSensorialMps;
	}

	public void setCalidadDetalleSensorialMps(List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps) {
		this.calidadDetalleSensorialMps = calidadDetalleSensorialMps;
	}

	public CalidadDetalleSensorialMp addCalidadDetalleSensorialMp(CalidadDetalleSensorialMp calidadDetalleSensorialMp) {
		getCalidadDetalleSensorialMps().add(calidadDetalleSensorialMp);
		calidadDetalleSensorialMp.setCalidadNivelCuba(this);

		return calidadDetalleSensorialMp;
	}

	public CalidadDetalleSensorialMp removeCalidadDetalleSensorialMp(CalidadDetalleSensorialMp calidadDetalleSensorialMp) {
		getCalidadDetalleSensorialMps().remove(calidadDetalleSensorialMp);
		calidadDetalleSensorialMp.setCalidadNivelCuba(null);

		return calidadDetalleSensorialMp;
	}

}