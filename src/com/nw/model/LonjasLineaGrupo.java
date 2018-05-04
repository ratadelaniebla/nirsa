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
@NamedQuery(name="LonjasLineaGrupo.findAll", query="SELECT l FROM LonjasLineaGrupo l")
public class LonjasLineaGrupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlonjaslineagrupo;
	private String nombregrupo;
	private LonjasGrupo lonjasGrupo;
	private LonjasLinea lonjasLinea;
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;

	public LonjasLineaGrupo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasGrupo
	@ManyToOne
	@JoinColumn(name="idlonjasgrupo")
	public LonjasGrupo getLonjasGrupo() {
		return this.lonjasGrupo;
	}

	public void setLonjasGrupo(LonjasGrupo lonjasGrupo) {
		this.lonjasGrupo = lonjasGrupo;
	}


	//bi-directional many-to-one association to LonjasLinea
	@ManyToOne
	@JoinColumn(name="idlonjaslinea")
	public LonjasLinea getLonjasLinea() {
		return this.lonjasLinea;
	}

	public void setLonjasLinea(LonjasLinea lonjasLinea) {
		this.lonjasLinea = lonjasLinea;
	}


	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="lonjasLineaGrupo")
	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

	public LonjasProcesoEmpleado addLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().add(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setLonjasLineaGrupo(this);

		return lonjasProcesoEmpleado;
	}

	public LonjasProcesoEmpleado removeLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().remove(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setLonjasLineaGrupo(null);

		return lonjasProcesoEmpleado;
	}

}