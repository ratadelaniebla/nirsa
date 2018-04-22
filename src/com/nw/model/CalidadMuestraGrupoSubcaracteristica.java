package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_muestra_grupo_subcaracteristicas database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_grupo_subcaracteristicas")
public class CalidadMuestraGrupoSubcaracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestragruposubcaracteristicas;

	private String descripcion;

	private Integer estado;

	//bi-directional many-to-one association to CalidadMuestraAreaDetalleMuestra
	@OneToMany(mappedBy="calidadMuestraGrupoSubcaracteristica")
	private List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras;

	//bi-directional many-to-one association to CalidadMuestraGrupoCaracteristica
	@ManyToOne
	@JoinColumn(name="idcalidadmuestragrupocaracteristicas")
	private CalidadMuestraGrupoCaracteristica calidadMuestraGrupoCaracteristica;

	public CalidadMuestraGrupoSubcaracteristica() {
	}

	public Long getIdcalidadmuestragruposubcaracteristicas() {
		return this.idcalidadmuestragruposubcaracteristicas;
	}

	public void setIdcalidadmuestragruposubcaracteristicas(Long idcalidadmuestragruposubcaracteristicas) {
		this.idcalidadmuestragruposubcaracteristicas = idcalidadmuestragruposubcaracteristicas;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraAreaDetalleMuestras() {
		return this.calidadMuestraAreaDetalleMuestras;
	}

	public void setCalidadMuestraAreaDetalleMuestras(List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras) {
		this.calidadMuestraAreaDetalleMuestras = calidadMuestraAreaDetalleMuestras;
	}

	public CalidadMuestraGrupoCaracteristica getCalidadMuestraGrupoCaracteristica() {
		return this.calidadMuestraGrupoCaracteristica;
	}

	public void setCalidadMuestraGrupoCaracteristica(CalidadMuestraGrupoCaracteristica calidadMuestraGrupoCaracteristica) {
		this.calidadMuestraGrupoCaracteristica = calidadMuestraGrupoCaracteristica;
	}

}