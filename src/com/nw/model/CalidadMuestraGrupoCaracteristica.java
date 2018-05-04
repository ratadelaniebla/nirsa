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
@NamedQuery(name="CalidadMuestraGrupoCaracteristica.findAll", query="SELECT c FROM CalidadMuestraGrupoCaracteristica c")
public class CalidadMuestraGrupoCaracteristica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestragrupocaracteristicas;
	private String descripcion;
	private Integer estado;
	private CalidadMuestraGrupoCaracteristicasTipo calidadMuestraGrupoCaracteristicasTipo;
	private List<CalidadMuestraGrupoSubcaracteristica> calidadMuestraGrupoSubcaracteristicas;

	public CalidadMuestraGrupoCaracteristica() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadMuestraGrupoCaracteristicasTipo
	@ManyToOne
	@JoinColumn(name="idtipocaracteristicas")
	public CalidadMuestraGrupoCaracteristicasTipo getCalidadMuestraGrupoCaracteristicasTipo() {
		return this.calidadMuestraGrupoCaracteristicasTipo;
	}

	public void setCalidadMuestraGrupoCaracteristicasTipo(CalidadMuestraGrupoCaracteristicasTipo calidadMuestraGrupoCaracteristicasTipo) {
		this.calidadMuestraGrupoCaracteristicasTipo = calidadMuestraGrupoCaracteristicasTipo;
	}


	//bi-directional many-to-one association to CalidadMuestraGrupoSubcaracteristica
	@OneToMany(mappedBy="calidadMuestraGrupoCaracteristica")
	public List<CalidadMuestraGrupoSubcaracteristica> getCalidadMuestraGrupoSubcaracteristicas() {
		return this.calidadMuestraGrupoSubcaracteristicas;
	}

	public void setCalidadMuestraGrupoSubcaracteristicas(List<CalidadMuestraGrupoSubcaracteristica> calidadMuestraGrupoSubcaracteristicas) {
		this.calidadMuestraGrupoSubcaracteristicas = calidadMuestraGrupoSubcaracteristicas;
	}

	public CalidadMuestraGrupoSubcaracteristica addCalidadMuestraGrupoSubcaracteristica(CalidadMuestraGrupoSubcaracteristica calidadMuestraGrupoSubcaracteristica) {
		getCalidadMuestraGrupoSubcaracteristicas().add(calidadMuestraGrupoSubcaracteristica);
		calidadMuestraGrupoSubcaracteristica.setCalidadMuestraGrupoCaracteristica(this);

		return calidadMuestraGrupoSubcaracteristica;
	}

	public CalidadMuestraGrupoSubcaracteristica removeCalidadMuestraGrupoSubcaracteristica(CalidadMuestraGrupoSubcaracteristica calidadMuestraGrupoSubcaracteristica) {
		getCalidadMuestraGrupoSubcaracteristicas().remove(calidadMuestraGrupoSubcaracteristica);
		calidadMuestraGrupoSubcaracteristica.setCalidadMuestraGrupoCaracteristica(null);

		return calidadMuestraGrupoSubcaracteristica;
	}

}