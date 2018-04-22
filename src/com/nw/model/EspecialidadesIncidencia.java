package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especialidades_incidencia database table.
 * 
 */
@Entity
@Table(name="especialidades_incidencia")
public class EspecialidadesIncidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idespecialidadesincidencia;

	private String descripcion;

	//bi-directional many-to-one association to EspecialidadesIncidenciaEnlatado
	@OneToMany(mappedBy="especialidadesIncidencia")
	private List<EspecialidadesIncidenciaEnlatado> especialidadesIncidenciaEnlatados;

	public EspecialidadesIncidencia() {
	}

	public Integer getIdespecialidadesincidencia() {
		return this.idespecialidadesincidencia;
	}

	public void setIdespecialidadesincidencia(Integer idespecialidadesincidencia) {
		this.idespecialidadesincidencia = idespecialidadesincidencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<EspecialidadesIncidenciaEnlatado> getEspecialidadesIncidenciaEnlatados() {
		return this.especialidadesIncidenciaEnlatados;
	}

	public void setEspecialidadesIncidenciaEnlatados(List<EspecialidadesIncidenciaEnlatado> especialidadesIncidenciaEnlatados) {
		this.especialidadesIncidenciaEnlatados = especialidadesIncidenciaEnlatados;
	}

}