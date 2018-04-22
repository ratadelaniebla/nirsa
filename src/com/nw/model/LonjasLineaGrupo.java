package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lonjas_linea_grupo database table.
 * 
 */
@Entity
@Table(name="lonjas_linea_grupo")
public class LonjasLineaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlonjaslineagrupo;

	private String nombregrupo;

	//bi-directional many-to-one association to LonjasGrupo
	@ManyToOne
	@JoinColumn(name="idlonjasgrupo")
	private LonjasGrupo lonjasGrupo;

	//bi-directional many-to-one association to LonjasLinea
	@ManyToOne
	@JoinColumn(name="idlonjaslinea")
	private LonjasLinea lonjasLinea;

	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="lonjasLineaGrupo")
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;

	public LonjasLineaGrupo() {
	}

	public Integer getIdlonjaslineagrupo() {
		return this.idlonjaslineagrupo;
	}

	public void setIdlonjaslineagrupo(Integer idlonjaslineagrupo) {
		this.idlonjaslineagrupo = idlonjaslineagrupo;
	}

	public String getNombregrupo() {
		return this.nombregrupo;
	}

	public void setNombregrupo(String nombregrupo) {
		this.nombregrupo = nombregrupo;
	}

	public LonjasGrupo getLonjasGrupo() {
		return this.lonjasGrupo;
	}

	public void setLonjasGrupo(LonjasGrupo lonjasGrupo) {
		this.lonjasGrupo = lonjasGrupo;
	}

	public LonjasLinea getLonjasLinea() {
		return this.lonjasLinea;
	}

	public void setLonjasLinea(LonjasLinea lonjasLinea) {
		this.lonjasLinea = lonjasLinea;
	}

	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

}