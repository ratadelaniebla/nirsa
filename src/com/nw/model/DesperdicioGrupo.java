package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the desperdicio_grupo database table.
 * 
 */
@Entity
@Table(name="desperdicio_grupo")
@NamedQuery(name="DesperdicioGrupo.findAll", query="SELECT d FROM DesperdicioGrupo d")
public class DesperdicioGrupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer iddesperdiciogrupo;

	public DesperdicioGrupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIddesperdiciogrupo() {
		return this.iddesperdiciogrupo;
	}

	public void setIddesperdiciogrupo(Integer iddesperdiciogrupo) {
		this.iddesperdiciogrupo = iddesperdiciogrupo;
	}

}