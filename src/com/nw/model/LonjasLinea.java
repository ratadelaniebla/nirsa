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
@NamedQuery(name="LonjasLinea.findAll", query="SELECT l FROM LonjasLinea l")
public class LonjasLinea implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlonjaslinea;
	private String descripcion;
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;
	private List<LonjasLineaGrupo> lonjasLineaGrupos;
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;
	private List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas;
	private List<OeeDetalleParadaLonja> oeeDetalleParadaLonjas;

	public LonjasLinea() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="lonjasLinea")
	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public LonjasDetalleProcesoCoche addLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().add(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setLonjasLinea(this);

		return lonjasDetalleProcesoCoch;
	}

	public LonjasDetalleProcesoCoche removeLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().remove(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setLonjasLinea(null);

		return lonjasDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LonjasLineaGrupo
	@OneToMany(mappedBy="lonjasLinea")
	public List<LonjasLineaGrupo> getLonjasLineaGrupos() {
		return this.lonjasLineaGrupos;
	}

	public void setLonjasLineaGrupos(List<LonjasLineaGrupo> lonjasLineaGrupos) {
		this.lonjasLineaGrupos = lonjasLineaGrupos;
	}

	public LonjasLineaGrupo addLonjasLineaGrupo(LonjasLineaGrupo lonjasLineaGrupo) {
		getLonjasLineaGrupos().add(lonjasLineaGrupo);
		lonjasLineaGrupo.setLonjasLinea(this);

		return lonjasLineaGrupo;
	}

	public LonjasLineaGrupo removeLonjasLineaGrupo(LonjasLineaGrupo lonjasLineaGrupo) {
		getLonjasLineaGrupos().remove(lonjasLineaGrupo);
		lonjasLineaGrupo.setLonjasLinea(null);

		return lonjasLineaGrupo;
	}


	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="lonjasLinea")
	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

	public LonjasProcesoEmpleado addLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().add(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setLonjasLinea(this);

		return lonjasProcesoEmpleado;
	}

	public LonjasProcesoEmpleado removeLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().remove(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setLonjasLinea(null);

		return lonjasProcesoEmpleado;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLonja
	@OneToMany(mappedBy="lonjasLinea")
	public List<OeeDetalleMediosConDefectoLonja> getOeeDetalleMediosConDefectoLonjas() {
		return this.oeeDetalleMediosConDefectoLonjas;
	}

	public void setOeeDetalleMediosConDefectoLonjas(List<OeeDetalleMediosConDefectoLonja> oeeDetalleMediosConDefectoLonjas) {
		this.oeeDetalleMediosConDefectoLonjas = oeeDetalleMediosConDefectoLonjas;
	}

	public OeeDetalleMediosConDefectoLonja addOeeDetalleMediosConDefectoLonja(OeeDetalleMediosConDefectoLonja oeeDetalleMediosConDefectoLonja) {
		getOeeDetalleMediosConDefectoLonjas().add(oeeDetalleMediosConDefectoLonja);
		oeeDetalleMediosConDefectoLonja.setLonjasLinea(this);

		return oeeDetalleMediosConDefectoLonja;
	}

	public OeeDetalleMediosConDefectoLonja removeOeeDetalleMediosConDefectoLonja(OeeDetalleMediosConDefectoLonja oeeDetalleMediosConDefectoLonja) {
		getOeeDetalleMediosConDefectoLonjas().remove(oeeDetalleMediosConDefectoLonja);
		oeeDetalleMediosConDefectoLonja.setLonjasLinea(null);

		return oeeDetalleMediosConDefectoLonja;
	}


	//bi-directional many-to-one association to OeeDetalleParadaLonja
	@OneToMany(mappedBy="lonjasLinea")
	public List<OeeDetalleParadaLonja> getOeeDetalleParadaLonjas() {
		return this.oeeDetalleParadaLonjas;
	}

	public void setOeeDetalleParadaLonjas(List<OeeDetalleParadaLonja> oeeDetalleParadaLonjas) {
		this.oeeDetalleParadaLonjas = oeeDetalleParadaLonjas;
	}

	public OeeDetalleParadaLonja addOeeDetalleParadaLonja(OeeDetalleParadaLonja oeeDetalleParadaLonja) {
		getOeeDetalleParadaLonjas().add(oeeDetalleParadaLonja);
		oeeDetalleParadaLonja.setLonjasLinea(this);

		return oeeDetalleParadaLonja;
	}

	public OeeDetalleParadaLonja removeOeeDetalleParadaLonja(OeeDetalleParadaLonja oeeDetalleParadaLonja) {
		getOeeDetalleParadaLonjas().remove(oeeDetalleParadaLonja);
		oeeDetalleParadaLonja.setLonjasLinea(null);

		return oeeDetalleParadaLonja;
	}

}