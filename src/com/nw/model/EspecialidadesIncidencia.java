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
@NamedQuery(name="EspecialidadesIncidencia.findAll", query="SELECT e FROM EspecialidadesIncidencia e")
public class EspecialidadesIncidencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idespecialidadesincidencia;
	private String descripcion;
	private List<EspecialidadesIncidenciaEnlatado> especialidadesIncidenciaEnlatados;

	public EspecialidadesIncidencia() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to EspecialidadesIncidenciaEnlatado
	@OneToMany(mappedBy="especialidadesIncidencia")
	public List<EspecialidadesIncidenciaEnlatado> getEspecialidadesIncidenciaEnlatados() {
		return this.especialidadesIncidenciaEnlatados;
	}

	public void setEspecialidadesIncidenciaEnlatados(List<EspecialidadesIncidenciaEnlatado> especialidadesIncidenciaEnlatados) {
		this.especialidadesIncidenciaEnlatados = especialidadesIncidenciaEnlatados;
	}

	public EspecialidadesIncidenciaEnlatado addEspecialidadesIncidenciaEnlatado(EspecialidadesIncidenciaEnlatado especialidadesIncidenciaEnlatado) {
		getEspecialidadesIncidenciaEnlatados().add(especialidadesIncidenciaEnlatado);
		especialidadesIncidenciaEnlatado.setEspecialidadesIncidencia(this);

		return especialidadesIncidenciaEnlatado;
	}

	public EspecialidadesIncidenciaEnlatado removeEspecialidadesIncidenciaEnlatado(EspecialidadesIncidenciaEnlatado especialidadesIncidenciaEnlatado) {
		getEspecialidadesIncidenciaEnlatados().remove(especialidadesIncidenciaEnlatado);
		especialidadesIncidenciaEnlatado.setEspecialidadesIncidencia(null);

		return especialidadesIncidenciaEnlatado;
	}

}