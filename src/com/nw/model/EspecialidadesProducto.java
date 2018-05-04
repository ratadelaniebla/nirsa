package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especialidades_producto database table.
 * 
 */
@Entity
@Table(name="especialidades_producto")
@NamedQuery(name="EspecialidadesProducto.findAll", query="SELECT e FROM EspecialidadesProducto e")
public class EspecialidadesProducto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idespecialidadesproducto;
	private String descripcion;
	private List<EspecialidadesReceta> especialidadesRecetas;

	public EspecialidadesProducto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdespecialidadesproducto() {
		return this.idespecialidadesproducto;
	}

	public void setIdespecialidadesproducto(Integer idespecialidadesproducto) {
		this.idespecialidadesproducto = idespecialidadesproducto;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to EspecialidadesReceta
	@OneToMany(mappedBy="especialidadesProducto")
	public List<EspecialidadesReceta> getEspecialidadesRecetas() {
		return this.especialidadesRecetas;
	}

	public void setEspecialidadesRecetas(List<EspecialidadesReceta> especialidadesRecetas) {
		this.especialidadesRecetas = especialidadesRecetas;
	}

	public EspecialidadesReceta addEspecialidadesReceta(EspecialidadesReceta especialidadesReceta) {
		getEspecialidadesRecetas().add(especialidadesReceta);
		especialidadesReceta.setEspecialidadesProducto(this);

		return especialidadesReceta;
	}

	public EspecialidadesReceta removeEspecialidadesReceta(EspecialidadesReceta especialidadesReceta) {
		getEspecialidadesRecetas().remove(especialidadesReceta);
		especialidadesReceta.setEspecialidadesProducto(null);

		return especialidadesReceta;
	}

}