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
public class EspecialidadesProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idespecialidadesproducto;

	private String descripcion;

	//bi-directional many-to-one association to EspecialidadesReceta
	@OneToMany(mappedBy="especialidadesProducto")
	private List<EspecialidadesReceta> especialidadesRecetas;

	public EspecialidadesProducto() {
	}

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

	public List<EspecialidadesReceta> getEspecialidadesRecetas() {
		return this.especialidadesRecetas;
	}

	public void setEspecialidadesRecetas(List<EspecialidadesReceta> especialidadesRecetas) {
		this.especialidadesRecetas = especialidadesRecetas;
	}

}