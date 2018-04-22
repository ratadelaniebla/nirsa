package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_muestra_grupo_caracteristicas database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_grupo_caracteristicas")
public class CalidadMuestraGrupoCaracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestragrupocaracteristicas;

	private String descripcion;

	private Integer estado;

	//bi-directional many-to-one association to CalidadMuestraGrupoCaracteristicasTipo
	@ManyToOne
	@JoinColumn(name="idtipocaracteristicas")
	private CalidadMuestraGrupoCaracteristicasTipo calidadMuestraGrupoCaracteristicasTipo;

	//bi-directional many-to-one association to CalidadMuestraGrupoSubcaracteristica
	@OneToMany(mappedBy="calidadMuestraGrupoCaracteristica")
	private List<CalidadMuestraGrupoSubcaracteristica> calidadMuestraGrupoSubcaracteristicas;

	public CalidadMuestraGrupoCaracteristica() {
	}

	public Long getIdcalidadmuestragrupocaracteristicas() {
		return this.idcalidadmuestragrupocaracteristicas;
	}

	public void setIdcalidadmuestragrupocaracteristicas(Long idcalidadmuestragrupocaracteristicas) {
		this.idcalidadmuestragrupocaracteristicas = idcalidadmuestragrupocaracteristicas;
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

	public CalidadMuestraGrupoCaracteristicasTipo getCalidadMuestraGrupoCaracteristicasTipo() {
		return this.calidadMuestraGrupoCaracteristicasTipo;
	}

	public void setCalidadMuestraGrupoCaracteristicasTipo(CalidadMuestraGrupoCaracteristicasTipo calidadMuestraGrupoCaracteristicasTipo) {
		this.calidadMuestraGrupoCaracteristicasTipo = calidadMuestraGrupoCaracteristicasTipo;
	}

	public List<CalidadMuestraGrupoSubcaracteristica> getCalidadMuestraGrupoSubcaracteristicas() {
		return this.calidadMuestraGrupoSubcaracteristicas;
	}

	public void setCalidadMuestraGrupoSubcaracteristicas(List<CalidadMuestraGrupoSubcaracteristica> calidadMuestraGrupoSubcaracteristicas) {
		this.calidadMuestraGrupoSubcaracteristicas = calidadMuestraGrupoSubcaracteristicas;
	}

}