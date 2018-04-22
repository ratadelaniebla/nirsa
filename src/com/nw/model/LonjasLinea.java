package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lonjas_linea database table.
 * 
 */
@Entity
@Table(name="lonjas_linea")
public class LonjasLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlonjaslinea;

	private String descripcion;

	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasLinea")
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;

	//bi-directional many-to-one association to LonjasLineaGrupo
	@OneToMany(mappedBy="lonjasLinea")
	private List<LonjasLineaGrupo> lonjasLineaGrupos;

	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="lonjasLinea")
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;

	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLonja
	@OneToMany(mappedBy="lonjasLinea")
	private List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas;

	//bi-directional many-to-one association to OeeDetalleParadaLonja
	@OneToMany(mappedBy="lonjasLinea")
	private List<OeeDetalleParadaLonja> oeeDetalleParadaLonjas;

	public LonjasLinea() {
	}

	public Integer getIdlonjaslinea() {
		return this.idlonjaslinea;
	}

	public void setIdlonjaslinea(Integer idlonjaslinea) {
		this.idlonjaslinea = idlonjaslinea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public List<LonjasLineaGrupo> getLonjasLineaGrupos() {
		return this.lonjasLineaGrupos;
	}

	public void setLonjasLineaGrupos(List<LonjasLineaGrupo> lonjasLineaGrupos) {
		this.lonjasLineaGrupos = lonjasLineaGrupos;
	}

	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

	public List<OeeDetalleMediosConDefectoLonja> getOeeDetalleMediosConDefectoLonjas() {
		return this.oeeDetalleMediosConDefectoLonjas;
	}

	public void setOeeDetalleMediosConDefectoLonjas(List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas) {
		this.oeeDetalleMediosConDefectoLonjas = oeeDetalleMediosConDefectoLonjas;
	}

	public List<OeeDetalleParadaLonja> getOeeDetalleParadaLonjas() {
		return this.oeeDetalleParadaLonjas;
	}

	public void setOeeDetalleParadaLonjas(List<OeeDetalleParadaLonja> oeeDetalleParadaLonjas) {
		this.oeeDetalleParadaLonjas = oeeDetalleParadaLonjas;
	}

}