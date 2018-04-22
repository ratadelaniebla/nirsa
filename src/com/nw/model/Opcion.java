package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the opcion database table.
 * 
 */
@Entity
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idopcion;

	private String formulario;

	private String imagen;

	private String opcion;

	//bi-directional many-to-many association to Grupo
	@ManyToMany(mappedBy="opcions")
	private List<Grupo> grupos;

	public Opcion() {
	}

	public Integer getIdopcion() {
		return this.idopcion;
	}

	public void setIdopcion(Integer idopcion) {
		this.idopcion = idopcion;
	}

	public String getFormulario() {
		return this.formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getOpcion() {
		return this.opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}