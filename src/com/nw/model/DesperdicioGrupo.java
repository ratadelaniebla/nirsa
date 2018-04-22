package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the desperdicio_grupo database table.
 * 
 */
@Entity
@Table(name="desperdicio_grupo")
public class DesperdicioGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iddesperdiciogrupo;

	public DesperdicioGrupo() {
	}

	public Integer getIddesperdiciogrupo() {
		return this.iddesperdiciogrupo;
	}

	public void setIddesperdiciogrupo(Integer iddesperdiciogrupo) {
		this.iddesperdiciogrupo = iddesperdiciogrupo;
	}

}