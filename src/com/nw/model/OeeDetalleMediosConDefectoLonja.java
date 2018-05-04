package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_medios_con_defecto_lonjas database table.
 * 
 */
@Entity
@Table(name="oee_detalle_medios_con_defecto_lonjas")
@NamedQuery(name="OeeDetalleMediosConDefectoLonja.findAll", query="SELECT o FROM OeeDetalleMediosConDefectoLonja o")
public class OeeDetalleMediosConDefectoLonja implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idOeeDetalleMediosConDefectoLonjas;
	private Area area;
	private LonjasLinea lonjasLinea;
	private OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto;

	public OeeDetalleMediosConDefectoLonja() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_detalle_medios_con_defecto_lonjas")
	public Long getIdOeeDetalleMediosConDefectoLonjas() {
		return this.idOeeDetalleMediosConDefectoLonjas;
	}

	public void setIdOeeDetalleMediosConDefectoLonjas(Long idOeeDetalleMediosConDefectoLonjas) {
		this.idOeeDetalleMediosConDefectoLonjas = idOeeDetalleMediosConDefectoLonjas;
	}


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
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


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@ManyToOne
	@JoinColumn(name="id_oee_detalle_medios_con_defecto")
	public OeeDetalleMediosConDefecto getOeeDetalleMediosConDefecto() {
		return this.oeeDetalleMediosConDefecto;
	}

	public void setOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		this.oeeDetalleMediosConDefecto = oeeDetalleMediosConDefecto;
	}

}