package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_muestra_grupo_caracteristicas_tipo database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_grupo_caracteristicas_tipo")
public class CalidadMuestraGrupoCaracteristicasTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestragrupocaracteristicastipo;

	private String descripcion;

	private Integer estado;

	//bi-directional many-to-one association to CalidadMuestraGrupoCaracteristica
	@OneToMany(mappedBy="calidadMuestraGrupoCaracteristicasTipo")
	private List<CalidadMuestraGrupoCaracteristica> calidadMuestraGrupoCaracteristicas;

	public CalidadMuestraGrupoCaracteristicasTipo() {
	}

	public Long getIdcalidadmuestragrupocaracteristicastipo() {
		return this.idcalidadmuestragrupocaracteristicastipo;
	}

	public void setIdcalidadmuestragrupocaracteristicastipo(Long idcalidadmuestragrupocaracteristicastipo) {
		this.idcalidadmuestragrupocaracteristicastipo = idcalidadmuestragrupocaracteristicastipo;
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

	public List<CalidadMuestraGrupoCaracteristica> getCalidadMuestraGrupoCaracteristicas() {
		return this.calidadMuestraGrupoCaracteristicas;
	}

	public void setCalidadMuestraGrupoCaracteristicas(List<CalidadMuestraGrupoCaracteristica> calidadMuestraGrupoCaracteristicas) {
		this.calidadMuestraGrupoCaracteristicas = calidadMuestraGrupoCaracteristicas;
	}

}