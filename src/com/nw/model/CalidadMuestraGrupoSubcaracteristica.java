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
@NamedQuery(name="CalidadMuestraGrupoSubcaracteristica.findAll", query="SELECT c FROM CalidadMuestraGrupoSubcaracteristica c")
public class CalidadMuestraGrupoSubcaracteristica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestragruposubcaracteristicas;
	private String descripcion;
	private Integer estado;
	private List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras;
	private CalidadMuestraGrupoCaracteristica calidadMuestraGrupoCaracteristica;

	public CalidadMuestraGrupoSubcaracteristica() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadMuestraAreaDetalleMuestra
	@OneToMany(mappedBy="calidadMuestraGrupoSubcaracteristica")
	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraAreaDetalleMuestras() {
		return this.calidadMuestraAreaDetalleMuestras;
	}

	public void setCalidadMuestraAreaDetalleMuestras(List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras) {
		this.calidadMuestraAreaDetalleMuestras = calidadMuestraAreaDetalleMuestras;
	}

	public CalidadMuestraAreaDetalleMuestra addCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().add(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setCalidadMuestraGrupoSubcaracteristica(this);

		return calidadMuestraAreaDetalleMuestra;
	}

	public CalidadMuestraAreaDetalleMuestra removeCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().remove(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setCalidadMuestraGrupoSubcaracteristica(null);

		return calidadMuestraAreaDetalleMuestra;
	}


	//bi-directional many-to-one association to CalidadMuestraGrupoCaracteristica
	@ManyToOne
	@JoinColumn(name="idcalidadmuestragrupocaracteristicas")
	public CalidadMuestraGrupoCaracteristica getCalidadMuestraGrupoCaracteristica() {
		return this.calidadMuestraGrupoCaracteristica;
	}

	public void setCalidadMuestraGrupoCaracteristica(CalidadMuestraGrupoCaracteristica calidadMuestraGrupoCaracteristica) {
		this.calidadMuestraGrupoCaracteristica = calidadMuestraGrupoCaracteristica;
	}

}